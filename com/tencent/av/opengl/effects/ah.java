package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ah implements x {

    /* renamed from: a, reason: collision with root package name */
    protected int f73945a = -1;

    /* renamed from: b, reason: collision with root package name */
    protected int f73946b = -1;

    /* renamed from: c, reason: collision with root package name */
    private ByteBuffer f73947c = null;

    public ah() {
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "SurfacePreRender");
        }
        com.tencent.avcore.camera.data.c.m("YUVMode");
    }

    public static void h(int i3, int i16, int i17, float[] fArr, byte[] bArr, int i18, int i19, int i26, int i27, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        if (bArr != null) {
            int i28 = i3 * i16;
            int i29 = (i28 * 3) / 2;
            if (bArr.length >= i29 && byteBuffer.capacity() >= i29) {
                byteBuffer.position(0);
                byteBuffer.put(bArr, 0, i28);
                byteBuffer.position(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i18);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i3, i16, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
                byteBuffer.position(0);
                byteBuffer.put(bArr, i28, i28 / 2);
                byteBuffer.position(0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.RG8, i3 / 2, i16 / 2, 0, MonetPacketDescriptor.MonetDataFormat.RG8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
                GLES20.glBindFramebuffer(36160, i26);
                GLES20.glViewport(0, 0, i16, i3);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                TextureProgram b16 = pv.f.b(1);
                qv.b[] c16 = b16.c();
                GLES20.glUseProgram(b16.b());
                GLES20.glUniform1f(c16[2].f429680a, 1.0f);
                GLES20.glUniform1f(c16[7].f429680a, i3);
                GLES20.glUniform1f(c16[8].f429680a, i16);
                GLES20.glUniformMatrix4fv(c16[9].f429680a, 1, false, fArr, 0);
                if (i17 == 17) {
                    GLES20.glUniform1i(c16[10].f429680a, 3);
                } else {
                    GLES20.glUniform1i(c16[10].f429680a, 1);
                }
                GLES20.glUniform1i(c16[11].f429680a, 0);
                GLES20.glDisable(3042);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i18);
                GLES20.glUniform1i(c16[4].f429680a, 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
                GLES20.glUniform1i(c16[5].f429680a, 1);
                if (i27 % 4 == 1) {
                    GLES20.glUniformMatrix4fv(c16[1].f429680a, 1, false, AVGLUtils.matrixVRotate90, 0);
                } else {
                    GLES20.glUniformMatrix4fv(c16[1].f429680a, 1, false, AVGLUtils.matrixVRotate270, 0);
                }
                GLES20.glUniformMatrix4fv(c16[3].f429680a, 1, false, AVGLUtils.matrix, 0);
                GLES20.glVertexAttribPointer(c16[0].f429680a, 2, 5126, false, 8, (Buffer) floatBuffer);
                GLES20.glEnableVertexAttribArray(c16[0].f429680a);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(c16[0].f429680a);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    private void i(com.tencent.avcore.camera.data.c cVar, int i3, FloatBuffer floatBuffer) {
        h(cVar.f77442b, cVar.f77443c, com.tencent.avcore.camera.b.f77380w, YUVTexture.M, cVar.f77441a, this.f73945a, this.f73946b, i3, ad.a(cVar.f77447g), this.f73947c, floatBuffer);
        GLES20.glViewport(0, 0, cVar.f77442b, cVar.f77443c);
    }

    @Override // com.tencent.av.opengl.effects.r
    public void a() {
        ByteBuffer byteBuffer = this.f73947c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f73947c = null;
    }

    @Override // com.tencent.av.opengl.effects.x
    public t b(q qVar, com.tencent.avcore.camera.data.c cVar, t tVar) {
        com.tencent.av.utils.ab abVar = qVar.f74029o;
        if (abVar != null) {
            abVar.e("preRender");
        }
        int i3 = ((cVar.f77442b * cVar.f77443c) * 3) / 2;
        ByteBuffer byteBuffer = this.f73947c;
        if (byteBuffer != null && byteBuffer.capacity() != i3) {
            this.f73947c.clear();
            this.f73947c = null;
        }
        if (this.f73947c == null) {
            this.f73947c = ByteBuffer.allocate(i3);
        }
        i(cVar, tVar.f74045a, qVar.f74035u);
        com.tencent.av.utils.ab abVar2 = qVar.f74029o;
        if (abVar2 != null) {
            abVar2.d("preRender");
        }
        return tVar;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void c() {
        int[] iArr = new int[2];
        GLES20.glGenTextures(2, iArr, 0);
        this.f73945a = iArr[0];
        this.f73946b = iArr[1];
    }

    @Override // com.tencent.av.opengl.effects.x
    public boolean d(com.tencent.avcore.camera.data.c cVar) {
        byte[] bArr;
        if (cVar != null && (bArr = cVar.f77441a) != null && bArr.length > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void f() {
        GLES20.glDeleteTextures(2, new int[]{this.f73945a, this.f73946b}, 0);
        this.f73945a = -1;
        this.f73946b = -1;
    }

    @Override // com.tencent.av.opengl.effects.r
    public void g(int i3, int i16) {
    }
}
