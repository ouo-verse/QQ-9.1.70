package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.component.media.utils.BitmapUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapReference {
    private static final String TAG = "BitmapReference";
    private static Releaser<Bitmap> sReleaser;
    private volatile boolean isReleased = false;
    private Bitmap mBitmap;
    private static Set<Bitmap> sBitmapMemSet = Collections.synchronizedSet(new HashSet());
    static int releaseCount = 0;

    BitmapReference() {
    }

    @TargetApi(19)
    public static BitmapReference getBitmapReference(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            BitmapReference bitmapReference = new BitmapReference();
            bitmapReference.mBitmap = bitmap;
            if (!ImageManager.sCloseNativeAndCache && bitmap.isMutable()) {
                sBitmapMemSet.add(bitmap);
            }
            return bitmapReference;
        }
        return null;
    }

    public static void setGlobalReleaser(Releaser<Bitmap> releaser) {
        sReleaser = releaser;
    }

    protected void finalize() throws Throwable {
        try {
            release();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final int getAllocSize() {
        return BitmapUtils.getBitmapAllocSize(this.mBitmap);
    }

    public Bitmap getBitmap() {
        if (this.mBitmap.isRecycled()) {
            return null;
        }
        return this.mBitmap;
    }

    public final Bitmap.Config getConfig() {
        return this.mBitmap.getConfig();
    }

    public final int getHeight() {
        return this.mBitmap.getHeight();
    }

    public final int getRowBytes() {
        return this.mBitmap.getRowBytes();
    }

    public final int getWidth() {
        return this.mBitmap.getWidth();
    }

    public final boolean hasAlpha() {
        return this.mBitmap.hasAlpha();
    }

    public final boolean isMutable() {
        return this.mBitmap.isMutable();
    }

    public final boolean isRecycled() {
        return this.mBitmap.isRecycled();
    }

    @TargetApi(19)
    public void release() {
        if (!this.isReleased && !ImageManager.sCloseNativeAndCache) {
            this.isReleased = true;
            if (!sBitmapMemSet.remove(this.mBitmap) || this.mBitmap.isRecycled() || !this.mBitmap.isMutable()) {
                return;
            }
            Releaser<Bitmap> releaser = sReleaser;
            if (releaser != null) {
                releaser.release(this.mBitmap);
            } else {
                this.mBitmap.recycle();
            }
        }
    }
}
