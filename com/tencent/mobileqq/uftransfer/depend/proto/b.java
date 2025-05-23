package com.tencent.mobileqq.uftransfer.depend.proto;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.e;
import com.tencent.mobileqq.uftransfer.proto.f;
import com.tencent.mobileqq.uftransfer.proto.h;
import com.tencent.mobileqq.uftransfer.proto.i;
import com.tencent.mobileqq.uftransfer.proto.j;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x345.cmd0x345$ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccReq;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ResendRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static cmd0x346$ApplyUploadReqV2 a(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        cmd0x346$ApplyUploadReqV2 cmd0x346_applyuploadreqv2 = new cmd0x346$ApplyUploadReqV2();
        cmd0x346_applyuploadreqv2.uint64_sender_uin.set(cVar.e());
        cmd0x346_applyuploadreqv2.uint64_recver_uin.set(cVar.d());
        cmd0x346_applyuploadreqv2.uint64_file_size.set(cVar.t());
        cmd0x346_applyuploadreqv2.str_file_name.set(cVar.q());
        cmd0x346_applyuploadreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(cVar.m()));
        cmd0x346_applyuploadreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(cVar.n()));
        cmd0x346_applyuploadreqv2.str_local_filepath.set(cVar.r());
        cmd0x346_applyuploadreqv2.uint32_danger_level.set(cVar.s());
        cmd0x346_applyuploadreqv2.uint64_total_space.set(cVar.u());
        return cmd0x346_applyuploadreqv2;
    }

    public static cmd0x346$ApplyUploadHitReqV2 b(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        cmd0x346$ApplyUploadHitReqV2 cmd0x346_applyuploadhitreqv2 = new cmd0x346$ApplyUploadHitReqV2();
        cmd0x346_applyuploadhitreqv2.uint64_sender_uin.set(cVar.e());
        cmd0x346_applyuploadhitreqv2.uint64_recver_uin.set(cVar.d());
        cmd0x346_applyuploadhitreqv2.uint64_file_size.set(cVar.t());
        cmd0x346_applyuploadhitreqv2.str_file_name.set(cVar.q());
        cmd0x346_applyuploadhitreqv2.bytes_10m_md5.set(ByteStringMicro.copyFrom(cVar.m()));
        cmd0x346_applyuploadhitreqv2.bytes_3sha.set(ByteStringMicro.copyFrom(cVar.n()));
        cmd0x346_applyuploadhitreqv2.bytes_sha.set(ByteStringMicro.copyFrom(cVar.p()));
        cmd0x346_applyuploadhitreqv2.str_local_filepath.set(cVar.r());
        cmd0x346_applyuploadhitreqv2.uint32_danger_level.set(cVar.s());
        cmd0x346_applyuploadhitreqv2.uint64_total_space.set(cVar.u());
        return cmd0x346_applyuploadhitreqv2;
    }

    public static cmd0x346$ApplyUploadReqV3 c(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        cmd0x346$ApplyUploadReqV3 cmd0x346_applyuploadreqv3 = new cmd0x346$ApplyUploadReqV3();
        cmd0x346_applyuploadreqv3.uint64_sender_uin.set(cVar.e());
        cmd0x346_applyuploadreqv3.uint64_recver_uin.set(cVar.d());
        cmd0x346_applyuploadreqv3.uint64_file_size.set(cVar.t());
        cmd0x346_applyuploadreqv3.str_file_name.set(cVar.q());
        cmd0x346_applyuploadreqv3.bytes_10m_md5.set(ByteStringMicro.copyFrom(cVar.m()));
        if (cVar.o() != null) {
            cmd0x346_applyuploadreqv3.bytes_md5.set(ByteStringMicro.copyFrom(cVar.o()));
        }
        cmd0x346_applyuploadreqv3.bytes_sha.set(ByteStringMicro.copyFrom(cVar.p()));
        if (cVar.n() != null) {
            cmd0x346_applyuploadreqv3.bytes_3sha.set(ByteStringMicro.copyFrom(cVar.n()));
        }
        cmd0x346_applyuploadreqv3.uint32_contenttype.set(0);
        cmd0x346_applyuploadreqv3.str_local_filepath.set(cVar.r());
        cmd0x346_applyuploadreqv3.uint32_danger_level.set(cVar.s());
        cmd0x346_applyuploadreqv3.uint64_total_space.set(cVar.u());
        return cmd0x346_applyuploadreqv3;
    }

    public static cmd0x346$UploadSuccReq d(com.tencent.mobileqq.uftransfer.proto.a aVar) {
        cmd0x346$UploadSuccReq cmd0x346_uploadsuccreq = new cmd0x346$UploadSuccReq();
        cmd0x346_uploadsuccreq.uint64_sender_uin.set(aVar.e());
        cmd0x346_uploadsuccreq.uint64_recver_uin.set(aVar.d());
        cmd0x346_uploadsuccreq.bytes_uuid.set(ByteStringMicro.copyFrom(aVar.m()));
        if (aVar.f()) {
            if (!TextUtils.isEmpty(aVar.n())) {
                cmd0x346_uploadsuccreq.str_fileidcrc.set(aVar.n());
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CSetUploadSucReq: UseMediaPlatform enabled");
            } else {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CSetUploadSucReq: UseMediaPlatform enabled but FileIdCrc is null");
            }
        }
        return cmd0x346_uploadsuccreq;
    }

    public static com.tencent.mobileqq.uftransfer.proto.d e(cmd0x346$ApplyUploadRspV2 cmd0x346_applyuploadrspv2) {
        com.tencent.mobileqq.uftransfer.proto.d dVar = new com.tencent.mobileqq.uftransfer.proto.d();
        if (cmd0x346_applyuploadrspv2.int32_ret_code.has()) {
            dVar.D(cmd0x346_applyuploadrspv2.int32_ret_code.get());
        }
        if (cmd0x346_applyuploadrspv2.str_ret_msg.has()) {
            dVar.E(cmd0x346_applyuploadrspv2.str_ret_msg.get());
        }
        if (cmd0x346_applyuploadrspv2.uint64_total_space.has()) {
            dVar.J(cmd0x346_applyuploadrspv2.uint64_total_space.get());
        }
        if (cmd0x346_applyuploadrspv2.uint64_used_space.has()) {
            dVar.L(cmd0x346_applyuploadrspv2.uint64_used_space.get());
        }
        if (cmd0x346_applyuploadrspv2.uint64_uploaded_size.has()) {
            dVar.u(cmd0x346_applyuploadrspv2.uint64_uploaded_size.get());
        }
        if (cmd0x346_applyuploadrspv2.str_upload_ip.has()) {
            dVar.I(cmd0x346_applyuploadrspv2.str_upload_ip.get());
        } else if (cmd0x346_applyuploadrspv2.str_upload_domain.has()) {
            dVar.I(cmd0x346_applyuploadrspv2.str_upload_domain.get());
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadRspV2 has neither ip nor domain");
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_port.has()) {
            dVar.C(cmd0x346_applyuploadrspv2.uint32_upload_port.get());
        }
        if (cmd0x346_applyuploadrspv2.bytes_uuid.has()) {
            dVar.M(cmd0x346_applyuploadrspv2.bytes_uuid.get().toByteArray());
        }
        if (cmd0x346_applyuploadrspv2.bytes_upload_key.has()) {
            dVar.x(cmd0x346_applyuploadrspv2.bytes_upload_key.get().toByteArray());
        }
        if (cmd0x346_applyuploadrspv2.bool_file_exist.has()) {
            dVar.t(cmd0x346_applyuploadrspv2.bool_file_exist.get());
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_port.has()) {
            dVar.B(cmd0x346_applyuploadrspv2.uint32_pack_size.get());
        }
        if (cmd0x346_applyuploadrspv2.uint32_httpsvr_api_ver.has()) {
            dVar.w(cmd0x346_applyuploadrspv2.uint32_httpsvr_api_ver.get());
        }
        if (cmd0x346_applyuploadrspv2.bytes_sha.has()) {
            dVar.F(cmd0x346_applyuploadrspv2.bytes_sha.get().toByteArray());
        }
        if (cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.has() && cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.get().size() > 0) {
            dVar.z(cmd0x346_applyuploadrspv2.rpt_str_uploadip_list.get());
        }
        if (cmd0x346_applyuploadrspv2.str_upload_https_domain.has()) {
            dVar.H(cmd0x346_applyuploadrspv2.str_upload_https_domain.get());
        }
        if (cmd0x346_applyuploadrspv2.uint32_upload_https_port.has()) {
            dVar.v(cmd0x346_applyuploadrspv2.uint32_upload_https_port.get());
        }
        if (cmd0x346_applyuploadrspv2.str_upload_dns.has()) {
            dVar.s(cmd0x346_applyuploadrspv2.str_upload_dns.get());
        }
        if (cmd0x346_applyuploadrspv2.str_upload_lanip.has()) {
            dVar.y(cmd0x346_applyuploadrspv2.str_upload_lanip.get());
        }
        return dVar;
    }

    public static com.tencent.mobileqq.uftransfer.proto.d f(cmd0x346$ApplyUploadHitRspV2 cmd0x346_applyuploadhitrspv2) {
        com.tencent.mobileqq.uftransfer.proto.d dVar = new com.tencent.mobileqq.uftransfer.proto.d();
        if (cmd0x346_applyuploadhitrspv2.int32_ret_code.has()) {
            dVar.D(cmd0x346_applyuploadhitrspv2.int32_ret_code.get());
        }
        if (cmd0x346_applyuploadhitrspv2.str_ret_msg.has()) {
            dVar.E(cmd0x346_applyuploadhitrspv2.str_ret_msg.get());
        }
        if (cmd0x346_applyuploadhitrspv2.uint64_total_space.has()) {
            dVar.J(cmd0x346_applyuploadhitrspv2.uint64_total_space.get());
        }
        if (cmd0x346_applyuploadhitrspv2.uint64_used_space.has()) {
            dVar.L(cmd0x346_applyuploadhitrspv2.uint64_used_space.get());
        }
        if (cmd0x346_applyuploadhitrspv2.str_upload_ip.has()) {
            dVar.I(cmd0x346_applyuploadhitrspv2.str_upload_ip.get());
        } else if (cmd0x346_applyuploadhitrspv2.str_upload_domain.has()) {
            dVar.I(cmd0x346_applyuploadhitrspv2.str_upload_domain.get());
        } else {
            QLog.i("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadHitRspV2 has neither ip nor domain");
        }
        if (cmd0x346_applyuploadhitrspv2.uint32_upload_port.has()) {
            dVar.C(cmd0x346_applyuploadhitrspv2.uint32_upload_port.get());
        }
        if (cmd0x346_applyuploadhitrspv2.bytes_uuid.has()) {
            dVar.M(cmd0x346_applyuploadhitrspv2.bytes_uuid.get().toByteArray());
        }
        if (cmd0x346_applyuploadhitrspv2.bytes_upload_key.has()) {
            dVar.x(cmd0x346_applyuploadhitrspv2.bytes_upload_key.get().toByteArray());
        }
        if (cmd0x346_applyuploadhitrspv2.str_upload_https_domain.has()) {
            dVar.H(cmd0x346_applyuploadhitrspv2.str_upload_https_domain.get());
        }
        if (cmd0x346_applyuploadhitrspv2.uint32_upload_https_port.has()) {
            dVar.v(cmd0x346_applyuploadhitrspv2.uint32_upload_https_port.get());
        }
        if (cmd0x346_applyuploadhitrspv2.str_upload_dns.has()) {
            dVar.s(cmd0x346_applyuploadhitrspv2.str_upload_dns.get());
        }
        return dVar;
    }

    public static com.tencent.mobileqq.uftransfer.proto.d g(cmd0x346$ApplyUploadRspV3 cmd0x346_applyuploadrspv3, boolean z16) {
        com.tencent.mobileqq.uftransfer.proto.d dVar = new com.tencent.mobileqq.uftransfer.proto.d();
        if (cmd0x346_applyuploadrspv3.int32_ret_code.has()) {
            dVar.D(cmd0x346_applyuploadrspv3.int32_ret_code.get());
        }
        if (cmd0x346_applyuploadrspv3.str_ret_msg.has()) {
            dVar.E(cmd0x346_applyuploadrspv3.str_ret_msg.get());
        }
        if (cmd0x346_applyuploadrspv3.uint64_total_space.has()) {
            dVar.J(cmd0x346_applyuploadrspv3.uint64_total_space.get());
        }
        if (cmd0x346_applyuploadrspv3.uint64_used_space.has()) {
            dVar.L(cmd0x346_applyuploadrspv3.uint64_used_space.get());
        }
        if (cmd0x346_applyuploadrspv3.uint64_uploaded_size.has()) {
            dVar.u(cmd0x346_applyuploadrspv3.uint64_uploaded_size.get());
        }
        if (cmd0x346_applyuploadrspv3.str_upload_ip.has()) {
            dVar.I(cmd0x346_applyuploadrspv3.str_upload_ip.get());
        } else if (cmd0x346_applyuploadrspv3.str_upload_domain.has()) {
            dVar.I(cmd0x346_applyuploadrspv3.str_upload_domain.get());
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadRsV3 has neither ip nor domain");
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_port.has()) {
            dVar.C(cmd0x346_applyuploadrspv3.uint32_upload_port.get());
        }
        if (cmd0x346_applyuploadrspv3.bytes_uuid.has()) {
            dVar.M(cmd0x346_applyuploadrspv3.bytes_uuid.get().toByteArray());
        }
        if (cmd0x346_applyuploadrspv3.bytes_upload_key.has()) {
            dVar.x(cmd0x346_applyuploadrspv3.bytes_upload_key.get().toByteArray());
        }
        if (cmd0x346_applyuploadrspv3.bool_file_exist.has()) {
            dVar.t(cmd0x346_applyuploadrspv3.bool_file_exist.get());
        }
        dVar.K(z16);
        if (dVar.q()) {
            if (dVar.p()) {
                if (cmd0x346_applyuploadrspv3.str_fileidcrc.has()) {
                    dVar.G(cmd0x346_applyuploadrspv3.str_fileidcrc.get());
                }
            } else if (cmd0x346_applyuploadrspv3.bytes_media_plateform_upload_key.has()) {
                dVar.A(cmd0x346_applyuploadrspv3.bytes_media_plateform_upload_key.get().toByteArray());
            } else {
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CUploadRsV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
            }
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_port.has()) {
            dVar.B(cmd0x346_applyuploadrspv3.uint32_pack_size.get());
        }
        if (cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.has() && cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.get().size() > 0) {
            dVar.z(cmd0x346_applyuploadrspv3.rpt_str_uploadip_list.get());
        }
        if (cmd0x346_applyuploadrspv3.str_upload_https_domain.has()) {
            dVar.H(cmd0x346_applyuploadrspv3.str_upload_https_domain.get());
        }
        if (cmd0x346_applyuploadrspv3.uint32_upload_https_port.has()) {
            dVar.v(cmd0x346_applyuploadrspv3.uint32_upload_https_port.get());
        }
        if (cmd0x346_applyuploadrspv3.str_upload_dns.has()) {
            dVar.s(cmd0x346_applyuploadrspv3.str_upload_dns.get());
        }
        if (cmd0x346_applyuploadrspv3.str_upload_lanip.has()) {
            dVar.y(cmd0x346_applyuploadrspv3.str_upload_lanip.get());
        }
        return dVar;
    }

    public static cmd0x345$ReqBody.SubCmd0x1ReqBody h(e eVar) {
        cmd0x345$ReqBody.SubCmd0x1ReqBody subCmd0x1ReqBody = new cmd0x345$ReqBody.SubCmd0x1ReqBody();
        subCmd0x1ReqBody.str_md5.set(eVar.e());
        subCmd0x1ReqBody.str_sha.set(eVar.f());
        subCmd0x1ReqBody.str_file_name.set(eVar.b());
        subCmd0x1ReqBody.uint64_file_size.set(eVar.c());
        subCmd0x1ReqBody.uint32_upload_type.set(1);
        subCmd0x1ReqBody.uint32_disscus_uin.set((int) Long.parseLong(eVar.a()));
        subCmd0x1ReqBody.uint32_sender_uin.set((int) Long.parseLong(eVar.d()));
        subCmd0x1ReqBody.uint32_costom_id.set(0);
        return subCmd0x1ReqBody;
    }

    public static f i(cmd0x345$RspBody.SubCmd0x1RspBody subCmd0x1RspBody) {
        f fVar = new f();
        if (subCmd0x1RspBody.str_file_id.has()) {
            fVar.j(subCmd0x1RspBody.str_file_id.get());
        }
        if (subCmd0x1RspBody.str_file_key.has()) {
            fVar.k(subCmd0x1RspBody.str_file_key.get());
        }
        if (subCmd0x1RspBody.str_check_sum.has()) {
            fVar.p(subCmd0x1RspBody.str_check_sum.get());
        }
        if (subCmd0x1RspBody.str_host.has()) {
            fVar.r(subCmd0x1RspBody.str_host.get());
        }
        if (subCmd0x1RspBody.uint32_port.has()) {
            fVar.m(subCmd0x1RspBody.uint32_port.get());
        }
        if (subCmd0x1RspBody.str_file_name.has()) {
            fVar.q(subCmd0x1RspBody.str_file_name.get());
        }
        if (subCmd0x1RspBody.str_warn.has()) {
            fVar.o(subCmd0x1RspBody.str_warn.get());
        }
        if (subCmd0x1RspBody.str_https_domain.has()) {
            fVar.s(subCmd0x1RspBody.str_https_domain.get());
        }
        if (subCmd0x1RspBody.uint32_https_port.has()) {
            fVar.l(subCmd0x1RspBody.uint32_https_port.get());
        }
        if (subCmd0x1RspBody.str_dns.has()) {
            fVar.t(subCmd0x1RspBody.str_dns.get());
        }
        return fVar;
    }

    public static oidb_0x6d6$ResendReqBody j(h hVar) {
        oidb_0x6d6$ResendReqBody oidb_0x6d6_resendreqbody = new oidb_0x6d6$ResendReqBody();
        oidb_0x6d6_resendreqbody.uint32_bus_id.set(hVar.a());
        oidb_0x6d6_resendreqbody.uint32_app_id.set(3);
        oidb_0x6d6_resendreqbody.uint64_group_code.set(hVar.d());
        oidb_0x6d6_resendreqbody.str_file_id.set(hVar.c());
        oidb_0x6d6_resendreqbody.bytes_sha.set(ByteStringMicro.copyFrom(hVar.b()));
        return oidb_0x6d6_resendreqbody;
    }

    public static j k(oidb_0x6d6$ResendRspBody oidb_0x6d6_resendrspbody) {
        j jVar = new j();
        if (oidb_0x6d6_resendrspbody.int32_ret_code.has()) {
            jVar.r(oidb_0x6d6_resendrspbody.int32_ret_code.get());
        }
        if (oidb_0x6d6_resendrspbody.str_ret_msg.has()) {
            jVar.s(oidb_0x6d6_resendrspbody.str_ret_msg.get());
        }
        if (oidb_0x6d6_resendrspbody.str_client_wording.has()) {
            jVar.m(oidb_0x6d6_resendrspbody.str_client_wording.get());
        }
        if (oidb_0x6d6_resendrspbody.str_upload_ip.has()) {
            jVar.u(oidb_0x6d6_resendrspbody.str_upload_ip.get());
        }
        if (oidb_0x6d6_resendrspbody.bytes_check_key.has()) {
            jVar.l(oidb_0x6d6_resendrspbody.bytes_check_key.get().toByteArray());
        }
        return jVar;
    }

    public static oidb_0x6d6$UploadFileReqBody l(i iVar) {
        oidb_0x6d6$UploadFileReqBody oidb_0x6d6_uploadfilereqbody = new oidb_0x6d6$UploadFileReqBody();
        oidb_0x6d6_uploadfilereqbody.uint32_bus_id.set(iVar.a());
        oidb_0x6d6_uploadfilereqbody.uint32_app_id.set(3);
        oidb_0x6d6_uploadfilereqbody.uint64_group_code.set(iVar.j());
        oidb_0x6d6_uploadfilereqbody.bytes_md5.set(ByteStringMicro.copyFrom(iVar.b()));
        oidb_0x6d6_uploadfilereqbody.bytes_sha.set(ByteStringMicro.copyFrom(iVar.c()));
        if (iVar.d() != null && iVar.d().length > 0) {
            oidb_0x6d6_uploadfilereqbody.bytes_sha3.set(ByteStringMicro.copyFrom(iVar.d()));
        }
        if (TextUtils.isEmpty(iVar.i())) {
            oidb_0x6d6_uploadfilereqbody.str_parent_folder_id.set("/");
        } else {
            oidb_0x6d6_uploadfilereqbody.str_parent_folder_id.set(iVar.i());
        }
        oidb_0x6d6_uploadfilereqbody.str_file_name.set(iVar.g());
        oidb_0x6d6_uploadfilereqbody.str_local_path.set(iVar.h());
        oidb_0x6d6_uploadfilereqbody.uint32_entrance.set(iVar.e());
        oidb_0x6d6_uploadfilereqbody.uint64_file_size.set(iVar.f());
        oidb_0x6d6_uploadfilereqbody.bool_support_multi_upload.set(iVar.k());
        return oidb_0x6d6_uploadfilereqbody;
    }

    public static j m(oidb_0x6d6$UploadFileRspBody oidb_0x6d6_uploadfilerspbody) {
        j jVar = new j();
        if (oidb_0x6d6_uploadfilerspbody.int32_ret_code.has()) {
            jVar.r(oidb_0x6d6_uploadfilerspbody.int32_ret_code.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_ret_msg.has()) {
            jVar.s(oidb_0x6d6_uploadfilerspbody.str_ret_msg.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_client_wording.has()) {
            jVar.m(oidb_0x6d6_uploadfilerspbody.str_client_wording.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_file_id.has()) {
            jVar.n(oidb_0x6d6_uploadfilerspbody.str_file_id.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_upload_ip.has()) {
            jVar.u(oidb_0x6d6_uploadfilerspbody.str_upload_ip.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_server_dns.has()) {
            jVar.t(oidb_0x6d6_uploadfilerspbody.str_server_dns.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.bytes_check_key.has()) {
            jVar.l(oidb_0x6d6_uploadfilerspbody.bytes_check_key.get().toByteArray());
        }
        if (oidb_0x6d6_uploadfilerspbody.uint32_bus_id.has()) {
            jVar.k(oidb_0x6d6_uploadfilerspbody.uint32_bus_id.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_upload_ip_lan_v4.has()) {
            jVar.o(oidb_0x6d6_uploadfilerspbody.str_upload_ip_lan_v4.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.str_upload_ip_lan_v6.has()) {
            jVar.p(oidb_0x6d6_uploadfilerspbody.str_upload_ip_lan_v6.get());
        }
        if (oidb_0x6d6_uploadfilerspbody.uint32_upload_port.has()) {
            jVar.q(oidb_0x6d6_uploadfilerspbody.uint32_upload_port.get());
        }
        return jVar;
    }
}
