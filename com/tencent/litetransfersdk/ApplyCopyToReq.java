package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyCopyToReq {
    static IPatchRedirector $redirector_;
    public byte[] bytes_uuid;
    public String str_file_name;
    public String str_local_filepath;
    public int uint32_dst_svcid;
    public long uint64_dst_id;
    public long uint64_dst_uin;
    public long uint64_file_size;
    public long uint64_src_uin;

    public ApplyCopyToReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
