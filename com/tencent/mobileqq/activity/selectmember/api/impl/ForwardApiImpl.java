package com.tencent.mobileqq.activity.selectmember.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ForwardApiImpl implements IForwardApi {
    static IPatchRedirector $redirector_;

    public ForwardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectmember.api.IForwardApi
    public void startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3), str2);
        } else {
            ForwardSdkBaseOption.E(activity, z16, str, j3, i3, str2);
        }
    }
}
