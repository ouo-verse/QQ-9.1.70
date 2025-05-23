package com.tencent.richframework.video;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017J\b\u0010\u000f\u001a\u00020\u0004H\u0017J\b\u0010\u0010\u001a\u00020\u0004H\u0017J\b\u0010\u0011\u001a\u00020\u0004H\u0017J\b\u0010\u0012\u001a\u00020\u0004H\u0017J\b\u0010\u0013\u001a\u00020\u0004H\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0017J*\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017J\b\u0010\u001b\u001a\u00020\u0004H\u0017J\b\u0010\u001c\u001a\u00020\u0004H\u0017J\b\u0010\u001d\u001a\u00020\u0004H\u0017J \u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/richframework/video/IPlayerStateCallback;", "", "", "firstInit", "", "onInitSuccess", "onFirstFrameRendered", "onVideoPrepared", "", "what", "model", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "soloTime", "onVideoPassivePause", "onCompletion", "onRelease", "onDownloadAllFinish", "onSeekComplete", "onVideoLoopStart", "onVideoLoopEnd", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onVideoPlayError", "onTimerCallback", "onBufferStart", "onBufferEnd", "downloadSpeed", "downloadSize", "totalSize", "updateDownloadState", "video-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IPlayerStateCallback {
    @JvmDefault
    void onBufferEnd();

    @JvmDefault
    void onBufferStart();

    @JvmDefault
    void onCompletion();

    @JvmDefault
    void onDownloadAllFinish();

    @JvmDefault
    void onFirstFrameRendered();

    @JvmDefault
    void onInitSuccess(boolean firstInit);

    @JvmDefault
    void onRelease();

    @JvmDefault
    void onSeekComplete();

    @JvmDefault
    void onTimerCallback();

    @JvmDefault
    void onVideoLoopEnd();

    @JvmDefault
    void onVideoLoopStart();

    @JvmDefault
    void onVideoPassivePause(int what, int model, long playTime, long soloTime);

    @JvmDefault
    void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo);

    @JvmDefault
    void onVideoPrepared();

    @JvmDefault
    void updateDownloadState(long downloadSpeed, long downloadSize, long totalSize);
}
