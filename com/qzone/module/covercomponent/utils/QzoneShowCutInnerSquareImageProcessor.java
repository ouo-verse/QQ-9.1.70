package com.qzone.module.covercomponent.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;

/* loaded from: classes39.dex */
public class QzoneShowCutInnerSquareImageProcessor extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    private int f48739a;

    /* renamed from: b, reason: collision with root package name */
    private int f48740b;

    /* renamed from: c, reason: collision with root package name */
    private int f48741c;

    /* renamed from: d, reason: collision with root package name */
    private double f48742d;

    public QzoneShowCutInnerSquareImageProcessor(int i3, double d16) {
        this.f48739a = i3;
        this.f48742d = d16;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 101;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Bitmap createBitmap;
        try {
            Bitmap bitmap = ((ImageDrawable) drawable).getBitmapRef().getBitmap();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = this.f48739a;
            if (i3 > 0) {
                createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.RGB_565);
            } else {
                createBitmap = Bitmap.createBitmap(this.f48740b, this.f48741c, Bitmap.Config.RGB_565);
            }
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            if (height <= width) {
                width = height;
            }
            double d16 = this.f48742d;
            double d17 = width;
            int i16 = (int) ((1.0d - d16) * 0.5d * d17);
            int i17 = width - i16;
            int i18 = (int) (d16 * d17);
            if (this.f48739a > 0) {
                Rect rect = new Rect(i16, 0, i17, i18);
                int i19 = this.f48739a;
                canvas.drawBitmap(bitmap, rect, new Rect(0, 0, i19, i19), new Paint());
            } else {
                canvas.drawBitmap(bitmap, new Rect(i16, 0, i17, i18), new Rect(0, 0, this.f48740b, this.f48741c), new Paint());
            }
            return new SpecifiedBitmapDrawable(BitmapReference.getBitmapReference(createBitmap));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return drawable;
        }
    }

    public QzoneShowCutInnerSquareImageProcessor(int i3, int i16, double d16) {
        this.f48739a = -1;
        this.f48740b = i3;
        this.f48741c = i16;
        this.f48742d = d16;
    }
}
