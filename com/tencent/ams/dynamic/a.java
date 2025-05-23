package com.tencent.ams.dynamic;

import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements DLog.LogSupport {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, str2, th5);
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            QLog.e(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            QLog.i(str, 2, str2);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            QLog.d(str, 2, str2);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            QLog.w(str, 1, str2);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        d(str, str2, null);
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            QLog.e(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 11, this, str, str2, th5);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            QLog.i(str, 2, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void v(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            QLog.d(str, 2, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, th5);
        }
    }

    @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            QLog.w(str, 1, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, th5);
        }
    }
}
