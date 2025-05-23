package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class Renderer {
    private int aPositionHandle;
    private final GLBlendStateCache glBlendStateCache;
    private final String mTAG;
    private int outputFrameBufferId;
    private TextureInfo outputTextureInfo;
    protected int program;
    private int rendererHeight;
    private int rendererWidth;
    private final int[] shaderIndexes;
    private int stMatrixHandle;
    private FloatBuffer triangleVertices;
    private int uAlphaHandle;
    private int uMatrixHandle;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Renderer() {
        String str = "TextureFilter@" + Integer.toHexString(hashCode());
        this.mTAG = str;
        this.glBlendStateCache = new GLBlendStateCache();
        this.shaderIndexes = new int[2];
        this.outputTextureInfo = null;
        this.outputFrameBufferId = -1;
        Logger.d(str, "TextureFilter() called");
    }

    private int[] cacheViewport() {
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        int i3 = this.outputFrameBufferId;
        if (i3 != -1) {
            GLES20.glBindFramebuffer(36160, i3);
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
        }
        return iArr;
    }

    private void checkAndInitFrameBuffer(@NonNull TextureInfo textureInfo) {
        int frameBuffer = textureInfo.getFrameBuffer();
        if (frameBuffer == -1) {
            frameBuffer = createFrameBuffer(textureInfo);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                Logger.e(this.mTAG, "checkAndInitFrameBuffer: status = " + glCheckFramebufferStatus, new RuntimeException("EGL error encountered: FramebufferStatus is not complete."));
                return;
            }
            GLES20.glBindFramebuffer(36160, 0);
        }
        this.outputFrameBufferId = frameBuffer;
        textureInfo.setFrameBuffer(frameBuffer);
        this.outputTextureInfo = textureInfo;
    }

    private int createFrameBuffer(@NonNull TextureInfo textureInfo) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo.textureID);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, textureInfo.getFormat(), textureInfo.width, textureInfo.height, 0, textureInfo.getFormat(), NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i3 = iArr[0];
        GLES20.glBindFramebuffer(36160, i3);
        RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, textureInfo.textureID, 0);
        RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
        return i3;
    }

    private void createProgram(TextureInfo textureInfo) {
        if (this.program == 0) {
            if (textureInfo.textureType == 36197) {
                initShader("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
            } else {
                initShader("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
            }
            RenderContext.checkEglError("createProgram");
        }
    }

    private float[] getVerticesDataFromRect(TextureInfo textureInfo, CGRect cGRect) {
        if (cGRect == null) {
            cGRect = new CGRect(0.0f, 0.0f, textureInfo.width, textureInfo.height);
        } else {
            CGSize cGSize = cGRect.size;
            cGSize.width = Math.min(textureInfo.width, cGSize.width);
            CGSize cGSize2 = cGRect.size;
            cGSize2.height = Math.min(textureInfo.height, cGSize2.height);
        }
        float f16 = cGRect.origin.x + cGRect.size.width;
        int i3 = textureInfo.width;
        if (f16 > i3) {
            f16 = i3;
            Logger.e(this.mTAG, "applyFilter: crop right pixel exceed texture width");
        }
        float f17 = cGRect.origin.y + cGRect.size.height;
        int i16 = textureInfo.height;
        if (f17 > i16) {
            f17 = i16;
            Logger.e(this.mTAG, "applyFilter: crop bottom pixel exceed texture height");
        }
        PointF pointF = cGRect.origin;
        float f18 = pointF.x;
        float f19 = pointF.y;
        return new float[]{f18, f17, f18, f19, f16, f17, f16, f19};
    }

    private void initShader(String str, String str2) {
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

    private boolean isEqualsCurrentOutputTexture(@NonNull TextureInfo textureInfo) {
        TextureInfo textureInfo2 = this.outputTextureInfo;
        if (textureInfo2 == null) {
            return false;
        }
        if (textureInfo2.equals(textureInfo)) {
            return true;
        }
        TextureInfo textureInfo3 = this.outputTextureInfo;
        if (textureInfo3.textureID != textureInfo.textureID || textureInfo3.width != textureInfo.width || textureInfo3.height != textureInfo.height) {
            return false;
        }
        return true;
    }

    private void onFinishDraw(TextureInfo textureInfo) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
    }

    private void onPrepareDraw(TextureInfo textureInfo, float[] fArr) {
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

    private void restoreViewport(int[] iArr) {
        if (this.outputFrameBufferId != -1) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    private void updateBlendParams(TextureInfo textureInfo) {
        GLES20.glEnable(3042);
        if (!textureInfo.isMixAlpha()) {
            GLES20.glBlendEquationSeparate(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
            GLES20.glBlendFuncSeparate(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        } else {
            GLES20.glBlendEquationSeparate(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
            GLES20.glBlendFuncSeparate(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        }
    }

    public void clearBufferBuffer(int i3) {
        clearBufferBuffer(i3, 0.0f);
    }

    public void release() {
        Logger.d(this.mTAG, "release: start, thread = " + Thread.currentThread().getName() + ", egl = " + EGL14.eglGetCurrentContext());
        TextureInfo textureInfo = this.outputTextureInfo;
        if (textureInfo != null) {
            GLES20.glDeleteTextures(1, new int[]{textureInfo.textureID}, 0);
            this.outputTextureInfo = null;
        }
        int i3 = this.outputFrameBufferId;
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.outputFrameBufferId = -1;
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
                Logger.d(this.mTAG, "release: end");
                return;
            }
        }
    }

    public TextureInfo render(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f16, CGRect cGRect) {
        if (textureInfo == null) {
            return null;
        }
        RenderContext.checkEglError("onDrawFrame start");
        this.glBlendStateCache.cache();
        createProgram(textureInfo);
        float[] verticesDataFromRect = getVerticesDataFromRect(textureInfo, cGRect);
        this.triangleVertices.rewind();
        this.triangleVertices.put(verticesDataFromRect);
        int[] cacheViewport = cacheViewport();
        GLES20.glUseProgram(this.program);
        RenderContext.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix2), 0);
        GLES20.glUniform1f(this.uAlphaHandle, f16);
        updateBlendParams(textureInfo);
        onPrepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(matrix));
        GLES20.glDrawArrays(5, 0, 4);
        RenderContext.checkEglError("glDrawArrays");
        onFinishDraw(textureInfo);
        restoreViewport(cacheViewport);
        this.glBlendStateCache.restore();
        return this.outputTextureInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputTextureInfo(TextureInfo textureInfo) {
        if (textureInfo != null) {
            if (!textureInfo.isReleased()) {
                if (textureInfo.textureType == 3553) {
                    this.rendererWidth = textureInfo.width;
                    this.rendererHeight = textureInfo.height;
                    if (!isEqualsCurrentOutputTexture(textureInfo)) {
                        checkAndInitFrameBuffer(textureInfo);
                        return;
                    }
                    return;
                }
                throw new RuntimeException("\u76ee\u6807\u7eb9\u7406\u7c7b\u578b\u9700\u8981GLES20.GL_TEXTURE_2D");
            }
            throw new RuntimeException("outputTextureInfo \u5df2\u7ecf\u88ab\u91ca\u653e\u4e86");
        }
        throw new RuntimeException("outputTextureInfo \u4e3a\u7a7a");
    }

    public String toString() {
        return "TextureFilter{program=" + this.program + ", rendererWidth=" + this.rendererWidth + ", rendererHeight=" + this.rendererHeight + ", outputTextureInfo=" + this.outputTextureInfo + ", outputFrameBufferId=" + this.outputFrameBufferId + '}';
    }

    public void clearBufferBuffer(int i3, float f16) {
        int i16 = this.outputFrameBufferId;
        if (i16 != -1) {
            GLES20.glBindFramebuffer(36160, i16);
            GLES20.glClearColor(((16711680 & i3) >> 16) / 255.0f, ((65280 & i3) >> 8) / 255.0f, (i3 & 255) / 255.0f, f16);
            GLES20.glClear(16384);
        }
    }
}
