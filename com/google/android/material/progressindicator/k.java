package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class k extends h<ObjectAnimator> {

    /* renamed from: j, reason: collision with root package name */
    private static final Property<k, Float> f33991j = new b(Float.class, "animationFraction");

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f33992d;

    /* renamed from: e, reason: collision with root package name */
    private FastOutSlowInInterpolator f33993e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f33994f;

    /* renamed from: g, reason: collision with root package name */
    private int f33995g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33996h;

    /* renamed from: i, reason: collision with root package name */
    private float f33997i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f33995g = (kVar.f33995g + 1) % k.this.f33994f.f33952c.length;
            k.this.f33996h = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends Property<k, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f16) {
            kVar.r(f16.floatValue());
        }
    }

    public k(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f33995g = 1;
        this.f33994f = linearProgressIndicatorSpec;
        this.f33993e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f33997i;
    }

    private void o() {
        if (this.f33992d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f33991j, 0.0f, 1.0f);
            this.f33992d = ofFloat;
            ofFloat.setDuration(333L);
            this.f33992d.setInterpolator(null);
            this.f33992d.setRepeatCount(-1);
            this.f33992d.addListener(new a());
        }
    }

    private void p() {
        if (this.f33996h && this.f33986b[3] < 1.0f) {
            int[] iArr = this.f33987c;
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = z0.a.a(this.f33994f.f33952c[this.f33995g], this.f33985a.getAlpha());
            this.f33996h = false;
        }
    }

    private void s(int i3) {
        this.f33986b[0] = 0.0f;
        float b16 = b(i3, 0, QVipGiftProcessor.CMD);
        float[] fArr = this.f33986b;
        float interpolation = this.f33993e.getInterpolation(b16);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f33986b;
        float interpolation2 = this.f33993e.getInterpolation(b16 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f33986b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f33992d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.f33992d.start();
    }

    @VisibleForTesting
    void q() {
        this.f33996h = true;
        this.f33995g = 1;
        Arrays.fill(this.f33987c, z0.a.a(this.f33994f.f33952c[0], this.f33985a.getAlpha()));
    }

    @VisibleForTesting
    void r(float f16) {
        this.f33997i = f16;
        s((int) (f16 * 333.0f));
        p();
        this.f33985a.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }
}
