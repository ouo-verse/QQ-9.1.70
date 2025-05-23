package com.tencent.mobileqq.guild.performance.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.util.Logger;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007H\u0007R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/x;", "", "", AdMetricTag.EVENT_NAME, "", "errCode", "errMsg", "", "extraInfo", "", "a", "b", "Ljava/lang/String;", "taskKey", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f231066a = new x();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    x() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull String eventName, int errCode, @NotNull String errMsg, @Nullable Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
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
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, hashMap);
        }
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, eventName, hashMap);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildSearchEventReportTask", 2, "addTaskEvent, eventName: " + eventName + ", code: " + errCode + ", msg: " + errMsg + " ");
        }
    }

    public static /* synthetic */ void b(String str, int i3, String str2, Map map, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        if ((i16 & 8) != 0) {
            map = null;
        }
        a(str, i3, str2, map);
    }
}
