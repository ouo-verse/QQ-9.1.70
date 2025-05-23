package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class AbstractInstrument {
    static IPatchRedirector $redirector_;
    private final InstrumentDescriptor descriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor);
        } else {
            this.descriptor = instrumentDescriptor;
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractInstrument)) {
            return false;
        }
        return this.descriptor.equals(((AbstractInstrument) obj).descriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InstrumentDescriptor getDescriptor() {
        return this.descriptor;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.descriptor.hashCode();
    }
}
