package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.utils.ax;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GLVideoView extends com.tencent.av.opengl.ui.b {
    protected int A0;
    protected com.tencent.av.opengl.texture.b B0;
    protected com.tencent.av.opengl.texture.b C0;
    protected int D0;
    protected int E0;
    protected int F0;
    protected int G0;
    protected com.tencent.av.opengl.texture.a H0;
    private final String I;
    private long I0;
    protected Context J;
    private long J0;
    protected WeakReference<Context> K;
    private boolean K0;
    private ov.e L;
    int L0;
    protected YUVTexture M;
    int M0;
    protected com.tencent.av.opengl.texture.a N;
    int N0;
    protected rv.d O;
    b O0;
    protected com.tencent.av.opengl.texture.a P;
    protected boolean P0;
    private int Q;
    protected boolean Q0;
    protected boolean R;
    protected boolean R0;
    protected boolean S;
    int S0;
    protected int T;
    Runnable T0;
    protected int U;
    boolean U0;
    protected boolean V;
    int V0;
    private boolean W;
    private ImageView.ScaleType X;
    private float Y;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private final float[] f74823a0;

    /* renamed from: b0, reason: collision with root package name */
    private Matrix f74824b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Matrix f74825c0;

    /* renamed from: d0, reason: collision with root package name */
    protected RectF f74826d0;

    /* renamed from: e0, reason: collision with root package name */
    protected RectF f74827e0;

    /* renamed from: f0, reason: collision with root package name */
    protected RectF f74828f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f74829g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f74830h0;

    /* renamed from: i0, reason: collision with root package name */
    protected long f74831i0;

    /* renamed from: j0, reason: collision with root package name */
    protected long f74832j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f74833k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f74834l0;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f74835m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f74836n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f74837o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f74838p0;

    /* renamed from: q0, reason: collision with root package name */
    protected String f74839q0;

    /* renamed from: r0, reason: collision with root package name */
    protected float f74840r0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f74841s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f74842t0;

    /* renamed from: u0, reason: collision with root package name */
    protected String f74843u0;

    /* renamed from: v0, reason: collision with root package name */
    long f74844v0;

    /* renamed from: w0, reason: collision with root package name */
    protected com.tencent.av.opengl.texture.b f74845w0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f74846x0;

    /* renamed from: y0, reason: collision with root package name */
    protected int f74847y0;

    /* renamed from: z0, reason: collision with root package name */
    protected rv.a f74848z0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements GLRenderListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f74851a;

        a(VideoAppInterface videoAppInterface) {
            this.f74851a = videoAppInterface;
        }

        @Override // com.tencent.avcore.jni.render.GLRenderListener
        public void onFaceFeatureUpdate(byte[] bArr) {
            if (this.f74851a != null) {
                this.f74851a.k0(new Object[]{130, GLVideoView.this.G0(), bArr});
            }
        }

        @Override // com.tencent.avcore.jni.render.GLRenderListener
        public void onRenderFlush() {
            GLVideoView.super.p();
        }

        @Override // com.tencent.avcore.jni.render.GLRenderListener
        public void onRenderFrame() {
            GLVideoView.super.p();
        }

        @Override // com.tencent.avcore.jni.render.GLRenderListener
        public void onRenderInfoNotify(int i3, int i16, int i17, int i18) {
            VideoAppInterface videoAppInterface;
            int i06 = GLVideoView.i0(i18);
            boolean Y0 = com.tencent.av.r.h0().Y0();
            if (QLog.isColorLevel()) {
                QLog.w(GLVideoView.this.I, 1, "onRenderInfoNotify, width[" + GLVideoView.this.M0 + "->" + i3 + "], height[" + GLVideoView.this.N0 + "->" + i16 + "], angle[" + GLVideoView.this.L0 + "->" + i17 + "], rotation[" + GLVideoView.this.Q + "->" + i06 + "], srcR[" + i18 + "], isLocalView[" + GLVideoView.this.M0() + "], mIsSmallScreen[" + GLVideoView.this.U0 + "], isGameMode[" + Y0 + "]");
            }
            if (!GLVideoView.this.M0() && (videoAppInterface = this.f74851a) != null) {
                videoAppInterface.k0(new Object[]{10004, Integer.valueOf(i3), Integer.valueOf(i16)});
            }
            GLVideoView gLVideoView = GLVideoView.this;
            gLVideoView.M0 = i3;
            gLVideoView.N0 = i16;
            gLVideoView.L0 = i17;
            gLVideoView.T = i06;
            if (i18 != -1) {
                gLVideoView.Q = i06;
            }
            if (Y0) {
                GLVideoView.this.Q = 0;
            }
            GLVideoView.super.p();
        }

        @Override // com.tencent.avcore.jni.render.GLRenderListener
        public void onRenderReset() {
            GLVideoView.super.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: o, reason: collision with root package name */
        int f74867o;

        /* renamed from: p, reason: collision with root package name */
        int f74868p;

        /* renamed from: a, reason: collision with root package name */
        boolean f74853a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f74854b = false;

        /* renamed from: c, reason: collision with root package name */
        boolean f74855c = false;

        /* renamed from: d, reason: collision with root package name */
        boolean f74856d = false;

        /* renamed from: e, reason: collision with root package name */
        int f74857e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f74858f = 0;

        /* renamed from: g, reason: collision with root package name */
        int f74859g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f74860h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f74861i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f74862j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f74863k = 0;

        /* renamed from: l, reason: collision with root package name */
        int f74864l = 0;

        /* renamed from: m, reason: collision with root package name */
        int f74865m = 0;

        /* renamed from: n, reason: collision with root package name */
        int f74866n = 0;

        /* renamed from: q, reason: collision with root package name */
        int f74869q = 0;

        /* renamed from: r, reason: collision with root package name */
        int f74870r = 0;

        /* renamed from: s, reason: collision with root package name */
        int f74871s = 0;

        b() {
        }

        void a(String str, boolean z16, boolean z17, boolean z18, boolean z19, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, float f16, float f17, int i37, int i38, int i39, int i46, int i47) {
            int i48;
            if (QLog.isColorLevel()) {
                if (this.f74855c == z18 && this.f74856d == z19 && this.f74853a == z16 && this.f74854b == z17 && this.f74857e == i3 && this.f74858f == i16 && this.f74859g == i17 && this.f74860h == i18 && this.f74861i == i19 && this.f74862j == i26 && this.f74863k == i27 && this.f74864l == i28 && this.f74865m == i29 && this.f74866n == i36 && this.f74867o == i37 && this.f74868p == i38 && this.f74869q == i39) {
                    i48 = i46;
                    if (this.f74870r == i48) {
                        return;
                    }
                } else {
                    i48 = i46;
                }
                this.f74853a = z16;
                this.f74854b = z17;
                this.f74855c = z18;
                this.f74856d = z19;
                this.f74857e = i3;
                this.f74858f = i16;
                this.f74859g = i17;
                this.f74860h = i18;
                this.f74861i = i19;
                this.f74862j = i26;
                this.f74863k = i27;
                this.f74864l = i28;
                this.f74865m = i29;
                this.f74866n = i36;
                this.f74867o = i37;
                this.f74868p = i38;
                this.f74869q = i39;
                this.f74870r = i48;
                this.f74871s = i47;
                QLog.w(str, 1, "rendView, self[" + z16 + "], mirror[" + z17 + "], bForceGround[" + z18 + "], pt[" + i3 + ", " + i16 + "], dst[" + i17 + ", " + i18 + "], src[" + i19 + ", " + i26 + "], t1[" + i27 + ", " + i28 + "], t2[" + i29 + ", " + i36 + "], sR[" + f16 + "], tR[" + f17 + "], border[" + z19 + "], sAngle[" + i37 + "], yuvAngle[" + i38 + "], mRotation[" + i39 + "], rotation[" + i48 + "], scaleType[" + i47 + "]");
            }
        }
    }

    public GLVideoView(Context context, VideoAppInterface videoAppInterface, String str, long j3) {
        this(context, videoAppInterface, str, j3, true);
    }

    private void B1(float f16, boolean z16) {
        if (this.M != null) {
            boolean O0 = O0();
            YUVTexture yUVTexture = this.M;
            if (O0) {
                f16 = 0.0f;
            }
            yUVTexture.Y(f16);
            this.M.Z(z16);
        }
    }

    private void D1() {
        com.tencent.av.opengl.texture.a aVar = this.f74133p;
        if (aVar instanceof com.tencent.av.opengl.texture.b) {
            ((com.tencent.av.opengl.texture.b) aVar).L(this.K0);
        }
    }

    private boolean N0() {
        com.tencent.av.opengl.texture.a aVar = this.f74133p;
        if ((aVar instanceof com.tencent.av.opengl.texture.b) && ((com.tencent.av.opengl.texture.b) aVar).M()) {
            return true;
        }
        return false;
    }

    private boolean O0() {
        if (H0() == 2) {
            return true;
        }
        return false;
    }

    private boolean Q0() {
        if (!this.f74835m0 && !this.U0 && !this.f74836n0) {
            return true;
        }
        return false;
    }

    private boolean S0() {
        if (this.U0 && com.tencent.av.utils.j.b() && com.tencent.av.utils.j.c()) {
            return true;
        }
        return false;
    }

    public static int[] Z(byte[] bArr, int i3, int i16) {
        boolean z16;
        boolean z17;
        int i17;
        int i18 = i3;
        int i19 = i16;
        int[] iArr = null;
        if (bArr == null) {
            QLog.d("GLVideoView", 1, "I420toARGB is null nWidth=" + i18 + ", nHeight=" + i19);
            return null;
        }
        if (i19 < 0) {
            i19 = -i19;
            z16 = true;
        } else {
            z16 = false;
        }
        if (i18 < 0) {
            i18 = -i18;
            z17 = true;
        } else {
            z17 = false;
        }
        int i26 = i18 * i19;
        try {
            iArr = new int[i26];
            int i27 = 0;
            while (i27 < i26) {
                int i28 = i27 / i18;
                int i29 = i27 % i18;
                int i36 = ((i28 / 2) * (i18 / 2)) + (i29 / 2);
                int i37 = bArr[i27] & 255;
                int i38 = bArr[i26 + i36] & 255;
                int i39 = bArr[(i26 / 4) + i26 + i36] & 255;
                double d16 = i37;
                double d17 = i38 - 128;
                int i46 = i26;
                int i47 = i27;
                int i48 = (int) (d16 + (1.8556d * d17));
                double d18 = i39 - 128;
                int i49 = (int) (d16 - ((0.4681d * d18) + (d17 * 0.1872d)));
                int i56 = (int) (d16 + (d18 * 1.5748d));
                if (i48 > 255) {
                    i48 = 255;
                } else if (i48 < 0) {
                    i48 = 0;
                }
                if (i49 > 255) {
                    i49 = 255;
                } else if (i49 < 0) {
                    i49 = 0;
                }
                if (i56 > 255) {
                    i56 = 255;
                } else if (i56 < 0) {
                    i56 = 0;
                }
                if (z16) {
                    i17 = (((i19 - 1) - i28) * i18) + i29;
                } else {
                    i17 = i47;
                }
                if (z17) {
                    i17 = (((i17 / i18) * i18) + (i18 - 1)) - (i17 % i18);
                }
                iArr[i17] = ((i56 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | (-16777216) | ((i49 << 8) & 65280) | (i48 & 255);
                i27 = i47 + 1;
                i26 = i46;
            }
        } catch (OutOfMemoryError unused) {
        }
        return iArr;
    }

    private boolean g0() {
        boolean z16;
        if (this.f74838p0) {
            return true;
        }
        if (this.O == null || TextUtils.isEmpty(this.f74839q0)) {
            return false;
        }
        boolean N = this.O.N();
        if (!this.f74835m0 && !this.U0 && !this.f74836n0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (N != z16) {
            return true;
        }
        return false;
    }

    static int i0(int i3) {
        int i16 = i3 % 360;
        if (i16 != 90) {
            if (i16 != 180) {
                if (i16 != 270) {
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        return 3;
    }

    private void j0(int i3) {
        AVActivity aVActivity;
        int i16;
        long j3;
        WeakReference<Context> weakReference = this.K;
        if (weakReference != null && weakReference.get() != null) {
            if (this.K.get() != null && (this.K.get() instanceof AVActivity)) {
                aVActivity = (AVActivity) this.K.get();
            } else {
                aVActivity = null;
            }
            if (aVActivity != null && aVActivity.I0 != null && aVActivity.v3()) {
                final StringBuilder sb5 = new StringBuilder();
                final String G0 = G0();
                try {
                    sb5.append(i3);
                    sb5.append(';');
                    int networkType = NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication());
                    if (networkType == 1) {
                        i16 = 1;
                    } else if (networkType == 0) {
                        i16 = 0;
                    } else {
                        i16 = 2;
                    }
                    sb5.append(i16);
                    sb5.append(';');
                    SessionInfo f16 = com.tencent.av.n.e().f();
                    if (f16.S0 == 1) {
                        j3 = 0;
                    } else {
                        j3 = 1;
                    }
                    sb5.append(j3);
                    sb5.append(';');
                    sb5.append(f16.P0);
                    sb5.append(';');
                    sb5.append(com.tencent.av.r.h0().g0());
                    if (QLog.isColorLevel()) {
                        QLog.d(this.I, 2, "doBlackScreenDataReport questionUin:= " + G0 + ",rommInfo:=" + sb5.toString());
                    }
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.ui.GLVideoView.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ReportController.o(null, "CliOper", "", "", "0X8009FCB", "0X8009FCB", 0, 0, G0, "", sb5.toString(), "");
                        }
                    });
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.I, 2, "doBlackScreenDataReport Exception" + e16.getMessage());
                    }
                }
            }
        }
    }

    static Pair<Integer, Integer> p0(int i3, int i16, int i17, int i18, int i19) {
        if (i19 == 1) {
            i16 = i17 - i3;
            i3 = i16;
        } else if (i19 == 2) {
            i3 = i17 - i3;
            i16 = i18 - i16;
        } else if (i19 == 3) {
            int i26 = i18 - i16;
            i16 = i3;
            i3 = i26;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    private Long u0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.I0 > 10000) {
            this.I0 = currentTimeMillis;
            long j3 = this.J0;
            this.J0 = 0L;
            return new Long(j3);
        }
        this.J0++;
        return null;
    }

    public boolean A0() {
        return this.f74834l0;
    }

    public void A1(int i3, int i16, boolean z16) {
        float centerX;
        float centerX2;
        float f16;
        RectF rectF;
        float f17;
        float centerY;
        float centerY2;
        Pair<Integer, Integer> p06 = p0(i3, i16, 0, 0, this.Q);
        if (QLog.isDebugVersion() && QLog.isColorLevel()) {
            QLog.w(this.I, 1, "setTranslation, isEnd[" + z16 + "], x[" + i3 + "->" + p06.first + "], y[" + i16 + "->" + p06.second + "], mRotation[" + this.Q + "]");
        }
        this.f74825c0.getValues(this.f74823a0);
        float intValue = this.f74823a0[2] + ((Integer) p06.first).intValue();
        float intValue2 = this.f74823a0[5] + ((Integer) p06.second).intValue();
        float[] fArr = this.f74823a0;
        fArr[2] = intValue;
        fArr[5] = intValue2;
        this.f74825c0.setValues(fArr);
        if (z16) {
            RectF rectF2 = new RectF();
            this.f74825c0.mapRect(rectF2, this.f74827e0);
            float f18 = rectF2.left;
            RectF rectF3 = this.f74826d0;
            float f19 = rectF3.left;
            if (f18 < f19 && rectF2.right < rectF3.right) {
                if (rectF2.width() > this.f74826d0.width()) {
                    centerX = this.f74826d0.right;
                    centerX2 = rectF2.right;
                } else {
                    centerX = this.f74826d0.centerX();
                    centerX2 = rectF2.centerX();
                }
            } else if (f18 > f19 && rectF2.right > rectF3.right) {
                if (rectF2.width() > this.f74826d0.width()) {
                    centerX = this.f74826d0.left;
                    centerX2 = rectF2.left;
                } else {
                    centerX = this.f74826d0.centerX();
                    centerX2 = rectF2.centerX();
                }
            } else {
                if (f18 > f19 && rectF2.right < rectF3.right) {
                    centerX = rectF3.centerX();
                    centerX2 = rectF2.centerX();
                }
                f16 = rectF2.top;
                rectF = this.f74826d0;
                f17 = rectF.top;
                if (f16 >= f17 && rectF2.bottom < rectF.bottom) {
                    if (rectF2.height() > this.f74826d0.height()) {
                        centerY = this.f74826d0.bottom;
                        centerY2 = rectF2.bottom;
                    } else {
                        centerY = this.f74826d0.centerY();
                        centerY2 = rectF2.centerY();
                    }
                } else if (f16 <= f17 && rectF2.bottom > rectF.bottom) {
                    if (rectF2.height() > this.f74826d0.height()) {
                        centerY = this.f74826d0.top;
                        centerY2 = rectF2.top;
                    } else {
                        centerY = this.f74826d0.centerY();
                        centerY2 = rectF2.centerY();
                    }
                } else {
                    if (f16 > f17 && rectF2.bottom < rectF.bottom) {
                        centerY = rectF.centerY();
                        centerY2 = rectF2.centerY();
                    }
                    float[] fArr2 = this.f74823a0;
                    fArr2[2] = intValue;
                    fArr2[5] = intValue2;
                    this.f74825c0.setValues(fArr2);
                }
                intValue2 += centerY - centerY2;
                float[] fArr22 = this.f74823a0;
                fArr22[2] = intValue;
                fArr22[5] = intValue2;
                this.f74825c0.setValues(fArr22);
            }
            intValue += centerX - centerX2;
            f16 = rectF2.top;
            rectF = this.f74826d0;
            f17 = rectF.top;
            if (f16 >= f17) {
            }
            if (f16 <= f17) {
            }
            if (f16 > f17) {
                centerY = rectF.centerY();
                centerY2 = rectF2.centerY();
                intValue2 += centerY - centerY2;
            }
            float[] fArr222 = this.f74823a0;
            fArr222[2] = intValue;
            fArr222[5] = intValue2;
            this.f74825c0.setValues(fArr222);
        }
        super.p();
    }

    public float B0() {
        this.f74825c0.getValues(this.f74823a0);
        return this.f74823a0[0];
    }

    public ImageView.ScaleType C0() {
        return this.X;
    }

    public void C1(boolean z16) {
        if (this.f74837o0 != z16) {
            this.f74837o0 = z16;
            super.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void D(ov.a aVar) {
        boolean z16;
        boolean z17;
        com.tencent.av.opengl.texture.a aVar2;
        com.tencent.av.opengl.texture.a aVar3;
        if (!this.f74136s) {
            return;
        }
        YUVTexture yUVTexture = this.M;
        if (yUVTexture != null) {
            z16 = yUVTexture.V();
        } else {
            z16 = false;
        }
        if (!z16 && !this.K0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.W = z17;
        int n3 = super.n();
        int h16 = super.h();
        Rect k3 = super.k();
        int i3 = (n3 - k3.left) - k3.right;
        int i16 = (h16 - k3.top) - k3.bottom;
        aVar.k((-n3) / 2, (-h16) / 2);
        if (this.W) {
            this.L.c(-9013642);
            int i17 = k3.left;
            if (i17 > 0) {
                this.L.d(i17);
                int i18 = k3.left;
                aVar.b(i18 / 2, 0.0f, i18 / 2, h16, this.L);
            }
            int i19 = k3.top;
            if (i19 > 0) {
                this.L.d(i19);
                int i26 = k3.top;
                aVar.b(0.0f, i26 / 2, n3, i26 / 2, this.L);
            }
            int i27 = k3.right;
            if (i27 > 0) {
                this.L.d(i27);
                int i28 = k3.right;
                aVar.b(n3 - (i28 / 2), 0.0f, n3 - (i28 / 2), h16, this.L);
            }
            int i29 = k3.bottom;
            if (i29 > 0) {
                this.L.d(i29);
                int i36 = k3.bottom;
                aVar.b(0.0f, h16 - (i36 / 2), n3, h16 - (i36 / 2), this.L);
            }
        }
        aVar.k(n3 / 2, h16 / 2);
        if (this.W) {
            if ((!K0() || !this.f74834l0) && (aVar3 = this.f74133p) != null) {
                aVar3.z(i3);
                this.f74133p.y(i16);
                this.f74133p.a(aVar, 0, 0, i3, i16);
                return;
            } else {
                if (!this.P0) {
                    float f16 = 0;
                    aVar.l(f16, f16, i3, i16, this.f74135r);
                    return;
                }
                return;
            }
        }
        if ((!K0() || !this.f74834l0) && (aVar2 = this.f74133p) != null) {
            aVar2.z(n3);
            this.f74133p.y(h16);
            this.f74133p.a(aVar, 0, 0, n3, h16);
        } else if (!this.P0) {
            if (!z16 && !this.K0) {
                aVar.l(0.0f, 0.0f, n3, h16, this.f74135r);
            } else if (this.H0 != null && O0()) {
                this.H0.z(n3);
                this.H0.y(h16);
                this.H0.a(aVar, 0, 0, n3, h16);
            }
        }
    }

    public String D0() {
        return this.f74839q0;
    }

    @Override // com.tencent.av.opengl.ui.b
    protected void E(ov.a aVar) {
        if (!this.f74834l0) {
            if (QLog.isDevelopLevel()) {
                QLog.w(this.I, 1, "renderTexture, mNeedRenderVideo is false");
            }
        } else {
            YUVTexture yUVTexture = this.M;
            if (yUVTexture == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(this.I, 1, "renderTexture, mYuvTexture is null");
                }
            } else if (!yUVTexture.d0()) {
                QLog.w(this.I, 1, "renderTexture, updateCurFrame fail");
            } else if (!this.M.C()) {
                QLog.w(this.I, 1, "renderTexture, can not Render");
            } else {
                m0(false);
                if (this.R && this.P0) {
                    V0(aVar);
                } else {
                    a1(aVar);
                }
            }
        }
        if (this.U0 && !this.f74834l0) {
            return;
        }
        X0(aVar);
        W0(aVar);
        Z0(aVar);
        Y0(aVar);
    }

    public int E0() {
        return this.f74841s0;
    }

    public float F0() {
        return this.f74840r0;
    }

    public String G0() {
        return (String) l(0);
    }

    @Override // com.tencent.av.opengl.ui.b
    public void H(Bitmap bitmap) {
        super.H(bitmap);
        D1();
    }

    public int H0() {
        Integer num = (Integer) l(1);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public YUVTexture I0() {
        return this.M;
    }

    @Override // com.tencent.av.opengl.ui.b
    public void J(com.tencent.av.opengl.texture.b bVar) {
        super.J(bVar);
        D1();
    }

    protected boolean J0(int i3) {
        int H0 = H0();
        ImageView.ScaleType scaleType = this.X;
        if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            if (this.R) {
                return true;
            }
            if (i3 % 2 == 0 && !this.R0) {
                return true;
            }
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP && H0 == 2) {
            return true;
        }
        return false;
    }

    public boolean K0() {
        try {
            YUVTexture yUVTexture = this.M;
            if (yUVTexture == null) {
                return false;
            }
            return yUVTexture.C();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public boolean L0() {
        return this.K0;
    }

    public boolean M0() {
        return this.f74843u0.equals(G0());
    }

    @Override // com.tencent.av.opengl.ui.b
    public void P(int i3) {
        int i06 = i0(i3);
        this.U = i3;
        if (this.Q != i06 && !M0()) {
            this.Q = i06;
            this.f74825c0.reset();
            if (m() == 0) {
                super.p();
            }
        }
    }

    public boolean P0() {
        return this.f74837o0;
    }

    @Override // com.tencent.av.opengl.ui.b
    public void R(int i3) {
        super.R(i3);
        if (i3 == 1) {
            this.f74831i0 = 0L;
            this.f74832j0 = 0L;
            this.f74833k0 = 0;
        }
    }

    public boolean R0() {
        return this.f74835m0;
    }

    public void T0(int i3) {
        int i16 = this.A0;
        if (i16 != i3) {
            if (i16 != 2 || i3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.I, 1, "refreshMicState, uin[" + G0() + ", state[" + this.A0 + "->" + i3 + "]");
                }
                this.A0 = i3;
                p();
            }
        }
    }

    public void U0() {
        this.J = null;
        this.L = null;
        try {
            finalize();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    protected void V0(ov.a aVar) {
        int i3;
        int N = this.M.N();
        int M = this.M.M();
        Rect k3 = super.k();
        int n3 = super.n();
        int h16 = super.h();
        this.f74827e0.set((N - (z.m(M) / 2)) / 2, 0, r3 + r1, M + 0);
        this.f74828f0.set(0.0f, k3.top, n3 - k3.right, h16 - k3.bottom);
        YUVTexture yUVTexture = this.M;
        RectF rectF = this.f74827e0;
        yUVTexture.v((int) rectF.left, (int) rectF.top, (int) rectF.width(), (int) this.f74827e0.height());
        this.M.x(N, M);
        this.M.z((int) this.f74828f0.width());
        this.M.y((int) this.f74828f0.height());
        aVar.f(2);
        if (this.P0) {
            i3 = 0;
        } else {
            i3 = this.Q;
        }
        l0(aVar, i3, 0);
        YUVTexture yUVTexture2 = this.M;
        RectF rectF2 = this.f74828f0;
        yUVTexture2.a(aVar, (int) rectF2.left, (int) rectF2.top, (int) rectF2.width(), (int) this.f74828f0.height());
        aVar.restore();
        AVCoreLog.printColorLog(this.I, "renderDoubleScreenOfPC:|" + G0() + "|" + H0() + "|" + N + "|" + M + "|" + n3 + "|" + h16 + "|" + this.f74827e0.toString() + "|" + this.f74828f0.toString());
    }

    protected void W0(ov.a aVar) {
        if (this.f74846x0 && this.f74848z0 != null && !N0()) {
            this.f74848z0.a(aVar, 0, 0, n(), h());
        }
    }

    Bitmap X(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 4, bitmap.getHeight() / 4, true);
            Canvas canvas = new Canvas();
            canvas.setBitmap(createScaledBitmap);
            canvas.drawColor(Color.parseColor("#10ffffff"), PorterDuff.Mode.LIGHTEN);
            eh.a(createScaledBitmap, 20);
            return Bitmap.createScaledBitmap(createScaledBitmap, bitmap.getWidth(), bitmap.getHeight(), true);
        } catch (Exception e16) {
            QLog.d(this.I, 2, "doStartRenderFouceGround BlurBitmap exception e.stack " + e16.getStackTrace());
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.d(this.I, 2, "doStartRenderFouceGround BlurBitmap OOM exception e.stack " + e17.getStackTrace());
            return null;
        }
    }

    protected void X0(ov.a aVar) {
        int i3;
        int i16;
        int i17;
        if (this.f74830h0 && this.N != null) {
            this.f74829g0 %= 360;
            int n3 = super.n();
            int h16 = super.h();
            int f16 = this.N.f();
            int e16 = this.N.e();
            if (f16 > n3) {
                i3 = n3;
            } else {
                i3 = f16;
            }
            if (e16 > h16) {
                i16 = h16;
            } else {
                i16 = e16;
            }
            aVar.f(2);
            this.N.a(aVar, 0, 0, i3, i16);
            aVar.restore();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f74831i0 >= 80) {
                this.f74831i0 = currentTimeMillis;
                this.f74829g0 += 8;
            }
            long j3 = this.f74832j0;
            if (j3 == 0) {
                this.f74832j0 = currentTimeMillis;
                this.f74833k0 = 0;
            } else if (currentTimeMillis - j3 >= 5000 && (i17 = this.f74833k0) < 2) {
                this.f74832j0 = currentTimeMillis;
                j0(i17);
                this.f74833k0++;
            }
        }
    }

    public long Y() {
        if (M0() && H0() == 2) {
            return System.currentTimeMillis();
        }
        return this.f74844v0;
    }

    protected void Y0(ov.a aVar) {
        com.tencent.av.opengl.texture.b bVar;
        int f16;
        int L;
        int abs;
        if (this.f74837o0 && this.O != null) {
            int i3 = this.A0;
            if (i3 == 2) {
                bVar = this.C0;
            } else if (i3 == 1) {
                bVar = this.B0;
            } else {
                bVar = null;
            }
            com.tencent.av.opengl.texture.b bVar2 = bVar;
            if (bVar2 != null) {
                int n3 = super.n();
                int h16 = super.h();
                int f17 = bVar2.f();
                int e16 = bVar2.e();
                if (this.f74835m0) {
                    f16 = (n3 - f17) - this.D0;
                    L = (((h16 - this.O.M()) - this.D0) + this.O.L()) - e16;
                    abs = (e16 - this.O.L()) / 2;
                } else {
                    f16 = BaseAIOUtils.f(16.0f, this.J.getResources()) + this.O.f() + this.E0;
                    L = (this.S0 + this.O.L()) - e16;
                    abs = Math.abs((e16 - this.O.L()) / 2);
                }
                int i16 = L + abs;
                int f18 = BaseAIOUtils.f(1.5f, this.J.getResources());
                aVar.f(3);
                aVar.k((f17 - n3) / 2, (e16 - h16) / 2);
                bVar2.a(aVar, f16, i16 + f18, f17, e16);
                aVar.restore();
            }
        }
    }

    protected void Z0(ov.a aVar) {
        int f16;
        int i3;
        int i16;
        int i17;
        if (this.f74837o0) {
            Rect k3 = super.k();
            if (this.P != null) {
                int n3 = super.n();
                super.h();
                this.P.a(aVar, 0, 0, (n3 - k3.left) - k3.right, 36);
            }
            if (g0()) {
                if (this.O == null) {
                    this.O = new rv.d();
                }
                this.O.t();
                this.O.S(this.f74839q0);
                this.O.U(this.f74840r0);
                this.O.T(this.f74841s0);
                this.O.Q(this.f74842t0);
                if (this.f74835m0) {
                    this.O.R(((super.n() - this.F0) - this.D0) - BaseAIOUtils.f(20.0f, this.J.getResources()));
                } else {
                    this.O.R(((super.n() - this.F0) - this.E0) - this.G0);
                }
                this.O.P(Q0());
                this.O.O();
                this.f74838p0 = false;
            }
            if (this.O != null && !TextUtils.isEmpty(this.f74839q0)) {
                int n16 = super.n();
                int h16 = super.h();
                int f17 = this.O.f();
                int e16 = this.O.e();
                if (this.f74835m0) {
                    f16 = this.E0;
                    i3 = (h16 - this.O.M()) - this.D0;
                } else {
                    if (this.U0) {
                        i16 = this.V0;
                        i17 = i16;
                        this.O.P(Q0());
                        aVar.f(2);
                        aVar.k((f17 - n16) / 2, (e16 - h16) / 2);
                        this.O.a(aVar, i16, i17, f17, e16);
                        aVar.restore();
                    }
                    if (this.f74836n0) {
                        f16 = (n16 - f17) / 2;
                        i3 = (h16 - e16) / 2;
                    } else {
                        f16 = BaseAIOUtils.f(16.0f, this.J.getResources());
                        i3 = this.S0;
                    }
                }
                i16 = f16;
                i17 = i3;
                this.O.P(Q0());
                aVar.f(2);
                aVar.k((f17 - n16) / 2, (e16 - h16) / 2);
                this.O.a(aVar, i16, i17, f17, e16);
                aVar.restore();
            }
        }
    }

    public boolean a0() {
        return this.R;
    }

    protected void a1(ov.a aVar) {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        boolean z18;
        int i17;
        int i18;
        int i19;
        float f16;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z19;
        boolean z26;
        boolean z27;
        long j3;
        float f17;
        float f18;
        if (this.f74832j0 != 0) {
            this.f74832j0 = 0L;
            this.f74833k0 = 0;
        }
        Long u06 = u0();
        if (u06 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Rect k3 = super.k();
        this.f74844v0 = System.currentTimeMillis();
        int n3 = super.n();
        int h16 = super.h();
        int i36 = (n3 - k3.left) - k3.right;
        int i37 = (h16 - k3.top) - k3.bottom;
        boolean M0 = M0();
        int L = this.M.L();
        if (((!this.P0 && !S0()) || M0) && !this.Q0) {
            i3 = this.Q;
        } else {
            i3 = 0;
        }
        int i38 = ((L + i3) + 4) % 4;
        float f19 = k3.left;
        float f26 = k3.top;
        float f27 = i36;
        float f28 = i37;
        int i39 = i38 % 2;
        if (i39 != 0) {
            f19 = f26;
            f26 = f19;
            i37 = (int) f27;
            i36 = i37;
            f28 = f27;
            f27 = f28;
        }
        this.f74826d0.set(f19, f26, i36 + f19, i37 + f26);
        float N = this.M.N();
        float M = this.M.M();
        float f29 = N / M;
        float f36 = f27 / f28;
        if (!this.P0 && J0(i38) && !this.Q0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (i39 == 0) {
                f18 = f27 / f29;
                if (f18 > f28) {
                    f17 = f28 * f29;
                    f19 += (f27 - f17) / 2.0f;
                    f27 = f17;
                }
                f26 += (f28 - f18) / 2.0f;
                f28 = f18;
            } else {
                f17 = f28 * f29;
                if (f17 > f27) {
                    f18 = f27 / f29;
                    f26 += (f28 - f18) / 2.0f;
                    f28 = f18;
                }
                f19 += (f27 - f17) / 2.0f;
                f27 = f17;
            }
            f36 = f27 / f28;
        }
        float f37 = f36;
        this.f74827e0.set(f19, f26, f27 + f19, f28 + f26);
        this.f74825c0.mapRect(this.f74828f0, this.f74827e0);
        if (f29 > f37) {
            float f38 = M * f37;
            this.M.v((int) ((N - f38) / 2.0f), 0, (int) f38, (int) M);
        } else {
            float f39 = N / f37;
            this.M.v(0, (int) ((M - f39) / 2.0f), (int) N, (int) f39);
        }
        int i46 = (int) N;
        int i47 = (int) M;
        this.M.x(i46, i47);
        aVar.f(2);
        if (M0()) {
            i16 = this.M.E();
        } else {
            i16 = 0;
        }
        l0(aVar, i3, i16);
        aVar.p(i38 * 90, 0.0f, 0.0f, 1.0f);
        YUVTexture yUVTexture = this.M;
        if (i39 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        yUVTexture.c0(z18);
        this.M.z((int) this.f74828f0.width());
        this.M.y((int) this.f74828f0.height());
        float width = this.f74828f0.left - ((this.f74827e0.width() - this.f74828f0.width()) / 2.0f);
        RectF rectF = this.f74827e0;
        int i48 = (int) (width - rectF.left);
        int height = (int) ((this.f74828f0.top - ((rectF.height() - this.f74828f0.height()) / 2.0f)) - this.f74827e0.top);
        com.tencent.av.opengl.texture.b bVar = this.f74845w0;
        if (bVar != null) {
            i17 = height;
            f16 = M;
            i19 = i47;
            i26 = i38;
            i18 = i46;
            i27 = i3;
            i28 = h16;
            i29 = L;
            bVar.a(aVar, i48, i17, (int) this.f74828f0.width(), (int) this.f74828f0.height());
        } else {
            i17 = height;
            i18 = i46;
            i19 = i47;
            f16 = M;
            i26 = i38;
            i27 = i3;
            i28 = h16;
            i29 = L;
            this.M.a(aVar, i48, i17, (int) this.f74828f0.width(), (int) this.f74828f0.height());
        }
        if ((this.R && this.S) || z16) {
            z19 = false;
            this.S = false;
            String str = this.I;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FrameInfo:=<ImgWidth:=");
            sb5.append(N);
            sb5.append(",ImgHeight:=");
            sb5.append(f16);
            sb5.append(",YUVImgAngle:=");
            sb5.append(i29);
            sb5.append(",drawUin:=");
            sb5.append(G0());
            sb5.append(",mIsFillBlackEdge:=");
            sb5.append(this.R);
            sb5.append(",drawCounts:=");
            if (z16) {
                j3 = u06.longValue();
            } else {
                j3 = 0;
            }
            sb5.append(j3);
            sb5.append(",mAVSDKNotifyRotationType:=");
            sb5.append(this.T);
            sb5.append(",phoneRotateAngle:=");
            sb5.append(this.U);
            sb5.append(",renderRotation:=");
            sb5.append(i26);
            sb5.append(",selfAngle:=");
            sb5.append(i27);
            sb5.append(",mDstRectF.width():=");
            sb5.append(this.f74828f0.width());
            sb5.append(",mDstRectF.height():=");
            sb5.append(this.f74828f0.height());
            sb5.append(",uiWidth:=");
            sb5.append(n3);
            sb5.append(",uiHeight:=");
            sb5.append(i28);
            sb5.append(">");
            z26 = true;
            QLog.d(str, 1, sb5.toString());
        } else {
            z19 = false;
            z26 = true;
        }
        if (QLog.isColorLevel()) {
            if (this.O0 == null) {
                this.O0 = new b();
            }
            b bVar2 = this.O0;
            String str2 = this.I;
            boolean z28 = this.V;
            if (this.f74845w0 != null) {
                z27 = z26;
            } else {
                z27 = z19;
            }
            bVar2.a(str2, M0, z28, z27, z17, i48, i17, (int) this.f74828f0.width(), (int) this.f74828f0.width(), (int) this.f74827e0.width(), (int) this.f74827e0.width(), i18, i19, this.M.f(), this.M.e(), f29, f37, i27, i29, this.Q, i26, this.X.ordinal());
        }
        aVar.restore();
    }

    public void b1(Context context) {
        this.K = new WeakReference<>(context);
    }

    public void c1(boolean z16) {
        if (this.M != null) {
            if (QLog.isColorLevel()) {
                QLog.w(this.I, 1, "setCameraIsBindData, uin[" + G0() + "], VideoSrcType[" + H0() + "], isBind[" + z16 + "]");
            }
            this.M.b0(z16);
        }
    }

    public void d1(int i3) {
        if (this.f74847y0 != i3) {
            this.f74848z0 = new rv.a(i3);
        }
    }

    public void e1(Boolean bool) {
        this.W = bool.booleanValue();
    }

    public void f1(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        com.tencent.av.opengl.texture.b bVar = this.f74845w0;
        if (bVar != null) {
            bVar.t();
            this.f74845w0 = null;
        }
        this.f74845w0 = new com.tencent.av.opengl.texture.b(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void finalize() throws Throwable {
        try {
            com.tencent.av.opengl.texture.a aVar = this.P;
            if (aVar != null) {
                aVar.t();
                this.P = null;
            }
            rv.d dVar = this.O;
            if (dVar != null) {
                dVar.t();
                this.O = null;
            }
            com.tencent.av.opengl.texture.a aVar2 = this.N;
            if (aVar2 != null) {
                aVar2.t();
                this.N = null;
            }
            YUVTexture yUVTexture = this.M;
            if (yUVTexture != null) {
                yUVTexture.t();
                this.M = null;
            }
            com.tencent.av.opengl.texture.b bVar = this.f74845w0;
            if (bVar != null) {
                bVar.t();
                this.f74845w0 = null;
            }
            this.f74848z0 = null;
            com.tencent.av.opengl.texture.b bVar2 = this.B0;
            if (bVar2 != null) {
                bVar2.t();
                this.B0 = null;
            }
            com.tencent.av.opengl.texture.b bVar3 = this.C0;
            if (bVar3 != null) {
                bVar3.t();
                this.C0 = null;
            }
            com.tencent.av.opengl.texture.a aVar3 = this.H0;
            if (aVar3 != null) {
                aVar3.t();
                this.H0 = null;
            }
            this.T0 = null;
            this.f74830h0 = false;
            this.f74837o0 = false;
            this.f74839q0 = null;
        } finally {
            super.finalize();
        }
    }

    public void g1(boolean z16) {
        if (this.f74846x0 != z16) {
            this.f74846x0 = z16;
        }
        com.tencent.av.opengl.texture.a aVar = this.f74133p;
        if (aVar instanceof com.tencent.av.opengl.texture.b) {
            ((com.tencent.av.opengl.texture.b) aVar).O(z16);
        }
    }

    public void h0() {
        com.tencent.av.opengl.texture.b bVar = this.f74845w0;
        if (bVar != null) {
            bVar.t();
            this.f74845w0 = null;
        }
    }

    public void h1(String str, int i3) {
        Q(0, str);
        Q(1, Integer.valueOf(i3));
    }

    public void i1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.w(this.I, 1, "setIsPC, isPC[" + this.R + "->" + z16 + "]");
        }
        this.R = z16;
        if (z16) {
            this.S = true;
        }
        this.f74825c0.reset();
        super.p();
    }

    public void j1(boolean z16) {
        this.U0 = z16;
        if (z16) {
            this.V0 = this.J.getResources().getDimensionPixelSize(R.dimen.a9g);
        }
    }

    public boolean k0() {
        Bitmap v06;
        try {
            if (this.f74845w0 != null || (v06 = v0()) == null) {
                return false;
            }
            Bitmap X = X(v06);
            if (X == null) {
                QLog.d(this.I, 2, "doStartRenderFouceGround BlurBitmap failed");
                return false;
            }
            f1(X);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(this.I, 2, "doStartRenderFouceGround exception e.stack " + e16.getStackTrace());
            }
            return false;
        }
    }

    public void k1(int i3) {
        if (i3 > 0 && this.f74842t0 != i3) {
            this.f74842t0 = i3;
            this.f74838p0 = true;
            super.p();
            if (QLog.isDevelopLevel()) {
                QLog.d(this.I, 2, "setMaxLength maxLength: " + i3);
            }
        }
    }

    protected void l0(ov.a aVar, int i3, int i16) {
        boolean z16;
        if (i16 != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.V) {
            if (i3 % 2 == 0) {
                aVar.m(-1.0f, 1.0f, 1.0f);
            } else {
                aVar.m(1.0f, -1.0f, 1.0f);
            }
        }
    }

    public void l1(int i3, int i16) {
        com.tencent.av.opengl.texture.b bVar = this.C0;
        if (bVar != null) {
            bVar.t();
            this.C0 = null;
        }
        com.tencent.av.opengl.texture.b bVar2 = new com.tencent.av.opengl.texture.b(ba.getBitmapFromResourceId(this.J, i3));
        this.C0 = bVar2;
        bVar2.H(false);
        com.tencent.av.opengl.texture.b bVar3 = this.B0;
        if (bVar3 != null) {
            bVar3.t();
            this.B0 = null;
        }
        com.tencent.av.opengl.texture.b bVar4 = new com.tencent.av.opengl.texture.b(ba.getBitmapFromResourceId(this.J, i16));
        this.B0 = bVar4;
        bVar4.H(false);
    }

    public void m0(boolean z16) {
        if (this.f74830h0 != z16) {
            if (QLog.isColorLevel()) {
                QLog.d(this.I, 2, "enableLoading loading: " + z16 + ", mLoading: " + this.f74830h0);
            }
            this.f74830h0 = z16;
            if (z16) {
                if (this.N == null) {
                    this.N = new rv.c(this.J, R.drawable.dee);
                }
                GLRootView g16 = g();
                if (g16 != null) {
                    g16.post(this.T0);
                    return;
                }
                return;
            }
            GLRootView g17 = g();
            if (g17 != null) {
                g17.removeCallbacks(this.T0);
            }
            this.f74831i0 = 0L;
            this.f74832j0 = 0L;
            this.f74833k0 = 0;
        }
    }

    public void m1(long j3, boolean z16) {
        if (this.V != z16) {
            if (QLog.isColorLevel()) {
                QLog.w(this.I, 1, "setMirror, mMirror[" + this.V + "->" + z16 + "], seq[" + j3 + "]");
            }
            this.V = z16;
            super.p();
        }
    }

    public void n0(boolean z16) {
        o0(z16, false);
    }

    public void n1(boolean z16) {
        this.R0 = z16;
    }

    public void o0(boolean z16, boolean z17) {
        boolean z18;
        float f16;
        if (z16 && ax.c()) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.K0 = z18;
        if (z18) {
            f16 = ViewUtils.dpToPx(8.0f);
        } else {
            f16 = 0.0f;
        }
        B1(f16, z17);
        D1();
    }

    public void o1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.I, 2, "setNeedRenderVideo bRender: " + z16 + ", mNeedRenderVideo: " + this.f74834l0);
        }
        this.f74834l0 = z16;
        super.p();
    }

    public void p1(float f16, int i3, int i16) {
        Pair<Integer, Integer> p06 = p0(i3, i16, super.n(), super.h(), this.Q);
        this.f74824b0.set(this.f74825c0);
        this.f74824b0.postScale(f16, f16, ((Integer) p06.first).intValue(), ((Integer) p06.second).intValue());
        this.f74824b0.getValues(this.f74823a0);
        float[] fArr = this.f74823a0;
        float f17 = fArr[0];
        float f18 = (this.Y * 1.0f) / 1.1111112f;
        float f19 = this.Z * 1.1111112f;
        if (f17 > f18 && f17 < f19) {
            fArr[0] = f17;
            fArr[4] = f17;
            this.f74825c0.setValues(fArr);
            if (QLog.isColorLevel()) {
                QLog.w(this.I, 1, "setScale, scale[" + f16 + "->" + f17 + "], x[" + i3 + "->" + p06.first + "], y[" + i16 + "->" + p06.second + "], mRotation[" + this.Q + "]");
            }
            super.p();
        }
    }

    public void q0(boolean z16) {
        YUVTexture yUVTexture = this.M;
        if (yUVTexture != null) {
            try {
                yUVTexture.D(z16);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void q1(ImageView.ScaleType scaleType) {
        if (QLog.isColorLevel()) {
            QLog.d(this.I, 2, "setScaleType scaleType: " + scaleType);
        }
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        }
        if (this.X != scaleType) {
            this.X = scaleType;
            super.p();
        }
    }

    public void r0() {
        this.f74838p0 = true;
        super.p();
    }

    public void r1(boolean z16) {
        this.P0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void s() {
        GLRootView g16 = g();
        if (g16 != null) {
            g16.removeCallbacks(this.T0);
        }
        super.s();
    }

    public Context s0() {
        return this.K.get();
    }

    public void s1(boolean z16) {
        this.Q0 = z16;
    }

    public String t0() {
        return "TAG[" + this.I + "], uin[" + G0() + "], VST[" + H0() + "], LRT[" + Y() + "], Drc[" + ((int) this.f74828f0.width()) + ", " + ((int) this.f74828f0.height()) + "], Src[" + ((int) this.f74827e0.width()) + ", " + ((int) this.f74827e0.height()) + "], " + this.M.I();
    }

    public void t1(String str) {
        this.f74843u0 = str;
    }

    public void u1(String str) {
        if (!TextUtils.equals(str, this.f74839q0)) {
            this.f74839q0 = str;
            this.f74838p0 = true;
            super.p();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap v0() {
        Bitmap bitmap;
        byte[] P = this.M.P();
        Bitmap bitmap2 = null;
        if (P == null) {
            QLog.d(this.I, 2, "getFrameBitmap  get last frame failed");
            return null;
        }
        int R = this.M.R();
        int Q = this.M.Q();
        int O = this.M.O();
        if (O == 0) {
            int[] Z = Z(P, R, Q);
            if (Z == null) {
                QLog.d(this.I, 2, "getFrameBitmap  I420toARGB failed, type=" + O);
                return null;
            }
            try {
                bitmap = Bitmap.createBitmap(Z, R, Q, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                QLog.d(this.I, 2, "getFrameBitmap exception e.stack " + e16.getStackTrace());
                bitmap = null;
                if (bitmap == null) {
                }
                QLog.d(this.I, 2, "getFrameBitmap nWidth=" + R + ", nHeight=" + Q);
                return bitmap;
            } catch (OutOfMemoryError e17) {
                QLog.d(this.I, 2, "getFrameBitmap OOM exception e.stack " + e17.getStackTrace());
                bitmap = null;
                if (bitmap == null) {
                }
                QLog.d(this.I, 2, "getFrameBitmap nWidth=" + R + ", nHeight=" + Q);
                return bitmap;
            }
            if (bitmap == null) {
                QLog.d(this.I, 2, "getFrameBitmap createBitmap failed");
                return null;
            }
        } else {
            YuvImage yuvImage = new YuvImage(P, 17, R, Q, null);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, R, Q), 100, byteArrayOutputStream);
                bitmap2 = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                QLog.d(this.I, 1, "getFrameBitmap YuvImage close failed");
            } catch (OutOfMemoryError unused2) {
                QLog.d(this.I, 1, "getFrameBitmap YuvImage close failed OOM");
            }
            bitmap = bitmap2;
        }
        QLog.d(this.I, 2, "getFrameBitmap nWidth=" + R + ", nHeight=" + Q);
        return bitmap;
    }

    public void v1(int i3) {
        if (this.f74841s0 != i3) {
            this.f74841s0 = i3;
            this.f74838p0 = true;
            super.p();
            if (QLog.isColorLevel()) {
                QLog.d(this.I, 2, "setTextColor textColor: 0x" + Integer.toHexString(i3).toUpperCase());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void w() {
        this.f74119b = null;
    }

    public boolean w0() {
        return this.U0;
    }

    public void w1(boolean z16) {
        if (this.f74835m0 != z16) {
            this.f74835m0 = z16;
            super.p();
            if (QLog.isColorLevel()) {
                QLog.d(this.I, 2, "setTextInBottom inBottom: " + z16);
            }
        }
    }

    public int x0() {
        return this.f74842t0;
    }

    public void x1(boolean z16) {
        if (this.f74836n0 != z16) {
            this.f74836n0 = z16;
            super.p();
            if (QLog.isColorLevel()) {
                QLog.d(this.I, 2, "setTextInBottomCenter inBottom: " + z16);
            }
        }
    }

    public float y0() {
        return this.Z;
    }

    public void y1(float f16) {
        if (this.f74840r0 != f16) {
            this.f74840r0 = f16;
            this.f74838p0 = true;
            super.p();
            if (QLog.isDevelopLevel()) {
                QLog.d(this.I, 2, "setTextSize textSize: " + f16);
            }
        }
    }

    public float z0() {
        return this.Y;
    }

    public void z1(int i3) {
        this.S0 = i3;
    }

    public GLVideoView(Context context, VideoAppInterface videoAppInterface, String str, long j3, boolean z16) {
        super(context);
        this.Q = 0;
        this.R = false;
        this.S = false;
        this.T = -1;
        this.U = -1;
        this.V = false;
        this.W = true;
        this.Y = 1.0f;
        this.Z = 5.0f;
        this.f74823a0 = new float[9];
        this.f74829g0 = 0;
        this.f74830h0 = false;
        this.f74831i0 = 0L;
        this.f74832j0 = 0L;
        this.f74833k0 = 0;
        this.f74834l0 = true;
        this.f74835m0 = true;
        this.f74836n0 = false;
        this.f74837o0 = false;
        this.f74838p0 = false;
        this.f74839q0 = null;
        this.f74840r0 = 20.0f;
        this.f74841s0 = -1;
        this.f74842t0 = Integer.MAX_VALUE;
        this.f74843u0 = "";
        this.f74844v0 = 0L;
        this.f74846x0 = false;
        this.A0 = -1;
        this.I0 = -1L;
        this.J0 = -1L;
        this.K0 = false;
        this.L0 = 0;
        this.M0 = 0;
        this.N0 = 0;
        this.O0 = null;
        this.P0 = false;
        this.Q0 = false;
        this.R0 = false;
        this.S0 = 70;
        this.T0 = new Runnable() { // from class: com.tencent.av.ui.GLVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                GLRootView g16 = GLVideoView.this.g();
                if (g16 != null) {
                    GLVideoView.super.p();
                    g16.postDelayed(GLVideoView.this.T0, 80L);
                }
            }
        };
        this.U0 = false;
        this.V0 = 0;
        String str2 = "GLVideoView_" + str;
        this.I = str2;
        if (QLog.isDevelopLevel()) {
            QLog.w(str2, 1, "create GLVideoView");
        }
        this.J = context.getApplicationContext();
        this.L = new ov.e();
        this.D0 = BaseAIOUtils.f(6.0f, context.getResources());
        this.E0 = BaseAIOUtils.f(10.0f, context.getResources());
        this.F0 = BaseAIOUtils.f(18.0f, context.getResources());
        this.G0 = BaseAIOUtils.f(16.0f, context.getResources());
        if (z16) {
            com.tencent.av.opengl.texture.d dVar = new com.tencent.av.opengl.texture.d(this.J, this, str, j3);
            this.M = dVar;
            dVar.a0(new a(videoAppInterface));
        }
        this.X = ImageView.ScaleType.CENTER_INSIDE;
        this.f74824b0 = new Matrix();
        this.f74825c0 = new Matrix();
        this.f74826d0 = new RectF();
        this.f74827e0 = new RectF();
        this.f74828f0 = new RectF();
        if (ax.c()) {
            com.tencent.av.opengl.texture.c cVar = new com.tencent.av.opengl.texture.c();
            cVar.D(ViewUtils.dpToPx(8.0f));
            cVar.C(this.f74135r);
            this.H0 = cVar;
        }
    }
}
