package com.tencent.freesia;

import androidx.annotation.Nullable;
import com.tencent.freesia.HTTPObserverCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class a {
    @Nullable
    public static HTTPObserverCenter a() {
        IPatchRedirector iPatchRedirector = HTTPObserverCenter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (HTTPObserverCenter) iPatchRedirector.redirect((short) 1);
        }
        return HTTPObserverCenter.CppProxy.getInstance();
    }
}
