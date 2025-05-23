package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_ImmutableDoubleExemplarData extends ImmutableDoubleExemplarData {
    static IPatchRedirector $redirector_;
    private final long epochNanos;
    private final Attributes filteredAttributes;
    private final SpanContext spanContext;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableDoubleExemplarData(Attributes attributes, long j3, SpanContext spanContext, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, attributes, Long.valueOf(j3), spanContext, Double.valueOf(d16));
            return;
        }
        if (attributes != null) {
            this.filteredAttributes = attributes;
            this.epochNanos = j3;
            if (spanContext != null) {
                this.spanContext = spanContext;
                this.value = d16;
                return;
            }
            throw new NullPointerException("Null spanContext");
        }
        throw new NullPointerException("Null filteredAttributes");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleExemplarData)) {
            return false;
        }
        ImmutableDoubleExemplarData immutableDoubleExemplarData = (ImmutableDoubleExemplarData) obj;
        if (this.filteredAttributes.equals(immutableDoubleExemplarData.getFilteredAttributes()) && this.epochNanos == immutableDoubleExemplarData.getEpochNanos() && this.spanContext.equals(immutableDoubleExemplarData.getSpanContext()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableDoubleExemplarData.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.ExemplarData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.epochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.ExemplarData
    public Attributes getFilteredAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Attributes) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.filteredAttributes;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.ExemplarData
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpanContext) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.spanContext;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.DoubleExemplarData
    public double getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int hashCode = (this.filteredAttributes.hashCode() ^ 1000003) * 1000003;
        long j3 = this.epochNanos;
        return ((((hashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.spanContext.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "ImmutableDoubleExemplarData{filteredAttributes=" + this.filteredAttributes + ", epochNanos=" + this.epochNanos + ", spanContext=" + this.spanContext + ", value=" + this.value + "}";
    }
}
