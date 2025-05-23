package com.tencent.thumbplayer.api.asset;

/* loaded from: classes26.dex */
public interface ITPSimulatedLiveMediaAsset extends ITPMediaAsset {

    /* loaded from: classes26.dex */
    public interface ITPSimulatedLiveAssetRequest {
        void appendMediaAsset(ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException;
    }

    /* loaded from: classes26.dex */
    public interface ITPSimulatedLiveListener {
        void onNextAssetRequired(ITPSimulatedLiveAssetRequest iTPSimulatedLiveAssetRequest);
    }

    void setSimulatedLiveListener(ITPSimulatedLiveListener iTPSimulatedLiveListener);

    void setStartAsset(ITPMediaAsset iTPMediaAsset);
}
