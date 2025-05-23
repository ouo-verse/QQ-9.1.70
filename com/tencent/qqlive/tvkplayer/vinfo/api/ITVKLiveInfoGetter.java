package com.tencent.qqlive.tvkplayer.vinfo.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLiveInfoGetter {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKLiveInfoGetterListener {
        void onFailure(int i3, @NonNull TVKError tVKError);

        void onSuccess(int i3, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo);
    }

    void cancelRequest(int i3);

    int inquireLiveInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    int requestDlnaPlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    int requestLivePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException;

    void setLiveInfoListener(ITVKLiveInfoGetterListener iTVKLiveInfoGetterListener);
}
