package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_LogLimits extends LogLimits {
    static IPatchRedirector $redirector_;
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogLimits(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.maxNumberOfAttributes = i3;
            this.maxAttributeValueLength = i16;
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
        if (!(obj instanceof LogLimits)) {
            return false;
        }
        LogLimits logLimits = (LogLimits) obj;
        if (this.maxNumberOfAttributes == logLimits.getMaxNumberOfAttributes() && this.maxAttributeValueLength == logLimits.getMaxAttributeValueLength()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogLimits
    public int getMaxAttributeValueLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.maxAttributeValueLength;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogLimits
    public int getMaxNumberOfAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.maxNumberOfAttributes;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((this.maxNumberOfAttributes ^ 1000003) * 1000003) ^ this.maxAttributeValueLength;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "LogLimits{maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxAttributeValueLength=" + this.maxAttributeValueLength + "}";
    }
}
