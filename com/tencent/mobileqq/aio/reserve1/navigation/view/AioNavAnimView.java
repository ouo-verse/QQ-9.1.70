package com.tencent.mobileqq.aio.reserve1.navigation.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.tencent.image.AnimationCallback;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.aio.reserve1.navigation.AIONavCorrelation;
import com.tencent.mobileqq.aio.reserve1.navigation.view.LottiePlayHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AioNavAnimView extends FrameLayout implements mv3.a, LottiePlayHelper.a {
    static IPatchRedirector $redirector_;
    private final int C;
    private final int D;
    private final int E;
    AXrLottieDrawable F;
    AXrLottieDrawable G;
    Drawable H;
    Drawable I;
    private Paint J;
    private Paint K;
    private Paint L;
    private Paint M;
    private Paint N;
    private com.tencent.mobileqq.aio.reserve1.navigation.view.c P;
    private com.tencent.mobileqq.aio.reserve1.navigation.view.c Q;
    private com.tencent.mobileqq.aio.reserve1.navigation.view.c R;
    private com.tencent.mobileqq.aio.reserve1.navigation.view.c S;
    private final ArgbEvaluator T;
    private final ConcurrentLinkedQueue<j> U;
    private volatile boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f193328a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Handler f193329b0;

    /* renamed from: c0, reason: collision with root package name */
    private final LottiePlayHelper f193330c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f193331d;

    /* renamed from: d0, reason: collision with root package name */
    private final DrawFilter f193332d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f193333e;

    /* renamed from: e0, reason: collision with root package name */
    private AnimatorSet f193334e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f193335f;

    /* renamed from: f0, reason: collision with root package name */
    private Animator f193336f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f193337g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f193338h;

    /* renamed from: h0, reason: collision with root package name */
    private View.OnClickListener f193339h0;

    /* renamed from: i, reason: collision with root package name */
    private final int f193340i;

    /* renamed from: i0, reason: collision with root package name */
    private AnimationCallback f193341i0;

    /* renamed from: j0, reason: collision with root package name */
    private final Runnable f193342j0;

    /* renamed from: m, reason: collision with root package name */
    private final int f193343m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else if (AioNavAnimView.this.S != null && AioNavAnimView.this.R != null) {
                AioNavAnimView.this.R(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                AioNavAnimView.this.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f193346d;

        c(boolean z16) {
            this.f193346d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AioNavAnimView.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AioNavAnimView.this.f193336f0 = null;
                if (!this.f193346d) {
                    AioNavAnimView.this.setVisibility(8);
                } else {
                    AioNavAnimView.this.L();
                }
                AioNavAnimView.i(AioNavAnimView.this);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                AioNavAnimView.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f193349d;

        e(float f16) {
            this.f193349d = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AioNavAnimView.this, Float.valueOf(f16));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                AioNavAnimView.this.setTranslationY(this.f193349d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AioNavAnimView.this.D();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements AnimationCallback {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // com.tencent.image.AnimationCallback
        public void invalidateSelf() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AioNavAnimView.this.postInvalidateDelayed(64L);
            }
        }

        @Override // com.tencent.image.AnimationCallback
        public void scheduleSelf(Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else if (AioNavAnimView.this.S != null && AioNavAnimView.this.R != null) {
                AioNavAnimView.this.T(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else if (AioNavAnimView.this.P != null && AioNavAnimView.this.Q != null) {
                AioNavAnimView.this.Q(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        AIONavCorrelation f193355a;

        /* renamed from: b, reason: collision with root package name */
        String f193356b;

        /* renamed from: c, reason: collision with root package name */
        Object f193357c;

        j(AIONavCorrelation aIONavCorrelation, String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aIONavCorrelation, str, obj);
                return;
            }
            this.f193355a = aIONavCorrelation;
            this.f193356b = str;
            this.f193357c = obj;
        }
    }

    public AioNavAnimView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    private AnimationCallback A() {
        if (this.f193341i0 == null) {
            this.f193341i0 = new g();
        }
        return this.f193341i0;
    }

    private Drawable B(AIONavCorrelation aIONavCorrelation) {
        if (aIONavCorrelation == AIONavCorrelation.STRONG) {
            return this.I;
        }
        return this.H;
    }

    private AXrLottieDrawable C(AIONavCorrelation aIONavCorrelation) {
        if (aIONavCorrelation == AIONavCorrelation.STRONG) {
            return this.F;
        }
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.Q;
        if (cVar == null) {
            return;
        }
        this.P = null;
        W(cVar);
        requestLayout();
        if (!this.U.isEmpty()) {
            this.f193329b0.removeCallbacks(this.f193342j0);
            this.f193329b0.postDelayed(this.f193342j0, 100L);
        } else {
            this.V = false;
            if (this.f193328a0) {
                q(this.W);
            }
        }
    }

    private void F() {
        Paint paint = new Paint(1);
        this.J = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.K = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.K.setTextAlign(Paint.Align.CENTER);
        this.K.setTextSize(this.C);
        Paint paint3 = new Paint(1);
        this.L = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.L.setStrokeWidth(this.E);
        this.L.setAntiAlias(true);
        Paint paint4 = new Paint(1);
        this.M = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.M.setTextAlign(Paint.Align.CENTER);
        this.M.setTextSize(this.C);
        Paint paint5 = new Paint(1);
        this.N = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        this.N.setStrokeWidth(this.E);
        this.N.setAntiAlias(true);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(j jVar) {
        if (this.Q != null && getVisibility() == 0) {
            AnimatorSet animatorSet = this.f193334e0;
            if (animatorSet != null) {
                if (animatorSet.isStarted()) {
                    this.f193334e0.cancel();
                }
                this.f193334e0 = null;
            }
            this.W = true;
            this.P = this.Q;
            this.Q = s(jVar);
            N();
            this.R = new com.tencent.mobileqq.aio.reserve1.navigation.view.c(this.P);
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = new com.tencent.mobileqq.aio.reserve1.navigation.view.c(this.Q);
            this.S = cVar;
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.R;
            cVar.f193375n = cVar2.f193375n;
            cVar.f193377p = cVar2.f193377p;
            cVar.f193378q = cVar2.f193378q;
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar3 = this.P;
            cVar.f193370i = cVar3.f193367f;
            cVar.f193371j = cVar3.f193368g;
            this.V = true;
            W(this.Q);
            X(this.P);
            R(0.0f);
            Q(0.0f);
            T(0.0f);
            requestLayout();
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f193334e0 = animatorSet2;
            animatorSet2.playTogether(u(), t(), v());
            animatorSet2.setInterpolator(new LinearInterpolator());
            animatorSet2.addListener(new f());
            animatorSet2.start();
            return;
        }
        this.W = true;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c s16 = s(jVar);
        this.Q = s16;
        W(s16);
        requestLayout();
    }

    private void O(com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar, Drawable drawable) {
        if (cVar != null && drawable != null) {
            cVar.f193376o = drawable;
            int i3 = this.f193335f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f16 = i3;
            float f17 = intrinsicWidth;
            float f18 = intrinsicHeight;
            float min = Math.min(f16 / f17, i3 / f18);
            float round = Math.round((f16 - (f17 * min)) * 0.5f) + this.f193338h;
            float round2 = Math.round((cVar.f193368g - (f18 * min)) * 0.5f);
            if (cVar.f193377p == null) {
                cVar.f193377p = new Rect();
            }
            cVar.f193377p.set(0, 0, intrinsicWidth, intrinsicHeight);
            if (cVar.f193378q == null) {
                cVar.f193378q = new RectF();
            }
            int i16 = (int) round;
            int i17 = (int) round2;
            int i18 = i16 + i3;
            int i19 = i3 + i17;
            cVar.f193378q.set(i16, i17, i18, i19);
            drawable.setBounds(i16, i17, i18, i19);
        }
    }

    private void P(com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar) {
        int measureText;
        cVar.f193368g = this.f193331d;
        if (TextUtils.isEmpty(cVar.f193369h)) {
            measureText = 0;
        } else {
            measureText = (int) this.K.measureText(cVar.f193369h);
        }
        if (this.f193337g0 == 1) {
            measureText = Math.max(cVar.f193372k, measureText);
            cVar.f193372k = measureText;
        }
        cVar.f193373l = (measureText / 2) + ViewUtils.dip2px(34.0f);
        Paint.FontMetrics fontMetrics = this.K.getFontMetrics();
        float f16 = cVar.f193368g / 2;
        float abs = Math.abs(fontMetrics.ascent);
        float f17 = fontMetrics.descent;
        cVar.f193374m = (int) ((f16 + ((abs + f17) / 2.0f)) - f17);
        cVar.f193367f = Math.max(ViewUtils.dip2px(46.0f) + measureText, this.f193333e);
        if (cVar.f193375n == null) {
            cVar.f193375n = new Path();
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.a.a(this.L, cVar.f193375n, cVar.f193367f, cVar.f193368g, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(float f16) {
        int i3 = (int) (255.0f * f16);
        this.L.setAlpha(i3);
        this.N.setAlpha(255 - i3);
        this.J.setColor(((Integer) this.T.evaluate(f16, Integer.valueOf(this.P.f193366e), Integer.valueOf(this.Q.f193366e))).intValue());
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(float f16) {
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.S;
        int i3 = cVar.f193368g;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.R;
        int i16 = cVar2.f193368g;
        int i17 = cVar.f193367f;
        int i18 = cVar2.f193367f;
        int i19 = i16 + ((int) ((i3 - i16) * f16));
        cVar.f193371j = i19;
        int i26 = i18 + ((int) ((i17 - i18) * f16));
        cVar.f193370i = i26;
        com.tencent.mobileqq.aio.reserve1.navigation.view.a.a(this.L, cVar.f193375n, i26, i19, Math.max(this.Q.f193367f, this.P.f193367f) - this.S.f193370i, Math.max(this.Q.f193368g, this.P.f193368g) - this.S.f193371j);
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(float f16) {
        this.K.setAlpha((int) (f16 * 255.0f));
        this.M.setAlpha((int) ((1.0f - f16) * 255.0f));
        float f17 = 0.2f * f16;
        this.K.setTextSize((int) (this.C * (f17 + 0.8f)));
        int max = Math.max(this.Q.f193367f, this.P.f193367f);
        int max2 = Math.max(this.Q.f193368g, this.P.f193368g);
        int measureText = (int) this.K.measureText(this.S.f193369h);
        if (this.f193337g0 == 1) {
            measureText = Math.max(this.S.f193372k, measureText);
            this.S.f193372k = measureText;
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.S;
        cVar.f193373l = max - (this.D + (measureText / 2));
        cVar.f193374m = (int) (max2 - ((max2 - this.Q.f193374m) * f16));
        this.M.setTextSize(this.C * 0.8f);
        Paint.FontMetrics fontMetrics = this.M.getFontMetrics();
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.R;
        int i3 = this.P.f193374m;
        cVar2.f193374m = (int) (i3 - ((i3 - Math.abs(fontMetrics.ascent)) * f16));
        this.M.setTextSize((int) (this.C * (1.0f - f17)));
        int measureText2 = (int) this.M.measureText(this.R.f193369h);
        if (this.f193337g0 == 1) {
            measureText2 = Math.max(this.R.f193372k, measureText2);
            this.R.f193372k = measureText2;
        }
        this.R.f193373l = max - (this.D + (measureText2 / 2));
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar3 = this.S;
        int i16 = (max - cVar3.f193370i) + this.f193338h;
        int i17 = cVar3.f193371j;
        cVar3.f193378q.set(i16, (max2 - i17) + ((i17 - this.f193335f) / 2), i16 + r3, r1 + r3);
        postInvalidate();
    }

    private void U(com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar, AXrLottieDrawable aXrLottieDrawable) {
        float min;
        if (cVar != null && aXrLottieDrawable != null) {
            cVar.f193379r = aXrLottieDrawable;
            int i3 = this.f193340i;
            int intrinsicWidth = aXrLottieDrawable.getIntrinsicWidth();
            int intrinsicHeight = aXrLottieDrawable.getIntrinsicHeight();
            if (intrinsicWidth <= i3 && intrinsicHeight <= i3) {
                min = 1.0f;
            } else {
                min = Math.min(i3 / intrinsicWidth, i3 / intrinsicHeight);
            }
            float round = Math.round((i3 - (intrinsicWidth * min)) * 0.5f) + this.f193343m;
            float round2 = Math.round((cVar.f193368g - (intrinsicHeight * min)) * 0.5f);
            if (cVar.f193380s == null) {
                cVar.f193380s = new Rect();
            }
            cVar.f193380s.set(0, 0, intrinsicWidth, intrinsicHeight);
            if (cVar.f193381t == null) {
                cVar.f193381t = new RectF();
            }
            cVar.f193381t.set((int) round, (int) round2, r9 + i3, r2 + i3);
        }
    }

    private void W(com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar) {
        this.J.setColor(cVar.f193366e);
        this.L.setColor(cVar.f193364c);
        this.K.setColor(cVar.f193365d);
        this.K.setAlpha(255);
        this.L.setAlpha(255);
        this.K.setTextSize(this.C);
    }

    private void X(com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar) {
        this.J.setColor(cVar.f193366e);
        this.N.setColor(cVar.f193364c);
        this.M.setColor(cVar.f193365d);
        this.M.setAlpha(255);
        this.M.setTextSize(this.C);
        this.N.setAlpha(255);
    }

    static /* bridge */ /* synthetic */ com.tencent.mobileqq.aio.reserve1.navigation.view.b i(AioNavAnimView aioNavAnimView) {
        aioNavAnimView.getClass();
        return null;
    }

    private com.tencent.mobileqq.aio.reserve1.navigation.view.c s(j jVar) {
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = new com.tencent.mobileqq.aio.reserve1.navigation.view.c();
        AIONavCorrelation aIONavCorrelation = jVar.f193355a;
        cVar.f193362a = aIONavCorrelation;
        cVar.f193369h = jVar.f193356b;
        cVar.f193363b = jVar.f193357c;
        com.tencent.mobileqq.aio.reserve1.navigation.view.a.b(cVar, aIONavCorrelation);
        P(cVar);
        O(cVar, B(jVar.f193355a));
        U(cVar, C(jVar.f193355a));
        if (!TextUtils.isEmpty(cVar.f193369h)) {
            AccessibilityUtil.s(this, cVar.f193369h);
        }
        return cVar;
    }

    private ValueAnimator t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private ValueAnimator u() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new a());
        return ofFloat;
    }

    private ValueAnimator v() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private void w(Canvas canvas, com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar, com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2) {
        canvas.drawPath(cVar.f193375n, this.J);
        canvas.drawPath(cVar.f193375n, this.L);
        canvas.drawPath(cVar.f193375n, this.N);
        if (!TextUtils.isEmpty(cVar.f193369h)) {
            canvas.drawText(cVar.f193369h, cVar.f193373l, cVar.f193374m, this.K);
        }
        if (!TextUtils.isEmpty(cVar2.f193369h)) {
            canvas.drawText(cVar2.f193369h, cVar2.f193373l, cVar2.f193374m, this.M);
        }
        if (cVar.f193376o != null && cVar2.f193376o != null) {
            canvas.save();
            y(canvas, cVar2, this.M);
            canvas.restore();
            canvas.save();
            y(canvas, cVar, this.K);
            canvas.restore();
        }
    }

    private void x(Canvas canvas, com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar) {
        canvas.drawPath(cVar.f193375n, this.J);
        canvas.drawPath(cVar.f193375n, this.L);
        if (!TextUtils.isEmpty(cVar.f193369h)) {
            canvas.drawText(cVar.f193369h, cVar.f193373l, cVar.f193374m, this.K);
        }
        boolean z16 = this.W;
        if ((!z16 && cVar.f193379r != null) || (z16 && cVar.f193376o != null)) {
            canvas.save();
            if (this.W) {
                if (this.f193328a0) {
                    cVar.f193376o.draw(canvas);
                }
                y(canvas, cVar, this.K);
            } else {
                com.tencent.rlottie.c e16 = this.f193330c0.e();
                if (e16 != null && e16.b()) {
                    canvas.drawBitmap(e16.a(), cVar.f193380s, cVar.f193381t, this.K);
                }
            }
            canvas.restore();
        }
    }

    private void y(Canvas canvas, com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar, Paint paint) {
        Drawable drawable = cVar.f193376o;
        if (drawable instanceof ApngDrawable) {
            canvas.drawBitmap(((ApngDrawable) drawable).getImage().getCurrentFrame(), cVar.f193377p, cVar.f193378q, paint);
        } else {
            drawable.draw(canvas);
        }
    }

    private void z(boolean z16) {
        int i3;
        int i16;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.Q;
        if (cVar2 == null) {
            return;
        }
        int i17 = cVar2.f193367f;
        if (this.V && (cVar = this.P) != null) {
            i3 = cVar.f193367f;
        } else {
            i3 = 0;
        }
        int max = Math.max(i17, i3);
        if (z16) {
            if (getTranslationX() <= 0.0f && getVisibility() == 0) {
                return;
            } else {
                i16 = 0;
            }
        } else {
            if (getTranslationX() >= max) {
                return;
            }
            i16 = max;
            max = 0;
        }
        Animator animator = this.f193336f0;
        if (animator != null && animator.isRunning()) {
            this.f193336f0.cancel();
            max = (int) getTranslationX();
            N();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioNavAnimView", 2, "execSlideAnim: isShow = " + z16);
        }
        setTranslationX(max);
        setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(max, i16);
        ofInt.addUpdateListener(new b());
        ofInt.addListener(new c(z16));
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        this.f193336f0 = ofInt;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.H != null && this.I != null && this.G != null && this.F != null) {
            return true;
        }
        return false;
    }

    public boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (getVisibility() == 0 && getTranslationX() == 0.0f) {
            return true;
        }
        return false;
    }

    public void I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.Q;
        if (cVar == null) {
            V(str);
            return;
        }
        cVar.f193369h = str;
        P(cVar);
        requestLayout();
    }

    public void J(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioNavAnimView", 2, "showMoveDownAnim: visibility=" + getVisibility() + ", translationY=" + f16);
        }
        if (getVisibility() == 8) {
            setTranslationY(f16);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getTranslationY(), f16);
        ofFloat.addUpdateListener(new d());
        ofFloat.addListener(new e(f16));
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            z(true);
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f193328a0 = true;
        if (this.Q != null && !this.V && getVisibility() != 8) {
            N();
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.Q;
            AXrLottieDrawable aXrLottieDrawable = cVar.f193379r;
            Drawable drawable = cVar.f193376o;
            boolean z16 = this.W;
            if (z16 && drawable != null) {
                if (drawable instanceof ApngDrawable) {
                    ApngDrawable apngDrawable = (ApngDrawable) drawable;
                    AnimationCallback A = A();
                    apngDrawable.getImage().removeCallBack(A);
                    apngDrawable.getImage().addCallBack(A);
                    apngDrawable.resume();
                }
            } else if (!z16 && aXrLottieDrawable != null) {
                this.f193330c0.h(aXrLottieDrawable);
                this.f193330c0.g();
                aXrLottieDrawable.start();
            }
            postInvalidate();
        }
    }

    @AnyThread
    public void M(AIONavCorrelation aIONavCorrelation, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, aIONavCorrelation, str, obj);
            return;
        }
        this.U.add(new j(aIONavCorrelation, str, obj));
        if (this.V) {
            return;
        }
        this.f193329b0.removeCallbacks(this.f193342j0);
        this.f193329b0.post(this.f193342j0);
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.F;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
        AXrLottieDrawable aXrLottieDrawable2 = this.G;
        if (aXrLottieDrawable2 != null) {
            aXrLottieDrawable2.stop();
        }
        Drawable drawable = this.I;
        if (drawable instanceof ApngDrawable) {
            ApngDrawable apngDrawable = (ApngDrawable) drawable;
            apngDrawable.getImage().removeCallBack(A());
            apngDrawable.pause();
        }
        Drawable drawable2 = this.H;
        if (drawable2 instanceof ApngDrawable) {
            ApngDrawable apngDrawable2 = (ApngDrawable) drawable2;
            apngDrawable2.getImage().removeCallBack(A());
            apngDrawable2.pause();
        }
        this.f193330c0.stop();
    }

    public void S(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        AXrLottieDrawable aXrLottieDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, drawable, drawable2, drawable3, drawable4);
            return;
        }
        this.I = drawable;
        this.H = drawable2;
        AXrLottieDrawable aXrLottieDrawable2 = null;
        if (drawable3 instanceof AXrLottieDrawable) {
            aXrLottieDrawable = (AXrLottieDrawable) drawable3;
        } else {
            aXrLottieDrawable = null;
        }
        this.F = aXrLottieDrawable;
        if (drawable4 instanceof AXrLottieDrawable) {
            aXrLottieDrawable2 = (AXrLottieDrawable) drawable4;
        }
        this.G = aXrLottieDrawable2;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.Q;
        if (cVar != null) {
            O(cVar, B(cVar.f193362a));
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.Q;
            U(cVar2, C(cVar2.f193362a));
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar3 = this.S;
            if (cVar3 != null) {
                com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar4 = this.Q;
                cVar3.f193377p = cVar4.f193377p;
                cVar3.f193378q = cVar4.f193378q;
            }
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar5 = this.P;
        if (cVar5 != null) {
            O(cVar5, B(cVar5.f193362a));
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar6 = this.P;
            U(cVar6, C(cVar6.f193362a));
            com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar7 = this.R;
            if (cVar7 != null) {
                com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar8 = this.P;
                cVar7.f193377p = cVar8.f193377p;
                cVar7.f193378q = cVar8.f193378q;
            }
        }
        postInvalidate();
    }

    public void V(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar = this.Q;
        if (cVar != null) {
            Y(cVar.f193362a, str, cVar.f193363b);
        } else {
            Y(AIONavCorrelation.WEAK, str, null);
        }
    }

    public void Y(AIONavCorrelation aIONavCorrelation, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, aIONavCorrelation, str, obj);
            return;
        }
        AnimatorSet animatorSet = this.f193334e0;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f193334e0.cancel();
            this.f193334e0 = null;
        }
        this.U.clear();
        this.V = false;
        this.Q = null;
        this.P = null;
        G(new j(aIONavCorrelation, str, obj));
    }

    @Override // com.tencent.mobileqq.aio.reserve1.navigation.view.LottiePlayHelper.a
    public void a(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bitmap);
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.Q != null && getVisibility() == 0) {
            try {
                canvas.setDrawFilter(this.f193332d0);
                if (this.V) {
                    com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2 = this.S;
                    if (cVar2 != null && (cVar = this.R) != null) {
                        w(canvas, cVar2, cVar);
                    }
                    return;
                }
                x(canvas, this.Q);
            } catch (Exception e16) {
                Log.d("AioNavAnimView", "onDraw exception: " + e16);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar;
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getVisibility() == 8) {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
            return;
        }
        if (this.V && (cVar = this.Q) != null && (cVar2 = this.P) != null) {
            int max = Math.max(cVar.f193367f, cVar2.f193367f);
            int max2 = Math.max(this.Q.f193368g, this.P.f193368g);
            if (QLog.isDevelopLevel()) {
                QLog.d("AioNavAnimView", 4, "onMeasure: mIsInChangeAnim: width = " + max + ", height = " + max2);
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
            return;
        }
        com.tencent.mobileqq.aio.reserve1.navigation.view.c cVar3 = this.Q;
        if (cVar3 == null) {
            super.onMeasure(i3, i16);
        } else {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(cVar3.f193367f, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Q.f193368g, 1073741824));
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.W = z16;
            L();
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        N();
        this.G = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.V = false;
        this.f193328a0 = false;
        this.U.clear();
        this.f193329b0.removeCallbacksAndMessages(null);
        this.P = null;
        this.Q = null;
        this.S = null;
        this.R = null;
        this.f193339h0 = null;
    }

    public void setFrom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.f193337g0 = i3;
        }
    }

    public void setOnStateChangeListener(com.tencent.mobileqq.aio.reserve1.navigation.view.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) bVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 != 0) {
            N();
        }
    }

    public AioNavAnimView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AioNavAnimView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.T = new ArgbEvaluator();
        this.U = new ConcurrentLinkedQueue<>();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f193329b0 = handler;
        this.f193332d0 = new PaintFlagsDrawFilter(0, 3);
        this.f193337g0 = -1;
        this.f193342j0 = new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.navigation.view.AioNavAnimView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AioNavAnimView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                j jVar = (j) AioNavAnimView.this.U.poll();
                if (jVar == null) {
                    AioNavAnimView.this.V = false;
                    if (AioNavAnimView.this.f193328a0) {
                        AioNavAnimView aioNavAnimView = AioNavAnimView.this;
                        aioNavAnimView.q(aioNavAnimView.W);
                        return;
                    }
                    return;
                }
                Log.d("AioNavAnimView", "mUpdateRunnable is run!");
                AioNavAnimView.this.G(jVar);
            }
        };
        this.f193331d = ViewUtils.dip2px(40.0f);
        this.f193333e = ViewUtils.dip2px(46.0f);
        this.f193335f = ViewUtils.dip2px(20.0f);
        this.f193340i = ViewUtils.dip2px(16.0f);
        this.C = ViewUtils.dip2px(14.0f);
        this.D = ViewUtils.dip2px(12.0f);
        this.E = ViewUtils.dip2px(0.5f);
        this.f193338h = ViewUtils.dip2px(10.0f);
        this.f193343m = ViewUtils.dip2px(12.0f);
        LottiePlayHelper lottiePlayHelper = new LottiePlayHelper(handler);
        this.f193330c0 = lottiePlayHelper;
        lottiePlayHelper.f(this);
        F();
    }
}
