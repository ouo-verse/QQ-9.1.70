package com.tencent.beacon.a.b;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k extends com.tencent.beacon.a.b.a {

    /* renamed from: c, reason: collision with root package name */
    private static final int f77613c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f77614d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f77615e;

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f77616f;

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray<a> f77617g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray<Handler> f77618h;

    /* renamed from: i, reason: collision with root package name */
    private final l f77619i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f77620j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f77621a;

        /* renamed from: b, reason: collision with root package name */
        private final long f77622b;

        /* renamed from: c, reason: collision with root package name */
        private final long f77623c;

        /* renamed from: d, reason: collision with root package name */
        private final TimeUnit f77624d;

        /* renamed from: e, reason: collision with root package name */
        private Future<?> f77625e;

        a(Future<?> future, Runnable runnable, long j3, long j16, TimeUnit timeUnit) {
            this.f77625e = future;
            this.f77621a = runnable;
            this.f77622b = j3;
            this.f77623c = j16;
            this.f77624d = timeUnit;
        }

        boolean a(boolean z16) {
            return this.f77625e.cancel(z16);
        }

        boolean a() {
            return this.f77625e.isCancelled();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f77613c = availableProcessors;
        f77614d = Math.max(2, Math.min(availableProcessors - 1, 3));
        f77615e = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        this(null);
    }

    private boolean f() {
        if (!this.f77620j) {
            return false;
        }
        com.tencent.beacon.base.util.c.b("[task] was closed , should all stopped!", new Object[0]);
        return true;
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void a(@NonNull Runnable runnable) {
        if (f()) {
            return;
        }
        this.f77616f.execute(b(runnable));
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void b(int i3) {
        if (c()) {
            a aVar = this.f77617g.get(i3);
            if (aVar != null) {
                if (!aVar.a()) {
                } else {
                    aVar.f77625e = this.f77616f.scheduleAtFixedRate(aVar.f77621a, aVar.f77622b, aVar.f77623c, aVar.f77624d);
                }
            }
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void d() {
        com.tencent.beacon.base.util.c.a("[task] Resumed all schedule task", new Object[0]);
        if (f()) {
            return;
        }
        for (int i3 = 0; i3 < this.f77617g.size(); i3++) {
            b(this.f77617g.keyAt(i3));
        }
        com.tencent.beacon.base.util.c.a("[task] Resumed all schedule task", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScheduledExecutorService scheduledExecutorService) {
        this.f77620j = false;
        l lVar = new l();
        this.f77619i = lVar;
        this.f77616f = scheduledExecutorService == null ? ProxyExecutors.newScheduledThreadPool(f77614d, lVar) : scheduledExecutorService;
        this.f77617g = new SparseArray<>();
        this.f77618h = new SparseArray<>();
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void a(int i3, long j3, long j16, @NonNull Runnable runnable) {
        if (f()) {
            return;
        }
        a aVar = this.f77617g.get(i3);
        if (aVar == null || aVar.a()) {
            Runnable b16 = b(runnable);
            if (j3 <= 0) {
                j3 = 0;
            }
            if (j16 < 100) {
                j16 = 100;
            }
            ScheduledExecutorService scheduledExecutorService = this.f77616f;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            a aVar2 = new a(scheduledExecutorService.scheduleAtFixedRate(b16, j3, j16, timeUnit), b16, j3, j16, timeUnit);
            com.tencent.beacon.base.util.c.a("[task] add a new polling task! taskId: %d , periodTime: %d", Integer.valueOf(i3), Long.valueOf(j16));
            this.f77617g.put(i3, aVar2);
        }
    }

    private Runnable b(Runnable runnable) {
        return new j(this, runnable);
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(int i3, boolean z16) {
        a aVar = this.f77617g.get(i3);
        if (aVar == null || aVar.a()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[task] cancel a old pollingTaskWrapper!", new Object[0]);
        aVar.a(z16);
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void a(boolean z16) {
        if (f()) {
            return;
        }
        for (int i3 = 0; i3 < this.f77617g.size(); i3++) {
            a(this.f77617g.keyAt(i3), z16);
        }
        com.tencent.beacon.base.util.c.a("[task] All schedule tasks stop", new Object[0]);
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized void a(long j3, @NonNull Runnable runnable) {
        if (f()) {
            return;
        }
        Runnable b16 = b(runnable);
        if (j3 <= 0) {
            j3 = 0;
        }
        this.f77616f.schedule(b16, j3, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.beacon.a.b.a
    public synchronized Handler a(int i3) {
        Handler handler;
        handler = this.f77618h.get(i3);
        if (handler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.f77619i.a());
            baseHandlerThread.start();
            handler = new Handler(baseHandlerThread.getLooper());
        }
        this.f77618h.put(i3, handler);
        return handler;
    }
}
