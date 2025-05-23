package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Filter {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    private int aPositionHandle;
    protected int program;
    private int rendererHeight;
    private int rendererWidth;
    private int stMatrixHandle;
    private FloatBuffer triangleVertices;
    private int uAlphaHandle;
    private int uMatrixHandle;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;
    private boolean renderForScreen = true;
    private int bgColor = -16777216;

    @NonNull
    private final int[] shaderIndexes = new int[2];
    private TextureInfo _textureInfo = null;
    private int frameBuffer = -1;
    private int[] defaultViewport = new int[4];

    private void initFrameBuffer() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        RenderContext.checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        RenderContext.checkEglError("glTexParameter");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        this._textureInfo = new TextureInfo(i3, GLSLRender.GL_TEXTURE_2D, this.rendererWidth, this.rendererHeight, null, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        int i16 = iArr2[0];
        GLES20.glBindFramebuffer(36160, i16);
        RenderContext.checkEglError("glBindFramebuffer frameBuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            new RuntimeException("EGL error encountered: FramebufferStatus is not complete.").printStackTrace();
        } else {
            GLES20.glBindFramebuffer(36160, 0);
            this.frameBuffer = i16;
        }
    }

    public TextureInfo applyFilter(TextureInfo textureInfo) {
        return applyFilter(textureInfo, null, null, 1.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Filter filter = (Filter) obj;
        if (this.rendererHeight == filter.rendererHeight && this.rendererWidth == filter.rendererWidth && this.renderForScreen == filter.renderForScreen) {
            return true;
        }
        return false;
    }

    protected void finishDraw(TextureInfo textureInfo) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
    }

    public int getFrameBuffer() {
        return this.frameBuffer;
    }

    public int getRendererHeight() {
        return this.rendererHeight;
    }

    public int getRendererWidth() {
        return this.rendererWidth;
    }

    public int hashCode() {
        return ((((((((((((((((((((((0 + this.program) * 31) + this.uScreenSizeHandle) * 31) + this.uTextureSizeHandle) * 31) + this.uMatrixHandle) * 31) + this.uAlphaHandle) * 31) + this.stMatrixHandle) * 31) + this.aPositionHandle) * 31) + this.rendererWidth) * 31) + this.rendererHeight) * 31) + (this.renderForScreen ? 1 : 0)) * 31) + this.frameBuffer) * 31) + Arrays.hashCode(this.defaultViewport);
    }

    protected void initShaderForTextureInfo(TextureInfo textureInfo) {
        if (textureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
        } else {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
        }
    }

    protected void initShaders(String str, String str2) {
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        int createProgram = Program.createProgram(str, str2, this.shaderIndexes);
        this.program = createProgram;
        if (createProgram == 0) {
            new RuntimeException("failed creating program").printStackTrace();
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        RenderContext.checkEglError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == -1) {
            new RuntimeException("Could not get attribute location for aPosition").printStackTrace();
            return;
        }
        this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        RenderContext.checkEglError("glGetUniformLocation uMatrix");
        if (this.uMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for uMatrix").printStackTrace();
            return;
        }
        this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
        RenderContext.checkEglError("glGetUniformLocation uAlpha");
        if (this.uAlphaHandle == -1) {
            new RuntimeException("Could not get uniform location for uAlpha").printStackTrace();
            return;
        }
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        RenderContext.checkEglError("glGetUniformLocation stMatrix");
        if (this.stMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for stMatrix").printStackTrace();
            return;
        }
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        RenderContext.checkEglError("glGetUniformLocation uScreenSize");
        if (this.uScreenSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uScreenSize").printStackTrace();
            return;
        }
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        RenderContext.checkEglError("glGetUniformLocation uTextureSize");
        if (this.uTextureSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uTextureSize").printStackTrace();
        }
    }

    protected void prepareDraw(TextureInfo textureInfo, float[] fArr) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, textureInfo.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, (Buffer) this.triangleVertices);
        RenderContext.checkEglError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        RenderContext.checkEglError("glEnableVertexAttribArray aPositionHandle");
        GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, fArr, 0);
        GLES20.glUniform2f(this.uTextureSizeHandle, textureInfo.width, textureInfo.height);
        GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    }

    public void release() {
        int i3 = this.frameBuffer;
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.frameBuffer = -1;
        }
        TextureInfo textureInfo = this._textureInfo;
        if (textureInfo != null) {
            GLES20.glDeleteTextures(1, new int[]{textureInfo.textureID}, 0);
            this._textureInfo = null;
        }
        int i16 = this.program;
        if (i16 > 0) {
            GLES20.glDeleteProgram(i16);
            this.program = 0;
        }
        int i17 = 0;
        while (true) {
            int[] iArr = this.shaderIndexes;
            if (i17 < iArr.length) {
                int i18 = iArr[i17];
                if (i18 > 0) {
                    GLES20.glDeleteShader(i18);
                    this.shaderIndexes[i17] = 0;
                }
                i17++;
            } else {
                return;
            }
        }
    }

    public void setBgColor(int i3) {
        this.bgColor = i3;
    }

    public void setRenderForScreen(boolean z16) {
        this.renderForScreen = z16;
    }

    public void setRendererHeight(int i3) {
        this.rendererHeight = i3;
    }

    public void setRendererWidth(int i3) {
        this.rendererWidth = i3;
    }

    public TextureInfo textureInfo() {
        return this._textureInfo;
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2) {
        return applyFilter(textureInfo, matrix, matrix2, 1.0f);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Filter m263clone() {
        return new Filter();
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f16) {
        if (!this.renderForScreen && this.frameBuffer == -1) {
            initFrameBuffer();
        }
        if (this.program == 0) {
            initShaderForTextureInfo(textureInfo);
        }
        RenderContext.checkEglError("onDrawFrame start");
        Rectangle rectangle = new Rectangle(0.0f, 0.0f, textureInfo.width, textureInfo.height);
        float f17 = rectangle.f374241x;
        float f18 = rectangle.f374242y;
        float f19 = rectangle.height;
        float f26 = rectangle.width;
        this.triangleVertices.rewind();
        this.triangleVertices.put(new float[]{f17, f18 + f19, f17, f18, f17 + f26, f19 + f18, f17 + f26, f18});
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        int i3 = this.frameBuffer;
        if (i3 != -1) {
            GLES20.glBindFramebuffer(36160, i3);
            GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
        }
        GLES20.glUseProgram(this.program);
        RenderContext.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix2), 0);
        GLES20.glUniform1f(this.uAlphaHandle, f16);
        prepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(matrix));
        int i16 = this.bgColor;
        GLES20.glClearColor(((16711680 & i16) >> 16) / 255.0f, ((65280 & i16) >> 8) / 255.0f, (i16 & 255) / 255.0f, i16 >> 24);
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glDrawArrays(5, 0, 4);
        RenderContext.checkEglError("glDrawArrays");
        finishDraw(textureInfo);
        if (this.frameBuffer != -1) {
            GLES20.glBindFramebuffer(36160, 0);
            int[] iArr = this.defaultViewport;
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        if (this.renderForScreen) {
            return null;
        }
        return this._textureInfo;
    }
}
