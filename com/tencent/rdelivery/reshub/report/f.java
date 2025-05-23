package com.tencent.rdelivery.reshub.report;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.reshub.core.k;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J$\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/f;", "", "Lcom/tencent/rdelivery/reshub/core/k;", Const.BUNDLE_KEY_REQUEST, "Ljava/util/Properties;", "params", "", "b", "Lcom/tencent/rdelivery/RDelivery;", "rd", "Lkotlin/Function0;", "", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "a", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "reportedMap", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final f f364572b = new f();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Integer> reportedMap = new ConcurrentHashMap<>();

    f() {
    }

    private final void a(RDelivery rd5, Properties params, Function0<Unit> reportAction) {
        int b16 = lz3.a.f415844d.b();
        boolean z16 = true;
        if (b16 >= 2 && Random.INSTANCE.nextInt(b16) != 0) {
            z16 = false;
        }
        if (z16) {
            params.put("sampling", Integer.valueOf(b16));
            jz3.d.e("ReportReducer", "Hit Sample Report(Rate=" + b16 + "): " + params);
            reportAction.invoke();
            return;
        }
        jz3.d.e("ReportReducer", "Sample Not Hit(Rate=" + b16 + "), Ignore Report. " + params);
    }

    private final boolean b(k request, Properties params) {
        Long l3;
        String x16 = request.x();
        jz3.e resConfig = request.getResConfig();
        if (resConfig != null) {
            l3 = Long.valueOf(resConfig.f411261b);
        } else {
            l3 = null;
        }
        if (reportedMap.putIfAbsent(x16 + '-' + l3 + '-' + params.get("rs_result") + '-' + params.get("rs_err_code"), 1) != null) {
            return true;
        }
        return false;
    }

    public final void c(@NotNull k request, @NotNull Properties params, @NotNull Function0<Unit> reportAction) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(reportAction, "reportAction");
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        if (jVar.m() && b(request, params)) {
            jz3.d.a("ReportReducer", "Has Reported InProcess, Ignore Report. " + params);
            return;
        }
        if (!jVar.n()) {
            jz3.d.a("ReportReducer", "Do Report: " + params);
            reportAction.invoke();
            return;
        }
        a(request.getRDelivery(), params, reportAction);
    }
}
