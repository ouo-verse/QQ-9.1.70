package ac3;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lac3/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "enableMultiThread", "I", "d", "()I", "multiThreadFileSize", "c", "enhanceThreadNum", "enableDualDownload", "<init>", "(ZIIZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ac3.e, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanDownloadMultiThreadConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableMultiThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int multiThreadFileSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int enhanceThreadNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableDualDownload;

    public ZPlanDownloadMultiThreadConfig(boolean z16, int i3, int i16, boolean z17) {
        this.enableMultiThread = z16;
        this.multiThreadFileSize = i3;
        this.enhanceThreadNum = i16;
        this.enableDualDownload = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableDualDownload() {
        return this.enableDualDownload;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableMultiThread() {
        return this.enableMultiThread;
    }

    /* renamed from: c, reason: from getter */
    public final int getEnhanceThreadNum() {
        return this.enhanceThreadNum;
    }

    /* renamed from: d, reason: from getter */
    public final int getMultiThreadFileSize() {
        return this.multiThreadFileSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.enableMultiThread;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((((r06 * 31) + this.multiThreadFileSize) * 31) + this.enhanceThreadNum) * 31;
        boolean z17 = this.enableDualDownload;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ZPlanDownloadMultiThreadConfig(enableMultiThread=" + this.enableMultiThread + ", multiThreadFileSize=" + this.multiThreadFileSize + ", enhanceThreadNum=" + this.enhanceThreadNum + ", enableDualDownload=" + this.enableDualDownload + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadMultiThreadConfig)) {
            return false;
        }
        ZPlanDownloadMultiThreadConfig zPlanDownloadMultiThreadConfig = (ZPlanDownloadMultiThreadConfig) other;
        return this.enableMultiThread == zPlanDownloadMultiThreadConfig.enableMultiThread && this.multiThreadFileSize == zPlanDownloadMultiThreadConfig.multiThreadFileSize && this.enhanceThreadNum == zPlanDownloadMultiThreadConfig.enhanceThreadNum && this.enableDualDownload == zPlanDownloadMultiThreadConfig.enableDualDownload;
    }
}
