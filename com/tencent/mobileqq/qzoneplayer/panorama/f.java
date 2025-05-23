package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f {

    /* renamed from: t, reason: collision with root package name */
    private static final float f279408t = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: n, reason: collision with root package name */
    private float f279422n;

    /* renamed from: o, reason: collision with root package name */
    private float f279423o;

    /* renamed from: a, reason: collision with root package name */
    private float[] f279409a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private float[] f279410b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private float[] f279411c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private float[] f279412d = new float[16];

    /* renamed from: e, reason: collision with root package name */
    private float[] f279413e = new float[16];

    /* renamed from: f, reason: collision with root package name */
    private float[] f279414f = new float[16];

    /* renamed from: g, reason: collision with root package name */
    private float[] f279415g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    private float f279416h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f279417i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f279418j = 1.5f;

    /* renamed from: k, reason: collision with root package name */
    private float f279419k = 0.8f;

    /* renamed from: l, reason: collision with root package name */
    private float f279420l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f279421m = -90.0f;

    /* renamed from: p, reason: collision with root package name */
    private float f279424p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private float f279425q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    private boolean f279426r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f279427s = false;

    public f() {
        d();
        e();
        f();
    }

    private void a() {
        Matrix.setIdentityM(this.f279414f, 0);
        this.f279420l += this.f279424p;
        float f16 = this.f279421m + this.f279425q;
        this.f279421m = f16;
        float max = Math.max(-90.0f, f16);
        this.f279421m = max;
        this.f279421m = Math.min(90.0f, max);
        Matrix.rotateM(this.f279414f, 0, this.f279420l, 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(this.f279414f, 0, this.f279421m, (float) Math.cos((this.f279420l / 180.0f) * 3.141592653589793d), 0.0f, (float) Math.sin((this.f279420l / 180.0f) * 3.141592653589793d));
        this.f279424p = 0.0f;
        this.f279425q = 0.0f;
    }

    private void d() {
        i(this.f279416h);
    }

    private void e() {
        j(this.f279417i);
    }

    private void i(float f16) {
        this.f279416h = f16;
        Matrix.setIdentityM(this.f279410b, 0);
        Matrix.setLookAtM(this.f279410b, 0, 0.0f, 0.0f, f16, 0.0f, 0.0f, -15.0f, 0.0f, 1.0f, 0.0f);
    }

    private void j(float f16) {
        this.f279417i = f16;
        Matrix.setIdentityM(this.f279409a, 0);
        Matrix.setRotateM(this.f279409a, 0, f16, 0.0f, 1.0f, 0.0f);
    }

    public boolean b(float f16, float f17) {
        float f18 = this.f279424p;
        boolean z16 = this.f279426r;
        this.f279424p = f18 - (z16 ? f17 : f16);
        float f19 = this.f279425q;
        if (z16) {
            f17 = -f16;
        }
        this.f279425q = f19 - f17;
        return true;
    }

    public void g(boolean z16) {
        this.f279426r = z16;
    }

    public void f() {
        this.f279421m = 0.0f;
        this.f279420l = 0.0f;
    }

    public void h(g gVar, int i3, int i16) {
        Matrix.setIdentityM(this.f279409a, 0);
        a();
        Matrix.multiplyMM(this.f279415g, 0, this.f279409a, 0, this.f279414f, 0);
        System.arraycopy(this.f279415g, 0, this.f279409a, 0, 16);
        Matrix.setIdentityM(this.f279410b, 0);
        Matrix.multiplyMM(this.f279412d, 0, this.f279410b, 0, this.f279409a, 0);
        Matrix.multiplyMM(this.f279413e, 0, this.f279411c, 0, this.f279412d, 0);
        GLES20.glUniformMatrix4fv(gVar.d(), 1, false, this.f279412d, 0);
        GLES20.glUniformMatrix4fv(gVar.e(), 1, false, this.f279413e, 0);
        GLES20.glViewport(0, 0, i3, i16);
    }

    public boolean c(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 2) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (this.f279427s) {
                float f16 = this.f279422n;
                float f17 = f279408t;
                float f18 = ((x16 - f16) / f17) / 4.8f;
                float f19 = this.f279423o;
                float f26 = ((y16 - f19) / f17) / 4.8f;
                if (f16 != -1.0f && f19 != -1.0f) {
                    if (this.f279426r) {
                        this.f279424p -= f26;
                        this.f279425q += f18;
                    } else {
                        this.f279424p -= f18;
                        this.f279425q -= f26;
                    }
                }
            } else {
                this.f279427s = true;
            }
            this.f279422n = x16;
            this.f279423o = y16;
            return true;
        }
        this.f279427s = false;
        return false;
    }

    public void k(int i3, int i16) {
        float f16 = (i3 * 1.0f) / i16;
        this.f279418j = f16;
        l(f16);
    }

    private void l(float f16) {
        Matrix.frustumM(this.f279411c, 0, (-f16) / 2.0f, f16 / 2.0f, -0.5f, 0.5f, this.f279419k, 500.0f);
    }
}
