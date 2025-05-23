package com.tencent.offline.utils;

import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
class OfflineSecurity$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f339490d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f339491e;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadCenter.postDefaultUITask(new Runnable(b.h(this.f339490d, this.f339491e)) { // from class: com.tencent.offline.utils.OfflineSecurity$1.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f339492d;

                {
                    this.f339492d = r6;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, OfflineSecurity$1.this, Boolean.valueOf(r6));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        OfflineSecurity$1.this.getClass();
                    }
                }
            });
        }
    }
}
