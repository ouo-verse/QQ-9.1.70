package com.tencent.mobileqq.location.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class GlobalFloatDialogEventReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f241708a;

    public GlobalFloatDialogEventReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a() {
        a aVar = this.f241708a;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d() {
        a aVar = this.f241708a;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void e() {
        a aVar = this.f241708a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            BaseApplication.getContext().unregisterReceiver(this);
        }
    }

    public void c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f241708a = aVar;
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
        BaseApplication.getContext().registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null && intent.getAction() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GlobalFloatDialogEventReceiver", 4, "action: ", intent.getAction());
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(intent.getAction())) {
                d();
                return;
            }
            if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(intent.getAction())) {
                d();
                return;
            }
            if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(intent.getAction())) {
                e();
                return;
            }
            if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(intent.getAction()) || NewIntent.ACTION_ACCOUNT_KICKED.equals(intent.getAction()) || NewIntent.ACTION_ACCOUNT_EXPIRED.equals(intent.getAction()) || NewIntent.ACTION_FORCE_LOGOUT.equals(intent.getAction()) || NewIntent.ACTION_LOGOUT.equals(intent.getAction())) {
                a();
            }
        }
    }
}
