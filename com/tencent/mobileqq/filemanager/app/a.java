package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346$FileInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f207227a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f207228b = null;

    /* renamed from: c, reason: collision with root package name */
    public ByteStringMicro f207229c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f207230d = null;

    /* renamed from: e, reason: collision with root package name */
    public short f207231e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f207232f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f207233g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f207234h = null;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f207235i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f207236j = null;

    /* renamed from: k, reason: collision with root package name */
    public String f207237k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f207238l = null;

    /* renamed from: m, reason: collision with root package name */
    public String f207239m = null;

    /* renamed from: n, reason: collision with root package name */
    public short f207240n = 0;

    /* renamed from: o, reason: collision with root package name */
    public List<String> f207241o = null;

    public static void a(a aVar, cmd0x346$ApplyDownloadRsp cmd0x346_applydownloadrsp, boolean z16, String str) {
        if (aVar == null || cmd0x346_applydownloadrsp == null) {
            return;
        }
        if (cmd0x346_applydownloadrsp.int32_ret_code.has()) {
            aVar.f207227a = cmd0x346_applydownloadrsp.int32_ret_code.get();
        }
        if (cmd0x346_applydownloadrsp.str_ret_msg.has()) {
            aVar.f207228b = cmd0x346_applydownloadrsp.str_ret_msg.get();
        }
        if (cmd0x346_applydownloadrsp.msg_download_info.has()) {
            cmd0x346$DownloadInfo cmd0x346_downloadinfo = cmd0x346_applydownloadrsp.msg_download_info.get();
            if (cmd0x346_downloadinfo.bytes_download_key.has()) {
                aVar.f207229c = cmd0x346_downloadinfo.bytes_download_key.get();
            }
            if (cmd0x346_downloadinfo.str_download_ip.has()) {
                aVar.f207230d = cmd0x346_downloadinfo.str_download_ip.get();
            } else if (cmd0x346_downloadinfo.str_download_domain.has()) {
                aVar.f207230d = cmd0x346_downloadinfo.str_download_domain.get();
            } else {
                QLog.i("DownloadRespInfo", 1, "handleDownloadResp: has neither ip nor domain");
            }
            if (cmd0x346_downloadinfo.uint32_port.has()) {
                aVar.f207231e = (short) cmd0x346_downloadinfo.uint32_port.get();
            }
            if (z16) {
                if (cmd0x346_downloadinfo.bytes_media_platform_download_key.has()) {
                    ByteStringMicro byteStringMicro = cmd0x346_downloadinfo.bytes_media_platform_download_key.get();
                    aVar.f207229c = byteStringMicro;
                    aVar.f207232f = String.format("/asn.com/qqdownloadftnv5?ver=0&filetype=4001&openid=%s&rkey=%s", str, HexUtil.bytes2HexStr(byteStringMicro.toByteArray()));
                }
            } else if (cmd0x346_downloadinfo.str_download_url.has()) {
                aVar.f207232f = cmd0x346_downloadinfo.str_download_url.get();
            }
            if (cmd0x346_downloadinfo.str_cookie.has()) {
                aVar.f207233g = "FTN5K=" + cmd0x346_downloadinfo.str_cookie.get();
            }
            if (cmd0x346_downloadinfo.rpt_str_downloadip_list.has() && cmd0x346_downloadinfo.rpt_str_downloadip_list.get().size() > 0) {
                aVar.f207235i = cmd0x346_downloadinfo.rpt_str_downloadip_list.get();
            }
            if (cmd0x346_downloadinfo.str_https_download_domain.has()) {
                aVar.f207238l = cmd0x346_downloadinfo.str_https_download_domain.get();
            }
            if (cmd0x346_downloadinfo.uint32_https_port.has()) {
                aVar.f207240n = (short) cmd0x346_downloadinfo.uint32_https_port.get();
            }
            if (cmd0x346_downloadinfo.str_download_dns.has()) {
                aVar.f207239m = cmd0x346_downloadinfo.str_download_dns.get();
            }
            if (cmd0x346_downloadinfo.str_downloadipv6_list.has() && cmd0x346_downloadinfo.str_downloadipv6_list.get().size() > 0) {
                aVar.f207241o = cmd0x346_downloadinfo.str_downloadipv6_list.get();
            }
        }
        if (cmd0x346_applydownloadrsp.msg_file_info.has()) {
            cmd0x346$FileInfo cmd0x346_fileinfo = cmd0x346_applydownloadrsp.msg_file_info.get();
            if (cmd0x346_fileinfo.str_file_name.has()) {
                String str2 = cmd0x346_fileinfo.str_file_name.get();
                aVar.f207234h = str2;
                aVar.f207234h = ah.h0(str2);
            }
            aVar.f207236j = vb1.a.b(cmd0x346_fileinfo.bytes_10m_md5.get().toByteArray());
            QLog.i("DownloadRespInfo", 1, "file md5:" + aVar.f207236j);
            aVar.f207237k = vb1.a.b(cmd0x346_fileinfo.bytes_sha.get().toByteArray());
            QLog.i("DownloadRespInfo", 1, "file sha:" + aVar.f207237k);
        }
    }
}
