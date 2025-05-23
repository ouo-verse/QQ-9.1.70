package com.tencent.mm.ui.widget.edittext;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MB<T> {

    /* renamed from: a, reason: collision with root package name */
    public Object f153222a;

    /* renamed from: b, reason: collision with root package name */
    public Method f153223b;

    public MB(Object obj, String str, Class<?>... clsArr) {
        this.f153222a = obj;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                this.f153223b = cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
            }
        }
        if (this.f153223b == null) {
            new Throwable("MB " + str).printStackTrace();
        }
    }

    public T invoke(Object... objArr) {
        try {
            this.f153223b.setAccessible(true);
            return (T) this.f153223b.invoke(this.f153222a, objArr);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public MB(String str, String str2, Class<?>... clsArr) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            cls = null;
        }
        this.f153222a = null;
        while (cls != Object.class) {
            try {
                this.f153223b = cls.getDeclaredMethod(str2, clsArr);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            cls = cls.getSuperclass();
        }
    }
}
