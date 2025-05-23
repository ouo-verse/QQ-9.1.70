package com.tencent.ams.fusion.widget.alphaplayer.gl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AlphaTextureRenderer extends TextureSurfaceRenderer implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AlphaTextureRenderer";
    private static short[] drawOrder = null;
    private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;varying highp vec2 textureCoordinateRGB;varying highp vec2 textureCoordinateAlpha;void main () {    highp vec4 rgbColor = texture2D(texture, textureCoordinateRGB);    highp vec4 alphaColor = texture2D(texture, textureCoordinateAlpha);    gl_FragColor = vec4(rgbColor.rgb * alphaColor.rgb, alphaColor.r);}";
    private static float[] squareCoords = null;
    private static float squareSize = 0.0f;
    private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;varying vec2 textureCoordinateRGB;varying vec2 textureCoordinateAlpha;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;   textureCoordinateRGB = vec2((textureTransform * vTexCoordinate).x, (textureTransform * vTexCoordinate).y);   textureCoordinateAlpha = vec2(((textureTransform * vec4(vTexCoordinate.x + 0.5, vTexCoordinate.y, vTexCoordinate.z, vTexCoordinate.w))).x, (textureTransform * vTexCoordinate).y);}";
    private boolean adjustViewport;
    private ShortBuffer drawListBuffer;
    private int fragmentShaderHandle;
    private boolean frameAvailable;
    private final ScaleType scaleType;
    private int shaderProgram;
    private FloatBuffer textureBuffer;
    private float[] textureCoords;
    private int[] textures;
    private FloatBuffer vertexBuffer;
    private int vertexShaderHandle;
    protected int videoHeight;
    private SurfaceTexture videoTexture;
    private float[] videoTextureTransform;
    protected int videoWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31142);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ScaleType.values().length];
            $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType = iArr;
            try {
                iArr[ScaleType.FIT_HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType[ScaleType.FIT_WIDTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType[ScaleType.FIT_XY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType[ScaleType.CENTER_CROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType[ScaleType.FIT_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        squareSize = 1.0f;
        squareCoords = new float[]{-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        drawOrder = new short[]{0, 1, 2, 0, 2, 3};
    }

    public AlphaTextureRenderer(Object obj, int i3, int i16, TextureSurfaceRenderer.RendererStatusChangeListener rendererStatusChangeListener) {
        this(obj, i3, i16, ScaleType.FIT_CENTER, rendererStatusChangeListener, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), rendererStatusChangeListener);
    }

    private void adjustViewport() {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$ams$fusion$widget$alphaplayer$gl$ScaleType[this.scaleType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        adjustViewportFitCenter();
                    } else {
                        adjustViewportCenterCrop();
                    }
                } else {
                    adjustViewportFitXY();
                }
            } else {
                adjustViewportFitWidth();
            }
        } else {
            adjustViewportFitHeight();
        }
        this.adjustViewport = false;
    }

    private void adjustViewportCenterCrop() {
        int i3;
        try {
            int trueVideoWidth = getTrueVideoWidth();
            int i16 = this.width;
            int i17 = this.height;
            int i18 = trueVideoWidth * i17;
            int i19 = this.videoHeight;
            int i26 = 0;
            if (i18 > i16 * i19) {
                int i27 = (trueVideoWidth * i17) / i19;
                int i28 = (i27 - i16) / 2;
                i16 = i27;
                i3 = 0;
                i26 = i28;
            } else if (trueVideoWidth * i17 < i16 * i19) {
                int i29 = (i19 * i16) / trueVideoWidth;
                i3 = (i29 - i17) / 2;
                i17 = i29;
            } else {
                i3 = 0;
            }
            GLES20.glViewport(-i26, -i3, i16, i17);
            Logger.i(TAG, "adjustViewportCenterCrop - glViewport(, " + i26 + ", " + i3 + ", " + i16 + ", " + i17 + ")");
        } catch (Throwable th5) {
            Logger.e(TAG, "adjustViewportCenterCrop() failed", th5);
        }
    }

    private void adjustViewportFitCenter() {
        try {
            int trueVideoWidth = getTrueVideoWidth();
            int i3 = this.height;
            int i16 = this.width;
            float f16 = i3 / i16;
            int i17 = this.videoHeight;
            float f17 = trueVideoWidth;
            if (f16 > i17 / f17) {
                int i18 = (int) (i17 * (i16 / f17));
                int i19 = -((i18 - i3) / 2);
                GLES20.glViewport(0, i19, i16, i18);
                Logger.i(TAG, "adjustViewportFitCenter - glViewport(0, " + i19 + ", " + this.width + ", " + i18 + ")");
            } else {
                int i26 = (int) (f17 * (i3 / i17));
                int i27 = -((i26 - i16) / 2);
                GLES20.glViewport(i27, 0, i26, i3);
                Logger.i(TAG, "adjustViewportFitCenter - glViewport(, " + i27 + ", 0, " + i26 + ", " + this.height + ")");
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "adjustViewportFitCenter() failed", th5);
        }
    }

    private void adjustViewportFitHeight() {
        try {
            int trueVideoWidth = getTrueVideoWidth();
            int i3 = this.height;
            int i16 = (int) (trueVideoWidth * (i3 / this.videoHeight));
            int i17 = -((i16 - this.width) / 2);
            GLES20.glViewport(i17, 0, i16, i3);
            Logger.i(TAG, "adjustViewportFitHeight - glViewport(, " + i17 + ", 0, " + i16 + ", " + this.height + ")");
        } catch (Throwable th5) {
            Logger.e(TAG, "adjustViewportFitHeight() failed", th5);
        }
    }

    private void adjustViewportFitWidth() {
        try {
            int trueVideoWidth = getTrueVideoWidth();
            int i3 = this.width;
            int i16 = (int) (this.videoHeight * (i3 / trueVideoWidth));
            int i17 = -((i16 - this.height) / 2);
            GLES20.glViewport(0, i17, i3, i16);
            Logger.i(TAG, "adjustViewportFitCenter - glViewport(0, " + i17 + ", " + this.width + ", " + i16 + ")");
        } catch (Throwable th5) {
            Logger.e(TAG, "adjustViewportFitWidth() failed", th5);
        }
    }

    private void adjustViewportFitXY() {
        try {
            GLES20.glViewport(0, 0, this.width, this.height);
            Logger.i(TAG, "adjustViewportFitXY - glViewport(, 0, 0, " + this.width + ", " + this.height + ")");
        } catch (Throwable th5) {
            Logger.e(TAG, "adjustViewportFitXY() failed", th5);
        }
    }

    private void loadShaders() {
        int glCreateShader = GLES20.glCreateShader(35633);
        this.vertexShaderHandle = glCreateShader;
        GLES20.glShaderSource(glCreateShader, getVertexShaderCode());
        GLES20.glCompileShader(this.vertexShaderHandle);
        checkGlError("Vertex shader compile");
        int glCreateShader2 = GLES20.glCreateShader(35632);
        this.fragmentShaderHandle = glCreateShader2;
        GLES20.glShaderSource(glCreateShader2, getFragmentShaderCode());
        GLES20.glCompileShader(this.fragmentShaderHandle);
        checkGlError("Pixel shader compile");
        int glCreateProgram = GLES20.glCreateProgram();
        this.shaderProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, this.vertexShaderHandle);
        GLES20.glAttachShader(this.shaderProgram, this.fragmentShaderHandle);
        GLES20.glLinkProgram(this.shaderProgram);
        checkGlError("Shader program compile");
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(this.shaderProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("SurfaceTest", "Error while linking program:\n" + GLES20.glGetProgramInfoLog(this.shaderProgram));
        }
    }

    private void setupTexture() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(getTextureCoordinates().length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.textureBuffer = asFloatBuffer;
        asFloatBuffer.put(getTextureCoordinates());
        this.textureBuffer.position(0);
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.textures, 0);
        checkGlError("Texture generate");
        GLES20.glBindTexture(36197, this.textures[0]);
        checkGlError("Texture bind");
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textures[0]);
        this.videoTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    private void setupVertexBuffer() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(drawOrder.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.drawListBuffer = asShortBuffer;
        asShortBuffer.put(drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(squareCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(squareCoords);
        this.vertexBuffer.position(0);
    }

    public void checkGlError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Logger.e(TAG, str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer
    protected void destroyGLComponents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        GLES20.glDeleteTextures(1, this.textures, 0);
        GLES20.glDeleteProgram(this.shaderProgram);
        this.videoTexture.release();
        this.videoTexture.setOnFrameAvailableListener(null);
        Logger.d(TAG, "destroyGLComponents");
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer
    protected boolean draw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            this.videoTexture.updateTexImage();
            this.videoTexture.getTransformMatrix(this.videoTextureTransform);
            if (this.adjustViewport) {
                adjustViewport();
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            if (this.isClearSurface) {
                return true;
            }
            GLES20.glUseProgram(this.shaderProgram);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.shaderProgram, "textureTransform");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 3, 5126, false, 0, (Buffer) this.vertexBuffer);
            GLES20.glBindTexture(36197, this.textures[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(glGetUniformLocation, 0);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, (Buffer) this.textureBuffer);
            GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, this.videoTextureTransform, 0);
            GLES20.glDrawElements(4, drawOrder.length, 5123, this.drawListBuffer);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
            GLES20.glDisable(3042);
            return true;
        } catch (Exception e16) {
            Logger.e(TAG, "draw:thread id =" + Thread.currentThread().getId(), e16);
            return false;
        }
    }

    protected String getFragmentShaderCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return fragmentShaderCode;
    }

    protected float[] getTextureCoordinates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (float[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.textureCoords;
    }

    protected int getTrueVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.videoWidth / 2;
    }

    protected String getVertexShaderCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return vertexShaderCode;
    }

    public SurfaceTexture getVideoTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.videoTexture;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer
    @RequiresApi(api = 15)
    protected void initGLComponents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        setupVertexBuffer();
        setupTexture();
        loadShaders();
        Logger.d(TAG, "initGLComponents");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) surfaceTexture);
        } else {
            synchronized (this) {
                this.frameAvailable = true;
            }
        }
    }

    public void setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.adjustViewport = true;
    }

    public void setVideoSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.videoWidth = i3;
        this.videoHeight = i16;
        this.adjustViewport = true;
    }

    public AlphaTextureRenderer(Object obj, int i3, int i16, ScaleType scaleType, TextureSurfaceRenderer.RendererStatusChangeListener rendererStatusChangeListener, Executor executor) {
        super(obj, i3, i16, rendererStatusChangeListener, executor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), scaleType, rendererStatusChangeListener, executor);
            return;
        }
        this.textureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 0.0f, 1.0f};
        this.textures = new int[1];
        this.frameAvailable = false;
        this.adjustViewport = false;
        this.videoTextureTransform = new float[16];
        if (scaleType != null) {
            this.scaleType = scaleType;
        } else {
            this.scaleType = ScaleType.FIT_CENTER;
        }
    }
}
