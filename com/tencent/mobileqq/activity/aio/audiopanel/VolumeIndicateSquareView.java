package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VolumeIndicateSquareView extends View {
    private Paint C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f178303d;

    /* renamed from: e, reason: collision with root package name */
    private int f178304e;

    /* renamed from: f, reason: collision with root package name */
    private int f178305f;

    /* renamed from: h, reason: collision with root package name */
    private int f178306h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f178307i;

    /* renamed from: m, reason: collision with root package name */
    private int f178308m;

    public VolumeIndicateSquareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178303d = true;
        this.f178304e = 0;
        this.f178305f = 0;
        this.f178306h = 0;
        this.f178308m = 0;
        this.D = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.E9);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (this.C == null) {
            Paint paint = new Paint();
            this.C = paint;
            paint.setStyle(Paint.Style.FILL);
            this.C.setColor(this.f178306h);
        }
    }

    private void a(TypedArray typedArray) {
        boolean z16 = false;
        if (typedArray.getInt(jj2.b.G9, 0) == 0) {
            z16 = true;
        }
        this.f178303d = z16;
        this.f178304e = typedArray.getInt(jj2.b.H9, 5);
        this.f178305f = (int) typedArray.getDimension(jj2.b.J9, 8.0f);
        this.f178306h = typedArray.getColor(jj2.b.F9, -16776961);
        this.f178307i = new int[this.f178304e];
    }

    public void b() {
        if (this.f178307i != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f178307i;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = 0;
                i3++;
            }
            this.f178308m = 0;
        }
        invalidate();
    }

    public void c(int i3) {
        int[] iArr = this.f178307i;
        int i16 = this.f178308m;
        iArr[i16] = i3;
        int i17 = i16 + 1;
        this.f178308m = i17;
        if (i17 >= this.f178304e) {
            this.f178308m = 0;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        super.onDraw(canvas);
        int i3 = this.f178308m - 1;
        int i16 = 0;
        while (true) {
            int i17 = this.f178304e;
            if (i16 < i17) {
                if (i3 < 0) {
                    i3 = i17 - 1;
                }
                float f17 = this.f178307i[i3];
                if (f17 < 1.0f) {
                    f17 = 1.0f;
                }
                if (f17 > 8.0f) {
                    f17 = 8.0f;
                }
                int i18 = this.f178305f;
                float f18 = (f17 / 2.0f) * i18;
                if (this.f178303d) {
                    f16 = i16 * 2.0f * i18;
                } else {
                    f16 = (((i17 - 1) - i16) * 2.0f * i18) + i18;
                }
                float f19 = f16;
                int i19 = this.D;
                canvas.drawRect(f19, i19 - f18, f19 + i18, i19 + f18, this.C);
                i3--;
                i16++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.f178304e * 2;
        int i18 = this.f178305f;
        setMeasuredDimension((i17 * i18) + getPaddingLeft() + getPaddingRight(), (i18 * 8) + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.D = i16 / 2;
        invalidate();
    }

    public void setColor(int i3) {
        this.f178306h = i3;
        Paint paint = this.C;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setCount(int i3) {
        this.f178304e = i3;
        this.f178307i = new int[i3];
        requestLayout();
    }

    public void setSquareWidth(int i3) {
        this.f178305f = i3;
    }
}
