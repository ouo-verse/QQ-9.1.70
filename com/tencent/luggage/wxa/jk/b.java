package com.tencent.luggage.wxa.jk;

import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f131188g;

    public b(com.tencent.luggage.wxa.xn.b bVar, a.C6921a c6921a, String str, String[] strArr) {
        super(bVar, c6921a, str, strArr);
        this.f131188g = bVar;
    }

    @Override // com.tencent.luggage.wxa.xn.c
    public boolean a(com.tencent.luggage.wxa.xn.a aVar, boolean z16) {
        super.a(aVar, z16);
        return b(aVar, new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.xn.c
    public boolean b(com.tencent.luggage.wxa.xn.a aVar, boolean z16, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((a) aVar).getKeys();
        }
        return super.b(aVar, z16, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.xn.c
    public boolean a(com.tencent.luggage.wxa.xn.a aVar, boolean z16, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((a) aVar).getKeys();
        }
        return super.a(aVar, z16, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.xn.c
    public boolean b(com.tencent.luggage.wxa.xn.a aVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            strArr = ((a) aVar).getKeys();
        }
        return super.b(aVar, strArr);
    }
}
