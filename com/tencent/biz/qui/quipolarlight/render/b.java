package com.tencent.biz.qui.quipolarlight.render;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Size;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private fe0.a f95237a;

    /* renamed from: b, reason: collision with root package name */
    private final EGLContext f95238b;

    /* renamed from: c, reason: collision with root package name */
    private final EGLDisplay f95239c;

    /* renamed from: d, reason: collision with root package name */
    private final EGLSurface f95240d;

    /* renamed from: e, reason: collision with root package name */
    private Size f95241e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f95242f;

    public b(Size size) {
        this.f95241e = size;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f95239c = eglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.f95241e.getWidth(), MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.f95241e.getHeight(), 12344}, 0);
        this.f95240d = eglCreatePbufferSurface;
        EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
        this.f95238b = eglCreateContext;
        EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.f95237a = new fe0.a(this.f95241e.getWidth(), this.f95241e.getHeight());
        this.f95242f = Bitmap.createBitmap(this.f95241e.getWidth(), this.f95241e.getHeight(), Bitmap.Config.ARGB_8888);
    }

    private void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        ud0.d.b("MyGLRenderer", ud0.d.f438811e, str + ": glError " + glGetError);
        throw new IllegalStateException(str + ": glError " + glGetError);
    }

    public Bitmap b(float f16, int[] iArr, float f17, com.tencent.biz.qui.quipolarlight.a aVar) {
        int width = this.f95241e.getWidth();
        int height = this.f95241e.getHeight();
        fe0.a aVar2 = this.f95237a;
        if (aVar2 == null) {
            ud0.d.b("PolarImageGPURender", ud0.d.f438811e, "mComputeShader is null");
            return null;
        }
        aVar2.e(f16, iArr, f17, aVar);
        ByteBuffer byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(37074, 0, width * 4 * height, 1);
        if (byteBuffer == null) {
            ud0.d.b("PolarImageGPURender", ud0.d.f438811e, "render data get fail!!!");
            return null;
        }
        IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        ByteOrder order = asIntBuffer.order();
        asIntBuffer.rewind();
        if (order != ByteOrder.BIG_ENDIAN) {
            int[] iArr3 = new int[i3];
            asIntBuffer.get(iArr3);
            System.arraycopy(iArr3, 0, iArr2, 0, i3);
        } else {
            asIntBuffer.get(iArr2);
        }
        GLES30.glUnmapBuffer(37074);
        this.f95242f.setPixels(iArr2, 0, width, 0, 0, width, height);
        return this.f95242f;
    }

    public void c() {
        try {
            this.f95237a.b();
            this.f95237a = null;
            a("release context");
            EGLDisplay eGLDisplay = this.f95239c;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f95239c, this.f95240d);
            EGL14.eglDestroyContext(this.f95239c, this.f95238b);
            EGL14.eglTerminate(this.f95239c);
        } catch (Exception unused) {
            ud0.d.b("PolarImageGPURender", ud0.d.f438811e, "release data fail!!!");
        }
    }

    public void d(Size size) {
        this.f95241e = size;
        this.f95242f = Bitmap.createBitmap(size.getWidth(), this.f95241e.getHeight(), Bitmap.Config.ARGB_8888);
    }
}
