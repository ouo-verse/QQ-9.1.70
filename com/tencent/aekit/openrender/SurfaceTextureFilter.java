package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SurfaceTextureFilter extends VideoFilterBase {
    static IPatchRedirector $redirector_ = null;
    private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {   gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x,textureCoordinate.y));\n}";
    private static final String vertexShaderCode = "precision mediump float;\nattribute vec4 position;uniform mat4 tMat;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){   gl_Position = position;   textureCoordinate = tMat * inputTextureCoordinate;}";

    public SurfaceTextureFilter() {
        super(vertexShaderCode, fragmentShaderCode);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public Frame RenderProcess(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Frame) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        OnDrawFrameGLSL();
        Frame frame = FrameBufferCache.getInstance().get(i16, i17);
        frame.bindFrame(-1, i16, i17, 0.0d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        GLES20.glUniformMatrix4fv(this.mTMatHandle, 1, false, FloatBuffer.wrap(this.mTMat));
        GLES20.glDrawArrays(6, 0, 4);
        return frame;
    }
}
