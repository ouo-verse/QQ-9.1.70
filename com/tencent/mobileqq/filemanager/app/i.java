package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.g;
import com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderX5;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x345.cmd0x345$ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i implements ProtoReqManagerImpl.IProtoRespBack {

    /* renamed from: e, reason: collision with root package name */
    private static int f207279e;

    /* renamed from: d, reason: collision with root package name */
    private BaseQQAppInterface f207280d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f207281a;

        /* renamed from: b, reason: collision with root package name */
        private g f207282b;

        public a(g gVar) {
            this.f207282b = gVar;
        }

        public g a() {
            return this.f207282b;
        }

        public int b() {
            return this.f207281a;
        }

        public void c(int i3) {
            this.f207281a = i3;
        }
    }

    public i(BaseQQAppInterface baseQQAppInterface) {
        this.f207280d = baseQQAppInterface;
    }

    private void e(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        int i16;
        boolean z16;
        ProtoReqManagerImpl.ProtoReq protoReq2;
        int i17;
        String str = "";
        String str2 = null;
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            if (protoResp.resp.getResultCode() != 1000) {
                QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is failed[" + protoResp.resp.getResultCode() + "]");
                i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
                try {
                    cmd0x345_rspbody.mergeFrom(wupBuffer);
                    if (cmd0x345_rspbody.uint32_return_code.has()) {
                        i17 = cmd0x345_rspbody.uint32_return_code.get();
                    } else {
                        i17 = 0;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!cmd0x345_rspbody.msg_subcmd_0x6_rsp_body.has() && !cmd0x345_rspbody.msg_subcmd_0x5_rsp_body.has()) {
                    QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
                    protoReq2 = protoReq;
                    i16 = -100003;
                    z16 = false;
                    ((g.a) ((a) protoReq2.busiData).a()).a(z16, i16, str, str2, null, 0L, 0L);
                }
                if (cmd0x345_rspbody.msg_subcmd_0x6_rsp_body.has()) {
                    cmd0x345$RspBody.SubCmd0x6RspBody subCmd0x6RspBody = cmd0x345_rspbody.msg_subcmd_0x6_rsp_body.get();
                    if (subCmd0x6RspBody.str_ret_msg.has()) {
                        str = subCmd0x6RspBody.str_ret_msg.get();
                    }
                    if (subCmd0x6RspBody.str_file_id.has()) {
                        str2 = subCmd0x6RspBody.str_file_id.get();
                    }
                } else if (cmd0x345_rspbody.msg_subcmd_0x5_rsp_body.has()) {
                    cmd0x345$RspBody.SubCmd0x5RspBody subCmd0x5RspBody = cmd0x345_rspbody.msg_subcmd_0x5_rsp_body.get();
                    if (subCmd0x5RspBody.str_ret_msg.has()) {
                        str = subCmd0x5RspBody.str_ret_msg.get();
                    }
                    if (subCmd0x5RspBody.str_file_id.has()) {
                        str2 = subCmd0x5RspBody.str_file_id.get();
                    }
                }
                protoReq2 = protoReq;
                i16 = i17;
                z16 = true;
                ((g.a) ((a) protoReq2.busiData).a()).a(z16, i16, str, str2, null, 0L, 0L);
            }
        } else {
            QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        }
        protoReq2 = protoReq;
        i16 = i3;
        z16 = false;
        ((g.a) ((a) protoReq2.busiData).a()).a(z16, i16, str, str2, null, 0L, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        long j3;
        long j16;
        String str;
        String str2;
        String str3;
        int i16;
        boolean z16;
        boolean z17;
        int i17;
        String str4;
        String str5;
        long j17;
        boolean z18 = true;
        String str6 = null;
        long j18 = 0;
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            if (protoResp.resp.getResultCode() != 1000) {
                QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
                i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!cmd0x346_rspbody.msg_apply_forward_file_rsp.has()) {
                    QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
                    i16 = -100003;
                    z18 = false;
                    str3 = null;
                    str2 = null;
                    str = null;
                    j16 = 0;
                    j3 = 0;
                    if (i16 != 0) {
                        z16 = false;
                    } else {
                        z16 = z18;
                    }
                    ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str3, str2, str, j16, j3);
                }
                if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform " + z17);
                } else {
                    QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
                    z17 = false;
                }
                cmd0x346$ApplyForwardFileRsp cmd0x346_applyforwardfilersp = cmd0x346_rspbody.msg_apply_forward_file_rsp.get();
                if (cmd0x346_applyforwardfilersp.int32_ret_code.has()) {
                    i17 = cmd0x346_applyforwardfilersp.int32_ret_code.get();
                } else {
                    i17 = 0;
                }
                if (cmd0x346_applyforwardfilersp.str_ret_msg.has()) {
                    str4 = cmd0x346_applyforwardfilersp.str_ret_msg.get();
                } else {
                    str4 = null;
                }
                if (cmd0x346_applyforwardfilersp.bytes_uuid.has()) {
                    str5 = new String(cmd0x346_applyforwardfilersp.bytes_uuid.get().toByteArray());
                } else {
                    str5 = null;
                }
                if (z17 && cmd0x346_applyforwardfilersp.str_fileidcrc.has()) {
                    str6 = cmd0x346_applyforwardfilersp.str_fileidcrc.get();
                }
                if (cmd0x346_applyforwardfilersp.uint64_total_space.has()) {
                    j17 = cmd0x346_applyforwardfilersp.uint64_total_space.get();
                } else {
                    j17 = 0;
                }
                if (cmd0x346_applyforwardfilersp.uint64_used_space.has()) {
                    j18 = cmd0x346_applyforwardfilersp.uint64_used_space.get();
                }
                i16 = i17;
                str3 = str4;
                str2 = str5;
                str = str6;
                j3 = j18;
                j16 = j17;
                if (i16 != 0) {
                }
                ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str3, str2, str, j16, j3);
            }
        } else {
            QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        }
        i16 = i3;
        z18 = false;
        str3 = null;
        str2 = null;
        str = null;
        j16 = 0;
        j3 = 0;
        if (i16 != 0) {
        }
        ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str3, str2, str, j16, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        String str;
        String str2;
        int i16;
        boolean z16;
        int i17;
        String str3;
        boolean z17 = true;
        String str4 = null;
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            if (protoResp.resp.getResultCode() != 1000) {
                QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is failed[" + protoResp.resp.getResultCode() + "]");
                i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!cmd0x346_rspbody.msg_apply_copy_to_rsp.has()) {
                    QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
                    i16 = -100003;
                    z17 = false;
                    str2 = null;
                    str = null;
                    if (i16 != 0) {
                        z16 = false;
                    } else {
                        z16 = z17;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ProtocolManager", 2, "onForwardOfflineToOther: return " + z16 + ", retCode=" + i16 + ", retMsg=" + str2);
                    }
                    ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str2, str, null, 0L, 0L);
                }
                cmd0x346$ApplyCopyToRsp cmd0x346_applycopytorsp = cmd0x346_rspbody.msg_apply_copy_to_rsp.get();
                if (cmd0x346_applycopytorsp.int32_ret_code.has()) {
                    i17 = cmd0x346_applycopytorsp.int32_ret_code.get();
                } else {
                    i17 = 0;
                }
                if (cmd0x346_applycopytorsp.str_ret_msg.has()) {
                    str3 = cmd0x346_applycopytorsp.str_ret_msg.get();
                } else {
                    str3 = null;
                }
                if (cmd0x346_applycopytorsp.str_file_key.has()) {
                    str4 = cmd0x346_applycopytorsp.str_file_key.get();
                }
                i16 = i17;
                str2 = str3;
                str = str4;
                if (i16 != 0) {
                }
                if (QLog.isColorLevel()) {
                }
                ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str2, str, null, 0L, 0L);
            }
        } else {
            QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        }
        i16 = i3;
        z17 = false;
        str2 = null;
        str = null;
        if (i16 != 0) {
        }
        if (QLog.isColorLevel()) {
        }
        ((g.a) ((a) protoReq.busiData).a()).a(z16, i16, str2, str, null, 0L, 0L);
    }

    private void h(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        boolean z16 = true;
        cmd0x346$ApplyUploadRspV3 cmd0x346_applyuploadrspv3 = null;
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            if (protoResp.resp.getResultCode() != 1000) {
                QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
                i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!cmd0x346_rspbody.msg_apply_upload_rsp_v3.has()) {
                    QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
                    i3 = -100003;
                } else {
                    cmd0x346_applyuploadrspv3 = cmd0x346_rspbody.msg_apply_upload_rsp_v3.get();
                    i3 = -1;
                    ((g.b) ((a) protoReq.busiData).a()).a(z16, i3, cmd0x346_applyuploadrspv3);
                }
            }
        } else {
            QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        }
        z16 = false;
        ((g.b) ((a) protoReq.busiData).a()).a(z16, i3, cmd0x346_applyuploadrspv3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(ProtoReqManagerImpl.ProtoReq protoReq, ProtoReqManagerImpl.ProtoResp protoResp) {
        int i3;
        Object obj;
        int i16;
        boolean z16 = true;
        String str = "";
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            if (protoResp.resp.getResultCode() != 1000) {
                QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is failed[" + protoResp.resp.getResultCode() + "]");
                i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (!cmd0x346_rspbody.msg_upload_succ_rsp.has()) {
                    QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
                    i3 = -100003;
                } else {
                    cmd0x346$UploadSuccRsp cmd0x346_uploadsuccrsp = cmd0x346_rspbody.msg_upload_succ_rsp.get();
                    if (cmd0x346_uploadsuccrsp.int32_ret_code.has()) {
                        i16 = cmd0x346_uploadsuccrsp.int32_ret_code.get();
                    } else {
                        i16 = -1;
                    }
                    if (cmd0x346_uploadsuccrsp.str_ret_msg.has()) {
                        str = cmd0x346_uploadsuccrsp.str_ret_msg.get();
                    }
                    i3 = i16;
                    obj = protoReq.busiData;
                    if (obj == null) {
                        ((g.c) ((a) obj).a()).a(z16, i3, str);
                        return;
                    }
                    return;
                }
            }
        } else {
            QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is timeout[" + protoResp.resp.getResultCode() + "]");
            i3 = -100001;
        }
        z16 = false;
        obj = protoReq.busiData;
        if (obj == null) {
        }
    }

    private void k(String str, byte[] bArr, a aVar, int i3, int i16, int i17) {
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = str;
        protoReq.reqBody = bArr;
        protoReq.busiData = aVar;
        protoReq.tryTime = i3;
        protoReq.tryCount = i16;
        protoReq.fixScheduleCount = i17;
        protoReq.callback = this;
        ((IProtoReqManager) this.f207280d.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    public void a(String str, String str2, h hVar, g.a aVar) {
        cmd0x345$ReqBody.SubCmd0x5ReqBody subCmd0x5ReqBody = new cmd0x345$ReqBody.SubCmd0x5ReqBody();
        subCmd0x5ReqBody.uint32_src_bus_id.set(106);
        subCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
        subCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(hVar.f207277c.getBytes()));
        subCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(str));
        subCmd0x5ReqBody.uint64_file_size.set(hVar.f207276b);
        subCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(str2));
        subCmd0x5ReqBody.str_file_name.set(hVar.f207275a);
        String str3 = hVar.f207278d;
        if (str3 != null && str3.length() > 0) {
            subCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(hVar.f207278d.getBytes()));
        }
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x5_req_body.set(subCmd0x5ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(6);
        a aVar2 = new a(aVar);
        aVar2.c(6);
        k("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), aVar2, 30000, 3, 1);
    }

    public void b(String str, int i3, String str2, int i16, h hVar, int i17, int i18, g.a aVar) {
        cmd0x345$ReqBody.SubCmd0x6ReqBody subCmd0x6ReqBody = new cmd0x345$ReqBody.SubCmd0x6ReqBody();
        subCmd0x6ReqBody.uint32_dst_bus_id.set(i16);
        subCmd0x6ReqBody.uint64_file_size.set(hVar.f207276b);
        subCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(hVar.f207277c.getBytes()));
        if (!TextUtils.isEmpty(hVar.f207278d)) {
            subCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(hVar.f207278d.getBytes()));
        }
        subCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(str2));
        subCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(str.replace(Marker.ANY_NON_NULL_MARKER, "")));
        subCmd0x6ReqBody.str_file_name.set(hVar.f207275a);
        subCmd0x6ReqBody.str_src_file_path.set(hVar.f207277c);
        subCmd0x6ReqBody.str_src_parent_folder.set("/");
        subCmd0x6ReqBody.uint32_client_type.set(104);
        if (i3 != 1 && i3 != 0) {
            subCmd0x6ReqBody.uint64_app_id.set(3L);
            subCmd0x6ReqBody.uint64_talk_type.set(i3);
            byte[] G0 = ah.G0(this.f207280d, str, i3);
            if (G0 != null) {
                subCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(G0));
            }
            if (QLog.isColorLevel()) {
                QLog.i("ProtocolManager", 2, "forwardDiscToOther : add tempinfo SessionType[" + i3 + "]");
            }
        }
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x6_req_body.set(subCmd0x6ReqBody);
        cmd0x345_reqbody.uint32_sub_cmd.set(7);
        a aVar2 = new a(aVar);
        aVar2.c(7);
        k("GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), aVar2, i17, i18, 1);
    }

    public void c(String str, int i3, String str2, String str3, int i16, int i17, g.a aVar) {
        cmd0x346$ApplyForwardFileReq cmd0x346_applyforwardfilereq = new cmd0x346$ApplyForwardFileReq();
        cmd0x346_applyforwardfilereq.uint64_sender_uin.set(Long.parseLong(this.f207280d.getCurrentAccountUin()));
        String replace = str.replace(Marker.ANY_NON_NULL_MARKER, "");
        cmd0x346_applyforwardfilereq.uint64_recver_uin.set(Long.parseLong(replace));
        cmd0x346_applyforwardfilereq.bytes_uuid.set(ByteStringMicro.copyFrom(str2.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_apply_forward_file_req.set(cmd0x346_applyforwardfilereq);
        cmd0x346_reqbody.uint32_cmd.set(700);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i18 = f207279e;
        f207279e = i18 + 1;
        pBUInt32Field.set(i18);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (i3 != 0) {
            cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
            cmd0x346_extensionreq.uint64_id.set(3L);
            cmd0x346_extensionreq.uint64_type.set(i3);
            byte[] G0 = ah.G0(this.f207280d, replace, i3);
            if (G0 != null) {
                cmd0x346_extensionreq.bytes_sig.set(ByteStringMicro.copyFrom(G0));
            }
            cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
            if (QLog.isColorLevel()) {
                QLog.i("ProtocolManager", 2, "forwardOfflineFileToBuddy : add tempinfo SessionType[" + i3 + "]");
            }
        }
        if (!((IQFileConfigManager) this.f207280d.getRuntimeService(IQFileConfigManager.class, "")).isMediaPlatformEnabled() && !QQFileAssistantUtils.n(replace)) {
            QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform not enabled");
        } else {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
            if (str3 != null && str3.length() > 0) {
                cmd0x346_applyforwardfilereq.str_fileidcrc.set(str3);
                QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled");
            } else {
                QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled but FileIdCrc is null");
            }
        }
        k("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", cmd0x346_reqbody.toByteArray(), new a(aVar), i16, i17, 1);
    }

    public void d(String str, String str2, h hVar, int i3, int i16, int i17, g.a aVar) {
        cmd0x346$ApplyCopyToReq cmd0x346_applycopytoreq = new cmd0x346$ApplyCopyToReq();
        String replace = this.f207280d.getAccount().replace(Marker.ANY_NON_NULL_MARKER, "");
        cmd0x346_applycopytoreq.uint64_dst_id.set(Long.parseLong(replace));
        if (i3 == 106 || i3 == 102 || i3 == 104) {
            cmd0x346_applycopytoreq.uint64_dst_id.set(Long.parseLong(str2.replace(Marker.ANY_NON_NULL_MARKER, "")));
        }
        cmd0x346_applycopytoreq.uint32_dst_svcid.set(i3);
        cmd0x346_applycopytoreq.uint64_src_uin.set(Long.parseLong(replace));
        cmd0x346_applycopytoreq.uint64_file_size.set(hVar.f207276b);
        cmd0x346_applycopytoreq.str_file_name.set(hVar.f207275a);
        cmd0x346_applycopytoreq.bytes_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_apply_copy_to_req.set(cmd0x346_applycopytoreq);
        cmd0x346_reqbody.uint32_cmd.set(60100);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i18 = f207279e;
        f207279e = i18 + 1;
        pBUInt32Field.set(i18);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346_reqbody.toByteArray();
        k("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", cmd0x346_reqbody.toByteArray(), new a(aVar), i16, i17, 1);
    }

    public void j(String str, String str2, String str3, long j3, byte[] bArr, byte[] bArr2, int i3, int i16, g.b bVar) {
        long parseLong = Long.parseLong(this.f207280d.getCurrentAccountUin());
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(FSUploadConst.ERR_FILE_NOT_EXIST);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i17 = f207279e;
        f207279e = i17 + 1;
        pBUInt32Field.set(i17);
        cmd0x346$ApplyUploadReqV3 cmd0x346_applyuploadreqv3 = new cmd0x346$ApplyUploadReqV3();
        cmd0x346_applyuploadreqv3.uint64_sender_uin.set(parseLong);
        cmd0x346_applyuploadreqv3.uint64_recver_uin.set(Long.parseLong(str));
        cmd0x346_applyuploadreqv3.uint64_file_size.set(j3);
        cmd0x346_applyuploadreqv3.str_file_name.set(new String(str3));
        cmd0x346_applyuploadreqv3.bytes_10m_md5.set(ByteStringMicro.copyFrom(bArr));
        cmd0x346_applyuploadreqv3.bytes_sha.set(ByteStringMicro.copyFrom(bArr2));
        cmd0x346_applyuploadreqv3.str_local_filepath.set(str2);
        cmd0x346_applyuploadreqv3.uint32_danger_level.set(0);
        cmd0x346_applyuploadreqv3.uint64_total_space.set(0L);
        cmd0x346_reqbody.msg_apply_upload_req_v3.set(cmd0x346_applyuploadreqv3);
        cmd0x346_reqbody.setHasFlag(true);
        k("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", cmd0x346_reqbody.toByteArray(), new a(bVar), i3, i16, 1);
    }

    public void l(String str, byte[] bArr, int i3, int i16, g.c cVar) {
        a aVar;
        cmd0x346$UploadSuccReq cmd0x346_uploadsuccreq = new cmd0x346$UploadSuccReq();
        cmd0x346_uploadsuccreq.uint64_sender_uin.set(Long.parseLong(this.f207280d.getCurrentAccountUin()));
        cmd0x346_uploadsuccreq.uint64_recver_uin.set(Long.parseLong(str.replace(Marker.ANY_NON_NULL_MARKER, "")));
        cmd0x346_uploadsuccreq.bytes_uuid.set(ByteStringMicro.copyFrom(bArr));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.msg_upload_succ_req.set(cmd0x346_uploadsuccreq);
        cmd0x346_reqbody.uint32_cmd.set(800);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i17 = f207279e;
        f207279e = i17 + 1;
        pBUInt32Field.set(i17);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        if (cVar != null) {
            aVar = new a(cVar);
        } else {
            aVar = null;
        }
        k("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", cmd0x346_reqbody.toByteArray(), aVar, i3, i16, 1);
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(protoReq.ssoCmd)) {
            f(protoReq, protoResp);
        } else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(protoReq.ssoCmd)) {
            g(protoReq, protoResp);
        } else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(protoReq.ssoCmd)) {
            a aVar = (a) protoReq.busiData;
            int b16 = aVar.b();
            if (b16 == 6) {
                e(protoReq, protoResp);
            } else if (b16 == 7) {
                e(protoReq, protoResp);
            } else {
                QLog.w("ProtocolManager", 1, "unspourt:" + aVar.b());
            }
        } else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(protoReq.ssoCmd)) {
            h(protoReq, protoResp);
        }
        if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(protoReq.ssoCmd)) {
            i(protoReq, protoResp);
        }
    }
}
