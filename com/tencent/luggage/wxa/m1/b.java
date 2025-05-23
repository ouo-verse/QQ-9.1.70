package com.tencent.luggage.wxa.m1;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i3 = iArr[0];
        if (i3 != 0) {
            return i3;
        }
        w.b("MicroMsg.MMSightCameraGLUtil", "gen frame buffer error");
        return 0;
    }

    public static int b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        return iArr[0];
    }

    public static int a(String str, int i3) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        w.b("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    public static int a(String str, String str2) {
        int[] iArr = new int[1];
        int a16 = a(str, 35633);
        if (a16 == 0) {
            w.b("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            return 0;
        }
        int a17 = a(str2, 35632);
        if (a17 == 0) {
            w.b("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a16);
        GLES20.glAttachShader(glCreateProgram, a17);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            w.b("MicroMsg.MMSightCameraGLUtil", "link program failed");
            return 0;
        }
        GLES20.glDeleteShader(a16);
        GLES20.glDeleteShader(a17);
        return glCreateProgram;
    }
}
