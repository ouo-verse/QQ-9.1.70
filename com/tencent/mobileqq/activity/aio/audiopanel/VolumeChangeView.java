package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VolumeChangeView extends View {
    private int C;
    private Paint D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;

    /* renamed from: d, reason: collision with root package name */
    private boolean f178297d;

    /* renamed from: e, reason: collision with root package name */
    private int f178298e;

    /* renamed from: f, reason: collision with root package name */
    private int f178299f;

    /* renamed from: h, reason: collision with root package name */
    private int f178300h;

    /* renamed from: i, reason: collision with root package name */
    private int f178301i;

    /* renamed from: m, reason: collision with root package name */
    public int[] f178302m;

    public VolumeChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178297d = true;
        this.f178298e = 0;
        this.f178299f = 0;
        this.f178300h = 0;
        this.f178301i = 0;
        this.C = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.E9);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        boolean z16 = false;
        if (typedArray.getInt(jj2.b.G9, 0) == 0) {
            z16 = true;
        }
        this.f178297d = z16;
        this.f178298e = typedArray.getInt(jj2.b.H9, 5);
        this.f178299f = (int) typedArray.getDimension(jj2.b.J9, 8.0f);
        this.f178300h = (int) typedArray.getDimension(jj2.b.I9, 48.0f);
        this.I = (int) typedArray.getDimension(jj2.b.K9, 0.0f);
        this.f178301i = getResources().getColor(R.color.skin_audio_panel_volumn_change_bg);
        this.G = getResources().getColor(R.color.skin_audio_panel_volumn_change);
        this.H = getResources().getDimensionPixelOffset(R.dimen.b2d);
        this.f178302m = new int[this.f178298e];
    }

    public void b() {
        if (this.f178302m != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f178302m;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = 0;
                i3++;
            }
            this.C = 0;
        }
        invalidate();
    }

    public void c(int i3) {
        this.F = i3;
        if (i3 < 1) {
            this.F = 1;
        }
        if (this.F > 10) {
            this.F = 10;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        for (int i16 = 0; i16 < this.f178298e; i16++) {
            float f16 = 0.0f;
            if (this.f178297d) {
                if (i16 < this.F) {
                    this.D.setColor(this.G);
                } else {
                    this.D.setColor(this.f178301i);
                }
                if (i16 != 0) {
                    i3 = (this.H + this.f178299f) * i16;
                    f16 = i3;
                    int i17 = this.E;
                    int i18 = this.f178300h;
                    RectF rectF = new RectF(f16, i17 - (i18 / 2), this.f178299f + f16, i17 + (i18 / 2));
                    float f17 = this.I;
                    canvas.drawRoundRect(rectF, f17, f17, this.D);
                } else {
                    int i172 = this.E;
                    int i182 = this.f178300h;
                    RectF rectF2 = new RectF(f16, i172 - (i182 / 2), this.f178299f + f16, i172 + (i182 / 2));
                    float f172 = this.I;
                    canvas.drawRoundRect(rectF2, f172, f172, this.D);
                }
            } else {
                if (i16 < this.F) {
                    this.D.setColor(this.G);
                } else {
                    this.D.setColor(this.f178301i);
                }
                int i19 = this.f178298e;
                if (i16 != i19 - 1) {
                    i3 = ((i19 - 1) - i16) * (this.H + this.f178299f);
                    f16 = i3;
                    int i1722 = this.E;
                    int i1822 = this.f178300h;
                    RectF rectF22 = new RectF(f16, i1722 - (i1822 / 2), this.f178299f + f16, i1722 + (i1822 / 2));
                    float f1722 = this.I;
                    canvas.drawRoundRect(rectF22, f1722, f1722, this.D);
                } else {
                    int i17222 = this.E;
                    int i18222 = this.f178300h;
                    RectF rectF222 = new RectF(f16, i17222 - (i18222 / 2), this.f178299f + f16, i17222 + (i18222 / 2));
                    float f17222 = this.I;
                    canvas.drawRoundRect(rectF222, f17222, f17222, this.D);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.f178298e;
        int i18 = this.f178299f;
        int i19 = this.H;
        setMeasuredDimension(((i17 * (i18 + i19)) - i19) + getPaddingLeft() + getPaddingRight(), this.f178300h + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.E = i16 / 2;
        if (this.D == null) {
            Paint paint = new Paint();
            this.D = paint;
            paint.setStyle(Paint.Style.FILL);
            this.D.setColor(this.f178301i);
        }
        invalidate();
    }

    public void setBgColor(int i3) {
        this.f178301i = i3;
    }

    public void setColor(int i3) {
        this.G = i3;
        Paint paint = this.D;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setCount(int i3) {
        this.f178298e = i3;
        this.f178302m = new int[i3];
        requestLayout();
    }

    public void setSquareWidth(int i3) {
        this.f178299f = i3;
    }
}
