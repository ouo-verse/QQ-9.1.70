package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class s {
    public static <T> SynchronousMetricStorage a(RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = SynchronousMetricStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SynchronousMetricStorage) iPatchRedirector.redirect((short) 2, (Object) registeredView, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        View view = registeredView.getView();
        MetricDescriptor create = MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor);
        Aggregator<T> createAggregator = ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, exemplarFilter);
        if (com.tencent.opentelemetry.sdk.metrics.internal.aggregator.a.c() == createAggregator) {
            return b();
        }
        return new DefaultSynchronousMetricStorage(create, createAggregator, registeredView.getViewAttributesProcessor());
    }

    public static SynchronousMetricStorage b() {
        IPatchRedirector iPatchRedirector = SynchronousMetricStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SynchronousMetricStorage) iPatchRedirector.redirect((short) 1);
        }
        return EmptyMetricStorage.INSTANCE;
    }
}
