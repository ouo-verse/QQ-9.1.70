package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes22.dex */
public class DefaultTracerProvider implements TracerProvider {
    static IPatchRedirector $redirector_;
    private static final TracerProvider INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new DefaultTracerProvider();
        }
    }

    DefaultTracerProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TracerProvider getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) ? DefaultTracer.getInstance() : (Tracer) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public /* synthetic */ TracerBuilder tracerBuilder(String str) {
        return h.a(this, str);
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? DefaultTracer.getInstance() : (Tracer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
    }
}
