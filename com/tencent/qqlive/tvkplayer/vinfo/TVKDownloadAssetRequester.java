package com.tencent.qqlive.tvkplayer.vinfo;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDownloadAssetRequester implements ITVKDownloadAssetRequester {
    private static final ITVKDownloadAssetRequester.ITVKDownloadAssetListener DUMMY_LISTENER = new ITVKDownloadAssetRequester.ITVKDownloadAssetListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.TVKDownloadAssetRequester.1
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester.ITVKDownloadAssetListener
        public void onFailure(int i3, TVKError tVKError) {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester.ITVKDownloadAssetListener
        public void onSuccess(int i3, TVKVodVideoInfo tVKVodVideoInfo) {
        }
    };
    private static final String MODULE_NAME = "TVKDownloadAssetRequester";
    private static volatile TVKPlayerFeatureGroup sFeatureGroup;
    private ITVKDownloadAssetRequester.ITVKDownloadAssetListener mListener = DUMMY_LISTENER;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKContext mTVKContext;
    private final ITVKVodInfoGetter mVodInfoGetter;

    public TVKDownloadAssetRequester(@NonNull TVKContext tVKContext) {
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        ITVKVodInfoGetter createVodInfoGetter = TVKCGIFactory.createVodInfoGetter(tVKContext, Looper.myLooper());
        this.mVodInfoGetter = createVodInfoGetter;
        createVodInfoGetter.setVodInfoListener(new ITVKVodInfoGetter.ITVKVodInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.TVKDownloadAssetRequester.2
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                TVKDownloadAssetRequester.this.mListener.onFailure(i3, tVKError);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
                TVKDownloadAssetRequester.this.mListener.onSuccess(i3, tVKVodVideoInfo);
            }
        });
        initFeatureGroup(tVKContext);
    }

    private void initFeatureGroup(@NonNull TVKContext tVKContext) {
        if (sFeatureGroup == null) {
            synchronized (TVKDownloadAssetRequester.class) {
                if (sFeatureGroup == null) {
                    sFeatureGroup = new TVKPlayerFeatureGroup(new ArrayList(TVKFeatureFactory.createVodFeatureListForOfflineDownload(tVKContext)));
                }
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester
    public int requestDownloadAsset(@NonNull TVKUserInfo tVKUserInfo, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull String str, int i3) throws IllegalArgumentException {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.isAssetValid()) {
            if (tVKPlayerVideoInfo.getAsset().getAssetType() != 131072 && tVKPlayerVideoInfo.getAsset().getAssetType() != 524288) {
                throw new IllegalArgumentException("not onlineVodVidAsset, asset=" + tVKPlayerVideoInfo.getAsset());
            }
            this.mTVKContext.increaseSequence();
            this.mLogger.info("requestDownloadAsset asset:" + tVKPlayerVideoInfo.getAsset(), new Object[0]);
            return this.mVodInfoGetter.requestOfflineDownloadInfo(new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, tVKPlayerVideoInfo.getAsset(), tVKUserInfo).definition(str).streamFormatId(i3).flowId(TVKUtils.generateFlowId()).requestSource(2).build(), sFeatureGroup, null);
        }
        throw new IllegalArgumentException("videoInfo is invalid");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadAssetRequester
    public void setDownloadAssetListener(ITVKDownloadAssetRequester.ITVKDownloadAssetListener iTVKDownloadAssetListener) {
        if (iTVKDownloadAssetListener == null) {
            iTVKDownloadAssetListener = DUMMY_LISTENER;
        }
        this.mListener = iTVKDownloadAssetListener;
    }
}
