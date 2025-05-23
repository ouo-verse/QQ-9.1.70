package com.tencent.mobileqq.triton.screenrecord.gles;

import android.opengl.GLES20;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\bJ^\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\u0014J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/Texture2dProgram;", "", "()V", "mColorAdjust", "", "mKernel", "", "mProgramHandle", "", "mTexOffset", "mTextureTarget", "maPositionLoc", "maTextureCoordLoc", "muColorAdjustLoc", "muKernelLoc", "muMVPMatrixLoc", "muTexMatrixLoc", "muTexOffsetLoc", "createTextureObject", "draw", "", "mvpMatrix", "vertexBuffer", "Ljava/nio/FloatBuffer;", "firstVertex", "vertexCount", "coordsPerVertex", "vertexStride", "texMatrix", "texBuffer", "textureId", "texStride", "release", "setKernel", "values", "colorAdj", "setTexSize", "width", "height", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class Texture2dProgram {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = "Texture2dProgram";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private float mColorAdjust;
    private int mProgramHandle;
    private float[] mTexOffset;
    private final int maPositionLoc;
    private final int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private final int muMVPMatrixLoc;
    private final int muTexMatrixLoc;
    private int muTexOffsetLoc;
    private final int mTextureTarget = 36197;
    private final float[] mKernel = new float[9];

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/Texture2dProgram$Companion;", "", "()V", "FRAGMENT_SHADER_EXT", "", "KERNEL_SIZE", "", "TAG", "VERTEX_SHADER", "checkGlError", "", "op", "checkLocation", "location", "label", "createProgram", "vertexSource", "fragmentSource", "loadShader", "shaderType", "source", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkGlError(String op5) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            String str = op5 + ": glError 0x" + Integer.toHexString(glGetError);
            Logger.e$default(Texture2dProgram.TAG, str, null, 4, null);
            throw new RuntimeException(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkLocation(int location, String label) {
            if (location >= 0) {
                return;
            }
            throw new RuntimeException("Unable to locate '" + label + "' in program");
        }

        private final int loadShader(int shaderType, String source) {
            int glCreateShader = GLES20.glCreateShader(shaderType);
            checkGlError("glCreateShader type=" + shaderType);
            GLES20.glShaderSource(glCreateShader, source);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Logger.e$default(Texture2dProgram.TAG, "Could not compile shader " + shaderType + ':', null, 4, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" ");
                sb5.append(GLES20.glGetShaderInfoLog(glCreateShader));
                Logger.e$default(Texture2dProgram.TAG, sb5.toString(), null, 4, null);
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }

        public final int createProgram(@Nullable String vertexSource, @Nullable String fragmentSource) {
            int loadShader;
            int loadShader2 = loadShader(35633, vertexSource);
            if (loadShader2 == 0 || (loadShader = loadShader(35632, fragmentSource)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (glCreateProgram == 0) {
                Logger.e$default(Texture2dProgram.TAG, "Could not create program", null, 4, null);
            }
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Logger.e$default(Texture2dProgram.TAG, "Could not link program: ", null, 4, null);
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                Intrinsics.checkExpressionValueIsNotNull(glGetProgramInfoLog, "GLES20.glGetProgramInfoLog(program)");
                Logger.e$default(Texture2dProgram.TAG, glGetProgramInfoLog, null, 4, null);
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            return glCreateProgram;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Texture2dProgram() {
        Companion companion = INSTANCE;
        int createProgram = companion.createProgram(VERTEX_SHADER, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.mProgramHandle = createProgram;
        if (createProgram != 0) {
            Logger.d$default(TAG, "Created program " + this.mProgramHandle, null, 4, null);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            companion.checkLocation(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.maTextureCoordLoc = glGetAttribLocation2;
            companion.checkLocation(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation;
            companion.checkLocation(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.muTexMatrixLoc = glGetUniformLocation2;
            companion.checkLocation(glGetUniformLocation2, "uTexMatrix");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
            this.muKernelLoc = glGetUniformLocation3;
            if (glGetUniformLocation3 < 0) {
                this.muKernelLoc = -1;
                this.muTexOffsetLoc = -1;
                this.muColorAdjustLoc = -1;
                return;
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            this.muTexOffsetLoc = glGetUniformLocation4;
            companion.checkLocation(glGetUniformLocation4, "uTexOffset");
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            this.muColorAdjustLoc = glGetUniformLocation5;
            companion.checkLocation(glGetUniformLocation5, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    private final void setKernel(float[] values, float colorAdj) {
        boolean z16;
        if (values.length == 9) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            System.arraycopy(values, 0, this.mKernel, 0, 9);
            this.mColorAdjust = colorAdj;
            return;
        }
        throw new IllegalArgumentException(("Kernel size is " + values.length + " vs. 9").toString());
    }

    private final void setTexSize(int width, int height) {
        float f16 = 1.0f / width;
        float f17 = 1.0f / height;
        float f18 = -f16;
        float f19 = -f17;
        this.mTexOffset = new float[]{f18, f19, 0.0f, f19, f16, f19, f18, 0.0f, 0.0f, 0.0f, f16, 0.0f, f18, f17, 0.0f, f17, f16, f17};
    }

    public final int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        Companion companion = INSTANCE;
        companion.checkGlError("glGenTextures");
        int i3 = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i3);
        companion.checkGlError("glBindTexture " + i3);
        GLES20.glTexParameterf(36197, 10241, (float) 9728);
        GLES20.glTexParameterf(36197, 10240, (float) 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        companion.checkGlError("glTexParameter");
        return i3;
    }

    public final void draw(@Nullable float[] mvpMatrix, @Nullable FloatBuffer vertexBuffer, int firstVertex, int vertexCount, int coordsPerVertex, int vertexStride, @Nullable float[] texMatrix, @Nullable FloatBuffer texBuffer, int textureId, int texStride) {
        GLES20.glUseProgram(this.mProgramHandle);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, textureId);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, mvpMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, texMatrix, 0);
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GLES20.glVertexAttribPointer(this.maPositionLoc, coordsPerVertex, 5126, false, vertexStride, (Buffer) vertexBuffer);
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, texStride, (Buffer) texBuffer);
        int i3 = this.muKernelLoc;
        if (i3 >= 0) {
            GLES20.glUniform1fv(i3, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        GLES20.glDrawArrays(5, firstVertex, vertexCount);
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            while (glGetError != 0) {
                Logger.e$default(TAG, "glError 0x" + Integer.toHexString(glGetError), null, 4, null);
                glGetError = GLES20.glGetError();
            }
            throw new RuntimeException("opengl draw failed");
        }
    }

    public final void release() {
        Logger.d$default(TAG, "deleting program " + this.mProgramHandle, null, 4, null);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }
}
