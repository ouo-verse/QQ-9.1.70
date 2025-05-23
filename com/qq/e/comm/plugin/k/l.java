package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static Constructor a(Class cls, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(clsArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Object a(Constructor constructor, Object... objArr) {
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Method a(Class cls, String str, boolean z16, Class... clsArr) {
        Method method = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            method = z16 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            return method;
        } catch (Exception e16) {
            e16.printStackTrace();
            return method;
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return a(cls, str, true, clsArr);
    }

    public static Object a(Object obj, Method method, boolean z16, Object... objArr) {
        if (obj == null || method == null) {
            return null;
        }
        if (!z16) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        return a(obj, method, true, objArr);
    }

    public static Field a(Class cls, String str, boolean z16) {
        Field field = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            field = z16 ? cls.getField(str) : cls.getDeclaredField(str);
            return field;
        } catch (Exception e16) {
            e16.printStackTrace();
            return field;
        }
    }

    public static Field a(Class cls, String str) {
        return a(cls, str, true);
    }
}
