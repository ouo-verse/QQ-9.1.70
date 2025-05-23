package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ScrollLinearLayout extends LinearLayout implements NestedScrollingParent {

    /* renamed from: d, reason: collision with root package name */
    private int f213470d;

    /* renamed from: e, reason: collision with root package name */
    private View f213471e;

    /* renamed from: f, reason: collision with root package name */
    private View f213472f;

    /* renamed from: h, reason: collision with root package name */
    private OverScroller f213473h;

    public ScrollLinearLayout(Context context) {
        super(context);
        this.f213470d = BaseAIOUtils.f(80.0f, getResources());
    }

    public void a(int i3) {
        this.f213473h.fling(0, getScrollY(), 0, i3, 0, 0, 0, this.f213470d);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f213472f = findViewById(R.id.c9n);
        this.f213473h = new OverScroller(getContext());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.f213472f != null && this.f213471e != null) {
            getChildAt(0).measure(i3, View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f213472f.getLayoutParams().height = getMeasuredHeight();
            setMeasuredDimension(getMeasuredWidth(), this.f213471e.getMeasuredHeight() + this.f213472f.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        return super.onNestedFling(view, f16, f17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        if (getScrollY() >= this.f213470d) {
            return false;
        }
        a((int) f17);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        boolean z16;
        boolean z17;
        if (i16 > 0 && getScrollY() < this.f213470d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 < 0 && getScrollY() > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            scrollBy(0, i16);
            iArr[1] = i16;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        super.onNestedScroll(view, i3, i16, i17, i18);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        super.onNestedScrollAccepted(view, view2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        boolean z16;
        QLog.e(getClass().getSimpleName(), 1, "view:" + view + "-- target:" + view2);
        if ((i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.e(getClass().getSimpleName(), 1, "result:" + z16);
        return z16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        if (i16 < 0) {
            i16 = 0;
        }
        int i17 = this.f213470d;
        if (i16 > i17) {
            i16 = i17;
        }
        if (i16 != getScrollY()) {
            super.scrollTo(i3, i16);
        }
    }

    public ScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213470d = BaseAIOUtils.f(80.0f, getResources());
    }

    public ScrollLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213470d = BaseAIOUtils.f(80.0f, getResources());
    }
}
