package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements ILog {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void d(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
        } else {
            QLog.d(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void e(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            QLog.e(str, i3, str2);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void i(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
        } else {
            QLog.i(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void v(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
        } else {
            QLog.d(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void w(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
        } else {
            QLog.w(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILog
    public void e(String str, int i3, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            QLog.e(str, i3, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2, th5);
        }
    }
}
