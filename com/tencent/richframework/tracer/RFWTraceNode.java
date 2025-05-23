package com.tencent.richframework.tracer;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceNode;", "", "", "reset", "", "nodeTime", "J", "getNodeTime", "()J", "setNodeTime", "(J)V", QCircleWeakNetReporter.KEY_COST, "getCost", "setCost", "", "nodeName", "Ljava/lang/String;", "getNodeName", "()Ljava/lang/String;", "setNodeName", "(Ljava/lang/String;)V", "nodeDesc", "getNodeDesc", "setNodeDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTraceNode {
    private long cost;

    @NotNull
    private String nodeDesc;

    @NotNull
    private String nodeName;
    private long nodeTime;

    public RFWTraceNode(@NotNull String nodeName, @NotNull String nodeDesc) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(nodeDesc, "nodeDesc");
        this.nodeName = nodeName;
        this.nodeDesc = nodeDesc;
    }

    public final long getCost() {
        return this.cost;
    }

    @NotNull
    public final String getNodeDesc() {
        return this.nodeDesc;
    }

    @NotNull
    public final String getNodeName() {
        return this.nodeName;
    }

    public final long getNodeTime() {
        return this.nodeTime;
    }

    public final void reset() {
        this.nodeTime = 0L;
        this.cost = 0L;
    }

    public final void setCost(long j3) {
        this.cost = j3;
    }

    public final void setNodeTime(long j3) {
        this.nodeTime = j3;
    }
}
