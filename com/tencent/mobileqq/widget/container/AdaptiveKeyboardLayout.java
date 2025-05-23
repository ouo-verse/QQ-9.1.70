package com.tencent.mobileqq.widget.container;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AdaptiveKeyboardLayout extends FrameLayout {
    private b C;
    private SetChildMarginRunnable D;
    private boolean E;
    private a F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private View f316848d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f316849e;

    /* renamed from: f, reason: collision with root package name */
    private int f316850f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f316851h;

    /* renamed from: i, reason: collision with root package name */
    private int f316852i;

    /* renamed from: m, reason: collision with root package name */
    private int f316853m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class SetChildMarginRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f316854d;

        SetChildMarginRunnable(int i3) {
            this.f316854d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdaptiveKeyboardLayout.this.p(this.f316854d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    protected class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        int f316855d;

        b() {
            this.f316855d = 0;
            this.f316855d = ImmersiveUtils.getStatusBarHeight(AdaptiveKeyboardLayout.this.getContext());
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (AdaptiveKeyboardLayout.this.f316848d != null && AdaptiveKeyboardLayout.this.G) {
                Rect rect = new Rect();
                AdaptiveKeyboardLayout.this.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                int height2 = AdaptiveKeyboardLayout.this.f316848d.getHeight();
                QLog.d("AdaptiveKeyboardLayout", 1, "onGlobalLayout: rootHeight=" + height2 + ", visibleHeight=" + height);
                if (height == AdaptiveKeyboardLayout.this.f316852i && height2 == AdaptiveKeyboardLayout.this.f316853m) {
                    QLog.d("AdaptiveKeyboardLayout", 1, "onGlobalLayout: doesn't changed, return.");
                    return;
                }
                int i3 = height2 - height;
                if (AdaptiveKeyboardLayout.this.f316849e) {
                    i3 -= this.f316855d;
                }
                AdaptiveKeyboardLayout.this.f316852i = height;
                AdaptiveKeyboardLayout.this.f316853m = height2;
                if (i3 <= ViewUtils.dip2px(100.0f)) {
                    AdaptiveKeyboardLayout.this.o(0);
                    if (AdaptiveKeyboardLayout.this.F != null) {
                        AdaptiveKeyboardLayout.this.F.a(false, 0);
                        return;
                    }
                    return;
                }
                int min = Math.min(i3 + this.f316855d + 88, AdaptiveKeyboardLayout.this.l());
                AdaptiveKeyboardLayout.this.o(min);
                if (AdaptiveKeyboardLayout.this.F != null) {
                    AdaptiveKeyboardLayout.this.F.a(true, min);
                }
            }
        }
    }

    public AdaptiveKeyboardLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        if (getChildCount() > 0 && this.f316851h) {
            return getHeight() - getChildAt(0).getHeight();
        }
        return getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3) {
        if (getChildCount() <= 0) {
            return;
        }
        Runnable runnable = this.D;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (getChildCount() <= 0) {
            return;
        }
        if (this.E) {
            SetChildMarginRunnable setChildMarginRunnable = new SetChildMarginRunnable(i3);
            this.D = setChildMarginRunnable;
            postDelayed(setChildMarginRunnable, 80L);
            return;
        }
        p(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        if (getChildCount() <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i16 = i3 + this.f316850f;
        if (layoutParams.bottomMargin != i16) {
            layoutParams.bottomMargin = i16;
            childAt.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        boolean z16;
        if (getChildCount() <= 0) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 80;
            this.f316850f = layoutParams2.bottomMargin;
            if (layoutParams2.height != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f316851h = z16;
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("AdaptiveKeyboardLayout can host only one direct child");
    }

    public void m(View view, boolean z16) {
        this.f316848d = view;
        this.f316849e = z16;
        if (this.C == null) {
            this.C = new b();
            getViewTreeObserver().addOnGlobalLayoutListener(this.C);
        }
    }

    public void n() {
        o(0);
        this.f316853m = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.C != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.C);
            this.C = null;
        }
        removeCallbacks(this.D);
    }

    public void setIsSlightMove(boolean z16) {
        this.E = z16;
    }

    public void setKeyboardLayoutEnable(boolean z16) {
        this.G = z16;
    }

    public void setKeyboardListener(a aVar) {
        this.F = aVar;
    }

    public AdaptiveKeyboardLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdaptiveKeyboardLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = true;
    }
}
