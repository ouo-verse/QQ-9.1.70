package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubCmd0x6ReqBody {
    static IPatchRedirector $redirector_;
    public byte[] bytes_file_md5;
    public byte[] bytes_uuid;
    public String str_file_name;
    public String str_src_file_path;
    public String str_src_parent_folder;
    public int uint32_client_type;
    public int uint32_dst_bus_id;
    public long uint64_dst_uin;
    public long uint64_file_size;
    public long uint64_src_uin;

    public SubCmd0x6ReqBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
