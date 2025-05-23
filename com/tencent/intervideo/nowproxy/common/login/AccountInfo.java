package com.tencent.intervideo.nowproxy.common.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AccountInfo {
    static IPatchRedirector $redirector_;
    public String authappid;
    public long login_appid;
    public int login_type;
    public byte[] skey;
    public String token;
    public String user_id;

    public AccountInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
