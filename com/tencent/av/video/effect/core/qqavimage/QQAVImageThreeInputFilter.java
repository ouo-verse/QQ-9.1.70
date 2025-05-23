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
public class QQAVImageThreeInputFilter extends QQAVImageFilter {
    public int filterInputTextureUniform2;
    public int filterInputTextureUniform3;
    public int filterSourceTexture2;
    public int filterSourceTexture3;
    public int filterTextureCoordinateAttribute2;
    public int filterTextureCoordinateAttribute3;
    private Bitmap mBitmap2;
    private Bitmap mBitmap3;
    private ByteBuffer mTextureCoordinatesBuffer2;
    private ByteBuffer mTextureCoordinatesBuffer3;

    public QQAVImageThreeInputFilter(String str) {
        this(String.valueOf(13), str);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.filterSourceTexture2}, 0);
        this.filterSourceTexture2 = -1;
        GLES20.glDeleteTextures(1, new int[]{this.filterSourceTexture3}, 0);
        this.filterSourceTexture3 = -1;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysPre() {
        GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.filterSourceTexture2);
        GLES20.glUniform1i(this.filterInputTextureUniform2, 3);
        GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute3);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.filterSourceTexture3);
        GLES20.glUniform1i(this.filterInputTextureUniform3, 5);
        this.mTextureCoordinatesBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.filterTextureCoordinateAttribute2, 2, 5126, false, 0, (Buffer) this.mTextureCoordinatesBuffer2);
        this.mTextureCoordinatesBuffer3.position(0);
        GLES20.glVertexAttribPointer(this.filterTextureCoordinateAttribute3, 2, 5126, false, 0, (Buffer) this.mTextureCoordinatesBuffer3);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        Bitmap bitmap;
        super.onInit();
        this.filterTextureCoordinateAttribute2 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
        this.filterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute2);
        this.filterTextureCoordinateAttribute3 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate3");
        this.filterInputTextureUniform3 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute3);
        Bitmap bitmap2 = this.mBitmap2;
        if (bitmap2 != null && (bitmap = this.mBitmap3) != null) {
            setBitmap(bitmap2, bitmap);
        }
    }

    public void setBitmap(final Bitmap bitmap, final Bitmap bitmap2) {
        this.mBitmap2 = bitmap;
        this.mBitmap3 = bitmap2;
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter.1
            @Override // java.lang.Runnable
            public void run() {
                if (QQAVImageThreeInputFilter.this.filterSourceTexture2 == -1) {
                    GLES20.glActiveTexture(33987);
                    QQAVImageThreeInputFilter.this.filterSourceTexture2 = OpenGlUtils.loadTexture(bitmap, -1, false);
                }
                if (QQAVImageThreeInputFilter.this.filterSourceTexture3 == -1) {
                    GLES20.glActiveTexture(33989);
                    QQAVImageThreeInputFilter.this.filterSourceTexture3 = OpenGlUtils.loadTexture(bitmap2, -1, false);
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
        this.mTextureCoordinatesBuffer2 = order;
        this.mTextureCoordinatesBuffer3 = order;
    }

    public QQAVImageThreeInputFilter(String str, String str2) {
        super(str, str2);
        this.filterSourceTexture2 = -1;
        this.filterSourceTexture3 = -1;
        setRotation(0, false, false);
    }
}
