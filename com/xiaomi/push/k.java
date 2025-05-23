package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class k implements j, InvocationHandler {

    /* renamed from: o, reason: collision with root package name */
    private static final String[][] f389429o = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: j, reason: collision with root package name */
    private Context f389439j;

    /* renamed from: a, reason: collision with root package name */
    private Class f389430a = null;

    /* renamed from: b, reason: collision with root package name */
    private Class f389431b = null;

    /* renamed from: c, reason: collision with root package name */
    private Method f389432c = null;

    /* renamed from: d, reason: collision with root package name */
    private Method f389433d = null;

    /* renamed from: e, reason: collision with root package name */
    private Method f389434e = null;

    /* renamed from: f, reason: collision with root package name */
    private Method f389435f = null;

    /* renamed from: g, reason: collision with root package name */
    private Method f389436g = null;

    /* renamed from: h, reason: collision with root package name */
    private Method f389437h = null;

    /* renamed from: i, reason: collision with root package name */
    private Method f389438i = null;

    /* renamed from: k, reason: collision with root package name */
    private final Object f389440k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private volatile int f389441l = 0;

    /* renamed from: m, reason: collision with root package name */
    private volatile long f389442m = 0;

    /* renamed from: n, reason: collision with root package name */
    private volatile b f389443n = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        Boolean f389444a;

        /* renamed from: b, reason: collision with root package name */
        String f389445b;

        /* renamed from: c, reason: collision with root package name */
        String f389446c;

        /* renamed from: d, reason: collision with root package name */
        String f389447d;

        /* renamed from: e, reason: collision with root package name */
        String f389448e;

        b() {
            this.f389444a = null;
            this.f389445b = null;
            this.f389446c = null;
            this.f389447d = null;
            this.f389448e = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f389445b) || !TextUtils.isEmpty(this.f389446c) || !TextUtils.isEmpty(this.f389447d) || !TextUtils.isEmpty(this.f389448e)) {
                this.f389444a = Boolean.TRUE;
            }
            if (this.f389444a != null) {
                return true;
            }
            return false;
        }
    }

    public k(Context context) {
        this.f389439j = context.getApplicationContext();
        e(context);
        h(context);
    }

    private static <T> T b(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t16 = (T) method.invoke(obj, objArr);
                if (t16 != null) {
                    return t16;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private void d() {
        synchronized (this.f389440k) {
            try {
                this.f389440k.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private void e(Context context) {
        Class<?> a16 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i3 = 0;
        while (true) {
            String[][] strArr = f389429o;
            if (i3 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i3];
            Class<?> a17 = a(context, strArr2[0]);
            Class<?> a18 = a(context, strArr2[1]);
            if (a17 != null && a18 != null) {
                i("found class in index " + i3);
                cls2 = a18;
                cls = a17;
                break;
            }
            i3++;
            cls2 = a18;
            cls = a17;
        }
        this.f389430a = a16;
        this.f389432c = c(a16, "InitSdk", Context.class, cls);
        this.f389431b = cls;
        this.f389434e = c(cls2, com.tencent.luggage.wxa.q2.e.NAME, new Class[0]);
        this.f389437h = c(cls2, "isSupported", new Class[0]);
        this.f389438i = c(cls2, "shutDown", new Class[0]);
    }

    private void f(String str) {
        if (this.f389443n != null) {
            return;
        }
        long j3 = this.f389442m;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j3);
        int i3 = this.f389441l;
        if (elapsedRealtime > 3000 && i3 < 3) {
            synchronized (this.f389440k) {
                if (this.f389442m == j3 && this.f389441l == i3) {
                    i("retry, current count is " + i3);
                    this.f389441l = this.f389441l + 1;
                    h(this.f389439j);
                    j3 = this.f389442m;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j3);
                }
            }
        }
        if (this.f389443n == null && j3 >= 0 && elapsedRealtime <= 3000 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f389440k) {
                if (this.f389443n == null) {
                    try {
                        i(str + " wait...");
                        this.f389440k.wait(3000L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private static boolean g(Object obj) {
        if (!(obj instanceof Boolean) && !(obj instanceof Character) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double)) {
            return false;
        }
        return true;
    }

    private void h(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = -elapsedRealtime;
        Class cls = this.f389431b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                b(this.f389432c, this.f389430a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f389431b}, this));
            } catch (Throwable th5) {
                i("call init sdk error:" + th5);
            }
            this.f389442m = elapsedRealtime;
        }
        elapsedRealtime = j3;
        this.f389442m = elapsedRealtime;
    }

    private static void i(String str) {
        jz4.c.m("mdid:" + str);
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a */
    public boolean mo299a() {
        f("isSupported");
        return this.f389443n != null && Boolean.TRUE.equals(this.f389443n.f389444a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f389442m = SystemClock.elapsedRealtime();
        if (objArr != null) {
            b bVar = new b();
            int length = objArr.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Object obj2 = objArr[i3];
                if (obj2 != null && !g(obj2)) {
                    bVar.f389446c = (String) b(this.f389434e, obj2, new Object[0]);
                    bVar.f389444a = (Boolean) b(this.f389437h, obj2, new Object[0]);
                    b(this.f389438i, obj2, new Object[0]);
                    if (bVar.a()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("has get succ, check duplicate:");
                        if (this.f389443n != null) {
                            z16 = true;
                        }
                        sb5.append(z16);
                        i(sb5.toString());
                        synchronized (k.class) {
                            if (this.f389443n == null) {
                                this.f389443n = bVar;
                            }
                        }
                    }
                }
                i3++;
            }
        }
        d();
        return null;
    }

    @Override // com.xiaomi.push.j
    public String a() {
        f(com.tencent.luggage.wxa.q2.e.NAME);
        if (this.f389443n == null) {
            return null;
        }
        return this.f389443n.f389446c;
    }

    private static Class<?> a(Context context, String str) {
        try {
            return ii.c(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
