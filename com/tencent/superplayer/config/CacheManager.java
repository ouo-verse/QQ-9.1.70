package com.tencent.superplayer.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class CacheManager {
    private Map<String, CacheContent> mCache = new HashMap();

    public synchronized CacheContent get(String str) {
        CacheContent cacheContent;
        cacheContent = this.mCache.get(str);
        if (cacheContent == null) {
            cacheContent = new CacheContent(str);
            if (cacheContent.isValidate()) {
                this.mCache.put(str, cacheContent);
            }
        }
        return cacheContent;
    }

    public void save(CacheContent cacheContent, String str) {
        cacheContent.save(str);
    }
}
