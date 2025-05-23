package com.tencent.mobileqq.zootopia.space;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/space/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "totalSize", "", "Lcom/tencent/mobileqq/zootopia/space/k;", "b", "Ljava/util/List;", "getMapSpaceInfoList", "()Ljava/util/List;", "mapSpaceInfoList", "<init>", "(JLjava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.space.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class AllMapSpaceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long totalSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<MapSpaceInfo> mapSpaceInfoList;

    public AllMapSpaceInfo(long j3, List<MapSpaceInfo> mapSpaceInfoList) {
        Intrinsics.checkNotNullParameter(mapSpaceInfoList, "mapSpaceInfoList");
        this.totalSize = j3;
        this.mapSpaceInfoList = mapSpaceInfoList;
    }

    /* renamed from: a, reason: from getter */
    public final long getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        return (com.tencent.mobileqq.vas.banner.c.a(this.totalSize) * 31) + this.mapSpaceInfoList.hashCode();
    }

    public String toString() {
        return "AllMapSpaceInfo(totalSize=" + this.totalSize + ", mapSpaceInfoList=" + this.mapSpaceInfoList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllMapSpaceInfo)) {
            return false;
        }
        AllMapSpaceInfo allMapSpaceInfo = (AllMapSpaceInfo) other;
        return this.totalSize == allMapSpaceInfo.totalSize && Intrinsics.areEqual(this.mapSpaceInfoList, allMapSpaceInfo.mapSpaceInfoList);
    }
}
