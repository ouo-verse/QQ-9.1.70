package com.tencent.luggage.wxa.ap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f121610a;

    public Object a(Object... objArr) {
        this.f121610a = objArr;
        return this;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (Object obj : this.f121610a) {
            if (z16) {
                z16 = false;
            } else {
                sb5.append(",");
            }
            sb5.append(obj);
        }
        return sb5.toString();
    }

    public Object a(int i3) {
        Object[] objArr = this.f121610a;
        if (objArr.length <= i3) {
            return null;
        }
        return objArr[i3];
    }

    public int a() {
        Object[] objArr = this.f121610a;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public static a a(Object obj) {
        return (a) new a().a(obj);
    }

    public static b a(Object obj, Object obj2) {
        return (b) new b().a(obj, obj2);
    }

    public static c a(Object obj, Object obj2, Object obj3) {
        return (c) new c().a(obj, obj2, obj3);
    }
}
