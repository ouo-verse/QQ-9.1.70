package com.tencent.avcore.jni.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HWCodecAbility {
    static IPatchRedirector $redirector_;
    public int codecType;
    public boolean isHWCodec;
    public int maxH;
    public int maxW;

    public HWCodecAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.codecType = 8;
        this.isHWCodec = false;
        this.maxW = 1280;
        this.maxH = 720;
    }

    public HWCodecAbility(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.maxW = 1280;
        this.maxH = 720;
        this.codecType = i3;
        this.isHWCodec = z16;
    }
}
