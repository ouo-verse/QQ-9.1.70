package com.tencent.weiyun.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.data.UserItem;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class FetchUserInfoCallback extends WeiyunCallback {
    static IPatchRedirector $redirector_;

    public FetchUserInfoCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onError(int i3, String str, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.weiyun.callback.WeiyunCallback
    public void onNativeCallback(long j3, int i3, int i16, String str, boolean z16) {
        UserItem newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (i16 == 0) {
            if (j3 == 0) {
                newInstance = null;
            } else {
                newInstance = UserItem.newInstance(j3);
            }
            onSuccess(newInstance, i3);
            return;
        }
        onError(i16, str, i3);
    }

    public abstract void onSuccess(UserItem userItem, int i3);
}
