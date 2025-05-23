package com.tencent.qfsmonet.gles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.data.MonetGLTexturePacket;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.api.inputstream.MonetSurfaceTexture;
import com.tencent.qfsmonet.api.inputstream.MonetTextureCropInfo;
import com.tencent.qfsmonet.gles.MonetShaderDescriptor;
import com.tencent.qfsmonet.utils.MonetHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MonetHandler f342513a;

    /* renamed from: b, reason: collision with root package name */
    private MonetSurfaceTexture f342514b;

    /* renamed from: c, reason: collision with root package name */
    private int f342515c;

    /* renamed from: d, reason: collision with root package name */
    private MonetGLTexturePacket f342516d;

    /* renamed from: e, reason: collision with root package name */
    private f f342517e;

    /* renamed from: f, reason: collision with root package name */
    private int f342518f;

    /* renamed from: g, reason: collision with root package name */
    private int f342519g;

    /* renamed from: h, reason: collision with root package name */
    private p f342520h;

    /* renamed from: i, reason: collision with root package name */
    private FloatBuffer f342521i;

    /* renamed from: j, reason: collision with root package name */
    private MonetTextureCropInfo f342522j;

    /* renamed from: k, reason: collision with root package name */
    private MonetPacketDescriptor f342523k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f342524l;

    public o(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) monetContext);
            return;
        }
        this.f342524l = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        try {
            this.f342513a = new MonetHandler(monetContext.looper());
        } catch (OutOfMemoryError e16) {
            com.tencent.qfsmonet.utils.a.b("MonetOESRender", "MonetOESRender, ex=" + e16.toString());
        }
    }

    private boolean g(@NonNull final MonetSurfaceTexture monetSurfaceTexture) {
        if (this.f342515c > 0 && monetSurfaceTexture.width() > 0 && monetSurfaceTexture.height() > 0 && this.f342517e != null) {
            return true;
        }
        com.tencent.qfsmonet.utils.c.a(this.f342513a, new Runnable() { // from class: com.tencent.qfsmonet.gles.n
            @Override // java.lang.Runnable
            public final void run() {
                MonetSurfaceTexture.this.updateTexImage();
            }
        });
        return false;
    }

    private float[] h(@NonNull MonetTextureCropInfo monetTextureCropInfo, int i3, int i16) {
        float f16 = i16;
        float cropTop = monetTextureCropInfo.cropTop() / f16;
        float cropBottom = ((i16 - monetTextureCropInfo.cropBottom()) - 1) / f16;
        float f17 = i3;
        float cropLeft = monetTextureCropInfo.cropLeft() / f17;
        float cropRight = ((i3 - monetTextureCropInfo.cropRight()) - 1) / f17;
        float[] fArr = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        float f18 = cropLeft + 0.0f;
        fArr[0] = f18;
        float f19 = 1.0f - cropBottom;
        fArr[1] = f19;
        fArr[2] = f18;
        float f26 = cropTop + 0.0f;
        fArr[3] = f26;
        float f27 = 1.0f - cropRight;
        fArr[4] = f27;
        fArr[5] = f19;
        fArr[6] = f27;
        fArr[7] = f26;
        return fArr;
    }

    private void i(@NonNull MonetTextureCropInfo monetTextureCropInfo, int i3, int i16) {
        com.tencent.qfsmonet.utils.a.c("MonetOESRender", "Monet set parameter");
        float[] h16 = h(monetTextureCropInfo, i3, i16);
        if (this.f342521i == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(h16.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f342521i = allocateDirect.asFloatBuffer();
        }
        this.f342521i.put(h16);
        this.f342521i.position(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void s() {
        int i3 = 0;
        try {
            p();
            i3 = h.d(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_OES);
            if (i3 > 0) {
                this.f342514b = new MonetSurfaceTexture(i3);
            }
        } catch (IllegalStateException unused) {
            com.tencent.qfsmonet.utils.a.b("MonetOESRender", "getOESTextureId failed!");
            this.f342517e = null;
        }
        this.f342515c = i3;
    }

    private p l(int i3, int i16) {
        int format;
        int d16 = h.d(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D);
        MonetPacketDescriptor monetPacketDescriptor = this.f342523k;
        if (monetPacketDescriptor == null) {
            format = 6408;
        } else {
            format = monetPacketDescriptor.format();
        }
        int c16 = h.c(d16, i3, i16, format);
        MonetPacketDescriptor monetPacketDescriptor2 = new MonetPacketDescriptor(i3, i16, format);
        MonetGLTexturePacket monetGLTexturePacket = this.f342516d;
        if (monetGLTexturePacket != null) {
            h.a(monetGLTexturePacket.textureId());
            this.f342516d = null;
        }
        this.f342516d = new MonetGLTexturePacket(d16, c16, monetPacketDescriptor2);
        return new p(i3, i16, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void r() {
        int i3 = this.f342515c;
        if (i3 > 0) {
            h.a(i3);
        }
    }

    private void p() throws IllegalStateException {
        this.f342517e = new f();
        this.f342517e.b(new MonetShaderDescriptor.b().b("#extension GL_OES_EGL_image_external:require\nprecision mediump float;\nuniform samplerExternalOES vTexture;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    vec4 color = texture2D(vTexture, v_TexCoordinate);\n    gl_FragColor = color;\n}").g("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = vTexCoordinate.xy;\n    gl_Position = vPosition;\n}").e("vTexture").d("vTexCoordinate").f("vPosition").c(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_OES).a());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f342524l.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f342521i = asFloatBuffer;
        asFloatBuffer.put(this.f342524l);
        this.f342521i.position(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MonetPacketDescriptor monetPacketDescriptor) {
        this.f342520h = l(monetPacketDescriptor.width(), monetPacketDescriptor.height());
    }

    private boolean w(MonetTextureCropInfo monetTextureCropInfo) {
        if (monetTextureCropInfo == null || !com.tencent.qfsmonet.process.b.e()) {
            return false;
        }
        if (monetTextureCropInfo.cropBottom() == 0 && monetTextureCropInfo.cropTop() == 0 && monetTextureCropInfo.cropRight() == 0 && monetTextureCropInfo.cropLeft() == 0) {
            return false;
        }
        if (this.f342522j != null && monetTextureCropInfo.cropBottom() == this.f342522j.cropBottom() && monetTextureCropInfo.cropTop() == this.f342522j.cropTop() && monetTextureCropInfo.cropRight() == this.f342522j.cropRight() && monetTextureCropInfo.cropLeft() == this.f342522j.cropLeft()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void u(@NonNull MonetSurfaceTexture monetSurfaceTexture) {
        monetSurfaceTexture.updateTexImage();
        if (this.f342518f != monetSurfaceTexture.width() || this.f342519g != monetSurfaceTexture.height()) {
            this.f342520h = l(monetSurfaceTexture.width(), monetSurfaceTexture.height());
            this.f342519g = monetSurfaceTexture.height();
            this.f342518f = monetSurfaceTexture.width();
        }
        try {
            if (w(monetSurfaceTexture.textureCropInfo())) {
                i(monetSurfaceTexture.textureCropInfo(), this.f342518f, this.f342519g);
                this.f342522j = monetSurfaceTexture.textureCropInfo();
            }
            this.f342517e.e(this.f342515c, this.f342520h, this.f342521i);
        } catch (IllegalStateException e16) {
            com.tencent.qfsmonet.utils.a.b("MonetOESRender", "render failed!" + e16.toString());
        }
    }

    @Nullable
    public synchronized MonetGLTexturePacket k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MonetGLTexturePacket) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f342516d;
    }

    public synchronized void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        MonetHandler monetHandler = this.f342513a;
        if (monetHandler == null) {
            return;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.m
            @Override // java.lang.Runnable
            public final void run() {
                o.this.r();
            }
        });
        this.f342513a.removeCallbacksAndMessages(null);
        this.f342516d = null;
        this.f342513a = null;
        com.tencent.qfsmonet.utils.a.c("MonetOESRender", "destroy end!");
    }

    public synchronized MonetSurfaceTexture o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonetSurfaceTexture) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f342514b != null) {
            com.tencent.qfsmonet.utils.a.c("MonetOESRender", "getOESTextureId,id=" + this.f342514b);
            return this.f342514b;
        }
        MonetHandler monetHandler = this.f342513a;
        if (monetHandler == null) {
            return null;
        }
        com.tencent.qfsmonet.utils.c.a(monetHandler, new Runnable() { // from class: com.tencent.qfsmonet.gles.i
            @Override // java.lang.Runnable
            public final void run() {
                o.this.s();
            }
        });
        com.tencent.qfsmonet.utils.a.c("MonetOESRender", "getOESTextureId create id=" + this.f342515c);
        return this.f342514b;
    }

    public synchronized void x(@NonNull final MonetSurfaceTexture monetSurfaceTexture) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) monetSurfaceTexture);
            return;
        }
        if (this.f342513a == null) {
            com.tencent.qfsmonet.utils.a.c("MonetOESRender", "handler is null, has destroyed");
            return;
        }
        if (g(monetSurfaceTexture)) {
            com.tencent.qfsmonet.utils.c.a(this.f342513a, new Runnable() { // from class: com.tencent.qfsmonet.gles.k
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.u(monetSurfaceTexture);
                }
            });
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetOESRender", "render failed. width,height=" + monetSurfaceTexture.width() + "," + monetSurfaceTexture.height());
        com.tencent.qfsmonet.utils.c.a(this.f342513a, new Runnable() { // from class: com.tencent.qfsmonet.gles.j
            @Override // java.lang.Runnable
            public final void run() {
                MonetSurfaceTexture.this.updateTexImage();
            }
        });
        throw new IllegalArgumentException("invalid width,height=" + monetSurfaceTexture.width() + "," + monetSurfaceTexture.height());
    }

    public synchronized void z(@NonNull final MonetPacketDescriptor monetPacketDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) monetPacketDescriptor);
            return;
        }
        MonetPacketDescriptor monetPacketDescriptor2 = this.f342523k;
        if (monetPacketDescriptor2 != null && monetPacketDescriptor2.format() == monetPacketDescriptor.format() && monetPacketDescriptor.width() > 0 && monetPacketDescriptor.height() > 0) {
            com.tencent.qfsmonet.utils.a.c("MonetOESRender", "the same format, no need create");
            return;
        }
        if (monetPacketDescriptor.height() != 0 && monetPacketDescriptor.width() != 0) {
            com.tencent.qfsmonet.utils.c.a(this.f342513a, new Runnable() { // from class: com.tencent.qfsmonet.gles.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.v(monetPacketDescriptor);
                }
            });
            this.f342518f = monetPacketDescriptor.width();
            this.f342519g = monetPacketDescriptor.height();
            this.f342523k = monetPacketDescriptor;
            return;
        }
        this.f342523k = monetPacketDescriptor;
    }
}
