package com.tencent.aelight.camera.ae.flashshow.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends VideoFilterBase {

    /* renamed from: a, reason: collision with root package name */
    private float f64329a;

    /* renamed from: b, reason: collision with root package name */
    private float f64330b;

    public a() {
        super("precision mediump float;\nattribute vec4 position;uniform mat4 tMat;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){   gl_Position = position;   textureCoordinate = tMat * inputTextureCoordinate;}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {   gl_FragColor = texture2D(inputImageTexture, textureCoordinate.xy);\n}");
        this.f64329a = 0.0f;
        this.f64330b = 0.0f;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public Frame RenderProcess(int i3, int i16, int i17) {
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

    public void updateCorpRect(int i3, int i16, int i17, int i18) {
        updateTexCords(i3, i16, i17, i18);
    }

    private void updateTexCords(int i3, int i16, int i17, int i18) {
        float f16 = ((i17 - i3) / 2.0f) / i17;
        float f17 = 1.0f - f16;
        float f18 = ((i18 - i16) / 2.0f) / i18;
        float f19 = 1.0f - f18;
        if (Float.compare(f16, this.f64329a) == 0 && Float.compare(f18, this.f64330b) == 0) {
            return;
        }
        this.f64329a = f16;
        this.f64330b = f18;
        setTexCords(new float[]{f16, f18, f16, f19, f17, f19, f17, f18});
    }
}
