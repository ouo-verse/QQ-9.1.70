package com.tencent.av.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArcBackGroundTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private float f74719d;

    /* renamed from: e, reason: collision with root package name */
    private float f74720e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f74721f;

    /* renamed from: h, reason: collision with root package name */
    private Path f74722h;

    public ArcBackGroundTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(this.f74722h, this.f74721f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int round = Math.round(this.f74720e);
        int round2 = (int) Math.round(Math.sqrt(Math.pow(this.f74719d, 2.0d) - Math.pow(this.f74719d - round, 2.0d)) * 2.0d);
        setMeasuredDimension(round2, round);
        for (float f16 = 0.0f; f16 < round2; f16 = (float) (f16 + 0.2d)) {
            this.f74722h.lineTo(f16, ((float) (Math.sqrt(Math.pow(this.f74719d, 2.0d) - Math.pow(f16 - (round2 / 2), 2.0d)) - round)) + 5);
        }
        this.f74722h.close();
    }

    public ArcBackGroundTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcBackGroundTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f74721f = paint;
        paint.setColor(1711276032);
        this.f74721f.setStyle(Paint.Style.FILL);
        this.f74722h = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ArcBackGroundTextView, 0, 0);
        this.f74719d = obtainStyledAttributes.getDimension(R.styleable.ArcBackGroundTextView_circleRadius, 0.0f);
        this.f74720e = obtainStyledAttributes.getDimension(R.styleable.ArcBackGroundTextView_arcHeight, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
