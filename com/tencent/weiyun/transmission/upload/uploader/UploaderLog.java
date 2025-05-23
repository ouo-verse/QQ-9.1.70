package com.tencent.weiyun.transmission.upload.uploader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.ILog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploaderLog implements ILog {
    static IPatchRedirector $redirector_;

    public UploaderLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            TsLog.d(str, str2);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            TsLog.e(str, str2);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public int getLogLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            TsLog.i(str, str2);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            TsLog.v(str, str2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            TsLog.w(str, str2);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            TsLog.d(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            TsLog.e(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            TsLog.i(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void v(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            TsLog.v(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, th5);
        }
    }

    @Override // com.tencent.weiyun.utils.ILog
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            TsLog.w(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 10, this, str, str2, th5);
        }
    }
}
