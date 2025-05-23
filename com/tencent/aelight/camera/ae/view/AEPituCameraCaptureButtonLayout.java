package com.tencent.aelight.camera.ae.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.bubble.BubbleTextView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;
import com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout;
import com.tencent.aelight.camera.aebase.view.a;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes32.dex */
public class AEPituCameraCaptureButtonLayout extends AbsAECaptureButton {
    public View C;
    public View D;
    protected View E;
    protected AECameraGLSurfaceView F;
    protected AnimationQIMCircleProgress G;
    protected ImageView H;
    protected AECircleCaptureProgressView I;
    protected QIMCameraCountTimeLayout J;
    protected View K;
    ScaleAnimation L;
    ScaleAnimation M;
    protected g N;
    protected long P;
    protected ValueAnimator Q;
    protected ValueAnimator R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected a.InterfaceC0568a W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f65851a0;

    /* renamed from: b0, reason: collision with root package name */
    protected View f65852b0;

    /* renamed from: c0, reason: collision with root package name */
    protected BubbleTextView f65853c0;

    /* renamed from: d, reason: collision with root package name */
    private int f65854d;

    /* renamed from: d0, reason: collision with root package name */
    protected Runnable f65855d0;

    /* renamed from: e, reason: collision with root package name */
    private int f65856e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f65857e0;

    /* renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f65858f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f65859f0;

    /* renamed from: g0, reason: collision with root package name */
    private Runnable f65860g0;

    /* renamed from: h, reason: collision with root package name */
    protected AtomicBoolean f65861h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f65862h0;

    /* renamed from: i, reason: collision with root package name */
    protected float f65863i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f65864i0;

    /* renamed from: j0, reason: collision with root package name */
    protected boolean f65865j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f65866k0;

    /* renamed from: l0, reason: collision with root package name */
    private View.OnTouchListener f65867l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f65868m;

