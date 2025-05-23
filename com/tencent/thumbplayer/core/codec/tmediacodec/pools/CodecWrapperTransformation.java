package com.tencent.thumbplayer.core.codec.tmediacodec.pools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface CodecWrapperTransformation {
    void clearAndReleaseAll();

    @Nullable
    ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper formatWrapper);

    void removeFromRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper);

    void transToKeep(@NonNull ReuseCodecWrapper reuseCodecWrapper);

    void transToRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper);
}
