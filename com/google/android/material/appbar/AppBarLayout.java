package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int Q = 2131953241;

    @Nullable
    private WindowInsetsCompat C;
    private List<c> D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;

    @IdRes
    private int I;

    @Nullable
    private WeakReference<View> J;

    @Nullable
    private ValueAnimator K;
    private final List<f> L;
    private int[] M;

    @Nullable
    private Drawable N;
    private Behavior P;

    /* renamed from: d, reason: collision with root package name */
    private int f33189d;

    /* renamed from: e, reason: collision with root package name */
    private int f33190e;

    /* renamed from: f, reason: collision with root package name */
    private int f33191f;

    /* renamed from: h, reason: collision with root package name */
    private int f33192h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33193i;

    /* renamed from: m, reason: collision with root package name */
    private int f33194m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private d onDragCallback;
        private SavedState savedState;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f33200d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f33201e;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f33200d = coordinatorLayout;
                this.f33201e = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.setHeaderTopBottomOffset(this.f33200d, this.f33201e, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class b implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f33203a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f33204b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f33205c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f33206d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
                this.f33203a = coordinatorLayout;
                this.f33204b = appBarLayout;
                this.f33205c = view;
                this.f33206d = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.f33203a, (CoordinatorLayout) this.f33204b, this.f33205c, 0, this.f33206d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class c implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f33208a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f33209b;

            c(AppBarLayout appBarLayout, boolean z16) {
                this.f33208a = appBarLayout;
                this.f33209b = z16;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                this.f33208a.setExpanded(this.f33209b);
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static abstract class d<T extends AppBarLayout> {
        }

        public BaseBehavior() {
        }

        private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t16.p()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i3 = -t16.k();
                    if (i3 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(coordinatorLayout, t16, view, i3));
                        return;
                    }
                    return;
                }
                addActionToExpand(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z16) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new c(t16, z16));
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, float f16) {
            int height;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i3);
            float abs2 = Math.abs(f16);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t16.getHeight()) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t16, i3, height);
        }

        private void animateOffsetWithDuration(CoordinatorLayout coordinatorLayout, T t16, int i3, int i16) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i3) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(x0.a.f446814e);
                this.offsetAnimator.addUpdateListener(new a(coordinatorLayout, t16));
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(Math.min(i16, 600));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i3);
            this.offsetAnimator.start();
        }

        private int calculateSnapOffset(int i3, int i16, int i17) {
            if (i3 >= (i16 + i17) / 2) {
                return i17;
            }
            return i16;
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view) {
            if (t16.t() && coordinatorLayout.getHeight() - view.getHeight() <= t16.getHeight()) {
                return true;
            }
            return false;
        }

        private static boolean checkFlag(int i3, int i16) {
            if ((i3 & i16) == i16) {
                return true;
            }
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i3) {
            int abs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = appBarLayout.getChildAt(i16);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T t16, int i3) {
            int childCount = t16.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = t16.getChildAt(i16);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i17 = -i3;
                if (top <= i17 && bottom >= i17) {
                    return i16;
                }
            }
            return -1;
        }

        private int interpolateOffset(@NonNull T t16, int i3) {
            int abs = Math.abs(i3);
            int childCount = t16.getChildCount();
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= childCount) {
                    break;
                }
                View childAt = t16.getChildAt(i17);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator d16 = layoutParams.d();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (d16 != null) {
                        int c16 = layoutParams.c();
                        if ((c16 & 1) != 0) {
                            i16 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((c16 & 2) != 0) {
                                i16 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i16 -= t16.o();
                        }
                        if (i16 > 0) {
                            float f16 = i16;
                            return Integer.signum(i3) * (childAt.getTop() + Math.round(f16 * d16.getInterpolation((abs - childAt.getTop()) / f16)));
                        }
                    }
                } else {
                    i17++;
                }
            }
            return i3;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            List<View> dependents = coordinatorLayout.getDependents(t16);
            int size = dependents.size();
            for (int i3 = 0; i3 < size; i3++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i3).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) behavior).getOverlayTop() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            int o16 = t16.o() + t16.getPaddingTop();
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - o16;
            int childIndexOnOffset = getChildIndexOnOffset(t16, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t16.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int c16 = layoutParams.c();
                if ((c16 & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i16 = -childAt.getBottom();
                    if (childIndexOnOffset == 0 && ViewCompat.getFitsSystemWindows(t16) && ViewCompat.getFitsSystemWindows(childAt)) {
                        i3 -= t16.o();
                    }
                    if (checkFlag(c16, 2)) {
                        i16 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(c16, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i16;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i3 = minimumHeight;
                        } else {
                            i16 = minimumHeight;
                        }
                    }
                    if (checkFlag(c16, 32)) {
                        i3 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i16 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    animateOffsetTo(coordinatorLayout, t16, MathUtils.clamp(calculateSnapOffset(topBottomOffsetForScrollingSibling, i16, i3) + o16, -t16.p(), 0), 0.0f);
                }
            }
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t16.p() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            addAccessibilityScrollActions(coordinatorLayout, t16, findFirstScrollingChild);
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, boolean z16) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t16, i3);
            boolean z17 = false;
            if (appBarChildOnOffset != null) {
                int c16 = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).c();
                if ((c16 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i16 <= 0 || (c16 & 12) == 0 ? !((c16 & 2) == 0 || (-i3) < (appBarChildOnOffset.getBottom() - minimumHeight) - t16.o()) : (-i3) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t16.o()) {
                        z17 = true;
                    }
                }
            }
            if (t16.v()) {
                z17 = t16.G(findFirstScrollingChild(coordinatorLayout));
            }
            boolean D = t16.D(z17);
            if (z16 || (D && shouldJumpElevationState(coordinatorLayout, t16))) {
                t16.jumpDrawablesToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return true;
            }
            return false;
        }

        void restoreScrollState(@Nullable SavedState savedState, boolean z16) {
            if (this.savedState == null || z16) {
                this.savedState = savedState;
            }
        }

        @Nullable
        SavedState saveScrollState(@Nullable Parcelable parcelable, @NonNull T t16) {
            boolean z16;
            boolean z17;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t16.getChildCount();
            boolean z18 = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t16.getChildAt(i3);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (topAndBottomOffset == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    savedState.f33196e = z16;
                    if (!z16 && (-topAndBottomOffset) >= t16.p()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    savedState.f33195d = z17;
                    savedState.f33197f = i3;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t16.o()) {
                        z18 = true;
                    }
                    savedState.f33199i = z18;
                    savedState.f33198h = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(T t16) {
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(@NonNull T t16) {
            return -t16.l();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(@NonNull T t16) {
            return t16.p();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            snapToChildIfNeeded(coordinatorLayout, t16);
            if (t16.v()) {
                t16.D(t16.G(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t16, i3);
            int n3 = t16.n();
            SavedState savedState = this.savedState;
            if (savedState == null || (n3 & 8) != 0) {
                if (n3 != 0) {
                    boolean z16 = (n3 & 4) != 0;
                    if ((n3 & 2) != 0) {
                        int i16 = -t16.q();
                        if (z16) {
                            animateOffsetTo(coordinatorLayout, t16, i16, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t16, i16);
                        }
                    } else if ((n3 & 1) != 0) {
                        if (z16) {
                            animateOffsetTo(coordinatorLayout, t16, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t16, 0);
                        }
                    }
                }
            } else if (savedState.f33195d) {
                setHeaderTopBottomOffset(coordinatorLayout, t16, -t16.p());
            } else if (savedState.f33196e) {
                setHeaderTopBottomOffset(coordinatorLayout, t16, 0);
            } else {
                View childAt = t16.getChildAt(savedState.f33197f);
                int i17 = -childAt.getBottom();
                if (this.savedState.f33199i) {
                    round = ViewCompat.getMinimumHeight(childAt) + t16.o();
                } else {
                    round = Math.round(childAt.getHeight() * this.savedState.f33198h);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t16, i17 + round);
            }
            t16.A();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t16.p(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t16, getTopAndBottomOffset(), 0, true);
            t16.w(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t16);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, int i17, int i18) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t16.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t16, i3, i16, View.MeasureSpec.makeMeasureSpec(0, 0), i18);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) t16, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3, int i16, int[] iArr, int i17) {
            int i18;
            int i19;
            if (i16 != 0) {
                if (i16 < 0) {
                    i18 = -t16.p();
                    i19 = t16.k() + i18;
                } else {
                    i18 = -t16.q();
                    i19 = 0;
                }
                int i26 = i18;
                int i27 = i19;
                if (i26 != i27) {
                    iArr[1] = scroll(coordinatorLayout, t16, i16, i26, i27);
                }
            }
            if (t16.v()) {
                t16.D(t16.G(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            if (i18 < 0) {
                iArr[1] = scroll(coordinatorLayout, t16, i18, -t16.l(), 0);
            }
            if (i18 == 0) {
                updateAccessibilityActions(coordinatorLayout, t16);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                restoreScrollState((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t16, this.savedState.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t16, parcelable);
                this.savedState = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) t16);
            SavedState saveScrollState = saveScrollState(onSaveInstanceState, t16);
            return saveScrollState == null ? onSaveInstanceState : saveScrollState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view, View view2, int i3, int i16) {
            ValueAnimator valueAnimator;
            boolean z16 = (i3 & 2) != 0 && (t16.v() || canScrollChildren(coordinatorLayout, t16, view));
            if (z16 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i16;
            return z16;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3) {
            if (this.lastStartedType == 0 || i3 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t16);
                if (t16.v()) {
                    t16.D(t16.G(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, int i17) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i18 = 0;
            if (i16 != 0 && topBottomOffsetForScrollingSibling >= i16 && topBottomOffsetForScrollingSibling <= i17) {
                int clamp = MathUtils.clamp(i3, i16, i17);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    int interpolateOffset = t16.r() ? interpolateOffset(t16, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i19 = topBottomOffsetForScrollingSibling - clamp;
                    this.offsetDelta = clamp - interpolateOffset;
                    if (topAndBottomOffset) {
                        while (i18 < t16.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t16.getChildAt(i18).getLayoutParams();
                            d b16 = layoutParams.b();
                            if (b16 != null && (layoutParams.c() & 1) != 0) {
                                b16.a(t16, t16.getChildAt(i18), getTopAndBottomOffset());
                            }
                            i18++;
                        }
                    }
                    if (!topAndBottomOffset && t16.r()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t16);
                    }
                    t16.w(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, t16, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    i18 = i19;
                }
            } else {
                this.offsetDelta = 0;
            }
            updateAccessibilityActions(coordinatorLayout, t16);
            return i18;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: d, reason: collision with root package name */
            boolean f33195d;

            /* renamed from: e, reason: collision with root package name */
            boolean f33196e;

            /* renamed from: f, reason: collision with root package name */
            int f33197f;

            /* renamed from: h, reason: collision with root package name */
            float f33198h;

            /* renamed from: i, reason: collision with root package name */
            boolean f33199i;

            /* compiled from: P */
            /* loaded from: classes2.dex */
            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i3) {
                    return new SavedState[i3];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f33195d = parcel.readByte() != 0;
                this.f33196e = parcel.readByte() != 0;
                this.f33197f = parcel.readInt();
                this.f33198h = parcel.readFloat();
                this.f33199i = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeByte(this.f33195d ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f33196e ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f33197f);
                parcel.writeFloat(this.f33198h);
                parcel.writeByte(this.f33199i ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public void setDragCallback(@Nullable d dVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i3) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i3, i16, i17, i18);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i3, int i16, int[] iArr, int i17) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3, i16, iArr, i17);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3, i16, i17, i18, i19, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i3, int i16) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i3, i16);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i3) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.d dVar) {
            super.setDragCallback(dVar);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z16) {
            super.setHorizontalOffsetEnabled(z16);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i3) {
            return super.setLeftAndRightOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z16) {
            super.setVerticalOffsetEnabled(z16);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.v()) {
                    appBarLayout.D(appBarLayout.G(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i3;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int p16 = appBarLayout.p();
                int k3 = appBarLayout.k();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((k3 == 0 || p16 + appBarLayoutOffset > k3) && (i3 = p16 - k3) != 0) {
                    return (appBarLayoutOffset / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).p();
            }
            return super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, view, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z16) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z16);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z16) {
            super.setHorizontalOffsetEnabled(z16);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i3) {
            return super.setLeftAndRightOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z16) {
            super.setVerticalOffsetEnabled(z16);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f443900h7);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(w0.a.f443911i7, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.x(windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MaterialShapeDrawable f33215d;

        b(MaterialShapeDrawable materialShapeDrawable) {
            this.f33215d = materialShapeDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f33215d.X(floatValue);
            if (AppBarLayout.this.N instanceof MaterialShapeDrawable) {
                ((MaterialShapeDrawable) AppBarLayout.this.N).X(floatValue);
            }
            Iterator it = AppBarLayout.this.L.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(floatValue, this.f33215d.A());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c<T extends AppBarLayout> {
        void onOffsetChanged(T t16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class d {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e extends d {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f33217a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private final Rect f33218b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.o());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d
        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f16) {
            b(this.f33217a, appBarLayout, view);
            float abs = this.f33217a.top - Math.abs(f16);
            if (abs <= 0.0f) {
                float clamp = 1.0f - MathUtils.clamp(Math.abs(abs / this.f33217a.height()), 0.0f, 1.0f);
                float height = (-abs) - ((this.f33217a.height() * 0.3f) * (1.0f - (clamp * clamp)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f33218b);
                this.f33218b.offset(0, (int) (-height));
                ViewCompat.setClipBounds(view, this.f33218b);
                return;
            }
            ViewCompat.setClipBounds(view, null);
            view.setTranslationY(0.0f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface f {
        void a(@Dimension float f16, @ColorInt int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface g extends c<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void B(boolean z16, boolean z17, boolean z18) {
        int i3;
        int i16;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int i17 = 0;
        if (z17) {
            i16 = 4;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16;
        if (z18) {
            i17 = 8;
        }
        this.f33194m = i18 | i17;
        requestLayout();
    }

    private boolean C(boolean z16) {
        if (this.F != z16) {
            this.F = z16;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    private boolean F() {
        if (this.N != null && o() > 0) {
            return true;
        }
        return false;
    }

    private boolean H() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) {
            return false;
        }
        return true;
    }

    private void I(@NonNull MaterialShapeDrawable materialShapeDrawable, boolean z16) {
        float f16;
        float dimension = getResources().getDimension(R.dimen.f158657c84);
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = dimension;
        }
        if (!z16) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, dimension);
        this.K = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.f127046));
        this.K.setInterpolator(x0.a.f446810a);
        this.K.addUpdateListener(new b(materialShapeDrawable));
        this.K.start();
    }

    private void J() {
        setWillNotDraw(!F());
    }

    private void f() {
        WeakReference<View> weakReference = this.J;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.J = null;
    }

    @Nullable
    private View g(@Nullable View view) {
        int i3;
        View view2;
        if (this.J == null && (i3 = this.I) != -1) {
            if (view != null) {
                view2 = view.findViewById(i3);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.I);
            }
            if (view2 != null) {
                this.J = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.J;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean s() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((LayoutParams) getChildAt(i3).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void u() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.P;
        if (behavior != null && this.f33190e != -1 && this.f33194m == 0) {
            savedState = behavior.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        } else {
            savedState = null;
        }
        this.f33190e = -1;
        this.f33191f = -1;
        this.f33192h = -1;
        if (savedState != null) {
            this.P.restoreScrollState(savedState, false);
        }
    }

    void A() {
        this.f33194m = 0;
    }

    boolean D(boolean z16) {
        return E(z16, !this.E);
    }

    boolean E(boolean z16, boolean z17) {
        if (z17 && this.G != z16) {
            this.G = z16;
            refreshDrawableState();
            if (this.H && (getBackground() instanceof MaterialShapeDrawable)) {
                I((MaterialShapeDrawable) getBackground(), z16);
                return true;
            }
            return true;
        }
        return false;
    }

    boolean G(@Nullable View view) {
        View g16 = g(view);
        if (g16 != null) {
            view = g16;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(@Nullable c cVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        if (cVar != null && !this.D.contains(cVar)) {
            this.D.add(cVar);
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (F()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f33189d);
            this.N.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.N;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void e(g gVar) {
        d(gVar);
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.P = behavior;
        return behavior;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    int k() {
        int i3;
        int minimumHeight;
        int i16 = this.f33191f;
        if (i16 != -1) {
            return i16;
        }
        int i17 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = layoutParams.f33211a;
            if ((i18 & 5) == 5) {
                int i19 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i18 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i18 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i3 = i19 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i3 = Math.min(i3, measuredHeight - o());
                    }
                    i17 += i3;
                }
                i3 = i19 + minimumHeight;
                if (childCount == 0) {
                    i3 = Math.min(i3, measuredHeight - o());
                }
                i17 += i3;
            } else if (i17 > 0) {
                break;
            }
        }
        int max = Math.max(0, i17);
        this.f33191f = max;
        return max;
    }

    int l() {
        int i3 = this.f33192h;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i18 = layoutParams.f33211a;
            if ((i18 & 1) == 0) {
                break;
            }
            i17 += measuredHeight;
            if ((i18 & 2) != 0) {
                i17 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i16++;
        }
        int max = Math.max(0, i17);
        this.f33192h = max;
        return max;
    }

    public final int m() {
        int o16 = o();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                minimumHeight = ViewCompat.getMinimumHeight(getChildAt(childCount - 1));
            } else {
                minimumHeight = 0;
            }
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + o16;
    }

    int n() {
        return this.f33194m;
    }

    @VisibleForTesting
    final int o() {
        WindowInsetsCompat windowInsetsCompat = this.C;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        if (this.M == null) {
            this.M = new int[4];
        }
        int[] iArr = this.M;
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z16 = this.F;
        if (z16) {
            i16 = R.attr.bcp;
        } else {
            i16 = -2130971406;
        }
        iArr[0] = i16;
        if (z16 && this.G) {
            i17 = R.attr.bcq;
        } else {
            i17 = -2130971407;
        }
        iArr[1] = i17;
        if (z16) {
            i18 = R.attr.bcn;
        } else {
            i18 = -2130971404;
        }
        iArr[2] = i18;
        if (z16 && this.G) {
            i19 = R.attr.bcm;
        } else {
            i19 = -2130971403;
        }
        iArr[3] = i19;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        boolean z17 = true;
        if (ViewCompat.getFitsSystemWindows(this) && H()) {
            int o16 = o();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), o16);
            }
        }
        u();
        this.f33193i = false;
        int childCount2 = getChildCount();
        int i19 = 0;
        while (true) {
            if (i19 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i19).getLayoutParams()).d() != null) {
                this.f33193i = true;
                break;
            }
            i19++;
        }
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), o());
        }
        if (!this.E) {
            if (!this.H && !s()) {
                z17 = false;
            }
            C(z17);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && H()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += o();
                }
            } else {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + o(), 0, View.MeasureSpec.getSize(i16));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        u();
    }

    public final int p() {
        int i3 = this.f33190e;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = layoutParams.f33211a;
            if ((i18 & 1) == 0) {
                break;
            }
            i17 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i16 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i17 -= o();
            }
            if ((i18 & 2) != 0) {
                i17 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i16++;
        }
        int max = Math.max(0, i17);
        this.f33190e = max;
        return max;
    }

    int q() {
        return p();
    }

    boolean r() {
        return this.f33193i;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        com.google.android.material.shape.d.d(this, f16);
    }

    public void setExpanded(boolean z16) {
        setExpanded(z16, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z16) {
        this.H = z16;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i3) {
        this.I = i3;
        f();
    }

    public void setLiftableOverrideEnabled(boolean z16) {
        this.E = z16;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 == 1) {
            super.setOrientation(i3);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z16;
        Drawable drawable2 = this.N;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.N = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.N.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.N, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.N;
                if (getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                drawable4.setVisible(z16, false);
                this.N.setCallback(this);
            }
            J();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i3) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f16) {
        com.google.android.material.appbar.f.b(this, f16);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        boolean z16;
        super.setVisibility(i3);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.setVisible(z16, false);
        }
    }

    boolean t() {
        if (p() != 0) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return this.H;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.N) {
            return false;
        }
        return true;
    }

    void w(int i3) {
        this.f33189d = i3;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<c> list = this.D;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                c cVar = this.D.get(i16);
                if (cVar != null) {
                    cVar.onOffsetChanged(this, i3);
                }
            }
        }
    }

    WindowInsetsCompat x(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.C, windowInsetsCompat2)) {
            this.C = windowInsetsCompat2;
            J();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void y(@Nullable c cVar) {
        List<c> list = this.D;
        if (list != null && cVar != null) {
            list.remove(cVar);
        }
    }

    public void z(g gVar) {
        y(gVar);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f50081);
    }

    public void setExpanded(boolean z16, boolean z17) {
        B(z16, z17, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = Q;
        this.f33190e = -1;
        this.f33191f = -1;
        this.f33192h = -1;
        this.f33194m = 0;
        this.L = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i17 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            com.google.android.material.appbar.f.a(this);
        }
        com.google.android.material.appbar.f.c(this, attributeSet, i3, i16);
        TypedArray h16 = o.h(context2, attributeSet, w0.a.f443926k, i3, i16, new int[0]);
        ViewCompat.setBackground(this, h16.getDrawable(w0.a.f443937l));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.Y(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.N(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        int i18 = w0.a.f443982p;
        if (h16.hasValue(i18)) {
            B(h16.getBoolean(i18, false), false, false);
        }
        if (h16.hasValue(w0.a.f443970o)) {
            com.google.android.material.appbar.f.b(this, h16.getDimensionPixelSize(r12, 0));
        }
        if (i17 >= 26) {
            int i19 = w0.a.f443959n;
            if (h16.hasValue(i19)) {
                setKeyboardNavigationCluster(h16.getBoolean(i19, false));
            }
            int i26 = w0.a.f443948m;
            if (h16.hasValue(i26)) {
                setTouchscreenBlocksFocus(h16.getBoolean(i26, false));
            }
        }
        this.H = h16.getBoolean(w0.a.f443994q, false);
        this.I = h16.getResourceId(w0.a.f444006r, -1);
        setStatusBarForeground(h16.getDrawable(w0.a.f444018s));
        h16.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f33211a;

        /* renamed from: b, reason: collision with root package name */
        private d f33212b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f33213c;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes2.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33211a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f444042u);
            this.f33211a = obtainStyledAttributes.getInt(w0.a.f444065w, 0);
            f(a(obtainStyledAttributes.getInt(w0.a.f444054v, 0)));
            int i3 = w0.a.f444076x;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f33213c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i3, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @Nullable
        private d a(int i3) {
            if (i3 != 1) {
                return null;
            }
            return new e();
        }

        @Nullable
        public d b() {
            return this.f33212b;
        }

        public int c() {
            return this.f33211a;
        }

        public Interpolator d() {
            return this.f33213c;
        }

        boolean e() {
            int i3 = this.f33211a;
            if ((i3 & 1) == 1 && (i3 & 10) != 0) {
                return true;
            }
            return false;
        }

        public void f(@Nullable d dVar) {
            this.f33212b = dVar;
        }

        public void g(int i3) {
            this.f33211a = i3;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f33211a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33211a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f33211a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33211a = 1;
        }
    }
}
