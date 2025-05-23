package com.tencent.thumbplayer.tpplayer;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPPlayerListeners implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnAudioFrameOutListener, ITPPlayerListener.IOnAudioProcessFrameOutListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnStateChangedListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnDebugTrackingInfoListener, ITPPlayerListener.IOnGetRemainTimeBeforePlayListener, ITPPlayerListener.IOnSnapshotListener, ITPPlayerListener.IOnMediaAssetExpireListener {
    private static final String TAG = "TPPlayerListeners";
    private TPPlayerListenersEmptyImpl mEmptyListeners;
    private ITPPlayerListener.IOnAudioFrameOutListener mOnAudioFrameOutListener;
    private ITPPlayerListener.IOnAudioProcessFrameOutListener mOnAudioProcessFrameOutListener;
    private ITPPlayerListener.IOnCompletionListener mOnCompletionListener;
    private ITPPlayerListener.IOnDebugTrackingInfoListener mOnDebugTrackingInfoListener;
    private ITPPlayerListener.IOnErrorListener mOnErrorListener;
    private ITPPlayerListener.IOnGetRemainTimeBeforePlayListener mOnGetRemainTimeBeforePlayListener;
    private ITPPlayerListener.IOnInfoListener mOnInfoListener;
    private ITPPlayerListener.IOnMediaAssetExpireListener mOnMediaAssetExpireListener;
    private ITPPlayerListener.IOnPreparedListener mOnPreparedListener;
    private ITPPlayerListener.IOnSeekCompleteListener mOnSeekCompleteListener;
    private ITPPlayerListener.IOnSnapshotListener mOnSnapshotListener;
    private ITPPlayerListener.IOnStateChangedListener mOnStateChangedListener;
    private ITPPlayerListener.IOnStopAsyncCompleteListener mOnStopAsyncCompleteListener;
    private ITPPlayerListener.IOnSubtitleDataOutListener mOnSubtitleDataOutListener;
    private ITPPlayerListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
    private ITPPlayerListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private String mTag = TAG;

    public TPPlayerListeners(String str) {
        updateTag(str);
        TPPlayerListenersEmptyImpl tPPlayerListenersEmptyImpl = new TPPlayerListenersEmptyImpl(this.mTag);
        this.mEmptyListeners = tPPlayerListenersEmptyImpl;
        this.mOnPreparedListener = tPPlayerListenersEmptyImpl;
        this.mOnCompletionListener = tPPlayerListenersEmptyImpl;
        this.mOnInfoListener = tPPlayerListenersEmptyImpl;
        this.mOnErrorListener = tPPlayerListenersEmptyImpl;
        this.mOnSeekCompleteListener = tPPlayerListenersEmptyImpl;
        this.mOnVideoSizeChangedListener = tPPlayerListenersEmptyImpl;
        this.mOnVideoFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnAudioFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnAudioProcessFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnSubtitleDataOutListener = tPPlayerListenersEmptyImpl;
        this.mOnStateChangedListener = tPPlayerListenersEmptyImpl;
        this.mOnStopAsyncCompleteListener = tPPlayerListenersEmptyImpl;
        this.mOnDebugTrackingInfoListener = tPPlayerListenersEmptyImpl;
        this.mOnGetRemainTimeBeforePlayListener = tPPlayerListenersEmptyImpl;
        this.mOnSnapshotListener = tPPlayerListenersEmptyImpl;
        this.mOnMediaAssetExpireListener = tPPlayerListenersEmptyImpl;
    }

    public void clear() {
        TPPlayerListenersEmptyImpl tPPlayerListenersEmptyImpl = this.mEmptyListeners;
        this.mOnPreparedListener = tPPlayerListenersEmptyImpl;
        this.mOnCompletionListener = tPPlayerListenersEmptyImpl;
        this.mOnInfoListener = tPPlayerListenersEmptyImpl;
        this.mOnErrorListener = tPPlayerListenersEmptyImpl;
        this.mOnSeekCompleteListener = tPPlayerListenersEmptyImpl;
        this.mOnVideoSizeChangedListener = tPPlayerListenersEmptyImpl;
        this.mOnVideoFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnAudioFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnAudioProcessFrameOutListener = tPPlayerListenersEmptyImpl;
        this.mOnSubtitleDataOutListener = tPPlayerListenersEmptyImpl;
        this.mOnStateChangedListener = tPPlayerListenersEmptyImpl;
        this.mOnStopAsyncCompleteListener = tPPlayerListenersEmptyImpl;
        this.mOnDebugTrackingInfoListener = tPPlayerListenersEmptyImpl;
        this.mOnSnapshotListener = tPPlayerListenersEmptyImpl;
        this.mOnGetRemainTimeBeforePlayListener = tPPlayerListenersEmptyImpl;
        this.mOnMediaAssetExpireListener = tPPlayerListenersEmptyImpl;
    }

    public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        this.mOnAudioFrameOutListener.onAudioFrameOut(iTPPlayer, tPAudioFrameBuffer);
    }

    public TPAudioFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        return this.mOnAudioProcessFrameOutListener.onAudioProcessFrameOut(iTPPlayer, tPAudioFrameBuffer);
    }

    public void onCompletion(ITPPlayer iTPPlayer) {
        ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
        this.mOnCompletionListener.onCompletion(iTPPlayer);
    }

    public void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo) {
        this.mOnDebugTrackingInfoListener.onDebugTrackingInfo(iTPPlayer, tPDebugTrackingInfo);
    }

    public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
        ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
        this.mOnErrorListener.onError(iTPPlayer, tPError);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnGetRemainTimeBeforePlayListener
    public long onGetRemainTimeBeforePlayMs(ITPPlayer iTPPlayer) {
        return this.mOnGetRemainTimeBeforePlayListener.onGetRemainTimeBeforePlayMs(iTPPlayer);
    }

    public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
        ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
        this.mOnInfoListener.onInfo(iTPPlayer, i3, tPOnInfoParam);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnMediaAssetExpireListener
    public void onMediaAssetExpire(ITPPlayer iTPPlayer, ITPMediaAssetRequest iTPMediaAssetRequest) {
        this.mOnMediaAssetExpireListener.onMediaAssetExpire(iTPPlayer, iTPMediaAssetRequest);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
    public void onPrepared(ITPPlayer iTPPlayer) {
        ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
        this.mOnPreparedListener.onPrepared(iTPPlayer);
    }

    public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
        this.mOnSeekCompleteListener.onSeekComplete(iTPPlayer, j3);
    }

    public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
        this.mOnSnapshotListener.onSnapshotFailed(iTPPlayer, j3, tPError);
    }

    public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.mOnSnapshotListener.onSnapshotSuccess(iTPPlayer, j3, j16, tPVideoFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnStateChangedListener
    public void onStateChanged(ITPPlayer iTPPlayer, int i3, int i16) {
        this.mOnStateChangedListener.onStateChanged(iTPPlayer, i3, i16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnStopAsyncCompleteListener
    public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        this.mOnStopAsyncCompleteListener.onStopAsyncComplete(iTPPlayer);
    }

    public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        this.mOnSubtitleDataOutListener.onSubtitleDataOut(iTPPlayer, tPSubtitleData);
    }

    public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.mOnVideoFrameOutListener.onVideoFrameOut(iTPPlayer, tPVideoFrameBuffer);
    }

    public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
        this.mOnVideoSizeChangedListener.onVideoSizeChanged(iTPPlayer, i3, i16);
    }

    public void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener) {
        if (iOnAudioFrameOutListener == null) {
            iOnAudioFrameOutListener = this.mEmptyListeners;
        }
        this.mOnAudioFrameOutListener = iOnAudioFrameOutListener;
    }

    public void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener) {
        if (iOnAudioProcessFrameOutListener == null) {
            iOnAudioProcessFrameOutListener = this.mEmptyListeners;
        }
        this.mOnAudioProcessFrameOutListener = iOnAudioProcessFrameOutListener;
    }

    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        if (iOnCompletionListener == null) {
            iOnCompletionListener = this.mEmptyListeners;
        }
        this.mOnCompletionListener = iOnCompletionListener;
    }

    public void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener) {
        if (iOnDebugTrackingInfoListener == null) {
            iOnDebugTrackingInfoListener = this.mEmptyListeners;
        }
        this.mOnDebugTrackingInfoListener = iOnDebugTrackingInfoListener;
    }

    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        if (iOnErrorListener == null) {
            iOnErrorListener = this.mEmptyListeners;
        }
        this.mOnErrorListener = iOnErrorListener;
    }

    public void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        if (iOnGetRemainTimeBeforePlayListener == null) {
            iOnGetRemainTimeBeforePlayListener = this.mEmptyListeners;
        }
        this.mOnGetRemainTimeBeforePlayListener = iOnGetRemainTimeBeforePlayListener;
    }

    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        if (iOnInfoListener == null) {
            iOnInfoListener = this.mEmptyListeners;
        }
        this.mOnInfoListener = iOnInfoListener;
    }

    public void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        if (iOnMediaAssetExpireListener == null) {
            iOnMediaAssetExpireListener = this.mEmptyListeners;
        }
        this.mOnMediaAssetExpireListener = iOnMediaAssetExpireListener;
    }

    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        if (iOnPreparedListener == null) {
            iOnPreparedListener = this.mEmptyListeners;
        }
        this.mOnPreparedListener = iOnPreparedListener;
    }

    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        if (iOnSeekCompleteListener == null) {
            iOnSeekCompleteListener = this.mEmptyListeners;
        }
        this.mOnSeekCompleteListener = iOnSeekCompleteListener;
    }

    public void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener) {
        if (iOnSnapshotListener == null) {
            iOnSnapshotListener = this.mEmptyListeners;
        }
        this.mOnSnapshotListener = iOnSnapshotListener;
    }

    public void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        if (iOnStateChangedListener == null) {
            iOnStateChangedListener = this.mEmptyListeners;
        }
        this.mOnStateChangedListener = iOnStateChangedListener;
    }

    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        if (iOnStopAsyncCompleteListener == null) {
            iOnStopAsyncCompleteListener = this.mEmptyListeners;
        }
        this.mOnStopAsyncCompleteListener = iOnStopAsyncCompleteListener;
    }

    public void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener) {
        if (iOnSubtitleDataOutListener == null) {
            iOnSubtitleDataOutListener = this.mEmptyListeners;
        }
        this.mOnSubtitleDataOutListener = iOnSubtitleDataOutListener;
    }

    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        if (iOnVideoFrameOutListener == null) {
            iOnVideoFrameOutListener = this.mEmptyListeners;
        }
        this.mOnVideoFrameOutListener = iOnVideoFrameOutListener;
    }

    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        if (iOnVideoSizeChangedListener == null) {
            iOnVideoSizeChangedListener = this.mEmptyListeners;
        }
        this.mOnVideoSizeChangedListener = iOnVideoSizeChangedListener;
    }

    public void updateTag(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTag = TAG;
        } else {
            this.mTag = str;
        }
        TPPlayerListenersEmptyImpl tPPlayerListenersEmptyImpl = this.mEmptyListeners;
        if (tPPlayerListenersEmptyImpl != null) {
            tPPlayerListenersEmptyImpl.mTag = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class TPPlayerListenersEmptyImpl implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnAudioFrameOutListener, ITPPlayerListener.IOnAudioProcessFrameOutListener, ITPPlayerListener.IOnStateChangedListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnDebugTrackingInfoListener, ITPPlayerListener.IOnGetRemainTimeBeforePlayListener, ITPPlayerListener.IOnSnapshotListener, ITPPlayerListener.IOnMediaAssetExpireListener {
        private String mTag;

        public TPPlayerListenersEmptyImpl(String str) {
            this.mTag = str;
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioProcessFrameOutListener
        public TPAudioFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            return null;
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            TPLogUtil.i(this.mTag, " empty player listener , notify onCompletion");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            TPLogUtil.i(this.mTag, " empty player listener , notify onError, error type:" + tPError.getErrorType() + ", error code:" + tPError.getErrorCode());
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnGetRemainTimeBeforePlayListener
        public long onGetRemainTimeBeforePlayMs(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.mTag, " empty player listener , notify getRemainTimeBeforePlayMs");
            return 0L;
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnMediaAssetExpireListener
        public void onMediaAssetExpire(ITPPlayer iTPPlayer, ITPMediaAssetRequest iTPMediaAssetRequest) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onMediaAssetExpire");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            TPLogUtil.i(this.mTag, " empty player listener , notify onPrepared");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onSeekComplete");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onSnapshotFailed");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onSnapshotSuccess");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnStateChangedListener
        public void onStateChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onStateChange");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnStopAsyncCompleteListener
        public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onStopAsyncComplete");
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            TPLogUtil.i(this.mTag, " empty player listener , notify onVideoSizeChanged, width:" + i3 + ", height:" + i16);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioFrameOutListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnDebugTrackingInfoListener
        public void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo) {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, @Nullable TPOnInfoParam tPOnInfoParam) {
        }
    }
}
