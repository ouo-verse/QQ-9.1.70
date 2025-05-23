package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class f extends Drawable implements Animatable2Compat {
    private static final Property<f, Float> K = new c(Float.class, "growFraction");
    private boolean C;
    private float D;
    private List<Animatable2Compat.AnimationCallback> E;
    private Animatable2Compat.AnimationCallback F;
    private boolean G;
    private float H;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    final Context f33975d;

    /* renamed from: e, reason: collision with root package name */
    final com.google.android.material.progressindicator.b f33976e;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f33978h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f33979i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f33980m;
    final Paint I = new Paint();

    /* renamed from: f, reason: collision with root package name */
    com.google.android.material.progressindicator.a f33977f = new com.google.android.material.progressindicator.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c extends Property<f, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.h());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(f fVar, Float f16) {
            fVar.o(f16.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(@NonNull Context context, @NonNull com.google.android.material.progressindicator.b bVar) {
        this.f33975d = context;
        this.f33976e = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.F;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.E;
        if (list != null && !this.G) {
            Iterator<Animatable2Compat.AnimationCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Animatable2Compat.AnimationCallback animationCallback = this.F;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.E;
        if (list != null && !this.G) {
            Iterator<Animatable2Compat.AnimationCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onAnimationStart(this);
            }
        }
    }

    private void g(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z16 = this.G;
        this.G = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.G = z16;
    }

    private void n() {
        if (this.f33978h == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, K, 0.0f, 1.0f);
            this.f33978h = ofFloat;
            ofFloat.setDuration(500L);
            this.f33978h.setInterpolator(x0.a.f446811b);
            q(this.f33978h);
        }
        if (this.f33979i == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, K, 1.0f, 0.0f);
            this.f33979i = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f33979i.setInterpolator(x0.a.f446811b);
            p(this.f33979i);
        }
    }

    private void p(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f33979i;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f33979i = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void q(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f33978h;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f33978h = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public void clearAnimationCallbacks() {
        this.E.clear();
        this.E = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        if (!this.f33976e.b() && !this.f33976e.a()) {
            return 1.0f;
        }
        if (!this.C && !this.f33980m) {
            return this.H;
        }
        return this.D;
    }

    public boolean isRunning() {
        if (!m() && !k()) {
            return false;
        }
        return true;
    }

    public boolean j() {
        return t(false, false, false);
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f33979i;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.C) {
            return true;
        }
        return false;
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f33978h;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f33980m) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (this.H != f16) {
            this.H = f16;
            invalidateSelf();
        }
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.E == null) {
            this.E = new ArrayList();
        }
        if (!this.E.contains(animationCallback)) {
            this.E.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.J = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.I.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        return t(z16, z17, true);
    }

    public void start() {
        u(true, true, false);
    }

    public void stop() {
        u(false, true, false);
    }

    public boolean t(boolean z16, boolean z17, boolean z18) {
        boolean z19;
        float a16 = this.f33977f.a(this.f33975d.getContentResolver());
        if (z18 && a16 > 0.0f) {
            z19 = true;
        } else {
            z19 = false;
        }
        return u(z16, z17, z19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(boolean z16, boolean z17, boolean z18) {
        ValueAnimator valueAnimator;
        boolean z19;
        boolean a16;
        n();
        if (!isVisible() && !z16) {
            return false;
        }
        if (z16) {
            valueAnimator = this.f33978h;
        } else {
            valueAnimator = this.f33979i;
        }
        if (!z18) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z16, false);
        }
        if (z18 && valueAnimator.isRunning()) {
            return false;
        }
        if (z16 && !super.setVisible(z16, false)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z16) {
            a16 = this.f33976e.b();
        } else {
            a16 = this.f33976e.a();
        }
        if (!a16) {
            g(valueAnimator);
            return z19;
        }
        if (!z17 && valueAnimator.isPaused()) {
            valueAnimator.resume();
        } else {
            valueAnimator.start();
        }
        return z19;
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.E;
        if (list != null && list.contains(animationCallback)) {
            this.E.remove(animationCallback);
            if (this.E.isEmpty()) {
                this.E = null;
                return true;
            }
            return true;
        }
        return false;
    }
}
