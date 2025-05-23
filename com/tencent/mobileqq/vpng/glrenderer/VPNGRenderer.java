package com.tencent.mobileqq.vpng.glrenderer;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: classes20.dex */
public class VPNGRenderer extends GLRenderer implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_;

    /* renamed from: w0, reason: collision with root package name */
    private static final short[] f313190w0;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private float[] P;
    private FloatBuffer Q;
    private FloatBuffer R;
    private float[] S;
    private float[] T;
    private float[] U;
    private float[] V;
    private float[] W;
    private float[] X;
    private float[] Y;
    private float[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private int[] f313191a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f313192b0;

    /* renamed from: c0, reason: collision with root package name */
    private FloatBuffer f313193c0;

    /* renamed from: d0, reason: collision with root package name */
    private ShortBuffer f313194d0;

    /* renamed from: e0, reason: collision with root package name */
    private float[] f313195e0;

    /* renamed from: f0, reason: collision with root package name */
    private SurfaceTexture f313196f0;

    /* renamed from: g0, reason: collision with root package name */
    public MediaPlayer f313197g0;

    /* renamed from: h0, reason: collision with root package name */
    private MediaPlayer.OnCompletionListener f313198h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f313199i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f313200j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f313201k0;

    /* renamed from: l0, reason: collision with root package name */
    private volatile boolean f313202l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f313203m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f313204n0;

    /* renamed from: o0, reason: collision with root package name */
    private long f313205o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.vpng.glrenderer.a f313206p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f313207q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f313208r0;

    /* renamed from: s0, reason: collision with root package name */
    private LiveRoomGiftCallback f313209s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f313210t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f313211u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f313212v0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VPNGRenderer.this);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            if (!VPNGRenderer.this.f313204n0) {
                VPNGRenderer.this.f313202l0 = false;
                if (VPNGRenderer.this.f313198h0 != null) {
                    VPNGRenderer.this.f313198h0.onCompletion(VPNGRenderer.this.f313197g0);
                }
            } else {
                VPNGRenderer.this.f313197g0.start();
                if (VPNGRenderer.this.f313207q0) {
                    VPNGRenderer.this.M();
                }
            }
            if (VPNGRenderer.this.f313209s0 != null) {
                VPNGRenderer.this.f313209s0.onCall(7, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements MediaPlayer.OnErrorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VPNGRenderer.this);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            if (VPNGRenderer.this.f313209s0 != null) {
                VPNGRenderer.this.f313209s0.onCall(2, "");
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f313190w0 = new short[]{0, 1, 2, 0, 2, 3};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VPNGRenderer(int i3, int i16) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.I = false;
        this.P = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f313191a0 = new int[1];
        this.f313195e0 = new float[16];
        this.f313208r0 = 0;
        D();
    }

    private void B() {
        MediaPlayer mediaPlayer;
        synchronized (this) {
            if (!this.f313203m0) {
                return;
            }
            GLES20.glUseProgram(this.f313192b0);
            synchronized (this) {
                try {
                    if (this.I && (mediaPlayer = this.f313197g0) != null && this.f313196f0 != null && mediaPlayer.isPlaying()) {
                        this.f313196f0.updateTexImage();
                        this.f313196f0.getTransformMatrix(this.f313195e0);
                        this.I = false;
                    }
                } catch (Exception e16) {
                    QLog.e("VPNGRenderer", 2, "draw:" + e16.getMessage());
                }
            }
            C(this.F, this.G);
        }
    }

    private void C(int i3, int i16) {
        if (this.f313193c0 == null) {
            return;
        }
        O(i3, i16);
        GLES20.glEnableVertexAttribArray(this.M);
        GLES20.glVertexAttribPointer(this.M, 2, 5126, false, 0, (Buffer) this.f313193c0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f313191a0[0]);
        GLES20.glUniform1i(this.J, 0);
        GLES20.glEnableVertexAttribArray(this.K);
        GLES20.glVertexAttribPointer(this.K, 2, 5126, false, 0, (Buffer) this.Q);
        GLES20.glEnableVertexAttribArray(this.L);
        GLES20.glVertexAttribPointer(this.L, 2, 5126, false, 0, (Buffer) this.R);
        GLES20.glUniformMatrix4fv(this.N, 1, false, this.f313195e0, 0);
        GLES20.glDrawElements(4, f313190w0.length, 5123, this.f313194d0);
        GLES20.glDisableVertexAttribArray(this.M);
        GLES20.glDisableVertexAttribArray(this.K);
        GLES20.glDisableVertexAttribArray(this.L);
    }

    private void D() {
        float[] fArr = {0.0f, 1.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f, 1.0f};
        this.W = fArr;
        float[] fArr2 = {0.5f, 1.0f, 0.5f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.X = fArr2;
        this.V = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f, 1.0f};
        this.U = new float[]{0.5f, 1.0f, 0.5f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.S = fArr;
        this.T = fArr2;
        this.Y = new float[]{0.0f, 1.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f, 1.0f};
        this.Z = new float[]{0.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.5f};
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f313197g0 = reportMediaPlayer;
        reportMediaPlayer.setOnCompletionListener(new a());
        this.f313197g0.setOnErrorListener(new b());
        p(new Runnable() { // from class: com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VPNGRenderer.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                GLES20.glDeleteTextures(VPNGRenderer.this.f313191a0.length, VPNGRenderer.this.f313191a0, 0);
                GLES20.glDeleteProgram(VPNGRenderer.this.f313192b0);
                GLES20.glFlush();
            }
        });
    }

    private void E() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.S.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.Q = asFloatBuffer;
        asFloatBuffer.put(this.S);
        this.Q.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.T.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.R = asFloatBuffer2;
        asFloatBuffer2.put(this.T);
        this.R.position(0);
    }

    private void H(String str) {
        MediaPlayer mediaPlayer;
        float[] fArr;
        float[] fArr2;
        String str2 = this.f313199i0;
        if ((str2 == null || !str2.equals(str) || !this.f313202l0 || this.f313210t0) && (mediaPlayer = this.f313197g0) != null) {
            int i3 = this.f313208r0;
            if (i3 == 0) {
                fArr = this.W;
            } else if (i3 == 1) {
                fArr = this.U;
            } else {
                fArr = this.Z;
            }
            this.S = fArr;
            if (i3 == 0) {
                fArr2 = this.X;
            } else if (i3 == 1) {
                fArr2 = this.V;
            } else {
                fArr2 = this.Y;
            }
            this.T = fArr2;
            mediaPlayer.reset();
            if (this.f313210t0) {
                this.f313210t0 = false;
                this.f313205o0 = 0L;
                E();
            }
            try {
                this.f313197g0.setDataSource(str);
                this.f313197g0.prepare();
                this.f313200j0 = this.f313197g0.getVideoWidth();
                this.f313201k0 = this.f313197g0.getVideoHeight();
                this.f313197g0.start();
                this.f313202l0 = true;
            } catch (Exception e16) {
                QLog.e("VPNGRenderer", 2, "playVideo Exception: " + e16.getMessage());
                MediaPlayer.OnCompletionListener onCompletionListener = this.f313198h0;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(this.f313197g0);
                }
            }
        } else if (this.f313202l0) {
            J();
        }
        this.f313199i0 = str;
    }

    private void I() {
        MediaPlayer mediaPlayer;
        try {
            if (this.f313202l0 && (mediaPlayer = this.f313197g0) != null && !mediaPlayer.isPlaying()) {
                this.f313197g0.start();
            }
        } catch (Exception e16) {
            QLog.e("VPNGRenderer", 1, "playVideo(" + this.f313199i0 + "): " + e16.getMessage());
        }
    }

    private void O(int i3, int i16) {
        float f16;
        float f17 = this.f313200j0;
        float f18 = this.f313201k0;
        int i17 = this.f313208r0;
        if (i17 != 1 && i17 != 0) {
            f18 /= 2.0f;
        } else {
            f17 /= 2.0f;
        }
        float f19 = i3;
        float f26 = f19 / f17;
        float f27 = i16;
        float f28 = (f18 * f26) / f27;
        if (i17 != 1 && i17 != 2) {
            f16 = 1.0f;
        } else {
            if (f17 * f27 >= f18 * f19) {
                f26 = f27 / f18;
            }
            f16 = (f17 * f26) / f19;
            f28 = (f18 * f26) / f27;
        }
        float[] fArr = this.P;
        float f29 = -f16;
        fArr[0] = f29;
        fArr[1] = f28;
        fArr[2] = f29;
        float f36 = -f28;
        fArr[3] = f36;
        fArr[4] = f16;
        fArr[5] = f36;
        fArr[6] = f16;
        fArr[7] = f28;
        this.f313193c0.put(fArr);
        this.f313193c0.position(0);
    }

    private void Q() {
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.f313211u0)) {
            str = this.f313211u0;
        } else {
            str = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}";
        }
        if (!TextUtils.isEmpty(this.f313212v0)) {
            str2 = this.f313212v0;
        } else {
            str2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r * alpha;\n    gl_FragColor.g = gl_FragColor.g * alpha;\n    gl_FragColor.b = gl_FragColor.b * alpha;\n}";
        }
        int a16 = com.tencent.mobileqq.surfaceviewaction.util.a.a(str, str2);
        this.f313192b0 = a16;
        GLES20.glUseProgram(a16);
        this.J = GLES20.glGetUniformLocation(this.f313192b0, "texture");
        this.K = GLES20.glGetAttribLocation(this.f313192b0, "vTexCoordinate");
        this.L = GLES20.glGetAttribLocation(this.f313192b0, "vTexAlphaCoordinate");
        this.M = GLES20.glGetAttribLocation(this.f313192b0, "vPosition");
        this.N = GLES20.glGetUniformLocation(this.f313192b0, "textureTransform");
    }

    private void R() {
        if (this.f313197g0 == null) {
            return;
        }
        E();
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.f313191a0, 0);
        GLES20.glBindTexture(36197, this.f313191a0[0]);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f313191a0[0]);
        this.f313196f0 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.f313196f0);
        try {
            this.f313197g0.setSurface(surface);
        } catch (Exception e16) {
            QLog.e("VPNGRenderer", 1, "setupTexture(" + this.f313199i0 + "): " + e16.getMessage());
        }
        surface.release();
    }

    private void S() {
        short[] sArr = f313190w0;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.f313194d0 = asShortBuffer;
        asShortBuffer.put(sArr);
        this.f313194d0.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.P.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.f313193c0 = asFloatBuffer;
        asFloatBuffer.put(this.P);
        this.f313193c0.position(0);
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.D = true;
        MediaPlayer mediaPlayer = this.f313197g0;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.pause();
            } catch (Exception e16) {
                QLog.e("VPNGRenderer", 2, "pauseVideo: " + e16.getMessage());
            }
            LiveRoomGiftCallback liveRoomGiftCallback = this.f313209s0;
            if (liveRoomGiftCallback != null) {
                liveRoomGiftCallback.onCall(3, "");
            }
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            H(this.f313199i0);
        }
    }

    public void J() {
        MediaPlayer mediaPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.D = false;
        if (this.f313202l0 && (mediaPlayer = this.f313197g0) != null) {
            try {
                mediaPlayer.start();
            } catch (Exception e16) {
                QLog.e("VPNGRenderer", 2, "resumeVideo: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(com.tencent.mobileqq.vpng.glrenderer.a aVar) {
        this.f313206p0 = aVar;
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.f313204n0 = z16;
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f313207q0 = true;
        MediaPlayer mediaPlayer = this.f313197g0;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    public void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f313210t0 = z16;
        }
    }

    public void P(String str, int i3, LiveRoomGiftCallback liveRoomGiftCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), liveRoomGiftCallback);
            return;
        }
        this.f313208r0 = i3;
        this.f313199i0 = str;
        this.f313209s0 = liveRoomGiftCallback;
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.GLRenderer
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Q();
        S();
        R();
        I();
        this.f313206p0.onDrawBegin();
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.GLRenderer
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.f313197g0;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e16) {
            QLog.e("VPNGRenderer", 2, "onDestroy: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.GLRenderer
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.E == null) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        } else {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        B();
        GLES20.glFinish();
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.GLRenderer
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.vpng.glrenderer.GLRenderer
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        t();
        SurfaceTexture surfaceTexture = this.f313196f0;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f313196f0 = null;
        }
        MediaPlayer mediaPlayer = this.f313197g0;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f313197g0.release();
                this.f313197g0.setOnCompletionListener(null);
            } catch (Exception e16) {
                QLog.e("VPNGRenderer", 2, "release: " + e16.getMessage());
            }
            this.f313197g0 = null;
            this.f313203m0 = false;
            LiveRoomGiftCallback liveRoomGiftCallback = this.f313209s0;
            if (liveRoomGiftCallback != null) {
                liveRoomGiftCallback.onCall(6, "");
            }
        }
        super.n();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) surfaceTexture);
            return;
        }
        synchronized (this) {
            this.I = true;
            this.f313203m0 = true;
            if (this.f313205o0 == 0) {
                this.f313205o0 = System.currentTimeMillis();
                LiveRoomGiftCallback liveRoomGiftCallback = this.f313209s0;
                if (liveRoomGiftCallback != null) {
                    liveRoomGiftCallback.onCall(4, "");
                }
            } else {
                LiveRoomGiftCallback liveRoomGiftCallback2 = this.f313209s0;
                if (liveRoomGiftCallback2 != null) {
                    liveRoomGiftCallback2.onCall(5, "");
                }
            }
        }
    }
}
