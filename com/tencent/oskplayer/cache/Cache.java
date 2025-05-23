package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.FileType;
import java.io.File;
import java.util.NavigableSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Cache {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface Listener {
        void onSpanAdded(Cache cache, CacheSpan cacheSpan);

        void onSpanRemoved(Cache cache, CacheSpan cacheSpan);

        void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);
    }

    NavigableSet<CacheSpan> addListener(String str, Listener listener);

    void commitFile(File file);

    void evictOneSpan();

    long getCacheSpace();

    long getCachedBytesFromEnd(String str);

    long getCachedBytesFromStart(String str);

    double getCachedSizeRate(String str);

    NavigableSet<CacheSpan> getCachedSpans(String str);

    FileType getContentType(String str);

    Set<String> getKeys();

    long getRemainUnCachedBytes(String str);

    long getTotalLength(String str);

    boolean isCached(String str);

    boolean isCached(String str, long j3, long j16);

    void releaseHoleSpan(CacheSpan cacheSpan);

    void removeAll();

    void removeByKey(String str);

    void removeListener(String str, Listener listener);

    void removeSpan(CacheSpan cacheSpan);

    File startFile(String str, long j3, long j16, FileType fileType, long j17);

    CacheSpan startReadWrite(String str, long j3) throws InterruptedException;

    CacheSpan startReadWriteNonBlocking(String str, long j3);
}
