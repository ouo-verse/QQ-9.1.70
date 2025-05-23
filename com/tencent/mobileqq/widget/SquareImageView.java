package com.tencent.mobileqq.widget;

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

/* compiled from: P */
/* loaded from: classes20.dex */
public class SquareImageView extends URLImageView {
    protected final RectF C;
    protected final Path D;
    private Paint E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private float f316305d;

    /* renamed from: e, reason: collision with root package name */
    private float f316306e;

    /* renamed from: f, reason: collision with root package name */
    private int f316307f;

    /* renamed from: h, reason: collision with root package name */
    private String f316308h;

    /* renamed from: i, reason: collision with root package name */
    private int f316309i;

    /* renamed from: m, reason: collision with root package name */
    protected int f316310m;

    public SquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316305d = 1.0f;
        this.f316306e = 0.0f;
        this.f316307f = -1;
        this.f316309i = 20;
        this.C = new RectF();
        this.D = new Path();
        this.E = new Paint();
        this.F = -1;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f316310m != 0) {
            if (this.D.isEmpty()) {
                Path path = this.D;
                RectF rectF = this.C;
                int i3 = this.f316310m;
                path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
            }
            canvas.clipPath(this.D);
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3 = this.F;
        if (i3 != -1) {
            this.E.setColor(i3);
            this.E.setAntiAlias(false);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.E);
        }
        super.onDraw(canvas);
        if (this.f316307f != -1) {
            Paint paint = new Paint();
            paint.setColor(this.f316307f);
            RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            int i16 = this.f316310m;
            canvas.drawRoundRect(rectF, i16, i16, paint);
        }
        if (!TextUtils.isEmpty(this.f316308h)) {
            Paint paint2 = new Paint(1);
            paint2.setTextSize(this.f316309i);
            paint2.setColor(-1);
            paint2.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetricsInt fontMetricsInt = paint2.getFontMetricsInt();
            canvas.drawText(this.f316308h, getMeasuredWidth() / 2, ((getMeasuredHeight() - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2, paint2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.C.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i3);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((measuredWidth * 1.0f) / this.f316305d) + ((int) this.f316306e)), 1073741824));
    }

    public void setCircleBgColor(int i3) {
        this.F = i3;
        invalidate();
    }

    public void setFilterColor(int i3) {
        this.f316307f = i3;
        invalidate();
    }

    public void setFilterText(String str) {
        this.f316308h = str;
        requestLayout();
    }

    public void setFilterTextSize(int i3) {
        this.f316309i = i3;
        requestLayout();
    }

    public void setImageScale(float f16, float f17) {
        if (f16 > 0.0f) {
            this.f316305d = f16;
        }
        this.f316306e = f17;
        requestLayout();
    }

    public void setRoundRect(int i3) {
        if (i3 <= 0) {
            i3 = 0;
        }
        this.f316310m = i3;
        invalidate();
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316305d = 1.0f;
        this.f316306e = 0.0f;
        this.f316307f = -1;
        this.f316309i = 20;
        this.C = new RectF();
        this.D = new Path();
        this.E = new Paint();
        this.F = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.V7);
        this.f316305d = obtainStyledAttributes.getFloat(jj2.b.f409991a8, 1.0f);
        this.f316306e = obtainStyledAttributes.getFloat(jj2.b.f410003b8, 0.0f);
        this.f316307f = obtainStyledAttributes.getColor(jj2.b.W7, -1);
        this.f316308h = obtainStyledAttributes.getString(jj2.b.X7);
        this.f316309i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.Y7, 40);
        this.f316310m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.Z7, 0);
        obtainStyledAttributes.recycle();
    }

    public SquareImageView(Context context) {
        super(context);
        this.f316305d = 1.0f;
        this.f316306e = 0.0f;
        this.f316307f = -1;
        this.f316309i = 20;
        this.C = new RectF();
        this.D = new Path();
        this.E = new Paint();
        this.F = -1;
    }
}
