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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR(\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/f;", "", "", "e", "", "size", "b", "", "Ljava/lang/String;", "taskKey", "", "c", "Z", "()Z", "d", "(Z)V", "getFromInit$annotations", "()V", "fromInit", "", "J", "startTime", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f231009a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean fromInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    f() {
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
                logger.d().d("GuildDirectMsgInitReportTask", 2, "endTask but taskKey is empty");
                return;
            }
            return;
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_DIRECT_MSG_LIST_TIME_COST, null, System.currentTimeMillis() - startTime);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("list_count", String.valueOf(size)));
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildDirectMsgInitReportTask", 2, "endTask taskKey=" + taskKey);
        }
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end");
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, mapOf);
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
        taskKey = "";
    }

    public static final boolean c() {
        return fromInit;
    }

    public static final void d(boolean z16) {
        fromInit = z16;
    }

    @JvmStatic
    public static final void e() {
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#time_cost#direct_msg_list");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026_LIST_TIME_COST\n        )");
        taskKey = startOpenTelemetryTask;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(startOpenTelemetryTask, "start");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildDirectMsgInitReportTask", 2, "startTask taskKey = " + taskKey);
        }
        startTime = System.currentTimeMillis();
    }
}
