package com.tencent.gamematrix.gmcg.sdk.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgSdkScreenShotListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGImageUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.env.CGCodecHelper;
import com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager;
import com.tencent.gamematrix.gmcg.webrtc.VideoFilterController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.TimerTask;
import org.tencwebrtc.EglRenderer;

/* loaded from: classes6.dex */
public class GmCgPlaySessionViewHolder extends CGCommPlaySessionViewHolder {
    protected boolean mEnableViewConfigCallback;
    protected boolean mIsScreenShot;
    protected Bitmap mLastFrameScreenShot;
    protected EglRenderer.FrameListener mListener;
    protected GmCgPlayTextureView mPlayRenderTextureView;
    protected GmCgPlayView mPlayRenderView;
    protected boolean mUseTextureView;

    public GmCgPlaySessionViewHolder() {
        this.mUseTextureView = false;
        this.mIsScreenShot = false;
    }

    private CGLoadingLastFrameCache getLoadingLastFrameCache() {
        GmCgDeviceInfo gmCgDeviceInfo = GmCgStateManager.get().getGmCgDeviceInfo();
        if (gmCgDeviceInfo == null || !gmCgDeviceInfo.isValid()) {
            gmCgDeviceInfo = null;
        }
        return new CGLoadingLastFrameCache(gmCgDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doShotScreenLastFrame$0(Bitmap bitmap) {
        CGLog.i("GmCgPlaySessionViewHolder doShotScreenLastFrame: onFrame");
        if (2 == this.mGameScreenOrientation) {
            bitmap = CGImageUtil.rotaImageView(270, bitmap);
        }
        getLoadingLastFrameCache().saveLastFrameAsImg(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$screenShotPlaySessionView$1(GmCgSdkScreenShotListener gmCgSdkScreenShotListener, Bitmap bitmap) {
        if (this.mGameScreenOrientation == 2) {
            bitmap = CGImageUtil.rotaImageView(270, bitmap);
        }
        this.mLastFrameScreenShot = bitmap;
        CGLog.i("onFrame callback isScreenShot: " + this.mIsScreenShot);
        if (this.mIsScreenShot && gmCgSdkScreenShotListener != null) {
            gmCgSdkScreenShotListener.onScreenShotResult(this.mLastFrameScreenShot);
            this.mIsScreenShot = false;
        }
        new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.gamematrix.gmcg.sdk.view.GmCgPlaySessionViewHolder.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = GmCgPlaySessionViewHolder.this;
                GmCgPlayView gmCgPlayView = gmCgPlaySessionViewHolder.mPlayRenderView;
                if (gmCgPlayView != null) {
                    gmCgPlayView.removeFrameListener(gmCgPlaySessionViewHolder.mListener);
                }
                CGLog.i("onFrame removeFrameListener");
            }
        }, 0L);
    }

    public void destroy() {
        try {
            GmCgPlayView gmCgPlayView = this.mPlayRenderView;
            if (gmCgPlayView != null) {
                gmCgPlayView.release();
            }
        } catch (Exception unused) {
        }
    }

    public void doShotScreenLastFrame() {
        screenShotPlaySessionView(new GmCgSdkScreenShotListener() { // from class: com.tencent.gamematrix.gmcg.sdk.view.g
            @Override // com.tencent.gamematrix.gmcg.api.GmCgSdkScreenShotListener
            public final void onScreenShotResult(Bitmap bitmap) {
                GmCgPlaySessionViewHolder.this.lambda$doShotScreenLastFrame$0(bitmap);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    protected String getLastFrameImgToLoading() {
        return getLoadingLastFrameCache().getLastFrameImgIfHave();
    }

    public FrameLayout getPlayContainerView() {
        return this.mPlayContainerView;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    public int getPlayRenderHeight() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getHeight();
        }
        if (this.mUseTextureView) {
            GmCgPlayTextureView gmCgPlayTextureView = this.mPlayRenderTextureView;
            if (gmCgPlayTextureView != null) {
                return gmCgPlayTextureView.getHeight();
            }
            return 0;
        }
        GmCgPlayView gmCgPlayView = this.mPlayRenderView;
        if (gmCgPlayView != null) {
            return gmCgPlayView.getHeight();
        }
        return 0;
    }

    public View getPlayRenderView() {
        if (this.mUseTextureView) {
            return this.mPlayRenderTextureView;
        }
        return this.mPlayRenderView;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    public int getPlayRenderWidth() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getWidth();
        }
        if (this.mUseTextureView) {
            GmCgPlayTextureView gmCgPlayTextureView = this.mPlayRenderTextureView;
            if (gmCgPlayTextureView != null) {
                return gmCgPlayTextureView.getWidth();
            }
            return 0;
        }
        GmCgPlayView gmCgPlayView = this.mPlayRenderView;
        if (gmCgPlayView != null) {
            return gmCgPlayView.getWidth();
        }
        return 0;
    }

    public GmCgPlayView getPlaySurfaceView() {
        if (this.mUseTextureView) {
            return null;
        }
        return this.mPlayRenderView;
    }

    public GmCgPlayTextureView getPlayTextureView() {
        if (this.mUseTextureView) {
            return this.mPlayRenderTextureView;
        }
        return null;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    protected void onPlayRenderViewSetup() {
        this.mPlayRenderView.enableViewConfigCallback(this.mEnableViewConfigCallback);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    @Nullable
    protected Bitmap provideLastFrameScreenShot() {
        return this.mLastFrameScreenShot;
    }

    public void releaseLastFrameScreenshot() {
        try {
            Bitmap bitmap = this.mLastFrameScreenShot;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mLastFrameScreenShot.recycle();
                this.mLastFrameScreenShot = null;
            }
        } catch (Exception unused) {
        }
    }

    public void screenShotPlaySessionView(final GmCgSdkScreenShotListener gmCgSdkScreenShotListener) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("screenShotPlaySessionView is null: ");
        if (this.mPlayRenderView == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        CGLog.i(sb5.toString());
        if (this.mPlayRenderView != null) {
            this.mIsScreenShot = true;
            CGLog.i("start screenShotPlaySessionView");
            EglRenderer.FrameListener frameListener = new EglRenderer.FrameListener() { // from class: com.tencent.gamematrix.gmcg.sdk.view.f
                @Override // org.tencwebrtc.EglRenderer.FrameListener
                public final void onFrame(Bitmap bitmap) {
                    GmCgPlaySessionViewHolder.this.lambda$screenShotPlaySessionView$1(gmCgSdkScreenShotListener, bitmap);
                }
            };
            this.mListener = frameListener;
            this.mPlayRenderView.addFrameListener(frameListener, 1.0f);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    public void setPlayScreenOrientation(int i3) {
        super.setPlayScreenOrientation(i3);
        if (this.mUseTextureView) {
            GmCgPlayTextureView gmCgPlayTextureView = this.mPlayRenderTextureView;
            if (gmCgPlayTextureView != null) {
                gmCgPlayTextureView.configGameScreenOrientation(i3);
                return;
            }
            return;
        }
        GmCgPlayView gmCgPlayView = this.mPlayRenderView;
        if (gmCgPlayView != null) {
            gmCgPlayView.configGameScreenOrientation(i3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    protected void setupPlayRenderView() {
        if (this.mPlayContainerView == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPlayContainerView.getChildCount()) {
                break;
            }
            if (this.mPlayContainerView.getChildAt(i3) instanceof GmCgPlayView) {
                this.mPlayContainerView.removeViewAt(i3);
                break;
            }
            i3++;
        }
        this.mPlayRenderView = new GmCgPlayView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(1, 1, 1, 1);
        this.mPlayContainerView.addView(this.mPlayRenderView, 0, layoutParams);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    @SuppressLint({"DefaultLocale"})
    protected void showOverlayExtraInfo() {
        TextView textView = this.mTvExtraOverlay;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        GmCgDeviceInfo gmCgDeviceInfo = this.mGmCgDeviceInfo;
        String deviceID = gmCgDeviceInfo != null ? gmCgDeviceInfo.getDeviceID() : "";
        GmCgDeviceInfo gmCgDeviceInfo2 = this.mGmCgDeviceInfo;
        String deviceArea = gmCgDeviceInfo2 != null ? gmCgDeviceInfo2.getDeviceArea() : "";
        GmCgDeviceInfo gmCgDeviceInfo3 = this.mGmCgDeviceInfo;
        int frameworkType = gmCgDeviceInfo3 != null ? gmCgDeviceInfo3.getFrameworkType() : 0;
        GmCgDeviceInfo gmCgDeviceInfo4 = this.mGmCgDeviceInfo;
        String webrtcUrl = gmCgDeviceInfo4 != null ? gmCgDeviceInfo4.getWebrtcUrl() : "";
        GmCgDeviceInfo gmCgDeviceInfo5 = this.mGmCgDeviceInfo;
        String hardwareType = gmCgDeviceInfo5 != null ? gmCgDeviceInfo5.getHardwareType() : "";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(G) model/soc: ");
        sb5.append(CGGlbConfig.getBuildModel());
        sb5.append("/");
        sb5.append(CGGlbConfig.getSoc());
        sb5.append('\n');
        sb5.append("(V) h264 ability/h265 ability: ");
        sb5.append(CGCodecHelper.isHardH264Support() ? "hard" : "soft");
        sb5.append("/");
        sb5.append(CGCodecHelper.isHardH265Support() ? "hard" : "soft");
        sb5.append('\n');
        sb5.append("(V) roundTripLatency: ");
        sb5.append((int) this.mPlayPerfInfo.pRoundTripLatency);
        sb5.append('\n');
        sb5.append("(V) frameRcv/dec/drop: ");
        sb5.append(this.mPlayPerfInfo.pVideoFramesReceived);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pVideoFramesDecoded);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pVideoFramesDropped);
        sb5.append("\n(V) decTimeMs/decFrameRate: ");
        sb5.append(this.mPlayPerfInfo.pVideoDecodeTimeMs);
        sb5.append("/");
        sb5.append(String.format("%.1f", Double.valueOf(this.mPlayPerfInfo.pVideoFramerate)));
        sb5.append("fps\n(V) bitrate/vBitrate: ");
        sb5.append(this.mPlayPerfInfo.pBitrate);
        sb5.append("kbps/");
        sb5.append(this.mPlayPerfInfo.pVideoBitrate);
        sb5.append("kbps\n(V) pckRcv/pckLost: ");
        sb5.append(this.mPlayPerfInfo.pVideoPacketsReceived);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pVideoPacketsLost);
        sb5.append("\n(V) frameRes: ");
        sb5.append(this.mPlayPerfInfo.pVideoFrameWidth);
        sb5.append(" x ");
        sb5.append(this.mPlayPerfInfo.pVideoFrameHeight);
        sb5.append("\n(V) 1stRenderedDelay: ");
        sb5.append(this.mPlayPerfInfo.pVideoFirstFrameRenderDelay);
        sb5.append("ms\n(V) rtt/sLatency/ping: ");
        sb5.append(this.mPlayPerfInfo.pVideoRtt);
        sb5.append("ms/");
        sb5.append(this.mPlayPerfInfo.pVideoStutterLatency);
        sb5.append("ms/");
        sb5.append(this.mPlayPerfInfo.pTgpaPingValue);
        sb5.append("\n(V) freezeCnt/duration/last10s: ");
        sb5.append(this.mPlayPerfInfo.pVideoFreezeCount);
        sb5.append("/");
        sb5.append(String.format("%.1f", Double.valueOf(this.mPlayPerfInfo.pVideoTotalFreezesDuration)));
        sb5.append("/");
        sb5.append(String.format("%.1f", Double.valueOf(this.mPlayPerfInfo.pVideoFreezeDuringLast10s)));
        sb5.append("\n(A) pckRcv/lost/percent: ");
        sb5.append(this.mPlayPerfInfo.pAudioPacketsReceived);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pAudioPacketsLost);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pAudioPacketsLossPercentage);
        sb5.append("\n(A) bitrate: ");
        sb5.append(this.mPlayPerfInfo.pAudioBitrate);
        sb5.append("\n(N) net carrier: ");
        sb5.append(this.mPlayPerfInfo.pLocalNetCarrier);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pRemoteNetCarrier);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pSupportNetFreeFlow);
        sb5.append("/");
        sb5.append(this.mPlayPerfInfo.pRealNetFreeFlow);
        sb5.append("\n\n(G) cgGameId: ");
        sb5.append(this.mGmCgGameId);
        sb5.append("\n(G) identity: ");
        sb5.append(this.mIdentity);
        sb5.append("\n(G) deviceId/deviceType: ");
        sb5.append(deviceID);
        sb5.append('/');
        sb5.append(hardwareType);
        sb5.append("\n(G) area/framework: ");
        sb5.append(deviceArea);
        sb5.append("/");
        sb5.append(frameworkType);
        sb5.append("\n(G) signal: ");
        sb5.append(webrtcUrl);
        sb5.append("\n(G) status: ");
        sb5.append(this.mPlayStatusMessage);
        sb5.append("\n(V) codec: ");
        sb5.append(this.mCodecAbility.getName());
        sb5.append("|");
        sb5.append(this.mVideoCodecType.mimeType());
        sb5.append("\n(G) stream quality: ");
        sb5.append(this.mCurGmCgStreamQualityCfg.pBandwidthMin);
        sb5.append(",");
        sb5.append(this.mCurGmCgStreamQualityCfg.pBandwidthMax);
        sb5.append("  ");
        sb5.append(this.mCurGmCgStreamQualityCfg.pResWidth);
        sb5.append(HippyTKDListViewAdapter.X);
        sb5.append(this.mCurGmCgStreamQualityCfg.pResHeight);
        sb5.append("\n(G) perf dumping: ");
        sb5.append(this.mPerfDumping);
        sb5.append("\n(G) codec config: ");
        sb5.append(this.mPlayPerfInfo.pGameCodecConfig);
        sb5.append("\n(G) using vdecoder: ");
        sb5.append(this.mPlayPerfInfo.pUsingVDecoder);
        sb5.append("\n(V) videofilter: ");
        sb5.append(VideoFilterController.get().getVideoFilterType());
        sb5.append("\n(V) srType: ");
        sb5.append(this.mPlayPerfInfo.pSrType);
        sb5.append('\n');
        this.mTvExtraOverlay.setText(sb5.toString());
    }

    public GmCgPlaySessionViewHolder(@NonNull FrameLayout frameLayout, boolean z16, boolean z17, boolean z18, boolean z19) {
        this(frameLayout, z16, z17, z18, z19, true);
    }

    public GmCgPlaySessionViewHolder(@NonNull FrameLayout frameLayout, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        super(frameLayout, z16, z17, z18, z19);
        this.mUseTextureView = false;
        this.mIsScreenShot = false;
        this.mEnableViewConfigCallback = z26;
        GmCgPlayView gmCgPlayView = this.mPlayRenderView;
        if (gmCgPlayView != null) {
            gmCgPlayView.enableViewConfigCallback(z26);
        }
    }

    public GmCgPlaySessionViewHolder(@NonNull GmCgPlayView gmCgPlayView) {
        this.mUseTextureView = false;
        this.mIsScreenShot = false;
        this.mPlayRenderView = gmCgPlayView;
        this.mContext = gmCgPlayView.getContext();
    }

    public GmCgPlaySessionViewHolder(@NonNull GmCgPlayTextureView gmCgPlayTextureView) {
        this.mIsScreenShot = false;
        this.mUseTextureView = true;
        this.mPlayRenderTextureView = gmCgPlayTextureView;
        this.mContext = gmCgPlayTextureView.getContext();
    }
}
