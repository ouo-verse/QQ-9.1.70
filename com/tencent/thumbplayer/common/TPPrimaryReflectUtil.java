package com.tencent.thumbplayer.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.lang.reflect.Method;

/* loaded from: classes26.dex */
public class TPPrimaryReflectUtil {
    private static final String TAG = "TPPrimaryReflectUtil";
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;

    static {
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, th5.getMessage());
        }
    }

    private static boolean checkReflectionAvailable() {
        if (sForNameMethod != null && sGetDeclaredMethod != null && sGetFieldMethod != null) {
            return true;
        }
        return false;
    }

    @Nullable
    private static Method getReflectMethod(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Method method;
        Method method2 = null;
        if (!checkReflectionAvailable()) {
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
            TPLogUtil.e(TAG, th.getMessage());
            return method2;
        }
    }

    public static Object invokeMethod(@NonNull Object obj, @NonNull String str, @NonNull String str2, Class[] clsArr, Object... objArr) {
        try {
            Method reflectMethod = getReflectMethod(str, str2, clsArr);
            if (reflectMethod == null) {
                return null;
            }
            return reflectMethod.invoke(obj, objArr);
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, th5.getMessage());
            return null;
        }
    }
}
