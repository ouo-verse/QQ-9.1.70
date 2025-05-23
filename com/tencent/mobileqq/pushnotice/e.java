package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.IThirdPushSupport;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e implements IThirdPushSupport {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.IThirdPushSupport
    public int getThirdPushType(Context context, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) bundle)).intValue();
        }
        return ThirdPushManager.getInstance().getThirdPushType();
    }
}
