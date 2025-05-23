package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected int f194424a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f194425b;

    public a(int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) iArr);
        } else {
            this.f194425b = b(iArr);
            this.f194424a = i3;
        }
    }

    private int[] b(int[] iArr) {
        int i3 = this.f194424a;
        if (i3 != 2 && i3 != 3) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + 2];
        int i16 = length - 1;
        System.arraycopy(iArr, 0, iArr2, 0, i16);
        iArr2[i16] = 12352;
        if (this.f194424a == 2) {
            iArr2[length] = 4;
        } else {
            iArr2[length] = 64;
        }
        iArr2[length + 1] = 12344;
        return iArr2;
    }

    abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    @Override // com.tencent.mobileqq.apollo.view.opengl.e
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EGLConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) egl10, (Object) eGLDisplay);
        }
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.f194425b, null, 0, iArr)) {
            int i3 = iArr[0];
            if (i3 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                if (egl10.eglChooseConfig(eGLDisplay, this.f194425b, eGLConfigArr, i3, iArr)) {
                    EGLConfig a16 = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a16 != null) {
                        return a16;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }
}
