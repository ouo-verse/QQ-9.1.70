package com.tencent.luggage.wxa.lo;

import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public Object f133717a;

    /* renamed from: b, reason: collision with root package name */
    public String f133718b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f133719c;

    /* renamed from: d, reason: collision with root package name */
    public Field f133720d;

    /* renamed from: e, reason: collision with root package name */
    public String f133721e;

    public h(Object obj, String str, String str2) {
        if (obj != null) {
            this.f133717a = obj;
            this.f133718b = str;
            this.f133721e = str2;
            return;
        }
        throw new IllegalArgumentException("obj cannot be null");
    }

    public Object a() {
        b();
        Field field = this.f133720d;
        if (field != null) {
            try {
                return field.get(this.f133717a);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        }
        throw new NoSuchFieldException();
    }

    public final void b() {
        if (this.f133719c) {
            return;
        }
        this.f133719c = true;
        Class<?> cls = this.f133717a.getClass();
        while (cls != null) {
            try {
                try {
                    try {
                        Field declaredField = cls.getDeclaredField(this.f133718b);
                        declaredField.setAccessible(true);
                        this.f133720d = declaredField;
                        return;
                    } finally {
                        cls.getSuperclass();
                    }
                } catch (Exception unused) {
                    String str = this.f133721e;
                    if (str != null && !str.equals("")) {
                        Field[] declaredFields = cls.getDeclaredFields();
                        int length = declaredFields.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                Field field = declaredFields[i3];
                                if (field.getType().getName().equals(this.f133721e)) {
                                    field.setAccessible(true);
                                    this.f133720d = field;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    public void a(Object obj) {
        b();
        Field field = this.f133720d;
        if (field != null) {
            field.set(this.f133717a, obj);
            return;
        }
        throw new NoSuchFieldException();
    }
}
