package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.surfaceviewaction.f;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoSprite extends e implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.a, Runnable, SpriteGLView.a {
    static IPatchRedirector $redirector_;
    protected static final short[] M0;
    protected FrameSprite.a A0;
    protected String B0;
    protected int C0;
    protected int D0;
    protected boolean E0;
    protected boolean F0;
    protected boolean G0;
    protected Handler H0;
    protected boolean I0;
    protected boolean J0;
    protected Surface K0;
    protected f L0;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f291261a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f291262b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f291263c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f291264d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f291265e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f291266f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f291267g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f291268h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f291269i0;

    /* renamed from: j0, reason: collision with root package name */
    protected c f291270j0;

    /* renamed from: k0, reason: collision with root package name */
    protected b f291271k0;

    /* renamed from: l0, reason: collision with root package name */
    protected float[] f291272l0;

    /* renamed from: m0, reason: collision with root package name */
    protected SpriteGLView f291273m0;

    /* renamed from: n0, reason: collision with root package name */
    protected FloatBuffer f291274n0;

    /* renamed from: o0, reason: collision with root package name */
    protected FloatBuffer f291275o0;

    /* renamed from: p0, reason: collision with root package name */
    protected float f291276p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f291277q0;

    /* renamed from: r0, reason: collision with root package name */
    protected float[] f291278r0;

    /* renamed from: s0, reason: collision with root package name */
    protected float[] f291279s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int[] f291280t0;

    /* renamed from: u0, reason: collision with root package name */
    protected int f291281u0;

    /* renamed from: v0, reason: collision with root package name */
    protected FloatBuffer f291282v0;

    /* renamed from: w0, reason: collision with root package name */
    protected ShortBuffer f291283w0;

    /* renamed from: x0, reason: collision with root package name */
    protected float[] f291284x0;

    /* renamed from: y0, reason: collision with root package name */
    protected SurfaceTexture f291285y0;

    /* renamed from: z0, reason: collision with root package name */
    protected MediaPlayer f291286z0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class CompletionListener implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<VideoSprite> f291290d;

        CompletionListener(VideoSprite videoSprite) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoSprite);
            } else {
                this.f291290d = new WeakReference<>(videoSprite);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            VideoSprite videoSprite = this.f291290d.get();
            if (videoSprite == null) {
                return;
            }
            if (videoSprite.I0) {
                videoSprite.f291273m0.t(new Runnable(videoSprite) { // from class: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ VideoSprite f291291d;

                    {
                        this.f291291d = videoSprite;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CompletionListener.this, (Object) videoSprite);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            MediaPlayer mediaPlayer2 = this.f291291d.f291286z0;
                            if (mediaPlayer2 != null) {
                                mediaPlayer2.start();
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("VideoSprite", 2, "onCompletion: " + QLog.getStackTraceString(e16));
                            }
                        }
                    }
                });
                return;
            }
            videoSprite.E0 = false;
            videoSprite.H0.removeCallbacksAndMessages(null);
            FrameSprite.a aVar = videoSprite.A0;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class a implements MediaPlayer.OnErrorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<VideoSprite> f291292d;

        a(VideoSprite videoSprite) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoSprite);
            } else {
                this.f291292d = new WeakReference<>(videoSprite);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            VideoSprite videoSprite = this.f291292d.get();
            if (videoSprite == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "onError: " + i3);
            }
            if (i3 == 1) {
                FrameSprite.a aVar = videoSprite.A0;
                if (aVar != null) {
                    aVar.a();
                }
                videoSprite.stop();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void onProgressChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d implements MediaPlayer.OnPreparedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<VideoSprite> f291293d;

        d(VideoSprite videoSprite) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoSprite);
            } else {
                this.f291293d = new WeakReference<>(videoSprite);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            VideoSprite videoSprite = this.f291293d.get();
            if (videoSprite == null) {
                return;
            }
            try {
                videoSprite.C0 = videoSprite.f291286z0.getVideoWidth();
                videoSprite.D0 = videoSprite.f291286z0.getVideoHeight();
                videoSprite.f291286z0.start();
                videoSprite.E0 = true;
                if (videoSprite.f291270j0 != null) {
                    videoSprite.H0.postDelayed(videoSprite, 33L);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(e16));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            M0 = new short[]{0, 1, 2, 0, 2, 3};
        }
    }

    public VideoSprite(SpriteGLView spriteGLView, Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spriteGLView, context, Boolean.valueOf(z16));
            return;
        }
        this.Z = false;
        this.f291261a0 = false;
        this.f291262b0 = false;
        this.f291263c0 = false;
        this.f291272l0 = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f291276p0 = 0.5f;
        this.f291280t0 = new int[1];
        this.f291284x0 = new float[16];
        this.H0 = new Handler(Looper.getMainLooper());
        this.L0 = new f(0.0f, 0.0f);
        this.f291273m0 = spriteGLView;
        this.H = true;
        this.f291277q0 = z16;
        float f16 = z16 ? 0.5f : 1.0f;
        this.f291276p0 = f16;
        this.f291278r0 = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, f16, 0.0f, 0.0f, 1.0f, f16, 1.0f, 0.0f, 1.0f};
        this.f291279s0 = new float[]{f16, 1.0f, 0.0f, 1.0f, f16, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f291286z0 = reportMediaPlayer;
        reportMediaPlayer.setOnCompletionListener(new CompletionListener(this));
        this.f291286z0.setOnErrorListener(new a(this));
        spriteGLView.j(this);
        spriteGLView.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoSprite.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                VideoSprite.this.b0();
                VideoSprite.this.d0();
                VideoSprite.this.c0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (this.f291286z0 == null) {
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f291278r0.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f291274n0 = asFloatBuffer;
        asFloatBuffer.put(this.f291278r0);
        this.f291274n0.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.f291279s0.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.f291275o0 = asFloatBuffer2;
        asFloatBuffer2.put(this.f291279s0);
        this.f291275o0.position(0);
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.f291280t0, 0);
        N("Texture generate");
        GLES20.glBindTexture(36197, this.f291280t0[0]);
        N("Texture bind");
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f291280t0[0]);
        this.f291285y0 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = this.K0;
        if (surface != null) {
            surface.release();
        }
        Surface surface2 = new Surface(this.f291285y0);
        this.K0 = surface2;
        try {
            this.f291286z0.setSurface(surface2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoSprite", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        short[] sArr = M0;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.f291283w0 = asShortBuffer;
        asShortBuffer.put(sArr);
        this.f291283w0.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.f291272l0.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.f291282v0 = asFloatBuffer;
        asFloatBuffer.put(this.f291272l0);
        this.f291282v0.position(0);
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.e, com.tencent.mobileqq.surfaceviewaction.gl.d
    public void A(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        synchronized (this) {
            if (!this.F0) {
                return;
            }
            GLES20.glUseProgram(this.f291281u0);
            synchronized (this) {
                if (this.f291263c0) {
                    try {
                        this.f291285y0.updateTexImage();
                        this.f291285y0.getTransformMatrix(this.f291284x0);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("VideoSprite", 2, QLog.getStackTraceString(e16));
                        }
                    }
                    this.f291263c0 = false;
                    if (this.G0 && (bVar = this.f291271k0) != null) {
                        this.G0 = false;
                        bVar.a();
                    }
                }
            }
            O(i3, i16);
        }
    }

    public void N(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("SurfaceTest", str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    protected void O(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f291282v0 == null) {
            return;
        }
        a0(i3, i16);
        GLES20.glEnableVertexAttribArray(this.f291267g0);
        GLES20.glVertexAttribPointer(this.f291267g0, 2, 5126, false, 0, (Buffer) this.f291282v0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f291280t0[0]);
        GLES20.glUniform1i(this.f291264d0, 0);
        GLES20.glEnableVertexAttribArray(this.f291265e0);
        GLES20.glVertexAttribPointer(this.f291265e0, 4, 5126, false, 0, (Buffer) this.f291274n0);
        if (this.f291277q0) {
            GLES20.glUniform1i(this.f291269i0, 1);
            GLES20.glEnableVertexAttribArray(this.f291266f0);
            GLES20.glVertexAttribPointer(this.f291266f0, 4, 5126, false, 0, (Buffer) this.f291275o0);
        } else {
            GLES20.glUniform1i(this.f291269i0, 0);
        }
        GLES20.glUniformMatrix4fv(this.f291268h0, 1, false, this.f291284x0, 0);
        GLES20.glDrawElements(4, M0.length, 5123, this.f291283w0);
        GLES20.glDisableVertexAttribArray(this.f291267g0);
        GLES20.glDisableVertexAttribArray(this.f291265e0);
        GLES20.glDisableVertexAttribArray(this.f291266f0);
    }

    protected String P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        Context context = this.f291273m0.getContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("troop");
        String str = File.separator;
        sb5.append(str);
        sb5.append("shaders");
        sb5.append(str);
        sb5.append("FragmentShaderVideo.glsl");
        return com.tencent.mobileqq.surfaceviewaction.util.a.c(context, sb5.toString());
    }

    protected String Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        Context context = this.f291273m0.getContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("troop");
        String str = File.separator;
        sb5.append(str);
        sb5.append("shaders");
        sb5.append(str);
        sb5.append("VertexShaderVideo.glsl");
        return com.tencent.mobileqq.surfaceviewaction.util.a.c(context, sb5.toString());
    }

    public boolean R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f291286z0 == null) {
            return true;
        }
        return false;
    }

    protected void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "playVideo");
        }
        this.f291273m0.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoSprite.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                VideoSprite videoSprite = VideoSprite.this;
                if (videoSprite.E0 && (mediaPlayer = videoSprite.f291286z0) != null && !mediaPlayer.isPlaying()) {
                    VideoSprite.this.f291286z0.start();
                }
            }
        });
    }

    public void T(String str) {
        MediaPlayer mediaPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "playVideo: " + str);
        }
        String str2 = this.B0;
        if ((str2 == null || !str2.equals(str) || !this.E0) && (mediaPlayer = this.f291286z0) != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(e16));
                }
            }
            try {
                this.f291286z0.reset();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(e17));
                }
            }
            try {
                this.f291286z0.setDataSource(str);
                this.f291286z0.prepareAsync();
                this.f291286z0.setOnPreparedListener(new d(this));
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(e18));
                }
                FrameSprite.a aVar = this.A0;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
        this.B0 = str;
    }

    public void U(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "playVideo with seek: " + str);
        }
        this.f291273m0.t(new Runnable(str, i3) { // from class: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f291287d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f291288e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite$2$a */
            /* loaded from: classes18.dex */
            class a implements MediaPlayer.OnSeekCompleteListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                        return;
                    }
                    try {
                        VideoSprite.this.f291286z0.start();
                        VideoSprite videoSprite = VideoSprite.this;
                        videoSprite.E0 = true;
                        if (videoSprite.f291270j0 != null) {
                            videoSprite.H0.postDelayed(videoSprite, 33L);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("VideoSprite", 2, "playVideo: " + QLog.getStackTraceString(e16));
                        }
                    }
                }
            }

            {
                this.f291287d = str;
                this.f291288e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VideoSprite.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = VideoSprite.this.B0;
                if ((str2 == null || !str2.equals(this.f291287d) || !VideoSprite.this.E0) && (mediaPlayer = VideoSprite.this.f291286z0) != null) {
                    mediaPlayer.stop();
                    VideoSprite.this.f291286z0.reset();
                    try {
                        VideoSprite.this.f291286z0.setDataSource(this.f291287d);
                        VideoSprite.this.f291286z0.prepare();
                        VideoSprite videoSprite = VideoSprite.this;
                        videoSprite.C0 = videoSprite.f291286z0.getVideoWidth();
                        VideoSprite videoSprite2 = VideoSprite.this;
                        videoSprite2.D0 = videoSprite2.f291286z0.getVideoHeight();
                        VideoSprite.this.f291286z0.setOnSeekCompleteListener(new a());
                        VideoSprite.this.f291286z0.seekTo(this.f291288e);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(e16));
                        }
                        FrameSprite.a aVar = VideoSprite.this.A0;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                }
                VideoSprite.this.B0 = this.f291287d;
            }
        });
    }

    public void V(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.B0 = str;
        }
    }

    public void W(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.I0 = z16;
        }
    }

    public void X(FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.A0 = aVar;
        }
    }

    public void Y(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bVar);
        } else {
            this.f291271k0 = bVar;
        }
    }

    public void Z(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) cVar);
        } else {
            this.f291270j0 = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(int i3, int i16) {
        float f16;
        float g16;
        float g17;
        float g18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.M = i3;
        this.N = i16;
        float f17 = this.f291151e;
        if (f17 != 0.0f) {
            f16 = f17 / this.f291276p0;
        } else {
            f16 = this.C0;
        }
        float f18 = this.f291152f;
        if (f18 == 0.0f) {
            f18 = this.D0;
        }
        if (this.Z) {
            g16 = this.f291155m * g();
        } else {
            g16 = ((this.f291155m * g()) * (this.f291276p0 * f16)) / i3;
        }
        if (this.f291262b0 && this.Z) {
            float f19 = i3;
            float f26 = i16;
            if (f19 / f16 < f26 / f18) {
                g16 *= (f26 * f16) / (f19 * f18);
            }
        }
        float f27 = i3;
        float f28 = f18 * ((f27 / this.f291276p0) / f16) * g16;
        float f29 = i16;
        float f36 = f28 / f29;
        h(this.L0);
        if (this.f291261a0) {
            g17 = ((this.L0.f291217a * g()) / this.f291276p0) / f27;
        } else {
            g17 = (((this.L0.f291217a * g()) - (i3 / 2)) / this.f291276p0) / f27;
        }
        if (this.f291261a0) {
            g18 = ((this.L0.f291218b * g()) / this.f291276p0) / f29;
        } else {
            g18 = (((this.L0.f291218b * g()) - (i16 / 2)) / this.f291276p0) / f29;
        }
        float[] fArr = this.f291272l0;
        float f37 = (-g16) + g17;
        fArr[0] = f37;
        float f38 = f36 + g18;
        fArr[1] = f38;
        fArr[2] = f37;
        float f39 = (-f36) + g18;
        fArr[3] = f39;
        float f46 = g16 + g17;
        fArr[4] = f46;
        fArr[5] = f39;
        fArr[6] = f46;
        fArr[7] = f38;
        this.f291282v0.put(fArr);
        this.f291282v0.position(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            this.f291281u0 = com.tencent.mobileqq.surfaceviewaction.util.a.a(Q(), P());
        } catch (Exception e16) {
            QLog.e("VideoSprite", 2, "setupGraphics: " + QLog.getStackTraceString(e16));
        }
        GLES20.glUseProgram(this.f291281u0);
        this.f291264d0 = GLES20.glGetUniformLocation(this.f291281u0, "texture");
        this.f291265e0 = GLES20.glGetAttribLocation(this.f291281u0, "vTexCoordinate");
        this.f291266f0 = GLES20.glGetAttribLocation(this.f291281u0, "vTexAlphaCoordinate");
        this.f291267g0 = GLES20.glGetAttribLocation(this.f291281u0, "vPosition");
        this.f291268h0 = GLES20.glGetUniformLocation(this.f291281u0, "textureTransform");
        this.f291269i0 = GLES20.glGetUniformLocation(this.f291281u0, "v_isAlpha");
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.a
    public int getCurrentTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        MediaPlayer mediaPlayer = this.f291286z0;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getCurrentPosition();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "getCurrentTime: " + QLog.getStackTraceString(e16));
                    return 0;
                }
                return 0;
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.l();
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "pause");
        }
        try {
            MediaPlayer mediaPlayer = this.f291286z0;
            if (mediaPlayer != null && !this.J0 && mediaPlayer.isPlaying()) {
                this.f291286z0.pause();
                this.J0 = true;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "pause: " + QLog.getStackTraceString(e16));
            }
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.e, com.tencent.mobileqq.surfaceviewaction.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        MediaPlayer mediaPlayer = this.f291286z0;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setOnCompletionListener(null);
                this.f291286z0.setOnErrorListener(null);
                this.f291286z0.setOnPreparedListener(null);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, QLog.getStackTraceString(e16));
                }
            }
            try {
                this.f291286z0.stop();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, QLog.getStackTraceString(e17));
                }
            }
            try {
                this.f291286z0.release();
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, QLog.getStackTraceString(e18));
                }
            }
            this.f291286z0 = null;
            this.F0 = false;
            this.A0 = null;
            this.f291271k0 = null;
            this.f291273m0.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoSprite.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int[] iArr = VideoSprite.this.f291280t0;
                    GLES20.glDeleteTextures(iArr.length, iArr, 0);
                    GLES20.glFlush();
                }
            });
            this.f291273m0.s(this);
            this.H0.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.n();
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "resume");
        }
        MediaPlayer mediaPlayer = this.f291286z0;
        if (mediaPlayer != null) {
            if (this.J0) {
                try {
                    mediaPlayer.start();
                    this.J0 = false;
                } catch (Exception unused) {
                }
            } else {
                String str = this.B0;
                if (str != null) {
                    T(str);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView.a
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        b0();
        d0();
        c0();
        S();
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.f291286z0;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "onDestroy->mMediaPlayer.pause(): " + QLog.getStackTraceString(e16));
            }
        }
        try {
            Surface surface = this.K0;
            if (surface != null) {
                surface.release();
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "onDestroy->release surface: " + QLog.getStackTraceString(e17));
            }
        }
        this.H0.removeCallbacksAndMessages(null);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surfaceTexture);
            return;
        }
        synchronized (this) {
            this.f291263c0 = true;
            if (!this.F0) {
                this.G0 = true;
                this.F0 = true;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.f291286z0 != null && this.f291270j0 != null) {
            this.H0.postDelayed(this, 33L);
            try {
                i3 = this.f291286z0.getCurrentPosition();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoSprite", 2, "run: " + QLog.getStackTraceString(e16));
                }
                i3 = 0;
            }
            this.f291270j0.onProgressChanged(i3);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoSprite", 2, "stop");
        }
        MediaPlayer mediaPlayer = this.f291286z0;
        if (mediaPlayer != null) {
            if (this.E0 || this.F0 || this.J0) {
                try {
                    mediaPlayer.stop();
                    this.E0 = false;
                    this.F0 = false;
                    this.J0 = false;
                } catch (Exception unused) {
                }
            }
        }
    }
}
