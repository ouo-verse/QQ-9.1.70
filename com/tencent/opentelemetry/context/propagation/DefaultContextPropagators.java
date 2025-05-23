package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class DefaultContextPropagators implements ContextPropagators {
    static IPatchRedirector $redirector_;
    private static final ContextPropagators NOOP;
    private final TextMapPropagator textMapPropagator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            NOOP = new DefaultContextPropagators(NoopTextMapPropagator.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultContextPropagators(TextMapPropagator textMapPropagator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) textMapPropagator);
        } else {
            this.textMapPropagator = textMapPropagator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextPropagators noop() {
        return NOOP;
    }

    @Override // com.tencent.opentelemetry.context.propagation.ContextPropagators
    public TextMapPropagator getTextMapPropagator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (TextMapPropagator) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.textMapPropagator;
    }
}
