package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class AutoValue_ImmutableDoublePointData extends ImmutableDoublePointData {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final long epochNanos;
    private final List<ExemplarData> exemplars;
    private final long startEpochNanos;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableDoublePointData(long j3, long j16, Attributes attributes, List<ExemplarData> list, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), attributes, list, Double.valueOf(d16));
            return;
        }
        this.startEpochNanos = j3;
        this.epochNanos = j16;
        if (attributes != null) {
            this.attributes = attributes;
            if (list != null) {
                this.exemplars = list;
                this.value = d16;
                return;
            }
            throw new NullPointerException("Null exemplars");
        }
        throw new NullPointerException("Null attributes");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoublePointData)) {
            return false;
        }
        ImmutableDoublePointData immutableDoublePointData = (ImmutableDoublePointData) obj;
        if (this.startEpochNanos == immutableDoublePointData.getStartEpochNanos() && this.epochNanos == immutableDoublePointData.getEpochNanos() && this.attributes.equals(immutableDoublePointData.getAttributes()) && this.exemplars.equals(immutableDoublePointData.getExemplars()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableDoublePointData.getValue())) {
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

    @Override // com.tencent.opentelemetry.sdk.metrics.data.DoublePointData
    public double getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        long j3 = this.startEpochNanos;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003;
        long j16 = this.epochNanos;
        return ((((((i3 ^ ((int) (j16 ^ (j16 >>> 32)))) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.exemplars.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "ImmutableDoublePointData{startEpochNanos=" + this.startEpochNanos + ", epochNanos=" + this.epochNanos + ", attributes=" + this.attributes + ", exemplars=" + this.exemplars + ", value=" + this.value + "}";
    }
}
