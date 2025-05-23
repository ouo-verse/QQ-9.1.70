package com.tencent.thumbplayer.api.richmedia;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.common.TPTimeRange;

/* loaded from: classes26.dex */
public interface ITPRichMediaAsyncRequester {
    void cancelRequest(int i3);

    @Nullable
    TPRichMediaFeature[] getFeatures() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    int requestDataAsyncAtPositionMs(int i3, long j3) throws IllegalStateException, IllegalArgumentException;

    int requestDataAsyncAtPositionMsArray(int i3, long[] jArr) throws IllegalStateException, IllegalArgumentException;

    int requestDataAsyncAtTimeRange(int i3, TPTimeRange tPTimeRange) throws IllegalStateException, IllegalArgumentException;

    int requestDataAsyncAtTimeRangeArray(int i3, TPTimeRange[] tPTimeRangeArr) throws IllegalStateException, IllegalArgumentException;

    void setListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener);

    void setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset) throws IllegalStateException, IllegalArgumentException;
}
