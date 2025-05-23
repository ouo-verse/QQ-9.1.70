package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ag extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f316603a;

    /* renamed from: b, reason: collision with root package name */
    Matrix f316604b;

    /* renamed from: c, reason: collision with root package name */
    Paint f316605c;

    /* renamed from: d, reason: collision with root package name */
    private int f316606d;

    /* renamed from: e, reason: collision with root package name */
    private int f316607e;

    /* renamed from: f, reason: collision with root package name */
    boolean f316608f;

    /* renamed from: g, reason: collision with root package name */
    String f316609g;

    /* renamed from: h, reason: collision with root package name */
    private int f316610h;

    /* renamed from: i, reason: collision with root package name */
    boolean f316611i;

    public ag(Bitmap bitmap, int i3) {
        this(bitmap, i3, true);
    }

    public void a() {
        this.f316611i = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Bitmap bitmap = this.f316603a;
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth() / 2;
        int height = this.f316603a.getHeight() / 2;
        if (!this.f316608f) {
            this.f316604b.reset();
            this.f316604b.postTranslate(this.f316606d - width, this.f316607e - height);
            this.f316608f = true;
        }
        this.f316604b.postRotate(5.0f, this.f316606d, this.f316607e);
        canvas.drawBitmap(this.f316603a, this.f316604b, null);
        if (this.f316611i) {
            if (this.f316610h >= 10) {
                canvas.drawText(this.f316609g, (float) (this.f316606d - (width * 0.6d)), (float) (this.f316607e + (height * 0.25d)), this.f316605c);
            } else {
                canvas.drawText(this.f316609g, (float) (this.f316606d - (width * 0.375d)), (float) (this.f316607e + (height * 0.25d)), this.f316605c);
            }
        }
        canvas.restore();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        int i16 = i3 / 85;
        if (i16 > 99) {
            i16 = 99;
        }
        this.f316610h = i16;
        this.f316609g = this.f316610h + "%";
        return super.onLevelChange(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f316606d = rect.centerX();
        this.f316607e = rect.centerY();
        this.f316608f = false;
        super.setBounds(rect);
    }

    public ag(Bitmap bitmap, int i3, boolean z16) {
        this.f316604b = new Matrix();
        Paint paint = new Paint();
        this.f316605c = paint;
        this.f316608f = false;
        this.f316609g = "0%";
        this.f316611i = true;
        this.f316603a = bitmap;
        paint.setAntiAlias(true);
        this.f316605c.setColor(-1);
        this.f316605c.setTextSize(i3);
        this.f316605c.setTypeface(Typeface.DEFAULT_BOLD);
        this.f316611i = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
