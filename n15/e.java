package n15;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 )2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u000bR\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001cR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001cR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001c\u00a8\u0006*"}, d2 = {"Ln15/e;", "", "", "shaderType", "", "source", "e", "vertexSource", "fragmentSource", "b", "op", "", "a", "d", "Landroid/graphics/SurfaceTexture;", "st", "", "invert", "c", "f", "", "[F", "mTriangleVerticesData", "Ljava/nio/FloatBuffer;", "Ljava/nio/FloatBuffer;", "mTriangleVertices", "mMVPMatrix", "mSTMatrix", "I", "mProgram", "mTextureId", "g", "muMVPMatrixHandle", h.F, "muSTMatrixHandle", "i", "maPositionHandle", "j", "maTextureHandle", "<init>", "()V", "k", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float[] mTriangleVerticesData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FloatBuffer mTriangleVertices;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float[] mSTMatrix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mProgram;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int muMVPMatrixHandle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int muSTMatrixHandle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maPositionHandle;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int maTextureHandle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float[] mMVPMatrix = new float[16];

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mTextureId = -1;

    public e() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        float[] fArr2 = new float[16];
        this.mSTMatrix = fArr2;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(asFloatBuffer, "allocateDirect(\n        \u2026eOrder()).asFloatBuffer()");
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(fArr2, 0);
    }

    private final void a(String op5) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("STextureRender", op5 + ": glError " + glGetError);
        throw new RuntimeException(op5 + ": glError " + glGetError);
    }

    private final int e(int shaderType, String source) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        GLES20.glShaderSource(glCreateShader, source);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public final void c(SurfaceTexture st5, boolean invert) {
        Intrinsics.checkNotNullParameter(st5, "st");
        a("onDrawFrame start");
        st5.getTransformMatrix(this.mSTMatrix);
        if (invert) {
            float[] fArr = this.mSTMatrix;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTextureId);
        this.mTriangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTriangleVertices.position(3);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, (Buffer) this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    /* renamed from: d, reason: from getter */
    public final int getMTextureId() {
        return this.mTextureId;
    }

    public final void f() {
        int b16 = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", GPUOESBaseFilter.OES_FRAGMENT_SHADER);
        this.mProgram = b16;
        if (b16 != 0) {
            this.maPositionHandle = GLES20.glGetAttribLocation(b16, "aPosition");
            this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            this.mTextureId = i3;
            GLES20.glBindTexture(36197, i3);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            return;
        }
        throw new RuntimeException("failed creating program");
    }

    private final int b(String vertexSource, String fragmentSource) {
        int e16;
        int e17 = e(35633, vertexSource);
        if (e17 == 0 || (e16 = e(35632, fragmentSource)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, e17);
        GLES20.glAttachShader(glCreateProgram, e16);
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
