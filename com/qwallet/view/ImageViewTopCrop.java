package com.qwallet.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageViewTopCrop extends ImageView {
    public ImageViewTopCrop(Context context) {
        super(context);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        float max;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return super.setFrame(i3, i16, i17, i18);
        }
        float f16 = i17 - i3;
        float f17 = i18 - i16;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (f16 <= intrinsicWidth && f17 <= intrinsicHeight) {
            max = 1.0f;
        } else {
            max = Math.max(f16 / intrinsicWidth, f17 / intrinsicHeight);
        }
        Matrix imageMatrix = getImageMatrix();
        imageMatrix.setScale(max, max, 0.0f, 0.0f);
        imageMatrix.postTranslate((f16 - (intrinsicWidth * max)) / 2.0f, f17 - (intrinsicHeight * max));
        setImageMatrix(imageMatrix);
        return super.setFrame(i3, i16, i17, i18);
    }

    public ImageViewTopCrop(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public ImageViewTopCrop(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
