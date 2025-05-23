package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.album.ui.widget.MarkImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncMarkImageView extends MarkImageView implements AsyncImageable {
    private final AsyncImageable.AsyncImageableImpl C;

    public AsyncMarkImageView(Context context) {
        this(context, null);
    }

    public String c() {
        return this.C.t();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImage() {
        this.C.cancelAsyncLoadImage();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImageWithoutListener() {
        this.C.cancelAsyncLoadImageWithoutListener();
    }

    public String d() {
        return this.C.v();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncClipSize(int i3, int i16) {
        this.C.setAsyncClipSize(i3, i16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImage(String str) {
        this.C.setAsyncImage(str);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.C.setAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
        this.C.setAsyncImageProcessor(imageProcessor);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImages(ArrayList<String> arrayList, long j3) {
        this.C.setAsyncImages(arrayList, j3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncJustCover(boolean z16) {
        this.C.setAsyncJustCover(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPreferQuality(boolean z16) {
        this.C.setAsyncPreferQuality(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPriority(boolean z16) {
        this.C.setAsyncPriority(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncRootFilePath(String str) {
        this.C.setAsyncRootFilePath(str);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setDefaultImage(int i3) {
        this.C.setDefaultImage(i3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setFailImage(int i3) {
        this.C.setFailImage(i3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.C.setInternalAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedDownload(boolean z16) {
        this.C.setNeedDownload(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedGifStream(boolean z16) {
        this.C.setNeedGifStream(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedPieceLoad(boolean z16) {
        this.C.setNeedPieceLoad(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedProgress(boolean z16) {
        this.C.setNeedProgress(z16);
    }

    public AsyncMarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AsyncMarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new AsyncImageable.AsyncImageableImpl(this, this);
    }
}
