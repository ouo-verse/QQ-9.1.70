package com.tencent.qqlive.tvkplayer.api.asset;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class TVKPfdAsset extends TVKAssetBase {
    private final ParcelFileDescriptor mPfd;

    public TVKPfdAsset(ParcelFileDescriptor parcelFileDescriptor) {
        this.mPfd = parcelFileDescriptor;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 4;
    }

    public ParcelFileDescriptor getPfd() {
        return this.mPfd;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        if (this.mPfd != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "TVKPfdAsset: pfd:" + this.mPfd + ", assetType:" + getAssetType();
    }
}
