package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import mqq.util.WeakReference;

/* loaded from: classes5.dex */
public class RFWPlayerBackGroundInterceptor extends RFWPlayerBaseInterceptor {
    private BackGroundCallBack mCallBack;

    public RFWPlayerBackGroundInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayer() {
        if (!RFWVideoUtils.enableBackGroundPause(this.mPlayerOptions)) {
            QLog.d(getTag(), 1, "onProcessBackground not enable backGround interceptor");
            return;
        }
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            return;
        }
        rFWPlayer.pause();
        QLog.d(getTag(), 1, "onProcessBackground pause play success");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        if (!RFWVideoUtils.enableBackGroundPause(this.mPlayerOptions)) {
            QLog.d(getTag(), 1, "afterOpenMedia not enable backGround interceptor,");
            return;
        }
        this.mCallBack = new BackGroundCallBack(this);
        QLog.d(getTag(), 1, "afterOpenMedia register back ground callback");
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this.mCallBack);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        guardManager.registerCallBack(this.mCallBack);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        if (this.mCallBack == null) {
            return;
        }
        RFWLifecycleHelper.getInstance().unRegisterProcessChangeListener(this.mCallBack);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        guardManager.unregisterCallback(this.mCallBack);
    }

    /* loaded from: classes5.dex */
    private static class BackGroundCallBack implements IGuardInterface, IProcessStateChangeCallback {
        private final WeakReference<RFWPlayerBackGroundInterceptor> mWeakReference;

        public BackGroundCallBack(RFWPlayerBackGroundInterceptor rFWPlayerBackGroundInterceptor) {
            this.mWeakReference = new WeakReference<>(rFWPlayerBackGroundInterceptor);
        }

        private void pausePlayer() {
            RFWPlayerBackGroundInterceptor rFWPlayerBackGroundInterceptor = this.mWeakReference.get();
            if (rFWPlayerBackGroundInterceptor != null) {
                rFWPlayerBackGroundInterceptor.pausePlayer();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            pausePlayer();
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public void onProcessBackground() {
            pausePlayer();
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public /* synthetic */ void onProcessForeground() {
            com.tencent.richframework.lifecycle.a.b(this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}
