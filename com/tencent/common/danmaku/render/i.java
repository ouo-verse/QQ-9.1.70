package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.tencent.common.danmaku.render.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i implements g, TextureView.SurfaceTextureListener, View.OnAttachStateChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private TextureView f99763d;

    /* renamed from: e, reason: collision with root package name */
    private g.a f99764e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f99765f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f99766h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f99767i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f99768m;

    public i(TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) textureView);
            return;
        }
        this.f99765f = false;
        this.f99766h = false;
        this.f99767i = false;
        this.f99768m = true;
        this.f99763d = textureView;
        textureView.setOpaque(false);
        this.f99763d.setSurfaceTextureListener(this);
        this.f99763d.addOnAttachStateChangeListener(this);
    }

    @Override // com.tencent.common.danmaku.render.g
    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.f99763d.getY();
    }

    @Override // com.tencent.common.danmaku.render.g
    public void b(g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f99764e = aVar;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f99766h;
    }

    @Override // com.tencent.common.danmaku.render.g
    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f99765f = z16;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f99764e = null;
        TextureView textureView = this.f99763d;
        if (textureView != null) {
            textureView.setOnTouchListener(null);
            this.f99763d = null;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f99765f;
    }

    @Override // com.tencent.common.danmaku.render.g
    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f99766h = z16;
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f99768m;
    }

    @Override // com.tencent.common.danmaku.render.g
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f99763d;
    }

    @Override // com.tencent.common.danmaku.render.g
    public Canvas lockCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Canvas) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f99763d.lockCanvas();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.common.danmaku.util.e.b("TextureDanmakuView", "[onSurfaceTextureAvailable] surface texture available...");
        this.f99763d.setOpaque(false);
        g.a aVar = this.f99764e;
        if (aVar != null) {
            aVar.d();
            this.f99764e.b();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        g.a aVar = this.f99764e;
        if (aVar != null) {
            aVar.c();
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.common.danmaku.util.e.b("TextureDanmakuView", "[onSurfaceTextureSizeChanged] surface texture size changed...");
        g.a aVar = this.f99764e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) surfaceTexture);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
            return;
        }
        g.a aVar = this.f99764e;
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
            this.f99763d.setOnTouchListener(onTouchListener);
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void unlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.common.danmaku.render.g
    public void unlockCanvasAndPost(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
        } else {
            this.f99763d.unlockCanvasAndPost(canvas);
        }
    }
}
