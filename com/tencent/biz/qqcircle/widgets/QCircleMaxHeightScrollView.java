package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleMaxHeightScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private int f93039d;

    public QCircleMaxHeightScrollView(Context context) {
        this(context, null);
    }

    private boolean a() {
        View childAt = getChildAt(0);
        if (childAt != null && getHeight() < childAt.getHeight()) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true ^ a());
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f93039d, Integer.MIN_VALUE));
    }

    public void setMaxHeight(int i3) {
        this.f93039d = i3;
    }

    public QCircleMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleMaxHeightScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449838u5);
        this.f93039d = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449850v5, ImmersiveUtils.dpToPx(300.0f));
        obtainStyledAttributes.recycle();
    }
}
