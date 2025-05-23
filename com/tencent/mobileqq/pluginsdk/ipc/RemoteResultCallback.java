package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class RemoteResultCallback extends RemoteCallback.Stub {
    static IPatchRedirector $redirector_;

    public RemoteResultCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onCallback(Bundle bundle);

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback
    public final void onRemoteCallback(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        onCallback(bundle);
    }
}