    /* renamed from: m0, reason: collision with root package name */
    protected Handler f65869m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AEPituCameraCaptureButtonLayout.this.K(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ms.a.f("CameraCaptureLayout", "scaleAnimator cancel!");
            AEPituCameraCaptureButtonLayout.this.f65861h.set(true);
            AEPituCameraCaptureButtonLayout.this.J.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ms.a.f("CameraCaptureLayout", "scaleAnimator end, shortVideoShot:" + AEPituCameraCaptureButtonLayout.this.f65858f.get() + ", mActionUpAnimator:" + AEPituCameraCaptureButtonLayout.this.f65861h.get());
            if (!AEPituCameraCaptureButtonLayout.this.f65861h.get()) {
                AEPituCameraCaptureButtonLayout.this.f65858f.set(true);
                AEPituCameraCaptureButtonLayout.this.f65869m0.sendEmptyMessage(2);
                AEPituCameraCaptureButtonLayout.this.G();
                AEPituCameraCaptureButtonLayout.this.P = System.currentTimeMillis();
                AEPituCameraCaptureButtonLayout.this.f65869m0.sendEmptyMessage(5);
                return;
            }
            AEPituCameraCaptureButtonLayout.this.J();
            AEPituCameraCaptureButtonLayout.this.K(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ms.a.f("CameraCaptureLayout", "scaleAnimator start!");
            AEPituCameraCaptureButtonLayout.this.f65869m0.sendEmptyMessage(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (!AEPituCameraCaptureButtonLayout.this.f65859f0) {
                AEPituCameraCaptureButtonLayout.this.G.setCenterScaleValue(floatValue);
            } else {
                AEPituCameraCaptureButtonLayout.this.I.setCenterScaleValue(floatValue);
            }
        }
    }

    /* loaded from: classes32.dex */
    class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                vq.a.f443174a.a(AEPituCameraCaptureButtonLayout.this.D, null);
            }
            if (AEPituCameraCaptureButtonLayout.this.f65859f0) {
                return AEPituCameraCaptureButtonLayout.this.r(view, motionEvent);
            }
            return AEPituCameraCaptureButtonLayout.this.t(view, motionEvent);
        }
    }

    /* loaded from: classes32.dex */
    class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AEPituCameraCaptureButtonLayout.this.q(message);
        }
    }

    /* loaded from: classes32.dex */
    public interface g extends AbsAECaptureButton.a {
    }

    public AEPituCameraCaptureButtonLayout(Context context) {
        super(context);
        this.f65858f = new AtomicBoolean(false);
        this.f65861h = new AtomicBoolean(false);
        this.f65863i = 20000.0f;
        this.f65868m = 20;
        this.L = null;
        this.M = null;
        this.P = 0L;
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f65851a0 = 1;
        this.f65857e0 = true;
        this.f65862h0 = true;
        this.f65865j0 = true;
        this.f65866k0 = true;
        this.f65867l0 = new e();
        this.f65869m0 = new f(Looper.getMainLooper());
        v();
    }

    private void A() {
        ms.a.a("CameraCaptureLayout", "makeForegroundBtnGoneAnimation");
        if (this.H != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, this.H.getWidth() / 2.0f, (this.H.getHeight() / 2.0f) + 50.0f);
            this.L = scaleAnimation;
            scaleAnimation.setDuration(400L);
            this.L.setFillAfter(true);
            this.L.setAnimationListener(new a());
            this.H.startAnimation(this.L);
        }
    }

    private void B() {
        ms.a.a("CameraCaptureLayout", "recoverImageAnimation");
        if (this.H == null) {
            return;
        }
        ScaleAnimation scaleAnimation = this.M;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        ScaleAnimation scaleAnimation2 = this.L;
        if (scaleAnimation2 != null) {
            scaleAnimation2.cancel();
        }
        this.H.bringToFront();
        this.H.setVisibility(0);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, (this.H.getWidth() / 2.0f) + 17.0f, (this.H.getHeight() / 2.0f) + 17.0f);
        this.M = scaleAnimation3;
        scaleAnimation3.setFillAfter(true);
        this.H.startAnimation(this.M);
    }

    private void n() {
        int i3 = this.f65851a0;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                return;
            }
            if (!AEResUtil.R()) {
                QQToast.makeText(getContext(), 1, getContext().getString(R.string.y76), 1).show();
                return;
            }
            if (this.U && this.f65858f.get()) {
                I();
                return;
            }
            if (this.U) {
                return;
            }
            if (this.f65862h0 && this.V) {
                H();
                return;
            } else {
                d();
                return;
            }
        }
        ms.a.a("CameraCaptureLayout", "checkStartCapture: isStarting = " + this.U + " | shortVideoShot = " + this.f65858f.get() + " | countDownEnable = " + this.V);
        if (this.U && this.f65858f.get()) {
            I();
            return;
        }
        if (this.U) {
            return;
        }
        if ((this.f65862h0 || z()) && this.V) {
            H();
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view, MotionEvent motionEvent) {
        if (this.U) {
            t(view, motionEvent);
            return;
        }
        if (this.f65860g0 != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.f65860g0);
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            t(view, obtain);
            obtain.recycle();
        }
        this.f65860g0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean r(final View view, final MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            if (motionEvent.getAction() != 0) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() >= 100) {
                    o(view, motionEvent);
                }
                return true;
            }
            if (this.f65860g0 == null) {
                this.f65860g0 = new Runnable() { // from class: com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AEPituCameraCaptureButtonLayout.this.o(view, motionEvent);
                    }
                };
            }
            ThreadManager.getUIHandler().postDelayed(this.f65860g0, 100L);
            return true;
        }
        return s(view, motionEvent);
    }

    private boolean s(View view, MotionEvent motionEvent) {
        o(view, motionEvent);
        return t(view, motionEvent);
    }

    private boolean x() {
        return (getContext() instanceof Activity) && gq.a.j(((Activity) getContext()).getIntent());
    }

    private boolean y() {
        return (getContext() instanceof Activity) && gq.a.r(((Activity) getContext()).getIntent());
    }

    private boolean z() {
        return (getContext() instanceof Activity) && gq.a.v(((Activity) getContext()).getIntent());
    }

    public void C() {
        D();
        this.f65861h.set(false);
        this.f65858f.set(false);
        this.P = 0L;
        this.S = false;
    }

    protected void E() {
        if (!this.f65859f0) {
            A();
            this.Q = ValueAnimator.ofFloat(1.0f, 1.45f);
        } else {
            this.Q = ValueAnimator.ofFloat(1.0f, 1.1735f);
        }
        if (!this.f65859f0) {
            this.Q.setDuration(400L);
        } else {
            this.Q.setDuration(300L);
        }
        this.Q.addUpdateListener(new b());
        this.Q.addListener(new c());
        this.Q.start();
        if (!this.f65859f0) {
            this.G.changeMode(1);
        } else {
            this.I.d(1);
        }
        if (!this.f65859f0) {
            this.R = ValueAnimator.ofFloat(1.0f, 0.85f);
            this.G.setStrokeWidth(6.0f);
        } else {
            this.R = ValueAnimator.ofFloat(1.0f, 0.6f);
            this.I.setStrokeWidth(5.0f);
        }
        if (!this.f65859f0) {
            this.R.setDuration(400L);
        } else {
            this.R.setDuration(300L);
        }
        this.R.addUpdateListener(new d());
        this.R.start();
    }

    public void H() {
        a.InterfaceC0568a interfaceC0568a = this.W;
        if (interfaceC0568a != null) {
            interfaceC0568a.a();
        }
    }

    public void I() {
        ms.a.a("CameraCaptureLayout", "stopCapture: \u7ed3\u675f\u62cd\u6444 | shortVideoShot = " + this.f65858f.get() + " | mActionUpAnimator = " + this.f65861h.get());
        if (!this.U) {
            ms.a.f("CameraCaptureLayout", "stop failed because is not start");
            return;
        }
        int i3 = this.f65851a0;
        if (i3 != 1) {
            if (i3 == 2) {
                this.f65869m0.sendEmptyMessage(4);
                this.U = false;
                if (!this.f65859f0) {
                    this.G.changeMode(0);
                    return;
                } else {
                    this.I.d(0);
                    return;
                }
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                if (this.f65858f.get()) {
                    ms.a.a("CameraCaptureLayout", "in stop capture 1");
                    this.f65861h.set(true);
                    this.f65869m0.removeMessages(5);
                    J();
                    AEBaseReportParam.U().V0(System.currentTimeMillis() - p());
                    this.f65869m0.sendEmptyMessage(3);
                    this.U = false;
                    if (!this.f65859f0) {
                        this.G.changeMode(0);
                        return;
                    } else {
                        this.I.d(0);
                        return;
                    }
                }
                ms.a.a("CameraCaptureLayout", "in stop capture 2 " + this.U);
                return;
            }
        }
        this.f65861h.set(true);
        this.f65869m0.removeMessages(5);
        J();
        if (this.f65858f.get()) {
            this.f65869m0.sendEmptyMessage(3);
        } else {
            this.f65869m0.removeMessages(1);
            int i16 = this.f65851a0;
            if (i16 == 1) {
                this.f65869m0.sendEmptyMessage(4);
            } else if (i16 == 3) {
                this.f65869m0.sendEmptyMessage(3);
                g gVar = this.N;
                if (gVar != null) {
                    gVar.o();
                }
            }
        }
        this.U = false;
        if (!this.f65859f0) {
            this.G.changeMode(0);
        } else {
            this.I.d(0);
        }
    }

    protected void J() {
        ValueAnimator valueAnimator = this.Q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.R;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    protected void K(float f16) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        int i3 = this.f65854d;
        layoutParams.width = (int) (i3 * f16);
        layoutParams.height = (int) (i3 * f16);
        layoutParams.addRule(13);
        if (!this.f65859f0) {
            this.D.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            int i16 = this.f65856e;
            layoutParams2.width = (int) (i16 * f16);
            layoutParams2.height = (int) (i16 * f16);
            layoutParams2.addRule(13);
            this.G.setLayoutParams(layoutParams2);
            return;
        }
        this.I.g(f16);
    }

    protected void L() {
        int i3;
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.P;
        float f16 = (float) currentTimeMillis;
        float f17 = this.f65863i;
        boolean z16 = f16 >= f17;
        this.S = z16;
        if (z16) {
            i3 = QIMCircleProgress.MAX_PROGRESS;
        } else {
            i3 = (int) ((f16 / f17) * QIMCircleProgress.MAX_PROGRESS);
        }
        if (!this.f65859f0) {
            int i16 = ((int) currentTimeMillis) / 1000;
            if (i16 < 10) {
                str = "00:0" + i16;
            } else {
                str = "00:" + i16;
            }
            this.J.setText(str);
            this.G.setProgress(i3);
        } else {
            this.J.setText((((int) currentTimeMillis) / 1000) + "\u79d2");
            this.I.setProgress((float) i3);
        }
        QLog.isDevelopLevel();
        if (this.S) {
            I();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void a() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(158.0f, this.J.getResources());
        this.J.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public View b() {
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public boolean c() {
        return !this.f65859f0 ? this.G.getMode() != 0 : this.I.e() != 0;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void d() {
        this.f65861h.set(false);
        ms.a.a("CameraCaptureLayout", "startCapture: \u5f00\u59cb\u62cd\u6444");
        if (this.U) {
            ms.a.f("CameraCaptureLayout", "start fail because is started");
            return;
        }
        int i3 = this.f65851a0;
        if (i3 == 3 || i3 == 1 || i3 == 4) {
            this.f65869m0.sendEmptyMessageDelayed(1, 100L);
        }
        this.U = true;
        if (this.f65851a0 == 2) {
            I();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void e(boolean z16, a.InterfaceC0568a interfaceC0568a) {
        this.V = z16;
        this.W = interfaceC0568a;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void f(AbsAECaptureButton.a aVar, int i3, GLSurfaceView gLSurfaceView) {
        this.F = (AECameraGLSurfaceView) gLSurfaceView;
        if (aVar instanceof g) {
            this.N = (g) aVar;
            return;
        }
        throw new IllegalArgumentException("arg listener must be instance of PituCaptureButtonListener");
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void g(boolean z16, com.tencent.aelight.camera.ae.view.b bVar) {
        if (!this.f65859f0) {
            AnimationQIMCircleProgress animationQIMCircleProgress = this.G;
            if (animationQIMCircleProgress != null) {
                animationQIMCircleProgress.a(z16, bVar);
            }
        } else {
            AECircleCaptureProgressView aECircleCaptureProgressView = this.I;
            if (aECircleCaptureProgressView != null) {
                aECircleCaptureProgressView.b(z16, bVar);
            }
            View view = this.K;
            if (view != null) {
                view.setBackgroundResource(bVar.f65909f);
            }
        }
        QIMCameraCountTimeLayout qIMCameraCountTimeLayout = this.J;
        if (qIMCameraCountTimeLayout == null || !z16) {
            return;
        }
        qIMCameraCountTimeLayout.setTextColor(bVar.f65914k);
        this.J.setTextShadow(bVar.f65915l);
        this.J.setDotView(bVar.f65913j);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void h(boolean z16) {
        if (!this.f65859f0) {
            AnimationQIMCircleProgress animationQIMCircleProgress = this.G;
            if (animationQIMCircleProgress != null) {
                animationQIMCircleProgress.b(z16);
            }
        } else {
            AECircleCaptureProgressView aECircleCaptureProgressView = this.I;
            if (aECircleCaptureProgressView != null) {
                aECircleCaptureProgressView.c(z16);
            }
        }
        QIMCameraCountTimeLayout qIMCameraCountTimeLayout = this.J;
        if (qIMCameraCountTimeLayout != null) {
            int i3 = -1;
            if (z16 && !this.f65864i0) {
                i3 = -16777216;
            }
            qIMCameraCountTimeLayout.setTextColor(i3);
        }
    }

    public void m() {
        BubbleTextView bubbleTextView = this.f65853c0;
        if (bubbleTextView == null || bubbleTextView.getVisibility() == 0 || AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_PHOTO_VIDEO_TAKE_TIPS, false, 0)) {
            return;
        }
        AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_PHOTO_VIDEO_TAKE_TIPS, true, 0);
        int a16 = v.a(getContext(), 8.0f);
        int f16 = BaseAIOUtils.f(6.0f, getResources());
        this.f65853c0.setPadding(a16, f16, a16, f16);
        this.f65853c0.setIncludeFontPadding(false);
        this.f65853c0.setTextSize(1, 14.0f);
        this.f65853c0.f62581m = Color.parseColor("#252525");
        this.f65853c0.setTextColor(-1);
        this.f65853c0.f62578f = BaseAIOUtils.f(6.0f, getResources());
        this.f65853c0.setText(getContext().getString(R.string.f169868y15));
        this.f65853c0.a();
        this.f65853c0.setVisibility(0);
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AEPituCameraCaptureButtonLayout.this.u();
            }
        };
        this.f65855d0 = runnable;
        this.f65853c0.postDelayed(runnable, 5000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BubbleTextView bubbleTextView = this.f65853c0;
        if (bubbleTextView != null) {
            bubbleTextView.removeCallbacks(this.f65855d0);
            u();
        }
    }

    public long p() {
        return this.P;
    }

    protected void q(Message message) {
        ms.a.f("CameraCaptureLayout", "handleMessage what:" + message.what + ", shortVideoShot:" + this.f65858f.get());
        int i3 = message.what;
        if (i3 != 9) {
            switch (i3) {
                case 1:
                    E();
                    return;
                case 2:
                    this.J.setVisibility(0);
                    g gVar = this.N;
                    if (gVar != null) {
                        gVar.h();
                        return;
                    }
                    return;
                case 3:
                    if (this.f65858f.get()) {
                        g gVar2 = this.N;
                        if (gVar2 != null) {
                            gVar2.a();
                        }
                        this.f65858f.set(false);
                        this.f65861h.set(false);
                        D();
                        setVisibility(8);
                        return;
                    }
                    return;
                case 4:
                    g gVar3 = this.N;
                    if (gVar3 != null) {
                        gVar3.g();
                    }
                    D();
                    if (x()) {
                        com.tencent.aelight.camera.ae.report.b.b().i();
                    }
                    if (y()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("ext6", String.valueOf(AEBeautyProviderView.m()));
                        hashMap.put("ext7", String.valueOf(AEBeautyProviderView.n()));
                        if (AEMaterialManager.H() != null) {
                            hashMap.put("ext15", AEMaterialManager.H().f69050id);
                        }
                        if (AEMaterialManager.J() != null) {
                            hashMap.put("ext16", AEMaterialManager.J().f69050id);
                        }
                        AEMaterialManager aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
                        if (aEMaterialManager != null) {
                            hashMap.put("ext17", aEMaterialManager.I());
                        }
                        com.tencent.aelight.camera.aebase.c.b(14, hashMap);
                        return;
                    }
                    return;
                case 5:
                    if (this.f65858f.get()) {
                        L();
                        this.f65869m0.sendEmptyMessageDelayed(5, 50L);
                        return;
                    }
                    return;
                case 6:
                    C();
                    break;
                default:
                    return;
            }
        }
        g gVar4 = this.N;
        if (gVar4 != null) {
            gVar4.d();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        if (this.f65865j0 == z16) {
            return;
        }
        this.f65865j0 = z16;
        if (z16) {
            this.C.setVisibility(8);
            this.D.setVisibility(0);
            if (this.f65859f0) {
                this.G.setVisibility(0);
                return;
            } else {
                this.I.setVisibility(0);
                return;
            }
        }
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        if (this.f65859f0) {
            this.G.setVisibility(8);
        } else {
            this.I.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setGifMode(boolean z16) {
        this.f65862h0 = z16;
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setMaxDuration(float f16) {
        this.f65863i = f16;
        this.f65868m = (int) (f16 / 1000.0f);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setTouchEnable(boolean z16) {
        this.f65857e0 = z16;
    }

    protected boolean t(View view, MotionEvent motionEvent) {
        QLog.isDevelopLevel();
        if (!this.f65857e0) {
            return false;
        }
        if (this.f65866k0 && motionEvent.getAction() != 1) {
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, true, this.D, this.F);
        }
        if (this.S || !this.f65865j0) {
            return false;
        }
        if (this.N != null && (motionEvent.getAction() & 255) == 0) {
            this.N.f();
        }
        if (this.f65852b0.getVisibility() == 0) {
            l();
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            u();
            if (this.T) {
                return false;
            }
            n();
            return true;
        }
        if (action == 1) {
            ms.a.c("PhotoTakenPerformance", "start");
            I();
            return true;
        }
        if (action != 3) {
            return action == 5;
        }
        if (!this.f65859f0) {
            I();
        } else {
            this.U = false;
            this.f65869m0.removeMessages(1);
        }
        return true;
    }

    public void u() {
        BubbleTextView bubbleTextView = this.f65853c0;
        if (bubbleTextView == null) {
            return;
        }
        bubbleTextView.setVisibility(8);
    }

    protected void v() {
        this.f65864i0 = i.b();
        if (!this.f65859f0) {
            LayoutInflater.from(getContext()).inflate(R.layout.dos, (ViewGroup) this, true);
            this.f65854d = BaseAIOUtils.f(53.0f, getResources());
            this.f65856e = BaseAIOUtils.f(80.0f, getResources());
            AnimationQIMCircleProgress animationQIMCircleProgress = (AnimationQIMCircleProgress) findViewById(R.id.rrh);
            this.G = animationQIMCircleProgress;
            animationQIMCircleProgress.setBackgroundResource(R.drawable.iyn);
            this.G.setCenterView();
            this.G.setVisibility(0);
            this.G.changeMode(0);
            ImageView imageView = (ImageView) findViewById(R.id.rpq);
            this.H = imageView;
            imageView.setVisibility(0);
            this.H.bringToFront();
            this.H.setImageResource(R.drawable.iw8);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.dl7, (ViewGroup) this, true);
            this.f65854d = BaseAIOUtils.f(98.0f, getResources());
            this.f65856e = BaseAIOUtils.f(98.0f, getResources());
            this.I = (AECircleCaptureProgressView) findViewById(R.id.rrh);
            this.K = findViewById(R.id.rv_);
            this.I.setCenterView();
            this.I.setVisibility(0);
            this.I.d(0);
            this.f65853c0 = (BubbleTextView) findViewById(R.id.rpw);
        }
        this.E = findViewById(R.id.rqp);
        View findViewById = findViewById(R.id.rtz);
        this.D = findViewById;
        findViewById.setOnTouchListener(this.f65867l0);
        this.D.setEnabled(true);
        View findViewById2 = findViewById(R.id.f163753ru0);
        this.C = findViewById2;
        findViewById2.setOnTouchListener(this.f65867l0);
        vq.a.f443174a.b(this.D, "em_ae_photo_btn");
        QIMCameraCountTimeLayout qIMCameraCountTimeLayout = (QIMCameraCountTimeLayout) findViewById(R.id.rqt);
        this.J = qIMCameraCountTimeLayout;
        qIMCameraCountTimeLayout.setIsCircleStyle(this.f65859f0);
        this.f65852b0 = findViewById(R.id.rri);
    }

    public void l() {
        F(false);
    }

    @Override // zq.a
    public void onPause() {
        this.T = true;
        I();
    }

    @Override // zq.a
    public void onResume() {
        this.T = false;
        this.U = false;
        m();
        C();
    }

    protected void D() {
        K(1.0f);
        B();
        if (!this.f65859f0) {
            this.G.setProgressOffset(-10.0f);
            this.G.setProgress(0.0f);
            this.G.setCenterScaleValue(1.0f);
        } else {
            this.I.setProgress(0.0f);
            this.I.setCenterScaleValue(1.0f);
        }
        if (!this.f65859f0) {
            this.J.setText("0\u79d2");
        } else {
            this.J.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        }
        this.J.setVisibility(8);
        this.D.setEnabled(true);
        this.D.setVisibility(0);
    }

    public void F(boolean z16) {
        if (z16) {
            this.f65852b0.setVisibility(0);
        } else {
            this.f65852b0.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setFunctionFlag(int i3) {
        if (i3 != -1) {
            this.f65851a0 = i3;
        }
    }

    protected void w(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415482f)) == null) {
            return;
        }
        this.f65859f0 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    public AEPituCameraCaptureButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65858f = new AtomicBoolean(false);
        this.f65861h = new AtomicBoolean(false);
        this.f65863i = 20000.0f;
        this.f65868m = 20;
        this.L = null;
        this.M = null;
        this.P = 0L;
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f65851a0 = 1;
        this.f65857e0 = true;
        this.f65862h0 = true;
        this.f65865j0 = true;
        this.f65866k0 = true;
        this.f65867l0 = new e();
        this.f65869m0 = new f(Looper.getMainLooper());
        w(context, attributeSet);
        v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ms.a.a("CameraCaptureLayout", "makeForegroundBtnGoneAnimation onAnimationEnd");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ms.a.a("CameraCaptureLayout", "makeForegroundBtnGoneAnimation onAnimationStart");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    protected void G() {
    }
}
