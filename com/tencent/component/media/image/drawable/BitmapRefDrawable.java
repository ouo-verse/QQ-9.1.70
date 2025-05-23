package com.tencent.component.media.image.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapRefDrawable extends BitmapDrawable {
    protected BitmapReference mBitmapRef;

    public BitmapRefDrawable() {
    }

    public BitmapReference getBitmapRef() {
        return this.mBitmapRef;
    }

    public boolean isMulible() {
        BitmapReference bitmapReference = this.mBitmapRef;
        if (bitmapReference != null) {
            return bitmapReference.isMutable();
        }
        return false;
    }

    public Drawable newDrawable() {
        return new BitmapRefDrawable(this.mBitmapRef);
    }

    public BitmapRefDrawable(BitmapReference bitmapReference) {
        super(bitmapReference == null ? null : bitmapReference.getBitmap());
        this.mBitmapRef = bitmapReference;
    }
}
