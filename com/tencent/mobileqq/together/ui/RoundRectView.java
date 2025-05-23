package com.tencent.mobileqq.together.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RoundRectView extends PressEffectImageView {

    /* renamed from: e, reason: collision with root package name */
    private int f293381e;

    /* renamed from: f, reason: collision with root package name */
    private int f293382f;

    /* renamed from: h, reason: collision with root package name */
    private int f293383h;

    /* renamed from: i, reason: collision with root package name */
    private int f293384i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f293385m;

    public RoundRectView(Context context) {
        super(context);
        this.f293384i = 0;
        a();
    }

    private void a() {
        this.f293385m = new Paint();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0.0f, 0.0f, this.f293382f, this.f293383h);
        this.f293385m.setColor(this.f293384i);
        int i3 = this.f293381e;
        canvas.drawRoundRect(rectF, i3, i3, this.f293385m);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f293382f && height == this.f293383h) {
            return;
        }
        this.f293382f = width;
        this.f293383h = height;
    }

    public void setAllRadius(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f293381e == i3) {
            return;
        }
        this.f293381e = i3;
        invalidate();
    }

    public void setBgColor(int i3) {
        if (this.f293384i == i3) {
            return;
        }
        this.f293384i = i3;
        invalidate();
    }

    public RoundRectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f293384i = 0;
        a();
    }
}
