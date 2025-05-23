package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ChrysanthemumLoadingView extends View {
    private final int C;
    private final int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private ValueAnimator I;

    /* renamed from: d, reason: collision with root package name */
    private int f89611d;

    /* renamed from: e, reason: collision with root package name */
    private int f89612e;

    /* renamed from: f, reason: collision with root package name */
    private int f89613f;

    /* renamed from: h, reason: collision with root package name */
    private int f89614h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f89615i;

    /* renamed from: m, reason: collision with root package name */
    private final int f89616m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ChrysanthemumLoadingView.this.H = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ChrysanthemumLoadingView.this.invalidate();
        }
    }

    public ChrysanthemumLoadingView(Context context) {
        this(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.Z);
        this.F = obtainStyledAttributes.getColor(y91.a.f449579a0, DownloadCardView.COLOR_APP_VERSION);
        this.G = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449592b0, 20);
        this.E = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449605c0, 10);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f89615i = paint;
        paint.setAntiAlias(true);
        this.f89615i.setStrokeCap(Paint.Cap.ROUND);
        this.f89615i.setStyle(Paint.Style.STROKE);
        this.f89615i.setColor(this.F);
        this.f89615i.setStrokeWidth(this.E);
    }

    public void c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(12, 1);
        this.I = ofInt;
        ofInt.setDuration(1000L);
        this.I.setInterpolator(new LinearInterpolator());
        this.I.setRepeatCount(-1);
        this.I.setRepeatMode(1);
        this.I.addUpdateListener(new a());
        this.I.start();
    }

    public void d() {
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        this.I.end();
        this.I = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = 0;
        while (i3 < 12) {
            i3++;
            this.f89615i.setAlpha((((this.H + i3) % 12) * 255) / 12);
            int i16 = this.f89613f;
            canvas.drawLine(i16, this.f89614h - (this.G * 1.3f), i16, r2 - (r5 * 2), this.f89615i);
            canvas.rotate(30.0f, this.f89613f, this.f89614h);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f89611d = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i16);
        this.f89612e = size;
        this.f89613f = this.f89611d / 2;
        this.f89614h = size / 2;
    }

    public ChrysanthemumLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChrysanthemumLoadingView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f89616m = DownloadCardView.COLOR_APP_VERSION;
        this.C = 10;
        this.D = 20;
        this.E = 10;
        this.F = DownloadCardView.COLOR_APP_VERSION;
        this.G = 20;
        this.H = 1;
        b(context, attributeSet);
    }
}
