package com.tencent.common.danmaku.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DanmakuMeasureManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f99627a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f99628b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.common.danmaku.inject.b f99629c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(com.tencent.common.danmaku.data.a aVar);
    }

    public DanmakuMeasureManager(com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f99629c = bVar;
        }
    }

    private Handler b() {
        HandlerThread handlerThread = this.f99627a;
        if (handlerThread == null || !handlerThread.isAlive()) {
            try {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("DanmakuMeasureThread");
                this.f99627a = baseHandlerThread;
                baseHandlerThread.start();
                this.f99627a.setUncaughtExceptionHandler(new com.tencent.common.danmaku.util.b());
                this.f99628b = new Handler(this.f99627a.getLooper());
            } catch (Throwable th5) {
                com.tencent.common.danmaku.util.e.c("DanmakuMeasureManager", th5);
            }
        }
        return this.f99628b;
    }

    public static void c(com.tencent.common.danmaku.inject.b bVar, com.tencent.common.danmaku.data.a aVar) {
        if (aVar.S()) {
            return;
        }
        com.tencent.common.danmaku.util.a e16 = bVar.g(aVar).e(aVar);
        aVar.t0(e16.b() + (com.tencent.common.danmaku.inject.b.p().e() * 2));
        aVar.s0(e16.a() + (com.tencent.common.danmaku.inject.b.p().f() * 2));
        aVar.b();
    }

    public void d(com.tencent.common.danmaku.data.a aVar, a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        Handler b16 = b();
        if (b16 != null) {
            b16.post(new Runnable(aVar, aVar2) { // from class: com.tencent.common.danmaku.core.DanmakuMeasureManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.common.danmaku.data.a f99630d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ a f99631e;

                {
                    this.f99630d = aVar;
                    this.f99631e = aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DanmakuMeasureManager.this, aVar, aVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DanmakuMeasureManager.c(DanmakuMeasureManager.this.f99629c, this.f99630d);
                    a aVar3 = this.f99631e;
                    if (aVar3 != null) {
                        aVar3.a(this.f99630d);
                    }
                }
            });
        }
    }

    public void e(List<com.tencent.common.danmaku.data.a> list, a aVar) {
        Handler b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) aVar);
        } else if (list != null && list.size() != 0 && (b16 = b()) != null) {
            b16.post(new Runnable(list, aVar) { // from class: com.tencent.common.danmaku.core.DanmakuMeasureManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f99632d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ a f99633e;

                {
                    this.f99632d = list;
                    this.f99633e = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DanmakuMeasureManager.this, list, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    for (com.tencent.common.danmaku.data.a aVar2 : new ArrayList(this.f99632d)) {
                        DanmakuMeasureManager.c(DanmakuMeasureManager.this.f99629c, aVar2);
                        a aVar3 = this.f99633e;
                        if (aVar3 != null) {
                            aVar3.a(aVar2);
                        }
                    }
                }
            });
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.f99627a;
        if (handlerThread != null && handlerThread.isAlive()) {
            if (com.tencent.common.danmaku.util.c.d()) {
                this.f99627a.quitSafely();
            } else {
                this.f99627a.quit();
            }
        }
    }
}
