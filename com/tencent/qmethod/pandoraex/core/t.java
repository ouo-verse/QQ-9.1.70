package com.tencent.qmethod.pandoraex.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class t {
    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Class<? super Object> superclass;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (method == null && (superclass = cls.getSuperclass()) != null) {
            return a(superclass, str, clsArr);
        }
        return method;
    }

    public static Object b(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method a16 = a(obj.getClass(), str, clsArr);
        Object obj2 = null;
        try {
            if (a16 != null) {
                a16.setAccessible(true);
                obj2 = a16.invoke(obj, objArr);
            } else {
                o.c("ReflectUtils", "Method is not exist");
            }
        } catch (IllegalAccessException e16) {
            o.d("ReflectUtils", "invokeMethod error", e16);
        } catch (InvocationTargetException e17) {
            o.d("ReflectUtils", "invokeMethod error", e17);
        }
        return obj2;
    }
}
