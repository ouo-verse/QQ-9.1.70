package com.tencent.view;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RendererUtils {
    static IPatchRedirector $redirector_ = null;
    private static final float DEGREE_TO_RADIAN = 0.017453292f;
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nuniform vec4 bkg;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.r*alpha + bkg.r*(1.0-alpha), color.g*alpha + bkg.g*(1.0-alpha), color.b*alpha + bkg.b*(1.0-alpha), 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_ALPHA = "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nuniform vec4 bkg;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.r*alpha + bkg.r*(1.0-alpha), color.g*alpha + bkg.g*(1.0-alpha), color.b*alpha + bkg.b*(1.0-alpha), color.a);\n}\n";
    private static final float[] POS_VERTICES;
    private static final float[] TEX_VERTICES;
    private static final String VERTEX_SHADER = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FilterContext {
        static IPatchRedirector $redirector_;
        public int posCoordHandle;
        public FloatBuffer posVertices;
        public int shaderProgram;
        public int texCoordHandle;
        public int texSamplerHandle;
        public FloatBuffer texVertices;

        public FilterContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class RenderContext {
        static IPatchRedirector $redirector_;
        private float alpha;
        private boolean alphaBlend;
        private int alphaHandle;
        private int bkgHandle;
        private int posCoordHandle;
        private FloatBuffer posVertices;
        private int shaderProgram;
        private int texCoordHandle;
        private int texSamplerHandle;
        private FloatBuffer texVertices;

        public RenderContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.alpha = 1.0f;
                this.alphaBlend = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TEX_VERTICES = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            POS_VERTICES = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        }
    }

    public RendererUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkGlError(String str) {
        int glGetError;
        if (AEOpenRenderConfig.isEnableLog() && (glGetError = GLES20.glGetError()) != 0) {
            LogUtils.e("RendererUtils", str + ": glError " + glGetError);
            for (StackTraceElement stackTraceElement : Thread.getAllStackTraces().get(Thread.currentThread())) {
                LogUtils.e("SS     ", stackTraceElement.toString());
            }
        }
    }

    public static void clearTexture(int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        checkGlError("glDeleteTextures");
    }

    public static FilterContext createFilterProgram(String str, String str2, float[] fArr, float[] fArr2) {
        int loadShader;
        if (str == null) {
            str = VERTEX_SHADER;
        }
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glDeleteShader(loadShader2);
            GLES20.glDeleteShader(loadShader);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException("Could not link program: " + glGetProgramInfoLog);
            }
        }
        FilterContext filterContext = new FilterContext();
        filterContext.texSamplerHandle = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        filterContext.texCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        filterContext.posCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        if (fArr2 == null) {
            fArr2 = TEX_VERTICES;
        }
        filterContext.texVertices = createVerticesBuffer(fArr2);
        if (fArr == null) {
            fArr = POS_VERTICES;
        }
        filterContext.posVertices = createVerticesBuffer(fArr);
        filterContext.shaderProgram = glCreateProgram;
        return filterContext;
    }

    private static RenderContext createProgram(float[] fArr, float[] fArr2, boolean z16) {
        int loadShader;
        int loadShader2 = loadShader(35633, VERTEX_SHADER);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, FRAGMENT_SHADER_ALPHA)) == 0) {
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glDeleteShader(loadShader2);
            GLES20.glDeleteShader(loadShader);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException("Could not link program: " + glGetProgramInfoLog);
            }
        }
        RenderContext renderContext = new RenderContext();
        renderContext.texSamplerHandle = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        renderContext.alphaHandle = GLES20.glGetUniformLocation(glCreateProgram, c.f123400v);
        renderContext.bkgHandle = GLES20.glGetUniformLocation(glCreateProgram, "bkg");
        renderContext.texCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        renderContext.posCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        renderContext.texVertices = createVerticesBuffer(fArr2);
        renderContext.posVertices = createVerticesBuffer(fArr);
        renderContext.shaderProgram = glCreateProgram;
        renderContext.alphaBlend = z16;
        return renderContext;
    }

    public static RenderContext createProgramWithBlend() {
        return createProgram(POS_VERTICES, TEX_VERTICES, true);
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GlUtil.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        return iArr[0];
    }

    private static FloatBuffer createVerticesBuffer(float[] fArr) {
        if (fArr.length == 8) {
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(fArr).position(0);
            return asFloatBuffer;
        }
        throw new RuntimeException("Number of vertices should be four.");
    }

    public static void deleteProgram(int i3) {
        GLES20.glDeleteProgram(i3);
    }

    private static float[] getFitVertices(int i3, int i16, int i17, int i18) {
        float f16 = (i17 / i18) / (i3 / i16);
        float[] fArr = new float[8];
        System.arraycopy(POS_VERTICES, 0, fArr, 0, 8);
        if (f16 > 1.0f) {
            fArr[0] = fArr[0] / f16;
            fArr[2] = fArr[2] / f16;
            fArr[4] = fArr[4] / f16;
            fArr[6] = fArr[6] / f16;
        } else {
            fArr[1] = fArr[1] * f16;
            fArr[3] = fArr[3] * f16;
            fArr[5] = fArr[5] * f16;
            fArr[7] = fArr[7] * f16;
        }
        return fArr;
    }

    private static int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new RuntimeException("Could not compile shader " + i3 + ":" + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    public static void renderBackground(int i3) {
        if (i3 != -1) {
            GLES20.glClearColor(Color.red(i3) / 255.0f, Color.green(i3) / 255.0f, Color.blue(i3) / 255.0f, Color.alpha(i3) / 255.0f);
        } else {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        }
        GLES20.glClear(16384);
    }

    public static void renderTexture(RenderContext renderContext, int i3, int i16, int i17, boolean z16) {
        renderContext.alphaBlend = z16;
        renderTexture(renderContext, i3, i16, i17);
    }

    public static void renderTexture2FBO(FilterContext filterContext, int i3, int i16, int i17, int i18) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i16);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i17, i18, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        checkGlError("glTexImage2D");
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i16, 0);
        checkGlError("glFramebufferTexture2D");
        GLES20.glViewport(0, 0, i17, i18);
        checkGlError("glViewport");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(filterContext.shaderProgram);
        if (GLES20.glGetError() != 0) {
            checkGlError("createProgram");
        }
        GLES20.glVertexAttribPointer(filterContext.texCoordHandle, 2, 5126, false, 0, (Buffer) filterContext.texVertices);
        GLES20.glEnableVertexAttribArray(filterContext.texCoordHandle);
        GLES20.glVertexAttribPointer(filterContext.posCoordHandle, 2, 5126, false, 0, (Buffer) filterContext.posVertices);
        GLES20.glEnableVertexAttribArray(filterContext.posCoordHandle);
        checkGlError("vertex attribute setup");
        GLES20.glUniform1i(filterContext.texSamplerHandle, 0);
        checkGlError("glUniform1i");
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        checkGlError("glBindTexture");
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        checkGlError("glBindFramebuffer");
        deleteProgram(filterContext.shaderProgram);
    }

    public static Bitmap saveTexture(int i3, int i16, int i17) {
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        saveTextureToBitmap(i3, i16, i17, createBitmap);
        return createBitmap;
    }

    public static Bitmap saveTexture2Bitmap(int i3, int i16, int i17, int i18) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, i16, i3, 0);
        ByteBuffer allocate = ByteBuffer.allocate(i17 * i18 * 4);
        GLES20.glReadPixels(0, 0, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
        allocate.position(0);
        createBitmap.copyPixelsFromBuffer(allocate);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }

    public static QImage saveTexture2QImage(int i3, int i16, int i17) {
        return saveTexture2QImageWithShare(i3, i16, i17, BitmapUtils.currentShareIndex);
    }

    public static QImage saveTexture2QImageWithShare(int i3, int i16, int i17, int i18) {
        if (i18 < 0) {
            if (DeviceAttrs.getInstance().gpuWorkaroundForTU880) {
                GLES20.glActiveTexture(33984);
                checkGlError("glActiveTexture");
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
                checkGlError("glBindTexture");
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
            checkGlError("glFramebufferTexture2D");
            checkGlError("glReadPixels");
            QImage nativeCopyTexture = GLSLRender.nativeCopyTexture(i16, i17);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            checkGlError("glBindFramebuffer");
            return nativeCopyTexture;
        }
        return GLSLRender.nativeCopyTextureWithShare(i16, i17, i3, i18);
    }

    public static Bitmap saveTextureTo(int i3, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glReadPixels(i18, i19, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        checkGlError("glReadPixels");
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }

    public static void saveTextureToBitmap(int i3, int i16, int i17, Bitmap bitmap) {
        saveTextureToBitmapWithShare(i3, i16, i17, bitmap, BitmapUtils.currentShareIndex);
    }

    public static void saveTextureToBitmapWithShare(int i3, int i16, int i17, Bitmap bitmap, int i18) {
        if (i18 < 0) {
            if (DeviceAttrs.getInstance().gpuWorkaroundForTU880) {
                GLES20.glActiveTexture(33984);
                checkGlError("glActiveTexture");
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
                checkGlError("glBindTexture");
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
            checkGlError("glFramebufferTexture2D");
            checkGlError("glReadPixels");
            GLSLRender.nativeCopyPixelToBitmap(bitmap);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            checkGlError("glBindFramebuffer");
            return;
        }
        GLSLRender.nativeCopyPixelToBitmapWithShare(bitmap, i3, i18);
    }

    public static ByteBuffer saveTextureToByteBuffer(int i3, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glReadPixels(i18, i19, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        checkGlError("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return allocate;
    }

    public static void saveTextureToRgbBuffer(int i3, int i16, int i17, byte[] bArr, int i18) {
        int i19 = BitmapUtils.currentShareIndex;
        if (i19 < 0) {
            GLES20.glBindFramebuffer(36160, i18);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
            checkGlError("glFramebufferTexture2D");
            GLSLRender.nativeToRGBData(bArr, i16, i17);
            GLES20.glBindFramebuffer(36160, 0);
            checkGlError("glBindFramebuffer");
            return;
        }
        GLSLRender.nativePushDataFromTexture(bArr, i16, i17, i19);
    }

    public static void saveTextureToRgbBufferByShare(int i3, int i16, int i17, byte[] bArr, int i18) {
        GLSLRender.nativeCopyTexturToDataWithShare(i3, bArr, i16, i17, i18);
    }

    public static void setRenderToAlpha(RenderContext renderContext, int i3) {
        renderContext.alpha = i3 / 255.0f;
    }

    public static void setRenderToFit(RenderContext renderContext, int i3, int i16, int i17, int i18) {
        renderContext.posVertices = createVerticesBuffer(getFitVertices(i3, i16, i17, i18));
    }

    public static void setRenderToFlip(RenderContext renderContext, int i3, int i16, int i17, int i18, float f16, float f17) {
        float f18;
        float[] fitVertices = getFitVertices(i3, i16, i17, i18);
        if ((((int) f16) / 180) % 2 != 0) {
            float f19 = -fitVertices[0];
            fitVertices[0] = f19;
            fitVertices[4] = f19;
            float f26 = -fitVertices[2];
            fitVertices[2] = f26;
            fitVertices[6] = f26;
        }
        if ((((int) f17) / 180) % 2 != 0) {
            float f27 = -fitVertices[1];
            fitVertices[1] = f27;
            fitVertices[3] = f27;
            float f28 = -fitVertices[5];
            fitVertices[5] = f28;
            fitVertices[7] = f28;
        }
        float[] fArr = new float[8];
        System.arraycopy(fitVertices, 0, fArr, 0, 8);
        if (f16 % 180.0f != 0.0f) {
            double d16 = (f16 - (r3 * 180)) * 0.017453292f;
            float cos = (float) Math.cos(d16);
            float sin = (float) Math.sin(d16);
            float f29 = fitVertices[0];
            float f36 = 5.0f / ((sin * f29) + 5.0f);
            float f37 = f29 * cos * f36;
            fArr[0] = f37;
            fArr[1] = fitVertices[1] * f36;
            fArr[4] = f37;
            fArr[5] = fitVertices[5] * f36;
            float f38 = fitVertices[2];
            float f39 = 5.0f / ((sin * f38) + 5.0f);
            float f46 = cos * f38 * f39;
            fArr[2] = f46;
            fArr[3] = fitVertices[3] * f39;
            fArr[6] = f46;
            fArr[7] = fitVertices[7] * f39;
            f18 = 180.0f;
        } else {
            f18 = 180.0f;
        }
        if (f17 % f18 != 0.0f) {
            double d17 = (f17 - (r4 * 180)) * 0.017453292f;
            float cos2 = (float) Math.cos(d17);
            float sin2 = (float) Math.sin(d17);
            float f47 = fitVertices[1];
            float f48 = 5.0f / ((sin2 * f47) + 5.0f);
            fArr[0] = fitVertices[0] * f48;
            float f49 = f47 * cos2 * f48;
            fArr[1] = f49;
            fArr[2] = fitVertices[2] * f48;
            fArr[3] = f49;
            float f56 = fitVertices[5];
            float f57 = 5.0f / ((sin2 * f56) + 5.0f);
            fArr[4] = fitVertices[4] * f57;
            float f58 = cos2 * f56 * f57;
            fArr[5] = f58;
            fArr[6] = fitVertices[6] * f57;
            fArr[7] = f58;
        }
        renderContext.posVertices = createVerticesBuffer(fArr);
    }

    public static void setRenderToRotate(RenderContext renderContext, int i3, int i16, int i17, int i18, float f16) {
        double d16 = (-f16) * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        float f17 = i3;
        float f18 = cos * f17;
        float f19 = f17 * sin;
        float f26 = i16;
        float f27 = cos * f26;
        float f28 = sin * f26;
        float[] fArr = new float[8];
        float f29 = (-f18) + f28;
        fArr[0] = f29;
        float f36 = (-f19) - f27;
        fArr[1] = f36;
        float f37 = f18 + f28;
        fArr[2] = f37;
        float f38 = f19 - f27;
        fArr[3] = f38;
        fArr[4] = -f37;
        fArr[5] = -f38;
        fArr[6] = -f29;
        fArr[7] = -f36;
        float f39 = i17;
        float f46 = i18;
        float min = Math.min(f39 / Math.max(Math.abs(f29), Math.abs(fArr[2])), f46 / Math.max(Math.abs(fArr[1]), Math.abs(fArr[3])));
        for (int i19 = 0; i19 < 8; i19 += 2) {
            fArr[i19] = fArr[i19] * (min / f39);
            int i26 = i19 + 1;
            fArr[i26] = fArr[i26] * (min / f46);
        }
        renderContext.posVertices = createVerticesBuffer(fArr);
    }

    public static void setRenderToScale(RenderContext renderContext, RectF rectF) {
        float f16 = rectF.left;
        float f17 = rectF.bottom;
        float f18 = rectF.right;
        float f19 = rectF.top;
        renderContext.posVertices = createVerticesBuffer(new float[]{(f16 * 2.0f) - 1.0f, 1.0f - (f17 * 2.0f), (f18 * 2.0f) - 1.0f, 1.0f - (f17 * 2.0f), (f16 * 2.0f) - 1.0f, 1.0f - (f19 * 2.0f), (f18 * 2.0f) - 1.0f, 1.0f - (f19 * 2.0f)});
    }

    public static int createTexture(Bitmap bitmap) {
        int createTexture = createTexture();
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, createTexture);
        try {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
        }
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        checkGlError("texImage2D");
        return createTexture;
    }

    public static void renderTexture(RenderContext renderContext, int i3, int i16, int i17) {
        GLES20.glUseProgram(renderContext.shaderProgram);
        if (GLES20.glGetError() != 0) {
            createProgram();
            checkGlError("createProgram");
        }
        GLES20.glViewport(0, 0, i16, i17);
        checkGlError("glViewport");
        if (renderContext.alphaBlend) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        } else {
            GLES20.glDisable(3042);
        }
        GLES20.glVertexAttribPointer(renderContext.texCoordHandle, 2, 5126, false, 0, (Buffer) renderContext.texVertices);
        GLES20.glEnableVertexAttribArray(renderContext.texCoordHandle);
        GLES20.glVertexAttribPointer(renderContext.posCoordHandle, 2, 5126, false, 0, (Buffer) renderContext.posVertices);
        GLES20.glEnableVertexAttribArray(renderContext.posCoordHandle);
        checkGlError("vertex attribute setup");
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        checkGlError("glBindTexture");
        GLES20.glUniform1i(renderContext.texSamplerHandle, 0);
        GLES20.glUniform1f(renderContext.alphaHandle, renderContext.alpha);
        GLES20.glUniform4f(renderContext.bkgHandle, 0.203125f, 0.203125f, 0.21484375f, 1.0f);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
    }

    public static Bitmap saveTexture(Frame frame) {
        if (frame == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(frame.width, frame.height, Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            saveTextureToBitmap(frame.getTextureId(), frame.width, frame.height, createBitmap);
        }
        return createBitmap;
    }

    public static void renderBackground() {
        GLES20.glClearColor(0.22265625f, 0.22265625f, 0.22265625f, 1.0f);
        GLES20.glClear(16384);
    }

    public static RenderContext createProgram() {
        return createProgram(POS_VERTICES, TEX_VERTICES, false);
    }
}
