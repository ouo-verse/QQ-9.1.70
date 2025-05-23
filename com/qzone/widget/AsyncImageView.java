package com.qzone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import java.util.ArrayList;

/* compiled from: P */
@Deprecated
/* loaded from: classes37.dex */
public class AsyncImageView extends ExtendImageView implements AsyncImageable {
    private final AsyncImageable.AsyncImageableImpl mAsyncImageableImpl;

    public AsyncImageView(Context context) {
        this(context, null);
    }

    public void applyDefaultImage() {
        this.mAsyncImageableImpl.k();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImage() {
        this.mAsyncImageableImpl.cancelAsyncLoadImage();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImageWithoutListener() {
        this.mAsyncImageableImpl.cancelAsyncLoadImageWithoutListener();
    }

    public void clearAsyncImage() {
        this.mAsyncImageableImpl.o();
    }

    public ImageLoader.Options getDownloadFailedOptions() {
        return this.mAsyncImageableImpl.s();
    }

    public String getFailedImageUrl() {
        return this.mAsyncImageableImpl.t();
    }

    public ImageLoader.Options getImageOption() {
        return this.mAsyncImageableImpl.u();
    }

    public String getImageUrl() {
        return this.mAsyncImageableImpl.v();
    }

    public void setApplyDefaultImage(boolean z16) {
        this.mAsyncImageableImpl.B(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncClipSize(int i3, int i16) {
        this.mAsyncImageableImpl.setAsyncClipSize(i3, i16);
    }

    public void setAsyncImage(String str) {
        this.mAsyncImageableImpl.setAsyncImage(str);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.mAsyncImageableImpl.setAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
        this.mAsyncImageableImpl.setAsyncImageProcessor(imageProcessor);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImages(ArrayList<String> arrayList, long j3) {
        this.mAsyncImageableImpl.setAsyncImages(arrayList, j3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncJustCover(boolean z16) {
        this.mAsyncImageableImpl.setAsyncJustCover(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPreferQuality(boolean z16) {
        this.mAsyncImageableImpl.setAsyncPreferQuality(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPriority(boolean z16) {
        this.mAsyncImageableImpl.setAsyncPriority(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncRootFilePath(String str) {
        this.mAsyncImageableImpl.setAsyncRootFilePath(str);
    }

    public void setDecodeConfig(Bitmap.Config config) {
        this.mAsyncImageableImpl.G(config);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setDefaultImage(int i3) {
        this.mAsyncImageableImpl.setDefaultImage(i3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setFailImage(int i3) {
        this.mAsyncImageableImpl.setFailImage(i3);
    }

    public void setImageType(int i3) {
        this.mAsyncImageableImpl.I(i3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.mAsyncImageableImpl.setInternalAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedDownload(boolean z16) {
        this.mAsyncImageableImpl.setNeedDownload(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedGifStream(boolean z16) {
        this.mAsyncImageableImpl.setNeedGifStream(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedPieceLoad(boolean z16) {
        this.mAsyncImageableImpl.setNeedPieceLoad(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedProgress(boolean z16) {
        this.mAsyncImageableImpl.setNeedProgress(z16);
    }

    public void setPlayingGif(boolean z16) {
        this.mAsyncImageableImpl.J(z16);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setAsyncImage(ImageUrl imageUrl, String str) {
        this.mAsyncImageableImpl.C(imageUrl, str);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAsyncImageableImpl = new AsyncImageable.AsyncImageableImpl(this, this);
    }
}
