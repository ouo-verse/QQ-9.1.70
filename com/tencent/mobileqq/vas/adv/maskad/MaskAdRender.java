package com.tencent.mobileqq.vas.adv.maskad;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.ShaderHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MaskAdRender extends BaseRender {
    private static final String TAG = "VideoPlayer|AlphaHalfBlendRender";
    private int mOffsetParamHandleOES;
    private float mOffsetX;
    private int mPositionHandleOES;
    private int mShaderProgramOES;
    private int mTextureCoordinateHandleOES;
    private int mTextureParamHandleOES;
    private int mTextureTransformHandleOES;
    private int[] mTexturesOES;
    private Surface mVideoSurface;
    private SurfaceTexture mVideoTexture;
    private int mWidthParamHandleOES;
    private double mXFactor;
    private int mXFactorHandleOES;

    public MaskAdRender() {
        super(1);
        this.mTexturesOES = new int[1];
    }

    private void releaseSurface() {
        Surface surface = this.mVideoSurface;
        if (surface != null) {
            surface.release();
            this.mVideoSurface = null;
            Logger.v(TAG, " release  surface");
        }
    }

    private void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mVideoTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mVideoTexture = null;
            Logger.v(TAG, " release  surface texture");
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void draw(byte[] bArr, int i3, int i16) {
        try {
            GLES20.glUseProgram(this.mShaderProgramOES);
            GLES20.glClear(16384);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBindTexture(36197, this.mTexturesOES[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
            GLES20.glUniform1f(this.mXFactorHandleOES, (float) this.mXFactor);
            GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
            GLES20.glUniform1f(this.mWidthParamHandleOES, i3);
            SurfaceTexture surfaceTexture = this.mVideoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.mVideoTexture.getTransformMatrix(this.mTextureTransform);
                GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
                GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
                GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, (Buffer) this.mTextureCoordsBuffer);
                GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.mTextureTransform, 0);
                GLES20.glDrawElements(5, this.mDrawOrder.length, 5123, this.mDrawListBuffer);
                GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
                GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glDisable(3042);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                return;
            }
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
        } catch (Exception e16) {
            Logger.v(TAG, " Exception in draw oes");
            e16.printStackTrace();
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public Surface getSurface() {
        return this.mVideoSurface;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public SurfaceTexture getVideoTexture() {
        return this.mVideoTexture;
    }

    public void realDestory() {
        GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
        GLES20.glDeleteProgram(this.mShaderProgramOES);
        releaseSurface();
        releaseSurfaceTexture();
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setup() {
        Logger.v(TAG, "setup OES");
        checkGlError(" setup OES ");
        setupVertexBuffer();
        setupTextureCoordsBuffer();
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nuniform float x_factor;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexCoordinate1 = (textureTransform * vec4(x_factor + vTexCoordinate.x, vTexCoordinate.y, 0.0, 1.0)).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nuniform float x_factor;\nuniform float width;\nuniform float offset;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n     vec4 color = texture2D(texture, v_TexCoordinate);\n     vec4 color1 = texture2D(texture, v_TexCoordinate1);   \n     if (v_TexCoordinate.x < 0.003) {  \n        color1.a = 0.0;\n     } else if (v_TexCoordinate.x > 0.997 ) { \n       color1.a = 0.0;\n     } else {\n       color1.a = color.r;\n     }\n     gl_FragColor = color1;\n}\n"), new String[]{"texture", "width", "vPosition", "vTexCoordinate", "textureTransform", "x_factor", "offset"});
        this.mShaderProgramOES = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
        this.mWidthParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "width");
        this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
        this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
        this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
        this.mXFactorHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "x_factor");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mShaderProgramOES, "offset");
        this.mOffsetParamHandleOES = glGetUniformLocation;
        GLES20.glUniform1f(glGetUniformLocation, this.mOffsetX);
        GLES20.glUseProgram(0);
        checkGlError("Texture generate OES>>");
        GLES20.glGenTextures(1, this.mTexturesOES, 0);
        GLES20.glBindTexture(36197, this.mTexturesOES[0]);
        checkGlError("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.mVideoTexture = new SurfaceTexture(this.mTexturesOES[0]);
        this.mVideoSurface = new Surface(this.mVideoTexture);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setupTextureCoordsBuffer() {
        Logger.v(TAG, "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mTextureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 0.0f, 1.0f});
        this.mTextureCoordsBuffer.position(0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void updateSize(int i3, int i16, int i17, int i18) {
        this.mXFactor = 0.5d;
        this.mOffsetX = 1.0f / i17;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void destroy() {
    }
}
