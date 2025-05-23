package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableEntryMetadata extends ImmutableEntryMetadata {
    static IPatchRedirector $redirector_;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEntryMetadata(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            if (str != null) {
                this.value = str;
                return;
            }
            throw new NullPointerException("Null value");
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntryMetadata) {
            return this.value.equals(((ImmutableEntryMetadata) obj).getValue());
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.baggage.ImmutableEntryMetadata, com.tencent.opentelemetry.api.baggage.BaggageEntryMetadata
    public String getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.value.hashCode() ^ 1000003;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ImmutableEntryMetadata{value=" + this.value + "}";
    }
}
