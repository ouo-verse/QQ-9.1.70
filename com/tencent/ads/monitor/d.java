package com.tencent.ads.monitor;

import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes37.dex */
public final class d implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ PingService f61671d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e f61672e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PingService pingService, e eVar) {
        this.f61671d = pingService;
        this.f61672e = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Queue queue;
        e eVar = this.f61672e;
        if (eVar == null || PingService.doRequestPing(eVar)) {
            return;
        }
        queue = this.f61671d.f61662g;
        queue.offer(this.f61672e);
        PingService.b(this.f61671d, this.f61672e);
        this.f61671d.c();
    }
}
