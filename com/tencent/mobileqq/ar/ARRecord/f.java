package com.tencent.mobileqq.ar.ARRecord;

import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private EGL10 f197056a;

    /* renamed from: b, reason: collision with root package name */
    private EGLDisplay f197057b;

    /* renamed from: c, reason: collision with root package name */
    private EGLContext f197058c;

    /* renamed from: d, reason: collision with root package name */
    private EGLSurface f197059d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.b f197060e;

    public f(com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar, Surface surface) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f197056a = egl10;
        this.f197058c = egl10.eglGetCurrentContext();
        this.f197057b = this.f197056a.eglGetCurrentDisplay();
        this.f197059d = this.f197056a.eglGetCurrentSurface(12377);
        com.tencent.mobileqq.videocodec.mediacodec.encoder.b bVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.b(aVar);
        this.f197060e = bVar;
        bVar.b(surface);
    }

    public void a() {
        this.f197060e.c();
    }

    public void b() {
        EGL10 egl10 = this.f197056a;
        EGLDisplay eGLDisplay = this.f197057b;
        EGLSurface eGLSurface = this.f197059d;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f197058c);
    }

    public void c() {
        com.tencent.mobileqq.videocodec.mediacodec.encoder.b bVar = this.f197060e;
        if (bVar != null) {
            bVar.d();
            this.f197060e = null;
        }
    }

    public void d(long j3) {
        this.f197060e.e(j3);
    }

    public void e() {
        this.f197060e.f();
    }
}
