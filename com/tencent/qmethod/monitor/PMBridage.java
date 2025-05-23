package com.tencent.qmethod.monitor;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0017\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qmethod/monitor/PMBridage;", "", "()V", "appendTag", "", "tag", "", "fullSample", "", "ts", "", Method.POST, "runnable", "Ljava/lang/Runnable;", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class PMBridage {
    public static final PMBridage INSTANCE = new PMBridage();

    PMBridage() {
    }

    @JvmStatic
    public static void appendTag(@NotNull String tag, boolean fullSample, long ts5) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        a.f343451h.a(tag, fullSample, ts5);
    }

    @JvmStatic
    public static void post(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        PMonitorReporter.INSTANCE.b().post(runnable);
    }
}
