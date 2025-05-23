package com.tencent.mobileqq.shortvideo.videotransfer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TransferInstFilter extends GPUBaseFilter {
    public static final String DEFAULT_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
    public static final String DEFAULT_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}";
    private static final String TAG = "TransferInstFilter";
    private int iResolution;
    private int mAttrMVPMatrix;
    private int mAttrPosition;
    private int mAttrTextureCoord;
    private int mAttrTextureMatrix;
    private float[] mCommonFloats;
    private int mCurrentTimeMs;
    private float[] mDefaultMvpMatirx;
    private float[] mDefaultTextureMatirx;
    private int mEndTimeMs;
    private int mInputTextureID;
    private int mOffsetLocation;
    private int mOutputTextureID;
    private RenderBuffer mRenderFBO;
    private int mSampleSizeLoc;
    private int mStartTimeMs;
    private int mUniCommonParam;
    private int mUniCurrentTime;
    private int mUniInputTexture;
    private int mUniInputTexture2;
    private int mUniInputTexture2Size;
    private int mUniInputTextureSize;
    private int mUniTimeRange;
    private int mWeightsLoc;
    private int shaderID;
    private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.VERTEXT_COORDS);
    private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);
    private static final float[] BLURWEIGHTS = {0.041555f, 0.041348f, 0.040733f, 0.039728f, 0.038363f, 0.036676f, 0.034715f, 0.032532f, 0.030183f, 0.027726f, 0.025215f, 0.022704f, 0.020239f, 0.017863f, 0.015609f, 0.013504f, 0.011566f, 0.009808f, 0.008235f, 0.006845f, 0.005633f};

    public TransferInstFilter(String str, String str2) {
        super(str, str2);
        this.mAttrPosition = -1;
        this.mAttrTextureCoord = -1;
        this.mAttrMVPMatrix = -1;
        this.mAttrTextureMatrix = -1;
        this.mUniInputTexture = -1;
        this.mUniInputTexture2 = -1;
        this.mUniInputTextureSize = -1;
        this.mUniInputTexture2Size = -1;
        this.mUniTimeRange = -1;
        this.mUniCurrentTime = -1;
        this.mUniCommonParam = -1;
        this.mOffsetLocation = -1;
        this.mSampleSizeLoc = -1;
        this.mWeightsLoc = -1;
        this.iResolution = -1;
        this.mCurrentTimeMs = 0;
        this.mStartTimeMs = 0;
        this.mEndTimeMs = 0;
        this.mCommonFloats = new float[4];
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void destroy() {
        super.destroy();
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.mRenderFBO = null;
        }
    }

    public boolean drawTexture(int i3, int i16, float[] fArr, float[] fArr2) {
        RenderBuffer renderBuffer;
        int i17 = this.mCurrentTimeMs;
        if (i17 <= this.mEndTimeMs && i17 >= this.mStartTimeMs) {
            GPUBaseFilter.checkGlError("onDrawFrame start");
            if (fArr == null) {
                fArr = this.mDefaultTextureMatirx;
            }
            if (fArr2 == null) {
                fArr2 = this.mDefaultMvpMatirx;
            }
            int program = getProgram();
            if (program > 0 && (renderBuffer = this.mRenderFBO) != null) {
                renderBuffer.bind();
                GLES20.glUseProgram(program);
                GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
                GPUBaseFilter.checkGlError("glVertexAttribPointer mAttrPosition");
                GLES20.glEnableVertexAttribArray(this.mAttrPosition);
                GPUBaseFilter.checkGlError("glEnableVertexAttribArray mAttrPosition");
                GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
                GPUBaseFilter.checkGlError("glVertexAttribPointer mAttrTextureCoord");
                GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
                GPUBaseFilter.checkGlError("glEnableVertexAttribArray mAttrTextureCoord");
                int i18 = this.mAttrMVPMatrix;
                if (i18 >= 0) {
                    GLES20.glUniformMatrix4fv(i18, 1, false, fArr2, 0);
                    GPUBaseFilter.checkGlError("glUniformMatrix4fv mAttrMVPMatrix");
                }
                int i19 = this.mAttrTextureMatrix;
                if (i19 >= 0) {
                    GLES20.glUniformMatrix4fv(i19, 1, false, fArr, 0);
                    GPUBaseFilter.checkGlError("glUniformMatrix4fv mAttrTextureMatrix");
                }
                if (this.mInputTextureID >= 0) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(this.mTextureType, this.mInputTextureID);
                    GLES20.glUniform1i(this.mUniInputTexture, 0);
                }
                if (i16 >= 0) {
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(this.mTextureType, i16);
                    GLES20.glUniform1i(this.mUniInputTexture2, 1);
                }
                int i26 = this.mUniInputTextureSize;
                if (i26 >= 0) {
                    GLES20.glUniform2f(i26, this.mOutputWidth, this.mOutputHeight);
                    GPUBaseFilter.checkGlError("glUniform2f mUniInputTextureSize");
                }
                int i27 = this.mUniInputTexture2Size;
                if (i27 >= 0) {
                    GLES20.glUniform2f(i27, this.mOutputWidth, this.mOutputHeight);
                    GPUBaseFilter.checkGlError("glUniform2f mUniInputTexture2Size");
                }
                int i28 = this.iResolution;
                if (i28 >= 0) {
                    GLES20.glUniform3f(i28, this.mOutputWidth, this.mOutputHeight, 0.0f);
                    GPUBaseFilter.checkGlError("glUniform2f iResolution");
                }
                if (this.shaderID == 4) {
                    int i29 = this.mOffsetLocation;
                    if (i29 >= 0) {
                        GLES20.glUniform2f(i29, 1.0f / this.mOutputWidth, 1.0f / this.mOutputHeight);
                    }
                    int i36 = this.mWeightsLoc;
                    if (i36 >= 0) {
                        float[] fArr3 = BLURWEIGHTS;
                        GLES20.glUniform1fv(i36, fArr3.length, FloatBuffer.wrap(fArr3));
                    }
                }
                GLES20.glUniform1f(this.mUniCurrentTime, this.mCurrentTimeMs);
                GPUBaseFilter.checkGlError("glUniform2f mUniCurrentTime");
                GLES20.glUniform2f(this.mUniTimeRange, this.mStartTimeMs, this.mEndTimeMs - r3);
                GPUBaseFilter.checkGlError("glUniform2f mUniTimeRange");
                int i37 = this.mUniCommonParam;
                float[] fArr4 = this.mCommonFloats;
                GLES20.glUniform4f(i37, fArr4[0], fArr4[1], fArr4[2], fArr4[3]);
                onDrawTexture();
                GLES20.glDrawArrays(5, 0, 4);
                GPUBaseFilter.checkGlError("glDrawArrays");
                GLES20.glDisableVertexAttribArray(this.mAttrPosition);
                GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
                if (i16 >= 0) {
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(this.mTextureType, 0);
                }
                if (this.mInputTextureID >= 0) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(this.mTextureType, 0);
                }
                setOutputTextureID(this.mRenderFBO.getTexId());
                this.mRenderFBO.unbind();
                return true;
            }
        }
        return false;
    }

    public int getOutputTextureID() {
        return this.mOutputTextureID;
    }

    public int getShaderID() {
        return this.shaderID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        float[] fArr = new float[16];
        this.mDefaultTextureMatirx = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.mDefaultMvpMatirx = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        int program = getProgram();
        if (program <= 0) {
            return;
        }
        GLES20.glUseProgram(program);
        int glGetAttribLocation = GLES20.glGetAttribLocation(program, "position");
        this.mAttrPosition = glGetAttribLocation;
        GPUBaseFilter.checkLocation(glGetAttribLocation, "position");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(program, "inputTextureCoordinate");
        this.mAttrTextureCoord = glGetAttribLocation2;
        GPUBaseFilter.checkLocation(glGetAttribLocation2, "inputTextureCoordinate");
        int glGetUniformLocation = GLES20.glGetUniformLocation(program, "uMVPMatrix");
        this.mAttrMVPMatrix = glGetUniformLocation;
        GPUBaseFilter.checkLocation(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(program, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        this.mAttrTextureMatrix = glGetUniformLocation2;
        GPUBaseFilter.checkLocation(glGetUniformLocation2, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(program, "inputImageTexture");
        this.mUniInputTexture = glGetUniformLocation3;
        GPUBaseFilter.checkLocation(glGetUniformLocation3, "inputImageTexture");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(program, "inputImageTexture2");
        this.mUniInputTexture2 = glGetUniformLocation4;
        GPUBaseFilter.checkLocation(glGetUniformLocation4, "inputImageTexture2");
        this.mUniInputTextureSize = GLES20.glGetUniformLocation(program, "inputImageTextureSize");
        this.mUniInputTexture2Size = GLES20.glGetUniformLocation(program, "inputImageTexture2Size");
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(program, "timeRange");
        this.mUniTimeRange = glGetUniformLocation5;
        GPUBaseFilter.checkLocation(glGetUniformLocation5, "timeRange");
        int glGetUniformLocation6 = GLES20.glGetUniformLocation(program, "time");
        this.mUniCurrentTime = glGetUniformLocation6;
        GPUBaseFilter.checkLocation(glGetUniformLocation6, "time");
        this.iResolution = GLES20.glGetUniformLocation(program, "iResolution");
        GPUBaseFilter.checkLocation(this.mUniCurrentTime, "iResolution");
        int glGetUniformLocation7 = GLES20.glGetUniformLocation(program, "commonParamVec4");
        this.mUniCommonParam = glGetUniformLocation7;
        GPUBaseFilter.checkLocation(glGetUniformLocation7, "commonParamVec4");
        if (this.shaderID == 4) {
            this.mOffsetLocation = GLES20.glGetUniformLocation(program, "texelOffset");
            this.mWeightsLoc = GLES20.glGetUniformLocation(program, "weight");
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer == null || renderBuffer.getWidth() != i3 || this.mRenderFBO.getHeight() != i16) {
            this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
        }
    }

    public void setInputTextureID(int i3) {
        this.mInputTextureID = i3;
    }

    public void setOutputTextureID(int i3) {
        this.mOutputTextureID = i3;
    }

    public void setShaderID(int i3) {
        this.shaderID = i3;
    }

    public void updateData(int i3, int i16, int i17, float f16, float f17, float f18, float f19) {
        this.mCurrentTimeMs = i17;
        this.mStartTimeMs = i3;
        this.mEndTimeMs = i16;
        float[] fArr = this.mCommonFloats;
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
        fArr[3] = f19;
    }
}
