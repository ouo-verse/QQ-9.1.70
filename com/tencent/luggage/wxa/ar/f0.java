package com.tencent.luggage.wxa.ar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    public Class f121633a;

    /* renamed from: b, reason: collision with root package name */
    public Class[] f121634b;

    /* renamed from: c, reason: collision with root package name */
    public Constructor f121635c;

    public f0(Class cls, Class... clsArr) {
        a(cls, clsArr);
    }

    public boolean a(Class cls, Class... clsArr) {
        this.f121633a = cls;
        this.f121634b = clsArr;
        this.f121635c = null;
        if (cls == null) {
            return false;
        }
        try {
            try {
                this.f121635c = cls.getConstructor(clsArr);
            } catch (NoSuchMethodException unused) {
                Constructor declaredConstructor = this.f121633a.getDeclaredConstructor(this.f121634b);
                this.f121635c = declaredConstructor;
                declaredConstructor.setAccessible(true);
            }
        } catch (NoSuchMethodException e16) {
            x0.c("ReflectConstructor", "init error:" + e16.getLocalizedMessage());
        }
        return this.f121635c != null;
    }

    public String toString() {
        Constructor constructor = this.f121635c;
        if (constructor != null) {
            return constructor.toString();
        }
        if (this.f121633a == null) {
            return "";
        }
        return "" + this.f121633a.toString();
    }

    public Object a(Object... objArr) {
        Constructor constructor = this.f121635c;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException e16) {
                throw new RejectedExecutionException(e16);
            } catch (IllegalArgumentException e17) {
                throw e17;
            } catch (InstantiationException e18) {
                throw new RejectedExecutionException(e18);
            } catch (InvocationTargetException e19) {
                throw new RuntimeException(e19.getCause());
            }
        }
        throw new UnsupportedOperationException(toString());
    }
}
