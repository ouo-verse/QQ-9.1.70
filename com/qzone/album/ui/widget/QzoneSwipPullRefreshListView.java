package com.qzone.album.ui.widget;

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
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.qzone.widget.QZonePullToRefreshListView;
import cooperation.qzone.QZoneTopGestureLayout;

/* loaded from: classes39.dex */
public class QzoneSwipPullRefreshListView extends QZonePullToRefreshListView implements Handler.Callback {
    private boolean U;
    private byte V;
    private View W;

    /* renamed from: a0, reason: collision with root package name */
    private View f44236a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f44237b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f44238c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f44239d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f44240e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f44241f0;

    /* renamed from: g0, reason: collision with root package name */
    private VelocityTracker f44242g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f44243h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f44244i0;

    /* renamed from: j0, reason: collision with root package name */
    private Scroller f44245j0;

    /* renamed from: k0, reason: collision with root package name */
    private Handler f44246k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f44247l0;

    /* renamed from: m0, reason: collision with root package name */
    private final int f44248m0;

    /* renamed from: n0, reason: collision with root package name */
    private c f44249n0;

    /* loaded from: classes39.dex */
    public interface a {
    }

    /* loaded from: classes39.dex */
    public interface c {
        void hideMenuPop();

        void interceptTouchEvent(boolean z16);

        void updateCurShowRightView(View view);
    }

    public QzoneSwipPullRefreshListView(Context context) {
        this(context, null);
    }

    private void addVelocityTracker(MotionEvent motionEvent) {
        if (this.f44242g0 == null) {
            this.f44242g0 = VelocityTracker.obtain();
        }
        this.f44242g0.addMovement(motionEvent);
    }

    private void cancelShowHideAnim() {
        this.f44246k0.removeMessages(1);
        this.f44246k0.removeMessages(0);
        this.f44247l0 = null;
    }

    private void endOfTouch() {
        int scrollVelocity = getScrollVelocity();
        int scrollX = this.f44236a0.getScrollX();
        int i3 = this.f44243h0;
        if (scrollVelocity > i3) {
            hiddeRight(this.f44236a0);
            return;
        }
        if (scrollVelocity < (-i3)) {
            showRight(this.f44236a0);
            return;
        }
        if (scrollVelocity > 0 && scrollX < this.f44244i0 * 0.7f) {
            hiddeRight(this.f44236a0);
            return;
        }
        if (scrollVelocity < 0 && scrollX > this.f44244i0 * 0.3f) {
            showRight(this.f44236a0);
            return;
        }
        if (this.f44241f0 && scrollX < this.f44244i0 * 0.7f) {
            hiddeRight(this.f44236a0);
        } else if (scrollX > this.f44244i0 * 0.3f) {
            showRight(this.f44236a0);
        } else {
            hiddeRight(this.f44236a0);
        }
    }

    private int getScrollVelocity() {
        this.f44242g0.computeCurrentVelocity(1000);
        return (int) this.f44242g0.getXVelocity();
    }

    private boolean isHitCurItemLeft(float f16) {
        return f16 < ((float) (getWidth() - this.f44244i0));
    }

