package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.BlockingQueue;

/* compiled from: P */
/* loaded from: classes.dex */
public class NetworkDispatcher extends BaseThread {
    private final BlockingQueue<Request<?>> C;
    private final f D;
    private final c E;
    private final i F;
    private volatile boolean G = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, f fVar, c cVar, i iVar) {
        this.C = blockingQueue;
        this.D = fVar;
        this.E = cVar;
        this.F = iVar;
    }

    @TargetApi(14)
    private void c(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    private void d(Request<?> request, VolleyError volleyError) {
        this.F.c(request, request.parseNetworkError(volleyError));
    }

    private void o() throws InterruptedException {
        p(this.C.take());
    }

    @VisibleForTesting
    void p(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.sendEvent(3);
        try {
            try {
                request.addMarker("network-queue-take");
            } catch (VolleyError e16) {
                e16.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                d(request, e16);
                request.notifyListenerResponseNotUsable();
            } catch (Exception e17) {
                k.d(e17, "Unhandled exception %s", e17.toString());
                VolleyError volleyError = new VolleyError(e17);
                volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.F.c(request, volleyError);
                request.notifyListenerResponseNotUsable();
            }
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
                request.notifyListenerResponseNotUsable();
                return;
            }
            c(request);
            g a16 = this.D.a(request);
            request.addMarker("network-http-complete");
            if (a16.f31335e && request.hasHadResponseDelivered()) {
                request.finish("not-modified");
                request.notifyListenerResponseNotUsable();
                return;
            }
            h<?> parseNetworkResponse = request.parseNetworkResponse(a16);
            request.addMarker("network-parse-complete");
            if (request.shouldCache() && parseNetworkResponse.f31338b != null) {
                this.E.b(request.getCacheKey(), parseNetworkResponse.f31338b);
                request.addMarker("network-cache-written");
            }
            request.markDelivered();
            this.F.b(request, parseNetworkResponse);
            request.notifyListenerResponseReceived(parseNetworkResponse);
        } finally {
            request.sendEvent(4);
        }
    }

    public void quit() {
        this.G = true;
        interrupt();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                o();
            } catch (InterruptedException unused) {
                if (this.G) {
                    Thread.currentThread().interrupt();
                    return;
                }
                k.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
