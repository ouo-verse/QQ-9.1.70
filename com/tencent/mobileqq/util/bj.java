package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bj extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f306623a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f306624b = new TextPaint();

    /* renamed from: c, reason: collision with root package name */
    private Paint f306625c = new Paint(7);

    /* renamed from: d, reason: collision with root package name */
    private int f306626d;

    /* renamed from: e, reason: collision with root package name */
    private Context f306627e;

    /* renamed from: f, reason: collision with root package name */
    private String f306628f;

    public bj(Context context, String str) {
        this.f306627e = context;
        this.f306628f = str;
        this.f306623a = j.h(context.getResources(), R.drawable.day);
        this.f306624b.setAntiAlias(true);
        this.f306624b.setColor(-1);
        this.f306626d = Math.min(this.f306623a.getWidth(), this.f306623a.getHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int desiredWidth;
        Rect bounds = getBounds();
        this.f306624b.setTextSize((r2 / 2) * (bounds.width() / this.f306626d));
        Paint.FontMetrics fontMetrics = this.f306624b.getFontMetrics();
        canvas.drawBitmap(this.f306623a, 0.0f, 0.0f, this.f306625c);
        String str = this.f306628f;
        if (str != null) {
            if (str == null) {
                desiredWidth = 0;
            } else {
                desiredWidth = (int) Layout.getDesiredWidth(str, this.f306624b);
            }
            float f16 = fontMetrics.descent;
            int width = bounds.left + ((bounds.width() - desiredWidth) / 2);
            float height = bounds.top + (bounds.height() / 2.0f);
            float f17 = fontMetrics.bottom;
            float f18 = fontMetrics.top;
            canvas.drawText(this.f306628f, width, (int) ((height - ((f17 - f18) / 2.0f)) - f18), this.f306624b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f306623a.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f306623a.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f306625c.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f306625c.setColorFilter(colorFilter);
    }
}
