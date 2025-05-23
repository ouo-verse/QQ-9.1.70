package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface MetricData {
    public static final IPatchRedirector $redirector_ = null;

    Data<?> getData();

    String getDescription();

    GaugeData<DoublePointData> getDoubleGaugeData();

    SumData<DoublePointData> getDoubleSumData();

    HistogramData getHistogramData();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    GaugeData<LongPointData> getLongGaugeData();

    SumData<LongPointData> getLongSumData();

    String getName();

    Resource getResource();

    SummaryData getSummaryData();

    MetricDataType getType();

    String getUnit();

    boolean isEmpty();
}
