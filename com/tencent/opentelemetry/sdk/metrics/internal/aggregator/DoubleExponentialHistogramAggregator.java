package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
final class DoubleExponentialHistogramAggregator implements Aggregator<ExponentialHistogramAccumulation> {
    static IPatchRedirector $redirector_;
    private final ExponentialBucketStrategy bucketStrategy;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<ExponentialHistogramAccumulation> {
        static IPatchRedirector $redirector_;
        private final ExponentialBucketStrategy bucketStrategy;
        private final DoubleExponentialHistogramBuckets negativeBuckets;
        private final DoubleExponentialHistogramBuckets positiveBuckets;
        private double sum;
        private long zeroCount;

        Handle(ExemplarReservoir exemplarReservoir, ExponentialBucketStrategy exponentialBucketStrategy) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir, (Object) exponentialBucketStrategy);
                return;
            }
            this.sum = 0.0d;
            this.zeroCount = 0L;
            this.bucketStrategy = exponentialBucketStrategy;
            this.positiveBuckets = exponentialBucketStrategy.newBuckets();
            this.negativeBuckets = exponentialBucketStrategy.newBuckets();
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ ExponentialHistogramAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<ExemplarData>) list);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected synchronized void doRecordDouble(double d16) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
                return;
            }
            if (!b.a(d16)) {
                return;
            }
            this.sum += d16;
            int compare = Double.compare(d16, 0.0d);
            if (compare == 0) {
                this.zeroCount++;
                return;
            }
            if (compare > 0) {
                doubleExponentialHistogramBuckets = this.positiveBuckets;
            } else {
                doubleExponentialHistogramBuckets = this.negativeBuckets;
            }
            if (!doubleExponentialHistogramBuckets.record(d16)) {
                downScale(doubleExponentialHistogramBuckets.getScaleReduction(d16));
                doubleExponentialHistogramBuckets.record(d16);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordLong(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                doRecordDouble(j3);
            }
        }

        void downScale(int i3) {
            this.positiveBuckets.downscale(i3);
            this.negativeBuckets.downscale(i3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected synchronized ExponentialHistogramAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ExponentialHistogramAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
            ExponentialHistogramAccumulation create = ExponentialHistogramAccumulation.create(this.positiveBuckets.getScale(), this.sum, this.positiveBuckets.copy(), this.negativeBuckets.copy(), this.zeroCount, list);
            this.sum = 0.0d;
            this.zeroCount = 0L;
            this.positiveBuckets.clear();
            this.negativeBuckets.clear();
            return create;
        }
    }

    DoubleExponentialHistogramAggregator(Supplier<ExemplarReservoir> supplier) {
        this(supplier, ExponentialBucketStrategy.newStrategy(20, 320, ExponentialCounterFactory.CC.a()));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) supplier);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation, java.lang.Object] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ ExponentialHistogramAccumulation accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        return a.a(this, d16, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation, java.lang.Object] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ ExponentialHistogramAccumulation accumulateLongMeasurement(long j3, Attributes attributes, Context context) {
        return a.b(this, j3, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<ExponentialHistogramAccumulation> createHandle() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            obj = this.reservoirSupplier.get();
            return new Handle((ExemplarReservoir) obj, this.bucketStrategy);
        }
        return (AggregatorHandle) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, ExponentialHistogramAccumulation> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MetricData) iPatchRedirector.redirect((short) 6, this, resource, instrumentationScopeInfo, metricDescriptor, map, aggregationTemporality, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j3 = j16;
        }
        return ImmutableMetricData.createExponentialHistogram(resource, instrumentationScopeInfo, name, description, unit, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.a.a(aggregationTemporality, MetricDataUtils.toExponentialHistogramPointList(map, j3, j17)));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public ExponentialHistogramAccumulation diff(ExponentialHistogramAccumulation exponentialHistogramAccumulation, ExponentialHistogramAccumulation exponentialHistogramAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ExponentialHistogramAccumulation) iPatchRedirector.redirect((short) 5, (Object) this, (Object) exponentialHistogramAccumulation, (Object) exponentialHistogramAccumulation2);
        }
        double sum = exponentialHistogramAccumulation2.getSum() - exponentialHistogramAccumulation.getSum();
        long zeroCount = exponentialHistogramAccumulation2.getZeroCount() - exponentialHistogramAccumulation.getZeroCount();
        DoubleExponentialHistogramBuckets diff = DoubleExponentialHistogramBuckets.diff(exponentialHistogramAccumulation2.getPositiveBuckets(), exponentialHistogramAccumulation.getPositiveBuckets());
        DoubleExponentialHistogramBuckets diff2 = DoubleExponentialHistogramBuckets.diff(exponentialHistogramAccumulation2.getNegativeBuckets(), exponentialHistogramAccumulation.getNegativeBuckets());
        int min = Math.min(diff.getScale(), diff2.getScale());
        diff.downscale(diff.getScale() - min);
        diff2.downscale(diff2.getScale() - min);
        return ExponentialHistogramAccumulation.create(diff.getScale(), sum, diff, diff2, zeroCount, exponentialHistogramAccumulation2.getExemplars());
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public ExponentialHistogramAccumulation merge(ExponentialHistogramAccumulation exponentialHistogramAccumulation, ExponentialHistogramAccumulation exponentialHistogramAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ExponentialHistogramAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) exponentialHistogramAccumulation, (Object) exponentialHistogramAccumulation2);
        }
        double sum = exponentialHistogramAccumulation.getSum() + exponentialHistogramAccumulation2.getSum();
        long zeroCount = exponentialHistogramAccumulation.getZeroCount() + exponentialHistogramAccumulation2.getZeroCount();
        DoubleExponentialHistogramBuckets merge = DoubleExponentialHistogramBuckets.merge(exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation2.getPositiveBuckets());
        DoubleExponentialHistogramBuckets merge2 = DoubleExponentialHistogramBuckets.merge(exponentialHistogramAccumulation.getNegativeBuckets(), exponentialHistogramAccumulation2.getNegativeBuckets());
        int min = Math.min(merge.getScale(), merge2.getScale());
        merge.downscale(merge.getScale() - min);
        merge2.downscale(merge2.getScale() - min);
        return ExponentialHistogramAccumulation.create(merge.getScale(), sum, merge, merge2, zeroCount, exponentialHistogramAccumulation2.getExemplars());
    }

    DoubleExponentialHistogramAggregator(Supplier<ExemplarReservoir> supplier, ExponentialBucketStrategy exponentialBucketStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) supplier, (Object) exponentialBucketStrategy);
        } else {
            this.reservoirSupplier = supplier;
            this.bucketStrategy = exponentialBucketStrategy;
        }
    }
}
