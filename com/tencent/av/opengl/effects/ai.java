package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ai implements w {

    /* renamed from: d, reason: collision with root package name */
    byte[] f73951d;

    /* renamed from: h, reason: collision with root package name */
    byte[] f73955h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f73956i;

    /* renamed from: j, reason: collision with root package name */
    private String f73957j;

    /* renamed from: k, reason: collision with root package name */
    private RenderBuffer f73958k;

    /* renamed from: m, reason: collision with root package name */
    private TextureRender f73960m;

    /* renamed from: a, reason: collision with root package name */
    private boolean f73948a = true;

    /* renamed from: b, reason: collision with root package name */
    int f73949b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f73950c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73952e = true;

    /* renamed from: f, reason: collision with root package name */
    private int f73953f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f73954g = -1;

    /* renamed from: l, reason: collision with root package name */
    private float[] f73959l = null;

    public ai(String str) {
        this.f73957j = str;
        m();
    }

    private void h(int i3, int i16) {
        if (this.f73960m == null) {
            this.f73960m = new TextureRender();
        }
        if (this.f73958k == null) {
            this.f73958k = new RenderBuffer(i3, i16, 33984);
        }
        if (this.f73959l == null) {
            float[] fArr = new float[16];
            this.f73959l = fArr;
            Matrix.setIdentityM(fArr, 0);
        }
    }

    static void i(int i3, int i16, int i17, int i18, FloatBuffer floatBuffer) {
        GLES20.glBindFramebuffer(36160, i18);
        GLES20.glViewport(0, 0, i16, i3);
        TextureProgram b16 = pv.f.b(5);
        qv.b[] c16 = b16.c();
        GLES20.glUseProgram(b16.b());
        ov.b.x(false);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glUniform1i(c16[4].f429680a, 0);
        GLES20.glUniform1f(c16[2].f429680a, 1.0f);
        GLES20.glUniformMatrix4fv(c16[1].f429680a, 1, false, AVGLUtils.matrixVRotate90, 0);
        GLES20.glUniformMatrix4fv(c16[3].f429680a, 1, false, AVGLUtils.matrix, 0);
        GLES20.glVertexAttribPointer(c16[0].f429680a, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(c16[0].f429680a);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private int k(int i3, int i16, int i17, com.tencent.avcore.camera.data.c cVar, boolean z16) {
        cVar.f77451k = 1;
        if (z16) {
            o();
        }
        h(i16, i3);
        this.f73958k.bind();
        Matrix.setIdentityM(this.f73959l, 0);
        Matrix.scaleM(this.f73959l, 0, -1.0f, 1.0f, 1.0f);
        this.f73960m.drawTexture(GLSLRender.GL_TEXTURE_2D, i17, null, this.f73959l);
        this.f73958k.unbind();
        return this.f73958k.getTexId();
    }

    private int l(int i3, int i16, int i17, com.tencent.avcore.camera.data.c cVar, boolean z16) {
        cVar.f77451k = 2;
        if (z16) {
            o();
        }
        h(i16, i3);
        this.f73958k.bind();
        int a16 = (((cVar.f77445e - ad.a(cVar.f77447g)) - 1) + 4) % 4;
        Matrix.setIdentityM(this.f73959l, 0);
        if (a16 % 2 == 0) {
            Matrix.scaleM(this.f73959l, 0, -1.0f, -1.0f, 1.0f);
        } else {
            Matrix.scaleM(this.f73959l, 0, 1.0f, 1.0f, 1.0f);
        }
        this.f73960m.drawTexture(GLSLRender.GL_TEXTURE_2D, i17, null, this.f73959l);
        this.f73958k.unbind();
        return this.f73958k.getTexId();
    }

    private void m() {
        this.f73952e = ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isFilterProcessPostRenderUserShader();
    }

    private void n(q qVar, com.tencent.avcore.camera.data.c cVar, t tVar, p pVar, FloatBuffer floatBuffer, ac acVar) {
        boolean z16;
        boolean z17;
        int i3 = cVar.f77442b * cVar.f77443c;
        int i16 = (i3 * 3) / 2;
        boolean z18 = this.f73952e;
        if (z18) {
            byte[] bArr = this.f73955h;
            if (bArr != null && bArr.length == i16) {
                z17 = false;
            } else {
                this.f73955h = new byte[i16];
                z17 = true;
            }
            int i17 = (i3 * 1) / 2;
            byte[] bArr2 = this.f73956i;
            if (bArr2 == null || bArr2.length != i17) {
                this.f73956i = new byte[i17];
                z17 = true;
            }
            z16 = z17;
        } else {
            int i18 = i3 * 4;
            byte[] bArr3 = this.f73951d;
            if (bArr3 == null || bArr3.length != i18) {
                this.f73951d = new byte[i18];
            }
            z16 = false;
        }
        if (z18) {
            j(qVar.f74016b, qVar.f74017c, tVar.f74046b, this.f73953f, floatBuffer, cVar, z16);
            p(qVar.f74016b, qVar.f74017c);
        } else {
            i(qVar.f74016b, qVar.f74017c, tVar.f74046b, this.f73950c, floatBuffer);
            q(this.f73950c, qVar.f74017c, qVar.f74016b, this.f73951d);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, cVar.f77442b, cVar.f77443c);
        if (!this.f73948a || !cVar.i()) {
            cVar.f77441a = this.f73951d;
            cVar.f77442b = qVar.f74017c;
            cVar.f77443c = qVar.f74016b;
            cVar.f77444d = 21;
            if (this.f73952e) {
                cVar.f77444d = 100;
                cVar.f77441a = this.f73955h;
            }
            cVar.f77445e = (((cVar.f77445e - ad.a(cVar.f77447g)) - 1) + 4) % 4;
            acVar.b(cVar, pVar.f74007d, pVar.f74008e, pVar.f74009f, pVar.f74010g, pVar.f74011h);
        }
        this.f73948a = false;
    }

    private void o() {
        TextureRender textureRender = this.f73960m;
        if (textureRender != null) {
            textureRender.release();
            this.f73960m = null;
        }
        RenderBuffer renderBuffer = this.f73958k;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.f73958k = null;
        }
    }

    private void p(int i3, int i16) {
        ByteBuffer wrap = ByteBuffer.wrap(this.f73955h);
        GLES20.glBindFramebuffer(36160, this.f73953f);
        int i17 = (i16 * 2) / 8;
        GLES20.glReadPixels(0, 0, i17, i3, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        byte[] bArr = this.f73956i;
        GLES20.glReadPixels(i17, 0, (i16 * 1) / 8, i3, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
        GLES20.glBindFramebuffer(36160, 0);
        System.arraycopy(bArr, 0, this.f73955h, i16 * i3, bArr.length);
    }

    public static void q(int i3, int i16, int i17, byte[] bArr) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glViewport(0, 0, i16, i17);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
        GLES20.glBindFramebuffer(36160, 0);
    }

    @Override // com.tencent.av.opengl.effects.r
    public void a() {
        this.f73951d = null;
        if (this.f73952e) {
            this.f73955h = null;
            this.f73956i = null;
        }
    }

    @Override // com.tencent.av.opengl.effects.r
    public void c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (this.f73952e) {
            this.f73954g = iArr[0];
        } else {
            this.f73949b = iArr[0];
        }
    }

    @Override // com.tencent.av.opengl.effects.w
    public void e(q qVar, com.tencent.avcore.camera.data.c cVar, t tVar, p pVar, ac acVar) {
        com.tencent.av.utils.ab abVar = qVar.f74029o;
        if (abVar != null) {
            abVar.e("postRender");
        }
        n(qVar, cVar, tVar, pVar, qVar.f74035u, acVar);
        com.tencent.av.utils.ab abVar2 = qVar.f74029o;
        if (abVar2 != null) {
            abVar2.d("postRender");
        }
    }

    @Override // com.tencent.av.opengl.effects.r
    public void f() {
        if (this.f73952e) {
            o();
            GLES20.glDeleteTextures(1, new int[]{this.f73954g}, 0);
            this.f73954g = -1;
            GLES20.glDeleteFramebuffers(1, new int[]{this.f73953f}, 0);
            this.f73953f = -1;
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{this.f73949b}, 0);
        this.f73949b = -1;
        GLES20.glDeleteFramebuffers(1, new int[]{this.f73950c}, 0);
        this.f73950c = -1;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void g(int i3, int i16) {
        if (this.f73952e) {
            this.f73953f = AVGLUtils.initFrameBuffer(i16, i3, this.f73954g);
        } else {
            this.f73950c = AVGLUtils.initFrameBuffer(i16, i3, this.f73949b);
        }
    }

    void j(int i3, int i16, int i17, int i18, FloatBuffer floatBuffer, com.tencent.avcore.camera.data.c cVar, boolean z16) {
        boolean z17;
        int i19;
        boolean isFilterProcessRenderUseSurface = ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isFilterProcessRenderUseSurface();
        if ((cVar.f77447g & isFilterProcessRenderUseSurface) && cVar.f77451k == 0 && vu.a.e(MobileQQ.sMobileQQ.peekAppRuntime(), "KEY_SHARE_MIRROR_SWITCH_IS_OPEN", false)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (isFilterProcessRenderUseSurface & cVar.f77447g) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (f16 != null && com.tencent.av.ui.x.e(f16.O1)) {
                z17 = false;
            }
            if (!z17) {
                i19 = k(i16, i3, i17, cVar, z16);
            } else {
                i19 = l(i16, i3, i17, cVar, z16);
            }
        } else {
            i19 = i17;
        }
        GLES20.glBindFramebuffer(36160, i18);
        GLES20.glViewport(0, 0, i16, i3);
        TextureProgram b16 = pv.f.b(6);
        qv.b[] c16 = b16.c();
        GLES20.glUseProgram(b16.b());
        ov.b.x(false);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
        GLES20.glUniform1i(c16[4].f429680a, 0);
        GLES20.glUniform1f(c16[2].f429680a, 1.0f);
        GLES20.glUniformMatrix4fv(c16[1].f429680a, 1, false, AVGLUtils.matrixVRotate90, 0);
        GLES20.glUniformMatrix4fv(c16[3].f429680a, 1, false, AVGLUtils.matrix, 0);
        GLES20.glUniform1f(c16[7].f429680a, i3);
        GLES20.glUniform1f(c16[8].f429680a, i16);
        GLES20.glVertexAttribPointer(c16[0].f429680a, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(c16[0].f429680a);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
    }
}
