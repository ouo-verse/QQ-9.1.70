package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ViewTransformer extends ViewGroup implements Animation.AnimationListener {

    /* renamed from: d, reason: collision with root package name */
    private View f277825d;

    /* renamed from: e, reason: collision with root package name */
    private View f277826e;

    /* renamed from: f, reason: collision with root package name */
    private Context f277827f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    public ViewTransformer(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        this.f277827f = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view = this.f277825d;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f277825d;
        this.f277825d = this.f277826e;
        this.f277826e = view2;
        if (getChildCount() > 1 && this.f277825d != null && this.f277826e != null) {
            removeAllViews();
            addView(this.f277825d, 0);
            addView(this.f277826e, 1);
            requestLayout();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f277826e.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i27 = i26 + marginLayoutParams.leftMargin;
            int i28 = measuredWidth + i27 + marginLayoutParams.rightMargin;
            int i29 = marginLayoutParams.topMargin;
            childAt.layout(i27, i29, i28, measuredHeight + i29 + marginLayoutParams.bottomMargin);
            i19++;
            i26 = i28;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                try {
                    measureChildWithMargins(childAt, i3, 0, i16, 0);
                } catch (Exception e16) {
                    QLog.e("ViewTransformer", 1, "error msg in qqpay-impl module: ", e16);
                }
                i17 += childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i18 <= measuredHeight) {
                    i18 = measuredHeight;
                }
            }
        }
        setMeasuredDimension(i17, i16);
    }

    public ViewTransformer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public ViewTransformer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d(context);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    public void setLisenter(a aVar) {
    }
}
