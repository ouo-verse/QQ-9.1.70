package com.tencent.qqlive.tvkplayer.richmedia.sync;

import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaOptParam;

/* loaded from: classes23.dex */
public class TVKTPRichMediaSynchronizerStub implements ITPRichMediaSynchronizer {
    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public TPRichMediaFeature[] getFeatures() throws IllegalStateException {
        return new TPRichMediaFeature[0];
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void prepareAsync() throws IllegalStateException {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void release() {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void reset() throws IllegalStateException {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void deselectFeatureAsync(int i3) throws IllegalStateException, IllegalArgumentException {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset) throws IllegalStateException, IllegalArgumentException {
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void selectFeatureAsync(int i3, TPRichMediaOptParam tPRichMediaOptParam) throws IllegalStateException, IllegalArgumentException {
    }
}
