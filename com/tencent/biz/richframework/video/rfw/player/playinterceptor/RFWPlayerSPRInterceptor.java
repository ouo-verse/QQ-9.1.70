package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.spr.RFWSprManger;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qfsmonet.api.IMonetProcessor;
import com.tencent.qfsmonet.api.IMonetTextureIdInterceptor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.MonetSDK;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.inputstream.MonetSurfaceTexture;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.module.singleinput.IMonetModuleChain;
import com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream;
import com.tencent.qfsmonet.gles.h;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.view.ISPlayerVideoView;
import mqq.util.WeakReference;

/* loaded from: classes5.dex */
public class RFWPlayerSPRInterceptor extends RFWPlayerBaseInterceptor {
    private volatile boolean mHasInitMonte;
    private volatile boolean mHasOpenSPR;
    private IMonetProcessor mMonetProcessor;
    private Surface mMonetSurface;
    private MonetSurfaceTexture mMonetSurfaceTexture;
    private IMonetSingleInputModule mPatchModule;
    private Surface mPlayerSurface;
    private IMonetSingleInputModule mSingleInputModule;
    private IMonetSurfaceInputStream mSurfaceInputStream;
    private IMonetSurfaceOutputStream mSurfaceOutputStream;

    /* loaded from: classes5.dex */
    private static class ReleaseRunnable implements Runnable {
        WeakReference<RFWPlayerSPRInterceptor> mInterceptor;

        ReleaseRunnable(RFWPlayerSPRInterceptor rFWPlayerSPRInterceptor) {
            this.mInterceptor = new WeakReference<>(rFWPlayerSPRInterceptor);
        }

        @Override // java.lang.Runnable
        public void run() {
            RFWPlayerSPRInterceptor rFWPlayerSPRInterceptor = this.mInterceptor.get();
            if (rFWPlayerSPRInterceptor == null) {
                return;
            }
            if (rFWPlayerSPRInterceptor.mSurfaceOutputStream != null) {
                rFWPlayerSPRInterceptor.mSurfaceOutputStream.updateSurface(null);
            }
            if (rFWPlayerSPRInterceptor.mMonetProcessor != null) {
                rFWPlayerSPRInterceptor.mMonetProcessor.destroy();
            }
        }
    }

    public RFWPlayerSPRInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private void addViewCallback(ISPlayerVideoView iSPlayerVideoView) {
        if (iSPlayerVideoView == null) {
            return;
        }
        iSPlayerVideoView.addViewCallBack(new VideoViewCallBackImpl(this));
    }

    private void initMonetSurface() {
        synchronized (this) {
            if (this.mHasInitMonte) {
                RFWLog.d(getTag(), RFWLog.USR, "initMonetSurface has init ,return ");
                return;
            }
            this.mHasInitMonte = true;
            try {
                MonetSDK.initSDK(RFWApplication.getApplication());
                IMonetProcessor a16 = com.tencent.qfsmonet.proxy.a.a();
                this.mMonetProcessor = a16;
                MonetContext initializeWithSoLoad = a16.initializeWithSoLoad();
                if (initializeWithSoLoad == null) {
                    RFWLog.d(getTag(), RFWLog.USR, "create surface failed ");
                    return;
                }
                this.mSingleInputModule = com.tencent.qfsmonet.proxy.a.b(initializeWithSoLoad, IMonetModule.SINGLE_INPUT_MODULE_CHAIN);
                this.mPatchModule = com.tencent.qfsmonet.proxy.a.b(initializeWithSoLoad, IMonetModule.SINGLE_INPUT_PATCH);
                this.mSurfaceInputStream = com.tencent.qfsmonet.proxy.a.c(initializeWithSoLoad);
                this.mSurfaceOutputStream = com.tencent.qfsmonet.proxy.a.d(initializeWithSoLoad);
                this.mMonetSurfaceTexture = this.mSurfaceInputStream.getRenderObject();
                ((IMonetModuleChain) this.mSingleInputModule).addSingleModule(this.mPatchModule);
                this.mMonetProcessor.loadModule(this.mSingleInputModule, this.mSurfaceInputStream, this.mSurfaceOutputStream);
                this.mMonetSurfaceTexture.setDefaultBufferSize(this.mPlayerOptions.getRealPlayBean().mWidth, this.mPlayerOptions.getRealPlayBean().mHeight);
                this.mMonetSurfaceTexture.width(this.mPlayerOptions.getRealPlayBean().mWidth);
                this.mMonetSurfaceTexture.height(this.mPlayerOptions.getRealPlayBean().mHeight);
                this.mMonetProcessor.run();
                this.mMonetSurface = new Surface(this.mMonetSurfaceTexture);
                monetHack();
                this.mHasOpenSPR = true;
                RFWLog.d(getTag(), RFWLog.USR, "create surface success:");
            } catch (Exception e16) {
                RFWLog.d(getTag(), RFWLog.USR, "init error ", e16);
            }
        }
    }

    private boolean isFeedVideo() {
        if (this.mPlayerOptions.getIOC() == null || this.mPlayerOptions.getIOC().getUpperData() == null || !(this.mPlayerOptions.getIOC().getUpperData().getValue("KEY_NEED_SRP") instanceof Boolean)) {
            return false;
        }
        boolean booleanValue = ((Boolean) this.mPlayerOptions.getIOC().getUpperData().getValue("KEY_NEED_SRP")).booleanValue();
        RFWLog.d(getTag(), RFWLog.USR, "isFeedVideo:" + booleanValue);
        return booleanValue;
    }

