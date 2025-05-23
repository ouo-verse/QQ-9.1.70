package com.tencent.qqlive.tvkplayer.qqliveasset.api;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.dtreport.IDtReport;

/* loaded from: classes23.dex */
public interface ITVKQQLiveAssetPlayer extends IDtReport {
    public static final String TVK_PLAYER_THREAD_NAME = "TVKWorker";

    /* loaded from: classes23.dex */
    public interface ITVKQQLiveAssetPlayerListener {
        long getAdvRemainTimeMs();

        void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer);

        void onCaptureImageFailed(int i3, int i16);

        void onCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap);

        void onCompletion();

        void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo);

        boolean onError(TVKError tVKError);

        TVKUserInfo onGetUserInfo();

        boolean onInfo(int i3, long j3, long j16, Object obj);

        void onLoopBackChanged();

        void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo);

        void onOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16);

        void onPermissionTimeout();

        void onSeekComplete();

        void onStateChange(ITVKPlayerState iTVKPlayerState);

        void onSubtitleDataOut(TPSubtitleData tPSubtitleData);

        void onVideoCGIed(@Nullable TVKNetVideoInfo tVKNetVideoInfo);

        void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer);

        void onVideoPrepared();

        void onVideoPreparing();

        void onVideoSizeChanged(int i3, int i16);
    }

    void addTrackInfo(int i3, String str, String str2);

    int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException;

    void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException;

    void deselectTrack(int i3) throws IllegalArgumentException, IllegalStateException;

    void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException;

    ITVKAudioFxProcessor getAudioFxProcessor();

    long getAvailablePositionMs();

    int getBufferPercent();

    TVKNetVideoInfo getCurNetVideoInfo();

    long getCurrentPosition();

    @Deprecated
    int getDownloadSpeed(int i3);

    long getDuration();

    boolean getOutputMute();

    TPProgramInfo[] getProgramInfo();

    ITVKRichMediaSynchronizer getRichMediaSynchronizer() throws IllegalStateException;

    int getSelectedTrack(int i3);

    @Deprecated
    String getStreamDumpInfo();

    @Nullable
    ITVKSubtitleRendererController getSubtitleRendererController();

    TVKTrackInfo[] getTrackInfo();

    ITVKVideoFxProcessor getVideoFxProcessor();

    int getVideoHeight();

    int getVideoRotation() throws IllegalStateException;

    int getVideoWidth();

    boolean isLoopBack();

    boolean isPaused();

    boolean isPlaying();

    void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException;

    void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void openMediaPlayerByAfd(Context context, AssetFileDescriptor assetFileDescriptor, long j3, long j16);

    void openMediaPlayerByPfd(Context context, ParcelFileDescriptor parcelFileDescriptor, long j3, long j16);

    void openMediaPlayerByUrl(Context context, String str, String str2, long j3, long j16, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void pause();

    void pauseDownload();

    void prepare();

    void refreshPlayer();

    void refreshPlayerWithReopen();

    void release();

    void resumeDownload();

    void seekForLive(long j3);

    void seekTo(int i3);

    void seekToAccuratePos(int i3);

    void seekToAccuratePosFast(int i3);

    void selectProgram(int i3, long j3);

    void selectTrack(int i3) throws IllegalArgumentException, IllegalStateException;

    void setAlignment(int i3);

    void setAssetPlayerListener(ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener);

    void setAudioGainRatio(float f16);

    void setDisplayOffset(float f16, float f17);

    void setDisplayScale(float f16);

    void setDisplayScale(float f16, float f17, float f18);

    void setFlowId(String str);

    void setLoopback(boolean z16);

    void setLoopback(boolean z16, long j3, long j16);

    boolean setOutputMute(boolean z16);

    void setPlaySpeedRatio(float f16);

    void setSurface(Surface surface);

    void setXYaxis(int i3);

    void start();

    void startAd();

    void stop();

    void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException;

    void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer);

    void updateReportParam(TVKProperties tVKProperties);

    void updateUserInfo(TVKUserInfo tVKUserInfo);
}
