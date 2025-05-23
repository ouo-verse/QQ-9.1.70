package com.tencent.libra.cache;

import androidx.annotation.Nullable;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ICache {
    void addToCache(LibraRequestKey libraRequestKey, EngineResource<?> engineResource, Option option);

    void clearAll();

    @Nullable
    BitmapPool getBitmapPool();

    EngineResource<?> getCache(LibraRequestKey libraRequestKey);

    int getCacheSize();

    void removeCache(LibraRequestKey libraRequestKey);
}
