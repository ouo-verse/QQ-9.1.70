package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class r {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f231044a = "0";

        /* renamed from: b, reason: collision with root package name */
        public String f231045b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f231046c = "0";

        /* renamed from: d, reason: collision with root package name */
        public String f231047d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f231048e = "0";

        /* renamed from: f, reason: collision with root package name */
        public String f231049f = "0";

        /* renamed from: g, reason: collision with root package name */
        public String f231050g = "0";

        /* renamed from: h, reason: collision with root package name */
        public String f231051h = "0";

        /* renamed from: i, reason: collision with root package name */
        public String f231052i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f231053j = "0";

        /* renamed from: k, reason: collision with root package name */
        public String f231054k = "";

        /* renamed from: l, reason: collision with root package name */
        public String f231055l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f231056m = "0";
    }

    private static void a(HashMap<GuildTelemetryAttributes, String> hashMap, a aVar) {
        hashMap.put(GuildTelemetryAttributes.BIZ_TYPE, b(aVar.f231044a, "0"));
        hashMap.put(GuildTelemetryAttributes.URL, b(aVar.f231045b, ""));
        hashMap.put(GuildTelemetryAttributes.SIZE, b(aVar.f231046c, "0"));
        hashMap.put(GuildTelemetryAttributes.MD5, b(aVar.f231047d, ""));
        hashMap.put(GuildTelemetryAttributes.TOTAL_TIME, b(aVar.f231048e, "0"));
        hashMap.put(GuildTelemetryAttributes.START_TIME, b(aVar.f231049f, "0"));
        hashMap.put(GuildTelemetryAttributes.COST_TIME, b(aVar.f231050g, "0"));
        hashMap.put(GuildTelemetryAttributes.RESULT, b(aVar.f231051h, "0"));
        hashMap.put(GuildTelemetryAttributes.ERROR_MSG, b(aVar.f231052i, ""));
    }

    private static String b(String str, String str2) {
        if (str == null) {
            return str2;
        }
        return str;
    }

    public static void c(GuildTelemetryTask guildTelemetryTask, a aVar) {
        HashMap hashMap = new HashMap();
        a(hashMap, aVar);
        hashMap.put(GuildTelemetryAttributes.DOWNLOAD_RATE, b(aVar.f231053j, "0"));
        hashMap.put(GuildTelemetryAttributes.FILE_SAVE_PATH, b(aVar.f231054k, ""));
        if (QLog.isColorLevel()) {
            QLog.i("Guild.perf.GuildPerReport", 2, "report task:" + guildTelemetryTask.getTaskName() + ",params:" + hashMap.toString());
        }
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).telemetryReport(guildTelemetryTask, hashMap);
        ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).addDownloadTraffic(guildTelemetryTask, hashMap);
    }

    public static void d(GuildTelemetryTask guildTelemetryTask, a aVar) {
        HashMap hashMap = new HashMap();
        a(hashMap, aVar);
        hashMap.put(GuildTelemetryAttributes.FILE_NAME, b(aVar.f231055l, ""));
        hashMap.put(GuildTelemetryAttributes.UPLOAD_RATE, b(aVar.f231056m, ""));
        if (QLog.isColorLevel()) {
            QLog.i("Guild.perf.GuildPerReport", 2, "report task:" + guildTelemetryTask.getTaskName() + ",params:" + hashMap.toString());
        }
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).telemetryReport(guildTelemetryTask, hashMap);
    }
}
