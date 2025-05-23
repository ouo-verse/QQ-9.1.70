package com.tencent.luggage.wxa.v6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.p5.c {

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f143288d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f143289e = new byte[0];

    @Override // com.tencent.luggage.wxa.h4.a
    public Map a() {
        Map a16;
        synchronized (this.f143289e) {
            a16 = super.a();
            Iterator it = this.f143288d.iterator();
            while (it.hasNext()) {
                a16.remove((String) it.next());
            }
            Intrinsics.checkNotNullExpressionValue(a16, "super.createForAppServic\u2026          }\n            }");
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.h4.a
    public Map b() {
        Map b16 = super.b();
        Iterator it = this.f143288d.iterator();
        while (it.hasNext()) {
            b16.remove((String) it.next());
        }
        Intrinsics.checkNotNullExpressionValue(b16, "super.createForPage().ap\u2026)\n            }\n        }");
        return b16;
    }

    @Override // com.tencent.luggage.wxa.p5.c, com.tencent.luggage.wxa.h4.a
    public void c() {
        super.c();
        a(new com.tencent.luggage.wxa.w6.b());
        a(new com.tencent.luggage.wxa.w6.a());
        a(new a());
        a(new f());
        a(new g());
        a(new e());
        a(new d());
        a(new c());
        a(com.tencent.luggage.wxa.x6.f.f144599a.a());
        a(com.tencent.luggage.wxa.y6.f.f145437a.a());
        a(new com.tencent.luggage.wxa.y6.b());
        a(new com.tencent.luggage.wxa.a7.a());
        a(new com.tencent.luggage.wxa.a7.b());
    }

    @Override // com.tencent.luggage.wxa.p5.c, com.tencent.luggage.wxa.h4.a
    public void d() {
        super.d();
        b(new com.tencent.luggage.wxa.w6.b());
        b(new com.tencent.luggage.wxa.w6.a());
        b(new a());
        b(new f());
        b(new g());
        b(new com.tencent.luggage.wxa.b7.b());
        b(new e());
        b(new com.tencent.luggage.wxa.gg.e());
        b(new com.tencent.luggage.wxa.gg.b());
        b(new d());
        b(new c());
        b(com.tencent.luggage.wxa.x6.f.f144599a.a());
        b(com.tencent.luggage.wxa.y6.f.f145437a.a());
        b(new b());
        b(new com.tencent.luggage.wxa.o2.a());
        b(new com.tencent.luggage.wxa.a7.a());
        b(new com.tencent.luggage.wxa.a7.b());
    }
}
