package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import x81.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(14)
/* loaded from: classes11.dex */
public class NormalVideoARRenderable implements com.tencent.mobileqq.ar.ARRenderModel.a, SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {
    private int C;
    private int N;
    c P;
    p Q;
    boolean R;
    private x81.g S;
    private x81.i T;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f197191e;

    /* renamed from: f, reason: collision with root package name */
    private String f197192f;

    /* renamed from: i, reason: collision with root package name */
    private int f197194i;

    /* renamed from: d, reason: collision with root package name */
    private MediaPlayer f197190d = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f197193h = false;

    /* renamed from: m, reason: collision with root package name */
    private int f197195m = 0;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private float[] K = new float[16];
    public float[] L = new float[16];
    private int M = 0;
    private g.a U = new a();
    private boolean V = true;
    public long W = 0;
    public long X = 0;
    private Runnable Y = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.3
        @Override // java.lang.Runnable
        @TargetApi(11)
        public void run() {
            try {
                NormalVideoARRenderable.this.f197191e.updateTexImage();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    th5.printStackTrace();
                }
            }
            NormalVideoARRenderable.this.f197191e.getTransformMatrix(NormalVideoARRenderable.this.K);
            if (com.tencent.mobileqq.olympic.activity.d.f255224a) {
                NormalVideoARRenderable normalVideoARRenderable = NormalVideoARRenderable.this;
                long j3 = normalVideoARRenderable.X + 1;
                normalVideoARRenderable.X = j3;
                if (j3 >= 30) {
                    normalVideoARRenderable.X = 0L;
                    long currentTimeMillis = System.currentTimeMillis();
                    NormalVideoARRenderable normalVideoARRenderable2 = NormalVideoARRenderable.this;
                    float f16 = 30000.0f / ((float) (currentTimeMillis - normalVideoARRenderable2.W));
                    normalVideoARRenderable2.W = currentTimeMillis;
                    QLog.d(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, 2, "video fetch=" + f16);
                }
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ NormalVideoARRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onDestroy();
            NormalVideoARRenderable normalVideoARRenderable = this.this$0;
            c cVar = normalVideoARRenderable.P;
            if (cVar != null) {
                cVar.h(1, normalVideoARRenderable.C - this.this$0.f197195m);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements g.a {
        a() {
        }

        @Override // x81.g.a
        public void init(int i3) {
            NormalVideoARRenderable.this.N = GLES20.glGetUniformLocation(i3, "uDisplayType");
            com.tencent.mobileqq.ar.g.a("glGetUniformLocation uDisplayType");
        }

        @Override // x81.g.a
        public void update() {
            GLES20.glUniform1i(NormalVideoARRenderable.this.N, NormalVideoARRenderable.this.f197194i);
        }
    }

    public NormalVideoARRenderable(c cVar, p pVar) {
        this.f197194i = 0;
        this.C = 1;
        this.R = false;
        this.P = cVar;
        this.Q = pVar;
        this.f197192f = pVar.f197321j;
        this.C = pVar.f197322k;
        this.f197194i = pVar.f197320i;
        this.T = pVar.f197323l;
        String lowerCase = DeviceInfoMonitor.getModel().toLowerCase();
        if (Build.MANUFACTURER.toLowerCase().contains("meizu") && lowerCase.contains("m040")) {
            this.R = true;
        }
    }

    private void m() {
        QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mHasMediaInit=" + this.E);
        Matrix.setIdentityM(this.K, 0);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.M = iArr[0];
        QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mTextureID=" + this.M);
        if (this.M == 0) {
            return;
        }
        n();
    }

    private void n() {
        if (this.S == null) {
            x81.g b16 = x81.h.b(this.T, 1);
            this.S = b16;
            b16.j(com.tencent.mobileqq.ar.g.f198366a, com.tencent.mobileqq.ar.g.f198368c);
            this.S.k("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // \u9700\u8981\u6e32\u67d3\u6210\u5706\u5f62\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // \u5706\u5fc3(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.U);
            x81.g gVar = this.S;
            p pVar = this.Q;
            gVar.c(pVar.f197229e, pVar.f197230f, pVar.f197231g, pVar.f197232h);
        }
    }

    private void p() {
        QLog.d("AREngine_ARVideoRenderable", 1, "initMedia, mHasMediaInit=" + this.E);
        if (this.E) {
            return;
        }
        this.E = true;
        if (TextUtils.isEmpty(this.f197192f)) {
            QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, mVideoPath is empty");
            return;
        }
        if (!new File(this.f197192f).exists()) {
            QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, file not exist");
            return;
        }
        try {
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f197190d = reportMediaPlayer;
            reportMediaPlayer.setOnCompletionListener(this);
            this.f197190d.setOnErrorListener(this);
            this.f197190d.setOnBufferingUpdateListener(this);
            this.f197190d.setOnPreparedListener(this);
            this.f197190d.setOnInfoListener(this);
            this.f197190d.setLooping(false);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.M);
            this.f197191e = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            Surface surface = new Surface(this.f197191e);
            this.f197190d.setSurface(surface);
            surface.release();
            this.E = true;
        } catch (Throwable th5) {
            QLog.d("AREngine_ARVideoRenderable", 1, "init, throwable t = " + th5.getMessage());
            if (QLog.isColorLevel()) {
                th5.printStackTrace();
            }
        }
    }

    private void q() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "isColorLevel, mLoopCount=" + this.C + ", mCurPlayCount=" + this.f197195m);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        if (!this.R && this.E && this.f197190d != null && (this.G || this.f197193h || this.H)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        p pVar = this.Q;
        if (pVar != null) {
            return pVar.f197228d;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        p pVar = this.Q;
        if (pVar != null) {
            return pVar.f197226b;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.Q.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void init() {
        if (this.D) {
            return;
        }
        this.D = true;
        QLog.d("AREngine_ARVideoRenderable", 1, "init");
        m();
        p();
    }

    public void j(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        if (this.F && fArr2 != null && fArr3 != null && fArr4 != null && this.Q != null) {
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glEnable(3042);
            if (this.S == null) {
                n();
            }
            p pVar = this.Q;
            if (pVar != null && pVar.f197228d == 1) {
                x81.g gVar = this.S;
                if (gVar != null) {
                    gVar.f(new int[]{this.M}, this.T, k(fArr, fArr3, fArr4), this.K);
                }
            } else {
                x81.g gVar2 = this.S;
                if (gVar2 != null) {
                    gVar2.f(new int[]{this.M}, this.T, k(fArr, fArr2, fArr4), this.K);
                }
            }
            GLES20.glDisable(3042);
            GLES20.glBindTexture(36197, 0);
            if (this.V) {
                this.V = false;
            }
        }
    }

    public float[] k(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.setIdentityM(this.L, 0);
        if (g() == 2) {
            ArCloudConfigInfo.b bVar = this.Q.f197324m;
            if (bVar != null) {
                Matrix.scaleM(this.L, 0, bVar.f197706c * fArr[0], bVar.f197707d * fArr[1], 1.0f);
                float[] fArr4 = this.L;
                ArCloudConfigInfo.b bVar2 = this.Q.f197324m;
                Matrix.translateM(fArr4, 0, bVar2.f197708e, bVar2.f197709f, bVar2.f197710g);
            }
        } else {
            if (this.Q.f197229e != 1) {
                Matrix.scaleM(this.L, 0, fArr[0], fArr[1], 1.0f);
            }
            float[] fArr5 = this.L;
            Matrix.multiplyMM(fArr5, 0, fArr2, 0, fArr5, 0);
            float[] fArr6 = this.L;
            Matrix.multiplyMM(fArr6, 0, fArr3, 0, fArr6, 0);
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        j((float[]) aVar.a("TARGET_SIZE"), (float[]) aVar.a("POSE"), (float[]) aVar.a("CAMERA_MATRIX"), (float[]) aVar.a("CAMERA_POSITION"));
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        return this.F;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "onBufferingUpdate, percent=" + i3);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "onCompletion");
        }
        c cVar = this.P;
        if (cVar != null) {
            cVar.h(2, this.C - this.f197195m);
        }
        if (this.f197195m >= this.C) {
            this.G = true;
            this.H = false;
            return;
        }
        try {
            this.f197190d.stop();
            this.f197190d.prepare();
            this.f197190d.start();
            this.f197195m++;
            q();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            QLog.d("AREngine_ARVideoRenderable", 1, "onCompletion, exception=" + e16 + ", msg=" + e16.getMessage());
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        QLog.d("AREngine_ARVideoRenderable", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        MediaPlayer mediaPlayer = this.f197190d;
        if (mediaPlayer != null) {
            try {
                boolean isPlaying = mediaPlayer.isPlaying();
                if (QLog.isColorLevel()) {
                    QLog.d("HSRender", 2, "onDestroy, isPlaying=" + isPlaying + ", isLooping=" + this.f197190d.isLooping());
                }
                if (isPlaying) {
                    this.f197190d.stop();
                }
                this.f197190d.reset();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                QLog.d("AREngine_ARVideoRenderable", 1, "onDestroy, exception, e=" + e16.getMessage());
            }
        }
        this.F = false;
        x81.g gVar = this.S;
        if (gVar != null) {
            gVar.i();
            this.S = null;
        }
        this.f197195m = 0;
        this.H = false;
        this.G = false;
        this.f197193h = false;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        QLog.d("AREngine_ARVideoRenderable", 1, "onError, what=" + i3 + ", extra" + i16);
        c cVar = this.P;
        if (cVar != null) {
            cVar.f(this.Q.f197225a);
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put("extra", String.valueOf(i16));
        hashMap.put("url", this.Q.f197225a);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "immersed_ar_on_error", true, 0L, 0L, hashMap, "", false);
        onDestroy();
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.I) {
            this.F = true;
        } else {
            this.I = true;
        }
        if (!this.H && DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 6")) {
            QLog.d("AREngine_ARVideoRenderable", 1, "onFrameAvailable mIsLooping ");
        } else {
            this.P.i(this.Y);
        }
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "onInfo, what=" + i3 + ", extra=" + i16);
            return false;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "onPrepared");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        MediaPlayer mediaPlayer;
        boolean z16;
        QLog.d("AREngine_ARVideoRenderable", 1, "start");
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "start, arTarget=" + this);
        }
        if (!this.f197193h && (mediaPlayer = this.f197190d) != null && !mediaPlayer.isPlaying()) {
            this.I = false;
            this.F = false;
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(this.f197192f));
                    try {
                        this.f197190d.setDataSource(fileInputStream2.getFD());
                        this.f197195m = 1;
                        MediaPlayer mediaPlayer2 = this.f197190d;
                        if (this.C == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        mediaPlayer2.setLooping(z16);
                        this.H = true;
                        this.f197190d.prepare();
                        this.G = false;
                        this.f197190d.start();
                        this.f197193h = true;
                        c cVar = this.P;
                        if (cVar != null) {
                            cVar.h(0, this.C);
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th5) {
                            th = th5;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            th.printStackTrace();
                        }
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        QLog.d("AREngine_ARVideoRenderable", 2, "start, IOException=" + e.getMessage());
                        if (QLog.isColorLevel()) {
                            e.printStackTrace();
                        }
                        onDestroy();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th6) {
                                th = th6;
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                th.printStackTrace();
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = fileInputStream2;
                        QLog.d("AREngine_ARVideoRenderable", 2, "start, Throwable=" + th.getMessage());
                        if (QLog.isColorLevel()) {
                            th.printStackTrace();
                        }
                        onDestroy();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th8) {
                                th = th8;
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                th.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e17) {
                    e = e17;
                } catch (Throwable th9) {
                    th = th9;
                }
            } catch (Throwable th10) {
                if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th11) {
                        if (QLog.isColorLevel()) {
                            th11.printStackTrace();
                        }
                    }
                }
                throw th10;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARVideoRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying(), mIsPlaying=" + this.f197193h + ", mMediaPlayer=" + this.f197190d);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
    }
}
