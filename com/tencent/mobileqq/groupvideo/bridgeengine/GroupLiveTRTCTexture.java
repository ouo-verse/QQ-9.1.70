package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCTexture {
    static IPatchRedirector $redirector_;
    public EGLContext eglContext10;
    public android.opengl.EGLContext eglContext14;
    public int textureId;

    public GroupLiveTRTCTexture(int i3, EGLContext eGLContext, android.opengl.EGLContext eGLContext2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), eGLContext, eGLContext2);
            return;
        }
        this.textureId = i3;
        this.eglContext10 = eGLContext;
        this.eglContext14 = eGLContext2;
    }
}
