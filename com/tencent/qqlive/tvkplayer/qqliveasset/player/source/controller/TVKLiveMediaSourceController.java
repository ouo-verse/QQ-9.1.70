package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKLiveTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveMediaSourceController extends TVKMediaSourceController {

    @NonNull
    private final ITVKLiveInfoGetter mLiveInfoGetter;
    private final ITVKLiveInfoGetter.ITVKLiveInfoGetterListener mLiveInfoGetterListener;

    public TVKLiveMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable Looper looper, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        super(tVKQQLiveAssetPlayerContext, iTVKMediaSourceListener);
        ITVKLiveInfoGetter.ITVKLiveInfoGetterListener iTVKLiveInfoGetterListener = new ITVKLiveInfoGetter.ITVKLiveInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKLiveMediaSourceController.1
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                if (TVKLiveMediaSourceController.this.isRequestProcessedOrCanceled(i3)) {
                    TVKLiveMediaSourceController.this.mLogger.info("onFailure, requestId=" + i3 + " might be cancelled", new Object[0]);
                    return;
                }
                TVKLiveMediaSourceController.this.removeRequestId(i3);
                if (!TVKLiveMediaSourceController.this.preprocessOnCGIFailure(i3, tVKError)) {
                    return;
                }
                TVKLiveMediaSourceController tVKLiveMediaSourceController = TVKLiveMediaSourceController.this;
                tVKLiveMediaSourceController.mMediaSourceListener.onFailure(i3, tVKLiveMediaSourceController.mRuntimeParam.getTVKAsset(), tVKError);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
            public void onSuccess(int i3, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
                TVKLiveMediaSourceController.this.onLiveVideoInfoRespSuccess(i3, tVKLiveVideoInfo);
            }
        };
        this.mLiveInfoGetterListener = iTVKLiveInfoGetterListener;
        ITVKLiveInfoGetter createLiveInfoGetter = TVKCGIFactory.createLiveInfoGetter(tVKQQLiveAssetPlayerContext, looper);
        this.mLiveInfoGetter = createLiveInfoGetter;
        createLiveInfoGetter.setLiveInfoListener(iTVKLiveInfoGetterListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLiveVideoInfoRespSuccess(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
        ITPMediaAsset iTPMediaAsset;
        if (isRequestProcessedOrCanceled(i3)) {
            this.mLogger.info("onLiveVideoInfoRespSuccess, requestId=" + i3 + " might be cancelled", new Object[0]);
            return;
        }
        removeRequestId(i3);
        if (!preprocessOnCGISuccess(i3, tVKLiveVideoInfo)) {
            return;
        }
        try {
            iTPMediaAsset = TVKLiveTPMediaAssetBuilder.newBuilder().playerVideoInfo(this.mInputParam.getPlayerVideoInfo()).inputDefinition(this.mInputParam.getDefinition()).flowId(this.mInputParam.getFlowId()).liveVideoInfo(tVKLiveVideoInfo).build();
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("error encountered while generating media asset: " + e16, new Object[0]);
            iTPMediaAsset = null;
        }
        if (iTPMediaAsset == null) {
            this.mLogger.error("media asset is null, notify error", new Object[0]);
            this.mMediaSourceListener.onFailure(i3, this.mRuntimeParam.getTVKAsset(), new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETPROGINFO_ERR, TVKCommonErrorCodeUtil.CODE.LIVE.LIVEINFO_URL_EMPTY_ERR));
            return;
        }
        this.mMediaSourceListener.onSuccess(i3, this.mRuntimeParam.getTVKAsset(), iTPMediaAsset, tVKLiveVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    public void cancelRequest(int i3) {
        this.mLiveInfoGetter.cancelRequest(i3);
        removeRequestId(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x004e  */
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int requestNetVideoInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, @NonNull ITVKFeatureGroup iTVKFeatureGroup, @Nullable ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        int i3;
        try {
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("requestNetVideoInfo, failed to execute request: " + e16, new Object[0]);
        }
        if (TVKAssetUtils.isLiveAsset(tVKCGIRequestParam.getAsset())) {
            i3 = this.mLiveInfoGetter.requestLivePlayInfo(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup);
            if (i3 != -1) {
                addRequestId(i3);
            }
            return i3;
        }
        this.mLogger.error("requestNetVideoInfo, unhandled asset=" + tVKCGIRequestParam.getAsset(), new Object[0]);
        i3 = -1;
        if (i3 != -1) {
        }
        return i3;
    }
}
