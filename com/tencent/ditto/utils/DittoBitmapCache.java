package com.tencent.ditto.utils;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoBitmapCache {
    private Bitmap mBitmap;

    protected void finalize() throws Throwable {
        this.mBitmap = null;
        super.finalize();
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.mBitmap == null) {
            this.mBitmap = bitmap;
            return;
        }
        throw new RuntimeException("delicately set bitmap");
    }
}
