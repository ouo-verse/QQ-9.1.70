package com.tencent.mobileqq.guild.robot.components.base.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.robot.components.base.widget.NestedBoundRecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class NestedBoundRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f232138f;

    public NestedBoundRecyclerView(Context context) {
        this(context, null);
    }

    private void E() {
        long min = Math.min(Math.abs(getTop()) / 1.5f, 250.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(getTop(), 0);
        this.f232138f = ofInt;
        ofInt.setInterpolator(new TimeInterpolator() { // from class: bx1.a
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float F;
                F = NestedBoundRecyclerView.F(f16);
                return F;
            }
        });
        this.f232138f.setDuration(min);
        this.f232138f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bx1.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NestedBoundRecyclerView.this.G(valueAnimator);
            }
        });
        this.f232138f.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float F(float f16) {
        float f17 = f16 - 1.0f;
        return (f17 * f17 * f17) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(ValueAnimator valueAnimator) {
        offsetTopAndBottom(((Integer) valueAnimator.getAnimatedValue()).intValue() - getTop());
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        if (!canScrollVertically(i16) || getTop() != 0) {
            int i18 = (int) (i16 * 0.5f);
            offsetTopAndBottom(-i18);
            if (iArr != null && iArr.length >= 2) {
                iArr[1] = i18;
            }
            i16 -= i18;
        }
        return super.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        if (motionEvent.getActionMasked() == 0 && (valueAnimator = this.f232138f) != null && valueAnimator.isRunning()) {
            this.f232138f.cancel();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        super.stopNestedScroll(i3);
        E();
    }

    public NestedBoundRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedBoundRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
