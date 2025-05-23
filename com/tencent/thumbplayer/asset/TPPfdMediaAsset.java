package com.tencent.thumbplayer.asset;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPPfdMediaAsset;

/* loaded from: classes26.dex */
public class TPPfdMediaAsset extends TPMediaAsset implements ITPPfdMediaAsset {
    private ParcelFileDescriptor mParcelFileDescriptor;

    public TPPfdMediaAsset(ParcelFileDescriptor parcelFileDescriptor) {
        this.mParcelFileDescriptor = parcelFileDescriptor;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 2;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mParcelFileDescriptor;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        if (this.mParcelFileDescriptor != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPPfdMediaAsset
    public void setParcelFileDescriptor(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        this.mParcelFileDescriptor = parcelFileDescriptor;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPPfdMediaAsset(" + super.toString() + "), parcelFileDescriptor=" + this.mParcelFileDescriptor;
    }
}
