package com.tencent.qqlive.tvkplayer.api.asset;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKAssetBase implements ITVKAsset {
    public boolean isLiveAsset() {
        if ((getAssetType() & 65280) != 0) {
            return true;
        }
        return false;
    }

    public boolean isQQLiveAsset() {
        if (!isVodAsset() && !isLiveAsset()) {
            return false;
        }
        return true;
    }

    public boolean isVodAsset() {
        if ((getAssetType() & ITVKAsset.VOD_ASSET_MASK_BIT) != 0) {
            return true;
        }
        return false;
    }
}
