package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.ImmutableSpanContext;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class e {
    public static byte[] a(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) spanContext);
        }
        return OtelEncodingUtils.bytesFromBase16(spanContext.getSpanId(), SpanId.getLength());
    }

    public static byte[] b(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) spanContext);
        }
        return OtelEncodingUtils.bytesFromBase16(spanContext.getTraceId(), TraceId.getLength());
    }

    public static boolean c(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) spanContext)).booleanValue();
        }
        return spanContext.getTraceFlags().isSampled();
    }

    public static boolean d(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) spanContext)).booleanValue();
        }
        if (TraceId.isValid(spanContext.getTraceId()) && SpanId.isValid(spanContext.getSpanId())) {
            return true;
        }
        return false;
    }

    public static SpanContext e(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanContext) iPatchRedirector.redirect((short) 2, str, str2, traceFlags, traceState);
        }
        return ImmutableSpanContext.create(str, str2, traceFlags, traceState, false, false);
    }

    public static SpanContext f(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpanContext) iPatchRedirector.redirect((short) 3, str, str2, traceFlags, traceState);
        }
        return ImmutableSpanContext.create(str, str2, traceFlags, traceState, true, false);
    }

    public static SpanContext g() {
        IPatchRedirector iPatchRedirector = SpanContext.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpanContext) iPatchRedirector.redirect((short) 1);
        }
        return ImmutableSpanContext.INVALID;
    }
}
