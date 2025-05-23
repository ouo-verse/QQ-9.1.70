package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedpointObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int NOTIFY_DATA_CHANGE = 3;
    public static final int NOTIFY_LEBA_REDTOUCH = 4;

    public RedpointObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onDataChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    public void onNotifyLebaRedTouch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            if (i3 != 3) {
                if (i3 == 4) {
                    onNotifyLebaRedTouch(z16);
                    return;
                }
                return;
            }
            onDataChange(z16);
        }
    }
}
