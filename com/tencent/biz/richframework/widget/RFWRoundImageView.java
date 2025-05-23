package com.tencent.biz.richframework.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.ui.res.R$styleable;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class RFWRoundImageView extends ImageView {
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private final Paint mBitmapPaint;
    protected int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    protected int mBorderWidth;
    private int mCircleBackgroundColor;
    private final Paint mCircleBackgroundPaint;
    private ColorFilter mColorFilter;
    float[] mCornersRadius;
    private boolean mDisableCircularTransformation;
    private boolean mDrawableDirty;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private boolean mEnableClearBitmapCanvasWhenDirty;
    private int mImageAlpha;
    private boolean mInitialized;
    private boolean mIsCircle;
    private boolean mRebuildShader;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final Path mTempPath = new Path();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(api = 21)
    /* loaded from: classes5.dex */
    public class OutlineProvider extends ViewOutlineProvider {
        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (RFWRoundImageView.this.mDisableCircularTransformation) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            RFWRoundImageView.this.mBorderRect.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public RFWRoundImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = 255;
        this.mEnableClearBitmapCanvasWhenDirty = false;
        this.mCornersRadius = new float[8];
        this.mIsCircle = true;
        init();
    }

    private RectF calculateBounds() {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - min) / 2.0f);
        float f16 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f16, f16 + paddingTop);
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private boolean inTouchableArea(float f16, float f17) {
        if (this.mBorderRect.isEmpty() || Math.pow(f16 - this.mBorderRect.centerX(), 2.0d) + Math.pow(f17 - this.mBorderRect.centerY(), 2.0d) <= Math.pow(this.mBorderRadius, 2.0d)) {
            return true;
        }
        return false;
    }

    private void init() {
        this.mInitialized = true;
        super.setScaleType(SCALE_TYPE);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setDither(true);
        this.mBitmapPaint.setFilterBitmap(true);
        this.mBitmapPaint.setAlpha(this.mImageAlpha);
        this.mBitmapPaint.setColorFilter(this.mColorFilter);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mCircleBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mCircleBackgroundPaint.setAntiAlias(true);
        this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
        setOutlineProvider(new OutlineProvider());
    }

    private void initializeBitmap() {
        Bitmap bitmapFromDrawable = getBitmapFromDrawable(getDrawable());
        this.mBitmap = bitmapFromDrawable;
        if (bitmapFromDrawable != null && bitmapFromDrawable.isMutable()) {
            this.mBitmapCanvas = new Canvas(this.mBitmap);
        } else {
            this.mBitmapCanvas = null;
        }
        if (!this.mInitialized) {
            return;
        }
        if (this.mBitmap != null) {
            updateShaderMatrix();
        } else {
            this.mBitmapPaint.setShader(null);
        }
    }

    private void updateDimensions() {
        int i3;
        this.mBorderRect.set(calculateBounds());
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        this.mDrawableRect.set(this.mBorderRect);
        if (!this.mBorderOverlay && (i3 = this.mBorderWidth) > 0) {
            this.mDrawableRect.inset(i3 - 1.0f, i3 - 1.0f);
        }
        this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        updateShaderMatrix();
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        if (this.mBitmap == null) {
            return;
        }
        this.mShaderMatrix.set(null);
        int height2 = this.mBitmap.getHeight();
        float width2 = this.mBitmap.getWidth();
        float f16 = height2;
        float f17 = 0.0f;
        if (this.mDrawableRect.height() * width2 > this.mDrawableRect.width() * f16) {
            width = this.mDrawableRect.height() / f16;
            float width3 = (this.mDrawableRect.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
            f17 = width3;
        } else {
            width = this.mDrawableRect.width() / width2;
            height = (this.mDrawableRect.height() - (f16 * width)) * 0.5f;
        }
        this.mShaderMatrix.setScale(width, width);
        Matrix matrix = this.mShaderMatrix;
        float f18 = (int) (f17 + 0.5f);
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(f18 + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.mRebuildShader = true;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.mImageAlpha;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        this.mDrawableDirty = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    protected void onDraw(Canvas canvas) {
        if (this.mDisableCircularTransformation) {
            super.onDraw(canvas);
            return;
        }
        if (this.mCircleBackgroundColor != 0) {
            canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mCircleBackgroundPaint);
        }
        if (this.mBitmap != null) {
            if (this.mDrawableDirty && this.mBitmapCanvas != null) {
                this.mDrawableDirty = false;
                Drawable drawable = getDrawable();
                drawable.setBounds(0, 0, this.mBitmapCanvas.getWidth(), this.mBitmapCanvas.getHeight());
                if (this.mEnableClearBitmapCanvasWhenDirty && drawable.getOpacity() != -1 && !(drawable instanceof BitmapDrawable)) {
                    this.mBitmapCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                drawable.draw(this.mBitmapCanvas);
            }
            if (this.mRebuildShader) {
                this.mRebuildShader = false;
                Bitmap bitmap = this.mBitmap;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                bitmapShader.setLocalMatrix(this.mShaderMatrix);
                this.mBitmapPaint.setShader(bitmapShader);
            }
            if (this.mIsCircle) {
                canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
            } else {
                Path path = mTempPath;
                path.reset();
                path.addRoundRect(this.mDrawableRect, this.mCornersRadius, Path.Direction.CW);
                canvas.drawPath(path, this.mBitmapPaint);
            }
        }
        if (this.mBorderWidth > 0) {
            canvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDisableCircularTransformation) {
            return super.onTouchEvent(motionEvent);
        }
        if (inTouchableArea(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        if (!z16) {
        } else {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i3) {
        if (i3 == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i3;
        this.mBorderPaint.setColor(i3);
        invalidate();
    }

    public void setBorderOverlay(boolean z16) {
        if (z16 == this.mBorderOverlay) {
            return;
        }
        this.mBorderOverlay = z16;
        updateDimensions();
        invalidate();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i3;
        this.mBorderPaint.setStrokeWidth(i3);
        updateDimensions();
        invalidate();
    }

    public void setBottomLeftRadius(int i3) {
        if (this.mIsCircle) {
            return;
        }
        float[] fArr = this.mCornersRadius;
        float f16 = i3;
        if (fArr[6] == f16) {
            return;
        }
        fArr[6] = f16;
        fArr[7] = f16;
        invalidate();
    }

    public void setBottomRightRadius(int i3) {
        if (this.mIsCircle) {
            return;
        }
        float[] fArr = this.mCornersRadius;
        float f16 = i3;
        if (fArr[4] == f16) {
            return;
        }
        fArr[4] = f16;
        fArr[5] = f16;
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int i3) {
        if (i3 == this.mCircleBackgroundColor) {
            return;
        }
        this.mCircleBackgroundColor = i3;
        this.mCircleBackgroundPaint.setColor(i3);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int i3) {
        setCircleBackgroundColor(getContext().getResources().getColor(i3));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.mColorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mInitialized) {
            this.mBitmapPaint.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z16) {
        if (z16 == this.mDisableCircularTransformation) {
            return;
        }
        this.mDisableCircularTransformation = z16;
        if (z16) {
            this.mBitmap = null;
            this.mBitmapCanvas = null;
            this.mBitmapPaint.setShader(null);
        } else {
            initializeBitmap();
        }
        invalidate();
    }

    public void setEnableClearBitmapCanvasWhenDirty(boolean z16) {
        this.mEnableClearBitmapCanvasWhenDirty = z16;
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i3) {
        int i16 = i3 & 255;
        if (i16 == this.mImageAlpha) {
            return;
        }
        this.mImageAlpha = i16;
        if (this.mInitialized) {
            this.mBitmapPaint.setAlpha(i16);
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.mDisableCircularTransformation) {
            return;
        }
        initializeBitmap();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.mDisableCircularTransformation) {
            return;
        }
        initializeBitmap();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i3) {
        super.setImageResource(i3);
        if (this.mDisableCircularTransformation) {
            return;
        }
        initializeBitmap();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.mDisableCircularTransformation) {
            return;
        }
        initializeBitmap();
        invalidate();
    }

    public final void setIsCircle(boolean z16) {
        if (this.mIsCircle == z16) {
            return;
        }
        this.mIsCircle = z16;
        this.mCornersRadius = new float[8];
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
        super.setPaddingRelative(i3, i16, i17, i18);
        updateDimensions();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.mDisableCircularTransformation) {
            super.setScaleType(scaleType);
        } else if (scaleType == SCALE_TYPE) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public void setTopLeftRadius(int i3) {
        if (this.mIsCircle) {
            return;
        }
        float[] fArr = this.mCornersRadius;
        float f16 = i3;
        if (fArr[0] == f16) {
            return;
        }
        fArr[0] = f16;
        fArr[1] = f16;
        invalidate();
    }

    public void setTopRightRadius(int i3) {
        if (this.mIsCircle) {
            return;
        }
        float[] fArr = this.mCornersRadius;
        float f16 = i3;
        if (fArr[2] == f16) {
            return;
        }
        fArr[2] = f16;
        fArr[3] = f16;
        invalidate();
    }

    public RFWRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = 255;
        this.mEnableClearBitmapCanvasWhenDirty = false;
        this.mCornersRadius = new float[8];
        this.mIsCircle = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RFWRoundImageView, i3, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RFWRoundImageView_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R$styleable.RFWRoundImageView_civ_border_color, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R$styleable.RFWRoundImageView_civ_border_overlay, false);
        this.mCircleBackgroundColor = obtainStyledAttributes.getColor(R$styleable.RFWRoundImageView_civ_circle_background_color, 0);
        boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.RFWRoundImageView_civ_is_circle, true);
        this.mIsCircle = z16;
        if (!z16) {
            setTopLeftRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.RFWRoundImageView_civ_corner_top_left_radius, 0));
            setTopRightRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.RFWRoundImageView_civ_corner_top_right_radius, 0));
            setBottomLeftRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.RFWRoundImageView_civ_corner_bottom_left_radius, 0));
            setBottomRightRadius(obtainStyledAttributes.getDimensionPixelSize(R$styleable.RFWRoundImageView_civ_corner_bottom_right_radius, 0));
        }
        obtainStyledAttributes.recycle();
        init();
    }
}
