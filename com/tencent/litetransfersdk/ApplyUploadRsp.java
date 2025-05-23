package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApplyUploadRsp {
    static IPatchRedirector $redirector_;
    public boolean bool_file_exist;
    public boolean bool_use_https;
    public boolean bool_use_new_httpclient;
    public byte[] bytes_sha;
    public byte[] bytes_upload_key;
    public String bytes_uuid;
    public int int32_ret_code;
    public String[] rpt_str_uploadip_list;
    public String[] rpt_str_uploadipv6_list;
    public String str_ret_msg;
    public String str_upload_dns;
    public String str_upload_domain;
    public String str_upload_https_domain;
    public String str_upload_ip;
    public int uint32_httpsvr_api_ver;
    public int uint32_pack_size;
    public int uint32_upload_https_port;
    public int uint32_upload_port;
    public long uint64_total_space;
    public long uint64_uploaded_size;
    public long uint64_used_space;
    public int v6_select_type;

    public ApplyUploadRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
