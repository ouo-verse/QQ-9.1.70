package com.tencent.luggage.wxa.dj;

import com.tencent.luggage.wxa.gj.d;
import com.tencent.luggage.wxa.gj.e;
import com.tencent.luggage.wxa.gj.f;
import com.tencent.luggage.wxa.gj.g;
import com.tencent.luggage.wxa.gj.h;
import com.tencent.luggage.wxa.gj.i;
import com.tencent.luggage.wxa.gj.j;
import com.tencent.luggage.wxa.gj.k;
import com.tencent.luggage.wxa.gj.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f124287a = new HashMap();

    static {
        a(new com.tencent.luggage.wxa.gj.b());
        a(new h());
        a(new j());
        a(new l());
        a(new k());
        a(new f());
        a(new e());
        a(new i());
        a(new com.tencent.luggage.wxa.gj.a());
        a(new com.tencent.luggage.wxa.gj.c());
        a(new d());
        a(new g());
    }

    public static com.tencent.luggage.wxa.ej.a a(int i3) {
        return (com.tencent.luggage.wxa.ej.a) f124287a.get(Integer.valueOf(i3));
    }

    public static void a(com.tencent.luggage.wxa.ej.a aVar) {
        f124287a.put(Integer.valueOf(aVar.a()), aVar);
    }
}
