package com.tencent.tedger.resource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.resource.ResourceManagerImp;

/* compiled from: P */
/* loaded from: classes26.dex */
class ResourceManagerImp$6$1$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ResourceManagerImp.AnonymousClass6.a f375298d;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ResourceManagerImp.AnonymousClass6.this.f375297d.release();
        }
    }
}
