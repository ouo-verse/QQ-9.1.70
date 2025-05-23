package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.mobileqq.ar.ARRenderModel.m;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class ARPromotionMediaPlayerWrapper implements SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnSeekCompleteListener {
    private Surface C;
    private SurfaceTexture D;
    private RenderBuffer J;
    private TextureRender K;
    private a M;
    private String R;

    /* renamed from: f, reason: collision with root package name */
    private int f196811f;

    /* renamed from: h, reason: collision with root package name */
    private ISuperPlayer f196812h;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f196809d = false;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f196810e = false;

    /* renamed from: i, reason: collision with root package name */
    private long f196813i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f196814m = -1;
    private float[] E = new float[16];
    private float[] F = new float[16];
    private ByteBuffer[] G = new ByteBuffer[3];
    private int[] H = new int[3];
    private m I = new m(0);
    private volatile boolean L = false;
    private boolean N = false;
    private int P = 0;
    private int Q = 1;
    private boolean S = false;
    private boolean T = true;
    private Runnable U = new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!ARPromotionMediaPlayerWrapper.this.L && ARPromotionMediaPlayerWrapper.this.D != null) {
                    ARPromotionMediaPlayerWrapper.this.D.updateTexImage();
                    ARPromotionMediaPlayerWrapper.this.D.getTransformMatrix(ARPromotionMediaPlayerWrapper.this.F);
                    ARPromotionMediaPlayerWrapper.this.f196813i++;
                    ARPromotionMediaPlayerWrapper.this.A();
                    Matrix.setIdentityM(ARPromotionMediaPlayerWrapper.this.E, 0);
                    ARPromotionMediaPlayerWrapper.this.J.bind();
                    ARPromotionMediaPlayerWrapper.this.K.drawTexture(36197, ARPromotionMediaPlayerWrapper.this.f196814m, ARPromotionMediaPlayerWrapper.this.F, ARPromotionMediaPlayerWrapper.this.E);
                    ARPromotionMediaPlayerWrapper.this.J.unbind();
                    if (ARPromotionMediaPlayerWrapper.this.f196813i == 2 && ARPromotionMediaPlayerWrapper.this.M != null) {
                        ARPromotionMediaPlayerWrapper.this.M.j(ARPromotionMediaPlayerWrapper.this.f196811f, 0, ARPromotionMediaPlayerWrapper.this.J.getTexId());
                        QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.drawFrame hardWare");
                    }
                }
            } catch (Exception e16) {
                QLog.e("ARWorldCupMediaPlayerWrapper", 1, "mUpdateHardTextureRunnable fail.", e16);
            }
        }
    };
    private boolean V = false;

    /* renamed from: com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f196815d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f196816e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ byte[] f196817f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f196818h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f196819i;
        final /* synthetic */ ARPromotionMediaPlayerWrapper this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.this$0.L) {
                try {
                    this.this$0.A();
                    this.this$0.f196813i++;
                    if (this.this$0.J != null && this.this$0.I != null) {
                        this.this$0.J.bind();
                        this.this$0.D(this.f196815d, this.f196816e, this.f196817f);
                        if (!this.this$0.I.h()) {
                            this.this$0.I.a();
                            this.this$0.I.d(m.C);
                        }
                        this.this$0.I.b(this.this$0.G[0], this.this$0.G[1], this.this$0.G[2], this.f196818h, this.f196819i);
                        this.this$0.I.g();
                        this.this$0.J.unbind();
                        if (this.this$0.f196813i == 2 && this.this$0.M != null) {
                            this.this$0.M.j(this.this$0.f196811f, 0, this.this$0.J.getTexId());
                            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface a {
        void b(Runnable runnable);

        void j(int i3, int i16, int i17);
    }

    public ARPromotionMediaPlayerWrapper(a aVar, int i3) {
        this.M = aVar;
        this.f196811f = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ISuperPlayer iSuperPlayer;
        if (this.J == null && (iSuperPlayer = this.f196812h) != null) {
            this.J = new RenderBuffer(iSuperPlayer.getVideoWidth(), this.f196812h.getVideoHeight(), 33984);
            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
        }
        if (this.K == null) {
            this.K = new TextureRender();
            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
        }
        RenderBuffer renderBuffer = this.J;
        if (renderBuffer != null && !GLES20.glIsTexture(renderBuffer.getTexId())) {
            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
        }
    }

    private void C() {
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", this.f196812h));
        if (this.D == null || this.C == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            Matrix.setIdentityM(this.F, 0);
            this.f196814m = iArr[0];
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f196814m);
            this.D = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.C = new Surface(this.D);
        }
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer == null) {
            this.f196812h = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 108, null);
        } else {
            iSuperPlayer.stop();
            this.f196812h.reset();
        }
        this.f196812h.setSurface(this.C);
        this.f196812h.setOnVideoPreparedListener(this);
        this.f196812h.setOnInfoListener(this);
        this.f196812h.setOnErrorListener(this);
        this.f196812h.setOnDefinitionInfoListener(this);
        this.f196812h.setOnCompletionListener(this);
        this.f196812h.setOnSeekCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer[] byteBufferArr = this.G;
        if (byteBufferArr[0] == null || this.H[0] != bArr.length) {
            try {
                byteBufferArr[0] = ByteBuffer.allocateDirect(bArr.length);
                this.G[0].order(ByteOrder.nativeOrder());
            } catch (Throwable th5) {
                QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", th5);
            }
        }
        this.G[0].clear();
        this.H[0] = bArr.length;
        this.G[0].put(bArr);
        this.G[0].position(0);
        ByteBuffer[] byteBufferArr2 = this.G;
        if (byteBufferArr2[1] == null || this.H[1] != bArr2.length) {
            try {
                byteBufferArr2[1] = ByteBuffer.allocateDirect(bArr.length);
                this.G[1].order(ByteOrder.nativeOrder());
            } catch (Throwable th6) {
                QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", th6);
            }
        }
        this.G[1].clear();
        this.H[1] = bArr2.length;
        this.G[1].put(bArr2);
        this.G[1].position(0);
        ByteBuffer[] byteBufferArr3 = this.G;
        if (byteBufferArr3[2] == null || this.H[2] != bArr3.length) {
            try {
                byteBufferArr3[2] = ByteBuffer.allocateDirect(bArr.length);
                this.G[2].order(ByteOrder.nativeOrder());
            } catch (Throwable th7) {
                QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", th7);
            }
        }
        this.G[2].clear();
        this.H[2] = bArr3.length;
        this.G[2].put(bArr3);
        this.G[2].position(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, MD5Utils.toMD5(str));
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.enableCodecReuse = false;
        obtain.isPrePlay = false;
        this.f196812h.openMediaPlayer(BaseApplication.getContext(), createVideoInfoForUrl, 0L, obtain);
    }

    public long B() {
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return -1L;
    }

    public boolean E() {
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer == null) {
            return false;
        }
        return iSuperPlayer.isPlaying();
    }

    public void G(String str, long j3, boolean z16, int i3, boolean z17) {
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("playVideo videoUrl=%s videoSize=%s", str, Long.valueOf(j3)));
        C();
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer != null && !iSuperPlayer.isPlaying()) {
            this.T = true;
            this.N = z17;
            this.P = 0;
            if (i3 <= 0) {
                i3 = 10000;
            }
            this.Q = i3;
            this.R = str;
            F(str);
            this.S = false;
        }
    }

    public void H() {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("releaseVideoPlayer mVideoPlayer=%s", this.f196812h));
        try {
            this.T = true;
            this.M = null;
            if (this.f196812h != null) {
                this.L = true;
                this.f196812h.stop();
                this.f196812h.release();
                this.f196812h = null;
                this.I.f();
                SurfaceTexture surfaceTexture = this.D;
                if (surfaceTexture != null) {
                    surfaceTexture.setOnFrameAvailableListener(null);
                    this.D.release();
                    this.D = null;
                }
                Surface surface = this.C;
                if (surface != null) {
                    surface.release();
                    this.C = null;
                }
                int i3 = this.f196814m;
                if (i3 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                    this.f196814m = -1;
                }
                RenderBuffer renderBuffer = this.J;
                if (renderBuffer != null) {
                    renderBuffer.destroy();
                    this.J = null;
                }
                TextureRender textureRender = this.K;
                if (textureRender != null) {
                    textureRender.release();
                }
            }
        } catch (Exception unused) {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
        }
    }

    public void I() {
        try {
            if (this.f196812h != null && !this.f196810e) {
                this.f196810e = true;
                this.f196812h.seekTo(0);
                QLog.d("ARWorldCupMediaPlayerWrapper", 1, "mVideoPlayer restart seekTo(0)");
            }
        } catch (Exception e16) {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "restart mVideoPlayer error happen", e16);
        }
    }

    public void J(boolean z16) {
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, "call setMu result:" + z16);
        this.V = z16;
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    public void K(boolean z16) {
        this.T = z16;
    }

    public void L() {
        StringBuilder sb5;
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "stopVideo");
        ISuperPlayer iSuperPlayer = this.f196812h;
        if (iSuperPlayer != null) {
            try {
                try {
                    this.f196813i = 0L;
                    if (iSuperPlayer.isPlaying() || this.S) {
                        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "run inner stopVideo");
                        this.f196812h.stop();
                        this.S = false;
                    }
                    try {
                        if (this.J != null) {
                            this.J = null;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        sb5 = new StringBuilder();
                        sb5.append("stopVideo finllay fail.");
                        sb5.append(e);
                        QLog.e("ARWorldCupMediaPlayerWrapper", 1, sb5.toString());
                    }
                } catch (Throwable th5) {
                    try {
                        if (this.J != null) {
                            this.J = null;
                        }
                    } catch (Exception e17) {
                        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + e17);
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                QLog.e("ARWorldCupMediaPlayerWrapper", 1, "playVideo fail.", e18);
                try {
                    if (this.J != null) {
                        this.J = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    sb5 = new StringBuilder();
                    sb5.append("stopVideo finllay fail.");
                    sb5.append(e);
                    QLog.e("ARWorldCupMediaPlayerWrapper", 1, sb5.toString());
                }
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        this.f196810e = false;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                if (ARPromotionMediaPlayerWrapper.this.T) {
                    ARPromotionMediaPlayerWrapper.this.P++;
                }
                QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + ARPromotionMediaPlayerWrapper.this.T + " mCurrentPlayTimes=" + ARPromotionMediaPlayerWrapper.this.P + "|" + ARPromotionMediaPlayerWrapper.this.Q);
                if (ARPromotionMediaPlayerWrapper.this.P >= ARPromotionMediaPlayerWrapper.this.Q || ARPromotionMediaPlayerWrapper.this.f196812h == null || ARPromotionMediaPlayerWrapper.this.L) {
                    ARPromotionMediaPlayerWrapper.this.P = 0;
                    ARPromotionMediaPlayerWrapper.this.Q = 1;
                    ARPromotionMediaPlayerWrapper.this.S = true;
                    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
                    if (ARPromotionMediaPlayerWrapper.this.M != null && ARPromotionMediaPlayerWrapper.this.J != null) {
                        ARPromotionMediaPlayerWrapper.this.M.j(ARPromotionMediaPlayerWrapper.this.f196811f, 1, 0);
                        return;
                    }
                    return;
                }
                try {
                    ARPromotionMediaPlayerWrapper.this.f196812h.stop();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, stop, exception=" + e16.getMessage());
                }
                ARPromotionMediaPlayerWrapper.this.f196812h.setOutputMute(ARPromotionMediaPlayerWrapper.this.V);
                ARPromotionMediaPlayerWrapper aRPromotionMediaPlayerWrapper = ARPromotionMediaPlayerWrapper.this;
                aRPromotionMediaPlayerWrapper.F(aRPromotionMediaPlayerWrapper.R);
                ARPromotionMediaPlayerWrapper.this.S = false;
                if (ARPromotionMediaPlayerWrapper.this.N && ARPromotionMediaPlayerWrapper.this.M != null && ARPromotionMediaPlayerWrapper.this.J != null) {
                    ARPromotionMediaPlayerWrapper.this.M.j(ARPromotionMediaPlayerWrapper.this.f196811f, 1, ARPromotionMediaPlayerWrapper.this.Q - ARPromotionMediaPlayerWrapper.this.P);
                }
                QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (ARPromotionMediaPlayerWrapper.this.Q - ARPromotionMediaPlayerWrapper.this.P) + "video resources:" + ARPromotionMediaPlayerWrapper.this.R);
            }
        };
        a aVar = this.M;
        if (aVar != null) {
            aVar.b(runnable);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onError");
        this.f196810e = false;
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a aVar = this.M;
        if (aVar != null) {
            aVar.b(this.U);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
        if (this.f196812h != null) {
            this.f196810e = false;
            try {
                this.f196812h.start();
            } catch (Exception e16) {
                QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", e16);
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared");
        this.f196810e = false;
        ISuperPlayer iSuperPlayer2 = this.f196812h;
        if (iSuperPlayer2 != null) {
            try {
                iSuperPlayer2.start();
            } catch (Exception e16) {
                QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", e16);
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
    }
}
