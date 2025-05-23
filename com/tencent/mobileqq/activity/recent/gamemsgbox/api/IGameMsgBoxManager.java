package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.ar;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.List;
import k71.b;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes10.dex */
public interface IGameMsgBoxManager extends IRuntimeService {
    public static final int FETCH_FROM_GAME_BOX = 2;
    public static final int FETCH_FROM_LOGIN = 1;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    void asyncFindGameBoxRecentUserInfo(String str, b<GameBoxRecentUser> bVar);

    void clearTitles();

    void fetchRecentGameContacts(boolean z16, k71.a aVar, int i3);

    GameBoxRecentUser findGameBoxRecentUserInfo(String str);

    gd1.a findGameDetailInfoByConvertUin(String str);

    gd1.a findGameDetailInfoByConvertUinV2(String str);

    ArrayList<String> getAppidsInGameBox();

    ar getCallback();

    SharedPreferences getGameMsgBoxSp();

    List<String> getNTAllOpenSyncRecentUserList();

    List<com.tencent.mobileqq.activity.recent.gamemsgbox.data.b> getTitles();

    int getUnreadCount(String str);

    boolean isGameInGameBox(BaseQQAppInterface baseQQAppInterface, String str);

    boolean isGameInGameBox(String str);

    boolean isShowGameBoxTips();

    String obtainConvertUinByPeerUid(String str);

    void registerNTGameTabListener(a aVar);

    void resetFetchListener();

    void resetNTLoadRemoteUserList();

    void setConfigToNTKernel(AppRuntime appRuntime, GameSwitchConfig gameSwitchConfig, String str, boolean z16);

    boolean shouldForbidNotification(AppRuntime appRuntime, RecentContactInfo recentContactInfo);

    boolean shouldShowRedPoint(GameSwitchConfig gameSwitchConfig);

    void startAddFriend(Context context, String str, String str2, String str3, String str4);

    void tryUpdateGameMsgInfoFromRecentUser();

    void unregisterNTGameTabListener();

    void updateGameTab(List<String> list);

    void updateGameTabInfo(gd1.a aVar, GameSwitchConfig gameSwitchConfig);

    void updateNTOpenSyncUser(gd1.a aVar, GameSwitchConfig gameSwitchConfig);

    void updateRedPointShowState(boolean z16, String str);

    void updateShowGameBoxTips(boolean z16);
}
