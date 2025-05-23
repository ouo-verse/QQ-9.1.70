package com.tencent.mobileqq.troop.widget;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RedDotAnimateView extends View {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    ValueAnimator E;
    ValueAnimator F;
    ValueAnimator G;
    AnimatorSet H;

    /* renamed from: d, reason: collision with root package name */
    Paint f302375d;

    /* renamed from: e, reason: collision with root package name */
    Paint f302376e;

    /* renamed from: f, reason: collision with root package name */
    int f302377f;

    /* renamed from: h, reason: collision with root package name */
    int f302378h;

    /* renamed from: i, reason: collision with root package name */
    float f302379i;

    /* renamed from: m, reason: collision with root package name */
    float f302380m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedDotAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            RedDotAnimateView redDotAnimateView = RedDotAnimateView.this;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RedDotAnimateView redDotAnimateView2 = RedDotAnimateView.this;
            redDotAnimateView.f302380m = (floatValue * redDotAnimateView2.f302377f) / 2.0f;
            redDotAnimateView2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedDotAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            RedDotAnimateView redDotAnimateView = RedDotAnimateView.this;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RedDotAnimateView redDotAnimateView2 = RedDotAnimateView.this;
            redDotAnimateView.f302379i = (floatValue * redDotAnimateView2.f302377f) / 2.0f;
            redDotAnimateView2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedDotAnimateView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            RedDotAnimateView.this.C = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            RedDotAnimateView.this.invalidate();
        }
    }

    public RedDotAnimateView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = 76;
        this.D = 255;
        a();
    }

    void a() {
        Paint paint = new Paint();
        this.f302375d = paint;
        paint.setAntiAlias(true);
        this.f302375d.setColor(Color.rgb(241, 54, 27));
        this.f302375d.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f302376e = paint2;
        paint2.setAntiAlias(true);
        this.f302376e.setColor(Color.rgb(241, 54, 27));
        this.f302376e.setStyle(Paint.Style.FILL);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.33333334f, 1.9f), Keyframe.ofFloat(0.5f, 0.58f), Keyframe.ofFloat(0.6666667f, 1.25f), Keyframe.ofFloat(1.0f, 1.0f)));
        this.G = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(1600L);
        this.G.setInterpolator(new AccelerateDecelerateInterpolator());
        this.G.addUpdateListener(new a());
        ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.13333334f, 0.0f), Keyframe.ofFloat(0.33333334f, 3.0f), Keyframe.ofFloat(0.5f, 1.4f), Keyframe.ofFloat(0.6666667f, 2.08f), Keyframe.ofFloat(1.0f, 2.08f)));
        this.E = ofPropertyValuesHolder2;
        ofPropertyValuesHolder2.setDuration(1600L);
        this.E.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E.addUpdateListener(new b());
        ValueAnimator ofPropertyValuesHolder3 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("", Keyframe.ofFloat(0.0f, 0.3f), Keyframe.ofFloat(0.13333334f, 0.3f), Keyframe.ofFloat(0.33333334f, 0.3f), Keyframe.ofFloat(0.5f, 0.3f), Keyframe.ofFloat(0.6666667f, 0.3f), Keyframe.ofFloat(1.0f, 0.0f)));
        this.F = ofPropertyValuesHolder3;
        ofPropertyValuesHolder3.setDuration(1600L);
        this.F.setInterpolator(new LinearInterpolator());
        this.F.addUpdateListener(new c());
        AnimatorSet animatorSet = new AnimatorSet();
        this.H = animatorSet;
        animatorSet.setDuration(1600L);
        this.H.playTogether(this.G, this.E, this.F);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f302378h == 0) {
            this.f302378h = getHeight();
        }
        if (this.f302377f == 0) {
            this.f302377f = getWidth();
        }
        this.f302375d.setAlpha(this.D);
        canvas.drawCircle(this.f302377f / 2, this.f302378h / 2, this.f302380m, this.f302375d);
        this.f302376e.setAlpha(this.C);
        canvas.drawCircle(this.f302377f / 2, this.f302378h / 2, this.f302379i, this.f302376e);
    }

    public void setStaticRedDot(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f302377f = i3;
        this.f302378h = i16;
        this.C = 0;
        this.f302380m = i3 / 2;
        invalidate();
    }

    public void setVisibleAndZeroRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f302379i = 0.0f;
        this.f302380m = 0.0f;
        setVisibility(0);
    }

    public RedDotAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = 76;
        this.D = 255;
        a();
    }
}
