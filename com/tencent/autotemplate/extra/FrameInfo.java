package com.tencent.autotemplate.extra;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameInfo {
    static IPatchRedirector $redirector_;
    public Rect frame;
    public int sourceHeight;
    public int sourceWidth;

    public FrameInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
