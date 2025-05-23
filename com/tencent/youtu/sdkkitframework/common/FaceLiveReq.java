package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceLiveReq {
    static IPatchRedirector $redirector_;
    public String app_id;
    public String config;
    public String data;
    public String session_id;
    public String sign;

    public FaceLiveReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.session_id = "not_set";
        }
    }
}
