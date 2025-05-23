package m94;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lm94/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lm94/g;", "Lm94/g;", "()Lm94/g;", "data", "<init>", "(ILm94/g;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m94.f, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class DressHistoryChangeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int operation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final g data;

    public DressHistoryChangeInfo(int i3, g data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.operation = i3;
        this.data = data;
    }

    /* renamed from: a, reason: from getter */
    public final g getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getOperation() {
        return this.operation;
    }

    public int hashCode() {
        return (this.operation * 31) + this.data.hashCode();
    }

    public String toString() {
        return "DressHistoryChangeInfo(operation=" + this.operation + ", data=" + this.data + ")";
    }

    public /* synthetic */ DressHistoryChangeInfo(int i3, g gVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 2 : i3, gVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressHistoryChangeInfo)) {
            return false;
        }
        DressHistoryChangeInfo dressHistoryChangeInfo = (DressHistoryChangeInfo) other;
        return this.operation == dressHistoryChangeInfo.operation && Intrinsics.areEqual(this.data, dressHistoryChangeInfo.data);
    }
}
