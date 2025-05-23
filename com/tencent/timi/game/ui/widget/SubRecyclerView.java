package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SubRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private int f380105f;

    /* renamed from: h, reason: collision with root package name */
    private int f380106h;

    /* renamed from: i, reason: collision with root package name */
    private int f380107i;

    /* renamed from: m, reason: collision with root package name */
    private int f380108m;

    public SubRecyclerView(Context context) {
        this(context, null);
    }

    private boolean C(MotionEvent motionEvent) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f380105f);
        if (findPointerIndex < 0) {
            return false;
        }
        int x16 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
        int y16 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
        if (getScrollState() != 1) {
            if (!D(x16 - this.f380106h, y16 - this.f380107i, getLayoutManager().canScrollHorizontally(), getLayoutManager().canScrollVertically()) || !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean D(int i3, int i16, boolean z16, boolean z17) {
        boolean z18;
        if (z16 && Math.abs(i3) > this.f380108m && (Math.abs(i3) >= Math.abs(i16) || z17)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 && Math.abs(i16) > this.f380108m && (Math.abs(i16) >= Math.abs(i3) || z16)) {
            return true;
        }
        return z18;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 2) {
                if (actionMasked != 5) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                this.f380105f = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.f380106h = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.f380107i = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            }
            return C(motionEvent);
        }
        this.f380105f = MotionEventCompat.getPointerId(motionEvent, 0);
        this.f380106h = (int) (motionEvent.getX() + 0.5f);
        this.f380107i = (int) (motionEvent.getY() + 0.5f);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i3) {
        super.setScrollingTouchSlop(i3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.f380108m = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
                return;
            }
            return;
        }
        this.f380108m = viewConfiguration.getScaledTouchSlop();
    }

    public SubRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f380105f = -1;
        this.f380108m = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
