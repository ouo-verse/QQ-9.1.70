package com.tencent.opentelemetry.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.api.trace.TracerProvider;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface OpenTelemetry {
    public static final IPatchRedirector $redirector_ = null;

    ContextPropagators getPropagators();

    Tracer getTracer(String str);

    Tracer getTracer(String str, String str2);

    TracerProvider getTracerProvider();

    TracerBuilder tracerBuilder(String str);
}
