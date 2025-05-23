package com.tencent.litetransfersdk;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346$FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* loaded from: classes7.dex */
public class ProtocolHelper {
    static IPatchRedirector $redirector_ = null;
    static final int DEVICETYPE_IPAD = 3;
    static final int DEVICETYPE_NONE = 0;
    static final int DEVICETYPE_PC = 1;
    static final int DEVICETYPE_PHONE = 2;
    static final int DEVICETYPE_UNK4 = 4;
    static final int DEVICETYPE_UNK5 = 5;
    public static final int TYPE_TINYID = 1;
    public static final int TYPE_UIN = 0;
    public static int V6SelectType_DomainV6 = 0;
    public static int V6SelectType_IPv4 = 0;
    public static int V6SelectType_IPv6 = 0;
    public static int V6SelectType_Unkown = 0;
    public static int mDstAppId = 0;
    public static int mDstInstId = 0;
    public static int mDstType = 0;
    public static final String sTagName = "dataline.ProtocolHelper";
    protected AppInterface mApp;
    protected int mUinType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66504);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
            return;
        }
        mDstAppId = 1;
        mDstType = 1;
        mDstInstId = 1;
        V6SelectType_Unkown = 0;
        V6SelectType_IPv4 = 1;
        V6SelectType_IPv6 = 2;
        V6SelectType_DomainV6 = 3;
    }

    public ProtocolHelper(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, i3);
        } else {
            this.mApp = appInterface;
            this.mUinType = i3;
        }
    }

    private void FillIPv6InfoForDownloadResp(MsgSCBody msgSCBody, cmd0x346$RspBody cmd0x346_rspbody) {
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (d.c().isConfigEnableIPV6(qQAppInterface, 7)) {
                msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.v6_select_type = V6SelectType_IPv4;
                String str = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_download_dns.get();
                if (!TextUtils.isEmpty(str)) {
                    msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_dns = str;
                    QLog.i("Dataline", 1, "[IPv6-File] recv dataline file. is config enable IPv6. domain[" + str + "]");
                    d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(qQAppInterface, new d.a(str, 0), 7);
                    if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                        String str2 = "";
                        if (d.b()) {
                            QLog.d("Dataline", 1, "[IPv6-File] recv dataline file. debugIsDisableIPv4OnDoubleStack");
                            DownloadInfo downloadInfo = msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info;
                            downloadInfo.str_download_ip = "";
                            downloadInfo.rpt_str_downloadip_list = null;
                        }
                        if (iPlistForV6Domain.f207643a == 2) {
                            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.v6_select_type = V6SelectType_IPv6;
                            int size = iPlistForV6Domain.f207644b.size();
                            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadipv6_list = new String[size];
                            for (int i3 = 0; i3 < size; i3++) {
                                d.b bVar = iPlistForV6Domain.f207644b.get(i3);
                                msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadipv6_list[i3] = bVar.a();
                                str2 = str2 + " " + bVar.a() + ":" + bVar.f207642b;
                            }
                            QLog.i("Dataline", 1, "[IPv6-File] recv dataline file use IPv6. iplist:" + str2);
                            return;
                        }
                        msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.v6_select_type = V6SelectType_DomainV6;
                        QLog.i("Dataline", 1, "[IPv6-File] recv dataline file use IPv6. domain");
                        return;
                    }
                    QLog.i("Dataline", 1, "[IPv6-File] recv dataline file use IPv4");
                }
            }
        }
    }

    private void FillIPv6InfoForUploadRspV2(MsgSCBody msgSCBody, cmd0x346$RspBody cmd0x346_rspbody) {
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (d.c().isConfigEnableIPV6(qQAppInterface, 7)) {
                msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_IPv4;
                String str = cmd0x346_rspbody.msg_apply_upload_rsp_v2.str_upload_dns.get();
                if (!TextUtils.isEmpty(str)) {
                    QLog.i("Dataline", 1, "[IPv6-File] v2 send dataline file. is config enable IPv6. domain[" + str + "]");
                    msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_dns = str;
                    d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(qQAppInterface, new d.a(str, 0), 7);
                    if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                        String str2 = "";
                        if (d.b()) {
                            QLog.d("Dataline", 1, "[IPv6-File] v2 send dataline file. debugIsDisableIPv4OnDoubleStack");
                            ApplyUploadRsp applyUploadRsp = msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp;
                            applyUploadRsp.str_upload_ip = "";
                            applyUploadRsp.rpt_str_uploadip_list = null;
                        }
                        if (iPlistForV6Domain.f207643a == 2) {
                            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_IPv6;
                            int size = iPlistForV6Domain.f207644b.size();
                            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadipv6_list = new String[size];
                            for (int i3 = 0; i3 < size; i3++) {
                                d.b bVar = iPlistForV6Domain.f207644b.get(i3);
                                msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadipv6_list[i3] = bVar.a();
                                str2 = str2 + " " + bVar.a() + ":" + bVar.f207642b;
                            }
                            QLog.i("Dataline", 1, "[IPv6-File] v2 send dataline file use IPv6. iplist:" + str2);
                            return;
                        }
                        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_DomainV6;
                        QLog.i("Dataline", 1, "[IPv6-File] v2 send dataline file use IPv6. domain");
                        return;
                    }
                    QLog.i("Dataline", 1, "[IPv6-File] v2 send dataline file use IPv4");
                }
            }
        }
    }

    private void FillIPv6InfoForUploadRspV3(MsgSCBody msgSCBody, cmd0x346$RspBody cmd0x346_rspbody) {
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (d.c().isConfigEnableIPV6(qQAppInterface, 7)) {
                msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_IPv4;
                String str = cmd0x346_rspbody.msg_apply_upload_rsp_v3.str_upload_dns.get();
                if (!TextUtils.isEmpty(str)) {
                    QLog.i("Dataline", 1, "[IPv6-File] v3 send dataline file. is config enable IPv6. domain[" + str + "]");
                    msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_dns = str;
                    d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(qQAppInterface, new d.a(str, 0), 7);
                    if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                        String str2 = "";
                        if (d.b()) {
                            QLog.d("Dataline", 1, "[IPv6-File] v3 send dataline file. debugIsDisableIPv4OnDoubleStack");
                            ApplyUploadRsp applyUploadRsp = msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp;
                            applyUploadRsp.str_upload_ip = "";
                            applyUploadRsp.rpt_str_uploadip_list = null;
                        }
                        if (iPlistForV6Domain.f207643a == 2) {
                            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_IPv6;
                            int size = iPlistForV6Domain.f207644b.size();
                            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadipv6_list = new String[size];
                            for (int i3 = 0; i3 < size; i3++) {
                                d.b bVar = iPlistForV6Domain.f207644b.get(i3);
                                msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadipv6_list[i3] = bVar.a();
                                str2 = str2 + " " + bVar.a() + ":" + bVar.f207642b;
                            }
                            QLog.i("Dataline", 1, "[IPv6-File] v3 send dataline file use IPv6. iplist:" + str2);
                            return;
                        }
                        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.v6_select_type = V6SelectType_DomainV6;
                        QLog.i("Dataline", 1, "[IPv6-File] v3 send dataline file use IPv6. domain");
                        return;
                    }
                    QLog.i("Dataline", 1, "[IPv6-File] v3 send dataline file use IPv4");
                }
            }
        }
    }

    public static String FixImageFileExtName(String str, String str2, int i3, boolean z16) {
        String str3;
        if (i3 == 1 && FileManagerUtil.getFileType(str) != 0 && !z16) {
            if (GifDrawable.isGifFile(new File(str2))) {
                str3 = QzoneEmotionUtils.SIGN_ICON_URL_END;
            } else {
                str3 = ".jpg";
            }
            return str + str3;
        }
        return str;
    }

    public static void GetTypeInfo(int i3) {
        if (i3 == 1) {
            mDstAppId = 1001;
            mDstType = 3;
            mDstInstId = 0;
        } else if (i3 == 2) {
            mDstAppId = 1001;
            mDstType = 2;
            mDstInstId = 0;
        } else {
            mDstAppId = 1;
            mDstType = 1;
            mDstInstId = 1;
        }
    }

    private FileInfo createFileInfo(cmd0x346$FileInfo cmd0x346_fileinfo) {
        if (cmd0x346_fileinfo == null) {
            return null;
        }
        FileInfo fileInfo = new FileInfo();
        fileInfo.uint64_uin = cmd0x346_fileinfo.uint64_uin.get();
        fileInfo.uint32_danger_evel = cmd0x346_fileinfo.uint32_danger_evel.get();
        fileInfo.uint64_file_size = cmd0x346_fileinfo.uint64_file_size.get();
        fileInfo.uint32_life_time = cmd0x346_fileinfo.uint32_life_time.get();
        fileInfo.uint32_upload_time = cmd0x346_fileinfo.uint32_upload_time.get();
        fileInfo.bytes_uuid = cmd0x346_fileinfo.bytes_uuid.get().toByteArray();
        fileInfo.str_file_name = cmd0x346_fileinfo.str_file_name.get();
        fileInfo.uint32_abs_file_type = cmd0x346_fileinfo.uint32_abs_file_type.get();
        fileInfo.bytes_10m_md5 = cmd0x346_fileinfo.bytes_10m_md5.get().toByteArray();
        fileInfo.uint32_client_type = cmd0x346_fileinfo.uint32_client_type.get();
        fileInfo.uint64_owner_uin = cmd0x346_fileinfo.uint64_owner_uin.get();
        fileInfo.uint64_peer_uin = cmd0x346_fileinfo.uint64_peer_uin.get();
        fileInfo.uint32_expire_time = cmd0x346_fileinfo.uint32_expire_time.get();
        return fileInfo;
    }

    public boolean CheckActionInfo(SubMsgType0x7$MsgBody.FTNNotify fTNNotify, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) fTNNotify, (Object) str)).booleanValue();
        }
        if (fTNNotify.msg_ActionInfo.has()) {
            return isMyNotify(fTNNotify.msg_ActionInfo.get(), str);
        }
        return false;
    }

    public void FillMsgSCBody(MsgSCBody msgSCBody, cmd0x346$RspBody cmd0x346_rspbody, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, msgSCBody, cmd0x346_rspbody, Integer.valueOf(i3));
            return;
        }
        MsgSCBody0x346 msgSCBody0x346 = new MsgSCBody0x346();
        msgSCBody.msgBody0x346 = msgSCBody0x346;
        msgSCBody0x346.uMsgSubType = i3;
        if (i3 == 810) {
            msgSCBody0x346.pMsgBody0x346_810 = new UploadSuccRsp();
            msgSCBody.msgBody0x346.pMsgBody0x346_810.int32_ret_code = cmd0x346_rspbody.msg_upload_succ_rsp.int32_ret_code.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_810.str_ret_msg = cmd0x346_rspbody.msg_upload_succ_rsp.str_ret_msg.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_810.msg_file_info = createFileInfo(cmd0x346_rspbody.msg_upload_succ_rsp.msg_file_info);
            return;
        }
        if (i3 == 910) {
            msgSCBody0x346.pMsgBody0x346_910 = new DeleteFileRsp();
            msgSCBody.msgBody0x346.pMsgBody0x346_910.int32_ret_code = cmd0x346_rspbody.msg_delete_file_rsp.int32_ret_code.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_910.str_ret_msg = cmd0x346_rspbody.msg_delete_file_rsp.str_ret_msg.get();
            return;
        }
        if (i3 == 1210) {
            msgSCBody0x346.pMsgBody0x346_1210 = new ApplyDownloadRsp();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.int32_ret_code = cmd0x346_rspbody.msg_apply_download_rsp.int32_ret_code.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.str_ret_msg = cmd0x346_rspbody.msg_apply_download_rsp.str_ret_msg.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info = new DownloadInfo();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.bytes_download_key = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.bytes_download_key.get().toByteArray();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_ip = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_download_ip.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_domain = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_download_domain.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_port = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.uint32_port.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_url = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_download_url.get();
            List<String> list = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.rpt_str_downloadip_list.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list = (String[]) list.toArray(new String[list.size()]);
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_cookie.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_file_info = createFileInfo(cmd0x346_rspbody.msg_apply_download_rsp.msg_file_info);
            FillIPv6InfoForDownloadResp(msgSCBody, cmd0x346_rspbody);
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_https_port = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.uint32_https_port.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_https_download_domain = cmd0x346_rspbody.msg_apply_download_rsp.msg_download_info.str_https_download_domain.get();
            SharedPreferences sharedPreferences = this.mApp.getApp().getSharedPreferences("dataline_config_" + this.mApp.getCurrentAccountUin(), 0);
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.bool_use_new_httpclient = sharedPreferences.getBoolean("use_new_httpclient", false);
            msgSCBody.msgBody0x346.pMsgBody0x346_1210.bool_use_https = sharedPreferences.getBoolean("use_https_connect", false);
            QLog.d(sTagName, 1, "FillMsgSCBody use_new_httpclient[" + msgSCBody.msgBody0x346.pMsgBody0x346_1210.bool_use_new_httpclient + "], bool_use_https[" + msgSCBody.msgBody0x346.pMsgBody0x346_1210.bool_use_https + "]");
            return;
        }
        if (i3 == 1410) {
            msgSCBody0x346.fileQueryRsp = new FileQueryRsp();
            msgSCBody.msgBody0x346.fileQueryRsp.int32_ret_code = cmd0x346_rspbody.msg_file_query_rsp.int32_ret_code.get();
            msgSCBody.msgBody0x346.fileQueryRsp.str_ret_msg = cmd0x346_rspbody.msg_file_query_rsp.str_ret_msg.get();
            msgSCBody.msgBody0x346.fileQueryRsp.msg_file_info = createFileInfo(cmd0x346_rspbody.msg_file_query_rsp.msg_file_info);
            return;
        }
        if (i3 == 1610) {
            msgSCBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = cmd0x346_rspbody.msg_apply_upload_rsp_v2.int32_ret_code.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = cmd0x346_rspbody.msg_apply_upload_rsp_v2.str_ret_msg.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint64_total_space.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint64_used_space.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint64_uploaded_size.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = cmd0x346_rspbody.msg_apply_upload_rsp_v2.str_upload_ip.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = cmd0x346_rspbody.msg_apply_upload_rsp_v2.str_upload_domain.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint32_upload_port.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = cmd0x346_rspbody.msg_apply_upload_rsp_v2.bytes_uuid.get().toStringUtf8();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = cmd0x346_rspbody.msg_apply_upload_rsp_v2.bytes_upload_key.get().toByteArray();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = cmd0x346_rspbody.msg_apply_upload_rsp_v2.bool_file_exist.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint32_pack_size.get();
            List<String> list2 = cmd0x346_rspbody.msg_apply_upload_rsp_v2.rpt_str_uploadip_list.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = (String[]) list2.toArray(new String[list2.size()]);
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_httpsvr_api_ver = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint32_httpsvr_api_ver.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_sha = cmd0x346_rspbody.msg_apply_upload_rsp_v2.bytes_sha.get().toByteArray();
            FillIPv6InfoForUploadRspV2(msgSCBody, cmd0x346_rspbody);
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_https_port = cmd0x346_rspbody.msg_apply_upload_rsp_v2.uint32_upload_https_port.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_https_domain = cmd0x346_rspbody.msg_apply_upload_rsp_v2.str_upload_https_domain.get();
            SharedPreferences sharedPreferences2 = this.mApp.getApp().getSharedPreferences("dataline_config_" + this.mApp.getCurrentAccountUin(), 0);
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_new_httpclient = sharedPreferences2.getBoolean("use_new_httpclient", false);
            msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_https = sharedPreferences2.getBoolean("use_https_connect", false);
            QLog.d(sTagName, 1, "FillMsgSCBody use_new_httpclient[" + msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_new_httpclient + "], bool_use_https[" + msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_https + "]");
            return;
        }
        if (i3 != 1710) {
            if (i3 != 1810) {
                if (i3 != 60110) {
                    if (QLog.isColorLevel()) {
                        QLog.e(sTagName, 2, "PBToMsgSCBody : msgtype is not cmd0x346");
                        return;
                    }
                    return;
                } else {
                    msgSCBody0x346.applyCopyToRsp = new ApplyCopyToRsp();
                    msgSCBody.msgBody0x346.applyCopyToRsp.int32_ret_code = cmd0x346_rspbody.msg_apply_copy_to_rsp.int32_ret_code.get();
                    msgSCBody.msgBody0x346.applyCopyToRsp.str_ret_msg = cmd0x346_rspbody.msg_apply_copy_to_rsp.str_ret_msg.get();
                    msgSCBody.msgBody0x346.applyCopyToRsp.str_file_key = cmd0x346_rspbody.msg_apply_copy_to_rsp.str_file_key.get();
                    return;
                }
            }
            msgSCBody0x346.pMsgBody0x346_1810 = new ApplyUploadHitRsp();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.int32_ret_code = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.int32_ret_code.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.str_ret_msg = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.str_ret_msg.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_ip = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.str_upload_ip.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_domain = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.str_upload_domain.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_uuid = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.bytes_uuid.get().toByteArray();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_upload_key = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.bytes_upload_key.get().toByteArray();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_total_space = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.uint64_total_space.get();
            msgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_used_space = cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.uint64_used_space.get();
            return;
        }
        msgSCBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = cmd0x346_rspbody.msg_apply_upload_rsp_v3.int32_ret_code.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = cmd0x346_rspbody.msg_apply_upload_rsp_v3.str_ret_msg.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint64_total_space.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint64_used_space.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint64_uploaded_size.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = cmd0x346_rspbody.msg_apply_upload_rsp_v3.str_upload_ip.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = cmd0x346_rspbody.msg_apply_upload_rsp_v3.str_upload_domain.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint32_upload_port.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = cmd0x346_rspbody.msg_apply_upload_rsp_v3.bytes_uuid.get().toStringUtf8();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = cmd0x346_rspbody.msg_apply_upload_rsp_v3.bytes_upload_key.get().toByteArray();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = cmd0x346_rspbody.msg_apply_upload_rsp_v3.bool_file_exist.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint32_pack_size.get();
        List<String> list3 = cmd0x346_rspbody.msg_apply_upload_rsp_v3.rpt_str_uploadip_list.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = (String[]) list3.toArray(new String[list3.size()]);
        FillIPv6InfoForUploadRspV3(msgSCBody, cmd0x346_rspbody);
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_https_port = cmd0x346_rspbody.msg_apply_upload_rsp_v3.uint32_upload_https_port.get();
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_https_domain = cmd0x346_rspbody.msg_apply_upload_rsp_v3.str_upload_https_domain.get();
        SharedPreferences sharedPreferences3 = this.mApp.getApp().getSharedPreferences("dataline_config_" + this.mApp.getCurrentAccountUin(), 0);
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_new_httpclient = sharedPreferences3.getBoolean("use_new_httpclient", false);
        msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_https = sharedPreferences3.getBoolean("use_https_connect", false);
        QLog.d(sTagName, 1, "FillMsgSCBody use_new_httpclient[" + msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_new_httpclient + "], bool_use_https[" + msgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_use_https + "]");
    }

    public boolean FillReqBody(MsgCSBody0x346 msgCSBody0x346, cmd0x346$ReqBody cmd0x346_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msgCSBody0x346, (Object) cmd0x346_reqbody)).booleanValue();
        }
        int i3 = msgCSBody0x346.uMsgSubType;
        if (i3 != 800) {
            if (i3 != 900) {
                if (i3 != 1200) {
                    if (i3 != 1400) {
                        if (i3 != 1600) {
                            if (i3 != 1700) {
                                if (i3 != 1800) {
                                    if (i3 != 60100) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(sTagName, 2, "send0x346Req, unknwon nCmdType:" + msgCSBody0x346.uMsgSubType);
                                        }
                                        return false;
                                    }
                                    cmd0x346_reqbody.msg_apply_copy_to_req.setHasFlag(true);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.uint64_dst_id.set(msgCSBody0x346.applyCopyToReq.uint64_dst_id);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.uint64_dst_uin.set(msgCSBody0x346.applyCopyToReq.uint64_dst_uin);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.uint32_dst_svcid.set(msgCSBody0x346.applyCopyToReq.uint32_dst_svcid);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.uint64_src_uin.set(msgCSBody0x346.applyCopyToReq.uint64_src_uin);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.uint64_file_size.set(msgCSBody0x346.applyCopyToReq.uint64_file_size);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.str_file_name.set(msgCSBody0x346.applyCopyToReq.str_file_name);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.str_local_filepath.set(msgCSBody0x346.applyCopyToReq.str_local_filepath);
                                    cmd0x346_reqbody.msg_apply_copy_to_req.bytes_uuid.set(ByteStringMicro.copyFrom(msgCSBody0x346.applyCopyToReq.bytes_uuid));
                                } else {
                                    cmd0x346$ApplyUploadHitReqV2 cmd0x346_applyuploadhitreqv2 = new cmd0x346$ApplyUploadHitReqV2();
                                    ApplyUploadHitReq applyUploadHitReq = msgCSBody0x346.pMsgBody0x346_1800;
                                    if (applyUploadHitReq == null) {
                                        return false;
                                    }
                                    cmd0x346_applyuploadhitreqv2.uint64_sender_uin.set(applyUploadHitReq.uint64_sender_uin);
                                    cmd0x346_applyuploadhitreqv2.uint64_recver_uin.set(applyUploadHitReq.uint64_recver_uin);
                                    cmd0x346_applyuploadhitreqv2.uint64_file_size.set(applyUploadHitReq.uint64_file_size);
                                    cmd0x346_applyuploadhitreqv2.str_file_name.set(applyUploadHitReq.str_file_name);
                                    cmd0x346_applyuploadhitreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(applyUploadHitReq.bytes_10m_md5));
                                    cmd0x346_applyuploadhitreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(applyUploadHitReq.bytes_3sha));
                                    cmd0x346_applyuploadhitreqv2.bytes_sha.set(ByteStringMicro.copyFrom(applyUploadHitReq.bytes_sha));
                                    cmd0x346_applyuploadhitreqv2.str_local_filepath.set(applyUploadHitReq.str_local_filepath);
                                    cmd0x346_applyuploadhitreqv2.uint32_danger_level.set(applyUploadHitReq.uint32_danger_level);
                                    cmd0x346_applyuploadhitreqv2.uint64_total_space.set(applyUploadHitReq.uint64_total_space);
                                    cmd0x346_reqbody.msg_apply_upload_hit_req_v2.set(cmd0x346_applyuploadhitreqv2);
                                }
                            } else {
                                cmd0x346$ApplyUploadReqV3 cmd0x346_applyuploadreqv3 = new cmd0x346$ApplyUploadReqV3();
                                ApplyUploadReq applyUploadReq = msgCSBody0x346.pMsgBody0x346_uploadReq;
                                if (applyUploadReq == null) {
                                    return false;
                                }
                                cmd0x346_applyuploadreqv3.uint64_sender_uin.set(applyUploadReq.uint64_sender_uin);
                                cmd0x346_applyuploadreqv3.uint64_recver_uin.set(applyUploadReq.uint64_recver_uin);
                                cmd0x346_applyuploadreqv3.uint64_file_size.set(applyUploadReq.uint64_file_size);
                                cmd0x346_applyuploadreqv3.str_file_name.set(applyUploadReq.str_file_name);
                                cmd0x346_applyuploadreqv3.bytes_10m_md5.set(ByteStringMicro.copyFrom(applyUploadReq.bytes_10m_md5));
                                cmd0x346_applyuploadreqv3.bytes_sha.set(ByteStringMicro.copyFrom(applyUploadReq.bytes_sha));
                                cmd0x346_applyuploadreqv3.str_local_filepath.set(applyUploadReq.str_local_filepath);
                                cmd0x346_applyuploadreqv3.uint32_danger_level.set(applyUploadReq.uint32_danger_level);
                                cmd0x346_applyuploadreqv3.uint64_total_space.set(applyUploadReq.uint64_total_space);
                                cmd0x346_reqbody.msg_apply_upload_req_v3.set(cmd0x346_applyuploadreqv3);
                            }
                        } else {
                            cmd0x346$ApplyUploadReqV2 cmd0x346_applyuploadreqv2 = new cmd0x346$ApplyUploadReqV2();
                            ApplyUploadReq applyUploadReq2 = msgCSBody0x346.pMsgBody0x346_uploadReq;
                            if (applyUploadReq2 == null) {
                                return false;
                            }
                            cmd0x346_applyuploadreqv2.uint64_sender_uin.set(applyUploadReq2.uint64_sender_uin);
                            cmd0x346_applyuploadreqv2.uint64_recver_uin.set(applyUploadReq2.uint64_recver_uin);
                            cmd0x346_applyuploadreqv2.uint64_file_size.set(applyUploadReq2.uint64_file_size);
                            cmd0x346_applyuploadreqv2.str_file_name.set(applyUploadReq2.str_file_name);
                            cmd0x346_applyuploadreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(applyUploadReq2.bytes_10m_md5));
                            cmd0x346_applyuploadreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(applyUploadReq2.bytes_sha));
                            cmd0x346_applyuploadreqv2.str_local_filepath.set(applyUploadReq2.str_local_filepath);
                            cmd0x346_applyuploadreqv2.uint32_danger_level.set(applyUploadReq2.uint32_danger_level);
                            cmd0x346_applyuploadreqv2.uint64_total_space.set(applyUploadReq2.uint64_total_space);
                            cmd0x346_reqbody.msg_apply_upload_req_v2.set(cmd0x346_applyuploadreqv2);
                        }
                    } else {
                        cmd0x346_reqbody.msg_file_query_req.setHasFlag(true);
                        cmd0x346_reqbody.msg_file_query_req.uint64_uin.set(msgCSBody0x346.fileQueryReq.uint64_uin);
                        byte[] bArr = msgCSBody0x346.fileQueryReq.bytes_uuid;
                        if (bArr != null) {
                            cmd0x346_reqbody.msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(bArr));
                        }
                    }
                } else {
                    cmd0x346$ApplyDownloadReq cmd0x346_applydownloadreq = new cmd0x346$ApplyDownloadReq();
                    ApplyDownloadReq applyDownloadReq = msgCSBody0x346.pMsgBody0x346_1200;
                    if (applyDownloadReq == null) {
                        return false;
                    }
                    cmd0x346_applydownloadreq.uint64_uin.set(applyDownloadReq.uint64_uin);
                    cmd0x346_applydownloadreq.bytes_uuid.set(ByteStringMicro.copyFrom(applyDownloadReq.bytes_uuid));
                    int i16 = applyDownloadReq.uint32_ext_uintype;
                    if (i16 != 0) {
                        cmd0x346_applydownloadreq.uint32_ext_uintype.set(i16);
                    }
                    if (applyDownloadReq.uint32_ext_uintype == 1) {
                        cmd0x346_applydownloadreq.uint32_owner_type.set(1);
                    } else {
                        cmd0x346_applydownloadreq.uint32_owner_type.set(2);
                    }
                    cmd0x346_reqbody.msg_apply_download_req.set(cmd0x346_applydownloadreq);
                }
            } else {
                cmd0x346_reqbody.msg_delete_file_req.setHasFlag(true);
                cmd0x346_reqbody.msg_delete_file_req.uint64_uin.set(msgCSBody0x346.pMsgBody0x346_900.uint64_uin);
                cmd0x346_reqbody.msg_delete_file_req.uint64_peer_uin.set(msgCSBody0x346.pMsgBody0x346_900.uint64_peer_uin);
                cmd0x346_reqbody.msg_delete_file_req.uint32_delete_type.set(msgCSBody0x346.pMsgBody0x346_900.uint32_delete_type);
                String str = msgCSBody0x346.pMsgBody0x346_900.bytes_uuid;
                if (str != null) {
                    cmd0x346_reqbody.msg_delete_file_req.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
                }
            }
        } else {
            cmd0x346_reqbody.msg_upload_succ_req.setHasFlag(true);
            cmd0x346_reqbody.msg_upload_succ_req.uint64_sender_uin.set(msgCSBody0x346.pMsgBody0x346_800.uint64_sender_uin);
            cmd0x346_reqbody.msg_upload_succ_req.uint64_recver_uin.set(msgCSBody0x346.pMsgBody0x346_800.uint64_recver_uin);
            String str2 = msgCSBody0x346.pMsgBody0x346_800.bytes_uuid;
            if (str2 != null) {
                cmd0x346_reqbody.msg_upload_succ_req.bytes_uuid.set(ByteStringMicro.copyFrom(str2.getBytes()));
            }
        }
        return true;
    }

    public long GenSessionIdFromDev(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return j3;
            }
            return (j3 & (-2305843009213693953L)) | 1152921504606846976L;
        }
        return (j3 & (-1152921504606846977L)) | LockFreeTaskQueueCore.CLOSED_MASK;
    }

    public long GetSelfUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        if (this.mUinType == 0) {
            return Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
        }
        return 0L;
    }

    public SubMsgType0x7$MsgBody MsgBodyFromMpFileNotify(long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 27, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        }
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(11);
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3);
        SubMsgType0x7$MsgBody.MpFileNotify mpFileNotify = new SubMsgType0x7$MsgBody.MpFileNotify();
        mpFileNotify.uint64_sessionid.set(j16);
        mpFileNotify.uint32_operate.set(i3);
        mpFileNotify.uint32_type.set(1);
        mpFileNotify.setHasFlag(true);
        subMsgType0x7$MsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(mpFileNotify);
        subMsgType0x7$MsgBody.setHasFlag(true);
        return subMsgType0x7$MsgBody;
    }

    public MsgCSBody MsgCSBodyFromFTNNotify(int i3, SubMsgType0x7$MsgBody.MsgHeader msgHeader, List<SubMsgType0x7$MsgBody.FTNNotify> list, boolean z16) {
        long j3;
        byte[] byteArray;
        int i16;
        int i17;
        int i18;
        String str;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), msgHeader, list, Boolean.valueOf(z16));
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgTime = i3;
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = msgHeader.uint32_src_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = msgHeader.uint32_src_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = msgHeader.uint32_dst_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = msgHeader.uint32_dst_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = msgHeader.uint64_dst_uin.get();
        MsgHeader msgHeader2 = msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
        if (msgHeader.uint64_src_uin.has()) {
            j3 = msgHeader.uint64_src_uin.get();
        } else {
            j3 = 0;
        }
        msgHeader2.uint64_src_uin = j3;
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = msgHeader.uint32_dst_ter_type.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = msgHeader.uint32_src_ter_type.get();
        ArrayList arrayList = new ArrayList();
        Iterator<SubMsgType0x7$MsgBody.FTNNotify> it = list.iterator();
        while (true) {
            int i27 = 9;
            if (!it.hasNext()) {
                break;
            }
            SubMsgType0x7$MsgBody.FTNNotify next = it.next();
            if (next.uint64_sessionid.has()) {
                MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
                if (!z16) {
                    i27 = 1;
                }
                msgCSBody0x211_0x7.uMsgSubCmd = i27;
                FTNNotify fTNNotify = new FTNNotify();
                fTNNotify.uint64_sessionid = GenSessionIdFromDev(next.uint64_sessionid.get(), msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
                fTNNotify.str_file_name = next.str_file_name.get();
                fTNNotify.str_file_index = next.str_file_index.get();
                fTNNotify.bytes_file_md5 = next.bytes_file_md5.get().toByteArray();
                fTNNotify.uint64_file_len = next.uint64_file_len.get();
                byte[] bArr = null;
                if (z16) {
                    byteArray = null;
                } else {
                    byteArray = next.bytes_originfile_md5.get().toByteArray();
                }
                fTNNotify.bytes_originfile_md5 = byteArray;
                fTNNotify.uint32_originfiletype = next.uint32_originfiletype.get();
                if (next.uint32_group_id.has()) {
                    i16 = next.uint32_group_id.get();
                } else {
                    i16 = 0;
                }
                fTNNotify.uint32_group_id = i16;
                if (next.uint32_group_size.has()) {
                    i17 = next.uint32_group_size.get();
                } else {
                    i17 = 0;
                }
                fTNNotify.uint32_group_size = i17;
                if (next.uint32_group_curindex.has()) {
                    i18 = next.uint32_group_curindex.get();
                } else {
                    i18 = 0;
                }
                fTNNotify.uint32_group_curindex = i18;
                ActionInfo actionInfo = new ActionInfo();
                fTNNotify.msg_ActionInfo = actionInfo;
                if (next.msg_ActionInfo.has()) {
                    str = next.msg_ActionInfo.get().str_service_name.get();
                } else {
                    str = null;
                }
                actionInfo.strServiceName = str;
                ActionInfo actionInfo2 = fTNNotify.msg_ActionInfo;
                if (next.msg_ActionInfo.has()) {
                    bArr = next.msg_ActionInfo.get().bytes_buf.get().toByteArray();
                }
                actionInfo2.vServiceInfo = bArr;
                if (next.uint32_batchID.has()) {
                    i19 = next.uint32_batchID.get();
                } else {
                    i19 = 0;
                }
                fTNNotify.uint32_batchID = i19;
                if (next.uint32_groupflag.has()) {
                    i26 = next.uint32_groupflag.get();
                } else {
                    i26 = 0;
                }
                fTNNotify.uint32_groupflag = i26;
                arrayList.add(fTNNotify);
            }
        }
        MsgCSBody0x211_0x7 msgCSBody0x211_0x72 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        int i28 = msgCSBody0x211_0x72.uMsgSubCmd;
        if (i28 == 9) {
            msgCSBody0x211_0x72.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = (FTNNotify[]) arrayList.toArray(new FTNNotify[arrayList.size()]);
        } else if (i28 == 1) {
            msgCSBody0x211_0x72.pMsgBody0x211_0x7_0x1_FTNNotifySrc = (FTNNotify[]) arrayList.toArray(new FTNNotify[arrayList.size()]);
        }
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromFTNNotify_0x210(long j3, long j16, long j17, String str, long j18, byte[] bArr, String str2, byte[] bArr2, int i3, int i16, int i17, int i18, long j19, long j26, long j27, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str, Long.valueOf(j18), bArr, str2, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Boolean.valueOf(z16));
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
        ArrayList arrayList = new ArrayList();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = bArr2 == null ? 9 : 1;
        FTNNotify fTNNotify = new FTNNotify();
        fTNNotify.uint64_sessionid = j3;
        fTNNotify.str_file_name = str;
        fTNNotify.str_file_index = str2;
        fTNNotify.bytes_file_md5 = bArr;
        fTNNotify.uint64_file_len = j18;
        fTNNotify.bytes_originfile_md5 = bArr2;
        fTNNotify.uint32_originfiletype = (int) j16;
        fTNNotify.uint32_group_id = i3;
        fTNNotify.uint32_group_size = i16;
        fTNNotify.uint32_group_curindex = i17;
        fTNNotify.uint32_batchID = i18;
        fTNNotify.msg_ActionInfo = new ActionInfo();
        arrayList.add(fTNNotify);
        MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        int i19 = msgCSBody0x211_0x7.uMsgSubCmd;
        if (i19 == 9) {
            msgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = (FTNNotify[]) arrayList.toArray(new FTNNotify[arrayList.size()]);
        } else if (i19 == 1) {
            msgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = (FTNNotify[]) arrayList.toArray(new FTNNotify[arrayList.size()]);
        }
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromFileControl(SubMsgType0x7$MsgBody.MsgHeader msgHeader, List<SubMsgType0x7$MsgBody.FileControl> list) {
        long j3;
        int i3;
        int i16;
        String str;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 26, (Object) this, (Object) msgHeader, (Object) list);
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        msgCSBody0x211_0x7.uMsgSubCmd = 3;
        msgCSBody0x211_0x7.msgHeader = new MsgHeader();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = msgHeader.uint32_src_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = msgHeader.uint32_src_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = msgHeader.uint32_dst_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = msgHeader.uint32_dst_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = msgHeader.uint64_dst_uin.get();
        MsgHeader msgHeader2 = msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
        if (msgHeader.uint64_src_uin.has()) {
            j3 = msgHeader.uint64_src_uin.get();
        } else {
            j3 = 0;
        }
        msgHeader2.uint64_src_uin = j3;
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = msgHeader.uint32_dst_ter_type.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = msgHeader.uint32_src_ter_type.get();
        ArrayList arrayList = new ArrayList();
        for (SubMsgType0x7$MsgBody.FileControl fileControl : list) {
            if (fileControl.uint64_sessionid.has() && fileControl.uint32_operate.has()) {
                FileControl fileControl2 = new FileControl();
                fileControl2.uint64_sessionid = GenSessionIdFromDev(fileControl.uint64_sessionid.get(), msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
                fileControl2.uint32_operate = fileControl.uint32_operate.get();
                int i19 = 0;
                if (fileControl.uint32_seq.has()) {
                    i3 = fileControl.uint32_seq.get();
                } else {
                    i3 = 0;
                }
                fileControl2.uint32_seq = i3;
                if (fileControl.uint32_code.has()) {
                    i16 = fileControl.uint32_code.get();
                } else {
                    i16 = 0;
                }
                fileControl2.uint32_code = i16;
                if (fileControl.str_msg.has()) {
                    str = fileControl.str_msg.get();
                } else {
                    str = null;
                }
                fileControl2.str_msg = str;
                if (fileControl.uint32_group_id.has()) {
                    i17 = fileControl.uint32_group_id.get();
                } else {
                    i17 = 0;
                }
                fileControl2.uint32_group_id = i17;
                if (fileControl.uint32_group_curindex.has()) {
                    i18 = fileControl.uint32_group_curindex.get();
                } else {
                    i18 = 0;
                }
                fileControl2.uint32_group_curindex = i18;
                if (fileControl.uint32_batchID.has()) {
                    i19 = fileControl.uint32_batchID.get();
                }
                fileControl2.uint32_batchID = i19;
                fileControl2.bool_file_assist = fileControl.bool_file_assist.get();
                arrayList.add(fileControl2);
                if (QLog.isColorLevel()) {
                    QLog.d(sTagName, 2, "onFileOperate0x211, \u63a7\u5236\u4fe1\u4ee4, sessionid[" + fileControl2.uint64_sessionid + "]; curindex[" + fileControl2.uint32_group_curindex + "]; group_id[" + fileControl2.uint32_group_id + "]; batchID[" + fileControl2.uint32_batchID + "]; operate[" + fileControl2.uint32_operate + "];");
                }
            }
        }
        msgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = (FileControl[]) arrayList.toArray(new FileControl[arrayList.size()]);
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromFileControl_0x210(long j3, long j16, int i3, int i16, short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Short.valueOf(s16));
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "uSessionID[" + j3 + "]onFileOpdrate: 210  operate = " + j16);
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
        msgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
        ArrayList arrayList = new ArrayList();
        FileControl fileControl = new FileControl();
        fileControl.uint64_sessionid = j3;
        fileControl.uint32_operate = (int) j16;
        fileControl.uint32_seq = s16;
        fileControl.uint32_code = 0;
        fileControl.str_msg = null;
        fileControl.uint32_group_id = i16;
        fileControl.uint32_group_curindex = 0;
        fileControl.uint32_batchID = 0;
        fileControl.bool_file_assist = false;
        arrayList.add(fileControl);
        msgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = (FileControl[]) arrayList.toArray(new FileControl[arrayList.size()]);
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromNFCNotify(int i3, SubMsgType0x7$MsgBody.MsgHeader msgHeader, List<SubMsgType0x7$MsgBody.NFCNotify> list, boolean z16) {
        long j3;
        byte[] byteArray;
        int i16;
        int i17;
        int i18;
        String str;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), msgHeader, list, Boolean.valueOf(z16));
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgTime = i3;
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = msgHeader.uint32_src_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = msgHeader.uint32_src_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = msgHeader.uint32_dst_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = msgHeader.uint32_dst_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = msgHeader.uint64_dst_uin.get();
        MsgHeader msgHeader2 = msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
        if (msgHeader.uint64_src_uin.has()) {
            j3 = msgHeader.uint64_src_uin.get();
        } else {
            j3 = 0;
        }
        msgHeader2.uint64_src_uin = j3;
        MsgHeader msgHeader3 = msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
        msgHeader3.uint32_dst_uin_type = 0;
        msgHeader3.uint32_dst_ter_type = msgHeader.uint32_dst_ter_type.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = msgHeader.uint32_src_ter_type.get();
        ArrayList arrayList = new ArrayList();
        Iterator<SubMsgType0x7$MsgBody.NFCNotify> it = list.iterator();
        while (true) {
            int i27 = 10;
            if (!it.hasNext()) {
                break;
            }
            SubMsgType0x7$MsgBody.NFCNotify next = it.next();
            if (next.uint64_sessionid.has()) {
                long GenSessionIdFromDev = GenSessionIdFromDev(next.uint64_sessionid.get(), msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
                MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
                if (!z16) {
                    i27 = 2;
                }
                msgCSBody0x211_0x7.uMsgSubCmd = i27;
                NFCNotify nFCNotify = new NFCNotify();
                nFCNotify.uint64_sessionid = GenSessionIdFromDev;
                nFCNotify.str_file_name = next.str_file_name.get();
                nFCNotify.bytes_file_md5 = next.bytes_file_md5.get().toByteArray();
                nFCNotify.fixed32_ip = next.fixed32_ip.get();
                nFCNotify.uint32_port = next.uint32_port.get();
                nFCNotify.bytes_url_notify = next.bytes_url_notify.get().toByteArray();
                nFCNotify.bytes_tokenkey = next.bytes_tokenkey.get().toByteArray();
                nFCNotify.uint64_file_len = next.uint64_file_len.get();
                byte[] bArr = null;
                if (z16) {
                    byteArray = null;
                } else {
                    byteArray = next.bytes_originfile_md5.get().toByteArray();
                }
                nFCNotify.bytes_originfile_md5 = byteArray;
                nFCNotify.uint32_originfiletype = next.uint32_originfiletype.get();
                if (next.uint32_group_id.has()) {
                    i16 = next.uint32_group_id.get();
                } else {
                    i16 = 0;
                }
                nFCNotify.uint32_group_id = i16;
                if (next.uint32_group_size.has()) {
                    i17 = next.uint32_group_size.get();
                } else {
                    i17 = 0;
                }
                nFCNotify.uint32_group_size = i17;
                if (next.uint32_group_curindex.has()) {
                    i18 = next.uint32_group_curindex.get();
                } else {
                    i18 = 0;
                }
                nFCNotify.uint32_group_curindex = i18;
                ActionInfo actionInfo = new ActionInfo();
                nFCNotify.msg_ActionInfo = actionInfo;
                if (next.msg_ActionInfo.has()) {
                    str = next.msg_ActionInfo.get().str_service_name.get();
                } else {
                    str = null;
                }
                actionInfo.strServiceName = str;
                ActionInfo actionInfo2 = nFCNotify.msg_ActionInfo;
                if (next.msg_ActionInfo.has()) {
                    bArr = next.msg_ActionInfo.get().bytes_buf.get().toByteArray();
                }
                actionInfo2.vServiceInfo = bArr;
                if (next.uint32_batchID.has()) {
                    i19 = next.uint32_batchID.get();
                } else {
                    i19 = 0;
                }
                nFCNotify.uint32_batchID = i19;
                if (next.uint32_groupflag.has()) {
                    i26 = next.uint32_groupflag.get();
                } else {
                    i26 = 0;
                }
                nFCNotify.uint32_groupflag = i26;
                nFCNotify.bool_file_assist = next.bool_file_assist.get();
                arrayList.add(nFCNotify);
                if (QLog.isColorLevel()) {
                    QLog.d(sTagName, 2, "onFileComing0x211_0xa_0x2, \u8fd1\u573a\u4fe1\u4ee4[" + z16 + "]; sessionid[" + nFCNotify.uint64_sessionid + "]; curindex[" + nFCNotify.uint32_group_curindex + "]; group_id[" + nFCNotify.uint32_group_id + "]; group_size[" + nFCNotify.uint32_group_size + "]; batchID[" + nFCNotify.uint32_batchID + "]; groupflag[" + nFCNotify.uint32_groupflag + "]; file_name[" + nFCNotify.str_file_name + "]; file_len[" + nFCNotify.uint64_file_len + "];");
                }
            }
        }
        MsgCSBody0x211_0x7 msgCSBody0x211_0x72 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        int i28 = msgCSBody0x211_0x72.uMsgSubCmd;
        if (i28 == 10) {
            msgCSBody0x211_0x72.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = (NFCNotify[]) arrayList.toArray(new NFCNotify[arrayList.size()]);
        } else if (i28 == 2) {
            msgCSBody0x211_0x72.pMsgBody0x211_0x7_0x2_NFCNotifySrc = (NFCNotify[]) arrayList.toArray(new NFCNotify[arrayList.size()]);
        }
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromNFCNotify_0x210(long j3, long j16, long j17, String str, long j18, byte[] bArr, long j19, long j26, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3, int i16, int i17, int i18, long j27, long j28, long j29, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str, Long.valueOf(j18), bArr, Long.valueOf(j19), Long.valueOf(j26), bArr2, bArr3, bArr4, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j27), Long.valueOf(j28), Long.valueOf(j29), Boolean.valueOf(z16));
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
        ArrayList arrayList = new ArrayList();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = bArr4 == null ? 10 : 2;
        NFCNotify nFCNotify = new NFCNotify();
        nFCNotify.uint64_sessionid = j3;
        nFCNotify.str_file_name = str;
        nFCNotify.bytes_file_md5 = bArr;
        nFCNotify.fixed32_ip = (int) j19;
        nFCNotify.uint32_port = (int) j26;
        nFCNotify.bytes_url_notify = bArr2;
        nFCNotify.bytes_tokenkey = bArr3;
        nFCNotify.uint64_file_len = j18;
        nFCNotify.bytes_originfile_md5 = bArr4;
        nFCNotify.uint32_originfiletype = (int) j16;
        nFCNotify.uint32_group_id = i3;
        nFCNotify.uint32_group_size = i16;
        nFCNotify.uint32_group_curindex = i17;
        nFCNotify.uint32_batchID = i18;
        nFCNotify.msg_ActionInfo = new ActionInfo();
        arrayList.add(nFCNotify);
        MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        int i19 = msgCSBody0x211_0x7.uMsgSubCmd;
        if (i19 == 10) {
            msgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = (NFCNotify[]) arrayList.toArray(new NFCNotify[arrayList.size()]);
        } else if (i19 == 2) {
            msgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = (NFCNotify[]) arrayList.toArray(new NFCNotify[arrayList.size()]);
        }
        return msgCSBody;
    }

    public MsgCSBody MsgCSBodyFromRFCInfoNotify(int i3, SubMsgType0x7$MsgBody.MsgHeader msgHeader, List<SubMsgType0x7$MsgBody.RNFCNotify> list) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (MsgCSBody) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), msgHeader, list);
        }
        MsgCSBody msgCSBody = new MsgCSBody();
        msgCSBody.uMsgTime = i3;
        msgCSBody.uMsgType = 529;
        MsgCSBody0x211 msgCSBody0x211 = new MsgCSBody0x211();
        msgCSBody.msgBody0x211 = msgCSBody0x211;
        msgCSBody0x211.uMsgSubType = 7;
        msgCSBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = msgHeader.uint32_src_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = msgHeader.uint32_src_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = msgHeader.uint32_dst_app_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = msgHeader.uint32_dst_inst_id.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = msgHeader.uint64_dst_uin.get();
        MsgHeader msgHeader2 = msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
        if (msgHeader.uint64_src_uin.has()) {
            j3 = msgHeader.uint64_src_uin.get();
        } else {
            j3 = 0;
        }
        msgHeader2.uint64_src_uin = j3;
        MsgCSBody0x211_0x7 msgCSBody0x211_0x7 = msgCSBody.msgBody0x211.msgBody0x211_0x7;
        MsgHeader msgHeader3 = msgCSBody0x211_0x7.msgHeader;
        msgHeader3.uint32_dst_uin_type = 0;
        msgCSBody0x211_0x7.uMsgSubCmd = 8;
        msgHeader3.uint32_dst_ter_type = msgHeader.uint32_dst_ter_type.get();
        msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = msgHeader.uint32_src_ter_type.get();
        ArrayList arrayList = new ArrayList();
        for (SubMsgType0x7$MsgBody.RNFCNotify rNFCNotify : list) {
            long GenSessionIdFromDev = GenSessionIdFromDev(rNFCNotify.uint64_sessionid.get(), msgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
            RFCInfoNotify rFCInfoNotify = new RFCInfoNotify();
            rFCInfoNotify.uSessionId = GenSessionIdFromDev;
            rFCInfoNotify.uServerIp = rNFCNotify.fixed32_ip.get();
            rFCInfoNotify.uSvrPort = rNFCNotify.uint32_port.get();
            rFCInfoNotify.vTokenKey = rNFCNotify.bytes_token.get().toByteArray();
            rFCInfoNotify.uSvrTaskId = rNFCNotify.uint64_svrTaskId.get();
            rFCInfoNotify.bool_file_assist = rNFCNotify.bool_file_assist.get();
            arrayList.add(rFCInfoNotify);
        }
        msgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy = (RFCInfoNotify[]) arrayList.toArray(new RFCInfoNotify[arrayList.size()]);
        return msgCSBody;
    }

    public void fillMsgHeader(SubMsgType0x7$MsgBody.MsgHeader msgHeader, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            fillMsgHeader(msgHeader, j3, GetSelfUin());
        } else {
            iPatchRedirector.redirect((short) 4, this, msgHeader, Long.valueOf(j3));
        }
    }

    public void fillService(Session session, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, session, str, bArr);
            return;
        }
        if (session != null && str != null && str.length() > 0) {
            ActionInfo actionInfo = new ActionInfo();
            session.actionInfo = actionInfo;
            actionInfo.strServiceName = str;
            actionInfo.vServiceInfo = bArr;
        }
    }

    public Session genSession(DataLineMsgRecord dataLineMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Session) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dataLineMsgRecord);
        }
        Session genSession = genSession(dataLineMsgRecord.fileFrom, dataLineMsgRecord.path, dataLineMsgRecord.thumbPath, dataLineMsgRecord.filename, DataLineHandler.D4(dataLineMsgRecord.msgtype), 0, dataLineMsgRecord.sessionid, dataLineMsgRecord.groupId, dataLineMsgRecord.groupSize, dataLineMsgRecord.groupIndex);
        if (genSession != null) {
            genSession.uFileSizeSrc = dataLineMsgRecord.filesize;
            String str = dataLineMsgRecord.fileUuid;
            if (str != null) {
                genSession.vOfflineFileUUID = str.getBytes();
            }
            byte[] bArr = dataLineMsgRecord.md5;
            if (bArr != null) {
                genSession.vFileMD5Src = bArr;
            }
            genSession.uOwnerUin = dataLineMsgRecord.uOwnerUin;
        }
        return genSession;
    }

    boolean isMyNotify(SubMsgType0x7$MsgBody.ActionInfo actionInfo, String str) {
        if (actionInfo.str_service_name.has()) {
            String str2 = actionInfo.str_service_name.get();
            if (str2.length() > 0 && str2.compareToIgnoreCase(str) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public SubMsgType0x7$MsgBody msgBodyFromFTNNotify(FTNNotify fTNNotify, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 19, this, fTNNotify, Long.valueOf(j3), Integer.valueOf(i3));
        }
        String str = fTNNotify.str_file_name;
        String FixImageFileExtName = FixImageFileExtName(str, str, fTNNotify.uint32_originfiletype, false);
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(i3);
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3, DataLineMsgRecord.getDevTypeBySeId(fTNNotify.uint64_sessionid));
        SubMsgType0x7$MsgBody.FTNNotify fTNNotify2 = new SubMsgType0x7$MsgBody.FTNNotify();
        fTNNotify2.uint64_sessionid.set(fTNNotify.uint64_sessionid);
        fTNNotify2.str_file_name.set(FixImageFileExtName);
        fTNNotify2.str_file_index.set(fTNNotify.str_file_index);
        byte[] bArr = fTNNotify.bytes_file_md5;
        if (bArr != null) {
            fTNNotify2.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        fTNNotify2.uint64_file_len.set(fTNNotify.uint64_file_len);
        byte[] bArr2 = fTNNotify.bytes_originfile_md5;
        if (bArr2 != null) {
            fTNNotify2.bytes_originfile_md5.set(ByteStringMicro.copyFrom(bArr2));
        }
        fTNNotify2.uint32_originfiletype.set(fTNNotify.uint32_originfiletype);
        fTNNotify2.uint32_batchID.set(fTNNotify.uint32_batchID);
        if (fTNNotify.uint32_group_size > 1) {
            fTNNotify2.uint32_group_id.set(fTNNotify.uint32_group_id);
            fTNNotify2.uint32_group_size.set(fTNNotify.uint32_group_size);
            fTNNotify2.uint32_group_curindex.set(fTNNotify.uint32_group_curindex);
            fTNNotify2.uint32_groupflag.set(fTNNotify.uint32_groupflag);
        }
        SubMsgType0x7$MsgBody.ActionInfo actionInfo = new SubMsgType0x7$MsgBody.ActionInfo();
        actionInfo.str_service_name.set(fTNNotify.msg_ActionInfo.strServiceName);
        byte[] bArr3 = fTNNotify.msg_ActionInfo.vServiceInfo;
        if (bArr3 != null) {
            actionInfo.bytes_buf.set(ByteStringMicro.copyFrom(bArr3));
        }
        actionInfo.setHasFlag(true);
        fTNNotify2.msg_ActionInfo.set(actionInfo);
        fTNNotify2.setHasFlag(true);
        if (1 == i3) {
            subMsgType0x7$MsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(fTNNotify2);
        } else {
            subMsgType0x7$MsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.add(fTNNotify2);
        }
        subMsgType0x7$MsgBody.setHasFlag(true);
        return subMsgType0x7$MsgBody;
    }

    public SubMsgType0x7$MsgBody msgBodyFromFileControl(FileControl fileControl, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 20, this, fileControl, Long.valueOf(j3), Integer.valueOf(i3));
        }
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(i3);
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3, DataLineMsgRecord.getDevTypeBySeId(fileControl.uint64_sessionid));
        SubMsgType0x7$MsgBody.FileControl fileControl2 = new SubMsgType0x7$MsgBody.FileControl();
        fileControl2.uint64_sessionid.set(fileControl.uint64_sessionid);
        fileControl2.uint32_operate.set(fileControl.uint32_operate);
        fileControl2.uint32_seq.set(fileControl.uint32_seq);
        fileControl2.uint32_group_id.set(fileControl.uint32_group_id);
        fileControl2.uint32_batchID.set(fileControl.uint32_batchID);
        String str = fileControl.str_msg;
        if (str != null && str.length() != 0) {
            fileControl2.str_msg.set(fileControl.str_msg);
        }
        fileControl2.setHasFlag(true);
        subMsgType0x7$MsgBody.rpt_msg_subcmd_0x3_filecontrol.add(fileControl2);
        subMsgType0x7$MsgBody.setHasFlag(true);
        return subMsgType0x7$MsgBody;
    }

    public SubMsgType0x7$MsgBody msgBodyFromNFCNotify(NFCNotify nFCNotify, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 17, this, nFCNotify, Long.valueOf(j3), Integer.valueOf(i3));
        }
        String str = nFCNotify.str_file_name;
        int i16 = nFCNotify.uint32_originfiletype;
        if (nFCNotify.bytes_originfile_md5 == null) {
            z16 = true;
        }
        String FixImageFileExtName = FixImageFileExtName(str, str, i16, z16);
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(nFCNotify.uint64_sessionid);
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(i3);
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3, devTypeBySeId);
        SubMsgType0x7$MsgBody.NFCNotify nFCNotify2 = new SubMsgType0x7$MsgBody.NFCNotify();
        nFCNotify2.uint64_sessionid.set(nFCNotify.uint64_sessionid);
        nFCNotify2.str_file_name.set(FixImageFileExtName);
        byte[] bArr = nFCNotify.bytes_file_md5;
        if (bArr != null) {
            nFCNotify2.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        nFCNotify2.fixed32_ip.set(nFCNotify.fixed32_ip);
        nFCNotify2.uint32_port.set(nFCNotify.uint32_port);
        nFCNotify2.bytes_url_notify.set(ByteStringMicro.copyFrom(nFCNotify.bytes_url_notify));
        nFCNotify2.bytes_tokenkey.set(ByteStringMicro.copyFrom("1234567890123456".getBytes()));
        nFCNotify2.uint64_file_len.set(nFCNotify.uint64_file_len);
        byte[] bArr2 = nFCNotify.bytes_originfile_md5;
        if (bArr2 != null) {
            nFCNotify2.bytes_originfile_md5.set(ByteStringMicro.copyFrom(bArr2));
        }
        nFCNotify2.uint32_originfiletype.set(nFCNotify.uint32_originfiletype);
        nFCNotify2.uint32_batchID.set(nFCNotify.uint32_batchID);
        if (nFCNotify.uint32_group_size > 1) {
            nFCNotify2.uint32_group_id.set(nFCNotify.uint32_group_id);
            nFCNotify2.uint32_group_size.set(nFCNotify.uint32_group_size);
            nFCNotify2.uint32_group_curindex.set(nFCNotify.uint32_group_curindex);
            nFCNotify2.uint32_groupflag.set(nFCNotify.uint32_groupflag);
        }
        SubMsgType0x7$MsgBody.ActionInfo actionInfo = new SubMsgType0x7$MsgBody.ActionInfo();
        actionInfo.str_service_name.set(nFCNotify.msg_ActionInfo.strServiceName);
        byte[] bArr3 = nFCNotify.msg_ActionInfo.vServiceInfo;
        if (bArr3 != null) {
            actionInfo.bytes_buf.set(ByteStringMicro.copyFrom(bArr3));
        }
        actionInfo.setHasFlag(true);
        nFCNotify2.msg_ActionInfo.set(actionInfo);
        nFCNotify2.bool_file_assist.set(nFCNotify.bool_file_assist);
        nFCNotify2.setHasFlag(true);
        if (2 == i3) {
            subMsgType0x7$MsgBody.rpt_msg_subcmd_0x2_nfc_notify.add(nFCNotify2);
        } else {
            subMsgType0x7$MsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.add(nFCNotify2);
        }
        subMsgType0x7$MsgBody.setHasFlag(true);
        return subMsgType0x7$MsgBody;
    }

    public SubMsgType0x7$MsgBody msgBodyFromRFCInfoNotify(RFCInfoNotify rFCInfoNotify, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 18, this, rFCInfoNotify, Long.valueOf(j3), Integer.valueOf(i3));
        }
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3, DataLineMsgRecord.getDevTypeBySeId(rFCInfoNotify.uSessionId));
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(i3);
        SubMsgType0x7$MsgBody.RNFCNotify rNFCNotify = new SubMsgType0x7$MsgBody.RNFCNotify();
        rNFCNotify.uint64_sessionid.set(rFCInfoNotify.uSessionId);
        rNFCNotify.bytes_token.set(ByteStringMicro.copyFrom(rFCInfoNotify.vTokenKey));
        rNFCNotify.fixed32_ip.set(rFCInfoNotify.uServerIp);
        rNFCNotify.uint32_port.set(rFCInfoNotify.uSvrPort);
        rNFCNotify.uint64_svrTaskId.set(rFCInfoNotify.uSvrTaskId);
        rNFCNotify.bool_file_assist.set(rFCInfoNotify.bool_file_assist);
        subMsgType0x7$MsgBody.rpt_msg_subcmd_0x8_rnfc_notify.add(rNFCNotify);
        return subMsgType0x7$MsgBody;
    }

    public MsgHeader msgHeader(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? msgHeader(j3, 0) : (MsgHeader) iPatchRedirector.redirect((short) 6, (Object) this, j3);
    }

    public void showFileIsEmptyDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            com.tencent.mobileqq.filemanager.util.d.f("'" + str + "'" + BaseApplication.getContext().getResources().getString(R.string.c3s));
            return;
        }
        new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.ProtocolHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f119779d;

            {
                this.f119779d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProtocolHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.filemanager.util.d.f("'" + this.f119779d + "'" + BaseApplication.getContext().getResources().getString(R.string.c3s));
            }
        });
    }

    public void showFileNotExistDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            com.tencent.mobileqq.filemanager.util.d.f("'" + str + "'" + BaseApplication.getContext().getResources().getString(R.string.c3w));
            return;
        }
        new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.ProtocolHelper.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f119781d;

            {
                this.f119781d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProtocolHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.filemanager.util.d.f("'" + this.f119781d + "'" + BaseApplication.getContext().getResources().getString(R.string.c3w));
            }
        });
    }

    public void showFileTooLargeDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            com.tencent.mobileqq.filemanager.util.d.f("'" + str + "'" + BaseApplication.getContext().getResources().getString(R.string.c3u));
            return;
        }
        new Handler(mainLooper).post(new Runnable(str) { // from class: com.tencent.litetransfersdk.ProtocolHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f119780d;

            {
                this.f119780d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProtocolHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.filemanager.util.d.f("'" + this.f119780d + "'" + BaseApplication.getContext().getResources().getString(R.string.c3u));
            }
        });
    }

    public void showNoNetworkDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.c4w);
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.litetransfersdk.ProtocolHelper.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProtocolHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.c4w);
                    }
                }
            });
        }
    }

    public void showQQIsOfflineDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.c4v);
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.litetransfersdk.ProtocolHelper.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProtocolHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.c4v);
                    }
                }
            });
        }
    }

    public void fillMsgHeader(SubMsgType0x7$MsgBody.MsgHeader msgHeader, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            fillMsgHeader(msgHeader, j3, GetSelfUin(), i3);
        } else {
            iPatchRedirector.redirect((short) 5, this, msgHeader, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public MsgHeader msgHeader(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MsgHeader) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        int f16 = AppSetting.f();
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.uint32_src_app_id = 1001;
        msgHeader.uint32_src_inst_id = f16;
        msgHeader.uint64_dst_uin = j3;
        msgHeader.uint64_src_uin = GetSelfUin();
        GetTypeInfo(i3);
        msgHeader.uint32_dst_ter_type = mDstType;
        msgHeader.uint32_dst_app_id = mDstAppId;
        msgHeader.uint32_dst_inst_id = mDstInstId;
        msgHeader.uint32_src_ter_type = 2;
        return msgHeader;
    }

    public static void fillMsgHeader(SubMsgType0x7$MsgBody.MsgHeader msgHeader, long j3, long j16) {
        fillMsgHeader(msgHeader, j3, j16, 0);
    }

    public static void fillMsgHeader(SubMsgType0x7$MsgBody.MsgHeader msgHeader, long j3, long j16, int i3) {
        int f16 = AppSetting.f();
        msgHeader.uint32_src_app_id.set(1001);
        msgHeader.uint32_src_inst_id.set(f16);
        msgHeader.uint64_dst_uin.set(j3);
        msgHeader.uint64_src_uin.set(j16);
        GetTypeInfo(i3);
        msgHeader.uint32_dst_ter_type.set(mDstType);
        msgHeader.uint32_dst_app_id.set(mDstAppId);
        msgHeader.uint32_dst_inst_id.set(mDstInstId);
        if (AppSetting.p(BaseApplication.getContext())) {
            msgHeader.uint32_src_ter_type.set(3);
        } else {
            msgHeader.uint32_src_ter_type.set(2);
        }
        msgHeader.setHasFlag(true);
    }

    public boolean CheckActionInfo(SubMsgType0x7$MsgBody.NFCNotify nFCNotify, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) nFCNotify, (Object) str)).booleanValue();
        }
        if (nFCNotify.msg_ActionInfo.has()) {
            return isMyNotify(nFCNotify.msg_ActionInfo.get(), str);
        }
        return false;
    }

    public Session genSession(int i3, String str, String str2, int i16, int i17, long j3, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? genSession(i3, str, str2, null, i16, i17, j3, i18, i19, i26) : (Session) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
    }

    public Session genSession(int i3, String str, String str2, String str3, int i16, int i17, long j3, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Session) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
        if (QLog.isColorLevel()) {
            QLog.d(sTagName, 2, "--->>sendFile sPath[" + str + "], sPathThumb[" + str2 + "], type[" + i16 + "], fileFrom[" + i3);
        }
        if (i3 == 0 && str != null && !str.equals("")) {
            File file = new File(str);
            if (!file.exists()) {
                showFileNotExistDialog(str3);
                return null;
            }
            if (file.length() == 0) {
                showFileIsEmptyDialog(str3);
                return null;
            }
            if (!h.o() && file.length() > 2147483648L) {
                showFileTooLargeDialog(str3);
                return null;
            }
        }
        Session session = new Session();
        session.uFileSizeSrc = FileManagerUtil.getFileSizes(str);
        session.uSessionID = j3;
        session.emFileFrom = i3;
        session.bSend = true;
        session.emFileType = i16;
        session.uChannelType = i17;
        session.dwGroupID = i18;
        session.dwGroupSize = i19;
        session.dwGroupIndex = i26;
        session.pFileBuffer = null;
        session.strFilePathSrc = str;
        session.strFilePathThumb = str2;
        session.strFileNameSrc = str3;
        return session;
    }

    public SubMsgType0x7$MsgBody MsgBodyFromMpFileNotify(long j3, long j16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SubMsgType0x7$MsgBody) iPatchRedirector.redirect((short) 28, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), str);
        }
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(11);
        fillMsgHeader(subMsgType0x7$MsgBody.msg_header, j3);
        SubMsgType0x7$MsgBody.MpFileNotify mpFileNotify = new SubMsgType0x7$MsgBody.MpFileNotify();
        mpFileNotify.uint64_sessionid.set(j16);
        mpFileNotify.uint32_operate.set(i3);
        mpFileNotify.uint32_type.set(1);
        mpFileNotify.uint32_power.set(3);
        mpFileNotify.uint32_operate.set(i3);
        JSONObject jSONObject = new JSONObject();
        if (i3 == 2 || i3 == 4) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("nonce", str);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        jSONObject.put("apn", AppNetConnInfo.getCurrentAPN());
        String jSONObject2 = jSONObject.toString();
        if (jSONObject2 != null) {
            mpFileNotify.bytes_json.set(ByteStringMicro.copyFrom(jSONObject2.getBytes()));
        }
        mpFileNotify.setHasFlag(true);
        subMsgType0x7$MsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(mpFileNotify);
        subMsgType0x7$MsgBody.setHasFlag(true);
        return subMsgType0x7$MsgBody;
    }
}
