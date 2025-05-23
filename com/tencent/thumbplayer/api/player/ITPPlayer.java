package com.tencent.thumbplayer.api.player;

import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPTimeoutException;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.dtreport.IDtReport;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;

/* loaded from: classes26.dex */
public interface ITPPlayer extends IDtReport {
    public static final long TP_PLAYER_DEFAULT_OPAQUE = -1;
    public static final long TP_PLAYER_INVALID_DURATION_VALUE = -1;
    public static final long TP_PLAYER_LOOPBACK_END_POSITION_DEFAULT_MS = -1;
    public static final long TP_PLAYER_LOOPBACK_START_POSITION_DEFAULT_MS = 0;

    void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException;

    void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException;

    void addPlugin(ITPPluginBase iTPPluginBase);

    void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException;

    void deselectTrackAsync(int i3);

    void deselectTrackAsync(int i3, long j3);

    long getAvailablePositionMs();

    long getCurrentPositionMs();

    int getCurrentState() throws TPTimeoutException;

    long getDurationMs();

    int getHeight();

    int getPlayerCoreType();

    @Nullable
    TPProgramInfo[] getProgramInfo();

    String getProperty(String str);

    @Nullable
    ITPReportExtendedController getReportExtendedController();

    @Nullable
    ITPBusinessReportManager getReportManager();

    TPContext getTPConext();

    @Nullable
    TPTrackInfo[] getTrackInfo();

    int getWidth();

    void pause() throws IllegalStateException;

    void pauseDownload() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void removeTrack(int i3) throws IllegalArgumentException;

    void reopenPlayer(int i3, boolean z16);

    void reset();

    void resumeDownload();

    void seekToAsync(long j3) throws IllegalStateException;

    void seekToAsync(long j3, int i3) throws IllegalStateException;

    void seekToAsync(long j3, int i3, long j16) throws IllegalStateException;

    void seekToAsync(long j3, long j16) throws IllegalStateException;

    void selectProgramAsync(int i3);

    void selectProgramAsync(int i3, long j3);

    void selectTrackAsync(int i3);

    void selectTrackAsync(int i3, long j3);

    void setAudioMute(boolean z16);

    void setAudioNormalizeVolumeParams(String str);

    void setAudioVolume(float f16);

    void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19);

    void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException;

    void setIsActive(boolean z16);

    void setLogTagPrefix(String str);

    void setLoopback(boolean z16);

    void setLoopback(boolean z16, long j3, long j16);

    void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener);

    void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener);

    void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener);

    void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener);

    void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener);

    void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener);

    void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener);

    void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener);

    void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener);

    void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener);

    void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener);

    void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener);

    void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener);

    void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener);

    void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener);

    void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener);

    void setPlaySpeedRatio(float f16);

    void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException;

    void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException;

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;

    void stopAsync() throws IllegalStateException;

    void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;
}
