package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.os.MqqHandler;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IGameMsgBoxABTestApi extends QRouteApi {
    boolean isGameBoxMuteGrayDotNewStyle();

    boolean isGameMsgAddTab();

    void reportGameTabExposure(MqqHandler mqqHandler);
}
