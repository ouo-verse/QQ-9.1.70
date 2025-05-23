package com.tencent.mobileqq.mqq.api.impl;

import com.tencent.mobileqq.adapter.s;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ThreadListenerAdapter implements ThreadExcutor.IThreadListener {
    static IPatchRedirector $redirector_;
    private s mThreadListener;

    ThreadListenerAdapter(s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadListenerAdapter from(s sVar) {
        return new ThreadListenerAdapter(sVar);
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPostRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPreRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
