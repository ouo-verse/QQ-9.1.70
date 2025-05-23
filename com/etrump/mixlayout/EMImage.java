package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EMImage {
    public static final int IMAGE_FORMAT_BMP = 1;
    public static final int IMAGE_FORMAT_GIF = 4;
    public static final int IMAGE_FORMAT_JPG = 3;
    public static final int IMAGE_FORMAT_PNG = 2;
    public static final int IMAGE_FORMAT_RAW = 0;
    private int mType = 0;
    private Bitmap mBitmap = null;
    private byte[] mRawData = null;

    public static void callbackDrawText(int i3, Canvas canvas, Matrix matrix, float f16, float f17, float f18, float f19, int i16, boolean z16, int i17, int i18, int i19, int i26, boolean z17, int i27, int i28) {
        if (canvas == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("");
        sb5.appendCodePoint(i3);
        String sb6 = sb5.toString();
        Paint paint = new Paint();
        paint.reset();
        paint.setColor(i16);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(f19);
        canvas.save();
        canvas.setMatrix(matrix);
        if (z16) {
            paint.setShadowLayer(i26 == 0 ? 0.1f : i26, i18, i19, i17);
        }
        canvas.drawText(sb6, 0.0f, f16, paint);
        if (z17) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(i27);
            paint.setStrokeWidth(i28);
            paint.setTextSize(f19);
            canvas.drawText(sb6, 0.0f, f16, paint);
        }
        canvas.restore();
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public byte[] getBytes() {
        return this.mRawData;
    }

    public int getType() {
        return this.mType;
    }
}
