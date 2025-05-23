package com.tencent.mobileqq.wink.picker.qcircle.sticker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes21.dex */
public class RouteTraceView extends View {
    private static float F = 10.0f;
    private float C;
    private float D;
    private ValueAnimator E;

    /* renamed from: d, reason: collision with root package name */
    private Path f325111d;

    /* renamed from: e, reason: collision with root package name */
    private float f325112e;

    /* renamed from: f, reason: collision with root package name */
    private float f325113f;

    /* renamed from: h, reason: collision with root package name */
    private PathMeasure f325114h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f325115i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f325116m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RouteTraceView.this.f325112e = ((Float) valueAnimator.getAnimatedValue()).floatValue() * RouteTraceView.this.D;
            RouteTraceView routeTraceView = RouteTraceView.this;
            routeTraceView.f325113f = Math.max(routeTraceView.f325112e - RouteTraceView.this.C, 0.0f);
            RouteTraceView.this.invalidate();
        }
    }

    public RouteTraceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f325111d = new Path();
        this.f325116m = null;
        g();
    }

    private void f() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cancelViewAnimation mValueAnimator is null ");
        if (this.E == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        w53.b.a("RouteTraceView", sb5.toString());
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.E.removeAllUpdateListeners();
            this.E = null;
        }
    }

    private void g() {
        Paint paint = new Paint(1);
        this.f325115i = paint;
        paint.setColor(Color.parseColor("#FF00BAFF"));
        this.f325115i.setStyle(Paint.Style.STROKE);
        this.f325115i.setStrokeWidth(F);
    }

    public void h() {
        if (this.f325116m == null) {
            return;
        }
        RectF rectF = this.f325116m;
        float f16 = rectF.left;
        float f17 = rectF.top;
        this.f325115i.setShader(new LinearGradient(f16, f17, rectF.right, f17, Color.parseColor("#FF00BAFF"), Color.parseColor("#FF0099FF"), Shader.TileMode.CLAMP));
        Path path = new Path();
        RectF rectF2 = this.f325116m;
        path.moveTo(rectF2.left, rectF2.top);
        RectF rectF3 = this.f325116m;
        path.lineTo(rectF3.right, rectF3.top);
        RectF rectF4 = this.f325116m;
        path.lineTo(rectF4.right, rectF4.bottom);
        RectF rectF5 = this.f325116m;
        path.lineTo(rectF5.left, rectF5.bottom);
        RectF rectF6 = this.f325116m;
        path.lineTo(rectF6.left, rectF6.top);
        PathMeasure pathMeasure = new PathMeasure();
        this.f325114h = pathMeasure;
        pathMeasure.setPath(path, false);
        this.D = this.f325114h.getLength();
        RectF rectF7 = this.f325116m;
        this.C = rectF7.right - rectF7.left;
        f();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.E = ofFloat;
        ofFloat.setDuration(2000L);
        this.E.setRepeatMode(1);
        this.E.setRepeatCount(-1);
        this.E.addUpdateListener(new a());
        this.E.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f325116m == null) {
            return;
        }
        this.f325111d.reset();
        this.f325114h.getSegment(this.f325113f, this.f325112e, this.f325111d, true);
        canvas.drawPath(this.f325111d, this.f325115i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        h();
    }

    public void setAttachRect(RectF rectF) {
        float f16 = rectF.left;
        float f17 = F;
        this.f325116m = new RectF(f16 + (f17 / 2.0f), rectF.top + (f17 / 2.0f), rectF.right - (f17 / 2.0f), rectF.bottom - (f17 / 2.0f));
    }
}
