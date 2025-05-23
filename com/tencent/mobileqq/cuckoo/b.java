package com.tencent.mobileqq.cuckoo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Class cls);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(Class cls);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(Class cls);
}
