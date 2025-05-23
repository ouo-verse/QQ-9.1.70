package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.data.n;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting$QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMsgManagerService extends IRuntimeService {
    public static final String ACTION_GAME_CENTER_PUSH = "action_qgame_center_push";
    public static final String GAMEID_GET_UNREAD_NUM = "-10001";
    public static final String GAMEID_INIT = "-10000";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(List<n> list);
    }

    void addRecentPartnerListener(a aVar);

    void addUserInfoChangedObserver(ie1.b bVar);

    void applyPartner(String str, String str2, g gVar);

    void checkGameMsgTabConfigUpdate();

    void cleanSessionUnread(String str);

    GameBasicInfo findGameConfig(String str);

    @Deprecated
    GameSwitchConfig findGameSwitchConfig(String str);

    void findGameSwitchConfig(String str, uc1.b<GameSwitchConfig> bVar);

    GameSwitchConfig findGameSwitchConfigFromMemoryCache(String str);

    GameUserInfo findGameUserInfo(String str);

    String getAIORedDotStyleId();

    String getBoxMsgSwitchId();

    Bundle getGameCenterRequestInfo(AppInterface appInterface, String str);

    Bundle getGameCenterSessionInfo(AppInterface appInterface, int i3, String str);

    Bundle getGameCenterUnreadTotal();

    HashMap<String, gd1.a> getGameDetailInfo(ArrayList<String> arrayList);

    HashMap<String, gd1.a> getGameDetailInfoV2(ArrayList<String> arrayList);

    String getGameMsgListUrl();

    String getGameMsgSettingUrl();

    String getGamePrefix();

    boolean getHasUnreadMsg();

    GameCenterSessionInfo getLastSessionInfo();

    GameCenterSessionInfo getLastSessionInfoExceptDelSession();

    JSONObject getMetaDreamSayHiConfig();

    boolean getMsgShowOnList();

    boolean getNeedPopMsgView();

    String getPlayerInfoUrl();

    JSONObject getQuickReplyConfig();

    List<n> getRecentPartnerList();

    String getRedDotConfig(String str);

    void getRemoteGameSessionList(j jVar);

    long getReqMsgCnt();

    JSONObject getSayHiDefaultConfig();

    com.tencent.mobileqq.gamecenter.data.j getSessionDelDataHelper();

    GameCenterSessionInfo getSessionInfoByRoleId(String str);

    GameCenterSessionInfo getSessionInfoByUin(String str);

    GameCenterSessionInfo getSessionInfoByUinV2(String str);

    List<GameCenterSessionInfo> getSessionInfoList();

    List<GameCenterSessionInfo> getSessionInfoList(int i3, String str);

    boolean getShowReqMsgUnread();

    gd1.a getSingleGameDetail(String str);

    gd1.a getSingleGameDetailV2(String str);

    int getUnreadCnt();

    int getUnreadCnt(boolean z16);

    int getUnreadCnt4MsgTab();

    HashMap<String, Integer> getUnreadForEachGame();

    String getUnreadStr4EachGame();

    int getUnshowedUnreadCnt();

    int getViewType();

    boolean gotoPlayerInfoPage(AppRuntime appRuntime, Context context, String str, String str2);

    boolean isGameMsgBlocked(String str);

    boolean isGameMsgShowInBoxFormTabConfig();

    boolean isGameMsgSync(String str);

    boolean isGrayOpen();

    boolean isInited();

    boolean isJumpGameProfileCard();

    boolean isShowInMsgBox();

    void notifyGameMsgSayHiInfo(int i3, long j3, String str, GameMsgGreeting$QueryAIOGreetInfoRsp gameMsgGreeting$QueryAIOGreetInfoRsp);

    void notifyReceiveGameMsgSayHiMessage(String str, String str2);

    void notifyRemoteUserReady(int i3, ArrayList<com.tencent.mobileqq.gamecenter.data.f> arrayList);

    void notifySessionChangedBySwitch();

    void onGameMsgRRecv(int i3);

    void onGameSwitchChange(String str, int i3, int i16);

    void onReceiveGamePartnerChangePush();

    void onSendApplyPartnerMessage(int i3, int i16, long j3, String str);

    Bundle openGameCenterAIO(AppInterface appInterface, String str);

    void pushMsgForH5(String str);

    void removeGameMsgPartnerCallback();

    void removeGameMsgSayHiCallback();

    void removeRecentPartnerListener(a aVar);

    void removeUserInfoChangedObserver(ie1.b bVar);

    void reqGameMsgSayHiInfo(String str, String str2, h hVar);

    void saveOrUpdateGameBasicConfigs(ArrayList<GameBasicInfo> arrayList);

    void saveOrUpdateGameSwitchConfigs(ArrayList<GameSwitchConfig> arrayList);

    void saveOrUpdateGameUsrInfoArrays(ArrayList<GameUserInfo> arrayList);

    void sendApplyPartnerMessage(String str, String str2, String str3, g gVar);

    void setH5PushMsgState(boolean z16);

    void setMsgShowOnList(boolean z16);

    void setNeedPopMsgView(boolean z16);

    void setPubAccRedSwitch(int i3);

    void setRead(GameCenterSessionInfo gameCenterSessionInfo);

    void setRecentPartnerList(List<n> list);

    void setShowReqMsgUnread(boolean z16);

    void setUnshowedUnreadCnt(int i3);

    void setUnshowedUnreadCntV2(int i3, boolean z16);

    PopupWindow showGameAIOStatusPopupWindow(gd1.a aVar, Activity activity, Bundle bundle, View.OnClickListener onClickListener);

    void updateRecentPartnerList(List<n> list);

    void updateRedDotConfig(String str, String str2);
}
