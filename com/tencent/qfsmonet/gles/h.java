package com.tencent.qfsmonet.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import androidx.annotation.IntRange;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.gles.MonetShaderDescriptor;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f342504a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f342504a = hashMap;
        hashMap.put(Integer.valueOf(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_2D), Integer.valueOf(GLSLRender.GL_TEXTURE_2D));
        hashMap.put(Integer.valueOf(MonetShaderDescriptor.OpenGLSamplerType.SAMPLER_OES), 36197);
    }

    public static void a(@IntRange(from = 1) int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
    }

    public static Bitmap b(int i3, int i16, int i17) {
        if (i3 == 0 || i16 == 0 || i17 == 0) {
            return null;
        }
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i18 = iArr[0];
        GLES20.glBindFramebuffer(36160, i18);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i17, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * i16 * 4);
        allocateDirect.position(0);
        GLES20.glReadPixels(0, 0, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        allocateDirect.rewind();
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glDeleteRenderbuffers(1, IntBuffer.wrap(iArr));
        GLES20.glDeleteFramebuffers(1, IntBuffer.allocate(i18));
        return createBitmap;
    }

    public static int c(@IntRange(from = 1) int i3, @IntRange(from = 1) int i16, @IntRange(from = 1) int i17, int i18) {
        int i19;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        if (i18 == 34836) {
            GLES30.glTexStorage2D(GLSLRender.GL_TEXTURE_2D, 1, MonetPacketDescriptor.MonetDataFormat.RGBA32F, i16, i17);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
            i19 = 0;
        } else {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i18, i16, i17, 0, i18, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            i19 = 0;
        }
        GLES20.glBindFramebuffer(36160, iArr[i19]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, i19);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
        GLES20.glBindFramebuffer(36160, i19);
        com.tencent.qfsmonet.utils.a.c("MonetGLTextureHelper", "generateFrameBufferId:" + iArr[i19] + " width:" + i16 + " height:" + i17);
        return iArr[i19];
    }

    public static int d(int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(g(i3), iArr[0]);
        GLES20.glTexParameterf(g(i3), 10240, 9729.0f);
        GLES20.glTexParameterf(g(i3), 10241, 9729.0f);
        GLES20.glTexParameteri(g(i3), 10242, 33071);
        GLES20.glTexParameteri(g(i3), 10243, 33071);
        GLES20.glBindTexture(g(i3), 0);
        com.tencent.qfsmonet.utils.a.c("MonetGLTextureHelper", "generateTextureId:" + iArr[0]);
        return iArr[0];
    }

    public static int e(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(g(i3), iArr[0]);
        GLES20.glTexParameterf(g(i3), 10240, 9729.0f);
        GLES20.glTexParameterf(g(i3), 10241, 9729.0f);
        GLES20.glTexParameteri(g(i3), 10242, 33071);
        GLES20.glTexParameteri(g(i3), 10243, 33071);
        GLES20.glTexImage2D(g(i3), 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(g(i3), 0);
        com.tencent.qfsmonet.utils.a.c("MonetGLTextureHelper", "generateTextureId:" + iArr[0]);
        return iArr[0];
    }

    public static int f(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(g(i3), iArr[0]);
        GLES20.glTexParameterf(g(i3), 10240, 9729.0f);
        GLES20.glTexParameterf(g(i3), 10241, 9729.0f);
        GLES20.glTexParameteri(g(i3), 10242, 33071);
        GLES20.glTexParameteri(g(i3), 10243, 33071);
        GLES20.glBindTexture(g(i3), 0);
        GLES20.glTexImage2D(g(i3), 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        com.tencent.qfsmonet.utils.a.c("MonetGLTextureHelper", "generateTextureId:" + iArr[0]);
        return iArr[0];
    }

    public static int g(int i3) {
        return f342504a.get(Integer.valueOf(i3)).intValue();
    }
}
