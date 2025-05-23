package com.tencent.mobileqq.mini.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RoundImageView extends ImageView {
    private static final int COLORDRAWABLE_DIMENSION = 1;
    private static final int DEFAULT_BORDER_COLOR = 0;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public RoundImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = 0;
        this.mBorderWidth = 0;
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
                createBitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (this.mBitmap == null) {
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
        this.mBitmapHeight = this.mBitmap.getHeight();
        this.mBitmapWidth = this.mBitmap.getWidth();
        this.mBorderRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        RectF rectF = this.mDrawableRect;
        int i3 = this.mBorderWidth;
        rectF.set(i3, i3, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
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
        int i3 = this.mBorderWidth;
        matrix.postTranslate(((int) (f16 + 0.5f)) + i3, ((int) (height + 0.5f)) + i3);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mDrawableRadius, this.mBitmapPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mBorderRadius, this.mBorderPaint);
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

    public void setBorderWidth(int i3) {
        if (i3 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i3;
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == SCALE_TYPE) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = 0;
        this.mBorderWidth = 0;
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }
}
