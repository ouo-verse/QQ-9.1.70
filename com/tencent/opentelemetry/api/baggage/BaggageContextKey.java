package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.ContextKey;
import com.tencent.opentelemetry.context.f;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public class BaggageContextKey {
    static IPatchRedirector $redirector_;
    static final ContextKey<Baggage> KEY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            KEY = f.a("opentelemetry-baggage-key");
        }
    }

    BaggageContextKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
