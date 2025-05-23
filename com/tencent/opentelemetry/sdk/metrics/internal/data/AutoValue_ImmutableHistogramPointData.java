package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class AutoValue_ImmutableHistogramPointData extends ImmutableHistogramPointData {
    static IPatchRedirector $redirector_;
    private final Attributes getAttributes;
    private final List<Double> getBoundaries;
    private final long getCount;
    private final List<Long> getCounts;
    private final long getEpochNanos;
    private final List<ExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final long getStartEpochNanos;
    private final double getSum;
    private final boolean hasMax;
    private final boolean hasMin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableHistogramPointData(long j3, long j16, Attributes attributes, List<ExemplarData> list, double d16, long j17, boolean z16, double d17, boolean z17, double d18, List<Double> list2, List<Long> list3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), attributes, list, Double.valueOf(d16), Long.valueOf(j17), Boolean.valueOf(z16), Double.valueOf(d17), Boolean.valueOf(z17), Double.valueOf(d18), list2, list3);
            return;
        }
        this.getStartEpochNanos = j3;
        this.getEpochNanos = j16;
        if (attributes != null) {
            this.getAttributes = attributes;
            if (list != null) {
                this.getExemplars = list;
                this.getSum = d16;
                this.getCount = j17;
                this.hasMin = z16;
                this.getMin = d17;
                this.hasMax = z17;
                this.getMax = d18;
                if (list2 != null) {
                    this.getBoundaries = list2;
                    if (list3 != null) {
                        this.getCounts = list3;
                        return;
                    }
                    throw new NullPointerException("Null getCounts");
                }
                throw new NullPointerException("Null getBoundaries");
            }
            throw new NullPointerException("Null getExemplars");
        }
        throw new NullPointerException("Null getAttributes");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableHistogramPointData)) {
            return false;
        }
        ImmutableHistogramPointData immutableHistogramPointData = (ImmutableHistogramPointData) obj;
        if (this.getStartEpochNanos == immutableHistogramPointData.getStartEpochNanos() && this.getEpochNanos == immutableHistogramPointData.getEpochNanos() && this.getAttributes.equals(immutableHistogramPointData.getAttributes()) && this.getExemplars.equals(immutableHistogramPointData.getExemplars()) && Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(immutableHistogramPointData.getSum()) && this.getCount == immutableHistogramPointData.getCount() && this.hasMin == immutableHistogramPointData.hasMin() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(immutableHistogramPointData.getMin()) && this.hasMax == immutableHistogramPointData.hasMax() && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(immutableHistogramPointData.getMax()) && this.getBoundaries.equals(immutableHistogramPointData.getBoundaries()) && this.getCounts.equals(immutableHistogramPointData.getCounts())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Attributes) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.getAttributes;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public List<Double> getBoundaries() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.getBoundaries;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public long getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.getCount;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public List<Long> getCounts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.getCounts;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.getEpochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public List<ExemplarData> getExemplars() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.getExemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public double getMax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Double) iPatchRedirector.redirect((short) 11, (Object) this)).doubleValue();
        }
        return this.getMax;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public double getMin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this)).doubleValue();
        }
        return this.getMin;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getStartEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.getStartEpochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public double getSum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        return this.getSum;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public boolean hasMax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.hasMax;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData
    public boolean hasMin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.hasMin;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        long j3 = this.getStartEpochNanos;
        long j16 = this.getEpochNanos;
        int hashCode = (((((((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j16 ^ (j16 >>> 32)))) * 1000003) ^ this.getAttributes.hashCode()) * 1000003) ^ this.getExemplars.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum)))) * 1000003;
        long j17 = this.getCount;
        int i16 = (hashCode ^ ((int) (j17 ^ (j17 >>> 32)))) * 1000003;
        boolean z16 = this.hasMin;
        int i17 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        if (z16) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int doubleToLongBits = (((i16 ^ i3) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin)))) * 1000003;
        if (!this.hasMax) {
            i17 = 1237;
        }
        return ((((((doubleToLongBits ^ i17) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax)))) * 1000003) ^ this.getBoundaries.hashCode()) * 1000003) ^ this.getCounts.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "ImmutableHistogramPointData{getStartEpochNanos=" + this.getStartEpochNanos + ", getEpochNanos=" + this.getEpochNanos + ", getAttributes=" + this.getAttributes + ", getExemplars=" + this.getExemplars + ", getSum=" + this.getSum + ", getCount=" + this.getCount + ", hasMin=" + this.hasMin + ", getMin=" + this.getMin + ", hasMax=" + this.hasMax + ", getMax=" + this.getMax + ", getBoundaries=" + this.getBoundaries + ", getCounts=" + this.getCounts + "}";
    }
}
