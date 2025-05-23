package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageTwoInputFilter extends QQAVImageFilter {
    private Bitmap mBitmap;
    public int mFilterInputTextureUniform2;
    public int mFilterSecondTextureCoordinateAttribute;
    public int mFilterSourceTexture2;
    private ByteBuffer mTexture2CoordinatesBuffer;

    public QQAVImageTwoInputFilter(String str) {
        this(String.valueOf(24), str);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.mFilterSourceTexture2}, 0);
        this.mFilterSourceTexture2 = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDrawArraysAfter() {
        int i3 = this.mFilterSecondTextureCoordinateAttribute;
        if (i3 != -1) {
            GLES20.glDisableVertexAttribArray(i3);
        }
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glActiveTexture(33984);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDrawArraysPre() {
        int i3 = this.mFilterSecondTextureCoordinateAttribute;
        if (i3 != -1) {
            GLES20.glEnableVertexAttribArray(i3);
            this.mTexture2CoordinatesBuffer.position(0);
            GLES20.glVertexAttribPointer(this.mFilterSecondTextureCoordinateAttribute, 2, 5126, false, 0, (Buffer) this.mTexture2CoordinatesBuffer);
        }
        if (this.mFilterInputTextureUniform2 != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFilterSourceTexture2);
            GLES20.glUniform1i(this.mFilterInputTextureUniform2, 3);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mFilterSecondTextureCoordinateAttribute = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
        this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.mFilterSecondTextureCoordinateAttribute);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            setBitmap(this.mBitmap);
        }
    }

    public void recycleBitmap() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }

    public void setBitmap(final Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            return;
        }
        this.mBitmap = bitmap;
        if (bitmap == null) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (QQAVImageTwoInputFilter.this.mFilterSourceTexture2 == -1 && (bitmap2 = bitmap) != null && !bitmap2.isRecycled()) {
                    GLES20.glActiveTexture(33987);
                    QQAVImageTwoInputFilter.this.mFilterSourceTexture2 = OpenGlUtils.loadTexture(bitmap, -1, false);
                }
            }
        });
    }

    public void setRotation(int i3, boolean z16, boolean z17) {
        float[] rotation = TextureRotationUtil.getRotation(i3, z16, z17);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(rotation);
        asFloatBuffer.flip();
        this.mTexture2CoordinatesBuffer = order;
    }

    public QQAVImageTwoInputFilter(String str, String str2) {
        super(str, str2);
        this.mFilterSourceTexture2 = -1;
        setRotation(0, false, false);
    }
}
