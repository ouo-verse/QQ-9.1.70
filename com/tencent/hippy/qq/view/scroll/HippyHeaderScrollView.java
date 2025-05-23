package com.tencent.hippy.qq.view.scroll;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.scroll.HippyOnScrollHelper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyHeaderScrollView extends FrameLayout implements HippyViewBase, HippyScrollView {
    private static final int DIRECTION_DOWN = 2;
    private static final int DIRECTION_UP = 1;
    private boolean hasCompleteFirstBatch;
    private int initialContentOffset;
    private boolean isClickHead;
    private int mCurY;
    private HippyListView mCurrentListView;
    private String mCurrentListViewTag;
    private float mDeltaY;
    private int mDirection;
    private boolean mDisallowIntercept;
    private float mDownX;
    private float mDownY;
    private boolean mHasChecked;
    private boolean mHasSetChildAction;
    private boolean mHasUnsentScrollEvent;
    private int mHeaderHeight;
    private final HippyOnScrollHelper mHippyOnScrollHelper;
    private int mLastScrollChangeY;
    private long mLastScrollEventTimeStamp;
    private int mLastScrollerY;
    private float mLastY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mScrollEnabled;
    private boolean mScrollEventEnable;
    protected int mScrollEventThrottle;
    protected int mScrollMinOffset;
    private HippyHeaderScrollHelper mScrollable;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int maxY;
    private int minY;
    private OnScrollListener onScrollListener;
    private int sysVersion;
    public boolean verticalScrollFlag;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnScrollListener {
        void onScroll(int i3, int i16);
    }

    public HippyHeaderScrollView(Context context) {
        this(context, null);
    }

    private int calcDuration(int i3, int i16) {
        return i3 - i16;
    }

    private void checkIsClickHead(int i3, int i16, int i17) {
        boolean z16;
        if (i3 + i17 <= i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isClickHead = z16;
    }

    private void checkListView() {
        if (!TextUtils.isEmpty(this.mCurrentListViewTag) && !this.mHasChecked) {
            setCurrentListViewTag(this.mCurrentListViewTag);
            this.mHasChecked = true;
        }
    }

    private ViewGroup foundCurrentTagView(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this);
        while (!linkedList.isEmpty()) {
            ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    Object tag = childAt.getTag(R.id.x_z);
                    if (tag != null && tag.equals(str)) {
                        return (ViewGroup) childAt;
                    }
                    linkedList.addLast((ViewGroup) childAt);
                }
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private int getScrollerVelocity(int i3, int i16) {
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            return 0;
        }
        if (this.sysVersion >= 14) {
            return (int) scroller.getCurrVelocity();
        }
        return i3 / i16;
    }

    private void obtainVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void sendOnScrollEvent() {
        this.mHasUnsentScrollEvent = false;
        HippyScrollViewEventHelper.emitScrollEvent(this);
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void callSmoothScrollTo(final int i3, int i16, int i17) {
        if (i17 > 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getScrollY(), i16);
            ofInt.setDuration(i17);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.hippy.qq.view.scroll.HippyHeaderScrollView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HippyHeaderScrollView.this.scrollTo(i3, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
            return;
        }
        scrollTo(i3, i16);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (this.mDirection == 1) {
                if (isStickied()) {
                    int finalY = this.mScroller.getFinalY() - currY;
                    int calcDuration = calcDuration(this.mScroller.getDuration(), this.mScroller.timePassed());
                    this.mScrollable.smoothScrollBy(getScrollerVelocity(finalY, calcDuration), finalY, calcDuration);
                    this.mScroller.abortAnimation();
                    return;
                }
                scrollTo(0, currY);
                invalidate();
            } else {
                if (this.mScrollable.isTop() || this.isClickHead) {
                    scrollTo(0, getScrollY() + (currY - this.mLastScrollerY));
                    if (this.mCurY <= this.minY) {
                        this.mScroller.abortAnimation();
                        return;
                    }
                }
                invalidate();
            }
            this.mLastScrollerY = currY;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (!this.mScrollEnabled) {
            return false;
        }
        checkListView();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.mDownX);
        float abs2 = Math.abs(y16 - this.mDownY);
        obtainVelocityTracker(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            int i3 = 2;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        recycleVelocityTracker();
                    }
                } else if (!this.mDisallowIntercept) {
                    this.mDeltaY = this.mLastY - y16;
                    this.mLastY = y16;
                    int i16 = this.mTouchSlop;
                    if (abs > i16 && abs > 2.0f * abs2) {
                        this.verticalScrollFlag = false;
                    } else if (abs2 > i16 && abs2 > abs) {
                        this.verticalScrollFlag = true;
                    }
                    boolean isStickied = isStickied();
                    if (this.verticalScrollFlag && ((this.mDeltaY > 0.0f && !isStickied) || this.mScrollable.isTop() || this.isClickHead)) {
                        if (!this.mHasSetChildAction) {
                            this.mHasSetChildAction = true;
                        }
                        scrollBy(0, (int) (this.mDeltaY + 0.5d));
                        invalidate();
                    }
                }
            } else {
                if (this.verticalScrollFlag) {
                    if (this.mDeltaY < 0.0f || !isStickied()) {
                        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        float yVelocity = this.mVelocityTracker.getYVelocity();
                        if (yVelocity <= 0.0f) {
                            i3 = 1;
                        }
                        this.mDirection = i3;
                        this.mScroller.fling(0, getScrollY(), 0, -((int) yVelocity), 0, 0, -2147483647, Integer.MAX_VALUE);
                        this.mLastScrollerY = getScrollY();
                        invalidate();
                    }
                    int i17 = this.mTouchSlop;
                    if ((abs > i17 || abs2 > i17) && (this.isClickHead || (this.mCurY > 0 && !isStickied()))) {
                        int action2 = motionEvent.getAction();
                        motionEvent2.setAction(3);
                        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        motionEvent2.setAction(action2);
                        return dispatchTouchEvent;
                    }
                }
                recycleVelocityTracker();
            }
        } else {
            this.mHasSetChildAction = false;
            this.mDisallowIntercept = false;
            this.verticalScrollFlag = false;
            this.mDownX = x16;
            this.mDownY = y16;
            this.mLastY = y16;
            this.mDeltaY = 0.0f;
            checkIsClickHead((int) y16, this.mHeaderHeight, getScrollY());
            this.mScroller.abortAnimation();
        }
        if (this.verticalScrollFlag) {
            motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), this.mDownX, motionEvent.getY(), motionEvent.getMetaState());
        }
        super.dispatchTouchEvent(motionEvent2);
        return true;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public boolean isHeadTop() {
        if (this.mCurY == this.minY && this.mScrollable.isTop()) {
            return true;
        }
        return false;
    }

    public boolean isStickied() {
        if (this.mCurY == this.maxY) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        this.maxY = this.mHeaderHeight;
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16) + this.mHeaderHeight, 1073741824));
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (this.mHippyOnScrollHelper.onScrollChanged(i3, i16) && this.mScrollEventEnable) {
            int abs = Math.abs(i16 - this.mLastScrollChangeY);
            int i19 = this.mScrollMinOffset;
            if (i19 > 0 && abs >= i19) {
                this.mLastScrollChangeY = i16;
                sendOnScrollEvent();
                return;
            }
            if (i19 == 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {
                    this.mLastScrollEventTimeStamp = elapsedRealtime;
                    sendOnScrollEvent();
                    return;
                }
            }
            this.mHasUnsentScrollEvent = true;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        int scrollY = getScrollY();
        int i17 = i16 + scrollY;
        int i18 = this.maxY;
        if (i17 >= i18 || i17 <= (i18 = this.minY)) {
            i17 = i18;
        }
        super.scrollBy(i3, i17 - scrollY);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        int i17 = this.maxY;
        if (i16 >= i17) {
            i16 = i17;
        } else {
            int i18 = this.minY;
            if (i16 <= i18) {
                i16 = i18;
            }
        }
        this.mCurY = i16;
        OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(i16, i17);
        }
        super.scrollTo(i3, i16);
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void scrollToInitContentOffset() {
        if (this.hasCompleteFirstBatch) {
            return;
        }
        int i3 = this.initialContentOffset;
        if (i3 > 0) {
            scrollTo(0, i3);
        }
        this.hasCompleteFirstBatch = true;
    }

    public void setCurrentListViewTag(String str) {
        QLog.d("HippyHeaderScrollView", 1, "setCurrentListViewTag listViewTag:" + str);
        this.mHasChecked = false;
        this.mCurrentListViewTag = str;
        ViewGroup foundCurrentTagView = foundCurrentTagView(str);
        if (foundCurrentTagView instanceof HippyListView) {
            HippyListView hippyListView = (HippyListView) foundCurrentTagView;
            this.mCurrentListView = hippyListView;
            hippyListView.setOverScrollEnabled(false);
            setCurrentScrollableContainer(new HippyHeaderScrollHelper.ScrollableContainer() { // from class: com.tencent.hippy.qq.view.scroll.HippyHeaderScrollView.1
                @Override // com.tencent.hippy.qq.view.scroll.HippyHeaderScrollHelper.ScrollableContainer
                public View getScrollableView() {
                    return HippyHeaderScrollView.this.mCurrentListView;
                }
            });
        }
    }

    public void setCurrentScrollableContainer(HippyHeaderScrollHelper.ScrollableContainer scrollableContainer) {
        this.mScrollable.setCurrentScrollableContainer(scrollableContainer);
    }

    public void setHeaderHeight(int i3) {
        QLog.d("HippyHeaderScrollView", 2, "setHeaderHeight ", Integer.valueOf(i3));
        if (i3 > 0) {
            float f16 = i3;
            if (this.mHeaderHeight != ViewUtils.dpToPx(f16)) {
                int dpToPx = ViewUtils.dpToPx(f16);
                this.mHeaderHeight = dpToPx;
                this.maxY = dpToPx;
                requestLayout();
            }
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setInitialContentOffset(int i3) {
        this.initialContentOffset = i3;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEnabled(boolean z16) {
        this.mScrollEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEventEnable(boolean z16) {
        this.mScrollEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEventThrottle(int i3) {
        this.mScrollEventThrottle = i3;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollMinOffset(int i3) {
        this.mScrollMinOffset = (int) PixelUtil.dp2px(Math.max(5, i3));
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void showScrollIndicator(boolean z16) {
        setVerticalScrollBarEnabled(z16);
    }

    public HippyHeaderScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HippyHeaderScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.verticalScrollFlag = false;
        this.maxY = 0;
        this.minY = 0;
        this.mHasSetChildAction = false;
        this.mDeltaY = 0.0f;
        this.mScrollEnabled = true;
        this.mScrollEventEnable = true;
        this.mScrollMinOffset = 0;
        this.mLastScrollEventTimeStamp = -1L;
        this.mScrollEventThrottle = 10;
        this.initialContentOffset = 0;
        this.hasCompleteFirstBatch = false;
        this.mScroller = new Scroller(context);
        this.mScrollable = new HippyHeaderScrollHelper();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.sysVersion = Build.VERSION.SDK_INT;
        this.mHippyOnScrollHelper = new HippyOnScrollHelper();
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setContentOffset4Reuse(HippyMap hippyMap) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setFlingEnabled(boolean z16) {
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setMomentumScrollBeginEventEnable(boolean z16) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setMomentumScrollEndEventEnable(boolean z16) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setPagingEnabled(boolean z16) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollBeginDragEventEnable(boolean z16) {
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEndDragEventEnable(boolean z16) {
    }
}
