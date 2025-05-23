package com.tencent.tmassistantbase.util.t;

import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    protected Object f380522a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f380523b;

    /* renamed from: c, reason: collision with root package name */
    protected HashMap<String, b> f380524c;

    /* compiled from: P */
    /* renamed from: com.tencent.tmassistantbase.util.t.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9996a implements InvocationHandler {
        public C9996a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            System.currentTimeMillis();
            b a16 = a.this.a(method.getName());
            boolean z16 = true;
            try {
                method.setAccessible(true);
                if (a16 != null && a16.b() && !a16.a(a.this.f380522a, method, objArr)) {
                    try {
                        Object b16 = a16.b(a.this.f380522a, method, objArr);
                        a16.a(a.this.f380522a, method, objArr, b16);
                        return b16;
                    } catch (Throwable unused) {
                        if (z16) {
                            return method.invoke(a.this.f380522a, objArr);
                        }
                        return null;
                    }
                }
                return method.invoke(a.this.f380522a, objArr);
            } catch (Throwable unused2) {
                z16 = false;
            }
        }
    }

    public void a(b bVar) {
        if (this.f380524c == null) {
            this.f380524c = new HashMap<>();
        }
        if (bVar == null || TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f380524c.put(bVar.a(), bVar);
    }

    public b a(String str) {
        HashMap<String, b> hashMap = this.f380524c;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public static void a(Class cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length != 0) {
            hashSet.addAll(Arrays.asList(interfaces));
        }
        if (cls.getSuperclass() != Object.class) {
            a(cls.getSuperclass(), hashSet);
        }
    }

    public Object a(Object obj) {
        HashSet hashSet = new HashSet();
        a(obj.getClass(), (HashSet<Class<?>>) hashSet);
        Class[] clsArr = new Class[hashSet.size()];
        hashSet.toArray(clsArr);
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), clsArr, new C9996a());
    }

    public static int a(Object[] objArr, Class<?> cls) {
        if (!a(objArr)) {
            int i3 = -1;
            for (Object obj : objArr) {
                i3++;
                if (obj != null && cls == obj.getClass()) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
