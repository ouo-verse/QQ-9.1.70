package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultCacheKeyGenerator implements CacheKeyGenerator {
    private VideoKeyGenerator mVideoKeyGenerator = new DefaultVideoKeyGenerator();

    @Override // com.tencent.oskplayer.cache.CacheKeyGenerator
    public String generate(String str) {
        return this.mVideoKeyGenerator.generate(str);
    }
}
