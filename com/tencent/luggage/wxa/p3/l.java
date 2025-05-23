package com.tencent.luggage.wxa.p3;

import com.tencent.luggage.wxa.hn.g0;
import com.tencent.luggage.wxa.hn.hh;
import com.tencent.luggage.wxa.hn.ih;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.xa;
import com.tencent.luggage.wxa.n3.b0;
import com.tencent.luggage.wxa.tn.w;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l extends i {

    /* renamed from: g, reason: collision with root package name */
    public final String f137207g = "TdiCgiServiceNoLogin";

    @Override // com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public void a(b tdiCgi) {
        Intrinsics.checkNotNullParameter(tdiCgi, "tdiCgi");
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public Class c() {
        return ih.class;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public abstract String i();

    @Override // com.tencent.luggage.wxa.p3.i
    public int n() {
        return a.f137135a.a();
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public String r() {
        return a.f137135a.b();
    }

    public final String u() {
        return com.tencent.luggage.wxa.s3.f.c();
    }

    public final String v() {
        return com.tencent.luggage.wxa.s3.f.f140021a.d();
    }

    public final String w() {
        return com.tencent.luggage.wxa.s3.f.f140021a.e();
    }

    @Override // com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public void z() {
        w.d(i(), "uninstall appId:" + u());
        super.z();
    }

    @Override // com.tencent.luggage.wxa.p3.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public hh a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar) {
        hh hhVar = new hh();
        a(hhVar);
        hhVar.f127810e = str;
        hhVar.f127811f = u();
        hhVar.f127813h = new com.tencent.luggage.wxa.fn.c(bVar != null ? bVar.b() : null);
        hhVar.f127812g = g.a();
        hhVar.f127814i = str2;
        hhVar.f127816k = v();
        hhVar.f127817l = w();
        g gVar = g.f137156a;
        hhVar.f127815j = gVar.a(str);
        hhVar.f127818m = gVar.c();
        w.a(i(), "url:" + str + " appId:" + str2 + " host_appId:" + u() + " token:" + v() + " username:" + w() + " cmdid:" + hhVar.f127815j + " req");
        return hhVar;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public xa a(ih ihVar) {
        Intrinsics.checkNotNullParameter(ihVar, "<this>");
        return ihVar.f127906f;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public com.tencent.luggage.wxa.n3.b a(int i3, String url, com.tencent.luggage.wxa.n3.w networkType, com.tencent.luggage.wxa.fn.b bVar) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        b0 b0Var = b0.HYBRID_ECDH;
        byte[] b16 = bVar != null ? bVar.b() : null;
        if (b16 == null) {
            b16 = new byte[0];
        }
        return new com.tencent.luggage.wxa.n3.b(i3, b0Var, b16, url, networkType, 30000);
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public void a(com.tencent.luggage.wxa.fn.b bVar) {
        if (bVar instanceof s8) {
            s8 s8Var = (s8) bVar;
            if (s8Var.f128671d == null) {
                g0 g0Var = new g0();
                s8Var.f128671d = g0Var;
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
    public byte[] b(ih resp) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        byte[] c16 = resp.f127905e.c();
        Intrinsics.checkNotNullExpressionValue(c16, "resp.resp_data.toByteArray()");
        return c16;
    }

    @Override // com.tencent.luggage.wxa.p3.i
    public void b(com.tencent.luggage.wxa.fn.b bVar) {
        if (bVar instanceof hh) {
            hh hhVar = (hh) bVar;
            hhVar.f127816k = v();
            hhVar.f127817l = w();
            w.e(i(), "find bug " + v() + TokenParser.SP + w());
        }
    }
}
