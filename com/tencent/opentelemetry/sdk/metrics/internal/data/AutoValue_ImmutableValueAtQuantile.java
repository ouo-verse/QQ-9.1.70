package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableValueAtQuantile extends ImmutableValueAtQuantile {
    static IPatchRedirector $redirector_;
    private final double quantile;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableValueAtQuantile(double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Double.valueOf(d17));
        } else {
            this.quantile = d16;
            this.value = d17;
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableValueAtQuantile)) {
            return false;
        }
        ImmutableValueAtQuantile immutableValueAtQuantile = (ImmutableValueAtQuantile) obj;
        if (Double.doubleToLongBits(this.quantile) == Double.doubleToLongBits(immutableValueAtQuantile.getQuantile()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableValueAtQuantile.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile
    public double getQuantile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.quantile;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile
    public double getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((((int) ((Double.doubleToLongBits(this.quantile) >>> 32) ^ Double.doubleToLongBits(this.quantile))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImmutableValueAtQuantile{quantile=" + this.quantile + ", value=" + this.value + "}";
    }
}
