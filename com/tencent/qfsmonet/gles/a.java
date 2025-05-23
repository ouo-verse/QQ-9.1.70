package com.tencent.qfsmonet.gles;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.tencwebrtc.EglBase;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static EGLConfig a(@NonNull EGLDisplay eGLDisplay, int i3) {
        int i16;
        if (i3 == 3) {
            i16 = 68;
        } else {
            i16 = 4;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i16, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Config", "unable to find RGBA8888 config, version:" + i3);
            return null;
        }
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Config", "find RGBA8888 config, version:" + i3);
        return eGLConfigArr[0];
    }
}
