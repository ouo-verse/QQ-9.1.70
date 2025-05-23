package com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes17.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    protected b f276208a;

    /* renamed from: b, reason: collision with root package name */
    private EGLSurface f276209b = EGL14.EGL_NO_SURFACE;

    /* renamed from: c, reason: collision with root package name */
    private int f276210c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f276211d = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(b bVar) {
        this.f276208a = bVar;
    }

    public void a(int i3, int i16) {
        if (this.f276209b == EGL14.EGL_NO_SURFACE) {
            this.f276209b = this.f276208a.b(i3, i16);
            this.f276210c = i3;
            this.f276211d = i16;
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f276208a.d(this.f276209b);
    }

    public void c() {
        this.f276208a.f(this.f276209b);
        this.f276209b = EGL14.EGL_NO_SURFACE;
        this.f276211d = -1;
        this.f276210c = -1;
    }
}
