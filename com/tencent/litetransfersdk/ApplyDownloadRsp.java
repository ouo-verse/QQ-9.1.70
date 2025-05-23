package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyDownloadRsp {
    static IPatchRedirector $redirector_;
    public boolean bool_use_https;
    public boolean bool_use_new_httpclient;
    public int int32_ret_code;
    public DownloadInfo msg_download_info;
    public FileInfo msg_file_info;
    public String str_ret_msg;

    public ApplyDownloadRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
