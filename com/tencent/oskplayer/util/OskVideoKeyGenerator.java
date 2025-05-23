package com.tencent.oskplayer.util;

import com.tencent.oskplayer.cache.CacheKeyGenerator;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskVideoKeyGenerator implements VideoKeyGenerator {
    private CacheKeyGenerator mCacheKeyGenerator;
    private VideoKeyGenerator mDefaultCacheKeyGenerator = new DefaultVideoKeyGenerator();

    public OskVideoKeyGenerator(CacheKeyGenerator cacheKeyGenerator) {
        this.mCacheKeyGenerator = cacheKeyGenerator;
    }

    @Override // com.tencent.oskplayer.proxy.VideoKeyGenerator
    public String generate(String str) {
        CacheKeyGenerator cacheKeyGenerator = this.mCacheKeyGenerator;
        if (cacheKeyGenerator != null) {
            return cacheKeyGenerator.generate(str);
        }
        return this.mDefaultCacheKeyGenerator.generate(str);
    }
}
