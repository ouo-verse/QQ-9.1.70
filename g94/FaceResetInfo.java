package g94;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lg94/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "isSide", "b", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "from", "<init>", "(ZLjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g94.d, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class FaceResetInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSide;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String from;

    public FaceResetInfo(boolean z16, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.isSide = z16;
        this.from = from;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsSide() {
        return this.isSide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isSide;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.from.hashCode();
    }

    public String toString() {
        return "FaceResetInfo(isSide=" + this.isSide + ", from=" + this.from + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceResetInfo)) {
            return false;
        }
        FaceResetInfo faceResetInfo = (FaceResetInfo) other;
        return this.isSide == faceResetInfo.isSide && Intrinsics.areEqual(this.from, faceResetInfo.from);
    }
}
