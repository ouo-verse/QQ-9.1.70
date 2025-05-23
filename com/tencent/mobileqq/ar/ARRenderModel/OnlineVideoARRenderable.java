package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import x81.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(11)
/* loaded from: classes11.dex */
public class OnlineVideoARRenderable implements com.tencent.mobileqq.ar.ARRenderModel.a, SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnSeekCompleteListener {
    private SurfaceTexture C;
    private int E;
    private volatile ISuperPlayer F;
    private long R;
    private String S;
    private int U;
    private int V;
    private x81.g Y;
    private x81.g Z;

    /* renamed from: a0, reason: collision with root package name */
    private x81.i f197197a0;

    /* renamed from: f, reason: collision with root package name */
    private c f197204f;

    /* renamed from: h, reason: collision with root package name */
    private q f197207h;

    /* renamed from: m, reason: collision with root package name */
    private Surface f197212m;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f197200d = false;

    /* renamed from: e, reason: collision with root package name */
    private float[] f197202e = new float[16];

    /* renamed from: i, reason: collision with root package name */
    private float[] f197209i = new float[16];
    private int D = 0;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private int M = 0;
    private boolean N = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean T = false;
    private boolean W = false;
    private int X = 0;

    /* renamed from: b0, reason: collision with root package name */
    private g.a f197198b0 = new a();

