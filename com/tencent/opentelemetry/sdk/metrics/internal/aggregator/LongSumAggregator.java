package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LongSumAggregator extends AbstractSumAggregator<LongAccumulation> {
    static IPatchRedirector $redirector_;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<LongAccumulation> {
        static IPatchRedirector $redirector_;
        private final LongAdder current;

        Handle(ExemplarReservoir exemplarReservoir) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir);
            } else {
                this.current = new LongAdder();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ LongAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<ExemplarData>) list);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public void doRecordLong(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.current.add(j3);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected LongAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            long sumThenReset;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LongAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
            sumThenReset = this.current.sumThenReset();
            return LongAccumulation.create(sumThenReset, list);
        }
    }

    public LongSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir> supplier) {
        super(instrumentDescriptor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor, (Object) supplier);
        } else {
            this.reservoirSupplier = supplier;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<LongAccumulation> createHandle() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            obj = this.reservoirSupplier.get();
            return new Handle((ExemplarReservoir) obj);
        }
        return (AggregatorHandle) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, LongAccumulation> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MetricData) iPatchRedirector.redirect((short) 5, this, resource, instrumentationScopeInfo, metricDescriptor, map, aggregationTemporality, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean isMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j3 = j16;
        }
        return ImmutableMetricData.createLongSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(isMonotonic, aggregationTemporality, MetricDataUtils.toLongPointList(map, j3, j17)));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? LongAccumulation.create(longAccumulation2.getValue() - longAccumulation.getValue(), longAccumulation2.getExemplars()) : (LongAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) longAccumulation, (Object) longAccumulation2);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? LongAccumulation.create(longAccumulation.getValue() + longAccumulation2.getValue(), longAccumulation2.getExemplars()) : (LongAccumulation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) longAccumulation, (Object) longAccumulation2);
    }
}
