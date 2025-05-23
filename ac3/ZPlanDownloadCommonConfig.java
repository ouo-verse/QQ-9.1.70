package ac3;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lac3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "enableCrcCheck", "enableBizMd5Check", "<init>", "(ZZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ac3.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanDownloadCommonConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableCrcCheck;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableBizMd5Check;

    public ZPlanDownloadCommonConfig(boolean z16, boolean z17) {
        this.enableCrcCheck = z16;
        this.enableBizMd5Check = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableBizMd5Check() {
        return this.enableBizMd5Check;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableCrcCheck() {
        return this.enableCrcCheck;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enableCrcCheck;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.enableBizMd5Check;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ZPlanDownloadCommonConfig(enableCrcCheck=" + this.enableCrcCheck + ", enableBizMd5Check=" + this.enableBizMd5Check + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadCommonConfig)) {
            return false;
        }
        ZPlanDownloadCommonConfig zPlanDownloadCommonConfig = (ZPlanDownloadCommonConfig) other;
        return this.enableCrcCheck == zPlanDownloadCommonConfig.enableCrcCheck && this.enableBizMd5Check == zPlanDownloadCommonConfig.enableBizMd5Check;
    }
}
