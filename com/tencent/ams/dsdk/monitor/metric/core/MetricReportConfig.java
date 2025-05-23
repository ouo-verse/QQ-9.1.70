package com.tencent.ams.dsdk.monitor.metric.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MetricReportConfig {
    static IPatchRedirector $redirector_ = null;
    public static final MetricReportConfig DEFAULT;
    private static final int DEFAULT_COUNT_THRESHOLD = 10;
    private static final long DEFAULT_INTERVAL_MILLIS_THRESHOLD = 60000;
    private static final int DEFAULT_MAX_COUNT = 10000;
    public static final String METRIC_REPORTER_PRODUCT_URL = "https://sdkreport.e.qq.com/monitor_report";
    public static final String METRIC_REPORTER_TEST_URL = "https://ttc.gdt.qq.com/monitor_report";
    public final int countThreshold;
    public final boolean enableMetricReportFlush;
    public final long intervalMillisThreshold;
    public final int maxCount;
    public final String url;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT = new MetricReportConfig(METRIC_REPORTER_PRODUCT_URL, 10000, 10, 60000L, true);
        }
    }

    public MetricReportConfig(String str, int i3, int i16, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        this.url = str;
        this.maxCount = i3;
        this.countThreshold = i16;
        this.intervalMillisThreshold = j3;
        this.enableMetricReportFlush = z16;
    }
}
