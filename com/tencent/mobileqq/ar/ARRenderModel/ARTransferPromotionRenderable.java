package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARPromotion.c;
import com.tencent.mobileqq.ar.ARPromotion.d;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes11.dex */
public class ARTransferPromotionRenderable implements a, ARPromotionMediaPlayerWrapper.a, ARNativeBridge.ARWorldCupCallback, View.OnTouchListener, Handler.Callback, ARTransferDoorLogicManager.a {
    private i C;
    private ARNativeBridge D;
    private int E;
    private com.tencent.mobileqq.armap.sensor.a G;
    private volatile int H;
    private volatile int I;
    private int J;
    private int K;
    private boolean L;
    private boolean M;
    private com.tencent.mobileqq.ar.ARPromotion.d P;
    private c.a Q;
    private ARPromotionSoundPlayer R;
    private ARTransferDoorLogicManager V;
    private ISPlayerPreDownloader W;
    private int X;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f197074a0;

    /* renamed from: f, reason: collision with root package name */
    MqqWeakReferenceHandler f197081f;

    /* renamed from: i, reason: collision with root package name */
    private Context f197084i;

    /* renamed from: m, reason: collision with root package name */
    private c f197085m;

    /* renamed from: d, reason: collision with root package name */
    volatile int f197077d = 0;

    /* renamed from: e, reason: collision with root package name */
    volatile int f197079e = 0;

