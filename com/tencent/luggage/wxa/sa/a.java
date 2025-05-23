package com.tencent.luggage.wxa.sa;

import com.tencent.luggage.wxa.ta.c;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Class f140216a;

    /* renamed from: b, reason: collision with root package name */
    public String f140217b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f140218c;

    /* renamed from: d, reason: collision with root package name */
    public Field f140219d;

    public a(Class cls, String str) {
        if (cls != null && str != null && str.length() != 0) {
            this.f140216a = cls;
            this.f140217b = str;
            return;
        }
        throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }

    public synchronized Object a(boolean z16) {
        b();
        Field field = this.f140219d;
        if (field != null) {
            try {
                return field.get(null);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        }
        if (!z16) {
            throw new NoSuchFieldException();
        }
        c.e("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.f140217b);
        return null;
    }

    public final synchronized void b() {
        if (this.f140218c) {
            return;
        }
        for (Class cls = this.f140216a; cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(this.f140217b);
                declaredField.setAccessible(true);
                this.f140219d = declaredField;
                break;
            } catch (Exception unused) {
            }
        }
        this.f140218c = true;
    }

    public synchronized Object a() {
        Object obj;
        try {
            try {
                obj = a(true);
            } catch (IllegalArgumentException e16) {
                c.c("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e16);
                obj = null;
                return obj;
            } catch (NoSuchFieldException e17) {
                c.c("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e17);
                obj = null;
                return obj;
            }
        } catch (IllegalAccessException e18) {
            c.c("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e18);
            obj = null;
            return obj;
        }
        return obj;
    }
}
