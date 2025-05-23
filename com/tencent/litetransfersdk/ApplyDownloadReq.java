package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyDownloadReq {
    static IPatchRedirector $redirector_;
    public byte[] bytes_uuid;
    public int uint32_ext_uintype;
    public int uint32_owner_type;
    public long uint64_uin;

    public ApplyDownloadReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
