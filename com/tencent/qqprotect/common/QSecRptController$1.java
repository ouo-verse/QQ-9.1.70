package com.tencent.qqprotect.common;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.common.pb.SafeReport$ReqBody;

/* compiled from: P */
/* loaded from: classes25.dex */
class QSecRptController$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f363493d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeReport$ReqBody f363494e;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c.b(this.f363493d, this.f363494e);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
