package com.tencent.mobileqq.qrscan.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ARMapThreadStubReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public ARMapThreadStubReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Context context, boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ARMapThreadStubReceiver", 2, String.format("notifyARMapThreadStartCompleted preStart=%s", Boolean.valueOf(z16)));
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
        intent.putExtra("pre_start_thread", z16);
        intent.putExtra("from", str);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null) {
            String action = intent.getAction();
            boolean booleanExtra = intent.getBooleanExtra("pre_start_thread", false);
            if (QLog.isColorLevel()) {
                QLog.d("ARMapThreadStubReceiver", 2, String.format("onReceive action=%s preStart=%s", action, Boolean.valueOf(booleanExtra)));
            }
            String stringExtra = intent.getStringExtra("from");
            if ("com.tencent.mobileqq.armap.ACTION_START_THREAD".equals(action)) {
                a(context, booleanExtra, stringExtra);
            }
        }
    }
}
