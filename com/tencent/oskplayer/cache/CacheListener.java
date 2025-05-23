package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.cache.Cache;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CacheListener implements Cache.Listener {
    private File mCacheFile;
    private int mElapsedMs;
    private String mVideoKey;

    public CacheListener(String str, int i3) {
        this.mVideoKey = str;
        this.mElapsedMs = i3;
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        if (cacheSpan != null) {
            this.mCacheFile = cacheSpan.file;
            cache.removeListener(this.mVideoKey, this);
        }
    }

    public void setFileLastModified(int i3) {
        File file = this.mCacheFile;
        if (file != null) {
            file.setLastModified(i3);
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    @Override // com.tencent.oskplayer.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }
}
