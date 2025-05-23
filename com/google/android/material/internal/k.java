package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f33867a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private b f33868b = null;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    ValueAnimator f33869c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f33870d = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k kVar = k.this;
            if (kVar.f33869c == animator) {
                kVar.f33869c = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f33872a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f33873b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f33872a = iArr;
            this.f33873b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f33870d);
        this.f33867a.add(bVar);
    }
}
