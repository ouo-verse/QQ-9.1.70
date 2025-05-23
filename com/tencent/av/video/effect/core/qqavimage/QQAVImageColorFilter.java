package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class QQAVImageColorFilter extends QQAVImageFilter {
    protected int[] GL_TEXTURES;
    protected Bitmap[] bitmaps;
    protected int[] coordinateAttributes;
    protected FloatBuffer[] coordinatesBuffers;
    protected int[] inputTextureUniforms;
    protected int[] sourceTextures;
    protected int textureNum;

    public QQAVImageColorFilter(String str, int i3) {
        this(String.valueOf(15), str, i3);
    }

    private void loadBitmap(int i3, Bitmap bitmap) {
        if ((bitmap == null || !bitmap.isRecycled()) && bitmap != null && !bitmap.isRecycled() && this.sourceTextures[i3] == -1) {
            GLES20.glActiveTexture(this.GL_TEXTURES[i3]);
            this.sourceTextures[i3] = OpenGlUtils.loadTexture(bitmap, -1, false);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        super.onDestroy();
        if (this.textureNum > 0) {
            try {
                GLES20.glDeleteTextures(1, this.sourceTextures, 0);
                for (int i3 = 0; i3 < this.textureNum; i3++) {
                    this.sourceTextures[i3] = -1;
                    Bitmap bitmap = this.bitmaps[i3];
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.bitmaps[i3].recycle();
                        this.bitmaps[i3] = null;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysPre() {
        for (int i3 = 0; i3 < this.textureNum; i3++) {
            int i16 = this.coordinateAttributes[i3];
            if (i16 != -1) {
                GLES20.glEnableVertexAttribArray(i16);
                this.coordinatesBuffers[i3].position(0);
                GLES20.glVertexAttribPointer(this.coordinateAttributes[i3], 2, 5126, false, 0, (Buffer) this.coordinatesBuffers[i3]);
            }
            if (this.inputTextureUniforms[i3] != -1) {
                GLES20.glActiveTexture(this.GL_TEXTURES[i3]);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.sourceTextures[i3]);
                GLES20.glUniform1i(this.inputTextureUniforms[i3], i3 + 3);
            }
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        for (int i3 = 0; i3 < this.textureNum; i3++) {
            int i16 = i3 + 2;
            this.coordinateAttributes[i3] = GLES20.glGetAttribLocation(getProgram(), String.format("inputTextureCoordinate%d", Integer.valueOf(i16)));
            this.inputTextureUniforms[i3] = GLES20.glGetUniformLocation(getProgram(), String.format("inputImageTexture%d", Integer.valueOf(i16)));
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void setBitmap(int i3, Bitmap bitmap) {
        if ((bitmap != null && bitmap.isRecycled()) || bitmap == null) {
            return;
        }
        this.bitmaps[i3] = bitmap;
        if (!bitmap.isRecycled()) {
            loadBitmap(i3, this.bitmaps[i3]);
        }
    }

    public void setRotation(int i3, boolean z16, boolean z17) {
        float[] fArr = OpenGlUtils.CUBE8;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        for (int i16 = 0; i16 < this.textureNum; i16++) {
            this.coordinatesBuffers[i16] = asFloatBuffer;
        }
    }

    public QQAVImageColorFilter(String str, String str2, int i3) {
        super(str, str2);
        this.GL_TEXTURES = new int[]{33987, 33988, 33989, 33990, 33991, 33992};
        this.textureNum = i3;
        this.coordinateAttributes = new int[i3];
        this.inputTextureUniforms = new int[i3];
        this.sourceTextures = new int[i3];
        int i16 = 0;
        while (true) {
            int i17 = this.textureNum;
            if (i16 < i17) {
                this.sourceTextures[i16] = -1;
                i16++;
            } else {
                this.coordinatesBuffers = new FloatBuffer[i17];
                this.bitmaps = new Bitmap[i17];
                setRotation(0, false, false);
                return;
            }
        }
    }
}