    private boolean judgeScrollDirection(float f16, float f17) {
        int i3 = this.f44248m0;
        if (f16 <= i3 && f17 <= i3) {
            return false;
        }
        if (f16 > i3 && f17 / f16 < 0.6f) {
            this.V = (byte) 1;
        } else {
            this.V = (byte) 2;
        }
        return true;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.f44242g0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f44242g0 = null;
        }
    }

    private void scrollItemView(int i3, int i16, View view, int i17) {
        int scrollX = view.getScrollX() - (i3 - this.f44239d0);
        if (scrollX <= i17) {
            i17 = scrollX < 0 ? 0 : scrollX;
        }
        view.scrollTo(i17, 0);
    }

    private boolean v0(int i3) {
        int i16 = i3 - this.f44237b0;
        return ((float) Math.abs(i16)) > ((float) this.f44248m0) && i16 < 0;
    }

    private boolean w0(int i3) {
        View view = this.f44236a0;
        if (view != null && this.f44244i0 != 0) {
            int scrollX = view.getScrollX();
            if (scrollX > 0 && this.f44236a0.getScrollX() < this.f44244i0) {
                return true;
            }
            if (scrollX == 0 && this.V == 1 && v0(i3)) {
                return true;
            }
            if (!this.f44241f0 && this.f44236a0.getScrollX() == this.f44244i0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        int i16;
        int i17 = message.what;
        if (i17 == 0) {
            boolean computeScrollOffset = this.f44245j0.computeScrollOffset();
            float currX = this.f44245j0.getCurrX();
            View view = this.f44247l0;
            if (view != null && view.getScrollX() < (i3 = (int) currX)) {
                this.f44247l0.scrollTo(i3, 0);
                invalidate();
            }
            if (computeScrollOffset) {
                this.f44246k0.sendEmptyMessage(0);
                return true;
            }
            this.f44247l0 = null;
            return true;
        }
        if (i17 != 1) {
            if (i17 != 2) {
                return false;
            }
            c cVar = this.f44249n0;
            if (cVar == null) {
                return true;
            }
            cVar.hideMenuPop();
            return true;
        }
        boolean computeScrollOffset2 = this.f44245j0.computeScrollOffset();
        float currX2 = this.f44245j0.getCurrX();
        View view2 = this.f44247l0;
        if (view2 != null && view2.getScrollX() > (i16 = (int) currX2)) {
            this.f44247l0.scrollTo(i16, 0);
            invalidate();
        }
        if (computeScrollOffset2) {
            this.f44246k0.sendEmptyMessage(1);
            return true;
        }
        this.f44247l0 = null;
        return true;
    }

    public void hideCurShowingRightView() {
        if (!isShowingRightView(this.f44236a0)) {
            int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
            int lastVisiblePosition = getLastVisiblePosition();
            while (true) {
                if (firstVisiblePosition > lastVisiblePosition) {
                    break;
                }
                View childAt = getChildAt(firstVisiblePosition);
                if (isShowingRightView(childAt)) {
                    this.f44236a0 = childAt;
                    break;
                }
                firstVisiblePosition++;
            }
        }
        hiddeRight(this.f44236a0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0122 A[ADDED_TO_REGION] */
    @Override // com.qzone.widget.QZonePullToRefreshListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        c cVar;
        if (!this.U) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.V = (byte) 0;
            c cVar2 = this.f44249n0;
            if (cVar2 != null) {
                cVar2.updateCurShowRightView(null);
            }
            this.f44237b0 = x16;
            this.f44239d0 = x16;
            this.f44238c0 = y16;
            this.f44240e0 = y16;
            View view = this.f44236a0;
            this.W = view;
            boolean isShowingRightView = isShowingRightView(view);
            this.f44241f0 = isShowingRightView;
            if (!isShowingRightView) {
                int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
                int lastVisiblePosition = getLastVisiblePosition();
                while (true) {
                    if (lastVisiblePosition < firstVisiblePosition) {
                        break;
                    }
                    View childAt = getChildAt(lastVisiblePosition);
                    boolean isShowingRightView2 = isShowingRightView(childAt);
                    this.f44241f0 = isShowingRightView2;
                    if (isShowingRightView2) {
                        this.W = childAt;
                        break;
                    }
                    lastVisiblePosition--;
                }
            }
            this.f44244i0 = 0;
            this.f44236a0 = null;
            int i3 = this.f44238c0;
            if (isOverscrollHeadVisiable()) {
                i3 = this.f44238c0 + getScrollY();
            }
            int pointToPosition = pointToPosition(this.f44237b0, i3);
            if (pointToPosition >= 0) {
                View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                this.f44236a0 = childAt2;
                if (childAt2 != null && (childAt2.getTag(-3) instanceof Integer)) {
                    this.f44244i0 = ((Integer) this.f44236a0.getTag(-3)).intValue();
                }
            }
            if (this.f44241f0 && (this.f44236a0 != this.W || isHitCurItemLeft(x16))) {
                z16 = true;
                if (action != 0) {
                }
                if (action != 1) {
                }
                cVar.interceptTouchEvent(false);
                if (z16) {
                }
            }
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            cVar.interceptTouchEvent(false);
            if (z16) {
            }
        } else {
            if (action == 1) {
                if (this.f44241f0) {
                    hiddeRight(this.W);
                }
                this.f44237b0 = -1;
                this.f44239d0 = -1;
                this.f44238c0 = -1;
                this.f44240e0 = -1;
            } else if (action != 2) {
                if (action == 3) {
                    if (this.f44241f0) {
                        hiddeRight(this.W);
                    }
                    this.f44237b0 = -1;
                    this.f44239d0 = -1;
                    this.f44238c0 = -1;
                    this.f44240e0 = -1;
                }
            } else if (this.f44244i0 > 0) {
                if (this.V == 0) {
                    judgeScrollDirection(Math.abs(x16 - this.f44237b0), Math.abs(y16 - this.f44238c0));
                }
                if (this.V == 1) {
                    z16 = x16 < this.f44237b0;
                    if (z16) {
                        this.f44246k0.sendEmptyMessage(2);
                    }
                    if (action != 0 && this.f44241f0) {
                        c cVar3 = this.f44249n0;
                        if (cVar3 != null) {
                            cVar3.interceptTouchEvent(true);
                        }
                        cancelShowHideAnim();
                    } else if ((action != 1 || action == 3) && (cVar = this.f44249n0) != null) {
                        cVar.interceptTouchEvent(false);
                    }
                    return z16 ? super.onInterceptTouchEvent(motionEvent) : z16;
                }
            }
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            cVar.interceptTouchEvent(false);
            if (z16) {
            }
        }
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView, cooperation.qzone.api.FeedListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View view;
        c cVar;
        boolean z17;
        if (!this.U) {
            return super.onTouchEvent(motionEvent);
        }
        addVelocityTracker(motionEvent);
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action == 0) {
            z16 = this.f44241f0 && (this.f44236a0 != this.W || isHitCurItemLeft((float) x16));
            if (this.f44241f0 && (view = this.W) != this.f44236a0) {
                hiddeRight(view);
            }
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3) {
                    if (this.f44241f0) {
                        z16 = this.f44236a0 != this.W || isHitCurItemLeft((float) x16);
                        View view2 = this.f44236a0;
                        if (view2 == this.W) {
                            if (this.V == 1) {
                                endOfTouch();
                                z16 = true;
                            } else {
                                hiddeRight(view2);
                            }
                        }
                        recycleVelocityTracker();
                        this.f44237b0 = -1;
                        this.f44239d0 = -1;
                        this.f44238c0 = -1;
                        this.f44240e0 = -1;
                    } else if (this.f44244i0 != 0 && this.V == 1) {
                        endOfTouch();
                        z16 = true;
                        recycleVelocityTracker();
                        this.f44237b0 = -1;
                        this.f44239d0 = -1;
                        this.f44238c0 = -1;
                        this.f44240e0 = -1;
                    } else {
                        z16 = false;
                        recycleVelocityTracker();
                        this.f44237b0 = -1;
                        this.f44239d0 = -1;
                        this.f44238c0 = -1;
                        this.f44240e0 = -1;
                    }
                }
                z16 = false;
            } else {
                if (this.f44241f0) {
                    z17 = this.f44236a0 != this.W || isHitCurItemLeft((float) x16);
                    if (this.f44236a0 == this.W) {
                        if (this.V != 0 || judgeScrollDirection(Math.abs(x16 - this.f44237b0), Math.abs(y16 - this.f44238c0))) {
                            if (this.V == 1) {
                                QZoneTopGestureLayout.shouldInterceptEvent(false);
                                scrollItemView(x16, y16, this.f44236a0, this.f44244i0);
                                z17 = true;
                            }
                        }
                    }
                    this.f44239d0 = x16;
                    this.f44240e0 = y16;
                } else {
                    if (this.f44244i0 == 0) {
                        QZoneTopGestureLayout.shouldInterceptEvent(true);
                    } else {
                        if (this.V != 0 || judgeScrollDirection(Math.abs(x16 - this.f44237b0), Math.abs(y16 - this.f44238c0))) {
                            if (w0(x16)) {
                                QZoneTopGestureLayout.shouldInterceptEvent(false);
                                scrollItemView(x16, y16, this.f44236a0, this.f44244i0);
                                z17 = true;
                                this.f44239d0 = x16;
                                this.f44240e0 = y16;
                            } else {
                                QZoneTopGestureLayout.shouldInterceptEvent(true);
                            }
                        }
                        z16 = false;
                    }
                    z17 = false;
                    this.f44239d0 = x16;
                    this.f44240e0 = y16;
                }
                z16 = z17;
            }
        } else if (this.f44241f0) {
            z16 = this.f44236a0 != this.W || isHitCurItemLeft((float) x16);
            View view3 = this.f44236a0;
            if (view3 == this.W) {
                if (this.V == 1) {
                    endOfTouch();
                    z16 = true;
                } else {
                    hiddeRight(view3);
                }
            }
            recycleVelocityTracker();
            this.f44237b0 = -1;
            this.f44239d0 = -1;
            this.f44238c0 = -1;
            this.f44240e0 = -1;
        } else if (this.f44244i0 != 0 && this.V == 1) {
            endOfTouch();
            z16 = true;
            recycleVelocityTracker();
            this.f44237b0 = -1;
            this.f44239d0 = -1;
            this.f44238c0 = -1;
            this.f44240e0 = -1;
        } else {
            z16 = false;
            recycleVelocityTracker();
            this.f44237b0 = -1;
            this.f44239d0 = -1;
            this.f44238c0 = -1;
            this.f44240e0 = -1;
        }
        if (action == 0 && this.f44241f0) {
            c cVar2 = this.f44249n0;
            if (cVar2 != null) {
                cVar2.interceptTouchEvent(true);
            }
        } else if ((action == 1 || action == 3) && (cVar = this.f44249n0) != null) {
            cVar.interceptTouchEvent(false);
        }
        return !z16 ? super.onTouchEvent(motionEvent) : z16;
    }

    public void setDragEnable(boolean z16) {
        this.U = z16;
        if (z16) {
            return;
        }
        hideCurShowingRightView();
    }

    public void setSwipListListener(c cVar) {
        this.f44249n0 = cVar;
    }

    public QzoneSwipPullRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = false;
        this.f44245j0 = new Scroller(context, new b());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f44248m0 = viewConfiguration.getScaledTouchSlop();
        this.f44243h0 = viewConfiguration.getScaledMinimumFlingVelocity() * 4;
        this.f44237b0 = -1;
        this.f44239d0 = -1;
        this.f44238c0 = -1;
        this.f44240e0 = -1;
        this.f44246k0 = new Handler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof c) {
            this.f44249n0 = (c) listAdapter;
        }
    }

    private int getAnimDuration(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    private boolean isShowingRightView(View view) {
        return view != null && view.getScrollX() >= this.f44248m0;
    }

    private void hiddeRight(View view) {
        int scrollX = view != null ? view.getScrollX() : 0;
        c cVar = this.f44249n0;
        if (cVar != null) {
            cVar.updateCurShowRightView(null);
        }
        if (scrollX != 0) {
            int intValue = view.getTag(-3) instanceof Integer ? ((Integer) view.getTag(-3)).intValue() : 0;
            View view2 = this.f44247l0;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.f44247l0 = view;
            int i3 = -scrollX;
            this.f44245j0.startScroll(scrollX, 0, i3, 0, getAnimDuration(intValue, i3));
            this.f44246k0.sendEmptyMessage(1);
            QZoneTopGestureLayout.shouldInterceptEvent(true);
        }
    }

    private void showRight(View view) {
        int i3;
        if (view != null) {
            int scrollX = view.getScrollX();
            c cVar = this.f44249n0;
            if (cVar != null) {
                cVar.updateCurShowRightView(view);
            }
            i3 = scrollX;
        } else {
            i3 = 0;
        }
        int i16 = this.f44244i0;
        if (i16 == 0 && view != null && (view.getTag(-3) instanceof Integer)) {
            i16 = ((Integer) view.getTag(-3)).intValue();
        }
        if (i3 != i16) {
            View view2 = this.f44247l0;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.f44247l0 = view;
            int i17 = i16 - i3;
            this.f44245j0.startScroll(i3, 0, i17, 0, getAnimDuration(i16, i17));
            this.f44246k0.sendEmptyMessage(0);
            QZoneTopGestureLayout.shouldInterceptEvent(false);
        }
    }

    public boolean u0(int i3) {
        View childAt;
        if (i3 < 0 || i3 >= getAdapter().getCount() || (childAt = getChildAt(i3 - getFirstVisiblePosition())) == null || !(childAt.getTag(-3) instanceof Integer) || childAt.getScrollX() != 0) {
            return false;
        }
        this.f44244i0 = ((Integer) childAt.getTag(-3)).intValue();
        this.f44236a0 = childAt;
        showRight(childAt);
        return true;
    }

    /* loaded from: classes39.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    public void setRightIconMenuListener(a aVar) {
    }
}
