package com.tencent.luggage.wxa.zg;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements n {

    /* renamed from: a, reason: collision with root package name */
    public Context f146636a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f146637b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.h0.b f146638c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.a0.b f146639d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.n.e f146640e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.o0.g f146641f;

    /* renamed from: g, reason: collision with root package name */
    public int f146642g = 50;

    /* renamed from: h, reason: collision with root package name */
    public int f146643h = 5000;

    public f(Context context, Handler handler, com.tencent.luggage.wxa.h0.b bVar, com.tencent.luggage.wxa.a0.b bVar2, com.tencent.luggage.wxa.n.e eVar, com.tencent.luggage.wxa.o0.g gVar) {
        this.f146636a = context;
        this.f146637b = handler;
        this.f146638c = bVar;
        this.f146639d = bVar2;
        this.f146640e = eVar;
        this.f146641f = gVar;
    }

    @Override // com.tencent.luggage.wxa.zg.n
    public List a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b());
        arrayList.addAll(c());
        return arrayList;
    }

    public List b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.luggage.wxa.n.i(com.tencent.luggage.wxa.z.c.f146162a, null, true, this.f146637b, this.f146640e, com.tencent.luggage.wxa.n.c.a(this.f146636a), new com.tencent.luggage.wxa.n.d[0]));
        return arrayList;
    }

    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.luggage.wxa.o0.e(this.f146636a, com.tencent.luggage.wxa.z.c.f146162a, this.f146643h, null, false, this.f146637b, this.f146641f, this.f146642g));
        return arrayList;
    }
}