    /* renamed from: c0, reason: collision with root package name */
    private Runnable f197199c0 = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.2
        @Override // java.lang.Runnable
        public void run() {
            if (OnlineVideoARRenderable.this.J) {
                try {
                    OnlineVideoARRenderable.this.C.updateTexImage();
                    OnlineVideoARRenderable.this.C.getTransformMatrix(OnlineVideoARRenderable.this.f197209i);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    };

    /* renamed from: d0, reason: collision with root package name */
    private int f197201d0 = -1;

    /* renamed from: e0, reason: collision with root package name */
    private int f197203e0 = -1;

    /* renamed from: f0, reason: collision with root package name */
    private int f197205f0 = -1;

    /* renamed from: g0, reason: collision with root package name */
    private IntBuffer[] f197206g0 = new IntBuffer[3];

    /* renamed from: h0, reason: collision with root package name */
    private ByteBuffer[] f197208h0 = new ByteBuffer[3];

    /* renamed from: i0, reason: collision with root package name */
    private int[] f197210i0 = new int[3];

    /* renamed from: j0, reason: collision with root package name */
    private boolean f197211j0 = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ OnlineVideoARRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onDestroy();
            if (this.this$0.f197204f != null) {
                this.this$0.f197204f.h(1, this.this$0.V - this.this$0.M);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable$4, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f197213d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197214e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f197215f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ byte[] f197216h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ byte[] f197217i;
        final /* synthetic */ OnlineVideoARRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f197201d0 != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.this$0.f197201d0}, 0);
            }
            if (this.this$0.f197203e0 != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.this$0.f197203e0}, 0);
            }
            if (this.this$0.f197205f0 != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.this$0.f197205f0}, 0);
            }
            try {
                OnlineVideoARRenderable onlineVideoARRenderable = this.this$0;
                onlineVideoARRenderable.f197201d0 = onlineVideoARRenderable.F(1, this.f197213d, this.f197214e, this.f197215f);
                OnlineVideoARRenderable onlineVideoARRenderable2 = this.this$0;
                onlineVideoARRenderable2.f197203e0 = onlineVideoARRenderable2.F(2, this.f197216h, this.f197214e / 2, (this.f197215f + 1) / 2);
                OnlineVideoARRenderable onlineVideoARRenderable3 = this.this$0;
                onlineVideoARRenderable3.f197205f0 = onlineVideoARRenderable3.F(3, this.f197217i, this.f197214e / 2, (this.f197215f + 1) / 2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_OnlineVideoARRenderable", 2, "drawFrame_soft exception=" + e16.getMessage());
                    e16.printStackTrace();
                }
            }
            this.this$0.J = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements g.a {
        a() {
        }

        @Override // x81.g.a
        public void init(int i3) {
            OnlineVideoARRenderable.this.E = GLES20.glGetUniformLocation(i3, "uDisplayType");
            com.tencent.mobileqq.ar.g.a("glGetUniformLocation uDisplayType");
        }

        @Override // x81.g.a
        public void update() {
            GLES20.glUniform1i(OnlineVideoARRenderable.this.E, OnlineVideoARRenderable.this.U);
        }
    }

    public OnlineVideoARRenderable(c cVar, q qVar) {
        this.R = -1L;
        this.S = null;
        this.U = 0;
        this.V = 1;
        this.f197204f = cVar;
        this.f197207h = qVar;
        this.V = qVar.f197329m;
        this.U = qVar.f197325i;
        this.f197197a0 = qVar.f197330n;
        this.S = qVar.f197326j;
        this.R = qVar.f197327k;
        boolean b16 = com.tencent.mobileqq.ar.g.b();
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, "Construction mSoftwarePlayConfig:false  isRubbishDevice:" + b16 + "  isSoftPlay:" + this.f197207h.f197328l);
        }
    }

    private void C() {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
        Matrix.setIdentityM(this.f197209i, 0);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.D = iArr[0];
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl, mTextureID=" + this.D);
        if (this.D == 0) {
            return;
        }
        D(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str) {
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, MD5Utils.toMD5(str));
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.enableCodecReuse = false;
        obtain.isPrePlay = false;
        this.F.openMediaPlayer(BaseApplication.getContext(), createVideoInfoForUrl, 0L, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(int i3, byte[] bArr, int i16, int i17) throws Exception {
        int i18 = i3 - 1;
        IntBuffer[] intBufferArr = this.f197206g0;
        if (intBufferArr[0] == null) {
            intBufferArr[0] = IntBuffer.allocate(1);
            this.f197206g0[1] = IntBuffer.allocate(1);
            this.f197206g0[2] = IntBuffer.allocate(1);
        }
        this.f197206g0[i18].clear();
        GLES20.glGenTextures(1, this.f197206g0[i18]);
        int i19 = this.f197206g0[i18].get();
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        ByteBuffer[] byteBufferArr = this.f197208h0;
        if (byteBufferArr[i18] == null || this.f197210i0[i18] != bArr.length) {
            try {
                byteBufferArr[i18] = ByteBuffer.allocateDirect(bArr.length);
                this.f197208h0[i18].order(ByteOrder.nativeOrder());
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_OnlineVideoARRenderable", 2, "textureYUV, exception=" + th5.getMessage());
                    th5.printStackTrace();
                }
            }
        }
        this.f197210i0[i18] = bArr.length;
        this.f197208h0[i18].put(bArr);
        this.f197208h0[i18].position(0);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i16, i17, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f197208h0[i18]);
        return i19;
    }

    public void A(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float[] B;
        if (this.J && fArr2 != null && this.f197207h != null) {
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glEnable(3042);
            if (this.f197207h.f197228d == 1) {
                B = B(fArr, fArr3, fArr4);
            } else {
                B = B(fArr, fArr2, fArr4);
            }
            boolean z16 = this.P;
            if (!z16) {
                if (this.Y == null) {
                    D(z16);
                }
                x81.g gVar = this.Y;
                if (gVar != null) {
                    gVar.f(new int[]{this.D}, this.f197197a0, B, this.f197209i);
                }
            } else {
                if (this.Z == null) {
                    D(z16);
                }
                Matrix.setIdentityM(this.f197209i, 0);
                x81.g gVar2 = this.Z;
                if (gVar2 != null) {
                    gVar2.f(new int[]{this.f197201d0, this.f197203e0, this.f197205f0}, this.f197197a0, B, this.f197209i);
                }
            }
            GLES20.glDisable(3042);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GLES20.glBindTexture(36197, 0);
            if (this.f197211j0) {
                this.f197211j0 = false;
            }
        }
    }

    public float[] B(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.setIdentityM(this.f197202e, 0);
        if (g() == 2) {
            ArCloudConfigInfo.b bVar = this.f197207h.f197331o;
            if (bVar != null) {
                Matrix.scaleM(this.f197202e, 0, bVar.f197706c * fArr[0], bVar.f197707d * fArr[1], 1.0f);
                float[] fArr4 = this.f197202e;
                ArCloudConfigInfo.b bVar2 = this.f197207h.f197331o;
                Matrix.translateM(fArr4, 0, bVar2.f197708e, bVar2.f197709f, bVar2.f197710g);
            }
        } else if (fArr2 != null && fArr3 != null) {
            if (this.f197207h.f197229e != 1) {
                Matrix.scaleM(this.f197202e, 0, fArr[0], fArr[1], 1.0f);
            }
            float[] fArr5 = this.f197202e;
            Matrix.multiplyMM(fArr5, 0, fArr2, 0, fArr5, 0);
            float[] fArr6 = this.f197202e;
            Matrix.multiplyMM(fArr6, 0, fArr3, 0, fArr6, 0);
        } else {
            this.f197202e = new float[16];
        }
        return this.f197202e;
    }

    public void D(boolean z16) {
        if (z16) {
            if (this.Z == null) {
                x81.g b16 = x81.h.b(this.f197197a0, 3);
                this.Z = b16;
                b16.j(com.tencent.mobileqq.ar.g.f198367b, com.tencent.mobileqq.ar.g.f198368c);
                this.Z.k("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // \u9700\u8981\u6e32\u67d3\u6210\u5706\u5f62\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // \u5706\u5fc3(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.f197198b0);
                x81.g gVar = this.Z;
                q qVar = this.f197207h;
                gVar.c(qVar.f197229e, qVar.f197230f, qVar.f197231g, qVar.f197232h);
                return;
            }
            return;
        }
        if (this.Y == null) {
            x81.g b17 = x81.h.b(this.f197197a0, 1);
            this.Y = b17;
            b17.j(com.tencent.mobileqq.ar.g.f198366a, com.tencent.mobileqq.ar.g.f198368c);
            this.Y.k("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // \u9700\u8981\u6e32\u67d3\u6210\u5706\u5f62\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // \u5706\u5fc3(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.f197198b0);
            x81.g gVar2 = this.Y;
            q qVar2 = this.f197207h;
            gVar2.c(qVar2.f197229e, qVar2.f197230f, qVar2.f197231g, qVar2.f197232h);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        if (this.G && this.H && this.F != null && (this.K || this.L || this.F.isPlaying())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        q qVar = this.f197207h;
        if (qVar != null) {
            return qVar.f197228d;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        q qVar = this.f197207h;
        if (qVar != null) {
            return qVar.f197226b;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.f197207h.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    @TargetApi(11)
    public void init() {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "init, mHasSDKInit=" + this.G);
        if (this.G) {
            return;
        }
        C();
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.D);
        this.C = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f197212m = new Surface(this.C);
        this.F = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 108, null);
        this.F.setSurface(this.f197212m);
        this.F.setOnVideoPreparedListener(this);
        this.F.setOnInfoListener(this);
        this.F.setOnErrorListener(this);
        this.F.setOnDefinitionInfoListener(this);
        this.F.setOnCompletionListener(this);
        this.F.setOnSeekCompleteListener(this);
        this.G = true;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        A((float[]) aVar.a("TARGET_SIZE"), (float[]) aVar.a("POSE"), (float[]) aVar.a("CAMERA_MATRIX"), (float[]) aVar.a("CAMERA_POSITION"));
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        return this.J;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
        }
        c cVar = this.f197204f;
        if (cVar != null) {
            cVar.h(2, this.V - this.M);
        }
        if (this.M >= this.V) {
            this.K = true;
            this.L = false;
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        OnlineVideoARRenderable.this.F.stop();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            e16.printStackTrace();
                        }
                        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, stop, exception=" + e16.getMessage());
                    }
                    OnlineVideoARRenderable.this.N = true;
                    OnlineVideoARRenderable onlineVideoARRenderable = OnlineVideoARRenderable.this;
                    onlineVideoARRenderable.E(onlineVideoARRenderable.S);
                    OnlineVideoARRenderable.this.M++;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        e17.printStackTrace();
                    }
                    QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, exception=" + e17.getMessage());
                }
            }
        };
        c cVar2 = this.f197204f;
        if (cVar2 != null) {
            cVar2.i(runnable);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.P = false;
        this.M = 1;
        this.Q = false;
        this.N = false;
        if (this.F != null) {
            try {
                this.F.stop();
                this.F.release();
            } catch (Exception e16) {
                QLog.d("AREngine_OnlineVideoARRenderable", 1, "onDestroy exception, msg=" + e16.getMessage());
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                c cVar = this.f197204f;
                if (cVar != null) {
                    cVar.f(this.f197207h.f197225a);
                }
            }
        }
        x81.g gVar = this.Y;
        if (gVar != null) {
            gVar.i();
            this.Y = null;
        }
        x81.g gVar2 = this.Z;
        if (gVar2 != null) {
            gVar2.i();
            this.Z = null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("decode_type", String.valueOf(this.X));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "immersed_ar_decode_type", true, 0L, 0L, hashMap, "", false);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        c cVar = this.f197204f;
        if (cVar != null) {
            cVar.f(this.f197207h.f197225a);
        }
        onDestroy();
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.J = true;
        this.f197204f.i(this.f197199c0);
        if (!this.W) {
            this.W = true;
            this.X = 1;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onSeekComplete");
        iSuperPlayer.start();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, "onVideoPrepared. mCanPlay=" + this.I);
        }
        if (!this.I) {
            return;
        }
        if (this.N) {
            this.N = false;
            this.F.start();
            return;
        }
        this.H = true;
        try {
            this.F.start();
            this.L = true;
            c cVar = this.f197204f;
            if (cVar != null) {
                cVar.h(0, this.V);
            }
        } catch (Exception e16) {
            QLog.d("AREngine_OnlineVideoARRenderable", 1, "onVideoPrepared, exception=" + e16.getMessage());
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, arResourceInfo=" + this.f197207h);
        }
        if (!this.Q && this.F != null && !this.F.isPlaying()) {
            if (this.R >= 0 && !TextUtils.isEmpty(this.S)) {
                if (!this.G) {
                    QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
                    return;
                }
                this.H = false;
                this.J = false;
                this.K = false;
                this.L = false;
                this.M = 1;
                this.X = 0;
                this.W = false;
                this.I = true;
                this.Q = true;
                String a16 = y81.a.a(this.S);
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, video dir=" + a16 + ", mSoftwarePlayConfig=false");
                }
                E(this.S);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mVideoSize < 0 || TextUtils.isEmpty(mVideoUrl)");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying()");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
    }
}
