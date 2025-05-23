package com.tencent.mm.ui.widget.pulldown;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mm.ui.widget.pulldown.IOverScrollCallback;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q2\u00020\u0001:\u0001QB\u001b\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bO\u0010PJ@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016J0\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007JH\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J8\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0004J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0007J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J8\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J(\u0010&\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J8\u0010(\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u000e\u0010)\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010,\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J \u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J \u0010/\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0007H\u0016J8\u00102\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020$H\u0016J0\u00103\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J(\u00106\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J(\u00108\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010:R\u001c\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b8\u0010<\u0012\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010<R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006R"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/AppLayoutPullDownBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Landroid/view/View;", "child", "target", "", "dx", "dy", "", "consumed", "type", "", "onNestedPreScroll", Element.ELEMENT_NAME_DISTANCE, "a", "getOffset", "offset", "setOffset", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "distanceConsumed", "distanceUnconsumed", "scrollDirection", "getMaxFlingOffset", "getMinOffset", "getMinFlingVelocity", "", "getDampingFactor", "getMaxOffset", "directTargetChild", "axes", "", "onStartNestedScroll", "onStopNestedScroll", "springBack", "onNestedScrollAccepted", "stopSpringBack", HippyNestedScrollComponent.PRIORITY_PARENT, "dependency", "layoutDependsOn", "onDependentViewChanged", "layoutDirection", "onLayoutChild", "velocityX", "velocityY", "onNestedFling", "onNestedPreFling", "minOffset", "maxOffset", "c", "newOffset", "b", "Landroid/widget/OverScroller;", "Landroid/widget/OverScroller;", "mOverScroller", "I", "getMDirectionToEnd$annotations", "()V", "mDirectionToEnd", "mDirectionToStart", "d", "mMinFlingVelocity", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "mSpringBackAnimator", "Landroid/view/animation/Interpolator;", "f", "Landroid/view/animation/Interpolator;", "mSpringBackInterpolator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AppLayoutPullDownBehavior extends AppBarLayout.ScrollingViewBehavior {

    @NotNull
    public static final String TAG = "PullDownBehavior";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public OverScroller mOverScroller;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int mDirectionToEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int mDirectionToStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mMinFlingVelocity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ValueAnimator mSpringBackAnimator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Interpolator mSpringBackInterpolator;

    public AppLayoutPullDownBehavior(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSpringBackInterpolator = new DecelerateInterpolator(0.8f);
    }

    public final int a(CoordinatorLayout coordinatorLayout, View child, View target, int distance, int type) {
        int offset;
        int i3;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedPreScrollInner() called with:  child = " + child.getClass() + ", target = " + target.getClass() + ", distance = " + distance + ", type = " + type);
        if (distance != 0) {
            if (distance < 0) {
                i3 = getOffset(coordinatorLayout);
                offset = 0;
            } else {
                offset = getOffset(coordinatorLayout);
                i3 = 0;
            }
            if (i3 != offset) {
                return c(coordinatorLayout, distance, i3, offset);
            }
        }
        return 0;
    }

    public final int b(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - a(child, distance), minOffset, maxOffset);
    }

    public final int c(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - distance, minOffset, maxOffset);
    }

    public final float getDampingFactor(@NotNull View child, @IOverScrollCallback.ScrollDirection int scrollDirection) {
        Intrinsics.checkNotNullParameter(child, "child");
        return 1 + (4 * ((Math.abs(getOffset(child)) * 1.0f) / child.getHeight()));
    }

    public final int getMaxFlingOffset(@NotNull View child, @IOverScrollCallback.ScrollDirection int scrollDirection) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (scrollDirection != 2 && scrollDirection != 8) {
            return (-child.getHeight()) / 3;
        }
        return child.getHeight() / 3;
    }

    public final int getMaxOffset(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return child.getHeight();
    }

    public final int getMinFlingVelocity(@NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.mMinFlingVelocity <= 0) {
            this.mMinFlingVelocity = ViewConfiguration.get(child.getContext()).getScaledMinimumFlingVelocity() * 15;
        }
        return this.mMinFlingVelocity;
    }

    public final int getMinOffset(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return -child.getHeight();
    }

    public final int getOffset(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return (int) child.getTranslationY();
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Log.d(TAG, "layoutDependsOn() called with: parent = " + parent.getClass().getName() + ", child = " + child.getClass().getName() + ", dependency = " + dependency.getClass().getName());
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Log.d(TAG, "onDependentViewChanged() called with: parent = " + parent.getClass().getName() + ", child = " + child.getClass().getName() + ", dependency = " + dependency.getClass().getName());
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull View child, int layoutDirection) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Log.d(TAG, "onLayoutChild() called with: parent = " + parent.getClass().getName() + ", child = " + child.getClass().getName() + ", layoutDirection = " + Integer.TYPE.getName());
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedFling() called with: coordinatorLayout = " + coordinatorLayout.getClass().getName() + ", child = " + child.getClass().getName() + ", target = " + target + ", velocityX = " + velocityX + ", velocityY = " + velocityY + ", consumed = " + consumed);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedPreFling() called with: coordinatorLayout = " + coordinatorLayout.getClass().getName() + ", child = " + child.getClass().getName() + ", target = " + target.getClass().getName() + ", velocityX = " + velocityX + ", velocityY = " + velocityY);
        if (this.mOverScroller == null) {
            this.mOverScroller = new OverScroller(coordinatorLayout.getContext());
        }
        OverScroller overScroller = this.mOverScroller;
        if (overScroller != null) {
            overScroller.fling(0, 0, 0, (int) velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return false;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        consumed[1] = a(coordinatorLayout, child, target, dy5, type);
        Log.d(TAG, "onNestedPreScroll() comsumed[1]=" + consumed[1]);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedScroll() called with: child = " + child.getClass().getName() + ", target = " + target.getClass().getName() + ", dxConsumed = " + dxConsumed + ", dyConsumed = " + dyConsumed + ", dxUnconsumed = " + dxUnconsumed + ", dyUnconsumed = " + dyUnconsumed + ", type = " + type);
        if (dyConsumed == 0 && dyUnconsumed != 0) {
            a(coordinatorLayout, child, target, dyConsumed, dyUnconsumed, type);
        } else {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScrollAccepted(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        OverScroller overScroller;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedScrollAccepted() called with: coordinatorLayout = " + coordinatorLayout.getClass().getName() + ", child = " + child.getClass().getName() + ", directTargetChild = " + directTargetChild + ", target = " + target.getClass().getName() + ", axes = " + axes + ", type = " + type);
        if (type == 0) {
            stopSpringBack(child);
        }
        if (type == 0 && (overScroller = this.mOverScroller) != null) {
            overScroller.forceFinished(true);
        }
        if ((axes & 2) != 0) {
            this.mDirectionToEnd = 2;
            this.mDirectionToStart = 1;
        } else {
            this.mDirectionToEnd = 8;
            this.mDirectionToStart = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onStartNestedScroll() called with: coordinatorLayout = " + coordinatorLayout.getClass().getName() + ", child = " + child.getClass().getName() + ", directTargetChild = " + directTargetChild.getClass().getName() + ", target = " + target.getClass().getName() + ", axes = " + axes + ", type = " + type);
        if ((axes & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onStopNestedScroll() called with:child = " + child.getClass() + ", target = " + target + ", type = " + type);
        if (type == 0) {
            if (getOffset(coordinatorLayout) != 0) {
                OverScroller overScroller = this.mOverScroller;
                if (overScroller == null || !overScroller.computeScrollOffset()) {
                    springBack(coordinatorLayout);
                    return;
                }
                return;
            }
            return;
        }
        if (getOffset(coordinatorLayout) != 0) {
            springBack(coordinatorLayout);
        }
    }

    public final void setOffset(@NotNull View child, int offset) {
        Intrinsics.checkNotNullParameter(child, "child");
        child.setTranslationY(offset);
    }

    public final void springBack(@NotNull final View child) {
        boolean z16;
        Intrinsics.checkNotNullParameter(child, "child");
        int offset = getOffset(child);
        if (offset == 0) {
            return;
        }
        if (this.mSpringBackAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[0]);
            this.mSpringBackAnimator = ofInt;
            if (ofInt != null) {
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.pulldown.AppLayoutPullDownBehavior$springBack$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(@NotNull ValueAnimator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Object animatedValue = animation.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                        AppLayoutPullDownBehavior.this.setOffset(child, ((Integer) animatedValue).intValue());
                    }
                });
            }
        }
        ValueAnimator valueAnimator = this.mSpringBackAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        float abs = ((Math.abs(offset) * 1.0f) / getMaxOffset(child)) * 300;
        ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(Math.max((int) abs, 150));
        }
        ValueAnimator valueAnimator3 = this.mSpringBackAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(this.mSpringBackInterpolator);
        }
        ValueAnimator valueAnimator4 = this.mSpringBackAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.setIntValues(offset, 0);
        }
        ValueAnimator valueAnimator5 = this.mSpringBackAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    public final void stopSpringBack(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        ValueAnimator valueAnimator = this.mSpringBackAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
    }

    public final int a(View child, int newOffset, int minOffset, int maxOffset) {
        int clamp;
        int offset = getOffset(child);
        if (offset < minOffset || offset > maxOffset || offset == (clamp = MathUtils.clamp(newOffset, minOffset, maxOffset))) {
            return 0;
        }
        setOffset(child, clamp);
        return offset - clamp;
    }

    public final void a(CoordinatorLayout coordinatorLayout, View child, View target, int distanceConsumed, int distanceUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.d(TAG, "onNestedScrollInner() called with, child = " + child.getClass().getName() + ", target = " + target.getClass().getName() + ", distanceConsumed = " + distanceConsumed + ", distanceUnconsumed = " + distanceUnconsumed + ", type = " + type);
        if (distanceUnconsumed < 0) {
            if (type == 0) {
                b(coordinatorLayout, distanceUnconsumed, 0, getMaxOffset(coordinatorLayout));
                return;
            }
            OverScroller overScroller = this.mOverScroller;
            if (overScroller != null && overScroller.computeScrollOffset() && Math.abs(overScroller.getCurrVelocity()) >= Math.abs(getMinFlingVelocity(coordinatorLayout, this.mDirectionToEnd)) && getOffset(coordinatorLayout) < getMaxFlingOffset(coordinatorLayout, this.mDirectionToEnd)) {
                b(coordinatorLayout, distanceUnconsumed, getOffset(coordinatorLayout), getMaxFlingOffset(coordinatorLayout, this.mDirectionToEnd));
                return;
            } else {
                Log.i(TAG, "111111111");
                ViewCompat.stopNestedScroll(target, 1);
                return;
            }
        }
        if (distanceUnconsumed > 0) {
            if (type == 0) {
                b(coordinatorLayout, distanceUnconsumed, getMinOffset(coordinatorLayout), 0);
                return;
            }
            OverScroller overScroller2 = this.mOverScroller;
            if (overScroller2 != null && overScroller2.computeScrollOffset() && Math.abs(overScroller2.getCurrVelocity()) >= Math.abs(getMinFlingVelocity(coordinatorLayout, this.mDirectionToStart)) && getOffset(coordinatorLayout) > getMaxFlingOffset(coordinatorLayout, this.mDirectionToStart)) {
                b(coordinatorLayout, distanceUnconsumed, getMaxFlingOffset(coordinatorLayout, this.mDirectionToStart), getOffset(coordinatorLayout));
            } else {
                Log.i(TAG, "22222");
                ViewCompat.stopNestedScroll(target, 1);
            }
        }
    }

    public final int a(View child, int distance) {
        float dampingFactor = getDampingFactor(child, distance > 0 ? this.mDirectionToStart : this.mDirectionToEnd);
        if (dampingFactor == 0.0f) {
            dampingFactor = 1.0f;
        }
        return (int) ((distance / dampingFactor) + 0.5f);
    }
}
