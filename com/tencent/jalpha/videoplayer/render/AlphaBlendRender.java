package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.jalpha.common.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AlphaBlendRender extends BaseRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|SurfaceTextureBlendRender";
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
    private SurfaceTexture videoTexture;

    public AlphaBlendRender() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            GLES20.glUseProgram(this.mShaderProgramOES);
            GLES20.glClear(16384);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBindTexture(36197, this.mTexturesOES[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
            GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
            GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Surface) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mVideoSurface;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public SurfaceTexture getVideoTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 7, (Object) this);
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
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nuniform highp float width;\nuniform highp float offset;\nuniform samplerExternalOES texture;\nvarying highp vec2 v_TexCoordinate;\nint iter_mod(int x, int y) {\n    for(int i=0; i>-1; i++) {\n        if(x < y) break;\n        x = x - y;\n    }\n    return x;\n}\nbool equals(float x, float y) {\n    if(x -y < 0.015 && x-y > -0.015 ) {\n       return true;\n    }\n    return false;\n}\nvoid main () {\n     vec4 color = texture2D(texture, v_TexCoordinate);\n     highp int posx =int(v_TexCoordinate.x * width);\n     vec4 color1;\n     if ( iter_mod(posx, 2) ==0 ) {  \n         color1 = texture2D(texture, v_TexCoordinate + vec2( offset, 0.0));   \n        if ( equals(color.r, color1.r) && equals(color.g, color1.g) && equals(color.b,color1.b)) {\n           color1 = texture2D(texture, v_TexCoordinate + vec2( offset * 0.99, 0.0));   \n       \n}     } else {\n        color1 = texture2D(texture, v_TexCoordinate - vec2( offset, 0.0));   \n        if ( equals(color.r, color1.r) && equals(color.g, color1.g) && equals(color.b,color1.b) ) {\n           color1 = texture2D(texture, v_TexCoordinate - vec2( offset * 0.99, 0.0) );   \n       \n}     }\n     float y1 = (0.299 * color.r + 0.587 * color.g + 0.114 * color.b) * 255.0; \n     float u1 = (-0.169 * color.r -0.331 * color.g + 0.500 * color.b) * 255.0; \n     float v1 = (0.500 * color.r - 0.419 * color.g - 0.081 * color.b) * 255.0; \n     float y2 = (0.299 * color1.r + 0.587 * color1.g + 0.114 * color1.b) * 255.0;\n     float ry;\n     float ay;\n     if ( iter_mod(posx, 2) ==0 ) {\n        ay = y1;\n        ry = y2;\n     } else {\n        ay = y2;\n        ry = y1;\n     }\n     if ( ay <= ry ) {\n        float temp = ay;\n        ay = ry;\n        ry = temp;\n     } \n     float r = (ry +  1.403 * v1)* 3.0 ;\n     float g = (ry  -0.344 * u1  -0.714 * v1 ) * 3.0; \n     float b = (ry + 1.770 * u1 )* 3.0; \n      float a = (ay - 86.0) * 3.0;\n     color.a = a/ 255.0;\n     color.r = r / 255.0; \n     color.g = g / 255.0; \n     color.b = b / 255.0; \n     gl_FragColor = color;\n}\n"), new String[]{"texture", "offset", "width", "vPosition", "vTexCoordinate", "textureTransform"});
        this.mShaderProgramOES = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
        this.mWidthParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "width");
        this.mOffsetParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "offset");
        this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
        this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
        this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
        GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
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
    public void updateSize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.v(TAG, "updateSize: viewWidth " + i3 + " viewHeight " + i16 + " textureWidth " + i17 + "," + i18);
        float f16 = (float) i17;
        this.mTextureWidth = f16;
        this.mOffsetX = (float) (1.0d / ((double) f16));
    }
}
