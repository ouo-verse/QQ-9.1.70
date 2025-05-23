package com.tencent.bugly.common.utils;

import android.app.Application;
import android.content.Context;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ContextUtil {
    private static final String TAG = "CrashReport";
    private static Context sContext;

    private static Context getContextFromAppGlobal() {
        Application application;
        Object th5;
        try {
            Method declaredMethod = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            application = (Application) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th6) {
            application = null;
            th5 = th6;
        }
        try {
            Logger.f365497g.i(TAG, "fetch getInitialApplication: " + application);
        } catch (Throwable th7) {
            th5 = th7;
            Logger.f365497g.e(TAG, "fetch getInitialApplication error " + th5);
            return application;
        }
        return application;
    }

    private static Context getContextFromThread() {
        Application application;
        Object th5;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            application = (Application) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th6) {
            application = null;
            th5 = th6;
        }
        try {
            Logger.f365497g.i(TAG, "fetch currentApplication: " + application);
        } catch (Throwable th7) {
            th5 = th7;
            Logger.f365497g.e(TAG, "fetch currentApplication error " + th5);
            return application;
        }
        return application;
    }

    public static Context getGlobalContext() {
        Context context = sContext;
        if (context == null) {
            Context contextFromThread = getContextFromThread();
            sContext = contextFromThread;
            if (contextFromThread == null) {
                sContext = getContextFromAppGlobal();
            }
        } else if (!(context instanceof Application)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = sContext;
            }
            sContext = applicationContext;
        }
        return sContext;
    }

    public static void setGlobalContext(Context context) {
        if (context != null) {
            if (context instanceof Application) {
                sContext = context;
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            sContext = context;
        }
    }
}
