package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableLinkData extends ImmutableLinkData {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final SpanContext spanContext;
    private final int totalAttributeCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableLinkData(SpanContext spanContext, Attributes attributes, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spanContext, attributes, Integer.valueOf(i3));
            return;
        }
        if (spanContext != null) {
            this.spanContext = spanContext;
            if (attributes != null) {
                this.attributes = attributes;
                this.totalAttributeCount = i3;
                return;
            }
            throw new NullPointerException("Null attributes");
        }
        throw new NullPointerException("Null spanContext");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLinkData)) {
            return false;
        }
        ImmutableLinkData immutableLinkData = (ImmutableLinkData) obj;
        if (this.spanContext.equals(immutableLinkData.getSpanContext()) && this.attributes.equals(immutableLinkData.getAttributes()) && this.totalAttributeCount == immutableLinkData.getTotalAttributeCount()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.LinkData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.LinkData
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.spanContext;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.data.LinkData
    public int getTotalAttributeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.totalAttributeCount;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return ((((this.spanContext.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.totalAttributeCount;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ImmutableLinkData{spanContext=" + this.spanContext + ", attributes=" + this.attributes + ", totalAttributeCount=" + this.totalAttributeCount + "}";
    }
}
