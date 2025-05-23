package com.tencent.common.app.business;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseZplanAppInterface extends AppInterface {
    static IPatchRedirector $redirector_;

    public BaseZplanAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) str);
        }
    }
}
