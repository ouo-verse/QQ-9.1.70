package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@API
/* loaded from: classes7.dex */
public class LoadPluginException extends Exception {
    static IPatchRedirector $redirector_;

    public LoadPluginException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    public LoadPluginException(Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
    }

    public LoadPluginException(String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) th5);
    }
}
