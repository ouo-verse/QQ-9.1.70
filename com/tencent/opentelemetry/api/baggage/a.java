package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.e;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static boolean a(Baggage baggage) {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) baggage)).booleanValue();
        }
        if (baggage.size() == 0) {
            return true;
        }
        return false;
    }

    public static Context b(Baggage baggage, Context context) {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) baggage, (Object) context);
        }
        return context.with(BaggageContextKey.KEY, baggage);
    }

    public static BaggageBuilder c() {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaggageBuilder) iPatchRedirector.redirect((short) 2);
        }
        return ImmutableBaggage.builder();
    }

    public static Baggage d() {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Baggage) iPatchRedirector.redirect((short) 3);
        }
        return f(e.k());
    }

    public static Baggage e() {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Baggage) iPatchRedirector.redirect((short) 1);
        }
        return ImmutableBaggage.empty();
    }

    public static Baggage f(Context context) {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Baggage) iPatchRedirector.redirect((short) 4, (Object) context);
        }
        Baggage baggage = (Baggage) context.get(BaggageContextKey.KEY);
        if (baggage == null) {
            return e();
        }
        return baggage;
    }

    @Nullable
    public static Baggage g(Context context) {
        IPatchRedirector iPatchRedirector = Baggage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Baggage) iPatchRedirector.redirect((short) 5, (Object) context);
        }
        return (Baggage) context.get(BaggageContextKey.KEY);
    }
}
