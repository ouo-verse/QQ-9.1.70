package com.tencent.autotemplate.extra;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.PTFaceAttr;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FaceInfo {
    static IPatchRedirector $redirector_;
    public PTFaceAttr faceAttr;
    public int sourceHeight;
    public int sourceWidth;

    public FaceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
