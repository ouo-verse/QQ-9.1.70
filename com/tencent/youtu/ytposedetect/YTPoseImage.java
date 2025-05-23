package com.tencent.youtu.ytposedetect;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class YTPoseImage {
    static IPatchRedirector $redirector_;
    public int height;
    public int width;
    public byte[] yuvRotateData;

    public YTPoseImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
