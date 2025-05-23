package com.tencent.qqcamerakit.preview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f344961a;

    /* renamed from: b, reason: collision with root package name */
    private d f344962b;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f344961a = new c();
        this.f344962b = new d();
        this.f344961a.f();
        this.f344962b.f();
    }

    public void a(int i3, int i16, float[] fArr, float[] fArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2);
        } else if (i3 == 36197) {
            this.f344962b.d(i16, fArr, fArr2);
        } else {
            if (i3 == 3553) {
                this.f344961a.d(i16, fArr, fArr2);
                return;
            }
            throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
        }
    }
}
