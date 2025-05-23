package com.tencent.mobileqq.signature.pay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class SignPayEventReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f288431a;

    public SignPayEventReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288431a = null;
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f288431a = aVar;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        MobileQQ.sMobileQQ.peekAppRuntime().getApplication().registerReceiver(this, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            MobileQQ.sMobileQQ.peekAppRuntime().getApplication().unregisterReceiver(this);
            this.f288431a = null;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[ADDED_TO_REGION] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (!intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("data");
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantEventReceiver", 2, "checkDispatchEvent event:" + stringExtra + " dataStr:" + stringExtra2);
        }
        if (this.f288431a == null) {
            return;
        }
        try {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -829587912) {
                if (hashCode == 1093579329 && stringExtra.equals("openBeautyPaySuccess")) {
                    c16 = 0;
                    if (c16 != 0 || c16 == 1) {
                        this.f288431a.onPaySuccess();
                        return;
                    }
                    return;
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
                this.f288431a.onPaySuccess();
                return;
            }
            if (stringExtra.equals("vipPaySuccess")) {
                c16 = 1;
                if (c16 != 0) {
                }
                this.f288431a.onPaySuccess();
                return;
            }
            c16 = '\uffff';
            if (c16 != 0) {
            }
            this.f288431a.onPaySuccess();
            return;
        } catch (Throwable th5) {
            QLog.e("AvatarPendantEventReceiver", 1, th5, new Object[0]);
        }
        QLog.e("AvatarPendantEventReceiver", 1, th5, new Object[0]);
    }
}
