package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.common.danmaku.inject.l;
import com.tencent.common.danmaku.render.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements g, SurfaceHolder.Callback, View.OnAttachStateChangeListener {
    static IPatchRedirector $redirector_;
    private volatile Object C;
    private volatile boolean D;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f99757d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceHolder f99758e;

    /* renamed from: f, reason: collision with root package name */
    private g.a f99759f;

    /* renamed from: h, reason: collision with root package name */
    private volatile ReentrantLock f99760h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Object f99761i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f99762m;

    public h(SurfaceView surfaceView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) surfaceView);
            return;
        }
        this.D = false;
        this.f99757d = surfaceView;
        surfaceView.setWillNotCacheDrawing(true);
        this.f99757d.setDrawingCacheEnabled(false);
        this.f99757d.setWillNotDraw(true);
        this.f99757d.setZOrderMediaOverlay(true);
        SurfaceHolder holder = this.f99757d.getHolder();
        this.f99758e = holder;
        holder.addCallback(this);
        this.f99758e.setFormat(-2);
        this.f99757d.addOnAttachStateChangeListener(this);
    }

    private void h() {
        this.f99761i = com.tencent.common.danmaku.a.b().a().f(SurfaceView.class, "mDrawingStopped", this.f99757d);
        this.C = com.tencent.common.danmaku.a.b().a().f(SurfaceView.class, "mWindow", this.f99757d);
        if (this.f99761i instanceof Boolean) {
            this.f99762m = ((Boolean) this.f99761i).booleanValue();
        }
    }

    private void i() {
        Object f16 = com.tencent.common.danmaku.a.b().a().f(SurfaceView.class, "mSurfaceLock", this.f99757d);
        if (f16 instanceof ReentrantLock) {
            this.f99760h = (ReentrantLock) f16;
        }
    }

    private void j() {
        i();
        h();
    }

    private boolean k() {
        if (l.b() && ((Build.VERSION.SDK_INT == 23 && l()) || com.tencent.common.danmaku.a.b().a().b())) {
            return true;
        }
        return false;
    }

    private boolean l() {
        j();
        if (this.f99760h != null && this.f99761i != null && this.C != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Canvas m() {
        Canvas canvas;
        Canvas lockHardwareCanvas;
        if (com.tencent.common.danmaku.a.b().a().b()) {
            lockHardwareCanvas = this.f99758e.lockHardwareCanvas();
            return lockHardwareCanvas;
        }
        this.f99760h.lock();
        h();
        if (!this.f99762m && this.C != null) {
            try {
                canvas = this.f99758e.getSurface().lockHardwareCanvas();
            } catch (Exception e16) {
                com.tencent.common.danmaku.util.e.c("SurfaceDanmakuView", "Exception locking surface", e16);
            }
            if (canvas == null) {
                return canvas;
            }
            this.f99760h.unlock();
            return null;
        }
        canvas = null;
        if (canvas == null) {
        }
    }

    private void n(Canvas canvas) {
        if (com.tencent.common.danmaku.a.b().a().b()) {
            this.f99758e.unlockCanvasAndPost(canvas);
            return;
        }
        this.f99758e.getSurface().unlockCanvasAndPost(canvas);
        if (this.f99760h != null) {
            this.f99760h.unlock();
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.f99757d.getY();
    }

    @Override // com.tencent.common.danmaku.render.g
    public void b(g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f99759f = aVar;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.common.danmaku.render.g
    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.common.danmaku.render.g
    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.common.danmaku.render.g
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f99757d;
    }

    @Override // com.tencent.common.danmaku.render.g
    public Canvas lockCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Canvas) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.D) {
            return m();
        }
        return this.f99758e.lockCanvas();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
            return;
        }
        g.a aVar = this.f99759f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onTouchListener);
        } else {
            this.f99757d.setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        g.a aVar = this.f99759f;
        if (aVar != null) {
            aVar.b();
        }
        com.tencent.common.danmaku.util.e.e("SurfaceDanmakuView", "surfaceChanged, width = ", Integer.valueOf(i16), ", height = ", Integer.valueOf(i17));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceHolder);
            return;
        }
        g.a aVar = this.f99759f;
        if (aVar != null) {
            aVar.d();
        }
        this.D = k();
        com.tencent.common.danmaku.util.e.e("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = ", Boolean.valueOf(this.D));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) surfaceHolder);
            return;
        }
        g.a aVar = this.f99759f;
        if (aVar != null) {
            aVar.c();
        }
        com.tencent.common.danmaku.util.e.e("SurfaceDanmakuView", "surfaceDestroyed");
    }

    @Override // com.tencent.common.danmaku.render.g
    public void unlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ReentrantLock reentrantLock = (ReentrantLock) com.tencent.common.danmaku.a.b().a().f(SurfaceView.class, "mSurfaceLock", this.f99757d);
        Surface surface = this.f99757d.getHolder().getSurface();
        try {
            try {
                Method declaredMethod = Surface.class.getDeclaredMethod("nativeRelease", Long.TYPE);
                declaredMethod.setAccessible(true);
                Field declaredField = Surface.class.getDeclaredField("mLockedObject");
                declaredField.setAccessible(true);
                Long l3 = (Long) declaredField.get(surface);
                com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = ", l3);
                if (l3.longValue() != 0) {
                    declaredMethod.invoke(null, l3);
                }
                declaredField.setLong(surface, 0L);
                com.tencent.common.danmaku.util.e.b("surface_lock", "SurfaceDanmakuView unlock: release success");
                com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ", reentrantLock);
            } catch (Exception e16) {
                com.tencent.common.danmaku.util.e.c("surface_lock", "SurfaceDanmakuView unlock:release failed", e16);
                com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ", reentrantLock);
                if (reentrantLock != null && reentrantLock.isLocked()) {
                    com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock");
                } else {
                    return;
                }
            }
            if (reentrantLock != null && reentrantLock.isLocked()) {
                com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock");
                reentrantLock.unlock();
            }
        } catch (Throwable th5) {
            com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ", reentrantLock);
            if (reentrantLock != null && reentrantLock.isLocked()) {
                com.tencent.common.danmaku.util.e.e("surface_lock", "SurfaceDanmakuView unlock");
                reentrantLock.unlock();
            }
            throw th5;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void unlockCanvasAndPost(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
        } else if (this.D) {
            n(canvas);
        } else {
            this.f99758e.unlockCanvasAndPost(canvas);
        }
    }
}
