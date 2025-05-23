package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.tencent.mapsdk.internal.by;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 2131953243;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;

    @Nullable
    private ColorStateList backgroundTint;

    @NonNull
    private final ArrayList<e> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;

    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private g shapeAppearanceModelDefault;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    ViewDragHelper viewDragHelper;

    @Nullable
    WeakReference<V> viewRef;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface SaveFlags {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface StableState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface State {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class StateSettlingTracker {

        /* renamed from: a, reason: collision with root package name */
        private int f33348a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f33349b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f33350c;

        StateSettlingTracker() {
            this.f33350c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.f33349b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
                    if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.c(stateSettlingTracker.f33348a);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.state == 2) {
                        bottomSheetBehavior.setStateInternal(stateSettlingTracker2.f33348a);
                    }
                }
            };
        }

        void c(int i3) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.f33348a = i3;
                if (!this.f33349b) {
                    ViewCompat.postOnAnimation(BottomSheetBehavior.this.viewRef.get(), this.f33350c);
                    this.f33349b = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                BottomSheetBehavior.this.materialShapeDrawable.Z(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ViewUtils.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f33354a;

        b(boolean z16) {
            this.f33354a = z16;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
        @Override // com.google.android.material.internal.ViewUtils.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.e eVar) {
            boolean z16;
            int i3;
            int i16;
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            BottomSheetBehavior.this.insetTop = insets.top;
            boolean i17 = ViewUtils.i(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = eVar.f33795d + BottomSheetBehavior.this.insetBottom;
            }
            if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                if (i17) {
                    i16 = eVar.f33794c;
                } else {
                    i16 = eVar.f33792a;
                }
                paddingLeft = i16 + insets.left;
            }
            if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                if (i17) {
                    i3 = eVar.f33792a;
                } else {
                    i3 = eVar.f33794c;
                }
                paddingRight = i3 + insets.right;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z17 = true;
            if (BottomSheetBehavior.this.marginLeftSystemWindowInsets) {
                int i18 = marginLayoutParams.leftMargin;
                int i19 = insets.left;
                if (i18 != i19) {
                    marginLayoutParams.leftMargin = i19;
                    z16 = true;
                    if (BottomSheetBehavior.this.marginRightSystemWindowInsets) {
                        int i26 = marginLayoutParams.rightMargin;
                        int i27 = insets.right;
                        if (i26 != i27) {
                            marginLayoutParams.rightMargin = i27;
                            z16 = true;
                        }
                    }
                    if (BottomSheetBehavior.this.marginTopSystemWindowInsets) {
                        int i28 = marginLayoutParams.topMargin;
                        int i29 = insets.top;
                        if (i28 != i29) {
                            marginLayoutParams.topMargin = i29;
                            if (z17) {
                                view.setLayoutParams(marginLayoutParams);
                            }
                            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                            if (this.f33354a) {
                                BottomSheetBehavior.this.gestureInsetBottom = insets2.bottom;
                            }
                            if (!BottomSheetBehavior.this.paddingBottomSystemWindowInsets || this.f33354a) {
                                BottomSheetBehavior.this.updatePeekHeight(false);
                            }
                            return windowInsetsCompat;
                        }
                    }
                    z17 = z16;
                    if (z17) {
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (this.f33354a) {
                    }
                    if (!BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                    }
                    BottomSheetBehavior.this.updatePeekHeight(false);
                    return windowInsetsCompat;
                }
            }
            z16 = false;
            if (BottomSheetBehavior.this.marginRightSystemWindowInsets) {
            }
            if (BottomSheetBehavior.this.marginTopSystemWindowInsets) {
            }
            z17 = z16;
            if (z17) {
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f33354a) {
            }
            if (!BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
            }
            BottomSheetBehavior.this.updatePeekHeight(false);
            return windowInsetsCompat;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c extends ViewDragHelper.Callback {

        /* renamed from: a, reason: collision with root package name */
        private long f33356a;

        c() {
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2) {
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i3, int i16) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i3, int i16) {
            int i17;
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                i17 = bottomSheetBehavior.parentHeight;
            } else {
                i17 = bottomSheetBehavior.collapsedOffset;
            }
            return MathUtils.clamp(i3, expandedOffset, i17);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i3) {
            if (i3 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i3, int i16, int i17, int i18) {
            BottomSheetBehavior.this.dispatchOnSlide(i16);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        
            if (r7.f33357b.shouldExpandOnUpwardDrag(r0, (r9 * 100.0f) / r10.parentHeight) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        
            if (r9 > r7.f33357b.halfExpandedOffset) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
        
            if (java.lang.Math.abs(r8.getTop() - r7.f33357b.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.f33357b.halfExpandedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c9, code lost:
        
            if (r7.f33357b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
        
            if (java.lang.Math.abs(r9 - r7.f33357b.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.f33357b.collapsedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0107, code lost:
        
            if (r7.f33357b.shouldSkipHalfExpandedStateWhenDragging() != false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0121, code lost:
        
            if (r7.f33357b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onViewReleased(@NonNull View view, float f16, float f17) {
            int i3 = 6;
            if (f17 < 0.0f) {
                if (!BottomSheetBehavior.this.fitToContents) {
                    int top = view.getTop();
                    long currentTimeMillis = System.currentTimeMillis() - this.f33356a;
                    if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable && bottomSheetBehavior.shouldHide(view, f17)) {
                    if ((Math.abs(f16) < Math.abs(f17) && f17 > 500.0f) || a(view)) {
                        i3 = 5;
                    } else {
                        if (!BottomSheetBehavior.this.fitToContents) {
                        }
                        i3 = 3;
                    }
                } else if (f17 != 0.0f && Math.abs(f16) <= Math.abs(f17)) {
                    if (!BottomSheetBehavior.this.fitToContents) {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                        }
                    }
                    i3 = 4;
                } else {
                    int top3 = view.getTop();
                    if (!BottomSheetBehavior.this.fitToContents) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i16 = bottomSheetBehavior2.halfExpandedOffset;
                        if (top3 < i16) {
                            if (top3 >= Math.abs(top3 - bottomSheetBehavior2.collapsedOffset)) {
                            }
                            i3 = 3;
                        } else {
                            if (Math.abs(top3 - i16) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                            }
                            i3 = 4;
                        }
                    }
                }
            }
            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
            bottomSheetBehavior3.startSettling(view, i3, bottomSheetBehavior3.shouldSkipSmoothAnimation());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i3) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i16 = bottomSheetBehavior.state;
            if (i16 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i16 == 3 && bottomSheetBehavior.activePointerId == i3) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f33356a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements AccessibilityViewCommand {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33358a;

        d(int i3) {
            this.f33358a = i3;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.setState(this.f33358a);
            return true;
        }
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new c();
    }

    private int addAccessibilityActionForState(V v3, @StringRes int i3, int i16) {
        return ViewCompat.addAccessibilityAction(v3, v3.getResources().getString(i3), createAccessibilityViewCommandForState(i16));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i3;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i3 = this.gestureInsetBottom) > 0) {
            return Math.max(this.peekHeight, i3 + this.peekHeightGestureInsetBuffer);
        }
        return this.peekHeight + this.insetBottom;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int i3) {
        return new d(i3);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = materialShapeDrawable;
        materialShapeDrawable.N(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.Y(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new a());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i3, int i16, int i17, int i18) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i16, i18);
        if (i17 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i17 = Math.min(size, i17);
            }
            return View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i17), 1073741824);
    }

    private int getTopOffsetForState(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 == 6) {
                        return this.halfExpandedOffset;
                    }
                    throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
                }
                return this.parentHeight;
            }
            return this.collapsedOffset;
        }
        return getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isLayouting(V v3) {
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v3)) {
            return true;
        }
        return false;
    }

    private void replaceAccessibilityActionForState(V v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i3) {
        ViewCompat.replaceAccessibilityAction(v3, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i3));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i3 = this.saveFlags;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.peekHeight = savedState.f33344e;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.fitToContents = savedState.f33345f;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = savedState.f33346h;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.skipCollapsed = savedState.f33347i;
        }
    }

    private void runAfterLayout(V v3, Runnable runnable) {
        if (isLayouting(v3)) {
            v3.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(@NonNull View view) {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.peekHeightAuto) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.paddingBottomSystemWindowInsets && !this.paddingLeftSystemWindowInsets && !this.paddingRightSystemWindowInsets && !this.marginLeftSystemWindowInsets && !this.marginRightSystemWindowInsets && !this.marginTopSystemWindowInsets && !z16) {
            return;
        }
        ViewUtils.b(view, new b(z16));
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null && (this.draggable || this.state == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettling(View view, int i3, boolean z16) {
        boolean z17;
        int topOffsetForState = getTopOffsetForState(i3);
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && (!z16 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), topOffsetForState) : viewDragHelper.settleCapturedViewAt(view.getLeft(), topOffsetForState))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            setStateInternal(2);
            updateDrawableForTargetState(i3);
            this.stateSettlingTracker.c(i3);
            return;
        }
        setStateInternal(i3);
    }

    private void updateAccessibilityActions() {
        V v3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v3, 524288);
        ViewCompat.removeAccessibilityAction(v3, 262144);
        ViewCompat.removeAccessibilityAction(v3, 1048576);
        int i3 = this.expandHalfwayActionId;
        if (i3 != -1) {
            ViewCompat.removeAccessibilityAction(v3, i3);
        }
        int i16 = 6;
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionId = addAccessibilityActionForState(v3, com.tencent.mobileqq.R.string.f170636zg1, 6);
        }
        if (this.hideable && this.state != 5) {
            replaceAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i17 = this.state;
        if (i17 != 3) {
            if (i17 != 4) {
                if (i17 == 6) {
                    replaceAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                    replaceAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
                    return;
                }
                return;
            }
            if (this.fitToContents) {
                i16 = 3;
            }
            replaceAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i16);
            return;
        }
        if (this.fitToContents) {
            i16 = 4;
        }
        replaceAccessibilityActionForState(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i16);
    }

    private void updateDrawableForTargetState(int i3) {
        boolean z16;
        ValueAnimator valueAnimator;
        float f16;
        if (i3 == 2) {
            return;
        }
        if (i3 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.isShapeExpanded != z16) {
            this.isShapeExpanded = z16;
            if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                if (z16) {
                    f16 = 0.0f;
                } else {
                    f16 = 1.0f;
                }
                this.interpolatorAnimator.setFloatValues(1.0f - f16, f16);
                this.interpolatorAnimator.start();
            }
        }
    }

    private void updateImportantForAccessibility(boolean z16) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z16) {
            if (this.importantForAccessibilityMap == null) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = coordinatorLayout.getChildAt(i3);
            if (childAt != this.viewRef.get()) {
                if (z16) {
                    this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.updateImportantForAccessibilityOnSiblings) {
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                    ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                }
            }
        }
        if (!z16) {
            this.importantForAccessibilityMap = null;
        } else if (this.updateImportantForAccessibilityOnSiblings) {
            this.viewRef.get().sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z16) {
        V v3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (v3 = this.viewRef.get()) != null) {
                if (z16) {
                    setState(4);
                } else {
                    v3.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(@NonNull e eVar) {
        if (!this.callbacks.contains(eVar)) {
            this.callbacks.add(eVar);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int i3) {
        float f16;
        float f17;
        V v3 = this.viewRef.get();
        if (v3 != null && !this.callbacks.isEmpty()) {
            int i16 = this.collapsedOffset;
            if (i3 <= i16 && i16 != getExpandedOffset()) {
                int i17 = this.collapsedOffset;
                f16 = i17 - i3;
                f17 = i17 - getExpandedOffset();
            } else {
                int i18 = this.collapsedOffset;
                f16 = i18 - i3;
                f17 = this.parentHeight - i18;
            }
            float f18 = f16 / f17;
            for (int i19 = 0; i19 < this.callbacks.size(); i19++) {
                this.callbacks.get(i19).onSlide(v3, f18);
            }
        }
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i3));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public int getExpandedOffset() {
        int i3;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i16 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i3 = 0;
        } else {
            i3 = this.insetTop;
        }
        return Math.max(i16, i3);
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @VisibleForTesting
    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z16;
        View view;
        ViewDragHelper viewDragHelper;
        if (v3.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.touchingScrollingChild = false;
                    this.activePointerId = -1;
                    if (this.ignoreEvents) {
                        this.ignoreEvents = false;
                        return false;
                    }
                }
            } else {
                int x16 = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x16, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v3, x16, this.initialY)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.ignoreEvents = z16;
            }
            if (!this.ignoreEvents && (viewDragHelper = this.viewDragHelper) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.getTouchSlop()) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        boolean z16;
        float f16;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v3)) {
            v3.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.c8i);
            setWindowInsetsListener(v3);
            this.viewRef = new WeakReference<>(v3);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                ViewCompat.setBackground(v3, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                float f17 = this.elevation;
                if (f17 == -1.0f) {
                    f17 = ViewCompat.getElevation(v3);
                }
                materialShapeDrawable2.X(f17);
                if (this.state == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isShapeExpanded = z16;
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                if (z16) {
                    f16 = 0.0f;
                } else {
                    f16 = 1.0f;
                }
                materialShapeDrawable3.Z(f16);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v3, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v3) == 0) {
                ViewCompat.setImportantForAccessibility(v3, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v3.getTop();
        coordinatorLayout.onLayoutChild(v3, i3);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v3.getHeight();
        this.childHeight = height;
        int i16 = this.parentHeight;
        int i17 = i16 - height;
        int i18 = this.insetTop;
        if (i17 < i18) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i16;
            } else {
                this.childHeight = i16 - i18;
            }
        }
        this.fitToContentsOffset = Math.max(0, i16 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i19 = this.state;
        if (i19 == 3) {
            ViewCompat.offsetTopAndBottom(v3, getExpandedOffset());
        } else if (i19 == 6) {
            ViewCompat.offsetTopAndBottom(v3, this.halfExpandedOffset);
        } else if (this.hideable && i19 == 5) {
            ViewCompat.offsetTopAndBottom(v3, this.parentHeight);
        } else if (i19 == 4) {
            ViewCompat.offsetTopAndBottom(v3, this.collapsedOffset);
        } else if (i19 == 1 || i19 == 2) {
            ViewCompat.offsetTopAndBottom(v3, top - v3.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v3));
        for (int i26 = 0; i26 < this.callbacks.size(); i26++) {
            this.callbacks.get(i26).onLayout(v3);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3, int i16, int i17, int i18) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(getChildMeasureSpec(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i17, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i18, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, float f16, float f17) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        if (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v3, view, f16, f17)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        View view2;
        if (i17 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (isNestedScrollingCheckEnabled() && view != view2) {
            return;
        }
        int top = v3.getTop();
        int i18 = top - i16;
        if (i16 > 0) {
            if (i18 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                ViewCompat.offsetTopAndBottom(v3, -expandedOffset);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i16;
                ViewCompat.offsetTopAndBottom(v3, -i16);
                setStateInternal(1);
            }
        } else if (i16 < 0 && !view.canScrollVertically(-1)) {
            int i19 = this.collapsedOffset;
            if (i18 > i19 && !this.hideable) {
                int i26 = top - i19;
                iArr[1] = i26;
                ViewCompat.offsetTopAndBottom(v3, -i26);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i16;
                ViewCompat.offsetTopAndBottom(v3, -i16);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v3.getTop());
        this.lastNestedScrollDy = i16;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i3 = savedState.f33343d;
        if (i3 != 1 && i3 != 2) {
            this.state = i3;
            this.lastStableState = i3;
        } else {
            this.state = 4;
            this.lastStableState = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i3, int i16) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i3 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.getTop() <= r2.halfExpandedOffset) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3) {
        WeakReference<View> weakReference;
        int i16 = 3;
        if (v3.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        if (isNestedScrollingCheckEnabled() && ((weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get() || !this.nestedScrolled)) {
            return;
        }
        if (this.lastNestedScrollDy > 0) {
            if (!this.fitToContents) {
            }
            startSettling(v3, i16, false);
            this.nestedScrolled = false;
        }
        if (this.hideable && shouldHide(v3, getYVelocity())) {
            i16 = 5;
        } else if (this.lastNestedScrollDy == 0) {
            int top = v3.getTop();
            if (!this.fitToContents) {
                int i17 = this.halfExpandedOffset;
                if (top < i17) {
                    if (top >= Math.abs(top - this.collapsedOffset)) {
                    }
                }
            }
        } else {
            if (!this.fitToContents) {
                int top2 = v3.getTop();
            }
            i16 = 4;
        }
        startSettling(v3, i16, false);
        this.nestedScrolled = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(v3, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull e eVar) {
        this.callbacks.remove(eVar);
    }

    @Deprecated
    public void setBottomSheetCallback(e eVar) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (eVar != null) {
            this.callbacks.add(eVar);
        }
    }

    public void setDraggable(boolean z16) {
        this.draggable = z16;
    }

    public void setExpandedOffset(int i3) {
        if (i3 >= 0) {
            this.expandedOffset = i3;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z16) {
        int i3;
        if (this.fitToContents == z16) {
            return;
        }
        this.fitToContents = z16;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        if (this.fitToContents && this.state == 6) {
            i3 = 3;
        } else {
            i3 = this.state;
        }
        setStateInternal(i3);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z16) {
        this.gestureInsetBottomIgnored = z16;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f16) {
        if (f16 > 0.0f && f16 < 1.0f) {
            this.halfExpandedRatio = f16;
            if (this.viewRef != null) {
                calculateHalfExpandedOffset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean z16) {
        if (this.hideable != z16) {
            this.hideable = z16;
            if (!z16 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean z16) {
        this.hideable = z16;
    }

    public void setMaxHeight(@Px int i3) {
        this.maxHeight = i3;
    }

    public void setMaxWidth(@Px int i3) {
        this.maxWidth = i3;
    }

    public void setPeekHeight(int i3) {
        setPeekHeight(i3, false);
    }

    public void setSaveFlags(int i3) {
        this.saveFlags = i3;
    }

    public void setSkipCollapsed(boolean z16) {
        this.skipCollapsed = z16;
    }

    public void setState(int i3) {
        String str;
        final int i16;
        if (i3 != 1 && i3 != 2) {
            if (!this.hideable && i3 == 5) {
                Log.w(TAG, "Cannot set state: " + i3);
                return;
            }
            if (i3 == 6 && this.fitToContents && getTopOffsetForState(i3) <= this.fitToContentsOffset) {
                i16 = 3;
            } else {
                i16 = i3;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                final V v3 = this.viewRef.get();
                runAfterLayout(v3, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BottomSheetBehavior.this.startSettling(v3, i16, false);
                    }
                });
                return;
            } else {
                setStateInternal(i3);
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("STATE_");
        if (i3 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb5.append(str);
        sb5.append(" should not be set externally.");
        throw new IllegalArgumentException(sb5.toString());
    }

    void setStateInternal(int i3) {
        V v3;
        if (this.state == i3) {
            return;
        }
        this.state = i3;
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.hideable && i3 == 5)) {
            this.lastStableState = i3;
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            updateImportantForAccessibility(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i3);
        for (int i16 = 0; i16 < this.callbacks.size(); i16++) {
            this.callbacks.get(i16).onStateChanged(v3, i3);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z16) {
        this.updateImportantForAccessibilityOnSiblings = z16;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long j3, @FloatRange(from = 0.0d, to = 100.0d) float f16) {
        return false;
    }

    boolean shouldHide(@NonNull View view, float f16) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((view.getTop() + (f16 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public final void setPeekHeight(int i3, boolean z16) {
        boolean z17 = true;
        if (i3 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z17 = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != i3) {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, i3);
            }
            z17 = false;
        }
        if (z17) {
            updatePeekHeight(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        final int f33343d;

        /* renamed from: e, reason: collision with root package name */
        int f33344e;

        /* renamed from: f, reason: collision with root package name */
        boolean f33345f;

        /* renamed from: h, reason: collision with root package name */
        boolean f33346h;

        /* renamed from: i, reason: collision with root package name */
        boolean f33347i;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.f33343d = parcel.readInt();
            this.f33344e = parcel.readInt();
            this.f33345f = parcel.readInt() == 1;
            this.f33346h = parcel.readInt() == 1;
            this.f33347i = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f33343d);
            parcel.writeInt(this.f33344e);
            parcel.writeInt(this.f33345f ? 1 : 0);
            parcel.writeInt(this.f33346h ? 1 : 0);
            parcel.writeInt(this.f33347i ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f33343d = bottomSheetBehavior.state;
            this.f33344e = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.f33345f = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.f33346h = bottomSheetBehavior.hideable;
            this.f33347i = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new c();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.cuj);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f443983p0);
        int i16 = w0.a.f444031t0;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.backgroundTint = g1.c.a(context, obtainStyledAttributes, i16);
        }
        if (obtainStyledAttributes.hasValue(w0.a.K0)) {
            this.shapeAppearanceModelDefault = g.e(context, attributeSet, com.tencent.mobileqq.R.attr.a2w, DEF_STYLE_RES).m();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(w0.a.f444019s0, -1.0f);
        int i17 = w0.a.f443995q0;
        if (obtainStyledAttributes.hasValue(i17)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i17, -1));
        }
        int i18 = w0.a.f444007r0;
        if (obtainStyledAttributes.hasValue(i18)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i18, -1));
        }
        int i19 = w0.a.f444101z0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i19);
        if (peekValue != null && (i3 = peekValue.data) == -1) {
            setPeekHeight(i3);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i19, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(w0.a.f444089y0, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(w0.a.C0, false));
        setFitToContents(obtainStyledAttributes.getBoolean(w0.a.f444066w0, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(w0.a.B0, false));
        setDraggable(obtainStyledAttributes.getBoolean(w0.a.f444043u0, true));
        setSaveFlags(obtainStyledAttributes.getInt(w0.a.A0, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(w0.a.f444077x0, 0.5f));
        int i26 = w0.a.f444055v0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i26);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i26, 0));
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.G0, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.H0, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.I0, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.J0, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.D0, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.E0, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(w0.a.F0, false);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class e {
        public abstract void onSlide(@NonNull View view, float f16);

        public abstract void onStateChanged(@NonNull View view, int i3);

        void onLayout(@NonNull View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
    }
}
