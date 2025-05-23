package com.tencent.biz.richframework.network.cache;

import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DiskCache extends LruCache {
    private static final String TAG = "DiskCache";

    public DiskCache(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.biz.richframework.network.cache.LruCache
    protected String getCacheTag() {
        RFWLog.d(TAG, RFWLog.DEV, "Get cache tag[Disk]: cache");
        return "protocal_cache";
    }
}
