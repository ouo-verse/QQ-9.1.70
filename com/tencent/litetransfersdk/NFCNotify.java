package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NFCNotify {
    static IPatchRedirector $redirector_;
    public boolean bool_file_assist;
    public byte[] bytes_file_md5;
    public byte[] bytes_originfile_md5;
    public byte[] bytes_tokenkey;
    public byte[] bytes_url_notify;
    public int fixed32_ip;
    public ActionInfo msg_ActionInfo;
    public String str_file_name;
    public int uint32_batchID;
    public int uint32_group_curindex;
    public int uint32_group_id;
    public int uint32_group_size;
    public int uint32_groupflag;
    public int uint32_originfiletype;
    public int uint32_port;
    public long uint64_file_len;
    public long uint64_sessionid;

    public NFCNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
