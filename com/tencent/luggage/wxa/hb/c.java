package com.tencent.luggage.wxa.hb;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.hb.a {
    public static final a R = new a(null);
    public static final String S = "MicroMsg.GLTextureRenderProcYuvToRgb";
    public d G;
    public d H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public ByteBuffer O;
    public ByteBuffer P;
    public byte[] Q;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(int i3, int i16, int i17, int i18, int i19, int i26) {
        super(i3, i16, i17, i18, i19, i26);
        this.Q = new byte[0];
        int b16 = com.tencent.luggage.wxa.jb.a.f130928a.b("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
        this.I = b16;
        if (b16 == 0) {
            w.b(S, "checkInit, load program failed!");
        }
        this.K = GLES20.glGetAttribLocation(this.I, "a_position");
        this.J = GLES20.glGetAttribLocation(this.I, "a_texCoord");
        this.L = GLES20.glGetUniformLocation(this.I, "y_texture");
        this.M = GLES20.glGetUniformLocation(this.I, "uv_texture");
        this.N = GLES20.glGetUniformLocation(this.I, "uMatrix");
        this.G = com.tencent.luggage.wxa.eb.c.a(true, 5L);
        this.H = com.tencent.luggage.wxa.eb.c.a(true, 5L);
    }

    @Override // com.tencent.luggage.wxa.hb.a
    public void q() {
        super.q();
        GLES20.glDeleteProgram(this.I);
        this.G.close();
        this.H.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r0.capacity() != ((m() * l()) / 2)) goto L22;
     */
    @Override // com.tencent.luggage.wxa.hb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s() {
        boolean z16;
        if (this.I != 0 && h() > 0 && g() > 0) {
            if (this.Q.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ByteBuffer byteBuffer = this.O;
                if (byteBuffer != null && this.P != null) {
                    Intrinsics.checkNotNull(byteBuffer);
                    if (byteBuffer.capacity() == m() * l()) {
                        ByteBuffer byteBuffer2 = this.P;
                        Intrinsics.checkNotNull(byteBuffer2);
                    }
                }
                this.O = ByteBuffer.allocateDirect(m() * l());
                this.P = ByteBuffer.allocateDirect((m() * l()) / 2);
                ByteBuffer byteBuffer3 = this.O;
                Intrinsics.checkNotNull(byteBuffer3);
                byteBuffer3.order(ByteOrder.nativeOrder());
                ByteBuffer byteBuffer4 = this.P;
                Intrinsics.checkNotNull(byteBuffer4);
                byteBuffer4.order(ByteOrder.nativeOrder());
                ByteBuffer byteBuffer5 = this.O;
                Intrinsics.checkNotNull(byteBuffer5);
                byteBuffer5.put(this.Q, 0, m() * l());
                ByteBuffer byteBuffer6 = this.O;
                Intrinsics.checkNotNull(byteBuffer6);
                byteBuffer6.position(0);
                ByteBuffer byteBuffer7 = this.P;
                Intrinsics.checkNotNull(byteBuffer7);
                byteBuffer7.put(this.Q, m() * l(), (m() * l()) / 2);
                ByteBuffer byteBuffer8 = this.P;
                Intrinsics.checkNotNull(byteBuffer8);
                byteBuffer8.position(0);
                GLES20.glUseProgram(this.I);
                GLES20.glActiveTexture(33984);
                d.a(this.G, m(), l(), MonetPacketDescriptor.MonetDataFormat.R8, this.O, 0, 0, 48, null);
                GLES20.glUniform1i(this.L, 0);
                GLES20.glActiveTexture(33985);
                d.a(this.H, m() / 2, l() / 2, MonetPacketDescriptor.MonetDataFormat.RG8, this.P, 0, 0, 48, null);
                GLES20.glUniform1i(this.M, 1);
                GLES20.glUniformMatrix4fv(this.N, 1, false, n(), 0);
                f().position(0);
                GLES20.glVertexAttribPointer(this.K, 2, 5126, false, 0, (Buffer) f());
                GLES20.glEnableVertexAttribArray(this.K);
                k().position(0);
                GLES20.glVertexAttribPointer(this.J, 2, 5126, false, 0, (Buffer) k());
                GLES20.glEnableVertexAttribArray(this.J);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.K);
                GLES20.glDisableVertexAttribArray(this.J);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                GLES20.glFinish();
            }
        }
    }
}
