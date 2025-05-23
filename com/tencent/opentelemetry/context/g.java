package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class g {
    public static void a(Function<? super ContextStorage, ? extends ContextStorage> function) {
        IPatchRedirector iPatchRedirector = ContextStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) function);
        } else {
            ContextStorageWrappers.addWrapper(function);
        }
    }

    public static ContextStorage b() {
        IPatchRedirector iPatchRedirector = ContextStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ContextStorage) iPatchRedirector.redirect((short) 2);
        }
        return ThreadLocalContextStorage.INSTANCE;
    }

    public static ContextStorage c() {
        IPatchRedirector iPatchRedirector = ContextStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ContextStorage) iPatchRedirector.redirect((short) 1);
        }
        return LazyStorage.get();
    }
}
