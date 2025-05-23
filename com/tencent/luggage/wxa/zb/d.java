package com.tencent.luggage.wxa.zb;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends c {

    /* renamed from: d, reason: collision with root package name */
    public int f146477d;

    /* renamed from: e, reason: collision with root package name */
    public int f146478e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.ac.a f146479f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f146480g;

    /* renamed from: h, reason: collision with root package name */
    public int f146481h;

    /* renamed from: i, reason: collision with root package name */
    public Context f146482i;

    public d(int i3, int i16, Context context) {
        super(i3, i16);
        this.f146482i = context;
        a(i3, i16, this.f146479f);
    }

    private void a(int i3, int i16, com.tencent.luggage.wxa.ac.a aVar) {
        this.f146479f = aVar;
        if (aVar == null) {
            this.f146479f = new a();
        }
        this.f146477d = i3;
        this.f146478e = i16;
    }

    @Override // com.tencent.luggage.wxa.zb.c
    public int b() {
        return this.f146478e;
    }

    @Override // com.tencent.luggage.wxa.zb.c
    public int c() {
        return this.f146477d;
    }

    @Override // com.tencent.luggage.wxa.zb.c, com.tencent.luggage.wxa.ac.b
    /* renamed from: b */
    public Integer getItem(int i3) {
        if (i3 < 0 || i3 >= a()) {
            return null;
        }
        if (this.f146480g) {
            return Integer.valueOf((this.f146477d + i3) - 1);
        }
        return Integer.valueOf(this.f146477d + i3);
    }

    public void a(boolean z16, int i3) {
        this.f146480g = z16;
        this.f146481h = i3;
    }

    @Override // com.tencent.luggage.wxa.zb.c, com.tencent.luggage.wxa.ac.b
    public String a(int i3) {
        if (i3 == 0 && this.f146480g) {
            return this.f146482i.getString(this.f146481h);
        }
        return super.a(i3);
    }

    @Override // com.tencent.luggage.wxa.zb.c, com.tencent.luggage.wxa.ac.b
    public int a() {
        int i3;
        if (this.f146480g) {
            i3 = (this.f146478e - this.f146477d) + 1;
        } else {
            i3 = this.f146478e - this.f146477d;
        }
        return i3 + 1;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.ac.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ac.a
        public String a(String str) {
            return str;
        }
    }
}
