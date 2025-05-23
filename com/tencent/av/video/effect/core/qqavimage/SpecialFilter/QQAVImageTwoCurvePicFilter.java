package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

/* loaded from: classes3.dex */
public class QQAVImageTwoCurvePicFilter extends QQAVImageThreeInputFilter {
    public QQAVImageTwoCurvePicFilter(int i3) {
        super(String.valueOf(getShaderBySubId(i3)));
    }

    private static int getShaderBySubId(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return 30;
            }
            return 32;
        }
        return 31;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void setBitmap(int i3, Bitmap bitmap) {
        if ((bitmap != null && bitmap.isRecycled()) || bitmap == null) {
            return;
        }
        if (i3 == 0) {
            this.filterSourceTexture2 = OpenGlUtils.loadTexture(bitmap, this.filterSourceTexture2, false);
        } else if (i3 == 1) {
            this.filterSourceTexture3 = OpenGlUtils.loadTexture(bitmap, this.filterSourceTexture3, false);
        }
    }
}
