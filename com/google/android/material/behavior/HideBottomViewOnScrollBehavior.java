package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private int f33277g;

    /* renamed from: h, reason: collision with root package name */
    private int f33278h;

    /* renamed from: i, reason: collision with root package name */
    private int f33279i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private ViewPropertyAnimator f33280j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f33280j = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f33277g = 0;
        this.f33278h = 2;
        this.f33279i = 0;
    }

    private void c(@NonNull V v3, int i3, long j3, TimeInterpolator timeInterpolator) {
        this.f33280j = v3.animate().translationY(i3).setInterpolator(timeInterpolator).setDuration(j3).setListener(new a());
    }

    public boolean d() {
        if (this.f33278h == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f33278h == 2) {
            return true;
        }
        return false;
    }

    public void f(@NonNull V v3, @Dimension int i3) {
        this.f33279i = i3;
        if (this.f33278h == 1) {
            v3.setTranslationY(this.f33277g + i3);
        }
    }

    public void g(@NonNull V v3) {
        h(v3, true);
    }

    public void h(@NonNull V v3, boolean z16) {
        if (d()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f33280j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f33278h = 1;
        int i3 = this.f33277g + this.f33279i;
        if (z16) {
            c(v3, i3, 175L, x0.a.f446812c);
        } else {
            v3.setTranslationY(i3);
        }
    }

    public void i(@NonNull V v3) {
        j(v3, true);
    }

    public void j(@NonNull V v3, boolean z16) {
        if (e()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f33280j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f33278h = 2;
        if (z16) {
            c(v3, 0, 225L, x0.a.f446813d);
        } else {
            v3.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        this.f33277g = v3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v3.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v3, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        if (i16 > 0) {
            g(v3);
        } else if (i16 < 0) {
            i(v3);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3, int i16) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33277g = 0;
        this.f33278h = 2;
        this.f33279i = 0;
    }
}
