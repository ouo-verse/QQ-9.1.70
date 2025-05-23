package com.tencent.mobileqq.videocodec.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.filter.d;
import com.tencent.mobileqq.filter.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.c;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes20.dex */
public class a implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, c {
    static IPatchRedirector $redirector_;
    private Object C;
    private Object D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private long I;
    public int J;
    public int K;
    private boolean L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private GPUOESBaseFilter R;
    private g S;
    private d T;
    private GPUAlphaBlendFilter U;
    private RenderBuffer V;
    private RenderBuffer W;
    private boolean X;
    private boolean Y;
    private QQFilterRenderManager Z;

    /* renamed from: a0, reason: collision with root package name */
    private ArrayList<DynamicStickerData> f312518a0;

    /* renamed from: b0, reason: collision with root package name */
    private ArrayList<TrackerStickerParam> f312519b0;

    /* renamed from: c0, reason: collision with root package name */
    private TransferData f312520c0;

    /* renamed from: d, reason: collision with root package name */
    protected e f312521d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f312522d0;

    /* renamed from: e, reason: collision with root package name */
    protected HWVideoDecoder f312523e;

    /* renamed from: f, reason: collision with root package name */
    protected DecodeConfig f312524f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.videocodec.mediacodec.encoder.c f312525h;

    /* renamed from: i, reason: collision with root package name */
    private c f312526i;

    /* renamed from: m, reason: collision with root package name */
    private InterfaceC8954a f312527m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.videocodec.mediacodec.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8954a {
        int a(int i3, long j3);

        void b(int i3, int i16, int i17, int i18);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = new Object();
        this.D = new Object();
        this.E = false;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = 0;
        this.K = 0;
        this.L = false;
        this.N = -1;
        this.f312519b0 = null;
        this.f312522d0 = false;
        this.f312521d = new e();
        this.f312523e = new HWVideoDecoder();
    }

    private void b() {
        this.R.destroy();
        g gVar = this.S;
        if (gVar != null) {
            gVar.f();
        }
        d dVar = this.T;
        if (dVar != null) {
            dVar.destroy();
        }
        GPUAlphaBlendFilter gPUAlphaBlendFilter = this.U;
        if (gPUAlphaBlendFilter != null) {
            gPUAlphaBlendFilter.destroy();
        }
    }

