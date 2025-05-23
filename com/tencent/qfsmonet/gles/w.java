package com.tencent.qfsmonet.gles;

import android.opengl.EGLSurface;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.gles.MonetShaderDescriptor;
import com.tencent.qfsmonet.utils.MonetHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MonetHandler f342536a;

    /* renamed from: b, reason: collision with root package name */
    private MonetContext f342537b;

    /* renamed from: c, reason: collision with root package name */
    private f f342538c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f342539d;

    /* renamed from: e, reason: collision with root package name */
    private EGLSurface f342540e;

    /* renamed from: f, reason: collision with root package name */
    private int f342541f;

    /* renamed from: g, reason: collision with root package name */
    private int f342542g;

    public w(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) monetContext);
            return;
        }
        this.f342541f = 0;
        this.f342542g = 0;
        this.f342537b = monetContext;
        try {
            this.f342536a = new MonetHandler(monetContext.looper());
        } catch (OutOfMemoryError e16) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "MonetSurfaceRender, ex=" + e16.toString());
        }
    }

    private EGLSurface g(@NonNull Surface surface) {
        EGLSurface c16;
        b context = this.f342537b.context();
        if (surface != null && surface.isValid()) {
            c16 = d.d(context.c(), context.a(), surface);
        } else {
            c16 = d.c(context.c(), context.a());
        }
        if (d.k(context.c(), context.b(), context.d(), c16)) {
            this.f342537b.context().e(c16);
            return c16;
        }
        com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "updateSurface failed!");
        return this.f342537b.context().d();
    }

    private int i(@NonNull b bVar) {
        return d.h(bVar.c(), bVar.d(), MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT);
    }

    private int k(@NonNull b bVar) {
        return d.h(bVar.c(), bVar.d(), MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void s() {
        f fVar = this.f342538c;
        if (fVar != null) {
            fVar.a();
        }
        this.f342538c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void t() {
        MonetContext monetContext;
        if (this.f342538c != null && (monetContext = this.f342537b) != null && monetContext.context() != null) {
            b context = this.f342537b.context();
            this.f342541f = k(context);
            this.f342542g = i(context);
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "getSurfaceSize failed. monetRender is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void u() {
        if (this.f342538c != null) {
            return;
        }
        this.f342538c = new f();
        try {
            this.f342538c.b(new MonetShaderDescriptor.b().b("precision mediump float;\nuniform sampler2D vTexture;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    vec4 color = texture2D(vTexture, v_TexCoordinate);\n    gl_FragColor = color;\n}").g("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = vTexCoordinate.xy;\n    gl_Position = vPosition;\n}").e("vTexture").d("vTexCoordinate").f("vPosition").c(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D).a());
        } catch (IllegalStateException e16) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "initRender failed. ex=" + e16.toString());
            this.f342538c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void v() {
        if (this.f342540e == null) {
            this.f342540e = g(this.f342539d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void w(@IntRange(from = 1) int i3) {
        MonetContext monetContext;
        if (this.f342538c != null && (monetContext = this.f342537b) != null && monetContext.context() != null) {
            b context = this.f342537b.context();
            try {
                this.f342538c.c(i3, k(context), i(context));
                d.j(context.c(), context.d());
                return;
            } catch (IllegalStateException e16) {
                com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "renderToScreen failed. ex=" + e16.toString());
                return;
            }
        }
        com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "renderToScreen failed. monetRender is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void x(@Nullable Surface surface) {
        MonetContext monetContext = this.f342537b;
        if (monetContext != null && monetContext.context() != null) {
            if (surface == this.f342539d) {
                com.tencent.qfsmonet.utils.a.c("MonetSurfaceRender", "same with current surface, surface=" + surface);
                return;
            }
            this.f342539d = surface;
            if (this.f342540e == null) {
                com.tencent.qfsmonet.utils.a.c("MonetSurfaceRender", "updateSurface before render, address:" + surface);
                return;
            }
            g(surface);
            com.tencent.qfsmonet.utils.a.c("MonetSurfaceRender", "updateSurface, address:" + surface);
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "context is invalid!");
    }

    public void A(@Nullable final Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surface);
            return;
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "handler create failed");
        } else {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.u
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.x(surface);
                }
            });
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "handler create failed");
            return;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.q
            @Override // java.lang.Runnable
            public final void run() {
                w.this.s();
            }
        });
        this.f342536a.removeCallbacksAndMessages(null);
        this.f342536a = null;
    }

    public Size j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Size) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "getSurfaceSize failed");
            return null;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.r
            @Override // java.lang.Runnable
            public final void run() {
                w.this.t();
            }
        });
        return new Size(this.f342541f, this.f342542g);
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "handler create failed");
            return false;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.v
            @Override // java.lang.Runnable
            public final void run() {
                w.this.u();
            }
        });
        if (this.f342538c == null) {
            return false;
        }
        return true;
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "handler create failed");
        } else {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.t
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.v();
                }
            });
        }
    }

    public void z(@NonNull final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        MonetHandler monetHandler = this.f342536a;
        if (monetHandler == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceRender", "handler create failed");
        } else {
            com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.s
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.w(i3);
                }
            });
        }
    }
}
