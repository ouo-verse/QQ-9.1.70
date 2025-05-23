package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class DoubleLastValueAggregator implements Aggregator<DoubleAccumulation> {
    static IPatchRedirector $redirector_;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<DoubleAccumulation> {
        static IPatchRedirector $redirector_;

        @Nullable
        private static final Double DEFAULT_VALUE;
        private final AtomicReference<Double> current;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23418);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                DEFAULT_VALUE = null;
            }
        }

        /* synthetic */ Handle(ExemplarReservoir exemplarReservoir, AnonymousClass1 anonymousClass1) {
            this(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) exemplarReservoir, (Object) anonymousClass1);
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
                this.current.set(Double.valueOf(d16));
            }
        }

        Handle(ExemplarReservoir exemplarReservoir) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.current = new AtomicReference<>(DEFAULT_VALUE);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected DoubleAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? DoubleAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).doubleValue(), list) : (DoubleAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    public DoubleLastValueAggregator(Supplier<ExemplarReservoir> supplier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) supplier);
        } else {
            this.reservoirSupplier = supplier;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ DoubleAccumulation accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        return a.a(this, d16, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ DoubleAccumulation accumulateLongMeasurement(long j3, Attributes attributes, Context context) {
        return a.b(this, j3, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<DoubleAccumulation> createHandle() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            obj = this.reservoirSupplier.get();
            return new Handle((ExemplarReservoir) obj, null);
        }
        return (AggregatorHandle) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? doubleAccumulation2 : (DoubleAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) doubleAccumulation, (Object) doubleAccumulation2);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? doubleAccumulation2 : (DoubleAccumulation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) doubleAccumulation, (Object) doubleAccumulation2);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MetricData) iPatchRedirector.redirect((short) 5, this, resource, instrumentationScopeInfo, metricDescriptor, map, aggregationTemporality, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j3 = j16;
        }
        return ImmutableMetricData.createDoubleGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toDoublePointList(map, j3, j17)));
    }
}
