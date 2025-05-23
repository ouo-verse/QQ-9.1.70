package com.tencent.mobileqq.qzoneplayer.videorenderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oskplayer.util.PlayerUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes16.dex */
public class VideoTextureRenderer extends TextureSurfaceRenderer implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_ = null;
    public static final String LOG_TAG = "VideoTextureRenderer";
    private static short[] drawOrder = null;
    private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
    private static float[] squareCoords = null;
    private static float squareSize = 0.0f;
    private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
    private Context ctx;
    private int currentTime;
    private ShortBuffer drawListBuffer;
    private int fragmentShaderHandle;
    private boolean frameAvailable;
    private CountDownLatch latch;
    private int shaderProgram;
    private FloatBuffer textureBuffer;
    private float[] textureCoords;
    private int[] textures;
    private FloatBuffer vertexBuffer;
    private int vertexShaderHandle;
    private int videoHeight;
    private SurfaceTexture videoTexture;
    private float[] videoTextureTransform;
    private int videoWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        squareSize = 1.0f;
        squareCoords = new float[]{-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        drawOrder = new short[]{0, 1, 2, 0, 2, 3};
    }

    public VideoTextureRenderer(CountDownLatch countDownLatch, SurfaceTexture surfaceTexture, int i3, int i16) {
        super(surfaceTexture, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, countDownLatch, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.textureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        this.textures = new int[1];
        this.frameAvailable = false;
        this.latch = countDownLatch;
        this.videoTextureTransform = new float[16];
    }

    private void loadShaders() {
        int glCreateShader = GLES20.glCreateShader(35633);
        this.vertexShaderHandle = glCreateShader;
        GLES20.glShaderSource(glCreateShader, vertexShaderCode);
        GLES20.glCompileShader(this.vertexShaderHandle);
        checkGlError("Vertex shader compile");
        int glCreateShader2 = GLES20.glCreateShader(35632);
        this.fragmentShaderHandle = glCreateShader2;
        GLES20.glShaderSource(glCreateShader2, fragmentShaderCode);
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
            PlayerUtils.log(6, "SurfaceTest", "Error while linking program:\n" + GLES20.glGetProgramInfoLog(this.shaderProgram));
        }
    }

    private void setupTexture() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.textureBuffer = asFloatBuffer;
        asFloatBuffer.put(this.textureCoords);
        this.textureBuffer.position(0);
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.textures, 0);
        checkGlError("Texture generate");
        GLES20.glBindTexture(36197, this.textures[0]);
        checkGlError("Texture bind");
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textures[0]);
        this.videoTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.latch.countDown();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                PlayerUtils.log(6, "SurfaceTest", str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.videorenderer.TextureSurfaceRenderer
    protected void deinitGLComponents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        GLES20.glDeleteTextures(1, this.textures, 0);
        GLES20.glDeleteProgram(this.shaderProgram);
        this.videoTexture.release();
        this.videoTexture.setOnFrameAvailableListener(null);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.videorenderer.TextureSurfaceRenderer
    protected boolean draw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        synchronized (this) {
            if (!this.frameAvailable) {
                return false;
            }
            this.videoTexture.updateTexImage();
            this.videoTexture.getTransformMatrix(this.videoTextureTransform);
            this.frameAvailable = false;
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.shaderProgram);
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.shaderProgram, "textureTransform");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 3, 5126, false, 12, (Buffer) this.vertexBuffer);
            GLES20.glBindTexture(36197, this.textures[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(glGetUniformLocation, 0);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, (Buffer) this.textureBuffer);
            GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, this.videoTextureTransform, 0);
            GLES20.glDrawElements(4, drawOrder.length, 5123, this.drawListBuffer);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
            GLES20.glViewport(0, 0, this.width, this.height);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.videorenderer.TextureSurfaceRenderer
    public SurfaceTexture getSurfaceTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.videoTexture;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.videorenderer.TextureSurfaceRenderer
    protected void initGLComponents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        setupVertexBuffer();
        setupTexture();
        loadShaders();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceTexture);
        } else {
            synchronized (this) {
                this.frameAvailable = true;
            }
        }
    }
}
