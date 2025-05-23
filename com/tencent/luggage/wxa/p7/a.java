package com.tencent.luggage.wxa.p7;

import com.tencent.luggage.wxa.hn.eb;
import com.tencent.luggage.wxa.hn.fa;
import com.tencent.luggage.wxa.hn.fb;
import com.tencent.luggage.wxa.hn.ga;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.wd;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.d;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.n3.e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f137370b = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6588a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ga f137371a;

        public C6588a(ga gaVar) {
            this.f137371a = gaVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(fb fbVar) {
            wd wdVar;
            wd wdVar2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("run op[");
            sb5.append(this.f137371a.f127698d.f127628d);
            sb5.append(TokenParser.SP);
            sb5.append(this.f137371a.f127698d.f127629e);
            sb5.append(TokenParser.SP);
            sb5.append(this.f137371a.f127702h);
            sb5.append("], get resp:");
            sb5.append((fbVar == null || (wdVar2 = fbVar.f127630e) == null) ? -1 : wdVar2.f128970d);
            w.d("Luggage.CgiModCollection", sb5.toString());
            Integer valueOf = (fbVar == null || (wdVar = fbVar.f127630e) == null) ? null : Integer.valueOf(wdVar.f128970d);
            if ((valueOf != null && valueOf.intValue() == 0) || valueOf == null) {
                return;
            }
            valueOf.intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ga f137372a;

        public b(ga gaVar) {
            this.f137372a = gaVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            w.b("Luggage.CgiModCollection", "run op[" + this.f137372a.f127698d.f127628d + TokenParser.SP + this.f137372a.f127698d.f127629e + TokenParser.SP + this.f137372a.f127702h + "], interrupted by " + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f137373a = new c();

        @Override // com.tencent.luggage.wxa.xo.d.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final fb call() {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return "/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord";
    }

    public com.tencent.luggage.wxa.xo.d a(String str, eb request, Class clazz) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!com.tencent.luggage.wxa.o3.l.f136139a.c()) {
            com.tencent.luggage.wxa.xo.d a16 = com.tencent.luggage.wxa.xo.h.a((d.a) c.f137373a);
            Intrinsics.checkNotNullExpressionValue(a16, "pipeline(Pipeable.Resolv\u2026solve null\n            })");
            return a16;
        }
        return super.a(str, (s8) request, clazz);
    }

    public static final ga a(fa self, fa faVar, fa faVar2) {
        Intrinsics.checkNotNullParameter(self, "self");
        return f137370b.a(1, self, faVar, faVar2);
    }

    public static /* synthetic */ ga a(fa faVar, fa faVar2, fa faVar3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            faVar2 = null;
        }
        if ((i3 & 4) != 0) {
            faVar3 = null;
        }
        return a(faVar, faVar2, faVar3);
    }

    public static final ga a(fa self) {
        Intrinsics.checkNotNullParameter(self, "self");
        return a(f137370b, 2, self, null, null, 12, null);
    }

    public static /* synthetic */ ga a(a aVar, int i3, fa faVar, fa faVar2, fa faVar3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            faVar2 = null;
        }
        if ((i16 & 8) != 0) {
            faVar3 = null;
        }
        return aVar.a(i3, faVar, faVar2, faVar3);
    }

    public final ga a(int i3, fa faVar, fa faVar2, fa faVar3) {
        ga gaVar = new ga();
        gaVar.f127698d = faVar;
        gaVar.f127702h = i3;
        gaVar.f127699e = faVar2;
        gaVar.f127700f = faVar3;
        return gaVar;
    }

    public final void a(ga op5) {
        Intrinsics.checkNotNullParameter(op5, "op");
        eb ebVar = new eb();
        ebVar.f127568f.add(op5);
        ebVar.f127567e = 4;
        Unit unit = Unit.INSTANCE;
        a((String) null, ebVar, fb.class).a(new C6588a(op5)).a(new b(op5));
    }
}
