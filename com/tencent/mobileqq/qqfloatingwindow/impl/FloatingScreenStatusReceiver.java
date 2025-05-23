package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import gh2.f;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FloatingScreenStatusReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static int f264350e;

    /* renamed from: a, reason: collision with root package name */
    private Context f264351a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f264352b;

    /* renamed from: c, reason: collision with root package name */
    private f f264353c;

    /* renamed from: d, reason: collision with root package name */
    private int f264354d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f264350e = MobileQQ.sProcessId;
        }
    }

    public FloatingScreenStatusReceiver(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f264352b = false;
        this.f264351a = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.mobileqq.floatingscreen.statuschange");
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        QLog.d("FSReceiver", 1, "registerReceiver " + hashCode());
        this.f264351a.getApplicationContext().registerReceiver(this, intentFilter);
    }

    private boolean b(int i3) {
        if (i3 != -1 && i3 != this.f264354d) {
            return false;
        }
        return true;
    }

    public void a(int i3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) fVar);
        } else {
            this.f264354d = i3;
            this.f264353c = fVar;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            QLog.d("FSReceiver", 1, "unregisterReceiver " + hashCode());
            this.f264351a.getApplicationContext().unregisterReceiver(this);
        } catch (Exception e16) {
            QLog.e("FSReceiver", 1, "unregisterReceiver Exception : ", e16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null && intent.getAction() != null) {
            boolean z16 = true;
            if (QLog.isColorLevel()) {
                QLog.d("FSReceiver", 4, "action: ", intent.getAction());
            }
            if ("tencent.mobileqq.floatingscreen.statuschange".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("param_concern_floating_type", -1);
                if (!b(intExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FSReceiver", 2, "type not available, concern:", Integer.valueOf(intExtra), " ,curr:", Integer.valueOf(this.f264354d));
                        return;
                    }
                    return;
                }
                int intExtra2 = intent.getIntExtra("param_curr_window_status", 0);
                int intExtra3 = intent.getIntExtra("param_busitype", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("FSReceiver", 2, "busiType:", Integer.valueOf(intExtra3), " ,status:", Integer.valueOf(intExtra2), " ,hide:", Boolean.valueOf(this.f264352b));
                }
                if (intent.hasExtra("param_ignored_processid") && f264350e == intent.getIntExtra("param_ignored_processid", -1)) {
                    return;
                }
                switch (intExtra2) {
                    case 102:
                        this.f264353c.a();
                        this.f264352b = true;
                        return;
                    case 103:
                        this.f264353c.d(true);
                        this.f264352b = false;
                        return;
                    case 104:
                        this.f264353c.b();
                        return;
                    default:
                        return;
                }
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(intent.getAction())) {
                this.f264353c.c();
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(intent.getAction())) {
                this.f264353c.e();
                return;
            }
            if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(intent.getAction())) {
                this.f264353c.a();
                return;
            }
            if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("process_name");
                if (stringExtra == null || !stringExtra.contains(ProcessConstant.OPEN_SDK)) {
                    z16 = false;
                }
                if (!z16 && !this.f264352b) {
                    this.f264353c.d(false);
                    return;
                }
                return;
            }
            if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(intent.getAction()) || NewIntent.ACTION_ACCOUNT_KICKED.equals(intent.getAction()) || NewIntent.ACTION_ACCOUNT_EXPIRED.equals(intent.getAction()) || NewIntent.ACTION_FORCE_LOGOUT.equals(intent.getAction()) || NewIntent.ACTION_LOGOUT.equals(intent.getAction())) {
                int intExtra4 = intent.getIntExtra("type", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("FSReceiver", 2, "cnrType=" + intExtra4 + " action=" + intent.getAction());
                }
                this.f264353c.b();
            }
        }
    }
}
