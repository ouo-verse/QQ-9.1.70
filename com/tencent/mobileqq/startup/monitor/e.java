package com.tencent.mobileqq.startup.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J2\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J*\u0010\u000b\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/startup/monitor/e;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "a", "", "costR", "b", "c", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f289721a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31364);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f289721a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull HashMap<String, String> reportParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reportParams);
            return;
        }
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        HashMap hashMap = new HashMap();
        hashMap.putAll(reportParams);
        QQBeaconReport.report(null, "actColdStart", hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("NtStartupMonitor", 1, "finish reportColdStartup");
        }
    }

    public final void b(long costR, @NotNull HashMap<String, String> reportParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(costR), reportParams);
            return;
        }
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("costR", String.valueOf(costR));
        String str = reportParams.get(VasPerfReportUtils.WHILE_COST_TOTAL);
        if (str != null) {
            hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, str);
        }
        String str2 = reportParams.get("firstSync");
        if (str2 != null) {
            hashMap.put("firstSync", str2);
        }
        String str3 = reportParams.get("actLoginS");
        if (str3 != null) {
            hashMap.put("actLoginS", str3);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLoginR", true, costR, 0L, hashMap, null);
    }

    public final void c(@NotNull HashMap<String, String> reportParams) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) reportParams);
            return;
        }
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        HashMap hashMap = new HashMap();
        if (d.f289708a.g()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("whichTab", str);
        String str2 = reportParams.get("hitSnapshot");
        if (str2 != null) {
            hashMap.put("hitSnapshot", str2);
        }
        String str3 = reportParams.get("actLoginS");
        if (str3 != null) {
            com.tencent.mobileqq.perf.report.opentelemetry.a.d("qqperf_startup", Long.parseLong(str3), "actLoginS", hashMap);
        }
        String str4 = reportParams.get("coldCost");
        if (str4 != null) {
            com.tencent.mobileqq.perf.report.opentelemetry.a.d("qqperf_startup", Long.parseLong(str4), "coldCost", hashMap);
        }
        String str5 = reportParams.get("sysLaunch");
        if (str5 != null) {
            com.tencent.mobileqq.perf.report.opentelemetry.a.d("qqperf_startup", Long.parseLong(str5), "sysLaunch", hashMap);
        }
    }
}
