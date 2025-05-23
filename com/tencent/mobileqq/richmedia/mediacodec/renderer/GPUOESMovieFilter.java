package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: classes18.dex */
public class GPUOESMovieFilter extends GPUBaseFilter {
    private static final String MOVIE_FRAG_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nuniform int v_isAlpha;\nuniform float real_half;\nuniform float x_add_margin;\n\nvoid main () {\n    if(v_TexCoordinate.x  > x_add_margin && v_TexCoordinate.x  < real_half - x_add_margin\n    && v_TexCoordinate.y  > 0.0 && v_TexCoordinate.y  < 1.0) {\n        vec4 color;\n        color = texture2D(texture, v_TexCoordinate);\n        float alpha = 1.0;\n        if (v_isAlpha == 1) {\n            alpha = texture2D(texture, v_TexAlphaCoordinate).g;\n        }\n        gl_FragColor = color;\n        gl_FragColor.a = gl_FragColor.a * alpha;\n        gl_FragColor.r = gl_FragColor.r * alpha;\n        gl_FragColor.g = gl_FragColor.g * alpha;\n        gl_FragColor.b = gl_FragColor.b * alpha;\n    } else {\n        gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n    } \n}";
    private static final String MOVIE_VERTEX_SHADER = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}\n";
    public static final String TAG = "GPUOESMovieFilter";
    public float height;
    private ShortBuffer mDrawListBuffer;
    private boolean mIsSupportAlpha;
    private int mPositionHandle;
    private int mRealHalfHandle;
    private float[] mSquareCoords;
    private int mSupportAlphaHandle;
    private int mTextureAlphaCoordinateHandle;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mTextureBuffer2;
    private int mTextureCoordinateHandle;
    private float[] mTextureCoords;
    private float[] mTextureCoords2;
    private int mTextureParamHandle;
    private int mTextureTranformHandle;
    private FloatBuffer mVertexBuffer;
    private int mXAddMarginHandle;
    public int opacity;
    public float rotate;
    public float scale;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f281591x;

    /* renamed from: y, reason: collision with root package name */
    public float f281592y;
    private static final short[] sDrawOrder = {0, 1, 2, 0, 2, 3};
    private static float HALF = 0.5f;

    public GPUOESMovieFilter() {
        super(MOVIE_VERTEX_SHADER, MOVIE_FRAG_SHADER);
        this.scale = 1.0f;
        this.rotate = 0.0f;
        this.opacity = 255;
        this.mSquareCoords = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.mTextureType = 36197;
        this.mFilterType = 102;
        this.mIsSupportAlpha = true;
        float f16 = HALF;
        this.mTextureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, f16, 0.0f, 0.0f, 1.0f, f16, 1.0f, 0.0f, 1.0f};
        this.mTextureCoords2 = new float[]{f16, 1.0f, 0.0f, 1.0f, f16, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    private void setupGraphics() {
        int program = getProgram();
        GLES20.glUseProgram(program);
        this.mTextureParamHandle = GLES20.glGetUniformLocation(program, "texture");
        this.mTextureCoordinateHandle = GLES20.glGetAttribLocation(program, "vTexCoordinate");
        this.mTextureAlphaCoordinateHandle = GLES20.glGetAttribLocation(program, "vTexAlphaCoordinate");
        this.mPositionHandle = GLES20.glGetAttribLocation(program, "vPosition");
        this.mTextureTranformHandle = GLES20.glGetUniformLocation(program, "textureTransform");
        this.mSupportAlphaHandle = GLES20.glGetUniformLocation(program, "v_isAlpha");
        this.mRealHalfHandle = GLES20.glGetUniformLocation(program, "real_half");
        this.mXAddMarginHandle = GLES20.glGetUniformLocation(program, "x_add_margin");
    }

    private void setupTexture() {
        FloatBuffer floatBuffer = this.mTextureBuffer;
        if (floatBuffer != null && this.mTextureBuffer2 != null) {
            floatBuffer.clear();
            this.mTextureBuffer.put(this.mTextureCoords);
            this.mTextureBuffer.position(0);
            this.mTextureBuffer2.clear();
            this.mTextureBuffer2.put(this.mTextureCoords2);
            this.mTextureBuffer2.position(0);
            return;
        }
        this.mTextureBuffer = GlUtil.createFloatBuffer(this.mTextureCoords);
        this.mTextureBuffer2 = GlUtil.createFloatBuffer(this.mTextureCoords2);
    }

    private void setupVertexBuffer() {
        short[] sArr = sDrawOrder;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.mDrawListBuffer = asShortBuffer;
        asShortBuffer.put(sArr);
        this.mDrawListBuffer.position(0);
        this.mVertexBuffer = GlUtil.createFloatBuffer(this.mSquareCoords);
    }

    public void adjustVideo(float f16, float f17, float f18) {
        float f19;
        float f26;
        int i3;
        int i16 = this.mOutputHeight;
        if (i16 != 0 && (i3 = this.mOutputWidth) != 0) {
            float f27 = (f16 / HALF) / ((i16 * 1.0f) / i3);
            if (f27 > 1.0f) {
                f26 = 1.0f;
            } else {
                f26 = f27;
            }
            if (f27 > 1.0f) {
                f19 = 1.0f / f27;
            } else {
                f19 = 1.0f;
            }
        } else {
            f19 = 1.0f;
            f26 = 1.0f;
        }
        float f28 = HALF;
        float f29 = f28 * 0.5f * (1.0f - f26);
        float f36 = (1.0f - f19) * 0.5f;
        float f37 = f28 * f17 * f26;
        float f38 = f19 * f18;
        float[] fArr = this.mTextureCoords;
        float f39 = f29 + f37;
        fArr[0] = f39;
        float f46 = (1.0f - f36) + f38;
        fArr[1] = f46;
        fArr[4] = f39;
        float f47 = f36 + f38;
        fArr[5] = f47;
        fArr[8] = (f28 - f29) + f37;
        fArr[9] = f47;
        fArr[12] = (f28 - f29) + f37;
        fArr[13] = f46;
        float[] fArr2 = this.mTextureCoords2;
        fArr2[0] = f28 + f29 + f37;
        fArr2[1] = f46;
        fArr2[4] = f28 + f29 + f37;
        fArr2[5] = f47;
        float f48 = (1.0f - f29) + f37;
        fArr2[8] = f48;
        fArr2[9] = f47;
        fArr2[12] = f48;
        fArr2[13] = f46;
        setupTexture();
    }

    public void drawTexture(int i3, float[] fArr) {
        if (this.mVertexBuffer == null) {
            return;
        }
        if (fArr == null) {
            fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
        }
        GLES20.glUseProgram(getProgram());
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mTextureParamHandle, 0);
        GLES20.glUniform1f(this.mRealHalfHandle, HALF * fArr[0]);
        GLES20.glUniform1f(this.mXAddMarginHandle, (fArr[0] / this.mOutputWidth) * 2.0f);
        GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandle);
        GLES20.glVertexAttribPointer(this.mTextureCoordinateHandle, 4, 5126, false, 0, (Buffer) this.mTextureBuffer);
        if (this.mIsSupportAlpha) {
            GLES20.glUniform1i(this.mSupportAlphaHandle, 1);
            GLES20.glEnableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
            GLES20.glVertexAttribPointer(this.mTextureAlphaCoordinateHandle, 4, 5126, false, 0, (Buffer) this.mTextureBuffer2);
        } else {
            GLES20.glUniform1i(this.mSupportAlphaHandle, 0);
        }
        GLES20.glUniformMatrix4fv(this.mTextureTranformHandle, 1, false, fArr, 0);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        GLES20.glDrawElements(4, sDrawOrder.length, 5123, this.mDrawListBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        setupGraphics();
        setupVertexBuffer();
        setupTexture();
    }
}
