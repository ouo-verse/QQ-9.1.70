package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameMsgUnissoHandlerApi extends QRouteApi {
    void addOrShieldFriend(int i3, int i16, String str, String str2, String str3);

    void getAioPopInfo(int i3, int i16, String str, String str2);

    void getGameMsgTabConfig();

    void getGameStartPriority(int i3, String str);

    void getGameSwitch(int i3);

    void setGameSwitch(int i3, String str, int i16, int i17, com.tencent.mobileqq.gamecenter.data.c cVar);
}
