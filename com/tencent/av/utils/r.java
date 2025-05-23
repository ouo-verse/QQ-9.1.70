package com.tencent.av.utils;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private int[] f77161a;

    public r() {
        int[] iArr = new int[1];
        this.f77161a = iArr;
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f77161a[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glGenFramebuffers(1, new int[1], 0);
    }

    public int a(int i3, int i16) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f77161a[0]);
        GLES20.glCopyTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, 0, 0, i3, i16, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        return this.f77161a[0];
    }

    public void b() {
        GLES20.glDeleteFramebuffers(1, this.f77161a, 0);
    }
}
