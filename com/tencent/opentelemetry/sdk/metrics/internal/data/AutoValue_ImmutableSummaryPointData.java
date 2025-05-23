package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import java.util.List;

/* loaded from: classes22.dex */
final class AutoValue_ImmutableSummaryPointData extends ImmutableSummaryPointData {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final long count;
    private final long epochNanos;
    private final List<ExemplarData> exemplars;
    private final long startEpochNanos;
    private final double sum;
    private final List<ValueAtQuantile> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSummaryPointData(long j3, long j16, Attributes attributes, List<ExemplarData> list, long j17, double d16, List<ValueAtQuantile> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), attributes, list, Long.valueOf(j17), Double.valueOf(d16), list2);
            return;
        }
        this.startEpochNanos = j3;
        this.epochNanos = j16;
        if (attributes != null) {
            this.attributes = attributes;
            if (list != null) {
                this.exemplars = list;
                this.count = j17;
                this.sum = d16;
                if (list2 != null) {
                    this.values = list2;
                    return;
                }
                throw new NullPointerException("Null values");
            }
            throw new NullPointerException("Null exemplars");
        }
        throw new NullPointerException("Null attributes");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSummaryPointData)) {
            return false;
        }
        ImmutableSummaryPointData immutableSummaryPointData = (ImmutableSummaryPointData) obj;
        if (this.startEpochNanos == immutableSummaryPointData.getStartEpochNanos() && this.epochNanos == immutableSummaryPointData.getEpochNanos() && this.attributes.equals(immutableSummaryPointData.getAttributes()) && this.exemplars.equals(immutableSummaryPointData.getExemplars()) && this.count == immutableSummaryPointData.getCount() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(immutableSummaryPointData.getSum()) && this.values.equals(immutableSummaryPointData.getValues())) {
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
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData
    public long getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.count;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.epochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public List<ExemplarData> getExemplars() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.exemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.PointData
    public long getStartEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.startEpochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData
    public double getSum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Double) iPatchRedirector.redirect((short) 7, (Object) this)).doubleValue();
        }
        return this.sum;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData
    public List<ValueAtQuantile> getValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.values;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        long j3 = this.startEpochNanos;
        long j16 = this.epochNanos;
        int hashCode = (((((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j16 ^ (j16 >>> 32)))) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.exemplars.hashCode()) * 1000003;
        long j17 = this.count;
        return ((((hashCode ^ ((int) (j17 ^ (j17 >>> 32)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)))) * 1000003) ^ this.values.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "ImmutableSummaryPointData{startEpochNanos=" + this.startEpochNanos + ", epochNanos=" + this.epochNanos + ", attributes=" + this.attributes + ", exemplars=" + this.exemplars + ", count=" + this.count + ", sum=" + this.sum + ", values=" + this.values + "}";
    }
}
