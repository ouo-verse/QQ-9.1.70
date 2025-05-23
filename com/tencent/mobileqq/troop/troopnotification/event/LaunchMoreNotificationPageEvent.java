package com.tencent.mobileqq.troop.troopnotification.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class LaunchMoreNotificationPageEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public LaunchMoreNotificationPageEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
