package com.tencent.crossengine;

import android.view.Surface;
import com.tencent.crossengine.util.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RenderContext {

    /* renamed from: a, reason: collision with root package name */
    private long f100462a;

    /* renamed from: b, reason: collision with root package name */
    private a f100463b;

    /* renamed from: c, reason: collision with root package name */
    private int f100464c;

    /* renamed from: d, reason: collision with root package name */
    private int f100465d;

    public RenderContext(a aVar) {
        this.f100462a = nCreateNativeRenderContext(aVar.b());
        this.f100463b = aVar;
    }

    private native long nCreateNativeRenderContext(boolean z16);

    private native void nExit(long j3);

    private native void nInitRenderContext(long j3, Surface surface, int i3, int i16, float f16);

    private native void nOnPause(long j3);

    private native void nOnResume(long j3);

    private native void nSurfaceChanged(long j3, Surface surface, int i3, int i16);

    private native void nSurfaceDestroyed(long j3);

    private native void nUpdateRenderContext(long j3);

    public void a() {
        nExit(this.f100462a);
    }

    public void b() {
        nSurfaceDestroyed(this.f100462a);
    }

    public int c() {
        return this.f100465d;
    }

    public long d() {
        return this.f100462a;
    }

    public int e() {
        return this.f100464c;
    }

    public void f(Surface surface, int i3, int i16) {
        this.f100464c = i3;
        this.f100465d = i16;
        nInitRenderContext(this.f100462a, surface, (int) (i3 / this.f100463b.a()), (int) (i16 / this.f100463b.a()), this.f100463b.a());
    }

    public void g() {
        nOnPause(this.f100462a);
    }

    public void h() {
        nOnResume(this.f100462a);
    }

    public void i(Surface surface, int i3, int i16) {
        this.f100464c = i3;
        this.f100465d = i16;
        nSurfaceChanged(this.f100462a, surface, (int) (i3 / this.f100463b.a()), (int) (i16 / this.f100463b.a()));
    }
}
