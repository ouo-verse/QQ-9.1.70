package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AsynchronousMetricStorage<T> implements MetricStorage {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AsynchronousMetricStorage";
    private Map<Attributes, T> accumulations;
    private final Aggregator<T> aggregator;
    private final AttributesProcessor attributesProcessor;
    private final MetricDescriptor metricDescriptor;
    private final TemporalMetricStorage<T> metricStorage;

    AsynchronousMetricStorage(MetricDescriptor metricDescriptor, Aggregator<T> aggregator, AttributesProcessor attributesProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, metricDescriptor, aggregator, attributesProcessor);
            return;
        }
        this.accumulations = new HashMap();
        this.metricDescriptor = metricDescriptor;
        this.metricStorage = new TemporalMetricStorage<>(aggregator, false);
        this.aggregator = aggregator;
        this.attributesProcessor = attributesProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> AsynchronousMetricStorage<T> create(RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor) {
        View view = registeredView.getView();
        return new AsynchronousMetricStorage<>(MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor), ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, com.tencent.opentelemetry.sdk.metrics.internal.exemplar.b.b()), registeredView.getViewAttributesProcessor());
    }

    private void recordAccumulation(T t16, Attributes attributes) {
        Attributes process = this.attributesProcessor.process(attributes, com.tencent.opentelemetry.context.e.k());
        if (this.accumulations.size() >= 2000) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Instrument " + this.metricDescriptor.getSourceInstrument().getName() + " has exceeded the maximum allowed accumulations (2000).");
                return;
            }
            return;
        }
        if (this.accumulations.containsKey(attributes)) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Instrument " + this.metricDescriptor.getSourceInstrument().getName() + " has recorded multiple values for the same attributes.");
                return;
            }
            return;
        }
        this.accumulations.put(process, t16);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricData collectAndReset(CollectionInfo collectionInfo, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MetricData) iPatchRedirector.redirect((short) 3, this, collectionInfo, resource, instrumentationScopeInfo, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
        }
        AggregationTemporality aggregationTemporality = collectionInfo.getAggregationTemporality(this.metricDescriptor.getSourceInstrument().getType());
        Map<Attributes, T> map = this.accumulations;
        this.accumulations = new HashMap();
        return this.metricStorage.buildMetricFor(collectionInfo.getCollector(), resource, instrumentationScopeInfo, getMetricDescriptor(), aggregationTemporality, map, j3, j16);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricDescriptor getMetricDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MetricDescriptor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.metricDescriptor;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.aggregator == com.tencent.opentelemetry.sdk.metrics.internal.aggregator.a.c()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordDouble(double d16, Attributes attributes) {
        T accumulateDoubleMeasurement = this.aggregator.accumulateDoubleMeasurement(d16, attributes, com.tencent.opentelemetry.context.e.k());
        if (accumulateDoubleMeasurement != null) {
            recordAccumulation(accumulateDoubleMeasurement, attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordLong(long j3, Attributes attributes) {
        T accumulateLongMeasurement = this.aggregator.accumulateLongMeasurement(j3, attributes, com.tencent.opentelemetry.context.e.k());
        if (accumulateLongMeasurement != null) {
            recordAccumulation(accumulateLongMeasurement, attributes);
        }
    }
}
