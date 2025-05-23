package com.tencent.shadow.core.runtime.skin.loader;

import android.app.Application;
import android.content.Context;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ContextHolder {
    private static Context sApplicationContext;

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
