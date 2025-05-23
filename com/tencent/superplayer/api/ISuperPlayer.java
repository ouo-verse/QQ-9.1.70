package com.tencent.superplayer.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.report.ISPReportProvider;
import com.tencent.superplayer.tvkplayer.ITVKAbility;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.dtreport.IDtReport;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ISuperPlayer extends ITVKAbility, IDtReport {

    /* loaded from: classes26.dex */
    public interface OnAudioFrameOutputListener {
        void onAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface OnCaptureImageListener {
        void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16);

        void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap);
    }

    /* loaded from: classes26.dex */
    public interface OnCompletionListener {
        void onCompletion(ISuperPlayer iSuperPlayer);
    }

    /* loaded from: classes26.dex */
    public interface OnDefinitionInfoListener {
        void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList);
    }

    /* loaded from: classes26.dex */
    public interface OnErrorListener {
        boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str);
    }

    /* loaded from: classes26.dex */
    public interface OnInfoListener {
        boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj);
    }

    /* loaded from: classes26.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(ISuperPlayer iSuperPlayer);
    }

    /* loaded from: classes26.dex */
    public interface OnSubtitleDataListener {
        void onSubtitleData(ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData);
    }

    /* loaded from: classes26.dex */
    public interface OnTVideoNetInfoListener {
        void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo);
    }

    /* loaded from: classes26.dex */
    public interface OnVideoFrameOutputListener {
        void onVideoFrameOutput(TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface OnVideoPreparedListener {
        void onVideoPrepared(ISuperPlayer iSuperPlayer);
    }

    /* loaded from: classes26.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16);
    }

    void addExtReportData(String str, String str2);

    void addExtReportData(Map<String, String> map);

    void addSubtitleSource(String str, String str2);

    int captureImageInTime(long j3, int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException;

    int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) throws IllegalStateException, IllegalArgumentException, IllegalAccessException;

    void deselectTrack(int i3, long j3);

    int getCurrentPlayerState();

    long getCurrentPositionMs();

    long getDurationMs();

    long getFileSizeBytes();

    float getMaxVolumeGain();

    MediaInfo getMediaInfo();

    long getPlayableDurationMs();

    TPProgramInfo[] getProgramInfo();

    String getProperty(String str);

    ISPReportProvider getReportProvider();

    int getSceneId();

    String getStreamDumpInfo();

    SuperPlayerVideoInfo getSuperVideoInfo();

    String getToken();

    TPTrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoRotation();

    ISPlayerVideoView getVideoView();

    int getVideoWidth();

    boolean isBuffering();

    boolean isLoopBack();

    boolean isOutputMute();

    boolean isPausing();

    boolean isPlaying();

    void onPrePlayViewShow();

    void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3);

    void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption);

    void pause();

    void pauseDownload();

    void release();

    void reset();

    void resumeDownload();

    void seekTo(int i3);

    void seekTo(int i3, int i16);

    void selectProgram(int i3, long j3);

    void selectTrack(int i3, long j3);

    void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18);

    void setLoopback(boolean z16);

    void setLoopback(boolean z16, long j3, long j16);

    void setOnAudioFrameOutputListener(OnAudioFrameOutputListener onAudioFrameOutputListener);

    void setOnCaptureImageListener(OnCaptureImageListener onCaptureImageListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnDefinitionInfoListener(OnDefinitionInfoListener onDefinitionInfoListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnSubtitleDataListener(OnSubtitleDataListener onSubtitleDataListener);

    void setOnTVideoNetInfoUpdateListener(OnTVideoNetInfoListener onTVideoNetInfoListener);

    void setOnVideoFrameOutputListener(OnVideoFrameOutputListener onVideoFrameOutputListener);

    void setOnVideoPreparedListener(OnVideoPreparedListener onVideoPreparedListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOutputMute(boolean z16);

    void setPlaySpeedRatio(float f16);

    void setPlayerActive();

    void setPlayerOptionalParamList(List<TPOptionalParam> list);

    void setReportContentId(String str);

    void setSurface(Surface surface);

    void setVolumeGain(float f16);

    void setXYaxis(int i3);

    void start();

    void stop();

    void switchDefinition(String str, int i3);

    void switchDefinitionForUrl(String str, int i3);

    void updatePlayerSceneId(int i3);

    void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView);
}
