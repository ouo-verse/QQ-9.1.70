package com.tencent.mobileqq.wxapi.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXShareRsp {
    static IPatchRedirector $redirector_;
    public int errCode;
    public String errStr;
    public String openId;
    public String transaction;

    public WXShareRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
