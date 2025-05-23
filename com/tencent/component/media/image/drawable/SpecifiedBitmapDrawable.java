package com.tencent.component.media.image.drawable;

import com.tencent.component.media.image.BitmapReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpecifiedBitmapDrawable extends BitmapRefDrawable {
    public SpecifiedBitmapDrawable(BitmapReference bitmapReference) {
        super(bitmapReference);
    }

    @Override // com.tencent.component.media.image.drawable.BitmapRefDrawable
    public BitmapReference getBitmapRef() {
        return this.mBitmapRef;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (getBitmap() == null) {
            return super.getIntrinsicHeight();
        }
        return getBitmap().getHeight();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (getBitmap() == null) {
            return super.getIntrinsicWidth();
        }
        return getBitmap().getWidth();
    }

    @Override // com.tencent.component.media.image.drawable.BitmapRefDrawable
    public boolean isMulible() {
        BitmapReference bitmapReference = this.mBitmapRef;
        if (bitmapReference != null) {
            return bitmapReference.isMutable();
        }
        return false;
    }
}
