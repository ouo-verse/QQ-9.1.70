package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;

/* loaded from: classes20.dex */
public class ImageProgressCircle extends View {
    private int C;
    boolean D;
    String E;
    private int F;
    boolean G;

    /* renamed from: d, reason: collision with root package name */
    boolean f315726d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f315727e;

    /* renamed from: f, reason: collision with root package name */
    Matrix f315728f;

    /* renamed from: h, reason: collision with root package name */
    Paint f315729h;

    /* renamed from: i, reason: collision with root package name */
    private int f315730i;

    /* renamed from: m, reason: collision with root package name */
    private int f315731m;

    public ImageProgressCircle(Context context) {
        super(context);
        this.f315726d = true;
        this.f315728f = new Matrix();
        this.f315729h = new Paint();
        this.D = false;
        this.E = "";
        this.G = true;
        b(context);
    }

    private void b(Context context) {
        try {
            this.f315727e = BitmapFactory.decodeResource(context.getResources(), R.drawable.nox);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        int i3 = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.f315729h.setAntiAlias(true);
        this.f315729h.setColor(-1);
        this.f315729h.setTextSize(i3);
        this.f315729h.setTypeface(Typeface.DEFAULT_BOLD);
        this.G = true;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f159006tp);
        this.C = dimensionPixelSize;
        this.f315730i = dimensionPixelSize / 2;
        this.f315731m = dimensionPixelSize / 2;
    }

    public String a() {
        return this.E;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f315726d && this.f315727e != null) {
            canvas.save();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            int width = this.f315727e.getWidth() / 2;
            int height = this.f315727e.getHeight() / 2;
            if (!this.D) {
                this.f315728f.reset();
                this.f315728f.postTranslate(this.f315730i - width, this.f315731m - height);
                this.D = true;
            }
            this.f315728f.postRotate(5.0f, this.f315730i, this.f315731m);
            canvas.drawBitmap(this.f315727e, this.f315728f, null);
            if (this.G) {
                if (this.F >= 10) {
                    canvas.drawText(this.E, (float) (this.f315730i - (width * 0.66d)), (float) (this.f315731m + (height * 0.25d)), this.f315729h);
                } else {
                    canvas.drawText(this.E, (float) (this.f315730i - (width * 0.25d)), (float) (this.f315731m + (height * 0.25d)), this.f315729h);
                }
            }
            canvas.restore();
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (i17 - i3 == 0) {
            int i19 = this.C;
            layout(i3 - (i19 / 2), i16, i17 + (i19 / 2), i18);
        } else if (i18 - i16 == 0) {
            int i26 = this.C;
            layout(i3, i16 - (i26 / 2), i17, i18 + (i26 / 2));
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
        }
    }

    public void setProgress(int i3) {
        if (i3 >= 100) {
            this.f315726d = false;
        }
        int i16 = (i3 * 100) / 85;
        if (i16 > 99) {
            i16 = 99;
        }
        this.F = i16;
        this.E = this.F + "%";
        postInvalidate();
    }

    public ImageProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315726d = true;
        this.f315728f = new Matrix();
        this.f315729h = new Paint();
        this.D = false;
        this.E = "";
        this.G = true;
        b(context);
    }

    public ImageProgressCircle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315726d = true;
        this.f315728f = new Matrix();
        this.f315729h = new Paint();
        this.D = false;
        this.E = "";
        this.G = true;
        b(context);
    }
}
