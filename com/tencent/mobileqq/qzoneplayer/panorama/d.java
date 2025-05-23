package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qzoneplayer.panorama.h;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends e implements SurfaceTexture.OnFrameAvailableListener {
    private SurfaceTexture J;
    private boolean K;
    private int[] L;
    private i M;
    private g N;
    private final f P;
    private h Q;
    protected int R;
    protected int S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements h.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.panorama.h.a
        public void a() {
            d.this.P.f();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.panorama.h.a
        public void onSensorChange(float f16, float f17, float f18) {
            d.this.P.b(f16, f17);
        }
    }

    public d(Context context, b bVar, SurfaceTexture surfaceTexture, int i3, int i16) {
        super(context, bVar, surfaceTexture, i3, i16);
        this.K = false;
        this.L = new int[1];
        this.P = new f();
        this.M = new j();
        this.N = new g();
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.L[0]);
        this.J = surfaceTexture2;
        surfaceTexture2.setOnFrameAvailableListener(this);
        this.K = true;
        this.Q = new h(this.G);
    }

    private void u() {
        this.M.d(this.G);
        this.M.i(this.N);
    }

    private void v() {
        if (!this.N.a(this.G)) {
            throw new RuntimeException("int program Error failed.");
        }
    }

    public void A(int i3, int i16) {
        if (this.f279404f != 0) {
            this.R = i3;
            this.S = i16;
        } else {
            this.f279404f = i3;
            this.f279405h = i16;
            this.R = 0;
        }
        this.P.k(i3, this.f279405h);
    }

    public void B(boolean z16) {
        f fVar = this.P;
        if (fVar != null) {
            fVar.g(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    public void b() {
        g gVar = this.N;
        if (gVar != null) {
            gVar.b();
        }
        super.b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    protected void c() {
        SurfaceTexture surfaceTexture = this.J;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.J.setOnFrameAvailableListener(null);
            this.J = null;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    public void d() {
        h hVar = this.Q;
        if (hVar != null) {
            hVar.d();
        }
        super.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    protected boolean e() {
        if (!this.K) {
            return false;
        }
        int i3 = this.R;
        if (i3 != 0) {
            this.f279404f = i3;
            int i16 = this.S;
            this.f279405h = i16;
            this.R = 0;
            GLES20.glViewport(1, 0, i3, i16);
        }
        synchronized (this) {
            GLES20.glActiveTexture(33984);
            this.J.updateTexImage();
        }
        q();
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    public void g() {
        t();
        super.g();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            k();
        }
    }

    public void p(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            Log.e("SurfaceTest", str + ": glError " + GLUtils.getEGLErrorString(glGetError));
        }
    }

    public Surface r() {
        return new Surface(s());
    }

    public SurfaceTexture s() {
        return this.J;
    }

    protected void t() {
        h hVar = this.Q;
        if (hVar == null || hVar.a()) {
            return;
        }
        this.Q.b(new a());
        this.Q.c();
    }

    public void w(int i3, int i16) {
        A(i3, i16);
    }

    public void x(int i3, int i16) {
        A(i3, i16);
    }

    public void y() {
        m();
    }

    public boolean z(View view, MotionEvent motionEvent) {
        f fVar = this.P;
        if (fVar == null) {
            return false;
        }
        fVar.c(motionEvent);
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.panorama.e
    protected void i() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2884);
        GLES20.glEnable(2929);
        C();
        v();
        u();
    }

    private void C() {
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.L, 0);
        p("Texture generate");
        GLES20.glBindTexture(36197, this.L[0]);
        p("Texture bind");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        SurfaceTexture surfaceTexture = this.J;
        if (surfaceTexture == null) {
            SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.L[0]);
            this.J = surfaceTexture2;
            surfaceTexture2.setOnFrameAvailableListener(this);
        } else {
            surfaceTexture.detachFromGLContext();
            this.J.attachToGLContext(this.L[0]);
            this.J.setOnFrameAvailableListener(this);
        }
    }

    private void q() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        this.N.j();
        this.M.i(this.N);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.L[0]);
        GLES20.glUniform1i(this.N.h(), 0);
        this.P.h(this.N, this.f279404f, this.f279405h);
        GLES20.glDrawArrays(4, 0, this.M.a());
    }
}
