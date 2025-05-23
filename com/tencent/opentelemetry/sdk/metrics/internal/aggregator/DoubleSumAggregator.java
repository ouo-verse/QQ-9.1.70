package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DoubleSumAggregator extends AbstractSumAggregator<DoubleAccumulation> {
    static IPatchRedirector $redirector_;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<DoubleAccumulation> {
        static IPatchRedirector $redirector_;
        private final DoubleAdder current;

        Handle(ExemplarReservoir exemplarReservoir) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir);
            } else {
                this.current = AdderUtil.createDoubleAdder();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ DoubleAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<ExemplarData>) list);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordDouble(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
            } else {
                this.current.add(d16);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected DoubleAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? DoubleAccumulation.create(this.current.sumThenReset(), list) : (DoubleAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    public DoubleSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir> supplier) {
        super(instrumentDescriptor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor, (Object) supplier);
        } else {
            this.reservoirSupplier = supplier;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<DoubleAccumulation> createHandle() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            obj = this.reservoirSupplier.get();
            return new Handle((ExemplarReservoir) obj);
        }
        return (AggregatorHandle) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MetricData) iPatchRedirector.redirect((short) 6, this, resource, instrumentationScopeInfo, metricDescriptor, map, aggregationTemporality, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean isMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j3 = j16;
        }
        return ImmutableMetricData.createDoubleSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(isMonotonic, aggregationTemporality, MetricDataUtils.toDoublePointList(map, j3, j17)));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AbstractSumAggregator, com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? DoubleAccumulation.create(d16) : (DoubleAccumulation) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? DoubleAccumulation.create(doubleAccumulation2.getValue() - doubleAccumulation.getValue(), doubleAccumulation2.getExemplars()) : (DoubleAccumulation) iPatchRedirector.redirect((short) 5, (Object) this, (Object) doubleAccumulation, (Object) doubleAccumulation2);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? DoubleAccumulation.create(doubleAccumulation.getValue() + doubleAccumulation2.getValue(), doubleAccumulation2.getExemplars()) : (DoubleAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) doubleAccumulation, (Object) doubleAccumulation2);
    }
}
