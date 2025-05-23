package ht1;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f406230a;

    /* renamed from: b, reason: collision with root package name */
    private final String f406231b;

    /* renamed from: c, reason: collision with root package name */
    private int f406232c = -1;

    public b(String str, String str2) {
        this.f406230a = str;
        this.f406231b = str2;
    }

    private int d(String str, int i3) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            OpenGlUtils.checkGlError("glCompileShader");
            return 0;
        }
        return glCreateShader;
    }

    public void a() {
        int[] iArr = new int[1];
        int d16 = d(this.f406230a, 35633);
        if (d16 == 0) {
            Log.e("Program", "load vertex shader failed.");
            return;
        }
        int d17 = d(this.f406231b, 35632);
        if (d17 == 0) {
            Log.e("Program", "load fragment shader failed.");
            return;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, d16);
        GLES20.glAttachShader(glCreateProgram, d17);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            Log.e("Program", "link program failed. status: " + iArr[0]);
            return;
        }
        GLES20.glDeleteShader(d16);
        GLES20.glDeleteShader(d17);
        this.f406232c = glCreateProgram;
    }

    public void b() {
        GLES20.glDeleteProgram(this.f406232c);
        this.f406232c = -1;
    }

    public int c() {
        return this.f406232c;
    }
}
