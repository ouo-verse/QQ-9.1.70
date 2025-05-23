package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private AnimatorSet f34499h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f34499h = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean e(View view, View view2, boolean z16, boolean z17) {
        boolean z18;
        AnimatorSet animatorSet = this.f34499h;
        if (animatorSet != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            animatorSet.cancel();
        }
        AnimatorSet g16 = g(view, view2, z16, z18);
        this.f34499h = g16;
        g16.addListener(new a());
        this.f34499h.start();
        if (!z17) {
            this.f34499h.end();
        }
        return true;
    }

    @NonNull
    protected abstract AnimatorSet g(View view, View view2, boolean z16, boolean z17);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
