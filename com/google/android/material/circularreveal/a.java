package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: P */
    /* renamed from: com.google.android.material.circularreveal.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0231a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f33502d;

        C0231a(b bVar) {
            this.f33502d = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f33502d.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f33502d.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator a(@NonNull b bVar, float f16, float f17, float f18) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(bVar, (Property<b, V>) b.c.f33505a, (TypeEvaluator) b.C0232b.f33503b, (Object[]) new b.e[]{new b.e(f16, f17, f18)});
        b.e f19 = bVar.f();
        if (f19 != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) bVar, (int) f16, (int) f17, f19.f33509c, f18);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull b bVar) {
        return new C0231a(bVar);
    }
}
