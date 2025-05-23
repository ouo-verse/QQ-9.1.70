package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.e3;
import com.tencent.luggage.wxa.hn.f3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f135199a = new j();

    public final String a(String appId, String hostAppId, int i3) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(hostAppId, "hostAppId");
        e3 e3Var = new e3();
        e3Var.f127539e = hostAppId;
        e3Var.f127540f = i3;
        f3 f3Var = (f3) ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getruntimesession", appId, e3Var, f3.class);
        if (f3Var != null) {
            str = f3Var.f127599e;
        } else {
            str = null;
        }
        if (str != null) {
            String str2 = f3Var.f127599e;
            Intrinsics.checkNotNullExpressionValue(str2, "response.session_id");
            if (str2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                com.tencent.luggage.wxa.tn.w.a("CgiGetRuntimeSession", "host_appid: " + hostAppId + " getSession_id " + f3Var.f127599e);
                String str3 = f3Var.f127599e;
                Intrinsics.checkNotNullExpressionValue(str3, "response.session_id");
                return str3;
            }
        }
        com.tencent.luggage.wxa.tn.w.b("CgiGetRuntimeSession", "host_appid: " + hostAppId + " getSession_id fail " + f3Var);
        return "";
    }
}
