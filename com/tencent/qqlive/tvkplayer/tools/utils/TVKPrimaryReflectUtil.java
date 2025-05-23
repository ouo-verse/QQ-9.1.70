package com.tencent.qqlive.tvkplayer.tools.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* loaded from: classes23.dex */
public class TVKPrimaryReflectUtil {
    public static final String TAG = "TVKPlayer[ReflectionUtil]";
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;

    static {
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, th5.getMessage());
        }
    }

    private static boolean canReflection() {
        if (sForNameMethod != null && sGetDeclaredMethod != null && sGetFieldMethod != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Method getMethod(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Method method;
        Method method2 = null;
        if (!canReflection()) {
            return null;
        }
        try {
            method = (Method) sGetDeclaredMethod.invoke((Class) sForNameMethod.invoke(null, str), str2, clsArr);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            method.setAccessible(true);
            return method;
        } catch (Throwable th6) {
            th = th6;
            method2 = method;
            TVKLogUtil.e(TAG, th.getMessage());
            return method2;
        }
    }

    public static Object invokeMethod(@NonNull Object obj, @NonNull String str, @NonNull String str2, Class[] clsArr, Object... objArr) {
        try {
            Method method = getMethod(str, str2, clsArr);
            if (method == null) {
                return null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, th5.getMessage());
            return null;
        }
    }
}
