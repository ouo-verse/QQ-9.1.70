package com.tencent.richframework.tracer;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceStep;", "", "", "reset", "", "start", "J", "getStart", "()J", "setStart", "(J)V", "end", "getEnd", "setEnd", QCircleWeakNetReporter.KEY_COST, "getCost", "setCost", "", "stepName", "Ljava/lang/String;", "getStepName", "()Ljava/lang/String;", "setStepName", "(Ljava/lang/String;)V", "stepDesc", "getStepDesc", "setStepDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTraceStep {
    private long cost;
    private long end;
    private long start;

    @NotNull
    private String stepDesc;

    @NotNull
    private String stepName;

    public RFWTraceStep(@NotNull String stepName, @NotNull String stepDesc) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Intrinsics.checkNotNullParameter(stepDesc, "stepDesc");
        this.stepName = stepName;
        this.stepDesc = stepDesc;
    }

    public final long getCost() {
        return this.cost;
    }

    public final long getEnd() {
        return this.end;
    }

    public final long getStart() {
        return this.start;
    }

    @NotNull
    public final String getStepDesc() {
        return this.stepDesc;
    }

    @NotNull
    public final String getStepName() {
        return this.stepName;
    }

    public final void reset() {
        this.start = 0L;
        this.end = 0L;
        this.cost = 0L;
    }

    public final void setCost(long j3) {
        this.cost = j3;
    }

    public final void setEnd(long j3) {
        this.end = j3;
    }

    public final void setStart(long j3) {
        this.start = j3;
    }
}
