package ds;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f394731a;

    /* renamed from: b, reason: collision with root package name */
    private FloatBuffer f394732b;

    /* renamed from: e, reason: collision with root package name */
    private int f394735e;

    /* renamed from: g, reason: collision with root package name */
    private int f394737g;

    /* renamed from: h, reason: collision with root package name */
    private int f394738h;

    /* renamed from: i, reason: collision with root package name */
    private int f394739i;

    /* renamed from: j, reason: collision with root package name */
    private int f394740j;

    /* renamed from: c, reason: collision with root package name */
    private float[] f394733c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private float[] f394734d = new float[16];

    /* renamed from: f, reason: collision with root package name */
    private int f394736f = -12345;

    public b() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f394731a = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f394732b = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f394734d, 0);
    }

    private int f(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("STextureRender", "Could not compile shader " + i3 + ":");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        sb5.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("STextureRender", sb5.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("STextureRender", str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void d(SurfaceTexture surfaceTexture, boolean z16) {
        a("onDrawFrame start");
        Log.e("STextureRender", Arrays.toString(this.f394734d));
        Log.e("STextureRender", String.valueOf(z16));
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f394735e);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f394736f);
        this.f394732b.position(0);
        GLES20.glVertexAttribPointer(this.f394739i, 3, 5126, false, 20, (Buffer) this.f394732b);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f394739i);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f394732b.position(3);
        GLES20.glVertexAttribPointer(this.f394740j, 2, 5126, false, 20, (Buffer) this.f394732b);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f394740j);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f394733c, 0);
        GLES20.glUniformMatrix4fv(this.f394737g, 1, false, this.f394733c, 0);
        GLES20.glUniformMatrix4fv(this.f394738h, 1, false, this.f394734d, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glBindTexture(36197, 0);
    }

    public int e() {
        return this.f394736f;
    }

    public void g() {
        int c16 = c("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", GPUOESBaseFilter.OES_FRAGMENT_SHADER);
        this.f394735e = c16;
        if (c16 != 0) {
            int glGetAttribLocation = GLES20.glGetAttribLocation(c16, "aPosition");
            this.f394739i = glGetAttribLocation;
            b(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f394735e, "aTextureCoord");
            this.f394740j = glGetAttribLocation2;
            b(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f394735e, "uMVPMatrix");
            this.f394737g = glGetUniformLocation;
            b(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f394735e, "uSTMatrix");
            this.f394738h = glGetUniformLocation2;
            b(glGetUniformLocation2, "uSTMatrix");
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            this.f394736f = i3;
            GLES20.glBindTexture(36197, i3);
            a("glBindTexture mTextureID");
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            a("glTexParameter");
            return;
        }
        throw new RuntimeException("failed creating program");
    }

    public static void b(int i3, String str) {
        if (i3 >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    private int c(String str, String str2) {
        int f16;
        int f17 = f(35633, str);
        if (f17 == 0 || (f16 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            Log.e("STextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, f17);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f16);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("STextureRender", "Could not link program: ");
        Log.e("STextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }
}
