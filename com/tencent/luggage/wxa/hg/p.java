package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.bf.s0;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.rc.c0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f127173a = new p();

    public final b a(com.tencent.luggage.wxa.c5.e runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        b bVar = (b) runtime.c(b.class);
        if (bVar != null) {
            return bVar;
        }
        com.tencent.luggage.wxa.j4.d S = runtime.S();
        String a16 = S != null ? com.tencent.luggage.wxa.y8.h.a(S.f130798j0) : null;
        if (a16 == null) {
            w.b("MicroMsg.AppBrand.SmStorageFactory", "getOrCreate, uin is null");
            return null;
        }
        String appId = runtime.getAppId();
        if (appId == null) {
            w.b("MicroMsg.AppBrand.SmStorageFactory", "getOrCreate, appId is null");
            return null;
        }
        c0 a17 = s0.a(a16, appId);
        com.tencent.luggage.wxa.rc.l mkdir = a17.mkdir("wxfile://clientdata/TSMStorage", true);
        Intrinsics.checkNotNullExpressionValue(mkdir, "clientPrivateFS.mkdir(sm\u2026ageDirRelativePath, true)");
        if (com.tencent.luggage.wxa.rc.l.OK != mkdir && com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS != mkdir) {
            w.b("MicroMsg.AppBrand.SmStorageFactory", "getOrCreate, mkdir fail, ret: " + mkdir);
            return null;
        }
        String b16 = x.b(new v(a17.i(), "TSMStorage").g(), true);
        if (b16 == null) {
            w.b("MicroMsg.AppBrand.SmStorageFactory", "getOrCreate, smStorageRootPath is null");
            return null;
        }
        w.d("MicroMsg.AppBrand.SmStorageFactory", "getOrCreate, uin: " + a16 + ", appId: " + appId + ", smStorageRootPath: " + b16);
        q a18 = a(b16, appId, a16);
        runtime.a((com.tencent.luggage.wxa.xd.m) a18);
        return a18;
    }

    public q a(String rootPath, String appId, String userId) {
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return q.f127174f.a(rootPath, appId, userId);
    }
}
