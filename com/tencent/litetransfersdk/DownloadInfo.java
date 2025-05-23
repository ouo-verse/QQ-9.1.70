package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DownloadInfo {
    static IPatchRedirector $redirector_;
    public byte[] bytes_download_key;
    public String[] rpt_str_downloadip_list;
    public int rpt_str_downloadip_list_count;
    public String[] rpt_str_downloadipv6_list;
    public String str_cookie;
    public String str_download_dns;
    public String str_download_domain;
    public String str_download_ip;
    public String str_download_url;
    public String str_https_download_domain;
    public int uint32_https_port;
    public int uint32_port;
    public int v6_select_type;

    public DownloadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
