package com.tencent.component.media.image.image;

import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapImage extends Image {
    private final BitmapReference mBitmap;
    private final Image.MetaInfo mMetaInfo = new Image.MetaInfo();

    public BitmapImage(BitmapReference bitmapReference) {
        boolean z16;
        if (bitmapReference != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtils.assertTrue(z16);
        this.mBitmap = bitmapReference;
        initMetaInfo();
    }

    private void initMetaInfo() {
        this.mMetaInfo.width = this.mBitmap.getWidth();
        this.mMetaInfo.height = this.mBitmap.getHeight();
    }

    public BitmapReference getBitmap() {
        return this.mBitmap;
    }

    public Image.MetaInfo getMetaInfo() {
        return this.mMetaInfo;
    }

    @Override // com.tencent.component.media.image.image.Image
    public boolean isRecycled() {
        return this.mBitmap.isRecycled();
    }

    @Override // com.tencent.component.media.image.image.Image
    public void recycle() {
        if (!this.mBitmap.isRecycled()) {
            this.mBitmap.release();
        }
    }

    @Override // com.tencent.component.media.image.image.Image
    public int size() {
        if (this.mBitmap.isRecycled()) {
            return 0;
        }
        return this.mBitmap.getAllocSize();
    }
}
