package aq;

import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.ttpic.video.AEEncoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements AEEncoder, com.tencent.mobileqq.videocodec.mediacodec.recorder.c {

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c f26713e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f26714f;

    /* renamed from: h, reason: collision with root package name */
    private float[] f26715h = new float[16];

    /* renamed from: i, reason: collision with root package name */
    private final Object f26716i = new Object();

    /* renamed from: d, reason: collision with root package name */
    private e f26712d = new e();

    public b(String str, int i3, int i16) {
        this.f26713e = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str, i3, i16, 5242880, 1, false, 0);
        Matrix.setIdentityM(this.f26715h, 0);
        Matrix.setRotateM(this.f26715h, 0, 180.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        this.f26712d.n();
        this.f26714f = false;
        synchronized (this.f26716i) {
            this.f26716i.notifyAll();
        }
    }

    @Override // com.tencent.ttpic.video.AEEncoder
    public void release() {
        this.f26712d.s();
        synchronized (this.f26716i) {
            try {
                LockMethodProxy.wait(this.f26716i);
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.tencent.ttpic.video.AEEncoder
    public int writeFrame(int i3, long j3) {
        if (!this.f26714f) {
            this.f26713e.d(EGL14.eglGetCurrentContext());
            this.f26712d.q(this.f26713e, this);
            this.f26714f = true;
        }
        this.f26712d.h(GLSLRender.GL_TEXTURE_2D, i3, null, this.f26715h, 1000000 * j3);
        return 0;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(int i3, Throwable th5) {
    }
}
