package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity3;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SplashMiniGameStarterServiceImpl implements ISplashMiniGameStarterService {
    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public SplashMiniGameData getCurrData() {
        return SplashMiniGameStarter.curData;
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public Class getGameActivityClass() {
        return GameActivity3.class;
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public boolean needJump() {
        return SplashMiniGameStarter.needJump;
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public boolean needShow() {
        return SplashMiniGameStarter.needShow();
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void preloadGameProcess() {
        SplashMiniGameStarter.preloadGameProcess();
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void preloadMiniGame() {
        SplashMiniGameStarter.preloadMiniGame();
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void preloadProcess() {
        SplashMiniGameStarter.preloadProcess();
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void saveConfigData(String str) {
        SplashMiniGameUtil.saveConfigData(str);
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void setHasClickJumpBtn(boolean z16) {
        SplashMiniGameStarter.hasClickJumpBtn = z16;
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void setHasJumped() {
        SplashMiniGameStarter.setHasJumped();
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void setNeedJump(boolean z16) {
        SplashMiniGameStarter.needJump = z16;
    }

    @Override // com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
    public void setNeedShow(boolean z16) {
        SplashMiniGameStarter.setNeedShow(z16);
    }
}
