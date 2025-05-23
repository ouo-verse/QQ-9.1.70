package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.ThreadLocalContextStorage;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class j {
    public static Scope a() {
        IPatchRedirector iPatchRedirector = Scope.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Scope) iPatchRedirector.redirect((short) 1);
        }
        return ThreadLocalContextStorage.NoopScope.INSTANCE;
    }
}
