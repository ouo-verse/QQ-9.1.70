package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDDoubleScrollView extends LinearLayout implements IDoubleScroll, View.OnLayoutChangeListener, HippyViewBase {
    private static final int IS_CHILD_EVENT = 1;
    private static final int IS_PARENT_EVENT = 2;
    private static final int IS_UNKONW_EVENT = 0;
    private static final String TAG = "HippyQBDoubleScrollView";
    private int deadLine;

    /* renamed from: dx, reason: collision with root package name */
    private int f114171dx;

    /* renamed from: dy, reason: collision with root package name */
    private int f114172dy;
    private FlingController flingController;
    private int isChildViewEvent;
    private boolean isHidden;
    private int lastX;
    private int lastY;
    private boolean mEnableDoubleScroll;
    private IDoubleScroll mNestDoubleScrollView;
    private OnScrollEvent mOnScrollEvent;
    private boolean oldHiddenState;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class OnScrollEvent extends HippyViewEvent {
        public OnScrollEvent(String str) {
            super(str);
        }
    }

    public HippyTKDDoubleScrollView(Context context) {
        super(context);
        this.mEnableDoubleScroll = true;
        this.lastX = 0;
        this.lastY = 0;
        this.f114171dx = 0;
        this.f114172dy = 0;
        this.isChildViewEvent = 0;
        this.isHidden = false;
        setOrientation(1);
        setOverScrollMode(2);
        FlingController flingController = new FlingController();
        this.flingController = flingController;
        flingController.setFlingListener(this);
    }

    private void computeHidden(int i3, int i16) {
        int nestViewScrollY = this.mNestDoubleScrollView.getNestViewScrollY();
        this.oldHiddenState = this.isHidden;
        int i17 = i3 + i16;
        int i18 = this.deadLine;
        if (i17 >= i18) {
            setHidden(true);
        } else if (nestViewScrollY + i16 < 0 && nestViewScrollY >= 0) {
            setHidden(false);
            this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
        } else if (i3 == i18 && nestViewScrollY > 0 && i16 < 0) {
            setHidden(true);
        }
        if (this.oldHiddenState != this.isHidden) {
            pageChanged();
        }
    }

    private OnScrollEvent getOnScrollEvent() {
        if (this.mOnScrollEvent == null) {
            this.mOnScrollEvent = new OnScrollEvent(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
        return this.mOnScrollEvent;
    }

    private void pageChanged() {
        this.f114172dy = 0;
        if (this.isHidden) {
            scrollTo(0, this.deadLine);
        } else {
            this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
        }
    }

    private void scrollByAuto(int i3) {
        if (this.mNestDoubleScrollView == null) {
            return;
        }
        if (getDeadLine() == 0) {
            setDeadLine(getChildAt(0).getHeight() - getHeight());
        }
        computeHidden(getScrollY(), i3);
        if (((this.mNestDoubleScrollView.getNestViewScrollY() + this.mNestDoubleScrollView.getLayoutHeight()) - this.deadLine) + getScrollY() + i3 >= this.mNestDoubleScrollView.getRealHeight()) {
            this.flingController.stop();
            if (this.mNestDoubleScrollView.getRealHeight() == 0) {
                return;
            }
            if (!isHidden()) {
                int realHeight = ((this.mNestDoubleScrollView.getRealHeight() + getHeight()) - this.mNestDoubleScrollView.getLayoutHeight()) - getHeight();
                if (realHeight <= 0) {
                    realHeight = this.deadLine;
                }
                scrollTo(0, realHeight);
                return;
            }
            int realHeight2 = this.mNestDoubleScrollView.getRealHeight() - this.mNestDoubleScrollView.getLayoutHeight();
            if (realHeight2 < 0) {
                realHeight2 = this.deadLine;
            }
            this.mNestDoubleScrollView.scrollNestViewTo(0, realHeight2);
            return;
        }
        if (this.isHidden) {
            if (this.mNestDoubleScrollView.getNestViewScrollY() + i3 >= 0) {
                this.mNestDoubleScrollView.scrollNestViewBy(0, i3);
                return;
            } else {
                this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
                return;
            }
        }
        if (getScrollY() + i3 >= 0) {
            scrollBy(0, i3);
            return;
        }
        scrollTo(0, 0);
        if (this.mNestDoubleScrollView.getNestViewScrollY() + i3 >= 0) {
            this.mNestDoubleScrollView.scrollNestViewBy(0, i3);
        } else {
            this.mNestDoubleScrollView.scrollNestViewTo(0, 0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        FlingController flingController = this.flingController;
        if (flingController.isFling) {
            scrollByAuto(-flingController.computeDistance());
            invalidate();
        }
    }

    public int getDeadLine() {
        return this.deadLine;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getLayoutHeight() {
        return getHeight();
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getNestViewScrollY() {
        return getScrollY();
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getRealHeight() {
        return getHeight();
    }

    public boolean isDoubleScrollEnable() {
        return this.mEnableDoubleScroll;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void notifyNestViewToFling(int i3, int i16) {
        scrollByAuto(i16);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnableDoubleScroll) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        return false;
                    }
                } else {
                    if (motionEvent.getPointerCount() > 1) {
                        int pointerId = motionEvent.getPointerId(0);
                        this.f114171dx = this.lastX - ((int) motionEvent.getX(pointerId));
                        this.f114172dy = this.lastY - ((int) motionEvent.getY(pointerId));
                        this.lastX = (int) motionEvent.getX(pointerId);
                        this.lastY = (int) motionEvent.getY(pointerId);
                    } else {
                        this.f114171dx = this.lastX - ((int) motionEvent.getX());
                        this.f114172dy = this.lastY - ((int) motionEvent.getY());
                        this.lastX = (int) motionEvent.getX();
                        this.lastY = (int) motionEvent.getY();
                    }
                    int i3 = this.isChildViewEvent;
                    if (i3 == 0) {
                        if (Math.abs(this.f114171dx) <= 2 && Math.abs(this.f114172dy) <= 2) {
                            return false;
                        }
                        if (Math.abs(this.f114171dx) / 2 <= Math.abs(this.f114172dy)) {
                            this.isChildViewEvent = 2;
                            return true;
                        }
                        this.isChildViewEvent = 1;
                        return false;
                    }
                    if (i3 == 1 || i3 == 0) {
                        return false;
                    }
                }
            } else {
                int i16 = this.isChildViewEvent;
                if (i16 == 1 || i16 == 0) {
                    return false;
                }
            }
            return true;
        }
        this.isChildViewEvent = 0;
        this.flingController.stop();
        this.lastX = (int) motionEvent.getX();
        this.lastY = (int) motionEvent.getY();
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29;
        if (view instanceof ViewGroup) {
            View childAt = ((ViewGroup) view).getChildAt(r2.getChildCount() - 1);
            if (childAt != null) {
                i29 = childAt.getBottom();
            } else {
                i29 = 0;
            }
            if (view.getHeight() < i29) {
                view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i29, 1073741824));
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + i29);
            }
        }
        setDeadLine(view.getHeight() - getHeight());
        if (getScrollY() != getDeadLine() && this.mNestDoubleScrollView.getNestViewScrollY() > 0) {
            scrollTo(0, getDeadLine());
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        int width;
        int height;
        super.onScrollChanged(i3, i16, i17, i18);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("top", 0.0d);
        hippyMap.pushDouble("bottom", 0.0d);
        hippyMap.pushDouble("left", 0.0d);
        hippyMap.pushDouble("right", 0.0d);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushDouble(HippyTKDListViewAdapter.X, PixelUtil.px2dp(getScrollX()));
        hippyMap2.pushDouble("y", PixelUtil.px2dp(getScrollY()));
        HippyMap hippyMap3 = new HippyMap();
        if (getChildCount() > 0) {
            width = getChildAt(0).getWidth();
        } else {
            width = getWidth();
        }
        hippyMap3.pushDouble("width", PixelUtil.px2dp(width));
        if (getChildCount() > 0) {
            height = getChildAt(0).getHeight();
        } else {
            height = getHeight();
        }
        hippyMap3.pushDouble("height", PixelUtil.px2dp(height));
        HippyMap hippyMap4 = new HippyMap();
        hippyMap4.pushDouble("width", PixelUtil.px2dp(getWidth()));
        hippyMap4.pushDouble("height", PixelUtil.px2dp(getHeight()));
        HippyMap hippyMap5 = new HippyMap();
        hippyMap5.pushMap(WaterFallComponentName.PROPERTY_CONTENT_INSET, hippyMap);
        hippyMap5.pushMap("contentOffset", hippyMap2);
        hippyMap5.pushMap("contentSize", hippyMap3);
        hippyMap5.pushMap("layoutMeasurement", hippyMap4);
        getOnScrollEvent().send(this, hippyMap5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 6) goto L46;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            return false;
                        }
                    } else {
                        this.flingController.stop();
                        return true;
                    }
                } else {
                    if (motionEvent.getPointerCount() > 1) {
                        int pointerId = motionEvent.getPointerId(0);
                        try {
                            this.flingController.setY((int) motionEvent.getY(pointerId));
                            i3 = pointerId;
                        } catch (IllegalArgumentException e16) {
                            Log.e(TAG, "onTouchEvent: motionEvent.getY(flag) " + e16.getMessage());
                        }
                        this.flingController.setY((int) motionEvent.getY(i3));
                        this.f114171dx = this.lastX - ((int) motionEvent.getX(i3));
                        this.f114172dy = this.lastY - ((int) motionEvent.getY(i3));
                        this.lastX = (int) motionEvent.getX(i3);
                        this.lastY = (int) motionEvent.getY(i3);
                    } else {
                        this.flingController.setY((int) motionEvent.getY());
                        this.f114171dx = this.lastX - ((int) motionEvent.getX());
                        this.f114172dy = this.lastY - ((int) motionEvent.getY());
                        this.lastX = (int) motionEvent.getX();
                        this.lastY = (int) motionEvent.getY();
                    }
                    if (this.isChildViewEvent == 0) {
                        if (Math.abs(this.f114171dx) / 2 <= Math.abs(this.f114172dy)) {
                            this.isChildViewEvent = 2;
                        } else {
                            this.isChildViewEvent = 1;
                        }
                    }
                    if (this.isChildViewEvent == 2) {
                        scrollByAuto(this.f114172dy);
                    }
                }
            }
            if (this.isChildViewEvent != 1) {
                this.flingController.startFling();
                if (this.mNestDoubleScrollView != null && (isHidden() || this.mNestDoubleScrollView.getNestViewScrollY() != 0)) {
                    invalidate();
                }
            }
            return true;
        }
        this.isChildViewEvent = 0;
        this.flingController.stop();
        this.lastX = (int) motionEvent.getX();
        this.lastY = (int) motionEvent.getY();
        return true;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void scrollNestViewBy(int i3, int i16) {
        scrollTo(i3, i16);
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void scrollNestViewTo(int i3, int i16) {
        scrollTo(i3, i16);
    }

    public void scrollToDeadLine() {
        scrollTo(0, this.deadLine);
        computeHidden(this.deadLine, 0);
    }

    public void setDeadLine(int i3) {
        this.deadLine = i3;
    }

    public void setDoubleScrollRespondView(IDoubleScroll iDoubleScroll, boolean z16) {
        if (iDoubleScroll != null) {
            if (z16) {
                this.mNestDoubleScrollView = iDoubleScroll;
                this.deadLine = 0;
                View childAt = getChildAt(0);
                if (childAt != null) {
                    childAt.addOnLayoutChangeListener(this);
                    return;
                }
                return;
            }
            if (iDoubleScroll == this.mNestDoubleScrollView) {
                this.mNestDoubleScrollView = null;
                this.deadLine = 0;
                View childAt2 = getChildAt(0);
                if (childAt2 != null) {
                    childAt2.removeOnLayoutChangeListener(this);
                }
            }
        }
    }

    public void setEnableDoubleScroll(boolean z16) {
        this.mEnableDoubleScroll = z16;
    }

    public void setHidden(boolean z16) {
        this.isHidden = z16;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
