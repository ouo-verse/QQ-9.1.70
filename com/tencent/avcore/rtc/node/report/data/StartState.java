package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StartState {
    static IPatchRedirector $redirector_;
    public String attributes;
    public int source;
    public long startTime;

    public StartState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.attributes = "";
        }
    }
}
