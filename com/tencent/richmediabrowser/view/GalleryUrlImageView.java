package com.tencent.richmediabrowser.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.constant.DecoderType;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

/* compiled from: P */
/* loaded from: classes25.dex */
public class GalleryUrlImageView extends BrowserURLImageView {
    private IGalleryImageListener imageListener;
    private boolean isOriginalImage;
    public RichMediaBrowserInfo mImageInfo;
    private int mPosition;

    public GalleryUrlImageView(Context context) {
        super(context);
        this.isOriginalImage = false;
    }

    public static int getInSampleSize(int i3, int i16, int i17, int i18) {
        int i19 = 1;
        while (true) {
            if (i17 <= i16 && i18 <= i3) {
                break;
            }
            int round = Math.round(i17 / i16);
            int round2 = Math.round(i18 / i3);
            if (round <= round2) {
                round = round2;
            }
            if (round < 2) {
                break;
            }
            i18 /= 2;
            i17 /= 2;
            i19 *= 2;
        }
        return i19;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public Drawable getDrawable() {
        return super.getDrawable();
    }

    public Bitmap getRegionBmp(Rect rect, Matrix matrix, int i3, int i16) {
        Rect rect2 = new Rect(0, 0, i3, i16);
        rect2.offset(-rect.left, -rect.top);
        RectF rectF = new RectF(rect2);
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        RectF rectF2 = new RectF();
        matrix2.mapRect(rectF2, rectF);
        rectF2.intersect(0.0f, 0.0f, rect.width(), rect.height());
        int width = (int) (i3 / (rectF2.width() / rectF2.height()));
        int inSampleSize = getInSampleSize(1280, 1280, i3, width);
        if (inSampleSize > 1) {
            i3 /= inSampleSize;
            width /= inSampleSize;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix3 = new Matrix();
        float width2 = i3 / rectF2.width();
        matrix3.postTranslate(-rectF2.left, -rectF2.top);
        matrix3.postScale(width2, width2);
        canvas.setMatrix(matrix3);
        draw(canvas);
        return createBitmap;
    }

    public boolean isOriginalImage() {
        return this.isOriginalImage;
    }

    @Override // com.tencent.richmediabrowser.view.BrowserURLImageView, com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IGalleryImageListener iGalleryImageListener;
        super.onLoadFialed(uRLDrawable, th5);
        String ref = uRLDrawable.getURL().getRef();
        if ((ref == null || !ref.equals(DecoderType.DECODER_DISPLAY)) && (iGalleryImageListener = this.imageListener) != null) {
            iGalleryImageListener.onLoadSuccessed(this.mPosition, false);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserURLImageView, com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IGalleryImageListener iGalleryImageListener;
        String ref = uRLDrawable.getURL().getRef();
        if (ref != null && ref.equals(DecoderType.DECODER_ORIGINAL)) {
            this.ignoreLayout = true;
            super.onLoadSuccessed(uRLDrawable);
            this.ignoreLayout = false;
            IGalleryImageListener iGalleryImageListener2 = this.imageListener;
            if (iGalleryImageListener2 != null) {
                iGalleryImageListener2.onLoadSuccessed(this.mPosition, true);
            }
        } else {
            super.onLoadSuccessed(uRLDrawable);
            if ((ref == null || !ref.equals(DecoderType.DECODER_DISPLAY)) && (iGalleryImageListener = this.imageListener) != null) {
                iGalleryImageListener.onLoadSuccessed(this.mPosition, true);
            }
        }
        IGalleryImageListener iGalleryImageListener3 = this.imageListener;
        if (iGalleryImageListener3 != null) {
            iGalleryImageListener3.onLoadDrawable(this.mPosition, uRLDrawable);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserURLImageView
    public void setDecodingDrawble(URLDrawable uRLDrawable) {
        super.setDecodingDrawble(uRLDrawable);
    }

    public void setGalleryImageListener(IGalleryImageListener iGalleryImageListener) {
        this.imageListener = iGalleryImageListener;
    }

    public void setIgnoreLayout(boolean z16) {
        this.ignoreLayout = z16;
    }

    public void setImageInfo(RichMediaBrowserInfo richMediaBrowserInfo) {
        this.mImageInfo = richMediaBrowserInfo;
    }

    public void setOriginalImage(boolean z16) {
        this.isOriginalImage = z16;
    }

    public void setPosition(int i3) {
        this.mPosition = i3;
    }

    public GalleryUrlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOriginalImage = false;
    }
}
