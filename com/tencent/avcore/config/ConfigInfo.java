package com.tencent.avcore.config;

import android.content.Context;
import com.tencent.avcore.jni.config.ConfigInfoJni;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ConfigInfo extends ConfigInfoJni {
    static IPatchRedirector $redirector_;
    private static volatile ConfigInfo instance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            instance = null;
        }
    }

    ConfigInfo(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public static ConfigInfo instance(Context context) {
        if (instance == null) {
            synchronized (ConfigInfo.class) {
                if (instance == null) {
                    try {
                        try {
                            instance = new ConfigInfo(context);
                        } catch (Error e16) {
                            instance = null;
                            e16.printStackTrace();
                        }
                    } catch (Exception e17) {
                        instance = null;
                        e17.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
