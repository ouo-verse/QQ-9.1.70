package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SpanLimitsBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES_PER_EVENT = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES_PER_LINK = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_EVENTS = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_LINKS = 128;
    private int maxAttributeValueLength;
    private int maxNumAttributes;
    private int maxNumAttributesPerEvent;
    private int maxNumAttributesPerLink;
    private int maxNumEvents;
    private int maxNumLinks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanLimitsBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maxNumAttributes = 128;
        this.maxNumEvents = 128;
        this.maxNumLinks = 128;
        this.maxNumAttributesPerEvent = 128;
        this.maxNumAttributesPerLink = 128;
        this.maxAttributeValueLength = Integer.MAX_VALUE;
    }

    public SpanLimits build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpanLimits) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return SpanLimits.create(this.maxNumAttributes, this.maxNumEvents, this.maxNumLinks, this.maxNumAttributesPerEvent, this.maxNumAttributesPerLink, this.maxAttributeValueLength);
    }

    public SpanLimitsBuilder setMaxAttributeValueLength(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 > -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxAttributeValueLength must be non-negative");
        this.maxAttributeValueLength = i3;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfAttributes(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfAttributes must be greater than 0");
        this.maxNumAttributes = i3;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfAttributesPerEvent(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfAttributesPerEvent must be greater than 0");
        this.maxNumAttributesPerEvent = i3;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfAttributesPerLink(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfAttributesPerLink must be greater than 0");
        this.maxNumAttributesPerLink = i3;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfEvents(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfEvents must be greater than 0");
        this.maxNumEvents = i3;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfLinks(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpanLimitsBuilder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxNumberOfLinks must be greater than 0");
        this.maxNumLinks = i3;
        return this;
    }
}
