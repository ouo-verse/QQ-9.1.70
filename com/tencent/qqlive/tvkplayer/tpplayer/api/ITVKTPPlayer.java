package com.tencent.qqlive.tvkplayer.tpplayer.api;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.dtreport.IDtReport;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;

/* loaded from: classes23.dex */
public interface ITVKTPPlayer extends IDtReport {
    public static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_FLOWID = "tp_asset_param_key_string_flowid";
    public static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_PLAY_SCENE_TYPE = "tp_asset_param_key_string_play_scene_type";
    public static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_VID = "tp_asset_param_key_string_vid";

    void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException;

    void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException;

    void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException;

    void deselectTrackAsync(int i3, long j3);

    long getAvailablePositionMs();

    long getCurrentPositionMs();

    long getDurationMs();

    int getHeight();

    int getPlayerCoreType();

    String getProperty(String str);

    @Nullable
    ITPBusinessReportManager getReportManager();

    ITPPlayer getTPPlayer();

    @Nullable
    TPTrackInfo[] getTrackInfo();

    int getWidth();

    void pause() throws IllegalStateException;

    void pauseDownload();

    void prepareAsync() throws IllegalStateException, UnsupportedOperationException;

    void release();

    void removeTrack(int i3) throws IllegalArgumentException;

    void reset() throws IllegalStateException;

    void resumeDownload();

    void seekToAsync(int i3) throws IllegalStateException;

    void seekToAsync(int i3, int i16, long j3) throws IllegalStateException;

    void seekToAsync(int i3, long j3) throws IllegalStateException;

    void selectTrackAsync(int i3, long j3);

    void setAudioMute(boolean z16);

    void setAudioVolume(float f16);

    void setDataSource(ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException;

    void setLoopback(boolean z16);

    void setLoopback(boolean z16, long j3, long j16);

    void setPlaySpeedRatio(float f16);

    void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void setSurface(Surface surface);

    void setTVKTPPlayerListener(ITVKTPPlayerListener iTVKTPPlayerListener);

    void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException;

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;

    void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;

    void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException;
}
