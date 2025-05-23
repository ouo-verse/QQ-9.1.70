package com.tencent.mobileqq.zplan.report.api.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import sj3.ZPlanReportEndTaskInfo;
import sj3.ZPlanReportStartTaskInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/impl/c;", "Lqj3/b;", "Lsj3/b;", "taskInfo", "Ljava/lang/Runnable;", h.F, "", "name", "featureName", "g", "startTaskInfo", "Lsj3/a;", "endTaskInfo", "", "a", "d", "taskName", AdMetricTag.EVENT_NAME, "", "params", "e", "c", "Lcom/tencent/mobileqq/tianjige/external/a;", "qqExternalSpanData", "b", "Lcom/tencent/mobileqq/tianjige/i;", "Lcom/tencent/mobileqq/tianjige/i;", "tracer", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "timeoutRunnerMap", "reportTaskMap", "", "Z", "enableReport", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements qj3.b {

    /* renamed from: a, reason: collision with root package name */
    public static final c f335062a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final i tracer = ZPlanReportHelperImpl.INSTANCE.b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Runnable> timeoutRunnerMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, ZPlanReportStartTaskInfo> reportTaskMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableReport = ZPlanQQMC.INSTANCE.enableOpenTelemetryReport();

    c() {
    }

    private final Runnable h(final ZPlanReportStartTaskInfo taskInfo) {
        return new Runnable() { // from class: com.tencent.mobileqq.zplan.report.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i(ZPlanReportStartTaskInfo.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanReportStartTaskInfo taskInfo) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(taskInfo, "$taskInfo");
        String taskName = taskInfo.getTaskName();
        String featureName = taskInfo.getFeatureName();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("fail reason", "time out!"), TuplesKt.to("timeout_threshold", String.valueOf(taskInfo.getTimeout())));
        f335062a.c(new ZPlanReportEndTaskInfo(taskName, featureName, 1, mapOf));
    }

    @Override // qj3.b
    public void a(ZPlanReportStartTaskInfo startTaskInfo, ZPlanReportEndTaskInfo endTaskInfo) {
        Intrinsics.checkNotNullParameter(startTaskInfo, "startTaskInfo");
        Intrinsics.checkNotNullParameter(endTaskInfo, "endTaskInfo");
        if (enableReport) {
            QLog.i("ZPLanReportTracer", 1, "startZPlanOpenTelemetrySingleReport, taskName: " + startTaskInfo.getTaskName());
            tracer.l(startTaskInfo.getTaskName(), startTaskInfo.d());
            c(endTaskInfo);
        }
    }

    @Override // qj3.b
    public void b(com.tencent.mobileqq.tianjige.external.a qqExternalSpanData) {
        Intrinsics.checkNotNullParameter(qqExternalSpanData, "qqExternalSpanData");
        tracer.i(qqExternalSpanData);
    }

    @Override // qj3.b
    public void c(ZPlanReportEndTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        if (enableReport) {
            String g16 = g(taskInfo.getTaskName(), taskInfo.getFeatureName());
            Runnable runnable = (Runnable) TypeIntrinsics.asMutableMap(timeoutRunnerMap).remove(g16);
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
            }
            QLog.i("ZPLanReportTracer", 1, "endZPlanOpenTelemetryReport, taskName: " + g16 + ", statusCode: " + taskInfo.getStatusCode());
            tracer.b(g16, taskInfo.getStatusCode(), taskInfo.a());
            HashMap<String, ZPlanReportStartTaskInfo> hashMap = reportTaskMap;
            if (hashMap.containsKey(g16)) {
                TypeIntrinsics.asMutableMap(hashMap).remove(g16);
            }
        }
    }

    @Override // qj3.b
    public void d(ZPlanReportStartTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        if (enableReport) {
            String g16 = g(taskInfo.getTaskName(), taskInfo.getFeatureName());
            String g17 = g(taskInfo.getParentTaskName(), taskInfo.getParentFeatureName());
            HashMap<String, ZPlanReportStartTaskInfo> hashMap = reportTaskMap;
            if (hashMap.containsKey(g16)) {
                ZPlanReportStartTaskInfo zPlanReportStartTaskInfo = hashMap.get(g16);
                QLog.e("ZPLanReportTracer", 1, "task: " + g16 + " has already started, previousParentName: " + (zPlanReportStartTaskInfo != null ? f335062a.g(zPlanReportStartTaskInfo.getParentTaskName(), zPlanReportStartTaskInfo.getParentFeatureName()) : null));
                return;
            }
            Long timeout = taskInfo.getTimeout();
            if (timeout != null) {
                ThreadManagerV2.executeDelay(h(taskInfo), 16, null, true, timeout.longValue());
            }
            QLog.i("ZPLanReportTracer", 1, "startZPlanOpenTelemetryReport, taskName: " + g16 + ", parentTaskName: " + g17);
            tracer.u(g16, taskInfo.d(), g17);
            Intrinsics.checkNotNull(g16);
            hashMap.put(g16, taskInfo);
        }
    }

    @Override // qj3.b
    public void e(String taskName, String featureName, String eventName, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (enableReport) {
            String g16 = g(taskName, featureName);
            QLog.i("ZPLanReportTracer", 1, "startZPlanOpenTelemetryEventReport, taskName: " + g16 + ", eventName: " + eventName);
            tracer.h(g16, eventName, params);
        }
    }

    private final String g(String name, String featureName) {
        if (name == null || name.length() == 0) {
            return null;
        }
        if (featureName == null || featureName.length() == 0) {
            return name;
        }
        return name + "_" + featureName;
    }
}
