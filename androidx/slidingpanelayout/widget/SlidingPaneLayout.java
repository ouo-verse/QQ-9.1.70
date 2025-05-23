package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    /* loaded from: classes.dex */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i3);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    /* loaded from: classes.dex */
    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i3, int i16) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i3, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i3, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i3, int i16) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i3, int i16) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i16);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i3) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i3) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset == 0.0f) {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i3, int i16, int i17, int i18) {
            SlidingPaneLayout.this.onPanelDragged(i3);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f16, float f17) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f16 < 0.0f || (f16 == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f16 > 0.0f || (f16 == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i3) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    /* loaded from: classes.dex */
    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean isOpen;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean closePane(View view, int i3) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i3)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f16, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f16 > 0.0f && i3 != 0) {
            int i16 = (((int) ((((-16777216) & i3) >>> 24) * f16)) << 24) | (i3 & 16777215);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i16, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    private boolean openPane(View view, int i3) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i3)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f16) {
        boolean z16;
        int childCount;
        float f17;
        int i3;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (layoutParams.dimWhenOffset) {
            if (isLayoutRtlSupport) {
                i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            } else {
                i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            }
            if (i3 <= 0) {
                z16 = true;
                childCount = getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = getChildAt(i16);
                    if (childAt != this.mSlideableView) {
                        float f18 = 1.0f - this.mParallaxOffset;
                        int i17 = this.mParallaxBy;
                        this.mParallaxOffset = f16;
                        int i18 = ((int) (f18 * i17)) - ((int) ((1.0f - f16) * i17));
                        if (isLayoutRtlSupport) {
                            i18 = -i18;
                        }
                        childAt.offsetLeftAndRight(i18);
                        if (z16) {
                            float f19 = this.mParallaxOffset;
                            if (isLayoutRtlSupport) {
                                f17 = f19 - 1.0f;
                            } else {
                                f17 = 1.0f - f19;
                            }
                            dimChildView(childAt, f17, this.mCoveredFadeColor);
                        }
                    }
                }
            }
        }
        z16 = false;
        childCount = getChildCount();
        while (i16 < childCount) {
        }
    }

    private static boolean viewIsOpaque(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    protected boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        int i19;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i26 = i16 + scrollX;
                if (i26 >= childAt.getLeft() && i26 < childAt.getRight() && (i19 = i17 + scrollY) >= childAt.getTop() && i19 < childAt.getBottom() && canScroll(childAt, true, i3, i26 - childAt.getLeft(), i19 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z16) {
            if (isLayoutRtlSupport()) {
                i18 = i3;
            } else {
                i18 = -i3;
            }
            if (view.canScrollHorizontally(i18)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i3;
        int i16;
        super.draw(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i16 = view.getRight();
                i3 = intrinsicWidth + i16;
            } else {
                int left = view.getLeft();
                int i17 = left - intrinsicWidth;
                i3 = left;
                i16 = i17;
            }
            drawable.setBounds(i16, top, i3, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
    }

    boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            return false;
        }
        return true;
    }

    boolean isLayoutRtlSupport() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        if (this.mCanSlide && this.mSlideOffset != 1.0f) {
            return false;
        }
        return true;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mPostedRunnables.get(i3).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.mCanSlide && (!this.mIsUnableToDrag || actionMasked == 0)) {
            if (actionMasked != 3 && actionMasked != 1) {
                if (actionMasked != 0) {
                    if (actionMasked == 2) {
                        float x16 = motionEvent.getX();
                        float y16 = motionEvent.getY();
                        float abs = Math.abs(x16 - this.mInitialMotionX);
                        float abs2 = Math.abs(y16 - this.mInitialMotionY);
                        if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                            this.mDragHelper.cancel();
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                } else {
                    this.mIsUnableToDrag = false;
                    float x17 = motionEvent.getX();
                    float y17 = motionEvent.getY();
                    this.mInitialMotionX = x17;
                    this.mInitialMotionY = y17;
                    if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x17, (int) y17) && isDimmed(this.mSlideableView)) {
                        z16 = true;
                        if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent) && !z16) {
                            return false;
                        }
                    }
                }
                z16 = false;
                return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) ? true : true;
            }
            this.mDragHelper.cancel();
            return false;
        }
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int paddingLeft;
        int paddingRight;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z17;
        float f16;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i36 = i17 - i3;
        if (isLayoutRtlSupport) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            if (this.mCanSlide && this.mPreservedOpenState) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            this.mSlideOffset = f16;
        }
        int i37 = paddingLeft;
        for (int i38 = 0; i38 < childCount; i38++) {
            View childAt = getChildAt(i38);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i39 = i36 - paddingRight;
                    int min = (Math.min(paddingLeft, i39 - this.mOverhangSize) - i37) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = min;
                    if (isLayoutRtlSupport) {
                        i29 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        i29 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    }
                    if (i37 + i29 + min + (measuredWidth / 2) > i39) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    layoutParams.dimWhenOffset = z17;
                    int i46 = (int) (min * this.mSlideOffset);
                    i37 += i29 + i46;
                    this.mSlideOffset = i46 / min;
                    i19 = 0;
                } else if (this.mCanSlide && (i26 = this.mParallaxBy) != 0) {
                    i19 = (int) ((1.0f - this.mSlideOffset) * i26);
                    i37 = paddingLeft;
                } else {
                    i37 = paddingLeft;
                    i19 = 0;
                }
                if (isLayoutRtlSupport) {
                    i28 = (i36 - i37) + i19;
                    i27 = i28 - measuredWidth;
                } else {
                    i27 = i37 - i19;
                    i28 = i27 + measuredWidth;
                }
                childAt.layout(i27, paddingTop, i28, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i47 = 0; i47 < childCount; i47++) {
                    dimChildView(getChildAt(i47), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int paddingTop;
        int i17;
        int i18;
        boolean z16;
        int measuredWidth;
        int makeMeasureSpec;
        int i19;
        int i26;
        int makeMeasureSpec2;
        float f16;
        int i27;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i28;
        int makeMeasureSpec5;
        int i29;
        int measuredHeight;
        boolean z17;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (mode2 == 0) {
            if (isInEditMode()) {
                if (mode2 == 0) {
                    size2 = 300;
                    mode2 = Integer.MIN_VALUE;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
        boolean z18 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i17 = 0;
            } else {
                i17 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            paddingTop = i17;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i17 = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int i36 = 0;
        boolean z19 = false;
        int i37 = paddingLeft;
        float f17 = 0.0f;
        while (true) {
            i18 = 8;
            if (i36 >= childCount) {
                break;
            }
            View childAt = getChildAt(i36);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z18;
            } else {
                float f18 = layoutParams.weight;
                if (f18 > 0.0f) {
                    f17 += f18;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i38 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i39 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i39 == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i38, Integer.MIN_VALUE);
                    f16 = f17;
                    i27 = Integer.MIN_VALUE;
                } else {
                    f16 = f17;
                    i27 = Integer.MIN_VALUE;
                    if (i39 == -1) {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i38, 1073741824);
                    } else {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i39, 1073741824);
                        i28 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i28 != -2) {
                            i29 = View.MeasureSpec.makeMeasureSpec(paddingTop, i27);
                        } else {
                            if (i28 == -1) {
                                makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i28, 1073741824);
                            }
                            i29 = makeMeasureSpec5;
                        }
                        childAt.measure(makeMeasureSpec3, i29);
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (mode2 == i27 && measuredHeight > i17) {
                            i17 = Math.min(measuredHeight, paddingTop);
                        }
                        i37 -= measuredWidth2;
                        if (i37 >= 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        layoutParams.slideable = z17;
                        z19 |= z17;
                        if (z17) {
                            this.mSlideableView = childAt;
                        }
                        f17 = f16;
                    }
                }
                makeMeasureSpec3 = makeMeasureSpec4;
                i28 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i28 != -2) {
                }
                childAt.measure(makeMeasureSpec3, i29);
                int measuredWidth22 = childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i27) {
                    i17 = Math.min(measuredHeight, paddingTop);
                }
                i37 -= measuredWidth22;
                if (i37 >= 0) {
                }
                layoutParams.slideable = z17;
                z19 |= z17;
                if (z17) {
                }
                f17 = f16;
            }
            i36++;
            z18 = false;
        }
        if (z19 || f17 > 0.0f) {
            int i46 = paddingLeft - this.mOverhangSize;
            int i47 = 0;
            while (i47 < childCount) {
                View childAt2 = getChildAt(i47);
                if (childAt2.getVisibility() != i18) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i18) {
                        if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            measuredWidth = 0;
                        } else {
                            measuredWidth = childAt2.getMeasuredWidth();
                        }
                        if (z19 && childAt2 != this.mSlideableView) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth > i46 || layoutParams2.weight > 0.0f)) {
                                if (z16) {
                                    int i48 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i48 == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i26 = 1073741824;
                                    } else if (i48 == -1) {
                                        i26 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i26 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i48, 1073741824);
                                    }
                                } else {
                                    i26 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i46, i26), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.weight > 0.0f) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                int i49 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i49 == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (i49 == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i49, 1073741824);
                                }
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z19) {
                                int i56 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                i19 = i46;
                                int makeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(i56, 1073741824);
                                if (measuredWidth != i56) {
                                    childAt2.measure(makeMeasureSpec6, makeMeasureSpec);
                                }
                                i47++;
                                i46 = i19;
                                i18 = 8;
                            } else {
                                i19 = i46;
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((layoutParams2.weight * Math.max(0, i37)) / f17)), 1073741824), makeMeasureSpec);
                                i47++;
                                i46 = i19;
                                i18 = 8;
                            }
                        }
                    }
                }
                i19 = i46;
                i47++;
                i46 = i19;
                i18 = 8;
            }
        }
        setMeasuredDimension(size, i17 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z19;
        if (this.mDragHelper.getViewDragState() != 0 && !z19) {
            this.mDragHelper.abort();
        }
    }

    void onPanelDragged(int i3) {
        int paddingLeft;
        int i16;
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i3 = (getWidth() - i3) - width;
        }
        if (isLayoutRtlSupport) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i16 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i16 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }
        float f16 = (i3 - (paddingLeft + i16)) / this.mSlideRange;
        this.mSlideOffset = f16;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(f16);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z16;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
            z16 = isOpen();
        } else {
            z16 = this.mPreservedOpenState;
        }
        savedState.isOpen = z16;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float f16 = x16 - this.mInitialMotionX;
                float f17 = y16 - this.mInitialMotionY;
                int touchSlop = this.mDragHelper.getTouchSlop();
                if ((f16 * f16) + (f17 * f17) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x16, (int) y16)) {
                    closePane(this.mSlideableView, 0);
                }
            }
        } else {
            float x17 = motionEvent.getX();
            float y17 = motionEvent.getY();
            this.mInitialMotionX = x17;
            this.mInitialMotionY = y17;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        boolean z16;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            if (view == this.mSlideableView) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mPreservedOpenState = z16;
        }
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i3) {
        this.mCoveredFadeColor = i3;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i3) {
        this.mParallaxBy = i3;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i3) {
        setShadowDrawable(getResources().getDrawable(i3));
    }

    public void setShadowResourceLeft(int i3) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setShadowResourceRight(int i3) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setSliderFadeColor(@ColorInt int i3) {
        this.mSliderFadeColor = i3;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float f16, int i3) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f16 * this.mSlideRange)) + this.mSlideableView.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f16 * this.mSlideRange));
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    void updateObscuredViewsVisibility(View view) {
        int paddingLeft;
        int width;
        int i3;
        int i16;
        int i17;
        int i18;
        View childAt;
        int i19;
        boolean z16;
        int i26;
        int i27;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            width = getPaddingLeft();
        } else {
            width = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 != null && viewIsOpaque(view)) {
            i3 = view.getLeft();
            i16 = view.getRight();
            i17 = view.getTop();
            i18 = view.getBottom();
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        int childCount = getChildCount();
        int i28 = 0;
        while (i28 < childCount && (childAt = getChildAt(i28)) != view2) {
            if (childAt.getVisibility() == 8) {
                z16 = isLayoutRtlSupport;
            } else {
                if (isLayoutRtlSupport) {
                    i19 = width;
                } else {
                    i19 = paddingLeft;
                }
                int max = Math.max(i19, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                z16 = isLayoutRtlSupport;
                if (isLayoutRtlSupport) {
                    i26 = paddingLeft;
                } else {
                    i26 = width;
                }
                int min = Math.min(i26, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= i3 && max2 >= i17 && min <= i16 && min2 <= i18) {
                    i27 = 4;
                } else {
                    i27 = 0;
                }
                childAt.setVisibility(i27);
            }
            i28++;
            view2 = view;
            isLayoutRtlSupport = z16;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {R.attr.layout_weight};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f16) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = create;
        create.setMinVelocity(f16 * 400.0f);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    /* loaded from: classes.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f16) {
        }
    }
}
