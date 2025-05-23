package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: j, reason: collision with root package name */
    final Rect f178967j;

    /* renamed from: k, reason: collision with root package name */
    final Rect f178968k;

    /* renamed from: l, reason: collision with root package name */
    private int f178969l;

    /* renamed from: m, reason: collision with root package name */
    private int f178970m;

    public HeaderScrollingViewBehavior() {
        this.f178967j = new Rect();
        this.f178968k = new Rect();
        this.f178969l = 0;
    }

    private static int resolveGravity(int i3) {
        if (i3 == 0) {
            return 8388659;
        }
        return i3;
    }

    @Nullable
    abstract View findFirstDependency(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getOverlapPixelsForOffset(View view) {
        if (this.f178970m == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i3 = this.f178970m;
        return MathUtils.clamp((int) (overlapRatioForOffset * i3), 0, i3);
    }

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScrollRange(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getVerticalLayoutGap() {
        return this.f178969l;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.ViewOffsetBehavior
    protected void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f178967j;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, findFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f178968k;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i3);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.f178969l = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i3);
        this.f178969l = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3, int i16, int i17, int i18) {
        View findFirstDependency;
        int i19;
        WindowInsetsCompat lastWindowInsets;
        int i26 = view.getLayoutParams().height;
        if ((i26 == -1 || i26 == -2) && (findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) != null) {
            int size = View.MeasureSpec.getSize(i17);
            if (size > 0) {
                if (ViewCompat.getFitsSystemWindows(findFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int scrollRange = size + getScrollRange(findFirstDependency);
            int measuredHeight = findFirstDependency.getMeasuredHeight();
            if (shouldHeaderOverlapScrollingChild()) {
                view.setTranslationY(-measuredHeight);
            } else {
                scrollRange -= measuredHeight;
            }
            if (i26 == -1) {
                i19 = 1073741824;
            } else {
                i19 = Integer.MIN_VALUE;
            }
            coordinatorLayout.onMeasureChild(view, i3, i16, View.MeasureSpec.makeMeasureSpec(scrollRange, i19), i18);
            return true;
        }
        return false;
    }

    public final void setOverlayTop(int i3) {
        this.f178970m = i3;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178967j = new Rect();
        this.f178968k = new Rect();
        this.f178969l = 0;
    }
}
