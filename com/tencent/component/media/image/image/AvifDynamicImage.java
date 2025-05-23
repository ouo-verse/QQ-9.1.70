package com.tencent.component.media.image.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.gif.AvifGifDrawable;
import libavif.AvifDecoder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AvifDynamicImage extends Image {
    private final Drawable mDrawable;

    public AvifDynamicImage(AvifDecoder avifDecoder) {
        this.mDrawable = new AvifGifDrawable(avifDecoder);
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.tencent.component.media.image.image.Image
    public boolean isRecycled() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof AvifGifDrawable) {
            return ((AvifGifDrawable) drawable).isDestroyed();
        }
        return false;
    }

    @Override // com.tencent.component.media.image.image.Image
    public void recycle() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof AvifGifDrawable) {
            ((AvifGifDrawable) drawable).stop();
            ((AvifGifDrawable) this.mDrawable).destroy();
        }
    }

    @Override // com.tencent.component.media.image.image.Image
    public int size() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof AvifGifDrawable) {
            return drawable.getIntrinsicWidth() * this.mDrawable.getIntrinsicHeight() * 4;
        }
        return 0;
    }
}
