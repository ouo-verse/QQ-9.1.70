package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class i implements DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f245941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f245941a = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        String str;
        String str2;
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            return;
        }
        com.tencent.mobileqq.microapp.widget.d dVar = (com.tencent.mobileqq.microapp.widget.d) dialogInterface;
        Bundle a16 = dVar.a();
        if (a16 != null) {
            str2 = a16.getString("key_event_name");
            str = a16.getString("key_params");
        } else {
            str = null;
            str2 = null;
        }
        String c16 = com.tencent.mobileqq.microapp.app.a.c(str2, str);
        boolean b16 = dVar.b();
        boolean c17 = dVar.c();
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "onDismiss eventName=" + str2 + ",scopeName=" + c16 + ",isConfirm=" + b16 + ",isRefuse=" + c17);
        }
        handler = this.f245941a.f245933j;
        Message obtainMessage = handler.obtainMessage(1);
        if (b16) {
            obtainMessage.arg1 = 1;
            this.f245941a.f245925b.a(c16, true);
        } else if (c17) {
            obtainMessage.arg1 = 2;
            obtainMessage.obj = c16;
            this.f245941a.f245925b.a(c16, false);
        } else {
            obtainMessage.arg1 = 3;
            obtainMessage.obj = c16;
        }
        obtainMessage.sendToTarget();
        this.f245941a.f245926c = null;
    }
}
