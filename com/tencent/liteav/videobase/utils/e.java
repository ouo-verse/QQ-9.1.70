package com.tencent.liteav.videobase.utils;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f119400a;

    /* renamed from: b, reason: collision with root package name */
    public final String f119401b;

    public e(String str, String str2) {
        this.f119400a = str;
        this.f119401b = str2;
    }

    public static int a(String str, int i3) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            OpenGlUtils.checkGlError("glCompileShader");
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
