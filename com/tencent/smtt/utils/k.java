package com.tencent.smtt.utils;

import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes25.dex */
public class k {
    public static Object a(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        return a(obj, str, (Class<?>[]) null, new Object[0]);
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th5) {
            if (th5.getCause() != null && th5.getCause().toString().contains("AuthenticationFail")) {
                return new String("AuthenticationFail");
            }
            if ("queryLicense".equals(str)) {
                return "current x5 not support";
            }
            if (str != null) {
                if (!str.equalsIgnoreCase("canLoadX5Core") && !str.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                    if (str.equalsIgnoreCase("authenticateX5") || str.equalsIgnoreCase("isLicenseUpdateNeeded")) {
                        TbsLog.i("ReflectionUtils", "current X5 not support authenticate API");
                    }
                }
                return null;
            }
            TbsLog.i("ReflectionUtils", "invokeInstance -- exceptions:" + Log.getStackTraceString(th5));
            return null;
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class && cls != null; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
