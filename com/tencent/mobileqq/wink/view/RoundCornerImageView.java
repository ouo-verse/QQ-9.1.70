package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class RoundCornerImageView extends PressDarkImageView {
    private Paint C;
    private int D;
    private int E;
    private boolean F;
    private int G;

    /* renamed from: m, reason: collision with root package name */
    private Path f326837m;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f326837m == null) {
            this.f326837m = new Path();
        }
        this.f326837m.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        int i3 = this.G;
        if (i3 <= 0) {
            i3 = width / 30;
        }
        float f16 = i3;
        this.f326837m.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        this.f326837m.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f326837m);
        super.draw(canvas);
        if (this.F) {
            this.C.setColor(this.D);
            int i16 = this.E;
            if (i16 != 0) {
                this.C.setStrokeWidth(i16);
            }
            this.f326837m.reset();
            this.f326837m.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
            canvas.drawRoundRect(rectF, f16, f16, this.C);
        }
    }

    public void setBorder(boolean z16) {
        this.F = z16;
    }

    public void setBorderWidth(int i3) {
        this.E = i3;
    }

    public void setColor(int i3) {
        this.D = i3;
    }

    public void setCorner(int i3) {
        if (i3 > 0) {
            this.G = i3;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f326837m = new Path();
        this.C = new Paint();
        int parseColor = Color.parseColor("#FFD5D5D5");
        this.D = parseColor;
        this.F = false;
        this.G = 0;
        this.C.setColor(parseColor);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setAntiAlias(true);
        this.C.setFilterBitmap(true);
        super.setLayerType(2, null);
    }
}
