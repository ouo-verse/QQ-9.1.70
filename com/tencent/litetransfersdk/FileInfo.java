package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FileInfo {
    static IPatchRedirector $redirector_;
    public byte[] bytes_10m_md5;
    public byte[] bytes_sha;
    public byte[] bytes_uuid;
    public DownloadInfo msg_download_info;
    public String str_file_name;
    public int uint32_abs_file_type;
    public int uint32_client_type;
    public int uint32_danger_evel;
    public int uint32_expire_time;
    public int uint32_life_time;
    public int uint32_upload_time;
    public long uint64_file_size;
    public long uint64_owner_uin;
    public long uint64_peer_uin;
    public long uint64_uin;

    public FileInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
