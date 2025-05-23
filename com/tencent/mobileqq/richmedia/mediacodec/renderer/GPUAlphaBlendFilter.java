package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes18.dex */
public class GPUAlphaBlendFilter extends GPUBaseFilter {
    private static final String TAG = "GPUAlphaBlendFilter";
    private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.VERTEXT_COORDS);
    private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        GPUBaseFilter.checkGlError("onDrawFrame start");
        int program = getProgram();
        if (fArr == null) {
            fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
        }
        if (fArr2 == null) {
            fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
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
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GPUBaseFilter.checkGlError("glVertexAttribPointer aPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GPUBaseFilter.checkGlError("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GPUBaseFilter.checkGlError("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GPUBaseFilter.checkGlError("glEnableVertexAttribArray mTextureHandle");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        onDrawTexture();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        GLES20.glDrawArrays(5, 0, 4);
        GPUBaseFilter.checkGlError("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, 0);
        GLES20.glDisable(3042);
    }
}
