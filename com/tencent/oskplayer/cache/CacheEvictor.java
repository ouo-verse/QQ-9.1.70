package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.cache.Cache;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface CacheEvictor extends Cache.Listener {
    void evictOne(Cache cache);

    void onStartFile(Cache cache, String str, long j3, long j16);
}