    public static Bitmap d(Bitmap bitmap, float f16) {
        if (bitmap == null) {
            QLog.e("Mp4ReEncoder", 1, "rotateBitmap, arg source is null");
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f16);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        hd0.c.t("Richard", "cancelEncode");
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "cancelEncode");
        }
        this.X = true;
        this.J = 6;
        this.f312523e.stopDecode();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f312521d.m();
    }

    public void e(ArrayList<DynamicStickerData> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            this.f312518a0 = arrayList;
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            TransferData transferData = new TransferData();
            this.f312520c0 = transferData;
            transferData.fromJSONObject(str);
        }
    }

    public void g(DecodeConfig decodeConfig, com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, c cVar2, InterfaceC8954a interfaceC8954a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, decodeConfig, cVar, cVar2, interfaceC8954a);
            return;
        }
        this.f312524f = decodeConfig;
        this.f312525h = cVar;
        int i3 = decodeConfig.speedType;
        if (i3 == 1 || i3 == 3) {
            this.f312522d0 = true;
        }
        this.f312526i = cVar2;
        this.f312527m = interfaceC8954a;
        this.f312521d.q(cVar, this);
        this.X = false;
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
        }
        this.f312521d.s();
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) th5);
            return;
        }
        this.Y = true;
        this.J = i3 + 10000;
        this.f312521d.s();
        c cVar = this.f312526i;
        if (cVar != null) {
            cVar.onEncodeError(this.J, th5);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
        }
        this.Y = true;
        this.f312521d.s();
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, long j16) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + j3 + " orgSampleTime: " + j16);
        }
        synchronized (this.C) {
            this.F = j3;
            this.G = j16;
            synchronized (this.D) {
                this.D.notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + j3);
            }
            try {
                this.C.wait(2000L);
                if (!this.E && this.J == 0 && !this.X) {
                    this.H = -1L;
                    this.F = 0L;
                    this.G = 0L;
                    onEncodeError(3, new RuntimeException("frame wait timed out"));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Mp4ReEncoder", 2, "onDecodeFrame end timestamp = " + j3);
                }
                this.E = false;
            } catch (InterruptedException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
                }
                this.E = false;
                throw e16;
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeSeekTo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.Y = false;
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(int i3, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) th5);
            return;
        }
        this.J = i3;
        this.f312523e.stopDecode();
        c cVar = this.f312526i;
        if (cVar != null) {
            cVar.onEncodeError(i3, th5);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        c cVar = this.f312526i;
        if (cVar != null) {
            cVar.onEncodeFinish(str);
        }
        int i3 = this.N;
        if (i3 != -1) {
            GlUtil.deleteTexture(i3);
            this.N = -1;
        }
        this.Z.surfaceDestroyed();
        int i16 = this.M;
        if (i16 != -1) {
            GlUtil.deleteTexture(i16);
            this.M = -1;
        }
        GlUtil.deleteTexture(this.M);
        b();
        this.V.destroy();
        this.W.destroy();
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        c cVar = this.f312526i;
        if (cVar != null) {
            cVar.onEncodeFrame();
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
        List<QQBaseFilter> qQFilters;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        try {
            this.M = GlUtil.createTexture(36197);
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.f312525h;
            this.V = new RenderBuffer(cVar.f312559d, cVar.f312560e, 33984);
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = this.f312525h;
            this.W = new RenderBuffer(cVar2.f312559d, cVar2.f312560e, 33984);
            GPUOESBaseFilter gPUOESBaseFilter = (GPUOESBaseFilter) com.tencent.mobileqq.filter.a.a(102);
            this.R = gPUOESBaseFilter;
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar3 = this.f312525h;
            gPUOESBaseFilter.onOutputSizeChanged(cVar3.f312559d, cVar3.f312560e);
            this.R.init();
            DecodeConfig decodeConfig = this.f312524f;
            if (decodeConfig.isLocal && this.f312525h.f312574s) {
                if (decodeConfig.isLandscape) {
                    i3 = -90;
                } else {
                    i3 = 0;
                }
                g gVar = new g(i3);
                this.S = gVar;
                DecodeConfig decodeConfig2 = this.f312524f;
                int i16 = decodeConfig2.width;
                int i17 = decodeConfig2.height;
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar4 = this.f312525h;
                gVar.e(i16, i17, cVar4.f312559d, cVar4.f312560e);
                g gVar2 = this.S;
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar5 = this.f312525h;
                gVar2.d(cVar5.f312559d, cVar5.f312560e);
            }
            if (com.tencent.mobileqq.filter.a.b(this.f312525h.f312564i) || this.f312525h.f312567l != null) {
                this.T = new d();
                if (com.tencent.mobileqq.filter.a.b(this.f312525h.f312564i)) {
                    this.T.a(com.tencent.mobileqq.filter.a.a(this.f312525h.f312564i));
                }
                if (this.f312525h.f312567l != null) {
                    try {
                        GPUBaseFilter a16 = com.tencent.mobileqq.filter.a.a(106);
                        ((com.tencent.mobileqq.filter.c) a16).d(this.f312525h.f312567l);
                        this.T.a(a16);
                    } catch (Exception e16) {
                        QLog.e("Mp4ReEncoder", 1, "mosaic filter create error, ", e16);
                    }
                }
                d dVar = this.T;
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar6 = this.f312525h;
                dVar.onOutputSizeChanged(cVar6.f312559d, cVar6.f312560e);
                this.T.init();
            }
            String str = this.f312525h.f312566k;
            if (str != null) {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    if (this.f312524f.isLocal) {
                        if (this.f312525h.f312576u && decodeFile.getWidth() > decodeFile.getHeight()) {
                            decodeFile = d(decodeFile, 90.0f);
                        }
                    } else {
                        decodeFile = d(decodeFile, 360 - r3.adjustRotation);
                    }
                    this.N = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, decodeFile);
                    this.P = decodeFile.getWidth();
                    this.Q = decodeFile.getHeight();
                    decodeFile.recycle();
                    GPUAlphaBlendFilter gPUAlphaBlendFilter = new GPUAlphaBlendFilter();
                    this.U = gPUAlphaBlendFilter;
                    com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar7 = this.f312525h;
                    gPUAlphaBlendFilter.onOutputSizeChanged(cVar7.f312559d, cVar7.f312560e);
                    this.U.init();
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Mp4ReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.f312525h.f312566k, e17);
                    }
                    onEncodeError(1, e17);
                    return;
                }
            }
            QQFilterRenderManager qQFilterRenderManager = new QQFilterRenderManager();
            this.Z = qQFilterRenderManager;
            QQFilterRenderManager.ChainBuilder chainBuilder = qQFilterRenderManager.getChainBuilder();
            chainBuilder.setUseSort(true);
            ArrayList<DynamicStickerData> arrayList = this.f312518a0;
            QQTransferFilter qQTransferFilter = null;
            if (arrayList != null && arrayList.size() > 0) {
                chainBuilder.addFilter(120, null);
            }
            if (this.f312519b0 != null) {
                chainBuilder.addFilter(110, null);
            }
            chainBuilder.commit();
            this.Z.getBusinessOperation().setDynamicStickerParam(this.f312518a0);
            this.Z.getBusinessOperation().setTrackerStickerParam(this.f312519b0);
            QQFilterRenderManager qQFilterRenderManager2 = this.Z;
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar8 = this.f312525h;
            int i18 = cVar8.f312559d;
            int i19 = cVar8.f312560e;
            qQFilterRenderManager2.surfaceCreate(i18, i19, i18, i19);
            InterfaceC8954a interfaceC8954a = this.f312527m;
            if (interfaceC8954a != null) {
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar9 = this.f312525h;
                int i26 = cVar9.f312559d;
                int i27 = cVar9.f312560e;
                interfaceC8954a.b(i26, i27, i26, i27);
            }
            this.Z.getBusinessOperation().setVideoStartTime(this.f312524f.startTimeMillSecond);
            if (this.f312520c0 != null) {
                if (!this.Z.hasQQFilter(160)) {
                    this.Z.pushChainBasedStackTopChain(160, null);
                    qQTransferFilter = (QQTransferFilter) this.Z.getQQFilterByType(160);
                }
                if (qQTransferFilter == null && (qQFilters = this.Z.getQQFilters(160)) != null && qQFilters.size() > 0 && (qQFilters.get(0) instanceof QQTransferFilter)) {
                    qQTransferFilter = (QQTransferFilter) qQFilters.get(0);
                }
                if (qQTransferFilter != null) {
                    qQTransferFilter.setTransferData(this.f312520c0);
                    qQTransferFilter.setSpeedRate(HWVideoDecoder.getSpeedRate(this.f312524f.speedType));
                }
            }
            this.f312523e.startDecode(this.f312524f, this.M, this, this);
            c cVar10 = this.f312526i;
            if (cVar10 != null) {
                cVar10.onEncodeStart();
            }
        } catch (Exception e18) {
            onEncodeError(4, e18);
            QLog.e("Mp4ReEncoder", 1, "onEncodeStart ex=" + e18);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b0, code lost:
    
        if ((r13.H - r7) < 16666666) goto L82;
     */
    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceTexture);
            return;
        }
        while (this.H >= this.F && !this.Y) {
            if (QLog.isColorLevel()) {
                QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.H + ", mLastDecodeTimestamp " + this.F + ", mLastDecodeSampleTimestamp :" + this.G);
            }
            synchronized (this.D) {
                try {
                    this.D.wait(5L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Mp4ReEncoder", 4, "onFrameAvailable wait");
        }
        synchronized (this.C) {
            if (!this.X && this.J == 0 && !this.Y) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Mp4ReEncoder", 4, "onFrameAvailable start");
                }
                if (this.E) {
                    onEncodeError(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
                }
                try {
                    surfaceTexture.updateTexImage();
                    this.H = this.F;
                    if (QLog.isColorLevel()) {
                        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.H);
                    }
                    float[] fArr = new float[16];
                    surfaceTexture.getTransformMatrix(fArr);
                    RenderBuffer renderBuffer = this.V;
                    renderBuffer.recoverInitialTexId();
                    float[] fArr2 = new float[16];
                    android.opengl.Matrix.setIdentityM(fArr2, 0);
                    android.opengl.Matrix.rotateM(fArr2, 0, this.f312525h.f312569n, 0.0f, 0.0f, 1.0f);
                    android.opengl.Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
                    this.V.bind();
                    this.R.drawTexture(this.M, fArr, fArr2);
                    this.V.unbind();
                    if (this.S != null) {
                        renderBuffer.bind();
                        int c16 = this.S.c(renderBuffer.getTexId());
                        if (c16 != -1) {
                            renderBuffer.setTexId(c16);
                        }
                        renderBuffer.unbind();
                    }
                    if (this.f312527m != null) {
                        renderBuffer.bind();
                        int a16 = this.f312527m.a(renderBuffer.getTexId(), this.H);
                        if (a16 != -1) {
                            renderBuffer.setTexId(a16);
                        }
                        renderBuffer.unbind();
                    }
                    if (this.T != null) {
                        renderBuffer.bind();
                        this.T.drawTexture(renderBuffer.getTexId(), null, null);
                        renderBuffer = this.T.c();
                        renderBuffer.unbind();
                    }
                    renderBuffer.bind();
                    if (this.U != null) {
                        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.f312525h;
                        this.U.drawTexture(this.N, null, GPUBaseFilter.caculateCenterCropMvpMatrix(cVar.f312559d, cVar.f312560e, this.P, this.Q));
                    }
                    renderBuffer.unbind();
                    long j3 = this.H;
                    if (!this.L) {
                        this.L = true;
                        if (j3 > 0) {
                            j3 = 0;
                        }
                    }
                    this.Z.getBusinessOperation().SetTimeStamp(j3, this.G);
                    renderBuffer.setTexId(this.Z.drawFrame(renderBuffer.getTexId()));
                    if (this.f312522d0) {
                        long j16 = this.I;
                        if (j16 != -1) {
                        }
                    }
                    float[] fArr3 = new float[16];
                    android.opengl.Matrix.setIdentityM(fArr3, 0);
                    android.opengl.Matrix.scaleM(fArr3, 0, 1.0f, -1.0f, 1.0f);
                    this.I = this.H;
                    this.f312521d.h(GLSLRender.GL_TEXTURE_2D, renderBuffer.getTexId(), null, fArr3, this.H);
                    for (int i3 = 1; i3 <= this.K; i3++) {
                        this.f312521d.h(GLSLRender.GL_TEXTURE_2D, renderBuffer.getTexId(), null, fArr3, this.H + (i3 * 5 * 1000));
                    }
                    renderBuffer.recoverInitialTexId();
                    this.E = true;
                    this.C.notifyAll();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Mp4ReEncoder", 4, "onFrameAvailable end");
                    }
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    this.E = true;
                    this.C.notifyAll();
                    QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.J + " ; canceled=" + this.X);
                    return;
                }
            }
            this.E = true;
            this.C.notifyAll();
            QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.J + "; canceled=" + this.X + "; stopped=" + this.Y);
        }
    }
}
