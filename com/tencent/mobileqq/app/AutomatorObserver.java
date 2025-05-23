package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AutomatorObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int CACHE_DISCUSS = 3;
    public static final int CACHE_FRIEND = 1;
    public static final int CACHE_TROOP = 2;
    public static final int TYPE_GET_UPDATE_FINISH = 0;
    public static final int TYPE_INIT_CACHE = 3;
    public static final int TYPE_MSG_RECVED = 4;
    public static final int TYPE_START_SECURITY = 2;

    public AutomatorObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void onCacheInited(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    protected void onGetCheckUpdateFin(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onMsgReceived() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected void onStartSecurityScan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        onMsgReceived();
                        return;
                    }
                    return;
                }
                onCacheInited(((Integer) obj).intValue());
                return;
            }
            onStartSecurityScan();
            return;
        }
        onGetCheckUpdateFin(z16, obj);
    }
}
