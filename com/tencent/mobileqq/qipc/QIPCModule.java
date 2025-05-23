package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import eipc.EIPCModule;

/* loaded from: classes16.dex */
public abstract class QIPCModule extends EIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final int[] LISTEN_MSGS;
    static final int MSG_ACCOUNT_CHANGE = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            LISTEN_MSGS = new int[]{1};
        }
    }

    public QIPCModule(String str) {
        super(str, LISTEN_MSGS);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public void onAccountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // eipc.EIPCModule
    public void onReceiveMsg(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
            return;
        }
        super.onReceiveMsg(i3, bundle);
        if (i3 == 1) {
            onAccountChange();
        }
    }
}
