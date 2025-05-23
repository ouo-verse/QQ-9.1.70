package com.tencent.mobileqq.gamecenter.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterQIPCModuleApi extends QRouteApi {
    public static final String ACTION_GET_GAME_FRIEND_STATUS = "get_game_friend_status";
    public static final String NAME = "GameCenterQIPCModule";

    void createWidget(int i3);

    void getGameFriendEnableStatus(String str, @NonNull k<Boolean> kVar);

    QIPCModule getQIPCModule();

    void queryWidget(int i3, @NonNull k<Boolean> kVar);

    void reportAtta(String str, @NonNull k<Integer> kVar);

    void setSwitchStatus(int i3, int i16, @NonNull k<Integer> kVar);
}
