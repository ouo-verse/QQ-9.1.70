package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageTwoSrcFilter extends QQAVImageThreeInputFilter {
    private int mHeightLocation;
    private int mWidthLocation;

    public QQAVImageTwoSrcFilter() {
        super(String.valueOf(37));
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
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
