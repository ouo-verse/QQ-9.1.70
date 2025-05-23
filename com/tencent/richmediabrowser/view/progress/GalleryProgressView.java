package com.tencent.richmediabrowser.view.progress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

/* loaded from: classes25.dex */
public class GalleryProgressView implements AbstractProgressView {
    private static final String TAG = "GalleryProgressView";
    Rect bounds;
    PhotoProgressDrawable mPhotoProgressDrawable;
    ImageView progressBar;
    boolean isShow = false;
    boolean isStarted = false;
    int progress = 0;

    private void initDrawable(Context context) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.n5m);
        } catch (OutOfMemoryError e16) {
            BrowserLogHelper.getInstance().getGalleryLog().e(TAG, 4, "initDrawable exception = " + e16.getMessage());
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
        }
        PhotoProgressDrawable photoProgressDrawable = new PhotoProgressDrawable(bitmap, (int) (context.getResources().getDisplayMetrics().density * 12.0f));
        this.mPhotoProgressDrawable = photoProgressDrawable;
        photoProgressDrawable.setLevel(0);
        this.bounds = new Rect(0, 0, 0, 0);
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void hide() {
        this.isShow = false;
        if (this.progressBar.getVisibility() == 0) {
            this.progressBar.setVisibility(4);
        }
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void init(Context context, BrowserBaseScene browserBaseScene) {
        this.progressBar = (ImageView) browserBaseScene.getRootView().findViewById(R.id.g2h);
        initDrawable(context);
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public boolean isShow() {
        return this.isShow;
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public boolean isStarted() {
        return this.isStarted;
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void setProgress(int i3) {
        if (i3 >= 0 && i3 <= 100) {
            this.mPhotoProgressDrawable.setLevel(i3 * 100);
            this.mPhotoProgressDrawable.invalidateSelf();
        }
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void show() {
        this.isShow = true;
        if (this.isStarted && this.progressBar.getVisibility() == 4) {
            if (this.bounds.width() == 0 || this.bounds.height() == 0) {
                this.bounds.set(0, 0, this.progressBar.getWidth(), this.progressBar.getHeight());
                this.mPhotoProgressDrawable.setBounds(this.bounds);
                this.progressBar.setImageDrawable(this.mPhotoProgressDrawable);
            }
            this.progressBar.setVisibility(0);
        }
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void start(int i3) {
        this.progress = i3;
        this.isStarted = true;
        if (this.isShow) {
            if (this.bounds.width() == 0 || this.bounds.height() == 0) {
                this.bounds.set(0, 0, this.progressBar.getWidth(), this.progressBar.getHeight());
                this.mPhotoProgressDrawable.setBounds(this.bounds);
                this.progressBar.setImageDrawable(this.mPhotoProgressDrawable);
            }
            this.progressBar.setVisibility(0);
        }
        if (i3 >= 0 && i3 < 100) {
            this.mPhotoProgressDrawable.setLevel(i3 * 100);
            this.mPhotoProgressDrawable.invalidateSelf();
        } else {
            this.mPhotoProgressDrawable.disableDrawText();
        }
    }

    @Override // com.tencent.richmediabrowser.view.progress.AbstractProgressView
    public void stop() {
        this.progress = 0;
        this.isStarted = false;
        if (this.progressBar.getVisibility() == 0) {
            this.progressBar.setVisibility(4);
        }
    }

    public void init(Context context, ImageView imageView) {
        this.progressBar = imageView;
        initDrawable(context);
    }
}
