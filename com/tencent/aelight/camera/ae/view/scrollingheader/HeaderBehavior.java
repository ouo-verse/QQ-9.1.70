package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* compiled from: P */
/* loaded from: classes32.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: j, reason: collision with root package name */
    private Runnable f65927j;

    /* renamed from: k, reason: collision with root package name */
    OverScroller f65928k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f65929l;

    /* renamed from: m, reason: collision with root package name */
    private int f65930m;

    /* renamed from: n, reason: collision with root package name */
    private int f65931n;

    /* renamed from: o, reason: collision with root package name */
    private int f65932o;

    /* renamed from: p, reason: collision with root package name */
    private VelocityTracker f65933p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final CoordinatorLayout f65934d;

        /* renamed from: e, reason: collision with root package name */
        private final V f65935e;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v3) {
            this.f65934d = coordinatorLayout;
            this.f65935e = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f65935e == null || (overScroller = HeaderBehavior.this.f65928k) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = HeaderBehavior.this;
                headerBehavior.setHeaderTopBottomOffset(this.f65934d, this.f65935e, headerBehavior.f65928k.getCurrY());
                ViewCompat.postOnAnimation(this.f65935e, this);
                return;
            }
            HeaderBehavior.this.onFlingFinished(this.f65934d, this.f65935e);
        }
    }

    public HeaderBehavior() {
        this.f65930m = -1;
        this.f65932o = -1;
    }

    private void ensureVelocityTracker() {
        if (this.f65933p == null) {
            this.f65933p = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v3) {
        return false;
    }

    int getMaxDragOffset(V v3) {
        return -v3.getHeight();
    }

    int getScrollRangeForDragFling(V v3) {
        return v3.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f65932o < 0) {
            this.f65932o = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f65929l) {
            int i3 = this.f65930m;
            if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y16 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y16 - this.f65931n) > this.f65932o) {
                this.f65931n = y16;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f65930m = -1;
            int x16 = (int) motionEvent.getX();
            int y17 = (int) motionEvent.getY();
            boolean z16 = canDragView(v3) && coordinatorLayout.isPointInChildBounds(v3, x16, y17);
            this.f65929l = z16;
            if (z16) {
                this.f65931n = y17;
                this.f65930m = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.f65928k;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f65928k.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f65933p;
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
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        boolean z16;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f65933p;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f65933p.computeCurrentVelocity(1000);
                fling(coordinatorLayout, v3, -getScrollRangeForDragFling(v3), 0, this.f65933p.getYVelocity(this.f65930m));
                z16 = true;
                this.f65929l = false;
                this.f65930m = -1;
                velocityTracker = this.f65933p;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f65933p = null;
                }
                velocityTracker2 = this.f65933p;
                if (velocityTracker2 != null) {
                }
                if (this.f65929l) {
                    return true;
                }
            }
        } else {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f65930m);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y16 = (int) motionEvent.getY(findPointerIndex);
                int i3 = this.f65931n - y16;
                this.f65931n = y16;
                scroll(coordinatorLayout, v3, i3, getMaxDragOffset(v3), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i16 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f65930m = motionEvent.getPointerId(i16);
                    this.f65931n = (int) (motionEvent.getY(i16) + 0.5f);
                }
            }
            z16 = false;
            velocityTracker2 = this.f65933p;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.f65929l || z16;
        }
        z16 = false;
        this.f65929l = false;
        this.f65930m = -1;
        velocityTracker = this.f65933p;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f65933p;
        if (velocityTracker2 != null) {
        }
        if (this.f65929l) {
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

    final boolean fling(CoordinatorLayout coordinatorLayout, V v3, int i3, int i16, float f16) {
        Runnable runnable = this.f65927j;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.f65927j = null;
        }
        if (this.f65928k == null) {
            this.f65928k = new OverScroller(v3.getContext());
        }
        this.f65928k.fling(0, getTopAndBottomOffset(), 0, Math.round(f16), 0, 0, i3, i16);
        if (this.f65928k.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v3);
            this.f65927j = flingRunnable;
            ViewCompat.postOnAnimation(v3, flingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v3);
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65930m = -1;
        this.f65932o = -1;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
