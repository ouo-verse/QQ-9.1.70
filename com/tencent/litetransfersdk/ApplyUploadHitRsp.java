package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyUploadHitRsp {
    static IPatchRedirector $redirector_;
    public byte[] bytes_upload_key;
    public byte[] bytes_uuid;
    public int int32_ret_code;
    public String str_ret_msg;
    public String str_upload_domain;
    public String str_upload_ip;
    public int uint32_upload_port;
    public long uint64_total_space;
    public long uint64_used_space;

    public ApplyUploadHitRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
