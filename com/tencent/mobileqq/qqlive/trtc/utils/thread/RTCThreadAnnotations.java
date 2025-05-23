package com.tencent.mobileqq.qqlive.trtc.utils.thread;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RTCThreadAnnotations {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<a> f273380a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class, Class> f273381b;

    /* compiled from: P */
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes17.dex */
    public @interface ThreadSwitch {
        boolean lockwait() default false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f273382a;

        /* renamed from: b, reason: collision with root package name */
        Map<Integer, Method> f273383b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f273380a = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Boolean.TYPE, Boolean.class);
        f273381b = Collections.unmodifiableMap(hashMap);
    }

    public static String a(Class<?> cls, int i3) {
        Method method;
        Map<Integer, Method> e16 = e(cls);
        if (e16 == null || (method = e16.get(Integer.valueOf(i3))) == null) {
            return "unknown";
        }
        return method.getName();
    }

    public static Method b(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> e16 = e(cls);
        if (e16 == null) {
            return null;
        }
        Iterator<Integer> it = e16.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (e16.get(Integer.valueOf(intValue)).getName().equals(str) && f(e16.get(Integer.valueOf(intValue)), objArr)) {
                return e16.get(Integer.valueOf(intValue));
            }
        }
        return null;
    }

    public static Method c(Class<?> cls, int i3) {
        Map<Integer, Method> e16 = e(cls);
        if (e16 == null) {
            return null;
        }
        return e16.get(Integer.valueOf(i3));
    }

    public static int d(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, Method> e16 = e(cls);
        if (e16 == null) {
            return -1;
        }
        Iterator<Integer> it = e16.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (e16.get(Integer.valueOf(intValue)).getName().equals(str) && f(e16.get(Integer.valueOf(intValue)), objArr)) {
                return intValue;
            }
        }
        return -1;
    }

    private static Map<Integer, Method> e(Class<?> cls) {
        Iterator<a> it = f273380a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f273382a.equals(cls.getName())) {
                return next.f273383b;
            }
        }
        return null;
    }

    private static boolean f(Method method, Object[] objArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (objArr != null && objArr.length != 0) {
            if (parameterTypes.length != objArr.length) {
                return false;
            }
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                Class<?> cls = parameterTypes[i3];
                Object obj = objArr[i3];
                if (obj == null) {
                    if (cls.isPrimitive()) {
                        return false;
                    }
                } else if (!cls.isAssignableFrom(obj.getClass()) && !i(cls, objArr[i3])) {
                    return false;
                }
            }
            return true;
        }
        if (parameterTypes.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean g(Class<?> cls) {
        Iterator<a> it = f273380a.iterator();
        while (it.hasNext()) {
            if (it.next().f273382a.equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h(Class<?> cls, Class<?> cls2, Object obj, Class<?> cls3) {
        if (cls.equals(cls2) && obj.getClass().equals(cls3)) {
            return true;
        }
        return false;
    }

    private static boolean i(Class<?> cls, Object obj) {
        boolean z16 = false;
        if (!cls.isPrimitive()) {
            return false;
        }
        for (Map.Entry<Class, Class> entry : f273381b.entrySet()) {
            z16 |= h(cls, entry.getKey(), obj, entry.getValue());
        }
        return z16;
    }

    public static boolean j(Class<?> cls, int i3) {
        Method method;
        ThreadSwitch threadSwitch;
        Map<Integer, Method> e16 = e(cls);
        if (e16 == null || (method = e16.get(Integer.valueOf(i3))) == null || (threadSwitch = (ThreadSwitch) method.getAnnotation(ThreadSwitch.class)) == null) {
            return false;
        }
        return threadSwitch.lockwait();
    }

    public static boolean k(Class<?> cls, int i3) {
        if (g(cls)) {
            return true;
        }
        HashMap hashMap = new HashMap();
        try {
            for (Method method : cls.getMethods()) {
                if (((ThreadSwitch) method.getAnnotation(ThreadSwitch.class)) != null) {
                    hashMap.put(Integer.valueOf(i3), method);
                    i3++;
                }
            }
            a aVar = new a();
            aVar.f273382a = cls.getName();
            aVar.f273383b = hashMap;
            f273380a.add(aVar);
            return true;
        } catch (Exception unused) {
            hashMap.clear();
            return false;
        }
    }
}
