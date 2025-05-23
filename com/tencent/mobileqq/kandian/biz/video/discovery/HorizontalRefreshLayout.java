package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HorizontalRefreshLayout extends FrameLayout {
    private int C;
    private float D;
    private float E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private View f239631d;

    /* renamed from: e, reason: collision with root package name */
    private View f239632e;

    /* renamed from: f, reason: collision with root package name */
    private int f239633f;

    /* renamed from: h, reason: collision with root package name */
    private int f239634h;

    /* renamed from: i, reason: collision with root package name */
    private int f239635i;

    /* renamed from: m, reason: collision with root package name */
    private int f239636m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HorizontalRefreshLayout.this.D = 0.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface c {
    }

    public HorizontalRefreshLayout(Context context) {
        super(context);
        this.D = 0.0f;
        this.F = x.c(getContext(), 25.0f);
    }

    private void c() {
        if (this.f239631d == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.f239632e)) {
                    this.f239631d = childAt;
                    return;
                }
            }
        }
    }

    private void d() {
        View view = this.f239631d;
        if (view == null || this.f239632e == null) {
            return;
        }
        view.animate().translationX(0.0f).setDuration(500L).setListener(new a()).start();
        this.f239632e.animate().translationX(this.f239633f).setDuration(500L).start();
    }

    public boolean b() {
        return ViewCompat.canScrollHorizontally(this.f239631d, 1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f239635i = x16;
            this.C = x16;
            this.f239636m = y16;
            if (x16 > this.F) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (action != 2) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            int i3 = x16 - this.f239635i;
            int i16 = y16 - this.f239636m;
            this.f239635i = x16;
            this.C = x16;
            if (Math.abs(i3) >= Math.abs(i16)) {
                if (this.f239632e != null && i3 < 0 && !b()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f239631d == null) {
            c();
            if (this.f239631d == null) {
                return;
            }
        }
        View view = this.f239632e;
        if (view != null) {
            view.setTranslationX(this.f239633f);
        }
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        View view = this.f239632e;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            this.f239633f = measuredWidth;
            this.f239634h = measuredWidth;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r1 != 3) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i3 = x16 - this.C;
                    this.C = x16;
                    float abs = this.D + (i3 * (1.0f - Math.abs(this.D / this.f239634h)));
                    this.D = abs;
                    if (abs >= 0.0f) {
                        this.D = 0.0f;
                        this.f239631d.setTranslationX(0.0f);
                    } else {
                        int i16 = this.f239634h;
                        if (abs <= (-i16)) {
                            float f16 = -i16;
                            this.D = f16;
                            this.f239631d.setTranslationX(f16);
                            this.f239632e.setTranslationX(this.f239633f + this.D);
                        } else {
                            this.f239631d.setTranslationX(abs);
                            this.f239632e.setTranslationX(this.f239633f + this.D);
                            this.E = Math.abs(this.D / this.f239633f);
                        }
                    }
                    return false;
                }
            }
            this.f239635i = 0;
            this.C = 0;
            d();
        } else {
            this.C = x16;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRefreshHeader(c cVar) {
        throw null;
    }

    public HorizontalRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0.0f;
        this.F = x.c(getContext(), 25.0f);
    }

    public HorizontalRefreshLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 0.0f;
        this.F = x.c(getContext(), 25.0f);
    }

    public void setOnDraggingListener(b bVar) {
    }
}
