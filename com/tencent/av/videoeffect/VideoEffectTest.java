package com.tencent.av.videoeffect;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.GLES20;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoEffectTest implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    a f77193e;

    /* renamed from: d, reason: collision with root package name */
    Thread f77192d = null;

    /* renamed from: f, reason: collision with root package name */
    private EGL10 f77194f = null;

    /* renamed from: h, reason: collision with root package name */
    private EGLDisplay f77195h = null;

    /* renamed from: i, reason: collision with root package name */
    private EGLSurface f77196i = null;

    /* renamed from: m, reason: collision with root package name */
    private EGLContext f77197m = null;
    private android.opengl.EGLDisplay C = null;
    private android.opengl.EGLSurface D = null;
    private android.opengl.EGLContext E = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3, long j3, String str, String str2);
    }

    public VideoEffectTest(a aVar) {
        this.f77193e = aVar;
    }

    @SuppressLint({"NewApi"})
    private void e() {
        android.opengl.EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.C = eglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(this.C, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0 && QLog.isColorLevel()) {
            QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        this.D = EGL14.eglCreatePbufferSurface(this.C, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 64, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 64, 12344}, 0);
        android.opengl.EGLContext eglCreateContext = EGL14.eglCreateContext(this.C, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
        this.E = eglCreateContext;
        android.opengl.EGLDisplay eGLDisplay = this.C;
        android.opengl.EGLSurface eGLSurface = this.D;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext);
    }

    @SuppressLint({"NewApi"})
    private void f() {
        android.opengl.EGLDisplay eGLDisplay = this.C;
        if (eGLDisplay != null && this.D != null && this.E != null) {
            android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.C, this.D);
            EGL14.eglDestroyContext(this.C, this.E);
            EGL14.eglTerminate(this.C);
        }
    }

    public void g() {
        Thread thread = this.f77192d;
        if (thread == null || !thread.isAlive()) {
            BaseThread baseThread = new BaseThread(this, "VideoEffectTest");
            this.f77192d = baseThread;
            baseThread.start();
        }
    }

    void h() {
        byte[] bArr = new byte[921600];
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < 480; i17++) {
            for (int i18 = 0; i18 < 640; i18++) {
                bArr[i16] = (byte) (i17 % 255);
                bArr[i16 + 1] = (byte) ((640 - i18) % 255);
                bArr[i16 + 2] = (byte) ((i17 + i18) % 255);
                i16 += 3;
            }
        }
        long j3 = 0;
        try {
            vw.a aVar = new vw.a(bArr, 480, 640);
            aVar.c();
            long c16 = ((aVar.c() + 0) + aVar.c()) / 2;
            aVar.a();
            if (c16 <= 0) {
                i3 = (int) c16;
            } else {
                i3 = 1;
                j3 = c16;
            }
        } catch (Throwable unused) {
        }
        int i19 = i3;
        long j16 = j3;
        a aVar2 = this.f77193e;
        if (aVar2 != null) {
            aVar2.a(i19, j16, GLES20.glGetString(7936), GLES20.glGetString(7937));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            e();
            h();
            f();
        } catch (Throwable unused) {
            a aVar = this.f77193e;
            if (aVar != null) {
                aVar.a(0, 0L, null, null);
            }
        }
    }
}
