package com.tencent.qqlive.tvkplayer.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.dtreport.IDtReport;

/* loaded from: classes23.dex */
public interface ITVKMediaPlayer extends IDtReport {
    public static final int TVK_PLAYER_LIVE_POSITION_PLAYBACK_BACK_TO_NORMAL_STREAM = -1;
    public static final int TVK_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
    public static final int TVK_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;

    /* loaded from: classes23.dex */
    public interface OnAdClickedListener {
        void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer);

        void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer);

        void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer);

        void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3);

        void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer);

        void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer);

        void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer);

        void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer);

        void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer);

        void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16);
    }

    /* loaded from: classes23.dex */
    public interface OnAdCustomCommandListener {
        Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj);
    }

    /* loaded from: classes23.dex */
    public interface OnAudioFrameOutListener {
        void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer);
    }

    /* loaded from: classes23.dex */
    public interface OnCaptureImageListener {
        void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16);

        void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap);
    }

    /* loaded from: classes23.dex */
    public interface OnCompletionListener {
        void onCompletion(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnErrorListener {
        boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError);
    }

    /* loaded from: classes23.dex */
    public interface OnGetUserInfoListener {
        TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnInfoListener {
        boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj);
    }

    /* loaded from: classes23.dex */
    public interface OnLogoPositionListener {
        void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16);
    }

    /* loaded from: classes23.dex */
    public interface OnLoopBackChangedListener {
        void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnMidAdListener {
        void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3);

        void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3);

        void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer);

        void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16);
    }

    /* loaded from: classes23.dex */
    public interface OnNetVideoInfoListener {
        void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo);
    }

    /* loaded from: classes23.dex */
    public interface OnPermissionTimeoutListener {
        void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnPostRollAdListener {
        void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer);

        void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3);

        void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnPreAdListener {
        void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer);

        void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3);

        void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnScrollAdListener {
        void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3);

        void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2);
    }

    /* loaded from: classes23.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoFrameOutListener {
        void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoPreparedListener {
        void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoPreparingListener {
        void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16);
    }

    void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void addReportEventListener(ITVKReportEventListener iTVKReportEventListener);

    void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException;

    void addTrack(int i3, String str, String str2) throws IllegalArgumentException;

    int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException;

    void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException;

    void deselectTrack(int i3);

    void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException;

    long getAdCurrentPosition();

    @Nullable
    Object getAdStatus();

    ITVKAudioFxProcessor getAudioFxProcessor();

    long getAvailablePositionMs();

    int getBufferPercent();

    TVKNetVideoInfo getCurNetVideoInfo();

    long getCurrentPosition();

    @Deprecated
    int getDownloadSpeed(int i3);

    long getDuration();

    String getHlsTagInfo(String str);

    boolean getOutputMute();

    long getPlayedTime();

    TPProgramInfo[] getProgramInfo();

    @Nullable
    ITVKRichMediaSynchronizer getRichMediaSynchronizer() throws IllegalStateException;

    int getSelectedTrack(int i3);

    @Deprecated
    String getStreamDumpInfo();

    @Nullable
    ITVKSubtitleRendererController getSubtitleRendererController();

    TVKTrackInfo[] getTrackInfo();

    ITVKVideoFxProcessor getVideoFxProcessor();

    int getVideoHeight();

    int getVideoRotation();

    ITVKVideoViewBase getVideoView();

    int getVideoWidth();

    boolean isLoopBack();

    boolean isPaused();

    boolean isPlaying();

    void onClickPause();

    void onClickPause(ViewGroup viewGroup);

    boolean onKeyEvent(KeyEvent keyEvent);

    void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException;

    void onSkipAdResult(boolean z16);

    boolean onTouchEvent(View view, MotionEvent motionEvent);

    void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void pause();

    void pauseDownload();

    void refreshPlayer();

    void refreshPlayerWithReopen();

    void release();

    void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener);

    void resumeDownload();

    void saveReport();

    void seekForLive(long j3);

    void seekTo(int i3);

    void seekToAccuratePos(int i3);

    void seekToAccuratePosFast(int i3);

    void selectProgram(int i3, long j3);

    void selectTrack(int i3);

    void setAlignment(int i3);

    void setAudioGainRatio(float f16);

    @RequiresApi(api = 24)
    void setDisplayOffset(float f16, float f17);

    void setDisplayScale(float f16);

    @RequiresApi(api = 24)
    void setDisplayScale(float f16, float f17, float f18);

    void setLoopback(boolean z16);

    void setLoopback(boolean z16, long j3, long j16);

    void setNextLoopVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str);

    void setNextPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void setOnAdClickedListener(OnAdClickedListener onAdClickedListener);

    void setOnAdCustomCommandListener(OnAdCustomCommandListener onAdCustomCommandListener);

    void setOnAudioFrameOutListener(OnAudioFrameOutListener onAudioFrameOutListener);

    void setOnCaptureImageListener(OnCaptureImageListener onCaptureImageListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnGetUserInfoListener(OnGetUserInfoListener onGetUserInfoListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLogoPositionListener(OnLogoPositionListener onLogoPositionListener);

    void setOnLoopbackChangedListener(OnLoopBackChangedListener onLoopBackChangedListener);

    void setOnMidAdListener(OnMidAdListener onMidAdListener);

    void setOnNetVideoInfoListener(OnNetVideoInfoListener onNetVideoInfoListener);

    void setOnPermissionTimeoutListener(OnPermissionTimeoutListener onPermissionTimeoutListener);

    void setOnPostRollAdListener(OnPostRollAdListener onPostRollAdListener);

    void setOnPreAdListener(OnPreAdListener onPreAdListener);

    void setOnScrollAdListener(OnScrollAdListener onScrollAdListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoFrameOutListener(OnVideoFrameOutListener onVideoFrameOutListener);

    void setOnVideoPreparedListener(OnVideoPreparedListener onVideoPreparedListener);

    void setOnVideoPreparingListener(OnVideoPreparingListener onVideoPreparingListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    boolean setOutputMute(boolean z16);

    void setPlaySpeedRatio(float f16);

    void setSurface(Surface surface);

    void setXYaxis(int i3);

    void skipAd();

    void start();

    void stop();

    void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException;

    void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer);

    void updateReportParam(TVKProperties tVKProperties);

    void updateUserInfo(TVKUserInfo tVKUserInfo);

    @Deprecated
    void updateVrReportParam(TVKProperties tVKProperties);
}
