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

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LongLastValueAggregator implements Aggregator<LongAccumulation> {
    static IPatchRedirector $redirector_;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<LongAccumulation> {
        static IPatchRedirector $redirector_;

        @Nullable
        private static final Long DEFAULT_VALUE;
        private final AtomicReference<Long> current;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23021);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                DEFAULT_VALUE = null;
            }
        }

        Handle(ExemplarReservoir exemplarReservoir) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir);
            } else {
                this.current = new AtomicReference<>(DEFAULT_VALUE);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ LongAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<ExemplarData>) list);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordLong(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.current.set(Long.valueOf(j3));
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected LongAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? LongAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).longValue(), list) : (LongAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
    }

    public LongLastValueAggregator(Supplier<ExemplarReservoir> supplier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) supplier);
        } else {
            this.reservoirSupplier = supplier;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ LongAccumulation accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        return a.a(this, d16, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ LongAccumulation accumulateLongMeasurement(long j3, Attributes attributes, Context context) {
        return a.b(this, j3, attributes, context);
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
    public LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? longAccumulation2 : (LongAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) longAccumulation, (Object) longAccumulation2);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? longAccumulation2 : (LongAccumulation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) longAccumulation, (Object) longAccumulation2);
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
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j3 = j16;
        }
        return ImmutableMetricData.createLongGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toLongPointList(map, j3, j17)));
    }
}
