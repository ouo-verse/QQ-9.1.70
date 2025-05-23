package com.tencent.opentelemetry.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static Tracer a(OpenTelemetry openTelemetry, String str) {
        IPatchRedirector iPatchRedirector = OpenTelemetry.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Tracer) iPatchRedirector.redirect((short) 3, (Object) openTelemetry, (Object) str);
        }
        return openTelemetry.getTracerProvider().get(str);
    }

    public static Tracer b(OpenTelemetry openTelemetry, String str, String str2) {
        IPatchRedirector iPatchRedirector = OpenTelemetry.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Tracer) iPatchRedirector.redirect((short) 4, (Object) openTelemetry, (Object) str, (Object) str2);
        }
        return openTelemetry.getTracerProvider().get(str, str2);
    }

    public static TracerBuilder c(OpenTelemetry openTelemetry, String str) {
        IPatchRedirector iPatchRedirector = OpenTelemetry.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 5, (Object) openTelemetry, (Object) str);
        }
        return openTelemetry.getTracerProvider().tracerBuilder(str);
    }

    public static OpenTelemetry d() {
        IPatchRedirector iPatchRedirector = OpenTelemetry.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (OpenTelemetry) iPatchRedirector.redirect((short) 1);
        }
        return DefaultOpenTelemetry.getNoop();
    }

    public static OpenTelemetry e(ContextPropagators contextPropagators) {
        IPatchRedirector iPatchRedirector = OpenTelemetry.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OpenTelemetry) iPatchRedirector.redirect((short) 2, (Object) contextPropagators);
        }
        return DefaultOpenTelemetry.getPropagating(contextPropagators);
    }
}
