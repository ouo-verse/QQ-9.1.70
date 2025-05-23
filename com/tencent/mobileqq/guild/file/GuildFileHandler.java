package com.tencent.mobileqq.guild.file;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ApplyDownloadReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ApplyDownloadRsp;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ApplyUploadReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ApplyUploadRsp;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ChannelInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$DownloadInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$FileInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ReqBody;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$RspBody;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$UploadCompletedReq;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFileHandler extends BusinessHandler implements g {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Integer, i> f224345d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, j> f224346e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, f> f224347f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Integer, h> f224348h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Integer, h> f224349i;

    public GuildFileHandler(AppInterface appInterface) {
        super(appInterface);
        this.f224345d = new HashMap<>();
        this.f224346e = new HashMap<>();
        this.f224347f = new HashMap<>();
        this.f224348h = new HashMap<>();
        this.f224349i = new HashMap<>();
    }

    private void D2(int i3, f fVar, boolean z16, p pVar) {
        if (fVar != null && pVar != null) {
            fVar.a(z16, pVar);
        }
        if (this.f224347f.containsKey(Integer.valueOf(i3))) {
            this.f224347f.remove(Integer.valueOf(i3));
        }
    }

    private void E2(int i3, boolean z16, h hVar, q qVar) {
        if (hVar != null) {
            hVar.a(z16, qVar);
        }
        this.f224349i.remove(Integer.valueOf(i3));
    }

    private void F2(int i3, boolean z16, h hVar, q qVar) {
        if (hVar != null) {
            hVar.a(z16, qVar);
        }
        this.f224348h.remove(Integer.valueOf(i3));
    }

    private void G2(int i3, i iVar, boolean z16, s sVar) {
        iVar.c(z16, sVar);
        this.f224345d.remove(Integer.valueOf(i3));
    }

    private void H2(int i3, j jVar, boolean z16, u uVar) {
        jVar.g(z16, uVar);
        this.f224346e.remove(Integer.valueOf(i3));
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("seq");
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        boolean z16 = true;
        if (this.f224347f.containsKey(Integer.valueOf(i3)) && this.f224347f.get(Integer.valueOf(i3)) != null) {
            f fVar = this.f224347f.get(Integer.valueOf(i3));
            if (obj == null) {
                D2(i3, fVar, false, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                int i16 = mergeFrom.uint32_result.get();
                if (i16 != 0) {
                    QLog.i("GuildFileHandler", 1, "handleDownloadFileRequest err! resultCode = " + i16);
                    M2(i16, mergeFrom.str_error_msg.get());
                    D2(i3, fVar, false, null);
                    return;
                }
                oidb_0xfc2$RspBody oidb_0xfc2_rspbody = new oidb_0xfc2$RspBody();
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xfc2_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.i("GuildFileHandler", 2, e16.toString());
                        D2(i3, fVar, false, null);
                        return;
                    }
                }
                p pVar = new p();
                pVar.m(string);
                pVar.e(string2);
                pVar.q(mergeFrom.uint32_result.get());
                pVar.r(mergeFrom.str_error_msg.get());
                pVar.d(oidb_0xfc2_rspbody.msg_bus_type.get());
                oidb_0xfc2$ApplyDownloadRsp oidb_0xfc2_applydownloadrsp = oidb_0xfc2_rspbody.msg_apply_download_rsp.get();
                pVar.j(oidb_0xfc2_applydownloadrsp.msg_file_info.str_fileid.get());
                pVar.h(ByteStringMicro.copyFrom(oidb_0xfc2_applydownloadrsp.msg_download_info.bytes_download_key.get().toByteArray()));
                pVar.l(oidb_0xfc2_applydownloadrsp.msg_file_info.uint64_size.get());
                pVar.k(oidb_0xfc2_applydownloadrsp.msg_file_info.str_name.get());
                pVar.o(oidb_0xfc2_applydownloadrsp.msg_download_info.msg_out_addr.get());
                pVar.n(oidb_0xfc2_applydownloadrsp.msg_download_info.msg_inner_addr.get());
                pVar.p(oidb_0xfc2_applydownloadrsp.msg_download_info.msg_out_addr_ipv6.get());
                pVar.g(oidb_0xfc2_applydownloadrsp.msg_download_info.str_download_domain.get());
                pVar.i(oidb_0xfc2_applydownloadrsp.msg_download_info.str_download_url.get());
                pVar.f(oidb_0xfc2_applydownloadrsp.msg_download_info.str_cookie.get());
                try {
                    pVar.s(new String(oidb_0xfc2_applydownloadrsp.msg_file_info.bytes_md5.get().toByteArray(), "utf-8"));
                } catch (Exception unused) {
                    QLog.e("GuildFileHandler", 1, "downloadFileRspInfo getMd5 failed");
                    pVar.s("");
                }
                if (pVar.c() != 0) {
                    z16 = false;
                }
                D2(i3, fVar, z16, pVar);
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFileHandler", 2, "handleDownloadFileRequest. guildId: " + string + ", channelId: " + string2 + ", oidb_sso parseFrom byte " + e17.toString());
                }
                e17.printStackTrace();
                D2(i3, fVar, false, null);
                return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handleDownloadFileRequest seq not find seq = " + i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        if (r2.equals("sub_cmd_preview_image_thumb_request") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        char c16 = 1;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("sub_cmd");
            QLog.i("GuildFileHandler", 1, "handleGuildFile0XFC2_0Request subCmd =" + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            string.hashCode();
            switch (string.hashCode()) {
                case -1406441274:
                    if (string.equals("sub_cmd_upload_file_request")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1203026233:
                    break;
                case -921257497:
                    if (string.equals("sub_cmd_preview_video_thumb_request")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -697887301:
                    if (string.equals("sub_cmd_upload_file_succ_request")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 452858527:
                    if (string.equals("sub_cmd_download_file_request")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    N2(toServiceMsg, fromServiceMsg, obj);
                    return;
                case 1:
                    K2(toServiceMsg, fromServiceMsg, obj);
                    return;
                case 2:
                    L2(toServiceMsg, fromServiceMsg, obj);
                    return;
                case 3:
                    O2(toServiceMsg, fromServiceMsg, obj);
                    return;
                case 4:
                    I2(toServiceMsg, fromServiceMsg, obj);
                    return;
                default:
                    return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handleGuildFile0XFC2_0Request req == null || res == null");
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("seq");
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        boolean z16 = true;
        if (this.f224349i.containsKey(Integer.valueOf(i3)) && this.f224349i.get(Integer.valueOf(i3)) != null) {
            h hVar = this.f224349i.get(Integer.valueOf(i3));
            if (obj == null) {
                E2(i3, false, hVar, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                int i16 = mergeFrom.uint32_result.get();
                if (i16 != 0) {
                    QLog.i("GuildFileHandler", 1, "handlePreviewImageThumbRequest err! resultCode = " + i16);
                    E2(i3, false, hVar, null);
                    return;
                }
                oidb_0xfc2$RspBody oidb_0xfc2_rspbody = new oidb_0xfc2$RspBody();
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xfc2_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.i("GuildFileHandler", 2, e16.toString());
                        F2(i3, false, hVar, null);
                        return;
                    }
                }
                q qVar = new q();
                qVar.g(string);
                qVar.b(string2);
                qVar.k(mergeFrom.uint32_result.get());
                qVar.l(mergeFrom.str_error_msg.get());
                qVar.a(oidb_0xfc2_rspbody.msg_bus_type.get());
                oidb_0xfc2$DownloadInfo oidb_0xfc2_downloadinfo = oidb_0xfc2_rspbody.msg_apply_preview_rsp.get().msg_download_info.get();
                qVar.e(ByteStringMicro.copyFrom(oidb_0xfc2_downloadinfo.bytes_download_key.get().toByteArray()));
                qVar.i(oidb_0xfc2_downloadinfo.msg_out_addr.get());
                qVar.h(oidb_0xfc2_downloadinfo.msg_inner_addr.get());
                qVar.j(oidb_0xfc2_downloadinfo.msg_out_addr_ipv6.get());
                qVar.d(oidb_0xfc2_downloadinfo.str_download_domain.get());
                qVar.f(oidb_0xfc2_downloadinfo.str_download_url.get());
                qVar.c(oidb_0xfc2_downloadinfo.str_cookie.get());
                if (i16 != 0) {
                    z16 = false;
                }
                E2(i3, z16, hVar, qVar);
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFileHandler", 2, "handlePreviewVideoThumbRequest. guildId: " + string + ", channelId: " + string2 + ", oidb_sso parseFrom byte " + e17.toString());
                }
                e17.printStackTrace();
                E2(i3, false, hVar, null);
                return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handlePreviewVideoThumbRequest seq not find seq = " + i3);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("seq");
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        boolean z16 = true;
        if (this.f224348h.containsKey(Integer.valueOf(i3)) && this.f224348h.get(Integer.valueOf(i3)) != null) {
            h hVar = this.f224348h.get(Integer.valueOf(i3));
            if (obj == null) {
                F2(i3, false, hVar, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                int i16 = mergeFrom.uint32_result.get();
                if (i16 != 0) {
                    QLog.i("GuildFileHandler", 1, "handlePreviewVideoThumbRequest err! resultCode = " + i16);
                    F2(i3, false, hVar, null);
                    return;
                }
                oidb_0xfc2$RspBody oidb_0xfc2_rspbody = new oidb_0xfc2$RspBody();
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xfc2_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.i("GuildFileHandler", 2, e16.toString());
                        F2(i3, false, hVar, null);
                        return;
                    }
                }
                q qVar = new q();
                qVar.g(string);
                qVar.b(string2);
                qVar.k(mergeFrom.uint32_result.get());
                qVar.l(mergeFrom.str_error_msg.get());
                qVar.a(oidb_0xfc2_rspbody.msg_bus_type.get());
                oidb_0xfc2$DownloadInfo oidb_0xfc2_downloadinfo = oidb_0xfc2_rspbody.msg_apply_preview_rsp.get().msg_download_info.get();
                qVar.e(ByteStringMicro.copyFrom(oidb_0xfc2_downloadinfo.bytes_download_key.get().toByteArray()));
                qVar.i(oidb_0xfc2_downloadinfo.msg_out_addr.get());
                qVar.h(oidb_0xfc2_downloadinfo.msg_inner_addr.get());
                qVar.j(oidb_0xfc2_downloadinfo.msg_out_addr_ipv6.get());
                qVar.d(oidb_0xfc2_downloadinfo.str_download_domain.get());
                qVar.f(oidb_0xfc2_downloadinfo.str_download_url.get());
                qVar.c(oidb_0xfc2_downloadinfo.str_cookie.get());
                if (i16 != 0) {
                    z16 = false;
                }
                F2(i3, z16, hVar, qVar);
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFileHandler", 2, "handlePreviewVideoThumbRequest. guildId: " + string + ", channelId: " + string2 + ", oidb_sso parseFrom byte " + e17.toString());
                }
                e17.printStackTrace();
                F2(i3, false, hVar, null);
                return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handlePreviewVideoThumbRequest seq not find seq = " + i3);
    }

    private void M2(int i3, final String str) {
        if (i3 != 0 && !TextUtils.isEmpty(str)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.file.GuildFileHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    Context applicationContext = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext();
                    if (applicationContext != null) {
                        QQToast.makeText(applicationContext, 1, str, 0).show();
                    }
                }
            });
        }
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("seq");
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        boolean z16 = true;
        if (this.f224345d.containsKey(Integer.valueOf(i3)) && this.f224345d.get(Integer.valueOf(i3)) != null) {
            i iVar = this.f224345d.get(Integer.valueOf(i3));
            if (obj == null) {
                G2(i3, iVar, false, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                s sVar = new s();
                int i16 = mergeFrom.uint32_result.get();
                sVar.r(i16);
                sVar.s(mergeFrom.str_error_msg.get());
                if (i16 != 0) {
                    QLog.i("GuildFileHandler", 1, "handleUploadFileRequest err! resultCode = " + i16);
                    M2(i16, mergeFrom.str_error_msg.get());
                    G2(i3, iVar, false, sVar);
                    return;
                }
                oidb_0xfc2$RspBody oidb_0xfc2_rspbody = new oidb_0xfc2$RspBody();
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xfc2_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.i("GuildFileHandler", 2, e16.toString());
                        G2(i3, iVar, false, null);
                        return;
                    }
                }
                sVar.m(string);
                sVar.j(string2);
                sVar.h(oidb_0xfc2_rspbody.msg_bus_type.get());
                oidb_0xfc2$ApplyUploadRsp oidb_0xfc2_applyuploadrsp = oidb_0xfc2_rspbody.msg_apply_upload_rsp.get();
                sVar.l(oidb_0xfc2_applyuploadrsp.str_fileid.get());
                sVar.i(oidb_0xfc2_applyuploadrsp.bytes_upload_key.get().toByteArray());
                sVar.k(oidb_0xfc2_applyuploadrsp.bool_file_exist.get());
                sVar.q(oidb_0xfc2_applyuploadrsp.uint32_pack_size.get());
                sVar.t(oidb_0xfc2_applyuploadrsp.str_upload_domain.get());
                sVar.o(oidb_0xfc2_applyuploadrsp.msg_out_addr.get());
                sVar.n(oidb_0xfc2_applyuploadrsp.msg_out_addr.get());
                sVar.p(oidb_0xfc2_applyuploadrsp.msg_out_addr_ipv6.get());
                if (sVar.e() != 0) {
                    z16 = false;
                }
                G2(i3, iVar, z16, sVar);
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFileHandler", 2, "handleSendFileRequest. guildId: " + string + ", channelId: " + string2 + ", oidb_sso parseFrom byte " + e17.toString());
                }
                e17.printStackTrace();
                G2(i3, iVar, false, null);
                return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handleUploadFileRequest seq not find seq = " + i3);
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3 = toServiceMsg.extraData.getInt("seq");
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        boolean z16 = true;
        if (this.f224346e.containsKey(Integer.valueOf(i3)) && this.f224346e.get(Integer.valueOf(i3)) != null) {
            j jVar = this.f224346e.get(Integer.valueOf(i3));
            if (obj == null) {
                H2(i3, jVar, false, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                int i16 = mergeFrom.uint32_result.get();
                String str = mergeFrom.str_error_msg.get();
                u uVar = new u();
                uVar.l(string);
                uVar.e(string2);
                uVar.m(i16);
                uVar.o(str);
                if (i16 != 0) {
                    QLog.i("GuildFileHandler", 1, "handleUploadFileSuccRequest err! resultCode = " + i16);
                    H2(i3, jVar, false, uVar);
                    return;
                }
                oidb_0xfc2$RspBody oidb_0xfc2_rspbody = new oidb_0xfc2$RspBody();
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xfc2_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.i("GuildFileHandler", 2, e16.toString());
                        H2(i3, jVar, false, null);
                        return;
                    }
                }
                uVar.d(oidb_0xfc2_rspbody.msg_bus_type.get());
                oidb_0xfc2$FileInfo oidb_0xfc2_fileinfo = oidb_0xfc2_rspbody.msg_upload_completed_rsp.get().msg_file_info.get();
                uVar.g(oidb_0xfc2_fileinfo.str_fileid.get());
                uVar.i(oidb_0xfc2_fileinfo.str_name.get());
                uVar.k(oidb_0xfc2_fileinfo.uint64_size.get());
                uVar.j(oidb_0xfc2_fileinfo.bytes_sha.get().toByteArray());
                uVar.h(oidb_0xfc2_fileinfo.bytes_md5.get().toByteArray());
                uVar.f(oidb_0xfc2_fileinfo.uint32_danger_level.get());
                uVar.p(oidb_0xfc2_fileinfo.int64_upload_time.get());
                uVar.n(oidb_0xfc2_fileinfo.int64_save_time.get());
                if (uVar.b() != 0) {
                    z16 = false;
                }
                H2(i3, jVar, z16, uVar);
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFileHandler", 2, "handleSendFileRequest. guildId: " + string + ", channelId: " + string2 + ", oidb_sso parseFrom byte " + e17.toString());
                }
                e17.printStackTrace();
                H2(i3, jVar, false, null);
                return;
            }
        }
        QLog.e("GuildFileHandler", 1, "handleUploadFileSuccRequest seq not find seq = " + i3);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xfc2_0");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.guild.file.g
    public void n1(r rVar, i iVar) {
        if (rVar == null) {
            return;
        }
        oidb_0xfc2$ReqBody oidb_0xfc2_reqbody = new oidb_0xfc2$ReqBody();
        oidb_0xfc2_reqbody.msg_cmd.set(FSUploadConst.ERR_FILE_NOT_EXIST);
        oidb_0xfc2_reqbody.msg_bus_type.set(rVar.a());
        oidb_0xfc2$ChannelInfo oidb_0xfc2_channelinfo = new oidb_0xfc2$ChannelInfo();
        oidb_0xfc2_channelinfo.uint64_guild_id.set(Long.parseLong(rVar.i()));
        oidb_0xfc2_channelinfo.uint64_channel_id.set(Long.parseLong(rVar.d()));
        oidb_0xfc2_reqbody.msg_channel_info.set(oidb_0xfc2_channelinfo);
        oidb_0xfc2_reqbody.msg_terminal_type.set(2);
        oidb_0xfc2$ApplyUploadReq oidb_0xfc2_applyuploadreq = new oidb_0xfc2$ApplyUploadReq();
        oidb_0xfc2_applyuploadreq.uint64_file_size.set(rVar.h());
        oidb_0xfc2_applyuploadreq.str_file_name.set(rVar.f());
        oidb_0xfc2_applyuploadreq.uint32_content_type.set(rVar.e());
        oidb_0xfc2_applyuploadreq.bytes_md5.set(ByteStringMicro.copyFrom(rVar.b()));
        oidb_0xfc2_applyuploadreq.bytes_sha.set(ByteStringMicro.copyFrom(rVar.c()));
        oidb_0xfc2_reqbody.msg_apply_upload_req.set(oidb_0xfc2_applyuploadreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4034);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xfc2_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putInt("seq", rVar.j());
        createToServiceMsg.extraData.putString("guildId", rVar.i());
        createToServiceMsg.extraData.putString("channelId", rVar.d());
        createToServiceMsg.extraData.putString("sub_cmd", "sub_cmd_upload_file_request");
        this.f224345d.put(Integer.valueOf(rVar.j()), iVar);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        this.f224345d.clear();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                QLog.e("GuildFileHandler", 1, "cmdfilter error=" + serviceCmd);
                return;
            }
            if (serviceCmd.equals("OidbSvcTrpcTcp.0xfc2_0")) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        QLog.e("GuildFileHandler", 1, "onReceive,resp == null or req == null");
    }

    @Override // com.tencent.mobileqq.guild.file.g
    public void q2(o oVar, f fVar) {
        if (oVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(oVar.d()) && !TextUtils.isEmpty(oVar.b())) {
            oidb_0xfc2$ReqBody oidb_0xfc2_reqbody = new oidb_0xfc2$ReqBody();
            oidb_0xfc2_reqbody.msg_cmd.set(1200);
            oidb_0xfc2_reqbody.msg_bus_type.set(oVar.a());
            oidb_0xfc2$ChannelInfo oidb_0xfc2_channelinfo = new oidb_0xfc2$ChannelInfo();
            oidb_0xfc2_channelinfo.uint64_guild_id.set(Long.parseLong(oVar.d()));
            oidb_0xfc2_channelinfo.uint64_channel_id.set(Long.parseLong(oVar.b()));
            oidb_0xfc2_reqbody.msg_channel_info.set(oidb_0xfc2_channelinfo);
            oidb_0xfc2_reqbody.msg_terminal_type.set(2);
            oidb_0xfc2$ApplyDownloadReq oidb_0xfc2_applydownloadreq = new oidb_0xfc2$ApplyDownloadReq();
            oidb_0xfc2_applydownloadreq.str_fileid.set(oVar.c());
            oidb_0xfc2_applydownloadreq.uint32_support_encrypt.set(oVar.f());
            oidb_0xfc2_reqbody.msg_apply_download_req.set(oidb_0xfc2_applydownloadreq);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(4034);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xfc2_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putInt("seq", oVar.e());
            createToServiceMsg.extraData.putString("guildId", oVar.d());
            createToServiceMsg.extraData.putString("channelId", oVar.b());
            createToServiceMsg.extraData.putString("sub_cmd", "sub_cmd_download_file_request");
            this.f224347f.put(Integer.valueOf(oVar.e()), fVar);
            sendPbReq(createToServiceMsg);
            return;
        }
        QLog.i("GuildFileHandler", 1, "downloadFileRequest: err! guildId or channelId is null.");
    }

    @Override // com.tencent.mobileqq.guild.file.g
    public void u2(t tVar, j jVar) {
        if (tVar != null && jVar != null) {
            oidb_0xfc2$ReqBody oidb_0xfc2_reqbody = new oidb_0xfc2$ReqBody();
            oidb_0xfc2_reqbody.msg_cmd.set(800);
            oidb_0xfc2_reqbody.msg_bus_type.set(tVar.a());
            oidb_0xfc2_reqbody.msg_terminal_type.set(2);
            oidb_0xfc2$ChannelInfo oidb_0xfc2_channelinfo = new oidb_0xfc2$ChannelInfo();
            oidb_0xfc2_channelinfo.uint64_guild_id.set(Long.parseLong(tVar.e()));
            oidb_0xfc2_channelinfo.uint64_channel_id.set(Long.parseLong(tVar.c()));
            oidb_0xfc2_reqbody.msg_channel_info.set(oidb_0xfc2_channelinfo);
            oidb_0xfc2$UploadCompletedReq oidb_0xfc2_uploadcompletedreq = new oidb_0xfc2$UploadCompletedReq();
            oidb_0xfc2_uploadcompletedreq.str_fileid.set(tVar.d());
            oidb_0xfc2_uploadcompletedreq.uint64_random.set(tVar.f());
            oidb_0xfc2_uploadcompletedreq.bytes_ext.set(ByteStringMicro.copyFromUtf8(tVar.b()));
            oidb_0xfc2_reqbody.msg_upload_completed_req.set(oidb_0xfc2_uploadcompletedreq);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(4034);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xfc2_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putInt("seq", tVar.g());
            createToServiceMsg.extraData.putString("guildId", tVar.e());
            createToServiceMsg.extraData.putString("channelId", tVar.c());
            createToServiceMsg.extraData.putString("sub_cmd", "sub_cmd_upload_file_succ_request");
            this.f224346e.put(Integer.valueOf(tVar.g()), jVar);
            sendPbReq(createToServiceMsg);
        }
    }
}
