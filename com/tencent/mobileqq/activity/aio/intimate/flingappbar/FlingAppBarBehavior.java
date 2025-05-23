package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingAppBarBehavior extends FlingAppBarLayout.Behavior {
    private boolean A;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private a f178922y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f178923z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final CoordinatorLayout f178924d;

        /* renamed from: e, reason: collision with root package name */
        private final FlingAppBarLayout f178925e;

        /* renamed from: f, reason: collision with root package name */
        private final a f178926f;

        FlingRunnable(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, a aVar) {
            this.f178924d = coordinatorLayout;
            this.f178925e = flingAppBarLayout;
            this.f178926f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            a aVar;
            if (this.f178925e != null && (overScroller = FlingAppBarBehavior.this.f178959k) != null) {
                if (overScroller.computeScrollOffset()) {
                    int currY = FlingAppBarBehavior.this.f178959k.getCurrY();
                    int i3 = -this.f178925e.getHeight();
                    if (currY < 0 && currY < i3 && (aVar = this.f178926f) != null) {
                        aVar.g(i3 - currY);
                        FlingAppBarBehavior.this.setHeaderTopBottomOffset(this.f178924d, this.f178925e, i3);
                    } else {
                        FlingAppBarBehavior.this.setHeaderTopBottomOffset(this.f178924d, this.f178925e, currY);
                    }
                    ViewCompat.postOnAnimation(this.f178925e, this);
                    return;
                }
                FlingAppBarBehavior.this.onFlingFinished(this.f178924d, this.f178925e);
            }
        }
    }

    public FlingAppBarBehavior() {
    }

    private int B(FlingAppBarLayout flingAppBarLayout) {
        int i3;
        if (flingAppBarLayout != null && (flingAppBarLayout.getParent() instanceof CoordinatorLayout)) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) flingAppBarLayout.getParent();
            a C = C(coordinatorLayout);
            if (C != null) {
                i3 = C.f();
            } else {
                i3 = 0;
            }
            int height = (flingAppBarLayout.getHeight() + i3) - coordinatorLayout.getHeight();
            Log.d("FlingAppBarBehavior", "getAppBarMaxScrollRange, scrollContentRange:" + i3 + ", maxScrollRange: " + height);
            return Math.max(0, height);
        }
        if (flingAppBarLayout == null) {
            return 0;
        }
        return flingAppBarLayout.getHeight();
    }

    private a C(CoordinatorLayout coordinatorLayout) {
        if (this.f178922y == null) {
            this.f178922y = a.c(coordinatorLayout);
        }
        return this.f178922y;
    }

    private void F(FlingAppBarLayout flingAppBarLayout) {
        try {
            Runnable runnable = this.f178958j;
            if (runnable != null) {
                flingAppBarLayout.removeCallbacks(runnable);
                this.f178958j = null;
            }
            OverScroller overScroller = this.f178959k;
            if (overScroller != null && !overScroller.isFinished()) {
                this.f178959k.abortAnimation();
            }
        } catch (Throwable th5) {
            QLog.e("FlingAppBarBehavior", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public boolean fling(CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, int i3, int i16, float f16) {
        Runnable runnable = this.f178958j;
        if (runnable != null) {
            flingAppBarLayout.removeCallbacks(runnable);
            this.f178958j = null;
        }
        if (this.f178959k == null) {
            this.f178959k = new OverScroller(flingAppBarLayout.getContext());
        }
        this.f178959k.fling(0, getTopAndBottomOffset(), 0, Math.round(f16), 0, 0, i3, i16);
        if (this.f178959k.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, flingAppBarLayout, C(coordinatorLayout));
            this.f178958j = flingRunnable;
            ViewCompat.postOnAnimation(flingAppBarLayout, flingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, flingAppBarLayout);
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.Behavior, com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, @NonNull MotionEvent motionEvent) {
        this.A = this.f178923z;
        if (motionEvent.getActionMasked() == 0) {
            F(flingAppBarLayout);
        }
        return super.onInterceptTouchEvent(coordinatorLayout, flingAppBarLayout, motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, View view, int i3, int i16, int i17, int i18, int i19) {
        if (!this.A) {
            super.onNestedScroll(coordinatorLayout, flingAppBarLayout, view, i3, i16, i17, i18, i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior, com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
    /* renamed from: k */
    public int getMaxDragOffset(@NonNull FlingAppBarLayout flingAppBarLayout) {
        return -B(flingAppBarLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior, com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
    /* renamed from: l */
    public int getScrollRangeForDragFling(@NonNull FlingAppBarLayout flingAppBarLayout) {
        return B(flingAppBarLayout);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: q */
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, View view, int i3, int i16, int[] iArr, int i17) {
        if (i17 == 1) {
            this.f178923z = true;
        }
        if (!this.A) {
            super.onNestedPreScroll(coordinatorLayout, flingAppBarLayout, view, i3, i16, iArr, i17);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: u */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, View view, View view2, int i3, int i16) {
        F(flingAppBarLayout);
        return super.onStartNestedScroll(coordinatorLayout, flingAppBarLayout, view, view2, i3, i16);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: v */
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, View view, int i3) {
        super.onStopNestedScroll(coordinatorLayout, flingAppBarLayout, view, i3);
        this.f178923z = false;
        this.A = false;
    }

    public FlingAppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
