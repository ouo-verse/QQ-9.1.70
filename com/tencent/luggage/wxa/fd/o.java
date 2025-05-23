package com.tencent.luggage.wxa.fd;

import android.os.SystemClock;
import android.webkit.WebSettings;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f125947a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f125948b = new AtomicReference();

    public static final String b(String str) {
        if (str == null || str.length() == 0) {
            str = f125947a.b();
        }
        String str2 = (String) f125948b.getAndSet(str);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + str + " ]");
        if (!Intrinsics.areEqual(str, str2)) {
            f125947a.a(str);
        }
        return str;
    }

    public static final String d() {
        boolean z16;
        AtomicReference atomicReference = f125948b;
        String str = (String) atomicReference.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
            Intrinsics.checkNotNullExpressionValue(str, "this");
            return str;
        }
        String e16 = e();
        atomicReference.set(e16);
        return e16;
    }

    public static final String e() {
        String str;
        o oVar;
        String str2;
        String str3;
        boolean z16;
        String str4;
        com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        o oVar2 = f125947a;
        String a16 = oVar2.a();
        if (a16 == null || (str = a16.toString()) == null) {
            str = "";
        }
        boolean a17 = com.tencent.luggage.wxa.uk.l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 32 && a17) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("block main thread and skip ");
            oVar = oVar2;
            str2 = a16;
            str3 = "";
            sb5.append((int) (elapsedRealtime2 / 16));
            sb5.append(" frames! runProfiled:log:");
            sb5.append("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv");
            sb5.append(" cost ");
            sb5.append(elapsedRealtime2);
            sb5.append(" ms result:");
            sb5.append(str);
            sb5.append(" isMainThread: ");
            sb5.append(a17);
            sb5.append(TokenParser.SP);
            com.tencent.luggage.wxa.tn.w.f("Luggage.Utils.Profile", sb5.toString());
        } else {
            oVar = oVar2;
            str2 = a16;
            str3 = "";
            com.tencent.luggage.wxa.tn.w.d("Luggage.Utils.Profile", "runProfiled:log:Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + a17 + TokenParser.SP);
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return str2;
        }
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        String b16 = oVar.b();
        if (b16 == null || (str4 = b16.toString()) == null) {
            str4 = str3;
        }
        boolean a18 = com.tencent.luggage.wxa.uk.l0.a();
        long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime3;
        if (elapsedRealtime4 > 32 && a18) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime4 / 16)) + " frames! runProfiled:log:Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit cost " + elapsedRealtime4 + " ms result:" + str4 + " isMainThread: " + a18 + TokenParser.SP);
        } else {
            com.tencent.luggage.wxa.tn.w.d("Luggage.Utils.Profile", "runProfiled:log:Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit cost " + elapsedRealtime4 + " ms result:" + str4 + " isMainThread: " + a18 + TokenParser.SP);
        }
        Intrinsics.checkNotNull(b16);
        return b16;
    }

    public final String a() {
        return c().c("UserAgent");
    }

    public final com.tencent.luggage.wxa.tn.f0 c() {
        return com.tencent.luggage.wxa.tn.f0.c("AppBrandNetworkConfigUserAgentHelper", 2);
    }

    public final boolean a(String str) {
        return c().b("UserAgent", str);
    }

    public final String b() {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(com.tencent.luggage.wxa.tn.z.c());
            Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "{\n            WebSetting\u2026t.getContext())\n        }");
            return defaultUserAgent;
        } catch (Throwable unused) {
            String property = System.getProperty("http.agent");
            return property == null ? "" : property;
        }
    }
}
