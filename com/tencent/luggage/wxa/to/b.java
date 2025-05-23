package com.tencent.luggage.wxa.to;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.vo.a {

    /* renamed from: a, reason: collision with root package name */
    public a f141776a;

    /* renamed from: b, reason: collision with root package name */
    public int f141777b = -1;

    /* renamed from: c, reason: collision with root package name */
    public Object f141778c;

    /* renamed from: d, reason: collision with root package name */
    public int f141779d;

    public b(Object obj, a aVar) {
        com.tencent.luggage.wxa.er.a.a("Callback should not be null!", obj);
        this.f141779d = obj.hashCode();
        this.f141778c = obj;
        this.f141776a = aVar;
    }

    public Object a() {
        return this.f141778c;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.hashCode() == this.f141779d) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.vo.a
    public void g() {
        com.tencent.luggage.wxa.er.a.a(this.f141776a);
        this.f141776a.b(this);
    }

    public int hashCode() {
        return this.f141779d;
    }
}
