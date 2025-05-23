package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    protected final int cornerRadius;
    protected final int margin;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RoundedDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final int margin;
        protected final Paint paint;

        public RoundedDrawable(Bitmap bitmap, int i3, int i16) {
            this.cornerRadius = i3;
            this.margin = i16;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.bitmapShader = bitmapShader;
            float f16 = i16;
            this.mBitmapRect = new RectF(f16, f16, bitmap.getWidth() - i16, bitmap.getHeight() - i16);
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            paint.setDither(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f16 = this.cornerRadius;
            canvas.drawRoundRect(rectF, f16, f16, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i3 = this.margin;
            rectF.set(i3, i3, rect.width() - this.margin, rect.height() - this.margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
            this.paint.setAlpha(i3);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public RoundedBitmapDisplayer(int i3) {
        this(i3, 0);
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new RoundedDrawable(bitmap, this.cornerRadius, this.margin));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public RoundedBitmapDisplayer(int i3, int i16) {
        this.cornerRadius = i3;
        this.margin = i16;
    }
}
