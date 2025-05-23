package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qqmini.minigame.R;

/* loaded from: classes23.dex */
public class CircularProgressView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f346743d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f346744e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f346745f;

    /* renamed from: h, reason: collision with root package name */
    private int[] f346746h;

    /* renamed from: i, reason: collision with root package name */
    private float f346747i;

    public CircularProgressView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f346745f, 0.0f, 360.0f, false, this.f346743d);
        canvas.drawArc(this.f346745f, 270.0f, (this.f346747i * 360.0f) / 1000.0f, false, this.f346744e);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        Paint paint;
        super.onMeasure(i3, i16);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (measuredWidth > measuredHeight) {
            i17 = measuredHeight;
        } else {
            i17 = measuredWidth;
        }
        float f16 = i17;
        if (this.f346743d.getStrokeWidth() > this.f346744e.getStrokeWidth()) {
            paint = this.f346743d;
        } else {
            paint = this.f346744e;
        }
        int strokeWidth = (int) (f16 - paint.getStrokeWidth());
        this.f346745f = new RectF(getPaddingLeft() + ((measuredWidth - strokeWidth) / 2), getPaddingTop() + ((measuredHeight - strokeWidth) / 2), r1 + strokeWidth, r5 + strokeWidth);
    }

    public void setProgress(float f16) {
        this.f346747i = f16;
        invalidate();
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularProgressView);
        Paint paint = new Paint();
        this.f346743d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f346743d.setStrokeCap(Paint.Cap.ROUND);
        this.f346743d.setAntiAlias(true);
        this.f346743d.setDither(true);
        this.f346743d.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CircularProgressView_backWidth, 5.0f));
        this.f346743d.setColor(obtainStyledAttributes.getColor(R.styleable.CircularProgressView_backColor, -3355444));
        Paint paint2 = new Paint();
        this.f346744e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f346744e.setStrokeCap(Paint.Cap.ROUND);
        this.f346744e.setAntiAlias(true);
        this.f346744e.setDither(true);
        this.f346744e.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CircularProgressView_progWidth, 10.0f));
        this.f346744e.setColor(obtainStyledAttributes.getColor(R.styleable.CircularProgressView_progColor, -16776961));
        int color = obtainStyledAttributes.getColor(R.styleable.CircularProgressView_progStartColor, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.CircularProgressView_progFirstColor, -1);
        if (color != -1 && color2 != -1) {
            this.f346746h = new int[]{color, color2};
        } else {
            this.f346746h = null;
        }
        this.f346747i = obtainStyledAttributes.getInteger(R.styleable.CircularProgressView_progress, 0);
        obtainStyledAttributes.recycle();
    }
}
