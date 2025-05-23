package com.tencent.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class ScrollView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    static final int ANIMATED_SCROLL_GAP = 250;
    public static boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    public static final int SCROLL_FLAG_DEFAULT = 0;
    public static final int SCROLL_FLAG_DISABLE_SCROLL_TOP = 1;
    private int mActivePointerId;
    private View mChildToScrollTo;
    private Drawable mContentBackgroundDrawable;
    int mCurScrollState;
    private boolean mEdgeEffectEnabled;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;

    @ViewDebug.ExportedProperty(category = TtmlNode.TAG_LAYOUT)
    private boolean mFillViewport;
    private Object mFlingStrictSpan;
    private Drawable mForeground;
    private boolean mIsBeingDragged;
    private boolean mIsLayoutDirty;
    boolean mLastIsFromCompute;
    private float mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private Drawable mOverScrollHeaderShadow;
    private int mOverScrollMode;
    protected int mOverflingDistance;
    protected int mOverscrollDistance;
    OnScrollChangeListenerCompat mScrollChangeCompatListener;
    public int mScrollFlag;
    OnScrollStateChangedListener mScrollListener;
    private Object mScrollStrictSpan;
    public OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollChangeListenerCompat {
        void onScrollChange(View view, int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollStateChangedListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChanged(ScrollView scrollView, int i3, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 61)) {
            redirector.redirect((short) 61);
        } else {
            DEBUG = false;
            SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
        }
    }

    public ScrollView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean canScroll() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() >= childAt.getHeight() + getPaddingTop() + getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private int clamp(int i3, int i16, int i17) {
        if (i16 < i17 && i3 >= 0) {
            if (i16 + i3 > i17) {
                return i17 - i16;
            }
            return i3;
        }
        return 0;
    }

    private void doScrollY(int i3) {
        if (i3 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        Object obj = this.mScrollStrictSpan;
        if (obj != null) {
            finishSpan(obj);
        }
        if (this.mScroller.isFinished()) {
            updateScrollState(0);
        } else {
            updateScrollState(2);
        }
    }

    @TargetApi(9)
    private Object enterCriticalSpan(String str) {
        if (DEBUG) {
            try {
                if (VersionUtils.isGingerBread()) {
                    return StrictMode.class.getMethod("enterCriticalSpan", String.class).invoke(null, str);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private View findFocusableViewInBounds(boolean z16, int i3, int i16) {
        boolean z17;
        boolean z18;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z19 = false;
        for (int i17 = 0; i17 < size; i17++) {
            View view2 = focusables.get(i17);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i16) {
                if (i3 < top && bottom < i16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (view == null) {
                    view = view2;
                    z19 = z17;
                } else {
                    if ((z16 && top < view.getTop()) || (!z16 && bottom > view.getBottom())) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z19) {
                        if (z17) {
                            if (!z18) {
                            }
                            view = view2;
                        }
                    } else if (z17) {
                        view = view2;
                        z19 = true;
                    } else {
                        if (!z18) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private View findFocusableViewInMyBounds(boolean z16, int i3, View view) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int i16 = i3 + verticalFadingEdgeLength;
        int height = (i3 + getHeight()) - verticalFadingEdgeLength;
        if (view != null && view.getTop() < height && view.getBottom() > i16) {
            return view;
        }
        return findFocusableViewInBounds(z16, i16, height);
    }

    @TargetApi(9)
    private Object finishSpan(Object obj) {
        if (DEBUG) {
            try {
                obj.getClass().getMethod("finish", new Class[0]).invoke(obj, new Object[0]);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    private float getVerticalScrollFactorWrap() {
        Object invokeMethodWithArgs = ReflectionUtil.invokeMethodWithArgs(this, "android.view.View", "offsetChildrenTopAndBottom", null, new Object[0]);
        if (invokeMethodWithArgs instanceof Float) {
            return ((Float) invokeMethodWithArgs).floatValue();
        }
        return 0.0f;
    }

    private boolean inChild(int i3, int i16) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i16 < childAt.getTop() - scrollY || i16 >= childAt.getBottom() - scrollY || i3 < childAt.getLeft() || i3 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        int i3 = (int) ((getResources().getDisplayMetrics().density * 0.0f) + 0.5f);
        this.mOverflingDistance = i3;
        this.mOverscrollDistance = i3;
        setOverScrollMode(2);
        this.mScroller.setFriction(0.005f);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private boolean isWithinDeltaOfScreen(View view, int i3, int i16) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.bottom + i3 >= getScrollY() && this.mTempRect.top - i3 <= getScrollY() + i16) {
            return true;
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mLastMotionY = motionEvent.getY(i3);
            this.mActivePointerId = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int reviseOverScrollByTouch(int i3, int i16) {
        int scrollY = getScrollY();
        if (getScrollY() > 0 && getScrollY() > i16) {
            scrollY = getScrollY() - i16;
        }
        if (i3 * scrollY < 0) {
            return i3;
        }
        return (((getHeight() - Math.abs(scrollY)) * i3) / getHeight()) / 2;
    }

    private boolean scrollAndFocus(int i3, int i16, int i17) {
        boolean z16;
        int i18;
        int height = getHeight();
        int scrollY = getScrollY();
        int i19 = height + scrollY;
        boolean z17 = false;
        if (i3 == 33) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z16, i16, i17);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i16 < scrollY || i17 > i19) {
            if (z16) {
                i18 = i16 - scrollY;
            } else {
                i18 = i17 - i19;
            }
            doScrollY(i18);
            z17 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i3);
        }
        return z17;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z16) {
        boolean z17;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (z16) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z17;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            if (getChildCount() <= 0) {
                super.addView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    public boolean arrowScroll(int i3) {
        int bottom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, i3)).booleanValue();
        }
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i3);
        } else {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom())) < maxScrollAmount) {
                maxScrollAmount = bottom;
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                int overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 && (overScrollMode != 1 || scrollRange <= 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (currY >= 0 && currY <= scrollRange) {
                    scrollTo(currX, currY);
                } else {
                    overScrollBy(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, this.mOverflingDistance, false);
                }
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                if (z16) {
                    EdgeEffect edgeEffect = this.mEdgeGlowTop;
                    if (edgeEffect != null && currY < 0 && scrollY >= 0) {
                        edgeEffect.onAbsorb((int) this.mScroller.getCurrVelocity());
                    } else if (edgeEffect != null && currY > scrollRange && scrollY <= scrollRange) {
                        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
            }
            awakenScrollBars();
            postInvalidate();
            return;
        }
        Object obj = this.mFlingStrictSpan;
        if (obj != null) {
            finishSpan(obj);
        }
        updateScrollState(0, true);
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this, (Object) rect)).intValue();
        }
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i17 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i17 -= verticalFadingEdgeLength;
        }
        int i18 = rect.bottom;
        if (i18 > i17 && rect.top > scrollY) {
            if (rect.height() > height) {
                i16 = rect.top - scrollY;
            } else {
                i16 = rect.bottom - i17;
            }
            return Math.min(i16 + 0, getChildAt(0).getBottom() - i17);
        }
        if (rect.top >= scrollY || i18 >= i17) {
            return 0;
        }
        if (rect.height() > height) {
            i3 = 0 - (i17 - rect.bottom);
        } else {
            i3 = 0 - (scrollY - rect.top);
        }
        return Math.max(i3, -getScrollY());
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        Drawable drawable = this.mContentBackgroundDrawable;
        if (drawable != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int width = getWidth();
            drawable.setBounds(0, 0, getWidth(), getHeight());
            if ((scrollX | scrollY) == 0) {
                drawable.draw(canvas);
            } else if (scrollY < 0) {
                canvas.translate(scrollX, 0.0f);
                drawable.draw(canvas);
                canvas.translate(-scrollX, 0.0f);
                Drawable drawable2 = this.mOverScrollHeaderShadow;
                if (drawable2 != null) {
                    int intrinsicHeight = drawable2.getIntrinsicHeight();
                    if (intrinsicHeight < (-scrollY)) {
                        drawable2.setBounds(new Rect(0, -intrinsicHeight, width, 0));
                    } else {
                        drawable2.setBounds(new Rect(0, scrollY, width, 0));
                    }
                    drawable2.draw(canvas);
                }
            } else {
                canvas.translate(scrollX, scrollY);
                drawable.draw(canvas);
                canvas.translate(-scrollX, -scrollY);
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollY = getScrollY();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), Math.min(0, scrollY));
                this.mEdgeGlowTop.setSize(width, getHeight());
                if (this.mEdgeGlowTop.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                int save2 = canvas.save();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((-width2) + getPaddingLeft(), Math.max(getScrollRange(), scrollY) + height);
                canvas.rotate(180.0f, width2, 0.0f);
                this.mEdgeGlowBottom.setSize(width2, height);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) keyEvent)).booleanValue();
        }
        this.mTempRect.setEmpty();
        int i3 = 130;
        if (!canScroll()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 20) {
                if (keyCode != 62) {
                    return false;
                }
                if (keyEvent.isShiftPressed()) {
                    i3 = 33;
                }
                pageScroll(i3);
                return false;
            }
            if (!keyEvent.isAltPressed()) {
                return arrowScroll(130);
            }
            return fullScroll(130);
        }
        if (!keyEvent.isAltPressed()) {
            return arrowScroll(33);
        }
        return fullScroll(33);
    }

    public void fling(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
            return;
        }
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - height), 0, height / 4);
            if (this.mFlingStrictSpan == null) {
                this.mFlingStrictSpan = enterCriticalSpan("ScrollView-fling");
            }
            invalidate();
        }
    }

    public boolean fullScroll(int i3) {
        boolean z16;
        int childCount;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, i3)).booleanValue();
        }
        if (i3 == 130) {
            z16 = true;
        } else {
            z16 = false;
        }
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z16 && (childCount = getChildCount()) > 0) {
            this.mTempRect.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i3, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    public int getMaxScrollAmount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return (int) ((getBottom() - getTop()) * 0.5f);
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.mOverScrollMode;
    }

    public OverScroller getOverScroller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (OverScroller) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return this.mScroller;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    public boolean isFillViewport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mFillViewport;
    }

    public boolean isScrollFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            return overScroller.isFinished();
        }
        return true;
    }

    public boolean isSmoothScrollingEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Object obj = this.mScrollStrictSpan;
        if (obj != null) {
            finishSpan(obj);
        }
        Object obj2 = this.mFlingStrictSpan;
        if (obj2 != null) {
            finishSpan(obj2);
        }
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorWrap = (int) (axisValue * getVerticalScrollFactorWrap());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - verticalScrollFactorWrap;
                if (i3 < 0) {
                    scrollRange = 0;
                } else if (i3 <= scrollRange) {
                    scrollRange = i3;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) accessibilityEvent);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getScrollRange() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        accessibilityEvent.setScrollable(z16);
        accessibilityEvent.setScrollX(getScrollX());
        accessibilityEvent.setScrollY(getScrollY());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (getScrollRange() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        accessibilityNodeInfo.setScrollable(z16);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.mActivePointerId;
                    if (i16 != -1) {
                        try {
                            f16 = motionEvent.getY(motionEvent.findPointerIndex(i16));
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            f16 = 0.0f;
                        }
                        if (((int) Math.abs(f16 - this.mLastMotionY)) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = f16;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            if (this.mScrollStrictSpan == null) {
                                this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
                            }
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                invalidate();
            }
        } else {
            float y16 = motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), (int) y16)) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y16;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                boolean z16 = !this.mScroller.isFinished();
                this.mIsBeingDragged = z16;
                if (z16 && this.mScrollStrictSpan == null) {
                    this.mScrollStrictSpan = enterCriticalSpan("ScrollView-scroll");
                }
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        scrollTo(getScrollX(), getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        if (this.mFillViewport && View.MeasureSpec.getMode(i16) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            super.scrollTo(i3, i16);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, i3, (Object) rect)).booleanValue();
        }
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View view = null;
        try {
            if (rect == null) {
                view = FocusFinder.getInstance().findNextFocus(this, null, i3);
            } else {
                view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (view == null || isOffScreen(view)) {
            return false;
        }
        return view.requestFocus(i3, rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        OnScrollChangeListenerCompat onScrollChangeListenerCompat = this.mScrollChangeCompatListener;
        if (onScrollChangeListenerCompat != null) {
            onScrollChangeListenerCompat.onScrollChange(this, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i18)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // android.view.View
    @TargetApi(8)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        float yVelocity;
        boolean z16;
        int i3;
        EdgeEffect edgeEffect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) motionEvent)).booleanValue();
        }
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                                if (findPointerIndex < motionEvent.getPointerCount() && -1 != findPointerIndex) {
                                    this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                } else if (QLog.isDevelopLevel()) {
                                    QLog.i(HippyScrollViewController.CLASS_NAME, 4, String.format("Pointer Index %d out of range!", Integer.valueOf(findPointerIndex)));
                                }
                            }
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            this.mLastMotionY = motionEvent.getY(action2);
                            this.mActivePointerId = motionEvent.getPointerId(action2);
                        }
                    } else if (this.mIsBeingDragged && getChildCount() > 0) {
                        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, this.mOverscrollDistance)) {
                            invalidate();
                        }
                        this.mActivePointerId = -1;
                        endDrag();
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex2 != -1) {
                        float y16 = motionEvent.getY(findPointerIndex2);
                        int i16 = (int) (this.mLastMotionY - y16);
                        if (!this.mIsBeingDragged && Math.abs(i16) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i16 = i16 > 0 ? i16 - this.mTouchSlop : i16 + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            this.mLastMotionY = y16;
                            int scrollX = getScrollX();
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            int overScrollMode = getOverScrollMode();
                            if (overScrollMode != 0 && (overScrollMode != 1 || scrollRange <= 0)) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (getScrollY() < 0 || getScrollY() > scrollRange) {
                                i16 = reviseOverScrollByTouch(i16, scrollRange);
                            }
                            int i17 = i16;
                            int scrollY2 = getScrollY() + i17;
                            if (scrollY2 >= 0 && scrollY2 <= scrollRange) {
                                scrollTo(0, scrollY2);
                                i3 = i17;
                            } else {
                                i3 = i17;
                                overScrollBy(0, i17, 0, getScrollY(), 0, scrollRange, 0, this.mOverscrollDistance, true);
                            }
                            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                            updateScrollState(1);
                            if (z16 && (edgeEffect = this.mEdgeGlowTop) != null) {
                                int i18 = i3;
                                int i19 = scrollY + i18;
                                if (i19 < 0) {
                                    edgeEffect.onPull(i18 / getHeight());
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                } else if (i19 > scrollRange) {
                                    this.mEdgeGlowBottom.onPull(i18 / getHeight());
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                }
                                EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
                                if (edgeEffect2 != null && (!edgeEffect2.isFinished() || !this.mEdgeGlowBottom.isFinished())) {
                                    invalidate();
                                }
                            }
                        }
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (VersionUtils.isrFroyo()) {
                    yVelocity = velocityTracker.getYVelocity(this.mActivePointerId);
                } else {
                    yVelocity = velocityTracker.getYVelocity();
                }
                int i26 = (int) yVelocity;
                if (getChildCount() > 0) {
                    if (Math.abs(i26) > this.mMinimumVelocity) {
                        fling(-i26);
                    } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        invalidate();
                    }
                }
                this.mActivePointerId = -1;
                endDrag();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z17 = !this.mScroller.isFinished();
            this.mIsBeingDragged = z17;
            if (z17 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                Object obj = this.mFlingStrictSpan;
                if (obj != null) {
                    finishSpan(obj);
                }
            }
            this.mLastMotionY = motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i29;
        boolean z27;
        boolean z28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        int i36 = this.mOverScrollMode;
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i36 != 0 && (i36 != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (i36 != 0 && (i36 != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i37 = i17 + i3;
        if (!z19) {
            i27 = 0;
        }
        int i38 = i18 + i16;
        if (!z26) {
            i28 = 0;
        }
        int i39 = -i27;
        int i46 = Integer.MAX_VALUE;
        if (i27 == Integer.MAX_VALUE) {
            i29 = Integer.MAX_VALUE;
        } else {
            i29 = i27 + i19;
        }
        int i47 = -i28;
        if (i28 != Integer.MAX_VALUE) {
            i46 = i28 + i26;
        }
        if (this.mScrollFlag == 1) {
            i47 = 0;
        }
        if (i37 > i29) {
            i37 = i29;
        } else if (i37 < i39) {
            i37 = i39;
        } else {
            z27 = false;
            if (i38 <= i46) {
                i38 = i46;
            } else if (i38 < i47) {
                i38 = i47;
            } else {
                z28 = false;
                onOverScrolled(i37, i38, z27, z28);
                if (z27 && !z28) {
                    return false;
                }
                return true;
            }
            z28 = true;
            onOverScrolled(i37, i38, z27, z28);
            if (z27) {
            }
            return true;
        }
        z27 = true;
        if (i38 <= i46) {
        }
        z28 = true;
        onOverScrolled(i37, i38, z27, z28);
        if (z27) {
        }
        return true;
    }

    public boolean pageScroll(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, i3)).booleanValue();
        }
        if (i3 == 130) {
            z16 = true;
        } else {
            z16 = false;
        }
        int height = getHeight();
        if (z16) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.mTempRect.top + height > childAt.getBottom()) {
                    this.mTempRect.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect = this.mTempRect;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.mTempRect;
        int i16 = rect2.top;
        int i17 = height + i16;
        rect2.bottom = i17;
        return scrollAndFocus(i3, i16, i17);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) view, (Object) view2);
            return;
        }
        if (!this.mIsLayoutDirty) {
            scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, this, view, rect, Boolean.valueOf(z16))).booleanValue();
        }
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (z16) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.mIsLayoutDirty = true;
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i3, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i16, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    public void setContentBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) drawable);
        } else if (drawable == null) {
            this.mContentBackgroundDrawable = null;
            this.mOverScrollHeaderShadow = null;
        } else {
            this.mContentBackgroundDrawable = drawable;
            this.mOverScrollHeaderShadow = getResources().getDrawable(com.tencent.mobileqq.R.drawable.csv);
        }
    }

    public void setEdgeEffectEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
            return;
        }
        if (this.mEdgeEffectEnabled != z16) {
            if (z16) {
                if (this.mOverScrollMode != 2 && this.mEdgeGlowTop == null) {
                    Context context = getContext();
                    this.mEdgeGlowTop = new EdgeEffect(context);
                    this.mEdgeGlowBottom = new EdgeEffect(context);
                }
            } else {
                this.mEdgeGlowTop = null;
                this.mEdgeGlowBottom = null;
            }
            this.mEdgeEffectEnabled = z16;
        }
    }

    public void setFillViewport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else if (z16 != this.mFillViewport) {
            this.mFillViewport = z16;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = this.mForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mForeground);
            }
            this.mForeground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setOnScrollChangeListenerCompat(OnScrollChangeListenerCompat onScrollChangeListenerCompat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) onScrollChangeListenerCompat);
        } else {
            this.mScrollChangeCompatListener = onScrollChangeListenerCompat;
        }
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) onScrollStateChangedListener);
        } else {
            this.mScrollListener = onScrollStateChangedListener;
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("Invalid overscroll mode " + i3);
        }
        if (i3 != 2) {
            if (this.mEdgeGlowTop == null && this.mEdgeEffectEnabled) {
                Context context = getContext();
                try {
                    this.mEdgeGlowTop = new EdgeEffect(context);
                    this.mEdgeGlowBottom = new EdgeEffect(context);
                } catch (Throwable unused) {
                }
            }
            this.mOverflingDistance = Integer.MAX_VALUE;
            this.mOverscrollDistance = Integer.MAX_VALUE;
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
        this.mOverScrollMode = i3;
    }

    public void setSmoothScrollingEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mSmoothScrollingEnabled = z16;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void smoothScrollBy(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i16 + scrollY, max)) - scrollY);
            invalidate();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                Object obj = this.mFlingStrictSpan;
                if (obj != null) {
                    finishSpan(obj);
                }
            }
            scrollBy(i3, i16);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            smoothScrollBy(i3 - getScrollX(), i16 - getScrollY());
        }
    }

    public void updateScrollState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
            updateScrollState(i3, false);
        } else {
            iPatchRedirector.redirect((short) 59, (Object) this, i3);
        }
    }

    public ScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void updateScrollState(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.mCurScrollState == i3 && this.mLastIsFromCompute == z16) {
            return;
        }
        this.mLastIsFromCompute = z16;
        this.mCurScrollState = i3;
        OnScrollStateChangedListener onScrollStateChangedListener = this.mScrollListener;
        if (onScrollStateChangedListener != null) {
            onScrollStateChangedListener.onScrollStateChanged(this, i3, z16);
        }
    }

    public ScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mEdgeEffectEnabled = false;
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollStrictSpan = null;
        this.mFlingStrictSpan = null;
        this.mScrollFlag = 0;
        this.mCurScrollState = 0;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i3, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        setEdgeEffectEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
        } else {
            if (getChildCount() <= 0) {
                super.addView(view, i3);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) layoutParams);
        } else {
            if (getChildCount() <= 0) {
                super.addView(view, layoutParams);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), layoutParams);
        } else {
            if (getChildCount() <= 0) {
                super.addView(view, i3, layoutParams);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
    }
}
