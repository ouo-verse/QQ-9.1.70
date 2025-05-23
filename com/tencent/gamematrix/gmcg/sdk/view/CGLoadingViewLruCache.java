package com.tencent.gamematrix.gmcg.sdk.view;

import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGLoadingViewLruCache {
    private LinkedHashMap<String, CGLoadingViewMapHolder> mCache;
    int mCapacity;

    public CGLoadingViewLruCache(int i3) {
        this.mCache = new LinkedHashMap<>(i3);
        this.mCapacity = i3;
    }

    public CGLoadingViewMapHolder get(String str) {
        if (!this.mCache.containsKey(str)) {
            return null;
        }
        CGLoadingViewMapHolder cGLoadingViewMapHolder = this.mCache.get(str);
        this.mCache.remove(str);
        this.mCache.put(str, cGLoadingViewMapHolder);
        return cGLoadingViewMapHolder;
    }

    public CGLoadingViewMapHolder hasCacheByUrl(String str) {
        for (CGLoadingViewMapHolder cGLoadingViewMapHolder : this.mCache.values()) {
            if (cGLoadingViewMapHolder.hasCached(str)) {
                return cGLoadingViewMapHolder;
            }
        }
        return null;
    }

    public void put(String str, CGLoadingViewMapHolder cGLoadingViewMapHolder) {
        if (this.mCache.containsKey(str)) {
            this.mCache.remove(str);
        }
        if (this.mCapacity == this.mCache.size()) {
            removeAndDeleteFile(this.mCache.keySet().iterator().next());
        }
        this.mCache.put(str, cGLoadingViewMapHolder);
    }

    public void removeAndDeleteFile(String str) {
        if (this.mCache.containsKey(str)) {
            CGLoadingViewMapHolder cGLoadingViewMapHolder = this.mCache.get(str);
            if (cGLoadingViewMapHolder != null) {
                cGLoadingViewMapHolder.removeRefGameId(str);
            }
            this.mCache.remove(str);
        }
    }

    public String toString() {
        return "CGLoadingViewLruCache{mCache=" + this.mCache + ", mCapacity=" + this.mCapacity + '}';
    }
}
