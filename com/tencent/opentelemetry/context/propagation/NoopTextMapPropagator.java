package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.e;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
final class NoopTextMapPropagator implements TextMapPropagator {
    static IPatchRedirector $redirector_;
    private static final NoopTextMapPropagator INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new NoopTextMapPropagator();
        }
    }

    NoopTextMapPropagator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TextMapPropagator getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c16, TextMapGetter<C> textMapGetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, this, context, c16, textMapGetter);
        }
        if (context == null) {
            return e.m();
        }
        return context;
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c16, TextMapSetter<C> textMapSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, c16, textMapSetter);
        }
    }
}
