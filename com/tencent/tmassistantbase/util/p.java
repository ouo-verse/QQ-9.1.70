package com.tencent.tmassistantbase.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final Object f380494a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f380495b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        a() {
        }
    }

    p(Class<?> cls) {
        this.f380494a = cls;
    }

    public static p a(Class<?> cls) {
        return new p(cls);
    }

    private Field c(String str) {
        Class<?> b16 = b();
        try {
            return (Field) a(b16.getField(str));
        } catch (NoSuchFieldException e16) {
            do {
                try {
                    return (Field) a(b16.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    b16 = b16.getSuperclass();
                    if (b16 == null) {
                        throw new ReflectException(e16);
                    }
                }
            } while (b16 == null);
            throw new ReflectException(e16);
        }
    }

    private static Class<?> d(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public static p f(String str) {
        return a(d(str));
    }

    public p b(String str) {
        try {
            return a(c(str).get(this.f380494a));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    public <T> T e(String str) {
        return (T) b(str).a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f380494a.equals(((p) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f380494a.hashCode();
    }

    public String toString() {
        return this.f380494a.toString();
    }

    public static p a(Object obj) {
        return new p(obj);
    }

    public static <T extends AccessibleObject> T a(T t16) {
        if (t16 == null) {
            return null;
        }
        if (t16 instanceof Member) {
            Member member = (Member) t16;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t16;
            }
        }
        if (!t16.isAccessible()) {
            t16.setAccessible(true);
        }
        return t16;
    }

    p(Object obj) {
        this.f380494a = obj;
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> b16 = b();
        for (Method method : b16.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : b16.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            b16 = b16.getSuperclass();
        } while (b16 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + b() + ".");
    }

    public <T> T a() {
        return (T) this.f380494a;
    }

    public p a(String str) {
        return a(str, new Object[0]);
    }

    public p a(String str, Object... objArr) {
        Class<?>[] a16 = a(objArr);
        try {
            try {
                return a(a(str, a16), this.f380494a, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, a16), this.f380494a, objArr);
            }
        } catch (NoSuchMethodException e16) {
            throw new ReflectException(e16);
        }
    }

    public Class<?> b() {
        if (this.f380495b) {
            return (Class) this.f380494a;
        }
        return this.f380494a.getClass();
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> b16 = b();
        try {
            return b16.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return b16.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    b16 = b16.getSuperclass();
                }
            } while (b16 != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < clsArr2.length; i3++) {
            if (clsArr2[i3] != a.class && !b(clsArr[i3]).isAssignableFrom(b(clsArr2[i3]))) {
                return false;
            }
        }
        return true;
    }

    private static p a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e16) {
            throw new ReflectException(e16);
        }
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            clsArr[i3] = obj == null ? a.class : obj.getClass();
        }
        return clsArr;
    }
}
