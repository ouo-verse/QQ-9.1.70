package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHookMediaSourceListener implements ITVKMediaSourceListener {

    @Nullable
    private final ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mAssetPlayerListener;

    @NonNull
    private final ITVKMediaSourceListener mListener;

    public TVKHookMediaSourceListener(@NonNull ITVKMediaSourceListener iTVKMediaSourceListener, @Nullable ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener) {
        this.mListener = iTVKMediaSourceListener;
        this.mAssetPlayerListener = iTVKQQLiveAssetPlayerListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
    public void onFailure(int i3, ITVKAsset iTVKAsset, @NonNull TVKError tVKError) {
        if (this.mAssetPlayerListener != null) {
            TVKEventParams.GetVInfoResponseParam getVInfoResponseParam = new TVKEventParams.GetVInfoResponseParam();
            getVInfoResponseParam.asset = iTVKAsset;
            getVInfoResponseParam.errorInfo = tVKError;
            getVInfoResponseParam.videoInfo = (TVKNetVideoInfo) tVKError.getExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO);
            this.mAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE, 0L, 0L, getVInfoResponseParam);
        }
        this.mListener.onFailure(i3, iTVKAsset, tVKError);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
    public void onSuccess(int i3, ITVKAsset iTVKAsset, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener = this.mAssetPlayerListener;
        if (iTVKQQLiveAssetPlayerListener != null) {
            iTVKQQLiveAssetPlayerListener.onNetVideoInfo(tVKNetVideoInfo);
            TVKEventParams.GetVInfoResponseParam getVInfoResponseParam = new TVKEventParams.GetVInfoResponseParam();
            getVInfoResponseParam.asset = iTVKAsset;
            getVInfoResponseParam.videoInfo = tVKNetVideoInfo;
            this.mAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE, 0L, 0L, getVInfoResponseParam);
            if (iTPMediaAsset instanceof ITPSimulatedLiveMediaAsset) {
                this.mAssetPlayerListener.onInfo(549, 0L, 0L, tVKNetVideoInfo);
            }
        }
        this.mListener.onSuccess(i3, iTVKAsset, iTPMediaAsset, tVKNetVideoInfo);
    }
}
