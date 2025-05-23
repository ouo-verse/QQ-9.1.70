package ck3;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lck3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isDownloading", "", "J", "()J", "lastFinishTime", "<init>", "(ZJ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ck3.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanModHotPatchStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDownloading;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastFinishTime;

    public ZPlanModHotPatchStatus(boolean z16, long j3) {
        this.isDownloading = z16;
        this.lastFinishTime = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getLastFinishTime() {
        return this.lastFinishTime;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDownloading() {
        return this.isDownloading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isDownloading;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + c.a(this.lastFinishTime);
    }

    public String toString() {
        return "ZPlanModHotPatchStatus(isDownloading=" + this.isDownloading + ", lastFinishTime=" + this.lastFinishTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanModHotPatchStatus)) {
            return false;
        }
        ZPlanModHotPatchStatus zPlanModHotPatchStatus = (ZPlanModHotPatchStatus) other;
        return this.isDownloading == zPlanModHotPatchStatus.isDownloading && this.lastFinishTime == zPlanModHotPatchStatus.lastFinishTime;
    }
}
