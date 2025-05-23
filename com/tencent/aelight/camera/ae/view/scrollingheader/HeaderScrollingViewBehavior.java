package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: j, reason: collision with root package name */
    final Rect f65936j;

    /* renamed from: k, reason: collision with root package name */
    final Rect f65937k;

    /* renamed from: l, reason: collision with root package name */
    private int f65938l;

    /* renamed from: m, reason: collision with root package name */
    private int f65939m;

    public HeaderScrollingViewBehavior() {
        this.f65936j = new Rect();
        this.f65937k = new Rect();
        this.f65938l = 0;
    }

    private static int resolveGravity(int i3) {
        if (i3 == 0) {
            return 8388659;
        }
        return i3;
    }

    public abstract View findFirstDependency(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getOverlapPixelsForOffset(View view) {
        if (this.f65939m == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i3 = this.f65939m;
        return MathUtils.clamp((int) (overlapRatioForOffset * i3), 0, i3);
    }

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getVerticalLayoutGap() {
        return this.f65938l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.view.scrollingheader.ViewOffsetBehavior
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f65936j;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, findFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f65937k;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i3);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.f65938l = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i3);
        this.f65938l = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i3, int i16, int i17, int i18) {
        View findFirstDependency;
        WindowInsetsCompat lastWindowInsets;
        int i19 = view.getLayoutParams().height;
        if ((i19 != -1 && i19 != -2) || (findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
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
        coordinatorLayout.onMeasureChild(view, i3, i16, View.MeasureSpec.makeMeasureSpec(scrollRange, i19 == -1 ? 1073741824 : Integer.MIN_VALUE), i18);
        return true;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65936j = new Rect();
        this.f65937k = new Rect();
        this.f65938l = 0;
    }
}
