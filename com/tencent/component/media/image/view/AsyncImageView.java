package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import com.tencent.component.media.image.view.AsyncImageable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AsyncImageView extends ExtendImageView implements AsyncImageable {
    private final AsyncImageable.AsyncImageableImpl mAsyncImageableImpl;

    public AsyncImageView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.component.media.image.view.AsyncImageable
    public String getAsyncImage() {
        return this.mAsyncImageableImpl.getAsyncImage();
    }

    @Override // com.tencent.component.media.image.view.AsyncImageable
    public AsyncImageable.AsyncOptions getAsyncOptions() {
        return this.mAsyncImageableImpl.getAsyncOptions();
    }

    public void setAsyncAlwaysLoad(boolean z16) {
        getAsyncOptions().setAlwaysLoad(z16);
    }

    public void setAsyncClipSize(int i3, int i16) {
        getAsyncOptions().setClipSize(i3, i16);
    }

    public void setAsyncDefaultImage(int i3) {
        getAsyncOptions().setDefaultImage(i3);
    }

    public void setAsyncFailImage(int i3) {
        getAsyncOptions().setFailImage(i3);
    }

    @Override // com.tencent.component.media.image.view.AsyncImageable
    public void setAsyncImage(String str) {
        this.mAsyncImageableImpl.setAsyncImage(str);
    }

    @Override // com.tencent.component.media.image.view.AsyncImageable
    public void setAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.mAsyncImageableImpl.setAsyncImageListener(asyncImageListener);
    }

    public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
        getAsyncOptions().setImageProcessor(imageProcessor);
    }

    public void setAsyncJustCover(boolean z16) {
        getAsyncOptions().setJustCover(z16);
    }

    public void setAsyncPreferQuality(boolean z16) {
        getAsyncOptions().setPreferQuality(z16);
    }

    public void setAsyncPriority(boolean z16) {
        getAsyncOptions().setPriority(z16);
    }

    public void setAsyncRawImageProcessor(RawImageProcessor rawImageProcessor) {
        getAsyncOptions().setRawImageProcessor(rawImageProcessor);
    }

    public void setAsyncRootFilePath(String str) {
        getAsyncOptions().setFileRootPath(str);
    }

    @Override // com.tencent.component.media.image.view.AsyncImageable
    public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.mAsyncImageableImpl.setInternalAsyncImageListener(asyncImageListener);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setAsyncDefaultImage(Drawable drawable) {
        getAsyncOptions().setDefaultImage(drawable);
    }

    public void setAsyncFailImage(Drawable drawable) {
        getAsyncOptions().setFailImage(drawable);
    }

    public void setAsyncImage(String str, String... strArr) {
        this.mAsyncImageableImpl.setAsyncImage(str, strArr);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAsyncImageableImpl = new AsyncImageable.AsyncImageableImpl(this, this);
    }
}
