package com.tencent.qqperf.monitor.message;

import com.tencent.qqperf.monitor.message.SyncBarrierLeakFix;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SyncBarrierLeakFix f363280a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static b f363281a = new b();
    }

    public static b a() {
        return a.f363281a;
    }

    public void b(SyncBarrierLeakFix.SyncBarrierLeakFixConfig syncBarrierLeakFixConfig) {
        if (this.f363280a == null) {
            this.f363280a = new SyncBarrierLeakFix();
        }
        this.f363280a.k();
        this.f363280a.n(syncBarrierLeakFixConfig);
    }
}
