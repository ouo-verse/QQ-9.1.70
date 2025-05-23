package ac3;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lac3/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "modTaskLimit", "b", "fileTaskLimit", "l2nTaskLimit", "d", "otherTaskLimit", "<init>", "(IIII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ac3.f, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanDownloadQueueManagerConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int modTaskLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int fileTaskLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int l2nTaskLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int otherTaskLimit;

    public ZPlanDownloadQueueManagerConfig(int i3, int i16, int i17, int i18) {
        this.modTaskLimit = i3;
        this.fileTaskLimit = i16;
        this.l2nTaskLimit = i17;
        this.otherTaskLimit = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getFileTaskLimit() {
        return this.fileTaskLimit;
    }

    /* renamed from: b, reason: from getter */
    public final int getL2nTaskLimit() {
        return this.l2nTaskLimit;
    }

    /* renamed from: c, reason: from getter */
    public final int getModTaskLimit() {
        return this.modTaskLimit;
    }

    /* renamed from: d, reason: from getter */
    public final int getOtherTaskLimit() {
        return this.otherTaskLimit;
    }

    public int hashCode() {
        return (((((this.modTaskLimit * 31) + this.fileTaskLimit) * 31) + this.l2nTaskLimit) * 31) + this.otherTaskLimit;
    }

    public String toString() {
        return "ZPlanDownloadQueueManagerConfig(modTaskLimit=" + this.modTaskLimit + ", fileTaskLimit=" + this.fileTaskLimit + ", l2nTaskLimit=" + this.l2nTaskLimit + ", otherTaskLimit=" + this.otherTaskLimit + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadQueueManagerConfig)) {
            return false;
        }
        ZPlanDownloadQueueManagerConfig zPlanDownloadQueueManagerConfig = (ZPlanDownloadQueueManagerConfig) other;
        return this.modTaskLimit == zPlanDownloadQueueManagerConfig.modTaskLimit && this.fileTaskLimit == zPlanDownloadQueueManagerConfig.fileTaskLimit && this.l2nTaskLimit == zPlanDownloadQueueManagerConfig.l2nTaskLimit && this.otherTaskLimit == zPlanDownloadQueueManagerConfig.otherTaskLimit;
    }
}
