package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.l;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class ActiveResources {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f31596a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f31597b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<com.bumptech.glide.load.c, a> f31598c;

    /* renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<l<?>> f31599d;

    /* renamed from: e, reason: collision with root package name */
    private l.a f31600e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f31601f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class a extends WeakReference<l<?>> {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.c f31604a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f31605b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        q<?> f31606c;

        a(@NonNull com.bumptech.glide.load.c cVar, @NonNull l<?> lVar, @NonNull ReferenceQueue<? super l<?>> referenceQueue, boolean z16) {
            super(lVar, referenceQueue);
            q<?> qVar;
            this.f31604a = (com.bumptech.glide.load.c) h0.j.d(cVar);
            if (lVar.c() && z16) {
                qVar = (q) h0.j.d(lVar.b());
            } else {
                qVar = null;
            }
            this.f31606c = qVar;
            this.f31605b = lVar.c();
        }

        void a() {
            this.f31606c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z16) {
        this(z16, ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull final Runnable runnable) {
                return new BaseThread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.bumptech.glide.load.c cVar, l<?> lVar) {
        a put = this.f31598c.put(cVar, new a(cVar, lVar, this.f31599d, this.f31596a));
        if (put != null) {
            put.a();
        }
    }

    void b() {
        while (!this.f31601f) {
            try {
                c((a) this.f31599d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(@NonNull a aVar) {
        q<?> qVar;
        synchronized (this) {
            this.f31598c.remove(aVar.f31604a);
            if (aVar.f31605b && (qVar = aVar.f31606c) != null) {
                this.f31600e.a(aVar.f31604a, new l<>(qVar, true, false, aVar.f31604a, this.f31600e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bumptech.glide.load.c cVar) {
        a remove = this.f31598c.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public synchronized l<?> e(com.bumptech.glide.load.c cVar) {
        a aVar = this.f31598c.get(cVar);
        if (aVar == null) {
            return null;
        }
        l<?> lVar = aVar.get();
        if (lVar == null) {
            c(aVar);
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(l.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f31600e = aVar;
            }
        }
    }

    @VisibleForTesting
    ActiveResources(boolean z16, Executor executor) {
        this.f31598c = new HashMap();
        this.f31599d = new ReferenceQueue<>();
        this.f31596a = z16;
        this.f31597b = executor;
        executor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}
