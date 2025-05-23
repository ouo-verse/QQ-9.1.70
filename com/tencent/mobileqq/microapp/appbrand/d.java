package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
final class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f245994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f245994a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.microapp.appbrand.b.h a16 = com.tencent.mobileqq.microapp.appbrand.b.h.a();
        a aVar = this.f245994a;
        a16.a(aVar.f245899d, aVar.f245898c);
        a aVar2 = this.f245994a;
        com.tencent.mobileqq.microapp.app.b.a().a(new b.a(2, aVar2.f245896a, aVar2.f245897b, null));
        if (QLog.isColorLevel()) {
            QLog.i("MiniAppInterface", 2, "\u9875\u9762\u52a0\u8f7d\u5b8c\u6210");
        }
    }
}
