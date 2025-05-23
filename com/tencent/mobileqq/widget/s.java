package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class s extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private int f317257b;

    /* renamed from: f, reason: collision with root package name */
    private int f317261f;

    /* renamed from: k, reason: collision with root package name */
    private ValueAnimator f317266k;

    /* renamed from: c, reason: collision with root package name */
    private int f317258c = -872415232;

    /* renamed from: d, reason: collision with root package name */
    private int f317259d = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f317262g = Color.argb(255, 137, 208, 67);

    /* renamed from: h, reason: collision with root package name */
    public int f317263h = Color.argb(255, 255, 66, 34);

    /* renamed from: i, reason: collision with root package name */
    private int f317264i = Color.argb(127, 255, 255, 255);

    /* renamed from: j, reason: collision with root package name */
    private int f317265j = -1;

    /* renamed from: a, reason: collision with root package name */
    private Paint f317256a = new Paint();

    /* renamed from: e, reason: collision with root package name */
    private PorterDuffXfermode f317260e = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s.this.f317265j = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            s.this.invalidateSelf();
        }
    }

    private void b(int i3) {
        ValueAnimator valueAnimator = this.f317266k;
        if (valueAnimator != null && valueAnimator.isRunning() && i3 == 7) {
            this.f317266k.cancel();
        }
    }

    private void d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.f317266k = ofInt;
        ofInt.addUpdateListener(new a());
        this.f317266k.setDuration(3000L);
        this.f317266k.setInterpolator(new LinearInterpolator());
        this.f317266k.start();
    }

    public void c(int i3) {
        if (this.f317261f != i3) {
            this.f317261f = i3;
            if (i3 == 6) {
                d();
                return;
            }
            b(i3);
            this.f317265j = -1;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f317257b;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
