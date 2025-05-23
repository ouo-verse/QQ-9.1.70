package com.tencent.hydevteam.pluginframework.pluginloader.exceptions;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@API
/* loaded from: classes7.dex */
public class DynamicPluginLoaderLoadException extends Exception {
    static IPatchRedirector $redirector_;

    public DynamicPluginLoaderLoadException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    public DynamicPluginLoaderLoadException(Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
    }
}
