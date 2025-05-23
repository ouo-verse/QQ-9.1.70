package com.qzone.feed.ui.navigationbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneRedTouchTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    Paint f47402d;

    /* renamed from: e, reason: collision with root package name */
    int f47403e;

    /* renamed from: f, reason: collision with root package name */
    int f47404f;

    /* renamed from: h, reason: collision with root package name */
    int f47405h;

    /* renamed from: i, reason: collision with root package name */
    private String f47406i;

    public QZoneRedTouchTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47403e = ar.d(-7.0f);
        this.f47404f = ar.d(-7.0f);
        this.f47405h = ar.v(12.0f);
        e();
    }

    private float b() {
        Paint.FontMetrics fontMetrics = this.f47402d.getFontMetrics();
        Rect d16 = d();
        return (d16.top + (d16.height() / 2)) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f);
    }

    private void c(RectF rectF) {
        if (TextUtils.isEmpty(this.f47406i)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.f47402d.getFontMetrics();
        int length = this.f47406i.length();
        float[] fArr = new float[length];
        this.f47402d.getTextWidths(this.f47406i, fArr);
        float f16 = 0.0f;
        for (int i3 = 0; i3 < length; i3++) {
            f16 += fArr[i3];
        }
        rectF.left = 0.0f;
        rectF.right = f16 + 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = fontMetrics.bottom - fontMetrics.top;
    }

    private Rect d() {
        Rect rect = new Rect();
        if (!TextUtils.isEmpty(this.f47406i)) {
            RectF rectF = new RectF();
            c(rectF);
            rect.top = 0;
            rect.bottom = (int) (0 + rectF.height() + (ar.e(1.0f) * 2));
            rect.left = 0;
            rect.right = (int) (0 + rectF.width() + (ar.e(1.0f) * 2));
            if (rect.width() < rect.height()) {
                rect.right = rect.left + rect.height();
            }
        }
        return rect;
    }

    protected void a(Canvas canvas) {
        if (TextUtils.isEmpty(this.f47406i)) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.f162320bw4);
        Rect d16 = d();
        d16.offset(getWidth() - d16.width(), 0);
        drawable.setBounds(d16);
        drawable.draw(canvas);
        canvas.drawText(this.f47406i, d16.left + (d16.width() / 2), b(), this.f47402d);
    }

    void e() {
        Paint paint = new Paint(1);
        this.f47402d = paint;
        paint.setTextSize(this.f47405h);
        this.f47402d.setTextAlign(Paint.Align.CENTER);
        this.f47402d.setColor(-1);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (TextUtils.isEmpty(this.f47406i)) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int i17 = this.f47404f;
        if (i17 < 0) {
            measuredHeight -= i17;
        } else if (i17 > getMeasuredHeight()) {
            measuredHeight = this.f47404f;
        }
        Rect d16 = d();
        int measuredWidth = getMeasuredWidth();
        int width = this.f47403e + measuredWidth + d16.width();
        if (measuredWidth < width) {
            measuredWidth = width;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setMessage(String str) {
        this.f47406i = str;
        requestLayout();
    }

    public QZoneRedTouchTextView(Context context) {
        super(context);
        this.f47403e = ar.d(-7.0f);
        this.f47404f = ar.d(-7.0f);
        this.f47405h = ar.v(12.0f);
        e();
    }

    public QZoneRedTouchTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47403e = ar.d(-7.0f);
        this.f47404f = ar.d(-7.0f);
        this.f47405h = ar.v(12.0f);
        e();
    }
}
