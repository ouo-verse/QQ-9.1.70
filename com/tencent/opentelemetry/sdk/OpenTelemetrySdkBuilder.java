package com.tencent.opentelemetry.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.GlobalOpenTelemetry;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;
import com.tencent.opentelemetry.context.propagation.a;
import com.tencent.opentelemetry.sdk.OpenTelemetrySdk;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenTelemetrySdkBuilder {
    static IPatchRedirector $redirector_;
    private ContextPropagators propagators;
    private SdkTracerProvider tracerProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenTelemetrySdkBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.propagators = a.b();
        }
    }

    public OpenTelemetrySdk build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OpenTelemetrySdk) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.tracerProvider == null) {
            this.tracerProvider = SdkTracerProvider.builder().build();
        }
        return new OpenTelemetrySdk(new OpenTelemetrySdk.ObfuscatedTracerProvider(this.tracerProvider), this.propagators);
    }

    public OpenTelemetrySdk buildAndRegisterGlobal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (OpenTelemetrySdk) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        OpenTelemetrySdk build = build();
        GlobalOpenTelemetry.set(build);
        return build;
    }

    public OpenTelemetrySdkBuilder setPropagators(ContextPropagators contextPropagators) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OpenTelemetrySdkBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) contextPropagators);
        }
        this.propagators = contextPropagators;
        return this;
    }

    public OpenTelemetrySdkBuilder setTracerProvider(SdkTracerProvider sdkTracerProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OpenTelemetrySdkBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sdkTracerProvider);
        }
        this.tracerProvider = sdkTracerProvider;
        return this;
    }
}
