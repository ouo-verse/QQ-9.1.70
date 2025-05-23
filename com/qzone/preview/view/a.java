package com.qzone.preview.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.qzone.reborn.util.h;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends ImageProcessor {

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f50087c = new Paint(6);

    /* renamed from: a, reason: collision with root package name */
    private int f50088a;

    /* renamed from: b, reason: collision with root package name */
    private int f50089b;

    public a(int i3, int i16) {
        this.f50088a = i3;
        this.f50089b = i16;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return getClass().hashCode() + this.f50088a + this.f50089b;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        float width;
        float height;
        BitmapReference bitmapReference;
        BitmapReference a16 = h.a(drawable);
        if (a16.getWidth() == this.f50088a && a16.getHeight() == this.f50089b) {
            return new BitmapRefDrawable(a16);
        }
        Matrix matrix = new Matrix();
        float f16 = 0.0f;
        if (a16.getWidth() * this.f50089b > this.f50088a * a16.getHeight()) {
            width = this.f50089b / a16.getHeight();
            f16 = (this.f50088a - (a16.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f50088a / a16.getWidth();
            height = (this.f50089b - (a16.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f16 + 0.5f), (int) (height + 0.5f));
        try {
            try {
                bitmapReference = ImageManager.getInstance().getBitmap(this.f50088a, this.f50089b, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                bitmapReference = ImageManager.getInstance().getBitmap(this.f50088a, this.f50089b, Bitmap.Config.ARGB_4444);
            }
        } catch (Exception e16) {
            QZLog.e("PictureCenterCropProcessor", e16.getMessage());
            bitmapReference = null;
        }
        if (bitmapReference == null) {
            return drawable;
        }
        QZLog.e("PictureCenterCropProcessor", "PictureCenterCropProcessor process");
        Canvas canvas = new Canvas(bitmapReference.getBitmap());
        canvas.drawBitmap(a16.getBitmap(), matrix, f50087c);
        canvas.setBitmap(null);
        return new BitmapRefDrawable(bitmapReference);
    }
}
