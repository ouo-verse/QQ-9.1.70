package com.tencent.sqshow.zootopia.view.pull2refresh.androidx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes34.dex */
public class NestTouchFixRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private int f373375f;

    /* renamed from: h, reason: collision with root package name */
    private int f373376h;

    /* renamed from: i, reason: collision with root package name */
    private int f373377i;

    /* renamed from: m, reason: collision with root package name */
    private int f373378m;

    public NestTouchFixRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.f373375f = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f373376h = (int) (motionEvent.getX() + 0.5f);
            this.f373377i = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f373375f = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.f373376h = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.f373377i = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f373375f);
        if (findPointerIndex < 0) {
            return false;
        }
        int x16 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
        int y16 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
        if (getScrollState() != 1) {
            int i3 = x16 - this.f373376h;
            int i16 = y16 - this.f373377i;
            boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
            boolean canScrollVertically = getLayoutManager().canScrollVertically();
            boolean z16 = canScrollHorizontally && Math.abs(i3) > this.f373378m && (Math.abs(i3) >= Math.abs(i16) || canScrollVertically);
            if (canScrollVertically && Math.abs(i16) > this.f373378m && (Math.abs(i16) >= Math.abs(i3) || canScrollHorizontally)) {
                z16 = true;
            }
            return z16 && super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i3) {
        super.setScrollingTouchSlop(i3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 == 0) {
            this.f373378m = viewConfiguration.getScaledTouchSlop();
        } else {
            if (i3 != 1) {
                return;
            }
            this.f373378m = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public NestTouchFixRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestTouchFixRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f373375f = -1;
        this.f373378m = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
