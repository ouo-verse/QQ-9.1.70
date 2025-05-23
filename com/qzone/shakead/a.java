package com.qzone.shakead;

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
/* loaded from: classes37.dex */
public class a extends BaseRender {

    /* renamed from: a, reason: collision with root package name */
    private int f59715a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f59716b;

    /* renamed from: c, reason: collision with root package name */
    private Surface f59717c;

    /* renamed from: d, reason: collision with root package name */
    private int f59718d;

    /* renamed from: e, reason: collision with root package name */
    private int f59719e;

    /* renamed from: f, reason: collision with root package name */
    private int f59720f;

    /* renamed from: g, reason: collision with root package name */
    private int f59721g;

    /* renamed from: h, reason: collision with root package name */
    private int f59722h;

    /* renamed from: i, reason: collision with root package name */
    private int f59723i;

    /* renamed from: j, reason: collision with root package name */
    private int f59724j;

    /* renamed from: k, reason: collision with root package name */
    private double f59725k;

    /* renamed from: l, reason: collision with root package name */
    private float f59726l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f59727m;

    private void releaseSurface() {
        Surface surface = this.f59717c;
        if (surface != null) {
            surface.release();
            this.f59717c = null;
            Logger.v("VideoPlayer|AlphaHalfBlendRender", " release  surface");
        }
    }

    private void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.f59716b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f59716b = null;
            Logger.v("VideoPlayer|AlphaHalfBlendRender", " release  surface texture");
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void destroy() {
        GLES20.glDeleteTextures(1, this.f59727m, 0);
        GLES20.glDeleteProgram(this.f59715a);
        releaseSurface();
        releaseSurfaceTexture();
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public Surface getSurface() {
        return this.f59717c;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public SurfaceTexture getVideoTexture() {
        return this.f59716b;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setup() {
        Logger.v("VideoPlayer|AlphaHalfBlendRender", "setup OES");
        checkGlError(" setup OES ");
        setupVertexBuffer();
        setupTextureCoordsBuffer();
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nuniform float x_factor;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexCoordinate1 = (textureTransform * vec4(x_factor + vTexCoordinate.x * 0.5, vTexCoordinate.y, 0.0, 1.0)).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nuniform float x_factor;\nuniform float width;\nuniform float offset;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n     vec4 color = texture2D(texture, v_TexCoordinate);\n     vec4 color1 = texture2D(texture, v_TexCoordinate1);   \n     if (v_TexCoordinate.x < 0.003) {  \n        color.a = 0.0;\n     } else if (v_TexCoordinate.x > 0.997 ) { \n       color.a = 0.0;\n     } else {\n       color.a = color1.r;\n     }\n     gl_FragColor = color;\n}\n"), new String[]{"texture", "width", "vPosition", "vTexCoordinate", "textureTransform", "x_factor", "offset"});
        this.f59715a = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.f59718d = GLES20.glGetUniformLocation(this.f59715a, "texture");
        this.f59724j = GLES20.glGetUniformLocation(this.f59715a, "width");
        this.f59719e = GLES20.glGetAttribLocation(this.f59715a, "vTexCoordinate");
        this.f59720f = GLES20.glGetAttribLocation(this.f59715a, "vPosition");
        this.f59721g = GLES20.glGetUniformLocation(this.f59715a, "textureTransform");
        this.f59722h = GLES20.glGetUniformLocation(this.f59715a, "x_factor");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f59715a, "offset");
        this.f59723i = glGetUniformLocation;
        GLES20.glUniform1f(glGetUniformLocation, this.f59726l);
        GLES20.glUseProgram(0);
        checkGlError("Texture generate OES>>");
        GLES20.glGenTextures(1, this.f59727m, 0);
        GLES20.glBindTexture(36197, this.f59727m[0]);
        checkGlError("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.f59716b = new SurfaceTexture(this.f59727m[0]);
        this.f59717c = new Surface(this.f59716b);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setupTextureCoordsBuffer() {
        Logger.v("VideoPlayer|AlphaHalfBlendRender", "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mTextureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.6666667f, 0.0f, 0.0f, 1.0f, 0.6666667f, 1.0f, 0.0f, 1.0f});
        this.mTextureCoordsBuffer.position(0);
    }

    public a() {
        super(1);
        this.f59727m = new int[1];
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void draw(byte[] bArr, int i3, int i16) {
        try {
            GLES20.glUseProgram(this.f59715a);
            GLES20.glClear(16384);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBindTexture(36197, this.f59727m[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.f59718d, 0);
            GLES20.glUniform1f(this.f59722h, (float) this.f59725k);
            GLES20.glUniform1f(this.f59723i, this.f59726l);
            GLES20.glUniform1f(this.f59724j, i3);
            SurfaceTexture surfaceTexture = this.f59716b;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.f59716b.getTransformMatrix(this.mTextureTransform);
                GLES20.glEnableVertexAttribArray(this.f59720f);
                GLES20.glVertexAttribPointer(this.f59720f, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
                GLES20.glEnableVertexAttribArray(this.f59719e);
                GLES20.glVertexAttribPointer(this.f59719e, 4, 5126, false, 0, (Buffer) this.mTextureCoordsBuffer);
                GLES20.glUniformMatrix4fv(this.f59721g, 1, false, this.mTextureTransform, 0);
                GLES20.glDrawElements(5, this.mDrawOrder.length, 5123, this.mDrawListBuffer);
                GLES20.glDisableVertexAttribArray(this.f59720f);
                GLES20.glDisableVertexAttribArray(this.f59719e);
                GLES20.glDisable(3042);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                return;
            }
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
        } catch (Exception e16) {
            Logger.v("VideoPlayer|AlphaHalfBlendRender", " Exception in draw oes");
            e16.printStackTrace();
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void updateSize(int i3, int i16, int i17, int i18) {
        this.f59725k = 0.6666666666666666d;
        this.f59726l = 1.0f / i17;
    }
}
