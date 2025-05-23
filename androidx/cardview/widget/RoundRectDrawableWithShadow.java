package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;
    private boolean mDirty = true;
    private boolean mAddPaddingForCorners = true;
    private boolean mPrintedShadowClipWarning = false;
    private Paint mPaint = new Paint(5);

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f16, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f16, float f17, float f18) {
        this.mShadowStartColor = resources.getColor(R.color.f156853d6);
        this.mShadowEndColor = resources.getColor(R.color.f156852d5);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.f158489h6);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (f16 + 0.5f);
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f17, f18);
    }

    private void buildComponents(Rect rect) {
        float f16 = this.mRawMaxShadowSize;
        float f17 = 1.5f * f16;
        this.mCardBounds.set(rect.left + f16, rect.top + f17, rect.right - f16, rect.bottom - f17);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f16 = this.mCornerRadius;
        RectF rectF = new RectF(-f16, -f16, f16, f16);
        RectF rectF2 = new RectF(rectF);
        float f17 = this.mShadowSize;
        rectF2.inset(-f17, -f17);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f18 = this.mCornerRadius;
        float f19 = f18 / (this.mShadowSize + f18);
        Paint paint = this.mCornerShadowPaint;
        float f26 = this.mCornerRadius + this.mShadowSize;
        int i3 = this.mShadowStartColor;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f26, new int[]{i3, i3, this.mShadowEndColor}, new float[]{0.0f, f19, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.mEdgeShadowPaint;
        float f27 = this.mCornerRadius;
        float f28 = this.mShadowSize;
        int i16 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, (-f27) + f28, 0.0f, (-f27) - f28, new int[]{i16, i16, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float calculateHorizontalPadding(float f16, float f17, boolean z16) {
        if (z16) {
            return (float) (f16 + ((1.0d - COS_45) * f17));
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float calculateVerticalPadding(float f16, float f17, boolean z16) {
        if (z16) {
            return (float) ((f16 * 1.5f) + ((1.0d - COS_45) * f17));
        }
        return f16 * 1.5f;
    }

    private void drawShadow(Canvas canvas) {
        boolean z16;
        boolean z17;
        float f16 = this.mCornerRadius;
        float f17 = (-f16) - this.mShadowSize;
        float f18 = f16 + this.mInsetShadow + (this.mRawShadowSize / 2.0f);
        float f19 = f18 * 2.0f;
        if (this.mCardBounds.width() - f19 > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mCardBounds.height() - f19 > 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f18, rectF.top + f18);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z16) {
            canvas.drawRect(0.0f, f17, this.mCardBounds.width() - f19, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.mCardBounds;
        canvas.translate(rectF2.right - f18, rectF2.bottom - f18);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z16) {
            canvas.drawRect(0.0f, f17, this.mCardBounds.width() - f19, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.mCardBounds;
        canvas.translate(rectF3.left + f18, rectF3.bottom - f18);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z17) {
            canvas.drawRect(0.0f, f17, this.mCardBounds.height() - f19, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.mCardBounds;
        canvas.translate(rectF4.right - f18, rectF4.top + f18);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z17) {
            canvas.drawRect(0.0f, f17, this.mCardBounds.height() - f19, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f16, float f17) {
        if (f16 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f16 + ". Must be >= 0");
        }
        if (f17 >= 0.0f) {
            float even = toEven(f16);
            float even2 = toEven(f17);
            if (even > even2) {
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
                even = even2;
            }
            if (this.mRawShadowSize == even && this.mRawMaxShadowSize == even2) {
                return;
            }
            this.mRawShadowSize = even;
            this.mRawMaxShadowSize = even2;
            this.mShadowSize = (int) ((even * 1.5f) + this.mInsetShadow + 0.5f);
            this.mDirty = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid max shadow size " + f17 + ". Must be >= 0");
    }

    private int toEven(float f16) {
        int i3 = (int) (f16 + 0.5f);
        if (i3 % 2 == 1) {
            return i3 - 1;
        }
        return i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getColor() {
        return this.mBackground;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMinHeight() {
        float f16 = this.mRawMaxShadowSize;
        return (Math.max(f16, this.mCornerRadius + this.mInsetShadow + ((f16 * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMinWidth() {
        float f16 = this.mRawMaxShadowSize;
        return (Math.max(f16, this.mCornerRadius + this.mInsetShadow + (f16 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddPaddingForCorners(boolean z16) {
        this.mAddPaddingForCorners = z16;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mPaint.setAlpha(i3);
        this.mCornerShadowPaint.setAlpha(i3);
        this.mEdgeShadowPaint.setAlpha(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCornerRadius(float f16) {
        if (f16 >= 0.0f) {
            float f17 = (int) (f16 + 0.5f);
            if (this.mCornerRadius == f17) {
                return;
            }
            this.mCornerRadius = f17;
            this.mDirty = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f16 + ". Must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxShadowSize(float f16) {
        setShadowSize(this.mRawShadowSize, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShadowSize(float f16) {
        setShadowSize(f16, this.mRawMaxShadowSize);
    }
}
