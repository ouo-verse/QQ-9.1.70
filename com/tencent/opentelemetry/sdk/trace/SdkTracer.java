package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.SpanBuilder;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkTracer implements Tracer {
    static IPatchRedirector $redirector_ = null;
    static final String FALLBACK_SPAN_NAME = "<unspecified span name>";
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final TracerSharedState sharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracer(TracerSharedState tracerSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tracerSharedState, (Object) instrumentationScopeInfo);
        } else {
            this.sharedState = tracerSharedState;
            this.instrumentationScopeInfo = instrumentationScopeInfo;
        }
    }

    InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.api.trace.Tracer
    public SpanBuilder spanBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (str == null || str.trim().isEmpty()) {
            str = FALLBACK_SPAN_NAME;
        }
        if (this.sharedState.hasBeenShutdown()) {
            return com.tencent.opentelemetry.api.trace.h.b().get(this.instrumentationScopeInfo.getName()).spanBuilder(str);
        }
        InstrumentationScopeInfo instrumentationScopeInfo = this.instrumentationScopeInfo;
        TracerSharedState tracerSharedState = this.sharedState;
        return new SdkSpanBuilder(str, instrumentationScopeInfo, tracerSharedState, tracerSharedState.getSpanLimits());
    }
}
