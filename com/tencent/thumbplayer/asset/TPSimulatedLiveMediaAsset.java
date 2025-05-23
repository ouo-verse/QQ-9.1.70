package com.tencent.thumbplayer.asset;

import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;

/* loaded from: classes26.dex */
public class TPSimulatedLiveMediaAsset extends TPMediaAsset implements ITPSimulatedLiveMediaAsset {
    private ITPMediaAsset mStartAsset = null;
    private ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener mListener = null;

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 8;
    }

    public ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener getSimulatedLiveListener() {
        return this.mListener;
    }

    public ITPMediaAsset getStartAsset() {
        return this.mStartAsset;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        ITPMediaAsset iTPMediaAsset = this.mStartAsset;
        if ((iTPMediaAsset instanceof TPUrlMediaAsset) && iTPMediaAsset.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset
    public void setSimulatedLiveListener(ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener iTPSimulatedLiveListener) {
        this.mListener = iTPSimulatedLiveListener;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset
    public void setStartAsset(ITPMediaAsset iTPMediaAsset) {
        this.mStartAsset = iTPMediaAsset;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPSimulatedLiveMediaAsset, mStartAsset:" + this.mStartAsset;
    }
}
