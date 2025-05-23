package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.Data;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.GaugeData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramData;
import com.tencent.opentelemetry.sdk.metrics.data.LongPointData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricDataType;
import com.tencent.opentelemetry.sdk.metrics.data.SumData;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryData;
import com.tencent.opentelemetry.sdk.metrics.data.a;
import com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableMetricData implements MetricData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMetricData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static ImmutableMetricData create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, MetricDataType metricDataType, Data<?> data) {
        return new AutoValue_ImmutableMetricData(resource, instrumentationScopeInfo, str, str2, str3, metricDataType, data);
    }

    public static MetricData createDoubleGauge(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, GaugeData<DoublePointData> gaugeData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.DOUBLE_GAUGE, gaugeData);
    }

    public static MetricData createDoubleHistogram(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, HistogramData histogramData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.HISTOGRAM, histogramData);
    }

    public static MetricData createDoubleSum(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SumData<DoublePointData> sumData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.DOUBLE_SUM, sumData);
    }

    public static MetricData createDoubleSummary(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SummaryData summaryData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.SUMMARY, summaryData);
    }

    public static MetricData createExponentialHistogram(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, ExponentialHistogramData exponentialHistogramData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.EXPONENTIAL_HISTOGRAM, exponentialHistogramData);
    }

    public static MetricData createLongGauge(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, GaugeData<LongPointData> gaugeData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.LONG_GAUGE, gaugeData);
    }

    public static MetricData createLongSum(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SumData<LongPointData> sumData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.LONG_SUM, sumData);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getDoubleGaugeData() {
        return a.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getDoubleSumData() {
        return a.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ HistogramData getHistogramData() {
        return a.c(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getLongGaugeData() {
        return a.d(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getLongSumData() {
        return a.e(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SummaryData getSummaryData() {
        return a.f(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ boolean isEmpty() {
        return a.g(this);
    }
}
