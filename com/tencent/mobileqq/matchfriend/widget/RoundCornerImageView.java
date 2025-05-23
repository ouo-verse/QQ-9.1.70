package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RoundCornerImageView extends URLImageView {
    private int C;
    private int D;
    private int E;
    private RectF F;
    private float[] G;
    private float H;

    /* renamed from: d, reason: collision with root package name */
    private Path f245663d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f245664e;

    /* renamed from: f, reason: collision with root package name */
    private int f245665f;

    /* renamed from: h, reason: collision with root package name */
    private int f245666h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f245667i;

    /* renamed from: m, reason: collision with root package name */
    private int f245668m;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f245663d == null) {
            this.f245663d = new Path();
        }
        this.f245663d.reset();
        this.F.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        this.f245663d.addRoundRect(this.F, this.G, Path.Direction.CW);
        this.f245663d.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f245663d);
        super.draw(canvas);
        if (this.f245667i) {
            this.f245664e.setColor(this.f245665f);
            this.f245664e.setStyle(Paint.Style.STROKE);
            this.f245664e.setAntiAlias(true);
            this.f245664e.setFilterBitmap(true);
            this.f245664e.setDither(true);
            int i3 = this.f245666h;
            if (i3 != 0) {
                this.f245664e.setStrokeWidth(i3);
            }
            RectF rectF = this.F;
            float f16 = this.H;
            canvas.drawRoundRect(rectF, f16, f16, this.f245664e);
        }
    }

    public void setBorder(boolean z16) {
        this.f245667i = z16;
    }

    public void setBorderWidth(int i3) {
        this.f245666h = i3;
    }

    public void setColor(int i3) {
        this.f245665f = i3;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245663d = new Path();
        this.f245664e = new Paint();
        this.f245665f = Color.parseColor("#FFD5D5D5");
        this.f245667i = false;
        this.f245668m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
        int i16 = this.f245668m;
        int i17 = this.C;
        int i18 = this.E;
        int i19 = this.D;
        this.G = new float[]{i16, i16, i17, i17, i18, i18, i19, i19};
        this.H = 0.0f;
        super.setLayerType(2, null);
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
        if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i18 >= 0) {
            this.f245668m = i3;
            this.C = i16;
            this.D = i17;
            this.E = i18;
            float[] fArr = this.G;
            float f16 = i3;
            fArr[0] = f16;
            fArr[1] = f16;
            float f17 = i16;
            fArr[2] = f17;
            fArr[3] = f17;
            float f18 = i18;
            fArr[4] = f18;
            fArr[5] = f18;
            float f19 = i17;
            fArr[6] = f19;
            fArr[7] = f19;
            this.H = (((i3 + i16) + i17) + i18) / 4;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }
}
