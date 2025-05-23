package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultTracerBuilder implements TracerBuilder {
    static IPatchRedirector $redirector_;
    private static final DefaultTracerBuilder INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new DefaultTracerBuilder();
        }
    }

    DefaultTracerBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TracerBuilder getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Tracer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return DefaultTracer.getInstance();
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this;
    }
}
