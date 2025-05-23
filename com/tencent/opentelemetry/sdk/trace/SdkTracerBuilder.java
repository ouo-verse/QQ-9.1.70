package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class SdkTracerBuilder implements TracerBuilder {
    static IPatchRedirector $redirector_;
    private final String instrumentationName;
    private String instrumentationVersion;
    private final ComponentRegistry<SdkTracer> registry;
    private String schemaUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracerBuilder(ComponentRegistry<SdkTracer> componentRegistry, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentRegistry, (Object) str);
        } else {
            this.registry = componentRegistry;
            this.instrumentationName = str;
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Tracer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.registry.get(this.instrumentationName, this.instrumentationVersion, this.schemaUrl);
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.instrumentationVersion = str;
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.schemaUrl = str;
        return this;
    }
}
