package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class h {
    public static TracerBuilder a(TracerProvider tracerProvider, String str) {
        IPatchRedirector iPatchRedirector = TracerProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 2, (Object) tracerProvider, (Object) str);
        }
        return DefaultTracerBuilder.getInstance();
    }

    public static TracerProvider b() {
        IPatchRedirector iPatchRedirector = TracerProvider.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (TracerProvider) iPatchRedirector.redirect((short) 1);
        }
        return DefaultTracerProvider.getInstance();
    }
}
