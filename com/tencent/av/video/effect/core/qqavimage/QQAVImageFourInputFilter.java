package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageFourInputFilter extends QQAVImageFilter {
    public int mFilterInputTextureUniform2;
    public int mFilterInputTextureUniform3;
    public int mFilterInputTextureUniform4;
    public int mFilterSourceTexture2;
    public int mFilterSourceTexture3;
    public int mFilterSourceTexture4;
    public int mFilterTextureCoordinateAttribute2;
    public int mFilterTextureCoordinateAttribute3;
    public int mFilterTextureCoordinateAttribute4;
    private ByteBuffer mTextureCoordinatesBuffer2;
    private ByteBuffer mTextureCoordinatesBuffer3;
    private ByteBuffer mTextureCoordinatesBuffer4;

    public QQAVImageFourInputFilter(String str) {
        this(String.valueOf(29), str);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.mFilterSourceTexture2}, 0);
        this.mFilterSourceTexture2 = -1;
        GLES20.glDeleteTextures(1, new int[]{this.mFilterSourceTexture3}, 0);
        this.mFilterSourceTexture3 = -1;
        GLES20.glDeleteTextures(1, new int[]{this.mFilterSourceTexture4}, 0);
        this.mFilterSourceTexture4 = -1;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysPre() {
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFilterSourceTexture2);
        GLES20.glUniform1i(this.mFilterInputTextureUniform2, 3);
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute3);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFilterSourceTexture3);
        GLES20.glUniform1i(this.mFilterInputTextureUniform3, 4);
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute4);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFilterSourceTexture4);
        GLES20.glUniform1i(this.mFilterInputTextureUniform4, 5);
        this.mTextureCoordinatesBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute2, 2, 5126, false, 0, (Buffer) this.mTextureCoordinatesBuffer2);
        this.mTextureCoordinatesBuffer3.position(0);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute3, 2, 5126, false, 0, (Buffer) this.mTextureCoordinatesBuffer3);
        this.mTextureCoordinatesBuffer4.position(0);
        GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute4, 2, 5126, false, 0, (Buffer) this.mTextureCoordinatesBuffer4);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mFilterTextureCoordinateAttribute2 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
        this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute2);
        this.mFilterTextureCoordinateAttribute3 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate3");
        this.mFilterInputTextureUniform3 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute3);
        this.mFilterTextureCoordinateAttribute4 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate4");
        this.mFilterInputTextureUniform4 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture4");
        GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute4);
    }

    public void setRotation(int i3, boolean z16, boolean z17) {
        float[] rotation = TextureRotationUtil.getRotation(i3, z16, z17);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(rotation);
        asFloatBuffer.flip();
        this.mTextureCoordinatesBuffer2 = order;
        this.mTextureCoordinatesBuffer3 = order;
        this.mTextureCoordinatesBuffer4 = order;
    }

    public QQAVImageFourInputFilter(String str, String str2) {
        super(str, str2);
        this.mFilterSourceTexture2 = -1;
        this.mFilterSourceTexture3 = -1;
        this.mFilterSourceTexture4 = -1;
        setRotation(0, false, false);
    }
}
