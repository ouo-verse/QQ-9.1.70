package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* loaded from: classes22.dex */
final class AutoValue_ImmutableExponentialHistogramPointData extends ImmutableExponentialHistogramPointData {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final long count;
    private final long epochNanos;
    private final List<ExemplarData> exemplars;
    private final ExponentialHistogramBuckets negativeBuckets;
    private final ExponentialHistogramBuckets positiveBuckets;
    private final int scale;
    private final long startEpochNanos;
    private final double sum;
    private final long zeroCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableExponentialHistogramPointData(int i3, double d16, long j3, long j16, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j17, long j18, Attributes attributes, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Double.valueOf(d16), Long.valueOf(j3), Long.valueOf(j16), exponentialHistogramBuckets, exponentialHistogramBuckets2, Long.valueOf(j17), Long.valueOf(j18), attributes, list);
            return;
        }
        this.scale = i3;
        this.sum = d16;
        this.count = j3;
        this.zeroCount = j16;
        if (exponentialHistogramBuckets != null) {
            this.positiveBuckets = exponentialHistogramBuckets;
            if (exponentialHistogramBuckets2 != null) {
                this.negativeBuckets = exponentialHistogramBuckets2;
                this.startEpochNanos = j17;
                this.epochNanos = j18;
                if (attributes != null) {
                    this.attributes = attributes;
                    if (list != null) {
                        this.exemplars = list;
                        return;
                    }
                    throw new NullPointerException("Null exemplars");
                }
                throw new NullPointerException("Null attributes");
            }
            throw new NullPointerException("Null negativeBuckets");
        }
        throw new NullPointerException("Null positiveBuckets");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableExponentialHistogramPointData)) {
            return false;
        }
        ImmutableExponentialHistogramPointData immutableExponentialHistogramPointData = (ImmutableExponentialHistogramPointData) obj;
        if (this.scale == immutableExponentialHistogramPointData.getScale() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(immutableExponentialHistogramPointData.getSum()) && this.count == immutableExponentialHistogramPointData.getCount() && this.zeroCount == immutableExponentialHistogramPointData.getZeroCount() && this.positiveBuckets.equals(immutableExponentialHistogramPointData.getPositiveBuckets()) && this.negativeBuckets.equals(immutableExponentialHistogramPointData.getNegativeBuckets()) && this.startEpochNanos == immutableExponentialHistogramPointData.getStartEpochNanos() && this.epochNanos == immutableExponentialHistogramPointData.getEpochNanos() && this.attributes.equals(immutableExponentialHistogramPointData.getAttributes()) && this.exemplars.equals(immutableExponentialHistogramPointData.getExemplars())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.data.PointData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Attributes) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public long getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.count;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.epochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.data.PointData
    public List<ExemplarData> getExemplars() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.exemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public ExponentialHistogramBuckets getNegativeBuckets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ExponentialHistogramBuckets) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.negativeBuckets;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public ExponentialHistogramBuckets getPositiveBuckets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ExponentialHistogramBuckets) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.positiveBuckets;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public int getScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.scale;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getStartEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.startEpochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public double getSum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.sum;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramPointData, com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public long getZeroCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.zeroCount;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        int doubleToLongBits = (((this.scale ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)))) * 1000003;
        long j3 = this.count;
        int i3 = (doubleToLongBits ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j16 = this.zeroCount;
        int hashCode = (((((i3 ^ ((int) (j16 ^ (j16 >>> 32)))) * 1000003) ^ this.positiveBuckets.hashCode()) * 1000003) ^ this.negativeBuckets.hashCode()) * 1000003;
        long j17 = this.startEpochNanos;
        int i16 = (hashCode ^ ((int) (j17 ^ (j17 >>> 32)))) * 1000003;
        long j18 = this.epochNanos;
        return ((((i16 ^ ((int) (j18 ^ (j18 >>> 32)))) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.exemplars.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "ImmutableExponentialHistogramPointData{scale=" + this.scale + ", sum=" + this.sum + ", count=" + this.count + ", zeroCount=" + this.zeroCount + ", positiveBuckets=" + this.positiveBuckets + ", negativeBuckets=" + this.negativeBuckets + ", startEpochNanos=" + this.startEpochNanos + ", epochNanos=" + this.epochNanos + ", attributes=" + this.attributes + ", exemplars=" + this.exemplars + "}";
    }
}
