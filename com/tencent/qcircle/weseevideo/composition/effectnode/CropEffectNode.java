package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.filter.GLSLRender;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CropEffectNode implements TAVVideoEffect {
    private CropModel mCropModel;
    private final String sEffectId = "CropEffectNode" + Integer.toHexString(hashCode());
    protected String reportKey = "CropEffectNode";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class CropEffectFilter implements TAVVideoEffect.Filter, IReportable {
        private TextureInfo cachedCropOutputTextureInfo;
        private TextureInfo cachedSourceTextureInfo;
        private CropFilter cropFilter;

        public CropEffectFilter() {
            this.cropFilter = new CropFilter();
        }

        @NonNull
        private TextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
            return new TextureInfo(tAVTextureInfo.textureID, tAVTextureInfo.textureType, tAVTextureInfo.width, tAVTextureInfo.height, null, 0);
        }

        @NonNull
        private TAVTextureInfo getTavTextureInfo(TextureInfo textureInfo) {
            return new TAVTextureInfo(textureInfo.textureID, textureInfo.textureType, textureInfo.width, textureInfo.height, null, 0);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            CIContext ciContext = renderInfo.getCiContext();
            int i3 = (int) cIImage.getSize().width;
            int i16 = (int) cIImage.getSize().height;
            if (this.cachedSourceTextureInfo == null) {
                this.cachedSourceTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            TextureInfo textureInfo = this.cachedSourceTextureInfo;
            if (textureInfo.width != i3 || textureInfo.height != i16) {
                textureInfo.release();
                this.cachedSourceTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            ciContext.convertImageToTexture(cIImage, this.cachedSourceTextureInfo);
            int width = (int) ((cIImage.getSize().width * CropEffectNode.this.getCropModel().getCropConfig().getWidth()) + 0.5f);
            int height = (int) ((cIImage.getSize().height * CropEffectNode.this.getCropModel().getCropConfig().getHeight()) + 0.5f);
            Matrix matrix = new Matrix();
            matrix.postTranslate(CropEffectNode.this.getCropModel().getCropConfig().getX(), (1.0f - CropEffectNode.this.getCropModel().getCropConfig().getHeight()) - CropEffectNode.this.getCropModel().getCropConfig().getY());
            if (this.cachedCropOutputTextureInfo == null) {
                this.cachedCropOutputTextureInfo = CIContext.newTextureInfo(width, height);
            }
            TextureInfo textureInfo2 = this.cachedCropOutputTextureInfo;
            if (textureInfo2.width != width || textureInfo2.height != height) {
                textureInfo2.release();
                this.cachedCropOutputTextureInfo = CIContext.newTextureInfo(width, height);
            }
            this.cropFilter.setOutputTextureInfo(this.cachedCropOutputTextureInfo);
            this.cropFilter.applyFilter(this.cachedSourceTextureInfo, new Matrix(), matrix, 1.0f, new CGRect(0.0f, 0.0f, width, height));
            return new CIImage(this.cachedCropOutputTextureInfo);
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return CropEffectNode.this.reportKey;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            CropFilter cropFilter = this.cropFilter;
            if (cropFilter != null) {
                cropFilter.release();
            }
            TextureInfo textureInfo = this.cachedSourceTextureInfo;
            if (textureInfo != null) {
                textureInfo.release();
            }
            TextureInfo textureInfo2 = this.cachedCropOutputTextureInfo;
            if (textureInfo2 != null) {
                textureInfo2.release();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class CropFilter {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final String FRAGMENT_SHADER = "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
        private static final String FRAGMENT_SHADER_END = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
        private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
        private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
        private final String TAG;
        private int aPositionHandle;
        private int outputFrameBufferId;
        private TextureInfo outputTextureInfo;
        protected int program;
        private int rendererHeight;
        private int rendererWidth;

        @NonNull
        private final int[] shaderIndexes;
        private int stMatrixHandle;
        private FloatBuffer triangleVertices;
        private int uAlphaHandle;
        private int uMatrixHandle;
        private int uScreenSizeHandle;
        private int uTextureSizeHandle;

        public CropFilter() {
            String str = "TextureFilter@" + Integer.toHexString(hashCode());
            this.TAG = str;
            this.shaderIndexes = new int[2];
            this.outputTextureInfo = null;
            this.outputFrameBufferId = -1;
            Logger.d(str, "CropFilter() called");
        }

        private void checkAndInitFrameBuffer(@NonNull TextureInfo textureInfo) {
            int frameBuffer = textureInfo.getFrameBuffer();
            if (frameBuffer == -1) {
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo.textureID);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, textureInfo.width, textureInfo.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                frameBuffer = iArr[0];
                GLES20.glBindFramebuffer(36160, frameBuffer);
                RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, textureInfo.textureID, 0);
                RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
                int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                if (glCheckFramebufferStatus != 36053) {
                    Log.e(this.TAG, "checkAndInitFrameBuffer: status = " + glCheckFramebufferStatus, new RuntimeException("EGL error encountered: FramebufferStatus is not complete."));
                    return;
                }
                GLES20.glBindFramebuffer(36160, 0);
            }
            this.outputFrameBufferId = frameBuffer;
            textureInfo.setFrameBuffer(frameBuffer);
            this.outputTextureInfo = textureInfo;
        }

        private void finishDraw(TextureInfo textureInfo) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(textureInfo.textureType, 0);
        }

        private void initShaderForTextureInfo(TextureInfo textureInfo) {
            if (textureInfo.textureType == 36197) {
                initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
            } else {
                initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
            }
        }

        private void initShaders(String str, String str2) {
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

        private void prepareDraw(TextureInfo textureInfo, float[] fArr) {
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

        public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f16, CGRect cGRect) {
            if (textureInfo == null) {
                return null;
            }
            if (this.program == 0) {
                initShaderForTextureInfo(textureInfo);
            }
            RenderContext.checkEglError("onDrawFrame start");
            if (cGRect == null) {
                cGRect = new CGRect(0.0f, 0.0f, textureInfo.width, textureInfo.height);
            } else {
                CGSize cGSize = cGRect.size;
                cGSize.width = Math.min(textureInfo.width, cGSize.width);
                CGSize cGSize2 = cGRect.size;
                cGSize2.height = Math.min(textureInfo.height, cGSize2.height);
            }
            float f17 = cGRect.origin.x + cGRect.size.width;
            int i3 = textureInfo.width;
            if (f17 > i3) {
                f17 = i3;
                Logger.e(this.TAG, "applyFilter: crop right pixel exceed texture width");
            }
            float f18 = cGRect.origin.y + cGRect.size.height;
            int i16 = textureInfo.height;
            if (f18 > i16) {
                f18 = i16;
                Logger.e(this.TAG, "applyFilter: crop bottom pixel exceed texture height");
            }
            PointF pointF = cGRect.origin;
            float f19 = pointF.x;
            float f26 = pointF.y;
            this.triangleVertices.rewind();
            this.triangleVertices.put(new float[]{f19, f18, f19, f26, f17, f18, f17, f26});
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            int i17 = this.outputFrameBufferId;
            if (i17 != -1) {
                GLES20.glBindFramebuffer(36160, i17);
                GLES20.glGetIntegerv(2978, iArr, 0);
                GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
            }
            GLES20.glUseProgram(this.program);
            RenderContext.checkEglError("glUseProgram");
            GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix2), 0);
            GLES20.glUniform1f(this.uAlphaHandle, f16);
            GLES20.glEnable(3042);
            GLES20.glBlendEquationSeparate(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
            GLES20.glBlendFuncSeparate(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            prepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(matrix));
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            RenderContext.checkEglError("glDrawArrays");
            finishDraw(textureInfo);
            if (this.outputFrameBufferId != -1) {
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            GLES20.glBlendFuncSeparate(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            return this.outputTextureInfo;
        }

        public void clearBufferBuffer(int i3) {
            int i16 = this.outputFrameBufferId;
            if (i16 != -1) {
                GLES20.glBindFramebuffer(36160, i16);
                GLES20.glClearColor(((16711680 & i3) >> 16) / 255.0f, ((65280 & i3) >> 8) / 255.0f, (i3 & 255) / 255.0f, 1.0f);
                GLES20.glClear(16384);
            }
        }

        public void release() {
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
                    Logger.d(this.TAG, "release: end");
                    return;
                }
            }
        }

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
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        return new CropEffectFilter();
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @Nullable
    /* renamed from: effectId */
    public String getMEffectId() {
        if (this.mCropModel == null) {
            return "";
        }
        return this.sEffectId;
    }

    public CropModel getCropModel() {
        return this.mCropModel;
    }

    public void setCropModel(CropModel cropModel) {
        this.mCropModel = cropModel;
    }
}
