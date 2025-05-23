package com.tencent.rdelivery.report;

import android.content.Context;
import com.tencent.raft.measure.RAFTMeasure;
import com.tencent.raft.measure.config.RAFTComConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/rdelivery/report/a;", "", "Landroid/content/Context;", "context", "", "initSuccess", "", QCircleWeakNetReporter.KEY_COST, "", "a", "Lcom/tencent/raft/measure/config/RAFTComConfig;", "Lcom/tencent/raft/measure/config/RAFTComConfig;", "RAFT_COM_CONFIG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f364372b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final RAFTComConfig RAFT_COM_CONFIG = new RAFTComConfig("Rdelivery-Android", "1.3.36-RC01");

    a() {
    }

    public final void a(@NotNull Context context, boolean initSuccess, long cost) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        RAFTComConfig rAFTComConfig = RAFT_COM_CONFIG;
        RAFTMeasure.enableCrashMonitor(context, rAFTComConfig);
        RAFTMeasure.reportSuccess(context, rAFTComConfig, "init_success", initSuccess);
        RAFTMeasure.reportAvg(context, rAFTComConfig, "init_cost", cost);
    }
}
