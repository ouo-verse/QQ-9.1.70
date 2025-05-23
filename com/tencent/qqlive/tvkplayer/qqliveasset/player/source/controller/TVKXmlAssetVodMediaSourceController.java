package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodXmlAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKXmlAssetVodMediaSourceController extends TVKVodMediaSourceController {
    private final ITVKDataParseGetter mDataParseGetter;
    private final ITVKDataParseGetter.ITVKVodDataParseGetterListener mVodDataParseGetterListener;

    public TVKXmlAssetVodMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable Looper looper, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        super(tVKQQLiveAssetPlayerContext, iTVKMediaSourceListener);
        ITVKDataParseGetter.ITVKVodDataParseGetterListener iTVKVodDataParseGetterListener = new ITVKDataParseGetter.ITVKVodDataParseGetterListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKXmlAssetVodMediaSourceController.1
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter.ITVKVodDataParseGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                if (TVKXmlAssetVodMediaSourceController.this.isRequestProcessedOrCanceled(i3)) {
                    TVKXmlAssetVodMediaSourceController.this.mLogger.info("DataParser, onFailure, requestId=" + i3 + " getRequestParam=null, request may be cancelled", new Object[0]);
                    return;
                }
                TVKXmlAssetVodMediaSourceController.this.removeRequestId(i3);
                if (!TVKXmlAssetVodMediaSourceController.this.preprocessOnCGIFailure(i3, tVKError)) {
                    return;
                }
                TVKXmlAssetVodMediaSourceController tVKXmlAssetVodMediaSourceController = TVKXmlAssetVodMediaSourceController.this;
                tVKXmlAssetVodMediaSourceController.mMediaSourceListener.onFailure(i3, tVKXmlAssetVodMediaSourceController.mRuntimeParam.getTVKAsset(), tVKError);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter.ITVKVodDataParseGetterListener
            public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
                TVKXmlAssetVodMediaSourceController.this.onVodVideoInfoRespSuccess(i3, tVKVodVideoInfo);
            }
        };
        this.mVodDataParseGetterListener = iTVKVodDataParseGetterListener;
        ITVKDataParseGetter createVodXmlParseGetter = TVKCGIFactory.createVodXmlParseGetter(tVKQQLiveAssetPlayerContext, looper);
        this.mDataParseGetter = createVodXmlParseGetter;
        createVodXmlParseGetter.setListener(iTVKVodDataParseGetterListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    public void cancelRequest(int i3) {
        this.mDataParseGetter.cancelRequest(i3);
        removeRequestId(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController
    public int requestNetVideoInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, @NonNull ITVKFeatureGroup iTVKFeatureGroup, @Nullable ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        ITVKAsset asset = tVKCGIRequestParam.getAsset();
        if (asset != null && asset.getAssetType() == 65536) {
            int parse = this.mDataParseGetter.parse(((TVKOnlineVodXmlAsset) asset).getXml(), iTVKFeatureGroup);
            addRequestId(parse);
            return parse;
        }
        return -1;
    }
}
