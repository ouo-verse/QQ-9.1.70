package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NetworkDispatcher extends BaseThread {
    private final BlockingQueue<Request> C;
    private final h D;
    private final l E;
    private volatile boolean F = false;

    public NetworkDispatcher(BlockingQueue<Request> blockingQueue, h hVar, l lVar) {
        this.C = blockingQueue;
        this.D = hVar;
        this.E = lVar;
        setName("Super_TVK_NetworkDispatcher");
    }

    @TargetApi(14)
    private void c(Request request) {
        TrafficStats.setThreadStatsTag(request.m());
    }

    private void o() throws InterruptedException {
        p(this.C.take());
    }

    @VisibleForTesting
    void p(Request request) {
        try {
            if (request.o()) {
                request.h();
                return;
            }
            c(request);
            this.E.a(request, this.D.a(request));
        } catch (IOException e16) {
            this.E.b(request, e16);
        }
    }

    public void quit() {
        this.F = true;
        interrupt();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                o();
            } catch (Throwable unused) {
                if (this.F) {
                    Thread.currentThread().interrupt();
                    return;
                }
                Log.e("NetworkDispatcher", "Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it");
            }
        }
    }
}
