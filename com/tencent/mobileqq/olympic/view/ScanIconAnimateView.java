package com.tencent.mobileqq.olympic.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ScanIconAnimateView extends View {
    static IPatchRedirector $redirector_;
    float C;
    float D;
    DrawFilter E;
    ValueAnimator F;
    AnimatorSet G;
    ValueAnimator H;
    ValueAnimator I;
    ValueAnimator J;
    ValueAnimator K;
    float L;
    float M;
    ValueAnimator N;
    ValueAnimator P;
    i Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    Bitmap f255238d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f255239e;

    /* renamed from: f, reason: collision with root package name */
    Paint f255240f;

    /* renamed from: h, reason: collision with root package name */
    Paint f255241h;

    /* renamed from: i, reason: collision with root package name */
    float f255242i;

    /* renamed from: m, reason: collision with root package name */
    float f255243m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.f255242i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.f255242i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.f255243m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.D = ((Float) valueAnimator.getAnimatedValue()).floatValue() * (-1.0f) * BaseAIOUtils.f(1.5f, ScanIconAnimateView.this.getResources());
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.M = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ScanIconAnimateView.this.L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScanIconAnimateView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanIconAnimateView.this);
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
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ScanIconAnimateView.this.R = true;
                i iVar = ScanIconAnimateView.this.Q;
                if (iVar != null) {
                    iVar.onEnd();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
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
                return;
            }
            i iVar = ScanIconAnimateView.this.Q;
            if (iVar != null) {
                iVar.onStart();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface i {
        void onEnd();

        void onStart();
    }

    public ScanIconAnimateView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b(Context context) {
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.hau);
            int f16 = BaseAIOUtils.f(32.0f, getResources());
            int i3 = f16 * 2;
            this.f255238d = Bitmap.createScaledBitmap(decodeResource, i3, i3, true);
            this.f255239e = Bitmap.createScaledBitmap(decodeResource2, f16, f16, true);
            Paint paint = new Paint();
            this.f255240f = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f255241h = paint2;
            paint2.setAntiAlias(true);
            this.E = new PaintFlagsDrawFilter(0, 3);
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.13333334f, 8.0f), Keyframe.ofFloat(0.2f, -6.0f), Keyframe.ofFloat(0.26666668f, 3.0f), Keyframe.ofFloat(0.33333334f, 0.0f), Keyframe.ofFloat(0.6666667f, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            this.F = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(1500L);
            this.F.setRepeatCount(-1);
            this.F.addUpdateListener(new a());
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.2f, 40.0f), Keyframe.ofFloat(0.4f, -20.0f), Keyframe.ofFloat(0.6f, 5.0f), Keyframe.ofFloat(0.8f, -5.0f), Keyframe.ofFloat(0.9f, 3.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            this.H = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(1000L);
            this.H.setInterpolator(new AccelerateDecelerateInterpolator());
            this.H.addUpdateListener(new b());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f, 1.0f, 1.0f, 0.5f, 0.5f);
            this.I = ofFloat;
            ofFloat.setDuration(1000L);
            this.I.setInterpolator(new AccelerateDecelerateInterpolator());
            this.I.addUpdateListener(new c());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f);
            this.J = ofFloat2;
            ofFloat2.setDuration(1000L);
            this.J.addUpdateListener(new d());
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            this.K = ofFloat3;
            ofFloat3.setDuration(1000L);
            this.K.addUpdateListener(new e());
            ValueAnimator ofPropertyValuesHolder3 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.6f, 1.0f), Keyframe.ofFloat(0.8f, 1.08f), Keyframe.ofFloat(0.9f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)));
            this.N = ofPropertyValuesHolder3;
            ofPropertyValuesHolder3.setDuration(1000L);
            this.N.addUpdateListener(new f());
            ValueAnimator ofPropertyValuesHolder4 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.6f, 0.0f), Keyframe.ofFloat(0.9f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)));
            this.P = ofPropertyValuesHolder4;
            ofPropertyValuesHolder4.setDuration(1000L);
            this.P.addUpdateListener(new g());
            AnimatorSet animatorSet = new AnimatorSet();
            this.G = animatorSet;
            animatorSet.setDuration(1000L);
            this.G.playTogether(this.H, this.I, this.K, this.J, this.N, this.P);
            this.G.addListener(new h());
        } catch (OutOfMemoryError e16) {
            QLog.d("ScanIconAnimateView", 1, "init failed ", e16);
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        boolean isRunning = this.F.isRunning();
        if (QLog.isColorLevel()) {
            QLog.d("ScanIconAnimateView", 2, "isPendulumRunning = " + isRunning);
        }
        return isRunning;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanIconAnimateView", 2, "startPendulumAnim ");
        }
        if (!this.R) {
            return;
        }
        this.F.start();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanIconAnimateView", 2, "startPopUpAnim ");
        }
        if (this.R) {
            return;
        }
        this.G.start();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanIconAnimateView", 2, "stopPendulumAnim ");
        }
        this.F.cancel();
        this.f255242i = 0.0f;
        invalidate();
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanIconAnimateView", 2, "stopPopUpAnim ");
        }
        this.G.cancel();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.save();
        this.f255241h.setAlpha((int) (this.L * 255.0f));
        float f16 = this.M;
        canvas.scale(f16, f16, BaseAIOUtils.f(16.0f, getResources()), BaseAIOUtils.f(16.0f, getResources()));
        canvas.drawBitmap(this.f255239e, 0.0f, 0.0f, this.f255241h);
        canvas.restore();
        canvas.save();
        canvas.translate(0.0f, this.D);
        float f17 = this.f255243m;
        canvas.scale(f17, f17, BaseAIOUtils.f(16.0f, getResources()), BaseAIOUtils.f(23.0f, getResources()));
        canvas.rotate(this.f255242i, BaseAIOUtils.f(16.0f, getResources()), BaseAIOUtils.f(23.0f, getResources()));
        this.f255240f.setAlpha((int) (this.C * 255.0f));
        canvas.setDrawFilter(this.E);
        canvas.drawBitmap(this.f255238d, BaseAIOUtils.f(-16.0f, getResources()), BaseAIOUtils.f(-23.0f, getResources()), this.f255240f);
        canvas.restore();
    }

    public void setPopUpListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
        } else {
            this.Q = iVar;
        }
    }

    public ScanIconAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ScanIconAnimateView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f255242i = 0.0f;
        this.f255243m = 0.5f;
        this.C = 1.0f;
        this.D = 0.0f;
        this.L = 1.0f;
        this.M = 1.0f;
        this.R = false;
        b(context);
    }
}
