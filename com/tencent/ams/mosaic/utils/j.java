package com.tencent.ams.mosaic.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class j {
    static IPatchRedirector $redirector_;

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th5) {
            f.c(ReflectionUtil.TAG, "Exception ", th5);
            return null;
        }
    }

    public static Field b(Class cls, String str, boolean z16) {
        Field declaredField;
        Field field = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (z16) {
                declaredField = cls.getField(str);
            } else {
                declaredField = cls.getDeclaredField(str);
            }
            field = declaredField;
            return field;
        } catch (Exception e16) {
            f.c(ReflectionUtil.TAG, "Exception ", e16);
            return field;
        }
    }

    public static Method c(Class cls, String str, boolean z16, Class... clsArr) {
        Method declaredMethod;
        Method method = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (z16) {
                declaredMethod = cls.getMethod(str, clsArr);
            } else {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            }
            method = declaredMethod;
            return method;
        } catch (Exception e16) {
            f.c(ReflectionUtil.TAG, "Exception ", e16);
            return method;
        }
    }

    public static Object d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            f.c(ReflectionUtil.TAG, "Exception ", e16);
            return null;
        }
    }

    public static Field e(Class cls, String str) {
        return b(cls, str, true);
    }

    public static Method f(Class cls, String str, Class... clsArr) {
        return c(cls, str, true, clsArr);
    }

    public static Object g(Object obj, Method method, boolean z16, Object... objArr) {
        if (obj == null || method == null) {
            return null;
        }
        if (!z16) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (Exception e16) {
                f.c(ReflectionUtil.TAG, "Exception ", e16);
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object h(Object obj, Method method, Object... objArr) {
        return g(obj, method, true, objArr);
    }

    public static boolean i(Field field, Object obj, boolean z16, Object obj2) {
        if (field != null && obj != null) {
            if (!z16) {
                try {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                } catch (Exception e16) {
                    f.c(ReflectionUtil.TAG, "Exception ", e16);
                }
            }
            field.set(obj, obj2);
            return true;
        }
        return false;
    }

    public static boolean j(Field field, Object obj, Object obj2) {
        return i(field, obj, true, obj2);
    }
}
