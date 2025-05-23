package j0;

import com.tencent.litetransfersdk.ApplyDownloadRsp;
import com.tencent.litetransfersdk.DownloadInfo;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public String f409039f;

    /* renamed from: a, reason: collision with root package name */
    public long f409034a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f409035b = null;

    /* renamed from: c, reason: collision with root package name */
    public ByteStringMicro f409036c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f409037d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f409038e = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f409040g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f409041h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f409042i = null;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f409043j = null;

    /* renamed from: k, reason: collision with root package name */
    public String f409044k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f409045l = null;

    /* renamed from: m, reason: collision with root package name */
    public String f409046m = null;

    /* renamed from: n, reason: collision with root package name */
    public String f409047n = null;

    /* renamed from: o, reason: collision with root package name */
    public short f409048o = 0;

    /* renamed from: p, reason: collision with root package name */
    public List<String> f409049p = null;

    public void a(MsgSCBody msgSCBody) {
        ApplyDownloadRsp applyDownloadRsp = msgSCBody.msgBody0x346.pMsgBody0x346_1210;
        this.f409034a = applyDownloadRsp.int32_ret_code;
        this.f409035b = applyDownloadRsp.str_ret_msg;
        this.f409036c = ByteStringMicro.copyFrom(applyDownloadRsp.msg_download_info.bytes_download_key);
        DownloadInfo downloadInfo = msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info;
        this.f409037d = downloadInfo.str_download_ip;
        this.f409039f = downloadInfo.str_download_domain;
        this.f409038e = downloadInfo.uint32_port;
        this.f409040g = downloadInfo.str_download_url;
        this.f409043j = Arrays.asList(downloadInfo.rpt_str_downloadip_list);
        this.f409041h = msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie;
    }
}
