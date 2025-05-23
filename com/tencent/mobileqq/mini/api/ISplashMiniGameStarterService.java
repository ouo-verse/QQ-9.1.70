package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ISplashMiniGameStarterService extends QRouteApi {
    SplashMiniGameData getCurrData();

    Class getGameActivityClass();

    boolean needJump();

    boolean needShow();

    void preloadGameProcess();

    void preloadMiniGame();

    void preloadProcess();

    void saveConfigData(String str);

    void setHasClickJumpBtn(boolean z16);

    void setHasJumped();

    void setNeedJump(boolean z16);

    void setNeedShow(boolean z16);
}
