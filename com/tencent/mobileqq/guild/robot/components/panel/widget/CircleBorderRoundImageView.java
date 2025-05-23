package com.tencent.mobileqq.guild.robot.components.panel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.RoundImageView;
import up1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class CircleBorderRoundImageView extends RoundImageView {
    private final Context D;
    private int E;
    private int F;
    private int G;
    private int H;

    public CircleBorderRoundImageView(Context context) {
        super(context);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.D = context;
        d();
    }

    private void c(Canvas canvas, int i3, int i16) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(i16);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.E);
        canvas.drawCircle(this.F / 2, this.G / 2, i3, paint);
    }

    private void d() {
        this.E = 2;
        this.H = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.RoundImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.F == 0) {
            this.F = getWidth();
        }
        if (this.G == 0) {
            this.G = getHeight();
        }
        int min = Math.min(this.F, this.G) / 2;
        int i3 = this.E;
        c(canvas, (min - i3) + (i3 / 2), this.H);
    }

    public void setCustomAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.D.obtainStyledAttributes(attributeSet, a.f439527i0);
        this.E = obtainStyledAttributes.getDimensionPixelSize(a.f439553k0, 0);
        this.H = obtainStyledAttributes.getColor(a.f439540j0, -1);
        obtainStyledAttributes.recycle();
    }

    public CircleBorderRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.D = context;
        setCustomAttributes(attributeSet);
    }

    public CircleBorderRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.D = context;
        setCustomAttributes(attributeSet);
    }
}
