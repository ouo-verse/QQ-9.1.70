package com.tencent.biz.subscribe.part.block.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NestScrollRecyclerView extends RecyclerViewCompat implements NestedScrollingParent {
    private static String F = "NestScrollRecyclerView";
    private View C;
    private View D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private NestedScrollingParentHelper f96171d;

    /* renamed from: e, reason: collision with root package name */
    private int f96172e;

    /* renamed from: f, reason: collision with root package name */
    private int f96173f;

    /* renamed from: h, reason: collision with root package name */
    private int f96174h;

    /* renamed from: i, reason: collision with root package name */
    private int f96175i;

    /* renamed from: m, reason: collision with root package name */
    private RefreshHeaderView f96176m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    public NestScrollRecyclerView(Context context) {
        this(context, null);
    }

    private void e() {
        this.f96171d = new NestedScrollingParentHelper(this);
        this.f96175i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private boolean f(RecyclerView recyclerView) {
        if (recyclerView instanceof NestScrollRecyclerView) {
            ((NestScrollRecyclerView) recyclerView).c();
        }
        if (this.D == null) {
            QLog.d(F, 1, "isNestViewNotReachTop mNestTargetViewWrapper is null");
            return false;
        }
        QLog.d(F, 1, "isNestViewNotReachTop mNestTargetViewWrapper.getTop()" + this.D.getTop());
        if (this.D.getTop() <= 0) {
            return false;
        }
        return true;
    }

    private boolean g(int i3, RecyclerView recyclerView) {
        j(recyclerView);
        if ((i3 > 0 && f(recyclerView)) || (i3 < 0 && !recyclerView.canScrollVertically(-1))) {
            QLog.d(F, 4, "parent is consume");
            return true;
        }
        QLog.d(F, 4, "self consume");
        return false;
    }

    private boolean h(MotionEvent motionEvent) {
        if ((getAdapter() instanceof PullLoadMoreAdapter) && ((PullLoadMoreAdapter) getAdapter()).D() && ((PullLoadMoreAdapter) getAdapter()).A() != null) {
            ((PullLoadMoreAdapter) getAdapter()).A().handleRefreshGesture(motionEvent);
        }
        if (d() != null) {
            d().handleRefreshGesture(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void i(RefreshHeaderView refreshHeaderView) {
        this.f96176m = refreshHeaderView;
    }

    private void j(RecyclerView recyclerView) {
        if ((recyclerView instanceof NestScrollRecyclerView) && (getAdapter() instanceof PullLoadMoreAdapter) && ((PullLoadMoreAdapter) getAdapter()).D()) {
            NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) recyclerView;
            if (nestScrollRecyclerView.d() == null) {
                nestScrollRecyclerView.i(((PullLoadMoreAdapter) getAdapter()).A());
            }
        }
    }

    public a c() {
        return null;
    }

    public RefreshHeaderView d() {
        return this.f96176m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewCompat, android.support.v7.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        QLog.d(F, 1, "velocityX" + i3 + "   velocityY:" + i16);
        return super.fling(i3, i16);
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f96171d.getNestedScrollAxes();
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        QLog.d(F, 4, "onInterceptTouchEvent hashCode" + hashCode());
        int action = motionEvent.getAction();
        int actionIndex = motionEvent.getActionIndex();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            QLog.d(F, 4, "onInterceptTouchEvent:  X:" + motionEvent.getX() + " Y:" + motionEvent.getY());
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.f96172e;
            int i16 = (int) (((float) (y16 - this.f96173f)) * 0.6f);
            QLog.d(F, 1, "ACTION_MOVE dx:" + i3 + "    dy:" + i16);
            if (Math.abs(i3) > this.f96175i && Math.abs(i3) >= Math.abs(i16)) {
                QLog.d(F, 4, "move axis x");
                return false;
            }
            if (this.C instanceof NestScrollRecyclerView) {
                QLog.d(F, 4, "NestScrollRecyclerView");
                return false;
            }
        } else {
            this.f96172e = (int) (motionEvent.getX() + 0.5f);
            this.f96173f = (int) (motionEvent.getY() + 0.5f);
            this.f96174h = MotionEventCompat.findPointerIndex(motionEvent, actionIndex);
            this.C = null;
            this.D = null;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.E) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            if (getMeasuredHeight() > ImmersiveUtils.getScreenHeight()) {
                measuredHeight = ImmersiveUtils.getScreenHeight();
            }
            if (getMeasuredWidth() > ImmersiveUtils.getScreenWidth()) {
                measuredWidth = ImmersiveUtils.getScreenWidth();
            }
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        Log.d(F, String.format("----onNestedFling---------------- velocityX:%s, velocityY:%s, consumed:%s", Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16)));
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        boolean z16;
        if (view instanceof NestScrollRecyclerView) {
            int i3 = (int) f17;
            if (g(i3, (NestScrollRecyclerView) view)) {
                fling((int) f16, i3);
                z16 = true;
                Log.d(F, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", Boolean.valueOf(z16), Float.valueOf(f17)));
                return z16;
            }
        }
        z16 = false;
        Log.d(F, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", Boolean.valueOf(z16), Float.valueOf(f17)));
        return z16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        Log.d(F, String.format("onNestedPreScroll dx:%s,dy:%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        if ((view instanceof RecyclerView) && g(i16, (RecyclerView) view)) {
            scrollBy(0, i16);
            Log.d(F, "scrollBy" + i16);
            iArr[1] = i16;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        Log.d(F, "onNestedScroll: targetView:" + view.hashCode() + " dxConsumed:" + i3 + "   dyConsumed:" + i16 + "   dxUnconsumed:" + i17 + "   dyUnconsumed:" + i18);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    @SuppressLint({"NewApi"})
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        Log.d(F, "----\u7236\u5e03\u5c40onNestedScrollAccepted----------------");
        this.C = view2;
        this.D = view;
        this.f96171d.onNestedScrollAccepted(view, view2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        Log.d(F, String.format("\u7236\u5e03\u5c40onStartNestedScroll: child:%s, target:%s, nestedScrollAxes:%s", Integer.valueOf(view.hashCode()), Integer.valueOf(view2.hashCode()), Integer.valueOf(i3)));
        if ((i3 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Log.d(F, "----\u7236\u5e03\u5c40onStopNestedScroll----------------");
        this.f96171d.onStopNestedScroll(view);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return h(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewCompat, android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
    }

    public void setNeedLimitHeightWidth(boolean z16) {
        this.E = z16;
    }

    public NestScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e();
    }

    public void setNestScrollDelegate(a aVar) {
    }

    public void setTransDispatchDelegate(b bVar) {
    }
}
