package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

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
/* loaded from: classes10.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    Runnable f178958j;

    /* renamed from: k, reason: collision with root package name */
    OverScroller f178959k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f178960l;

    /* renamed from: m, reason: collision with root package name */
    private int f178961m;

    /* renamed from: n, reason: collision with root package name */
    private int f178962n;

    /* renamed from: o, reason: collision with root package name */
    private int f178963o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private VelocityTracker f178964p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final CoordinatorLayout f178965d;

        /* renamed from: e, reason: collision with root package name */
        private final V f178966e;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v3) {
            this.f178965d = coordinatorLayout;
            this.f178966e = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f178966e != null && (overScroller = HeaderBehavior.this.f178959k) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.f178965d, this.f178966e, headerBehavior.f178959k.getCurrY());
                    ViewCompat.postOnAnimation(this.f178966e, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.f178965d, this.f178966e);
            }
        }
    }

    public HeaderBehavior() {
        this.f178961m = -1;
        this.f178963o = -1;
    }

    private void ensureVelocityTracker() {
        if (this.f178964p == null) {
            this.f178964p = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v3) {
        return false;
    }

    boolean fling(CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3, int i16, float f16) {
        Runnable runnable = this.f178958j;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.f178958j = null;
        }
        if (this.f178959k == null) {
            this.f178959k = new OverScroller(v3.getContext());
        }
        this.f178959k.fling(0, getTopAndBottomOffset(), 0, Math.round(f16), 0, 0, i3, i16);
        if (this.f178959k.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v3);
            this.f178958j = flingRunnable;
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
        if (this.f178963o < 0) {
            this.f178963o = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f178960l) {
            int i3 = this.f178961m;
            if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y16 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y16 - this.f178962n) > this.f178963o) {
                this.f178962n = y16;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f178961m = -1;
            int x16 = (int) motionEvent.getX();
            int y17 = (int) motionEvent.getY();
            if (canDragView(v3) && coordinatorLayout.isPointInChildBounds(v3, x16, y17)) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f178960l = z16;
            if (z16) {
                this.f178962n = y17;
                this.f178961m = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.f178959k;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f178959k.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f178964p;
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
                        this.f178961m = motionEvent.getPointerId(i3);
                        this.f178962n = (int) (motionEvent.getY(i3) + 0.5f);
                    }
                }
            } else {
                int findPointerIndex = motionEvent.findPointerIndex(this.f178961m);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y16 = (int) motionEvent.getY(findPointerIndex);
                int i16 = this.f178962n - y16;
                this.f178962n = y16;
                scroll(coordinatorLayout, v3, i16, getMaxDragOffset(v3), 0);
            }
            z16 = false;
            velocityTracker2 = this.f178964p;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.f178960l && !z16) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.f178964p;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f178964p.computeCurrentVelocity(1000);
            fling(coordinatorLayout, v3, -getScrollRangeForDragFling(v3), 0, this.f178964p.getYVelocity(this.f178961m));
            z16 = true;
            this.f178960l = false;
            this.f178961m = -1;
            velocityTracker = this.f178964p;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f178964p = null;
            }
            velocityTracker2 = this.f178964p;
            if (velocityTracker2 != null) {
            }
            return !this.f178960l ? true : true;
        }
        z16 = false;
        this.f178960l = false;
        this.f178961m = -1;
        velocityTracker = this.f178964p;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f178964p;
        if (velocityTracker2 != null) {
        }
        if (!this.f178960l) {
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
        this.f178961m = -1;
        this.f178963o = -1;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
