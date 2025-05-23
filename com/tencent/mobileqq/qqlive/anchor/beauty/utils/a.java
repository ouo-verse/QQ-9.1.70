package com.tencent.mobileqq.qqlive.anchor.beauty.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements ILightLogger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static a f270549a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f270549a = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        if (f270549a == null) {
            f270549a = new a();
        }
        return f270549a;
    }

    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            QLog.d(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            QLog.e(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            QLog.i(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            QLog.i(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            QLog.w(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            QLog.d(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 11, this, str, str2, th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            QLog.e(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            QLog.i(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, th5);
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            QLog.i(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 13, this, str, str2, th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            QLog.w(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, th5);
        }
    }
}
