package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NodeEvent {
    static IPatchRedirector $redirector_;
    public String attributes;
    public String eventId;
    public long eventTime;

    public NodeEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.eventId = "";
            this.attributes = "";
        }
    }
}
