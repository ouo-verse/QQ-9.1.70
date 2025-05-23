package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DeleteFileReq {
    static IPatchRedirector $redirector_;
    public String bytes_uuid;
    public int uint32_delete_type;
    public long uint64_peer_uin;
    public long uint64_uin;

    public DeleteFileReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
