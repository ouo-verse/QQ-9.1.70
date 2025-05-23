package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;

/* loaded from: classes39.dex */
public class DrawUrlPicArea extends SubArea implements r {
    private Drawable mDrawable;
    private ImageLoader.ImageLoadListener mImageLoadListener = new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.DrawUrlPicArea.1
        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            DrawUrlPicArea.this.mDrawable = drawable;
            DrawUrlPicArea.this.invalidate();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    };

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return true;
        }
        drawable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mDrawable.draw(canvas);
        return true;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    public void setData(FeedPictureInfo feedPictureInfo, int i3, int i16, ImageUrl imageUrl) {
        this.mWidth = i3;
        this.mHeight = i16;
        String str = feedPictureInfo.h().url;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.extraProcessor = feedPictureInfo.c();
        obtain.clipWidth = i3;
        obtain.clipHeight = i16;
        obtain.useMainThread = true;
        this.mDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.mImageLoadListener, obtain);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mDrawable = null;
    }

    public void setData(String str, int i3, int i16, ImageProcessor imageProcessor, ImageUrl imageUrl) {
        this.mWidth = i3;
        this.mHeight = i16;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.extraProcessor = imageProcessor;
        obtain.clipWidth = i3;
        obtain.clipHeight = i16;
        obtain.useMainThread = true;
        this.mDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.mImageLoadListener, obtain);
    }

    public void setData(String str, int i3, int i16, ImageUrl imageUrl) {
        this.mWidth = i3;
        this.mHeight = i16;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.clipWidth = i3;
        obtain.clipHeight = i16;
        obtain.useMainThread = true;
        this.mDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.mImageLoadListener, obtain);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
