package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.superplayer.api.ISuperPlayer;

/* loaded from: classes5.dex */
public class RFWPlayerStatusInterceptor extends RFWPlayerBaseInterceptor {
    private volatile boolean mHasStart;
    private volatile boolean mIsDeInit;
    private volatile boolean mIsError;
    private volatile boolean mIsFirstRenderBack;
    private volatile boolean mIsPrepare;
    private volatile boolean mIsRelease;

    public RFWPlayerStatusInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    public boolean isError() {
        return this.mIsError;
    }

    public boolean isFirstRenderCallback() {
        return this.mIsFirstRenderBack;
    }

    public boolean isIsDeInit() {
        return this.mIsDeInit;
    }

    public boolean isPrepared() {
        return this.mIsPrepare;
    }

    public boolean isRelease() {
        return this.mIsRelease;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        this.mIsError = true;
        return super.onError(iSuperPlayer, i3, i16, i17, str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPause() {
        super.onPause();
        RFWLog.d(getTag(), RFWLog.USR, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerDeInit() {
        this.mIsDeInit = true;
        RFWLog.d(getTag(), RFWLog.USR, "onPlayerDeInit");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoFirstVideoFrameRendered() {
        super.onPlayerInfoFirstVideoFrameRendered();
        this.mIsFirstRenderBack = true;
        RFWLog.d(getTag(), RFWLog.USR, "FrameRendered");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerParamsReset() {
        super.onPlayerParamsReset();
        this.mIsFirstRenderBack = false;
        this.mIsPrepare = false;
        this.mIsDeInit = false;
        this.mIsError = false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        this.mIsRelease = true;
        this.mHasStart = false;
        RFWLog.d(getTag(), RFWLog.USR, "onRelease:" + i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        this.mHasStart = true;
        RFWLog.d(getTag(), RFWLog.USR, "onStart");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStop() {
        super.onStop();
        RFWLog.d(getTag(), RFWLog.USR, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        super.onVideoPrepare();
        this.mIsPrepare = true;
        RFWLog.d(getTag(), RFWLog.USR, "onVideoPrepare");
    }
}
