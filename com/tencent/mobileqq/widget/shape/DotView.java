package com.tencent.mobileqq.widget.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import jj2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DotView extends View {

    /* renamed from: d, reason: collision with root package name */
    private int f317422d;

    /* renamed from: e, reason: collision with root package name */
    private int f317423e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f317424f;

    public DotView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f317422d;
        canvas.drawCircle(i3, i3, i3, this.f317424f);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int i17 = this.f317422d * 2;
        setMeasuredDimension(i17, i17);
    }

    public void setColor(int i3) {
        this.f317423e = i3;
        this.f317424f.setColor(i3);
        invalidate();
    }

    public void setRadius(float f16) {
        this.f317422d = ViewUtils.dip2px(f16);
        requestLayout();
    }

    public DotView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317422d = 5;
        this.f317423e = -16777216;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f410008c1);
            this.f317422d = (int) obtainStyledAttributes.getDimension(b.f410032e1, this.f317422d);
            this.f317423e = obtainStyledAttributes.getColor(b.f410020d1, this.f317423e);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.f317424f = paint;
        paint.setColor(this.f317423e);
        this.f317424f.setFlags(1);
    }
}
