package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes27.dex */
abstract class TuxSoftTask<T> implements Runnable {
    static IPatchRedirector $redirector_;
    private final SoftReference<T> mRef;

    /* JADX INFO: Access modifiers changed from: protected */
    public TuxSoftTask(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
        } else {
            this.mRef = new SoftReference<>(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getRef() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRef.get();
    }
}
