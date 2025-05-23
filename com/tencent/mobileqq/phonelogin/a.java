package com.tencent.mobileqq.phonelogin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f258511b;

    /* renamed from: c, reason: collision with root package name */
    private static a f258512c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f258513a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f258511b = new byte[0];
            f258512c = null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258513a = false;
        }
    }

    public static a a() {
        if (f258512c == null) {
            synchronized (f258511b) {
                if (f258512c == null) {
                    f258512c = new a();
                }
            }
        }
        return f258512c;
    }

    public boolean b(AppRuntime appRuntime, String str) {
        WtloginManager wtloginManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (appRuntime == null || (wtloginManager = (WtloginManager) appRuntime.getManager(1)) == null) {
            return true;
        }
        boolean hasPwd = wtloginManager.getHasPwd(str);
        if (QLog.isColorLevel()) {
            QLog.d("sp", 2, "getHasPwd return uin=" + str + " ret = " + hasPwd);
        }
        return hasPwd;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f258513a;
    }

    public void d(AppRuntime appRuntime, String str, boolean z16) {
        WtloginManager wtloginManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, str, Boolean.valueOf(z16));
        } else {
            if (appRuntime == null || (wtloginManager = (WtloginManager) appRuntime.getManager(1)) == null) {
                return;
            }
            wtloginManager.setHasPwd(str, z16);
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f258513a = z16;
        }
    }
}
