package com.tencent.qq.effect.alphavideo.videoplayer.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RenderType {
    static IPatchRedirector $redirector_ = null;
    public static final int RENDER_OES = 1;
    public static final int RENDER_RGBA = 2;
    public static final int RENDER_YUV420P_NO_REVERSE = 3;
    public static final int RENDER_YUV420P_REVERSE = 4;

    public RenderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
