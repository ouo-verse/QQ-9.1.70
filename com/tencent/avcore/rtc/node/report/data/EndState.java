package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EndState {
    static IPatchRedirector $redirector_;
    public String attributes;
    public long endTime;
    public int reason;
    public int statusCode;
    public String statusMsg;

    public EndState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.statusMsg = "";
            this.attributes = "";
        }
    }
}
