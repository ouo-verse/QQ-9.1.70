package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.image.Image;

/* loaded from: classes5.dex */
public class PhotoGifImage extends Image {
    private Drawable mDrawable;

    public PhotoGifImage(ImageKey imageKey) {
        if (ImageManagerEnv.g().isPreferNewAnimationImp()) {
            ImageLoader.Options options = imageKey.options;
            if (NewAnimationDrawable.isSuitable(options.photoList, options.clipWidth, options.clipHeight)) {
                NewAnimationDrawable newAnimationDrawable = new NewAnimationDrawable(imageKey.options);
                this.mDrawable = newAnimationDrawable;
                newAnimationDrawable.setDefaultFrame(ImageManagerEnv.g().getPhotoGifDefaultDrawable());
                return;
            }
        }
        this.mDrawable = new PhotoGifDrawable(imageKey);
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.tencent.component.media.image.image.Image
    public boolean isRecycled() {
        return false;
    }

    @Override // com.tencent.component.media.image.image.Image
    public int size() {
        return 0;
    }

    @Override // com.tencent.component.media.image.image.Image
    public void recycle() {
    }
}
