package com.tencent.thumbplayer.api.asset;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public interface ITPPfdMediaAsset extends ITPMediaAsset {
    void setParcelFileDescriptor(@NonNull ParcelFileDescriptor parcelFileDescriptor);
}
