package com.tencent.qqlive.tvkplayer.tpplayer.api;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;

/* loaded from: classes23.dex */
public interface ITVKTPPlayerListener {
    void onAudioFrameOut(TPAudioFrameBuffer tPAudioFrameBuffer);

    void onCompletion();

    void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo);

    void onError(@NonNull TPError tPError);

    long onGetRemainTimeBeforePlayMs();

    void onInfo(int i3, TPOnInfoParam tPOnInfoParam);

    void onMediaAssetExpire(ITPMediaAssetRequest iTPMediaAssetRequest);

    void onNextAssetRequired(ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest iTPSimulatedLiveAssetRequest);

    void onPrepared();

    void onSeekComplete(long j3);

    void onSnapshotFailed(long j3, @NonNull TPError tPError);

    void onSnapshotSuccess(long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer);

    void onSubtitleDataOut(TPSubtitleData tPSubtitleData);

    void onVideoFrameOut(TPVideoFrameBuffer tPVideoFrameBuffer);

    void onVideoSizeChanged(int i3, int i16);
}
