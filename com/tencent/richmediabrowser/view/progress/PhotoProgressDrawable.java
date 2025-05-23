package com.tencent.richmediabrowser.view.progress;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* loaded from: classes25.dex */
public class PhotoProgressDrawable extends Drawable {
    private int centerX;
    private int centerY;
    boolean inited;
    boolean isDrawText;
    Bitmap mBitmap;
    Matrix mMatrix;
    Paint mPaint;
    private int mProgress;
    String mProgressText;

    public PhotoProgressDrawable(Bitmap bitmap, int i3) {
        this(bitmap, i3, true);
    }

    public void disableDrawText() {
        this.isDrawText = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth() / 2;
        int height = this.mBitmap.getHeight() / 2;
        if (!this.inited) {
            this.mMatrix.reset();
            this.mMatrix.postTranslate(this.centerX - width, this.centerY - height);
            this.inited = true;
        }
        this.mMatrix.postRotate(5.0f, this.centerX, this.centerY);
        canvas.drawBitmap(this.mBitmap, this.mMatrix, null);
        if (this.isDrawText) {
            if (this.mProgress >= 10) {
                canvas.drawText(this.mProgressText, (float) (this.centerX - (width * 0.6d)), (float) (this.centerY + (height * 0.25d)), this.mPaint);
            } else {
                canvas.drawText(this.mProgressText, (float) (this.centerX - (width * 0.375d)), (float) (this.centerY + (height * 0.25d)), this.mPaint);
            }
        }
        canvas.restore();
        invalidateSelf();
    }

    public void enableDrawText() {
        this.isDrawText = true;
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
        this.mProgress = i16;
        this.mProgressText = this.mProgress + "%";
        return super.onLevelChange(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.centerX = rect.centerX();
        this.centerY = rect.centerY();
        this.inited = false;
        super.setBounds(rect);
    }

    public PhotoProgressDrawable(Bitmap bitmap, int i3, boolean z16) {
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.inited = false;
        this.mProgressText = "0%";
        this.isDrawText = true;
        this.mBitmap = bitmap;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(i3);
        this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.isDrawText = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
