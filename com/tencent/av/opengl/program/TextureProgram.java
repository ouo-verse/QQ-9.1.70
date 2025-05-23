package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import qv.a;
import qv.b;
import tv.c;

/* loaded from: classes3.dex */
public class TextureProgram {

    /* renamed from: a, reason: collision with root package name */
    int f74076a;

    /* renamed from: b, reason: collision with root package name */
    int f74077b;

    /* renamed from: c, reason: collision with root package name */
    int f74078c;

    /* renamed from: d, reason: collision with root package name */
    b[] f74079d;

    /* JADX INFO: Access modifiers changed from: protected */
    public TextureProgram(String str, String str2, b[] bVarArr, boolean z16) {
        this.f74076a = -1;
        this.f74077b = -1;
        this.f74078c = -1;
        this.f74077b = d(35633, str);
        int d16 = d(35632, str2);
        this.f74078c = d16;
        this.f74079d = bVarArr;
        this.f74076a = a(this.f74077b, d16, bVarArr);
    }

    public static int a(int i3, int i16, b[] bVarArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        c.a();
        if (glCreateProgram == 0) {
            QLog.e("TextureProgram", 2, "Cannot create GL program: = " + GLES20.glGetError());
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, i3);
        c.a();
        GLES20.glAttachShader(glCreateProgram, i16);
        c.a();
        GLES20.glLinkProgram(glCreateProgram);
        c.a();
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        for (b bVar : bVarArr) {
            bVar.a(glCreateProgram);
        }
        return glCreateProgram;
    }

    public static int d(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        c.a();
        GLES20.glCompileShader(glCreateShader);
        c.a();
        return glCreateShader;
    }

    public int b() {
        return this.f74076a;
    }

    public b[] c() {
        return this.f74079d;
    }

    public TextureProgram() {
        this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new b[]{new a("aPosition"), new qv.c("uMatrix"), new qv.c("uAlpha"), new qv.c(CameraFilterEngine.TEXTURE_MATRIX_UNIFORM), new qv.c("uTextureSampler0")}, false);
    }
}
