package com.tencent.component.media.image.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SliceBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private static final int SLICE_SIZE = 2048;
    private BitmapState mBitmapState;
    private int mHeight;
    private boolean mMutated;
    private int mTargetDensity;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class BitmapState extends Drawable.ConstantState {
        int mChangingConfigurations;
        Paint mPaint;
        SliceBitmap mSliceBitmap;
        int mTargetDensity;

        BitmapState(Bitmap bitmap) {
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = new SliceBitmap(bitmap);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new SliceBitmapDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new SliceBitmapDrawable(this, resources);
        }

        BitmapState(SliceBitmap sliceBitmap) {
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = sliceBitmap;
        }

        BitmapState(BitmapState bitmapState) {
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = bitmapState.mSliceBitmap;
            this.mChangingConfigurations = bitmapState.mChangingConfigurations;
            this.mTargetDensity = bitmapState.mTargetDensity;
            this.mPaint = new Paint(bitmapState.mPaint);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SliceBitmap {
        public static final int DENSITY_NONE = 0;
        public static final int SLICE_SIZE = 2048;
        boolean hasAlpha;
        Bitmap[] mBitmaps;
        int mChangingConfigurations;
        int mColumnCount;
        int mDensity;
        int mHeight;
        int mRowCount;
        int mWidth;

        public SliceBitmap(Bitmap bitmap) {
            int i3;
            int i16;
            if (needSlice(bitmap)) {
                this.mWidth = bitmap.getWidth();
                this.mHeight = bitmap.getHeight();
                this.mDensity = bitmap.getDensity();
                this.hasAlpha = bitmap.hasAlpha();
                int i17 = ((this.mWidth + 2048) - 1) / 2048;
                this.mRowCount = i17;
                int i18 = ((this.mHeight + 2048) - 1) / 2048;
                this.mColumnCount = i18;
                Bitmap[] bitmapArr = new Bitmap[i17 * i18];
                int i19 = 0;
                for (int i26 = 0; i26 < this.mRowCount; i26++) {
                    for (int i27 = 0; i27 < this.mColumnCount; i27++) {
                        int i28 = i26 * 2048;
                        int i29 = i27 * 2048;
                        int i36 = i28 + 2048;
                        int i37 = this.mWidth;
                        if (i36 > i37) {
                            i3 = i37 - i28;
                        } else {
                            i3 = 2048;
                        }
                        int i38 = i29 + 2048;
                        int i39 = this.mHeight;
                        if (i38 > i39) {
                            i16 = i39 - i29;
                        } else {
                            i16 = 2048;
                        }
                        bitmapArr[i19] = Bitmap.createBitmap(bitmap, i28, i29, i3, i16);
                        i19++;
                    }
                }
                this.mBitmaps = bitmapArr;
                return;
            }
            throw new IllegalArgumentException("the bitmap no need to Slice");
        }

        @SuppressLint({"NewApi"})
        public static int getBitmapSize(Bitmap bitmap) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getByteCount();
        }

        public static boolean needSlice(Bitmap bitmap) {
            if (bitmap.getWidth() <= 2048 && bitmap.getHeight() <= 2048) {
                return false;
            }
            return true;
        }

        public static int scaleFromDensity(int i3, int i16, int i17) {
            if (i16 != 0 && i16 != i17) {
                return ((i3 * i17) + (i16 >> 1)) / i16;
            }
            return i3;
        }

        @TargetApi(11)
        void draw(Canvas canvas, Rect rect, Paint paint) {
            int save = canvas.save();
            boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
            int density = canvas.getDensity();
            canvas.translate(rect.left, rect.top);
            if (rect.width() != this.mWidth || rect.height() != this.mHeight) {
                canvas.scale(rect.width() / this.mWidth, rect.height() / this.mHeight);
            }
            if (!isHardwareAccelerated) {
                canvas.setDensity(this.mDensity);
            }
            int i3 = 0;
            for (int i16 = 0; i16 < this.mRowCount; i16++) {
                for (int i17 = 0; i17 < this.mColumnCount; i17++) {
                    Bitmap bitmap = this.mBitmaps[i3];
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, i16 * 2048, i17 * 2048, paint);
                    }
                    i3++;
                }
            }
            if (!isHardwareAccelerated) {
                canvas.setDensity(density);
            }
            canvas.restoreToCount(save);
        }

        public Bitmap getBitmap(int i3) {
            Bitmap[] bitmapArr = this.mBitmaps;
            if (bitmapArr != null && bitmapArr.length > i3) {
                return bitmapArr[i3];
            }
            return null;
        }

        public final int getByteCount() {
            int i3 = 0;
            for (Bitmap bitmap : this.mBitmaps) {
                i3 += getBitmapSize(bitmap);
            }
            return i3;
        }

        public int getColumnCount() {
            return this.mColumnCount;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public int getRowCount() {
            return this.mRowCount;
        }

        public int getScaledHeight(Canvas canvas) {
            return scaleFromDensity(getHeight(), this.mDensity, canvas.getDensity());
        }

        public int getScaledWidth(Canvas canvas) {
            return scaleFromDensity(getWidth(), this.mDensity, canvas.getDensity());
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final boolean hasAlpha() {
            return this.hasAlpha;
        }

        public void recyle() {
            for (Bitmap bitmap : this.mBitmaps) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }

        public int getScaledHeight(DisplayMetrics displayMetrics) {
            return scaleFromDensity(getHeight(), this.mDensity, displayMetrics.densityDpi);
        }

        public int getScaledWidth(DisplayMetrics displayMetrics) {
            return scaleFromDensity(getWidth(), this.mDensity, displayMetrics.densityDpi);
        }

        public int getScaledHeight(int i3) {
            return scaleFromDensity(getHeight(), this.mDensity, i3);
        }

        public int getScaledWidth(int i3) {
            return scaleFromDensity(getWidth(), this.mDensity, i3);
        }
    }

    private void computeBitmapSize() {
        this.mWidth = this.mBitmapState.mSliceBitmap.getScaledWidth(this.mTargetDensity);
        this.mHeight = this.mBitmapState.mSliceBitmap.getScaledHeight(this.mTargetDensity);
    }

    public static boolean needSlice(Bitmap bitmap) {
        if (bitmap.getWidth() <= 2048 && bitmap.getHeight() <= 2048) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        BitmapState bitmapState = this.mBitmapState;
        bitmapState.mSliceBitmap.draw(canvas, bounds, bitmapState.mPaint);
    }

    public Bitmap getBitmap(int i3) {
        return this.mBitmapState.mSliceBitmap.getBitmap(i3);
    }

    public int getByteCount() {
        return this.mBitmapState.mSliceBitmap.getByteCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
    }

    public int getColumnCount() {
        return this.mBitmapState.mSliceBitmap.getColumnCount();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return this.mBitmapState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        BitmapState bitmapState = this.mBitmapState;
        if (!bitmapState.mSliceBitmap.hasAlpha && bitmapState.mPaint.getAlpha() >= 255) {
            return -1;
        }
        return -3;
    }

    public final Paint getPaint() {
        return this.mBitmapState.mPaint;
    }

    public int getRowCount() {
        return this.mBitmapState.mSliceBitmap.getRowCount();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mBitmapState = new BitmapState(this.mBitmapState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mBitmapState.mPaint.getAlpha()) {
            this.mBitmapState.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z16) {
        this.mBitmapState.mPaint.setAntiAlias(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapState.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mBitmapState.mPaint.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mBitmapState.mPaint.setFilterBitmap(z16);
        invalidateSelf();
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public SliceBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(new BitmapState(bitmap), resources);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i3) {
        if (this.mTargetDensity != i3) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            computeBitmapSize();
            invalidateSelf();
        }
    }

    public SliceBitmapDrawable(Resources resources, SliceBitmap sliceBitmap) {
        this(new BitmapState(sliceBitmap), resources);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }

    SliceBitmapDrawable(BitmapState bitmapState, Resources resources) {
        this.mBitmapState = bitmapState;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = bitmapState.mTargetDensity;
        }
        computeBitmapSize();
    }
}
