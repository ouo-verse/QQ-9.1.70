package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* loaded from: classes26.dex */
public interface ITPPlayDataTransport extends ITPPlayRemuxer {
    public static final String TAG = "data_transport";

    /* loaded from: classes26.dex */
    public static class SwitchTaskInfo {
        private final int mMode;
        private final boolean mNeedSwitchPlayerDataSource;
        private final ITPMediaAsset mProxyMediaAsset;
        private final int mTaskID;

        public SwitchTaskInfo(int i3, ITPMediaAsset iTPMediaAsset, boolean z16, int i16) {
            this.mTaskID = i3;
            this.mProxyMediaAsset = iTPMediaAsset;
            this.mNeedSwitchPlayerDataSource = z16;
            this.mMode = i16;
        }

        public int getMode() {
            return this.mMode;
        }

        public ITPMediaAsset getProxyMediaAsset() {
            return this.mProxyMediaAsset;
        }

        public int getTaskID() {
            return this.mTaskID;
        }

        public boolean isNeedSwitchPlayerDataSource() {
            return this.mNeedSwitchPlayerDataSource;
        }
    }

    void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam);

    long getAvailablePositionMs();

    float getDownloadPercentage();

    @Nullable
    TPError getError();

    @Nullable
    TPError getError(String str);

    boolean isUseDataTransportForCurrentPlayTask();

    void onBufferingEnd();

    void onBufferingStart();

    void onPlayerStateChanged(int i3);

    void onSeek();

    void onSeekComplete();

    void onSwitchDataSourceComplete(int i3);

    void pause();

    void release();

    void reset();

    void resume();

    void setPlayDataTransportListener(ITPPlayDataTransportListener iTPPlayDataTransportListener);

    void setPlaySpeedRatio(float f16);

    @Nullable
    ITPMediaAsset start(@NonNull ITPMediaAsset iTPMediaAsset);

    @Nullable
    ITPMediaAsset startAudioTrack(@NonNull ITPMediaAsset iTPMediaAsset);

    @Nullable
    ITPMediaAsset startSubtitleTrack(@NonNull ITPMediaAsset iTPMediaAsset);

    void stop();

    @Nullable
    SwitchTaskInfo switchDataSource(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3);

    void updateDataSource(@NonNull ITPMediaAsset iTPMediaAsset);
}
