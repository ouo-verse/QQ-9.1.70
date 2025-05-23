package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FileControl {
    static IPatchRedirector $redirector_;
    public boolean bool_file_assist;
    String str_msg;
    public int uint32_batchID;
    public int uint32_code;
    public int uint32_group_curindex;
    public int uint32_group_id;
    public int uint32_operate;
    public int uint32_seq;
    public long uint64_sessionid;

    public FileControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
