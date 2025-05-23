package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Interactive3DRenderable implements a, ARNativeBridge.ActionCallback {
    private int C;
    private int E;
    private int F;
    private com.tencent.mobileqq.ar.e G;
    private String[] H;
    private String I;
    private int J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private Context f197148d;

    /* renamed from: f, reason: collision with root package name */
    private n f197150f;

    /* renamed from: h, reason: collision with root package name */
    private c f197151h;

    /* renamed from: i, reason: collision with root package name */
    private GLSurfaceView f197152i;

    /* renamed from: m, reason: collision with root package name */
    private ARNativeBridge f197153m;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f197149e = 1;
    private volatile int D = 1;
    boolean L = false;
    private long M = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            Interactive3DRenderable interactive3DRenderable = this.this$0;
            interactive3DRenderable.L = true;
            interactive3DRenderable.onDestroy();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197156d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f197157e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f197158f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197159h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchBegin(this.f197156d, this.f197157e, this.f197158f, 5, this.f197159h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_POINTER_DOWN native_onTouchBegin");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$4, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f197161e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f197162f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197163h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchBegin(this.f197160d, this.f197161e, this.f197162f, 0, this.f197163h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_DOWN native_onTouchBegin");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$5, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f197164d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f197165e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float[] f197166f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197167h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchMove(this.f197164d, this.f197165e, this.f197166f, this.f197167h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_MOVE native_onTouchMove");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$6, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197168d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f197169e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f197170f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197171h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchEnd(this.f197168d, this.f197169e, this.f197170f, 6, this.f197171h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_POINTER_UP native_onTouchEnd");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$7, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f197173e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f197174f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197175h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchEnd(this.f197172d, this.f197173e, this.f197174f, 1, this.f197175h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_UP native_onTouchEnd");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$8, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f197176d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f197177e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float[] f197178f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f197179h;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_onTouchCancel(this.f197176d, this.f197177e, this.f197178f, this.f197179h, this.this$0.f197153m.mCurrentActiveId);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_CANCEL native_onTouchCancel");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable$9, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass9 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f197180d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f197181e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f197182f;
        final /* synthetic */ Interactive3DRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f197153m.native_setBinHaiState(BaseActivity.sTopActivity, this.this$0.f197153m, this.f197180d, this.f197181e, this.f197182f);
        }
    }

    public Interactive3DRenderable(c cVar, n nVar, GLSurfaceView gLSurfaceView) {
        this.f197151h = cVar;
        this.f197150f = nVar;
        this.f197152i = gLSurfaceView;
        this.f197148d = cVar.d();
        this.f197153m = (ARNativeBridge) this.f197151h.e(0);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
        this.E = i3;
        this.F = i16;
    }

    @Override // com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback
    public void callback(int i3, String str, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "fNativeDoActionCallback action=" + i3 + ", params=" + str + ", callbackId=" + i16 + ", result=" + str2);
        }
        c cVar = this.f197151h;
        if (cVar == null) {
            return;
        }
        if (i3 != 100) {
            switch (i3) {
                case 56:
                    i("res/music/fudai_appear.mp3");
                    h("res/music/fudai_background.mp3");
                    return;
                case 57:
                    return;
                case 58:
                    if (System.currentTimeMillis() - this.M < 300) {
                        return;
                    }
                    this.M = System.currentTimeMillis();
                    i("res/music/fudai_click.mp3");
                    return;
                case 59:
                    i("res/music/fudai_explode.mp3");
                    return;
                default:
                    switch (i3) {
                        case 61:
                            h("res/music/gameing_background.mp3");
                            return;
                        case 62:
                            i("res/music/redpack_get.mp3");
                            return;
                        case 63:
                            i("res/music/aimed.mp3");
                            return;
                        case 64:
                            h("res/music/gameend_background.mp3");
                            return;
                        default:
                            cVar.m(this, this.f197150f.f197315i, i3, 0, str2);
                            return;
                    }
            }
        }
        this.K++;
        this.J += i16;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        if (this.f197149e == 9 && this.C != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        return 1;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        return this.f197150f.f197315i.f197702i;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.f197150f.f197225a;
    }

    public void h(final String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "playBgMusic, " + str);
        }
        this.f197152i.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.11
            @Override // java.lang.Runnable
            public void run() {
                if (Interactive3DRenderable.this.G != null && !TextUtils.isEmpty(str)) {
                    Interactive3DRenderable.this.G.l(Interactive3DRenderable.this.I + str, true, true);
                }
            }
        });
    }

    public void i(final String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "playEffectMusic, " + str);
        }
        this.f197152i.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.10
            @Override // java.lang.Runnable
            public void run() {
                if (Interactive3DRenderable.this.G != null && !TextUtils.isEmpty(str)) {
                    Interactive3DRenderable.this.G.n(Interactive3DRenderable.this.I + str, true);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void init() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "init");
        }
    }

    public void j(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "setNativeState, mCurState=" + this.f197149e + ", new State=" + i3);
        }
        this.f197149e = i3;
        if (i3 != 2) {
            switch (i3) {
                case 6:
                    this.f197153m.nativeonSurfaceChanged(this.C, this.E, this.F);
                    return;
                case 7:
                    this.f197153m.nativeResume(this.C);
                    this.D = 0;
                    j(11);
                    return;
                case 8:
                    this.f197153m.nativePause(this.C);
                    return;
                case 9:
                    this.f197151h.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Interactive3DRenderable.this.f197149e != 9) {
                                return;
                            }
                            if (Interactive3DRenderable.this.f197151h != null) {
                                Interactive3DRenderable.this.f197151h.h(0, 2);
                            }
                            if (Interactive3DRenderable.this.G != null) {
                                Interactive3DRenderable.this.G.m(true);
                            }
                        }
                    });
                    return;
                case 10:
                    this.f197153m.nativeDestroyCertainEngine(this.C);
                    this.f197153m.setupActionCallback(null);
                    this.C = 0;
                    com.tencent.mobileqq.ar.e eVar = this.G;
                    if (eVar != null) {
                        eVar.o();
                        this.G.j();
                    }
                    this.f197149e = 1;
                    return;
                default:
                    return;
            }
        }
        ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        int indentification = this.f197153m.getIndentification();
        this.C = indentification;
        String str = this.f197150f.f197316j;
        Context context = this.f197148d;
        this.f197153m.nativeCreateEngineBusiness(indentification, str, context, context.getAssets(), this.f197150f.f197317k, this.E, this.F, 100);
        this.f197153m.setupActionCallback(this);
        j(7);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        this.f197153m.nativeOnDrawFrame(this.C, aVar.f197261b, (float[]) aVar.a("CAMERA_POSITION"));
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        return true;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, " + this);
        }
        if (this.f197149e == 9) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, queueEvent, " + this);
            }
            c cVar = this.f197151h;
            if (cVar != null && this.L) {
                cVar.h(1, 0);
                this.L = false;
            }
            c cVar2 = this.f197151h;
            if (cVar2 != null) {
                cVar2.f(this.f197150f.f197225a);
                QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
                this.f197151h.m(this, this.f197150f.f197315i, 101, 0, null);
            }
            if (this.f197149e == 9) {
                j(10);
            }
        }
        int i3 = this.K;
        if (i3 > 0) {
            float f16 = (this.J * 1.0f) / i3;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("fps_total", String.valueOf(this.J));
            hashMap.put("fps_count", String.valueOf(this.K));
            hashMap.put("fps_avg", String.format(Locale.getDefault(), "%.1f", Float.valueOf(f16)));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseActivity.sTopActivity.getCurrentAccountUin(), "binhai_fps", true, 0L, 0L, hashMap, "", false);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
        if (this.f197149e == 11) {
            int i3 = this.D + 1;
            this.D = i3;
            if (i3 >= 2) {
                j(9);
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_Interactive3DRenderable", 2, "start");
        }
        if (1 == this.f197149e) {
            String str = this.f197150f.f197317k;
            this.I = str;
            String[] strArr = new String[8];
            this.H = strArr;
            strArr[0] = str + "res/music/loading.mp3";
            this.H[1] = str + "res/music/321ready.mp3";
            this.H[2] = str + "res/music/redpack_open.mp3";
            this.H[3] = str + "res/music/fudai_click.mp3";
            this.H[4] = str + "res/music/fudai_explode.mp3";
            this.H[5] = str + "res/music/fudai_appear.mp3";
            this.H[6] = str + "res/music/redpack_get.mp3";
            this.H[7] = str + "res/music/aimed.mp3";
            this.G = new com.tencent.mobileqq.ar.e(1, this.H);
            j(2);
            this.K = 0;
            this.J = 0;
        }
        c cVar = this.f197151h;
        if (cVar != null) {
            cVar.m(this, this.f197150f.f197315i, 100, 0, null);
        }
    }
}
