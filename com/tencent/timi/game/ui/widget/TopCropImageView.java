package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TopCropImageView extends URLImageView {
    public TopCropImageView(Context context) {
        super(context);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private boolean c() {
        float f16;
        float f17;
        Matrix imageMatrix = getImageMatrix();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return true;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            return true;
        }
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f16 = height;
            f17 = intrinsicHeight;
        } else {
            f16 = width;
            f17 = intrinsicWidth;
        }
        float f18 = f16 / f17;
        imageMatrix.setScale(f18, f18);
        setImageMatrix(imageMatrix);
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        c();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        c();
        return super.setFrame(i3, i16, i17, i18);
    }

    public TopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public TopCropImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
