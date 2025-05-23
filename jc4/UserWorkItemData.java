package jc4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ljc4/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lpv4/s;", "a", "Lpv4/s;", "b", "()Lpv4/s;", "uiData", "Law4/c;", "Law4/c;", "()Law4/c;", "statusData", "<init>", "(Lpv4/s;Law4/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jc4.h, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class UserWorkItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final s uiData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final aw4.c statusData;

    public UserWorkItemData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final aw4.c getStatusData() {
        return this.statusData;
    }

    /* renamed from: b, reason: from getter */
    public final s getUiData() {
        return this.uiData;
    }

    public int hashCode() {
        s sVar = this.uiData;
        int hashCode = (sVar == null ? 0 : sVar.hashCode()) * 31;
        aw4.c cVar = this.statusData;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "UserWorkItemData(uiData=" + this.uiData + ", statusData=" + this.statusData + ")";
    }

    public UserWorkItemData(s sVar, aw4.c cVar) {
        this.uiData = sVar;
        this.statusData = cVar;
    }

    public /* synthetic */ UserWorkItemData(s sVar, aw4.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : sVar, (i3 & 2) != 0 ? null : cVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserWorkItemData)) {
            return false;
        }
        UserWorkItemData userWorkItemData = (UserWorkItemData) other;
        return Intrinsics.areEqual(this.uiData, userWorkItemData.uiData) && Intrinsics.areEqual(this.statusData, userWorkItemData.statusData);
    }
}
