package com.tencent.mobileqq.zplan.minihome.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/minihome/data/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "added", "b", "deleted", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.data.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class RoomInstDiff {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<DecorateIdentifies> added;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<DecorateIdentifies> deleted;

    public RoomInstDiff() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<DecorateIdentifies> a() {
        return this.added;
    }

    public final List<DecorateIdentifies> b() {
        return this.deleted;
    }

    public int hashCode() {
        return (this.added.hashCode() * 31) + this.deleted.hashCode();
    }

    public String toString() {
        return "RoomInstDiff(added=" + this.added + ", deleted=" + this.deleted + ")";
    }

    public RoomInstDiff(List<DecorateIdentifies> added, List<DecorateIdentifies> deleted) {
        Intrinsics.checkNotNullParameter(added, "added");
        Intrinsics.checkNotNullParameter(deleted, "deleted");
        this.added = added;
        this.deleted = deleted;
    }

    public /* synthetic */ RoomInstDiff(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomInstDiff)) {
            return false;
        }
        RoomInstDiff roomInstDiff = (RoomInstDiff) other;
        return Intrinsics.areEqual(this.added, roomInstDiff.added) && Intrinsics.areEqual(this.deleted, roomInstDiff.deleted);
    }
}
