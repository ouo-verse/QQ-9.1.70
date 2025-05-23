package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SkinEngineInitBridge {
    static IPatchRedirector $redirector_;

    public SkinEngineInitBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void init(Context context) throws Exception {
        IPluginAdapterProxy.getProxy().initSkinEngine(context);
    }

    public static void initSkin(Context context) {
        IPluginAdapterProxy.getProxy().initSkin(context);
    }
}
