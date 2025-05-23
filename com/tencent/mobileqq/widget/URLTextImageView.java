package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class URLTextImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    public String f316488d;

    /* renamed from: e, reason: collision with root package name */
    Paint f316489e;

    /* renamed from: f, reason: collision with root package name */
    int f316490f;

    /* renamed from: h, reason: collision with root package name */
    public int f316491h;

    /* renamed from: i, reason: collision with root package name */
    float f316492i;

    /* renamed from: m, reason: collision with root package name */
    int f316493m;

    public URLTextImageView(Context context) {
        super(context);
        this.f316491h = 0;
        this.f316492i = 0.0f;
        this.f316493m = R.color.f156970gg;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!TextUtils.isEmpty(this.f316488d)) {
            if (this.f316489e == null) {
                Paint paint = new Paint(1);
                this.f316489e = paint;
                paint.setColor(getContext().getResources().getColor(this.f316493m));
                this.f316489e.setTextAlign(Paint.Align.CENTER);
            }
            if (this.f316491h != this.f316489e.getTextSize()) {
                this.f316489e.setTextSize(this.f316491h);
                Paint.FontMetricsInt fontMetricsInt = this.f316489e.getFontMetricsInt();
                int height = getHeight() - fontMetricsInt.bottom;
                int i3 = fontMetricsInt.top;
                this.f316490f = ((height + i3) / 2) - i3;
            }
            int i16 = this.f316490f;
            float f16 = this.f316492i;
            if (f16 != 0.0f) {
                i16 = (int) (f16 * getHeight());
            }
            canvas.drawText(this.f316488d, getWidth() / 2, i16, this.f316489e);
        }
    }

    public void setTextColor(int i3) {
        this.f316493m = i3;
        Paint paint = this.f316489e;
        if (paint != null) {
            paint.setColor(getContext().getResources().getColor(this.f316493m));
        }
    }

    public void setTextSize(int i3) {
        this.f316491h = i3;
    }

    public void setTopPercent(float f16) {
        this.f316492i = f16;
    }

    public URLTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316491h = 0;
        this.f316492i = 0.0f;
        this.f316493m = R.color.f156970gg;
    }

    public URLTextImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316491h = 0;
        this.f316492i = 0.0f;
        this.f316493m = R.color.f156970gg;
    }
}
