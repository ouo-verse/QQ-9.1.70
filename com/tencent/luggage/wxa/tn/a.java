package com.tencent.luggage.wxa.tn;

import android.app.Application;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Application f141521a;

    /* renamed from: b, reason: collision with root package name */
    public static Application f141522b;

    public static synchronized Application a() {
        synchronized (a.class) {
            Application application = f141521a;
            if (application != null) {
                return application;
            }
            Application application2 = f141522b;
            if (application2 != null) {
                return application2;
            }
            Application b16 = b();
            f141522b = b16;
            if (b16 != null) {
                return b16;
            }
            throw new IllegalStateException("Please make sure you do not call Applications#context() before or inside Application#attachBaseContext(Context). If you have to, please call Applications#attach(Application) first.");
        }
    }

    public static Application b() {
        try {
            Method declaredMethod = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Application) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e16) {
            try {
                Method declaredMethod2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
                declaredMethod2.setAccessible(true);
                return (Application) declaredMethod2.invoke(null, new Object[0]);
            } catch (Exception e17) {
                w.f("MicroMsg.sdk.ApplicationGlobal", "get activity thread fail, error = " + e16.getMessage() + " & " + e17.getMessage());
                return null;
            }
        }
    }

    public static synchronized void a(Application application) {
        synchronized (a.class) {
            if (f141521a == null) {
                f141521a = application;
            }
        }
    }
}
