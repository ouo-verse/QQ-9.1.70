package com.tencent.luggage.wxa.eb;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Process;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.luggage.wxa.tn.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import java.io.Closeable;
import java.nio.Buffer;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements Closeable {

    /* renamed from: k, reason: collision with root package name */
    public static final a f124607k = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public boolean f124610c;

    /* renamed from: d, reason: collision with root package name */
    public long f124611d;

    /* renamed from: e, reason: collision with root package name */
    public final long f124612e;

    /* renamed from: j, reason: collision with root package name */
    public int f124617j;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f124608a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f124609b = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f124613f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f124614g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f124615h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f124616i = 6408;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(boolean z16, long j3) {
        this.f124611d = j3;
        if (j3 < 0) {
            this.f124611d = 15L;
        }
        b.f124602a.d();
        a(z16);
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        this.f124612e = nativeHandle;
        w.d("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.f124609b + "  sampler2D:" + z16 + " tid:" + this.f124613f + ", context: " + nativeHandle + ", stackTrace:\t" + w0.b());
    }

    public final void a(boolean z16) {
        this.f124608a = false;
        this.f124613f = Process.myTid();
        this.f124610c = z16;
        if (z16) {
            this.f124609b = com.tencent.luggage.wxa.jb.a.f130928a.c();
        } else {
            this.f124609b = com.tencent.luggage.wxa.jb.a.f130928a.d();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f124608a) {
            w.d("MicroMsg.GLTextureObject", hashCode() + " tex already close");
            return;
        }
        int myTid = Process.myTid();
        if (this.f124613f != myTid) {
            w.b("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene\uff1a" + this.f124611d + "  created in:" + this.f124613f + " release in:" + myTid + ", stackTrace:\t" + w0.b());
            b.f124602a.f();
            this.f124608a = false;
            return;
        }
        this.f124608a = true;
        com.tencent.luggage.wxa.jb.a.f130928a.b(this.f124609b);
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (eglGetCurrentContext.getNativeHandle() == 0) {
            String str = "context is destroyed, texture leaked! texID: " + this.f124609b;
            w.b("MicroMsg.GLTextureObject", str);
            if (e.f141559a) {
                throw new IllegalStateException(str);
            }
        }
        if (eglGetCurrentContext.getNativeHandle() != this.f124612e) {
            String str2 = "release texID(" + this.f124609b + ") with current context(" + eglGetCurrentContext.getNativeHandle() + ") which NOT equals to the origin context (" + this.f124612e + "). something wrong and causes leak!";
            w.b("MicroMsg.GLTextureObject", str2);
            if (e.f141559a) {
                throw new IllegalStateException(str2);
            }
        }
        w.d("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.f124609b + "  sampler2D:" + this.f124610c + ", context: " + eglGetCurrentContext.getNativeHandle() + ", stacks:" + w0.b());
    }

    public final int d() {
        switch (this.f124616i) {
            case 6408:
            case MonetPacketDescriptor.MonetDataFormat.R8 /* 6409 */:
            case MonetPacketDescriptor.MonetDataFormat.RG8 /* 6410 */:
                return 32;
            default:
                return 24;
        }
    }

    public final int e() {
        return this.f124609b;
    }

    public final void finalize() {
        if (!this.f124608a) {
            b bVar = b.f124602a;
            bVar.e();
            bVar.b(this.f124611d);
            w.b("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene\uff1a" + this.f124611d);
            return;
        }
        w.d("MicroMsg.GLTextureObject", hashCode() + " release success!");
    }

    public final int g() {
        if (a()) {
            return this.f124614g * this.f124615h * d();
        }
        return ((this.f124614g * this.f124615h) * 3) / 2;
    }

    public String toString() {
        return "hashcode:" + hashCode() + " texID:" + this.f124609b + " sampler2D:" + this.f124610c + " memRelease:" + this.f124608a + " scene:" + this.f124611d + " create-tid:" + this.f124613f + " width:" + this.f124614g + " height:" + this.f124615h;
    }

    public final void a(int i3, int i16) {
        this.f124614g = i3;
        this.f124615h = i16;
    }

    public static /* synthetic */ void a(d dVar, int i3, int i16, int i17, Buffer buffer, int i18, int i19, int i26, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: allocTexMem");
        }
        if ((i26 & 4) != 0) {
            i17 = 32856;
        }
        int i27 = i17;
        if ((i26 & 8) != 0) {
            buffer = null;
        }
        Buffer buffer2 = buffer;
        if ((i26 & 16) != 0) {
            i18 = 9729;
        }
        int i28 = i18;
        if ((i26 & 32) != 0) {
            i19 = 10497;
        }
        dVar.a(i3, i16, i27, buffer2, i28, i19);
    }

    public final void a(int i3, int i16, int i17, Buffer buffer, int i18, int i19) {
        if (i3 == this.f124614g && i16 == this.f124615h && i17 == this.f124616i && buffer == null) {
            return;
        }
        int i26 = this.f124617j;
        this.f124617j = i26 + 1;
        if (i26 % 50 == 0) {
            w.d("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + i3 + ", height:" + i16 + ", internalFormat:" + i17 + ", memorySize:" + g());
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, e());
        com.tencent.luggage.wxa.jb.b bVar = com.tencent.luggage.wxa.jb.b.f130941a;
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, bVar.a(i17), i3, i16, 0, bVar.b(i17), NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
        float f16 = i18;
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, f16);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, f16);
        float f17 = i19;
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, f17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, f17);
        this.f124614g = i3;
        this.f124615h = i16;
        this.f124616i = i17;
    }

    public final boolean a() {
        return this.f124610c;
    }
}
