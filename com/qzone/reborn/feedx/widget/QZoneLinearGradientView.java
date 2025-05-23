package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneLinearGradientView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f55937d;

    /* renamed from: e, reason: collision with root package name */
    private Shader f55938e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f55939f;

    /* renamed from: h, reason: collision with root package name */
    private float f55940h;

    public QZoneLinearGradientView(Context context) {
        super(context);
        this.f55937d = new Paint();
        this.f55938e = new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, Shader.TileMode.CLAMP);
        this.f55939f = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f55937d.setShader(this.f55938e);
        RectF rectF = this.f55939f;
        float f16 = this.f55940h;
        canvas.drawRoundRect(rectF, f16, f16, this.f55937d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f55939f = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setRadius(float f16) {
        this.f55940h = f16;
        requestLayout();
    }

    public void setShader(Shader shader) {
        this.f55938e = shader;
        requestLayout();
    }

    public QZoneLinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55937d = new Paint();
        this.f55938e = new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, Shader.TileMode.CLAMP);
        this.f55939f = new RectF();
    }
}
