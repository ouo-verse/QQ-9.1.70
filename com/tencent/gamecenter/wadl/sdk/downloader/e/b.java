package com.tencent.gamecenter.wadl.sdk.downloader.e;

import com.tencent.gamecenter.wadl.sdk.common.b.e;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f107384e = new b();

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f107385a;

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f107386b;

    /* renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f107387c;

    /* renamed from: d, reason: collision with root package name */
    private ThreadPoolExecutor f107388d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        private Future<?> f107389a;

        public a(Future<?> future) {
            this.f107389a = future;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.common.b.e
        public boolean a() {
            Future<?> future = this.f107389a;
            if (future != null) {
                try {
                    return future.cancel(false);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            return false;
        }
    }

    b() {
    }

    public e a(Runnable runnable) {
        if (this.f107386b == null) {
            this.f107386b = c();
        }
        return new a(this.f107386b.submit(new com.tencent.gamecenter.wadl.sdk.downloader.e.a(runnable, null)));
    }

    public synchronized e b(Runnable runnable) {
        if (this.f107385a == null) {
            this.f107385a = b();
        }
        return new a(this.f107385a.submit(new com.tencent.gamecenter.wadl.sdk.downloader.e.a(runnable, null)));
    }

    public e c(Runnable runnable) {
        if (this.f107387c == null) {
            this.f107387c = e();
        }
        return new a(this.f107387c.submit(new com.tencent.gamecenter.wadl.sdk.downloader.e.a(runnable, null)));
    }

    public e d(Runnable runnable) {
        if (this.f107388d == null) {
            this.f107388d = d();
        }
        return new a(this.f107388d.submit(runnable));
    }

    public synchronized ThreadPoolExecutor e() {
        if (this.f107387c == null) {
            int e16 = com.tencent.gamecenter.wadl.sdk.common.a.e();
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-ThreadPoolHolder", "[initScheduleExecutor], core_num:" + e16);
            this.f107387c = com.tencent.gamecenter.wadl.sdk.common.a.f106993p.getThreadPool("GameDownload-SchedulePool", e16, 20, 16, 5);
        }
        return this.f107387c;
    }

    public static b a() {
        return f107384e;
    }

    private synchronized ThreadPoolExecutor b() {
        if (this.f107385a == null) {
            this.f107385a = com.tencent.gamecenter.wadl.sdk.common.a.f106993p.getThreadPool("GameDownload-Default", 2, 6, 16, 5);
        }
        return this.f107385a;
    }

    private synchronized ThreadPoolExecutor c() {
        if (this.f107386b == null) {
            this.f107386b = com.tencent.gamecenter.wadl.sdk.common.a.f106993p.getThreadPool("GameDownload-DirectPool", 2, 6, 16, 5);
        }
        return this.f107386b;
    }

    private synchronized ThreadPoolExecutor d() {
        if (this.f107388d == null) {
            this.f107388d = com.tencent.gamecenter.wadl.sdk.common.a.f106993p.getThreadPool("GameDownload-HijackPool", 2, 6, 16, 5);
        }
        return this.f107388d;
    }
}
