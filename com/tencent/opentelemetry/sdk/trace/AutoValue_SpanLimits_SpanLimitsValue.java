package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.trace.SpanLimits;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_SpanLimits_SpanLimitsValue extends SpanLimits.SpanLimitsValue {
    static IPatchRedirector $redirector_;
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;
    private final int maxNumberOfAttributesPerEvent;
    private final int maxNumberOfAttributesPerLink;
    private final int maxNumberOfEvents;
    private final int maxNumberOfLinks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SpanLimits_SpanLimitsValue(int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        this.maxNumberOfAttributes = i3;
        this.maxNumberOfEvents = i16;
        this.maxNumberOfLinks = i17;
        this.maxNumberOfAttributesPerEvent = i18;
        this.maxNumberOfAttributesPerLink = i19;
        this.maxAttributeValueLength = i26;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanLimits.SpanLimitsValue)) {
            return false;
        }
        SpanLimits.SpanLimitsValue spanLimitsValue = (SpanLimits.SpanLimitsValue) obj;
        if (this.maxNumberOfAttributes == spanLimitsValue.getMaxNumberOfAttributes() && this.maxNumberOfEvents == spanLimitsValue.getMaxNumberOfEvents() && this.maxNumberOfLinks == spanLimitsValue.getMaxNumberOfLinks() && this.maxNumberOfAttributesPerEvent == spanLimitsValue.getMaxNumberOfAttributesPerEvent() && this.maxNumberOfAttributesPerLink == spanLimitsValue.getMaxNumberOfAttributesPerLink() && this.maxAttributeValueLength == spanLimitsValue.getMaxAttributeValueLength()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits.SpanLimitsValue, com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxAttributeValueLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.maxAttributeValueLength;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.maxNumberOfAttributes;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributesPerEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.maxNumberOfAttributesPerEvent;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributesPerLink() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.maxNumberOfAttributesPerLink;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.maxNumberOfEvents;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfLinks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxNumberOfLinks;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return ((((((((((this.maxNumberOfAttributes ^ 1000003) * 1000003) ^ this.maxNumberOfEvents) * 1000003) ^ this.maxNumberOfLinks) * 1000003) ^ this.maxNumberOfAttributesPerEvent) * 1000003) ^ this.maxNumberOfAttributesPerLink) * 1000003) ^ this.maxAttributeValueLength;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SpanLimitsValue{maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxNumberOfEvents=" + this.maxNumberOfEvents + ", maxNumberOfLinks=" + this.maxNumberOfLinks + ", maxNumberOfAttributesPerEvent=" + this.maxNumberOfAttributesPerEvent + ", maxNumberOfAttributesPerLink=" + this.maxNumberOfAttributesPerLink + ", maxAttributeValueLength=" + this.maxAttributeValueLength + "}";
    }
}
