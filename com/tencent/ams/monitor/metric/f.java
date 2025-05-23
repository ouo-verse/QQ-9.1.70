package com.tencent.ams.monitor.metric;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
class f implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70581a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f70582b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f70583c;

    public f(WeakReference<j> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            return;
        }
        this.f70581a = new d(weakReference);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AdMetricThread");
        this.f70582b = baseHandlerThread;
        baseHandlerThread.start();
        this.f70583c = new Handler(this.f70582b.getLooper());
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean postDelayed(Runnable runnable, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, runnable, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (!this.f70582b.isAlive()) {
            this.f70581a.a("AdMetricThreadManagerAdapter", "[postDelayed] do nothing, mHandlerThread is not alive");
            return false;
        }
        return this.f70583c.postDelayed(runnable, j3);
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean quitSafely() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f70582b.quitSafely();
    }
}
