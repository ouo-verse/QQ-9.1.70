package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyUploadHitReq {
    static IPatchRedirector $redirector_;
    public byte[] bytes_10m_md5;
    public byte[] bytes_3sha;
    public byte[] bytes_sha;
    public String str_file_name;
    public String str_local_filepath;
    public int uint32_danger_level;
    public long uint64_file_size;
    public long uint64_recver_uin;
    public long uint64_sender_uin;
    public long uint64_total_space;

    public ApplyUploadHitReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
