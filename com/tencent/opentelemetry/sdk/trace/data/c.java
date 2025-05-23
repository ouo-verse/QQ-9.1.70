package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    public static String a(SpanData spanData) {
        IPatchRedirector iPatchRedirector = SpanData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) spanData);
        }
        return spanData.getParentSpanContext().getSpanId();
    }

    public static String b(SpanData spanData) {
        IPatchRedirector iPatchRedirector = SpanData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) spanData);
        }
        return spanData.getSpanContext().getSpanId();
    }

    public static String c(SpanData spanData) {
        IPatchRedirector iPatchRedirector = SpanData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) spanData);
        }
        return spanData.getSpanContext().getTraceId();
    }
}
