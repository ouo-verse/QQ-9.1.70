package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f245843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f245843a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            bArr = this.f245843a.f245838b;
            synchronized (bArr) {
                a aVar = this.f245843a;
                str = aVar.f245837a;
                QWalletTools.saveObject(aVar, str);
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
