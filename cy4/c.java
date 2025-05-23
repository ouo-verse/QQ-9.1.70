package cy4;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcy4/c;", "", "", "a", "J", "c", "()J", "f", "(J)V", "totalCostTime", "b", "e", "netReqCostTime", "d", "downloadCostTime", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long totalCostTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long netReqCostTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long downloadCostTime;

    /* renamed from: a, reason: from getter */
    public final long getDownloadCostTime() {
        return this.downloadCostTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getNetReqCostTime() {
        return this.netReqCostTime;
    }

    /* renamed from: c, reason: from getter */
    public final long getTotalCostTime() {
        return this.totalCostTime;
    }

    public final void d(long j3) {
        this.downloadCostTime = j3;
    }

    public final void e(long j3) {
        this.netReqCostTime = j3;
    }

    public final void f(long j3) {
        this.totalCostTime = j3;
    }
}
