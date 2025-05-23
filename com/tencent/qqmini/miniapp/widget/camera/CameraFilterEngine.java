package com.tencent.qqmini.miniapp.widget.camera;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CameraFilterEngine {
    public static final String POSITION_ATTRIBUTE = "aPosition";
    public static final String TEXTURE_COORD_ATTRIBUTE = "aTextureCoordinate";
    public static final String TEXTURE_MATRIX_UNIFORM = "uTextureMatrix";
    public static final String TEXTURE_SAMPLER_UNIFORM = "uTextureSampler";
    private static final float[] vertexData = {1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f};
    private final FloatBuffer mBuffer = createBuffer();
    private final int mShaderProgram = linkProgram(loadShader(35633, "attribute vec4 aPosition;\nuniform mat4 uTextureMatrix;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vTextureCoord = (uTextureMatrix * aTextureCoordinate).xy;\n  gl_Position = aPosition;\n}"), loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES uTextureSampler;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n}"));

    private FloatBuffer createBuffer() {
        float[] fArr = vertexData;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    private int linkProgram(int i3, int i16) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i3);
            GLES20.glAttachShader(glCreateProgram, i16);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glUseProgram(glCreateProgram);
            return glCreateProgram;
        }
        throw new RuntimeException("Create Program Failed!" + GLES20.glGetError());
    }

    private int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }
        throw new RuntimeException("Create Shader Failed!" + GLES20.glGetError());
    }

    public FloatBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getShaderProgram() {
        return this.mShaderProgram;
    }
}
