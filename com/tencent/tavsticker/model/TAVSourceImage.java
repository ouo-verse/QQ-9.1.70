package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.tav.coremedia.TextureInfo;
import org.libpag.PAGImage;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSourceImage {
    private static final String TAG = "TAVSourceImage";
    private int index;
    private Matrix matrix;
    private PAGImage pagImage;

    public TAVSourceImage(Bitmap bitmap, int i3) {
        this.pagImage = null;
        this.matrix = null;
        this.index = 0;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.pagImage = PAGImage.FromBitmap(bitmap);
            this.index = i3;
            return;
        }
        throw new IllegalArgumentException("<init> parameter 'bitmap' is illegal!");
    }

    public int getIndex() {
        return this.index;
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public PAGImage getPagImage() {
        return this.pagImage;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
        PAGImage pAGImage = this.pagImage;
        if (pAGImage != null) {
            pAGImage.setMatrix(matrix);
        }
    }

    public TAVSourceImage(TextureInfo textureInfo, int i3) {
        this(textureInfo, false, i3);
    }

    public TAVSourceImage(TextureInfo textureInfo, boolean z16, int i3) {
        this.pagImage = null;
        this.matrix = null;
        this.index = 0;
        if (textureInfo != null) {
            this.pagImage = PAGImage.FromTexture(textureInfo.textureID, textureInfo.textureType, textureInfo.width, textureInfo.height, z16);
        }
        this.index = i3;
    }
}
