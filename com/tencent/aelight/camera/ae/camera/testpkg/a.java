package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.common.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a implements b {

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.qqcamerakit.capture.c f62309d = new com.tencent.qqcamerakit.capture.c(BaseApplication.getContext(), null, !AECameraConstants.PIXEL_4XL.equals(Build.MANUFACTURER + " " + DeviceInfoMonitor.getModel()));

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void a(boolean z16) {
        this.f62309d.b(z16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void b() {
        this.f62309d.m();
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public int c() {
        return this.f62309d.f();
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void d(d dVar) {
        this.f62309d.v(dVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void e() {
        this.f62309d.t();
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void f(boolean z16) {
        this.f62309d.u(z16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public Object g() {
        return this.f62309d.c();
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void h(int i3, boolean z16) {
        this.f62309d.i(i3, z16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void i(int i3, long j3) {
        this.f62309d.l(i3, j3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void j(boolean z16) {
        this.f62309d.s(z16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public long k() {
        return this.f62309d.e();
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void l(com.tencent.qqcamerakit.capture.d dVar, com.tencent.qqcamerakit.capture.d dVar2, com.tencent.qqcamerakit.capture.d dVar3, int i3, String str, int i16, int i17) {
        this.f62309d.p(dVar, dVar2, dVar3, i3, str, i16, i17);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void m(int i3) {
        this.f62309d.h(i3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public boolean n(int i3) {
        return this.f62309d.g(i3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void o(d dVar) {
        this.f62309d.j(dVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void p(com.tencent.qqcamerakit.capture.d dVar, boolean z16, String str, int i3, c.b bVar) {
        this.f62309d.a(dVar, z16, str, i3, bVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void q(Matrix matrix, c.a aVar, int i3, int i16, int i17, float f16, float f17) {
        this.f62309d.k(matrix, aVar, i3, i16, i17, f16, f17);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void r(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        this.f62309d.r(surfaceTexture, bVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void setZoom(float f16) {
        this.f62309d.q(f16);
    }
}
