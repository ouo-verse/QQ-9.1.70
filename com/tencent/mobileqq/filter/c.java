package com.tencent.mobileqq.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: s, reason: collision with root package name */
    private static String f209728s;

    /* renamed from: h, reason: collision with root package name */
    private int f209729h;

    /* renamed from: i, reason: collision with root package name */
    private int f209730i;

    /* renamed from: j, reason: collision with root package name */
    private int f209731j;

    /* renamed from: k, reason: collision with root package name */
    private float f209732k;

    /* renamed from: l, reason: collision with root package name */
    private float f209733l;

    /* renamed from: m, reason: collision with root package name */
    private float f209734m;

    /* renamed from: n, reason: collision with root package name */
    private int f209735n;

    /* renamed from: o, reason: collision with root package name */
    private int f209736o;

    /* renamed from: p, reason: collision with root package name */
    private Bitmap f209737p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f209738q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f209739r;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42516);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f209728s = GlUtil.readTextFromRawResource(BaseApplication.getContext(), R.raw.a_);
        }
    }

    public c() {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", f209728s);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209735n = -1;
        this.f209737p = null;
        this.f209738q = false;
        this.f209739r = false;
        this.f209732k = 30.0f;
        this.mTextureType = GLSLRender.GL_TEXTURE_2D;
        this.mFilterType = 106;
    }

    public void c(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap);
        } else {
            this.f209738q = true;
            this.f209737p = bitmap;
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        this.f209738q = true;
        this.f209739r = true;
        try {
            this.f209737p = com.tencent.biz.qqstory.utils.b.t(str, null);
        } catch (IOException e16) {
            hd0.c.h("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", e16);
        }
    }

    public void e(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f209732k = f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDestroy() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f209739r && (bitmap = this.f209737p) != null && !bitmap.isRecycled()) {
            this.f209737p.recycle();
            this.f209737p = null;
            hd0.c.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
        }
        int i3 = this.f209735n;
        if (i3 != -1) {
            GlUtil.deleteTexture(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filter.b, com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDrawTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDrawTexture();
        GLES20.glUniform1f(this.f209729h, this.f209733l);
        GLES20.glUniform1f(this.f209730i, this.f209734m);
        GLES20.glUniform1f(this.f209731j, this.f209732k);
        if (this.f209737p == null) {
            hd0.c.g("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
            return;
        }
        GLES20.glActiveTexture(33985);
        if (this.f209735n == -1 || this.f209738q) {
            if (this.f209737p.isRecycled()) {
                hd0.c.g("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
                return;
            }
            int i3 = this.f209735n;
            if (i3 != -1) {
                GlUtil.deleteTexture(i3);
            }
            this.f209735n = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, this.f209737p);
            this.f209738q = false;
            if (this.f209739r) {
                this.f209737p.recycle();
            }
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f209735n);
        GLES20.glUniform1i(this.f209736o, 1);
    }

    @Override // com.tencent.mobileqq.filter.b, com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onInitialized();
        int glGetUniformLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
        this.f209729h = glGetUniformLocation;
        GPUBaseFilter.checkLocation(glGetUniformLocation, "imageWidthFactor");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
        this.f209730i = glGetUniformLocation2;
        GPUBaseFilter.checkLocation(glGetUniformLocation2, "imageHeightFactor");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(getProgram(), "pixel");
        this.f209731j = glGetUniformLocation3;
        GPUBaseFilter.checkLocation(glGetUniformLocation3, "mPixelLocation");
        this.f209736o = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
        e(this.f209732k);
        this.f209738q = true;
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onOutputSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onOutputSizeChanged(i3, i16);
        hd0.c.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(i3), Integer.valueOf(i16));
        this.f209733l = 9.259259E-4f;
        this.f209734m = 5.2083336E-4f;
    }
}
