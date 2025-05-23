package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.image.URLImageView;
import y91.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SquareImageView extends URLImageView {
    protected final RectF C;
    protected final Path D;
    private Paint E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private float f92084d;

    /* renamed from: e, reason: collision with root package name */
    private float f92085e;

    /* renamed from: f, reason: collision with root package name */
    private int f92086f;

    /* renamed from: h, reason: collision with root package name */
    private String f92087h;

    /* renamed from: i, reason: collision with root package name */
    private int f92088i;

    /* renamed from: m, reason: collision with root package name */
    protected int f92089m;

    public SquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92084d = 1.0f;
        this.f92085e = 0.0f;
        this.f92086f = -1;
        this.f92088i = 20;
        this.C = new RectF();
        this.D = new Path();
        this.E = new Paint();
        this.F = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f449790q9);
        this.f92084d = obtainStyledAttributes.getFloat(a.f449854v9, 1.0f);
        this.f92085e = obtainStyledAttributes.getFloat(a.f449866w9, 0.0f);
        this.f92086f = obtainStyledAttributes.getColor(a.f449803r9, -1);
        this.f92087h = obtainStyledAttributes.getString(a.f449816s9);
        this.f92088i = obtainStyledAttributes.getDimensionPixelSize(a.f449829t9, 40);
        this.f92089m = obtainStyledAttributes.getDimensionPixelSize(a.f449842u9, 0);
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f92089m != 0) {
            if (this.D.isEmpty()) {
                Path path = this.D;
                RectF rectF = this.C;
                int i3 = this.f92089m;
                path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated()) {
                setLayerType(2, null);
            }
            canvas.clipPath(this.D);
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.F;
        if (i3 != -1) {
            this.E.setColor(i3);
            this.E.setAntiAlias(false);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.E);
        }
        super.onDraw(canvas);
        if (this.f92086f != -1) {
            Paint paint = new Paint();
            paint.setColor(this.f92086f);
            RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            int i16 = this.f92089m;
            canvas.drawRoundRect(rectF, i16, i16, paint);
        }
        if (!TextUtils.isEmpty(this.f92087h)) {
            Paint paint2 = new Paint(1);
            paint2.setTextSize(this.f92088i);
            paint2.setColor(-1);
            paint2.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetricsInt fontMetricsInt = paint2.getFontMetricsInt();
            canvas.drawText(this.f92087h, getMeasuredWidth() / 2, ((getMeasuredHeight() - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2, paint2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.C.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i3);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((measuredWidth * 1.0f) / this.f92084d) + ((int) this.f92085e)), 1073741824));
    }

    public void setCircleBgColor(int i3) {
        this.F = i3;
        invalidate();
    }

    public void setFilterColor(int i3) {
        this.f92086f = i3;
        invalidate();
    }

    public void setFilterText(String str) {
        this.f92087h = str;
        requestLayout();
    }

    public void setFilterTextSize(int i3) {
        this.f92088i = i3;
        requestLayout();
    }

    public void setImageScale(float f16, float f17) {
        if (f16 > 0.0f) {
            this.f92084d = f16;
        }
        this.f92085e = f17;
        requestLayout();
    }

    public void setRoundRect(int i3) {
        if (i3 <= 0) {
            i3 = 0;
        }
        this.f92089m = i3;
        invalidate();
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareImageView(Context context) {
        this(context, null);
    }
}
