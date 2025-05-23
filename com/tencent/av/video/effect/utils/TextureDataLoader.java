package com.tencent.av.video.effect.utils;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextureDataLoader {
    public static final int NO_PROGRAM = 0;
    public static final String YUV_FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform int yuvFormat;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform mat4 colorMat;\nvoid main() {\n    vec3 yuvData;\n    yuvData.x = texture2D(inputImageTexture0, textureCoordinate).x;\n    if(yuvFormat==1){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.y = uv.x;\n        yuvData.z = uv.y;\n    }else if(yuvFormat==2){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.z = uv.x;\n        yuvData.y = uv.y;\n    }else{\n        yuvData.y = texture2D(inputImageTexture1, textureCoordinate).x;\n        yuvData.z = texture2D(inputImageTexture2, textureCoordinate).x;\n    }\n    vec4 rgbData =  colorMat*vec4(yuvData,1.0);\n    gl_FragColor  = vec4(rgbData.rgb,1.0);\n}";
    public static final String YUV_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    private int mGLAttribPosition;
    private int mGLAttribTextureCoordinate;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private int mGLUniformColorMat;
    private int mGLUniformTexture0;
    private int mGLUniformTexture1;
    private int mGLUniformTexture2;
    private int mGLUniformYuvFormat;
    private int[] mYuvTempTextureId;
    public static float[] YUV_2_RGB_MATRIX = {1.0f, 1.0f, 1.0f, 0.0f, 9.3E-4f, -0.3437f, 1.77216f, 0.0f, 1.401687f, -0.71417f, 9.9E-4f, 0.0f, -0.7011f, 0.525f, -0.8828f, 1.0f};
    static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static final float[] TEXTURE_COORDINATE = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private ByteBuffer mDataBuffer = null;
    int mResultFBOReleTextureId = -1;
    int mResultFBO = -1;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mProgramId = 0;

    public TextureDataLoader() {
        this.mYuvTempTextureId = r0;
        int[] iArr = {-1, -1, -1};
        float[] fArr = CUBE;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = TEXTURE_COORDINATE;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
    }

    private void createResultFBO(int i3, int i16, int i17) {
        int i18 = this.mResultFBO;
        if (i18 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i18}, 0);
            this.mResultFBO = -1;
        }
        this.mResultFBO = initFrameBuffer(i3, i16, i17);
    }

    private static int initFrameBuffer(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i17, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return iArr[0];
    }

    public void destroy() {
        this.mWidth = 0;
        this.mHeight = 0;
        ByteBuffer byteBuffer = this.mDataBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.mDataBuffer = null;
        }
        int i3 = this.mResultFBO;
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.mResultFBO = -1;
            this.mResultFBOReleTextureId = -1;
        }
        int[] iArr = this.mYuvTempTextureId;
        if (iArr[0] != -1) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            int[] iArr2 = this.mYuvTempTextureId;
            iArr2[0] = -1;
            iArr2[1] = -1;
            iArr2[2] = -1;
        }
    }

    public EffectTexture loadDataToTexture(byte[] bArr, ColorFormat colorFormat, int i3, int i16, int i17) {
        int i18;
        if (bArr != null && bArr.length != 0 && i3 != 0 && i16 != 0) {
            int[] iArr = new int[1];
            if (i17 == -1) {
                GLES20.glGenTextures(1, iArr, 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            } else {
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
                iArr[0] = i17;
            }
            int i19 = iArr[0];
            if (this.mWidth != i3 || this.mHeight != i16) {
                this.mWidth = i3;
                this.mHeight = i16;
                ByteBuffer byteBuffer = this.mDataBuffer;
                if (byteBuffer != null) {
                    byteBuffer.clear();
                }
                this.mDataBuffer = ByteBuffer.allocate(this.mWidth * this.mHeight * 4);
                createResultFBO(i3, i16, i19);
                this.mResultFBOReleTextureId = i19;
            }
            if (this.mResultFBOReleTextureId != i19) {
                createResultFBO(this.mWidth, this.mHeight, i19);
                this.mResultFBOReleTextureId = i19;
            }
            if (this.mProgramId == 0) {
                int loadProgram = OpenGlUtils.loadProgram("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", YUV_FRAGMENT_SHADER);
                this.mProgramId = loadProgram;
                this.mGLAttribPosition = GLES20.glGetAttribLocation(loadProgram, "position");
                this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mProgramId, "inputTextureCoordinate");
                this.mGLUniformTexture0 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture0");
                this.mGLUniformTexture1 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture1");
                this.mGLUniformTexture2 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture2");
                this.mGLUniformYuvFormat = GLES20.glGetUniformLocation(this.mProgramId, "yuvFormat");
                this.mGLUniformColorMat = GLES20.glGetUniformLocation(this.mProgramId, "colorMat");
            }
            int[] iArr2 = this.mYuvTempTextureId;
            if (iArr2[0] == -1) {
                GLES20.glGenTextures(iArr2.length, iArr2, 0);
            }
            if (colorFormat == ColorFormat.RGBA) {
                this.mDataBuffer.position(0);
                this.mDataBuffer.put(bArr, 0, i3 * i16 * 4);
                this.mDataBuffer.position(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mResultFBOReleTextureId);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mDataBuffer);
                i18 = i19;
            } else {
                this.mDataBuffer.position(0);
                int i26 = i3 * i16;
                this.mDataBuffer.put(bArr, 0, i26);
                this.mDataBuffer.position(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[0]);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                i18 = i19;
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i3, i16, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mDataBuffer);
                ColorFormat colorFormat2 = ColorFormat.NV12;
                if (colorFormat != colorFormat2 && colorFormat != ColorFormat.NV21) {
                    this.mDataBuffer.position(0);
                    int i27 = i26 / 4;
                    this.mDataBuffer.put(bArr, i26, i27);
                    this.mDataBuffer.position(0);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[1]);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                    int i28 = i3 / 2;
                    int i29 = i16 / 2;
                    GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i28, i29, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mDataBuffer);
                    this.mDataBuffer.position(0);
                    this.mDataBuffer.put(bArr, i26 + i27, i27);
                    this.mDataBuffer.position(0);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[2]);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                    GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i28, i29, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mDataBuffer);
                } else {
                    this.mDataBuffer.position(0);
                    this.mDataBuffer.put(bArr, i26, i26 / 2);
                    this.mDataBuffer.position(0);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[1]);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                    GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.RG8, i3 / 2, i16 / 2, 0, MonetPacketDescriptor.MonetDataFormat.RG8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mDataBuffer);
                }
                GLES20.glBindFramebuffer(36160, this.mResultFBO);
                GLES20.glViewport(0, 0, i3, i16);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                GLES20.glUseProgram(this.mProgramId);
                GLES20.glUniformMatrix4fv(this.mGLUniformColorMat, 1, false, YUV_2_RGB_MATRIX, 0);
                if (colorFormat == colorFormat2) {
                    GLES20.glUniform1i(this.mGLUniformYuvFormat, 1);
                } else if (colorFormat == ColorFormat.NV21) {
                    GLES20.glUniform1i(this.mGLUniformYuvFormat, 2);
                } else {
                    GLES20.glUniform1i(this.mGLUniformYuvFormat, 3);
                }
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[0]);
                GLES20.glUniform1i(this.mGLUniformTexture0, 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[1]);
                GLES20.glUniform1i(this.mGLUniformTexture1, 1);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mYuvTempTextureId[2]);
                GLES20.glUniform1i(this.mGLUniformTexture2, 2);
                this.mGLCubeBuffer.position(0);
                GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, (Buffer) this.mGLCubeBuffer);
                this.mGLTextureBuffer.position(0);
                GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
                GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, (Buffer) this.mGLTextureBuffer);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
            return new EffectTexture(i18, this.mResultFBO, this.mWidth, this.mHeight);
        }
        return new EffectTexture(i17, -1, i3, i16);
    }
}
