package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h0 {
    public static Object a(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th5) {
            x0.a("ReflectionUtils", "invokeStatic, error", th5);
            return null;
        }
    }

    public static Object a(String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th5) {
            x0.a("ReflectionUtils", "invokeStatic, error", th5);
            return null;
        }
    }

    public static Object a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th5) {
            x0.a("ReflectionUtils", "instanceFromName, error", th5);
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        return a(obj, str, (Class[]) null, new Object[0]);
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object... objArr) {
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
            x0.a("ReflectionUtils", "invokeInstance, error", th5);
            return null;
        }
    }
}
