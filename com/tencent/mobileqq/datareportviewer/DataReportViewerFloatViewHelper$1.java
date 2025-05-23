package com.tencent.mobileqq.datareportviewer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
class DataReportViewerFloatViewHelper$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            b bVar = this.this$0;
            bVar.f203347h = bVar.h();
        }
    }
}
