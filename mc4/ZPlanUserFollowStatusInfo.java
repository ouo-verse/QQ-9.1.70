package mc4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lmc4/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "I", "()I", "setCurRelation", "(I)V", "curRelation", "c", "Z", "()Z", "setUpdating", "(Z)V", "isUpdating", "<init>", "(Ljava/lang/String;IZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: mc4.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanUserFollowStatusInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int curRelation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isUpdating;

    public ZPlanUserFollowStatusInfo(String uin, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.curRelation = i3;
        this.isUpdating = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurRelation() {
        return this.curRelation;
    }

    /* renamed from: b, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsUpdating() {
        return this.isUpdating;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.uin.hashCode() * 31) + this.curRelation) * 31;
        boolean z16 = this.isUpdating;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZPlanUserFollowStatusInfo(uin=" + this.uin + ", curRelation=" + this.curRelation + ", isUpdating=" + this.isUpdating + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanUserFollowStatusInfo)) {
            return false;
        }
        ZPlanUserFollowStatusInfo zPlanUserFollowStatusInfo = (ZPlanUserFollowStatusInfo) other;
        return Intrinsics.areEqual(this.uin, zPlanUserFollowStatusInfo.uin) && this.curRelation == zPlanUserFollowStatusInfo.curRelation && this.isUpdating == zPlanUserFollowStatusInfo.isUpdating;
    }
}
