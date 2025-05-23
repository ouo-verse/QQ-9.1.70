package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class PhotoGifDrawable extends QzoneAnimationDrawable {
    private static Drawable sDefaultFrame = ImageManagerEnv.g().getPhotoGifDefaultDrawable();

    public PhotoGifDrawable(ImageKey imageKey) {
        super(imageKey);
        setDrawableForDefaultFrame(sDefaultFrame);
    }

    public static boolean isPhotoGif(ImageKey imageKey) {
        ImageLoader.Options options;
        ArrayList<String> arrayList;
        if (imageKey != null && (options = imageKey.options) != null && options.needShowPhotoGifAnimation && (arrayList = options.photoList) != null && arrayList.size() > 1) {
            return true;
        }
        return false;
    }

    public static void setDefaultFrame(Drawable drawable) {
        sDefaultFrame = drawable;
    }

    @Override // com.tencent.component.media.photogif.QzoneAnimationDrawable
    public boolean canAnimate() {
        return ImageManagerEnv.g().shouldPlayPhotoGif();
    }
}
