package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes20.dex */
public class VipPngBitmap implements INinePathBitmap {
    public Bitmap mBitmap;
    public NinePatch mNinePatch;

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void draw(Canvas canvas, Rect rect, Rect rect2, Paint paint) {
        NinePatch ninePatch = this.mNinePatch;
        if (ninePatch != null) {
            if (paint != null) {
                ninePatch.draw(canvas, rect2, paint);
            }
        } else {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null && paint != null) {
                canvas.drawBitmap(bitmap, rect, rect2, paint);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void next(Bitmap bitmap) {
        if (bitmap != null) {
            this.mBitmap = bitmap;
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                this.mNinePatch = new NinePatch(this.mBitmap, ninePatchChunk, null);
            } else {
                this.mNinePatch = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void recycle() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
    }
}
