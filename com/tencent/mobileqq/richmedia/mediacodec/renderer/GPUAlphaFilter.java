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
public class GPUAlphaFilter extends GPUBaseFilter {
    public static final String ALPHA_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nvarying vec4 v_color;\n\nvoid main() {\n    gl_FragColor = v_color * texture2D(uTexture, vTextureCoord);\n}\n";
    public static final String ALPHA_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nattribute vec4 a_color;\nvarying vec4 v_color;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    v_color = a_color;\n}\n";
    private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.VERTEXT_COORDS);
    private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);

    public GPUAlphaFilter() {
        this(ALPHA_VERTEX_SHADER, ALPHA_FRAGMENT_SHADER);
    }

    public void drawTexture(int i3, float[] fArr, float[] fArr2, FloatBuffer floatBuffer) {
        float[] fArr3;
        float[] fArr4;
        GPUBaseFilter.checkGlError("onDrawFrame start");
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
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
        int glGetAttribLocation3 = GLES20.glGetAttribLocation(program, "a_color");
        GPUBaseFilter.checkLocation(glGetAttribLocation3, "a_color");
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
        GLES20.glVertexAttribPointer(glGetAttribLocation3, 4, 5126, false, 0, (Buffer) floatBuffer);
        GPUBaseFilter.checkGlError("glVertexAttribPointer aColor");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation3);
        GPUBaseFilter.checkGlError("glEnableVertexAttribArray aColor");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr4, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr3, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        onDrawTexture();
        GLES20.glDrawArrays(5, 0, 4);
        GPUBaseFilter.checkGlError("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, 0);
        GLES20.glDisable(3042);
    }

    public GPUAlphaFilter(String str, String str2) {
        super(str, str2);
    }
}
