package com.tencent.mobileqq.qzonestatus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class QAVBackPressedBeforeEnterQZoneEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public QAVBackPressedBeforeEnterQZoneEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
