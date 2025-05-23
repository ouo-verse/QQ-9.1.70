package com.tencent.tav.quick.export;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class OESTextureConverter {
    private static final String TAG = "OESTextureConverter";
    static float[] squareCoords = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    static float[] textureVertices = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private int mFrameBuffer;
    private int mPositionHandle;
    private int mProgram;
    private int mTextureCoordHandle;
    private int mTextureLocation;
    private FloatBuffer mTextureVerticesBuffer;
    private FloatBuffer mVertexBuffer;
    private int muSTMatrixHandle;
    private final String mVertexShaderCode = "precision mediump float;\nattribute vec4 vPosition;uniform mat4 uSTMatrix;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = uSTMatrix * inputTextureCoordinate;}";
    private final String mFragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, vec2(textureCoordinate.x,textureCoordinate.y));\n}";
    private float[] mSTMatrix = new float[16];
    private boolean mForHardwareBuffer = false;

    public OESTextureConverter() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(squareCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mVertexBuffer = asFloatBuffer;
        asFloatBuffer.put(squareCoords);
        this.mVertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(textureVertices.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.mTextureVerticesBuffer = asFloatBuffer2;
        asFloatBuffer2.put(textureVertices);
        this.mTextureVerticesBuffer.position(0);
        int loadShader = loadShader(35633, "precision mediump float;\nattribute vec4 vPosition;uniform mat4 uSTMatrix;\nattribute vec4 inputTextureCoordinate;varying vec4 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = uSTMatrix * inputTextureCoordinate;}");
        int loadShader2 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec4 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, vec2(textureCoordinate.x,textureCoordinate.y));\n}");
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(this.mProgram, loadShader2);
        GLES20.glLinkProgram(this.mProgram);
        GLES20.glDeleteShader(loadShader);
        GLES20.glDeleteShader(loadShader2);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mFrameBuffer = iArr[0];
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public void draw(int i3, int i16, int i17, int i18) {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i16);
        if (!this.mForHardwareBuffer) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i17, i18, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i16, 0);
        GLES20.glViewport(0, 0, i17, i18);
        this.mTextureLocation = GLES20.glGetUniformLocation(this.mProgram, "s_texture");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glUniform1i(this.mTextureLocation, 0);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        this.mPositionHandle = glGetAttribLocation;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
        this.mTextureCoordHandle = glGetAttribLocation2;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(this.mTextureCoordHandle, 2, 5126, false, 0, (Buffer) this.mTextureVerticesBuffer);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        this.muSTMatrixHandle = glGetUniformLocation;
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 6);
        GLES20.glBindTexture(36197, 0);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordHandle);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
    }

    public void release() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBuffer}, 0);
        GLES20.glDeleteProgram(this.mProgram);
    }

    public void setForHardwareBuffer(boolean z16) {
        this.mForHardwareBuffer = z16;
    }

    public void setSTMatrix(float[] fArr) {
        this.mSTMatrix = fArr;
    }
}
