package aq;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder;
import com.tencent.ttpic.video.AEDecoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements AEDecoder, SurfaceTexture.OnFrameAvailableListener, com.tencent.mobileqq.videocodec.mediacodec.decoder.d {
    private com.tencent.mobileqq.videocodec.mediacodec.decoder.a E;
    private int I;
    private int J;
    private SurfaceTextureFilter K;

    /* renamed from: d, reason: collision with root package name */
    private final int f26706d = 1;

    /* renamed from: e, reason: collision with root package name */
    private final int f26707e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final int f26708f = 3;

    /* renamed from: h, reason: collision with root package name */
    private final int f26709h = 4;

    /* renamed from: i, reason: collision with root package name */
    private final int f26710i = 5;

    /* renamed from: m, reason: collision with root package name */
    private final int f26711m = 6;
    private int C = 1;
    private final Object F = new Object();
    private int G = -1;
    private int H = -1;
    private Frame L = new Frame();
    private float[] M = new float[16];
    private HWVideoDecoder D = new HWVideoDecoder();

    public a(String str) {
        this.E = new com.tencent.mobileqq.videocodec.mediacodec.decoder.a(str, 0, false, false);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void a(long j3) throws InterruptedException {
        synchronized (this.F) {
            while (this.C != 2) {
                LockMethodProxy.wait(this.F);
            }
        }
        this.C = 3;
        this.F.notifyAll();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.M);
        this.C = 4;
        this.F.notifyAll();
    }

    @Override // com.tencent.ttpic.video.AEDecoder
    public void release() {
        c();
        this.D.e();
    }

    @Override // com.tencent.ttpic.video.AEDecoder
    public void setTexture(int i3) {
        b();
        this.I = i3;
        this.D.c(this.E, this.J, this, this);
        this.C = 2;
    }

    private void b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.J = iArr[0];
        SurfaceTextureFilter surfaceTextureFilter = new SurfaceTextureFilter();
        this.K = surfaceTextureFilter;
        surfaceTextureFilter.apply();
    }

    private void c() {
        GLES20.glDeleteTextures(1, new int[]{this.J}, 0);
        this.L.clear();
        this.K.clearGLSLSelf();
    }

    @Override // com.tencent.ttpic.video.AEDecoder
    public int getNextFrameTexture() {
        try {
            synchronized (this.F) {
                while (true) {
                    int i3 = this.C;
                    if (i3 == 4 || i3 == 5 || i3 == 6) {
                        break;
                    }
                    LockMethodProxy.wait(this.F);
                }
            }
        } catch (InterruptedException unused) {
        }
        if (this.C != 4) {
            return -1;
        }
        if (this.G == -1 || this.H == -1) {
            this.G = this.D.b();
            this.H = this.D.a();
        }
        this.K.updateMatrix(this.M);
        this.K.RenderProcess(this.J, this.G, this.H, this.I, 0.0d, this.L);
        this.C = 2;
        this.F.notifyAll();
        return 0;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeError(int i3, Throwable th5) {
        this.C = 6;
        this.F.notifyAll();
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeFinish() {
        this.C = 5;
        this.F.notifyAll();
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeSeekTo(long j3) {
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeCancel() {
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeRepeat() {
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.decoder.d
    public void onDecodeStart() {
    }
}
