package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableSummaryData;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static GaugeData a(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GaugeData) iPatchRedirector.redirect((short) 2, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.DOUBLE_GAUGE) {
            return (GaugeData) metricData.getData();
        }
        return ImmutableGaugeData.empty();
    }

    public static SumData b(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SumData) iPatchRedirector.redirect((short) 4, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.DOUBLE_SUM) {
            return (ImmutableSumData) metricData.getData();
        }
        return ImmutableSumData.empty();
    }

    public static HistogramData c(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HistogramData) iPatchRedirector.redirect((short) 7, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.HISTOGRAM) {
            return (HistogramData) metricData.getData();
        }
        return ImmutableHistogramData.empty();
    }

    public static GaugeData d(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GaugeData) iPatchRedirector.redirect((short) 3, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.LONG_GAUGE) {
            return (GaugeData) metricData.getData();
        }
        return ImmutableGaugeData.empty();
    }

    public static SumData e(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SumData) iPatchRedirector.redirect((short) 5, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.LONG_SUM) {
            return (SumData) metricData.getData();
        }
        return ImmutableSumData.empty();
    }

    public static SummaryData f(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SummaryData) iPatchRedirector.redirect((short) 6, (Object) metricData);
        }
        if (metricData.getType() == MetricDataType.SUMMARY) {
            return (SummaryData) metricData.getData();
        }
        return ImmutableSummaryData.empty();
    }

    public static boolean g(MetricData metricData) {
        IPatchRedirector iPatchRedirector = MetricData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) metricData)).booleanValue();
        }
        return metricData.getData().getPoints().isEmpty();
    }
}
