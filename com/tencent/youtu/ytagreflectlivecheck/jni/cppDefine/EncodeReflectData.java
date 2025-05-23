package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EncodeReflectData {
    static IPatchRedirector $redirector_;
    public byte[] encode_reflect_data;
    public byte[] live_image;
    public byte[] reserve;

    public EncodeReflectData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.encode_reflect_data = null;
        this.reserve = null;
        this.live_image = null;
    }
}
