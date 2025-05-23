package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class MetricDataType {
    private static final /* synthetic */ MetricDataType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MetricDataType DOUBLE_GAUGE;
    public static final MetricDataType DOUBLE_SUM;
    public static final MetricDataType EXPONENTIAL_HISTOGRAM;
    public static final MetricDataType HISTOGRAM;
    public static final MetricDataType LONG_GAUGE;
    public static final MetricDataType LONG_SUM;
    public static final MetricDataType SUMMARY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MetricDataType metricDataType = new MetricDataType("LONG_GAUGE", 0);
        LONG_GAUGE = metricDataType;
        MetricDataType metricDataType2 = new MetricDataType("DOUBLE_GAUGE", 1);
        DOUBLE_GAUGE = metricDataType2;
        MetricDataType metricDataType3 = new MetricDataType("LONG_SUM", 2);
        LONG_SUM = metricDataType3;
        MetricDataType metricDataType4 = new MetricDataType("DOUBLE_SUM", 3);
        DOUBLE_SUM = metricDataType4;
        MetricDataType metricDataType5 = new MetricDataType("SUMMARY", 4);
        SUMMARY = metricDataType5;
        MetricDataType metricDataType6 = new MetricDataType("HISTOGRAM", 5);
        HISTOGRAM = metricDataType6;
        MetricDataType metricDataType7 = new MetricDataType("EXPONENTIAL_HISTOGRAM", 6);
        EXPONENTIAL_HISTOGRAM = metricDataType7;
        $VALUES = new MetricDataType[]{metricDataType, metricDataType2, metricDataType3, metricDataType4, metricDataType5, metricDataType6, metricDataType7};
    }

    MetricDataType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MetricDataType valueOf(String str) {
        return (MetricDataType) Enum.valueOf(MetricDataType.class, str);
    }

    public static MetricDataType[] values() {
        return (MetricDataType[]) $VALUES.clone();
    }
}
