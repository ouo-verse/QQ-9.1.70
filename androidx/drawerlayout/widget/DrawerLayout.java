package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;

    @Nullable
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    private static final int[] THEME_ATTRS = {R.attr.colorPrimaryDark};
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};

    /* compiled from: P */
    /* loaded from: classes.dex */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View findVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
                if (findVisibleDrawer != null) {
                    CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(findVisibleDrawer));
                    if (drawerTitle != null) {
                        text.add(drawerTitle);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!DrawerLayout.CAN_HIDE_DESCENDANTS && !DrawerLayout.includeChildForAccessibility(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.includeChildForAccessibility(view)) {
                accessibilityNodeInfoCompat.setParent(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f16);

        void onDrawerStateChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.peekDrawer();
            }
        };

        ViewDragCallback(int i3) {
            this.mAbsGravity = i3;
        }

        private void closeOtherDrawer() {
            int i3 = 3;
            if (this.mAbsGravity == 3) {
                i3 = 5;
            }
            View findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(i3);
            if (findDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(findDrawerWithGravity);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i3, int i16) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i3, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i3, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i3, int i16) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.isDrawerView(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i3, int i16) {
            View findDrawerWithGravity;
            if ((i3 & 1) == 1) {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (findDrawerWithGravity != null && DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) == 0) {
                this.mDragger.captureChildView(findDrawerWithGravity, i16);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int i3) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i3, int i16) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i3) {
            ((LayoutParams) view.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i3) {
            DrawerLayout.this.updateDrawerState(i3, this.mDragger.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i3, int i16, int i17, int i18) {
            float width;
            int i19;
            int width2 = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                width = i3 + width2;
            } else {
                width = DrawerLayout.this.getWidth() - i3;
            }
            float f16 = width / width2;
            DrawerLayout.this.setDrawerViewOffset(view, f16);
            if (f16 == 0.0f) {
                i19 = 4;
            } else {
                i19 = 0;
            }
            view.setVisibility(i19);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f16, float f17) {
            int i3;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                if (f16 <= 0.0f && (f16 != 0.0f || drawerViewOffset <= 0.5f)) {
                    i3 = -width;
                } else {
                    i3 = 0;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f16 < 0.0f || (f16 == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                i3 = width2;
            }
            this.mDragger.settleCapturedViewAt(i3, view.getTop());
            DrawerLayout.this.invalidate();
        }

        void peekDrawer() {
            boolean z16;
            View findDrawerWithGravity;
            int width;
            int edgeSize = this.mDragger.getEdgeSize();
            int i3 = 0;
            if (this.mAbsGravity == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
                if (findDrawerWithGravity != null) {
                    i3 = -findDrawerWithGravity.getWidth();
                }
                width = i3 + edgeSize;
            } else {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
                width = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (findDrawerWithGravity != null) {
                if (((z16 && findDrawerWithGravity.getLeft() < width) || (!z16 && findDrawerWithGravity.getLeft() > width)) && DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) == 0) {
                    LayoutParams layoutParams = (LayoutParams) findDrawerWithGravity.getLayoutParams();
                    this.mDragger.smoothSlideViewTo(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
                    layoutParams.isPeeking = true;
                    DrawerLayout.this.invalidate();
                    closeOtherDrawer();
                    DrawerLayout.this.cancelChildViewTouch();
                }
            }
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.mDragger = viewDragHelper;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i3) {
            if (DrawerLayout.this.isDrawerView(view) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                return true;
            }
            return false;
        }
    }

    static {
        boolean z16 = true;
        int i3 = Build.VERSION.SDK_INT;
        CAN_HIDE_DESCENDANTS = true;
        SET_DRAWER_SHADOW_FROM_ELEVATION = true;
        if (i3 < 29) {
            z16 = false;
        }
        sEdgeSizeUsingSystemGestureInsets = z16;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            obtain.transform(this.mChildInvertedMatrix);
        }
        return obtain;
    }

    static String gravityToString(int i3) {
        if ((i3 & 3) == 3) {
            return "LEFT";
        }
        if ((i3 & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i3);
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((LayoutParams) getChildAt(i3).getLayoutParams()).isPeeking) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() != null) {
            return true;
        }
        return false;
    }

    static boolean includeChildForAccessibility(View view) {
        if (ViewCompat.getImportantForAccessibility(view) != 4 && ViewCompat.getImportantForAccessibility(view) != 2) {
            return true;
        }
        return false;
    }

    private boolean isInBoundsOfChild(float f16, float f17, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f16, (int) f17);
    }

    private void mirror(Drawable drawable, int i3) {
        if (drawable != null && DrawableCompat.isAutoMirrored(drawable)) {
            DrawableCompat.setLayoutDirection(drawable, i3);
        }
    }

    private Drawable resolveLeftShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        if (isDrawerOpen(view) && getDrawerLockMode(view) != 2) {
            ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, this.mActionDismiss);
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z16) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((!z16 && !isDrawerView(childAt)) || (z16 && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            }
        }
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z16 = false;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (isDrawerView(childAt)) {
                if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i3, i16);
                    z16 = true;
                }
            } else {
                this.mNonDrawerViews.add(childAt);
            }
        }
        if (!z16) {
            int size = this.mNonDrawerViews.size();
            for (int i18 = 0; i18 < size; i18++) {
                View view = this.mNonDrawerViews.get(i18);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i3, i16);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (findOpenDrawer() == null && !isDrawerView(view)) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 4);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(view, this.mChildAccessibilityDelegate);
        }
    }

    void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    boolean checkDrawerViewAbsoluteGravity(View view, int i3) {
        if ((getDrawerViewAbsoluteGravity(view) & i3) == i3) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(8388611);
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            f16 = Math.max(f16, ((LayoutParams) getChildAt(i3).getLayoutParams()).onScreen);
        }
        this.mScrimOpacity = f16;
        boolean continueSettling = this.mLeftDragger.continueSettling(true);
        boolean continueSettling2 = this.mRightDragger.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.mScrimOpacity > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                for (int i3 = childCount - 1; i3 >= 0; i3--) {
                    View childAt = getChildAt(i3);
                    if (isInBoundsOfChild(x16, y16, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    void dispatchOnDrawerClosed(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.openState & 1) == 1) {
            layoutParams.openState = 0;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerClosed(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            updateChildAccessibilityAction(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    void dispatchOnDrawerOpened(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.openState & 1) == 0) {
            layoutParams.openState = 1;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerOpened(view);
                }
            }
            updateChildrenImportantForAccessibility(view, true);
            updateChildAccessibilityAction(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void dispatchOnDrawerSlide(View view, float f16) {
        List<DrawerListener> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerSlide(view, f16);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        int height = getHeight();
        boolean isContentView = isContentView(view);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        if (isContentView) {
            int childCount = getChildCount();
            int i16 = 0;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (childAt != view && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i16) {
                            i16 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i16, 0, width, getHeight());
            i3 = i16;
        }
        boolean drawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(save);
        float f16 = this.mScrimOpacity;
        if (f16 > 0.0f && isContentView) {
            this.mScrimPaint.setColor((this.mScrimColor & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f16)) << 24));
            canvas.drawRect(i3, 0.0f, width, getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.mLeftDragger.getEdgeSize(), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.mRightDragger.getEdgeSize(), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    View findDrawerWithGravity(int i3) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((((LayoutParams) childAt.getLayoutParams()).openState & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i3) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i3 == 3) {
            int i16 = this.mLockModeLeft;
            if (i16 != 3) {
                return i16;
            }
            int i17 = layoutDirection == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i17 != 3) {
                return i17;
            }
            return 0;
        }
        if (i3 == 5) {
            int i18 = this.mLockModeRight;
            if (i18 != 3) {
                return i18;
            }
            int i19 = layoutDirection == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (i19 != 3) {
                return i19;
            }
            return 0;
        }
        if (i3 == 8388611) {
            int i26 = this.mLockModeStart;
            if (i26 != 3) {
                return i26;
            }
            int i27 = layoutDirection == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if (i27 != 3) {
                return i27;
            }
            return 0;
        }
        if (i3 != 8388613) {
            return 0;
        }
        int i28 = this.mLockModeEnd;
        if (i28 != 3) {
            return i28;
        }
        int i29 = layoutDirection == 0 ? this.mLockModeRight : this.mLockModeLeft;
        if (i29 != 3) {
            return i29;
        }
        return 0;
    }

    @Nullable
    public CharSequence getDrawerTitle(int i3) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    int getDrawerViewAbsoluteGravity(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).onScreen;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View view) {
        if (((LayoutParams) view.getLayoutParams()).gravity == 0) {
            return true;
        }
        return false;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (isDrawerView(view)) {
            return (((LayoutParams) view.getLayoutParams()).openState & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean isDrawerView(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        if ((absoluteGravity & 3) != 0 || (absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (isDrawerView(view)) {
            return ((LayoutParams) view.getLayoutParams()).onScreen > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(8388611);
    }

    void moveDrawerToOffset(View view, float f16) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = view.getWidth();
        int i3 = ((int) (width * f16)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i3 = -i3;
        }
        view.offsetLeftAndRight(i3);
        setDrawerViewOffset(view, f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            Object obj = this.mLastInsets;
            if (obj != null) {
                i3 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i3);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        boolean shouldInterceptTouchEvent = this.mLeftDragger.shouldInterceptTouchEvent(motionEvent) | this.mRightDragger.shouldInterceptTouchEvent(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.mLeftDragger.checkTouchSlop(3)) {
                        this.mLeftCallback.removeCallbacks();
                        this.mRightCallback.removeCallbacks();
                    }
                }
                z16 = false;
            }
            closeDrawers(true);
            this.mChildrenCanceledTouch = false;
            z16 = false;
        } else {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.mInitialMotionX = x16;
            this.mInitialMotionY = y16;
            if (this.mScrimOpacity > 0.0f && (findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x16, (int) y16)) != null && isContentView(findTopChildUnder)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mChildrenCanceledTouch = false;
        }
        if (shouldInterceptTouchEvent || z16 || hasPeekingDrawer() || this.mChildrenCanceledTouch) {
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && hasVisibleDrawer()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            View findVisibleDrawer = findVisibleDrawer();
            if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
                closeDrawers();
            }
            if (findVisibleDrawer != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        WindowInsets rootWindowInsets;
        float f16;
        int i19;
        boolean z17;
        int i26;
        boolean z18 = true;
        this.mInLayout = true;
        int i27 = i17 - i3;
        int childCount = getChildCount();
        int i28 = 0;
        while (i28 < childCount) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    int i29 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i29, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i29, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f17 = measuredWidth;
                        i19 = (-measuredWidth) + ((int) (layoutParams.onScreen * f17));
                        f16 = (measuredWidth + i19) / f17;
                    } else {
                        float f18 = measuredWidth;
                        f16 = (i27 - r11) / f18;
                        i19 = i27 - ((int) (layoutParams.onScreen * f18));
                    }
                    if (f16 != layoutParams.onScreen) {
                        z17 = z18;
                    } else {
                        z17 = false;
                    }
                    int i36 = layoutParams.gravity & 112;
                    if (i36 != 16) {
                        if (i36 != 80) {
                            int i37 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            childAt.layout(i19, i37, measuredWidth + i19, measuredHeight + i37);
                        } else {
                            int i38 = i18 - i16;
                            childAt.layout(i19, (i38 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i19, i38 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    } else {
                        int i39 = i18 - i16;
                        int i46 = (i39 - measuredHeight) / 2;
                        int i47 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i46 < i47) {
                            i46 = i47;
                        } else {
                            int i48 = i46 + measuredHeight;
                            int i49 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i48 > i39 - i49) {
                                i46 = (i39 - i49) - measuredHeight;
                            }
                        }
                        childAt.layout(i19, i46, measuredWidth + i19, measuredHeight + i46);
                    }
                    if (z17) {
                        setDrawerViewOffset(childAt, f16);
                    }
                    if (layoutParams.onScreen > 0.0f) {
                        i26 = 0;
                    } else {
                        i26 = 4;
                    }
                    if (childAt.getVisibility() != i26) {
                        childAt.setVisibility(i26);
                    }
                }
            }
            i28++;
            z18 = true;
        }
        if (sEdgeSizeUsingSystemGestureInsets && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.mLeftDragger;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            ViewDragHelper viewDragHelper2 = this.mRightDragger;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.right));
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i3, int i16) {
        boolean z16;
        boolean z17;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z18 = false;
        boolean z19 = false;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z16) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                        if (absoluteGravity == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f16 = this.mDrawerElevation;
                        if (elevation != f16) {
                            ViewCompat.setElevation(childAt, f16);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    if (drawerViewAbsoluteGravity == 3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if ((z17 && z18) || (!z17 && z19)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this " + TAG + " already has a drawer view along that edge");
                    }
                    if (z17) {
                        z18 = true;
                    } else {
                        z19 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i3, this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i16, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i17 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i3 = savedState.openDrawerGravity;
        if (i3 != 0 && (findDrawerWithGravity = findDrawerWithGravity(i3)) != null) {
            openDrawer(findDrawerWithGravity);
        }
        int i16 = savedState.lockModeLeft;
        if (i16 != 3) {
            setDrawerLockMode(i16, 3);
        }
        int i17 = savedState.lockModeRight;
        if (i17 != 3) {
            setDrawerLockMode(i17, 5);
        }
        int i18 = savedState.lockModeStart;
        if (i18 != 3) {
            setDrawerLockMode(i18, 8388611);
        }
        int i19 = savedState.lockModeEnd;
        if (i19 != 3) {
            setDrawerLockMode(i19, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z16;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            int i16 = layoutParams.openState;
            boolean z17 = true;
            if (i16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i16 != 2) {
                z17 = false;
            }
            if (z16 || z17) {
                savedState.openDrawerGravity = layoutParams.gravity;
                break;
            }
        }
        savedState.lockModeLeft = this.mLockModeLeft;
        savedState.lockModeRight = this.mLockModeRight;
        savedState.lockModeStart = this.mLockModeStart;
        savedState.lockModeEnd = this.mLockModeEnd;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (getDrawerLockMode(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mLeftDragger.processTouchEvent(motionEvent);
        this.mRightDragger.processTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    closeDrawers(true);
                    this.mChildrenCanceledTouch = false;
                }
            } else {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                View findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x16, (int) y16);
                if (findTopChildUnder != null && isContentView(findTopChildUnder)) {
                    float f16 = x16 - this.mInitialMotionX;
                    float f17 = y16 - this.mInitialMotionY;
                    int touchSlop = this.mLeftDragger.getTouchSlop();
                    if ((f16 * f16) + (f17 * f17) < touchSlop * touchSlop) {
                        View findOpenDrawer = findOpenDrawer();
                        if (findOpenDrawer != null) {
                        }
                    }
                }
                z16 = true;
                closeDrawers(z16);
            }
        } else {
            float x17 = motionEvent.getX();
            float y17 = motionEvent.getY();
            this.mInitialMotionX = x17;
            this.mInitialMotionY = y17;
            this.mChildrenCanceledTouch = false;
        }
        return true;
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(8388611);
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        super.requestDisallowInterceptTouchEvent(z16);
        if (z16) {
            closeDrawers(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object obj, boolean z16) {
        boolean z17;
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z16;
        if (!z16 && getBackground() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        setWillNotDraw(z17);
        requestLayout();
    }

    public void setDrawerElevation(float f16) {
        this.mDrawerElevation = f16;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (isDrawerView(childAt)) {
                ViewCompat.setElevation(childAt, this.mDrawerElevation);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.mListener;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.mListener = drawerListener;
    }

    public void setDrawerLockMode(int i3) {
        setDrawerLockMode(i3, 3);
        setDrawerLockMode(i3, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i3) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((i3 & 8388611) == 8388611) {
            this.mShadowStart = drawable;
        } else if ((i3 & 8388613) == 8388613) {
            this.mShadowEnd = drawable;
        } else if ((i3 & 3) == 3) {
            this.mShadowLeft = drawable;
        } else if ((i3 & 5) != 5) {
            return;
        } else {
            this.mShadowRight = drawable;
        }
        resolveShadowDrawables();
        invalidate();
    }

    public void setDrawerTitle(int i3, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence;
        } else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence;
        }
    }

    void setDrawerViewOffset(View view, float f16) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f16 == layoutParams.onScreen) {
            return;
        }
        layoutParams.onScreen = f16;
        dispatchOnDrawerSlide(view, f16);
    }

    public void setScrimColor(@ColorInt int i3) {
        this.mScrimColor = i3;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i3) {
        this.mStatusBarBackground = new ColorDrawable(i3);
        invalidate();
    }

    void updateDrawerState(int i3, View view) {
        int i16;
        int viewDragState = this.mLeftDragger.getViewDragState();
        int viewDragState2 = this.mRightDragger.getViewDragState();
        if (viewDragState != 1 && viewDragState2 != 1) {
            i16 = 2;
            if (viewDragState != 2 && viewDragState2 != 2) {
                i16 = 0;
            }
        } else {
            i16 = 1;
        }
        if (view != null && i3 == 0) {
            float f16 = ((LayoutParams) view.getLayoutParams()).onScreen;
            if (f16 == 0.0f) {
                dispatchOnDrawerClosed(view);
            } else if (f16 == 1.0f) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i16 != this.mDrawerState) {
            this.mDrawerState = i16;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerStateChanged(i16);
                }
            }
        }
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.acz);
    }

    public void closeDrawer(@NonNull View view, boolean z16) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.onScreen = 0.0f;
                layoutParams.openState = 0;
            } else if (z16) {
                layoutParams.openState |= 4;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view, getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 0.0f);
                updateDrawerState(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    void closeDrawers(boolean z16) {
        boolean smoothSlideViewTo;
        int childCount = getChildCount();
        boolean z17 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z16 || layoutParams.isPeeking)) {
                int width = childAt.getWidth();
                if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                    smoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    smoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z17 |= smoothSlideViewTo;
                layoutParams.isPeeking = false;
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (z17) {
            invalidate();
        }
    }

    public void openDrawer(@NonNull View view, boolean z16) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.onScreen = 1.0f;
                layoutParams.openState = 1;
                updateChildrenImportantForAccessibility(view, true);
                updateChildAccessibilityAction(view);
            } else if (z16) {
                layoutParams.openState |= 2;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 1.0f);
                updateDrawerState(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AccessibilityViewCommand() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                if (DrawerLayout.this.isDrawerOpen(view) && DrawerLayout.this.getDrawerLockMode(view) != 2) {
                    DrawerLayout.this.closeDrawer(view);
                    return true;
                }
                return false;
            }
        };
        setDescendantFocusability(262144);
        float f16 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f16) + 0.5f);
        float f17 = f16 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.mLeftCallback = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.mRightCallback = viewDragCallback2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, viewDragCallback);
        this.mLeftDragger = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f17);
        viewDragCallback.setDragger(create);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, viewDragCallback2);
        this.mRightDragger = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f17);
        viewDragCallback2.setDragger(create2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    boolean z16;
                    DrawerLayout drawerLayout = (DrawerLayout) view;
                    if (windowInsets.getSystemWindowInsetTop() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    drawerLayout.setChildInsets(windowInsets, z16);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
            try {
                this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i3, 0);
        try {
            int i16 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;
            if (obtainStyledAttributes2.hasValue(i16)) {
                this.mDrawerElevation = obtainStyledAttributes2.getDimension(i16, 0.0f);
            } else {
                this.mDrawerElevation = getResources().getDimension(com.tencent.mobileqq.R.dimen.c7t);
            }
            obtainStyledAttributes2.recycle();
            this.mNonDrawerViews = new ArrayList<>();
        } catch (Throwable th5) {
            obtainStyledAttributes2.recycle();
            throw th5;
        }
    }

    public void setDrawerLockMode(int i3, int i16) {
        View findDrawerWithGravity;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i16, ViewCompat.getLayoutDirection(this));
        if (i16 == 3) {
            this.mLockModeLeft = i3;
        } else if (i16 == 5) {
            this.mLockModeRight = i3;
        } else if (i16 == 8388611) {
            this.mLockModeStart = i3;
        } else if (i16 == 8388613) {
            this.mLockModeEnd = i3;
        }
        if (i3 != 0) {
            (absoluteGravity == 3 ? this.mLeftDragger : this.mRightDragger).cancel();
        }
        if (i3 != 1) {
            if (i3 == 2 && (findDrawerWithGravity = findDrawerWithGravity(absoluteGravity)) != null) {
                openDrawer(findDrawerWithGravity);
                return;
            }
            return;
        }
        View findDrawerWithGravity2 = findDrawerWithGravity(absoluteGravity);
        if (findDrawerWithGravity2 != null) {
            closeDrawer(findDrawerWithGravity2);
        }
    }

    public void setStatusBarBackground(int i3) {
        this.mStatusBarBackground = i3 != 0 ? ContextCompat.getDrawable(getContext(), i3) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i3) {
        View findDrawerWithGravity = findDrawerWithGravity(i3);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.gravity = 0;
        }

        public LayoutParams(int i3, int i16, int i17) {
            this(i3, i16);
            this.gravity = i17;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    public boolean isDrawerOpen(int i3) {
        View findDrawerWithGravity = findDrawerWithGravity(i3);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
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
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }
    }

    public void setDrawerShadow(@DrawableRes int i3, int i16) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i3), i16);
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i3, @NonNull View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i3, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i3) {
        closeDrawer(i3, true);
    }

    public void closeDrawer(int i3, boolean z16) {
        View findDrawerWithGravity = findDrawerWithGravity(i3);
        if (findDrawerWithGravity != null) {
            closeDrawer(findDrawerWithGravity, z16);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i3));
    }

    public void openDrawer(int i3) {
        openDrawer(i3, true);
    }

    public void openDrawer(int i3, boolean z16) {
        View findDrawerWithGravity = findDrawerWithGravity(i3);
        if (findDrawerWithGravity != null) {
            openDrawer(findDrawerWithGravity, z16);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i3));
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i3) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view, float f16) {
        }
    }
}
