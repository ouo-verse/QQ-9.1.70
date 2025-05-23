package com.tencent.aelight.camera.ae.camera.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.GLSLRender;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends VideoFilterBase {
    public c(String str) {
        super(str);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        GLES20.glUniformMatrix4fv(this.mFilterProjHandle, 1, false, FloatBuffer.wrap(this.mFilterProjMat));
        GLES20.glUniformMatrix4fv(this.mFilterViewHandle, 1, false, FloatBuffer.wrap(this.mFilterViewMat));
        GLES20.glUniformMatrix4fv(this.mTMatHandle, 1, false, FloatBuffer.wrap(this.mTMat));
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glFlush();
        return true;
    }
}
