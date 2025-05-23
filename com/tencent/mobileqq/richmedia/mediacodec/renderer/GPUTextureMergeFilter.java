package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes18.dex */
public class GPUTextureMergeFilter extends GPUBaseFilter {
    private static final String MERGE_FRAG_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D oriTexture;\nuniform sampler2D filterTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    float maskFactor = texture2D(maskTexture, vTextureCoord).a;\n    gl_FragColor = texture2D(oriTexture, vTextureCoord) * (1.0 - maskFactor) + texture2D(filterTexture, vTextureCoord) * maskFactor;\n}\n";
    private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.VERTEXT_COORDS);
    private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);

    public GPUTextureMergeFilter() {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", MERGE_FRAG_SHADER);
    }

    public void drawTexture(int i3, int i16, int i17, float[] fArr, float[] fArr2) {
        float[] fArr3;
        float[] fArr4;
        GPUBaseFilter.checkGlError("onDrawFrame start");
        int program = getProgram();
        if (fArr == null) {
            fArr3 = new float[16];
            Matrix.setIdentityM(fArr3, 0);
        } else {
            fArr3 = fArr;
        }
        if (fArr2 == null) {
            fArr4 = new float[16];
            Matrix.setIdentityM(fArr4, 0);
        } else {
            fArr4 = fArr2;
        }
        GLES20.glUseProgram(program);
        GPUBaseFilter.checkGlError("glUseProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(program, "aPosition");
        GPUBaseFilter.checkLocation(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(program, "aTextureCoord");
        GPUBaseFilter.checkLocation(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(program, "uMVPMatrix");
        GPUBaseFilter.checkLocation(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(program, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GPUBaseFilter.checkLocation(glGetUniformLocation2, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(program, "oriTexture");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(program, "filterTexture");
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(program, "maskTexture");
        GPUBaseFilter.checkLocation(glGetUniformLocation5, "maskTexture");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GPUBaseFilter.checkGlError("glVertexAttribPointer aPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GPUBaseFilter.checkGlError("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GPUBaseFilter.checkGlError("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GPUBaseFilter.checkGlError("glEnableVertexAttribArray mTextureHandle");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr4, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr3, 0);
        GLES20.glUniform1i(glGetUniformLocation3, 0);
        GLES20.glUniform1i(glGetUniformLocation4, 1);
        GLES20.glUniform1i(glGetUniformLocation5, 2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, i16);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(this.mTextureType, i17);
        onDrawTexture();
        GLES20.glDrawArrays(5, 0, 4);
        GPUBaseFilter.checkGlError("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, 0);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(this.mTextureType, 0);
    }
}
