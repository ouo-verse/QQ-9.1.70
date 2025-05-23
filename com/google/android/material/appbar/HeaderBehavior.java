package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;

    @Nullable
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;

    @Nullable
    private VelocityTracker velocityTracker;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final CoordinatorLayout f33235d;

        /* renamed from: e, reason: collision with root package name */
        private final V f33236e;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v3) {
            this.f33235d = coordinatorLayout;
            this.f33236e = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f33236e != null && (overScroller = HeaderBehavior.this.scroller) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.f33235d, this.f33236e, headerBehavior.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.f33236e, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.f33235d, this.f33236e);
            }
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v3) {
        return false;
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3, int i16, float f16) {
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v3.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f16), 0, 0, i3, i16);
        if (this.scroller.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v3);
            this.flingRunnable = flingRunnable;
            ViewCompat.postOnAnimation(v3, flingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v3);
        return false;
    }

    int getMaxDragOffset(@NonNull V v3) {
        return -v3.getHeight();
    }

    int getScrollRangeForDragFling(@NonNull V v3) {
        return v3.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z16;
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i3 = this.activePointerId;
            if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y16 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y16 - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y16;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x16 = (int) motionEvent.getX();
            int y17 = (int) motionEvent.getY();
            if (canDragView(v3) && coordinatorLayout.isPointInChildBounds(v3, x16, y17)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isBeingDragged = z16;
            if (z16) {
                this.lastMotionY = y17;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z16;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        if (motionEvent.getActionIndex() == 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        this.activePointerId = motionEvent.getPointerId(i3);
                        this.lastMotionY = (int) (motionEvent.getY(i3) + 0.5f);
                    }
                }
            } else {
                int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y16 = (int) motionEvent.getY(findPointerIndex);
                int i16 = this.lastMotionY - y16;
                this.lastMotionY = y16;
                scroll(coordinatorLayout, v3, i16, getMaxDragOffset(v3), 0);
            }
            z16 = false;
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.isBeingDragged && !z16) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.velocityTracker.computeCurrentVelocity(1000);
            fling(coordinatorLayout, v3, -getScrollRangeForDragFling(v3), 0, this.velocityTracker.getYVelocity(this.activePointerId));
            z16 = true;
            this.isBeingDragged = false;
            this.activePointerId = -1;
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
            }
            return !this.isBeingDragged ? true : true;
        }
        z16 = false;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
        }
        if (!this.isBeingDragged) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v3, int i3, int i16, int i17) {
        return setHeaderTopBottomOffset(coordinatorLayout, v3, getTopBottomOffsetForScrollingSibling() - i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v3, i3, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v3, int i3, int i16, int i17) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i16 == 0 || topAndBottomOffset < i16 || topAndBottomOffset > i17 || topAndBottomOffset == (clamp = MathUtils.clamp(i3, i16, i17))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
