package ma0;

import e40.QFSPublishFeedVariantInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lma0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "show", "needAnima", "Le40/d;", "c", "Le40/d;", "()Le40/d;", "variantInfo", "<init>", "(ZZLe40/d;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ma0.d, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class VariantUIData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean show;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needAnima;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QFSPublishFeedVariantInfo variantInfo;

    public VariantUIData(boolean z16, boolean z17, @NotNull QFSPublishFeedVariantInfo variantInfo) {
        Intrinsics.checkNotNullParameter(variantInfo, "variantInfo");
        this.show = z16;
        this.needAnima = z17;
        this.variantInfo = variantInfo;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedAnima() {
        return this.needAnima;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final QFSPublishFeedVariantInfo getVariantInfo() {
        return this.variantInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariantUIData)) {
            return false;
        }
        VariantUIData variantUIData = (VariantUIData) other;
        if (this.show == variantUIData.show && this.needAnima == variantUIData.needAnima && Intrinsics.areEqual(this.variantInfo, variantUIData.variantInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.show;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.needAnima;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i16 + i3) * 31) + this.variantInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "VariantUIData(show=" + this.show + ", needAnima=" + this.needAnima + ", variantInfo=" + this.variantInfo + ")";
    }
}
