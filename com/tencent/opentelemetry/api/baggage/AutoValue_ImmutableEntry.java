package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableEntry extends ImmutableEntry {
    static IPatchRedirector $redirector_;
    private final BaggageEntryMetadata metadata;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEntry(String str, BaggageEntryMetadata baggageEntryMetadata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) baggageEntryMetadata);
        } else {
            if (str != null) {
                this.value = str;
                if (baggageEntryMetadata != null) {
                    this.metadata = baggageEntryMetadata;
                    return;
                }
                throw new NullPointerException("Null metadata");
            }
            throw new NullPointerException("Null value");
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
        if (!(obj instanceof ImmutableEntry)) {
            return false;
        }
        ImmutableEntry immutableEntry = (ImmutableEntry) obj;
        if (this.value.equals(immutableEntry.getValue()) && this.metadata.equals(immutableEntry.getMetadata())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.baggage.BaggageEntry
    public BaggageEntryMetadata getMetadata() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaggageEntryMetadata) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.metadata;
    }

    @Override // com.tencent.opentelemetry.api.baggage.BaggageEntry
    public String getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((this.value.hashCode() ^ 1000003) * 1000003) ^ this.metadata.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImmutableEntry{value=" + this.value + ", metadata=" + this.metadata + "}";
    }
}
