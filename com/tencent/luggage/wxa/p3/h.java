package com.tencent.luggage.wxa.p3;

import com.tencent.luggage.wxa.hn.fh;
import com.tencent.luggage.wxa.hn.g0;
import com.tencent.luggage.wxa.hn.gh;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.xa;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.x3.a;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends i implements com.tencent.luggage.wxa.ya.b {

    /* renamed from: g, reason: collision with root package name */
    public final String f137160g = "TdiCgiService";

    /* renamed from: h, reason: collision with root package name */
    public b f137161h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f137162i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.x3.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.x3.h f137163a;

        public a(com.tencent.luggage.wxa.x3.h hVar) {
            this.f137163a = hVar;
        }

        @Override // com.tencent.luggage.wxa.x3.g
        public com.tencent.luggage.wxa.x3.h a() {
            return this.f137163a;
        }
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void G() {
        this.f137162i = false;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public Class c() {
        return gh.class;
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void e() {
        this.f137162i = true;
        w();
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public abstract String i();

    public final String u() {
        return com.tencent.luggage.wxa.s3.f.c();
    }

    public final int v() {
        com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
        if (!lVar.c()) {
            w.b(i(), "not login, fail");
            return -1;
        }
        com.tencent.luggage.wxa.o3.j a16 = lVar.a();
        if (a16 == null) {
            return -1;
        }
        return a16.h();
    }

    public final void w() {
        p pVar;
        b bVar = this.f137161h;
        if (bVar instanceof p) {
            pVar = (p) bVar;
        } else {
            pVar = null;
        }
        if (pVar != null) {
            a.C6898a.f144554a.a(new com.tencent.luggage.wxa.x3.e(new a(com.tencent.luggage.wxa.x3.h.f144573a.a(pVar.a()))));
        }
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public void b(com.tencent.luggage.wxa.fn.b bVar) {
        g0 g0Var;
        if (!(bVar instanceof s8) || (g0Var = ((s8) bVar).f128671d) == null) {
            return;
        }
        g0Var.f127655e = new com.tencent.luggage.wxa.y8.h(v()).a();
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public xa a(gh ghVar) {
        Intrinsics.checkNotNullParameter(ghVar, "<this>");
        return ghVar.f127724f;
    }

    @Override // com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public void a(b tdiCgi) {
        Intrinsics.checkNotNullParameter(tdiCgi, "tdiCgi");
        w.d(i(), "installTdiCloneSession appId:" + u() + " uin:" + v());
        super.a(tdiCgi);
        this.f137161h = tdiCgi;
        if (this.f137162i) {
            w();
        }
    }

    @Override // com.tencent.luggage.wxa.p3.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public fh a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar) {
        fh fhVar = new fh();
        a(fhVar);
        b(fhVar);
        fhVar.f127643e = str;
        fhVar.f127644f = u();
        fhVar.f127646h = new com.tencent.luggage.wxa.fn.c(bVar != null ? bVar.b() : null);
        fhVar.f127645g = g.a();
        fhVar.f127647i = str2;
        g gVar = g.f137156a;
        fhVar.f127648j = gVar.a(str);
        fhVar.f127649k = gVar.c();
        w.d(i(), "createTransferReq: url:" + str + " appId:" + str2 + " host_appId:" + u() + " uin:" + v() + " cmdid:" + fhVar.f127648j + " req");
        return fhVar;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public void a(com.tencent.luggage.wxa.fn.b bVar) {
        if (bVar instanceof s8) {
            s8 s8Var = (s8) bVar;
            if (s8Var.f128671d == null) {
                s8Var.f128671d = new g0();
                if (3 == g.a()) {
                    s8Var.f128671d.f127655e = 0;
                } else {
                    s8Var.f128671d.f127655e = new com.tencent.luggage.wxa.y8.h(v()).a();
                }
                g0 g0Var = s8Var.f128671d;
                g0Var.f127657g = com.tencent.luggage.wxa.tn.e.f141563e;
                String h16 = com.tencent.luggage.wxa.o3.l.f136139a.h();
                Charset charset = Charsets.UTF_8;
                byte[] bytes = h16.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                g0Var.f127656f = new com.tencent.luggage.wxa.fn.c(bytes);
                g0 g0Var2 = s8Var.f128671d;
                byte[] bytes2 = g.f137156a.b().getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                g0Var2.f127658h = new com.tencent.luggage.wxa.fn.c(bytes2);
                s8Var.f128671d.f127654d = new com.tencent.luggage.wxa.fn.c(new byte[0]);
                s8Var.f128671d.f127659i = 0;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public byte[] b(gh resp) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        byte[] c16 = resp.f127723e.c();
        Intrinsics.checkNotNullExpressionValue(c16, "resp.resp_data.toByteArray()");
        return c16;
    }
}
