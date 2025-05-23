package dg3;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: p, reason: collision with root package name */
    static float[] f393741p = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: q, reason: collision with root package name */
    static float[] f393742q = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: c, reason: collision with root package name */
    private FloatBuffer f393745c;

    /* renamed from: d, reason: collision with root package name */
    private FloatBuffer f393746d;

    /* renamed from: e, reason: collision with root package name */
    private final int f393747e;

    /* renamed from: f, reason: collision with root package name */
    private int f393748f;

    /* renamed from: g, reason: collision with root package name */
    private int f393749g;

    /* renamed from: h, reason: collision with root package name */
    private int f393750h;

    /* renamed from: i, reason: collision with root package name */
    private int f393751i;

    /* renamed from: j, reason: collision with root package name */
    private int f393752j;

    /* renamed from: k, reason: collision with root package name */
    private int f393753k;

    /* renamed from: o, reason: collision with root package name */
    private int f393757o;

    /* renamed from: a, reason: collision with root package name */
    private final String f393743a = "precision mediump float;\nattribute vec4 vPosition;uniform mat4 uSTMatrix;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = uSTMatrix * inputTextureCoordinate;}";

    /* renamed from: b, reason: collision with root package name */
    private final String f393744b = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, vec2(textureCoordinate.x,textureCoordinate.y));\n}";

    /* renamed from: l, reason: collision with root package name */
    private float[] f393754l = new float[16];

    /* renamed from: m, reason: collision with root package name */
    private float f393755m = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f393756n = -1.0f;

    public a(int i3) {
        this.f393757o = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f393741p.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f393745c = asFloatBuffer;
        asFloatBuffer.put(f393741p);
        this.f393745c.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(f393742q.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.f393746d = asFloatBuffer2;
        asFloatBuffer2.put(f393742q);
        this.f393746d.position(0);
        int d16 = d(35633, "precision mediump float;\nattribute vec4 vPosition;uniform mat4 uSTMatrix;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = uSTMatrix * inputTextureCoordinate;}");
        int d17 = d(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, vec2(textureCoordinate.x,textureCoordinate.y));\n}");
        int glCreateProgram = GLES20.glCreateProgram();
        this.f393747e = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, d16);
        GLES20.glAttachShader(glCreateProgram, d17);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(d16);
        GLES20.glDeleteShader(d17);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f393751i = iArr[0];
        Matrix.setIdentityM(this.f393754l, 0);
    }

    private int d(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public float[] c() {
        return this.f393754l;
    }

    public void e(int i3) {
        this.f393752j = i3;
    }

    public void a() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.f393751i}, 0);
    }

    public void b(int i3, int i16) {
        GLES20.glDisable(3042);
        GLES30.glBindVertexArray(0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        GLES20.glUseProgram(this.f393747e);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f393752j);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindFramebuffer(36160, this.f393751i);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.f393752j, 0);
        GLES20.glViewport(0, 0, i3, i16);
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        this.f393750h = GLES20.glGetUniformLocation(this.f393747e, "s_texture");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f393757o);
        GLES20.glUniform1i(this.f393750h, 0);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f393747e, "vPosition");
        this.f393748f = glGetAttribLocation;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(this.f393748f, 2, 5126, false, 0, (Buffer) this.f393745c);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f393747e, "inputTextureCoordinate");
        this.f393749g = glGetAttribLocation2;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(this.f393749g, 2, 5126, false, 0, (Buffer) this.f393746d);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f393747e, "uSTMatrix");
        this.f393753k = glGetUniformLocation;
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, this.f393754l, 0);
        GLES20.glDrawArrays(5, 0, 6);
        GLES20.glBindTexture(36197, 0);
        GLES20.glDisableVertexAttribArray(this.f393748f);
        GLES20.glDisableVertexAttribArray(this.f393749g);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
    }

    public void f(int i3, int i16, double d16, double d17) {
        int i17;
        int i18;
        if (d16 < d17) {
            i18 = (int) (i16 * d16);
            i17 = i16;
        } else {
            i17 = (int) (i3 / d16);
            i18 = i3;
        }
        float f16 = ((i3 - i18) / 2.0f) / i3;
        float f17 = 1.0f - f16;
        float f18 = ((i16 - i17) / 2.0f) / i16;
        float f19 = 1.0f - f18;
        if (Float.compare(f16, this.f393755m) == 0 && Float.compare(f18, this.f393756n) == 0) {
            return;
        }
        this.f393755m = f16;
        this.f393756n = f18;
        f393742q = new float[]{f16, f18, f16, f19, f17, f19, f16, f18, f17, f19, f17, f18};
        this.f393746d.clear();
        this.f393746d.put(f393742q);
        this.f393746d.position(0);
    }
}
