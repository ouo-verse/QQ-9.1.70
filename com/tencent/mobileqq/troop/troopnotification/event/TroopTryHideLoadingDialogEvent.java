package com.tencent.mobileqq.troop.troopnotification.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTryHideLoadingDialogEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public TroopTryHideLoadingDialogEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
