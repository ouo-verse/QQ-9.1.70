package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class g {
    public static TraceStateBuilder a() {
        IPatchRedirector iPatchRedirector = TraceState.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TraceStateBuilder) iPatchRedirector.redirect((short) 2);
        }
        return new ArrayBasedTraceStateBuilder();
    }

    public static TraceState b() {
        IPatchRedirector iPatchRedirector = TraceState.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (TraceState) iPatchRedirector.redirect((short) 1);
        }
        return ArrayBasedTraceStateBuilder.empty();
    }
}
