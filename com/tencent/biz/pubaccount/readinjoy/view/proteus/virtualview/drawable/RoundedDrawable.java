package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RoundedDrawable extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "RoundedDrawable";
    private final Bitmap mBitmap;
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final RectF mBitmapRect;
    private final int mBitmapWidth;
    private ColorStateList mBorderColor;
    private final Paint mBorderPaint;
    private final RectF mBorderRect;
    private float mBorderWidth;
    private float mCornerRadius;
    private final boolean[] mCornersRounded;
    private boolean mOval;
    private boolean mRebuildShader;
    private ImageView.ScaleType mScaleType;
    private final Matrix mShaderMatrix;
    private final RectF mSquareCornersRect;
    private Shader.TileMode mTileModeX;
    private Shader.TileMode mTileModeY;
    private final RectF mBounds = new RectF();
    private final RectF mDrawableRect = new RectF();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedDrawable(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.mBitmapRect = rectF;
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mSquareCornersRect = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mTileModeX = tileMode;
        this.mTileModeY = tileMode;
        this.mRebuildShader = true;
        this.mCornerRadius = 0.0f;
        this.mCornersRounded = new boolean[]{true, true, true, true};
        this.mOval = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(-16777216);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mBitmap = bitmap;
        int width = bitmap.getWidth();
        this.mBitmapWidth = width;
        int height = bitmap.getHeight();
        this.mBitmapHeight = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.mBorderColor.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.mBorderWidth);
    }

    private static boolean all(boolean[] zArr) {
        for (boolean z16 : zArr) {
            if (z16) {
                return false;
            }
        }
        return true;
    }

    private static boolean any(boolean[] zArr) {
        for (boolean z16 : zArr) {
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            Log.w(TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static RoundedDrawable fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static RoundedDrawable fromDrawable(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof RoundedDrawable) {
                return (RoundedDrawable) drawable;
            }
            if (!(drawable instanceof LayerDrawable)) {
                if (!(drawable instanceof StateListDrawable)) {
                    Bitmap drawableToBitmap = drawableToBitmap(drawable);
                    if (drawableToBitmap != null) {
                        return new RoundedDrawable(drawableToBitmap);
                    }
                    return null;
                }
                throw new IllegalStateException("can not change StateListDrawable");
            }
            throw new IllegalStateException("can not change LayerDrawable");
        }
        return null;
    }

    private static boolean only(int i3, boolean[] zArr) {
        int length = zArr.length;
        int i16 = 0;
        while (true) {
            boolean z16 = true;
            if (i16 >= length) {
                return true;
            }
            boolean z17 = zArr[i16];
            if (i16 != i3) {
                z16 = false;
            }
            if (z17 != z16) {
                return false;
            }
            i16++;
        }
    }

    private void redrawBitmapForSquareCorners(Canvas canvas) {
        if (all(this.mCornersRounded) || this.mCornerRadius == 0.0f) {
            return;
        }
        RectF rectF = this.mDrawableRect;
        float f16 = rectF.left;
        float f17 = rectF.top;
        float width = rectF.width() + f16;
        float height = this.mDrawableRect.height() + f17;
        float f18 = this.mCornerRadius;
        if (!this.mCornersRounded[0]) {
            this.mSquareCornersRect.set(f16, f17, f16 + f18, f17 + f18);
            canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
        }
        if (!this.mCornersRounded[1]) {
            this.mSquareCornersRect.set(width - f18, f17, width, f18);
            canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
        }
        if (!this.mCornersRounded[2]) {
            this.mSquareCornersRect.set(width - f18, height - f18, width, height);
            canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
        }
        if (!this.mCornersRounded[3]) {
            this.mSquareCornersRect.set(f16, height - f18, f18 + f16, height);
            canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
        }
    }

    private void redrawBorderForSquareCorners(Canvas canvas) {
        float f16;
        if (all(this.mCornersRounded) || this.mCornerRadius == 0.0f) {
            return;
        }
        RectF rectF = this.mDrawableRect;
        float f17 = rectF.left;
        float f18 = rectF.top;
        float width = rectF.width() + f17;
        float height = f18 + this.mDrawableRect.height();
        float f19 = this.mCornerRadius;
        float f26 = this.mBorderWidth / 2.0f;
        if (!this.mCornersRounded[0]) {
            canvas.drawLine(f17 - f26, f18, f17 + f19, f18, this.mBorderPaint);
            canvas.drawLine(f17, f18 - f26, f17, f18 + f19, this.mBorderPaint);
        }
        if (!this.mCornersRounded[1]) {
            canvas.drawLine((width - f19) - f26, f18, width, f18, this.mBorderPaint);
            canvas.drawLine(width, f18 - f26, width, f18 + f19, this.mBorderPaint);
        }
        if (!this.mCornersRounded[2]) {
            f16 = f19;
            canvas.drawLine((width - f19) - f26, height, width + f26, height, this.mBorderPaint);
            canvas.drawLine(width, height - f16, width, height, this.mBorderPaint);
        } else {
            f16 = f19;
        }
        if (!this.mCornersRounded[3]) {
            canvas.drawLine(f17 - f26, height, f17 + f16, height, this.mBorderPaint);
            canvas.drawLine(f17, height - f16, f17, height, this.mBorderPaint);
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        float min;
        int i3 = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                this.mBorderRect.set(this.mBitmapRect);
                                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
                                this.mShaderMatrix.mapRect(this.mBorderRect);
                                RectF rectF = this.mBorderRect;
                                float f16 = this.mBorderWidth;
                                rectF.inset(f16 / 2.0f, f16 / 2.0f);
                                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                            } else {
                                this.mBorderRect.set(this.mBounds);
                                RectF rectF2 = this.mBorderRect;
                                float f17 = this.mBorderWidth;
                                rectF2.inset(f17 / 2.0f, f17 / 2.0f);
                                this.mShaderMatrix.reset();
                                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                            }
                        } else {
                            this.mBorderRect.set(this.mBitmapRect);
                            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
                            this.mShaderMatrix.mapRect(this.mBorderRect);
                            RectF rectF3 = this.mBorderRect;
                            float f18 = this.mBorderWidth;
                            rectF3.inset(f18 / 2.0f, f18 / 2.0f);
                            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.mBorderRect.set(this.mBitmapRect);
                        this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
                        this.mShaderMatrix.mapRect(this.mBorderRect);
                        RectF rectF4 = this.mBorderRect;
                        float f19 = this.mBorderWidth;
                        rectF4.inset(f19 / 2.0f, f19 / 2.0f);
                        this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                    }
                } else {
                    this.mShaderMatrix.reset();
                    if (this.mBitmapWidth <= this.mBounds.width() && this.mBitmapHeight <= this.mBounds.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.mBounds.width() / this.mBitmapWidth, this.mBounds.height() / this.mBitmapHeight);
                    }
                    float width2 = (int) (((this.mBounds.width() - (this.mBitmapWidth * min)) * 0.5f) + 0.5f);
                    float height2 = (int) (((this.mBounds.height() - (this.mBitmapHeight * min)) * 0.5f) + 0.5f);
                    this.mShaderMatrix.setScale(min, min);
                    this.mShaderMatrix.postTranslate(width2, height2);
                    this.mBorderRect.set(this.mBitmapRect);
                    this.mShaderMatrix.mapRect(this.mBorderRect);
                    RectF rectF5 = this.mBorderRect;
                    float f26 = this.mBorderWidth;
                    rectF5.inset(f26 / 2.0f, f26 / 2.0f);
                    this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
                }
            } else {
                this.mBorderRect.set(this.mBounds);
                RectF rectF6 = this.mBorderRect;
                float f27 = this.mBorderWidth;
                rectF6.inset(f27 / 2.0f, f27 / 2.0f);
                this.mShaderMatrix.reset();
                float f28 = 0.0f;
                if (this.mBitmapWidth * this.mBorderRect.height() > this.mBorderRect.width() * this.mBitmapHeight) {
                    width = this.mBorderRect.height() / this.mBitmapHeight;
                    height = 0.0f;
                    f28 = (this.mBorderRect.width() - (this.mBitmapWidth * width)) * 0.5f;
                } else {
                    width = this.mBorderRect.width() / this.mBitmapWidth;
                    height = (this.mBorderRect.height() - (this.mBitmapHeight * width)) * 0.5f;
                }
                this.mShaderMatrix.setScale(width, width);
                Matrix matrix = this.mShaderMatrix;
                float f29 = this.mBorderWidth;
                matrix.postTranslate(((int) (f28 + 0.5f)) + (f29 / 2.0f), ((int) (height + 0.5f)) + (f29 / 2.0f));
            }
        } else {
            this.mBorderRect.set(this.mBounds);
            RectF rectF7 = this.mBorderRect;
            float f36 = this.mBorderWidth;
            rectF7.inset(f36 / 2.0f, f36 / 2.0f);
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setTranslate((int) (((this.mBorderRect.width() - this.mBitmapWidth) * 0.5f) + 0.5f), (int) (((this.mBorderRect.height() - this.mBitmapHeight) * 0.5f) + 0.5f));
        }
        this.mDrawableRect.set(this.mBorderRect);
        this.mRebuildShader = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.mRebuildShader) {
            BitmapShader bitmapShader = new BitmapShader(this.mBitmap, this.mTileModeX, this.mTileModeY);
            Shader.TileMode tileMode = this.mTileModeX;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.mTileModeY == tileMode2) {
                bitmapShader.setLocalMatrix(this.mShaderMatrix);
            }
            this.mBitmapPaint.setShader(bitmapShader);
            this.mRebuildShader = false;
        }
        if (this.mOval) {
            if (this.mBorderWidth > 0.0f) {
                canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                canvas.drawOval(this.mBorderRect, this.mBorderPaint);
                return;
            } else {
                canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                return;
            }
        }
        if (any(this.mCornersRounded)) {
            float f16 = this.mCornerRadius;
            if (this.mBorderWidth > 0.0f) {
                canvas.drawRoundRect(this.mDrawableRect, f16, f16, this.mBitmapPaint);
                canvas.drawRoundRect(this.mBorderRect, f16, f16, this.mBorderPaint);
                redrawBitmapForSquareCorners(canvas);
                redrawBorderForSquareCorners(canvas);
                return;
            }
            canvas.drawRoundRect(this.mDrawableRect, f16, f16, this.mBitmapPaint);
            redrawBitmapForSquareCorners(canvas);
            return;
        }
        canvas.drawRect(this.mDrawableRect, this.mBitmapPaint);
        if (this.mBorderWidth > 0.0f) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mBitmapPaint.getAlpha();
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mBitmapPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Bitmap getSourceBitmap() {
        return this.mBitmap;
    }

    public Shader.TileMode getTileModeX() {
        return this.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        return this.mTileModeY;
    }

    public boolean isOval() {
        return this.mOval;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mBorderColor.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        updateShaderMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.mBorderColor.getColorForState(iArr, 0);
        if (this.mBorderPaint.getColor() != colorForState) {
            this.mBorderPaint.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    public RoundedDrawable radius(int i3) {
        setCornerRadius(i3);
        return this;
    }

    public RoundedDrawable scaleType(ImageView.ScaleType scaleType) {
        setScaleType(scaleType);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mBitmapPaint.setAlpha(i3);
        invalidateSelf();
    }

    public RoundedDrawable setBorderColor(@ColorInt int i3) {
        return setBorderColor(ColorStateList.valueOf(i3));
    }

    public RoundedDrawable setBorderWidth(float f16) {
        this.mBorderWidth = f16;
        this.mBorderPaint.setStrokeWidth(f16);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public RoundedDrawable setCornerRadius(float f16) {
        setCornerRadius(f16, f16, f16, f16);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mBitmapPaint.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mBitmapPaint.setFilterBitmap(z16);
        invalidateSelf();
    }

    public RoundedDrawable setOval(boolean z16) {
        this.mOval = z16;
        return this;
    }

    public RoundedDrawable setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            updateShaderMatrix();
        }
        return this;
    }

    public RoundedDrawable setTileModeX(Shader.TileMode tileMode) {
        if (this.mTileModeX != tileMode) {
            this.mTileModeX = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    public RoundedDrawable setTileModeY(Shader.TileMode tileMode) {
        if (this.mTileModeY != tileMode) {
            this.mTileModeY = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap toBitmap() {
        return drawableToBitmap(this);
    }

    public float getCornerRadius(int i3) {
        if (this.mCornersRounded[i3]) {
            return this.mCornerRadius;
        }
        return 0.0f;
    }

    public RoundedDrawable setBorderColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBorderColor = colorStateList;
        this.mBorderPaint.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public RoundedDrawable setCornerRadius(int i3, float f16) {
        if (f16 != 0.0f) {
            float f17 = this.mCornerRadius;
            if (f17 != 0.0f && f17 != f16) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (f16 == 0.0f) {
            if (only(i3, this.mCornersRounded)) {
                this.mCornerRadius = 0.0f;
            }
            this.mCornersRounded[i3] = false;
        } else {
            if (this.mCornerRadius == 0.0f) {
                this.mCornerRadius = f16;
            }
            this.mCornersRounded[i3] = true;
        }
        return this;
    }

    public RoundedDrawable setCornerRadius(float f16, float f17, float f18, float f19) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f16));
        hashSet.add(Float.valueOf(f17));
        hashSet.add(Float.valueOf(f18));
        hashSet.add(Float.valueOf(f19));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.mCornerRadius = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.mCornerRadius = 0.0f;
            }
            boolean[] zArr = this.mCornersRounded;
            zArr[0] = f16 > 0.0f;
            zArr[1] = f17 > 0.0f;
            zArr[2] = f18 > 0.0f;
            zArr[3] = f19 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }
}
