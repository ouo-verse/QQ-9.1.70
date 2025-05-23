package com.tencent.opentelemetry.api.internal;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanId;
import com.tencent.opentelemetry.api.trace.TraceFlags;
import com.tencent.opentelemetry.api.trace.TraceId;
import com.tencent.opentelemetry.api.trace.TraceState;
import com.tencent.opentelemetry.api.trace.e;
import com.tencent.opentelemetry.api.trace.f;
import com.tencent.opentelemetry.api.trace.g;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableSpanContext implements SpanContext {
    static IPatchRedirector $redirector_;
    public static final SpanContext INVALID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INVALID = createInternal(TraceId.getInvalid(), SpanId.getInvalid(), f.c(), g.b(), false, false);
        }
    }

    public ImmutableSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SpanContext create(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z16, boolean z17) {
        if (!z17 && (!SpanId.isValid(str2) || !TraceId.isValid(str))) {
            return createInternal(TraceId.getInvalid(), SpanId.getInvalid(), traceFlags, traceState, z16, false);
        }
        return createInternal(str, str2, traceFlags, traceState, z16, true);
    }

    private static AutoValue_ImmutableSpanContext createInternal(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z16, boolean z17) {
        return new AutoValue_ImmutableSpanContext(str, str2, traceFlags, traceState, z16, z17);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public /* synthetic */ byte[] getSpanIdBytes() {
        return e.a(this);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public /* synthetic */ byte[] getTraceIdBytes() {
        return e.b(this);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public /* synthetic */ boolean isSampled() {
        return e.c(this);
    }

    @Override // com.tencent.opentelemetry.api.trace.SpanContext
    public abstract boolean isValid();
}
