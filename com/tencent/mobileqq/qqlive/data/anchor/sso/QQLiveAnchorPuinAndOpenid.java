package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class QQLiveAnchorPuinAndOpenid {
    static IPatchRedirector $redirector_;
    public String pgcOpenid;
    public long pgcPuin;

    public QQLiveAnchorPuinAndOpenid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveAnchorPuinAndOpenid{pgcPuin=" + this.pgcPuin + ", pgcOpenid='" + this.pgcOpenid + "'}";
    }
}
