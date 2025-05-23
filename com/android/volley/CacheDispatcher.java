package com.android.volley;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.android.volley.c;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.BlockingQueue;

/* compiled from: P */
/* loaded from: classes.dex */
public class CacheDispatcher extends BaseThread {
    private static final boolean I = k.f31342b;
    private final BlockingQueue<Request<?>> C;
    private final BlockingQueue<Request<?>> D;
    private final c E;
    private final i F;
    private volatile boolean G = false;
    private final l H;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, c cVar, i iVar) {
        this.C = blockingQueue;
        this.D = blockingQueue2;
        this.E = cVar;
        this.F = iVar;
        this.H = new l(this, blockingQueue2, iVar);
    }

    private void o() throws InterruptedException {
        p(this.C.take());
    }

    @VisibleForTesting
    void p(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.sendEvent(1);
        try {
            if (request.isCanceled()) {
                request.finish("cache-discard-canceled");
                return;
            }
            c.a aVar = this.E.get(request.getCacheKey());
            if (aVar == null) {
                request.addMarker("cache-miss");
                if (!this.H.c(request)) {
                    this.D.put(request);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar.b(currentTimeMillis)) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(aVar);
                if (!this.H.c(request)) {
                    this.D.put(request);
                }
                return;
            }
            request.addMarker("cache-hit");
            h<?> parseNetworkResponse = request.parseNetworkResponse(new g(aVar.f31317a, aVar.f31323g));
            request.addMarker("cache-hit-parsed");
            if (!parseNetworkResponse.b()) {
                request.addMarker("cache-parsing-failed");
                this.E.a(request.getCacheKey(), true);
                request.setCacheEntry(null);
                if (!this.H.c(request)) {
                    this.D.put(request);
                }
                return;
            }
            if (!aVar.c(currentTimeMillis)) {
                this.F.b(request, parseNetworkResponse);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(aVar);
                parseNetworkResponse.f31340d = true;
                if (!this.H.c(request)) {
                    this.F.a(request, parseNetworkResponse, new Runnable() { // from class: com.android.volley.CacheDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CacheDispatcher.this.D.put(request);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                } else {
                    this.F.b(request, parseNetworkResponse);
                }
            }
        } finally {
            request.sendEvent(2);
        }
    }

    public void quit() {
        this.G = true;
        interrupt();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (I) {
            k.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.E.initialize();
        while (true) {
            try {
                o();
            } catch (InterruptedException unused) {
                if (this.G) {
                    Thread.currentThread().interrupt();
                    return;
                }
                k.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
