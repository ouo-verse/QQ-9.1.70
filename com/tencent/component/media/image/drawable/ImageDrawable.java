package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.component.media.image.BitmapReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private BitmapReference mBitmap;
    private int mHeight;
    private ImageState mImageState;
    private boolean mMutated;
    private int mOriginalHeight;
    private int mOriginalWidth;
    private int mTargetDensity;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ImageState extends Drawable.ConstantState {
        BitmapReference mBitmap;
        int mChangingConfigurations;
        int mClipHeight;
        int mClipWidth;
        Paint mPaint;
        int mTargetDensity;

        ImageState(BitmapReference bitmapReference, int i3, int i16) {
            this.mTargetDensity = 160;
            this.mBitmap = bitmapReference;
            this.mClipWidth = i3;
            this.mClipHeight = i16;
            this.mPaint = new Paint(6);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ImageDrawable(this, (Resources) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ImageDrawable(this, resources);
        }

        ImageState(ImageState imageState) {
            this(imageState.mBitmap, imageState.mClipWidth, imageState.mClipHeight);
            this.mChangingConfigurations = imageState.mChangingConfigurations;
            this.mTargetDensity = imageState.mTargetDensity;
            this.mPaint = new Paint(imageState.mPaint);
        }
    }

    private void computeBitmapSize() {
        int scaledWidth;
        int scaledHeight;
        Bitmap bitmap = this.mBitmap.getBitmap();
        if (bitmap == null) {
            this.mHeight = -1;
            this.mWidth = -1;
            return;
        }
        int i3 = this.mTargetDensity;
        if (i3 == 0) {
            scaledWidth = bitmap.getWidth();
        } else {
            scaledWidth = bitmap.getScaledWidth(i3);
        }
        if (i3 == 0) {
            scaledHeight = bitmap.getHeight();
        } else {
            scaledHeight = bitmap.getScaledHeight(i3);
        }
        long computeProperSize = computeProperSize(scaledWidth, scaledHeight);
        this.mWidth = extractRangeStartFromLong(computeProperSize);
        this.mHeight = extractRangeEndFromLong(computeProperSize);
    }

    protected static long computeProperScale(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        float f19 = 1.0f;
        if (i17 <= 0 && i18 <= 0) {
            f18 = 1.0f;
        } else {
            if (i17 * i16 > i18 * i3) {
                f16 = i17;
                f17 = i3;
            } else {
                f16 = i18;
                f17 = i16;
            }
            f18 = f16 / f17;
        }
        if (f18 >= 1.0f) {
            f19 = f18;
        }
        return packRangeInLong((int) (i3 * f19), (int) (i16 * f19));
    }

    protected static int extractRangeEndFromLong(long j3) {
        return (int) (j3 & 4294967295L);
    }

    protected static int extractRangeStartFromLong(long j3) {
        return (int) (j3 >>> 32);
    }

    protected static long packRangeInLong(int i3, int i16) {
        return i16 | (i3 << 32);
    }

    protected final long computeProperSize(int i3, int i16) {
        ImageState imageState = this.mImageState;
        return computeProperScale(i3, i16, imageState.mClipWidth, imageState.mClipHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference != null) {
            bitmap = bitmapReference.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), this.mImageState.mPaint);
        }
    }

    public Bitmap getBitmap() {
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference != null) {
            return bitmapReference.getBitmap();
        }
        return null;
    }

    public int getBitmapHeight() {
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference == null) {
            return -1;
        }
        return bitmapReference.getHeight();
    }

    public BitmapReference getBitmapRef() {
        return this.mBitmap;
    }

    public int getBitmapWidth() {
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference == null) {
            return -1;
        }
        return bitmapReference.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mImageState.mChangingConfigurations;
    }

    public int getClipHeight() {
        return this.mImageState.mClipHeight;
    }

    public int getClipWidth() {
        return this.mImageState.mClipWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.mImageState.mChangingConfigurations = getChangingConfigurations();
        return this.mImageState;
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
        BitmapReference bitmapReference = this.mBitmap;
        if (bitmapReference != null && !bitmapReference.hasAlpha() && this.mImageState.mPaint.getAlpha() >= 255) {
            return -1;
        }
        return -3;
    }

    public int getOriginalHeight() {
        int i3 = this.mOriginalHeight;
        if (i3 <= 0) {
            return getIntrinsicHeight();
        }
        return i3;
    }

    public int getOriginalWidth() {
        int i3 = this.mOriginalWidth;
        if (i3 <= 0) {
            return getIntrinsicWidth();
        }
        return i3;
    }

    public final Paint getPaint() {
        return this.mImageState.mPaint;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mImageState = new ImageState(this.mImageState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    public void resize(int i3, int i16) {
        ImageState imageState = this.mImageState;
        if (imageState.mClipWidth != i3 || imageState.mClipHeight != i16) {
            imageState.mClipWidth = i3;
            imageState.mClipHeight = i16;
            computeBitmapSize();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mImageState.mPaint.getAlpha()) {
            this.mImageState.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z16) {
        this.mImageState.mPaint.setAntiAlias(z16);
        invalidateSelf();
    }

    protected final void setBitmapInternal(BitmapReference bitmapReference) {
        setBitmapInternal(bitmapReference, true);
    }

    public void setBitmapRef(BitmapReference bitmapReference) {
        setBitmapInternal(bitmapReference);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mImageState.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mImageState.mPaint.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mImageState.mPaint.setFilterBitmap(z16);
        invalidateSelf();
    }

    public void setOriginalHeight(int i3) {
        this.mOriginalHeight = i3;
    }

    public void setOriginalWidth(int i3) {
        this.mOriginalWidth = i3;
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public ImageDrawable(BitmapReference bitmapReference) {
        this(null, bitmapReference, -1, -1);
    }

    protected final void setBitmapInternal(BitmapReference bitmapReference, boolean z16) {
        if (bitmapReference != this.mBitmap) {
            this.mBitmap = bitmapReference;
            computeBitmapSize();
            if (z16) {
                invalidateSelf();
            }
        }
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public ImageDrawable(Resources resources, BitmapReference bitmapReference) {
        this(resources, bitmapReference, -1, -1);
    }

    public void setTargetDensity(int i3) {
        if (this.mTargetDensity != i3) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    public ImageDrawable(BitmapReference bitmapReference, int i3, int i16) {
        this(null, bitmapReference, i3, i16);
    }

    public ImageDrawable(Resources resources, BitmapReference bitmapReference, int i3, int i16) {
        this.mWidth = -1;
        this.mHeight = -1;
        this.mImageState = new ImageState(bitmapReference, i3, i16);
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        setBitmapInternal(bitmapReference);
    }

    ImageDrawable(ImageState imageState, Resources resources) {
        this.mWidth = -1;
        this.mHeight = -1;
        this.mImageState = new ImageState(imageState);
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else if (imageState != null) {
            this.mTargetDensity = imageState.mTargetDensity;
        }
        setBitmapInternal(imageState != null ? imageState.mBitmap : null);
    }
}
