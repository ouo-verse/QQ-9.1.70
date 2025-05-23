package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

/* compiled from: P */
/* loaded from: classes34.dex */
public class RecyclerViewWithHeaderFooterFix extends RecyclerViewWithHeaderFooter {

    /* renamed from: d, reason: collision with root package name */
    private int f373351d;

    /* renamed from: e, reason: collision with root package name */
    private int f373352e;

    /* renamed from: f, reason: collision with root package name */
    private int f373353f;

    /* renamed from: h, reason: collision with root package name */
    private int f373354h;

    public RecyclerViewWithHeaderFooterFix(Context context) {
        this(context, null);
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter, android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mInterceptTouchEvent) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.f373351d = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f373352e = (int) (motionEvent.getX() + 0.5f);
            this.f373353f = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f373351d = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.f373352e = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.f373353f = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f373351d);
        if (findPointerIndex < 0) {
            return false;
        }
        int x16 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
        int y16 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
        if (getScrollState() != 1) {
            int i3 = x16 - this.f373352e;
            int i16 = y16 - this.f373353f;
            boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
            boolean canScrollVertically = getLayoutManager().canScrollVertically();
            boolean z16 = canScrollHorizontally && Math.abs(i3) > this.f373354h && (Math.abs(i3) >= Math.abs(i16) || canScrollVertically);
            if (canScrollVertically && Math.abs(i16) > this.f373354h && (Math.abs(i16) >= Math.abs(i3) || canScrollHorizontally)) {
                z16 = true;
            }
            return z16 && super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setScrollingTouchSlop(int i3) {
        super.setScrollingTouchSlop(i3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 == 0) {
            this.f373354h = viewConfiguration.getScaledTouchSlop();
        } else {
            if (i3 != 1) {
                return;
            }
            this.f373354h = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public RecyclerViewWithHeaderFooterFix(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewWithHeaderFooterFix(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f373351d = -1;
        this.f373354h = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
