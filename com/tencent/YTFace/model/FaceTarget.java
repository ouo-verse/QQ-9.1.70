package com.tencent.YTFace.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FaceTarget implements Serializable {
    static IPatchRedirector $redirector_;
    public FaceStatus[] faces;
    public int height;
    public int size;
    public int width;

    public FaceTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
