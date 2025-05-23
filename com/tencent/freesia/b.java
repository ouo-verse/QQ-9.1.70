package com.tencent.freesia;

import androidx.annotation.Nullable;
import com.tencent.freesia.MSFObserverCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class b {
    @Nullable
    public static MSFObserverCenter a() {
        IPatchRedirector iPatchRedirector = MSFObserverCenter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (MSFObserverCenter) iPatchRedirector.redirect((short) 1);
        }
        return MSFObserverCenter.CppProxy.getInstance();
    }
}