    /* renamed from: h, reason: collision with root package name */
    volatile long f197083h = -1;
    private boolean F = false;
    private volatile boolean N = false;
    private ARPromotionMediaPlayerWrapper S = new ARPromotionMediaPlayerWrapper(this, 1);
    private ArrayList<Runnable> T = new ArrayList<>();
    private final Runnable U = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1
        @Override // java.lang.Runnable
        public void run() {
            ARTransferPromotionRenderable.this.j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ARTransferPromotionRenderable.this.S != null && ARTransferPromotionRenderable.this.S.E()) {
                        ARTransferPromotionRenderable.this.S.I();
                        QLog.d("ARTransferPromotionRenderable", 2, "mRepeatCheckRunnable run ");
                    }
                }
            });
            QLog.d("ARTransferPromotionRenderable", 2, "post mRepeatCheckRunnable ");
        }
    };
    private com.tencent.mobileqq.armap.sensor.d Y = new com.tencent.mobileqq.armap.sensor.d() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2
        @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
        public void onRotationUpdateQuaternion(final float[] fArr) {
            ARTransferPromotionRenderable.this.f197085m.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (6 == ARTransferPromotionRenderable.this.H && ARTransferPromotionRenderable.this.f197079e <= 4) {
                        ARNativeBridge aRNativeBridge = ARTransferPromotionRenderable.this.D;
                        float[] fArr2 = fArr;
                        aRNativeBridge.native_setARWorldCupQuaternion(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
                    }
                }
            });
        }
    };

    /* renamed from: b0, reason: collision with root package name */
    private volatile boolean f197075b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private volatile int f197076c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f197078d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private int f197080e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f197082f0 = false;

    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable$15, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ ARTransferPromotionRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            ARTransferPromotionRenderable.u(this.this$0);
            Context unused = this.this$0.f197084i;
            throw null;
        }
    }

    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable$5, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ ARTransferPromotionRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.L = true;
            this.this$0.onDestroy();
        }
    }

    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable$8, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ ARTransferPromotionRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            ARTransferPromotionRenderable.u(this.this$0);
            int unused = this.this$0.J;
            int unused2 = this.this$0.K;
            throw null;
        }
    }

    public ARTransferPromotionRenderable(c cVar, i iVar) {
        int i3;
        this.M = true;
        this.X = -1;
        this.f197085m = cVar;
        this.C = iVar;
        this.f197084i = cVar.d();
        this.D = (ARNativeBridge) cVar.e(0);
        this.V = (ARTransferDoorLogicManager) cVar.e(8);
        boolean e16 = r.e();
        if (this.F) {
            Context context = this.f197084i;
            if (e16) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            this.G = new com.tencent.mobileqq.armap.sensor.a(context, i3);
        }
        this.H = 1;
        this.f197081f = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.M = r.f197333k;
        this.W = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
        String a16 = this.C.a();
        if (!TextUtils.isEmpty(a16)) {
            this.X = this.W.startPreDownload(SuperPlayerFactory.createVideoInfoForUrl(a16, 101, MD5Utils.toMD5(a16)), 3000L, 1000L);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
            @Override // java.lang.Runnable
            public void run() {
                ARTransferPromotionRenderable aRTransferPromotionRenderable = ARTransferPromotionRenderable.this;
                aRTransferPromotionRenderable.P = com.tencent.mobileqq.ar.ARPromotion.d.b(aRTransferPromotionRenderable.C.f197268o);
                if (ARTransferPromotionRenderable.this.P != null) {
                    QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + ARTransferPromotionRenderable.this.P);
                    return;
                }
                QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
            }
        }, 8, null, true);
    }

    private void i0(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        if (this.M && this.N && fArr5 != null && this.f197079e < 6) {
            this.D.native_setARWorldCupQuaternion(fArr5[0], fArr5[1], fArr5[2], fArr5[3]);
        }
        synchronized (this.T) {
            while (!this.T.isEmpty()) {
                Runnable remove = this.T.remove(0);
                if (remove != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    remove.run();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= 200) {
                        QLog.d("ARTransferPromotionRenderable", 1, "event queue cost too long: " + currentTimeMillis2);
                    }
                }
            }
        }
        this.D.nativeOnDrawFrame(this.E, fArr2, fArr4);
        this.N = true;
        if (this.f197075b0) {
            int i3 = this.f197076c0 + 1;
            this.f197076c0 = i3;
            if (i3 >= 1) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ARTransferPromotionRenderable.this.R != null && ARTransferPromotionRenderable.this.H == 6) {
                            ARTransferPromotionRenderable.this.R.c(ARTransferPromotionRenderable.this.C.f197268o + "doorOpen.mp3", false);
                        }
                    }
                });
                this.V.v(true);
                ARTransferDoorLogicManager aRTransferDoorLogicManager = this.V;
                Objects.requireNonNull(aRTransferDoorLogicManager);
                aRTransferDoorLogicManager.l(6);
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.10
                    @Override // java.lang.Runnable
                    public void run() {
                        ReportController.o(null, "dc00898", "", "", "0X80098CD", "0X80098CD", 0, 0, ARTransferPromotionRenderable.this.C.f197225a, "", "", "");
                    }
                });
                this.f197075b0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(Runnable runnable) {
        synchronized (this.T) {
            this.T.add(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", Integer.valueOf(this.H), Integer.valueOf(i3)));
        }
        this.H = i3;
        int i16 = this.H;
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 != 6) {
                        if (i16 == 7) {
                            this.D.nativeDestroyCertainEngine(this.E);
                            this.D.setupActionCallback(null);
                            this.E = 0;
                            this.H = 1;
                            return;
                        }
                        return;
                    }
                    this.f197085m.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARTransferPromotionRenderable.this.H == 6) {
                                if (ARTransferPromotionRenderable.this.f197085m != null && !ARTransferPromotionRenderable.this.C.f197262i.booleanValue()) {
                                    ARTransferPromotionRenderable.this.f197085m.h(0, 1);
                                }
                                if ((ARTransferPromotionRenderable.this.V.p() == 0 || !ARTransferPromotionRenderable.this.M) && !ARTransferPromotionRenderable.this.C.f197262i.booleanValue()) {
                                    ARTransferPromotionRenderable.this.m();
                                } else if (!ARTransferPromotionRenderable.this.C.f197262i.booleanValue()) {
                                    ARTransferPromotionRenderable.this.V.l(1);
                                }
                                if (ARTransferPromotionRenderable.this.R == null) {
                                    ARTransferPromotionRenderable.this.R = new ARPromotionSoundPlayer();
                                }
                            }
                        }
                    });
                    if (QLog.isColorLevel()) {
                        QLog.d("ARTransferPromotionRenderable", 2, "enter STATE_ENGINE_DRAW status");
                        return;
                    }
                    return;
                }
                this.D.nativePause(this.E);
                return;
            }
            this.D.nativeResume(this.E);
            k0(5);
            this.I = 0;
            return;
        }
        ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        int indentification = this.D.getIndentification();
        this.E = indentification;
        Context context = this.f197084i;
        this.D.nativeCreateEngineBusiness(indentification, "test.scene", context, context.getAssets(), this.C.f197267n, this.J, this.K, 88);
        this.D.native_setARWorldCupCallBack(this);
        this.D.setPreLoadTransferDoorFlags();
        this.D.setARCoreSupport(0);
        k0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f197081f;
        if (mqqWeakReferenceHandler != null && !mqqWeakReferenceHandler.hasMessages(1105)) {
            this.f197081f.sendEmptyMessageDelayed(1105, 200L);
        }
        QLog.d("ARTransferPromotionRenderable", 2, "startMediaTimeListener ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f197081f;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(1105);
            this.V.I(false, "");
        }
        QLog.d("ARTransferPromotionRenderable", 2, "stopMediaTimeListener ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3, String str, boolean z16, int i16, boolean z17) {
        boolean z18 = true;
        QLog.d("ARTransferPromotionRenderable", 1, "tryPlayGameVideoAndSwitchStatus  " + i3 + "|" + str);
        File file = new File(str);
        if (TextUtils.isEmpty(str) || (!str.startsWith("http") && !str.startsWith("https"))) {
            z18 = false;
        }
        if (file.exists() || z18) {
            this.f197077d = i3;
            this.S.G(str, 123456L, z16, i16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q0() {
        ARNativeBridge aRNativeBridge = this.D;
        if (aRNativeBridge != null) {
            this.f197079e = aRNativeBridge.native_getNativeGameStatus();
        }
        return this.f197079e;
    }

    static /* bridge */ /* synthetic */ w81.c u(ARTransferPromotionRenderable aRTransferPromotionRenderable) {
        aRTransferPromotionRenderable.getClass();
        return null;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public boolean a() {
        return !this.C.f197262i.booleanValue();
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.a
    public void b(Runnable runnable) {
        c cVar = this.f197085m;
        if (cVar != null) {
            cVar.i(runnable);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
        this.J = i3;
        this.K = i16;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        if (this.H == 6 && this.E != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public void d(final int[] iArr, final int[] iArr2, final int[] iArr3, boolean z16) {
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20
            @Override // java.lang.Runnable
            public void run() {
                ARTransferPromotionRenderable.this.Z += iArr.length;
                QLog.i("ARTransferPromotionRenderable", 1, "insertWorldCupSpark. mInsertedSparkTotalCnt = " + ARTransferPromotionRenderable.this.Z + ", new cnt = " + iArr.length + ", px[0] = " + iArr[0] + ", py[0] = " + iArr2[0] + ", degree[0] = " + iArr3[0] + ", hasDrawedFrame = " + ARTransferPromotionRenderable.this.N);
                if (ARTransferPromotionRenderable.this.D != null && ARTransferPromotionRenderable.this.N) {
                    ARTransferPromotionRenderable.this.D.native_insertWorldCupSpark(iArr, iArr2, iArr3);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public void e(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
            QLog.d("ARTransferPromotionRenderable", 2, "setContainer  success");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public int f(final int i3) {
        if (this.f197079e == i3) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus status " + i3);
        }
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
            /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
            
                if (r0 != 8) goto L27;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + i3);
                int i16 = i3;
                if (i16 != 1 && i16 != 2) {
                    if (i16 != 4) {
                        if (i16 != 6) {
                        }
                    } else if (ARTransferPromotionRenderable.this.f197079e == 3) {
                        if (ARTransferPromotionRenderable.this.D != null) {
                            ARTransferPromotionRenderable.this.D.native_switchGameStatusWithNoParams(i3);
                        }
                    } else {
                        ARTransferPromotionRenderable.this.p0(4, ARTransferPromotionRenderable.this.C.f197268o + "360Video.mp4", false, ARTransferPromotionRenderable.this.C.f197264k, false);
                    }
                    ARTransferPromotionRenderable.this.q0();
                }
                if (i16 == 1 && ARTransferPromotionRenderable.this.f197085m != null && ARTransferPromotionRenderable.this.C.f197262i.booleanValue()) {
                    ARTransferPromotionRenderable.this.f197085m.h(0, 1);
                }
                if (ARTransferPromotionRenderable.this.D != null) {
                    ARTransferPromotionRenderable.this.D.native_switchGameStatusWithNoParams(i3);
                }
                ARTransferPromotionRenderable.this.q0();
            }
        });
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        return this.C.f197228d;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public int getGameStatus() {
        if (this.H != 6) {
            return 0;
        }
        return this.f197079e;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        return this.C.f197226b;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.C.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public void h(final int i3, final int i16, final int i17, final int i18) {
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19
            @Override // java.lang.Runnable
            public void run() {
                ARTransferPromotionRenderable.this.Z = 0;
                QLog.i("ARTransferPromotionRenderable", 1, "setRecogRes. mInsertedSparkTotalCnt = 0, sparkShaderVertFileName = , circleR = " + i3 + ", circleX = " + i16 + ", circleY = " + i17 + ", clockwise = " + i18 + ", hasDrawedFrame = " + ARTransferPromotionRenderable.this.N);
                if (ARTransferPromotionRenderable.this.D != null && ARTransferPromotionRenderable.this.N) {
                    ARTransferPromotionRenderable.this.D.native_setRecogRes("", "", "", "", "", i3, i16, i17, i18);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1105) {
            ARPromotionMediaPlayerWrapper aRPromotionMediaPlayerWrapper = this.S;
            if (aRPromotionMediaPlayerWrapper != null && aRPromotionMediaPlayerWrapper.E() && this.P != null) {
                d.a a16 = this.P.a(this.S.B());
                if (a16 == null) {
                    this.V.I(false, "");
                } else {
                    this.V.I(true, a16.f196888c);
                }
            }
            this.f197081f.sendEmptyMessageDelayed(1105, 200L);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public void i() {
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("ARTransferPromotionRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + ARTransferPromotionRenderable.this.N);
                if (ARTransferPromotionRenderable.this.D != null && ARTransferPromotionRenderable.this.N) {
                    ARTransferPromotionRenderable.this.D.native_zoomOutWorldCupSparks();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void init() {
        QLog.d("ARTransferPromotionRenderable", 2, "init test start +" + this);
        this.f197083h = Thread.currentThread().getId();
        this.V.m(this);
        if (!this.C.f197262i.booleanValue()) {
            this.V.C();
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.G;
        if (aVar != null && this.F) {
            QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState start sensor result=%s", Boolean.valueOf(aVar.e(this.Y))));
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.a
    public void j(final int i3, final int i16, final int i17) {
        QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange mCurrentPrePareChangeStatus " + this.f197077d + "|" + i3 + "|" + this.f197079e + "|status" + i16);
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14
            @Override // java.lang.Runnable
            public void run() {
                int i18;
                if (i3 == 1) {
                    int i19 = i16;
                    boolean z16 = false;
                    if (i19 == 0) {
                        int i26 = ARTransferPromotionRenderable.this.f197077d;
                        ARTransferPromotionRenderable.this.f197077d = 0;
                        if (i26 == 2 || i26 == 3 || i26 == 4 || i26 == 7) {
                            if (ARTransferPromotionRenderable.this.D != null) {
                                QLog.d("ARTransferPromotionRenderable", 2, "native_switchGameStatusWithVideoId status " + i16);
                                ARTransferPromotionRenderable.this.D.native_switchGameStatusWithVideoId(i26, i17);
                            }
                            if (i26 == 7) {
                                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ReportController.o(null, "dc00898", "", "", "0X80098D0", "0X80098D0", 0, 0, ARTransferPromotionRenderable.this.C.f197225a, "", "", "");
                                    }
                                });
                                QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_USER_DETERMINE_STATUS real start here");
                                return;
                            } else if (i26 == 3) {
                                QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_TRAVERSING_DOOR");
                                ARTransferPromotionRenderable.this.f197075b0 = true;
                                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ARTransferPromotionRenderable aRTransferPromotionRenderable = ARTransferPromotionRenderable.this;
                                        if (aRTransferPromotionRenderable.f197081f != null && aRTransferPromotionRenderable.S != null && ARTransferPromotionRenderable.this.S.E()) {
                                            long B = ARTransferPromotionRenderable.this.S.B();
                                            ARTransferPromotionRenderable.u(ARTransferPromotionRenderable.this);
                                            QLog.d("ARTransferPromotionRenderable", 2, "start Post  mRepeatCheckRunnable " + B);
                                        }
                                    }
                                });
                            }
                        }
                        ARTransferPromotionRenderable.this.q0();
                        return;
                    }
                    if (i19 == 1) {
                        ARTransferPromotionRenderable.this.q0();
                        int i27 = ARTransferPromotionRenderable.this.f197079e;
                        QLog.d("ARTransferPromotionRenderable", 2, "ARPromotionMediaPlayerWrapper.PLAYER_STATUS_END status " + ARTransferPromotionRenderable.this.f197079e);
                        if (i27 != 2 && i27 != 7 && i27 != 4) {
                            if (i27 == 5) {
                                QLog.d("ARTransferPromotionRenderable", 1, "GameStatus_OUTSIDE_WORLD_360 error happen, not have this status");
                                return;
                            }
                            return;
                        }
                        if (i17 == 0 || i27 != 7) {
                            ARTransferPromotionRenderable.this.n0();
                            if (i17 == 0 && i27 == 7 && !NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                                ARRecordUtils.h(HardCodeUtil.qqStr(R.string.jrp), false);
                                QLog.d("ARTransferPromotionRenderable", 2, "net work is so terrible ,we have to stop it");
                                return;
                            }
                            if (ARTransferPromotionRenderable.this.f197079e == 4 && ARTransferPromotionRenderable.this.C.f197265l == 2) {
                                if (ARTransferPromotionRenderable.this.f197085m != null) {
                                    ARTransferPromotionRenderable.this.f197085m.h(2, 0);
                                    return;
                                }
                                return;
                            }
                            if (ARTransferPromotionRenderable.this.f197079e == 4 && ARTransferPromotionRenderable.this.C.f197265l == 1) {
                                ARTransferPromotionRenderable.this.C.f197265l = 0;
                            }
                            if (ARTransferPromotionRenderable.this.f197079e == 4 && ARTransferPromotionRenderable.this.C.f197265l == 0) {
                                if (ARTransferPromotionRenderable.this.C.f197266m.isEmpty()) {
                                    if (ARTransferPromotionRenderable.this.f197085m != null) {
                                        ARTransferPromotionRenderable.this.f197085m.h(2, 0);
                                        return;
                                    }
                                    return;
                                }
                                if (ARTransferPromotionRenderable.this.C.e(1)) {
                                    ARTransferPromotionRenderable.this.V.v(true);
                                    return;
                                }
                                if (ARTransferPromotionRenderable.this.C.e(2)) {
                                    ARTransferPromotionRenderable aRTransferPromotionRenderable = ARTransferPromotionRenderable.this;
                                    aRTransferPromotionRenderable.Q = aRTransferPromotionRenderable.C.d();
                                } else if (ARTransferPromotionRenderable.this.C.e(3)) {
                                    ARTransferPromotionRenderable aRTransferPromotionRenderable2 = ARTransferPromotionRenderable.this;
                                    aRTransferPromotionRenderable2.Q = aRTransferPromotionRenderable2.C.c();
                                }
                                if (ARTransferPromotionRenderable.this.Q == null) {
                                    QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 error hapen mFixFullScreenVideoUrl is null");
                                    return;
                                }
                                QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 with auto play:" + ARTransferPromotionRenderable.this.Q);
                            }
                            if (ARTransferPromotionRenderable.this.f197079e != 5) {
                                if (ARTransferPromotionRenderable.this.f197079e == 4) {
                                    z16 = true;
                                }
                                if (z16) {
                                    i18 = i27 + 2;
                                } else {
                                    i18 = i27 + 1;
                                }
                                if (i18 > 0 && i18 < 14) {
                                    ARTransferPromotionRenderable.this.f(i18);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (ARTransferPromotionRenderable.this.f197085m != null) {
                            ARTransferPromotionRenderable.this.f197085m.h(2, i17);
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public String k() {
        return this.C.f197268o;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        i0((float[]) aVar.a("TARGET_SIZE"), (float[]) aVar.a("POSE"), (float[]) aVar.a("CAMERA_MATRIX"), (float[]) aVar.a("CAMERA_POSITION"), aVar.f197261b);
    }

    public void l0() {
        QLog.d("ARTransferPromotionRenderable", 2, "startCameraAniamtion ");
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.18
            @Override // java.lang.Runnable
            public void run() {
                if (ARTransferPromotionRenderable.this.D != null && ARTransferPromotionRenderable.this.f197079e <= 4) {
                    ARTransferPromotionRenderable.this.D.native_startTranversalAnimation();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public void m() {
        if (QLog.isColorLevel()) {
            QLog.d("ARTransferPromotionRenderable", 2, "directlyEnterTransferDoor");
        }
        this.V.E();
        this.V.I(false, "");
        ReportController.o(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, this.C.f197225a, "0", "0", "");
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.12
            @Override // java.lang.Runnable
            public void run() {
                if (!ARTransferPromotionRenderable.this.C.f197262i.booleanValue()) {
                    ARTransferPromotionRenderable.this.p0(3, ARTransferPromotionRenderable.this.C.f197268o + "360Video.mp4", false, ARTransferPromotionRenderable.this.C.f197264k, false);
                    ARTransferPromotionRenderable.this.S.J(true);
                    ARTransferPromotionRenderable.this.o0();
                    ARTransferPromotionRenderable.this.h0();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public boolean n() {
        if (this.H == 6 && this.E != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARNativeBridge.ARWorldCupCallback
    public void nativeCallBack(final int i3, int i16, int i17) {
        QLog.d("ARTransferPromotionRenderable", 1, "nativeCallBack  " + i3 + "|" + i16);
        j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16
            @Override // java.lang.Runnable
            public void run() {
                int i18 = i3;
                if (i18 == 2) {
                    ARTransferPromotionRenderable.this.q0();
                    if (ARTransferPromotionRenderable.this.f197077d == 0 && ARTransferPromotionRenderable.this.f197079e == 2) {
                        ARTransferPromotionRenderable.this.p0(3, ARTransferPromotionRenderable.this.C.f197268o + "360Video.mp4", false, ARTransferPromotionRenderable.this.C.f197264k, false);
                        ARTransferPromotionRenderable.this.S.J(true);
                        ARTransferPromotionRenderable.this.o0();
                        ARTransferPromotionRenderable.this.h0();
                        return;
                    }
                    return;
                }
                if (i18 != 3) {
                    if (i18 != 4) {
                        if (i18 != 5) {
                            if (i18 != 6) {
                                if (i18 != 8) {
                                    if (i18 == 1000) {
                                        ARTransferPromotionRenderable.this.S.J(false);
                                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                ARTransferPromotionRenderable.this.V.v(false);
                                                ReportController.o(null, "dc00898", "", "", "0X80098CE", "0X80098CE", 0, 0, ARTransferPromotionRenderable.this.C.f197225a, "", "", "");
                                            }
                                        });
                                        ARTransferPromotionRenderable.this.f197078d0 = true;
                                        return;
                                    }
                                    return;
                                }
                                ARTransferPromotionRenderable.this.S.L();
                                if (ARTransferPromotionRenderable.this.f197085m != null) {
                                    ARTransferPromotionRenderable.this.f197085m.h(2, 0);
                                }
                                QLog.d("ARTransferPromotionRenderable", 2, "ad play end here");
                                return;
                            }
                            ARTransferPromotionRenderable.this.S.L();
                            if (ARTransferPromotionRenderable.this.F) {
                                ARTransferPromotionRenderable.this.G.g();
                            }
                            ARTransferPromotionRenderable.u(ARTransferPromotionRenderable.this);
                            if (ARTransferPromotionRenderable.this.X != -1) {
                                ARTransferPromotionRenderable.this.W.stopPreDownload(ARTransferPromotionRenderable.this.X);
                                ARTransferPromotionRenderable.this.X = -1;
                            }
                            ARTransferPromotionRenderable aRTransferPromotionRenderable = ARTransferPromotionRenderable.this;
                            aRTransferPromotionRenderable.p0(7, aRTransferPromotionRenderable.Q.f196880c, false, ARTransferPromotionRenderable.this.Q.f196881d, true);
                            QLog.d("ARTransferPromotionRenderable", 2, "start play 360 over video " + ARTransferPromotionRenderable.this.Q);
                            return;
                        }
                        ARTransferPromotionRenderable.this.S.J(true);
                        ARTransferPromotionRenderable.this.S.K(false);
                        ARTransferPromotionRenderable.this.n0();
                        QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_OUTSIDE_WORLD_360 ready");
                        return;
                    }
                    ARTransferPromotionRenderable aRTransferPromotionRenderable2 = ARTransferPromotionRenderable.this;
                    MqqWeakReferenceHandler mqqWeakReferenceHandler = aRTransferPromotionRenderable2.f197081f;
                    if (mqqWeakReferenceHandler != null) {
                        mqqWeakReferenceHandler.removeCallbacks(aRTransferPromotionRenderable2.U);
                    }
                    ARTransferPromotionRenderable.u(ARTransferPromotionRenderable.this);
                    ARTransferPromotionRenderable.this.f197078d0 = false;
                    return;
                }
                ARTransferPromotionRenderable aRTransferPromotionRenderable3 = ARTransferPromotionRenderable.this;
                MqqWeakReferenceHandler mqqWeakReferenceHandler2 = aRTransferPromotionRenderable3.f197081f;
                if (mqqWeakReferenceHandler2 != null) {
                    mqqWeakReferenceHandler2.removeCallbacks(aRTransferPromotionRenderable3.U);
                }
                if (ARTransferPromotionRenderable.this.D != null) {
                    if (ARTransferPromotionRenderable.this.C.f197263j.booleanValue()) {
                        ARTransferPromotionRenderable.this.S.I();
                        QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: config jumpTo firstFrame");
                    }
                    ARTransferPromotionRenderable.this.m0();
                    ARTransferPromotionRenderable.this.f(4);
                }
                if (ARTransferPromotionRenderable.this.C.f197265l != 0 && ARTransferPromotionRenderable.this.C.f197265l == 1) {
                    ARTransferPromotionRenderable.this.V.v(true);
                }
                QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: m360VideoConnectType " + ARTransferPromotionRenderable.this.C.f197265l);
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        QLog.d("ARTransferPromotionRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", Integer.valueOf(this.H), Boolean.valueOf(this.L)));
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f197081f;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeCallbacks(this.U);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.6
            @Override // java.lang.Runnable
            public void run() {
                if (ARTransferPromotionRenderable.this.R != null) {
                    ARTransferPromotionRenderable.this.R.d();
                    ARTransferPromotionRenderable.this.R = null;
                }
            }
        });
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
            @Override // java.lang.Runnable
            public void run() {
                if (ARTransferPromotionRenderable.this.H == 6) {
                    if (ARTransferPromotionRenderable.this.f197085m != null && ARTransferPromotionRenderable.this.L) {
                        ARTransferPromotionRenderable.this.f197085m.h(1, 0);
                        ARTransferPromotionRenderable.this.L = false;
                    }
                    if (ARTransferPromotionRenderable.this.G != null && ARTransferPromotionRenderable.this.F) {
                        ARTransferPromotionRenderable.this.G.g();
                    }
                    if (ARTransferPromotionRenderable.this.X != -1 && ARTransferPromotionRenderable.this.W != null) {
                        ARTransferPromotionRenderable.this.W.stopPreDownload(ARTransferPromotionRenderable.this.X);
                        ARTransferPromotionRenderable.this.X = -1;
                    }
                    if (ARTransferPromotionRenderable.this.W != null) {
                        ARTransferPromotionRenderable.this.W.destory();
                    }
                    if (ARTransferPromotionRenderable.this.f197085m != null) {
                        ARTransferPromotionRenderable.this.f197085m.f(ARTransferPromotionRenderable.this.C.f197225a);
                    }
                    if (ARTransferPromotionRenderable.this.H == 6) {
                        ARTransferPromotionRenderable.this.k0(7);
                    }
                    ARTransferPromotionRenderable.this.V.G();
                    if (ARTransferPromotionRenderable.this.f197074a0 != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferPromotionRenderable.this.f197074a0.setVisibility(8);
                                ARTransferPromotionRenderable.this.f197074a0 = null;
                            }
                        });
                    }
                    synchronized (ARTransferPromotionRenderable.this.T) {
                        ARTransferPromotionRenderable.this.T.clear();
                    }
                    ARTransferPromotionRenderable.this.S.H();
                    ARTransferPromotionRenderable.this.n0();
                    ARTransferPromotionRenderable.u(ARTransferPromotionRenderable.this);
                }
            }
        };
        if (this.f197083h == Thread.currentThread().getId()) {
            runnable.run();
            QLog.e("ARTransferPromotionRenderable", 1, "onDestroy in GLThread.");
        } else {
            c cVar = this.f197085m;
            if (cVar != null) {
                cVar.i(runnable);
            }
            QLog.e("ARTransferPromotionRenderable", 1, "onDestroy not in GLThread.");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        QLog.d("ARTransferPromotionRenderable", 2, String.format("onTouch mNativeGameStatus=%d", Integer.valueOf(this.f197079e)));
        view.getWidth();
        new PointF(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() == 0) {
            if (this.f197079e == 3) {
                l0();
                view.setVisibility(8);
                QLog.d("ARTransferPromotionRenderable", 2, "start cameraAnimation here");
            } else if (this.f197079e == 4) {
                if (this.f197082f0) {
                    QLog.d("ARTransferPromotionRenderable", 2, "onTouch event not deal ready");
                    return false;
                }
                this.f197082f0 = true;
                c cVar = this.f197085m;
                if (cVar != null && this.D != null) {
                    cVar.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
                        @Override // java.lang.Runnable
                        public void run() {
                            final float rotateDegree = ARTransferPromotionRenderable.this.D.getRotateDegree();
                            boolean isEmpty = ARTransferPromotionRenderable.this.C.f197266m.isEmpty();
                            ARTransferPromotionRenderable.this.q0();
                            if (ARTransferPromotionRenderable.this.f197079e != 4) {
                                QLog.d("ARTransferPromotionRenderable", 1, "not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:" + ARTransferPromotionRenderable.this.f197079e);
                                ARTransferPromotionRenderable.this.f197082f0 = false;
                                return;
                            }
                            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ReportController.o(null, "dc00898", "", "", "0X80098CF", "0X80098CF", 0, 0, ARTransferPromotionRenderable.this.C.f197225a, Integer.toString((int) rotateDegree), "", "");
                                }
                            });
                            if (isEmpty) {
                                if (ARTransferPromotionRenderable.this.f197085m != null) {
                                    ARTransferPromotionRenderable.this.f197085m.h(2, 0);
                                    return;
                                }
                                return;
                            }
                            c.a b16 = ARTransferPromotionRenderable.this.C.b((int) rotateDegree);
                            if (b16 == null || TextUtils.isEmpty(b16.f196880c)) {
                                ARTransferPromotionRenderable.this.f197082f0 = false;
                                QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree " + rotateDegree);
                                return;
                            }
                            if (ARTransferPromotionRenderable.this.H != 6) {
                                return;
                            }
                            if (ARTransferPromotionRenderable.this.S.E()) {
                                ARTransferPromotionRenderable.this.S.L();
                            }
                            ARTransferPromotionRenderable.this.Q = b16;
                            ARTransferPromotionRenderable.this.j0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ARTransferPromotionRenderable.this.f(6);
                                }
                            });
                            ARTransferPromotionRenderable.this.n0();
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    view.setVisibility(8);
                                    ARTransferPromotionRenderable.this.f197082f0 = false;
                                }
                            });
                            QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:" + rotateDegree);
                        }
                    });
                }
                QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER click operation");
            } else {
                QLog.d("ARTransferPromotionRenderable", 1, "onTouch doNothing");
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
        if (this.H == 5) {
            int i3 = this.I + 1;
            this.I = i3;
            if (i3 >= 2) {
                k0(6);
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public boolean p() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.a
    public String q() {
        return this.C.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        QLog.d("ARTransferPromotionRenderable", 2, "start from this cluase second");
        if (1 == this.H) {
            k0(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
    }
}
