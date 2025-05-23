package com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "ownerCacheCapacity", "b", "totalCacheCapacity", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.b, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class CacheProperties {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int ownerCacheCapacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCacheCapacity;

    /* renamed from: a, reason: from getter */
    public final int getOwnerCacheCapacity() {
        return this.ownerCacheCapacity;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotalCacheCapacity() {
        return this.totalCacheCapacity;
    }

    public int hashCode() {
        return (this.ownerCacheCapacity * 31) + this.totalCacheCapacity;
    }

    public String toString() {
        return "CacheProperties(ownerCacheCapacity=" + this.ownerCacheCapacity + ", totalCacheCapacity=" + this.totalCacheCapacity + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheProperties)) {
            return false;
        }
        CacheProperties cacheProperties = (CacheProperties) other;
        return this.ownerCacheCapacity == cacheProperties.ownerCacheCapacity && this.totalCacheCapacity == cacheProperties.totalCacheCapacity;
    }
}
