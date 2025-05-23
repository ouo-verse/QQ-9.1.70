package com.tencent.luggage.wxa.tn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q0 {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f141698a;

    /* renamed from: b, reason: collision with root package name */
    public int f141699b;

    public q0(int i3) {
        if (i3 <= 0) {
            w.b("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
        } else {
            this.f141698a = new Object[i3];
        }
    }

    public Object a() {
        int i3;
        Object[] objArr = this.f141698a;
        if (objArr == null || (i3 = this.f141699b) <= 0) {
            return null;
        }
        int i16 = i3 - 1;
        Object obj = objArr[i16];
        objArr[i16] = null;
        this.f141699b = i16;
        return obj;
    }

    public boolean b(Object obj) {
        if (this.f141698a == null || a(obj)) {
            return false;
        }
        int i3 = this.f141699b;
        Object[] objArr = this.f141698a;
        if (i3 < objArr.length && i3 >= 0) {
            objArr[i3] = obj;
            this.f141699b = i3 + 1;
            return true;
        }
        w.b("MicroMsg.SimpleObjectPool", "error index %d %d", Integer.valueOf(i3), Integer.valueOf(this.f141698a.length));
        return false;
    }

    public final boolean a(Object obj) {
        if (this.f141698a == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f141699b; i3++) {
            if (this.f141698a[i3] == obj) {
                return true;
            }
        }
        return false;
    }
}
