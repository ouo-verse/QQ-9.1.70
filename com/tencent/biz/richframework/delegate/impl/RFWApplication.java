package com.tencent.biz.richframework.delegate.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWApplication {
    private static final String TAG = "RFWApplication";
    private static volatile IApplicationDelegate sApplicationDelegate;
    private static volatile Application sCurrentApplication;
    public static Long sFirstLaunchTimeMillis;
    private static volatile Boolean sIsDebug;

    public static String getAccountId() {
        if (getApplicationDelegate() != null) {
            return getApplicationDelegate().getAccountId();
        }
        return "";
    }

    @NonNull
    public static Application getApplication() {
        if (sCurrentApplication == null) {
            sCurrentApplication = getCurApplication();
        }
        return sCurrentApplication;
    }

    private static IApplicationDelegate getApplicationDelegate() {
        if (sApplicationDelegate == null) {
            synchronized (RFWApplication.class) {
                if (sApplicationDelegate == null) {
                    sApplicationDelegate = (IApplicationDelegate) RFWDelegate.getDelegate(IApplicationDelegate.class);
                }
            }
        }
        return sApplicationDelegate;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0061 A[RETURN] */
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Application getCurApplication() {
        Application application;
        Exception e16;
        Application application2;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            application = (Application) declaredMethod.invoke(null, new Object[0]);
            try {
                RFWLog.i(TAG, RFWLog.USR, "curApp class1:" + application);
            } catch (Exception e17) {
                e = e17;
                RFWLog.e(TAG, RFWLog.USR, "getCurApplication e:" + e.getMessage(), e);
                if (application == null) {
                }
            }
        } catch (Exception e18) {
            e = e18;
            application = null;
        }
        if (application == null) {
            return application;
        }
        try {
            Method declaredMethod2 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
            declaredMethod2.setAccessible(true);
            application2 = (Application) declaredMethod2.invoke(null, new Object[0]);
            try {
                RFWLog.i(TAG, RFWLog.USR, "curApp class2:" + application2);
            } catch (Exception e19) {
                e16 = e19;
                RFWLog.e(TAG, RFWLog.USR, "getCurApplication e:" + e16.getMessage(), e16);
                return application2;
            }
        } catch (Exception e26) {
            Application application3 = application;
            e16 = e26;
            application2 = application3;
        }
        return application2;
    }

    public static boolean isDebug() {
        boolean z16;
        try {
            if (sIsDebug != null) {
                return sIsDebug.booleanValue();
            }
            ApplicationInfo applicationInfo = getApplication().getApplicationInfo();
            if (applicationInfo == null) {
                return false;
            }
            if ((applicationInfo.flags & 2) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            sIsDebug = Boolean.valueOf(z16);
            return sIsDebug.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isPublicVersion() {
        if (getApplicationDelegate() != null) {
            return getApplicationDelegate().isPublicVersion();
        }
        return !isDebug();
    }

    public static void setCurrentApplication(Application application) {
        sCurrentApplication = application;
    }
}
