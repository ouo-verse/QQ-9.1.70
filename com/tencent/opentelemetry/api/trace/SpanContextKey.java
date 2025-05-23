package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.ContextKey;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class SpanContextKey {
    static IPatchRedirector $redirector_;
    static final ContextKey<Span> KEY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            KEY = com.tencent.opentelemetry.context.f.a("opentelemetry-trace-span-key");
        }
    }

    SpanContextKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
