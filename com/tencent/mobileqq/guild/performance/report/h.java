package com.tencent.mobileqq.guild.performance.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J>\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0007J\u001c\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/h;", "", "", "guildId", "pageFlag", "", "e", AdMetricTag.EVENT_NAME, "", "errCode", "errMsg", "", "extraInfo", "b", "d", "Ljava/lang/String;", "taskKey", "c", "getPageFlag", "()Ljava/lang/String;", "setPageFlag", "(Ljava/lang/String;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f231015a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pageFlag = "";

    h() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull String eventName, int errCode, @NotNull String errMsg, @Nullable Map<String, String> extraInfo) {
        boolean isBlank;
        boolean z16;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildJoinTask", 2, "addTaskEvent but taskKey is empty. return");
                return;
            }
            return;
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        HashMap hashMap = new HashMap();
        hashMap.put("ret", String.valueOf(errCode));
        hashMap.put("msg", errMsg);
        if (extraInfo != null) {
            hashMap.putAll(extraInfo);
        }
        if (errCode != 0) {
            hashMap.put("stage", eventName);
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, hashMap);
        }
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, eventName, hashMap);
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end", hashMap);
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("page_flag", pageFlag);
        hashMap2.put("ret", String.valueOf(errCode));
        hashMap2.put("stage", eventName);
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi2 = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        GuildCounterNames guildCounterNames = GuildCounterNames.GUILD_JOIN_SUCC_RATE;
        if (errCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        iQQOpenTelemetryReportApi2.reportMetricCount(guildCounterNames, z16, hashMap2);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildJoinTask", 2, "addTaskEvent, eventName: " + eventName + ", code: " + errCode + ", msg: " + errMsg + " extraInfo: " + extraInfo);
        }
    }

    public static /* synthetic */ void c(String str, int i3, String str2, Map map, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        if ((i16 & 8) != 0) {
            map = null;
        }
        b(str, i3, str2, map);
    }

    @JvmStatic
    public static final void d(int errCode, @NotNull String errMsg) {
        boolean isBlank;
        boolean z16;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildJoinTask", 2, "endTask but taskKey is empty. return");
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildJoinTask", 2, "endTask code: " + errCode + ", msg: " + errMsg);
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        HashMap hashMap = new HashMap();
        hashMap.put("ret", String.valueOf(errCode));
        hashMap.put("msg", errMsg);
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "end", hashMap);
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(taskKey);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("page_flag", pageFlag);
        hashMap2.put("ret", String.valueOf(errCode));
        hashMap2.put("stage", "end");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi2 = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        GuildCounterNames guildCounterNames = GuildCounterNames.GUILD_JOIN_SUCC_RATE;
        if (errCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        iQQOpenTelemetryReportApi2.reportMetricCount(guildCounterNames, z16, hashMap2);
        taskKey = "";
    }

    @JvmStatic
    public static final void e(@NotNull String guildId, @NotNull String pageFlag2) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageFlag2, "pageFlag");
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#event#join_guild");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026ants.TaskName.GUILD_JOIN)");
        taskKey = startOpenTelemetryTask;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(startOpenTelemetryTask, "start");
        HashMap hashMap = new HashMap();
        hashMap.put("stage", "");
        hashMap.put("guild_id", guildId);
        hashMap.put("page_flag", pageFlag2);
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, hashMap);
        pageFlag = pageFlag2;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildJoinTask", 2, "startTask, taskKey=" + taskKey + " guildId=" + guildId + " pageFlag=" + pageFlag2);
        }
    }
}
