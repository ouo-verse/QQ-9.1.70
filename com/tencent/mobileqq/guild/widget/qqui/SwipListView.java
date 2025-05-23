package com.tencent.mobileqq.guild.widget.qqui;

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
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class SwipListView extends XListView implements Handler.Callback {
    private int C;
    private int D;
    private boolean E;
    private VelocityTracker F;
    private int G;
    private int H;
    private Scroller I;
    private Handler J;
    private View K;
    private final int L;
    private c M;

    /* renamed from: d, reason: collision with root package name */
    private boolean f236495d;

    /* renamed from: e, reason: collision with root package name */
    private byte f236496e;

    /* renamed from: f, reason: collision with root package name */
    private View f236497f;

    /* renamed from: h, reason: collision with root package name */
    private View f236498h;

    /* renamed from: i, reason: collision with root package name */
    private int f236499i;

    /* renamed from: m, reason: collision with root package name */
    private int f236500m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void hideMenuPop();

        void interceptTouchEvent(boolean z16);

        void updateCurShowRightView(View view);
    }

    public SwipListView(Context context) {
        this(context, null);
    }

    private void addVelocityTracker(MotionEvent motionEvent) {
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
    }

    private void cancelShowHideAnim() {
        this.J.removeMessages(1);
        this.J.removeMessages(0);
        this.K = null;
    }

    private void endOfTouch() {
        int scrollVelocity = getScrollVelocity();
        int scrollX = this.f236498h.getScrollX();
        int i3 = this.G;
        if (scrollVelocity > i3) {
            hiddeRight(this.f236498h);
            return;
        }
        if (scrollVelocity < (-i3)) {
            showRight(this.f236498h);
            return;
        }
        if (scrollVelocity > 0 && scrollX < this.H * 0.7f) {
            hiddeRight(this.f236498h);
            return;
        }
        if (scrollVelocity < 0 && scrollX > this.H * 0.3f) {
            showRight(this.f236498h);
            return;
        }
        if (this.E && scrollX < this.H * 0.7f) {
            hiddeRight(this.f236498h);
        } else if (scrollX > this.H * 0.3f) {
            showRight(this.f236498h);
        } else {
            hiddeRight(this.f236498h);
        }
    }

    private int getAnimDuration(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    private int getScrollVelocity() {
        this.F.computeCurrentVelocity(1000);
        return (int) this.F.getXVelocity();
    }

    private void hiddeRight(View view) {
        int i3;
        int i16;
        if (view != null) {
            i3 = view.getScrollX();
        } else {
            i3 = 0;
        }
        c cVar = this.M;
        if (cVar != null) {
            cVar.updateCurShowRightView(null);
        }
        if (i3 != 0) {
            if (view.getTag(-3) instanceof Integer) {
                i16 = ((Integer) view.getTag(-3)).intValue();
            } else {
                i16 = 0;
            }
            View view2 = this.K;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.K = view;
            int i17 = -i3;
            this.I.startScroll(i3, 0, i17, 0, getAnimDuration(i16, i17));
            this.J.sendEmptyMessage(1);
        }
    }

    private boolean isHitCurItemLeft(float f16) {
        if (f16 < getWidth() - this.H) {
            return true;
        }
        return false;
    }

    private boolean isShowingRightView(View view) {
        if (view != null && view.getScrollX() >= this.L) {
            return true;
        }
        return false;
    }

    private boolean judgeScrollDirection(float f16, float f17) {
        int i3 = this.L;
        if (f16 <= i3 && f17 <= i3) {
            return false;
        }
        if (f16 > i3 && f17 / f16 < 0.6f) {
            this.f236496e = (byte) 1;
        } else {
            this.f236496e = (byte) 2;
        }
        return true;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.F = null;
        }
    }

    private void scrollItemView(int i3, int i16, View view, int i17) {
        int scrollX = view.getScrollX() - (i3 - this.C);
        if (scrollX <= i17) {
            if (scrollX < 0) {
                i17 = 0;
            } else {
                i17 = scrollX;
            }
        }
        view.scrollTo(i17, 0);
    }

    private void showRight(View view) {
        int i3;
        if (view != null) {
            int scrollX = view.getScrollX();
            c cVar = this.M;
            if (cVar != null) {
                cVar.updateCurShowRightView(view);
            }
            i3 = scrollX;
        } else {
            i3 = 0;
        }
        int i16 = this.H;
        if (i16 == 0 && view != null && (view.getTag(-3) instanceof Integer)) {
            i16 = ((Integer) view.getTag(-3)).intValue();
        }
        if (i3 != i16) {
            View view2 = this.K;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            cancelShowHideAnim();
            this.K = view;
            int i17 = i16 - i3;
            this.I.startScroll(i3, 0, i17, 0, getAnimDuration(i16, i17));
            this.J.sendEmptyMessage(0);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        int i16;
        int i17 = message.what;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    return false;
                }
                c cVar = this.M;
                if (cVar == null) {
                    return true;
                }
                cVar.hideMenuPop();
                return true;
            }
            boolean computeScrollOffset = this.I.computeScrollOffset();
            float currX = this.I.getCurrX();
            View view = this.K;
            if (view != null && view.getScrollX() > (i16 = (int) currX)) {
                this.K.scrollTo(i16, 0);
                invalidate();
            }
            if (computeScrollOffset) {
                this.J.sendEmptyMessage(1);
                return true;
            }
            this.K = null;
            return true;
        }
        boolean computeScrollOffset2 = this.I.computeScrollOffset();
        float currX2 = this.I.getCurrX();
        View view2 = this.K;
        if (view2 != null && view2.getScrollX() < (i3 = (int) currX2)) {
            this.K.scrollTo(i3, 0);
            invalidate();
        }
        if (computeScrollOffset2) {
            this.J.sendEmptyMessage(0);
            return true;
        }
        this.K = null;
        return true;
    }

    public void hideCurShowingRightView() {
        if (!isShowingRightView(this.f236498h)) {
            int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
            int lastVisiblePosition = getLastVisiblePosition();
            while (true) {
                if (firstVisiblePosition > lastVisiblePosition) {
                    break;
                }
                View childAt = getChildAt(firstVisiblePosition);
                if (isShowingRightView(childAt)) {
                    this.f236498h = childAt;
                    break;
                }
                firstVisiblePosition++;
            }
        }
        hiddeRight(this.f236498h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r2 != 3) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0110 A[ADDED_TO_REGION] */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        c cVar;
        if (!this.f236495d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.H > 0) {
                        if (this.f236496e == 0) {
                            judgeScrollDirection(Math.abs(x16 - this.f236499i), Math.abs(y16 - this.f236500m));
                        }
                        if (this.f236496e == 1) {
                            if (x16 < this.f236499i) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                this.J.sendEmptyMessage(2);
                            }
                            if (action != 0 && this.E) {
                                c cVar2 = this.M;
                                if (cVar2 != null) {
                                    cVar2.interceptTouchEvent(true);
                                }
                                cancelShowHideAnim();
                            } else if ((action != 1 || action == 3) && (cVar = this.M) != null) {
                                cVar.interceptTouchEvent(false);
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
                cVar.interceptTouchEvent(false);
                if (!z16) {
                }
            }
            if (this.E) {
                hiddeRight(this.f236497f);
            }
            this.f236499i = -1;
            this.C = -1;
            this.f236500m = -1;
            this.D = -1;
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            cVar.interceptTouchEvent(false);
            if (!z16) {
            }
        } else {
            this.f236496e = (byte) 0;
            c cVar3 = this.M;
            if (cVar3 != null) {
                cVar3.updateCurShowRightView(null);
            }
            this.f236499i = x16;
            this.C = x16;
            this.f236500m = y16;
            this.D = y16;
            View view = this.f236498h;
            this.f236497f = view;
            boolean isShowingRightView = isShowingRightView(view);
            this.E = isShowingRightView;
            if (!isShowingRightView) {
                int firstVisiblePosition = getFirstVisiblePosition() - getHeaderViewsCount();
                int lastVisiblePosition = getLastVisiblePosition();
                while (true) {
                    if (lastVisiblePosition < firstVisiblePosition) {
                        break;
                    }
                    View childAt = getChildAt(lastVisiblePosition);
                    boolean isShowingRightView2 = isShowingRightView(childAt);
                    this.E = isShowingRightView2;
                    if (isShowingRightView2) {
                        this.f236497f = childAt;
                        break;
                    }
                    lastVisiblePosition--;
                }
            }
            this.H = 0;
            this.f236498h = null;
            int i3 = this.f236500m;
            if (isOverscrollHeadVisiable()) {
                i3 = this.f236500m + getScrollY();
            }
            int pointToPosition = pointToPosition(this.f236499i, i3);
            if (pointToPosition >= 0) {
                View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                this.f236498h = childAt2;
                if (childAt2 != null && (childAt2.getTag(-3) instanceof Integer)) {
                    this.H = ((Integer) this.f236498h.getTag(-3)).intValue();
                }
            }
            if (this.E && (this.f236498h != this.f236497f || isHitCurItemLeft(x16))) {
                z16 = true;
                if (action != 0) {
                }
                if (action != 1) {
                }
                cVar.interceptTouchEvent(false);
                if (!z16) {
                }
            }
            z16 = false;
            if (action != 0) {
            }
            if (action != 1) {
            }
            cVar.interceptTouchEvent(false);
            if (!z16) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r2 != 3) goto L39;
     */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View view;
        c cVar;
        boolean z17;
        if (!this.f236495d) {
            return super.onTouchEvent(motionEvent);
        }
        addVelocityTracker(motionEvent);
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.E) {
                        if (this.f236498h == this.f236497f && !isHitCurItemLeft(x16)) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (this.f236498h == this.f236497f) {
                            if (this.f236496e != 0 || judgeScrollDirection(Math.abs(x16 - this.f236499i), Math.abs(y16 - this.f236500m))) {
                                if (this.f236496e == 1) {
                                    scrollItemView(x16, y16, this.f236498h, this.H);
                                    z16 = true;
                                }
                            }
                        }
                        this.C = x16;
                        this.D = y16;
                    } else {
                        if (this.H != 0) {
                            if (this.f236496e != 0 || judgeScrollDirection(Math.abs(x16 - this.f236499i), Math.abs(y16 - this.f236500m))) {
                                if (this.f236496e == 1) {
                                    scrollItemView(x16, y16, this.f236498h, this.H);
                                    z16 = true;
                                    this.C = x16;
                                    this.D = y16;
                                }
                            }
                        }
                        z16 = false;
                        this.C = x16;
                        this.D = y16;
                    }
                }
                z16 = false;
            }
            if (this.E) {
                if (this.f236498h == this.f236497f && !isHitCurItemLeft(x16)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                View view2 = this.f236498h;
                if (view2 == this.f236497f) {
                    if (this.f236496e == 1) {
                        endOfTouch();
                        z16 = true;
                        recycleVelocityTracker();
                        this.f236499i = -1;
                        this.C = -1;
                        this.f236500m = -1;
                        this.D = -1;
                    } else {
                        hiddeRight(view2);
                    }
                }
                z16 = z17;
                recycleVelocityTracker();
                this.f236499i = -1;
                this.C = -1;
                this.f236500m = -1;
                this.D = -1;
            } else if (this.H != 0 && this.f236496e == 1) {
                endOfTouch();
                z16 = true;
                recycleVelocityTracker();
                this.f236499i = -1;
                this.C = -1;
                this.f236500m = -1;
                this.D = -1;
            } else {
                z16 = false;
                recycleVelocityTracker();
                this.f236499i = -1;
                this.C = -1;
                this.f236500m = -1;
                this.D = -1;
            }
        } else {
            if (this.E && (this.f236498h != this.f236497f || isHitCurItemLeft(x16))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.E && (view = this.f236497f) != this.f236498h) {
                hiddeRight(view);
            }
        }
        if (action == 0 && this.E) {
            c cVar2 = this.M;
            if (cVar2 != null) {
                cVar2.interceptTouchEvent(true);
            }
        } else if ((action == 1 || action == 3) && (cVar = this.M) != null) {
            cVar.interceptTouchEvent(false);
        }
        if (!z16) {
            return super.onTouchEvent(motionEvent);
        }
        return z16;
    }

    public void setDragEnable(boolean z16) {
        this.f236495d = z16;
        if (!z16) {
            hideCurShowingRightView();
        }
    }

    public void setSwipListListener(c cVar) {
        this.M = cVar;
    }

    public SwipListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof c) {
            this.M = (c) listAdapter;
        }
    }

    public SwipListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236495d = false;
        this.I = new Scroller(context, new b());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.L = viewConfiguration.getScaledTouchSlop();
        this.G = viewConfiguration.getScaledMinimumFlingVelocity() * 4;
        this.f236499i = -1;
        this.C = -1;
        this.f236500m = -1;
        this.D = -1;
        this.J = new Handler(Looper.getMainLooper(), this);
    }

    public void setRightIconMenuListener(a aVar) {
    }
}
