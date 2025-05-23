package com.tencent.base.api.runtime;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a<T> extends b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Deprecated
    public abstract Activity f();

    @MainThread
    public abstract hx.a g();

    public abstract T h();
}
