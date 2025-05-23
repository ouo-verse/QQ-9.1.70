package com.tencent.jalpha.videoplayer.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RenderType {
    static IPatchRedirector $redirector_ = null;
    public static final int RENDER_OES = 1;
    public static final int RENDER_RGBA = 2;

    public RenderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
