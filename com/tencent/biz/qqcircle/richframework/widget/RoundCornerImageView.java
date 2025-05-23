package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundCornerImageView extends PressDarkImageView {
    private int C;
    private int D;
    private boolean E;
    private int F;

    /* renamed from: i, reason: collision with root package name */
    private Path f92073i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f92074m;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f92073i == null) {
            this.f92073i = new Path();
        }
        this.f92073i.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        int i3 = this.F;
        if (i3 <= 0) {
            i3 = width / 30;
        }
        float f16 = i3;
        this.f92073i.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        this.f92073i.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f92073i);
        super.draw(canvas);
        if (this.E) {
            this.f92074m.setColor(this.C);
            int i16 = this.D;
            if (i16 != 0) {
                this.f92074m.setStrokeWidth(i16);
            }
            this.f92073i.reset();
            this.f92073i.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
            canvas.drawRoundRect(rectF, f16, f16, this.f92074m);
        }
    }

    public void setBorder(boolean z16) {
        this.E = z16;
    }

    public void setBorderWidth(int i3) {
        this.D = i3;
    }

    public void setColor(int i3) {
        this.C = i3;
    }

    public void setCorner(int i3) {
        if (i3 > 0) {
            this.F = i3;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92073i = new Path();
        this.f92074m = new Paint();
        int parseColor = Color.parseColor("#FFD5D5D5");
        this.C = parseColor;
        this.E = false;
        this.F = 0;
        this.f92074m.setColor(parseColor);
        this.f92074m.setStyle(Paint.Style.STROKE);
        this.f92074m.setAntiAlias(true);
        this.f92074m.setFilterBitmap(true);
        super.setLayerType(2, null);
    }
}
