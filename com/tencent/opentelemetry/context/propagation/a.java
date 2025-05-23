package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static ContextPropagators a(TextMapPropagator textMapPropagator) {
        IPatchRedirector iPatchRedirector = ContextPropagators.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ContextPropagators) iPatchRedirector.redirect((short) 1, (Object) textMapPropagator);
        }
        Objects.requireNonNull(textMapPropagator, "textPropagator");
        return new DefaultContextPropagators(textMapPropagator);
    }

    public static ContextPropagators b() {
        IPatchRedirector iPatchRedirector = ContextPropagators.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ContextPropagators) iPatchRedirector.redirect((short) 2);
        }
        return DefaultContextPropagators.noop();
    }
}
