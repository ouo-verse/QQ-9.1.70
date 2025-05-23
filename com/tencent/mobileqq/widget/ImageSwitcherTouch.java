package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ImageSwitcherTouch extends ImageSwitcher {
    public ImageSwitcherTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDrawable(Drawable drawable, int i3, int i16) {
        ImageViewTouche imageViewTouche = (ImageViewTouche) getCurrentView();
        imageViewTouche.setAdjustViewBounds(true);
        imageViewTouche.setMaxWidth(i3);
        imageViewTouche.setMaxHeight(i16);
        imageViewTouche.setImageBitmap(null);
        imageViewTouche.setImageDrawable(drawable);
    }

    public void setDrawableWithSize(Drawable drawable, int i3, int i16) {
        ImageViewTouche imageViewTouche = (ImageViewTouche) getCurrentView();
        imageViewTouche.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageViewTouche.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        imageViewTouche.setImageBitmap(null);
        imageViewTouche.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        ImageViewTouche imageViewTouche = (ImageViewTouche) getCurrentView();
        imageViewTouche.setImageBitmap(bitmap);
        imageViewTouche.setImageRotateBitmapResetBase(new bb(bitmap, 0), true);
    }

    public ImageSwitcherTouch(Context context) {
        super(context);
    }
}
