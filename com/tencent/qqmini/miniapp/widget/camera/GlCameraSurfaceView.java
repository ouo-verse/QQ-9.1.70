package com.tencent.qqmini.miniapp.widget.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GlCameraSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "CameraSurfaceView";
    private boolean isSurfaceCreate;
    private Camera.Size mCameraSize;
    private FloatBuffer mDataBuffer;
    private int[] mFBOIds;
    private CameraFilterEngine mFilter;
    private SurfaceTexture mPreviewSt;
    private int mShaderProgram;
    private int mTextureId;
    private float[] transformMatrix;

    public GlCameraSurfaceView(Context context) {
        super(context);
        this.mFBOIds = new int[1];
        this.transformMatrix = new float[16];
        init();
    }

    private void changeGlSurfaceSize() {
        int i3;
        int width = getWidth();
        int height = getHeight();
        if (width != 0 && height != 0) {
            Camera.Size size = this.mCameraSize;
            int i16 = 0;
            if (size != null) {
                int i17 = size.height;
                int i18 = size.width;
                Log.i(TAG, "changeGlSurfaceSize: " + this.mCameraSize.width + "/" + this.mCameraSize.height);
                Log.i(TAG, "changeGlSurfaceSize: " + width + "/" + height);
                int i19 = i18 * width;
                int i26 = i17 * height;
                if (i19 > i26) {
                    int i27 = i19 / i17;
                    i3 = (height - i27) / 2;
                    height = i27;
                } else {
                    int i28 = i26 / i18;
                    i3 = 0;
                    i16 = (width - i28) / 2;
                    width = i28;
                }
            } else {
                i3 = 0;
            }
            Log.i(TAG, "changeGlSurfaceSize: " + width + "/" + height);
            Log.i(TAG, "changeGlSurfaceSize: " + i16 + "/" + i3);
            GLES20.glViewport(i16, i3, width, height);
        }
    }

    private static int createOESTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        return iArr[0];
    }

    private void createPreviewSt() {
        if (this.mPreviewSt != null) {
            return;
        }
        this.mTextureId = createOESTextureObject();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mPreviewSt = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.mFilter = new CameraFilterEngine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setEGLContextClientVersion(2);
        setRenderer(this);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            SurfaceTexture surfaceTexture = this.mPreviewSt;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.mPreviewSt.getTransformMatrix(this.transformMatrix);
            }
        } catch (IllegalStateException e16) {
            QMLog.e(TAG, Log.getStackTraceString(e16));
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mShaderProgram, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mShaderProgram, CameraFilterEngine.TEXTURE_COORD_ATTRIBUTE);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mShaderProgram, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mShaderProgram, CameraFilterEngine.TEXTURE_SAMPLER_UNIFORM);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTextureId);
        GLES20.glUniform1i(glGetUniformLocation2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, this.transformMatrix, 0);
        FloatBuffer floatBuffer = this.mDataBuffer;
        if (floatBuffer != null) {
            floatBuffer.position(0);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 16, (Buffer) this.mDataBuffer);
            this.mDataBuffer.position(2);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 16, (Buffer) this.mDataBuffer);
        }
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glBindFramebuffer(36160, 0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        Log.i(TAG, "onSurfaceChanged: ");
        changeGlSurfaceSize();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i(TAG, "onSurfaceCreated: ");
        createPreviewSt();
        this.mDataBuffer = this.mFilter.getBuffer();
        this.mShaderProgram = this.mFilter.getShaderProgram();
        GLES20.glGenFramebuffers(1, this.mFBOIds, 0);
        GLES20.glBindFramebuffer(36160, this.mFBOIds[0]);
        this.isSurfaceCreate = true;
        onCameraSurfaceCreate(this.mPreviewSt);
    }

    public void setCameraSize(Camera.Size size) {
        if (size.equals(this.mCameraSize)) {
            return;
        }
        this.mCameraSize = size;
        if (this.isSurfaceCreate) {
            changeGlSurfaceSize();
        }
    }

    public GlCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFBOIds = new int[1];
        this.transformMatrix = new float[16];
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCameraSurfaceCreate(SurfaceTexture surfaceTexture) {
    }
}
