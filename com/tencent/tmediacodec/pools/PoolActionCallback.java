package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;

/* loaded from: classes26.dex */
public interface PoolActionCallback {
    void onErase(@NonNull ReuseCodecWrapper reuseCodecWrapper);
}
