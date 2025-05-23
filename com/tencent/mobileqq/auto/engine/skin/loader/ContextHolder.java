package com.tencent.mobileqq.auto.engine.skin.loader;

import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ContextHolder {
    static IPatchRedirector $redirector_;
    private static Context sApplicationContext;

    public ContextHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Context getContext() {
        Context context = sApplicationContext;
        if (context == null) {
            try {
                Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                if (application != null) {
                    sApplicationContext = application;
                    return application;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                Application application2 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
                if (application2 != null) {
                    sApplicationContext = application2;
                    return application2;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            throw new IllegalStateException("ContextHolder is not initialed, it is recommend to init with application context.");
        }
        return context;
    }

    public static void setContext(Context context) {
        sApplicationContext = context;
    }
}
