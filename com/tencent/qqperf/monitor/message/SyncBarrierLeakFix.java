package com.tencent.qqperf.monitor.message;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SyncBarrierLeakFix implements Handler.Callback {
    public static final Boolean G = Boolean.FALSE;
    private volatile boolean C;
    private int D;
    private Handler E;
    private MessageQueue F;

    /* renamed from: d, reason: collision with root package name */
    private bc f363273d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f363274e;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f363276h;

    /* renamed from: m, reason: collision with root package name */
    private int f363278m;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f363275f = false;

    /* renamed from: i, reason: collision with root package name */
    private SyncBarrierLeakFixConfig f363277i = new SyncBarrierLeakFixConfig();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class InnerSyncBarrierLagRunnable implements Runnable {
        InnerSyncBarrierLagRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SyncBarrierLeakFix.this.C) {
                SyncBarrierLeakFix.this.l("innerSyncBarrierLagRunnable run");
                Message d16 = a.d(SyncBarrierLeakFix.this.F);
                if (d16 != null && d16.getTarget() == null) {
                    long f16 = a.f(d16);
                    int i3 = d16.arg1;
                    SyncBarrierLeakFix.this.l("innerSyncBarrierLagRunnable find Barrier, checkToken:" + i3 + " dis:" + f16);
                    if (f16 > SyncBarrierLeakFix.this.f363277i.timeout) {
                        QLog.w("SyncBarrierLeakFix", 1, "send verify msg");
                        SyncBarrierLeakFix.this.C = true;
                        SyncBarrierLeakFix.this.f363278m = i3;
                        SyncBarrierLeakFix.this.m(true);
                        SyncBarrierLeakFix.this.m(false);
                        SyncBarrierLeakFix.this.m(true);
                        SyncBarrierLeakFix.this.m(false);
                        SyncBarrierLeakFix.this.m(true);
                        SyncBarrierLeakFix.this.m(false);
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        SyncBarrierLeakFix.this.E.sendMessage(obtain);
                        return;
                    }
                }
                SyncBarrierLeakFix.this.f363273d.postDelayed(SyncBarrierLeakFix.this.f363274e, SyncBarrierLeakFix.this.f363277i.checkTick);
            }
        }
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes25.dex */
    public static class SyncBarrierLeakFixConfig implements IConfigData {
        public boolean enable;
        public boolean remove;
        public int checkTick = 5000;
        public int timeout = 10000;

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("SyncBarrierLeakFixConfig:<" + this.enable);
            sb5.append("|" + this.remove);
            sb5.append("|" + this.checkTick);
            sb5.append("|" + this.timeout + ">");
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        if (G.booleanValue()) {
            QLog.d("SyncBarrierLeakFix", 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        Message obtain = Message.obtain();
        if (z16) {
            obtain.what = 1;
            obtain.setAsynchronous(true);
        } else {
            obtain.what = 2;
        }
        this.E.sendMessage(obtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        String str;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                this.C = false;
                if (!this.f363276h || this.f363277i.remove) {
                    this.f363273d.postDelayed(this.f363274e, this.f363277i.checkTick);
                }
                return true;
            }
            this.D = 0;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SyncBarrierLeakFix", 2, "handle aync msg");
        }
        int i16 = this.D + 1;
        this.D = i16;
        if (i16 == 3) {
            Message d16 = a.d(this.F);
            if (d16.arg1 == this.f363278m && d16.getTarget() == null) {
                QLog.e("SyncBarrierLeakFix", 1, "barrier msg leak, token: " + this.f363278m);
                if (!this.f363276h) {
                    this.f363276h = true;
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        str = peekAppRuntime.getCurrentUin();
                    } else {
                        str = "";
                    }
                    QQBeaconReport.report(str, "barrier_leak");
                }
                if (this.f363277i.remove) {
                    QLog.d("SyncBarrierLeakFix", 1, "removeSyncBarrier run lastWarningToken:" + this.f363278m);
                    a.k(this.f363278m);
                }
            } else {
                QLog.d("SyncBarrierLeakFix", 1, "barrier msg removed alredy: " + this.f363278m);
            }
        }
        return true;
    }

    public synchronized boolean k() {
        boolean z16;
        z16 = true;
        if (this.f363273d == null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.F = mainLooper.getQueue();
                this.E = new Handler(mainLooper, this);
                this.f363273d = ThreadManagerV2.newHandlerRecycleThread("Perf_SyncBarrierLeakFix", 5).b();
                this.f363274e = new InnerSyncBarrierLagRunnable();
                this.f363273d.post(new Runnable() { // from class: com.tencent.qqperf.monitor.message.SyncBarrierLeakFix.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.perf.tool.a.f258204a.b();
                    }
                });
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public synchronized boolean n(SyncBarrierLeakFixConfig syncBarrierLeakFixConfig) {
        String syncBarrierLeakFixConfig2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateConfig config is ");
        if (syncBarrierLeakFixConfig == null) {
            syncBarrierLeakFixConfig2 = "null";
        } else {
            syncBarrierLeakFixConfig2 = syncBarrierLeakFixConfig.toString();
        }
        sb5.append(syncBarrierLeakFixConfig2);
        QLog.d("SyncBarrierLeakFix", 1, sb5.toString());
        if (syncBarrierLeakFixConfig == null) {
            return false;
        }
        this.f363277i = syncBarrierLeakFixConfig;
        if (syncBarrierLeakFixConfig.enable) {
            if (!this.f363275f) {
                this.f363273d.postDelayed(this.f363274e, this.f363277i.checkTick);
                this.f363275f = true;
            }
        } else if (this.f363275f) {
            this.f363273d.f(this.f363274e);
            this.f363275f = false;
        }
        return true;
    }
}
