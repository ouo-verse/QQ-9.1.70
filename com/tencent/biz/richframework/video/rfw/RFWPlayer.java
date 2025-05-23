package com.tencent.biz.richframework.video.rfw;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayerLimitLogUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPostAtFrontUtils;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitorImpl;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPerfReportInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerStatusInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.tvkplayer.RFWTVKPlayerCommonInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.tvkplayer.RFWTVKPlayerInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.richframework.engineer.test.api.RFWTestEvent;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.dtreport.IDtReport;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Arrays;
import java.util.Map;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayer implements ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnVideoSizeChangedListener, IDtReport {
    private static String EVENT_ID = "qcircle_player_sdk_init";
    public static int RELEASE_BY_REUSE = 5;
    public static int RELEASE_FORM_RELEASED = 6;
    public static int RELEASE_FROM_PLAYER_MANGER = 3;
    public static int RELEASE_FROM_PRELOAD = 1;
    public static int RELEASE_FROM_PRELOAD_TASK_COMPLETE = 2;
    public static int RELEASE_FROM_VIDEO_VIEW = 4;
    public static String sIsSupportHEVC = QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations").decodeString("key_sp_is_support_hevc", null);
    public static long sLastDownloadAvgSpeed;
    private RFWBaseInterceptorController mController;
    private SuperPlayerVideoInfo mCurrentVideoInfo;
    private boolean mIsLoopback;
    private boolean mOutputMute;
    private ISuperPlayer mPlayer;
    private RFWPlayerOptions mPlayerOptions;
    private ISPlayerVideoView mPlayerVideoView;
    private SuperPlayerOption mSuperPlayerOption;
    protected long mVideoPlayId = 0;
    private boolean mEnablePerfReport = true;
    private float mPlayRate = 1.0f;

    private void asyncInitSuperPlayer() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.j
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$asyncInitSuperPlayer$9();
            }
        });
    }

    private void createVideoInfo() {
        String targetIPURL;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_ip_url_back_up", true)) {
            if (TextUtils.isEmpty(this.mPlayerOptions.getRealPlayUrl())) {
                targetIPURL = this.mPlayerOptions.getTargetIPURL();
            } else {
                targetIPURL = this.mPlayerOptions.getRealPlayUrl();
            }
        } else if (TextUtils.isEmpty(this.mPlayerOptions.getTargetIPURL())) {
            targetIPURL = this.mPlayerOptions.getRealPlayUrl();
        } else {
            targetIPURL = this.mPlayerOptions.getTargetIPURL();
        }
        String str = targetIPURL;
        RFWLog.d(getTag(), RFWLog.USR, "ensureSuperPlayer playerUrl:" + str);
        this.mCurrentVideoInfo = RFWVideoUtils.createSuperVideoInfo(this.mPlayerOptions.getFileId(), str, RFWVideoUrlBackUpUtils.getBackUpVideoUrl(this.mPlayerOptions), this.mPlayerOptions.getHost(), getVideoDuration(), this.mPlayerOptions.getVideoFormat(), this.mPlayerOptions);
    }

    private void defaultOnInfo(int i3, long j3, long j16, Object obj) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onInfo(i3, j3, j16, obj);
        RFWPlayerListenerDispatchUtils.onInfo(this.mPlayerOptions, i3, j3, j3, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: detectHEVC, reason: merged with bridge method [inline-methods] */
    public void lambda$ensureSuperPlayer$8() {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations");
        if (!from.isAccessible() || (!from.decodeString("key_sp_is_detect_hevc", "").equals(""))) {
            return;
        }
        try {
            if (com.tencent.superplayer.utils.e.d(172, 102).getMaxFramerateFormaxLumaSamples() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String valueOf = String.valueOf(z16);
            sIsSupportHEVC = valueOf;
            QCircleExposeDataBean.sIsSupportHEVC = valueOf;
        } catch (Exception e16) {
            RFWLog.e(getTag(), RFWLog.USR, "getThumbPlayerVCodecTypeMaxCapability() error,", e16);
        }
        from.encodeString("key_sp_is_detect_hevc", "1");
        from.encodeString("key_sp_is_support_hevc", sIsSupportHEVC);
        from.commitAsync();
        RFWLog.i(getTag(), RFWLog.USR, "sIsSupportHEVC=" + sIsSupportHEVC);
    }

    private void disPatchRateChange(float f16, RFWPlayer rFWPlayer) {
        long currentPositionMs = getCurrentPositionMs();
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (currentPositionMs == 0) {
            currentPositionMs = rFWPlayerOptions.getStartOffset();
        }
        RFWPlayerListenerDispatchUtils.onPlayerRateChanged(rFWPlayerOptions, f16, currentPositionMs, rFWPlayer);
    }

    private void doInitSuperPlayer() {
        ISuperPlayer ensureSuperPlayer = this.mController.ensureSuperPlayer(this.mPlayerVideoView);
        this.mPlayer = ensureSuperPlayer;
        ensureSuperPlayer.setOnVideoPreparedListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mPlayer.setOnVideoSizeChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doRelease, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$release$2(int i3) {
        if (this.mPlayer != null) {
            RFWLog.d(getTag(), RFWLog.USR, "[release]:" + i3);
            this.mPlayer.stop();
            this.mPlayer.release();
            return;
        }
        RFWLog.d(getTag(), RFWLog.USR, "player is null [release] :" + i3);
    }

    private void downloadComplete() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.downloadComplete();
        }
        RFWPlayerListenerDispatchUtils.onDownloadComplete(this.mPlayerOptions);
    }

    private void ensureSuperPlayer() {
        this.mController.beforeCreateView();
        if (!TextUtils.isEmpty(this.mPlayerOptions.getPlayVid())) {
            this.mCurrentVideoInfo = RFWVideoUtils.createSuperVideoInfo(this.mPlayerOptions.getPlayVid(), "", null, "", getVideoDuration(), this.mPlayerOptions.getVideoFormat(), this.mPlayerOptions);
        } else {
            createVideoInfo();
        }
        this.mPlayerVideoView = this.mController.createPlayerVideoView();
        this.mController.afterCreateView();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_init_player_async", true) && this.mPlayerOptions.shouldInitBackThread()) {
            asyncInitSuperPlayer();
            return;
        }
        doInitSuperPlayer();
        RFWLog.d(getTag(), RFWLog.USR, "do initSuperPlayer sync");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.i
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$ensureSuperPlayer$8();
            }
        });
    }

    private void flagReleaseStatus(int i3) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class) != null) {
            ((RFWPlayerStatusInterceptor) this.mController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).onRelease(i3);
        }
    }

    public static long getLastDownloadAvgSpeed() {
        return sLastDownloadAvgSpeed;
    }

    private SDKInitListener getListener() {
        return new SDKInitListener() { // from class: com.tencent.biz.richframework.video.rfw.g
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z16) {
                RFWPlayer.this.lambda$getListener$1(z16);
            }
        };
    }

    private String getTag() {
        if (this.mPlayerOptions != null) {
            return "RFWPlayer_" + this.mPlayerOptions.tag();
        }
        return "RFWPlayer_" + hashCode();
    }

    private int getVideoDurationFromOptions() {
        if (this.mPlayerOptions.getStVideo() == null) {
            RFWLog.w(getTag(), RFWLog.USR, "getVideoDurationFromOptions null stVideo");
            return 0;
        }
        return this.mPlayerOptions.getStVideo().getDuration();
    }

    private boolean hasSuperPlayHitCache() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class) != null) {
            return ((RFWPlayerPerfReportInterceptor) this.mController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class)).hasHitCache();
        }
        return false;
    }

    @UiThread
    private void init() {
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("INIT_PLAYER_SDK", this.mPlayerOptions, true);
        if (QQVideoPlaySDKManager.isSDKReady() && QQVideoPlaySDKManager.isTpCoreSoExits()) {
            RFWLog.i(getTag(), RFWLog.USR, "sdk init success try openMedia");
            sdkInitSuccess(this.mPlayerOptions.getStartOffset());
            reportSdkInitStatus(2);
        } else {
            if (useDefaultPlayer()) {
                RFWLog.i(getTag(), RFWLog.USR, "sdk not ready and has h264 try to use systemPlayer");
                this.mPlayerOptions.setForceSystemPlayer(true);
                QQVideoPlaySDKManager.initSDKWithoutWait(RFWApplication.getApplication(), getListener(), false);
                reportSdkInitStatus(1);
                return;
            }
            initVideoSdkAsync();
        }
    }

    private void initVideoSdkAsync() {
        try {
            RFWLog.i(getTag(), RFWLog.USR, "sdk init is not ready");
            QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), getListener());
            reportSdkInitStatus(1);
        } catch (RuntimeException e16) {
            RFWLog.e(getTag(), RFWLog.USR, e16.getMessage());
            e16.printStackTrace();
        }
    }

    private void innerRelease(final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$innerRelease$4(i3);
            }
        });
    }

    private boolean isTvkPlayer() {
        return this.mController instanceof RFWTVKPlayerInterceptorController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncInitSuperPlayer$9() {
        if (isRelease()) {
            RFWLog.d(getTag(), RFWLog.USR, "do initSuperPlayer async but is release");
            return;
        }
        doInitSuperPlayer();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.RFWPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                RFWPlayerListenerDispatchUtils.onInitSuccess(RFWPlayer.this.mPlayerOptions, RFWPlayer.this);
            }
        });
        tryToOpenMediaPlayer(this.mPlayerOptions.getStartOffset());
        RFWLog.d(getTag(), RFWLog.USR, "do initSuperPlayer async");
        lambda$ensureSuperPlayer$8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getListener$0() {
        sdkInitSuccess(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getListener$1(boolean z16) {
        if (!z16) {
            RFWLog.e(getTag(), RFWLog.USR, "sdk init failed");
        } else {
            CommonUtil.j(CommonUtil.i(this.mPlayerOptions.getSceneId()));
            RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.h
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayer.this.lambda$getListener$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPlayerInfoFirstVideoFrameRendered$7() {
        if (isRelease() && !uq3.c.n5()) {
            innerRelease(RELEASE_FORM_RELEASED);
            RFWLog.e(getTag(), RFWLog.USR, "Player is released,First render return ");
        } else {
            RFWPlayerListenerDispatchUtils.onFirstFrameRendered(this.mPlayerOptions, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(final int i3) {
        RFWPlayerListenerDispatchUtils.onRelease(this.mPlayerOptions, this);
        if (this.mController != null) {
            RFWLog.d(getTag(), RFWLog.USR, "QFSPlayerRelease:" + i3 + "dispatch to controller");
            this.mController.onRelease(i3);
        } else {
            RFWLog.d(getTag(), RFWLog.USR, "QFSPlayerRelease:" + i3 + "mController is null");
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.f
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$release$2(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOutputMute$5(boolean z16) {
        this.mPlayer.setOutputMute(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlayRate$6(float f16) {
        disPatchRateChange(f16, this);
    }

    private void logInfo(int i3, Object obj) {
        RFWPlayerLimitLogUtils.printPlayerInfo(RFWPlayerLimitLogUtils.PrintLogParam.build().setPlayerTag(getTag()).setSuperPlayerVideoInfo(this.mCurrentVideoInfo).setWhat(i3).setExtra(obj).setHashCode(hashCode()));
    }

    private void onPlayerCDNInfoUpdate(Object obj) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerCDNInfoUpdate(obj);
    }

    private void onPlayerCurrentLoopStart() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerCurrentLoopStart();
        RFWPlayerListenerDispatchUtils.onVideoLoopStart(this.mPlayerOptions);
    }

    private void onPlayerDeInit() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerDeInit();
        RFWPlayerListenerDispatchUtils.onDeInit(this.mPlayerOptions, this);
        RFWLog.d(getTag(), RFWLog.USR, "player has deInit");
    }

    private void onPlayerInfoBufferingEnd() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerInfoBufferingEnd();
    }

    private void onPlayerInfoBufferingStart() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerInfoBufferingStart();
    }

    @RFWTestEvent(id = "VIDEO_COMPLETE_EVENT")
    private void onPlayerInfoCurrentLoopEnd() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onPlayerInfoCurrentLoopEnd();
        }
        RFWPlayerListenerDispatchUtils.onVideoLoopEnd(this.mPlayerOptions);
    }

    private void onPlayerInfoDownloadProgressUpdate(ISuperPlayer iSuperPlayer, Object obj) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerInfoDownloadProgressUpdate(iSuperPlayer, obj);
    }

    private void onPlayerQUICUpdate(Object obj) {
        if (this.mCurrentVideoInfo == null) {
            return;
        }
        this.mController.onPlayerQUICUpdate(obj);
    }

    private boolean openMediaPlayer(long j3) {
        if (this.mPlayer != null && this.mCurrentVideoInfo != null && this.mController != null) {
            if (this.mPlayerOptions.offsetBySeek()) {
                j3 = 0;
            }
            long j16 = j3;
            QLog.d(getTag(), 1, "[openMediaPlayer] fileId = " + this.mCurrentVideoInfo.getFileId() + " | startOffset: " + j16);
            resetParams();
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            this.mSuperPlayerOption = obtain;
            obtain.accurateSeekOnOpen = true;
            this.mController.beforeOpenMedia(obtain, this.mPlayer);
            this.mController.tryToOpenMediaPlayer(this.mPlayer, this.mCurrentVideoInfo, j16, this.mSuperPlayerOption);
            return true;
        }
        return false;
    }

    private void performSeek(long j3, boolean z16) {
        if (this.mPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[seek] null mPlayer");
            return;
        }
        try {
            long videoDuration = getVideoDuration();
            long j16 = 0;
            if (j3 > videoDuration && videoDuration != 0) {
                RFWLog.d(getTag(), RFWLog.USR, "seek over position=" + j3 + "duration=" + videoDuration);
                j3 = videoDuration;
            }
            if (j3 < 0) {
                RFWLog.d(getTag(), RFWLog.USR, "seek invalid position=" + j3 + "duration=" + this.mPlayer.getDurationMs());
            } else {
                j16 = j3;
            }
            updateSeekState(z16);
            this.mPlayer.seekTo((int) j16, 3);
            RFWLog.d(getTag(), RFWLog.USR, "seek position=" + j16 + "duration=" + videoDuration);
        } catch (Exception e16) {
            RFWLog.e(getTag(), RFWLog.USR, "[seek]", e16);
        }
    }

    private void playerParamReset() {
        resetVariablesWhenChangeDataSource();
        RFWVideoReporter.generateVideoPlayId();
        this.mVideoPlayId = RFWVideoReporter.obtainVideoPlayId();
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onPlayerParamsReset();
        }
    }

    private void reportSdkInitStatus(int i3) {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions != null && !rFWPlayerOptions.isPreloadPlayer() && this.mPlayerOptions.getTVKPlayerOption() == null) {
            QCircleQualityReporter.reportQualityEvent(EVENT_ID, Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(i3))), false);
        } else {
            RFWLog.i(getTag(), RFWLog.CLR, "sdk init is ready,report return");
        }
    }

    private void resetParams() {
        this.mPlayer.reset();
        this.mPlayer.setLoopback(this.mIsLoopback);
        setOutputMute(this.mOutputMute);
        this.mPlayer.setPlaySpeedRatio(this.mPlayRate);
    }

    private void resetVariablesWhenChangeDataSource() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            stop();
        }
        this.mVideoPlayId = 0L;
    }

    private void sdkInitSuccess(long j3) {
        if (isRelease()) {
            QLog.d(getTag(), 1, "sdkInitSuccess has release");
            return;
        }
        ensureSuperPlayer();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_init_player_async", true) && this.mPlayerOptions.shouldInitBackThread()) {
            return;
        }
        RFWPlayerListenerDispatchUtils.onInitSuccess(this.mPlayerOptions, this);
        tryToOpenMediaPlayer(j3);
    }

    private void setMuteWhenRelease() {
        if (uq3.c.J()) {
            RFWLog.e(getTag(), RFWLog.USR, "QFSPlayerRelease set output mute");
            setOutputMute(true);
        }
    }

    private void tryToOpenMediaPlayer(long j3) {
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("INIT_PLAYER_SDK", this.mPlayerOptions, false);
        if (this.mCurrentVideoInfo == null) {
            RFWLog.d(getTag(), RFWLog.USR, "playFailed video info null");
            RFWPlayerListenerDispatchUtils.onVideoPlayError(this.mPlayerOptions, 0, Integer.parseInt("19000001"), Integer.parseInt("19000001"), "");
            return;
        }
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("OPEN_MEDIA_SOURCE", this.mPlayerOptions, true);
        RFWLog.d(getTag(), RFWLog.USR, "[tryToOpenMediaPlayer], fileId = " + this.mCurrentVideoInfo.getFileId() + ", url = " + this.mCurrentVideoInfo.getPlayUrl());
        playerParamReset();
        if (openMediaPlayer(j3)) {
            this.mController.afterOpenMedia(this.mSuperPlayerOption, this.mPlayer);
        }
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("OPEN_MEDIA_SOURCE", this.mPlayerOptions, false);
    }

    private void updateSeekState(boolean z16) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class) != null) {
            ((RFWPlayerPerfReportInterceptor) this.mController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class)).upDateSeekState(z16);
        }
    }

    private boolean useDefaultPlayer() {
        if (!uq3.c.r0()) {
            RFWLog.i(getTag(), RFWLog.USR, "return not open");
            return false;
        }
        if (this.mController instanceof RFWTVKPlayerInterceptorController) {
            RFWLog.i(getTag(), RFWLog.USR, "return tvk");
            return false;
        }
        if (this.mPlayerOptions.getRealPlayBean() != null && this.mPlayerOptions.getRealPlayBean().mVideoEncode == 1) {
            RFWLog.i(getTag(), RFWLog.USR, "init sdk without wait");
            return true;
        }
        RFWLog.i(getTag(), RFWLog.USR, "return not h264");
        return false;
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            if (Build.VERSION.SDK_INT > 26) {
                RFWLog.e(getTag(), RFWLog.USR, RFWPlayerLimitLogUtils.getCurrentStackTrace("bindVideoPlayerInfo exception no player", 15));
                return;
            }
            return;
        }
        iSuperPlayer.bindVideoPlayerInfo(obj);
    }

    public boolean enableReport() {
        return this.mEnablePerfReport;
    }

    public long getCurrentPositionMs() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[getCurrentPositionMs] null mPlayer");
            return -1L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    public SuperPlayerVideoInfo getCurrentSuperVideoInfo() {
        return this.mCurrentVideoInfo;
    }

    public long getDurationMs() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[getDurationMs] null mPlayer");
            return -1L;
        }
        return iSuperPlayer.getDurationMs();
    }

    public float getPlayRate() {
        return this.mPlayRate;
    }

    public long getPlayTime() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class) != null) {
            return ((RFWPlayerPerfReportInterceptor) this.mController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class)).getPlayTime();
        }
        return 0L;
    }

    public long getPlayableDurationMs() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            return 0L;
        }
        return iSuperPlayer.getPlayableDurationMs() - this.mPlayer.getCurrentPositionMs();
    }

    public RFWPlayerOptions getRFWPlayerOptions() {
        return this.mPlayerOptions;
    }

    public ISuperPlayer getRealPlayer() {
        return this.mPlayer;
    }

    public SuperPlayerOption getSuperPlayerOption() {
        return this.mSuperPlayerOption;
    }

    @Nullable
    public TVKNetVideoInfo getTVKNetVideoInfo() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWTVKPlayerCommonInterceptor.class) != null) {
            return ((RFWTVKPlayerCommonInterceptor) this.mController.getTargetIntercept(RFWTVKPlayerCommonInterceptor.class)).getTVKNetVideoInfo();
        }
        return null;
    }

    public Map<Integer, Object> getTvkInfoMap() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWTVKPlayerCommonInterceptor.class) != null) {
            return ((RFWTVKPlayerCommonInterceptor) this.mController.getTargetIntercept(RFWTVKPlayerCommonInterceptor.class)).getTvkInfoMap();
        }
        return null;
    }

    public int getVideoDuration() {
        long videoDurationFromOptions = getVideoDurationFromOptions();
        long durationMs = getDurationMs();
        if (o.m() && durationMs > 0) {
            return (int) durationMs;
        }
        if (videoDurationFromOptions <= 0) {
            videoDurationFromOptions = durationMs;
        }
        return (int) videoDurationFromOptions;
    }

    public long getVideoPlayId() {
        return this.mVideoPlayId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getVideoView() {
        ISPlayerVideoView iSPlayerVideoView = this.mPlayerVideoView;
        if (iSPlayerVideoView == 0) {
            return null;
        }
        if (iSPlayerVideoView instanceof View) {
            return (View) iSPlayerVideoView;
        }
        return iSPlayerVideoView.getRenderView();
    }

    public boolean isDeInit() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class) != null && ((RFWPlayerStatusInterceptor) this.mController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).isIsDeInit()) {
            return true;
        }
        return false;
    }

    public boolean isError() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class) != null && ((RFWPlayerStatusInterceptor) this.mController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).isError()) {
            return true;
        }
        return false;
    }

    public boolean isFirstRenderCallback() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class) != null && ((RFWPlayerStatusInterceptor) this.mController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).isFirstRenderCallback()) {
            return true;
        }
        return false;
    }

    public boolean isHasHitCache() {
        boolean z16;
        if (!this.mPlayerOptions.hitPreloadCache() && !this.mPlayerOptions.isPreloadPlayer() && !this.mPlayerOptions.hitSelectUrlCache() && !hasSuperPlayHitCache()) {
            z16 = false;
        } else {
            z16 = true;
        }
        RFWLog.d(getTag(), RFWLog.CLR, "isHasHitCache:", Boolean.valueOf(z16));
        return z16;
    }

    public boolean isOutputMute() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            return false;
        }
        return iSuperPlayer.isOutputMute();
    }

    public boolean isPausing() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPausing();
        }
        return false;
    }

    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null || !iSuperPlayer.isPlaying() || isRelease()) {
            return false;
        }
        return true;
    }

    public boolean isPrepared() {
        RFWBaseInterceptorController rFWBaseInterceptorController;
        if (this.mPlayer == null || (rFWBaseInterceptorController = this.mController) == null) {
            return false;
        }
        if (!((RFWPlayerStatusInterceptor) rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).isPrepared() && this.mPlayer.getCurrentPlayerState() != 4) {
            return false;
        }
        return true;
    }

    public boolean isReady() {
        if (this.mPlayer != null) {
            return true;
        }
        return false;
    }

    public boolean isRelease() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerStatusInterceptor.class) != null && ((RFWPlayerStatusInterceptor) this.mController.getTargetIntercept(RFWPlayerStatusInterceptor.class)).isRelease()) {
            return true;
        }
        return false;
    }

    public boolean isSystemPlayer() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null && rFWBaseInterceptorController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class) != null) {
            return ((RFWPlayerPerfReportInterceptor) this.mController.getTargetIntercept(RFWPlayerPerfReportInterceptor.class)).isSysTemPlayer();
        }
        return false;
    }

    public void loadPlayOptions(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        this.mPlayerOptions = rFWPlayerOptions;
        if (rFWPlayerOptions.getTVKPlayerOption() != null) {
            this.mController = new RFWTVKPlayerInterceptorController(this);
            RFWLog.d(getTag(), RFWLog.USR, "use tvkPlayer");
        } else {
            this.mController = new RFWPlayerInterceptorController(this);
            RFWLog.d(getTag(), RFWLog.USR, "use superPlayer");
        }
        init();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        if (this.mController == null) {
            return;
        }
        RFWPlayerListenerDispatchUtils.onCompletion(this.mPlayerOptions, iSuperPlayer);
        this.mController.onCompletion(iSuperPlayer);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        String tag = getTag();
        int i18 = RFWLog.USR;
        RFWLog.e(tag, i18, "onError, msg =" + ("module:" + i3 + ", errorType:" + i16 + ", errorCode:" + i17 + ", extraInfo:" + str));
        if (this.mController == null) {
            return false;
        }
        RFWPlayerListenerDispatchUtils.onVideoPassivePause(this.mPlayerOptions, i17, i3, 0L, 0L, 0L);
        RFWPlayerListenerDispatchUtils.onVideoPlayError(this.mPlayerOptions, i3, i16, i17, str);
        this.mController.onError(iSuperPlayer, i3, i16, i17, str);
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        logInfo(i3, obj);
        if (i3 != 105) {
            if (i3 != 201) {
                if (i3 != 204) {
                    if (i3 != 207) {
                        if (i3 != 250) {
                            if (i3 != 253) {
                                if (i3 != 107) {
                                    if (i3 != 108) {
                                        if (i3 != 112) {
                                            if (i3 != 113) {
                                                defaultOnInfo(i3, j3, j16, obj);
                                            } else {
                                                onPlayerInfoBufferingEnd();
                                            }
                                        } else {
                                            onPlayerInfoBufferingStart();
                                        }
                                    } else {
                                        onPlayerInfoCurrentLoopEnd();
                                    }
                                } else {
                                    onPlayerCurrentLoopStart();
                                }
                            } else {
                                onPlayerDeInit();
                            }
                        } else {
                            onPlayerQUICUpdate(obj);
                        }
                    } else {
                        onPlayerInfoDownloadProgressUpdate(iSuperPlayer, obj);
                    }
                } else {
                    onPlayerCDNInfoUpdate(obj);
                }
            } else {
                downloadComplete();
            }
        } else {
            onPlayerInfoFirstVideoFrameRendered();
        }
        RFWPlayerMonitorImpl.instance().handleInfo(i3, j3, j16, obj);
        return false;
    }

    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onNetVideoInfo(tVKNetVideoInfo);
        RFWPlayerListenerDispatchUtils.onNetVideoInfo(this.mPlayerOptions, tVKNetVideoInfo);
    }

    @RFWTestEvent(id = "VIDEO_FIRST_FRAME_RENDER_EVENT")
    public void onPlayerInfoFirstVideoFrameRendered() {
        RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$onPlayerInfoFirstVideoFrameRendered$7();
            }
        });
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerInfoFirstVideoFrameRendered();
    }

    public void onRealTimeInfoChange(int i3, Object obj) {
        if ((this.mController instanceof RFWTVKPlayerInterceptorController) && this.mPlayer != null) {
            RFWLog.d(getTag(), RFWLog.USR, "call onRealTimeInfoChange");
            this.mPlayer.onRealTimeInfoChange(i3, obj);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onSeekComplete(iSuperPlayer);
        }
    }

    public void onStartTrackingTouch(int i3, int i16) {
        if (this.mPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[onStartTrackingTouch] null mPlayer");
            return;
        }
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onStartTrackingTouch(i3, i16);
        }
        RFWLog.d(getTag(), RFWLog.USR, "[startTracking]");
    }

    public void onStopTrackingTouch(int i3, int i16) {
        if (this.mPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[onStopTrackingTouch] null mPlayer");
            return;
        }
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onStopTrackingTouch(i3, i16);
        }
        seek((int) ((i3 / (i16 * 1.0f)) * ((float) this.mPlayer.getDurationMs())));
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        ISPlayerVideoView iSPlayerVideoView = this.mPlayerVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setXYaxis(0);
        }
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onVideoPrepare();
        if (isRelease() && !uq3.c.n5()) {
            innerRelease(RELEASE_FORM_RELEASED);
            RFWLog.e(getTag(), RFWLog.USR, "Player is released,prepared return ");
            return;
        }
        long startOffset = this.mPlayerOptions.getStartOffset();
        if (this.mPlayerOptions.offsetBySeek() && startOffset > 0) {
            seekByOffset(startOffset);
            RFWLog.d(getTag(), RFWLog.USR, "start offset by seek:" + startOffset);
        }
        RFWPlayerListenerDispatchUtils.onVideoPrepared(this.mPlayerOptions, this);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
        if (this.mController == null) {
            return;
        }
        RFWPlayerListenerDispatchUtils.onVideoSizeChanged(this.mPlayerOptions, iSuperPlayer, i3, i16);
    }

    public void pause() {
        if (this.mPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[pause] null mPlayer");
            return;
        }
        RFWPlayerListenerDispatchUtils.onPause(this.mPlayerOptions, this);
        RFWLog.d(getTag(), RFWLog.USR, "[pause]");
        this.mPlayer.pause();
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onPause();
        }
    }

    public void playerStartPlayState() {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.playerStartPlayState();
    }

    public void release(final int i3) {
        if (isRelease()) {
            return;
        }
        setMuteWhenRelease();
        flagReleaseStatus(i3);
        RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayer.this.lambda$release$3(i3);
            }
        });
        if (Build.VERSION.SDK_INT > 26) {
            RFWLog.e(getTag(), RFWLog.USR, RFWPlayerLimitLogUtils.getCurrentStackTrace("QFSPlayerRelease", 15));
        }
    }

    public void seek(long j3) {
        performSeek(j3, false);
    }

    public void seekByOffset(long j3) {
        performSeek(j3, true);
    }

    public void setEnablePerfReport(boolean z16) {
        this.mEnablePerfReport = z16;
    }

    public void setLoopback(boolean z16) {
        this.mIsLoopback = z16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16);
        }
    }

    public void setOutputMute(final boolean z16) {
        if (z16 == this.mOutputMute) {
            return;
        }
        this.mOutputMute = z16;
        if (this.mPlayer == null) {
            return;
        }
        QLog.d(getTag(), 1, "[setOutputMute] mute: " + z16);
        if (isTvkPlayer()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.a
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayer.this.lambda$setOutputMute$5(z16);
                }
            });
        } else {
            this.mPlayer.setOutputMute(z16);
        }
    }

    public void setPlayRate(final float f16) {
        if (this.mPlayRate == f16) {
            QLog.d(getTag(), 1, "setPlayRate return same rate:" + f16);
            return;
        }
        if (RFWThreadManager.getUIHandler().getLooper().isCurrentThread() && isSystemPlayer() && o.T0()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.c
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayer.this.lambda$setPlayRate$6(f16);
                }
            });
        } else {
            disPatchRateChange(f16, this);
        }
        this.mPlayRate = f16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
            QLog.d(getTag(), 1, "setPlayRate:" + f16);
            return;
        }
        QLog.d(getTag(), 1, "setPlayRate, play is empty");
    }

    public void setPlayerActive() {
        if (this.mPlayer == null) {
            return;
        }
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("SET_PLAYER_ACTIVE", this.mPlayerOptions, true);
        this.mPlayer.setPlayerActive();
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onPlayerActive(this.mSuperPlayerOption);
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback("SET_PLAYER_ACTIVE", this.mPlayerOptions, false);
    }

    public void setPlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        this.mPlayerVideoView = iSPlayerVideoView;
    }

    public void start() {
        if (this.mPlayer == null) {
            RFWLog.w(getTag(), RFWLog.USR, "[start] null mPlayer");
            return;
        }
        if (isRelease() && !uq3.c.n5()) {
            QLog.d(getTag(), 1, "start has release and do release");
            innerRelease(RELEASE_FORM_RELEASED);
            return;
        }
        if (this.mPlayer.isPlaying()) {
            RFWLog.w(getTag(), RFWLog.USR, "[start] mPlayer is playing");
            return;
        }
        if (RFWLifecycleHelper.getInstance().isRunningInBackground() && RFWVideoUtils.enableBackGroundPause(this.mPlayerOptions)) {
            RFWLog.d(getTag(), RFWLog.USR, "not need start , is on backGround");
            return;
        }
        RFWPlayerListenerDispatchUtils.onStart(this.mPlayerOptions, this);
        this.mPlayer.start();
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onStart();
    }

    public void stop() {
        RFWPlayerListenerDispatchUtils.onStop(this.mPlayerOptions, this);
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController != null) {
            rFWBaseInterceptorController.onStop();
        }
        if (this.mPlayer != null) {
            RFWLog.d(getTag(), RFWLog.USR, "[stop]");
            this.mPlayer.stop();
        }
    }

    public void switchDefinition(String str, int i3) {
        if (this.mPlayer != null && !TextUtils.isEmpty(str) && (this.mController instanceof RFWTVKPlayerInterceptorController)) {
            RFWLog.d(getTag(), RFWLog.USR, "switchDefinition():" + str);
            this.mPlayer.switchDefinition(str, i3);
        }
    }

    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        if (this.mPlayer != null && iSPlayerVideoView != null) {
            RFWLog.d(getTag(), RFWLog.USR, "updatePlayerVideoView()");
            this.mPlayer.updatePlayerVideoView(iSPlayerVideoView);
        }
    }

    public void updateProgress(int i3, int i16) {
        RFWBaseInterceptorController rFWBaseInterceptorController = this.mController;
        if (rFWBaseInterceptorController == null) {
            return;
        }
        rFWBaseInterceptorController.onUpdateProgress(i3, i16);
    }

    public void setLoopback(boolean z16, int i3, int i16) {
        this.mIsLoopback = z16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16, i3, i16);
        }
    }
}
