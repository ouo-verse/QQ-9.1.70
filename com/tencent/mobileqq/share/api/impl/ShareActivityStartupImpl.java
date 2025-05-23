package com.tencent.mobileqq.share.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.share.api.IShareActivityStartup;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShareActivityStartupImpl implements IShareActivityStartup {
    static IPatchRedirector $redirector_;

    public ShareActivityStartupImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.share.api.IShareActivityStartup
    public void gotoShareActivity(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        } else {
            ScreenShotHelper.f(context, str, false);
        }
    }
}
