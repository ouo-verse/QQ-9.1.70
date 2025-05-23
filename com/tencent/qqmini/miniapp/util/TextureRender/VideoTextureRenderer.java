package com.tencent.qqmini.miniapp.util.TextureRender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VideoTextureRenderer extends TextureSurfaceRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "miniapp-embedded";
    private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
    private static float squareSize = 1.0f;
    private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
    private boolean adjustViewport;
    private Context ctx;
    private ShortBuffer drawListBuffer;
    private int fragmentShaderHandle;
    private boolean frameAvailable;
    private String objectFit;
    private int shaderProgram;
    private FloatBuffer textureBuffer;
    private int[] textures;
    private FloatBuffer vertexBuffer;
    private int vertexShaderHandle;
    private int videoHeight;
    private SurfaceTexture videoTexture;
    private float[] videoTextureTransform;
    private int videoWidth;
    private static float[] squareCoords = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private static short[] drawOrder = {0, 1, 2, 0, 2, 3};
    private static float[] textureCoords = {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    public VideoTextureRenderer(Context context, Surface surface, int i3, int i16, Handler handler) {
        super(surface, i3, i16, handler);
        this.textures = new int[1];
        this.frameAvailable = false;
        this.objectFit = HVideoConstants.ResizeType.RESIZE_CONTAIN;
        this.adjustViewport = false;
        this.ctx = context;
        this.videoTextureTransform = new float[16];
    }

    private void adjustViewport() {
        if (HVideoConstants.ResizeType.RESIZE_CONTAIN.equals(this.objectFit)) {
            float min = Math.min(this.width / this.videoWidth, this.height / this.videoHeight);
            QMLog.d(TAG, "contain scale : " + min);
            GLES20.glViewport((int) ((float) Math.round((((float) this.width) - (((float) this.videoWidth) * min)) * 0.5f)), (int) ((float) Math.round((((float) this.height) - (((float) this.videoHeight) * min)) * 0.5f)), (int) (((float) this.videoWidth) * min), (int) (((float) this.videoHeight) * min));
        } else if (CanvasView.CUSTOM_ACTION_FILL.equals(this.objectFit)) {
            GLES20.glViewport(0, 0, this.width, this.height);
        } else if ("cover".equals(this.objectFit)) {
            float max = Math.max(this.width / this.videoWidth, this.height / this.videoHeight);
            QMLog.d(TAG, "cover scale : " + max);
            GLES20.glViewport((int) ((float) Math.round((((float) this.width) - (((float) this.videoWidth) * max)) * 0.5f)), (int) ((float) Math.round((((float) this.height) - (((float) this.videoHeight) * max)) * 0.5f)), (int) (((float) this.videoWidth) * max), (int) (((float) this.videoHeight) * max));
        }
        this.adjustViewport = false;
    }

    private void loadShaders() {
        try {
            QMLog.d(TAG, "loadShaders");
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
                QMLog.e(TAG, "Error while linking program:\n" + GLES20.glGetProgramInfoLog(this.shaderProgram));
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "loadShaders error.", th5);
        }
    }

    private void setupTexture(Context context) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureCoords.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            this.textureBuffer = asFloatBuffer;
            asFloatBuffer.put(textureCoords);
            this.textureBuffer.position(0);
            GLES20.glActiveTexture(33984);
            GLES20.glGenTextures(1, this.textures, 0);
            checkGlError("Texture generate");
            GLES20.glBindTexture(36197, this.textures[0]);
            checkGlError("Texture bind");
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.textures[0]);
            this.videoTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessage(1002);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "setupTexture error.", th5);
        }
    }

    private void setupVertexBuffer() {
        try {
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
        } catch (Throwable th5) {
            QMLog.e(TAG, "setupVertexBuffer error.", th5);
        }
    }

    public void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                QMLog.d(TAG, str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.util.TextureRender.TextureSurfaceRenderer
    protected void deinitGLComponents() {
        GLES20.glDeleteTextures(1, this.textures, 0);
        GLES20.glDeleteProgram(this.shaderProgram);
        this.videoTexture.release();
        this.videoTexture.setOnFrameAvailableListener(null);
    }

    @Override // com.tencent.qqmini.miniapp.util.TextureRender.TextureSurfaceRenderer
    protected boolean draw() {
        try {
            synchronized (this) {
                if (!this.frameAvailable) {
                    return false;
                }
                this.videoTexture.updateTexImage();
                this.videoTexture.getTransformMatrix(this.videoTextureTransform);
                this.frameAvailable = false;
                if (this.adjustViewport) {
                    adjustViewport();
                }
                GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
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
                return true;
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "draw error.", th5);
            return false;
        }
    }

    public SurfaceTexture getVideoTexture() {
        return this.videoTexture;
    }

    @Override // com.tencent.qqmini.miniapp.util.TextureRender.TextureSurfaceRenderer
    protected void initGLComponents() {
        QMLog.d(TAG, "initGLComponents \uff1a " + Thread.currentThread());
        setupVertexBuffer();
        setupTexture(this.ctx);
        loadShaders();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.frameAvailable = true;
        }
    }

    public void setSurfaceSize(int i3, int i16) {
        QMLog.e(TAG, "setSurfaceSize " + i3 + "; " + i16);
        this.width = i3;
        this.height = i16;
    }

    public void setVideoSize(int i3, int i16, String str) {
        QMLog.e(TAG, "setVideoSize " + i3 + "; " + i16 + "; " + str);
        this.videoWidth = i3;
        this.videoHeight = i16;
        this.objectFit = str;
        this.adjustViewport = true;
    }
}
