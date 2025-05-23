package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.jalpha.common.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Alpha3BlendRender extends BaseRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|Alpha3BlendRender";
    private int mHeightParamHandleOES;
    private int mOffsetParamHandleOES;
    private float mOffsetX;
    private int mPositionHandleOES;
    private int mShaderProgramOES;
    private int mTextureCoordinateHandleOES;
    private int mTextureParamHandleOES;
    private int mTextureTransformHandleOES;
    private float mTextureWidth;
    private int[] mTexturesOES;
    private Surface mVideoSurface;
    private int mWidthParamHandleOES;
    private float mXFactor;
    private int mXFactorHandleOES;
    private SurfaceTexture videoTexture;

    public Alpha3BlendRender() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mOffsetX = 0.0013333333f;
        this.mTextureWidth = 750.0f;
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
        SurfaceTexture surfaceTexture = this.videoTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.videoTexture = null;
            Logger.v(TAG, " release  surface texture");
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
        GLES20.glDeleteProgram(this.mShaderProgramOES);
        releaseSurface();
        releaseSurfaceTexture();
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void draw(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            GLES20.glUseProgram(this.mShaderProgramOES);
            GLES20.glClear(16384);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBindTexture(36197, this.mTexturesOES[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
            GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
            GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
            GLES20.glUniform1f(this.mXFactorHandleOES, this.mXFactor);
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.videoTexture.getTransformMatrix(this.mTextureTransform);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Surface) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mVideoSurface;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public SurfaceTexture getVideoTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.videoTexture;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Logger.v(TAG, "setup OES");
        checkGlError(" setup OES ");
        setupVertexBuffer();
        setupTextureCoordsBuffer();
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision mediump int;\nuniform float offset;\nuniform float width;\nuniform float x_factor;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\n\nconst mat4 alphaMat = mat4(\n   vec4(1.0, 0.0, 0.0, 0.0),\n   vec4(0.0, 1.0, 0.0, 0.0),\n   vec4(0.0, 0.0, 1.0, 0.0),\n   vec4(0.0, 0.0, 0.0, 1.0)\n);\n\nvoid main () {\n     vec2 v_TexCoordinate1 = v_TexCoordinate;\n     v_TexCoordinate1.x = v_TexCoordinate.x * x_factor;\n     vec4 color = texture2D(texture, v_TexCoordinate1);\n     \n     v_TexCoordinate1.x = (1.0 + v_TexCoordinate.x / 3.0) * x_factor;\n     vec4 color1 = texture2D(texture, v_TexCoordinate1);   \n     float posx = v_TexCoordinate.x * width * x_factor;\n     int filter_index = int(mod(posx, 3.0));\n     vec4 filter = alphaMat[filter_index];\n     color.a = dot(color1, filter);\n     gl_FragColor = color;\n}\n"), new String[]{"texture", "offset", "width", "vPosition", "vTexCoordinate", "textureTransform", "x_factor"});
        this.mShaderProgramOES = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
        this.mOffsetParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "offset");
        this.mWidthParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "width");
        this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
        this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
        this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
        this.mXFactorHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "x_factor");
        GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
        GLES20.glUseProgram(0);
        checkGlError("Texture generate OES>>");
        GLES20.glGenTextures(1, this.mTexturesOES, 0);
        GLES20.glBindTexture(36197, this.mTexturesOES[0]);
        checkGlError("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9728.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.videoTexture = new SurfaceTexture(this.mTexturesOES[0]);
        this.mVideoSurface = new Surface(this.videoTexture);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setupTextureCoordsBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Logger.v(TAG, "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mTextureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f});
        this.mTextureCoordsBuffer.position(0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void updateSize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int i19 = ((i17 * 3) + 3) / 4;
        while (((i19 * 4) + 2) / 3 > i17) {
            i19--;
        }
        Logger.e(TAG, "updateSize:" + i17 + ", originWidth:" + i19);
        float f16 = (float) i17;
        this.mXFactor = ((float) i19) / f16;
        this.mTextureWidth = f16;
    }
}