    private boolean isFeedVideoNeedSpr() {
        boolean z16;
        RFWVideoUrlBean realPlayBean = this.mPlayerOptions.getRealPlayBean();
        if (realPlayBean == null) {
            RFWLog.d(getTag(), RFWLog.USR, "no urlBean");
            return false;
        }
        int min = Math.min(realPlayBean.mWidth, realPlayBean.mHeight);
        int max = Math.max(realPlayBean.mWidth, realPlayBean.mHeight);
        if (min >= uq3.c.m4() && min <= uq3.c.n4() && max >= uq3.c.k4() && max <= uq3.c.l4()) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d(getTag(), RFWLog.USR, "isFeedVideoNeedSpr:" + z16 + "|shortSize:" + min + "|longSize:" + max);
        if (z16 && isFeedVideo()) {
            return true;
        }
        return false;
    }

    private void monetHack() {
        updateMonetSurface();
        ISPlayerVideoView iSPlayerVideoView = (ISPlayerVideoView) this.mPlayer.getVideoView();
        this.mPlayer.getRealPlayer().updatePlayerVideoView(null);
        addViewCallback(iSPlayerVideoView);
        this.mPlayer.getRealPlayer().setSurface(this.mMonetSurface);
        this.mMonetProcessor.setTextureIdInterceptor(new IMonetTextureIdInterceptor() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerSPRInterceptor.1
            @Override // com.tencent.qfsmonet.api.IMonetTextureIdInterceptor
            public String getBlackName() {
                return uq3.c.G2();
            }

            @Override // com.tencent.qfsmonet.api.IMonetTextureIdInterceptor
            public String getTag() {
                return RFWPlayerSPRInterceptor.this.getTag();
            }

            @Override // com.tencent.qfsmonet.api.IMonetTextureIdInterceptor
            public void onTextureIdAvailable(int i3, int i16, int i17, int i18) {
                RFWPlayerSPRInterceptor.this.notifyOriginFrame(i3, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOriginFrame(int i3, int i16, int i17) {
        Bitmap b16;
        if (!com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENBALE_SPR_COMPARE, 0) || (b16 = h.b(i16, i17, i3)) == null) {
            return;
        }
        RFWPlayerListenerDispatchUtils.onSprOriginFrameBack(this.mPlayerOptions, b16);
    }

    private void reportExpExpose() {
        if (RFWSprManger.g().enableExpose()) {
            com.tencent.relation.common.abtest.a.a("exp_qcircle_video_spr_8923").reportExpExposure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonetSurface() {
        Surface surface;
        IMonetSurfaceOutputStream iMonetSurfaceOutputStream = this.mSurfaceOutputStream;
        if (iMonetSurfaceOutputStream != null && (surface = this.mPlayerSurface) != null) {
            iMonetSurfaceOutputStream.updateSurface(surface);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterCreateView() {
        super.afterCreateView();
        RFWLog.d(getTag(), RFWLog.USR, "afterCreateView");
        addViewCallback((ISPlayerVideoView) this.mPlayer.getVideoView());
    }

    public boolean hasOpenSpr() {
        return this.mHasOpenSPR;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        if (!this.mHasOpenSPR) {
            return;
        }
        IMonetProcessor iMonetProcessor = this.mMonetProcessor;
        if (iMonetProcessor != null) {
            iMonetProcessor.setDestroyFlag();
        }
        RFWThreadManager.getInstance().execOnSubThread(new ReleaseRunnable(this));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        reportExpExpose();
        if (!RFWSprManger.g().enableSpr()) {
            RFWLog.d(getTag(), RFWLog.USR, "spr not hit ");
            return;
        }
        if (!RFWSprManger.g().isLoadSuccess()) {
            RFWSprManger.g().loadNeedSo();
            RFWLog.d(getTag(), RFWLog.USR, "spr so not load ");
            return;
        }
        if (!isFeedVideoNeedSpr()) {
            RFWPlayerListenerDispatchUtils.onSprEnable(this.mPlayerOptions, false);
            RFWLog.d(getTag(), RFWLog.USR, "feed not need spr ");
            return;
        }
        RFWLog.d(getTag(), RFWLog.USR, "feed  need spr ");
        initMonetSurface();
        RFWLog.d(getTag(), RFWLog.USR, "onStart enable spr: " + this.mHasOpenSPR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class VideoViewCallBackImpl implements ISPlayerVideoView.IVideoViewCallBack {
        WeakReference<RFWPlayerSPRInterceptor> mInterceptor;

        VideoViewCallBackImpl(RFWPlayerSPRInterceptor rFWPlayerSPRInterceptor) {
            this.mInterceptor = new WeakReference<>(rFWPlayerSPRInterceptor);
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
            RFWPlayerSPRInterceptor rFWPlayerSPRInterceptor = this.mInterceptor.get();
            if (rFWPlayerSPRInterceptor == null) {
                return;
            }
            if (obj instanceof Surface) {
                rFWPlayerSPRInterceptor.mPlayerSurface = (Surface) obj;
            } else if (obj instanceof SurfaceTexture) {
                rFWPlayerSPRInterceptor.mPlayerSurface = new Surface((SurfaceTexture) obj);
            }
            rFWPlayerSPRInterceptor.updateMonetSurface();
            RFWLog.d(rFWPlayerSPRInterceptor.getTag(), RFWLog.USR, "onSurfaceCreated");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
        }
    }
}
