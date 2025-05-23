package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
class TVKVidAssetVodMediaSourceController extends TVKVodMediaSourceController {
    private final ITVKVodInfoGetter mVodInfoGetter;
    private final ITVKVodInfoGetter.ITVKVodInfoGetterListener mVodInfoGetterListener;

    public TVKVidAssetVodMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable Looper looper, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        super(tVKQQLiveAssetPlayerContext, iTVKMediaSourceListener);
        ITVKVodInfoGetter.ITVKVodInfoGetterListener iTVKVodInfoGetterListener = new ITVKVodInfoGetter.ITVKVodInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKVidAssetVodMediaSourceController.1
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                if (TVKVidAssetVodMediaSourceController.this.isRequestProcessedOrCanceled(i3)) {
                    TVKVidAssetVodMediaSourceController.this.mLogger.info("onFailure, requestId=" + i3 + " getRequestParam=null, request may be cancelled", new Object[0]);
                    return;
                }
                TVKVidAssetVodMediaSourceController.this.removeRequestId(i3);
                if (!TVKVidAssetVodMediaSourceController.this.preprocessOnCGIFailure(i3, tVKError)) {
                    return;
                }
                TVKVidAssetVodMediaSourceController tVKVidAssetVodMediaSourceController = TVKVidAssetVodMediaSourceController.this;
                tVKVidAssetVodMediaSourceController.mMediaSourceListener.onFailure(i3, tVKVidAssetVodMediaSourceController.mRuntimeParam.getTVKAsset(), tVKError);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
                TVKVidAssetVodMediaSourceController.this.onVodVideoInfoRespSuccess(i3, tVKVodVideoInfo);
            }
        };
        this.mVodInfoGetterListener = iTVKVodInfoGetterListener;
        ITVKVodInfoGetter createVodInfoGetter = TVKCGIFactory.createVodInfoGetter(tVKQQLiveAssetPlayerContext, looper);
        this.mVodInfoGetter = createVodInfoGetter;
        createVodInfoGetter.setVodInfoListener(iTVKVodInfoGetterListener);
        createVodInfoGetter.setProxyCacheListener(TVKVodMediaSourceController.sProxyCacheListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    public void cancelRequest(int i3) {
        this.mVodInfoGetter.cancelRequest(i3);
        removeRequestId(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ee  */
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int requestNetVideoInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, @NonNull ITVKFeatureGroup iTVKFeatureGroup, @Nullable ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        int i3;
        int assetType;
        try {
            assetType = tVKCGIRequestParam.getAsset().getAssetType();
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("requestNetVideoInfo, failed to execute request: " + e16, new Object[0]);
        }
        if (!tVKCGIRequestParam.getVideoInfo().isVideoCacheRecord() && assetType != 262144) {
            if (assetType != 131072 && assetType != 524288 && assetType != 1048576) {
                this.mLogger.error("requestNetVideoInfo, unhandled assetType=" + assetType, new Object[0]);
                i3 = -1;
                if (i3 != -1) {
                    addRequestId(i3);
                }
                return i3;
            }
            this.mLogger.info("requestNetVideoInfo requestOnlinePlayInfo", new Object[0]);
            i3 = this.mVodInfoGetter.requestOnlinePlayInfo(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup);
            if (i3 != -1) {
            }
            return i3;
        }
        if (tVKCGIRequestParam.getVideoInfo().isVideoCaptureMode()) {
            this.mLogger.info("requestNetVideoInfo VideoCaptureMode, requestOnlinePlayInfo", new Object[0]);
            if (assetType == 262144) {
                TVKOfflineVodVidAsset tVKOfflineVodVidAsset = (TVKOfflineVodVidAsset) tVKCGIRequestParam.getAsset();
                this.mRuntimeParam.setTVKAsset(TVKAssetFactory.createOnlineVodVidAsset(tVKOfflineVodVidAsset.getVid(), tVKOfflineVodVidAsset.getCid()));
                tVKCGIRequestParam = new TVKCGIRequestParam.Builder(tVKCGIRequestParam.getVideoInfo(), this.mRuntimeParam.getTVKAsset(), tVKCGIRequestParam.getUserInfo()).definition(tVKCGIRequestParam.getDefinition()).streamFormatId(tVKCGIRequestParam.getStreamFormatId()).flowId(tVKCGIRequestParam.getFlowId()).build();
            }
            tVKCGIRequestParam.getVideoInfo().removeConfigMap(TVKPlayerVideoInfo.PLAYER_CFG_KEY_COMPATIBLE_MODE);
            i3 = this.mVodInfoGetter.requestOnlinePlayInfo(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup);
        } else {
            this.mLogger.info("requestNetVideoInfo requestOfflinePlayInfo", new Object[0]);
            i3 = this.mVodInfoGetter.requestOfflinePlayInfo(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup);
        }
        if (i3 != -1) {
        }
        return i3;
    }
}
