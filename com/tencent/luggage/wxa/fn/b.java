package com.tencent.luggage.wxa.fn;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.luggage.wxa.ir.b f126260c = com.tencent.luggage.wxa.ir.a.a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f126261a = false;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f126262b;

    public static int a(com.tencent.luggage.wxa.hr.a aVar) {
        return aVar.a();
    }

    public byte[] b() {
        d();
        com.tencent.luggage.wxa.mr.a aVar = new com.tencent.luggage.wxa.mr.a(new byte[a()]);
        a(aVar);
        byte[] a16 = aVar.a();
        aVar.c();
        return a16;
    }

    public Object c() {
        return "";
    }

    public int a(int i3, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        a(0, aVar);
    }

    public int a() {
        try {
            return a(1, new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public b a(byte[] bArr) {
        this.f126262b = bArr;
        a(2, bArr);
        return this;
    }

    public boolean a(com.tencent.luggage.wxa.hr.a aVar, b bVar, int i3) {
        boolean z16 = a(3, aVar, bVar, Integer.valueOf(i3)) == 0;
        this.f126261a = this.f126261a || !z16;
        return z16;
    }

    public b d() {
        return this;
    }
}
