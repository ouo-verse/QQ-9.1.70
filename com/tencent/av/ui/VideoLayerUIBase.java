package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.ba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoLayerUIBase extends com.tencent.av.opengl.ui.c {
    protected static String D0;
    protected int A0;
    protected Display B0;
    lw.a C0;
    final String N;
    protected boolean O;
    protected boolean P;
    protected Context Q;
    public VideoAppInterface R;
    protected View S;
    protected int T;
    protected int U;
    protected GLRootView V;
    protected AVFilamentTextureView W;
    protected ImageView X;
    protected Rect Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    protected ViewGroup f75269a0;

    /* renamed from: b0, reason: collision with root package name */
    protected IWinkZShowViewForOnlineStatusProvider.a f75270b0;

    /* renamed from: c0, reason: collision with root package name */
    public GLVideoView[] f75271c0;

    /* renamed from: d0, reason: collision with root package name */
    protected GLVideoView f75272d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f75273e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f75274f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ImageView f75275g0;

    /* renamed from: h0, reason: collision with root package name */
    protected x f75276h0;

    /* renamed from: i0, reason: collision with root package name */
    protected a f75277i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f75278j0;

    /* renamed from: k0, reason: collision with root package name */
    private RenderBuffer f75279k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.av.utils.r f75280l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextureRender f75281m0;

    /* renamed from: n0, reason: collision with root package name */
    protected QavVideoRecordUICtrl f75282n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f75283o0;

    /* renamed from: p0, reason: collision with root package name */
    private float[] f75284p0;

    /* renamed from: q0, reason: collision with root package name */
    private long f75285q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f75286r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f75287s0;

    /* renamed from: t0, reason: collision with root package name */
    boolean f75288t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f75289u0;

    /* renamed from: v0, reason: collision with root package name */
    protected Runnable f75290v0;

    /* renamed from: w0, reason: collision with root package name */
    protected Runnable f75291w0;

    /* renamed from: x0, reason: collision with root package name */
    protected int f75292x0;

    /* renamed from: y0, reason: collision with root package name */
    protected int f75293y0;

    /* renamed from: z0, reason: collision with root package name */
    protected int f75294z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class MoveSmallViewAnimation implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f75295d = 0;

        /* renamed from: e, reason: collision with root package name */
        private float f75296e;

        /* renamed from: f, reason: collision with root package name */
        private float f75297f;

        /* renamed from: h, reason: collision with root package name */
        private int f75298h;

        MoveSmallViewAnimation(int i3, int i16, int i17, int i18, int i19) {
            this.f75296e = (i18 - i16) / 10.0f;
            this.f75297f = (i19 - i17) / 10.0f;
            this.f75298h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoLayerUIBase.this.M0()) {
                return;
            }
            if (this.f75295d == 9) {
                VideoLayerUIBase.this.f1(this.f75298h);
            } else {
                VideoLayerUIBase.this.n0((int) this.f75296e, (int) this.f75297f);
            }
            int i3 = this.f75295d + 1;
            this.f75295d = i3;
            VideoAppInterface videoAppInterface = VideoLayerUIBase.this.R;
            if (videoAppInterface != null && i3 <= 9) {
                videoAppInterface.M().postDelayed(this, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<VideoLayerUIBase> f75299d;

        a(VideoLayerUIBase videoLayerUIBase) {
            this.f75299d = new WeakReference<>(videoLayerUIBase);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            VideoLayerUIBase videoLayerUIBase = this.f75299d.get();
            if (videoLayerUIBase != null) {
                videoLayerUIBase.F0(observable, obj);
            }
        }
    }

    public VideoLayerUIBase(VideoAppInterface videoAppInterface, Context context, View view) {
        super(context);
        this.O = false;
        this.P = false;
        this.T = 0;
        this.U = 0;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = false;
        this.f75269a0 = null;
        this.f75270b0 = null;
        this.f75271c0 = null;
        this.f75273e0 = 0;
        this.f75274f0 = -1;
        this.f75275g0 = null;
        this.f75278j0 = false;
        this.f75282n0 = null;
        this.f75283o0 = false;
        this.f75284p0 = null;
        this.f75285q0 = 0L;
        this.f75286r0 = 0;
        this.f75287s0 = false;
        this.f75288t0 = false;
        this.f75289u0 = false;
        this.f75290v0 = new Runnable() { // from class: com.tencent.av.ui.VideoLayerUIBase.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.av.r.h0() != null && !VideoLayerUIBase.this.f75288t0) {
                    com.tencent.av.r.h0().p2(com.tencent.av.n.e().f().f73091w);
                }
            }
        };
        this.f75291w0 = new Runnable() { // from class: com.tencent.av.ui.VideoLayerUIBase.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.av.r.h0() != null && !VideoLayerUIBase.this.f75288t0) {
                    try {
                        com.tencent.av.r.h0().S1(com.tencent.av.n.e().f().f73091w);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(VideoLayerUIBase.this.N, 2, "pauseVideo Runnable exception", e16);
                        }
                    }
                }
            }
        };
        this.f75292x0 = 0;
        this.f75293y0 = 0;
        this.f75294z0 = 2;
        this.A0 = 0;
        this.C0 = null;
        String str = getClass().getSimpleName() + "_" + com.tencent.av.utils.e.d();
        this.N = str;
        QLog.d(str, 1, "onCreate:" + this + ", VideoAppInterface:" + videoAppInterface + ", rootView:" + view);
        this.R = videoAppInterface;
        this.f75288t0 = false;
        this.Q = context;
        this.S = view;
        this.B0 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        a aVar = new a(this);
        this.f75277i0 = aVar;
        this.R.addObserver(aVar);
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Observable observable, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean z16 = false;
        switch (((Integer) objArr[0]).intValue()) {
            case 6100:
                ControlUIObserver.d dVar = (ControlUIObserver.d) ControlUIObserver.c(objArr);
                FaceItem w3 = ((com.tencent.av.business.manager.magicface.a) this.R.B(3)).w(dVar.f74779f);
                if (w3 != null && w3.isInteract()) {
                    z16 = true;
                }
                if (N0() || !z16) {
                    p0();
                    this.C0.h(dVar.a(), (ViewGroup) this.S, dVar);
                    return;
                }
                return;
            case 6101:
                if (this.R.Y(3)) {
                    p0();
                    this.C0.b((ViewGroup) this.S, (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                    return;
                }
                return;
            case 6102:
                if (this.R.Y(3)) {
                    p0();
                    this.C0.g((ViewGroup) this.S);
                    return;
                }
                return;
            default:
                E0(observable, obj);
                return;
        }
    }

    public static boolean O0(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f73035i;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean R0(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f73035i;
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    private void o0() {
        if (this.f75275g0 != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.S.findViewById(R.id.t0g);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f75275g0 = (ImageView) this.S.findViewById(R.id.a2a);
    }

    private void t0() {
        boolean z16;
        if (BaseApplication.getContext().getExternalFilesDir(null) != null && BaseApplication.getContext().getExternalCacheDir() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            D0 = BaseApplication.getContext().getExternalFilesDir(null).getPath();
        } else {
            D0 = BaseApplication.getContext().getFilesDir().getPath();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r7 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        if (r7 == 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0079, code lost:
    
        if (r7 == 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:
    
        if (r7 == 2) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int A0(int i3, int i16, int i17, int i18, int i19, int i26) {
        char c16;
        int dimensionPixelSize = this.Q.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.b28);
        int dimensionPixelSize2 = this.Q.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.b29);
        int i27 = i19 - i17;
        char c17 = 0;
        if (i27 > dimensionPixelSize) {
            c16 = 1;
        } else if (i27 < (-dimensionPixelSize)) {
            c16 = 2;
        } else {
            c16 = 0;
        }
        int i28 = i26 - i18;
        if (i28 > dimensionPixelSize2) {
            c17 = 1;
        } else if (i28 < (-dimensionPixelSize2)) {
            c17 = 2;
        }
        if (i16 == 3) {
            if (i3 != 1 && i3 != 2 && i3 != 4) {
                if (i3 == 3) {
                    if (c16 != 2) {
                        if (c17 == 2) {
                            return 2;
                        }
                    }
                }
                return 1;
            }
            return 3;
        }
        if (i16 == 2) {
            if (i3 == 1 || i3 == 3 || i3 == 4) {
                return 2;
            }
            if (i3 == 2) {
                if (c16 != 2) {
                    if (c17 != 1) {
                        return 2;
                    }
                    return 3;
                }
            }
            return 1;
        }
        if (i16 == 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4 && i3 == 1) {
                if (c16 == 1) {
                    if (c17 != 1) {
                        return 2;
                    }
                    return 3;
                }
            }
            return 1;
        }
        if (i16 == 4) {
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    if (c16 == 1) {
                        if (c17 == 2) {
                            return 2;
                        }
                        return 3;
                    }
                }
            }
            return 4;
        }
        return 1;
    }

    public int B0() {
        Rect f16 = super.f();
        int centerX = f16.centerX();
        int centerY = f16.centerY();
        int centerX2 = this.f75271c0[1].f().centerX();
        int centerY2 = this.f75271c0[1].f().centerY();
        if (centerX2 < centerX && centerY2 < centerY) {
            return 1;
        }
        if (centerX2 < centerX && centerY2 > centerY) {
            return 4;
        }
        if (centerX2 > centerX && centerY2 < centerY) {
            return 2;
        }
        if (centerX2 > centerX && centerY2 > centerY) {
            return 3;
        }
        return 0;
    }

    @Override // com.tencent.av.opengl.ui.c, com.tencent.av.opengl.ui.b
    @RequiresApi(api = 17)
    public void C(ov.a aVar) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.f75282n0;
        float[] fArr = null;
        if (qavVideoRecordUICtrl != null && qavVideoRecordUICtrl.V()) {
            if (!this.f75278j0) {
                this.f75278j0 = true;
                this.f75279k0 = new RenderBuffer(aVar.getWidth(), aVar.getHeight(), 33984);
                this.f75281m0 = new TextureRender();
                this.f75283o0 = this.f75282n0.Q();
                this.f75280l0 = new com.tencent.av.utils.r();
                if (this.f75283o0) {
                    int[] x16 = this.f75282n0.x(aVar.getWidth(), aVar.getHeight(), true);
                    float[] fArr2 = new float[16];
                    this.f75284p0 = fArr2;
                    Matrix.setIdentityM(fArr2, 0);
                    this.f75284p0[5] = (x16[1] * 1.0f) / ((aVar.getHeight() * x16[0]) / aVar.getWidth());
                    float[] fArr3 = this.f75284p0;
                    fArr3[13] = 1.0f - fArr3[5];
                } else {
                    this.f75282n0.x(aVar.getWidth(), aVar.getHeight(), false);
                }
            }
            Z0(aVar, true);
            GLES20.glBindFramebuffer(36161, 0);
            GLES20.glViewport(0, 0, aVar.getWidth(), aVar.getHeight());
            this.f75281m0.drawTexture(GLSLRender.GL_TEXTURE_2D, this.f75279k0.getTexId(), null, null);
            this.f75279k0.bind();
            int a16 = this.f75280l0.a(this.f75279k0.getWidth(), this.f75279k0.getHeight());
            this.f75279k0.unbind();
            QavVideoRecordUICtrl qavVideoRecordUICtrl2 = this.f75282n0;
            if (this.f75283o0) {
                fArr = this.f75284p0;
            }
            qavVideoRecordUICtrl2.C0(GLSLRender.GL_TEXTURE_2D, a16, fArr, null, SystemClock.elapsedRealtimeNanos());
            return;
        }
        if (this.f75278j0) {
            this.f75278j0 = false;
            int texId = this.f75279k0.getTexId();
            this.f75279k0.destroy();
            this.f75279k0 = null;
            this.f75281m0.release();
            this.f75281m0 = null;
            this.f75284p0 = null;
            GLES20.glDeleteTextures(1, new int[]{texId}, 0);
            this.f75280l0.b();
        }
        GLES20.glBindFramebuffer(36160, 0);
        Z0(aVar, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int C0(int i3) {
        int i16 = -1;
        if (this.f75271c0 == null) {
            return -1;
        }
        int i17 = i3;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i17 >= gLVideoViewArr.length) {
                break;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i17];
            if (TextUtils.isEmpty(gLVideoView.G0()) || gLVideoView.m() == 1) {
                break;
            }
            i17++;
        }
        i16 = i17;
        Y0("getUnusedView, start[" + i3 + "], result_index[" + i16 + "]");
        return i16;
    }

    protected int D0() {
        return 0;
    }

    public void G0() {
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0() {
        if (this.W == null) {
            ViewStub viewStub = (ViewStub) this.S.findViewById(R.id.t0_);
            if (viewStub != null) {
                viewStub.inflate();
            }
            this.W = (AVFilamentTextureView) this.S.findViewById(R.id.t0e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0() {
        if (this.V == null) {
            ((ViewStub) this.S.findViewById(R.id.t0h)).inflate();
        }
        GLRootView gLRootView = (GLRootView) this.S.findViewById(R.id.a2b);
        this.V = gLRootView;
        gLRootView.setContentPane(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0() {
        this.f75271c0 = new GLVideoView[16];
        int f16 = BaseAIOUtils.f(com.tencent.av.q.f74203n + com.tencent.av.q.f74204o, this.Q.getResources());
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            f16 += ImmersiveUtils.getStatusBarHeight(this.Q);
        }
        if (com.tencent.av.q.f74206q) {
            f16 += 25;
        }
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 < gLVideoViewArr.length) {
                gLVideoViewArr[i3] = new GLVideoView(this.Q, this.R, String.format("%s_%s", this.N, Integer.valueOf(i3)), com.tencent.av.r.h0().q0());
                this.f75271c0[i3].b1(this.Q);
                this.f75271c0[i3].R(1);
                this.f75271c0[i3].T0(-1);
                this.f75271c0[i3].l1(R.drawable.n78, R.drawable.n77);
                this.f75271c0[i3].r1(this.f75276h0.d());
                if (i3 == 0) {
                    this.f75271c0[i3].S(i3 * 2);
                } else {
                    GLVideoView[] gLVideoViewArr2 = this.f75271c0;
                    gLVideoViewArr2[i3].S((gLVideoViewArr2.length - i3) * 2);
                }
                this.f75271c0[i3].z1(f16);
                X(this.f75271c0[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    protected void K0() {
        ImageView imageView;
        ViewStub viewStub = (ViewStub) this.S.findViewById(R.id.t0_);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.X = (ImageView) this.S.findViewById(R.id.t09);
        Bitmap c16 = com.tencent.av.zplan.avatar.utils.a.f77344a.c(BaseApplicationImpl.getApplication(), "qav_zplan_avatar_bg_v1" + File.separator + "bg_default.png");
        if (c16 != null && (imageView = this.X) != null) {
            imageView.setImageBitmap(c16);
        }
    }

    public boolean L0(String str, int i3) {
        int w06 = w0("isBigView", str, i3);
        Y0("isBigView, uin[" + str + "], videoSrcType[" + i3 + "], result_index[" + w06 + "]");
        if (w06 == 0) {
            return true;
        }
        return false;
    }

    public boolean M0() {
        return this.f75289u0;
    }

    public boolean N0() {
        if (M0()) {
            return false;
        }
        return this.f75276h0.d();
    }

    public boolean P0() {
        return this.f75287s0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Q0() {
        boolean z16;
        String currentAccountUin = this.R.getCurrentAccountUin();
        GLVideoView gLVideoView = this.f75271c0[0];
        if (gLVideoView.m() == 0 && currentAccountUin.equals(gLVideoView.G0())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, "isLocalFront: " + z16);
        }
        Y0(String.format("isLocalFront, self isLocalFront[%s]", Boolean.valueOf(z16)));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S0() {
        String currentAccountUin = this.R.getCurrentAccountUin();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                break;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            if (gLVideoView.m() == 0 && !currentAccountUin.equals(gLVideoView.G0())) {
                z16 = true;
                break;
            }
            i3++;
        }
        Y0("isRemoteHasVideo, peer isRemoteHasVideo[" + z16 + "]");
        return z16;
    }

    public void U0(long j3, boolean z16) {
        int w06 = w0("onCameraOpened_" + z16, this.R.getCurrentAccountUin(), 1);
        if (w06 >= 0) {
            this.f75271c0[w06].m1(j3, z16);
        }
    }

    public void V0() {
        if (QLog.isColorLevel()) {
            QLog.w(this.N, 1, "onDestroy, mDestroyed[" + this.f75289u0 + "]");
        }
        this.f75289u0 = true;
        VideoAppInterface videoAppInterface = this.R;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.f75277i0);
            this.R.M().removeCallbacks(this.f75291w0);
        }
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.setOnTouchListener(null);
            this.V.setContentPane(null);
        }
        super.g0();
        if (this.f75271c0 != null) {
            int i3 = 0;
            while (true) {
                GLVideoView[] gLVideoViewArr = this.f75271c0;
                if (i3 >= gLVideoViewArr.length) {
                    break;
                }
                gLVideoViewArr[i3].R(1);
                this.f75271c0[i3].o1(true);
                this.f75271c0[i3].m0(false);
                this.f75271c0[i3].i1(false);
                this.f75271c0[i3].q0(true);
                this.f75271c0[i3].U0();
                i3++;
            }
        }
        this.R = null;
        this.f75288t0 = true;
        this.f75275g0 = null;
        this.Q = null;
        this.S = null;
        this.V = null;
        this.f75271c0 = null;
    }

    @Override // com.tencent.av.opengl.ui.c
    protected boolean W() {
        return false;
    }

    public void W0() {
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.onPause();
        }
    }

    public void X0() {
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.onResume();
        }
        e1(this.f75293y0, false);
    }

    void Y0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, ("printGLVideoView[" + str + "]\r\n") + u0());
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, ("printItemList[" + str + "]\r\n") + com.tencent.av.r.h0().I0(com.tencent.av.n.e().f().f73045k1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z0(ov.a aVar, boolean z16) {
        if (z16 && this.f75279k0 != null) {
            if (!W()) {
                this.f75279k0.bind();
                super.C(aVar);
                this.f75279k0.unbind();
                return;
            } else {
                super.j0(true);
                super.C(aVar);
                super.j0(false);
                return;
            }
        }
        super.C(aVar);
    }

    public void a1(boolean z16) {
        this.f75287s0 = z16;
    }

    public void b1(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            int i3 = 0;
            while (true) {
                GLVideoView[] gLVideoViewArr = this.f75271c0;
                if (i3 < gLVideoViewArr.length) {
                    GLVideoView gLVideoView = gLVideoViewArr[i3];
                    if (str.equals((String) gLVideoView.l(0)) && gLVideoView.m() == 0) {
                        gLVideoView.i1(z16);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void c1(long j3, GLVideoView gLVideoView) {
        if (gLVideoView != null && !gLVideoView.M0()) {
            gLVideoView.m1(j3, this.f75276h0.d());
        }
    }

    public void d1(QavVideoRecordUICtrl qavVideoRecordUICtrl) {
        this.f75282n0 = qavVideoRecordUICtrl;
    }

    @Override // com.tencent.av.opengl.ui.b
    public GLRootView g() {
        return this.V;
    }

    public void g1(boolean z16) {
        ViewGroup viewGroup;
        int i3;
        QLog.d(this.N, 2, "showFilamentView isShow: " + z16);
        this.f75287s0 = z16;
        if (this.W == null) {
            H0();
        }
        AVFilamentTextureView aVFilamentTextureView = this.W;
        if (aVFilamentTextureView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            aVFilamentTextureView.setVisibility(i3);
        }
        if (this.Y == null) {
            this.Y = new Rect();
        }
        if (z16) {
            View view = this.S;
            if (view == null) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) view.findViewById(R.id.t0f);
            }
            if (viewGroup != null) {
                if (this.W.getParent() != null) {
                    viewGroup.removeView(this.W);
                }
                viewGroup.addView(this.W);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.S;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.W);
                    viewGroup2.addView(this.W);
                }
            }
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) this.W.getParent();
            if (relativeLayout != null) {
                relativeLayout.removeView(this.W);
            }
            k1(false);
        }
        com.tencent.av.r.h0().N0(this.W, z16, this.Y, D0());
    }

    public void h1(int i3, boolean z16) {
        this.f75271c0[i3].C1(z16);
    }

    public void i1() {
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.setVisibility(0);
        }
    }

    public void j1(String str, int i3) {
        boolean z16;
        boolean z17;
        int w06 = w0("showNick", str, i3);
        if (w06 >= 0) {
            GLVideoView gLVideoView = this.f75271c0[w06];
            x xVar = this.f75276h0;
            if (xVar != null && xVar.c() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (w06 == 0 && !z16 && this.T != 0 && this.U != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            this.R.k0(new Object[]{9100, Integer.valueOf(w06), Boolean.valueOf(z17)});
        }
    }

    public void k1(boolean z16) {
        int i3;
        QLog.d(this.N, 2, "showOrHideZplanAvatarBg isShow: " + z16 + " mZplanAvatarBg: " + this.X);
        ImageView imageView = this.X;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        if (z16) {
            K0();
        }
    }

    public void l0(int i3) {
        int i16;
        int i17;
        int i18;
        int height;
        int dimensionPixelSize = this.Q.getResources().getDimensionPixelSize(R.dimen.b27);
        int dimensionPixelSize2 = this.Q.getResources().getDimensionPixelSize(R.dimen.f159623b24);
        int dimensionPixelSize3 = this.Q.getResources().getDimensionPixelSize(R.dimen.f159624b25);
        int dimensionPixelSize4 = this.Q.getResources().getDimensionPixelSize(R.dimen.b26);
        if (this.U == 0) {
            dimensionPixelSize4 = dimensionPixelSize3;
        }
        Rect f16 = super.f();
        int i19 = this.f75271c0[1].f().left;
        int i26 = this.f75271c0[1].f().top;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        i17 = 0;
                        i18 = 0;
                        this.R.M().post(new MoveSmallViewAnimation(i3, i19, i26, i17, i18));
                    }
                    height = f16.height();
                } else {
                    dimensionPixelSize3 = (f16.width() - dimensionPixelSize3) - dimensionPixelSize;
                    height = f16.height();
                }
                i18 = (height - dimensionPixelSize4) - dimensionPixelSize2;
                i17 = dimensionPixelSize3;
                this.R.M().post(new MoveSmallViewAnimation(i3, i19, i26, i17, i18));
            }
            dimensionPixelSize3 = (f16.width() - dimensionPixelSize3) - dimensionPixelSize;
            i16 = this.T;
        } else {
            i16 = this.T;
        }
        i17 = dimensionPixelSize3;
        i18 = dimensionPixelSize4 + i16;
        this.R.M().post(new MoveSmallViewAnimation(i3, i19, i26, i17, i18));
    }

    public void l1(String str, int i3, int i16) {
        int o16 = this.f75271c0[i3].o();
        this.f75271c0[i3].S(this.f75271c0[i16].o());
        this.f75271c0[i16].S(o16);
        if (com.tencent.av.n.e().f().f73035i == 4) {
            if (i3 == 0) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_CROP);
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_INSIDE);
            } else if (i16 == 0) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_INSIDE);
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_CROP);
            }
            String currentAccountUin = this.R.getCurrentAccountUin();
            String G0 = this.f75271c0[i3].G0();
            String G02 = this.f75271c0[i16].G0();
            if (currentAccountUin.equals(G0)) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_CROP);
            } else if (currentAccountUin.equals(G02)) {
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_CROP);
            }
            int E0 = this.f75271c0[i3].E0();
            float F0 = this.f75271c0[i3].F0();
            int x06 = this.f75271c0[i3].x0();
            boolean P0 = this.f75271c0[i3].P0();
            boolean R0 = this.f75271c0[i3].R0();
            boolean L0 = this.f75271c0[i3].L0();
            int E02 = this.f75271c0[i16].E0();
            float F02 = this.f75271c0[i16].F0();
            int x07 = this.f75271c0[i16].x0();
            boolean P02 = this.f75271c0[i16].P0();
            boolean R02 = this.f75271c0[i16].R0();
            boolean L02 = this.f75271c0[i16].L0();
            this.f75271c0[i3].w1(R02);
            this.f75271c0[i3].v1(E02);
            this.f75271c0[i3].y1(F02);
            this.f75271c0[i3].k1(x07);
            this.f75271c0[i3].C1(P02);
            this.f75271c0[i3].n0(L02);
            this.R.k0(new Object[]{9100, Integer.valueOf(i3), Boolean.valueOf(P02)});
            this.f75271c0[i16].w1(R0);
            this.f75271c0[i16].v1(E0);
            this.f75271c0[i16].y1(F0);
            this.f75271c0[i16].k1(x06);
            this.f75271c0[i16].C1(P0);
            this.f75271c0[i16].n0(L0);
            this.R.k0(new Object[]{9100, Integer.valueOf(i16), Boolean.valueOf(P0)});
        }
        GLVideoView[] gLVideoViewArr = this.f75271c0;
        GLVideoView gLVideoView = gLVideoViewArr[i3];
        gLVideoViewArr[i3] = gLVideoViewArr[i16];
        gLVideoViewArr[i16] = gLVideoView;
        this.f75271c0[i3].i1(gLVideoViewArr[i3].a0());
        this.f75271c0[i16].i1(this.f75271c0[i16].a0());
        float dp2px = ba.dp2px(BaseApplication.getContext(), 12.0f);
        float dp2px2 = ba.dp2px(BaseApplication.getContext(), 18.0f);
        if (i3 == 0) {
            this.f75271c0[i3].y1(dp2px2);
        } else {
            this.f75271c0[i3].y1(dp2px);
        }
        if (i16 == 0) {
            this.f75271c0[i16].y1(dp2px2);
        } else {
            this.f75271c0[i16].y1(dp2px);
        }
        this.f75271c0[0].O(0, 0, 0, 0);
        this.f75271c0[0].q(0, 0, super.n(), super.h());
        this.f75271c0[0].I(-15197410);
        c0();
        String G03 = this.f75271c0[i3].G0();
        String G04 = this.f75271c0[i16].G0();
        if (QLog.isColorLevel()) {
            QLog.w(this.N, 1, "swapGLVideoView, end, [" + i3 + "]=[" + G03 + "], [" + i16 + "]=[" + G04 + "]=[" + str + "]", new Throwable("who call SwapGLVideoView"));
        }
    }

    public void m0(int i3) {
        com.tencent.av.n.e().f().O1 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m1(int i3, int i16) {
        int o16 = this.f75271c0[i3].o();
        this.f75271c0[i3].S(this.f75271c0[i16].o());
        this.f75271c0[i16].S(o16);
        if (com.tencent.av.n.e().f().f73035i == 4) {
            if (i3 == 0) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_CROP);
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_INSIDE);
            } else if (i16 == 0) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_INSIDE);
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_CROP);
            }
            String currentAccountUin = this.R.getCurrentAccountUin();
            String G0 = this.f75271c0[i3].G0();
            String G02 = this.f75271c0[i16].G0();
            if (currentAccountUin.equals(G0)) {
                this.f75271c0[i3].q1(ImageView.ScaleType.CENTER_CROP);
            } else if (currentAccountUin.equals(G02)) {
                this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_CROP);
            }
            int E0 = this.f75271c0[i3].E0();
            float F0 = this.f75271c0[i3].F0();
            int x06 = this.f75271c0[i3].x0();
            boolean P0 = this.f75271c0[i3].P0();
            boolean R0 = this.f75271c0[i3].R0();
            int E02 = this.f75271c0[i16].E0();
            float F02 = this.f75271c0[i16].F0();
            int x07 = this.f75271c0[i16].x0();
            boolean P02 = this.f75271c0[i16].P0();
            this.f75271c0[i3].w1(this.f75271c0[i16].R0());
            this.f75271c0[i3].v1(E02);
            this.f75271c0[i3].y1(F02);
            this.f75271c0[i3].k1(x07);
            this.R.k0(new Object[]{9100, Integer.valueOf(i3), Boolean.valueOf(P02)});
            this.f75271c0[i16].w1(R0);
            this.f75271c0[i16].v1(E0);
            this.f75271c0[i16].y1(F0);
            this.f75271c0[i16].k1(x06);
            this.R.k0(new Object[]{9100, Integer.valueOf(i16), Boolean.valueOf(P0)});
        }
        GLVideoView[] gLVideoViewArr = this.f75271c0;
        GLVideoView gLVideoView = gLVideoViewArr[i3];
        gLVideoViewArr[i3] = gLVideoViewArr[i16];
        gLVideoViewArr[i16] = gLVideoView;
        this.f75271c0[i3].i1(gLVideoViewArr[i3].a0());
        this.f75271c0[i16].i1(this.f75271c0[i16].a0());
        float dp2px = ba.dp2px(BaseApplication.getContext(), 12.0f);
        float dp2px2 = ba.dp2px(BaseApplication.getContext(), 18.0f);
        if (i3 == 0) {
            this.f75271c0[i3].y1(dp2px2);
        } else {
            this.f75271c0[i3].y1(dp2px);
        }
        if (i16 == 0) {
            this.f75271c0[i16].y1(dp2px2);
        } else {
            this.f75271c0[i16].y1(dp2px);
        }
        T0(false);
        if (com.tencent.av.n.e().f().f73035i == 2) {
            com.tencent.av.n.e().f().M = Q0();
        }
        if (com.tencent.av.n.e().f().f73035i == 4) {
            q0(com.tencent.av.n.e().f());
        }
        String G03 = this.f75271c0[i3].G0();
        String G04 = this.f75271c0[i16].G0();
        if (QLog.isColorLevel()) {
            QLog.w(this.N, 1, "switchVideo, end, [" + i3 + "]=[" + G03 + "], [" + i16 + "]=[" + G04 + "]");
        }
    }

    public void n0(int i3, int i16) {
        Context context = this.Q;
        if (context == null) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.b27);
        int dimensionPixelSize2 = this.Q.getResources().getDimensionPixelSize(R.dimen.f159623b24);
        Rect f16 = super.f();
        int width = f16.width() - dimensionPixelSize;
        int height = f16.height() - dimensionPixelSize2;
        int i17 = this.f75271c0[1].f().left + i3;
        int i18 = this.f75271c0[1].f().top + i16;
        if (i17 < 0) {
            width = 0;
        } else if (i17 <= width) {
            width = i17;
        }
        if (i18 < 0) {
            height = 0;
        } else if (i18 <= height) {
            height = i18;
        }
        this.f75271c0[1].q(width, height, dimensionPixelSize + width, dimensionPixelSize2 + height);
    }

    public void n1(int i3, int i16, int i17, int i18) {
        if (this.Y == null) {
            this.Y = new Rect();
        }
        this.Y.set(i3, i17, i16, i18);
    }

    void p0() {
        if (this.C0 == null) {
            this.C0 = new lw.a(this.R, this.Q);
        }
    }

    void q0(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f73067q;
        if (i3 == 3000) {
            if (Q0()) {
                ReportController.o(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
                return;
            } else {
                ReportController.o(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 1) {
            if (Q0()) {
                if (sessionInfo.f73063p == 10) {
                    ReportController.o(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
                    return;
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (sessionInfo.f73063p == 10) {
                ReportController.o(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
            }
        }
    }

    public boolean r0() {
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                break;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            if (gLVideoView.m() == 0) {
                gLVideoView.h0();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(this.N, 1, "doCancelGlassRemoteVideo i=" + i3 + ", getVisibility=" + gLVideoView.m());
            }
            i3++;
        }
        ImageView imageView = this.f75275g0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        return false;
    }

    public boolean s0() {
        boolean z16 = true;
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                break;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            if (gLVideoView.m() == 0 && !(z16 = gLVideoView.k0())) {
                QLog.d(this.N, 1, "doGlassRemoteVideo failed !!!! i=" + i3 + ", getVisibility=" + gLVideoView.m());
                break;
            }
            QLog.d(this.N, 1, "doGlassRemoteVideo i=" + i3 + ", getVisibility=" + gLVideoView.m());
            i3++;
        }
        if (z16) {
            o0();
            ImageView imageView = this.f75275g0;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            QLog.d(this.N, 1, "doGlassRemoteVideo failed and cancel Glass");
            r0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void u(boolean z16, int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, "onLayout|left: " + i3 + ", top: " + i16 + ", right: " + i17 + ", bottom: " + i18);
        }
        T0(false);
    }

    String u0() {
        StringBuilder sb5 = new StringBuilder("[" + this.N + "]VideoView[5]:\r\n");
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 < gLVideoViewArr.length) {
                GLVideoView gLVideoView = gLVideoViewArr[i3];
                sb5.append("---------index[");
                sb5.append(i3);
                sb5.append("], size[");
                sb5.append(gLVideoView.n());
                sb5.append(", ");
                sb5.append(gLVideoView.h());
                sb5.append("], ");
                sb5.append(gLVideoView.t0());
                sb5.append("\r\n");
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }

    public AVFilamentTextureView v0() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w0(String str, String str2, int i3) {
        if (!TextUtils.isEmpty(str2)) {
            int i16 = 0;
            while (true) {
                GLVideoView[] gLVideoViewArr = this.f75271c0;
                if (i16 >= gLVideoViewArr.length) {
                    break;
                }
                GLVideoView gLVideoView = gLVideoViewArr[i16];
                if (!str2.equals(gLVideoView.G0()) || i3 != gLVideoView.H0() || gLVideoView.m() != 0) {
                    i16++;
                } else {
                    return i16;
                }
            }
        }
        return -1;
    }

    public long x0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (gLVideoViewArr == null || i3 >= gLVideoViewArr.length) {
                return 0L;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            if (gLVideoView.m() == 0 && str.equals(gLVideoView.G0())) {
                return gLVideoView.Y();
            }
            i3++;
        }
    }

    public int y0() {
        return this.f75294z0;
    }

    public int z0(int i3, int i16, int i17, int i18, int i19) {
        return A0(i3, B0(), i16, i17, i18, i19);
    }

    public void T0(boolean z16) {
    }

    protected void f1(int i3) {
    }

    protected void E0(Observable observable, Object obj) {
    }

    public void e1(int i3, boolean z16) {
    }
}
