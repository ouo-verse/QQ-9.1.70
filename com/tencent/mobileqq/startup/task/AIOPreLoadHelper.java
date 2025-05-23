package com.tencent.mobileqq.startup.task;

import androidx.annotation.Keep;
import com.tencent.aio.pref.annotation.AIOPreLoad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@AIOPreLoad
@Keep
/* loaded from: classes18.dex */
public class AIOPreLoadHelper {
    static IPatchRedirector $redirector_;

    public AIOPreLoadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
