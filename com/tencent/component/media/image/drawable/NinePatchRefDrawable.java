package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.component.media.image.BitmapReference;

/* loaded from: classes5.dex */
public class NinePatchRefDrawable extends NinePatchDrawable {
    private byte[] chunk;
    private BitmapReference mBitmapRef;
    private Rect padding;
    private Resources res;
    private String srcName;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NinePatchRefDrawable(Resources resources, BitmapReference bitmapReference, byte[] bArr, Rect rect, String str) {
        super(resources, r0, bArr, rect, str);
        Bitmap bitmap;
        if (bitmapReference == null) {
            bitmap = null;
        } else {
            bitmap = bitmapReference.getBitmap();
        }
        this.mBitmapRef = bitmapReference;
        this.res = resources;
        this.chunk = bArr;
        this.padding = rect;
        this.srcName = str;
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

    public Drawable newInstance() {
        try {
            return new NinePatchRefDrawable(this.res, this.mBitmapRef, this.chunk, this.padding, this.srcName);
        } catch (Exception e16) {
            e16.printStackTrace();
            return this;
        }
    }
}
