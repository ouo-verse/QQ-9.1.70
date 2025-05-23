package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgHeader {
    static IPatchRedirector $redirector_;
    public int uint32_dst_app_id;
    public int uint32_dst_inst_id;
    public int uint32_dst_ter_type;
    public int uint32_dst_uin_type;
    public int uint32_src_app_id;
    public int uint32_src_inst_id;
    public int uint32_src_ter_type;
    public int uint32_src_uin_type;
    public long uint64_dst_uin;
    public long uint64_src_uin;

    public MsgHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
