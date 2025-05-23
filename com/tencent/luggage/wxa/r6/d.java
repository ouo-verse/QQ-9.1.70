package com.tencent.luggage.wxa.r6;

import com.tencent.luggage.wxa.r6.f;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.u1.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f139294a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(g session, Map sceneMap) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(sceneMap, "sceneMap");
        if (!com.tencent.luggage.wxa.h6.d.b(session) && !sceneMap.isEmpty()) {
            h.b b16 = com.tencent.luggage.wxa.u1.h.INST.b();
            Intrinsics.checkNotNullExpressionValue(b16, "INST.memoryInfo");
            int a16 = (int) w0.a(z.c());
            com.tencent.luggage.wxa.vk.c a17 = com.tencent.luggage.wxa.vk.a.INST.a();
            Intrinsics.checkNotNullExpressionValue(a17, "INST.getBatteryInfo()");
            boolean z16 = a17.f143642a;
            String a18 = com.tencent.luggage.wxa.bk.k.a(z.c());
            for (Map.Entry entry : sceneMap.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                List list = (List) entry.getValue();
                i iVar = new i();
                iVar.p(intValue);
                iVar.c(a18);
                iVar.a(((i) list.get(0)).f139365c);
                iVar.b(((i) list.get(0)).f139386x);
                iVar.n(((i) list.get(0)).f139385w);
                iVar.a(((i) list.get(0)).f139388z);
                iVar.g(b(list));
                iVar.h(c(list));
                iVar.k(g(list));
                iVar.d(f(list));
                iVar.q(e(list));
                iVar.l(b16.f142077a);
                iVar.m(b16.f142077a - session.c());
                iVar.a(a16);
                iVar.i(b16.f142080d);
                iVar.j(d(list));
                iVar.e(a(list));
                iVar.f(d(list));
                iVar.c(a17.f143643b);
                iVar.b(0 | (z16 ? 1 : 0));
                iVar.o(((i) list.get(list.size() - 1)).f139373k);
                w.a("GameMultiSceneReport", "report scene:" + intValue + " count:" + list.size() + " event: " + iVar);
                a(session, iVar);
            }
            return;
        }
        w.b("GameMultiSceneReport", "session or sceneMap null ");
    }

    public final int b(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).f139363a;
        }
        return i3 / list.size();
    }

    public final int c(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).f139377o;
        }
        return i3 / list.size();
    }

    public final int d(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).D;
        }
        return i3 / list.size();
    }

    public final int e(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).f139384v;
        }
        return i3 / list.size();
    }

    public final int f(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).f139383u;
        }
        return i3;
    }

    public final int g(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).f139382t;
        }
        return i3;
    }

    public final void a(g gVar, i iVar) {
        String r16;
        f fVar = new f();
        fVar.b(gVar.f124304b);
        fVar.b(gVar.f124308f);
        fVar.a(f.a.a(gVar.f124305c));
        fVar.e(gVar.f124303a);
        fVar.a(gVar.f124306d);
        fVar.g(iVar.f139387y);
        fVar.s(gVar.f124307e);
        q i3 = gVar.b().i();
        if (i3 == null) {
            r16 = "";
        } else {
            r16 = i3.r();
            Intrinsics.checkNotNullExpressionValue(r16, "reader.versionName()");
        }
        fVar.f(r16);
        fVar.q(iVar.f139385w);
        if (iVar.f139365c != null) {
            fVar.n(r4.ordinal());
        } else {
            fVar.n(0L);
        }
        fVar.t(iVar.A);
        fVar.r(iVar.f139373k / 1000);
        fVar.i(iVar.f139363a);
        fVar.j(iVar.f139377o);
        fVar.m(iVar.f139382t);
        fVar.f(iVar.f139383u);
        fVar.u(iVar.f139384v);
        fVar.o(iVar.f139371i);
        fVar.p(iVar.f139372j);
        fVar.c(iVar.B);
        fVar.k(iVar.C);
        fVar.l(iVar.D);
        fVar.g(iVar.F);
        fVar.h(iVar.E);
        fVar.e(iVar.G);
        fVar.d(iVar.H);
        fVar.c(iVar.f139388z);
        if (k.a() != null) {
            fVar.d(k.a().a());
        }
        w.a("GameMultiSceneReport", "newQualityRuntime:event report:" + fVar.e());
        fVar.c();
    }

    public final int a(List list) {
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((i) it.next()).F;
        }
        return i3 / list.size();
    }
}
