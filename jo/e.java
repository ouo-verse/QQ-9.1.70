package jo;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Ljo/e;", "", "", "e", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setNodeName", "(Ljava/lang/String;)V", "nodeName", "b", "setNodeDesc", "nodeDesc", "", "J", "d", "()J", "g", "(J)V", "nodeTime", "f", QCircleWeakNetReporter.KEY_COST, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String nodeName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String nodeDesc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long nodeTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long cost;

    public e(String nodeName, String nodeDesc) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(nodeDesc, "nodeDesc");
        this.nodeName = nodeName;
        this.nodeDesc = nodeDesc;
    }

    /* renamed from: a, reason: from getter */
    public final long getCost() {
        return this.cost;
    }

    /* renamed from: b, reason: from getter */
    public final String getNodeDesc() {
        return this.nodeDesc;
    }

    /* renamed from: c, reason: from getter */
    public final String getNodeName() {
        return this.nodeName;
    }

    /* renamed from: d, reason: from getter */
    public final long getNodeTime() {
        return this.nodeTime;
    }

    public final void f(long j3) {
        this.cost = j3;
    }

    public final void g(long j3) {
        this.nodeTime = j3;
    }

    public final void e() {
        this.nodeTime = 0L;
        this.cost = 0L;
    }
}
