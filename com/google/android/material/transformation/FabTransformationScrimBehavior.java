package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import x0.b;
import x0.i;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    private final i f34520i;

    /* renamed from: j, reason: collision with root package name */
    private final i f34521j;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f34522d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f34523e;

        a(boolean z16, View view) {
            this.f34522d = z16;
            this.f34523e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f34522d) {
                this.f34523e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f34522d) {
                this.f34523e.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f34520i = new i(75L, 150L);
        this.f34521j = new i(0L, 150L);
    }

    private void h(@NonNull View view, boolean z16, boolean z17, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        i iVar;
        ObjectAnimator ofFloat;
        if (z16) {
            iVar = this.f34520i;
        } else {
            iVar = this.f34521j;
        }
        if (z16) {
            if (!z17) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        iVar.a(ofFloat);
        list.add(ofFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet g(@NonNull View view, @NonNull View view2, boolean z16, boolean z17) {
        ArrayList arrayList = new ArrayList();
        h(view2, z16, z17, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z16, view2));
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34520i = new i(75L, 150L);
        this.f34521j = new i(0L, 150L);
    }
}
