package mc3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lmc3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "traceId", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: mc3.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class InsExeExtParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String traceId;

    public InsExeExtParam() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return this.traceId.hashCode();
    }

    public String toString() {
        return "InsExeExtParam(traceId=" + this.traceId + ")";
    }

    public InsExeExtParam(String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.traceId = traceId;
    }

    public /* synthetic */ InsExeExtParam(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InsExeExtParam) && Intrinsics.areEqual(this.traceId, ((InsExeExtParam) other).traceId);
    }
}
