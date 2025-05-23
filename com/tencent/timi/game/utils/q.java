package com.tencent.timi.game.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static String f380310a = "ReflectionUtils";

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Method b(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        l.e(f380310a, "no such method " + str);
        return null;
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr) {
        return d(obj, str, clsArr, null);
    }

    public static Object d(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method b16 = b(obj, str, clsArr);
        if (b16 != null) {
            try {
                b16.setAccessible(true);
                if (objArr == null) {
                    return b16.invoke(obj, new Object[0]);
                }
                return b16.invoke(obj, objArr);
            } catch (IllegalAccessException e16) {
                l.f(f380310a, e16.toString(), e16);
                return null;
            } catch (IllegalArgumentException e17) {
                l.f(f380310a, e17.toString(), e17);
                return null;
            } catch (InvocationTargetException e18) {
                l.f(f380310a, e18.toString(), e18);
                return null;
            } catch (Exception e19) {
                l.f(f380310a, e19.toString(), e19);
                return null;
            }
        }
        return null;
    }

    public static Object e(Class cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (IllegalAccessException e16) {
            l.f(f380310a, e16.toString(), e16);
            return null;
        } catch (IllegalArgumentException e17) {
            l.f(f380310a, e17.toString(), e17);
            return null;
        } catch (InvocationTargetException e18) {
            l.f(f380310a, e18.toString(), e18);
            return null;
        } catch (Exception e19) {
            l.f(f380310a, e19.toString(), e19);
            return null;
        }
    }

    public static void f(Object obj, String str, Object obj2) {
        Field a16 = a(obj, str);
        if (a16 != null) {
            try {
                a16.setAccessible(true);
                if (a16.getType().equals(Integer.TYPE) && (obj2 instanceof Long)) {
                    a16.set(obj, Integer.valueOf(((Long) obj2).intValue()));
                } else {
                    a16.set(obj, obj2);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
