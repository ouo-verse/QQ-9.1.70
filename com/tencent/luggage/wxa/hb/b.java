package com.tencent.luggage.wxa.hb;

import android.opengl.GLES20;
import com.tencent.luggage.wxa.tn.w;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends a {
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public final String M;

    public b(int i3, int i16, int i17, int i18, int i19, int i26) {
        super(i3, i16, i17, i18, i19, i26);
        this.L = -1;
        this.M = "MicroMsg.GLTextureRenderProcExternalTexture";
        int b16 = com.tencent.luggage.wxa.jb.a.f130928a.b("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "#extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.G = b16;
        this.H = GLES20.glGetAttribLocation(b16, "a_position");
        this.I = GLES20.glGetAttribLocation(this.G, "a_texCoord");
        this.J = GLES20.glGetUniformLocation(this.G, "texture");
        this.K = GLES20.glGetUniformLocation(this.G, "uMatrix");
    }

    @Override // com.tencent.luggage.wxa.hb.a
    public void a(int i3) {
        this.L = i3;
    }

    @Override // com.tencent.luggage.wxa.hb.a
    public void q() {
        super.q();
        GLES20.glDeleteProgram(this.G);
    }

    @Override // com.tencent.luggage.wxa.hb.a
    public void s() {
        int i3 = this.L;
        if (i3 != -1 && GLES20.glIsTexture(i3)) {
            GLES20.glUseProgram(this.G);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.L);
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameterf(36197, 10242, 33071.0f);
            GLES20.glTexParameterf(36197, 10243, 33071.0f);
            GLES20.glUniform1i(this.J, 0);
            GLES20.glUniformMatrix4fv(this.K, 1, false, n(), 0);
            f().position(0);
            GLES20.glVertexAttribPointer(this.H, 2, 5126, false, 0, (Buffer) f());
            GLES20.glEnableVertexAttribArray(this.H);
            k().position(0);
            GLES20.glVertexAttribPointer(this.I, 2, 5126, false, 0, (Buffer) k());
            GLES20.glEnableVertexAttribArray(this.I);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.H);
            GLES20.glDisableVertexAttribArray(this.I);
            GLES20.glBindTexture(36197, 0);
            return;
        }
        w.b(this.M, "draw with invalid texture");
    }
}
