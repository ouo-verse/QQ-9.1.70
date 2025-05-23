package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

@Public
/* loaded from: classes5.dex */
public abstract class ImageProcessor {
    public static final int TYPE_BUBBLE = 6;
    public static final int TYPE_CIRCLE = 8;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_FEED_LIST_IMAGE = 5;
    public static final int TYPE_MARK = 7;
    public static final int TYPE_OVAL = 3;
    public static final int TYPE_ROUND_CORNER = 2;
    public static final int TYPE_SpecifiedSizeCropByPivot = 4;
    protected ImageKey mImageKey;
    protected ImageProcessor mPreProcessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable doProcess(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Drawable process = process(drawable);
        if (getType() == 5 && process == null) {
            return null;
        }
        if (process != null) {
            return process;
        }
        return drawable;
    }

    public int getType() {
        return 1;
    }

    @Public
    public abstract Drawable process(Drawable drawable);

    public void setImageKey(ImageKey imageKey) {
        this.mImageKey = imageKey;
    }

    public void setPreProcessor(ImageProcessor imageProcessor) {
        this.mPreProcessor = imageProcessor;
    }
}
