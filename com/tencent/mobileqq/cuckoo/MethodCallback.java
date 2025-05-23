package com.tencent.mobileqq.cuckoo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class MethodCallback extends a {
    static IPatchRedirector $redirector_;

    public MethodCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void methodCallbackEntry(String str, String str2, String str3, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void methodCallbackExit(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void methodCallbackExitThrowable(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] methodCallbackSetArgs(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Object[]) iPatchRedirector.redirect((short) 7, (Object) this, (Object) objArr);
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object methodCallbackSetResult(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, obj);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void methodCallbackEntry(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void methodCallbackEntry(Object[] objArr, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) objArr, obj);
    }
}
