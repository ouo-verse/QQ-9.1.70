package com.tencent.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReflectionUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ReflectionUtil";
    private static Method sForName;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            sForName = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "init throw t");
        }
    }

    public ReflectionUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean canReflection() {
        if (sForName != null && sGetDeclaredMethod != null && sGetFieldMethod != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Object getField(@NonNull Object obj, @NonNull String str, @NonNull String str2, Object obj2) {
        if (!canReflection()) {
            return obj2;
        }
        try {
            Field field = (Field) sGetFieldMethod.invoke((Class) sForName.invoke(null, str), str2);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable th5) {
            Log.e(TAG, "getFiled throw t", th5);
            return obj2;
        }
    }

    @Nullable
    public static Method getMethod(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Method method;
        Method method2 = null;
        if (!canReflection()) {
            return null;
        }
        try {
            method = (Method) sGetDeclaredMethod.invoke((Class) sForName.invoke(null, str), str2, clsArr);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            method.setAccessible(true);
            return method;
        } catch (Throwable th6) {
            th = th6;
            method2 = method;
            Log.e(TAG, "getMethod throw t", th);
            return method2;
        }
    }

    public static void invokeMethod(@NonNull Object obj, @NonNull String str, @NonNull String str2, Object... objArr) {
        if (canReflection()) {
            try {
                Method method = (Method) sGetDeclaredMethod.invoke((Class) sForName.invoke(null, str), str2, null);
                method.setAccessible(true);
                method.invoke(obj, objArr);
            } catch (Throwable th5) {
                Log.e(TAG, "invokeMethod throw t", th5);
            }
        }
    }

    public static Object invokeMethodWithArgs(@NonNull Object obj, @NonNull String str, @NonNull String str2, Class[] clsArr, Object... objArr) {
        if (canReflection()) {
            try {
                Method method = (Method) sGetDeclaredMethod.invoke((Class) sForName.invoke(null, str), str2, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (Throwable th5) {
                Log.e(TAG, "invokeMethod throw t", th5);
            }
        }
        return null;
    }

    public static void setFiled(@NonNull Object obj, @NonNull String str, @NonNull String str2, Object obj2) {
        if (canReflection()) {
            try {
                Field field = (Field) sGetFieldMethod.invoke((Class) sForName.invoke(null, str), str2);
                field.setAccessible(true);
                field.set(obj, obj2);
            } catch (Throwable th5) {
                Log.e(TAG, "setFiled throw t", th5);
            }
        }
    }

    @Nullable
    public static Field getField(@NonNull String str, @NonNull String str2) {
        Field field;
        Field field2 = null;
        if (!canReflection()) {
            return null;
        }
        try {
            field = (Field) sGetFieldMethod.invoke((Class) sForName.invoke(null, str), str2);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            field.setAccessible(true);
            return field;
        } catch (Throwable th6) {
            th = th6;
            field2 = field;
            Log.e(TAG, "getFiled throw t", th);
            return field2;
        }
    }
}
