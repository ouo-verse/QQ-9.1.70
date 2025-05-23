package com.tencent.biz.qrcode.util.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BoxShadow extends FrameLayout {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    RectF f95068d;

    /* renamed from: e, reason: collision with root package name */
    Paint f95069e;

    /* renamed from: f, reason: collision with root package name */
    int f95070f;

    /* renamed from: h, reason: collision with root package name */
    int f95071h;

    /* renamed from: i, reason: collision with root package name */
    int f95072i;

    /* renamed from: m, reason: collision with root package name */
    private int f95073m;

    public BoxShadow(Context context) {
        super(context);
        this.f95069e = new Paint();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        RectF rectF = this.f95068d;
        if (rectF != null) {
            int i3 = this.f95071h;
            canvas.drawRoundRect(rectF, i3, i3, this.f95069e);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f95068d == null || this.f95073m != getMeasuredWidth() || this.C != getMeasuredHeight()) {
            int i19 = this.f95072i;
            this.f95068d = new RectF(i19, i19, getMeasuredWidth() - this.f95072i, getMeasuredHeight() - (this.f95072i * 1.15f));
            this.f95073m = getMeasuredWidth();
            this.C = getMeasuredHeight();
        }
    }

    public void setShadowColor(int i3) {
        if (this.f95070f != i3) {
            this.f95070f = i3;
            this.f95069e.setColor(i3);
        }
    }

    public BoxShadow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95069e = new Paint();
    }

    public BoxShadow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95069e = new Paint();
    }
}
