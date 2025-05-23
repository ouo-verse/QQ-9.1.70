package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.lb;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nf extends BaseThread {

    /* renamed from: c, reason: collision with root package name */
    private static final int f149446c = 80;

    /* renamed from: d, reason: collision with root package name */
    private ne f149449d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f149450e = false;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f149447a = false;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f149448b = false;

    public nf(ne neVar) {
        setName("tms-texture");
        this.f149449d = neVar;
        LogUtil.a(a()).c(lb.a.f149160g, "tms-texture thread create");
    }

    private void d() {
        LogUtil.a(a()).c(lb.a.f149160g, "tms-texture thread resume");
        this.f149447a = false;
        synchronized (this) {
            notifyAll();
        }
    }

    private boolean e() {
        tk tkVar;
        ne neVar = this.f149449d;
        if (neVar == null || (tkVar = neVar.f149396i) == null || tkVar.f150515e == 0) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - tkVar.f150522l > 560) {
            tkVar.f150514d.nativeClearDownloadURLCache(tkVar.f150515e);
            tkVar.f150522l = SystemClock.elapsedRealtime();
        }
        return tkVar.f150514d.nativeGenerateTextures(tkVar.f150515e);
    }

    private boolean f() {
        return this.f149448b;
    }

    public final int a() {
        ne neVar = this.f149449d;
        if (neVar != null) {
            return neVar.N;
        }
        return -1;
    }

    public final void b() {
        LogUtil.a(a()).c(lb.a.f149160g, "tms-texture thread stop");
        this.f149447a = false;
        this.f149450e = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public final void c() {
        LogUtil.a(a()).b(lb.a.f149160g, "tms-texture thread pause");
        this.f149447a = true;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        ne neVar;
        tk tkVar;
        LogUtil.a(a()).c(lb.a.f149160g, "tms-texture thread run");
        while (!this.f149450e) {
            boolean z16 = false;
            if (!this.f149447a && (neVar = this.f149449d) != null && (tkVar = neVar.f149396i) != null && tkVar.f150515e != 0) {
                if (SystemClock.elapsedRealtime() - tkVar.f150522l > 560) {
                    tkVar.f150514d.nativeClearDownloadURLCache(tkVar.f150515e);
                    tkVar.f150522l = SystemClock.elapsedRealtime();
                }
                z16 = tkVar.f150514d.nativeGenerateTextures(tkVar.f150515e);
            }
            if (!z16) {
                try {
                    synchronized (this) {
                        wait(80L);
                    }
                } catch (InterruptedException e16) {
                    LogUtil.b(Log.getStackTraceString(e16));
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.f149448b = true;
        LogUtil.a(a()).c(lb.a.f149160g, "tms-texture thread destroy");
    }
}
