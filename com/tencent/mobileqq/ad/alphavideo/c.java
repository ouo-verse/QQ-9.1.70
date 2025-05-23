package com.tencent.mobileqq.ad.alphavideo;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.ShaderHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends BaseRender {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f186691a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f186692b;

    /* renamed from: c, reason: collision with root package name */
    private Surface f186693c;

    /* renamed from: d, reason: collision with root package name */
    private int f186694d;

    /* renamed from: e, reason: collision with root package name */
    private int f186695e;

    /* renamed from: f, reason: collision with root package name */
    private int f186696f;

    /* renamed from: g, reason: collision with root package name */
    private int f186697g;

    /* renamed from: h, reason: collision with root package name */
    private int f186698h;

    /* renamed from: i, reason: collision with root package name */
    private int f186699i;

    /* renamed from: j, reason: collision with root package name */
    private int f186700j;

    /* renamed from: k, reason: collision with root package name */
    private double f186701k;

    /* renamed from: l, reason: collision with root package name */
    private float f186702l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f186703m;

    public c() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f186703m = new int[1];
        }
    }

    private void releaseSurface() {
        Surface surface = this.f186693c;
        if (surface != null) {
            surface.release();
            this.f186693c = null;
            QLog.d("MaskAdAlphaVideoRender", 1, " release  surface");
        }
    }

    private void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.f186692b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f186692b = null;
            QLog.d("MaskAdAlphaVideoRender", 1, " release  surface texture");
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        GLES20.glDeleteTextures(1, this.f186703m, 0);
        GLES20.glDeleteProgram(this.f186691a);
        releaseSurface();
        releaseSurfaceTexture();
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void draw(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            GLES20.glUseProgram(this.f186691a);
            GLES20.glClear(16384);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBindTexture(36197, this.f186703m[0]);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.f186694d, 0);
            GLES20.glUniform1f(this.f186698h, (float) this.f186701k);
            GLES20.glUniform1f(this.f186699i, this.f186702l);
            GLES20.glUniform1f(this.f186700j, i3);
            SurfaceTexture surfaceTexture = this.f186692b;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.f186692b.getTransformMatrix(this.mTextureTransform);
                GLES20.glEnableVertexAttribArray(this.f186696f);
                GLES20.glVertexAttribPointer(this.f186696f, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
                GLES20.glEnableVertexAttribArray(this.f186695e);
                GLES20.glVertexAttribPointer(this.f186695e, 4, 5126, false, 0, (Buffer) this.mTextureCoordsBuffer);
                GLES20.glUniformMatrix4fv(this.f186697g, 1, false, this.mTextureTransform, 0);
                GLES20.glDrawElements(5, this.mDrawOrder.length, 5123, this.mDrawListBuffer);
                GLES20.glDisableVertexAttribArray(this.f186696f);
                GLES20.glDisableVertexAttribArray(this.f186695e);
                GLES20.glDisable(3042);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                return;
            }
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
        } catch (Exception e16) {
            QLog.d("MaskAdAlphaVideoRender", 1, " Exception in draw oes");
            e16.printStackTrace();
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public Surface getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Surface) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f186693c;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public SurfaceTexture getVideoTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f186692b;
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void setup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("MaskAdAlphaVideoRender", 1, "setup OES");
        checkGlError(" setup OES ");
        setupVertexBuffer();
        setupTextureCoordsBuffer();
        int createAndLinkProgram = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nuniform float x_factor;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexCoordinate1 = (textureTransform * vec4(x_factor + vTexCoordinate.x, vTexCoordinate.y, 0.0, 1.0)).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nuniform float x_factor;\nuniform float width;\nuniform float offset;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexCoordinate1;\nvoid main () {\n     vec4 color = texture2D(texture, v_TexCoordinate);\n     vec4 color1 = texture2D(texture, v_TexCoordinate1);   \n     if (v_TexCoordinate.x < 0.003) {  \n        color1.a = 0.0;\n     } else if (v_TexCoordinate.x > 0.997 ) { \n       color1.a = 0.0;\n     } else {\n       color1.a = color.r;\n     }\n     gl_FragColor = color1;\n}\n"), new String[]{"texture", "width", "vPosition", "vTexCoordinate", "textureTransform", "x_factor", "offset"});
        this.f186691a = createAndLinkProgram;
        GLES20.glUseProgram(createAndLinkProgram);
        this.f186694d = GLES20.glGetUniformLocation(this.f186691a, "texture");
        this.f186700j = GLES20.glGetUniformLocation(this.f186691a, "width");
        this.f186695e = GLES20.glGetAttribLocation(this.f186691a, "vTexCoordinate");
        this.f186696f = GLES20.glGetAttribLocation(this.f186691a, "vPosition");
        this.f186697g = GLES20.glGetUniformLocation(this.f186691a, "textureTransform");
        this.f186698h = GLES20.glGetUniformLocation(this.f186691a, "x_factor");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f186691a, "offset");
        this.f186699i = glGetUniformLocation;
        GLES20.glUniform1f(glGetUniformLocation, this.f186702l);
        GLES20.glUseProgram(0);
        checkGlError("Texture generate OES>>");
        GLES20.glGenTextures(1, this.f186703m, 0);
        GLES20.glBindTexture(36197, this.f186703m[0]);
        checkGlError("Texture bind");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.f186692b = new SurfaceTexture(this.f186703m[0]);
        this.f186693c = new Surface(this.f186692b);
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
        QLog.d("MaskAdAlphaVideoRender", 1, "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mTextureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 0.0f, 1.0f});
        this.mTextureCoordsBuffer.position(0);
    }

    @Override // com.tencent.jalpha.videoplayer.render.BaseRender
    public void updateSize(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f186701k = 0.5d;
            this.f186702l = 1.0f / i17;
        }
    }
}
