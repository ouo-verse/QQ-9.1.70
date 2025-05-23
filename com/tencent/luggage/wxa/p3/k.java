package com.tencent.luggage.wxa.p3;

import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.n3.o0;
import com.tencent.luggage.wxa.n3.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements d, com.tencent.luggage.wxa.bj.c, com.tencent.luggage.wxa.ya.b {

    /* renamed from: a, reason: collision with root package name */
    public static final k f137201a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final d f137202b = new o();

    /* renamed from: c, reason: collision with root package name */
    public static final j f137203c = new j();

    /* renamed from: d, reason: collision with root package name */
    public static final d f137204d = new n();

    /* renamed from: e, reason: collision with root package name */
    public static final d f137205e = new m();

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedList f137206f;

    static {
        LinkedList linkedList = new LinkedList();
        f137206f = linkedList;
        linkedList.add("/cgi-bin/mmoc-bin/hardware/getwerunuserstate");
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void G() {
        com.tencent.luggage.wxa.ya.b bVar;
        d[] dVarArr = {f137202b, f137203c, f137204d, f137205e};
        for (int i3 = 0; i3 < 4; i3++) {
            d dVar = dVarArr[i3];
            if (dVar instanceof com.tencent.luggage.wxa.ya.b) {
                bVar = (com.tencent.luggage.wxa.ya.b) dVar;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.G();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public void a(b tdiCgi) {
        Intrinsics.checkNotNullParameter(tdiCgi, "tdiCgi");
        if (z.m()) {
            f137202b.a(tdiCgi);
        }
    }

    public final d b() {
        return f137204d;
    }

    public final d c() {
        return f137202b;
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void e() {
        com.tencent.luggage.wxa.ya.b bVar;
        d[] dVarArr = {f137202b, f137203c, f137204d, f137205e};
        for (int i3 = 0; i3 < 4; i3++) {
            d dVar = dVarArr[i3];
            if (dVar instanceof com.tencent.luggage.wxa.ya.b) {
                bVar = (com.tencent.luggage.wxa.ya.b) dVar;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public void z() {
        f137202b.z();
        f137203c.z();
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public com.tencent.luggage.wxa.xo.d b(int i3, String url, w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        if (z.m()) {
            return f137202b.b(i3, url, networkType, bVar, respClazz);
        }
        return f137203c.b(i3, url, networkType, bVar, respClazz);
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public t8 a(int i3, String url, w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        if (com.tencent.luggage.wxa.o3.l.f136139a.c()) {
            if (z.m()) {
                return f137202b.a(i3, url, networkType, bVar, respClazz);
            }
            return f137203c.a(i3, url, networkType, bVar, respClazz);
        }
        if (z.m()) {
            return f137204d.a(i3, url, networkType, bVar, respClazz);
        }
        return f137205e.a(i3, url, networkType, bVar, respClazz);
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public com.tencent.luggage.wxa.xo.d b(String url, String str, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        com.tencent.luggage.wxa.xo.d b16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        if (a(url)) {
            if (com.tencent.luggage.wxa.o3.l.f136139a.c()) {
                if (z.m()) {
                    b16 = f137202b.b(url, str, bVar, respClazz);
                } else {
                    b16 = f137203c.b(url, str, bVar, respClazz);
                }
                Intrinsics.checkNotNullExpressionValue(b16, "{\n                if (MM\u2026          }\n            }");
            } else {
                if (z.m()) {
                    b16 = f137204d.b(url, str, bVar, respClazz);
                } else {
                    b16 = f137205e.b(url, str, bVar, respClazz);
                }
                Intrinsics.checkNotNullExpressionValue(b16, "{\n                if (MM\u2026         }\n\n            }");
            }
            return b16;
        }
        com.tencent.luggage.wxa.xo.d b17 = o0.f135228a.b(url, str, bVar, respClazz);
        Intrinsics.checkNotNullExpressionValue(b17, "INSTANCE.syncPipeline(url, appId, req, respClazz)");
        return b17;
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public t8 a(String url, String str, com.tencent.luggage.wxa.fn.b req, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        if (a(url)) {
            if (com.tencent.luggage.wxa.o3.l.f136139a.c()) {
                if (z.m()) {
                    return f137202b.a(url, str, req, respClazz);
                }
                return f137203c.a(url, str, req, respClazz);
            }
            if (z.m()) {
                return f137204d.a(url, str, req, respClazz);
            }
            return f137205e.a(url, str, req, respClazz);
        }
        return o0.f135228a.a(url, str, req, respClazz);
    }

    public final boolean a(String str) {
        return !f137206f.contains(str);
    }
}
