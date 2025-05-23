package com.tencent.mobileqq.qqvideoedit.view.scrollingheader;

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

/* compiled from: P */
/* loaded from: classes17.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private Runnable f276317j;

    /* renamed from: k, reason: collision with root package name */
    OverScroller f276318k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f276319l;

    /* renamed from: m, reason: collision with root package name */
    private int f276320m;

    /* renamed from: n, reason: collision with root package name */
    private int f276321n;

    /* renamed from: o, reason: collision with root package name */
    private int f276322o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private VelocityTracker f276323p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final CoordinatorLayout f276324d;

        /* renamed from: e, reason: collision with root package name */
        private final V f276325e;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v3) {
            this.f276324d = coordinatorLayout;
            this.f276325e = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f276325e != null && (overScroller = HeaderBehavior.this.f276318k) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.f276324d, this.f276325e, headerBehavior.f276318k.getCurrY());
                    ViewCompat.postOnAnimation(this.f276325e, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.f276324d, this.f276325e);
            }
        }
    }

    public HeaderBehavior() {
        this.f276320m = -1;
        this.f276322o = -1;
    }

    private void ensureVelocityTracker() {
        if (this.f276323p == null) {
            this.f276323p = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v3) {
        return false;
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3, int i16, float f16) {
        Runnable runnable = this.f276317j;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.f276317j = null;
        }
        if (this.f276318k == null) {
            this.f276318k = new OverScroller(v3.getContext());
        }
        this.f276318k.fling(0, getTopAndBottomOffset(), 0, Math.round(f16), 0, 0, i3, i16);
        if (this.f276318k.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v3);
            this.f276317j = flingRunnable;
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
        if (this.f276322o < 0) {
            this.f276322o = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f276319l) {
            int i3 = this.f276320m;
            if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y16 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y16 - this.f276321n) > this.f276322o) {
                this.f276321n = y16;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f276320m = -1;
            int x16 = (int) motionEvent.getX();
            int y17 = (int) motionEvent.getY();
            if (canDragView(v3) && coordinatorLayout.isPointInChildBounds(v3, x16, y17)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f276319l = z16;
            if (z16) {
                this.f276321n = y17;
                this.f276320m = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.f276318k;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f276318k.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f276323p;
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
                        this.f276320m = motionEvent.getPointerId(i3);
                        this.f276321n = (int) (motionEvent.getY(i3) + 0.5f);
                    }
                }
            } else {
                int findPointerIndex = motionEvent.findPointerIndex(this.f276320m);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y16 = (int) motionEvent.getY(findPointerIndex);
                int i16 = this.f276321n - y16;
                this.f276321n = y16;
                scroll(coordinatorLayout, v3, i16, getMaxDragOffset(v3), 0);
            }
            z16 = false;
            velocityTracker2 = this.f276323p;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.f276319l && !z16) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.f276323p;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f276323p.computeCurrentVelocity(1000);
            fling(coordinatorLayout, v3, -getScrollRangeForDragFling(v3), 0, this.f276323p.getYVelocity(this.f276320m));
            z16 = true;
            this.f276319l = false;
            this.f276320m = -1;
            velocityTracker = this.f276323p;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f276323p = null;
            }
            velocityTracker2 = this.f276323p;
            if (velocityTracker2 != null) {
            }
            return !this.f276319l ? true : true;
        }
        z16 = false;
        this.f276319l = false;
        this.f276320m = -1;
        velocityTracker = this.f276323p;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f276323p;
        if (velocityTracker2 != null) {
        }
        if (!this.f276319l) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v3, int i3, int i16, int i17) {
        return setHeaderTopBottomOffset(coordinatorLayout, v3, getTopBottomOffsetForScrollingSibling() - i3, i16, i17);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v3, int i3) {
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
        this.f276320m = -1;
        this.f276322o = -1;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
