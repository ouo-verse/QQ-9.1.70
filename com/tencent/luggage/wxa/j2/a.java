package com.tencent.luggage.wxa.j2;

import com.tencent.luggage.wxa.hn.d;
import com.tencent.luggage.wxa.hn.e;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.tn.w;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130765a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f130766b = "Luggage.CgiAdDataReport";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.j2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6323a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final C6323a f130767b = new C6323a();

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d call(d dVar) {
            Integer num;
            e9 e9Var;
            Integer num2;
            h0 h0Var;
            h0 h0Var2;
            String str = a.f130766b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AdDataReport runPipeline response:");
            String str2 = null;
            if (dVar != null && (h0Var2 = dVar.f128743d) != null) {
                num = Integer.valueOf(h0Var2.f127731d);
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(" errMsg:");
            if (dVar != null && (h0Var = dVar.f128743d) != null) {
                e9Var = h0Var.f127732e;
            } else {
                e9Var = null;
            }
            sb5.append(e9Var);
            sb5.append(", ret:");
            if (dVar != null) {
                num2 = Integer.valueOf(dVar.f127440e);
            } else {
                num2 = null;
            }
            sb5.append(num2);
            sb5.append(TokenParser.SP);
            if (dVar != null) {
                str2 = dVar.f127441f;
            }
            sb5.append(str2);
            w.d(str, sb5.toString());
            return dVar;
        }
    }

    public static final com.tencent.luggage.wxa.xo.d a(String appId, String hostAppId, int i3, String logStr, long j3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(hostAppId, "hostAppId");
        Intrinsics.checkNotNullParameter(logStr, "logStr");
        w.d(f130766b, "appId:" + appId + " hostAppId:" + hostAppId + " logId:" + i3 + " logStr:" + logStr);
        com.tencent.luggage.wxa.hn.c cVar = new com.tencent.luggage.wxa.hn.c();
        LinkedList linkedList = new LinkedList();
        cVar.f127370e = linkedList;
        e eVar = new e();
        eVar.f127527d = i3;
        byte[] bytes = logStr.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        eVar.f127528e = new com.tencent.luggage.wxa.fn.c(bytes);
        eVar.f127529f = j3;
        linkedList.add(eVar);
        com.tencent.luggage.wxa.xo.d b16 = ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmoc-bin/ad/addatareport", appId, cVar, d.class).b(C6323a.f130767b);
        Intrinsics.checkNotNullExpressionValue(b16, "customize(ICgiService::c\u2026xt response\n            }");
        return b16;
    }
}
