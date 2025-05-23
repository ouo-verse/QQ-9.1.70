package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/d;", "", "", "c", "", "size", "b", "", "Ljava/lang/String;", "taskKey", "", "J", "startTime", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f230988a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    d() {
    }

    @JvmStatic
    public static final void b(int size) {
        boolean z16;
        Map<String, String> mapOf;
        if (taskKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildAssistantReportTask", 2, "endTask but taskKey is empty");
                return;
            }
            return;
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_ASSISTANT_COST, null, System.currentTimeMillis() - startTime);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("list_count", String.valueOf(size)));
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end");
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, mapOf);
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
        taskKey = "";
    }

    @JvmStatic
    public static final void c() {
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#time_cost#guild_helper_page");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026ame.GUILD_ASSISTANT_COST)");
        taskKey = startOpenTelemetryTask;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(startOpenTelemetryTask, "start");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildAssistantReportTask", 2, "startTask, taskKey= " + taskKey);
        }
        startTime = System.currentTimeMillis();
    }
}
