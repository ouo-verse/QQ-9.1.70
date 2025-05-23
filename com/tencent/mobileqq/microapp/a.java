package com.tencent.mobileqq.microapp;

import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppInterface f245815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MiniAppInterface miniAppInterface) {
        this.f245815a = miniAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppInterface);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseApplicationImpl baseApplicationImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Kill process ");
            baseApplicationImpl = this.f245815a.app;
            sb5.append(baseApplicationImpl.getPackageName());
            QLog.d("MiniAppInterface", 2, sb5.toString());
        }
        SystemMethodProxy.killProcess(Process.myPid());
    }
}
