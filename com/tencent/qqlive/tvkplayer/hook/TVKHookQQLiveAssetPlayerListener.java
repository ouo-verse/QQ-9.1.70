package com.tencent.qqlive.tvkplayer.hook;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;

/* loaded from: classes23.dex */
public class TVKHookQQLiveAssetPlayerListener implements ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener {
    private final ITVKQQLiveAssetPlayerListenerHookCallback mHookCallback;
    private final ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mRealAssetPlayerListener;

    public TVKHookQQLiveAssetPlayerListener(ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback, ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener) {
        this.mHookCallback = iTVKQQLiveAssetPlayerListenerHookCallback;
        this.mRealAssetPlayerListener = iTVKQQLiveAssetPlayerListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public long getAdvRemainTimeMs() {
        return this.mRealAssetPlayerListener.getAdvRemainTimeMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        this.mRealAssetPlayerListener.onAudioFrameOut(tVKAudioFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCaptureImageFailed(int i3, int i16) {
        this.mRealAssetPlayerListener.onCaptureImageFailed(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
        this.mRealAssetPlayerListener.onCaptureImageSucceed(i3, i16, i17, bitmap);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCompletion() {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onCompletion();
        }
        this.mRealAssetPlayerListener.onCompletion();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onDebugTrackingInfo(tPDebugTrackingInfo);
        }
        this.mRealAssetPlayerListener.onDebugTrackingInfo(tPDebugTrackingInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public boolean onError(TVKError tVKError) {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onError();
        }
        return this.mRealAssetPlayerListener.onError(tVKError);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public TVKUserInfo onGetUserInfo() {
        return this.mRealAssetPlayerListener.onGetUserInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public boolean onInfo(int i3, long j3, long j16, Object obj) {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onInfo(i3, j3, j16, obj);
        }
        return this.mRealAssetPlayerListener.onInfo(i3, j3, j16, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onLoopBackChanged() {
        this.mRealAssetPlayerListener.onLoopBackChanged();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onNetVideoInfo(tVKNetVideoInfo);
        }
        this.mRealAssetPlayerListener.onNetVideoInfo(tVKNetVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16) {
        this.mRealAssetPlayerListener.onOriginalLogoPosition(i3, i16, i17, i18, z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onPermissionTimeout() {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onPermissionTimeout();
        }
        this.mRealAssetPlayerListener.onPermissionTimeout();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onSeekComplete() {
        this.mRealAssetPlayerListener.onSeekComplete();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onStateChange(ITVKPlayerState iTVKPlayerState) {
        this.mRealAssetPlayerListener.onStateChange(iTVKPlayerState);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onSubtitleDataOut(TPSubtitleData tPSubtitleData) {
        this.mRealAssetPlayerListener.onSubtitleDataOut(tPSubtitleData);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoCGIed(TVKNetVideoInfo tVKNetVideoInfo) {
        this.mRealAssetPlayerListener.onVideoCGIed(tVKNetVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        this.mRealAssetPlayerListener.onVideoFrameOut(tVKVideoFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoPrepared() {
        ITVKQQLiveAssetPlayerListenerHookCallback iTVKQQLiveAssetPlayerListenerHookCallback = this.mHookCallback;
        if (iTVKQQLiveAssetPlayerListenerHookCallback != null) {
            iTVKQQLiveAssetPlayerListenerHookCallback.onVideoPrepared();
        }
        this.mRealAssetPlayerListener.onVideoPrepared();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoPreparing() {
        this.mRealAssetPlayerListener.onVideoPreparing();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoSizeChanged(int i3, int i16) {
        this.mRealAssetPlayerListener.onVideoSizeChanged(i3, i16);
    }
}
