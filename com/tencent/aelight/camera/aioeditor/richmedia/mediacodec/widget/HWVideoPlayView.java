package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder;
import com.tencent.ark.EGLContextHolder;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes32.dex */
public class HWVideoPlayView extends GLSurfaceView implements GLSurfaceView.Renderer {
    public int C;
    public int D;
    protected int E;
    protected boolean F;
    public int G;
    public int H;
    protected int I;
    private final DecodeConfig J;
    private HWDecodeListener K;
    private GPUOESBaseFilter L;
    protected AudioDecoder M;
    protected final com.tencent.mobileqq.videocodec.audio.b N;
    public long P;
    public boolean Q;
    protected int R;
    protected long S;
    private boolean T;
    protected boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private long f67498a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f67499b0;

    /* renamed from: c0, reason: collision with root package name */
    public long f67500c0;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<b> f67501d;

    /* renamed from: d0, reason: collision with root package name */
    public int f67502d0;

    /* renamed from: e, reason: collision with root package name */
    protected HWVideoDecoder f67503e;

    /* renamed from: e0, reason: collision with root package name */
    private GLSurfaceView.EGLContextFactory f67504e0;

    /* renamed from: f, reason: collision with root package name */
    private int f67505f;

    /* renamed from: h, reason: collision with root package name */
    protected SurfaceTexture f67506h;

    /* renamed from: i, reason: collision with root package name */
    protected int f67507i;

    /* renamed from: m, reason: collision with root package name */
    protected int f67508m;

    /* loaded from: classes32.dex */
    class a implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f67510a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;

