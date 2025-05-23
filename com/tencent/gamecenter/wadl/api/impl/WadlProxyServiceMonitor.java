package com.tencent.gamecenter.wadl.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class WadlProxyServiceMonitor extends BaseThread {
    private g H;
    private final long C = 30000;
    private long D = 30000;
    private final long E = 60000;
    private final long F = 120000;
    private final int G = 3;
    private long I = 0;
    private long J = 0;
    private int K = 0;
    private volatile AtomicBoolean L = new AtomicBoolean(false);

    public WadlProxyServiceMonitor(g gVar) {
        this.H = gVar;
    }

    public boolean o() {
        return this.L.get();
    }

    public void p() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.I = elapsedRealtime;
        if (this.J == 0) {
            this.J = elapsedRealtime;
        }
        if (elapsedRealtime - this.J > 120000) {
            this.J = elapsedRealtime;
            if (this.K >= 3) {
                this.H.C3();
            }
            this.K = 0;
        } else {
            this.K++;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_WadlProxyServiceMonitor", 1, "onRecvHeart lastRecvReportTime=" + this.I + ",lastCheckTime=" + this.J + ",lastReportCount=" + this.K);
        }
    }

    public synchronized void q(float f16, boolean z16) {
        this.D = 30000.0f * f16;
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_WadlProxyServiceMonitor", 1, "setCheckRate rate=" + f16 + ",checkInterval=" + this.D + ",isServiceDied=" + z16);
        }
        if (z16) {
            this.K = 0;
        }
    }

    public synchronized void r() {
        try {
            if (!this.L.getAndSet(true)) {
                QLog.i("Wadl_WadlProxyServiceMonitor", 1, "startMonitoring...");
                setName("WadlProxyService.Monitor.Thread");
                start();
            } else {
                QLog.w("Wadl_WadlProxyServiceMonitor", 1, "startMonitoring,but is running");
            }
        } catch (Throwable th5) {
            QLog.e("Wadl_WadlProxyServiceMonitor", 1, "startMonitoring exception", th5);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.L.get()) {
            try {
                LockMethodProxy.sleep(this.D);
                if (this.L.get()) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = this.I;
                    if (j3 == 0 || elapsedRealtime - j3 > 60000) {
                        this.H.g4(1);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("Wadl_WadlProxyServiceMonitor", 1, "MonitorWorkingThread exception", th5);
                return;
            }
        }
        QLog.i("Wadl_WadlProxyServiceMonitor", 1, "MonitorWorkingThread is stop");
    }

    public synchronized void s() {
        QLog.i("Wadl_WadlProxyServiceMonitor", 1, "stopMonitoring");
        this.L.set(false);
    }
}
