package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10;
    static final ViewCompatImpl IMPL = new MarshmallowViewCompatImpl();
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        private Method mDispatchFinishTemporaryDetach;
        private Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

        BaseViewCompatImpl() {
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e16) {
                Log.e("ViewCompat", "Couldn't find method", e16);
            }
            this.mTempDetachBound = true;
        }

        private boolean canScrollingViewScrollHorizontally(ScrollingView scrollingView, int i3) {
            int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i3 < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            }
            if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            }
            return true;
        }

        private boolean canScrollingViewScrollVertically(ScrollingView scrollingView, int i3) {
            int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i3 < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            }
            if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            }
            return true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewPropertyAnimatorCompat animate(View view) {
            return new ViewPropertyAnimatorCompat(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i3) {
            if ((view instanceof ScrollingView) && canScrollingViewScrollHorizontally((ScrollingView) view, i3)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view, int i3) {
            if ((view instanceof ScrollingView) && canScrollingViewScrollVertically((ScrollingView) view, i3)) {
                return true;
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i3, int i16) {
            return i3 | i16;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchFinishTemporaryDetach(View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            Method method = this.mDispatchFinishTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e16) {
                    Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e16);
                    return;
                }
            }
            view.onFinishTemporaryDetach();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view, float f16, float f17, boolean z16) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedFling(f16, f17, z16);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view, float f16, float f17) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreFling(f16, f17);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view, int i3, int i16, int[] iArr, int[] iArr2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreScroll(i3, i16, iArr, iArr2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view, int i3, int i16, int i17, int i18, int[] iArr) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedScroll(i3, i16, i17, i18, iArr);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void dispatchStartTemporaryDetach(View view) {
            if (!this.mTempDetachBound) {
                bindTempDetach();
            }
            Method method = this.mDispatchStartTemporaryDetach;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e16) {
                    Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e16);
                    return;
                }
            }
            view.onStartTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view) {
            return 1.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatBase.getBackgroundTintList(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatBase.getBackgroundTintMode(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view) {
            return false;
        }

        long getFrameTime() {
            return 10L;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view) {
            return view.getMeasuredHeight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view) {
            return view.getMeasuredWidth();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view) {
            return ViewCompatBase.getMinimumHeight(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view) {
            return ViewCompatBase.getMinimumWidth(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View view) {
            return 2;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getScrollIndicators(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view) {
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view) {
            return 0;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view) {
            return 0.0f;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOnClickListeners(View view) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view) {
            return ViewCompatBase.isAttachedToWindow(view);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view) {
            return true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view) {
            return ViewCompatBase.isLaidOut(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view, int i3) {
            ViewCompatBase.offsetLeftAndRight(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view, int i3) {
            ViewCompatBase.offsetTopAndBottom(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return false;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view, Runnable runnable, long j3) {
            view.postDelayed(runnable, getFrameTime() + j3);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i3, int i16, int i17) {
            return View.resolveSize(i3, i16);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatBase.setBackgroundTintList(view, colorStateList);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatBase.setBackgroundTintMode(view, mode);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view, boolean z16) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z16);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view, int i3, int i16, int i17, int i18) {
            view.setPadding(i3, i16, i17, i18);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view, int i3) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view, int i3) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).startNestedScroll(i3);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view, int i3, int i16, int i17, int i18) {
            view.invalidate(i3, i16, i17, i18);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view, int i3, int i16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view, int i3) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view, boolean z16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view, Rect rect) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view, boolean z16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view, boolean z16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i3) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view, int i3) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view, int i3) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View view, int i3) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view, boolean z16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view, String str) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view, float f16) {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view, int i3, Paint paint) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        EclairMr1ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isOpaque(View view) {
            return ViewCompatEclairMr1.isOpaque(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16) {
            ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewGroup, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        GBViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getOverScrollMode(View view) {
            return ViewCompatGingerbread.getOverScrollMode(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOverScrollMode(View view, int i3) {
            ViewCompatGingerbread.setOverScrollMode(view, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class HCViewCompatImpl extends GBViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int combineMeasuredStates(int i3, int i16) {
            return ViewCompatHC.combineMeasuredStates(i3, i16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getAlpha(View view) {
            return ViewCompatHC.getAlpha(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ViewCompatHC.getFrameTime();
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayerType(View view) {
            return ViewCompatHC.getLayerType(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredHeightAndState(View view) {
            return ViewCompatHC.getMeasuredHeightAndState(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredState(View view) {
            return ViewCompatHC.getMeasuredState(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMeasuredWidthAndState(View view) {
            return ViewCompatHC.getMeasuredWidthAndState(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotX(View view) {
            return ViewCompatHC.getPivotX(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getPivotY(View view) {
            return ViewCompatHC.getPivotY(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotation(View view) {
            return ViewCompatHC.getRotation(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationX(View view) {
            return ViewCompatHC.getRotationX(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getRotationY(View view) {
            return ViewCompatHC.getRotationY(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleX(View view) {
            return ViewCompatHC.getScaleX(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getScaleY(View view) {
            return ViewCompatHC.getScaleY(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationX(View view) {
            return ViewCompatHC.getTranslationX(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationY(View view) {
            return ViewCompatHC.getTranslationY(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getX(View view) {
            return ViewCompatHC.getX(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getY(View view) {
            return ViewCompatHC.getY(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void jumpDrawablesToCurrentState(View view) {
            ViewCompatHC.jumpDrawablesToCurrentState(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view, int i3) {
            ViewCompatHC.offsetLeftAndRight(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view, int i3) {
            ViewCompatHC.offsetTopAndBottom(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int resolveSizeAndState(int i3, int i16, int i17) {
            return ViewCompatHC.resolveSizeAndState(i3, i16, i17);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setActivated(View view, boolean z16) {
            ViewCompatHC.setActivated(view, z16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAlpha(View view, float f16) {
            ViewCompatHC.setAlpha(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
            setLayerType(view, getLayerType(view), paint);
            view.invalidate();
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerType(View view, int i3, Paint paint) {
            ViewCompatHC.setLayerType(view, i3, paint);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotX(View view, float f16) {
            ViewCompatHC.setPivotX(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPivotY(View view, float f16) {
            ViewCompatHC.setPivotY(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotation(View view, float f16) {
            ViewCompatHC.setRotation(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationX(View view, float f16) {
            ViewCompatHC.setRotationX(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setRotationY(View view, float f16) {
            ViewCompatHC.setRotationY(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setSaveFromParentEnabled(View view, boolean z16) {
            ViewCompatHC.setSaveFromParentEnabled(view, z16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleX(View view, float f16) {
            ViewCompatHC.setScaleX(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScaleY(View view, float f16) {
            ViewCompatHC.setScaleY(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationX(View view, float f16) {
            ViewCompatHC.setTranslationX(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationY(View view, float f16) {
            ViewCompatHC.setTranslationY(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setX(View view, float f16) {
            ViewCompatHC.setX(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setY(View view, float f16) {
            ViewCompatHC.setY(view, f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOnClickListeners(View view) {
            return ViewCompatICSMr1.hasOnClickListeners(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        static boolean accessibilityDelegateCheckFailed = false;
        static Field mAccessibilityDelegateField;

        ICSViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewPropertyAnimatorCompat animate(View view) {
            if (this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mViewPropertyAnimatorCompatMap.get(view);
            if (viewPropertyAnimatorCompat == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
                this.mViewPropertyAnimatorCompatMap.put(view, viewPropertyAnimatorCompat2);
                return viewPropertyAnimatorCompat2;
            }
            return viewPropertyAnimatorCompat;
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i3) {
            return ViewCompatICS.canScrollHorizontally(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean canScrollVertically(View view, int i3) {
            return ViewCompatICS.canScrollVertically(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasAccessibilityDelegate(View view) {
            if (accessibilityDelegateCheckFailed) {
                return false;
            }
            if (mAccessibilityDelegateField == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    mAccessibilityDelegateField = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable unused) {
                    accessibilityDelegateCheckFailed = true;
                    return false;
                }
            }
            try {
                if (mAccessibilityDelegateField.get(view) == null) {
                    return false;
                }
                return true;
            } catch (Throwable unused2) {
                accessibilityDelegateCheckFailed = true;
                return false;
            }
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.getInfo());
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityDelegate(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            Object bridge;
            if (accessibilityDelegateCompat == null) {
                bridge = null;
            } else {
                bridge = accessibilityDelegateCompat.getBridge();
            }
            ViewCompatICS.setAccessibilityDelegate(view, bridge);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setFitsSystemWindows(View view, boolean z16) {
            ViewCompatICS.setFitsSystemWindows(view, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            Object accessibilityNodeProvider = ViewCompatJB.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean getFitsSystemWindows(View view) {
            return ViewCompatJB.getFitsSystemWindows(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getImportantForAccessibility(View view) {
            return ViewCompatJB.getImportantForAccessibility(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumHeight(View view) {
            return ViewCompatJB.getMinimumHeight(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getMinimumWidth(View view) {
            return ViewCompatJB.getMinimumWidth(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ViewParent getParentForAccessibility(View view) {
            return ViewCompatJB.getParentForAccessibility(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasOverlappingRendering(View view) {
            return ViewCompatJB.hasOverlappingRendering(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasTransientState(View view) {
            return ViewCompatJB.hasTransientState(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return ViewCompatJB.performAccessibilityAction(view, i3, bundle);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            ViewCompatJB.postOnAnimation(view, runnable);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postOnAnimationDelayed(View view, Runnable runnable, long j3) {
            ViewCompatJB.postOnAnimationDelayed(view, runnable, j3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
            ViewCompatJB.requestApplyInsets(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setHasTransientState(View view, boolean z16) {
            ViewCompatJB.setHasTransientState(view, z16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i3) {
            if (i3 == 4) {
                i3 = 2;
            }
            ViewCompatJB.setImportantForAccessibility(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view, int i3, int i16, int i17, int i18) {
            ViewCompatJB.postInvalidateOnAnimation(view, i3, i16, i17, i18);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLabelFor(View view) {
            return ViewCompatJellybeanMr1.getLabelFor(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getLayoutDirection(View view) {
            return ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingEnd(View view) {
            return ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getPaddingStart(View view) {
            return ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getWindowSystemUiVisibility(View view) {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isPaddingRelative(View view) {
            return ViewCompatJellybeanMr1.isPaddingRelative(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLabelFor(View view, int i3) {
            ViewCompatJellybeanMr1.setLabelFor(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayerPaint(View view, Paint paint) {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setLayoutDirection(View view, int i3) {
            ViewCompatJellybeanMr1.setLayoutDirection(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setPaddingRelative(View view, int i3, int i16, int i17, int i18) {
            ViewCompatJellybeanMr1.setPaddingRelative(view, i3, i16, i17, i18);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public Rect getClipBounds(View view) {
            return ViewCompatJellybeanMr2.getClipBounds(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setClipBounds(View view, Rect rect) {
            ViewCompatJellybeanMr2.setClipBounds(view, rect);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getAccessibilityLiveRegion(View view) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isAttachedToWindow(View view) {
            return ViewCompatKitKat.isAttachedToWindow(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isLaidOut(View view) {
            return ViewCompatKitKat.isLaidOut(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setAccessibilityLiveRegion(View view, int i3) {
            ViewCompatKitKat.setAccessibilityLiveRegion(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.JBViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setImportantForAccessibility(View view, int i3) {
            ViewCompatJB.setImportantForAccessibility(view, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompatLollipop.dispatchApplyWindowInsets(view, windowInsetsCompat);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedFling(View view, float f16, float f17, boolean z16) {
            return ViewCompatLollipop.dispatchNestedFling(view, f16, f17, z16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreFling(View view, float f16, float f17) {
            return ViewCompatLollipop.dispatchNestedPreFling(view, f16, f17);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedPreScroll(View view, int i3, int i16, int[] iArr, int[] iArr2) {
            return ViewCompatLollipop.dispatchNestedPreScroll(view, i3, i16, iArr, iArr2);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean dispatchNestedScroll(View view, int i3, int i16, int i17, int i18, int[] iArr) {
            return ViewCompatLollipop.dispatchNestedScroll(view, i3, i16, i17, i18, iArr);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatLollipop.getBackgroundTintList(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatLollipop.getBackgroundTintMode(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getElevation(View view) {
            return ViewCompatLollipop.getElevation(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public String getTransitionName(View view) {
            return ViewCompatLollipop.getTransitionName(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getTranslationZ(View view) {
            return ViewCompatLollipop.getTranslationZ(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public float getZ(View view) {
            return ViewCompatLollipop.getZ(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean hasNestedScrollingParent(View view) {
            return ViewCompatLollipop.hasNestedScrollingParent(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isImportantForAccessibility(View view) {
            return ViewCompatLollipop.isImportantForAccessibility(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean isNestedScrollingEnabled(View view) {
            return ViewCompatLollipop.isNestedScrollingEnabled(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompatLollipop.onApplyWindowInsets(view, windowInsetsCompat);
        }

        @Override // android.support.v4.view.ViewCompat.JBViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void requestApplyInsets(View view) {
            ViewCompatLollipop.requestApplyInsets(view);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatLollipop.setBackgroundTintList(view, colorStateList);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatLollipop.setBackgroundTintMode(view, mode);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setElevation(View view, float f16) {
            ViewCompatLollipop.setElevation(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setNestedScrollingEnabled(View view, boolean z16) {
            ViewCompatLollipop.setNestedScrollingEnabled(view, z16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            ViewCompatLollipop.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTransitionName(View view, String str) {
            ViewCompatLollipop.setTransitionName(view, str);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setTranslationZ(View view, float f16) {
            ViewCompatLollipop.setTranslationZ(view, f16);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public boolean startNestedScroll(View view, int i3) {
            return ViewCompatLollipop.startNestedScroll(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void stopNestedScroll(View view) {
            ViewCompatLollipop.stopNestedScroll(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        MarshmallowViewCompatImpl() {
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public int getScrollIndicators(View view) {
            return ViewCompatMarshmallow.getScrollIndicators(view);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetLeftAndRight(View view, int i3) {
            ViewCompatMarshmallow.offsetLeftAndRight(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.HCViewCompatImpl, android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void offsetTopAndBottom(View view, int i3) {
            ViewCompatMarshmallow.offsetTopAndBottom(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view, int i3) {
            ViewCompatMarshmallow.setScrollIndicators(view, i3);
        }

        @Override // android.support.v4.view.ViewCompat.BaseViewCompatImpl, android.support.v4.view.ViewCompat.ViewCompatImpl
        public void setScrollIndicators(View view, int i3, int i16) {
            ViewCompatMarshmallow.setScrollIndicators(view, i3, i16);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ViewCompatImpl {
        ViewPropertyAnimatorCompat animate(View view);

        boolean canScrollHorizontally(View view, int i3);

        boolean canScrollVertically(View view, int i3);

        int combineMeasuredStates(int i3, int i16);

        WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void dispatchFinishTemporaryDetach(View view);

        boolean dispatchNestedFling(View view, float f16, float f17, boolean z16);

        boolean dispatchNestedPreFling(View view, float f16, float f17);

        boolean dispatchNestedPreScroll(View view, int i3, int i16, int[] iArr, int[] iArr2);

        boolean dispatchNestedScroll(View view, int i3, int i16, int i17, int i18, int[] iArr);

        void dispatchStartTemporaryDetach(View view);

        int getAccessibilityLiveRegion(View view);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view);

        float getAlpha(View view);

        ColorStateList getBackgroundTintList(View view);

        PorterDuff.Mode getBackgroundTintMode(View view);

        Rect getClipBounds(View view);

        float getElevation(View view);

        boolean getFitsSystemWindows(View view);

        int getImportantForAccessibility(View view);

        int getLabelFor(View view);

        int getLayerType(View view);

        int getLayoutDirection(View view);

        int getMeasuredHeightAndState(View view);

        int getMeasuredState(View view);

        int getMeasuredWidthAndState(View view);

        int getMinimumHeight(View view);

        int getMinimumWidth(View view);

        int getOverScrollMode(View view);

        int getPaddingEnd(View view);

        int getPaddingStart(View view);

        ViewParent getParentForAccessibility(View view);

        float getPivotX(View view);

        float getPivotY(View view);

        float getRotation(View view);

        float getRotationX(View view);

        float getRotationY(View view);

        float getScaleX(View view);

        float getScaleY(View view);

        int getScrollIndicators(View view);

        String getTransitionName(View view);

        float getTranslationX(View view);

        float getTranslationY(View view);

        float getTranslationZ(View view);

        int getWindowSystemUiVisibility(View view);

        float getX(View view);

        float getY(View view);

        float getZ(View view);

        boolean hasAccessibilityDelegate(View view);

        boolean hasNestedScrollingParent(View view);

        boolean hasOnClickListeners(View view);

        boolean hasOverlappingRendering(View view);

        boolean hasTransientState(View view);

        boolean isAttachedToWindow(View view);

        boolean isImportantForAccessibility(View view);

        boolean isLaidOut(View view);

        boolean isNestedScrollingEnabled(View view);

        boolean isOpaque(View view);

        boolean isPaddingRelative(View view);

        void jumpDrawablesToCurrentState(View view);

        void offsetLeftAndRight(View view, int i3);

        void offsetTopAndBottom(View view, int i3);

        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i3, Bundle bundle);

        void postInvalidateOnAnimation(View view);

        void postInvalidateOnAnimation(View view, int i3, int i16, int i17, int i18);

        void postOnAnimation(View view, Runnable runnable);

        void postOnAnimationDelayed(View view, Runnable runnable, long j3);

        void requestApplyInsets(View view);

        int resolveSizeAndState(int i3, int i16, int i17);

        void setAccessibilityDelegate(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat);

        void setAccessibilityLiveRegion(View view, int i3);

        void setActivated(View view, boolean z16);

        void setAlpha(View view, float f16);

        void setBackgroundTintList(View view, ColorStateList colorStateList);

        void setBackgroundTintMode(View view, PorterDuff.Mode mode);

        void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16);

        void setClipBounds(View view, Rect rect);

        void setElevation(View view, float f16);

        void setFitsSystemWindows(View view, boolean z16);

        void setHasTransientState(View view, boolean z16);

        void setImportantForAccessibility(View view, int i3);

        void setLabelFor(View view, int i3);

        void setLayerPaint(View view, Paint paint);

        void setLayerType(View view, int i3, Paint paint);

        void setLayoutDirection(View view, int i3);

        void setNestedScrollingEnabled(View view, boolean z16);

        void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        void setOverScrollMode(View view, int i3);

        void setPaddingRelative(View view, int i3, int i16, int i17, int i18);

        void setPivotX(View view, float f16);

        void setPivotY(View view, float f16);

        void setRotation(View view, float f16);

        void setRotationX(View view, float f16);

        void setRotationY(View view, float f16);

        void setSaveFromParentEnabled(View view, boolean z16);

        void setScaleX(View view, float f16);

        void setScaleY(View view, float f16);

        void setScrollIndicators(View view, int i3);

        void setScrollIndicators(View view, int i3, int i16);

        void setTransitionName(View view, String str);

        void setTranslationX(View view, float f16);

        void setTranslationY(View view, float f16);

        void setTranslationZ(View view, float f16);

        void setX(View view, float f16);

        void setY(View view, float f16);

        boolean startNestedScroll(View view, int i3);

        void stopNestedScroll(View view);
    }

    ViewCompat() {
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        return IMPL.animate(view);
    }

    public static boolean canScrollHorizontally(View view, int i3) {
        return IMPL.canScrollHorizontally(view, i3);
    }

    public static boolean canScrollVertically(View view, int i3) {
        return IMPL.canScrollVertically(view, i3);
    }

    public static int combineMeasuredStates(int i3, int i16) {
        return IMPL.combineMeasuredStates(i3, i16);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float f16, float f17, boolean z16) {
        return IMPL.dispatchNestedFling(view, f16, f17, z16);
    }

    public static boolean dispatchNestedPreFling(View view, float f16, float f17) {
        return IMPL.dispatchNestedPreFling(view, f16, f17);
    }

    public static boolean dispatchNestedPreScroll(View view, int i3, int i16, int[] iArr, int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view, i3, i16, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i3, int i16, int i17, int i18, int[] iArr) {
        return IMPL.dispatchNestedScroll(view, i3, i16, i17, i18, iArr);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    public static int getAccessibilityLiveRegion(View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }

    public static float getAlpha(View view) {
        return IMPL.getAlpha(view);
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return IMPL.getBackgroundTintList(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return IMPL.getBackgroundTintMode(view);
    }

    public static Rect getClipBounds(View view) {
        return IMPL.getClipBounds(view);
    }

    public static float getElevation(View view) {
        return IMPL.getElevation(view);
    }

    public static boolean getFitsSystemWindows(View view) {
        return IMPL.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    public static int getLabelFor(View view) {
        return IMPL.getLabelFor(view);
    }

    public static int getLayerType(View view) {
        return IMPL.getLayerType(view);
    }

    public static int getLayoutDirection(View view) {
        return IMPL.getLayoutDirection(view);
    }

    public static int getMeasuredHeightAndState(View view) {
        return IMPL.getMeasuredHeightAndState(view);
    }

    public static int getMeasuredState(View view) {
        return IMPL.getMeasuredState(view);
    }

    public static int getMeasuredWidthAndState(View view) {
        return IMPL.getMeasuredWidthAndState(view);
    }

    public static int getMinimumHeight(View view) {
        return IMPL.getMinimumHeight(view);
    }

    public static int getMinimumWidth(View view) {
        return IMPL.getMinimumWidth(view);
    }

    public static int getOverScrollMode(View view) {
        return IMPL.getOverScrollMode(view);
    }

    public static int getPaddingEnd(View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static int getPaddingStart(View view) {
        return IMPL.getPaddingStart(view);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return IMPL.getParentForAccessibility(view);
    }

    public static float getPivotX(View view) {
        return IMPL.getPivotX(view);
    }

    public static float getPivotY(View view) {
        return IMPL.getPivotY(view);
    }

    public static float getRotation(View view) {
        return IMPL.getRotation(view);
    }

    public static float getRotationX(View view) {
        return IMPL.getRotationX(view);
    }

    public static float getRotationY(View view) {
        return IMPL.getRotationY(view);
    }

    public static float getScaleX(View view) {
        return IMPL.getScaleX(view);
    }

    public static float getScaleY(View view) {
        return IMPL.getScaleY(view);
    }

    public static int getScrollIndicators(@NonNull View view) {
        return IMPL.getScrollIndicators(view);
    }

    public static String getTransitionName(View view) {
        return IMPL.getTransitionName(view);
    }

    public static float getTranslationX(View view) {
        return IMPL.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        return IMPL.getTranslationY(view);
    }

    public static float getTranslationZ(View view) {
        return IMPL.getTranslationZ(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    public static float getX(View view) {
        return IMPL.getX(view);
    }

    public static float getY(View view) {
        return IMPL.getY(view);
    }

    public static float getZ(View view) {
        return IMPL.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return IMPL.hasNestedScrollingParent(view);
    }

    public static boolean hasOnClickListeners(View view) {
        return IMPL.hasOnClickListeners(view);
    }

    public static boolean hasOverlappingRendering(View view) {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean hasTransientState(View view) {
        return IMPL.hasTransientState(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return IMPL.isAttachedToWindow(view);
    }

    public static boolean isLaidOut(View view) {
        return IMPL.isLaidOut(view);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }

    public static boolean isOpaque(View view) {
        return IMPL.isOpaque(view);
    }

    public static boolean isPaddingRelative(View view) {
        return IMPL.isPaddingRelative(view);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        IMPL.jumpDrawablesToCurrentState(view);
    }

    public static void offsetLeftAndRight(View view, int i3) {
        IMPL.offsetLeftAndRight(view, i3);
    }

    public static void offsetTopAndBottom(View view, int i3) {
        IMPL.offsetTopAndBottom(view, i3);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        return IMPL.performAccessibilityAction(view, i3, bundle);
    }

    public static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j3) {
        IMPL.postOnAnimationDelayed(view, runnable, j3);
    }

    public static void requestApplyInsets(View view) {
        IMPL.requestApplyInsets(view);
    }

    public static int resolveSizeAndState(int i3, int i16, int i17) {
        return IMPL.resolveSizeAndState(i3, i16, i17);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static void setAccessibilityLiveRegion(View view, int i3) {
        IMPL.setAccessibilityLiveRegion(view, i3);
    }

    public static void setActivated(View view, boolean z16) {
        IMPL.setActivated(view, z16);
    }

    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        IMPL.setAlpha(view, f16);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        IMPL.setBackgroundTintMode(view, mode);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z16);
    }

    public static void setClipBounds(View view, Rect rect) {
        IMPL.setClipBounds(view, rect);
    }

    public static void setElevation(View view, float f16) {
        IMPL.setElevation(view, f16);
    }

    public static void setFitsSystemWindows(View view, boolean z16) {
        IMPL.setFitsSystemWindows(view, z16);
    }

    public static void setHasTransientState(View view, boolean z16) {
        IMPL.setHasTransientState(view, z16);
    }

    public static void setImportantForAccessibility(View view, int i3) {
        IMPL.setImportantForAccessibility(view, i3);
    }

    public static void setLabelFor(View view, @IdRes int i3) {
        IMPL.setLabelFor(view, i3);
    }

    public static void setLayerPaint(View view, Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    public static void setLayerType(View view, int i3, Paint paint) {
        IMPL.setLayerType(view, i3, paint);
    }

    public static void setLayoutDirection(View view, int i3) {
        IMPL.setLayoutDirection(view, i3);
    }

    public static void setNestedScrollingEnabled(View view, boolean z16) {
        IMPL.setNestedScrollingEnabled(view, z16);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOverScrollMode(View view, int i3) {
        IMPL.setOverScrollMode(view, i3);
    }

    public static void setPaddingRelative(View view, int i3, int i16, int i17, int i18) {
        IMPL.setPaddingRelative(view, i3, i16, i17, i18);
    }

    public static void setPivotX(View view, float f16) {
        IMPL.setPivotX(view, f16);
    }

    public static void setPivotY(View view, float f16) {
        IMPL.setPivotY(view, f16);
    }

    public static void setRotation(View view, float f16) {
        IMPL.setRotation(view, f16);
    }

    public static void setRotationX(View view, float f16) {
        IMPL.setRotationX(view, f16);
    }

    public static void setRotationY(View view, float f16) {
        IMPL.setRotationY(view, f16);
    }

    public static void setSaveFromParentEnabled(View view, boolean z16) {
        IMPL.setSaveFromParentEnabled(view, z16);
    }

    public static void setScaleX(View view, float f16) {
        IMPL.setScaleX(view, f16);
    }

    public static void setScaleY(View view, float f16) {
        IMPL.setScaleY(view, f16);
    }

    public static void setScrollIndicators(@NonNull View view, int i3) {
        IMPL.setScrollIndicators(view, i3);
    }

    public static void setTransitionName(View view, String str) {
        IMPL.setTransitionName(view, str);
    }

    public static void setTranslationX(View view, float f16) {
        IMPL.setTranslationX(view, f16);
    }

    public static void setTranslationY(View view, float f16) {
        IMPL.setTranslationY(view, f16);
    }

    public static void setTranslationZ(View view, float f16) {
        IMPL.setTranslationZ(view, f16);
    }

    public static void setX(View view, float f16) {
        IMPL.setX(view, f16);
    }

    public static void setY(View view, float f16) {
        IMPL.setY(view, f16);
    }

    public static boolean startNestedScroll(View view, int i3) {
        return IMPL.startNestedScroll(view, i3);
    }

    public static void stopNestedScroll(View view) {
        IMPL.stopNestedScroll(view);
    }

    public static void postInvalidateOnAnimation(View view, int i3, int i16, int i17, int i18) {
        IMPL.postInvalidateOnAnimation(view, i3, i16, i17, i18);
    }

    public static void setScrollIndicators(@NonNull View view, int i3, int i16) {
        IMPL.setScrollIndicators(view, i3, i16);
    }
}
