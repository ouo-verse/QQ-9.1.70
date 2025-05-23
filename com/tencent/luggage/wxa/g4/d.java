package com.tencent.luggage.wxa.g4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f126421a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f126422b;

    /* renamed from: c, reason: collision with root package name */
    public c f126423c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f126424d;

    /* renamed from: e, reason: collision with root package name */
    public int f126425e;

    /* renamed from: f, reason: collision with root package name */
    public int f126426f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f126422b.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.f126422b.getLayoutParams();
            layoutParams.topMargin = d.this.f126423c.getRect().top;
            d.this.f126422b.setLayoutParams(layoutParams);
            d.this.f126422b.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.f126422b.getLayoutParams();
            layoutParams.topMargin = d.this.f126423c.getRect().top + ((int) ((d.this.f126426f - d.this.f126422b.getHeight()) * floatValue));
            d.this.f126422b.setLayoutParams(layoutParams);
        }
    }

    public d(Context context) {
        super(context);
        a();
    }

    public Rect getDecorRect() {
        return this.f126424d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f126421a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setDecorRect(Rect rect) {
        if (rect != null) {
            this.f126425e = rect.width();
            this.f126426f = rect.height();
            this.f126424d = new Rect(rect);
        }
        this.f126423c.setRect(this.f126424d);
        this.f126423c.postInvalidate();
    }

    public final void a() {
        this.f126425e = getContext().getResources().getDimensionPixelSize(R.dimen.dbz);
        this.f126426f = getContext().getResources().getDimensionPixelSize(R.dimen.dby);
        c cVar = new c(getContext());
        this.f126423c = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        b();
        setWillNotDraw(false);
        ImageView imageView = new ImageView(getContext());
        this.f126422b = imageView;
        addView(imageView, new FrameLayout.LayoutParams(this.f126425e, -2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f126422b.getLayoutParams();
        layoutParams.gravity = 1;
        this.f126422b.setLayoutParams(layoutParams);
        this.f126422b.setBackgroundResource(R.drawable.ond);
        this.f126422b.setVisibility(8);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(2600L);
        this.f126421a = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f126421a.addListener(new a());
        this.f126421a.addUpdateListener(new b());
        this.f126421a.setRepeatMode(1);
        this.f126421a.setRepeatCount(-1);
    }

    public final void b() {
        Point point = new Point();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getSize(point);
        int i3 = (point.x / 2) - (this.f126425e / 2);
        int i16 = (point.y / 2) - (this.f126426f / 2);
        Rect rect = new Rect(i3, i16, this.f126425e + i3, this.f126426f + i16);
        this.f126424d = rect;
        this.f126423c.setRect(rect);
    }
}
