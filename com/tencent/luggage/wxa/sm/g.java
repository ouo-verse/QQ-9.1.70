package com.tencent.luggage.wxa.sm;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final int f140445b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f140446c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final int f140447d = 4;

    /* renamed from: a, reason: collision with root package name */
    public int f140448a = 4;

    public int a() {
        return this.f140448a;
    }

    public synchronized boolean b() {
        boolean z16;
        if (this.f140448a == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean c() {
        boolean z16;
        if (this.f140448a == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean d() {
        boolean z16;
        if (this.f140448a == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public void a(int i3) {
        this.f140448a = i3;
    }
}
