package com.tencent.opentelemetry.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.api.trace.TracerProvider;
import com.tencent.opentelemetry.api.trace.h;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class DefaultOpenTelemetry implements OpenTelemetry {
    static IPatchRedirector $redirector_;
    private static final OpenTelemetry NO_OP;
    private final ContextPropagators propagators;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            NO_OP = new DefaultOpenTelemetry(com.tencent.opentelemetry.context.propagation.a.b());
        }
    }

    DefaultOpenTelemetry(ContextPropagators contextPropagators) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) contextPropagators);
        } else {
            this.propagators = contextPropagators;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenTelemetry getNoop() {
        return NO_OP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenTelemetry getPropagating(ContextPropagators contextPropagators) {
        return new DefaultOpenTelemetry(contextPropagators);
    }

    @Override // com.tencent.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ContextPropagators) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.propagators;
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
        return h.b();
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
