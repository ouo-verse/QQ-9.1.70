package com.tencent.qqcamerakit.preview;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static float[] f344942h;

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f344943i;

    /* renamed from: j, reason: collision with root package name */
    private static final FloatBuffer f344944j;

    /* renamed from: a, reason: collision with root package name */
    private final String f344945a;

    /* renamed from: b, reason: collision with root package name */
    private final String f344946b;

    /* renamed from: c, reason: collision with root package name */
    private int f344947c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f344948d;

    /* renamed from: e, reason: collision with root package name */
    public int f344949e;

    /* renamed from: f, reason: collision with root package name */
    protected int f344950f;

    /* renamed from: g, reason: collision with root package name */
    private FloatBuffer f344951g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f344942h = fArr;
        f344943i = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f344944j = e.b(fArr);
    }

    public c() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", GPUBaseFilter.NO_FILTER_FRAGMENT_SHADER);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static float[] a(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18 = i17;
        float f19 = i18;
        float f26 = f18 / f19;
        float f27 = i3 / i16;
        if (f26 < f27) {
            f16 = (f27 * f19) / f18;
            f17 = 1.0f;
        } else if (f26 > f27) {
            f17 = f18 / (f27 * f19);
            f16 = 1.0f;
        } else {
            f16 = 1.0f;
            f17 = 1.0f;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, f16, f17, 1.0f);
        return fArr;
    }

    public static void b(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                com.tencent.qqcamerakit.common.e.c("GPUBaseFilter", 1, new RuntimeException(str + ": glError " + glGetError), new Object[0]);
            } else {
                return;
            }
        }
    }

    public static void c(int i3, String str) {
        if (i3 < 0) {
            com.tencent.qqcamerakit.common.e.c("GPUBaseFilter", 1, new RuntimeException("Unable to locate '" + str + "' in program"), new Object[0]);
        }
    }

    public void d(int i3, float[] fArr, float[] fArr2) {
        float[] fArr3;
        float[] fArr4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), fArr, fArr2);
            return;
        }
        b("onDrawFrame start");
        int e16 = e();
        if (fArr == null) {
            fArr3 = new float[16];
            Matrix.setIdentityM(fArr3, 0);
        } else {
            fArr3 = fArr;
        }
        if (fArr2 == null) {
            fArr4 = new float[16];
            Matrix.setIdentityM(fArr4, 0);
        } else {
            fArr4 = fArr2;
        }
        GLES20.glUseProgram(e16);
        b("glUseProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(e16, "aPosition");
        c(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(e16, "aTextureCoord");
        c(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(e16, "uMVPMatrix");
        c(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(e16, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        c(glGetUniformLocation2, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) f344944j);
        b("glVertexAttribPointer aPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        b("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.f344951g);
        b("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        b("glEnableVertexAttribArray mTextureHandle");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr4, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr3, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f344949e, i3);
        g();
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f344949e, 0);
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f344947c;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f344948d) {
            return;
        }
        int c16 = e.c(this.f344945a, this.f344946b);
        this.f344947c = c16;
        if (c16 == 0) {
            com.tencent.qqcamerakit.common.e.c("GPUBaseFilter", 1, new RuntimeException("failed creating program " + getClass().getSimpleName()), new Object[0]);
        }
        this.f344948d = true;
        h();
    }

    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f344949e = GLSLRender.GL_TEXTURE_2D;
        this.f344950f = 101;
        this.f344951g = e.b(f344943i);
        this.f344945a = str;
        this.f344946b = str2;
        this.f344949e = GLSLRender.GL_TEXTURE_2D;
        this.f344950f = 101;
    }
}
