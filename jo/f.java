package jo;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013\"\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Ljo/f;", "", "", "f", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setStepName", "(Ljava/lang/String;)V", "stepName", "b", "d", "setStepDesc", "stepDesc", "", "c", "J", "()J", "i", "(J)V", "start", tl.h.F, "end", "g", QCircleWeakNetReporter.KEY_COST, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String stepName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String stepDesc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long start;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long end;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long cost;

    public f(String stepName, String stepDesc) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Intrinsics.checkNotNullParameter(stepDesc, "stepDesc");
        this.stepName = stepName;
        this.stepDesc = stepDesc;
    }

    /* renamed from: a, reason: from getter */
    public final long getCost() {
        return this.cost;
    }

    /* renamed from: b, reason: from getter */
    public final long getEnd() {
        return this.end;
    }

    /* renamed from: c, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* renamed from: d, reason: from getter */
    public final String getStepDesc() {
        return this.stepDesc;
    }

    /* renamed from: e, reason: from getter */
    public final String getStepName() {
        return this.stepName;
    }

    public final void g(long j3) {
        this.cost = j3;
    }

    public final void h(long j3) {
        this.end = j3;
    }

    public final void i(long j3) {
        this.start = j3;
    }

    public final void f() {
        this.start = 0L;
        this.end = 0L;
        this.cost = 0L;
    }
}
