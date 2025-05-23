package com.tencent.state.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.state.square.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class CircleBoarderImageView extends SquareImageView {
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_FILL_COLOR = 0;
    private static final String TAG = "CircleBoarderImageView";
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private boolean mDisableCircularTransformation;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mFillColor;
    private final Paint mFillPaint;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public CircleBoarderImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        init();
    }

    private void applyColorFilter() {
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColorFilter(this.mColorFilter);
        }
    }

    private RectF calculateBounds() {
        return new RectF(0.0f, 0.0f, getWidth(), getHeight());
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
            Log.e(TAG, "getBitmapFromDrawable Exception", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            Log.e(TAG, "getBitmapFromDrawable OutOfMemory", e17);
            return null;
        }
    }

    private RectF getBorderRect() {
        return new RectF(this.mBorderWidth / 2.0f, 0.0f, getWidth() - (this.mBorderWidth / 2.0f), getHeight());
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    private void initializeBitmap() {
        if (this.mDisableCircularTransformation) {
            this.mBitmap = null;
        } else {
            this.mBitmap = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private void setup() {
        int i3;
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.mBitmap == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.mBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mFillPaint.setAntiAlias(true);
        this.mFillPaint.setColor(this.mFillColor);
        this.mBitmapHeight = this.mBitmap.getHeight();
        this.mBitmapWidth = this.mBitmap.getWidth();
        this.mBorderRect.set(getBorderRect());
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        this.mDrawableRect.set(calculateBounds());
        if (!this.mBorderOverlay && (i3 = this.mBorderWidth) > 0) {
            this.mDrawableRect.inset(i3 - 1.0f, i3 - 1.0f);
        }
        if (this.mDrawableRadius == -1.0f) {
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        }
        applyColorFilter();
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.mShaderMatrix.set(null);
        float f16 = 0.0f;
        if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
            width = this.mDrawableRect.height() / this.mBitmapHeight;
            height = 0.0f;
            f16 = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
        } else {
            width = this.mDrawableRect.width() / this.mBitmapWidth;
            height = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
        }
        this.mShaderMatrix.setScale(width, width);
        Matrix matrix = this.mShaderMatrix;
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(((int) (f16 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
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

    @Deprecated
    public int getFillColor() {
        return this.mFillColor;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public boolean isDisableCircularTransformation() {
        return this.mDisableCircularTransformation;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDisableCircularTransformation) {
            super.onDraw(canvas);
            return;
        }
        if (this.mBitmap == null) {
            return;
        }
        if (this.mFillColor != 0) {
            RectF rectF = this.mDrawableRect;
            float f16 = this.mDrawableRadius;
            canvas.drawRoundRect(rectF, f16, f16, this.mFillPaint);
        }
        RectF rectF2 = this.mDrawableRect;
        float f17 = this.mDrawableRadius;
        canvas.drawRoundRect(rectF2, f17, f17, this.mBitmapPaint);
        if (this.mBorderWidth > 0) {
            RectF rectF3 = this.mBorderRect;
            float f18 = this.mBorderRadius;
            canvas.drawRoundRect(rectF3, f18, f18, this.mBorderPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        setup();
    }

    public void setBorderColor(int i3) {
        if (i3 == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i3;
        this.mBorderPaint.setColor(i3);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(int i3) {
        setBorderColor(getContext().getResources().getColor(i3));
    }

    public void setBorderOverlay(boolean z16) {
        if (z16 == this.mBorderOverlay) {
            return;
        }
        this.mBorderOverlay = z16;
        setup();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i3;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.mColorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        applyColorFilter();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z16) {
        if (this.mDisableCircularTransformation == z16) {
            return;
        }
        this.mDisableCircularTransformation = z16;
        initializeBitmap();
    }

    @Deprecated
    public void setFillColor(int i3) {
        if (i3 == this.mFillColor) {
            return;
        }
        this.mFillColor = i3;
        this.mFillPaint.setColor(i3);
        invalidate();
    }

    @Deprecated
    public void setFillColorResource(int i3) {
        setFillColor(getContext().getResources().getColor(i3));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    @Override // com.tencent.state.view.SquareImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    @Override // com.tencent.state.view.SquareImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        if (z16) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public CircleBoarderImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleBoarderImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleBoarderImageView, i3, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleBoarderImageView_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.CircleBoarderImageView_civ_border_color, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R.styleable.CircleBoarderImageView_civ_border_overlay, false);
        this.mFillColor = obtainStyledAttributes.getColor(R.styleable.CircleBoarderImageView_civ_fill_color, 0);
        this.mDrawableRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleBoarderImageView_civ_radius_size, -1);
        obtainStyledAttributes.recycle();
        init();
    }
}
