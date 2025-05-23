package com.tencent.tav.decoder.decodecache;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
class CopyFilter {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String TAG = "MultiTextureFilter";
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
    private boolean renderForScreen = false;

    @NonNull
    private final int[] shaderIndexes = new int[2];
    private TextureInfo _textureInfo = null;
    private int frameBuffer = -1;
    private int[] defaultViewport = new int[4];

    private void initFrameBuffer(TextureInfo textureInfo) {
        if (textureInfo.textureType == 3553) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            this._textureInfo = textureInfo;
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            int i3 = iArr[0];
            GLES20.glBindFramebuffer(36160, i3);
            RenderContext.checkEglError("glBindFramebuffer frameBuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, textureInfo.textureID, 0);
            RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
            if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
                new RuntimeException("EGL error encountered: FramebufferStatus is not complete.").printStackTrace();
                return;
            }
            GLES20.glBindFramebuffer(36160, 0);
            this.frameBuffer = i3;
            textureInfo.setFrameBuffer(i3);
            return;
        }
        throw new RuntimeException("\u7eb9\u7406\u7c7b\u578b\u4e0d\u53ef\u4e3aOES");
    }

    public TextureInfo applyFilter(TextureInfo textureInfo) {
        return applyFilter(textureInfo, null);
    }

    public void clearBufferBuffer(int i3) {
        int i16 = this.frameBuffer;
        if (i16 != -1) {
            GLES20.glBindFramebuffer(36160, i16);
            GLES20.glClearColor(((16711680 & i3) >> 16) / 255.0f, ((65280 & i3) >> 8) / 255.0f, (i3 & 255) / 255.0f, 1.0f);
            GLES20.glClear(16384);
        }
    }

    protected void finishDraw(TextureInfo textureInfo) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
    }

    public int getRendererHeight() {
        return this.rendererHeight;
    }

    public int getRendererWidth() {
        return this.rendererWidth;
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
        releaseTexture();
        releaseProgram();
        int i3 = 0;
        while (true) {
            int[] iArr = this.shaderIndexes;
            if (i3 < iArr.length) {
                int i16 = iArr[i3];
                if (i16 > 0) {
                    GLES20.glDeleteShader(i16);
                    this.shaderIndexes[i3] = 0;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public void releaseProgram() {
        int i3 = this.program;
        if (i3 > 0) {
            GLES20.glDeleteProgram(i3);
            this.program = 0;
        }
    }

    public void releaseTexture() {
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
    }

    public void setDesTextureInfo(TextureInfo textureInfo) {
        if (textureInfo.getFrameBuffer() == -1) {
            initFrameBuffer(textureInfo);
        } else {
            this.frameBuffer = textureInfo.getFrameBuffer();
        }
        this._textureInfo = textureInfo;
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

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix) {
        if (!this.renderForScreen && this.frameBuffer == -1) {
            initFrameBuffer(this._textureInfo);
        }
        if (this.program == 0) {
            initShaderForTextureInfo(textureInfo);
        }
        RenderContext.checkEglError("onDrawFrame start");
        CGRect cGRect = new CGRect(0.0f, 0.0f, textureInfo.width, textureInfo.height);
        float f16 = cGRect.origin.x + cGRect.size.width;
        int i3 = textureInfo.width;
        if (f16 > i3) {
            f16 = i3;
            Log.e(TAG, "applyFilter: crop right pixel exceed texture width");
        }
        float f17 = cGRect.origin.y + cGRect.size.height;
        int i16 = textureInfo.height;
        if (f17 > i16) {
            f17 = i16;
            Log.e(TAG, "applyFilter: crop bottom pixel exceed texture height");
        }
        PointF pointF = cGRect.origin;
        float f18 = pointF.x;
        float f19 = pointF.y;
        this.triangleVertices.rewind();
        this.triangleVertices.put(new float[]{f18, f17, f18, f19, f16, f17, f16, f19});
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        int i17 = this.frameBuffer;
        if (i17 != -1) {
            GLES20.glBindFramebuffer(36160, i17);
            GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
        }
        GLES20.glUseProgram(this.program);
        RenderContext.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix), 0);
        GLES20.glUniform1f(this.uAlphaHandle, 1.0f);
        prepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(null));
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
