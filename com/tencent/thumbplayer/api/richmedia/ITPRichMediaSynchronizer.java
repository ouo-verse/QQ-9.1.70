package com.tencent.thumbplayer.api.richmedia;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;

/* loaded from: classes26.dex */
public interface ITPRichMediaSynchronizer {
    void deselectFeatureAsync(int i3) throws IllegalStateException, IllegalArgumentException;

    @Nullable
    TPRichMediaFeature[] getFeatures();

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset() throws IllegalStateException;

    void selectFeatureAsync(int i3, TPRichMediaOptParam tPRichMediaOptParam) throws IllegalStateException, IllegalArgumentException;

    void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener);

    void setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset) throws IllegalStateException, IllegalArgumentException;
}
