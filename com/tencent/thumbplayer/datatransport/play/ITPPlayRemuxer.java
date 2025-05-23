package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;

/* loaded from: classes26.dex */
public interface ITPPlayRemuxer {
    @Nullable
    ITPMediaAsset startRemuxing(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPMediaAsset iTPMediaAsset2);

    void stopRemuxing();
}
