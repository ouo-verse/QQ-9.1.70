package com.tencent.aelight.camera.ae.flashshow.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import common.config.service.QzoneConfig;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFlashCameraCaptureButtonLayout extends AbsLSCaptureButton {
    private LSCameraGLSurfaceView C;
    private ImageView D;
    protected ValueAnimator E;
    protected ValueAnimator F;
    private long G;
    private long H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    boolean M;
    protected boolean N;
    protected a.InterfaceC0557a P;
    protected float Q;
    protected int R;
    ScaleAnimation S;
    ScaleAnimation T;
    ScaleAnimation U;
    ScaleAnimation V;
    private AbsLSCaptureButton.a W;

    /* renamed from: a0, reason: collision with root package name */
    protected long f64412a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f64413b0;

    /* renamed from: c0, reason: collision with root package name */
    private j f64414c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f64415d;

    /* renamed from: d0, reason: collision with root package name */
    protected AtomicBoolean f64416d0;

    /* renamed from: e, reason: collision with root package name */
    private int f64417e;

    /* renamed from: e0, reason: collision with root package name */
    protected AtomicBoolean f64418e0;

    /* renamed from: f, reason: collision with root package name */
    private int f64419f;

    /* renamed from: f0, reason: collision with root package name */
    private View.OnTouchListener f64420f0;

    /* renamed from: g0, reason: collision with root package name */
    protected Handler f64421g0;

    /* renamed from: h, reason: collision with root package name */
    private View f64422h;

    /* renamed from: i, reason: collision with root package name */
    private AnimationFlashProgress f64423i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f64424m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum Style {
        VIDEO_STYLE,
        PIC_STYLE
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return AEFlashCameraCaptureButtonLayout.this.r(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AEFlashCameraCaptureButtonLayout.this.q(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AEFlashCameraCaptureButtonLayout.this.E(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ms.a.f("AEFlashCameraCaptureButtonLayout", "scaleAnimator cancel!");
            AEFlashCameraCaptureButtonLayout.this.f64418e0.set(true);
            AEFlashCameraCaptureButtonLayout.this.f64424m.setVisibility(8);
            AEFlashCameraCaptureButtonLayout.this.v();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ms.a.f("AEFlashCameraCaptureButtonLayout", "scaleAnimator end, shortVideoShot:" + AEFlashCameraCaptureButtonLayout.this.f64416d0.get() + ", mActionUpAnimator:" + AEFlashCameraCaptureButtonLayout.this.f64418e0.get());
            if (!AEFlashCameraCaptureButtonLayout.this.f64418e0.get()) {
                AEFlashCameraCaptureButtonLayout.this.f64416d0.set(true);
                AEFlashCameraCaptureButtonLayout.this.f64421g0.sendEmptyMessage(2);
                AEFlashCameraCaptureButtonLayout.this.f64412a0 = System.currentTimeMillis();
                AEFlashCameraCaptureButtonLayout.this.f64421g0.sendEmptyMessage(5);
                return;
            }
            AEFlashCameraCaptureButtonLayout.this.D();
            AEFlashCameraCaptureButtonLayout.this.E(1.0f);
            if (AEFlashCameraCaptureButtonLayout.this.C != null) {
                AEFlashCameraCaptureButtonLayout.this.C.onCaptureError(102);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ms.a.f("AEFlashCameraCaptureButtonLayout", "scaleAnimator start!");
            AEFlashCameraCaptureButtonLayout.this.f64421g0.sendEmptyMessage(9);
            AEFlashCameraCaptureButtonLayout.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AEFlashCameraCaptureButtonLayout.this.f64423i.setCenterScaleValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h extends AccessibilityDelegateCompat {
        h() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            AEFlashCameraCaptureButtonLayout aEFlashCameraCaptureButtonLayout = AEFlashCameraCaptureButtonLayout.this;
            if (aEFlashCameraCaptureButtonLayout.f64415d == 2) {
                string = aEFlashCameraCaptureButtonLayout.getContext().getString(R.string.y1e);
            } else if (aEFlashCameraCaptureButtonLayout.f64424m.getVisibility() == 0) {
                string = AEFlashCameraCaptureButtonLayout.this.getContext().getString(R.string.y1g, Integer.valueOf(AEFlashCameraCaptureButtonLayout.this.f64413b0));
            } else {
                string = AEFlashCameraCaptureButtonLayout.this.getContext().getString(R.string.y1f);
            }
            accessibilityNodeInfoCompat.setText(string);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static /* synthetic */ class i {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f64433a;

        static {
            int[] iArr = new int[Style.values().length];
            f64433a = iArr;
            try {
                iArr[Style.PIC_STYLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64433a[Style.VIDEO_STYLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface j {
        void a();
    }

    public AEFlashCameraCaptureButtonLayout(Context context) {
        super(context);
        this.f64415d = 1;
        this.E = null;
        this.F = null;
        this.G = 0L;
        this.H = 0L;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.Q = 30000.0f;
        this.R = 30;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.f64412a0 = 0L;
        this.f64413b0 = 0;
        this.f64416d0 = new AtomicBoolean(false);
        this.f64418e0 = new AtomicBoolean(false);
        this.f64420f0 = new a();
        this.f64421g0 = new b(Looper.getMainLooper());
        s();
    }

    private void k() {
        ViewCompat.setImportantForAccessibility(this.f64422h, 1);
        ViewCompat.setAccessibilityDelegate(this.f64422h, new h());
    }

    private void l() {
        ScaleAnimation scaleAnimation = this.U;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        ScaleAnimation scaleAnimation2 = this.T;
        if (scaleAnimation2 != null) {
            scaleAnimation2.cancel();
        }
        ScaleAnimation scaleAnimation3 = this.S;
        if (scaleAnimation3 != null) {
            scaleAnimation3.cancel();
        }
        ScaleAnimation scaleAnimation4 = this.V;
        if (scaleAnimation4 != null) {
            scaleAnimation4.cancel();
        }
    }

    private void m() {
        int i3 = this.f64415d;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            ms.a.a("AEFlashCameraCaptureButtonLayout", "checkStartCapture: isStarting = " + this.K + " | shortVideoShot = " + this.f64416d0.get() + " | countDownEnable = " + this.N);
            boolean z16 = this.K;
            if (z16) {
                B();
            } else {
                if (z16) {
                    return;
                }
                if (this.N) {
                    A();
                } else {
                    z();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ms.a.a("AEFlashCameraCaptureButtonLayout", "makeForegroundBtnGoneAnimation");
        if (this.D != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, this.D.getWidth() / 2.0f, (this.D.getHeight() / 2.0f) + 50.0f);
            this.U = scaleAnimation;
            scaleAnimation.setDuration(400L);
            this.U.setFillAfter(true);
            this.U.setAnimationListener(new g());
            this.D.startAnimation(this.U);
        }
    }

    private void u() {
        if (this.f64416d0.get()) {
            AbsLSCaptureButton.a aVar = this.W;
            if (aVar != null) {
                aVar.a();
            }
            this.f64416d0.set(false);
            this.f64418e0.set(false);
            x();
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ms.a.a("AEFlashCameraCaptureButtonLayout", "recoverImageAnimation");
        if (this.D == null) {
            return;
        }
        ScaleAnimation scaleAnimation = this.V;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        ScaleAnimation scaleAnimation2 = this.U;
        if (scaleAnimation2 != null) {
            scaleAnimation2.cancel();
        }
        this.D.bringToFront();
        this.D.setVisibility(0);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, (this.D.getWidth() / 2.0f) + 17.0f, (this.D.getHeight() / 2.0f) + 17.0f);
        this.V = scaleAnimation3;
        scaleAnimation3.setFillAfter(true);
        this.D.startAnimation(this.V);
    }

    public void A() {
        a.InterfaceC0557a interfaceC0557a = this.P;
        if (interfaceC0557a != null) {
            interfaceC0557a.a();
        }
    }

    public void C(boolean z16) {
        ms.a.a("AEFlashCameraCaptureButtonLayout", "stopCapture: \u7ed3\u675f\u62cd\u6444 | shortVideoShot = " + this.f64416d0.get() + " | mActionUpAnimator = " + this.f64418e0.get());
        if (!this.K) {
            ms.a.f("AEFlashCameraCaptureButtonLayout", "stop failed because is not start");
            return;
        }
        int i3 = this.f64415d;
        if (i3 != 1) {
            if (i3 == 2) {
                this.f64421g0.sendEmptyMessage(4);
                this.K = false;
                this.f64423i.changeMode(0);
                return;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    if (this.f64416d0.get()) {
                        ms.a.a("AEFlashCameraCaptureButtonLayout", "in stop capture 1");
                        this.f64418e0.set(true);
                        this.f64421g0.removeMessages(5);
                        D();
                        this.f64421g0.sendEmptyMessage(3);
                        this.K = false;
                        this.f64423i.changeMode(0);
                        return;
                    }
                    ms.a.a("AEFlashCameraCaptureButtonLayout", "in stop capture 2 " + this.K);
                    return;
                }
                if (i3 != 5) {
                    return;
                }
            }
        }
        this.f64418e0.set(true);
        this.f64421g0.removeMessages(5);
        D();
        this.f64421g0.removeMessages(1);
        int i16 = this.f64415d;
        if (i16 == 1) {
            this.f64421g0.sendEmptyMessage(4);
        } else if (i16 == 3) {
            if (z16) {
                u();
            } else {
                this.f64421g0.sendEmptyMessage(3);
            }
        }
        this.K = false;
        this.f64423i.changeMode(0);
    }

    protected void D() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.F;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    protected void E(float f16) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64422h.getLayoutParams();
        int i3 = this.f64417e;
        layoutParams.width = (int) (i3 * f16);
        layoutParams.height = (int) (i3 * f16);
        layoutParams.addRule(13);
        this.f64422h.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f64423i.getLayoutParams();
        int i16 = this.f64419f;
        layoutParams2.width = (int) (i16 * f16);
        layoutParams2.height = (int) (i16 * f16);
        layoutParams2.addRule(13);
        this.f64423i.setLayoutParams(layoutParams2);
    }

    protected void F() {
        int i3;
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.f64412a0;
        float f16 = (float) currentTimeMillis;
        float f17 = this.Q;
        boolean z16 = f16 >= f17;
        this.I = z16;
        if (z16) {
            i3 = QIMCircleProgress.MAX_PROGRESS;
        } else {
            i3 = (int) ((f16 / f17) * QIMCircleProgress.MAX_PROGRESS);
        }
        int i16 = ((int) currentTimeMillis) / 1000;
        this.f64413b0 = i16;
        if (i16 < 10) {
            str = "00:0" + this.f64413b0;
        } else {
            str = "00:" + this.f64413b0;
        }
        this.f64424m.setText(str);
        this.f64423i.setProgress(i3);
        ms.a.h();
        if (this.I) {
            B();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a
    public void a() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64424m.getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(158.0f, this.f64424m.getResources());
        this.f64424m.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a
    public View b() {
        return null;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a
    public boolean c() {
        return this.f64423i.getMode() != 0;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a
    public void d(AbsLSCaptureButton.a aVar, int i3, GLSurfaceView gLSurfaceView) {
        this.C = (LSCameraGLSurfaceView) gLSurfaceView;
        if (aVar instanceof AbsLSCaptureButton.a) {
            this.W = aVar;
        }
    }

    public void o(boolean z16, a.InterfaceC0557a interfaceC0557a) {
        this.N = z16;
        this.P = interfaceC0557a;
    }

    public View p() {
        return this.f64422h;
    }

    protected void q(Message message) {
        ms.a.f("AEFlashCameraCaptureButtonLayout", "handleMessage what:" + message.what + ", shortVideoShot:" + this.f64416d0.get());
        int i3 = message.what;
        if (i3 != 9) {
            switch (i3) {
                case 1:
                    y();
                    return;
                case 2:
                    this.f64424m.setVisibility(0);
                    AbsLSCaptureButton.a aVar = this.W;
                    if (aVar != null) {
                        aVar.h();
                        return;
                    }
                    return;
                case 3:
                    u();
                    return;
                case 4:
                    AbsLSCaptureButton.a aVar2 = this.W;
                    if (aVar2 != null) {
                        aVar2.g();
                    }
                    x();
                    return;
                case 5:
                    if (this.f64416d0.get()) {
                        F();
                        this.f64421g0.sendEmptyMessageDelayed(5, 50L);
                        return;
                    }
                    return;
                case 6:
                    w();
                    break;
                default:
                    return;
            }
        }
        AbsLSCaptureButton.a aVar3 = this.W;
        if (aVar3 != null) {
            aVar3.d();
        }
        this.f64423i.setVisibility(0);
    }

    protected boolean r(View view, MotionEvent motionEvent) {
        ms.a.h();
        if (!this.M) {
            return false;
        }
        if (motionEvent.getAction() != 1) {
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, true, this.f64422h, this.C);
        }
        if (this.I || !this.L) {
            return false;
        }
        if (this.W != null && (motionEvent.getAction() & 255) == 0) {
            if (!this.W.e()) {
                return false;
            }
            this.W.f();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.J) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.G = currentTimeMillis;
            if (currentTimeMillis - this.H < 500 && this.f64415d == 3) {
                return true;
            }
            this.H = currentTimeMillis;
            m();
            return true;
        }
        if (action != 1 && action != 3) {
            return action == 5;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ms.a.a("AEFlashCameraCaptureButtonLayout", "currentStamp" + currentTimeMillis2 + "timeStamp " + this.G);
        if (currentTimeMillis2 - this.G < 500 && this.f64415d == 3) {
            return true;
        }
        B();
        return true;
    }

    protected void s() {
        LayoutInflater.from(getContext()).inflate(R.layout.dlm, (ViewGroup) this, true);
        this.f64417e = BaseAIOUtils.f(53.0f, getResources());
        this.f64419f = BaseAIOUtils.f(80.0f, getResources());
        this.f64423i = (AnimationFlashProgress) findViewById(R.id.rrh);
        findViewById(R.id.rqp);
        this.f64424m = (TextView) findViewById(R.id.rqt);
        this.f64422h = findViewById(R.id.rtz);
        this.D = (ImageView) findViewById(R.id.rpq);
        this.f64422h.setOnTouchListener(this.f64420f0);
        this.f64423i.setCenterView();
        this.D.setImageResource(R.drawable.iw7);
        this.D.setVisibility(0);
        k();
    }

    public void setCaptureBtnStyle(Style style) {
        if (this.D == null) {
            return;
        }
        int i3 = i.f64433a[style.ordinal()];
        if (i3 == 1) {
            this.f64415d = 2;
            this.D.setVisibility(0);
            this.D.setImageResource(R.drawable.iw7);
            this.f64423i.setVisibility(8);
            n();
            invalidate();
            return;
        }
        if (i3 != 2) {
            return;
        }
        this.f64415d = 3;
        this.D.setVisibility(0);
        this.D.setImageResource(R.drawable.iw8);
        this.f64423i.setVisibility(8);
        n();
        invalidate();
    }

    public void setStartCallBack(j jVar) {
        this.f64414c0 = jVar;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton
    public void setTouchEnable(boolean z16) {
        this.M = z16;
    }

    public void w() {
        x();
        this.f64418e0.set(false);
        this.f64416d0.set(false);
        this.f64412a0 = 0L;
        this.I = false;
    }

    public void z() {
        this.f64418e0.set(false);
        ms.a.a("AEFlashCameraCaptureButtonLayout", "startCapture: \u5f00\u59cb\u62cd\u6444");
        j jVar = this.f64414c0;
        if (jVar != null) {
            jVar.a();
        }
        if (this.K) {
            ms.a.f("AEFlashCameraCaptureButtonLayout", "start fail because is started");
            return;
        }
        int i3 = this.f64415d;
        if (i3 == 3 || i3 == 1 || i3 == 4) {
            this.f64421g0.sendEmptyMessageDelayed(1, 100L);
        }
        this.K = true;
        if (this.f64415d == 2) {
            B();
        }
    }

    public void B() {
        C(false);
    }

    @Override // oq.a
    public void onPause() {
        this.J = true;
        l();
        C(true);
    }

    @Override // oq.a
    public void onResume() {
        this.J = false;
        this.K = false;
        w();
    }

    protected void y() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.45f);
        this.E = ofFloat;
        ofFloat.setDuration(400L);
        this.E.addUpdateListener(new d());
        this.E.addListener(new e());
        this.E.start();
        this.f64423i.changeMode(1);
        this.F = ValueAnimator.ofFloat(1.0f, 0.85f);
        this.f64423i.setStrokeWidth(6.0f);
        this.F.setDuration(400L);
        this.F.addUpdateListener(new f());
    }

    protected void n() {
        if (this.D == null) {
            return;
        }
        this.T = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, this.D.getWidth() / 2.0f, this.D.getHeight() / 2.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, this.D.getWidth() / 2.0f, this.D.getHeight() / 2.0f);
        this.S = scaleAnimation;
        scaleAnimation.setDuration(100L);
        this.S.setFillAfter(true);
        this.T.setDuration(100L);
        this.T.setFillAfter(true);
        this.D.startAnimation(this.S);
        this.S.setAnimationListener(new c());
    }

    protected void x() {
        E(1.0f);
        v();
        this.f64423i.setVisibility(8);
        this.f64423i.setProgress(0.0f);
        this.f64423i.setCenterScaleValue(1.0f);
        this.f64424m.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        this.f64413b0 = 0;
        this.f64424m.setVisibility(8);
        this.f64422h.setEnabled(true);
        this.f64422h.setVisibility(0);
        this.f64423i.setProgressOffset(-10.0f);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton
    public void setFunctionFlag(int i3) {
        if (i3 != -1) {
            this.f64415d = i3;
        }
    }

    public AEFlashCameraCaptureButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f64415d = 1;
        this.E = null;
        this.F = null;
        this.G = 0L;
        this.H = 0L;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.Q = 30000.0f;
        this.R = 30;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.f64412a0 = 0L;
        this.f64413b0 = 0;
        this.f64416d0 = new AtomicBoolean(false);
        this.f64418e0 = new AtomicBoolean(false);
        this.f64420f0 = new a();
        this.f64421g0 = new b(Looper.getMainLooper());
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEFlashCameraCaptureButtonLayout.this.D.startAnimation(AEFlashCameraCaptureButtonLayout.this.T);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ms.a.a("AEFlashCameraCaptureButtonLayout", "makeForegroundBtnGoneAnimation onAnimationEnd");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ms.a.a("AEFlashCameraCaptureButtonLayout", "makeForegroundBtnGoneAnimation onAnimationStart");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton
    public void setMaxDuration(float f16) {
    }
}
