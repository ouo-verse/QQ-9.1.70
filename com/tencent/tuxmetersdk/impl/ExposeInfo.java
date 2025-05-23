package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExposeInfo {
    static IPatchRedirector $redirector_;
    private Date exposeTime;

    public ExposeInfo(Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) date);
        } else {
            this.exposeTime = date;
        }
    }

    public Date getExposeTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Date) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.exposeTime;
    }

    public void setExposeTime(Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) date);
        } else {
            this.exposeTime = date;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ExposeInfo{exposeTime=" + Utils.formatDate(this.exposeTime) + '}';
    }
}
