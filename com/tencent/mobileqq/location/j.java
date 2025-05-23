package com.tencent.mobileqq.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private i f241295a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f241296b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent != null && intent.getIntExtra("pid", Process.myPid()) == Process.myPid() && j.this.f241295a != null) {
                j.this.f241295a.onThemeChanged();
            }
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241296b = new a();
        try {
            BaseApplication.getContext().registerReceiver(this.f241296b, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        } catch (Exception unused) {
            QLog.e("ThemeChangedReceiver", 1, "register receiver error");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            BaseApplication.getContext().unregisterReceiver(this.f241296b);
        } catch (Exception e16) {
            QLog.e("ThemeChangedReceiver", 1, "unInit exception " + e16.getMessage());
        }
    }

    public void c(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
        } else {
            this.f241295a = iVar;
        }
    }
}
