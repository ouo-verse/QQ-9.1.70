package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.a4;
import com.tencent.luggage.wxa.hn.b4;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f135202a = new k();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f135203b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f135204c;

        public a(String str, int i3) {
            this.f135203b = str;
            this.f135204c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean call(Void r26) {
            try {
                return Boolean.valueOf(k.a(this.f135203b, this.f135204c));
            } catch (Error e16) {
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                return Boolean.FALSE;
            }
        }
    }

    public static /* synthetic */ b4 a(k kVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return kVar.a(str, z16);
    }

    public static final com.tencent.luggage.wxa.xo.d b(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.luggage.wxa.xo.d d16 = com.tencent.luggage.wxa.xo.h.c().d(new a(appId, i3));
        Intrinsics.checkNotNullExpressionValue(d16, "appId: String, pkgType: \u2026\n            }\n        })");
        return d16;
    }

    public final b4 a(String str, boolean z16) {
        com.tencent.luggage.wxa.hn.h0 h0Var;
        com.tencent.luggage.wxa.hn.h0 h0Var2;
        a4 a4Var = new a4();
        a4Var.f127265e = str;
        a4Var.f127266f = z16;
        b4 b4Var = (b4) ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/getwxadebuginfo", str, a4Var, b4.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isLast:");
        sb5.append(z16);
        sb5.append(" response:");
        sb5.append((b4Var == null || (h0Var2 = b4Var.f128743d) == null) ? null : Integer.valueOf(h0Var2.f127731d));
        sb5.append(TokenParser.SP);
        sb5.append((b4Var == null || (h0Var = b4Var.f128743d) == null) ? null : h0Var.f127732e);
        sb5.append(" extJson:");
        sb5.append(b4Var != null ? b4Var.f127339e : null);
        com.tencent.luggage.wxa.tn.w.d("CgiGetWxaDebugInfo", sb5.toString());
        return b4Var;
    }

    public static final boolean a(String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (com.tencent.luggage.wxa.o3.l.f136139a.c()) {
            k kVar = f135202a;
            b4 a16 = a(kVar, appId, false, 2, null);
            if (a16 == null || a16.f128743d.f127731d == -12027) {
                a16 = kVar.a(appId, true);
            }
            if (a16 != null) {
                int i16 = a16.f128743d.f127731d;
                if (i16 != 0) {
                    if (i16 == -12026) {
                        throw new com.tencent.luggage.wxa.j3.a(5, null, 2, null);
                    }
                    if (i16 == -12025) {
                        throw new com.tencent.luggage.wxa.j3.a(6, null, 2, null);
                    }
                    if (i16 == -12005) {
                        throw new com.tencent.luggage.wxa.j3.a(4, null, 2, null);
                    }
                    if (i16 != -10002) {
                        throw new com.tencent.luggage.wxa.j3.a(1, "fail: ret " + a16.f128743d.f127731d);
                    }
                    throw new com.tencent.luggage.wxa.j3.a(3, null, 2, null);
                }
                JSONObject jSONObject = new JSONObject(a16.f127339e);
                com.tencent.luggage.wxa.tn.w.d("CgiGetWxaDebugInfo", "flushWxaDebugInfo " + appId + " updated:" + com.tencent.luggage.wxa.mc.j0.a().a(appId, i3, jSONObject.optString("downloadURL", ""), jSONObject.optString("checkSumMd5", "")) + " extInfoUpdated:" + com.tencent.luggage.wxa.ii.h.a().a(appId, i3, a16.f127339e));
                return true;
            }
            com.tencent.luggage.wxa.tn.w.b("CgiGetWxaDebugInfo", "wxaDebugInfo is null");
            throw new com.tencent.luggage.wxa.j3.a(1, "fail: request fail");
        }
        throw new com.tencent.luggage.wxa.j3.a(2, null, 2, null);
    }
}
