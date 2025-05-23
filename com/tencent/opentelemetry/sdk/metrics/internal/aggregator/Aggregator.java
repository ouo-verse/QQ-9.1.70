package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface Aggregator<T> {
    public static final IPatchRedirector $redirector_ = null;

    T accumulateDoubleMeasurement(double d16, Attributes attributes, Context context);

    T accumulateLongMeasurement(long j3, Attributes attributes, Context context);

    AggregatorHandle<T> createHandle();

    T diff(T t16, T t17);

    T merge(T t16, T t17);

    @Nullable
    MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, T> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17);
}
