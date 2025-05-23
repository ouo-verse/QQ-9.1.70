package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_LongAccumulation extends LongAccumulation {
    static IPatchRedirector $redirector_;
    private final List<ExemplarData> exemplars;
    private final long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LongAccumulation(long j3, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), list);
            return;
        }
        this.value = j3;
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
        if (!(obj instanceof LongAccumulation)) {
            return false;
        }
        LongAccumulation longAccumulation = (LongAccumulation) obj;
        if (this.value == longAccumulation.getValue() && this.exemplars.equals(longAccumulation.getExemplars())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    List<ExemplarData> getExemplars() {
        return this.exemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    long getValue() {
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        long j3 = this.value;
        return ((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.exemplars.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LongAccumulation{value=" + this.value + ", exemplars=" + this.exemplars + "}";
    }
}
