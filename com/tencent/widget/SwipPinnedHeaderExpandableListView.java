package com.tencent.widget;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.ExpandableListAdapter;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class SwipPinnedHeaderExpandableListView extends PinnedHeaderExpandableListView implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int ANIM_DURATION = 300;
    private static final int MSG_ANIM_HIDE = 1;
    private static final int MSG_ANIM_SHOW = 0;
    private static final int MSG_HIDE_POPMENU = 2;
    private static final byte SLIDE_DIR_DEFAULT = 0;
    private static final byte SLIDE_DIR_HORIZONTAL = 1;
    private static final byte SLIDE_DIR_VERTICAL = 2;
    public static final String TAG = "SwipListView";
    public static final int TAG_MENUS_WIDTH = -3;
    private View mCurItemView;
    private int mCurViewRVWidth;
    private int mCurX;
    private int mCurY;
    private boolean mDragEnable;
    private boolean mIsShowRV;
    private SwipListListener mListener;
    private int mMinFlingVelocity;
    private View mPreItemView;
    private RightIconMenuListener mRIMListenr;
    private Scroller mScroller;
    private Handler mScrollerHandler;
    private byte mSlideDir;
    private int mStartX;
    private int mStartY;
    private View mToAnimView;
    private final int scaledTouchSlop;
    private VelocityTracker velocityTracker;

    /* loaded from: classes27.dex */
    public interface RightIconMenuListener {
        void onRightIconMenuHide(View view);

        void onRightIconMenuShow(View view);
    }

    /* loaded from: classes27.dex */
    public static class SmoothInterpolator implements Interpolator {
        static IPatchRedirector $redirector_;

        public SmoothInterpolator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    /* loaded from: classes27.dex */
    public interface SwipListListener {
        void hideMenuPop();

        void interceptTouchEvent(boolean z16);

        boolean supportSwip(View view);

        void updateCurShowRightView(View view);
    }

    public SwipPinnedHeaderExpandableListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void addVelocityTracker(MotionEvent motionEvent) {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
    }

    private void cancelShowHideAnim() {
        this.mScrollerHandler.removeMessages(1);
        this.mScrollerHandler.removeMessages(0);
        this.mToAnimView = null;
    }

    private void endOfTouch() {
        int scrollVelocity = getScrollVelocity();
        int scrollX = this.mCurItemView.getScrollX();
        int i3 = this.mMinFlingVelocity;
        if (scrollVelocity > i3) {
            hiddeRight(this.mCurItemView);
            return;
        }
        if (scrollVelocity < (-i3)) {
            showRight(this.mCurItemView);
            return;
        }
        if (scrollVelocity > 0 && scrollX < this.mCurViewRVWidth * 0.7f) {
            hiddeRight(this.mCurItemView);
            return;
        }
        if (scrollVelocity < 0 && scrollX > this.mCurViewRVWidth * 0.3f) {
            showRight(this.mCurItemView);
            return;
        }
        if (this.mIsShowRV && scrollX < this.mCurViewRVWidth * 0.7f) {
            hiddeRight(this.mCurItemView);
        } else if (scrollX > this.mCurViewRVWidth * 0.3f) {
            showRight(this.mCurItemView);
        } else {
            hiddeRight(this.mCurItemView);
        }
    }

    private int getAnimDuration(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    private int getScrollVelocity() {
        this.velocityTracker.computeCurrentVelocity(1000);
        return (int) this.velocityTracker.getXVelocity();
    }

    private void hiddeRight(View view) {
        int i3;
        int i16;
        if (view != null) {
            i3 = view.getScrollX();
        } else {
            i3 = 0;
        }
        SwipListListener swipListListener = this.mListener;
        if (swipListListener != null) {
            swipListListener.updateCurShowRightView(null);
        }
        if (i3 != 0) {
            if (view.getTag(-3) instanceof Integer) {
                i16 = ((Integer) view.getTag(-3)).intValue();
            } else {
                i16 = 0;
            }
            View view2 = this.mToAnimView;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.mToAnimView = view;
            int i17 = -i3;
            this.mScroller.startScroll(i3, 0, i17, 0, getAnimDuration(i16, i17));
            this.mScrollerHandler.sendEmptyMessage(1);
            return;
        }
        RightIconMenuListener rightIconMenuListener = this.mRIMListenr;
        if (rightIconMenuListener != null) {
            rightIconMenuListener.onRightIconMenuHide(this.mToAnimView);
        }
    }

    private boolean isHitCurItemLeft(float f16) {
        if (f16 < getWidth() - this.mCurViewRVWidth) {
            return true;
        }
        return false;
    }

    private boolean isShowingRightView(View view) {
        if (view != null && view.getScrollX() >= this.scaledTouchSlop) {
            return true;
        }
        return false;
    }

    private boolean judgeScrollDirection(float f16, float f17) {
        int i3 = this.scaledTouchSlop;
        if (f16 <= i3 && f17 <= i3) {
            return false;
        }
        if (f16 > i3 && f17 / f16 < 0.6f) {
            this.mSlideDir = (byte) 1;
        } else {
            this.mSlideDir = (byte) 2;
        }
        return true;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void showRight(View view) {
        int i3;
        if (view != null) {
            int scrollX = view.getScrollX();
            SwipListListener swipListListener = this.mListener;
            if (swipListListener != null) {
                swipListListener.updateCurShowRightView(view);
            }
            i3 = scrollX;
        } else {
            i3 = 0;
        }
        int i16 = this.mCurViewRVWidth;
        if (i16 == 0 && view != null && (view.getTag(-3) instanceof Integer)) {
            i16 = ((Integer) view.getTag(-3)).intValue();
        }
        if (i3 != i16) {
            View view2 = this.mToAnimView;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.mToAnimView = view;
            int i17 = i16 - i3;
            this.mScroller.startScroll(i3, 0, i17, 0, getAnimDuration(i16, i17));
            this.mScrollerHandler.sendEmptyMessage(0);
            return;
        }
        RightIconMenuListener rightIconMenuListener = this.mRIMListenr;
        if (rightIconMenuListener != null) {
            rightIconMenuListener.onRightIconMenuShow(view);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                SwipListListener swipListListener = this.mListener;
                if (swipListListener != null) {
                    swipListListener.hideMenuPop();
                }
            } else {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                float currX = this.mScroller.getCurrX();
                View view = this.mToAnimView;
                if (view != null) {
                    view.scrollTo((int) currX, 0);
                    invalidate();
                }
                if (computeScrollOffset) {
                    this.mScrollerHandler.sendEmptyMessage(1);
                } else {
                    RightIconMenuListener rightIconMenuListener = this.mRIMListenr;
                    if (rightIconMenuListener != null) {
                        rightIconMenuListener.onRightIconMenuHide(this.mToAnimView);
                    }
                    this.mToAnimView = null;
                }
            }
        } else {
            boolean computeScrollOffset2 = this.mScroller.computeScrollOffset();
            float currX2 = this.mScroller.getCurrX();
            View view2 = this.mToAnimView;
            if (view2 != null) {
                view2.scrollTo((int) currX2, 0);
                invalidate();
            }
            if (computeScrollOffset2) {
                this.mScrollerHandler.sendEmptyMessage(0);
            } else {
                RightIconMenuListener rightIconMenuListener2 = this.mRIMListenr;
                if (rightIconMenuListener2 != null) {
                    rightIconMenuListener2.onRightIconMenuShow(this.mToAnimView);
                }
                this.mToAnimView = null;
            }
        }
        return true;
    }

    public void hideCurShowingRightView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!isShowingRightView(this.mCurItemView)) {
            int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
            int lastVisiblePosition = getLastVisiblePosition();
            while (true) {
                if (firstVisiblePosition > lastVisiblePosition) {
                    break;
                }
                View childAt = getChildAt(firstVisiblePosition);
                if (isShowingRightView(childAt)) {
                    this.mCurItemView = childAt;
                    break;
                }
                firstVisiblePosition++;
            }
        }
        hiddeRight(this.mCurItemView);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r2 != 3) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135 A[ADDED_TO_REGION] */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        SwipListListener swipListListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mDragEnable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.mCurViewRVWidth > 0) {
                        if (this.mSlideDir == 0) {
                            judgeScrollDirection(Math.abs(x16 - this.mStartX), Math.abs(y16 - this.mStartY));
                        }
                        if (this.mSlideDir == 1) {
                            if (x16 < this.mStartX) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                this.mScrollerHandler.sendEmptyMessage(2);
                            }
                            if (action != 0 && this.mIsShowRV) {
                                SwipListListener swipListListener2 = this.mListener;
                                if (swipListListener2 != null) {
                                    swipListListener2.interceptTouchEvent(true);
                                }
                                cancelShowHideAnim();
                            } else if ((action != 1 || action == 3) && (swipListListener = this.mListener) != null) {
                                swipListListener.interceptTouchEvent(false);
                            }
                            if (!z16) {
                                return super.onInterceptTouchEvent(motionEvent);
                            }
                            return z16;
                        }
                    }
                }
                z16 = false;
                if (action != 0) {
                }
                if (action != 1) {
                }
                swipListListener.interceptTouchEvent(false);
                if (!z16) {
                }
            }
            if (this.mIsShowRV) {
                hiddeRight(this.mPreItemView);
            }
            this.mStartX = -1;
            this.mCurX = -1;
            this.mStartY = -1;
            this.mCurY = -1;
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            swipListListener.interceptTouchEvent(false);
            if (!z16) {
            }
        } else {
            this.mSlideDir = (byte) 0;
            SwipListListener swipListListener3 = this.mListener;
            if (swipListListener3 != null) {
                swipListListener3.updateCurShowRightView(null);
            }
            this.mStartX = x16;
            this.mCurX = x16;
            this.mStartY = y16;
            this.mCurY = y16;
            View view = this.mCurItemView;
            this.mPreItemView = view;
            boolean isShowingRightView = isShowingRightView(view);
            this.mIsShowRV = isShowingRightView;
            if (!isShowingRightView) {
                int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
                int lastVisiblePosition = getLastVisiblePosition();
                while (true) {
                    if (lastVisiblePosition < firstVisiblePosition) {
                        break;
                    }
                    View childAt = getChildAt(lastVisiblePosition);
                    boolean isShowingRightView2 = isShowingRightView(childAt);
                    this.mIsShowRV = isShowingRightView2;
                    if (isShowingRightView2) {
                        this.mPreItemView = childAt;
                        break;
                    }
                    lastVisiblePosition--;
                }
            }
            this.mCurViewRVWidth = 0;
            this.mCurItemView = null;
            int i3 = this.mStartY;
            if (isOverscrollHeadVisiable()) {
                i3 = this.mStartY + getScrollY();
            }
            int pointToPosition = pointToPosition(this.mStartX, i3);
            if (pointToPosition >= 0) {
                View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                this.mCurItemView = childAt2;
                if (childAt2 != null && (childAt2.getTag(-3) instanceof Integer)) {
                    this.mCurViewRVWidth = ((Integer) this.mCurItemView.getTag(-3)).intValue();
                }
                if (this.mCurViewRVWidth > 0 && !supportSwip(this.mCurItemView)) {
                    this.mCurViewRVWidth = 0;
                }
            }
            if (this.mIsShowRV && (this.mCurItemView != this.mPreItemView || isHitCurItemLeft(x16))) {
                z16 = true;
                if (action != 0) {
                }
                if (action != 1) {
                }
                swipListListener.interceptTouchEvent(false);
                if (!z16) {
                }
            }
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            swipListListener.interceptTouchEvent(false);
            if (!z16) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if (r2 != 3) goto L45;
     */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View view;
        SwipListListener swipListListener;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mDragEnable) {
            return super.onTouchEvent(motionEvent);
        }
        addVelocityTracker(motionEvent);
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.mIsShowRV) {
                        if (this.mCurItemView == this.mPreItemView && !isHitCurItemLeft(x16)) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (this.mCurItemView == this.mPreItemView) {
                            if (this.mSlideDir != 0 || judgeScrollDirection(Math.abs(x16 - this.mStartX), Math.abs(y16 - this.mStartY))) {
                                if (this.mSlideDir == 1) {
                                    scrollItemView(x16, y16, this.mCurItemView, this.mCurViewRVWidth);
                                    z16 = true;
                                }
                            }
                        }
                        this.mCurX = x16;
                        this.mCurY = y16;
                    } else {
                        if (this.mCurViewRVWidth != 0) {
                            if (this.mSlideDir != 0 || judgeScrollDirection(Math.abs(x16 - this.mStartX), Math.abs(y16 - this.mStartY))) {
                                if (this.mSlideDir == 1) {
                                    scrollItemView(x16, y16, this.mCurItemView, this.mCurViewRVWidth);
                                    z16 = true;
                                    this.mCurX = x16;
                                    this.mCurY = y16;
                                }
                            }
                        }
                        z16 = false;
                        this.mCurX = x16;
                        this.mCurY = y16;
                    }
                }
                z16 = false;
            }
            if (this.mIsShowRV) {
                if (this.mCurItemView == this.mPreItemView && !isHitCurItemLeft(x16)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                View view2 = this.mCurItemView;
                if (view2 == this.mPreItemView) {
                    if (this.mSlideDir == 1) {
                        endOfTouch();
                        z16 = true;
                        recycleVelocityTracker();
                        this.mStartX = -1;
                        this.mCurX = -1;
                        this.mStartY = -1;
                        this.mCurY = -1;
                    } else {
                        hiddeRight(view2);
                    }
                }
                z16 = z17;
                recycleVelocityTracker();
                this.mStartX = -1;
                this.mCurX = -1;
                this.mStartY = -1;
                this.mCurY = -1;
            } else if (this.mCurViewRVWidth != 0 && this.mSlideDir == 1) {
                endOfTouch();
                z16 = true;
                recycleVelocityTracker();
                this.mStartX = -1;
                this.mCurX = -1;
                this.mStartY = -1;
                this.mCurY = -1;
            } else {
                z16 = false;
                recycleVelocityTracker();
                this.mStartX = -1;
                this.mCurX = -1;
                this.mStartY = -1;
                this.mCurY = -1;
            }
        } else {
            if (this.mIsShowRV && (this.mCurItemView != this.mPreItemView || isHitCurItemLeft(x16))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mIsShowRV && (view = this.mPreItemView) != this.mCurItemView) {
                hiddeRight(view);
            }
        }
        if (action == 0 && this.mIsShowRV) {
            SwipListListener swipListListener2 = this.mListener;
            if (swipListListener2 != null) {
                swipListListener2.interceptTouchEvent(true);
            }
        } else if ((action == 1 || action == 3) && (swipListListener = this.mListener) != null) {
            swipListListener.interceptTouchEvent(false);
        }
        if (!z16) {
            return super.onTouchEvent(motionEvent);
        }
        return z16;
    }

    public void resetState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.mPreItemView = null;
        this.mCurItemView = null;
        this.mStartX = -1;
        this.mCurX = -1;
        this.mStartY = -1;
        this.mCurY = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scrollItemView(int i3, int i16, View view, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), view, Integer.valueOf(i17));
            return;
        }
        int scrollX = view.getScrollX() - (i3 - this.mCurX);
        if (scrollX <= i17) {
            if (scrollX < 0) {
                i17 = 0;
            } else {
                i17 = scrollX;
            }
        }
        view.scrollTo(i17, 0);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView, com.tencent.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) expandableListAdapter);
            return;
        }
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof SwipListListener) {
            this.mListener = (SwipListListener) expandableListAdapter;
        }
    }

    public void setDragEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.mDragEnable = z16;
        if (!z16) {
            hideCurShowingRightView();
        }
    }

    public void setRightIconMenuListener(RightIconMenuListener rightIconMenuListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rightIconMenuListener);
        } else {
            this.mRIMListenr = rightIconMenuListener;
        }
    }

    public void setSwipListListener(SwipListListener swipListListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) swipListListener);
        } else {
            this.mListener = swipListListener;
        }
    }

    public boolean supportSwip(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view)).booleanValue();
        }
        SwipListListener swipListListener = this.mListener;
        if (swipListListener != null) {
            return swipListListener.supportSwip(view);
        }
        return true;
    }

    public SwipPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.expandableListViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SwipPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mDragEnable = false;
        this.mScroller = new Scroller(context, new SmoothInterpolator());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 4;
        this.mStartX = -1;
        this.mCurX = -1;
        this.mStartY = -1;
        this.mCurY = -1;
        this.mScrollerHandler = new Handler(Looper.getMainLooper(), this);
    }
}
