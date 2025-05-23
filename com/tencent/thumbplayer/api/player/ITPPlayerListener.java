package com.tencent.thumbplayer.api.player;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;

/* loaded from: classes26.dex */
public interface ITPPlayerListener {

    /* loaded from: classes26.dex */
    public interface IOnAudioFrameOutListener {
        void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface IOnAudioProcessFrameOutListener {
        TPAudioFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface IOnCompletionListener {
        void onCompletion(ITPPlayer iTPPlayer);
    }

    /* loaded from: classes26.dex */
    public interface IOnDebugTrackingInfoListener {
        void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo);
    }

    /* loaded from: classes26.dex */
    public interface IOnErrorListener {
        void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError);
    }

    /* loaded from: classes26.dex */
    public interface IOnGetRemainTimeBeforePlayListener {
        long onGetRemainTimeBeforePlayMs(ITPPlayer iTPPlayer);
    }

    /* loaded from: classes26.dex */
    public interface IOnInfoListener {
        void onInfo(ITPPlayer iTPPlayer, int i3, @Nullable TPOnInfoParam tPOnInfoParam);
    }

    /* loaded from: classes26.dex */
    public interface IOnMediaAssetExpireListener {
        void onMediaAssetExpire(ITPPlayer iTPPlayer, ITPMediaAssetRequest iTPMediaAssetRequest);
    }

    /* loaded from: classes26.dex */
    public interface IOnPreparedListener {
        void onPrepared(ITPPlayer iTPPlayer);
    }

    /* loaded from: classes26.dex */
    public interface IOnSeekCompleteListener {
        void onSeekComplete(ITPPlayer iTPPlayer, long j3);
    }

    /* loaded from: classes26.dex */
    public interface IOnSnapshotListener {
        void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError);

        void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface IOnStateChangedListener {
        void onStateChanged(ITPPlayer iTPPlayer, int i3, int i16);
    }

    /* loaded from: classes26.dex */
    public interface IOnStopAsyncCompleteListener {
        void onStopAsyncComplete(ITPPlayer iTPPlayer);
    }

    /* loaded from: classes26.dex */
    public interface IOnSubtitleDataOutListener {
        void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData);
    }

    /* loaded from: classes26.dex */
    public interface IOnVideoFrameOutListener {
        void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    /* loaded from: classes26.dex */
    public interface IOnVideoSizeChangedListener {
        void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16);
    }
}
