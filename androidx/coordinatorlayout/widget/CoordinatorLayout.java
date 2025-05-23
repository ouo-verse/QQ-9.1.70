package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.tencent.mapsdk.internal.by;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final Pools.Pool<Rect> sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View view, @Nullable Object obj) {
            ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
            if (getScrimOpacity(coordinatorLayout, v3) > 0.0f) {
                return true;
            }
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
            return -16777216;
        }

        @FloatRange(from = 0.0d, to = by.f147964a)
        public float getScrimOpacity(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view) {
            return false;
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view) {
            return false;
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3, int i16, int i17, int i18) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, float f16, float f17, boolean z16) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, float f16, float f17) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, int i17, int i18) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Rect rect, boolean z16) {
            return false;
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
            if (i17 == 0) {
                onNestedPreScroll(coordinatorLayout, v3, view, i3, i16, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, int i17, int i18, int i19) {
            if (i19 == 0) {
                onNestedScroll(coordinatorLayout, v3, view, i3, i16, i17, i18);
            }
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3, int i16) {
            if (i16 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v3, view, view2, i3);
            }
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3, int i16) {
            if (i16 == 0) {
                return onStartNestedScroll(coordinatorLayout, v3, view, view2, i3);
            }
            return false;
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3) {
            if (i3 == 0) {
                onStopNestedScroll(coordinatorLayout, v3, view);
            }
        }

        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i17;
            iArr[1] = iArr[1] + i18;
            onNestedScroll(coordinatorLayout, v3, view, i3, i16, i17, i18, i19);
        }

        public void onDetachedFromLayoutParams() {
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view) {
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Parcelable parcelable) {
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DispatchChangeEvent {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            EventCollector.getInstance().onChildViewAdded(view, view2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            EventCollector.getInstance().onChildViewRemoved(view, view2);
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float z16 = ViewCompat.getZ(view);
            float z17 = ViewCompat.getZ(view2);
            if (z16 > z17) {
                return -1;
            }
            return z16 < z17 ? 1 : 0;
        }
    }

    static {
        String str;
        Package r06 = CoordinatorLayout.class.getPackage();
        if (r06 != null) {
            str = r06.getName();
        } else {
            str = null;
        }
        WIDGET_PACKAGE_NAME = str;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private static int clamp(int i3, int i16, int i17) {
        if (i3 < i16) {
            return i16;
        }
        if (i3 > i17) {
            return i17;
        }
        return i3;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i3, int i16) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i16) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(max, max2, i3 + max, i16 + max2);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior behavior;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (ViewCompat.getFitsSystemWindows(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) != null) {
                windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i3, Rect rect, Rect rect2, LayoutParams layoutParams, int i16, int i17) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i3);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i3);
        int i18 = absoluteGravity & 7;
        int i19 = absoluteGravity & 112;
        int i26 = absoluteGravity2 & 7;
        int i27 = absoluteGravity2 & 112;
        if (i26 != 1) {
            if (i26 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i27 != 16) {
            if (i27 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i18 != 1) {
            if (i18 != 5) {
                width -= i16;
            }
        } else {
            width -= i16 / 2;
        }
        if (i19 != 16) {
            if (i19 != 80) {
                height -= i17;
            }
        } else {
            height -= i17 / 2;
        }
        rect2.set(width, height, i16 + width, i17 + height);
    }

    private int getKeyline(int i3) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e(TAG, "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    private void getTopSortedChildren(List<View> list) {
        int i3;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i16 = childCount - 1; i16 >= 0; i16--) {
            if (isChildrenDrawingOrderEnabled) {
                i3 = getChildDrawingOrder(childCount, i16);
            } else {
                i3 = i16;
            }
            list.add(getChildAt(i3));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    private void layoutChild(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i3);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i3) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i3, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i3, int i16) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i16);
        int i17 = absoluteGravity & 7;
        int i18 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i16 == 1) {
            i3 = width - i3;
        }
        int keyline = getKeyline(i3) - measuredWidth;
        if (i17 != 1) {
            if (i17 == 5) {
                keyline += measuredWidth;
            }
        } else {
            keyline += measuredWidth / 2;
        }
        int i19 = 0;
        if (i18 != 16) {
            if (i18 == 80) {
                i19 = measuredHeight + 0;
            }
        } else {
            i19 = 0 + (measuredHeight / 2);
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i19, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void offsetChildByInset(View view, Rect rect, int i3) {
        boolean z16;
        boolean z17;
        int width;
        int i16;
        int i17;
        int i18;
        int height;
        int i19;
        int i26;
        int i27;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior != null && behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                if (!acquireTempRect2.contains(acquireTempRect)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
                }
            } else {
                acquireTempRect.set(acquireTempRect2);
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i3);
            boolean z18 = true;
            if ((absoluteGravity & 48) == 48 && (i26 = (acquireTempRect.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.mInsetOffsetY) < (i27 = rect.top)) {
                setInsetOffsetY(view, i27 - i26);
                z16 = true;
            } else {
                z16 = false;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.mInsetOffsetY) < (i19 = rect.bottom)) {
                setInsetOffsetY(view, height - i19);
                z16 = true;
            }
            if (!z16) {
                setInsetOffsetY(view, 0);
            }
            if ((absoluteGravity & 3) == 3 && (i17 = (acquireTempRect.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.mInsetOffsetX) < (i18 = rect.left)) {
                setInsetOffsetX(view, i18 - i17);
                z17 = true;
            } else {
                z17 = false;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - acquireTempRect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.mInsetOffsetX) < (i16 = rect.right)) {
                setInsetOffsetX(view, width - i16);
            } else {
                z18 = z17;
            }
            if (!z18) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e16) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e16);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z16 = false;
        boolean z17 = false;
        for (int i16 = 0; i16 < size; i16++) {
            View view = list.get(i16);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if ((z16 || z17) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i3 != 0) {
                        if (i3 == 1) {
                            behavior.onTouchEvent(this, view, motionEvent2);
                        }
                    } else {
                        behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z16 && behavior != null) {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            z16 = behavior.onTouchEvent(this, view, motionEvent);
                        }
                    } else {
                        z16 = behavior.onInterceptTouchEvent(this, view, motionEvent);
                    }
                    if (z16) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean didBlockInteraction = layoutParams.didBlockInteraction();
                boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, view);
                if (isBlockingInteractionBelow && !didBlockInteraction) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (isBlockingInteractionBelow && !z17) {
                    break;
                }
            }
        }
        list.clear();
        return z16;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i16 = 0; i16 < childCount; i16++) {
                if (i16 != i3) {
                    View childAt2 = getChildAt(i16);
                    if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    private void resetTouchBehaviors(boolean z16) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z16) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            ((LayoutParams) getChildAt(i16).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i3) {
        if (i3 == 0) {
            return 17;
        }
        return i3;
    }

    private static int resolveGravity(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        if ((i3 & 112) == 0) {
            return i3 | 48;
        }
        return i3;
    }

    private static int resolveKeylineGravity(int i3) {
        if (i3 == 0) {
            return 8388661;
        }
        return i3;
    }

    private void setInsetOffsetX(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i16 = layoutParams.mInsetOffsetX;
        if (i16 != i3) {
            ViewCompat.offsetLeftAndRight(view, i3 - i16);
            layoutParams.mInsetOffsetX = i3;
        }
    }

    private void setInsetOffsetY(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i16 = layoutParams.mInsetOffsetY;
        if (i16 != i3) {
            ViewCompat.offsetTopAndBottom(view, i3 - i16);
            layoutParams.mInsetOffsetY = i3;
        }
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        if (incomingEdges != null && !incomingEdges.isEmpty()) {
            for (int i3 = 0; i3 < incomingEdges.size(); i3++) {
                View view2 = (View) incomingEdges.get(i3);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        if (view.getParent() != this) {
            z16 = true;
        } else {
            z16 = false;
        }
        getChildRect(view, z16, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        if (view2.getParent() != this) {
            z17 = true;
        } else {
            z17 = false;
        }
        getChildRect(view2, z17, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left) {
                if (acquireTempRect.bottom >= acquireTempRect2.top) {
                    z18 = true;
                }
            }
            return z18;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.mBehavior;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z16 = false;
        if (drawable != null && drawable.isStateful()) {
            z16 = false | drawable.setState(drawableState);
        }
        if (z16) {
            invalidate();
        }
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (hasDependencies(getChildAt(i3))) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (z16 != this.mNeedsPreDrawListener) {
            if (z16) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    void getChildRect(View view, boolean z16, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z16) {
                getDescendantRect(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        List<View> outgoingEdges = this.mChildDag.getOutgoingEdges(view);
        this.mTempDependenciesList.clear();
        if (outgoingEdges != null) {
            this.mTempDependenciesList.addAll(outgoingEdges);
        }
        return this.mTempDependenciesList;
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        this.mTempDependenciesList.clear();
        if (incomingEdges != null) {
            this.mTempDependenciesList.addAll(incomingEdges);
        }
        return this.mTempDependenciesList;
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    void getDesiredAnchoredChildRect(View view, int i3, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i3, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                layoutParams.setBehavior(behavior);
                layoutParams.mBehaviorResolved = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.setBehavior(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e16) {
                        Log.e(TAG, "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e16);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
        }
        return layoutParams;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(@NonNull View view, int i3, int i16) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i3, i16);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    void offsetChildToAnchor(View view, int i3) {
        Behavior behavior;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            boolean z16 = false;
            getChildRect(view, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i3, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            if (acquireTempRect3.left != acquireTempRect2.left || acquireTempRect3.top != acquireTempRect2.top) {
                z16 = true;
            }
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i16 = acquireTempRect3.left - acquireTempRect2.left;
            int i17 = acquireTempRect3.top - acquireTempRect2.top;
            if (i16 != 0) {
                ViewCompat.offsetLeftAndRight(view, i16);
            }
            if (i17 != 0) {
                ViewCompat.offsetTopAndBottom(view, i17);
            }
            if (z16 && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onDependentViewChanged(this, view, layoutParams.mAnchorView);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    final void onChildViewsChanged(int i3) {
        boolean z16;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i16 = 0; i16 < size; i16++) {
            View view = this.mDependencySortedChildren.get(i16);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i17 = 0; i17 < i16; i17++) {
                    if (layoutParams.mAnchorDirectChild == this.mDependencySortedChildren.get(i17)) {
                        offsetChildToAnchor(view, layoutDirection);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (layoutParams.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    int i18 = absoluteGravity & 112;
                    if (i18 != 48) {
                        if (i18 == 80) {
                            acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                        }
                    } else {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    }
                    int i19 = absoluteGravity & 7;
                    if (i19 != 3) {
                        if (i19 == 5) {
                            acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                        }
                    } else {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, layoutDirection);
                }
                if (i3 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i26 = i16 + 1; i26 < size; i26++) {
                    View view2 = this.mDependencySortedChildren.get(i26);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i3 == 0 && layoutParams2.getChangedAfterNestedScroll()) {
                            layoutParams2.resetChangedAfterNestedScroll();
                        } else {
                            if (i3 != 2) {
                                z16 = behavior.onDependentViewChanged(this, view2, view);
                            } else {
                                behavior.onDependentViewRemoved(this, view2, view);
                                z16 = true;
                            }
                            if (i3 == 1) {
                                layoutParams2.setChangedAfterNestedScroll(z16);
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                i3 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i3);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        Behavior behavior;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i19 = 0; i19 < size; i19++) {
            View view = this.mDependencySortedChildren.get(i19);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.checkAnchorChanged()) {
            View view2 = layoutParams.mAnchorView;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i3);
                return;
            }
            int i16 = layoutParams.keyline;
            if (i16 >= 0) {
                layoutChildWithKeyline(view, i16, i3);
                return;
            } else {
                layoutChild(view, i3);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011a, code lost:
    
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        boolean z17;
        int i17;
        int i18;
        int i19;
        int i26;
        Behavior behavior;
        LayoutParams layoutParams;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        int i39 = paddingLeft + paddingRight;
        int i46 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
            z17 = true;
        } else {
            z17 = false;
        }
        int size3 = this.mDependencySortedChildren.size();
        int i47 = suggestedMinimumWidth;
        int i48 = suggestedMinimumHeight;
        int i49 = 0;
        int i56 = 0;
        while (i56 < size3) {
            View view = this.mDependencySortedChildren.get(i56);
            if (view.getVisibility() == 8) {
                i37 = i56;
                i28 = size3;
                i29 = paddingLeft;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                int i57 = layoutParams2.keyline;
                if (i57 >= 0 && mode != 0) {
                    int keyline = getKeyline(i57);
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams2.gravity), layoutDirection) & 7;
                    i17 = i49;
                    if ((absoluteGravity == 3 && !z16) || (absoluteGravity == 5 && z16)) {
                        i18 = Math.max(0, (size - paddingRight) - keyline);
                    } else if ((absoluteGravity == 5 && !z16) || (absoluteGravity == 3 && z16)) {
                        i18 = Math.max(0, keyline - paddingLeft);
                    }
                    if (!z17 && !ViewCompat.getFitsSystemWindows(view)) {
                        int systemWindowInsetLeft = this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight();
                        int systemWindowInsetTop = this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom();
                        i19 = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetLeft, mode);
                        i26 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetTop, mode2);
                    } else {
                        i19 = i3;
                        i26 = i16;
                    }
                    behavior = layoutParams2.getBehavior();
                    if (behavior == null) {
                        layoutParams = layoutParams2;
                        i36 = i17;
                        i37 = i56;
                        i27 = i48;
                        i29 = paddingLeft;
                        i38 = i47;
                        i28 = size3;
                    } else {
                        layoutParams = layoutParams2;
                        i27 = i48;
                        i28 = size3;
                        i29 = paddingLeft;
                        i36 = i17;
                        i37 = i56;
                        i38 = i47;
                    }
                    onMeasureChild(view, i19, i18, i26, 0);
                    LayoutParams layoutParams3 = layoutParams;
                    int max = Math.max(i38, i39 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin);
                    int max2 = Math.max(i27, i46 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin);
                    i49 = View.combineMeasuredStates(i36, view.getMeasuredState());
                    i47 = max;
                    i48 = max2;
                } else {
                    i17 = i49;
                }
                i18 = 0;
                if (!z17) {
                }
                i19 = i3;
                i26 = i16;
                behavior = layoutParams2.getBehavior();
                if (behavior == null) {
                }
                onMeasureChild(view, i19, i18, i26, 0);
                LayoutParams layoutParams32 = layoutParams;
                int max3 = Math.max(i38, i39 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams32).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).rightMargin);
                int max22 = Math.max(i27, i46 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams32).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin);
                i49 = View.combineMeasuredStates(i36, view.getMeasuredState());
                i47 = max3;
                i48 = max22;
            }
            i56 = i37 + 1;
            paddingLeft = i29;
            size3 = i28;
        }
        int i58 = i49;
        setMeasuredDimension(View.resolveSizeAndState(i47, i3, (-16777216) & i58), View.resolveSizeAndState(i48, i16, i58 << 16));
    }

    public void onMeasureChild(View view, int i3, int i16, int i17, int i18) {
        measureChildWithMargins(view, i3, i16, i17, i18);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z17 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z17 |= behavior.onNestedFling(this, childAt, view, f16, f17, z16);
                }
            }
        }
        if (z17) {
            onChildViewsChanged(1);
        }
        return z17;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z16 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z16 |= behavior.onNestedPreFling(this, childAt, view, f16, f17);
                }
            }
        }
        return z16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        onNestedPreScroll(view, i3, i16, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        onNestedScroll(view, i3, i16, i17, i18, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id5 = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
            if (id5 != -1 && behavior != null && (parcelable2 = sparseArray.get(id5)) != null) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id5 = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (id5 != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id5, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean onTouchEvent;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            z16 = performIntercept(motionEvent, 1);
        } else {
            z16 = false;
        }
        Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (behavior != null) {
            onTouchEvent = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
                onTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (z16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                resetTouchBehaviors(false);
            }
            return onTouchEvent;
        }
        onTouchEvent = false;
        motionEvent2 = null;
        if (this.mBehaviorTouchView != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        resetTouchBehaviors(false);
        return onTouchEvent;
    }

    void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior != null && behavior.onRequestChildRectangleOnScreen(this, view, rect, z16)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        super.requestDisallowInterceptTouchEvent(z16);
        if (z16 && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z16) {
        super.setFitsSystemWindows(z16);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z16;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                drawable4.setVisible(z16, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i3) {
        Drawable drawable;
        if (i3 != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i3);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
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
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z16) {
            this.mStatusBarBackground.setVisible(z16, false);
        }
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z16;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
            this.mLastInsets = windowInsetsCompat;
            boolean z17 = true;
            if (windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mDrawStatusBarBackground = z16;
            if (z16 || getBackground() != null) {
                z17 = false;
            }
            setWillNotDraw(z17);
            WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
            requestLayout();
            return dispatchApplyWindowInsetsToBehaviors;
        }
        return windowInsetsCompat;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mStatusBarBackground) {
            return false;
        }
        return true;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a9i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr, int i17) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z16 = false;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i17) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i3, i16, iArr2, i17);
                    int[] iArr3 = this.mBehaviorConsumed;
                    i18 = i3 > 0 ? Math.max(i18, iArr3[0]) : Math.min(i18, iArr3[0]);
                    int[] iArr4 = this.mBehaviorConsumed;
                    i19 = i16 > 0 ? Math.max(i19, iArr4[1]) : Math.min(i19, iArr4[1]);
                    z16 = true;
                }
            }
        }
        iArr[0] = i18;
        iArr[1] = i19;
        if (z16) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19) {
        onNestedScroll(view, i3, i16, i17, i18, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i3, int i16) {
        Behavior behavior;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i3, i16);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i16) && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i3, i16);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i3, int i16) {
        int childCount = getChildCount();
        boolean z16 = false;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i3, i16);
                    z16 |= onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i16, onStartNestedScroll);
                } else {
                    layoutParams.setNestedScrollAccepted(i16, false);
                }
            }
        }
        return z16;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i3) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i3);
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i3)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i3);
                }
                layoutParams.resetNestedScroll(i3);
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        if (i3 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.R.styleable.CoordinatorLayout, 0, R.style.ata);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.R.styleable.CoordinatorLayout, i3, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i3 == 0) {
                saveAttributeDataForStyleable(context, androidx.coordinatorlayout.R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R.style.ata);
            } else {
                saveAttributeDataForStyleable(context, androidx.coordinatorlayout.R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i3, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f16 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i16 = 0; i16 < length; i16++) {
                this.mKeylines[i16] = (int) (r12[i16] * f16);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        Behavior behavior;
        boolean z16;
        int min;
        int childCount = getChildCount();
        boolean z17 = false;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i19) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i3, i16, i17, i18, i19, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    i26 = i17 > 0 ? Math.max(i26, iArr3[0]) : Math.min(i26, iArr3[0]);
                    if (i18 > 0) {
                        z16 = true;
                        min = Math.max(i27, this.mBehaviorConsumed[1]);
                    } else {
                        z16 = true;
                        min = Math.min(i27, this.mBehaviorConsumed[1]);
                    }
                    i27 = min;
                    z17 = z16;
                }
            }
        }
        iArr[0] = iArr[0] + i26;
        iArr[1] = iArr[1] + i27;
        if (z17) {
            onChildViewsChanged(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                this.behaviorStates.append(iArr[i3], readParcelableArray[i3]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int i16;
            super.writeToParcel(parcel, i3);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i16 = sparseArray.size();
            } else {
                i16 = 0;
            }
            parcel.writeInt(i16);
            int[] iArr = new int[i16];
            Parcelable[] parcelableArr = new Parcelable[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                iArr[i17] = this.behaviorStates.keyAt(i17);
                parcelableArr[i17] = this.behaviorStates.valueAt(i17);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.mAnchorId);
            this.mAnchorView = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.mAnchorDirectChild = null;
                        this.mAnchorView = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = parent;
                    }
                }
                this.mAnchorDirectChild = findViewById;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
        }

        private boolean shouldDodge(View view, int i3) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i3);
            if (absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i3) & absoluteGravity) == absoluteGravity) {
                return true;
            }
            return false;
        }

        private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view2 = this.mAnchorView;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return false;
                }
            }
            this.mAnchorDirectChild = view2;
            return true;
        }

        boolean checkAnchorChanged() {
            if (this.mAnchorView == null && this.mAnchorId != -1) {
                return true;
            }
            return false;
        }

        boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            if (view2 != this.mAnchorDirectChild && !shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) && ((behavior = this.mBehavior) == null || !behavior.layoutDependsOn(coordinatorLayout, view, view2))) {
                return false;
            }
            return true;
        }

        boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
                resolveAnchorView(view, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            boolean z16;
            boolean z17 = this.mDidBlockInteraction;
            if (z17) {
                return true;
            }
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                z16 = behavior.blocksInteractionBelow(coordinatorLayout, view);
            } else {
                z16 = false;
            }
            boolean z18 = z16 | z17;
            this.mDidBlockInteraction = z18;
            return z18;
        }

        boolean isNestedScrollAccepted(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return false;
                }
                return this.mDidAcceptNestedScrollNonTouch;
            }
            return this.mDidAcceptNestedScrollTouch;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        void resetNestedScroll(int i3) {
            setNestedScrollAccepted(i3, false);
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int i3) {
            invalidateAnchor();
            this.mAnchorId = i3;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        void setChangedAfterNestedScroll(boolean z16) {
            this.mDidChangeAfterNestedScroll = z16;
        }

        void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        void setNestedScrollAccepted(int i3, boolean z16) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.mDidAcceptNestedScrollNonTouch = z16;
                    return;
                }
                return;
            }
            this.mDidAcceptNestedScrollTouch = z16;
        }

        LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i3 = androidx.coordinatorlayout.R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i3);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(i3));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }
    }
}
