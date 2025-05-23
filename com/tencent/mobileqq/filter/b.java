package com.tencent.mobileqq.filter;

import android.opengl.GLES20;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends GPUBaseFilter {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static String f209721g;

    /* renamed from: a, reason: collision with root package name */
    private int f209722a;

    /* renamed from: b, reason: collision with root package name */
    private int f209723b;

    /* renamed from: c, reason: collision with root package name */
    private int f209724c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f209725d;

    /* renamed from: e, reason: collision with root package name */
    private float f209726e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f209727f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f209721g = GlUtil.readTextFromRawResource(BaseApplication.getContext(), R.raw.f169443a9);
        }
    }

    public b() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", f209721g);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f209725d = z16;
        }
    }

    public void b(boolean z16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Float.valueOf(f16));
            return;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        this.f209727f = z16;
        this.f209726e = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDrawTexture() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i3 = this.f209723b;
        float f17 = 1.0f;
        if (this.f209727f) {
            f16 = 1.0f;
        } else {
            f16 = 2.0f;
        }
        GLES20.glUniform1f(i3, f16);
        GLES20.glUniform1f(this.f209722a, this.f209726e);
        int i16 = this.f209724c;
        if (!this.f209725d) {
            f17 = 2.0f;
        }
        GLES20.glUniform1f(i16, f17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f209722a = GLES20.glGetUniformLocation(getProgram(), "percent");
        this.f209723b = GLES20.glGetUniformLocation(getProgram(), "drawPart");
        this.f209724c = GLES20.glGetUniformLocation(getProgram(), "cutX");
    }

    public String toString() {
        double d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.mFilterType);
        double d17 = 1.0d;
        if (this.f209727f) {
            d16 = 1.0d;
        } else {
            d16 = 2.0d;
        }
        objArr[1] = Double.valueOf(d16);
        objArr[2] = Float.valueOf(this.f209726e);
        if (!this.f209725d) {
            d17 = 2.0d;
        }
        objArr[3] = Double.valueOf(d17);
        return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", objArr);
    }

    public b(String str, String str2) {
        super(str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f209726e = 0.0f;
        this.f209727f = false;
        this.f209725d = true;
        this.mFilterType = 0;
    }
}
