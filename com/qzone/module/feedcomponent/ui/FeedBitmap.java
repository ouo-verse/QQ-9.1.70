package com.qzone.module.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class FeedBitmap {
    public static final int BITMAP_WIDTH = AreaConst.SCREEN_WIDTH - com.qzone.proxy.feedcomponent.util.g.a(10.0f);
    public int heightOffset;
    public boolean isUsed;
    protected Bitmap mBitmap;
    Canvas mCanvas;
    int mHeight;
    protected int mReferenceCount;
    protected int mType;

    /* JADX INFO: Access modifiers changed from: protected */
    public FeedBitmap(int i3) {
        this.mType = i3;
        if (i3 == 1) {
            int i16 = BitmapManager.MAINBODY_HEIGHT;
            this.mHeight = i16;
            this.mBitmap = Bitmap.createBitmap(BITMAP_WIDTH, i16, Bitmap.Config.ARGB_4444);
        } else {
            if (i3 != 2) {
                return;
            }
            int i17 = BitmapManager.COMMENT_HEIGHT;
            this.mHeight = i17;
            this.mBitmap = Bitmap.createBitmap(BITMAP_WIDTH, i17, Bitmap.Config.ARGB_4444);
        }
        Canvas canvas = new Canvas(this.mBitmap);
        this.mCanvas = canvas;
        canvas.drawColor(0);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Canvas getCanvas() {
        return this.mCanvas;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void reset() {
        this.heightOffset = 0;
        this.isUsed = false;
        this.mReferenceCount = 0;
    }
}
