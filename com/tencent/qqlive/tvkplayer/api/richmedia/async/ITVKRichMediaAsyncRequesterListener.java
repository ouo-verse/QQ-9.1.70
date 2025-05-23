package com.tencent.qqlive.tvkplayer.api.richmedia.async;

import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.response.TVKRichMediaFeatureData;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKRichMediaAsyncRequesterListener {
    void onFeatureDataRequestFailure(ITVKRichMediaAsyncRequester iTVKRichMediaAsyncRequester, int i3, TVKRichMediaFeature tVKRichMediaFeature, int i16);

    void onFeatureDataRequestSuccess(ITVKRichMediaAsyncRequester iTVKRichMediaAsyncRequester, int i3, TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaFeatureData tVKRichMediaFeatureData);

    void onRequesterError(ITVKRichMediaAsyncRequester iTVKRichMediaAsyncRequester, int i3);

    void onRequesterPrepared(ITVKRichMediaAsyncRequester iTVKRichMediaAsyncRequester);
}
