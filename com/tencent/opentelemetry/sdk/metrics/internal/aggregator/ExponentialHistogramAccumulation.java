package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
/* loaded from: classes22.dex */
public abstract class ExponentialHistogramAccumulation {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExponentialHistogramAccumulation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExponentialHistogramAccumulation create(int i3, double d16, @Nonnull DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, @Nonnull DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2, long j3, List<ExemplarData> list) {
        return new AutoValue_ExponentialHistogramAccumulation(i3, d16, doubleExponentialHistogramBuckets, doubleExponentialHistogramBuckets2, j3, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<ExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract DoubleExponentialHistogramBuckets getNegativeBuckets();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract DoubleExponentialHistogramBuckets getPositiveBuckets();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getScale();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getSum();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getZeroCount();
}
