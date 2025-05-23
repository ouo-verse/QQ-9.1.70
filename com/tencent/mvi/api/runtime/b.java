package com.tencent.mvi.api.runtime;

import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.j;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @MainThread
    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @MainThread
    public abstract ml3.b b();

    @MainThread
    public abstract Fragment c();

    @MainThread
    public abstract LifecycleOwner d();

    @MainThread
    public abstract j e();
}
