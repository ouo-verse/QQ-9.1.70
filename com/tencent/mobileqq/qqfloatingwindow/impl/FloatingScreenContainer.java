package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.FilterEnum;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FloatingScreenContainer extends FrameLayout {
    static IPatchRedirector $redirector_;
    private WindowManager C;
    private int D;
    private int E;
    private ValueAnimator F;
    private ObjectAnimator G;
    private boolean H;
    private boolean I;
    private float J;
    private float K;
    private int L;
    private int M;
    private float N;
    private float P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private WindowManager.LayoutParams W;

    /* renamed from: a0, reason: collision with root package name */
    private int f264318a0;

    /* renamed from: b0, reason: collision with root package name */
    private gh2.a f264319b0;

    /* renamed from: c0, reason: collision with root package name */
    private gh2.b f264320c0;

    /* renamed from: d, reason: collision with root package name */
    private int f264321d;

    /* renamed from: e, reason: collision with root package name */
    private int f264322e;

    /* renamed from: f, reason: collision with root package name */
    private int f264323f;

    /* renamed from: h, reason: collision with root package name */
    private FloatingScreenParams f264324h;

    /* renamed from: i, reason: collision with root package name */
    private FloatingScreenParams f264325i;

    /* renamed from: m, reason: collision with root package name */
    private Context f264326m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f264327d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f264328e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f264329f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f264330h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f264331i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f264332m;

        a(int i3, int i16, WindowManager.LayoutParams layoutParams, int i17, int i18, int i19, int i26) {
            this.f264327d = i3;
            this.f264328e = i16;
            this.f264329f = layoutParams;
            this.f264330h = i17;
            this.f264331i = i18;
            this.f264332m = i19;
            this.C = i26;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FloatingScreenContainer.this, Integer.valueOf(i3), Integer.valueOf(i16), layoutParams, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Float f16 = (Float) valueAnimator.getAnimatedValue();
            if (this.f264327d >= (-this.f264328e)) {
                this.f264329f.x = (int) (this.f264330h + (f16.floatValue() * (this.f264327d - this.f264330h)));
            }
            if (this.f264331i >= this.f264332m) {
                this.f264329f.y = (int) (this.C + (f16.floatValue() * (this.f264331i - this.C)));
            }
            FloatingScreenContainer.this.e0(this.f264329f);
            FloatingScreenContainer.this.f264324h.setFloatingCenterX(this.f264329f.x);
            FloatingScreenContainer.this.f264324h.setFloatingCenterY(this.f264329f.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingScreenContainer.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                animator.removeAllListeners();
                FloatingScreenContainer.this.postInvalidate();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f264334d;

        c(WindowManager.LayoutParams layoutParams) {
            this.f264334d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingScreenContainer.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Float f16 = (Float) valueAnimator.getAnimatedValue();
            this.f264334d.alpha = (f16.floatValue() * 1.0f) + 0.0f;
            FloatingScreenContainer.this.e0(this.f264334d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingScreenContainer.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FloatingScreenContainer.this.I = false;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            FloatingScreenContainer.this.G.removeAllListeners();
            FloatingScreenContainer.b(FloatingScreenContainer.this);
            FloatingScreenContainer.this.I = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                FloatingScreenContainer.this.I = true;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                FloatingScreenContainer.b(FloatingScreenContainer.this);
                FloatingScreenContainer.this.I = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f264337d;

        e(WindowManager.LayoutParams layoutParams) {
            this.f264337d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingScreenContainer.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Float f16 = (Float) valueAnimator.getAnimatedValue();
            this.f264337d.alpha = (f16.floatValue() * 1.0f) + 0.0f;
            FloatingScreenContainer.this.e0(this.f264337d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingScreenContainer.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FloatingScreenContainer.this.I = false;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            FloatingScreenContainer.this.G.removeAllListeners();
            FloatingScreenContainer.b(FloatingScreenContainer.this);
            FloatingScreenContainer.this.I = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                FloatingScreenContainer.this.I = true;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                FloatingScreenContainer.b(FloatingScreenContainer.this);
                FloatingScreenContainer.this.I = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface g {
    }

    public FloatingScreenContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    private void A(boolean z16) {
        int i3;
        int i16;
        gh2.b bVar;
        int i17;
        int identifier;
        this.f264324h = this.f264325i.m216clone();
        if (z16) {
            C();
        }
        Context context = this.f264326m;
        if (context != null && context.getResources() != null) {
            i3 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(14.0f, this.f264326m.getResources());
        } else {
            i3 = 28;
        }
        int i18 = 0;
        try {
            Context context2 = this.f264326m;
            if (context2 != null && context2.getResources() != null && (identifier = this.f264326m.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                i18 = this.f264326m.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        int outerWidth = ((this.D / 2) - i3) - (this.f264324h.getOuterWidth() / 2);
        int outerHeight = ((this.E / 2) - i3) - (this.f264324h.getOuterHeight() / 2);
        int i19 = (-outerHeight) + i18;
        int i26 = -this.D;
        int i27 = -this.E;
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        layoutParams.gravity = 17;
        int i28 = layoutParams.x;
        int i29 = -outerWidth;
        if (i28 < i29) {
            i26 = i29;
        }
        if (i28 > outerWidth) {
            i26 = outerWidth;
        }
        int i36 = layoutParams.y;
        if (i36 < i19) {
            i27 = i19;
        }
        if (i36 > outerHeight) {
            i16 = outerHeight;
        } else {
            i16 = i27;
        }
        if ((i28 < i29 - 7 || i28 > outerWidth + 7) && (bVar = this.f264320c0) != null) {
            int i37 = this.D;
            if (i16 >= i19) {
                i36 = i16;
            }
            if (bVar.d(i37, i36, i26)) {
                QLog.i("FloatingScreenContainer", 2, "onDragEndAnimation, interruptOnDragToEdge");
                return;
            }
        }
        int i38 = layoutParams.x;
        if (i38 > i29 && i38 < outerWidth) {
            if (i38 < 0) {
                i17 = i29;
            } else {
                i17 = outerWidth;
            }
        } else {
            i17 = i26;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.F.cancel();
            }
            this.F = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F = ofFloat;
        ofFloat.setTarget(this);
        this.F.setDuration(200L);
        this.F.addUpdateListener(new a(i17, outerWidth, layoutParams, layoutParams.x, i16, i19, layoutParams.y));
        this.F.addListener(new b());
        this.F.start();
        gh2.b bVar2 = this.f264320c0;
        if (bVar2 != null) {
            bVar2.onDragEnd();
        }
    }

    private void B(int i3, int i16) {
        if (this.f264324h.getCanMove()) {
            this.f264325i.setShapeType(this.f264324h.getShapeType());
            this.f264325i.setFloatingCenterX(this.f264324h.getFloatingCenterX() + i3);
            this.f264325i.setFloatingCenterY(this.f264324h.getFloatingCenterY() + i16);
            e0(X(this.f264325i, false));
            gh2.b bVar = this.f264320c0;
            if (bVar != null) {
                bVar.e(this.f264325i.getFloatingCenterX(), this.f264325i.getFloatingCenterY());
            }
        }
    }

    private void C() {
        if (this.V) {
            p();
            m();
            this.V = false;
        }
    }

    private void G() {
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        this.R = layoutParams.x;
        this.S = layoutParams.y;
        this.T = this.f264324h.getOuterWidth();
        this.U = this.f264324h.getOuterHeight();
    }

    private void I() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("action", "1");
        PluginRuntime runtime = PluginRuntime.getRuntime();
        if (runtime != null) {
            str = runtime.getAccount();
        } else {
            str = "";
        }
        StatisticCollector.getInstance(this.f264326m).collectPerformance(str, "VideoFloatScale", true, 0L, 0L, hashMap, "");
    }

    private void J() {
        this.N = -1.0f;
    }

    private void K() {
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams == null) {
            return;
        }
        floatingScreenParams.initParam();
        int i3 = this.D;
        int i16 = this.E;
        int width = this.f264324h.getWidth();
        int height = this.f264324h.getHeight();
        if (i3 < width || i16 < height) {
            if (i3 < width) {
                i16 = (int) Math.ceil(height * (i3 / width));
            } else {
                i3 = (int) Math.ceil(width * (i16 / height));
            }
            this.f264324h.initParam();
            this.f264324h.setWidth(i3);
            this.f264324h.setHeight(i16);
            this.f264325i = this.f264324h.m216clone();
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            L();
        }
    }

    private void P(int i3) {
        QLog.d("FloatingScreenContainer", 1, "[setFloatingMode] mode: " + i3);
        this.f264321d = i3;
    }

    private void S(boolean z16) {
        FloatingScreenParams floatingScreenParams;
        if (z16 && (floatingScreenParams = this.f264324h) != null && floatingScreenParams.getOuterRoundCorner() > 0) {
            setElevation(15.0f);
            setBackground(getResources().getDrawable(v()));
        } else {
            setElevation(0.0f);
            setBackgroundResource(0);
        }
    }

    private void T(WindowManager.LayoutParams layoutParams) {
        this.f264325i = this.f264324h.m216clone();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator objectAnimator = this.G;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.G.cancel();
            }
            this.G = null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.C, ofFloat);
        this.G = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addUpdateListener(new c(layoutParams));
        this.G.addListener(new d());
        this.G.start();
    }

    private float V(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getPointerCount() == 2) {
            float x16 = motionEvent.getX(0) - motionEvent.getX(1);
            float y16 = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x16 * x16) + (y16 * y16));
        }
        return 0.0f;
    }

    static /* synthetic */ g b(FloatingScreenContainer floatingScreenContainer) {
        floatingScreenContainer.getClass();
        return null;
    }

    private void b0(FrameLayout.LayoutParams layoutParams, float f16) {
        int i3;
        int i16 = this.D;
        if (i16 != 0 && (i3 = this.E) != 0) {
            if (f16 >= i16 / i3) {
                i3 = (int) (i16 / f16);
            } else {
                i16 = (int) (i3 * f16);
            }
            layoutParams.width = i16;
            layoutParams.height = i3;
        }
    }

    private void c0(FrameLayout.LayoutParams layoutParams, float f16, boolean z16) {
        int i3;
        float f17 = 1.0f;
        if (this.f264324h.getShapeType() == 1) {
            f17 = 1.0f / this.f264324h.getScreenRatio();
        } else if (this.f264324h.getShapeType() == 2) {
            f17 = this.f264324h.getScreenRatio();
        }
        int i16 = -1;
        if (Math.abs(f16 - f17) < 0.1d) {
            if (z16) {
                this.L = this.f264324h.getInitialWidth();
                this.M = this.f264324h.getInitialHeight();
            }
            i3 = -1;
        } else if (f16 > f17) {
            i3 = (int) Math.ceil(this.f264324h.getWidth() / f16);
            if (z16) {
                this.L = this.f264324h.getInitialWidth();
                this.M = (int) Math.ceil(this.f264324h.getInitialWidth() / f16);
            }
        } else {
            int ceil = (int) Math.ceil(this.f264324h.getHeight() * f16);
            if (z16) {
                this.M = this.f264324h.getInitialHeight();
                this.L = (int) Math.ceil(this.f264324h.getInitialHeight() * f16);
            }
            i16 = ceil;
            i3 = -1;
        }
        layoutParams.width = i16;
        layoutParams.height = i3;
    }

    private void d0(int i3, int i16) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f166636m30);
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private void f0() {
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.gravity = 17;
        layoutParams.width = ((this.D / 2) - this.R) + (this.f264324h.getOuterWidth() / 2);
        this.W.height = ((this.E / 2) - this.S) + (this.f264324h.getOuterHeight() / 2);
        WindowManager.LayoutParams layoutParams2 = this.W;
        layoutParams2.x = (this.D / 2) - (layoutParams2.width / 2);
        layoutParams2.y = (this.E / 2) - (layoutParams2.height / 2);
        this.V = true;
        e0(layoutParams2);
    }

    private void g0() {
        d0(-1, -1);
    }

    @SuppressLint({"WrongConstant"})
    private void h() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                this.W = layoutParams;
                layoutParams.layoutInDisplayCutoutMode = 2;
                WindowManager windowManager = this.C;
                if (windowManager != null) {
                    windowManager.updateViewLayout(this, this.W);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void h0() {
        View view = (FrameLayout) findViewById(R.id.f166636m30);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = 51;
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            int outerWidth = (floatingScreenParams.getOuterWidth() - this.f264324h.getWidth()) / 2;
            layoutParams.leftMargin = outerWidth;
            layoutParams.topMargin = outerWidth;
            if (QLog.isColorLevel()) {
                QLog.d("FloatingScreenContainer", 2, "updateWrapperGravity() margin = " + outerWidth + " OuterWidth = " + this.f264324h.getOuterWidth() + " Width = " + this.f264324h.getWidth());
            }
        }
        updateViewLayout(view, layoutParams);
    }

    private void i0(float f16) {
        if (this.Q && !this.V) {
            G();
            f0();
            h0();
            I();
            this.Q = false;
        }
        R(f16);
        S(false);
    }

    private void m() {
        n(this.f264324h.getOuterWidth(), this.f264324h.getOuterHeight());
        o();
        S(true);
    }

    private void n(int i3, int i16) {
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.gravity = 17;
        layoutParams.width = i3;
        layoutParams.height = i16;
        layoutParams.x = this.R + ((this.f264324h.getOuterWidth() - this.T) / 2);
        this.W.y = this.S + ((this.f264324h.getOuterHeight() - this.U) / 2);
        e0(this.W);
    }

    private void o() {
        View view = (FrameLayout) findViewById(R.id.f166636m30);
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = 17;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        updateViewLayout(view, layoutParams);
    }

    private void p() {
        int reboundSize = this.f264324h.getReboundSize();
        if (this.f264324h.getWidth() <= 0) {
            this.P = 1.0f;
            R(1.0f);
            if (QLog.isColorLevel()) {
                QLog.d("FloatingScreenContainer", 2, "onDragEndAnimation mFloatParams.getWidth() Wrong \uff01\uff01\uff01\uff01 mFloatParams.getWidth() = " + this.f264324h.getWidth());
                return;
            }
            return;
        }
        float width = reboundSize / this.f264324h.getWidth();
        if (width != 1.0f) {
            float f16 = this.P * width;
            this.P = f16;
            R(f16);
        }
    }

    private void x(Context context) {
        if (context != null) {
            this.f264323f = ViewConfiguration.get(context).getScaledTouchSlop();
        }
    }

    private void z(WindowManager.LayoutParams layoutParams) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator objectAnimator = this.G;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.G.cancel();
            }
            this.G = null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.C, ofFloat);
        this.G = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addUpdateListener(new e(layoutParams));
        this.G.addListener(new f());
        this.G.start();
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            floatingScreenParams.setShowPadding(true);
        }
        z(E());
        O();
    }

    @SuppressLint({"WrongConstant"})
    WindowManager.LayoutParams E() {
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.type = this.f264322e;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 2;
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            this.W.width = floatingScreenParams.getOuterWidth();
            this.W.height = this.f264324h.getOuterHeight();
            this.W.x = this.f264324h.getFloatingCenterX();
            this.W.y = this.f264324h.getFloatingCenterY();
        } else {
            WindowManager.LayoutParams layoutParams2 = this.W;
            layoutParams2.width = 500;
            layoutParams2.height = FilterEnum.MIC_PTU_TRANS_KONGCHENG;
            layoutParams2.x = 200;
            layoutParams2.y = 0;
        }
        return this.W;
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (!s()) {
            return false;
        }
        N();
        setVisibility(8);
        h();
        H();
        this.W = null;
        U();
        removeAllViews();
        this.f264325i = null;
        this.P = 1.0f;
        return true;
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            WindowManager windowManager = this.C;
            if (windowManager != null) {
                windowManager.removeView(this);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (!s()) {
            return;
        }
        this.f264324h.resetParams();
        this.P = 1.0f;
        R(1.0f);
        this.f264324h.resetParams();
        m();
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        WindowManager windowManager = this.C;
        if (windowManager != null) {
            this.E = windowManager.getDefaultDisplay().getHeight();
            this.D = this.C.getDefaultDisplay().getWidth();
        }
    }

    void N() {
        P(0);
    }

    void O() {
        P(1);
    }

    void Q() {
        P(2);
    }

    void R(float f16) {
        QLog.d("FloatingScreenContainer", 2, "setVideoAndContainerScaled: scale[" + f16 + "");
        this.f264324h.updateZoomRatio(f16);
        this.f264325i = this.f264324h.m216clone();
        int width = this.f264324h.getWidth();
        int height = this.f264324h.getHeight();
        if (this.M != -1) {
            height = (int) Math.ceil(r2 * f16);
        }
        if (this.L != -1) {
            width = (int) Math.ceil(r2 * f16);
        }
        d0(width, height);
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.F.cancel();
        }
    }

    public void W(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int floatingCenterX = this.f264324h.getFloatingCenterX();
        int floatingCenterY = this.f264324h.getFloatingCenterY();
        if (floatingCenterX != i3 || floatingCenterY != i16) {
            this.f264324h.setFloatingCenterX(i3);
            this.f264324h.setFloatingCenterY(i16);
            FloatingScreenParams m216clone = this.f264324h.m216clone();
            this.f264325i = m216clone;
            e0(X(m216clone, false));
        }
    }

    WindowManager.LayoutParams X(FloatingScreenParams floatingScreenParams, boolean z16) {
        int outerWidth = (this.D - floatingScreenParams.getOuterWidth()) / 2;
        int outerHeight = (this.E - floatingScreenParams.getOuterHeight()) / 2;
        if (Math.abs(floatingScreenParams.getFloatingCenterX()) > outerWidth) {
            if (floatingScreenParams.getFloatingCenterX() <= 0) {
                outerWidth = -outerWidth;
            }
            floatingScreenParams.setFloatingCenterX(outerWidth);
        }
        if (Math.abs(floatingScreenParams.getFloatingCenterY()) > outerHeight) {
            if (floatingScreenParams.getFloatingCenterY() <= 0) {
                outerHeight = -outerHeight;
            }
            floatingScreenParams.setFloatingCenterY(outerHeight);
        }
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        if (z16) {
            this.W.width = floatingScreenParams.getOuterWidth();
            this.W.height = floatingScreenParams.getOuterHeight();
        }
        this.W.x = floatingScreenParams.getFloatingCenterX();
        this.W.y = floatingScreenParams.getFloatingCenterY();
        return this.W;
    }

    public void Y(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
        } else if (f16 != this.f264324h.getScreenRatio()) {
            this.f264324h.setScreenRatio(f16);
            FloatingScreenParams m216clone = this.f264324h.m216clone();
            this.f264325i = m216clone;
            e0(X(m216clone, true));
        }
    }

    public void Z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else if (i3 != this.f264324h.getShapeType()) {
            this.f264324h.setShapeType(i3);
            FloatingScreenParams m216clone = this.f264324h.m216clone();
            this.f264325i = m216clone;
            e0(X(m216clone, true));
        }
    }

    public void a0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int width = this.f264324h.getWidth();
        int height = this.f264324h.getHeight();
        if (width != i3 || height != i16) {
            this.f264324h.setWidth(i3);
            this.f264324h.setHeight(i16);
            FloatingScreenParams m216clone = this.f264324h.m216clone();
            this.f264325i = m216clone;
            e0(X(m216clone, true));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (keyEvent.getKeyCode() == 4) {
            if (t()) {
                if (this.f264319b0 != null) {
                    QLog.d("FloatingScreenContainer", 1, "[dispatchKeyEvent] back pressed, quit window.");
                    this.f264319b0.onBackPressed();
                } else {
                    QLog.d("FloatingScreenContainer", 1, "[dispatchKeyEvent] back press listener should not be null.");
                }
            } else {
                QLog.d("FloatingScreenContainer", 1, "[dispatchKeyEvent] dispatch back key, current floating mode: " + this.f264321d);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void e(FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) floatingScreenParams);
            return;
        }
        try {
            if (this.C != null) {
                this.C.addView(this, i(floatingScreenParams));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void e0(WindowManager.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) layoutParams);
            return;
        }
        try {
            WindowManager windowManager = this.C;
            if (windowManager != null) {
                windowManager.updateViewLayout(this, layoutParams);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void f(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        floatingScreenParams.setShapeType(i3);
        int floatingCenterX = this.f264324h.getFloatingCenterX();
        int floatingCenterY = this.f264324h.getFloatingCenterY();
        Context context = this.f264326m;
        int i17 = 0;
        if (context != null && context.getResources() != null) {
            i16 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(14.0f, this.f264326m.getResources());
            try {
                int identifier = this.f264326m.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i17 = this.f264326m.getResources().getDimensionPixelSize(identifier);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            i16 = 28;
        }
        int outerWidth = ((this.D / 2) - i16) - (this.f264324h.getOuterWidth() / 2);
        int outerHeight = ((this.E / 2) - i16) - (this.f264324h.getOuterHeight() / 2);
        int i18 = (-outerHeight) + i17;
        if (floatingCenterX < 0) {
            outerWidth = -outerWidth;
        }
        if (floatingCenterY < i18) {
            floatingCenterY = i18;
        }
        if (floatingCenterY <= outerHeight) {
            outerHeight = floatingCenterY;
        }
        this.f264324h.setFloatingCenterX(outerWidth);
        this.f264324h.setFloatingCenterY(outerHeight);
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        this.W.width = this.f264324h.getOuterWidth();
        this.W.height = this.f264324h.getOuterHeight();
        this.W.x = this.f264324h.getFloatingCenterX();
        this.W.y = this.f264324h.getFloatingCenterY();
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.gravity = 17;
        e0(layoutParams);
    }

    public void g(boolean z16, int i3, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatingScreenContainer", 2, " enterFullScreen: " + z16 + " videoWidth: " + i3 + " videoHeight: " + i16 + " isCalledByEnterFloat: " + z17);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.m2z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (frameLayout != null) {
            if (i3 > 0 && i16 > 0) {
                float f16 = i3 / i16;
                if (z16) {
                    b0(layoutParams, f16);
                    g0();
                    setBackground(this.f264326m.getResources().getDrawable(R.drawable.hh9));
                    frameLayout.setClipToOutline(false);
                } else {
                    if (this.f264324h == null) {
                        this.L = -1;
                        this.M = -1;
                        if (QLog.isColorLevel()) {
                            QLog.d("FloatingScreenContainer", 2, " mFloatParams is null!");
                        }
                    } else {
                        c0(layoutParams, f16, z17);
                    }
                    setBackground(this.f264326m.getResources().getDrawable(R.color.ajr));
                    frameLayout.setClipToOutline(true);
                }
                frameLayout.setLayoutParams(layoutParams);
                return;
            }
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @SuppressLint({"WrongConstant"})
    WindowManager.LayoutParams i(FloatingScreenParams floatingScreenParams) {
        int outerWidth = (this.D - floatingScreenParams.getOuterWidth()) / 2;
        int outerHeight = (this.E - floatingScreenParams.getOuterHeight()) / 2;
        if (Math.abs(floatingScreenParams.getFloatingCenterX()) > outerWidth) {
            if (floatingScreenParams.getFloatingCenterX() <= 0) {
                outerWidth = -outerWidth;
            }
            floatingScreenParams.setFloatingCenterX(outerWidth);
        }
        if (Math.abs(floatingScreenParams.getFloatingCenterY()) > outerHeight) {
            if (floatingScreenParams.getFloatingCenterY() <= 0) {
                outerHeight = -outerHeight;
            }
            floatingScreenParams.setFloatingCenterY(outerHeight);
        }
        if (this.W == null) {
            this.W = new WindowManager.LayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.type = this.f264322e;
        layoutParams.format = 1;
        int windowFlags = floatingScreenParams.getWindowFlags();
        WindowManager.LayoutParams layoutParams2 = this.W;
        layoutParams2.flags = windowFlags | 16777256;
        layoutParams2.width = floatingScreenParams.getOuterWidth();
        this.W.height = floatingScreenParams.getOuterHeight();
        this.W.x = floatingScreenParams.getFloatingCenterX();
        this.W.y = floatingScreenParams.getFloatingCenterY();
        if (Build.VERSION.SDK_INT >= 28) {
            this.W.layoutInDisplayCutoutMode = 2;
        }
        if (!com.tencent.mobileqq.qqfloatingwindow.impl.b.e(this.f264326m)) {
            this.W.systemUiVisibility = 5892;
        }
        return this.W;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.f264324h != null) {
            u();
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            floatingScreenParams.setShowPadding(false);
        }
        T(k());
        Q();
    }

    @SuppressLint({"WrongConstant"})
    WindowManager.LayoutParams k() {
        if (this.W == null) {
            this.W = (WindowManager.LayoutParams) getLayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.W;
        layoutParams.type = this.f264322e;
        layoutParams.format = 1;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.x = 0;
        layoutParams.y = 0;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        if (!com.tencent.mobileqq.qqfloatingwindow.impl.b.e(this.f264326m)) {
            this.W.flags = 256;
        }
        if (i3 == 27) {
            this.W.flags = 288;
            QLog.d("FloatingScreenContainer", 1, "[enterFullScreenLayoutParams] current update flags.");
        }
        return this.W;
    }

    public void l(View view, FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view, (Object) floatingScreenParams);
            return;
        }
        if (s()) {
            F();
        }
        O();
        this.f264324h = floatingScreenParams;
        this.f264325i = floatingScreenParams.m216clone();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        removeAllViews();
        addView(view, layoutParams);
        e(floatingScreenParams);
        A(false);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
            return;
        }
        WindowManager windowManager = this.C;
        if (windowManager != null) {
            this.E = windowManager.getDefaultDisplay().getHeight();
            this.D = this.C.getDefaultDisplay().getWidth();
        }
        super.onConfigurationChanged(configuration);
        K();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z16 = false;
        if (t()) {
            this.H = false;
            return false;
        }
        if (motionEvent.getPointerCount() > 2) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y16 = motionEvent.getY();
                    float x16 = motionEvent.getX();
                    if (Math.abs(this.J - y16) > this.f264323f || Math.abs(this.K - x16) > this.f264323f) {
                        z16 = true;
                    }
                    this.H = z16;
                    if (z16) {
                        this.J = motionEvent.getRawY();
                        this.K = motionEvent.getRawX();
                    }
                }
            }
            this.H = false;
        } else {
            this.J = motionEvent.getY();
            this.K = motionEvent.getX();
            this.H = false;
        }
        return this.H;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f264325i == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.H) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.I) {
            Log.d("FloatingScreenContainer", "could not dragging while scaling!");
            return super.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            J();
                            this.Q = true;
                        }
                    }
                } else {
                    if (this.f264324h.getCanZoom() && pointerCount == 2) {
                        float V = V(motionEvent);
                        float f16 = this.N;
                        if (f16 != -1.0f) {
                            if (Math.abs(V - f16) <= 2.0f) {
                                return true;
                            }
                            float f17 = (this.P * V) / this.N;
                            this.P = f17;
                            i0(f17);
                            this.N = V;
                        } else {
                            this.N = V;
                            this.Q = true;
                        }
                    }
                    if (pointerCount == 1 && !this.V) {
                        B((int) (motionEvent.getRawX() - this.K), (int) (motionEvent.getRawY() - this.J));
                    }
                }
                return true;
            }
            A(true);
            J();
            this.Q = true;
            return true;
        }
        if (pointerCount == 2) {
            this.N = V(motionEvent);
        }
        return true;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            return floatingScreenParams.getFloatingCenterX();
        }
        return 0;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        FloatingScreenParams floatingScreenParams = this.f264324h;
        if (floatingScreenParams != null) {
            return floatingScreenParams.getFloatingCenterY();
        }
        return 0;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        if (this.f264321d != 0) {
            return true;
        }
        return false;
    }

    public void setOnBackPressListener(gh2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) aVar);
        } else {
            this.f264319b0 = aVar;
        }
    }

    public void setOnDragListener(gh2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) bVar);
        } else {
            this.f264320c0 = bVar;
        }
    }

    public void setOnScaleAnimListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) gVar);
        }
    }

    public void setOutCornerBackgroundDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f264318a0 = i3;
        }
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f264321d == 2) {
            return true;
        }
        return false;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f264321d == 1) {
            return true;
        }
        return false;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f264318a0;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.f264324h.getShapeType();
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.f264324h.isHasZoomed();
    }

    public FloatingScreenContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FloatingScreenContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f264321d = 0;
        this.f264323f = 20;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = false;
        this.I = false;
        this.L = -1;
        this.M = -1;
        this.N = -1.0f;
        this.P = 1.0f;
        this.Q = true;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.f264318a0 = R.drawable.hh_;
        x(context);
        this.f264326m = context;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.C = windowManager;
        if (windowManager != null) {
            this.E = windowManager.getDefaultDisplay().getHeight();
            this.D = this.C.getDefaultDisplay().getWidth();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f264322e = 2038;
        } else {
            this.f264322e = 2002;
        }
    }
}
