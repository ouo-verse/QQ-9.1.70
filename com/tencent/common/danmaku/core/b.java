package com.tencent.common.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.common.danmaku.tool.a f99643a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f99644b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99643a = new com.tencent.common.danmaku.tool.a();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f99643a.b();
        }
    }

    public Bitmap b(com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) bVar);
        }
        if (aVar != null) {
            synchronized (this) {
                if (aVar.N()) {
                    com.tencent.common.danmaku.util.e.a("create bitmap");
                    Bitmap m3 = aVar.m();
                    if (m3 == null) {
                        m3 = this.f99643a.c((int) aVar.y(), (int) aVar.x());
                    } else if (m3.getWidth() < ((int) aVar.y()) || m3.getHeight() < ((int) aVar.x())) {
                        this.f99643a.e(m3);
                        m3 = this.f99643a.c((int) aVar.y(), (int) aVar.x());
                    }
                    aVar.j0(m3);
                    com.tencent.common.danmaku.util.e.d();
                    if (m3 == null) {
                        return null;
                    }
                    Canvas n3 = aVar.n();
                    if (n3 == null) {
                        n3 = new Canvas(m3);
                        aVar.k0(n3);
                    } else {
                        n3.setBitmap(m3);
                    }
                    m3.eraseColor(0);
                    aVar.l0(false);
                    bVar.g(aVar).c(n3, aVar, bVar, com.tencent.common.danmaku.inject.b.p().e(), com.tencent.common.danmaku.inject.b.p().f());
                    return m3;
                }
                return aVar.m();
            }
        }
        throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }

    public void c(com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) bVar);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.f99644b;
        if (handlerThread != null && handlerThread.isAlive()) {
            if (com.tencent.common.danmaku.util.c.d()) {
                this.f99644b.quitSafely();
            } else {
                this.f99644b.quit();
            }
        }
    }

    public void e(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        } else {
            this.f99643a.e(bitmap);
        }
    }
}
