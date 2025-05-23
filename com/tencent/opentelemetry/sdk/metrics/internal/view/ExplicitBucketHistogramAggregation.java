package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleHistogramAggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramUtils;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import java.util.List;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExplicitBucketHistogramAggregation implements Aggregation, AggregatorFactory {
    static IPatchRedirector $redirector_;
    private static final Aggregation DEFAULT;
    private final List<Double> bucketBoundaries;
    private final double[] bucketBoundaryArray;

    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.view.ExplicitBucketHistogramAggregation$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22763);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            DEFAULT = new ExplicitBucketHistogramAggregation(ExplicitBucketHistogramUtils.DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES);
        }
    }

    ExplicitBucketHistogramAggregation(List<Double> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.bucketBoundaries = list;
            this.bucketBoundaryArray = ExplicitBucketHistogramUtils.createBoundaryArray(list);
        }
    }

    public static Aggregation create(List<Double> list) {
        return new ExplicitBucketHistogramAggregation(list);
    }

    public static Aggregation getDefault() {
        return DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ExemplarReservoir lambda$createAggregator$0(ExemplarFilter exemplarFilter) {
        return com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.a(exemplarFilter, com.tencent.opentelemetry.sdk.metrics.internal.exemplar.c.c(com.tencent.opentelemetry.sdk.common.a.a(), this.bucketBoundaries));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, final ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        return new DoubleHistogramAggregator(this.bucketBoundaryArray, new Supplier() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.k
            @Override // java.util.function.Supplier
            public final Object get() {
                ExemplarReservoir lambda$createAggregator$0;
                lambda$createAggregator$0 = ExplicitBucketHistogramAggregation.this.lambda$createAggregator$0(exemplarFilter);
                return lambda$createAggregator$0;
            }
        });
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instrumentDescriptor)).booleanValue();
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()];
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ExplicitBucketHistogramAggregation(" + this.bucketBoundaries.toString() + ")";
    }
}
