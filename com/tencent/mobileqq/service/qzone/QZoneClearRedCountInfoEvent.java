package com.tencent.mobileqq.service.qzone;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneClearRedCountInfoEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    public int mCountId;

    public QZoneClearRedCountInfoEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.mCountId = i3;
        }
    }
}
