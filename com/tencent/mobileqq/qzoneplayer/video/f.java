package com.tencent.mobileqq.qzoneplayer.video;

import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f implements GLSurfaceView.EGLConfigChooser {

    /* renamed from: a, reason: collision with root package name */
    private int[] f279999a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f280000b;

    private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f279999a) ? this.f279999a[0] : i16;
    }

    public boolean b() {
        return this.f280000b;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        this.f279999a = iArr;
        int[] iArr2 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12338, 1, 12337, 4, 12344};
        int i3 = iArr[0];
        if (i3 <= 0) {
            iArr2 = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12512, 1, 12513, 2, 12344};
            if (i3 <= 0) {
                iArr2 = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12344};
                if (egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr)) {
                    i3 = this.f279999a[0];
                    if (i3 <= 0) {
                        throw new IllegalArgumentException("No configs match configSpec");
                    }
                } else {
                    throw new IllegalArgumentException("3rd eglChooseConfig failed");
                }
            } else {
                this.f280000b = true;
            }
        }
        int i16 = i3;
        EGLConfig[] eGLConfigArr = new EGLConfig[i16];
        if (egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr, i16, this.f279999a)) {
            int i17 = 0;
            while (true) {
                if (i17 >= i16) {
                    i17 = -1;
                    break;
                }
                if (a(egl10, eGLDisplay, eGLConfigArr[i17], 12321, 0) == 8) {
                    break;
                }
                i17++;
            }
            if (i17 == -1) {
                Log.w("MultiSampleEGLConfigChooser", "Did not find sane config, using first");
            }
            EGLConfig eGLConfig = i16 > 0 ? eGLConfigArr[i17] : null;
            if (eGLConfig != null) {
                return eGLConfig;
            }
            throw new IllegalArgumentException("No config chosen");
        }
        throw new IllegalArgumentException("data eglChooseConfig failed");
    }
}
