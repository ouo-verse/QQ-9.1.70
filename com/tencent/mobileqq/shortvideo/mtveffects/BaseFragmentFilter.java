package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BaseFragmentFilter extends GPUBaseFilter {
    private int mAttrMVPMatrix;
    private int mAttrPosition;
    private int mAttrTextureCoord;
    private int mAttrTextureMatrix;
    private float[] mDefaultMvpMatirx;
    private float[] mDefaultTextureMatirx;
    private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.VERTEXT_COORDS);
    private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);

    public BaseFragmentFilter(String str) {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", str);
        this.mAttrPosition = -1;
        this.mAttrTextureCoord = -1;
        this.mAttrMVPMatrix = -1;
        this.mAttrTextureMatrix = -1;
    }

    public FloatBuffer getTextureBuffer(RectF rectF) {
        if (rectF == null) {
            return GlUtil.createFloatBuffer(GPUBaseFilter.TEXUTURE_COORDS);
        }
        float f16 = rectF.left;
        float f17 = rectF.bottom;
        float f18 = rectF.right;
        float f19 = rectF.top;
        return GlUtil.createFloatBuffer(new float[]{f16, f17, f18, f17, f18, f19, f16, f19});
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
        this.mAttrPosition = GLES20.glGetAttribLocation(program, "aPosition");
        this.mAttrTextureCoord = GLES20.glGetAttribLocation(program, "aTextureCoord");
        this.mAttrMVPMatrix = GLES20.glGetUniformLocation(program, "uMVPMatrix");
        this.mAttrTextureMatrix = GLES20.glGetUniformLocation(program, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
    }

    public boolean processBegin(float[] fArr, float[] fArr2) {
        if (fArr == null) {
            fArr = this.mDefaultTextureMatirx;
        }
        if (fArr2 == null) {
            fArr2 = this.mDefaultMvpMatirx;
        }
        int program = getProgram();
        if (program <= 0) {
            return false;
        }
        GLES20.glUseProgram(program);
        GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GLES20.glEnableVertexAttribArray(this.mAttrPosition);
        GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
        int i3 = this.mAttrMVPMatrix;
        if (i3 >= 0) {
            GLES20.glUniformMatrix4fv(i3, 1, false, fArr2, 0);
        }
        int i16 = this.mAttrTextureMatrix;
        if (i16 >= 0) {
            GLES20.glUniformMatrix4fv(i16, 1, false, fArr, 0);
        }
        return true;
    }

    public void processEnd(boolean z16, int... iArr) {
        if (z16) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mAttrPosition);
        GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
        if (z16) {
            GLES20.glDisable(3042);
        }
        if (iArr != null) {
            for (int i3 : iArr) {
                releaseTextureUnit(i3);
            }
        }
    }

    public void releaseTextureUnit(int i3) {
        GLES20.glActiveTexture(i3);
        GLES20.glBindTexture(this.mTextureType, 0);
    }
}
