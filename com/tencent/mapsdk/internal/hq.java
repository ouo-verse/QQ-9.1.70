package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hq {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static final Map<Class<?>, Object> f148728a;

        static {
            HashMap hashMap = new HashMap();
            f148728a = hashMap;
            Class cls = Boolean.TYPE;
            Boolean bool = Boolean.FALSE;
            hashMap.put(cls, bool);
            hashMap.put(Boolean.class, bool);
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Byte.class, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Short.class, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Integer.class, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Long.class, 0L);
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Character.class, (char) 0);
            Class cls2 = Float.TYPE;
            Float valueOf = Float.valueOf(0.0f);
            hashMap.put(cls2, valueOf);
            hashMap.put(Float.class, valueOf);
            Class cls3 = Double.TYPE;
            Double valueOf2 = Double.valueOf(0.0d);
            hashMap.put(cls3, valueOf2);
            hashMap.put(Double.class, valueOf2);
            hashMap.put(String.class, "");
        }

        a() {
        }

        static <T> T a(Class<T> cls) {
            return (T) f148728a.get(cls);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(Class<T> cls, Object... objArr) {
        boolean z16;
        if (cls != null && !cls.isEnum() && !cls.isInterface() && !cls.isAnnotation() && !cls.isArray()) {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            for (int i3 = 0; i3 < declaredConstructors.length; i3++) {
                Class<?>[] parameterTypes = declaredConstructors[i3].getParameterTypes();
                if (parameterTypes.length == objArr.length) {
                    int i16 = 0;
                    for (int i17 = 0; i17 < parameterTypes.length; i17++) {
                        if (parameterTypes[i17] == objArr[i17].getClass() || parameterTypes[i17].isAssignableFrom(objArr[i17].getClass())) {
                            i16++;
                        }
                    }
                    if (i16 == parameterTypes.length) {
                        z16 = true;
                        if (!z16) {
                            try {
                                declaredConstructors[i3].setAccessible(true);
                                return (T) declaredConstructors[i3].newInstance(objArr);
                            } catch (IllegalAccessException e16) {
                                LogUtil.c(e16.getMessage(), e16);
                            } catch (InstantiationException e17) {
                                LogUtil.c(e17.getMessage(), e17);
                            } catch (InvocationTargetException e18) {
                                LogUtil.c(e18.getMessage(), e18);
                            }
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e19) {
                LogUtil.c(e19.getMessage(), e19);
            } catch (InstantiationException e26) {
                LogUtil.c(e26.getMessage(), e26);
            }
        }
        return null;
    }

    private static <C> C b(Class<C> cls, String str) {
        return (C) a((Class) cls, str);
    }

    private static <C> C a(Class<C> cls) {
        return (C) a((Class) cls, "\u63a5\u53e3[" + cls + "]\u672a\u5b9e\u73b0\uff0c\u8c03\u7528\u65b9\u6cd5\u90fd\u8fd4\u56de\u9ed8\u8ba4\u503c");
    }

    public static <C> C a(final Class<C> cls, final String str) {
        if (cls.isInterface()) {
            return (C) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tencent.mapsdk.internal.hq.1

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f148725a = null;

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (this.f148725a != null) {
                        method.setAccessible(true);
                        return method.invoke(this.f148725a, objArr);
                    }
                    if (cls != method.getReturnType() && !method.getReturnType().isAssignableFrom(cls) && !cls.isAssignableFrom(method.getReturnType())) {
                        System.out.println(str + "\uff1acall method[" + method.getName() + "(...)->" + method.getReturnType() + "]");
                        return a.a(method.getReturnType());
                    }
                    return obj;
                }
            });
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < clsArr.length; i16++) {
            if (clsArr[i16] == objArr[i16].getClass() || clsArr[i16].isAssignableFrom(objArr[i16].getClass())) {
                i3++;
            }
        }
        return i3 == clsArr.length;
    }

    private static void a(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException e16) {
            LogUtil.c(e16.getMessage(), e16);
        } catch (NoSuchFieldException e17) {
            LogUtil.c(e17.getMessage(), e17);
        }
    }

    public static Object a(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (obj instanceof Class) {
            cls = (Class) obj;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            if (Modifier.isStatic(declaredField.getModifiers())) {
                return declaredField.get(cls);
            }
            return declaredField.get(obj);
        } catch (IllegalAccessException e16) {
            LogUtil.c(e16.getMessage(), e16);
            return null;
        } catch (NoSuchFieldException e17) {
            LogUtil.c(e17.getMessage(), e17);
            return null;
        }
    }

    private static Object a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i3 = 0; i3 < length; i3++) {
            clsArr[i3] = objArr[i3].getClass();
        }
        try {
            Method a16 = a((Class) obj.getClass(), str, clsArr);
            if (a16 != null) {
                a16.setAccessible(true);
                return a16.invoke(obj, objArr);
            }
        } catch (IllegalAccessException e16) {
            LogUtil.c(e16.getMessage(), e16);
        } catch (InvocationTargetException e17) {
            LogUtil.c(e17.getMessage(), e17);
        }
        return null;
    }

    private static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method a16 = a((Class) obj.getClass(), str, clsArr);
            if (a16 != null) {
                a16.setAccessible(true);
                return a16.invoke(obj, objArr);
            }
        } catch (IllegalAccessException e16) {
            LogUtil.c(e16.getMessage(), e16);
        } catch (InvocationTargetException e17) {
            LogUtil.c(e17.getMessage(), e17);
        }
        return null;
    }

    private static Method a(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e16) {
            if (cls.getSuperclass() != Object.class) {
                return a(cls.getSuperclass(), str, clsArr);
            }
            LogUtil.c(e16.getMessage(), e16);
            return null;
        }
    }

    public static Class a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException e16) {
            LogUtil.c(e16.getMessage(), e16);
            return null;
        }
    }

    public static <T> Class<? extends T> a(String str, Class<T> cls, ClassLoader classLoader) {
        try {
            Class<? extends T> cls2 = (Class<? extends T>) Class.forName(str, false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            return null;
        } catch (ClassNotFoundException e16) {
            LogUtil.c(e16.getMessage(), e16);
            return null;
        }
    }
}
