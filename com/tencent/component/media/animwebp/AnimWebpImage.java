package com.tencent.component.media.animwebp;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.utils.BitmapUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimWebpImage extends Image {
    private WebpDrawable drawable;

    public AnimWebpImage(ImageKey imageKey) {
        if (imageKey == null || TextUtils.isEmpty(imageKey.filePath)) {
            return;
        }
        this.drawable = new WebpDrawable(imageKey.filePath);
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.tencent.component.media.image.image.Image
    public boolean isRecycled() {
        WebpDrawable webpDrawable = this.drawable;
        if (webpDrawable != null) {
            return webpDrawable.isRunning();
        }
        return false;
    }

    @Override // com.tencent.component.media.image.image.Image
    public void recycle() {
        WebpDrawable webpDrawable = this.drawable;
        if (webpDrawable != null) {
            webpDrawable.stop();
        }
    }

    @Override // com.tencent.component.media.image.image.Image
    public int size() {
        WebpDrawable webpDrawable = this.drawable;
        if (webpDrawable != null && webpDrawable.getCurrentBitmap() != null) {
            return BitmapUtils.getBitmapAllocSize(this.drawable.getCurrentBitmap());
        }
        return 0;
    }

    public AnimWebpImage(byte[] bArr) {
        if (bArr != null) {
            this.drawable = new WebpDrawable(bArr);
        }
    }
}
