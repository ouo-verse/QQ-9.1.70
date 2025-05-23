package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class ProxyObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int EVENT_NONE = -1;
    public static final int EVENT_SAVE_DB_ERROR = 1001;
    public static final int EVENT_SAVE_DB_FINISH = 1000;
    public static final int EVENT_UPDATA_FRIEND_INFO = 2001;
    public static final int EVENT_UPDATA_TROOP_MEMBER = 2000;

    public ProxyObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void notifyEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            if (i3 != 1000) {
                if (i3 == 2000) {
                    onProxyUpdataTroopMember();
                    return;
                }
                return;
            }
            onProxySaveToDbFinished();
        }
    }

    public void onProxySaveToDbError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void onProxySaveToDbFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void onProxyUpdataTroopMember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
