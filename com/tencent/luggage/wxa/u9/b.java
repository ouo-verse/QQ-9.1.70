package com.tencent.luggage.wxa.u9;

import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f142160a;

    /* renamed from: b, reason: collision with root package name */
    public String f142161b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f142162c;

    /* renamed from: d, reason: collision with root package name */
    public Field f142163d;

    /* renamed from: e, reason: collision with root package name */
    public String f142164e;

    public b(Object obj, String str, String str2) {
        if (obj != null) {
            this.f142160a = obj;
            this.f142161b = str;
            this.f142164e = str2;
            return;
        }
        throw new IllegalArgumentException("obj cannot be null");
    }

    public Object a() {
        b();
        Field field = this.f142163d;
        if (field != null) {
            try {
                return field.get(this.f142160a);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        }
        throw new NoSuchFieldException();
    }

    public final void b() {
        if (this.f142162c) {
            return;
        }
        this.f142162c = true;
        Class<?> cls = this.f142160a.getClass();
        while (cls != null) {
            try {
                try {
                    try {
                        Field declaredField = cls.getDeclaredField(this.f142161b);
                        declaredField.setAccessible(true);
                        this.f142163d = declaredField;
                        return;
                    } finally {
                        cls.getSuperclass();
                    }
                } catch (Exception unused) {
                    String str = this.f142164e;
                    if (str != null && !str.equals("")) {
                        Field[] declaredFields = cls.getDeclaredFields();
                        int length = declaredFields.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                Field field = declaredFields[i3];
                                if (field.getType().getName().equals(this.f142164e)) {
                                    field.setAccessible(true);
                                    this.f142163d = field;
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
        Field field = this.f142163d;
        if (field != null) {
            field.set(this.f142160a, obj);
            return;
        }
        throw new NoSuchFieldException();
    }
}
