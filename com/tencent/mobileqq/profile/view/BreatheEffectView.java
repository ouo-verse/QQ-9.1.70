package com.tencent.mobileqq.profile.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import uy2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BreatheEffectView extends ImageView implements a.c {
    static IPatchRedirector $redirector_;
    public static final int[] D;
    private static int E;
    private TypeEvaluator C;

    /* renamed from: d, reason: collision with root package name */
    private AnimatorSet f260364d;

    /* renamed from: e, reason: collision with root package name */
    private LayerDrawable f260365e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable[] f260366f;

    /* renamed from: h, reason: collision with root package name */
    private Rect[] f260367h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f260368i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f260369m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements TypeEvaluator<Rect> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BreatheEffectView.this);
            }
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect evaluate(float f16, Rect rect, Rect rect2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Rect) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), rect, rect2);
            }
            return new Rect(rect.left + ((int) ((rect2.left - r1) * f16)), rect.top + ((int) ((rect2.top - r2) * f16)), rect.right + ((int) ((rect2.right - r3) * f16)), rect.bottom + ((int) ((rect2.bottom - r7) * f16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f260371d;

        b(long j3) {
            this.f260371d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BreatheEffectView.this, Long.valueOf(j3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
            } else {
                if (Math.abs(SystemClock.currentThreadTimeMillis() - this.f260371d) < 100) {
                    return;
                }
                BreatheEffectView.this.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f260373d;

        c(Drawable drawable) {
            this.f260373d = drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BreatheEffectView.this, (Object) drawable);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                this.f260373d.setBounds((Rect) valueAnimator.getAnimatedValue());
                BreatheEffectView.this.invalidate();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f260375d;

        d(f fVar) {
            this.f260375d = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BreatheEffectView.this, (Object) fVar);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f260375d.onBreatheShown();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f260377d;

        e(Drawable drawable) {
            this.f260377d = drawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BreatheEffectView.this, (Object) drawable);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Rect rect = (Rect) valueAnimator.getAnimatedValue();
            this.f260377d.setBounds(rect);
            BreatheEffectView.this.invalidate(rect);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface f {
        void onBreatheShown();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            D = new int[]{170, 112, 112};
        }
    }

    public BreatheEffectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = new a();
            g();
        }
    }

    private void g() {
        E = getResources().getDimensionPixelSize(R.dimen.an8);
        setBackgroundResource(R.drawable.ap9);
        Drawable background = getBackground();
        if (background instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) background;
            this.f260365e = layerDrawable;
            Drawable[] drawableArr = new Drawable[3];
            this.f260366f = drawableArr;
            drawableArr[2] = layerDrawable.findDrawableByLayerId(R.id.f164601a84);
            this.f260366f[1] = this.f260365e.findDrawableByLayerId(R.id.a85);
            this.f260366f[0] = this.f260365e.findDrawableByLayerId(R.id.a7z);
            return;
        }
        throw new RuntimeException("Background is not a layer drawable!");
    }

    private void h() {
        if (this.f260367h == null) {
            this.f260367h = new Rect[3];
            for (int i3 = 0; i3 < 3; i3++) {
                this.f260367h[i3] = new Rect(this.f260366f[i3].getBounds());
            }
            for (int i16 = 1; i16 < 3; i16++) {
                Drawable drawable = this.f260366f[i16];
                Rect rect = this.f260367h[i16];
                int centerX = rect.centerX();
                int centerY = rect.centerY();
                drawable.setBounds(centerX, centerY, centerX, centerY);
            }
        }
    }

    private boolean n() {
        if (this.f260365e != null && getBackground() == this.f260365e) {
            return true;
        }
        return false;
    }

    @Override // uy2.a.c
    public boolean a(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        Rect rect = this.f260369m;
        if (rect != null) {
            return rect.contains((int) f16, (int) f17);
        }
        if (this.f260368i == null) {
            int[] iArr = new int[2];
            this.f260368i = iArr;
            getLocationOnScreen(iArr);
        }
        int width = getWidth() + this.f260368i[0];
        int height = getHeight();
        int i3 = this.f260368i[1];
        int i16 = height + i3;
        if (f16 >= r4[0] && f16 <= width && f17 >= i3 && f17 <= i16) {
            return true;
        }
        return false;
    }

    @Override // uy2.a.c
    public boolean b(a.InterfaceC11376a interfaceC11376a, a.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, interfaceC11376a, bVar, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        k();
        return true;
    }

    @Override // uy2.a.c
    public void c(a.InterfaceC11376a interfaceC11376a, a.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, interfaceC11376a, bVar, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            m();
            j();
        }
    }

    @Override // uy2.a.c
    public boolean d(a.InterfaceC11376a interfaceC11376a, a.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 7, this, interfaceC11376a, bVar, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
    }

    @Override // uy2.a.c
    public void e(a.InterfaceC11376a interfaceC11376a, a.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, interfaceC11376a, bVar, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    public void f(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) fVar);
            return;
        }
        if (n()) {
            clearAnimation();
            AnimatorSet animatorSet = new AnimatorSet();
            for (int i3 = 1; i3 < 3; i3++) {
                Drawable drawable = this.f260366f[i3];
                Rect rect = this.f260367h[i3];
                int centerX = rect.centerX();
                int centerY = rect.centerY();
                ValueAnimator ofObject = ValueAnimator.ofObject(this.C, rect, new Rect(centerX, centerY, centerX, centerY));
                ofObject.addUpdateListener(new e(drawable));
                ofObject.setDuration(400L);
                animatorSet.playTogether(ofObject);
            }
            animatorSet.start();
        }
    }

    public void i(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fVar);
            return;
        }
        if (n()) {
            l();
            h();
            AnimatorSet animatorSet = new AnimatorSet();
            for (int i3 = 1; i3 < 3; i3++) {
                Drawable drawable = this.f260366f[i3];
                Rect rect = this.f260367h[i3];
                int centerX = rect.centerX();
                int centerY = rect.centerY();
                Rect rect2 = new Rect(centerX, centerY, centerX, centerY);
                drawable.setBounds(rect2);
                ValueAnimator ofObject = ValueAnimator.ofObject(this.C, rect2, rect);
                ofObject.addUpdateListener(new c(drawable));
                ofObject.setDuration(400L);
                ofObject.setStartDelay(i3 * 50);
                animatorSet.playTogether(ofObject);
            }
            if (fVar != null) {
                animatorSet.addListener(new d(fVar));
            }
            animatorSet.setInterpolator(new OvershootInterpolator(1.6f));
            animatorSet.start();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (n()) {
            if (this.f260364d == null) {
                this.f260364d = new AnimatorSet();
                for (int i3 = 0; i3 < 3; i3++) {
                    Drawable drawable = this.f260366f[i3];
                    Rect rect = new Rect();
                    Rect rect2 = this.f260367h[i3];
                    int i16 = rect2.left;
                    int i17 = E;
                    rect.left = i16 - i17;
                    rect.top = rect2.top - i17;
                    rect.right = rect2.right + i17;
                    rect.bottom = rect2.bottom + i17;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(drawable, "bounds", this.C, rect2, rect);
                    long j3 = i3 * 180;
                    ofObject.setStartDelay(j3);
                    ofObject.setDuration(600L);
                    ofObject.setInterpolator(new CycleInterpolator(0.5f));
                    ObjectAnimator ofInt = ObjectAnimator.ofInt(drawable, com.tencent.luggage.wxa.c8.c.f123400v, 0, 255);
                    ofInt.setInterpolator(new CycleInterpolator(0.5f));
                    ofInt.setStartDelay(j3);
                    ofInt.setDuration(600L);
                    this.f260364d.playTogether(ofInt);
                    if (2 == i3) {
                        ofObject.addListener(new b(SystemClock.currentThreadTimeMillis()));
                    }
                    this.f260364d.playTogether(ofObject);
                }
            }
            this.f260364d.start();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (n()) {
            AnimatorSet animatorSet = new AnimatorSet();
            for (int i3 = 0; i3 < 3; i3++) {
                Drawable drawable = this.f260366f[i3];
                Rect rect = this.f260367h[i3];
                Rect rect2 = new Rect();
                int i16 = rect.left;
                int i17 = E;
                rect2.left = i16 - i17;
                rect2.top = rect.top - i17;
                rect2.right = rect.right + i17;
                rect2.bottom = rect.bottom + i17;
                ObjectAnimator duration = ObjectAnimator.ofObject(drawable, "bounds", this.C, rect, rect2).setDuration(800L);
                duration.setInterpolator(new AccelerateInterpolator(0.24f));
                ObjectAnimator duration2 = ObjectAnimator.ofInt(drawable, com.tencent.luggage.wxa.c8.c.f123400v, 204, 0).setDuration(800L);
                duration2.setInterpolator(new AccelerateInterpolator(0.24f));
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
                ofInt.setDuration(1000L);
                animatorSet.playTogether(duration, duration2, ofInt);
            }
            animatorSet.start();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (n() && this.f260367h != null) {
            clearAnimation();
            for (int i3 = 0; i3 < 3; i3++) {
                this.f260366f[i3].setBounds(this.f260367h[i3]);
                this.f260366f[i3].setAlpha(255);
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            h();
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
        }
    }

    public void setHaloColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.f260366f != null) {
            for (int i16 = 0; i16 < 3; i16++) {
                Drawable drawable = this.f260366f[i16];
                if (drawable instanceof GradientDrawable) {
                    int i17 = (16777215 & i3) | (D[i16] << 24);
                    if (i16 != 0) {
                        ((GradientDrawable) drawable).setColor(i17);
                    } else {
                        ((GradientDrawable) drawable).setStroke(2, i17);
                    }
                }
            }
        }
    }

    public void setHoverHotArea(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rect);
        } else {
            this.f260369m = rect;
        }
    }

    public BreatheEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.C = new a();
            g();
        }
    }

    public BreatheEffectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.C = new a();
            g();
        }
    }
}
