package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomDrawable1 extends AnimationDrawable {

    /* renamed from: d, reason: collision with root package name */
    private int f315598d;

    /* renamed from: e, reason: collision with root package name */
    private int f315599e;

    /* renamed from: f, reason: collision with root package name */
    private int f315600f;

    /* renamed from: h, reason: collision with root package name */
    private int f315601h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f315602i;

    private void a(int i3, Canvas canvas, Paint paint) {
        paint.setColor(16777215);
        paint.setAlpha((int) (b(1, i3) * 255.0f));
        canvas.drawRect(d(1, i3), paint);
        paint.setAlpha((int) (b(2, i3) * 255.0f));
        canvas.drawRect(d(2, i3), paint);
        paint.setAlpha((int) (b(3, i3) * 255.0f));
        canvas.drawRect(d(3, i3), paint);
        paint.setAlpha((int) (b(4, i3) * 255.0f));
        canvas.drawRect(d(4, i3), paint);
    }

    private float b(int i3, int i16) {
        if (i16 == i3) {
            return 0.9f;
        }
        if (i3 > 1) {
            return b(i3 - 1, i16) + 0.2f;
        }
        return 0.3f;
    }

    private Rect d(int i3, int i16) {
        int i17;
        int i18;
        if (i3 == i16) {
            i17 = this.f315598d;
        } else {
            i17 = this.f315600f;
        }
        if (i3 == i16) {
            i18 = this.f315599e;
        } else {
            i18 = this.f315601h;
        }
        int i19 = 0;
        if (i3 > 1) {
            this.f315602i.left = d(i3 - 1, i16).right + 5;
        } else {
            this.f315602i.left = 0;
        }
        Rect rect = this.f315602i;
        if (i3 != i16) {
            i19 = (this.f315599e - this.f315601h) / 2;
        }
        rect.top = i19;
        rect.right = rect.left + i17;
        rect.bottom = i19 + i18;
        return rect;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getNumberOfFrames() == 0) {
            Paint paint = new Paint();
            for (int i3 = 1; i3 <= 4; i3++) {
                Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                a(i3, new Canvas(createBitmap), paint);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
                addFrame(new BitmapDrawable(createBitmap), 200);
            }
        }
        super.draw(canvas);
        start();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f315599e;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f315598d + (this.f315600f * 3) + 15;
    }
}
