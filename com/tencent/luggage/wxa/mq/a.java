package com.tencent.luggage.wxa.mq;

import com.tencent.luggage.wxa.zp.d;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Class f134877a;

    /* renamed from: b, reason: collision with root package name */
    public String f134878b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f134879c;

    /* renamed from: d, reason: collision with root package name */
    public Field f134880d;

    public a(Class cls, String str) {
        if (cls != null && str != null && str.length() != 0) {
            this.f134877a = cls;
            this.f134878b = str;
            return;
        }
        throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }

    public synchronized Object a() {
        return a(false);
    }

    public final synchronized void b() {
        if (this.f134879c) {
            return;
        }
        for (Class cls = this.f134877a; cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(this.f134878b);
                declaredField.setAccessible(true);
                this.f134880d = declaredField;
                break;
            } catch (Exception unused) {
            }
        }
        this.f134879c = true;
    }

    public synchronized Object a(boolean z16) {
        b();
        Field field = this.f134880d;
        if (field != null) {
            try {
                return field.get(null);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        }
        if (z16) {
            d.f146814c.w("ReflectFiled", String.format("Field %s is no exists.", this.f134878b), new Object[0]);
            return null;
        }
        throw new NoSuchFieldException();
    }

    public synchronized boolean a(Object obj, Object obj2) {
        return a(obj, obj2, false);
    }

    public synchronized boolean a(Object obj, Object obj2, boolean z16) {
        b();
        Field field = this.f134880d;
        if (field != null) {
            field.set(obj, obj2);
            return true;
        }
        if (z16) {
            d.f146814c.w("ReflectFiled", String.format("Field %s is no exists.", this.f134878b), new Object[0]);
            return false;
        }
        throw new NoSuchFieldException("Method " + this.f134878b + " is not exists.");
    }

    public synchronized boolean a(Object obj) {
        return a(null, obj, false);
    }
}
