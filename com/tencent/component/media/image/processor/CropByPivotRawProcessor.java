package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.RawImageProcessor;

/* loaded from: classes5.dex */
public class CropByPivotRawProcessor extends RawImageProcessor {
    private static final Paint sPaint = new Paint(3);
    private final int mHeight;
    private final float mPivotX;
    private final float mPivotY;
    private final int mWidth;

    public CropByPivotRawProcessor(int i3, int i16, float f16, float f17) {
        this.mWidth = i3;
        this.mHeight = i16;
        this.mPivotX = f16;
        this.mPivotY = f17;
    }

    public static boolean isGoldenCudgel(int i3, int i16) {
        if (Math.ceil(i3 * CropByPivotProcessor.GOLDEN_CUDGEL_RATIO) < i16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.media.image.SecondImageProcessor
    public String id() {
        return this.mWidth + "#" + this.mHeight + "#" + this.mPivotX + "#" + this.mPivotY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
    
        if (r0 < 0.0f) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r1 < 0.0f) goto L17;
     */
    @Override // com.tencent.component.media.image.SecondImageProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BitmapReference process(BitmapReference bitmapReference) {
        float f16;
        float f17;
        if (!isGoldenCudgel(bitmapReference.getWidth(), bitmapReference.getHeight())) {
            return bitmapReference;
        }
        int width = bitmapReference.getWidth();
        int height = bitmapReference.getHeight();
        int min = Math.min(this.mWidth, width);
        float f18 = min;
        float f19 = width;
        float f26 = f18 / f19;
        float f27 = height;
        int min2 = (int) Math.min(this.mHeight, f26 * f27);
        if (min >= width) {
            f26 = 1.0f;
        }
        int i3 = (int) (f19 * f26);
        int i16 = (int) (f27 * f26);
        int i17 = (int) (this.mPivotX * i3);
        int i18 = (int) (this.mPivotY * i16);
        if (i3 > min) {
            f16 = Math.min(i17 - (f18 * 0.5f), i3 - min);
        }
        f16 = 0.0f;
        if (i16 > min2) {
            f17 = Math.min(i18 - (min2 * 0.5f), i16 - min2);
        }
        f17 = 0.0f;
        BitmapReference bitmap = ImageManager.getInstance().getBitmap(min, min2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap.getBitmap());
        canvas.translate(-f16, -f17);
        canvas.scale(f26, f26);
        canvas.drawBitmap(bitmapReference.getBitmap(), 0.0f, 0.0f, sPaint);
        return bitmap;
    }
}
