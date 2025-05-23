package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public final class ParentBasedSamplerBuilder {
    static IPatchRedirector $redirector_;
    private Sampler localParentNotSampled;
    private Sampler localParentSampled;
    private Sampler remoteParentNotSampled;
    private Sampler remoteParentSampled;
    private final Sampler root;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentBasedSamplerBuilder(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sampler);
        } else {
            this.root = sampler;
        }
    }

    public Sampler build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Sampler) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new ParentBasedSampler(this.root, this.remoteParentSampled, this.remoteParentNotSampled, this.localParentSampled, this.localParentNotSampled);
    }

    public ParentBasedSamplerBuilder setLocalParentNotSampled(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ParentBasedSamplerBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) sampler);
        }
        this.localParentNotSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setLocalParentSampled(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ParentBasedSamplerBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) sampler);
        }
        this.localParentSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setRemoteParentNotSampled(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ParentBasedSamplerBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sampler);
        }
        this.remoteParentNotSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setRemoteParentSampled(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ParentBasedSamplerBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sampler);
        }
        this.remoteParentSampled = sampler;
        return this;
    }
}
