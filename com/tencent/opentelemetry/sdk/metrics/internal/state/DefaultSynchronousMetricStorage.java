package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DefaultSynchronousMetricStorage<T> implements SynchronousMetricStorage {
    static IPatchRedirector $redirector_;
    private final AttributesProcessor attributesProcessor;
    private final DeltaMetricStorage<T> deltaMetricStorage;
    private final BoundStorageHandle lateBoundStorageHandle;
    private final MetricDescriptor metricDescriptor;
    private final TemporalMetricStorage<T> temporalMetricStorage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSynchronousMetricStorage(MetricDescriptor metricDescriptor, Aggregator<T> aggregator, AttributesProcessor attributesProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, metricDescriptor, aggregator, attributesProcessor);
            return;
        }
        this.lateBoundStorageHandle = new BoundStorageHandle() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.DefaultSynchronousMetricStorage.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultSynchronousMetricStorage.this);
                }
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
            public void recordDouble(double d16, Attributes attributes, Context context) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Double.valueOf(d16), attributes, context);
                } else {
                    DefaultSynchronousMetricStorage.this.recordDouble(d16, attributes, context);
                }
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
            public void recordLong(long j3, Attributes attributes, Context context) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Long.valueOf(j3), attributes, context);
                } else {
                    DefaultSynchronousMetricStorage.this.recordLong(j3, attributes, context);
                }
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
            public void release() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.attributesProcessor = attributesProcessor;
        this.metricDescriptor = metricDescriptor;
        this.deltaMetricStorage = new DeltaMetricStorage<>(aggregator, metricDescriptor.getSourceInstrument());
        this.temporalMetricStorage = new TemporalMetricStorage<>(aggregator, true);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BoundStorageHandle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes);
        }
        Objects.requireNonNull(attributes, "attributes");
        if (this.attributesProcessor.usesContext()) {
            return this.lateBoundStorageHandle;
        }
        return this.deltaMetricStorage.bind(this.attributesProcessor.process(attributes, com.tencent.opentelemetry.context.e.k()));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricData collectAndReset(CollectionInfo collectionInfo, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MetricData) iPatchRedirector.redirect((short) 5, this, collectionInfo, resource, instrumentationScopeInfo, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
        }
        return this.temporalMetricStorage.buildMetricFor(collectionInfo.getCollector(), resource, instrumentationScopeInfo, getMetricDescriptor(), collectionInfo.getAggregationTemporality(getMetricDescriptor().getSourceInstrument().getType()), this.deltaMetricStorage.collectFor(collectionInfo.getCollector(), collectionInfo.getAllCollectors(), z16), j3, j16);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricDescriptor getMetricDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MetricDescriptor) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.metricDescriptor;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public /* synthetic */ boolean isEmpty() {
        return j.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public void recordDouble(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16), attributes, context);
            return;
        }
        Objects.requireNonNull(attributes, "attributes");
        Attributes process = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle bind = this.deltaMetricStorage.bind(process);
        try {
            bind.recordDouble(d16, process, context);
        } finally {
            bind.release();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public void recordLong(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes, context);
            return;
        }
        Objects.requireNonNull(attributes, "attributes");
        Attributes process = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle bind = this.deltaMetricStorage.bind(process);
        try {
            bind.recordLong(j3, process, context);
        } finally {
            bind.release();
        }
    }
}
