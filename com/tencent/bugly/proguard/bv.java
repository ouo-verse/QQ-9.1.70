package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bv extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    public bu f98353a;

    /* renamed from: g, reason: collision with root package name */
    private a f98359g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f98355c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f98356d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f98357e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f98358f = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f98354b = true;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    public final boolean a() {
        this.f98355c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e16) {
            av.b(e16);
        }
        av.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.f98353a = null;
        return true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bu buVar = this.f98353a;
        if (buVar != null) {
            buVar.f98347b = 5000L;
        } else {
            this.f98353a = new bu(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e16) {
            av.b(e16);
            return false;
        }
    }

    public final synchronized void c() {
        this.f98356d = false;
        av.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f98357e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        r2.d();
     */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        bu buVar;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f98355c) {
            try {
                buVar = this.f98353a;
                z16 = false;
            } catch (Exception e16) {
                av.b(e16);
            } catch (OutOfMemoryError e17) {
                av.b(e17);
            }
            if (buVar == null) {
                av.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                return;
            }
            if (buVar.f98348c) {
                buVar.f98348c = false;
                buVar.f98349d = SystemClock.uptimeMillis();
                buVar.f98346a.post(buVar);
            }
            a(buVar);
            if (this.f98354b && this.f98356d) {
                long b16 = buVar.b();
                if (b16 > 1510 && b16 < 199990) {
                    boolean z17 = true;
                    if (b16 <= 5010) {
                        this.f98358f = 1;
                        av.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                    } else {
                        int i3 = this.f98358f + 1;
                        this.f98358f = i3;
                        if ((i3 & (i3 - 1)) != 0) {
                            z17 = false;
                        }
                        if (z17) {
                            av.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                        }
                    }
                    z16 = z17;
                }
            }
            if (this.f98359g != null && this.f98356d) {
                buVar.a();
                buVar.b();
            }
            ba.b(500 - ((System.currentTimeMillis() - currentTimeMillis) % 500));
        }
    }

    private synchronized void a(bu buVar) {
        if (this.f98356d) {
            return;
        }
        if (this.f98357e && !buVar.a()) {
            av.c("Restart getting main stack trace.", new Object[0]);
            this.f98356d = true;
            this.f98357e = false;
        }
    }
}
