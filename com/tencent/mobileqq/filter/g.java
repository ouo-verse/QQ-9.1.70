package com.tencent.mobileqq.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    GaussianBlurFilterCompose f209756a;

    /* renamed from: b, reason: collision with root package name */
    GaussianBlurFilter f209757b;

    /* renamed from: c, reason: collision with root package name */
    TextureRender f209758c;

    /* renamed from: d, reason: collision with root package name */
    RenderBuffer f209759d;

    /* renamed from: e, reason: collision with root package name */
    RenderBuffer f209760e;

    /* renamed from: f, reason: collision with root package name */
    float[] f209761f;

    /* renamed from: g, reason: collision with root package name */
    float[] f209762g;

    /* renamed from: h, reason: collision with root package name */
    float[] f209763h;

    /* renamed from: i, reason: collision with root package name */
    int f209764i;

    /* renamed from: j, reason: collision with root package name */
    int f209765j;

    /* renamed from: k, reason: collision with root package name */
    int f209766k;

    /* renamed from: l, reason: collision with root package name */
    int f209767l;

    /* renamed from: m, reason: collision with root package name */
    int f209768m;

    public g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f209766k = i3;
            this.f209761f = a(i3);
        }
    }

    private float[] a(float f16) {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f16, 0.0f, 0.0f, 1.0f);
        return fArr;
    }

    private void b(int i3, int i16, int i17, int i18) {
        this.f209758c = new TextureRender();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = new GaussianBlurFilterCompose();
        this.f209756a = gaussianBlurFilterCompose;
        if (this.f209766k % 180 != 0) {
            gaussianBlurFilterCompose.init(i16, i3);
            this.f209759d = new RenderBuffer(i16, i3, 33984);
            this.f209762g = GPUBaseFilter.caculateCenterCropMvpMatrix(i16, i3, i17, i18);
            this.f209763h = GPUBaseFilter.caculateFitCenterMvpMatrix(i16, i3, i17, i18);
        } else {
            gaussianBlurFilterCompose.init(i3, i16);
            this.f209759d = new RenderBuffer(i3, i16, 33984);
            this.f209762g = GPUBaseFilter.caculateCenterCropMvpMatrix(i3, i16, i17, i18);
            this.f209763h = GPUBaseFilter.caculateFitCenterMvpMatrix(i3, i16, i17, i18);
        }
        this.f209757b = this.f209756a.getFilter();
        this.f209760e = new RenderBuffer(i17, i18, 33984);
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        if (this.f209766k != 0) {
            this.f209759d.bind();
            this.f209758c.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.f209761f);
            this.f209759d.unbind();
            i3 = this.f209759d.getTexId();
        }
        GaussianBlurFilter gaussianBlurFilter = this.f209757b;
        if (gaussianBlurFilter != null && gaussianBlurFilter.isInitSucc()) {
            this.f209756a.drawTexture(i3);
        }
        this.f209760e.bind();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GaussianBlurFilter gaussianBlurFilter2 = this.f209757b;
        if (gaussianBlurFilter2 != null && gaussianBlurFilter2.isInitSucc()) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(32771, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBlendColor(0.0f, 0.0f, 0.0f, 0.75f);
            this.f209758c.drawTexture(GLSLRender.GL_TEXTURE_2D, this.f209756a.getTextureId(), null, this.f209762g);
            GLES20.glDisable(3042);
        } else {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(32771, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBlendColor(0.0f, 0.0f, 0.0f, 0.1f);
            this.f209758c.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.f209762g);
            GLES20.glDisable(3042);
        }
        this.f209758c.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.f209763h);
        this.f209760e.unbind();
        return this.f209760e.getTexId();
    }

    public void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.f209767l != i3 || this.f209768m != i16) {
            this.f209767l = i3;
            this.f209768m = i16;
            b(this.f209764i, this.f209765j, i3, i16);
        }
    }

    public void e(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f209764i = i3;
        this.f209765j = i16;
        this.f209767l = i17;
        this.f209768m = i18;
        b(i3, i16, i17, i18);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        GaussianBlurFilter gaussianBlurFilter = this.f209757b;
        if (gaussianBlurFilter != null) {
            gaussianBlurFilter.destroy();
        }
        GaussianBlurFilterCompose gaussianBlurFilterCompose = this.f209756a;
        if (gaussianBlurFilterCompose != null) {
            gaussianBlurFilterCompose.destroy();
        }
        TextureRender textureRender = this.f209758c;
        if (textureRender != null) {
            textureRender.release();
        }
        RenderBuffer renderBuffer = this.f209759d;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.f209760e;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
    }
}
