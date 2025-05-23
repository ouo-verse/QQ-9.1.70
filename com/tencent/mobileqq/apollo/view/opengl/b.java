package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private int[] f194426c;

    /* renamed from: d, reason: collision with root package name */
    protected int f194427d;

    /* renamed from: e, reason: collision with root package name */
    protected int f194428e;

    /* renamed from: f, reason: collision with root package name */
    protected int f194429f;

    /* renamed from: g, reason: collision with root package name */
    protected int f194430g;

    /* renamed from: h, reason: collision with root package name */
    protected int f194431h;

    /* renamed from: i, reason: collision with root package name */
    protected int f194432i;

    public b(int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        super(i3, new int[]{12324, i16, 12323, i17, 12322, i18, 12321, i19, 12325, i26, 12326, i27, 12344});
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27));
            return;
        }
        this.f194426c = new int[1];
        this.f194427d = i16;
        this.f194428e = i17;
        this.f194429f = i18;
        this.f194430g = i19;
        this.f194431h = i26;
        this.f194432i = i27;
    }

    private int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f194426c)) {
            return this.f194426c[0];
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.a
    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EGLConfig) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfigArr);
        }
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int c16 = c(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int c17 = c(egl10, eGLDisplay, eGLConfig, 12326, 0);
            if (c16 >= this.f194431h && c17 >= this.f194432i) {
                int c18 = c(egl10, eGLDisplay, eGLConfig, 12324, 0);
                int c19 = c(egl10, eGLDisplay, eGLConfig, 12323, 0);
                int c26 = c(egl10, eGLDisplay, eGLConfig, 12322, 0);
                int c27 = c(egl10, eGLDisplay, eGLConfig, 12321, 0);
                if (c18 == this.f194427d && c19 == this.f194428e && c26 == this.f194429f && c27 == this.f194430g) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }
}
