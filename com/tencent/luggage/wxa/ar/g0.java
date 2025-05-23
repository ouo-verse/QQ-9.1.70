package com.tencent.luggage.wxa.ar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f121640a;

    /* renamed from: b, reason: collision with root package name */
    public Class f121641b;

    /* renamed from: c, reason: collision with root package name */
    public String f121642c;

    /* renamed from: d, reason: collision with root package name */
    public Class[] f121643d;

    /* renamed from: e, reason: collision with root package name */
    public Method f121644e;

    public g0(Object obj, String str, Class... clsArr) {
        a(obj, null, str, clsArr);
    }

    public boolean a(Object obj, Class cls, String str, Class... clsArr) {
        this.f121640a = obj;
        if (cls == null) {
            cls = obj != null ? obj.getClass() : null;
        }
        this.f121641b = cls;
        this.f121642c = str;
        this.f121643d = clsArr;
        this.f121644e = null;
        if (cls == null) {
            return false;
        }
        try {
            this.f121644e = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            for (Class cls2 = this.f121641b; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Method declaredMethod = cls2.getDeclaredMethod(this.f121642c, this.f121643d);
                    this.f121644e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    x0.d("ReflectMethod", "init, find method " + this.f121642c + " in class " + this.f121641b);
                    break;
                } catch (NoSuchMethodException e16) {
                    x0.d("ReflectMethod", "init error:" + e16);
                }
            }
        }
        return this.f121644e != null;
    }

    public String toString() {
        Method method = this.f121644e;
        if (method != null) {
            return method.toString();
        }
        String str = "";
        if (this.f121641b != null) {
            str = "" + this.f121641b + ".";
        }
        if (this.f121642c != null) {
            return str + this.f121642c;
        }
        return str;
    }

    public g0(Class cls, String str, Class... clsArr) {
        a(null, cls, str, clsArr);
    }

    public Object a(Object... objArr) {
        Method method = this.f121644e;
        if (method != null) {
            try {
                return method.invoke(this.f121640a, objArr);
            } catch (IllegalAccessException e16) {
                e = e16;
                throw new RejectedExecutionException(e);
            } catch (IllegalArgumentException e17) {
                throw e17;
            } catch (NullPointerException e18) {
                e = e18;
                throw new RejectedExecutionException(e);
            } catch (InvocationTargetException e19) {
                throw new RuntimeException(e19.getCause());
            }
        }
        throw new UnsupportedOperationException(toString());
    }

    public boolean a() {
        return this.f121644e == null;
    }
}
