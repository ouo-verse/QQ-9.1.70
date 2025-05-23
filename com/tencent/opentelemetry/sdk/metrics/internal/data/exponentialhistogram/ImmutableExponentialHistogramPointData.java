package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableExponentialHistogramPointData implements ExponentialHistogramPointData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableExponentialHistogramPointData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableExponentialHistogramPointData create(int i3, double d16, long j3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j16, long j17, Attributes attributes, List<ExemplarData> list) {
        return new AutoValue_ImmutableExponentialHistogramPointData(i3, d16, j3 + exponentialHistogramBuckets.getTotalCount() + exponentialHistogramBuckets2.getTotalCount(), j3, exponentialHistogramBuckets, exponentialHistogramBuckets2, j16, j17, attributes, list);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public abstract Attributes getAttributes();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract long getCount();

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public abstract long getEpochNanos();

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public abstract List<ExemplarData> getExemplars();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract ExponentialHistogramBuckets getNegativeBuckets();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract ExponentialHistogramBuckets getPositiveBuckets();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract int getScale();

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public abstract long getStartEpochNanos();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract double getSum();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public abstract long getZeroCount();
}
