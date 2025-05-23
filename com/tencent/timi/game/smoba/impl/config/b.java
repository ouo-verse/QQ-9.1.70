package com.tencent.timi.game.smoba.impl.config;

import trpc.yes.common.GameDataServerOuterClass$GetSmobaConfigRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f379349b;

    /* renamed from: a, reason: collision with root package name */
    private GetSmobaConfigRepo f379350a = new GetSmobaConfigRepo();

    b() {
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f379349b == null) {
                f379349b = new b();
            }
            bVar = f379349b;
        }
        return bVar;
    }

    public synchronized void a() {
        this.f379350a = null;
        f379349b = null;
    }

    public synchronized GameDataServerOuterClass$GetSmobaConfigRsp c() {
        return this.f379350a.b();
    }
}
