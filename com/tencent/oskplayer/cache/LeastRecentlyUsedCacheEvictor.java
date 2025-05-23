package com.tencent.oskplayer.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LeastRecentlyUsedCacheEvictor implements CacheEvictor, Comparator<CacheSpan> {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>(this);
    private volatile long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j3) {
        this.maxBytes = j3;
    }

    private void evictCache(Cache cache, long j3) {
        while (this.currentSize + j3 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            cache.removeSpan(this.leastRecentlyUsed.first());
        }
    }

    @Override // com.tencent.oskplayer.cache.CacheEvictor
    public void evictOne(Cache cache) {
        TreeSet<CacheSpan> treeSet = this.leastRecentlyUsed;
        if (treeSet != null && !treeSet.isEmpty()) {
            cache.removeSpan(this.leastRecentlyUsed.first());
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0L);
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override // com.tencent.oskplayer.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j3, long j16) {
        evictCache(cache, j16);
    }

    public void setMaxBytes(long j3) {
        this.maxBytes = j3;
    }

    @Override // java.util.Comparator
    public int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j3 = cacheSpan.lastAccessTimestamp;
        long j16 = cacheSpan2.lastAccessTimestamp;
        if (j3 - j16 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j3 < j16 ? -1 : 1;
    }
}
