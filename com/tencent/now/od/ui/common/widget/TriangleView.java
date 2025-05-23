package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TriangleView extends View {

    /* renamed from: d, reason: collision with root package name */
    private final int f338541d;

    /* renamed from: e, reason: collision with root package name */
    private int f338542e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f338543f;

    /* renamed from: h, reason: collision with root package name */
    private Path f338544h;

    /* renamed from: i, reason: collision with root package name */
    private int f338545i;

    public TriangleView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        Paint paint = new Paint(1);
        this.f338543f = paint;
        paint.setColor(this.f338542e);
        this.f338544h = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, tn3.a.Z, i3, 0);
        setColor(obtainStyledAttributes.getColor(tn3.a.f436671b0, -1));
        setDirection(obtainStyledAttributes.getInteger(tn3.a.f436661a0, 4));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f338544h.rewind();
        int i3 = this.f338545i;
        if (i3 == 2) {
            this.f338544h.moveTo(0.0f, 0.0f);
            this.f338544h.lineTo(getWidth(), getHeight() >> 1);
            this.f338544h.lineTo(0.0f, getHeight());
        } else if (i3 == 1) {
            this.f338544h.moveTo(0.0f, getHeight() >> 1);
            this.f338544h.lineTo(getWidth(), 0.0f);
            this.f338544h.lineTo(getWidth(), getHeight());
        } else if (i3 == 3) {
            this.f338544h.moveTo(0.0f, getHeight());
            this.f338544h.lineTo(getWidth() >> 1, 0.0f);
            this.f338544h.lineTo(getWidth(), getHeight());
        } else {
            this.f338544h.moveTo(0.0f, 0.0f);
            this.f338544h.lineTo(getWidth(), 0.0f);
            this.f338544h.lineTo(getWidth() >> 1, getHeight());
        }
        this.f338544h.close();
        canvas.drawPath(this.f338544h, this.f338543f);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        int i17 = this.f338541d;
        int i18 = (i17 * 2) / 3;
        if (mode != 1073741824 && (mode != Integer.MIN_VALUE || i17 <= size)) {
            size = i17;
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                if (i17 <= size2) {
                    size2 = i17;
                }
            } else {
                size2 = i18;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setColor(int i3) {
        if (this.f338542e != i3) {
            this.f338542e = i3;
            this.f338543f.setColor(i3);
            invalidate();
        }
    }

    public void setDirection(int i3) {
        if (this.f338545i != i3) {
            this.f338545i = i3;
            invalidate();
        }
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338542e = -1;
        this.f338545i = 4;
        this.f338541d = ((int) context.getResources().getDisplayMetrics().density) * 20;
        a(context, attributeSet, i3);
    }
}
