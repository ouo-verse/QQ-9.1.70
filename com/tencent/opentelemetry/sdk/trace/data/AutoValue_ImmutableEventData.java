package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableEventData extends ImmutableEventData {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final long epochNanos;
    private final String name;
    private final int totalAttributeCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEventData(String str, Attributes attributes, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, attributes, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (str != null) {
            this.name = str;
            if (attributes != null) {
                this.attributes = attributes;
                this.epochNanos = j3;
                this.totalAttributeCount = i3;
                return;
            }
            throw new NullPointerException("Null attributes");
        }
        throw new NullPointerException("Null name");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableEventData)) {
            return false;
        }
        ImmutableEventData immutableEventData = (ImmutableEventData) obj;
        if (this.name.equals(immutableEventData.getName()) && this.attributes.equals(immutableEventData.getAttributes()) && this.epochNanos == immutableEventData.getEpochNanos() && this.totalAttributeCount == immutableEventData.getTotalAttributeCount()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.epochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.EventData
    public int getTotalAttributeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.totalAttributeCount;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int hashCode = (((this.name.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode()) * 1000003;
        long j3 = this.epochNanos;
        return ((hashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.totalAttributeCount;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "ImmutableEventData{name=" + this.name + ", attributes=" + this.attributes + ", epochNanos=" + this.epochNanos + ", totalAttributeCount=" + this.totalAttributeCount + "}";
    }
}
