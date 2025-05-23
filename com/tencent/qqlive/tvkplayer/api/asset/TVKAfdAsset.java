package com.tencent.qqlive.tvkplayer.api.asset;

import android.content.res.AssetFileDescriptor;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAfdAsset extends TVKAssetBase {
    private final AssetFileDescriptor mAfd;

    public TVKAfdAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mAfd = assetFileDescriptor;
    }

    public AssetFileDescriptor getAfd() {
        return this.mAfd;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 8;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        if (this.mAfd != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "TVKAfdAsset: afd:" + this.mAfd + ", assetType:" + getAssetType();
    }
}