        a() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                QLog.e("HWVideoPlayView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
            HWVideoPlayView.this.k();
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f67510a, 2, 12344};
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 1, "createContext. display = " + eGLDisplay + " tid = " + Thread.currentThread().getId());
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void N();

        void g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class c implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<HWVideoPlayView> f67512d;

        public c(HWVideoPlayView hWVideoPlayView) {
            this.f67512d = new WeakReference<>(hWVideoPlayView);
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeCancel() {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onDecodeCancel error, videoPlayView is null!");
                return;
            }
            if (Thread.currentThread().getId() == hWVideoPlayView.S) {
                hWVideoPlayView.R = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 2, "onDecodeCancel, mCurrentStat:", Integer.valueOf(hWVideoPlayView.R));
            }
            if (hWVideoPlayView.K != null) {
                hWVideoPlayView.K.onDecodeCancel();
            }
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeError(int i3, Throwable th5) {
            QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + i3, th5);
            im2.b.a(th5);
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFinish() {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onDecodeFinish error, videoPlayView is null!");
                return;
            }
            if (Thread.currentThread().getId() == hWVideoPlayView.S) {
                hWVideoPlayView.R = 5;
            }
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 2, "onDecodeFinish, mCurrentStat:", Integer.valueOf(hWVideoPlayView.R));
            }
            if (hWVideoPlayView.K != null) {
                hWVideoPlayView.K.onDecodeFinish();
            }
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFrame(long j3, long j16) throws InterruptedException {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                return;
            }
            hWVideoPlayView.h(j3, j16);
            if (hWVideoPlayView.K != null) {
                hWVideoPlayView.K.onDecodeFrame(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeRepeat() {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onDecodeRepeat error, videoPlayView is null!");
                return;
            }
            QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
            hWVideoPlayView.M.d();
            if (hWVideoPlayView.K != null) {
                hWVideoPlayView.K.onDecodeRepeat();
            }
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeSeekTo(long j3) {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onDecodeSeekTo error, videoPlayView is null!");
            } else {
                hWVideoPlayView.M.f(j3);
            }
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeStart() {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onDecodeStart error, videoPlayView is null!");
                return;
            }
            hWVideoPlayView.R = 3;
            hWVideoPlayView.S = Thread.currentThread().getId();
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 2, "onDecodeStart, mCurrentStat:", Integer.valueOf(hWVideoPlayView.R));
            }
            if (hWVideoPlayView.K != null) {
                hWVideoPlayView.K.onDecodeStart();
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            HWVideoPlayView hWVideoPlayView = this.f67512d.get();
            if (hWVideoPlayView == null) {
                QLog.e("HWVideoPlayView", 1, "onFrameAvailable error, videoPlayView is null!");
            } else {
                hWVideoPlayView.f67506h = surfaceTexture;
                hWVideoPlayView.requestRender();
            }
        }
    }

    public HWVideoPlayView(Context context) {
        this(context, null);
    }

    public int c(int i3) {
        this.I = i3;
        return i3;
    }

    public int d(LocalMediaInfo localMediaInfo) {
        if (k.f(localMediaInfo)) {
            this.I = localMediaInfo.rotation + 90;
        } else {
            this.I = localMediaInfo.rotation;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 2, "adjustRotation: mVideoRotation=" + this.I);
        }
        return this.I;
    }

    public int f() {
        return this.J.speedType;
    }

    public String g() {
        return this.J.inputFilePath;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(float[] fArr, float[] fArr2) {
        this.L.drawTexture(this.f67505f, fArr, fArr2);
    }

    protected void j() {
        if (com.tencent.mobileqq.monitor.a.f247270d) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.monitor.a.f247271e.d(2, currentTimeMillis);
            if (com.tencent.mobileqq.monitor.a.f247271e.c()) {
                long[] jArr = com.tencent.mobileqq.monitor.a.f247271e.f247274b;
                long j3 = jArr[0];
                long j16 = currentTimeMillis - j3;
                long j17 = jArr[1];
                long j18 = j17 - j3;
                long j19 = jArr[2] - j17;
                if (id0.a.g(j16, 0L, 10000L) && id0.a.g(j18, 0L, 10000L) && id0.a.g(j19, 0L, 10000L)) {
                    id0.a.r("OpenEditCost", true, j16, String.valueOf(com.tencent.mobileqq.monitor.a.f247271e.f247275c), String.valueOf(j18), String.valueOf(j19));
                }
                com.tencent.mobileqq.monitor.a.f247271e.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        b bVar;
        SurfaceTexture surfaceTexture = this.f67506h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f67506h = null;
        }
        this.T = true;
        o();
        WeakReference<b> weakReference = this.f67501d;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.N();
    }

    public void l() {
        this.f67503e.pauseDecode();
        this.M.b();
        this.R = 4;
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 2, "pausePlay, mCurrentStat:", Integer.valueOf(this.R));
        }
        if (this.f67498a0 != 0) {
            this.f67500c0 += System.currentTimeMillis() - this.f67498a0;
            this.f67502d0 = this.f67499b0 - 15;
            this.f67498a0 = 0L;
        }
    }

    public void m() {
        this.f67503e.resumeDecode();
        this.M.e();
        this.R = 3;
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 2, "resumePlay, mCurrentStat:", Integer.valueOf(this.R));
        }
        if (this.f67498a0 == 0) {
            this.f67498a0 = System.currentTimeMillis();
        }
    }

    public void n() {
        if (!TextUtils.isEmpty(this.J.inputFilePath)) {
            this.f67503e.stopDecode();
            this.R = 1;
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 2, "startPlay, mCurrentStat:", Integer.valueOf(this.R));
            }
            c cVar = new c(this);
            this.f67503e.startDecode(this.J, this.f67505f, cVar, cVar);
            if (TextUtils.isEmpty(this.N.f312508a)) {
                return;
            }
            this.M.j(this.N);
            return;
        }
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }

    public void o() {
        this.f67503e.pauseDecode();
        this.M.b();
        this.f67503e.stopDecode();
        this.M.k();
        if (!this.W || this.f67498a0 <= 0) {
            return;
        }
        this.f67500c0 = System.currentTimeMillis() - this.f67498a0;
        this.f67502d0 = this.f67499b0 - 15;
        this.f67498a0 = 0L;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        long j3;
        try {
            if (this.f67506h != null) {
                if (!this.V) {
                    this.V = true;
                    j();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.W && this.f67499b0 > 15) {
                    this.W = true;
                    this.f67498a0 = currentTimeMillis;
                }
                if (com.tencent.mobileqq.monitor.a.f247268b) {
                    com.tencent.mobileqq.monitor.a.f247269c.f();
                    j3 = SystemClock.elapsedRealtime();
                } else {
                    j3 = 0;
                }
                this.f67506h.updateTexImage();
                float[] fArr = new float[16];
                this.f67506h.getTransformMatrix(fArr);
                i(fArr, GPUBaseFilter.caculateCenterCropMvpMatrix(this.C, this.D, this.f67507i, this.f67508m));
                this.f67499b0++;
                if (com.tencent.mobileqq.monitor.a.f247269c.c()) {
                    com.tencent.mobileqq.monitor.a.f247269c.e(Integer.valueOf((int) (SystemClock.elapsedRealtime() - j3)));
                    if (com.tencent.mobileqq.monitor.a.f247269c.a(8000)) {
                        com.tencent.mobileqq.monitor.a.c();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", th5);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        b bVar;
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 4, "onSurfaceChanged : " + i3 + ";" + i16);
        }
        this.f67505f = GlUtil.createTexture(36197);
        if (Build.VERSION.SDK_INT == 26 && !Build.MANUFACTURER.equals("HUAWEI")) {
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoPlayView", 4, "onSurfaceChanged special 8.0 device. Delay play.");
            }
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.2
                @Override // java.lang.Runnable
                public void run() {
                    HWVideoPlayView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (HWVideoPlayView.this.T) {
                                return;
                            }
                            HWVideoPlayView.this.n();
                        }
                    });
                }
            }, 500L);
        } else {
            n();
        }
        this.f67507i = i3;
        this.f67508m = i16;
        this.L.onOutputSizeChanged(this.C, this.D);
        WeakReference<b> weakReference = this.f67501d;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.g0();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
        }
        GPUOESBaseFilter gPUOESBaseFilter = (GPUOESBaseFilter) com.tencent.mobileqq.filter.a.a(102);
        this.L = gPUOESBaseFilter;
        gPUOESBaseFilter.init();
        this.T = false;
    }

    protected void p() {
        int i3 = this.C;
        int i16 = this.D;
        if (i3 * i16 <= 0) {
            return;
        }
        this.F = i16 * 9 == i3 * 16 || i16 * 16 == i3 * 9;
    }

    public void setBgmFilePath(String str) {
        com.tencent.mobileqq.videocodec.audio.b bVar = this.N;
        bVar.f312516i = str;
        bVar.f312517j = AudioEncoder.c(str, null, 0);
    }

    public void setDecodeListener(HWDecodeListener hWDecodeListener) {
        this.K = hWDecodeListener;
    }

    public void setFilePath(String str, String str2) {
        this.J.inputFilePath = str;
        com.tencent.mobileqq.videocodec.audio.b bVar = this.N;
        bVar.f312508a = str2;
        bVar.f312509b = AudioEncoder.c(str2, null, 0);
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.J.inputFilePath + " ; audioFilePath = " + str2);
        }
        if (this.P == 0 || this.C == 0 || this.D == 0) {
            long j3 = VideoCompositeHelper.j(this.J.inputFilePath);
            this.P = j3;
            this.N.f312515h = j3;
            d.a aVar = new d.a();
            int a16 = d.a(str, aVar);
            int[] iArr = aVar.f288248a;
            int i3 = iArr[0];
            int i16 = iArr[1];
            int i17 = this.I;
            this.C = (i17 == 90 || i17 == 270) ? i16 : i3;
            if (i17 != 90 && i17 != 270) {
                i3 = i16;
            }
            this.D = i3;
            p();
            this.G = this.C;
            this.H = this.D;
            QLog.d("HWVideoPlayView", 1, "setFilePath: errcode = " + a16 + " ; videoWidth = " + this.C + " , videoHeight=" + this.D + " , mVideoRotation=" + this.I + " , rotation=" + aVar.f288248a[2] + " videoDuration=" + this.P);
        }
    }

    public void setMediaInfo(LocalMediaInfo localMediaInfo) {
        long j3 = localMediaInfo.mDuration;
        this.P = j3;
        this.N.f312515h = j3;
        int i3 = localMediaInfo.mediaWidth;
        int i16 = localMediaInfo.mediaHeight;
        int i17 = this.I;
        this.C = (i17 == 90 || i17 == 270) ? i16 : i3;
        if (i17 != 90 && i17 != 270) {
            i3 = i16;
        }
        this.D = i3;
        p();
        this.G = this.C;
        this.H = this.D;
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 2, "videoWidth = " + this.C + " , videoHeight=" + this.D + " , mVideoRotation=" + this.I + " videoDuration=" + this.P);
        }
    }

    public void setMuteAudio(boolean z16) {
        this.N.f312512e = z16;
        this.M.g(z16);
    }

    public void setPlayRange(int i3, int i16) {
        DecodeConfig decodeConfig = this.J;
        if (decodeConfig != null) {
            decodeConfig.startTimeMillSecond = i3;
            decodeConfig.endTimeMillSecond = i16;
        }
        com.tencent.mobileqq.videocodec.audio.b bVar = this.N;
        if (bVar != null) {
            bVar.f312513f = i3;
            bVar.f312514g = i16;
        }
        HWVideoDecoder hWVideoDecoder = this.f67503e;
        if (hWVideoDecoder != null) {
            hWVideoDecoder.setPlayRange(i3, i16);
        }
        AudioDecoder audioDecoder = this.M;
        if (audioDecoder != null) {
            audioDecoder.h(i3, i16);
        }
    }

    public void setProlong(long j3) {
        this.J.prolongToTime = j3;
        this.f67503e.setProlongToTime(j3);
    }

    public void setRepeat(boolean z16) {
        this.J.repeat = z16;
        this.N.f312510c = z16;
    }

    public void setSpeedType(int i3) {
        this.J.speedType = i3;
        this.N.f312511d = i3;
        this.f67503e.setSpeedType(i3);
        this.M.i(i3);
    }

    public void setVideoDecodeConfig(DecodeConfig decodeConfig) {
        this.J.copyFrom(decodeConfig);
    }

    public void setVolume(float f16) {
        this.N.f312509b.f288233h = f16;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
        }
        super.surfaceDestroyed(surfaceHolder);
        o();
    }

    public HWVideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67503e = null;
        this.E = 0;
        this.F = false;
        this.J = new DecodeConfig();
        this.P = 0L;
        this.Q = false;
        this.R = 0;
        this.S = 0L;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f67498a0 = 0L;
        this.f67499b0 = 0;
        this.f67500c0 = 0L;
        this.f67502d0 = 0;
        a aVar = new a();
        this.f67504e0 = aVar;
        setEGLContextFactory(aVar);
        setEGLContextClientVersion(2);
        this.f67503e = new HWVideoDecoder();
        this.M = new AudioDecoder();
        this.N = new com.tencent.mobileqq.videocodec.audio.b();
        setRenderer(this);
        setRenderMode(0);
    }

    public void e() {
        setPlayRange(0, 0);
    }

    public void setPlayViewListener(b bVar) {
        if (bVar == null) {
            this.f67501d = null;
        } else {
            this.f67501d = new WeakReference<>(bVar);
        }
    }

    public void h(long j3, long j16) {
    }
}
