package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageViewAware extends ViewAware {
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        if (height <= 0 && (imageView = (ImageView) this.viewRef.get()) != null) {
            return imageView.getMaxHeight();
        }
        return height;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.viewRef.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.getScaleType();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        if (width <= 0 && (imageView = (ImageView) this.viewRef.get()) != null) {
            return imageView.getMaxWidth();
        }
        return width;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public ImageViewAware(ImageView imageView, boolean z16) {
        super(imageView, z16);
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }
}
