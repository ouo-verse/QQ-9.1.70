package com.tencent.thumbplayer.asset;

import android.content.res.AssetFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPAfdMediaAsset;

/* loaded from: classes26.dex */
public class TPAfdMediaAsset extends TPMediaAsset implements ITPAfdMediaAsset {
    private AssetFileDescriptor mAssetFileDescriptor;

    public TPAfdMediaAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mAssetFileDescriptor = assetFileDescriptor;
    }

    public AssetFileDescriptor getAssetFileDescriptor() {
        return this.mAssetFileDescriptor;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 1;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        if (this.mAssetFileDescriptor != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPAfdMediaAsset
    public void setAssetFileDescriptor(@NonNull AssetFileDescriptor assetFileDescriptor) {
        this.mAssetFileDescriptor = assetFileDescriptor;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPAfdMediaAsset(" + super.toString() + "), assetFileDescriptor=" + this.mAssetFileDescriptor;
    }
}
