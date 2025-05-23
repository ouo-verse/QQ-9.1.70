package com.xiaomi.push;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f389867a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f389868a;

        /* renamed from: b, reason: collision with root package name */
        public final T f389869b;
    }

    static {
        HashMap hashMap = new HashMap();
        f389867a = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class cls4 = Long.TYPE;
        hashMap.put(Long.class, cls4);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(cls, cls);
        Class cls5 = Byte.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T b(Class<? extends Object> cls, String str) {
        String str2;
        try {
            return (T) a(cls, null, str);
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Meet exception when call getStaticField '");
            sb5.append(str);
            sb5.append("' in ");
            if (cls != null) {
                str2 = cls.getSimpleName();
            } else {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append(", ");
            sb5.append(e16);
            Log.w("JavaCalls", sb5.toString());
            return null;
        }
    }

    public static <T> T c(Class<?> cls, String str, Object... objArr) {
        return (T) h(cls, str, l(objArr)).invoke(null, m(objArr));
    }

    public static <T> T d(Object obj, String str) {
        try {
            return (T) a(obj.getClass(), obj, str);
        } catch (Exception e16) {
            Log.w("JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e16);
            return null;
        }
    }

    public static <T> T e(Object obj, String str, Object... objArr) {
        try {
            return (T) n(obj, str, objArr);
        } catch (Exception e16) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e16);
            return null;
        }
    }

    public static <T> T f(String str, String str2) {
        try {
            return (T) a(ii.c(null, str), null, str2);
        } catch (Exception e16) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e16);
            return null;
        }
    }

    public static <T> T g(String str, String str2, Object... objArr) {
        try {
            return (T) c(ii.c(null, str), str2, objArr);
        } catch (Exception e16) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e16);
            return null;
        }
    }

    private static Method h(Class<?> cls, String str, Class<?>... clsArr) {
        Method i3 = i(cls.getDeclaredMethods(), str, clsArr);
        if (i3 == null) {
            if (cls.getSuperclass() != null) {
                return h(cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        i3.setAccessible(true);
        return i3;
    }

    private static Method i(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && k(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static void j(Object obj, String str, Object obj2) {
        try {
            o(obj, str, obj2);
        } catch (Exception e16) {
            Log.w("JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e16);
        }
    }

    private static boolean k(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            if (clsArr2 == null || clsArr2.length == 0) {
                return true;
            }
            return false;
        }
        if (clsArr2 == null) {
            if (clsArr.length == 0) {
                return true;
            }
            return false;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            Class<?> cls = clsArr2[i3];
            if (cls != null && !clsArr[i3].isAssignableFrom(cls)) {
                Map<Class<?>, Class<?>> map = f389867a;
                if (!map.containsKey(clsArr[i3]) || !map.get(clsArr[i3]).equals(map.get(clsArr2[i3]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Class<?>[] l(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj != null && (obj instanceof a)) {
                clsArr[i3] = ((a) obj).f389868a;
            } else {
                if (obj == null) {
                    cls = null;
                } else {
                    cls = obj.getClass();
                }
                clsArr[i3] = cls;
            }
        }
        return clsArr;
    }

    private static Object[] m(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i3 = 0; i3 < objArr.length; i3++) {
                Object obj = objArr[i3];
                if (obj != null && (obj instanceof a)) {
                    objArr2[i3] = ((a) obj).f389869b;
                } else {
                    objArr2[i3] = obj;
                }
            }
            return objArr2;
        }
        return null;
    }

    public static <T> T n(Object obj, String str, Object... objArr) {
        return (T) h(obj.getClass(), str, l(objArr)).invoke(obj, m(objArr));
    }

    public static void o(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }
}
