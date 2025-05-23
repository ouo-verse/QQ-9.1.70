package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.ILog;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class g implements ILog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static g f315304a;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static g a() {
        if (f315304a == null) {
            f315304a = new g();
        }
        return f315304a;
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            QLog.d(str, 2, str2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            QLog.e(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public int getLogLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            QLog.i(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            QLog.w(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            d(str, str2);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            e(str, str2);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            i(str, str2);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void v(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, str, str2, th5);
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            w(str, str2);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, str2, th5);
        }
    }
}
