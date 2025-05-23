package com.tencent.luggage.wxa.mq;

import com.tencent.luggage.wxa.zp.d;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Class f134881a;

    /* renamed from: b, reason: collision with root package name */
    public String f134882b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f134883c;

    /* renamed from: d, reason: collision with root package name */
    public Method f134884d;

    /* renamed from: e, reason: collision with root package name */
    public Class[] f134885e;

    public b(Class cls, String str, Class... clsArr) {
        if (cls != null && str != null && str.length() != 0) {
            this.f134881a = cls;
            this.f134882b = str;
            this.f134885e = clsArr;
            return;
        }
        throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }

    public final synchronized void a() {
        if (this.f134883c) {
            return;
        }
        for (Class cls = this.f134881a; cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(this.f134882b, this.f134885e);
                declaredMethod.setAccessible(true);
                this.f134884d = declaredMethod;
                break;
            } catch (Exception unused) {
            }
        }
        this.f134883c = true;
    }

    public synchronized Object a(Object obj, Object... objArr) {
        return a(obj, false, objArr);
    }

    public synchronized Object a(Object obj, boolean z16, Object... objArr) {
        a();
        Method method = this.f134884d;
        if (method != null) {
            return method.invoke(obj, objArr);
        }
        if (z16) {
            d.f146814c.w("ReflectFiled", "Field %s is no exists", this.f134882b);
            return null;
        }
        throw new NoSuchFieldException("Method " + this.f134882b + " is not exists.");
    }
}
