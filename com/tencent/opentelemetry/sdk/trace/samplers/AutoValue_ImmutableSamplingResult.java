package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableSamplingResult extends ImmutableSamplingResult {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final SamplingDecision decision;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSamplingResult(SamplingDecision samplingDecision, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) samplingDecision, (Object) attributes);
        } else {
            if (samplingDecision != null) {
                this.decision = samplingDecision;
                if (attributes != null) {
                    this.attributes = attributes;
                    return;
                }
                throw new NullPointerException("Null attributes");
            }
            throw new NullPointerException("Null decision");
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
        if (!(obj instanceof ImmutableSamplingResult)) {
            return false;
        }
        ImmutableSamplingResult immutableSamplingResult = (ImmutableSamplingResult) obj;
        if (this.decision.equals(immutableSamplingResult.getDecision()) && this.attributes.equals(immutableSamplingResult.getAttributes())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.ImmutableSamplingResult, com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Attributes) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.ImmutableSamplingResult, com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult
    public SamplingDecision getDecision() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SamplingDecision) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.decision;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((this.decision.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImmutableSamplingResult{decision=" + this.decision + ", attributes=" + this.attributes + "}";
    }
}
