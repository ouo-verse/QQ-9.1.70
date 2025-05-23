package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SurfaceTextureBlendRender extends BaseRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|SurfaceTextureBlendRender";
    private int mPositionHandleOES;
    private int mShaderProgramOES;
    private int mTextureCoordinateHandleOES;
    private int mTextureParamHandleOES;
    private int mTextureTransformHandleOES;
    private int[] mTexturesOES;
    private Surface mVideoSurface;
    private SurfaceTexture videoTexture;

    public SurfaceTextureBlendRender() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTexturesOES = new int[1];
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
        GLES20.glDeleteProgram(this.mShaderProgramOES);
        releaseSurface();
        releaseSurfaceTexture();
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender
    public void draw(byte[] bArr, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        try {
            GLES20.glUseProgram(this.mShaderProgramOES);
            GLES20.glClear(16384);
            GLES20.glBindTexture(36197, this.mTexturesOES[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.videoTexture.getTransformMatrix(this.textureTransform);
                GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
                if (!z16) {
                    GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, (Buffer) this.vertexBuffer);
                } else {
                    GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, (Buffer) this.vertexBuffer_horizonal_reverse);
                }
                GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, (Buffer) this.textureCoordsBuffer);
                GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.textureTransform, 0);
                GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
                GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
                GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                return;
            }
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
        } catch (Exception e16) {
            LogUtil.v(TAG, " Exception in draw oes");
            e16.printStackTrace();
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender
    public void drawFBO(byte[] bArr, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        try {
            GLES20.glUseProgram(this.mShaderProgramOES);
            GLES20.glClear(16384);
            GLES20.glBindTexture(36197, this.mTexturesOES[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.videoTexture.getTransformMatrix(this.textureTransform);
                GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
                if (!z16) {
                    GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, (Buffer) this.vertexBuffer_vertical_reverse);
                } else {
                    GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, (Buffer) this.vertexBuffer_horizonal_vertical_reverse);
                }
                GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, (Buffer) this.textureCoordsBuffer);
                GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.textureTransform, 0);
                GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
                GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
                GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                return;
            }
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
        } catch (Exception e16) {
            LogUtil.v(TAG, " Exception in drawFBO oes");
            e16.printStackTrace();
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    public Surface getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Surface) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mVideoSurface;
    }

    public SurfaceTexture getVideoTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.videoTexture;
    }

    public void releaseSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Surface surface = this.mVideoSurface;
        if (surface != null) {
            surface.release();
            this.mVideoSurface = null;
            LogUtil.v(TAG, " release  surface");
        }
    }

    public void releaseSurfaceTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SurfaceTexture surfaceTexture = this.videoTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.videoTexture = null;
            LogUtil.v(TAG, " release  surface texture");
        }
    }

    @Override // com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender
    public void setup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        LogUtil.v(TAG, "setup OES");
        checkGlError(" setup OES ");
        setupVertexBuffer();
        setupTextureCoordsBuffer();
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision mediump float;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n   vec4 color = texture2D(texture, v_TexCoordinate);\n   vec2 v_TexCoordinate1 = v_TexCoordinate;\n   v_TexCoordinate1.x = v_TexCoordinate.x + 0.5;\n    vec4 color1 = texture2D(texture, v_TexCoordinate1);\n   color.a = color1.r;\n    gl_FragColor = color;\n}\n"), new String[]{"texture", "vPosition", "vTexCoordinate", "textureTransform"});
        this.mShaderProgramOES = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
        this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
        this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
        this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
        GLES20.glUseProgram(0);
        checkGlError("Texture generate OES>>");
        GLES20.glGenTextures(1, this.mTexturesOES, 0);
        GLES20.glBindTexture(36197, this.mTexturesOES[0]);
        checkGlError("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.videoTexture = new SurfaceTexture(this.mTexturesOES[0]);
        this.mVideoSurface = new Surface(this.videoTexture);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }
}
