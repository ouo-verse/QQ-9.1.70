package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.qe;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.tn.w0;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f135177a = new g0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f135178b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f135179c;

        public a(String str, String str2) {
            this.f135178b = str;
            this.f135179c = str2;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final se call(se seVar) {
            if (seVar == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSync", "syncPipeline wxaAttrSyncResponse fail");
                return null;
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrSync", "syncPipeline appId:%s userName:%s wxaAttrSyncResponse errCode:%d errMsg:%s", this.f135178b, this.f135179c, Integer.valueOf(seVar.f128743d.f127731d), seVar.f128743d.f127732e);
            return seVar;
        }
    }

    public static final boolean a(String str) {
        return w0.d(com.tencent.luggage.wxa.fd.o0.a().c(str)) >= TimeUnit.MINUTES.toSeconds(5L);
    }

    public static final com.tencent.luggage.wxa.xo.e b(String str) {
        return a(str, null, 2, null);
    }

    public final com.tencent.luggage.wxa.xo.e c(String str) {
        return b("", str);
    }

    public static final com.tencent.luggage.wxa.xo.e b(String str, String str2) {
        qe qeVar = new qe();
        qeVar.f128525e = str2;
        qeVar.f128526f = com.tencent.luggage.wxa.fd.o0.a().d(str);
        qeVar.f128527g = str;
        com.tencent.luggage.wxa.xo.d b16 = ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", str, qeVar, se.class).b(new a(str, str2));
        Intrinsics.checkNotNullExpressionValue(b16, "appId: String?,\n        \u2026ncResponse\n            })");
        return b16;
    }

    public static /* synthetic */ se a(g0 g0Var, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return g0Var.a(str, str2);
    }

    public final se a(String str, String str2) {
        com.tencent.luggage.wxa.tn.w.a("Luggage.WxaAttrSync", "sync wxa app, appId=%s", str);
        qe qeVar = new qe();
        qeVar.f128525e = str2;
        qeVar.f128526f = com.tencent.luggage.wxa.fd.o0.a().d(str);
        qeVar.f128527g = str;
        se[] seVarArr = {null};
        se seVar = (se) ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).a("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", str, qeVar, se.class);
        if (seVar == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrSync", "sync %s, fail", str);
            return null;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrSync", "sync %s wxaAttrSyncResponse errCode:%d errMsg:%s", str, Integer.valueOf(seVar.f128743d.f127731d), seVar.f128743d.f127732e);
        seVarArr[0] = seVar;
        com.tencent.luggage.wxa.fd.o0.a().b(str, seVar);
        return seVarArr[0];
    }

    public static /* synthetic */ com.tencent.luggage.wxa.xo.e a(String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return b(str, str2);
    }
}
