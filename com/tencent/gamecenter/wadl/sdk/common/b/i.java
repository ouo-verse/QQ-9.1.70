package com.tencent.gamecenter.wadl.sdk.common.b;

import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    private static i f107033c = new i();

    /* renamed from: b, reason: collision with root package name */
    private Map<Runnable, TimerTask> f107035b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private Timer f107034a = new BaseTimer(h.a("ConnectionTimer"), true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f107036d;

        a(i iVar, Runnable runnable) {
            this.f107036d = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f107036d.run();
        }
    }

    i() {
    }

    public static i a() {
        return f107033c;
    }

    public void a(Runnable runnable, long j3) {
        a(runnable, false, j3);
    }

    private void a(Runnable runnable, boolean z16, long j3) {
        synchronized (runnable) {
            a(runnable);
            a aVar = new a(this, runnable);
            if (z16) {
                this.f107034a.schedule(aVar, j3, j3);
            } else {
                this.f107034a.schedule(aVar, j3);
            }
            this.f107035b.put(runnable, aVar);
        }
    }

    public boolean a(Runnable runnable) {
        synchronized (runnable) {
            TimerTask timerTask = this.f107035b.get(runnable);
            if (timerTask == null) {
                return true;
            }
            this.f107035b.remove(runnable);
            return timerTask.cancel();
        }
    }
}
