package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

/* loaded from: classes3.dex */
public class QQAVImageSingleCurvePicFilter extends QQAVImageTwoInputFilter {
    public QQAVImageSingleCurvePicFilter() {
        super(String.valueOf(33));
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void setBitmap(int i3, Bitmap bitmap) {
        if ((bitmap != null && bitmap.isRecycled()) || bitmap == null) {
            return;
        }
        this.mFilterSourceTexture2 = OpenGlUtils.loadTexture(bitmap, this.mFilterSourceTexture2, false);
    }
}
