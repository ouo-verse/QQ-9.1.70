package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UploadSuccRsp {
    static IPatchRedirector $redirector_;
    public int int32_ret_code;
    public FileInfo msg_file_info;
    public String str_ret_msg;

    public UploadSuccRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
