package com.tencent.libra.cache;

import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.memory.MemoryManager;
import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWDefaultLruCacheImpl implements ICache {
    private final LruCache<LibraRequestKey, EngineResource<?>> mImageCache = new RFWLruCache(Integer.valueOf((int) ((MemoryManager.getAvailClassSize() * 3) / 16)));

    @Override // com.tencent.libra.cache.ICache
    public void addToCache(LibraRequestKey libraRequestKey, EngineResource<?> engineResource, Option option) {
        this.mImageCache.put(libraRequestKey, engineResource);
    }

    @Override // com.tencent.libra.cache.ICache
    public void clearAll() {
        this.mImageCache.evictAll();
    }

    @Override // com.tencent.libra.cache.ICache
    @Nullable
    public BitmapPool getBitmapPool() {
        return null;
    }

    @Override // com.tencent.libra.cache.ICache
    public EngineResource<?> getCache(LibraRequestKey libraRequestKey) {
        return this.mImageCache.get(libraRequestKey);
    }

    @Override // com.tencent.libra.cache.ICache
    public int getCacheSize() {
        return this.mImageCache.maxSize();
    }

    @Override // com.tencent.libra.cache.ICache
    public void removeCache(LibraRequestKey libraRequestKey) {
        this.mImageCache.remove(libraRequestKey);
    }
}
