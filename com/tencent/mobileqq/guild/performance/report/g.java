package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/g;", "", "", "channelId", "", "b", "a", "Ljava/lang/String;", "taskKey", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f231013a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    g() {
    }

    @JvmStatic
    public static final void b(@Nullable String channelId) {
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#time_cost#wangzhe_app");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026e.E_SPORT_HALL_TIME_COST)");
        taskKey = startOpenTelemetryTask;
        HashMap hashMap = new HashMap();
        hashMap.put("channel_id", channelId);
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "start");
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, hashMap);
    }

    public final void a() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildESportHallChannelReportTask", 2, "endTask taskKey is empty");
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end");
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
    }
}
