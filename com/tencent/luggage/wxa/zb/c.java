package com.tencent.luggage.wxa.zb;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c implements com.tencent.luggage.wxa.ac.b {

    /* renamed from: a, reason: collision with root package name */
    public int f146473a;

    /* renamed from: b, reason: collision with root package name */
    public int f146474b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ac.a f146475c;

    public c(int i3, int i16, com.tencent.luggage.wxa.ac.a aVar) {
        a(i3, i16, aVar);
    }

    public final void a(int i3, int i16, com.tencent.luggage.wxa.ac.a aVar) {
        this.f146475c = aVar;
        if (aVar == null) {
            this.f146475c = new a();
        }
        this.f146473a = i3;
        this.f146474b = i16;
    }

    public int b() {
        return this.f146474b;
    }

    public int c() {
        return this.f146473a;
    }

    @Override // com.tencent.luggage.wxa.ac.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 < 0 || i3 >= a()) {
            return null;
        }
        return Integer.valueOf(this.f146473a + i3);
    }

    public c(int i3, int i16) {
        a(i3, i16, null);
    }

    @Override // com.tencent.luggage.wxa.ac.b
    public String a(int i3) {
        Integer item = getItem(i3);
        return this.f146475c.a(item == null ? "" : item.toString());
    }

    @Override // com.tencent.luggage.wxa.ac.b
    public int a() {
        return (this.f146474b - this.f146473a) + 1;
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
