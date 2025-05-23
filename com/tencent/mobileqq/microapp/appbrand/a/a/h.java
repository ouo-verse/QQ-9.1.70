package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class h implements DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f245940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f245940a = fVar;
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
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ConcurrentLinkedQueue concurrentLinkedQueue2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            return;
        }
        com.tencent.mobileqq.microapp.widget.d dVar = (com.tencent.mobileqq.microapp.widget.d) dialogInterface;
        Bundle a16 = dVar.a();
        if (a16 != null) {
            str = a16.getString("key_event_name");
            str2 = a16.getString("key_params");
        } else {
            str = null;
            str2 = null;
        }
        String d16 = com.tencent.mobileqq.microapp.app.a.d(str, str2);
        boolean b16 = dVar.b();
        boolean c16 = dVar.c();
        if (QLog.isColorLevel()) {
            QLog.d("JsPluginEngine", 2, "onDismiss eventName=" + str + ",permissionName=" + d16 + ",isConfirm=" + b16 + ",isRefuse=" + c16);
        }
        handler = this.f245940a.f245933j;
        Message obtainMessage = handler.obtainMessage(4);
        if (b16) {
            BaseActivity baseActivity = this.f245940a.f245924a.f245899d;
            if (baseActivity == null) {
                obtainMessage.arg1 = 3;
                obtainMessage.obj = d16;
                return;
            } else {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", baseActivity.getPackageName(), null));
                baseActivity.startActivity(intent);
            }
        } else if (c16) {
            obtainMessage.arg1 = 2;
            obtainMessage.obj = d16;
            concurrentLinkedQueue2 = this.f245940a.f245932i;
            concurrentLinkedQueue2.offer((f.a) a16.getSerializable("key_job_info"));
        } else {
            obtainMessage.arg1 = 3;
            obtainMessage.obj = d16;
            concurrentLinkedQueue = this.f245940a.f245932i;
            concurrentLinkedQueue.offer((f.a) a16.getSerializable("key_job_info"));
        }
        obtainMessage.sendToTarget();
        this.f245940a.f245926c = null;
    }
}
