package com.tencent.biz.qqcircle.immersive.album.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class FootRollBackScrollerView extends LinearLayout {
    private static final Object J = new Object();
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private float I;

    /* renamed from: d, reason: collision with root package name */
    private Context f84813d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f84814e;

    /* renamed from: f, reason: collision with root package name */
    private View f84815f;

    /* renamed from: h, reason: collision with root package name */
    private int f84816h;

    /* renamed from: i, reason: collision with root package name */
    private int f84817i;

    /* renamed from: m, reason: collision with root package name */
    private int f84818m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            FootRollBackScrollerView footRollBackScrollerView = FootRollBackScrollerView.this;
            boolean z16 = true;
            if (footRollBackScrollerView.f84814e.canScrollHorizontally(1) || i3 <= 0) {
                z16 = false;
            }
            footRollBackScrollerView.D = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FootRollBackScrollerView.d(FootRollBackScrollerView.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FootRollBackScrollerView.this.F = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface d {
    }

    public FootRollBackScrollerView(@NonNull Context context) {
        super(context);
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.I = 0.0f;
        this.f84813d = context;
    }

    static /* bridge */ /* synthetic */ d d(FootRollBackScrollerView footRollBackScrollerView) {
        footRollBackScrollerView.getClass();
        return null;
    }

    private void h() {
        int childCount = getChildCount();
        Object obj = J;
        View findViewWithTag = findViewWithTag(obj);
        if (findViewWithTag != null && getChildAt(childCount - 1) == findViewWithTag) {
            return;
        }
        o();
        View inflate = LayoutInflater.from(this.f84813d).inflate(R.layout.gla, (ViewGroup) this, false);
        this.f84815f = inflate;
        inflate.setTag(obj);
        addView(this.f84815f, childCount);
    }

    private void i() {
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt instanceof RecyclerView) {
                this.f84814e = (RecyclerView) childAt;
                break;
            }
            i3++;
        }
        RecyclerView recyclerView = this.f84814e;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a());
            return;
        }
        throw new IllegalArgumentException("the child views must contain a recyclerView");
    }

    private void j() {
        AnimatorSet animatorSet = new AnimatorSet();
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f84815f.getLayoutParams();
        final int i3 = layoutParams.rightMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, this.f84816h);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.album.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FootRollBackScrollerView.this.l(i3, layoutParams, valueAnimator);
            }
        });
        ofInt.addListener(new b());
        final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f84814e.getLayoutParams();
        final int i16 = layoutParams2.leftMargin;
        if (i16 != this.f84818m) {
            final int min = Math.min(this.H, this.f84816h);
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0, min);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.album.view.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FootRollBackScrollerView.this.m(min, layoutParams2, i16, valueAnimator);
                }
            });
            animatorSet.play(ofInt2);
        }
        animatorSet.play(ofInt);
        animatorSet.addListener(new c());
        animatorSet.start();
        this.F = true;
    }

    private void k() {
        if (!this.E) {
            this.f84816h = this.f84815f.getMeasuredWidth();
            this.f84815f.setVisibility(8);
            this.E = true;
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.album.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    FootRollBackScrollerView.this.n();
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i3, LinearLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, (int) (i3 + (((-this.f84816h) - i3) * valueAnimator.getAnimatedFraction())), layoutParams.bottomMargin);
        this.f84815f.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i3, LinearLayout.LayoutParams layoutParams, int i16, ValueAnimator valueAnimator) {
        layoutParams.setMargins(i16 + ((int) (valueAnimator.getAnimatedFraction() * i3)), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f84814e.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f84818m = ((LinearLayout.LayoutParams) this.f84815f.getLayoutParams()).leftMargin;
        this.f84815f.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f84815f.getLayoutParams();
        int i3 = layoutParams.rightMargin;
        this.f84817i = i3;
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i3 - this.f84816h, layoutParams.bottomMargin);
        this.f84815f.setLayoutParams(layoutParams);
    }

    private void o() {
        View findViewWithTag = findViewWithTag(J);
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16 = this.C;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (!super.onInterceptTouchEvent(motionEvent) || !z16) {
                        return false;
                    }
                } else if (!this.D || motionEvent.getX() - this.I >= 0.0f || this.F || !z16) {
                    return false;
                }
            } else if (this.G == 0 || !z16) {
                return false;
            }
        } else {
            this.I = motionEvent.getX();
            if (this.G == 0 || !z16) {
                return false;
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.C) {
            k();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (!this.F && this.G == 1) {
                    j();
                }
                this.G = 0;
                return super.onTouchEvent(motionEvent);
            }
            int min = Math.min((int) Math.abs(motionEvent.getX() - this.I), this.f84816h);
            this.H = min;
            int i3 = min - this.f84816h;
            if (i3 <= this.f84817i) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f84815f.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i3, layoutParams.bottomMargin);
                this.f84815f.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f84814e.getLayoutParams();
                layoutParams2.setMargins(this.f84818m - this.H, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                this.f84814e.setLayoutParams(layoutParams2);
                this.G = 1;
            }
            return true;
        }
        this.G = 0;
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.C) {
            h();
            this.E = false;
        } else {
            o();
        }
    }

    public void setShowFootViewAble(boolean z16) {
        this.C = z16;
        if (z16) {
            h();
        } else {
            o();
        }
    }

    public FootRollBackScrollerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.I = 0.0f;
        this.f84813d = context;
    }

    public void setFootViewShowCallBack(d dVar) {
    }
}
