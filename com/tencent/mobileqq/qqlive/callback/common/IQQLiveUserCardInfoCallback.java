package com.tencent.mobileqq.qqlive.callback.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.user.UserCardInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class IQQLiveUserCardInfoCallback implements BaseCallback {
    static IPatchRedirector $redirector_;

    public IQQLiveUserCardInfoCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
    public void onFailed(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        }
    }

    public void onSuccess(UserCardInfo userCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) userCardInfo);
        }
    }
}
