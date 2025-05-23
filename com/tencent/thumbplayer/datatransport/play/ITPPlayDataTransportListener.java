package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;

/* loaded from: classes26.dex */
public interface ITPPlayDataTransportListener {
    void onDownloadFinished();

    void onError(@NonNull TPError tPError);

    long onGetCurrentPlayOffsetByte();

    long onGetCurrentPositionMs();

    long onGetPlayerBufferLengthMs();

    long onGetRemainTimeBeforePlayMs();

    void onInfo(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo);

    void onMediaAssetExpire();

    void onNeedReconnectDueToM3u8DataUpdate();

    void onNeedReconnectDueToMediaDataInvalid();

    void onProgressUpdate(@NonNull TPDownloadProgressInfo tPDownloadProgressInfo);

    void onSuggestedBitrateChanged(int i3);

    void onSwitchDataSourceComplete(long j3);
}
