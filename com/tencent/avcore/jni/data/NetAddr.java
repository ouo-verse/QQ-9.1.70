package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NetAddr {
    static IPatchRedirector $redirector_;
    public int enum_proto_type;
    public int fixed32_IP;
    public int fixed32_inner_IP;
    public int uint32_port;

    public NetAddr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
