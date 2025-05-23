package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_DoubleAccumulation extends DoubleAccumulation {
    static IPatchRedirector $redirector_;
    private final List<ExemplarData> exemplars;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_DoubleAccumulation(double d16, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), list);
            return;
        }
        this.value = d16;
        if (list != null) {
            this.exemplars = list;
            return;
        }
        throw new NullPointerException("Null exemplars");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoubleAccumulation)) {
            return false;
        }
        DoubleAccumulation doubleAccumulation = (DoubleAccumulation) obj;
        if (Double.doubleToLongBits(this.value) == Double.doubleToLongBits(doubleAccumulation.getValue()) && this.exemplars.equals(doubleAccumulation.getExemplars())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    List<ExemplarData> getExemplars() {
        return this.exemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    double getValue() {
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return ((((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value))) ^ 1000003) * 1000003) ^ this.exemplars.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DoubleAccumulation{value=" + this.value + ", exemplars=" + this.exemplars + "}";
    }
}
