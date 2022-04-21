package yalong.site;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import yalong.site.bo.GlobalData;
import yalong.site.bo.LeagueClientBO;
import yalong.site.bo.ScoreBO;
import yalong.site.bo.SummonerInfoBO;
import yalong.site.frame.MainFrame;
import yalong.site.services.LeagueClientService;
import yalong.site.services.LinkLeagueClientApi;
import yalong.site.utils.RequestUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static yalong.site.utils.ProcessUtil.getClientProcess;

/**
 */
public class LeagueClientHelper {

    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                MainFrame.start();
                LeagueClientService service = new LeagueClientService();
                service.setRank(GlobalData.currentRankBO);
                service.runForever();
            } catch (Exception e) {
                e.printStackTrace();
                MainFrame.hiddenFrame();
                int running = MainFrame.continueRun(e.getMessage());
                if (running == 1) {
                    System.exit(0);
                }
            }
        }
    }
}
//测试部分
//        LeagueClientBO leagueClientBO = getClientProcess();
//        RequestUtil requestUtil = new RequestUtil(leagueClientBO);
//        LinkLeagueClientApi api = new LinkLeagueClientApi(requestUtil);
//        LeagueClientService service =new LeagueClientService();
//        String lobbyId = api.getRoomInfo();
//        //获取选英雄房间信息  处理过后拿到队友的summonerid
//        ArrayList<String> summonerIdList=api.getRoomSummonerId(lobbyId);
//        //打印出队友的puuid
//        for (String id:summonerIdList){
//            System.out.println(id);
//        }
//        ArrayList<String> strings = new ArrayList<>();
//        for (String id : summonerIdList) {
//            SummonerInfoBO infoBySummonerId = api.getInfoBySummonerId(id);
//            String puuid = infoBySummonerId.getPuuid();
//            strings.add(puuid);
//        }
//        //查询到每个人的战绩并处理，返回需要发送的消息列表
 //       ArrayList<String> msgs=service.dealScore2Msg(strings);
//        for(String msg:msgs){
//            //发送消息到英雄选择页面
//            api.msg2Room(lobbyId,msg);
//        }
//        String puuid =api.getInfoBySummonerId("2929100794").getPuuid();
//        System.out.println(api.getScoreByIdc(puuid, 1));
//        String msg = api.msg2Room()



