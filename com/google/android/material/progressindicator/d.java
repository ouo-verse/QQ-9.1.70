package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class d extends h<ObjectAnimator> {

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f33960l = {0, gdt_analysis_event.EVENT_MOTIVE_HIPPY_WEB_VIEW_DISPLAYED, 2700, BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_PRO};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f33961m = {QVipGiftProcessor.CMD, 2017, 3367, 4717};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f33962n = {1000, 2350, 3700, 5050};

    /* renamed from: o, reason: collision with root package name */
    private static final Property<d, Float> f33963o = new c(Float.class, "animationFraction");

    /* renamed from: p, reason: collision with root package name */
    private static final Property<d, Float> f33964p = new C0237d(Float.class, "completeEndFraction");

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f33965d;

    /* renamed from: e, reason: collision with root package name */
    private ObjectAnimator f33966e;

    /* renamed from: f, reason: collision with root package name */
    private final FastOutSlowInInterpolator f33967f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f33968g;

    /* renamed from: h, reason: collision with root package name */
    private int f33969h;

    /* renamed from: i, reason: collision with root package name */
    private float f33970i;

    /* renamed from: j, reason: collision with root package name */
    private float f33971j;

    /* renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f33972k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f33969h = (dVar.f33969h + 4) % d.this.f33968g.f33952c.length;
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
            d.this.a();
            d dVar = d.this;
            Animatable2Compat.AnimationCallback animationCallback = dVar.f33972k;
            if (animationCallback != null) {
                animationCallback.onAnimationEnd(dVar.f33985a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f16) {
            dVar.t(f16.floatValue());
        }
    }

    /* compiled from: P */
    /* renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0237d extends Property<d, Float> {
        C0237d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f16) {
            dVar.u(f16.floatValue());
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f33969h = 0;
        this.f33972k = null;
        this.f33968g = circularProgressIndicatorSpec;
        this.f33967f = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f33970i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f33971j;
    }

    private void q() {
        if (this.f33965d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f33963o, 0.0f, 1.0f);
            this.f33965d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f33965d.setInterpolator(null);
            this.f33965d.setRepeatCount(-1);
            this.f33965d.addListener(new a());
        }
        if (this.f33966e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f33964p, 0.0f, 1.0f);
            this.f33966e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f33966e.setInterpolator(this.f33967f);
            this.f33966e.addListener(new b());
        }
    }

    private void r(int i3) {
        for (int i16 = 0; i16 < 4; i16++) {
            float b16 = b(i3, f33962n[i16], 333);
            if (b16 >= 0.0f && b16 <= 1.0f) {
                int i17 = i16 + this.f33969h;
                int[] iArr = this.f33968g.f33952c;
                int length = i17 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                this.f33987c[0] = x0.c.b().evaluate(this.f33967f.getInterpolation(b16), Integer.valueOf(z0.a.a(iArr[length], this.f33985a.getAlpha())), Integer.valueOf(z0.a.a(this.f33968g.f33952c[length2], this.f33985a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f16) {
        this.f33971j = f16;
    }

    private void v(int i3) {
        float[] fArr = this.f33986b;
        float f16 = this.f33970i;
        fArr[0] = (f16 * 1520.0f) - 20.0f;
        fArr[1] = f16 * 1520.0f;
        for (int i16 = 0; i16 < 4; i16++) {
            float b16 = b(i3, f33960l[i16], QVipGiftProcessor.CMD);
            float[] fArr2 = this.f33986b;
            fArr2[1] = fArr2[1] + (this.f33967f.getInterpolation(b16) * 250.0f);
            float b17 = b(i3, f33961m[i16], QVipGiftProcessor.CMD);
            float[] fArr3 = this.f33986b;
            fArr3[0] = fArr3[0] + (this.f33967f.getInterpolation(b17) * 250.0f);
        }
        float[] fArr4 = this.f33986b;
        float f17 = fArr4[0];
        float f18 = fArr4[1];
        float f19 = f17 + ((f18 - f17) * this.f33971j);
        fArr4[0] = f19;
        fArr4[0] = f19 / 360.0f;
        fArr4[1] = f18 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    void a() {
        ObjectAnimator objectAnimator = this.f33965d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f33972k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.h
    void f() {
        ObjectAnimator objectAnimator = this.f33966e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f33985a.isVisible()) {
                this.f33966e.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void g() {
        q();
        s();
        this.f33965d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f33972k = null;
    }

    @VisibleForTesting
    void s() {
        this.f33969h = 0;
        this.f33987c[0] = z0.a.a(this.f33968g.f33952c[0], this.f33985a.getAlpha());
        this.f33971j = 0.0f;
    }

    @VisibleForTesting
    void t(float f16) {
        this.f33970i = f16;
        int i3 = (int) (f16 * 5400.0f);
        v(i3);
        r(i3);
        this.f33985a.invalidateSelf();
    }
}
