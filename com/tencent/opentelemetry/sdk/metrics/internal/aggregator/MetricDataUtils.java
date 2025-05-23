package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.internal.PrimitiveLongList;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData;
import com.tencent.opentelemetry.sdk.metrics.data.LongPointData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableDoublePointData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramPointData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/* compiled from: P */
/* loaded from: classes22.dex */
final class MetricDataUtils {
    static IPatchRedirector $redirector_;

    MetricDataUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMonotonicInstrument(InstrumentDescriptor instrumentDescriptor) {
        InstrumentType type = instrumentDescriptor.getType();
        if (type != InstrumentType.HISTOGRAM && type != InstrumentType.COUNTER && type != InstrumentType.OBSERVABLE_COUNTER) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toDoubleHistogramPointList$2(List list, long j3, long j16, List list2, Attributes attributes, HistogramAccumulation histogramAccumulation) {
        list.add(ImmutableHistogramPointData.create(j3, j16, attributes, histogramAccumulation.getSum(), Double.valueOf(histogramAccumulation.getMin()), Double.valueOf(histogramAccumulation.getMax()), list2, PrimitiveLongList.wrap((long[]) histogramAccumulation.getCounts().clone()), histogramAccumulation.getExemplars()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toDoublePointList$1(List list, long j3, long j16, Attributes attributes, DoubleAccumulation doubleAccumulation) {
        list.add(ImmutableDoublePointData.create(j3, j16, attributes, doubleAccumulation.getValue(), doubleAccumulation.getExemplars()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toExponentialHistogramPointList$3(List list, long j3, long j16, Attributes attributes, ExponentialHistogramAccumulation exponentialHistogramAccumulation) {
        list.add(com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.b.a(exponentialHistogramAccumulation.getScale(), exponentialHistogramAccumulation.getSum(), exponentialHistogramAccumulation.getZeroCount(), exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation.getNegativeBuckets(), j3, j16, attributes, exponentialHistogramAccumulation.getExemplars()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toLongPointList$0(List list, long j3, long j16, Attributes attributes, LongAccumulation longAccumulation) {
        list.add(ImmutableLongPointData.create(j3, j16, attributes, longAccumulation.getValue(), longAccumulation.getExemplars()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<HistogramPointData> toDoubleHistogramPointList(Map<Attributes, HistogramAccumulation> map, final long j3, final long j16, final List<Double> list) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.aggregator.h
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toDoubleHistogramPointList$2(arrayList, j3, j16, list, (Attributes) obj, (HistogramAccumulation) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<DoublePointData> toDoublePointList(Map<Attributes, DoubleAccumulation> map, final long j3, final long j16) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.aggregator.i
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toDoublePointList$1(arrayList, j3, j16, (Attributes) obj, (DoubleAccumulation) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ExponentialHistogramPointData> toExponentialHistogramPointList(Map<Attributes, ExponentialHistogramAccumulation> map, final long j3, final long j16) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.aggregator.k
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toExponentialHistogramPointList$3(arrayList, j3, j16, (Attributes) obj, (ExponentialHistogramAccumulation) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<LongPointData> toLongPointList(Map<Attributes, LongAccumulation> map, final long j3, final long j16) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.aggregator.j
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toLongPointList$0(arrayList, j3, j16, (Attributes) obj, (LongAccumulation) obj2);
            }
        });
        return arrayList;
    }
}
