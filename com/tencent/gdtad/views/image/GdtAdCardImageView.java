package com.tencent.gdtad.views.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import p71.a;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes6.dex */
public class GdtAdCardImageView extends ImageView {
    private static final String TAG = "GdtAdCardImageView";
    private int cornerRadius;
    private final Paint mPaint;

    public GdtAdCardImageView(Context context) {
        this(context, null);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix imageMatrix = getImageMatrix();
        if (imageMatrix != null) {
            canvas.concat(imageMatrix);
        }
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        Matrix imageMatrix = getImageMatrix();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            if (imageMatrix == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                drawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (getCropToPadding()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            Bitmap drawableToBitmap = drawableToBitmap(drawable);
            Paint paint = this.mPaint;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(drawableToBitmap, tileMode, tileMode));
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            int i3 = this.cornerRadius;
            canvas.drawRoundRect(rectF, i3, i3, this.mPaint);
            canvas.restoreToCount(saveCount);
        }
    }

    public void setCornerRadius(float f16) {
        this.cornerRadius = ViewUtils.dip2px(f16);
    }

    public GdtAdCardImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GdtAdCardImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.O1, 0, 0);
        if (obtainStyledAttributes != null) {
            for (int i16 = 0; i16 < obtainStyledAttributes.getIndexCount(); i16++) {
                obtainStyledAttributes.getIndex(i16);
                int index = obtainStyledAttributes.getIndex(i16);
                if (index == a.P1) {
                    this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mPaint = new Paint();
    }
}
