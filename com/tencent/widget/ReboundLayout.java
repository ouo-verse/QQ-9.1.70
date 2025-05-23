package com.tencent.widget;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReboundLayout extends LinearLayout implements NestedScrollingParent {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_WIDTH = 400;
    private boolean isRunAnim;
    private View mChildView;
    private int mDrag;
    private View mFooterView;
    private View mHeaderView;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ProgressAnimation extends Animation {
        static IPatchRedirector $redirector_;
        private float endProgress;
        private float startProgress;

        ProgressAnimation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReboundLayout.this);
                return;
            }
            this.startProgress = 0.0f;
            this.endProgress = 1.0f;
            ReboundLayout.this.isRunAnim = true;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), transformation);
                return;
            }
            float f17 = this.endProgress;
            float f18 = this.startProgress;
            float f19 = ((f17 - f18) * f16) + f18;
            ReboundLayout.this.scrollBy((int) ((400 - r5.getScrollX()) * f19), 0);
            if (f19 == 1.0f) {
                ReboundLayout.this.isRunAnim = false;
            }
        }

        @Override // android.view.animation.Animation
        public void initialize(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            super.initialize(i3, i16, i17, i18);
            setDuration(260L);
            setInterpolator(new AccelerateInterpolator());
        }
    }

    public ReboundLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.mChildView = getChildAt(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400, -1);
        this.mHeaderView = new View(this.mChildView.getContext());
        this.mFooterView = new View(this.mChildView.getContext());
        addView(this.mHeaderView, 0, layoutParams);
        addView(this.mFooterView, getChildCount(), layoutParams);
        scrollBy(400, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            this.mChildView.getLayoutParams().width = getMeasuredWidth();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 12, this, view, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16))).booleanValue();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, view, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (getScrollX() == 400) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16), iArr);
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (i3 > 0 && getScrollX() < 400 && !ViewCompat.canScrollHorizontally(view, -1)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 < 0 && !ViewCompat.canScrollHorizontally(view, -1)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i3 < 0 && getScrollX() > 400 && !ViewCompat.canScrollHorizontally(view, 1)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i3 > 0 && !ViewCompat.canScrollHorizontally(view, 1)) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z16 || z17 || z18 || z19) {
            scrollBy(i3 / this.mDrag, 0);
            iArr[0] = i3;
        }
        if (i3 > 0 && getScrollX() > 400 && !ViewCompat.canScrollHorizontally(view, -1)) {
            scrollTo(400, 0);
        }
        if (i3 < 0 && getScrollX() < 400 && !ViewCompat.canScrollHorizontally(view, 1)) {
            scrollTo(400, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, view2, Integer.valueOf(i3));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, view, view2, Integer.valueOf(i3))).booleanValue();
        }
        if ((view2 instanceof RecyclerView) && !this.isRunAnim) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            startAnimation(new ProgressAnimation());
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 800) {
            i3 = 800;
        }
        super.scrollTo(i3, i16);
    }

    public ReboundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ReboundLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mDrag = 3;
            setOrientation(0);
        }
    }

    @RequiresApi(api = 21)
    public ReboundLayout(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mDrag = 3;
            setOrientation(0);
        }
    }
}
