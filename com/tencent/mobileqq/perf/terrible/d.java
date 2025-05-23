package com.tencent.mobileqq.perf.terrible;

import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.perf.tool.AppInfoUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.metric.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/d;", "", "", "value", "", "type", "", "a", "msg", "", "count", "b", "Lcom/tencent/mobileqq/tianjige/metric/h;", "Lcom/tencent/mobileqq/tianjige/metric/h;", "recorder", "Lcom/tencent/mobileqq/tianjige/metric/d;", "c", "Lcom/tencent/mobileqq/tianjige/metric/d;", GcInfoStatHelper.GcInfo.GC_COUNT_RATE_HISTOGRAM, "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f258073a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final h recorder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.tianjige.metric.d histogram;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f258073a = new d();
        com.tencent.mobileqq.tianjige.a k3 = new a.C8649a().o("qq").n(true).m(1.0d).l(AppSetting.getSubVersion()).k();
        QLog.i("EnvStateReporter", 1, "\u6784\u9020 openTelemetryConfig\uff1a" + k3);
        com.tencent.mobileqq.tianjige.metric.f.d(10, k3);
        h b16 = com.tencent.mobileqq.tianjige.metric.f.b(10);
        Intrinsics.checkNotNullExpressionValue(b16, "getMetricRecorder(QQOpen\u2026.BusinessId.QQ_ENV_STATE)");
        recorder = b16;
        com.tencent.mobileqq.tianjige.metric.d f16 = b16.f("auto_test_perf_indicator", null);
        Intrinsics.checkNotNullExpressionValue(f16, "recorder.createHistogram\u2026EST_PERF_INDICATOR, null)");
        histogram = f16;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(double value, @NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(value), type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap hashMap = new HashMap();
        hashMap.put("indicator_type", type);
        hashMap.put("is_release", String.valueOf(!AppInfoUtil.f258158a.a()));
        hashMap.put("is_gray", String.valueOf(AppSetting.isGrayVersion()));
        hashMap.put("qlog_level", String.valueOf(QLog.getUIN_REPORTLOG_LEVEL()));
        hashMap.put("machine_level", String.valueOf(MemoryUtil.f258173a.g()));
        histogram.b(value, hashMap);
    }

    public final void b(@NotNull String msg2, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2, count);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("realUin", String.valueOf(QQRMonitorSDKManager.uin));
        hashMap.put("content", msg2);
        hashMap.put("count", String.valueOf(count));
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "perf_high_frequency_log_alert", true, 0L, 0L, hashMap, "");
    }
}
