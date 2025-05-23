package com.tencent.mobileqq.qqlive.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a implements BaseCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseSsoCallback";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onBusinessFailed(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "sso call back fail [business error] " + i3 + " error msg " + str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
    public void onFailed(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "sso call back fail [proxy error]" + i3 + " error msg " + str);
        }
    }

    public abstract void onProxyRequestSuccess(int i3, h hVar) throws InvalidProtocolBufferNanoException;
}
