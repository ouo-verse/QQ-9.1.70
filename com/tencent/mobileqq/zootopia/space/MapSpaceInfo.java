package com.tencent.mobileqq.zootopia.space;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/space/k;", "", "", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mapId", "b", "J", "()J", "mainOccupiedSize", "e", "(J)V", "cacheOccupiedSize", "<init>", "(Ljava/lang/String;JJ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.space.k, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class MapSpaceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long mainOccupiedSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long cacheOccupiedSize;

    public MapSpaceInfo(String mapId, long j3, long j16) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        this.mapId = mapId;
        this.mainOccupiedSize = j3;
        this.cacheOccupiedSize = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getCacheOccupiedSize() {
        return this.cacheOccupiedSize;
    }

    /* renamed from: b, reason: from getter */
    public final long getMainOccupiedSize() {
        return this.mainOccupiedSize;
    }

    /* renamed from: c, reason: from getter */
    public final String getMapId() {
        return this.mapId;
    }

    public final long d() {
        return this.mainOccupiedSize + this.cacheOccupiedSize;
    }

    public final void e(long j3) {
        this.cacheOccupiedSize = j3;
    }

    public int hashCode() {
        return (((this.mapId.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.mainOccupiedSize)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.cacheOccupiedSize);
    }

    public String toString() {
        return "MapSpaceInfo(mapId=" + this.mapId + ", mainOccupiedSize=" + this.mainOccupiedSize + ", cacheOccupiedSize=" + this.cacheOccupiedSize + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapSpaceInfo)) {
            return false;
        }
        MapSpaceInfo mapSpaceInfo = (MapSpaceInfo) other;
        return Intrinsics.areEqual(this.mapId, mapSpaceInfo.mapId) && this.mainOccupiedSize == mapSpaceInfo.mainOccupiedSize && this.cacheOccupiedSize == mapSpaceInfo.cacheOccupiedSize;
    }
}
