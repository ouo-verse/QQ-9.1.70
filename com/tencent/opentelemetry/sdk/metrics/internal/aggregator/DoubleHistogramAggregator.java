package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DoubleHistogramAggregator implements Aggregator<HistogramAccumulation> {
    static IPatchRedirector $redirector_;
    private final double[] boundaries;
    private final List<Double> boundaryList;
    private final Supplier<ExemplarReservoir> reservoirSupplier;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Handle extends AggregatorHandle<HistogramAccumulation> {
        static IPatchRedirector $redirector_;
        private final double[] boundaries;
        private long count;
        private final long[] counts;
        private final ReentrantLock lock;
        private double max;
        private double min;
        private double sum;

        Handle(double[] dArr, ExemplarReservoir exemplarReservoir) {
            super(exemplarReservoir);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dArr, (Object) exemplarReservoir);
                return;
            }
            this.lock = new ReentrantLock();
            this.boundaries = dArr;
            this.counts = new long[dArr.length + 1];
            this.sum = 0.0d;
            this.min = Double.MAX_VALUE;
            this.max = -1.0d;
            this.count = 0L;
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ HistogramAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<ExemplarData>) list);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordDouble(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
                return;
            }
            int findBucketIndex = ExplicitBucketHistogramUtils.findBucketIndex(this.boundaries, d16);
            this.lock.lock();
            try {
                this.sum += d16;
                this.min = Math.min(this.min, d16);
                this.max = Math.max(this.max, d16);
                this.count++;
                long[] jArr = this.counts;
                jArr[findBucketIndex] = jArr[findBucketIndex] + 1;
            } finally {
                this.lock.unlock();
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

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected HistogramAccumulation doAccumulateThenReset(List<ExemplarData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HistogramAccumulation) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
            this.lock.lock();
            try {
                double d16 = this.sum;
                long j3 = this.count;
                boolean z16 = j3 > 0;
                double d17 = j3 > 0 ? this.min : -1.0d;
                double d18 = j3 > 0 ? this.max : -1.0d;
                long[] jArr = this.counts;
                HistogramAccumulation create = HistogramAccumulation.create(d16, z16, d17, d18, Arrays.copyOf(jArr, jArr.length), list);
                this.sum = 0.0d;
                this.min = Double.MAX_VALUE;
                this.max = -1.0d;
                this.count = 0L;
                Arrays.fill(this.counts, 0L);
                return create;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public DoubleHistogramAggregator(double[] dArr, Supplier<ExemplarReservoir> supplier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dArr, (Object) supplier);
            return;
        }
        this.boundaries = dArr;
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d16 : dArr) {
            arrayList.add(Double.valueOf(d16));
        }
        this.boundaryList = Collections.unmodifiableList(arrayList);
        this.reservoirSupplier = supplier;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation, java.lang.Object] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ HistogramAccumulation accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        return a.a(this, d16, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation, java.lang.Object] */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ HistogramAccumulation accumulateLongMeasurement(long j3, Attributes attributes, Context context) {
        return a.b(this, j3, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<HistogramAccumulation> createHandle() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregatorHandle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        double[] dArr = this.boundaries;
        obj = this.reservoirSupplier.get();
        return new Handle(dArr, (ExemplarReservoir) obj);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, HistogramAccumulation> map, AggregationTemporality aggregationTemporality, long j3, long j16, long j17) {
        long j18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MetricData) iPatchRedirector.redirect((short) 5, this, resource, instrumentationScopeInfo, metricDescriptor, map, aggregationTemporality, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality == AggregationTemporality.CUMULATIVE) {
            j18 = j3;
        } else {
            j18 = j16;
        }
        return ImmutableMetricData.createDoubleHistogram(resource, instrumentationScopeInfo, name, description, unit, ImmutableHistogramData.create(aggregationTemporality, MetricDataUtils.toDoubleHistogramPointList(map, j18, j17, this.boundaryList)));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public HistogramAccumulation diff(HistogramAccumulation histogramAccumulation, HistogramAccumulation histogramAccumulation2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HistogramAccumulation) iPatchRedirector.redirect((short) 4, (Object) this, (Object) histogramAccumulation, (Object) histogramAccumulation2);
        }
        long[] counts = histogramAccumulation.getCounts();
        long[] jArr = new long[counts.length];
        for (int i3 = 0; i3 < counts.length; i3++) {
            jArr[i3] = histogramAccumulation2.getCounts()[i3] - counts[i3];
        }
        return HistogramAccumulation.create(histogramAccumulation2.getSum() - histogramAccumulation.getSum(), false, -1.0d, -1.0d, jArr, histogramAccumulation2.getExemplars());
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public HistogramAccumulation merge(HistogramAccumulation histogramAccumulation, HistogramAccumulation histogramAccumulation2) {
        double d16;
        double d17;
        double min;
        double max;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HistogramAccumulation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) histogramAccumulation, (Object) histogramAccumulation2);
        }
        long[] counts = histogramAccumulation.getCounts();
        long[] jArr = new long[counts.length];
        for (int i3 = 0; i3 < counts.length; i3++) {
            jArr[i3] = counts[i3] + histogramAccumulation2.getCounts()[i3];
        }
        if (histogramAccumulation.hasMinMax() && histogramAccumulation2.hasMinMax()) {
            min = Math.min(histogramAccumulation.getMin(), histogramAccumulation2.getMin());
            max = Math.max(histogramAccumulation.getMax(), histogramAccumulation2.getMax());
        } else if (histogramAccumulation.hasMinMax()) {
            min = histogramAccumulation.getMin();
            max = histogramAccumulation.getMax();
        } else if (histogramAccumulation2.hasMinMax()) {
            min = histogramAccumulation2.getMin();
            max = histogramAccumulation2.getMax();
        } else {
            d16 = -1.0d;
            d17 = -1.0d;
            return HistogramAccumulation.create(histogramAccumulation.getSum() + histogramAccumulation2.getSum(), !histogramAccumulation.hasMinMax() || histogramAccumulation2.hasMinMax(), d16, d17, jArr, histogramAccumulation2.getExemplars());
        }
        d17 = max;
        d16 = min;
        return HistogramAccumulation.create(histogramAccumulation.getSum() + histogramAccumulation2.getSum(), !histogramAccumulation.hasMinMax() || histogramAccumulation2.hasMinMax(), d16, d17, jArr, histogramAccumulation2.getExemplars());
    }
}
