package com.tencent.opentelemetry.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.OpenTelemetry;
import com.tencent.opentelemetry.api.a;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.api.trace.TracerProvider;
import com.tencent.opentelemetry.api.trace.h;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class OpenTelemetrySdk implements OpenTelemetry {
    static IPatchRedirector $redirector_;
    private final ContextPropagators propagators;
    private final ObfuscatedTracerProvider tracerProvider;

    /* compiled from: P */
    @ThreadSafe
    /* loaded from: classes22.dex */
    static class ObfuscatedTracerProvider implements TracerProvider {
        static IPatchRedirector $redirector_;
        private final SdkTracerProvider delegate;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ObfuscatedTracerProvider(SdkTracerProvider sdkTracerProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sdkTracerProvider);
            } else {
                this.delegate = sdkTracerProvider;
            }
        }

        @Override // com.tencent.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.delegate.get(str) : (Tracer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }

        @Override // com.tencent.opentelemetry.api.trace.TracerProvider
        public /* synthetic */ TracerBuilder tracerBuilder(String str) {
            return h.a(this, str);
        }

        public SdkTracerProvider unobfuscate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (SdkTracerProvider) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.delegate;
        }

        @Override // com.tencent.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.delegate.get(str, str2) : (Tracer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenTelemetrySdk(ObfuscatedTracerProvider obfuscatedTracerProvider, ContextPropagators contextPropagators) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) obfuscatedTracerProvider, (Object) contextPropagators);
        } else {
            this.tracerProvider = obfuscatedTracerProvider;
            this.propagators = contextPropagators;
        }
    }

    public static OpenTelemetrySdkBuilder builder() {
        return new OpenTelemetrySdkBuilder();
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ContextPropagators) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.propagators;
    }

    public SdkTracerProvider getSdkTracerProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SdkTracerProvider) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tracerProvider.unobfuscate();
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public /* synthetic */ Tracer getTracer(String str) {
        return a.a(this, str);
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public TracerProvider getTracerProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TracerProvider) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tracerProvider;
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public /* synthetic */ TracerBuilder tracerBuilder(String str) {
        return a.c(this, str);
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public /* synthetic */ Tracer getTracer(String str, String str2) {
        return a.b(this, str, str2);
    }
}
