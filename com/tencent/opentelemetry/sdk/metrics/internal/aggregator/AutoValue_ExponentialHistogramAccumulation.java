package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ExponentialHistogramAccumulation extends ExponentialHistogramAccumulation {
    static IPatchRedirector $redirector_;
    private final List<ExemplarData> exemplars;
    private final DoubleExponentialHistogramBuckets negativeBuckets;
    private final DoubleExponentialHistogramBuckets positiveBuckets;
    private final int scale;
    private final double sum;
    private final long zeroCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ExponentialHistogramAccumulation(int i3, double d16, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2, long j3, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Double.valueOf(d16), doubleExponentialHistogramBuckets, doubleExponentialHistogramBuckets2, Long.valueOf(j3), list);
            return;
        }
        this.scale = i3;
        this.sum = d16;
        if (doubleExponentialHistogramBuckets != null) {
            this.positiveBuckets = doubleExponentialHistogramBuckets;
            if (doubleExponentialHistogramBuckets2 != null) {
                this.negativeBuckets = doubleExponentialHistogramBuckets2;
                this.zeroCount = j3;
                if (list != null) {
                    this.exemplars = list;
                    return;
                }
                throw new NullPointerException("Null exemplars");
            }
            throw new NullPointerException("Null negativeBuckets");
        }
        throw new NullPointerException("Null positiveBuckets");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExponentialHistogramAccumulation)) {
            return false;
        }
        ExponentialHistogramAccumulation exponentialHistogramAccumulation = (ExponentialHistogramAccumulation) obj;
        if (this.scale == exponentialHistogramAccumulation.getScale() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(exponentialHistogramAccumulation.getSum()) && this.positiveBuckets.equals(exponentialHistogramAccumulation.getPositiveBuckets()) && this.negativeBuckets.equals(exponentialHistogramAccumulation.getNegativeBuckets()) && this.zeroCount == exponentialHistogramAccumulation.getZeroCount() && this.exemplars.equals(exponentialHistogramAccumulation.getExemplars())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    List<ExemplarData> getExemplars() {
        return this.exemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    DoubleExponentialHistogramBuckets getNegativeBuckets() {
        return this.negativeBuckets;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    DoubleExponentialHistogramBuckets getPositiveBuckets() {
        return this.positiveBuckets;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    int getScale() {
        return this.scale;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    double getSum() {
        return this.sum;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    long getZeroCount() {
        return this.zeroCount;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int doubleToLongBits = (((((((this.scale ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)))) * 1000003) ^ this.positiveBuckets.hashCode()) * 1000003) ^ this.negativeBuckets.hashCode()) * 1000003;
        long j3 = this.zeroCount;
        return ((doubleToLongBits ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.exemplars.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ExponentialHistogramAccumulation{scale=" + this.scale + ", sum=" + this.sum + ", positiveBuckets=" + this.positiveBuckets + ", negativeBuckets=" + this.negativeBuckets + ", zeroCount=" + this.zeroCount + ", exemplars=" + this.exemplars + "}";
    }
}
