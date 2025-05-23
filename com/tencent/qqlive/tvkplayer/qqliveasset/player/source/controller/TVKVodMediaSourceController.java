package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodXmlAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKVodTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoProxyCacheListener;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKVodMediaSourceController extends TVKMediaSourceController {
    protected static final ITVKVodInfoProxyCacheListener sProxyCacheListener = new ITVKVodInfoProxyCacheListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKVodMediaSourceController.1
        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoProxyCacheListener
        public String getOfflineCache(String str, String str2) {
            return TPDataTransportMgr.checkVideoStatus(str, str2);
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoProxyCacheListener
        public long getRecordDurationMs(String str, String str2) {
            return TPDataTransportMgr.getRecordDuration(str, str2);
        }
    };

    public TVKVodMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        super(tVKQQLiveAssetPlayerContext, iTVKMediaSourceListener);
    }

    private boolean preprocessForSimulatedLive(int i3, TVKVodVideoInfo tVKVodVideoInfo) {
        ITVKAsset tVKAsset = this.mRuntimeParam.getTVKAsset();
        if (tVKAsset != null && tVKAsset.getAssetType() == 1048576) {
            if (tVKVodVideoInfo.isPreview() && !TVKMediaPlayerConfig.PlayerConfig.enable_simulated_live_preview) {
                this.mLogger.error("preview is not allowed for simulated live", new Object[0]);
                TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PREVIEW_UNSUPPORTED_ERR);
                tVKError.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, tVKVodVideoInfo);
                this.mMediaSourceListener.onFailure(i3, tVKAsset, tVKError);
                return false;
            }
            int downloadType = tVKVodVideoInfo.getDownloadType();
            if (downloadType != 3 && downloadType != 8) {
                this.mLogger.error("only HLS is supported for simulated live", new Object[0]);
                TVKError tVKError2 = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.FORMAT_UNSUPPORTED_ERR);
                tVKError2.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, tVKVodVideoInfo);
                this.mMediaSourceListener.onFailure(i3, tVKAsset, tVKError2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVodVideoInfoRespSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        ITPMediaAsset iTPMediaAsset;
        if (isRequestProcessedOrCanceled(i3)) {
            this.mLogger.info("onVodVideoInfoRespSuccess, requestId=" + i3 + " getInputReqParam=null, request may be cancelled", new Object[0]);
            return;
        }
        removeRequestId(i3);
        ITVKAsset tVKAsset = this.mRuntimeParam.getTVKAsset();
        if (tVKAsset == null) {
            this.mLogger.info("unfortunately asset is null due to incorrect request id record, and I ain't have time to fix it", new Object[0]);
            return;
        }
        if (tVKAsset.getAssetType() == 65536) {
            TVKOnlineVodXmlAsset tVKOnlineVodXmlAsset = (TVKOnlineVodXmlAsset) tVKAsset;
            String vid = tVKOnlineVodXmlAsset.getVid();
            if (TextUtils.isEmpty(vid)) {
                vid = tVKVodVideoInfo.getVid();
            }
            this.mRuntimeParam.setTVKAsset(TVKAssetFactory.createOnlineVodVidAsset(vid, tVKOnlineVodXmlAsset.getCid()));
        }
        if (!preprocessOnCGISuccess(i3, tVKVodVideoInfo) || !preprocessForSimulatedLive(i3, tVKVodVideoInfo)) {
            return;
        }
        this.mRuntimeParam.setShouldUpdateSimulatedLiveParams(!tVKVodVideoInfo.getSimulatedLiveInfo().getVidList().isEmpty());
        try {
            iTPMediaAsset = TVKVodTPMediaAssetBuilder.newBuilder().playerVideoInfo(this.mInputParam.getPlayerVideoInfo()).inputDefinition(this.mInputParam.getDefinition()).startPositionMs(this.mRuntimeParam.getStartPositionMs()).skipEndPositionMs(this.mRuntimeParam.getSkipEndPositionMs()).flowId(this.mInputParam.getFlowId()).vodVideoInfo(tVKVodVideoInfo).build();
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("error encountered while generating media asset: " + e16, new Object[0]);
            iTPMediaAsset = null;
        }
        if (iTPMediaAsset == null) {
            this.mLogger.error("generateMediaAsset return null, notify error", new Object[0]);
            this.mMediaSourceListener.onFailure(i3, this.mRuntimeParam.getTVKAsset(), new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCommonErrorCodeUtil.CODE.VOD.VINFO_URL_EMPTY_ERR));
            return;
        }
        this.mMediaSourceListener.onSuccess(i3, this.mRuntimeParam.getTVKAsset(), iTPMediaAsset, tVKVodVideoInfo);
    }
}
