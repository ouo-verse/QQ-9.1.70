package com.tencent.qqlive.tvkplayer.vinfo.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVodInfoGetter {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKVodInfoGetterListener {
        void onFailure(int i3, @NonNull TVKError tVKError);

        void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo);
    }

    void cancelRequest(int i3);

    int requestDlnaPlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    int requestOfflineDownloadInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    int requestOfflinePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    int requestOnlinePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    void setProxyCacheListener(ITVKVodInfoProxyCacheListener iTVKVodInfoProxyCacheListener);

    void setVodInfoListener(ITVKVodInfoGetterListener iTVKVodInfoGetterListener);
}
