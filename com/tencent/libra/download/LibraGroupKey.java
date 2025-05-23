package com.tencent.libra.download;

import com.tencent.libra.cache.Key;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraGroupKey implements Key {
    private CacheStrategy mCacheStrategy = CacheStrategy.EXPLICIT;
    private String mGroupId;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum CacheStrategy {
        ONLY_SAVE,
        HIGHEST,
        EXPLICIT
    }

    public LibraGroupKey(String str) {
        this.mGroupId = str;
    }

    @Override // com.tencent.libra.cache.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.mGroupId, ((LibraGroupKey) obj).mGroupId);
        }
        return false;
    }

    public CacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    @Override // com.tencent.libra.cache.Key
    public int hashCode() {
        return Objects.hash(this.mGroupId);
    }

    public void setCacheStrategy(CacheStrategy cacheStrategy) {
        this.mCacheStrategy = cacheStrategy;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public String toString() {
        return "LibraGroupKey{mGroupId='" + this.mGroupId + "', mCacheStrategy=" + this.mCacheStrategy + '}';
    }
}
