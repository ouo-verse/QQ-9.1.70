package com.tencent.intervideo.nowproxy;

import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HostLog {
    static IPatchRedirector $redirector_;
    public static HostLog sInstance;
    private CustomizedLog mCustomizedLog;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sInstance = new HostLog();
        }
    }

    public HostLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void flushLogs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onFlushLogs();
        }
    }

    public HostLog getInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HostLog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sInstance;
    }

    public void log(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onLog(i3, str, str2);
        }
    }

    public void setCustomizedLog(CustomizedLog customizedLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) customizedLog);
        } else {
            this.mCustomizedLog = customizedLog;
        }
    }

    public void uploadLogs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onUploadLogs();
        }
    }
}
