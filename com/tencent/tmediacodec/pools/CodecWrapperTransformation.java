package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface CodecWrapperTransformation {
    void clearAndReleaseAll();

    @Nullable
    ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper formatWrapper);

    void removeFromRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper);

    void transToRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper);

    void transTokeep(@NonNull ReuseCodecWrapper reuseCodecWrapper);
}
