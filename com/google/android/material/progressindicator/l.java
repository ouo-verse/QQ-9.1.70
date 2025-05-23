package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class l extends h<ObjectAnimator> {

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f33999l = {533, 567, 850, 750};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f34000m = {1267, 1000, 333, 0};

    /* renamed from: n, reason: collision with root package name */
    private static final Property<l, Float> f34001n = new c(Float.class, "animationFraction");

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f34002d;

    /* renamed from: e, reason: collision with root package name */
    private ObjectAnimator f34003e;

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator[] f34004f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f34005g;

    /* renamed from: h, reason: collision with root package name */
    private int f34006h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34007i;

    /* renamed from: j, reason: collision with root package name */
    private float f34008j;

    /* renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f34009k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f34006h = (lVar.f34006h + 1) % l.this.f34005g.f33952c.length;
            l.this.f34007i = true;
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
            l.this.a();
            l lVar = l.this;
            Animatable2Compat.AnimationCallback animationCallback = lVar.f34009k;
            if (animationCallback != null) {
                animationCallback.onAnimationEnd(lVar.f33985a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c extends Property<l, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f16) {
            lVar.r(f16.floatValue());
        }
    }

    public l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f34006h = 0;
        this.f34009k = null;
        this.f34005g = linearProgressIndicatorSpec;
        this.f34004f = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.f155136p), AnimationUtilsCompat.loadInterpolator(context, R.animator.f155137q), AnimationUtilsCompat.loadInterpolator(context, R.animator.f155138r), AnimationUtilsCompat.loadInterpolator(context, R.animator.f155139s)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f34008j;
    }

    private void o() {
        if (this.f34002d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f34001n, 0.0f, 1.0f);
            this.f34002d = ofFloat;
            ofFloat.setDuration(JoinTimeType.THIRTY_MINUTES);
            this.f34002d.setInterpolator(null);
            this.f34002d.setRepeatCount(-1);
            this.f34002d.addListener(new a());
        }
        if (this.f34003e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f34001n, 1.0f);
            this.f34003e = ofFloat2;
            ofFloat2.setDuration(JoinTimeType.THIRTY_MINUTES);
            this.f34003e.setInterpolator(null);
            this.f34003e.addListener(new b());
        }
    }

    private void p() {
        if (this.f34007i) {
            Arrays.fill(this.f33987c, z0.a.a(this.f34005g.f33952c[this.f34006h], this.f33985a.getAlpha()));
            this.f34007i = false;
        }
    }

    private void s(int i3) {
        for (int i16 = 0; i16 < 4; i16++) {
            this.f33986b[i16] = Math.max(0.0f, Math.min(1.0f, this.f34004f[i16].getInterpolation(b(i3, f34000m[i16], f33999l[i16]))));
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f34002d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f34009k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
        ObjectAnimator objectAnimator = this.f34003e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f33985a.isVisible()) {
                this.f34003e.setFloatValues(this.f34008j, 1.0f);
                this.f34003e.setDuration((1.0f - this.f34008j) * 1800.0f);
                this.f34003e.start();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.f34002d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f34009k = null;
    }

    @VisibleForTesting
    void q() {
        this.f34006h = 0;
        int a16 = z0.a.a(this.f34005g.f33952c[0], this.f33985a.getAlpha());
        int[] iArr = this.f33987c;
        iArr[0] = a16;
        iArr[1] = a16;
    }

    @VisibleForTesting
    void r(float f16) {
        this.f34008j = f16;
        s((int) (f16 * 1800.0f));
        p();
        this.f33985a.invalidateSelf();
    }
}
