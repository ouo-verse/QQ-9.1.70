package com.tencent.thumbplayer.core.codec.tmediacodec.pools;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;

/* loaded from: classes26.dex */
public interface PoolActionCallback {
    void onErase(@NonNull ReuseCodecWrapper reuseCodecWrapper);
}
