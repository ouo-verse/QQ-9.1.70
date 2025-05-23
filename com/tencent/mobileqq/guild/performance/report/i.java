package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002R\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/i;", "", "", "c", "a", "", "taskName", "taskKey", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/IQQOpenTelemetryReportApi;", DTConstants.TAG.API, "d", "Ljava/util/HashMap;", "param", "b", "Ljava/lang/String;", "guildListLoadTaskKey", "guildListFirstInitTaskKey", "", "J", "guildListStartTime", "e", "channelListLoadTaskKey", "f", "changeGuildTaskKey", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long guildListStartTime;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f231018a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String guildListLoadTaskKey = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String guildListFirstInitTaskKey = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String channelListLoadTaskKey = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String changeGuildTaskKey = "";

    i() {
    }

    @JvmStatic
    public static final void a() {
        f231018a.b("gpro_quality#time_cost#left_bar_init", guildListFirstInitTaskKey, new HashMap<>());
        guildListFirstInitTaskKey = "";
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_CHANGE_TIME_COST, null, System.currentTimeMillis() - guildListStartTime);
    }

    private final void b(String taskName, String taskKey, HashMap<String, String> param) {
        boolean z16;
        if (taskKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildListLoadReportTask", 2, "endTask but taskKey is empty taskName=" + taskName);
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end");
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, param);
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildListLoadReportTask", 2, "endTask, taskName=" + taskName);
        }
    }

    @JvmStatic
    public static final void c() {
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#time_cost#left_bar_init");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026me.GUILD_LIST_FIRST_INIT)");
        guildListFirstInitTaskKey = startOpenTelemetryTask;
        f231018a.d("gpro_quality#time_cost#left_bar_init", startOpenTelemetryTask, iQQOpenTelemetryReportApi);
        guildListStartTime = System.currentTimeMillis();
    }

    private final void d(String taskName, String taskKey, IQQOpenTelemetryReportApi api) {
        api.reportOpenTelemetryTask(taskKey, "start");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildListLoadReportTask", 2, "startTask, taskKey= " + taskKey + ", taskName=" + taskName);
        }
    }
}
