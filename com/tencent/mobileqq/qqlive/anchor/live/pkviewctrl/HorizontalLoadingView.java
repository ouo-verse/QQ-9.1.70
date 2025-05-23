package com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.HorizontalLoadingView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class HorizontalLoadingView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f270703d;

    /* renamed from: e, reason: collision with root package name */
    private View f270704e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f270705f;

    /* renamed from: h, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f270706h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalLoadingView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(FrameLayout.LayoutParams layoutParams) {
            HorizontalLoadingView horizontalLoadingView = HorizontalLoadingView.this;
            horizontalLoadingView.addView(horizontalLoadingView.f270704e, layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(ValueAnimator valueAnimator) {
            HorizontalLoadingView.this.f270704e.setTranslationX(-((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int measuredWidth = HorizontalLoadingView.this.getMeasuredWidth();
            int i3 = (measuredWidth * 40) / 710;
            if (HorizontalLoadingView.this.f270704e == null) {
                HorizontalLoadingView.this.f270704e = new View(HorizontalLoadingView.this.getContext());
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                HorizontalLoadingView.this.f270704e.setBackground(URLDrawable.getDrawable("https://dlied5v6.qq.com/now/qq-live/images/room_loading_bak.png", obtain));
                final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth + i3, -1);
                layoutParams.gravity = 3;
                HorizontalLoadingView.this.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        HorizontalLoadingView.a.this.c(layoutParams);
                    }
                });
            }
            if (HorizontalLoadingView.this.f270703d != null) {
                HorizontalLoadingView.this.f270703d.removeAllUpdateListeners();
                HorizontalLoadingView.this.f270703d.cancel();
            }
            HorizontalLoadingView.this.f270703d = ValueAnimator.ofFloat(0.0f, i3);
            HorizontalLoadingView.this.f270703d.setInterpolator(new LinearInterpolator());
            HorizontalLoadingView.this.f270703d.setRepeatMode(1);
            HorizontalLoadingView.this.f270703d.setRepeatCount(-1);
            HorizontalLoadingView.this.f270703d.setDuration(1000L);
            HorizontalLoadingView.this.f270703d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HorizontalLoadingView.a.this.d(valueAnimator);
                }
            });
            HorizontalLoadingView.this.f270703d.start();
            HorizontalLoadingView.this.f270705f = false;
            HorizontalLoadingView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public HorizontalLoadingView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f270705f = false;
        this.f270706h = new a();
        f();
    }

    private void f() {
        this.f270705f = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this.f270706h);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.f270703d;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f270703d.cancel();
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f270706h);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        ValueAnimator valueAnimator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (view == this && (valueAnimator = this.f270703d) != null) {
            if (i3 == 0) {
                if (!this.f270705f) {
                    getViewTreeObserver().addOnGlobalLayoutListener(this.f270706h);
                }
                this.f270703d.start();
                return;
            }
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        super.onWindowVisibilityChanged(i3);
        ValueAnimator valueAnimator = this.f270703d;
        if (valueAnimator == null) {
            return;
        }
        if (i3 == 0) {
            if (getVisibility() == 0) {
                this.f270703d.start();
                return;
            }
            return;
        }
        valueAnimator.cancel();
    }

    public HorizontalLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f270705f = false;
        this.f270706h = new a();
        f();
    }

    public HorizontalLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f270705f = false;
        this.f270706h = new a();
        f();
    }
}
