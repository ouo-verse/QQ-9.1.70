package com.tencent.qqlive.tvkplayer.api.richmedia.async;

import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKRichMediaAsyncRequester {
    void cancelRequest(int i3);

    List<TVKRichMediaFeature> getFeatureList();

    void prepareAsync() throws IllegalStateException;

    void release();

    int requestFeatureDataAsyncAtTimeMs(TVKRichMediaFeature tVKRichMediaFeature, long j3);

    int requestFeatureDataAsyncAtTimeMsArray(TVKRichMediaFeature tVKRichMediaFeature, long[] jArr);

    int requestFeatureDataAsyncAtTimeRange(TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaTimeRange tVKRichMediaTimeRange);

    int requestFeatureDataAsyncAtTimeRanges(TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaTimeRange[] tVKRichMediaTimeRangeArr);

    void setRequesterListener(ITVKRichMediaAsyncRequesterListener iTVKRichMediaAsyncRequesterListener);

    void setRichMediaSource(String str) throws IllegalStateException, IllegalArgumentException;
}
