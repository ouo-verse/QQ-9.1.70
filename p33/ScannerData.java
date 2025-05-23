package p33;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lp33/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSingle", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "sweepColor", "hasCoverAnim", "<init>", "(ZLjava/lang/String;Z)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: p33.b, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class ScannerData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSingle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sweepColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasCoverAnim;

    public ScannerData(boolean z16, @NotNull String sweepColor, boolean z17) {
        Intrinsics.checkNotNullParameter(sweepColor, "sweepColor");
        this.isSingle = z16;
        this.sweepColor = sweepColor;
        this.hasCoverAnim = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasCoverAnim() {
        return this.hasCoverAnim;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSweepColor() {
        return this.sweepColor;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSingle() {
        return this.isSingle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannerData)) {
            return false;
        }
        ScannerData scannerData = (ScannerData) other;
        if (this.isSingle == scannerData.isSingle && Intrinsics.areEqual(this.sweepColor, scannerData.sweepColor) && this.hasCoverAnim == scannerData.hasCoverAnim) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSingle;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((r06 * 31) + this.sweepColor.hashCode()) * 31;
        boolean z17 = this.hasCoverAnim;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ScannerData(isSingle=" + this.isSingle + ", sweepColor=" + this.sweepColor + ", hasCoverAnim=" + this.hasCoverAnim + ")";
    }
}
