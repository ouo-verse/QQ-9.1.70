package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f130596g = {com.tencent.luggage.wxa.xn.c.a(u.f130592u, "PluginDevLaunchInfo")};

    public w(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, u.f130592u, "PluginDevLaunchInfo", com.tencent.luggage.wxa.q9.j.f138408m);
    }

    public boolean a(String str, String str2, long j3) {
        if (w0.c(str)) {
            return false;
        }
        u uVar = new u();
        uVar.f138415b = str;
        uVar.f138417d = str2;
        uVar.f138419f = j3;
        if (super.b(uVar, u.f130591t)) {
            uVar.f138419f = j3;
            boolean c16 = super.c(uVar, new String[0]);
            com.tencent.luggage.wxa.tn.w.d("PluginDevLaunchInfoStorage", "setPluginInfo update appId:%s,versionDesc:%s,devUin:%d ret:%b", str, str2, Long.valueOf(j3), Boolean.valueOf(c16));
            return c16;
        }
        boolean a16 = super.a(uVar);
        com.tencent.luggage.wxa.tn.w.d("PluginDevLaunchInfoStorage", "setPluginInfo insert appId:%s,versionDesc:%s,devUin:%d ret:%b", str, str2, Long.valueOf(j3), Boolean.valueOf(a16));
        return a16;
    }
}
