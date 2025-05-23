package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class MonetModuleRuntimeParams {
    static IPatchRedirector $redirector_ = null;
    public static final String PARAMS_KEY_SURFACE_HEIGHT = "surface_height";
    public static final String PARAMS_KEY_SURFACE_WIDTH = "surface_width";

    public MonetModuleRuntimeParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
