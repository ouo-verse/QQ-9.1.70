package com.tencent.component.media.image.drawable;

import com.tencent.component.media.image.image.BitmapImage;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapImageDrawable extends ImageDrawable {
    private final BitmapImage mImage;

    public BitmapImageDrawable(BitmapImage bitmapImage) {
        this(bitmapImage, -1, -1);
    }

    private void init() {
        setOriginalWidth(this.mImage.getMetaInfo().width);
        setOriginalHeight(this.mImage.getMetaInfo().height);
    }

    public int size() {
        BitmapImage bitmapImage = this.mImage;
        if (bitmapImage != null) {
            return bitmapImage.size();
        }
        return 0;
    }

    public BitmapImageDrawable(BitmapImage bitmapImage, int i3, int i16) {
        super(bitmapImage.getBitmap(), i3, i16);
        this.mImage = bitmapImage;
        init();
    }
}
