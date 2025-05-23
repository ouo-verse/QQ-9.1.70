package com.tencent.qqlive.tvkplayer.qqliveasset.common;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;

/* loaded from: classes23.dex */
public class TVKQQLiveAssetPlayerListenerEmpty implements ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener {
    private static final String TAG = "TVKPlayer[TVKQQLiveAssetPlayerListenerEmpty.jave]";

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public long getAdvRemainTimeMs() {
        TVKLogUtil.i(TAG, "getAdvRemainTimeMs");
        return 0L;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        TVKLogUtil.i(TAG, "onAudioFrameOut");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCaptureImageFailed(int i3, int i16) {
        TVKLogUtil.i(TAG, "onCaptureImageFailed id:" + i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
        TVKLogUtil.i(TAG, "onCaptureImageSucceed id:" + i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onCompletion() {
        TVKLogUtil.i(TAG, "onCompletion");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        TVKLogUtil.i(TAG, "onDebugTrackingInfo what:" + tPDebugTrackingInfo.getTrackingInfoID());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public boolean onError(TVKError tVKError) {
        TVKLogUtil.i(TAG, "onError " + tVKError.toString());
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public TVKUserInfo onGetUserInfo() {
        TVKLogUtil.i(TAG, "onGetUserInfo");
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public boolean onInfo(int i3, long j3, long j16, Object obj) {
        TVKLogUtil.i(TAG, "onInfo what:" + i3);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onLoopBackChanged() {
        TVKLogUtil.i(TAG, "onLoopBackChanged");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        TVKLogUtil.i(TAG, "onNetVideoInfo");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16) {
        TVKLogUtil.i(TAG, "onOriginalLogoPosition");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onPermissionTimeout() {
        TVKLogUtil.i(TAG, "onPermissionTimeout");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onSeekComplete() {
        TVKLogUtil.i(TAG, "onSeekComplete");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onStateChange(ITVKPlayerState iTVKPlayerState) {
        TVKLogUtil.i(TAG, "onStateChange  state:" + iTVKPlayerState.toString());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onSubtitleDataOut(TPSubtitleData tPSubtitleData) {
        TVKLogUtil.i(TAG, "onSubtitleDataOut");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoCGIed(TVKNetVideoInfo tVKNetVideoInfo) {
        TVKLogUtil.i(TAG, "onVideoCGIed");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        TVKLogUtil.i(TAG, "onVideoFrameOut");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoPrepared() {
        TVKLogUtil.i(TAG, "onVideoPrepared");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoPreparing() {
        TVKLogUtil.i(TAG, "onVideoPreparing");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
    public void onVideoSizeChanged(int i3, int i16) {
        TVKLogUtil.i(TAG, "onVideoSizeChanged width:" + i3 + ", height:" + i16);
    }
}
